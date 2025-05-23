package android.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes.dex */
class Drawables {
    static final int BOTTOM = 3;
    static final int DRAWABLE_LEFT = 1;
    static final int DRAWABLE_NONE = -1;
    static final int DRAWABLE_RIGHT = 0;
    static final int LEFT = 0;
    static final int RIGHT = 2;
    static final int TOP = 1;
    Drawable mDrawableEnd;
    Drawable mDrawableError;
    int mDrawableHeightEnd;
    int mDrawableHeightError;
    int mDrawableHeightLeft;
    int mDrawableHeightRight;
    int mDrawableHeightStart;
    int mDrawableHeightTemp;
    Drawable mDrawableLeftInitial;
    int mDrawablePadding;
    Drawable mDrawableRightInitial;
    int mDrawableSizeBottom;
    int mDrawableSizeEnd;
    int mDrawableSizeError;
    int mDrawableSizeLeft;
    int mDrawableSizeRight;
    int mDrawableSizeStart;
    int mDrawableSizeTemp;
    int mDrawableSizeTop;
    Drawable mDrawableStart;
    Drawable mDrawableTemp;
    int mDrawableWidthBottom;
    int mDrawableWidthTop;
    boolean mHasTint;
    boolean mHasTintMode;
    final Rect mCompoundRect = new Rect();
    final Drawable[] mShowing = new Drawable[4];
    boolean mIsRtlCompatibilityMode = true;
    int mDrawableSaved = -1;
    boolean mOverride = false;

    public Drawables(Context context) {
    }

    private void applyErrorDrawableIfNeeded(int i3) {
        int i16 = this.mDrawableSaved;
        if (i16 != 0) {
            if (i16 == 1) {
                this.mShowing[0] = this.mDrawableTemp;
                this.mDrawableSizeLeft = this.mDrawableSizeTemp;
                this.mDrawableHeightLeft = this.mDrawableHeightTemp;
            }
        } else {
            this.mShowing[2] = this.mDrawableTemp;
            this.mDrawableSizeRight = this.mDrawableSizeTemp;
            this.mDrawableHeightRight = this.mDrawableHeightTemp;
        }
        Drawable drawable = this.mDrawableError;
        if (drawable != null) {
            if (i3 != 1) {
                this.mDrawableSaved = 0;
                Drawable[] drawableArr = this.mShowing;
                this.mDrawableTemp = drawableArr[2];
                this.mDrawableSizeTemp = this.mDrawableSizeRight;
                this.mDrawableHeightTemp = this.mDrawableHeightRight;
                drawableArr[2] = drawable;
                this.mDrawableSizeRight = this.mDrawableSizeError;
                this.mDrawableHeightRight = this.mDrawableHeightError;
                return;
            }
            this.mDrawableSaved = 1;
            Drawable[] drawableArr2 = this.mShowing;
            this.mDrawableTemp = drawableArr2[0];
            this.mDrawableSizeTemp = this.mDrawableSizeLeft;
            this.mDrawableHeightTemp = this.mDrawableHeightLeft;
            drawableArr2[0] = drawable;
            this.mDrawableSizeLeft = this.mDrawableSizeError;
            this.mDrawableHeightLeft = this.mDrawableHeightError;
        }
    }

    public void clearByMetadata() {
        for (int length = this.mShowing.length - 1; length >= 0; length--) {
            Drawable drawable = this.mShowing[length];
            if (drawable != null) {
                drawable.setCallback(null);
            }
            this.mShowing[length] = null;
        }
        this.mDrawableHeightLeft = 0;
        this.mDrawableSizeLeft = 0;
        this.mDrawableHeightRight = 0;
        this.mDrawableSizeRight = 0;
        this.mDrawableWidthTop = 0;
        this.mDrawableSizeTop = 0;
        this.mDrawableWidthBottom = 0;
        this.mDrawableSizeBottom = 0;
    }

    public void discardRelative() {
        Drawable drawable = this.mDrawableStart;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.mDrawableStart = null;
        Drawable drawable2 = this.mDrawableEnd;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mDrawableEnd = null;
        this.mDrawableSizeStart = 0;
        this.mDrawableHeightStart = 0;
        this.mDrawableSizeEnd = 0;
        this.mDrawableHeightEnd = 0;
    }

    public boolean hasMetadata() {
        if (this.mDrawablePadding == 0 && !this.mHasTintMode && !this.mHasTint) {
            return false;
        }
        return true;
    }

