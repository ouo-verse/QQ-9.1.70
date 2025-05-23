package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SliceBitmapDrawable extends Drawable {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_PAINT_FLAGS = 6;
    private static final int SLICE_SIZE = 2048;
    private BitmapState mBitmapState;
    private int mHeight;
    private boolean mMutated;
    private int mTargetDensity;
    private int mWidth;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class BitmapState extends Drawable.ConstantState {
        static IPatchRedirector $redirector_;
        int mChangingConfigurations;
        Paint mPaint;
        SliceBitmap mSliceBitmap;
        int mTargetDensity;

        BitmapState(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitmap);
                return;
            }
            this.mPaint = new Paint(6);
            this.mTargetDensity = 160;
            this.mSliceBitmap = new SliceBitmap(bitmap);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return new SliceBitmapDrawable(this, null, 0 == true ? 1 : 0);
            }
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? new SliceBitmapDrawable(this, resources, null) : (Drawable) iPatchRedirector.redirect((short) 5, (Object) this, (Object) resources);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public BitmapState(SliceBitmap sliceBitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) sliceBitmap);
                return;
            }
            this.mPaint = new Paint(6);
            this.mTargetDensity = 160;
            this.mSliceBitmap = sliceBitmap;
        }

        BitmapState(BitmapState bitmapState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmapState);
                return;
            }
            this.mPaint = new Paint(6);
            this.mTargetDensity = 160;
            this.mSliceBitmap = bitmapState.mSliceBitmap;
            this.mChangingConfigurations = bitmapState.mChangingConfigurations;
            this.mTargetDensity = bitmapState.mTargetDensity;
            this.mPaint = new Paint(bitmapState.mPaint);
        }
    }

    /* synthetic */ SliceBitmapDrawable(BitmapState bitmapState, Resources resources, AnonymousClass1 anonymousClass1) {
        this(bitmapState, resources);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            return;
        }
        iPatchRedirector.redirect((short) 23, this, bitmapState, resources, anonymousClass1);
    }

    private void computeBitmapSize() {
        this.mWidth = this.mBitmapState.mSliceBitmap.getScaledWidth(this.mTargetDensity);
        this.mHeight = this.mBitmapState.mSliceBitmap.getScaledHeight(this.mTargetDensity);
    }

    public static boolean needSlice(Bitmap bitmap) {
        if (bitmap.getWidth() <= 2048 && bitmap.getHeight() <= 2048) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        Rect bounds = getBounds();
        BitmapState bitmapState = this.mBitmapState;
        bitmapState.mSliceBitmap.draw(canvas, bounds, bitmapState.mPaint);
    }

    public Bitmap getBitmap(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Bitmap) iPatchRedirector.redirect((short) 20, (Object) this, i3);
        }
        return this.mBitmapState.mSliceBitmap.getBitmap(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return super.getChangingConfigurations() | this.mBitmapState.mChangingConfigurations;
    }

    public int getColumnCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return this.mBitmapState.mSliceBitmap.getColumnCount();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Drawable.ConstantState) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        this.mBitmapState.mChangingConfigurations = getChangingConfigurations();
        return this.mBitmapState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.mHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        BitmapState bitmapState = this.mBitmapState;
        if (!bitmapState.mSliceBitmap.hasAlpha && bitmapState.mPaint.getAlpha() >= 255) {
            return -1;
        }
        return -3;
    }

    public final Paint getPaint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Paint) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mBitmapState.mPaint;
    }

    public int getRowCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.mBitmapState.mSliceBitmap.getRowCount();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Drawable) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        if (!this.mMutated && super.mutate() == this) {
            this.mBitmapState = new BitmapState(this.mBitmapState);
            this.mMutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else if (i3 != this.mBitmapState.mPaint.getAlpha()) {
            this.mBitmapState.mPaint.setAlpha(i3);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.mBitmapState.mPaint.setAntiAlias(z16);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) colorFilter);
        } else {
            this.mBitmapState.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.mBitmapState.mPaint.setDither(z16);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.mBitmapState.mPaint.setFilterBitmap(z16);
            invalidateSelf();
        }
    }

    public void setTargetDensity(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            setTargetDensity(canvas.getDensity());
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
        }
    }

    public SliceBitmapDrawable(Resources resources, Bitmap bitmap) {
        this(new BitmapState(bitmap), resources);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) resources, (Object) bitmap);
        } else {
            this.mBitmapState.mTargetDensity = this.mTargetDensity;
        }
    }

    public void setTargetDensity(DisplayMetrics displayMetrics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            setTargetDensity(displayMetrics.densityDpi);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) displayMetrics);
        }
    }

    public void setTargetDensity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        if (this.mTargetDensity != i3) {
            if (i3 == 0) {
                i3 = 160;
            }
            this.mTargetDensity = i3;
            computeBitmapSize();
            invalidateSelf();
        }
    }

    public SliceBitmapDrawable(Resources resources, SliceBitmap sliceBitmap) {
        this(new BitmapState(sliceBitmap), resources);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) resources, (Object) sliceBitmap);
        } else {
            this.mBitmapState.mTargetDensity = this.mTargetDensity;
        }
    }

    SliceBitmapDrawable(BitmapState bitmapState, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmapState, (Object) resources);
            return;
        }
        this.mBitmapState = bitmapState;
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        } else {
            this.mTargetDensity = bitmapState.mTargetDensity;
        }
        computeBitmapSize();
    }
}
