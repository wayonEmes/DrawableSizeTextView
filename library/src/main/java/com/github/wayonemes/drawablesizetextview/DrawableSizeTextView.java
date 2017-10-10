package com.github.wayonemes.drawablesizetextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * a TextView can set DrawableTop(Bottom Left Right) size
 */

public class DrawableSizeTextView extends TextView {
    public DrawableSizeTextView(Context context) {
        this(context, null);
    }

    public DrawableSizeTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableSizeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // get custom drawable width and height
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.DrawableSizeTextView);
        int drawableWidth = ta.getDimensionPixelSize(R.styleable.DrawableSizeTextView_drawable_width, -1);
        int drawableHeight = ta.getDimensionPixelSize(R.styleable.DrawableSizeTextView_drawable_height, -1);

        Drawable[] drawables = getCompoundDrawables();
        Drawable textDrawable = null;
        for (Drawable drawable : drawables) {
            if (drawable != null) {
                textDrawable = drawable;
            }
        }

        // set width and height
        if (textDrawable != null && drawableWidth != -1 && drawableHeight != -1) {
            textDrawable.setBounds(0, 0, drawableWidth, drawableHeight);
        }
        // set the drawable to TextView
        setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);

        ta.recycle();
    }
}
