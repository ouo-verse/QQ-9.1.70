package com.tencent.component.media.image.processor;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.drawable.ScaleDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;

/* loaded from: classes5.dex */
public class NormalFeedImageProcessor extends CropByPivotProcessor {
    private static final Paint mPaint = new Paint(6);
    private int defaultScaleType;
    private boolean hasPivot;
    private int mHeight;
    private boolean mKeepOrigScale;
    private int mMaxHeight;
    private int mMaxWidth;
    private int mWidth;

    public NormalFeedImageProcessor(int i3, int i16) {
        this.hasPivot = false;
        this.defaultScaleType = 0;
        this.mKeepOrigScale = false;
        this.mWidth = i3;
        this.mHeight = i16;
    }

    public int getHeight() {
        return this.mHeight;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public int getType() {
        return 5;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void keepOrigScale(boolean z16, int i3, int i16) {
        this.mKeepOrigScale = z16;
        this.mMaxWidth = i3;
        this.mMaxHeight = i16;
    }

    @Override // com.tencent.component.media.image.processor.CropByPivotProcessor, com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        int i3;
        int i16;
        int i17;
        int i18;
        if (this.mWidth > 0 && this.mHeight > 0) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i19 = this.mWidth;
            if (intrinsicWidth == i19 && intrinsicHeight == this.mHeight && (drawable instanceof SpecifiedBitmapDrawable)) {
                return drawable;
            }
            if (this.mKeepOrigScale && intrinsicWidth != 0 && intrinsicHeight != 0 && i19 != 0 && (i16 = this.mHeight) != 0) {
                float f16 = (intrinsicWidth * 1.0f) / intrinsicHeight;
                if (Math.abs(f16 - ((i19 * 1.0f) / i16)) > 0.05d && (i17 = this.mMaxWidth) != 0 && (i18 = this.mMaxHeight) != 0) {
                    if (f16 >= (i17 * 1.0f) / i18) {
                        int min = Math.min(intrinsicWidth * 2, i17);
                        this.mWidth = min;
                        this.mHeight = (int) (min / f16);
                    } else {
                        int min2 = Math.min(intrinsicHeight * 2, i18);
                        this.mHeight = min2;
                        this.mWidth = (int) (min2 * f16);
                    }
                }
            }
            if (intrinsicWidth < intrinsicHeight * 2 && !this.hasPivot) {
                i3 = this.defaultScaleType;
            } else {
                i3 = 10;
            }
            int i26 = i3;
            if (drawable instanceof ImageDrawable) {
                try {
                    BitmapReference bitmapRef = ((ImageDrawable) drawable).getBitmapRef();
                    Bitmap.Config config = bitmapRef.getConfig();
                    ImageManager imageManager = ImageManager.getInstance();
                    int i27 = this.mWidth;
                    int i28 = this.mHeight;
                    if (config == null) {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    BitmapReference bitmap = imageManager.getBitmap(i27, i28, config);
                    Canvas canvas = new Canvas(bitmap.getBitmap());
                    Matrix matrix = new Matrix();
                    ScaleDrawable.getMatrix(matrix, i26, bitmapRef.getWidth(), bitmapRef.getHeight(), this.mWidth, this.mHeight, this.mPivotXRate, this.mPivotYRate);
                    if (bitmapRef.isRecycled()) {
                        return null;
                    }
                    canvas.drawBitmap(bitmapRef.getBitmap(), matrix, mPaint);
                    if (!bitmapRef.isRecycled()) {
                        bitmapRef.release();
                    }
                    return new SpecifiedBitmapDrawable(bitmap);
                } catch (OutOfMemoryError e16) {
                    e16.printStackTrace();
                    return null;
                }
            }
            ScaleDrawable scaleDrawable = new ScaleDrawable(drawable, i26);
            scaleDrawable.setPivot(this.mPivotXRate, this.mPivotYRate);
            return new SpecifiedDrawable(scaleDrawable, this.mWidth, this.mHeight);
        }
        return drawable;
    }

    public void setDefaultScaleType(int i3) {
        if (i3 == -1) {
            return;
        }
        this.defaultScaleType = i3;
    }

    public NormalFeedImageProcessor(int i3, int i16, float f16, float f17) {
        this(i3, i16);
        setPivotRate(f16, f17);
        if (f16 == 0.0f && f17 == 0.0f) {
            return;
        }
        this.hasPivot = true;
    }
}
