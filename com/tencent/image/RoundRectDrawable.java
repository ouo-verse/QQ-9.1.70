package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RoundRectDrawable extends Drawable {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "RoundRectDrawable";
    private RoundRectDrawableState mBitmapState;
    private float mBorderWidth;
    final RectF mBounds;
    private float mCornerRadius;
    private int mHeight;
    private int mTargetDensity;
    private int mWidth;
    boolean reBuildCornerRadius;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class RoundRectDrawableState extends Drawable.ConstantState {
        static IPatchRedirector $redirector_;
        final int mBitmapHeight;
        final Paint mBitmapPaint;
        final RectF mBitmapRect;
        final BitmapShader mBitmapShader;
        final int mBitmapWidth;
        final Paint mBorderPaint;
        final RectF mBorderRect;
        int mChangingConfigurations;
        final RectF mDrawableRect;
        boolean mOval;
        final RoundRectBitmap mRoundRectBitmap;
        final Matrix mShaderMatrix;
        int mTargetDensity;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RoundRectDrawableState(RoundRectBitmap roundRectBitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) roundRectBitmap);
                return;
            }
            this.mDrawableRect = new RectF();
            RectF rectF = new RectF();
            this.mBitmapRect = rectF;
            this.mBorderRect = new RectF();
            Matrix matrix = new Matrix();
            this.mShaderMatrix = matrix;
            this.mOval = false;
            this.mTargetDensity = 160;
            this.mRoundRectBitmap = roundRectBitmap;
            int width = roundRectBitmap.mBitmap.getWidth();
            this.mBitmapWidth = width;
            int height = roundRectBitmap.mBitmap.getHeight();
            this.mBitmapHeight = height;
            rectF.set(0.0f, 0.0f, width, height);
            Bitmap bitmap = roundRectBitmap.mBitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.mBitmapShader = bitmapShader;
            bitmapShader.setLocalMatrix(matrix);
            Paint paint = new Paint();
            this.mBitmapPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
            Paint paint2 = new Paint();
            this.mBorderPaint = paint2;
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setAntiAlias(true);
            paint2.setColor(roundRectBitmap.mBoardColor);
            paint2.setStrokeWidth(roundRectBitmap.mBorderWidth);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return new RoundRectDrawable(this, null, 0 == true ? 1 : 0);
            }
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        void updateShaderMatrix(RectF rectF) {
            this.mBorderRect.set(this.mBitmapRect);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, rectF, Matrix.ScaleToFit.CENTER);
            this.mShaderMatrix.mapRect(this.mBorderRect);
            RectF rectF2 = this.mBorderRect;
            float f16 = this.mRoundRectBitmap.mBorderWidth;
            rectF2.inset(f16 / 2.0f, f16 / 2.0f);
            this.mShaderMatrix.setRectToRect(this.mBitmapRect, this.mBorderRect, Matrix.ScaleToFit.FILL);
            this.mDrawableRect.set(this.mBorderRect);
            this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new RoundRectDrawable(this, resources, null) : (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) resources);
        }
    }

    /* synthetic */ RoundRectDrawable(RoundRectDrawableState roundRectDrawableState, Resources resources, AnonymousClass1 anonymousClass1) {
        this(roundRectDrawableState, resources);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, this, roundRectDrawableState, resources, anonymousClass1);
    }

    private void computeBitmapSize() {
        this.mWidth = this.mBitmapState.mRoundRectBitmap.mBitmap.getScaledWidth(this.mTargetDensity);
        this.mHeight = this.mBitmapState.mRoundRectBitmap.mBitmap.getScaledHeight(this.mTargetDensity);
        int bitmapDensity = getBitmapDensity();
        this.mBorderWidth = (((int) (this.mBitmapState.mRoundRectBitmap.mBorderWidth * this.mTargetDensity)) + (bitmapDensity >> 1)) / bitmapDensity;
    }

    private int getBitmapDensity() {
        int density = this.mBitmapState.mRoundRectBitmap.mBitmap.getDensity();
        if (density == 0) {
            return 160;
        }
        return density;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        RoundRectDrawableState roundRectDrawableState = this.mBitmapState;
        RectF rectF = roundRectDrawableState.mDrawableRect;
        RectF rectF2 = roundRectDrawableState.mBorderRect;
        Paint paint = roundRectDrawableState.mBorderPaint;
        Paint paint2 = roundRectDrawableState.mBitmapPaint;
        float width = rectF.width();
        float height = rectF.height();
        int width2 = canvas.getWidth();
        int height2 = canvas.getHeight();
        RoundRectBitmap roundRectBitmap = this.mBitmapState.mRoundRectBitmap;
        if (width2 != roundRectBitmap.mDisplayWidth && height2 != roundRectBitmap.mDisplayHeight) {
            f16 = width2 / width;
            float f17 = height2 / height;
            if (f16 >= f17) {
                f16 = f17;
            }
        } else {
            f16 = 1.0f;
        }
        int bitmapDensity = getBitmapDensity();
        RoundRectDrawableState roundRectDrawableState2 = this.mBitmapState;
        float f18 = (((roundRectDrawableState2.mRoundRectBitmap.mCornerRadius * this.mTargetDensity) + (bitmapDensity >> 1)) / bitmapDensity) / f16;
        this.mCornerRadius = f18;
        if (roundRectDrawableState2.mOval) {
            if (this.mBorderWidth > 0.0f) {
                canvas.drawOval(rectF, paint2);
                canvas.drawOval(rectF2, paint);
                return;
            } else {
                canvas.drawOval(rectF, paint2);
                return;
            }
        }
        if (this.mBorderWidth > 0.0f) {
            canvas.drawRoundRect(rectF, Math.max(f18, 0.0f), Math.max(this.mCornerRadius, 0.0f), paint2);
            float f19 = this.mCornerRadius;
            canvas.drawRoundRect(rectF2, f19, f19, paint);
            return;
        }
        canvas.drawRoundRect(rectF, f18, f18, paint2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return super.getChangingConfigurations() | this.mBitmapState.mChangingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Drawable.ConstantState) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        this.mBitmapState.mChangingConfigurations = getChangingConfigurations();
        return this.mBitmapState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Drawable) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        this.mBitmapState = new RoundRectDrawableState(this.mBitmapState.mRoundRectBitmap);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rect);
            return;
        }
        super.onBoundsChange(rect);
        this.mBounds.set(rect);
        this.mBitmapState.updateShaderMatrix(this.mBounds);
        this.reBuildCornerRadius = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mBitmapState.mBitmapPaint.setAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) colorFilter);
        } else {
            this.mBitmapState.mBitmapPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        this.mBitmapState.mBorderPaint.setDither(z16);
        this.mBitmapState.mBitmapPaint.setDither(z16);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.mBitmapState.mBitmapPaint.setFilterBitmap(z16);
            invalidateSelf();
        }
    }

    public RoundRectDrawable setOval(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (RoundRectDrawable) iPatchRedirector.redirect((short) 13, (Object) this, z16);
        }
        this.mBitmapState.mOval = z16;
        return this;
    }

    public void setTargetDensity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        if (i3 != this.mTargetDensity) {
            if (i3 == 0) {
                i3 = 160;
            }
            this.mTargetDensity = i3;
            computeBitmapSize();
            invalidateSelf();
        }
    }

    public RoundRectDrawable(Resources resources, RoundRectBitmap roundRectBitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) resources, (Object) roundRectBitmap);
            return;
        }
        this.mTargetDensity = 160;
        this.reBuildCornerRadius = false;
        this.mBounds = new RectF();
        this.mBitmapState = new RoundRectDrawableState(roundRectBitmap);
        if (resources != null) {
            int i3 = resources.getDisplayMetrics().densityDpi;
            this.mTargetDensity = i3;
            this.mBitmapState.mTargetDensity = i3;
        }
        computeBitmapSize();
    }

    RoundRectDrawable(RoundRectDrawableState roundRectDrawableState, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) roundRectDrawableState, (Object) resources);
            return;
        }
        this.mTargetDensity = 160;
        this.reBuildCornerRadius = false;
        this.mBounds = new RectF();
        this.mBitmapState = roundRectDrawableState;
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        } else {
            this.mTargetDensity = roundRectDrawableState.mTargetDensity;
        }
        computeBitmapSize();
    }
}
