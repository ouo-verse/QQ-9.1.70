package com.tencent.mtt.supportui.views.asyncimage;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.tencent.mtt.supportui.utils.CommonTool;
import com.tencent.mtt.supportui.views.asyncimage.AsyncImageView;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ContentDrawable extends BaseDrawable {
    private Path mBorderPath;
    private float[] mBorderRadiusArray;
    private float[] mBorderWidthArray;
    protected Bitmap mContentBitmap;
    private int mImagePositionX;
    private int mImagePositionY;
    protected Paint mPaint;
    protected int mTintColor;
    public Path mSelfClipPath = null;
    private int sourceType = 1;
    protected AsyncImageView.ScaleType mScaleType = AsyncImageView.ScaleType.FIT_XY;
    protected int mAlpha = 255;
    private boolean mNeedUpdateBorderPath = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mtt.supportui.views.asyncimage.ContentDrawable$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType;

        static {
            int[] iArr = new int[AsyncImageView.ScaleType.values().length];
            $SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType = iArr;
            try {
                iArr[AsyncImageView.ScaleType.REPEAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[AsyncImageView.ScaleType.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[AsyncImageView.ScaleType.ORIGIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[AsyncImageView.ScaleType.CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[AsyncImageView.ScaleType.CENTER_INSIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[AsyncImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static float calculateBorderRadius(float f16, float f17, float f18) {
        if (f16 == 0.0f) {
            f16 = f17;
        }
        return Math.max(0.0f, f16 - (f18 * 0.5f));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updatePath() {
        float[] fArr;
        float f16;
        if (this.mNeedUpdateBorderPath && this.mContentBitmap != null) {
            Path path = this.mBorderPath;
            if (path == null) {
                this.mBorderPath = new Path();
            } else {
                path.rewind();
            }
            this.mNeedUpdateBorderPath = false;
            RectF rectF = new RectF(this.mRect);
            int width = this.mContentBitmap.getWidth();
            int height = this.mContentBitmap.getHeight();
            float width2 = this.mRect.width();
            float height2 = this.mRect.height();
            float f17 = width;
            float f18 = width2 / f17;
            float f19 = height;
            float f26 = height2 / f19;
            AsyncImageView.ScaleType scaleType = this.mScaleType;
            if (scaleType == AsyncImageView.ScaleType.CENTER && (f17 > width2 || f19 > height2)) {
                scaleType = AsyncImageView.ScaleType.CENTER_INSIDE;
            }
            int i3 = AnonymousClass1.$SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[scaleType.ordinal()];
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 == 5) {
                        if (f18 > f26) {
                            rectF.top = 0.0f;
                            rectF.bottom = height2;
                            rectF.left = (int) ((width2 - r3) / 2.0f);
                            f17 = (int) (((f17 * f26) + width2) / 2.0f);
                        } else {
                            float f27 = f19 * f18;
                            rectF.top = (int) ((height2 - f27) / 2.0f);
                            rectF.bottom = (int) ((f27 + height2) / 2.0f);
                            rectF.left = 0.0f;
                            rectF.right = width2;
                        }
                    }
                    float f28 = rectF.top;
                    int i16 = this.mImagePositionY;
                    rectF.top = f28 + i16;
                    rectF.bottom += i16;
                    float f29 = rectF.left;
                    int i17 = this.mImagePositionX;
                    rectF.left = f29 + i17;
                    rectF.right += i17;
                    fArr = this.mBorderWidthArray;
                    if (fArr != null) {
                        f16 = 0.0f;
                    } else {
                        f16 = fArr[0];
                    }
                    this.mBorderPath.addRect(rectF, Path.Direction.CW);
                    if (!CommonTool.hasPositiveItem(this.mBorderRadiusArray)) {
                        Path path2 = new Path();
                        float[] fArr2 = this.mBorderRadiusArray;
                        float f36 = fArr2[0];
                        float calculateBorderRadius = calculateBorderRadius(fArr2[1], f36, f16);
                        float calculateBorderRadius2 = calculateBorderRadius(this.mBorderRadiusArray[2], f36, f16);
                        float calculateBorderRadius3 = calculateBorderRadius(this.mBorderRadiusArray[3], f36, f16);
                        float calculateBorderRadius4 = calculateBorderRadius(this.mBorderRadiusArray[4], f36, f16);
                        rectF.set(this.mRect);
                        rectF.inset(f16, f16);
                        path2.addRoundRect(rectF, new float[]{calculateBorderRadius, calculateBorderRadius, calculateBorderRadius2, calculateBorderRadius2, calculateBorderRadius3, calculateBorderRadius3, calculateBorderRadius4, calculateBorderRadius4}, Path.Direction.CW);
                        this.mBorderPath.op(path2, Path.Op.INTERSECT);
                        return;
                    }
                    if (f16 > 0.0f) {
                        Path path3 = new Path();
                        path3.addRect(f16, f16, width2 - f16, height2 - f16, Path.Direction.CW);
                        this.mBorderPath.op(path3, Path.Op.INTERSECT);
                        return;
                    }
                    return;
                }
                rectF.top = (height2 - f19) / 2.0f;
                rectF.bottom = (f19 + height2) / 2.0f;
                rectF.left = (width2 - f17) / 2.0f;
                f17 = (f17 + width2) / 2.0f;
            } else {
                rectF.top = 0.0f;
                rectF.bottom = f19;
                rectF.left = 0.0f;
            }
            rectF.right = f17;
            float f282 = rectF.top;
            int i162 = this.mImagePositionY;
            rectF.top = f282 + i162;
            rectF.bottom += i162;
            float f292 = rectF.left;
            int i172 = this.mImagePositionX;
            rectF.left = f292 + i172;
            rectF.right += i172;
            fArr = this.mBorderWidthArray;
            if (fArr != null) {
            }
            this.mBorderPath.addRect(rectF, Path.Direction.CW);
            if (!CommonTool.hasPositiveItem(this.mBorderRadiusArray)) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0127  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas) {
        float f16;
        float f17;
        Bitmap bitmap = this.mContentBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            if (this.mPaint == null) {
                this.mPaint = new Paint(1);
            }
            updateContentRegion();
            updatePath();
            if (this.mContentBitmap != null) {
                Matrix matrix = new Matrix();
                matrix.reset();
                RectF rectF = new RectF(this.mRect);
                float[] fArr = this.mBorderWidthArray;
                if (fArr == null) {
                    f16 = 0.0f;
                } else {
                    f16 = fArr[0];
                }
                if (f16 > 1.0f) {
                    float f18 = f16 * 0.5f;
                    rectF.inset(f18, f18);
                }
                int width = this.mContentBitmap.getWidth();
                int height = this.mContentBitmap.getHeight();
                float width2 = this.mRect.width();
                float height2 = this.mRect.height();
                float f19 = width;
                float f26 = width2 / f19;
                float f27 = height;
                float f28 = height2 / f27;
                AsyncImageView.ScaleType scaleType = this.mScaleType;
                if (scaleType == AsyncImageView.ScaleType.CENTER && (f19 > width2 || f27 > height2)) {
                    scaleType = AsyncImageView.ScaleType.CENTER_INSIDE;
                }
                int i3 = AnonymousClass1.$SwitchMap$com$tencent$mtt$supportui$views$asyncimage$AsyncImageView$ScaleType[scaleType.ordinal()];
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 == 6) {
                                if (f26 <= f28) {
                                    f26 = f28;
                                }
                                float f29 = f27 * f26;
                                rectF.top = (int) ((height2 - f29) / 2.0f);
                                rectF.bottom = (int) ((height2 + f29) / 2.0f);
                                f17 = f19 * f26;
                            }
                            float f36 = rectF.top;
                            int i16 = this.mImagePositionY;
                            rectF.top = f36 + i16;
                            rectF.bottom += i16;
                            float f37 = rectF.left;
                            int i17 = this.mImagePositionX;
                            rectF.left = f37 + i17;
                            rectF.right += i17;
                            matrix.setRectToRect(new RectF(0.0f, 0.0f, this.mContentBitmap.getWidth(), this.mContentBitmap.getHeight()), rectF, Matrix.ScaleToFit.FILL);
                            this.mPaint.reset();
                            this.mPaint.setAlpha(this.mAlpha);
                            if (this.mTintColor != 0) {
                                this.mPaint.setColorFilter(new PorterDuffColorFilter(this.mTintColor, PorterDuff.Mode.SRC_ATOP));
                            }
                            drawBitmap(canvas, matrix);
                        }
                        if (f26 > f28) {
                            rectF.top = 0.0f;
                            rectF.bottom = height2;
                            f17 = f19 * f28;
                        } else {
                            float f38 = f27 * f26;
                            rectF.top = (int) ((height2 - f38) / 2.0f);
                            rectF.bottom = (int) ((height2 + f38) / 2.0f);
                            rectF.left = 0.0f;
                        }
                        rectF.left = (int) ((width2 - f17) / 2.0f);
                        f19 = (int) ((width2 + f17) / 2.0f);
                    } else {
                        rectF.top = (height2 - f27) / 2.0f;
                        rectF.bottom = (height2 + f27) / 2.0f;
                        rectF.left = (width2 - f19) / 2.0f;
                        width2 = (width2 + f19) / 2.0f;
                    }
                    rectF.right = width2;
                    float f362 = rectF.top;
                    int i162 = this.mImagePositionY;
                    rectF.top = f362 + i162;
                    rectF.bottom += i162;
                    float f372 = rectF.left;
                    int i172 = this.mImagePositionX;
                    rectF.left = f372 + i172;
                    rectF.right += i172;
                    matrix.setRectToRect(new RectF(0.0f, 0.0f, this.mContentBitmap.getWidth(), this.mContentBitmap.getHeight()), rectF, Matrix.ScaleToFit.FILL);
                    this.mPaint.reset();
                    this.mPaint.setAlpha(this.mAlpha);
                    if (this.mTintColor != 0) {
                    }
                    drawBitmap(canvas, matrix);
                }
                rectF.top = 0.0f;
                rectF.bottom = f27;
                rectF.left = 0.0f;
                rectF.right = f19;
                float f3622 = rectF.top;
                int i1622 = this.mImagePositionY;
                rectF.top = f3622 + i1622;
                rectF.bottom += i1622;
                float f3722 = rectF.left;
                int i1722 = this.mImagePositionX;
                rectF.left = f3722 + i1722;
                rectF.right += i1722;
                matrix.setRectToRect(new RectF(0.0f, 0.0f, this.mContentBitmap.getWidth(), this.mContentBitmap.getHeight()), rectF, Matrix.ScaleToFit.FILL);
                this.mPaint.reset();
                this.mPaint.setAlpha(this.mAlpha);
                if (this.mTintColor != 0) {
                }
                drawBitmap(canvas, matrix);
            }
        }
    }

    protected void drawBitmap(Canvas canvas, Matrix matrix) {
        Path path = this.mSelfClipPath;
        if (path != null) {
            try {
                canvas.clipPath(path);
            } catch (Throwable unused) {
            }
        }
        if (this.mScaleType == AsyncImageView.ScaleType.REPEAT) {
            Bitmap bitmap = this.mContentBitmap;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.mPaint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            if (this.mBorderPath != null) {
                this.mPaint.setAntiAlias(true);
                canvas.drawPath(this.mBorderPath, this.mPaint);
                return;
            }
            return;
        }
        if (!CommonTool.hasPositiveItem(this.mBorderRadiusArray) && !CommonTool.hasPositiveItem(this.mBorderWidthArray)) {
            this.mPaint.setFilterBitmap(true);
            canvas.drawBitmap(this.mContentBitmap, matrix, this.mPaint);
            return;
        }
        Bitmap bitmap2 = this.mContentBitmap;
        Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap2, tileMode2, tileMode2);
        bitmapShader.setLocalMatrix(matrix);
        this.mPaint.setShader(bitmapShader);
        if (this.mBorderPath != null) {
            this.mPaint.setAntiAlias(true);
            canvas.drawPath(this.mBorderPath, this.mPaint);
        }
    }

    public int getAlphaValue() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mNeedUpdateBorderPath = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.mAlpha = i3;
        invalidateSelf();
    }

    public void setBitmap(Bitmap bitmap) {
        this.mContentBitmap = bitmap;
    }

    public void setBorder(float[] fArr, float[] fArr2) {
        this.mBorderWidthArray = fArr2;
        this.mBorderRadiusArray = fArr;
        this.mNeedUpdateBorderPath = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i16, int i17, int i18) {
        super.setBounds(i3, i16, i17, i18);
        updateContentRegion();
    }

    public void setImagePositionX(int i3) {
        this.mImagePositionX = i3;
    }

    public void setImagePositionY(int i3) {
        this.mImagePositionY = i3;
    }

    public void setScaleType(AsyncImageView.ScaleType scaleType) {
        if (scaleType != null) {
            this.mScaleType = scaleType;
        }
    }

    public void setSourceType(int i3) {
        this.sourceType = i3;
    }

    public void setTintColor(int i3) {
        this.mTintColor = i3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
