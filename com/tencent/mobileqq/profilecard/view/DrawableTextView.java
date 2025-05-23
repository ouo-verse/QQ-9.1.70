package com.tencent.mobileqq.profilecard.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import jj2.b;

/* compiled from: P */
/* loaded from: classes35.dex */
public class DrawableTextView extends AppCompatTextView {
    private static final int BOTTOM = 3;
    private static final int LEFT = 0;
    private static final int RIGHT = 2;
    private static final int TOP = 1;
    private int drawableBottomHeight;
    private int drawableBottomWidth;
    private int drawableLeftHeight;
    private int drawableLeftWidth;
    private int drawableRightHeight;
    private int drawableRightWidth;
    private int drawableTopHeight;
    private int drawableTopWidth;
    private boolean isAlignCenter;
    private int mHeight;
    private int mWidth;

    public DrawableTextView(Context context) {
        this(context, null);
    }

    private void initView(Context context, AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.C8);
        this.drawableLeftWidth = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.drawableTopWidth = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.drawableRightWidth = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.drawableBottomWidth = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.drawableLeftHeight = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.drawableTopHeight = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.drawableRightHeight = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.drawableBottomHeight = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.isAlignCenter = obtainStyledAttributes.getBoolean(8, false);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.mWidth = i3;
        this.mHeight = i16;
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable = compoundDrawables[0];
        Drawable drawable2 = compoundDrawables[1];
        Drawable drawable3 = compoundDrawables[2];
        Drawable drawable4 = compoundDrawables[3];
        if (drawable != null) {
            setDrawable(drawable, 0, this.drawableLeftWidth, this.drawableLeftHeight);
        }
        if (drawable2 != null) {
            setDrawable(drawable2, 1, this.drawableTopWidth, this.drawableTopHeight);
        }
        if (drawable3 != null) {
            setDrawable(drawable3, 2, this.drawableRightWidth, this.drawableRightHeight);
        }
        if (drawable4 != null) {
            setDrawable(drawable4, 3, this.drawableBottomWidth, this.drawableBottomHeight);
        }
        setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public DrawableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawableTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.isAlignCenter = false;
        initView(context, attributeSet, i3);
    }

    private void setDrawable(Drawable drawable, int i3, int i16, int i17) {
        int lineHeight;
        int i18;
        if (i16 == 0) {
            i16 = drawable.getIntrinsicWidth();
        }
        if (i17 == 0) {
            i17 = drawable.getIntrinsicHeight();
        }
        int i19 = 0;
        if (i3 != 0) {
            if (i3 == 1) {
                int i26 = this.isAlignCenter ? 0 : ((-this.mWidth) / 2) + (i16 / 2);
                i16 += i26;
                i18 = i17 + 0;
                i19 = i26;
                lineHeight = 0;
            } else if (i3 != 2) {
                lineHeight = 0;
                i16 = 0;
                i18 = 0;
            }
            drawable.setBounds(i19, lineHeight, i16, i18);
        }
        lineHeight = this.isAlignCenter ? 0 : (((-getLineCount()) * getLineHeight()) / 2) + (getLineHeight() / 2);
        i18 = i17 + lineHeight;
        drawable.setBounds(i19, lineHeight, i16, i18);
    }
}