    public boolean resolveWithLayoutDirection(int i3) {
        Drawable[] drawableArr = this.mShowing;
        Drawable drawable = drawableArr[0];
        Drawable drawable2 = drawableArr[2];
        Drawable drawable3 = this.mDrawableLeftInitial;
        drawableArr[0] = drawable3;
        Drawable drawable4 = this.mDrawableRightInitial;
        drawableArr[2] = drawable4;
        if (this.mIsRtlCompatibilityMode) {
            Drawable drawable5 = this.mDrawableStart;
            if (drawable5 != null && drawable3 == null) {
                drawableArr[0] = drawable5;
                this.mDrawableSizeLeft = this.mDrawableSizeStart;
                this.mDrawableHeightLeft = this.mDrawableHeightStart;
            }
            Drawable drawable6 = this.mDrawableEnd;
            if (drawable6 != null && drawable4 == null) {
                drawableArr[2] = drawable6;
                this.mDrawableSizeRight = this.mDrawableSizeEnd;
                this.mDrawableHeightRight = this.mDrawableHeightEnd;
            }
        } else if (i3 != 1) {
            if (this.mOverride) {
                drawableArr[0] = this.mDrawableStart;
                this.mDrawableSizeLeft = this.mDrawableSizeStart;
                this.mDrawableHeightLeft = this.mDrawableHeightStart;
                drawableArr[2] = this.mDrawableEnd;
                this.mDrawableSizeRight = this.mDrawableSizeEnd;
                this.mDrawableHeightRight = this.mDrawableHeightEnd;
            }
        } else if (this.mOverride) {
            drawableArr[2] = this.mDrawableStart;
            this.mDrawableSizeRight = this.mDrawableSizeStart;
            this.mDrawableHeightRight = this.mDrawableHeightStart;
            drawableArr[0] = this.mDrawableEnd;
            this.mDrawableSizeLeft = this.mDrawableSizeEnd;
            this.mDrawableHeightLeft = this.mDrawableHeightEnd;
        }
        applyErrorDrawableIfNeeded(i3);
        Drawable[] drawableArr2 = this.mShowing;
        if (drawableArr2[0] == drawable && drawableArr2[2] == drawable2) {
            return false;
        }
        return true;
    }

    public void setErrorDrawable(Drawable drawable, TextView textView) {
        Drawable drawable2 = this.mDrawableError;
        if (drawable2 != drawable && drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mDrawableError = drawable;
        if (drawable != null) {
            Rect rect = this.mCompoundRect;
            this.mDrawableError.setState(textView.getDrawableState());
            this.mDrawableError.copyBounds(rect);
            this.mDrawableError.setCallback(textView);
            this.mDrawableSizeError = rect.width();
            this.mDrawableHeightError = rect.height();
            return;
        }
        this.mDrawableHeightError = 0;
        this.mDrawableSizeError = 0;
    }

    public Drawables updateDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, int[] iArr, Drawable.Callback callback) {
        this.mOverride = false;
        Drawable drawable5 = this.mShowing[0];
        if (drawable5 != drawable && drawable5 != null) {
            drawable5.setCallback(null);
        }
        Drawable[] drawableArr = this.mShowing;
        drawableArr[0] = drawable;
        Drawable drawable6 = drawableArr[1];
        if (drawable6 != drawable2 && drawable6 != null) {
            drawable6.setCallback(null);
        }
        Drawable[] drawableArr2 = this.mShowing;
        drawableArr2[1] = drawable2;
        Drawable drawable7 = drawableArr2[2];
        if (drawable7 != drawable3 && drawable7 != null) {
            drawable7.setCallback(null);
        }
        Drawable[] drawableArr3 = this.mShowing;
        drawableArr3[2] = drawable3;
        Drawable drawable8 = drawableArr3[3];
        if (drawable8 != drawable4 && drawable8 != null) {
            drawable8.setCallback(null);
        }
        this.mShowing[3] = drawable4;
        Rect rect = this.mCompoundRect;
        if (drawable != null) {
            drawable.setState(iArr);
            drawable.copyBounds(rect);
            drawable.setCallback(callback);
            this.mDrawableSizeLeft = rect.width();
            this.mDrawableHeightLeft = rect.height();
        } else {
            this.mDrawableHeightLeft = 0;
            this.mDrawableSizeLeft = 0;
        }
        if (drawable3 != null) {
            drawable3.setState(iArr);
            drawable3.copyBounds(rect);
            drawable3.setCallback(callback);
            this.mDrawableSizeRight = rect.width();
            this.mDrawableHeightRight = rect.height();
        } else {
            this.mDrawableHeightRight = 0;
            this.mDrawableSizeRight = 0;
        }
        if (drawable2 != null) {
            drawable2.setState(iArr);
            drawable2.copyBounds(rect);
            drawable2.setCallback(callback);
            this.mDrawableSizeTop = rect.height();
            this.mDrawableWidthTop = rect.width();
        } else {
            this.mDrawableWidthTop = 0;
            this.mDrawableSizeTop = 0;
        }
        if (drawable4 != null) {
            drawable4.setState(iArr);
            drawable4.copyBounds(rect);
            drawable4.setCallback(callback);
            this.mDrawableSizeBottom = rect.height();
            this.mDrawableWidthBottom = rect.width();
        } else {
            this.mDrawableWidthBottom = 0;
            this.mDrawableSizeBottom = 0;
        }
        return this;
    }
}
