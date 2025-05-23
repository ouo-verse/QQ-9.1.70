package com.tencent.hippy.qq.view.tkd.listview;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TintDrawableWrapper extends DrawableWrapper {
    private int mCurrentColor;
    private int mTint;
    private final PorterDuff.Mode mTintMode;
    private final ColorStateList mTintStateList;

    public TintDrawableWrapper(Drawable drawable, ColorStateList colorStateList) {
        this(drawable, colorStateList, PorterDuff.Mode.SRC_ATOP);
    }

    private boolean updateTint(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.mTintStateList;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.mCurrentColor)) != this.mCurrentColor) {
            if (colorForState != 0) {
                setColorFilter(colorForState, this.mTintMode);
            } else {
                clearColorFilter();
            }
            this.mCurrentColor = colorForState;
            return true;
        }
        if (this.mTint != 0) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        int i3 = this.mTint;
        if (i3 != 0) {
            super.setColorFilter(i3, this.mTintMode);
        }
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.mTintStateList;
        if ((colorStateList != null && colorStateList.isStateful()) || super.isStateful()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.DrawableWrapper, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        int i3;
        if (colorFilter == null && (i3 = this.mTint) != 0) {
            super.setColorFilter(i3, this.mTintMode);
        } else {
            super.setColorFilter(colorFilter);
        }
    }

    @Override // com.tencent.hippy.qq.view.tkd.listview.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        boolean state = super.setState(iArr);
        if (!updateTint(iArr) && !state) {
            return false;
        }
        return true;
    }

    public TintDrawableWrapper(Drawable drawable, int i3) {
        super(drawable);
        this.mTint = i3;
        this.mTintStateList = null;
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
        this.mTintMode = mode;
        super.setColorFilter(i3, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i3, PorterDuff.Mode mode) {
        if (this.mTint != 0 && mode == PorterDuff.Mode.SRC_ATOP) {
            i3 = Color.argb((int) ((1.0f - ((1.0f - (Color.alpha(r0) / 255.0f)) * (1.0f - (Color.alpha(i3) / 255.0f)))) * 255.0f), (int) (Color.red(i3) + (Color.red(this.mTint) * (1.0f - (Color.alpha(i3) / 255.0f)))), (int) (Color.green(i3) + (Color.green(this.mTint) * (1.0f - (Color.alpha(i3) / 255.0f)))), (int) (Color.blue(i3) + (Color.blue(this.mTint) * (1.0f - (Color.alpha(i3) / 255.0f)))));
        }
        super.setColorFilter(i3, mode);
    }

    public TintDrawableWrapper(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        super(drawable);
        this.mTintStateList = colorStateList;
        this.mTintMode = mode;
    }
}
