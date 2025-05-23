package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class ImageViewTouchBase extends ImageView {
    static final float SCALE_RATE = 1.15f;
    private boolean bShadow;
    protected Matrix mBaseMatrix;
    protected final bb mBitmapDisplayed;
    private final Matrix mDisplayMatrix;
    protected Handler mHandler;
    private final float[] mMatrixValues;
    float mMaxZoom;
    float mMinZoom;
    private Runnable mOnLayoutRunnable;
    private a mRecycler;
    protected Matrix mSuppMatrix;
    int mThisHeight;
    int mThisWidth;
    private RectF tmpRect;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        this.mBaseMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mDisplayMatrix = new Matrix();
        this.mMatrixValues = new float[9];
        this.mBitmapDisplayed = new bb(null);
        this.mThisWidth = -1;
        this.mThisHeight = -1;
        this.mMaxZoom = 3.0f;
        this.mMinZoom = 0.5f;
        this.bShadow = false;
        this.mHandler = new Handler();
        this.tmpRect = new RectF();
        this.mOnLayoutRunnable = null;
        init();
    }

    private void getProperBaseMatrix(bb bbVar, Matrix matrix) {
        float width = getWidth();
        float height = getHeight();
        float e16 = bbVar.e();
        float b16 = bbVar.b();
        matrix.reset();
        float min = Math.min(Math.min(width / e16, 3.0f), Math.min(height / b16, 3.0f));
        matrix.postConcat(bbVar.c());
        matrix.postScale(min, min);
        matrix.postTranslate((width - (e16 * min)) / 2.0f, (height - (b16 * min)) / 2.0f);
    }

    private void init() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void SetMinZoom(float f16) {
        this.mMinZoom = f16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007c, code lost:
    
        if (r0 < r7) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void center(boolean z16, boolean z17) {
        float f16;
        float f17;
        float height;
        float f18;
        if (this.mBitmapDisplayed.a() == null) {
            return;
        }
        Matrix imageViewMatrix = getImageViewMatrix();
        float f19 = 0.0f;
        RectF rectF = new RectF(0.0f, 0.0f, this.mBitmapDisplayed.a().getWidth(), this.mBitmapDisplayed.a().getHeight());
        imageViewMatrix.mapRect(rectF);
        float height2 = rectF.height();
        float width = rectF.width();
        if (z17) {
            float height3 = getHeight();
            if (height2 < height3) {
                height = (height3 - height2) / 2.0f;
                f18 = rectF.top;
            } else {
                float f26 = rectF.top;
                if (f26 > 0.0f) {
                    f16 = -f26;
                    if (z16) {
                        float width2 = getWidth();
                        if (width < width2) {
                            width2 = (width2 - width) / 2.0f;
                            f17 = rectF.left;
                        } else {
                            float f27 = rectF.left;
                            if (f27 > 0.0f) {
                                f19 = -f27;
                            } else {
                                f17 = rectF.right;
                            }
                        }
                        f19 = width2 - f17;
                    }
                    postTranslate(f19, f16);
                    setImageMatrix(getImageViewMatrix());
                }
                if (rectF.bottom < height3) {
                    height = getHeight();
                    f18 = rectF.bottom;
                }
            }
            f16 = height - f18;
            if (z16) {
            }
            postTranslate(f19, f16);
            setImageMatrix(getImageViewMatrix());
        }
        f16 = 0.0f;
        if (z16) {
        }
        postTranslate(f19, f16);
        setImageMatrix(getImageViewMatrix());
    }

    public void clear() {
        setImageBitmapResetBase(null, true);
    }

    public RectF getDisplayRect() {
        Matrix imageViewMatrix = getImageViewMatrix();
        RectF rectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        if (this.mBitmapDisplayed.a() != null) {
            rectF.set(0.0f, 0.0f, this.mBitmapDisplayed.a().getWidth(), this.mBitmapDisplayed.a().getHeight());
        }
        imageViewMatrix.mapRect(rectF);
        return rectF;
    }

    public int getImageHeight() {
        return this.mBitmapDisplayed.a().getHeight();
    }

    protected Matrix getImageViewMatrix() {
        this.mDisplayMatrix.set(this.mBaseMatrix);
        this.mDisplayMatrix.postConcat(this.mSuppMatrix);
        return this.mDisplayMatrix;
    }

    public int getImageWidth() {
        return this.mBitmapDisplayed.a().getWidth();
    }

    public float getMaxZoom() {
        return this.mMaxZoom;
    }

    public bb getRotateBitmap() {
        return this.mBitmapDisplayed;
    }

    protected float getScale(Matrix matrix) {
        return getValue(matrix, 0);
    }

    protected RectF getShownRect() {
        return this.tmpRect;
    }

    protected float getValue(Matrix matrix, int i3) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i3];
    }

    protected float maxZoom() {
        if (this.mBitmapDisplayed.a() == null) {
            return 1.0f;
        }
        float max = Math.max(this.mBitmapDisplayed.e() / this.mThisWidth, this.mBitmapDisplayed.b() / this.mThisHeight) * 4.0f;
        if (max < 1.0f) {
            return 3.0f;
        }
        return max;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            bb bbVar = this.mBitmapDisplayed;
            if (bbVar != null && bbVar.a() != null) {
                Paint paint = new Paint();
                Matrix imageViewMatrix = getImageViewMatrix();
                this.tmpRect.set(0.0f, 0.0f, this.mBitmapDisplayed.a().getWidth(), this.mBitmapDisplayed.a().getHeight());
                imageViewMatrix.mapRect(this.tmpRect);
                if (this.bShadow) {
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(1.0f);
                    this.tmpRect.right -= 1.0f;
                    int i3 = -14606047;
                    for (int i16 = 0; i16 < 5; i16++) {
                        RectF rectF = this.tmpRect;
                        rectF.left -= 1.0f;
                        rectF.top -= 1.0f;
                        rectF.right += 1.0f;
                        rectF.bottom += 1.0f;
                        paint.setColor(i3);
                        float f16 = i16;
                        canvas.drawRoundRect(this.tmpRect, f16, f16, paint);
                        int i17 = 5 - i16;
                        i3 += i17 | (i17 << 16) | (i17 << 8);
                    }
                }
            }
        } catch (RuntimeException e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4 && keyEvent.getRepeatCount() == 0) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        if (i3 == 4 && getScale() > 1.0f) {
            zoomTo(1.0f);
            return true;
        }
        return super.onKeyUp(i3, keyEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.mThisWidth = i17 - i3;
        this.mThisHeight = i18 - i16;
        Runnable runnable = this.mOnLayoutRunnable;
        if (runnable != null) {
            this.mOnLayoutRunnable = null;
            runnable.run();
        }
        if (this.mBitmapDisplayed.a() != null) {
            getProperBaseMatrix(this.mBitmapDisplayed, this.mBaseMatrix);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void panBy(float f16, float f17) {
        postTranslate(f16, f17);
        setImageMatrix(getImageViewMatrix());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postTranslate(float f16, float f17) {
        this.mSuppMatrix.postTranslate(f16, f17);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap, 0);
    }

    public void setImageBitmapResetBase(Bitmap bitmap, boolean z16) {
        setImageRotateBitmapResetBase(new bb(bitmap), z16);
    }

    public void setImageRotateBitmapResetBase(final bb bbVar, final boolean z16) {
        if (getWidth() <= 0) {
            this.mOnLayoutRunnable = new Runnable() { // from class: com.tencent.mobileqq.widget.ImageViewTouchBase.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageViewTouchBase.this.setImageRotateBitmapResetBase(bbVar, z16);
                }
            };
            return;
        }
        if (bbVar.a() != null) {
            getProperBaseMatrix(bbVar, this.mBaseMatrix);
            setImageBitmap(bbVar.a(), bbVar.d());
        } else {
            this.mBaseMatrix.reset();
            setImageBitmap(null);
        }
        if (z16) {
            this.mSuppMatrix.reset();
        }
        setImageMatrix(getImageViewMatrix());
        this.mMaxZoom = maxZoom();
    }

    public void setShadow(boolean z16) {
        this.bShadow = z16;
    }

    public float zoomBy(float f16) {
        this.mSuppMatrix.postScale(f16, f16, getWidth() / 2.0f, getHeight() / 2.0f);
        setImageMatrix(getImageViewMatrix());
        center(true, true);
        return getScale();
    }

    public void zoomIn() {
        zoomIn(SCALE_RATE);
    }

    public void zoomOut() {
        zoomOut(SCALE_RATE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000c, code lost:
    
        if (r3 < r0) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected float zoomTo(float f16, float f17, float f18) {
        float f19 = this.mMaxZoom;
        if (f16 <= f19) {
            f19 = this.mMinZoom;
        }
        f16 = f19;
        float scale = f16 / getScale();
        this.mSuppMatrix.postScale(scale, scale, f17, f18);
        setImageMatrix(getImageViewMatrix());
        center(true, true);
        return f16;
    }

    public void zoomToPoint(float f16, float f17, float f18) {
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        panBy(width - f17, height - f18);
        zoomTo(f16, width, height);
    }

    private void setImageBitmap(Bitmap bitmap, int i3) {
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        this.mBitmapDisplayed.a();
        this.mBitmapDisplayed.g(bitmap);
        this.mBitmapDisplayed.h(i3);
    }

    public float getScale() {
        return getScale(this.mSuppMatrix);
    }

    protected void zoomIn(float f16) {
        if (getScale() < this.mMaxZoom && this.mBitmapDisplayed.a() != null) {
            this.mSuppMatrix.postScale(f16, f16, getWidth() / 2.0f, getHeight() / 2.0f);
            setImageMatrix(getImageViewMatrix());
            center(true, true);
        }
    }

    protected void zoomOut(float f16) {
        if (this.mBitmapDisplayed.a() == null) {
            return;
        }
        if (getScale() / f16 < this.mMinZoom) {
            f16 = getScale() / this.mMinZoom;
        }
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        Matrix matrix = new Matrix(this.mSuppMatrix);
        float f17 = 1.0f / f16;
        matrix.postScale(f17, f17, width, height);
        if (getScale(matrix) > 0.5f) {
            this.mSuppMatrix.postScale(f17, f17, width, height);
        }
        setImageMatrix(getImageViewMatrix());
        center(true, true);
    }

    protected void zoomTo(float f16, final float f17, final float f18, final float f19) {
        final float scale = (f16 - getScale()) / f19;
        final float scale2 = getScale();
        final long currentTimeMillis = System.currentTimeMillis();
        this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.widget.ImageViewTouchBase.2
            @Override // java.lang.Runnable
            public void run() {
                float min = Math.min(f19, (float) (System.currentTimeMillis() - currentTimeMillis));
                ImageViewTouchBase.this.zoomTo(scale2 + (scale * min), f17, f18);
                if (min < f19) {
                    ImageViewTouchBase.this.mHandler.post(this);
                }
            }
        });
    }

    public float zoomTo(float f16) {
        return zoomTo(f16, getWidth() / 2.0f, getHeight() / 2.0f);
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBaseMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mDisplayMatrix = new Matrix();
        this.mMatrixValues = new float[9];
        this.mBitmapDisplayed = new bb(null);
        this.mThisWidth = -1;
        this.mThisHeight = -1;
        this.mMaxZoom = 3.0f;
        this.mMinZoom = 0.5f;
        this.bShadow = false;
        this.mHandler = new Handler();
        this.tmpRect = new RectF();
        this.mOnLayoutRunnable = null;
        init();
    }

    public void setRecycler(a aVar) {
    }
}
