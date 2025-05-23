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
public class FeedThumbnailProcessor extends CropByPivotProcessor {
    public static final float INFINITESCALE = -1.0f;
    private final int mMaxHeight;
    private float mMaxScale;
    private final int mMaxWidth;

    public FeedThumbnailProcessor(int i3, int i16) {
        this.mMaxScale = -1.0f;
        this.mMaxWidth = i3;
        this.mMaxHeight = i16;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public int getType() {
        return 5;
    }

    @Override // com.tencent.component.media.image.processor.CropByPivotProcessor, com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        if (this.mMaxWidth > 0 && this.mMaxHeight > 0) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i3 = this.mMaxWidth;
            if (intrinsicWidth == i3 && intrinsicHeight == this.mMaxHeight && intrinsicWidth * CropByPivotProcessor.GOLDEN_CUDGEL_RATIO > intrinsicHeight) {
                return drawable;
            }
            float f16 = intrinsicWidth;
            float f17 = intrinsicHeight;
            float min = Math.min(i3 / f16, this.mMaxHeight / f17);
            float f18 = this.mMaxScale;
            if (f18 != -1.0f && min > f18) {
                min = Math.min(min, f18);
            }
            int i16 = (int) (f16 * min);
            int min2 = (int) Math.min(f17 * min, i16 * CropByPivotProcessor.GOLDEN_CUDGEL_RATIO);
            if (drawable instanceof ImageDrawable) {
                try {
                    BitmapReference bitmapRef = ((ImageDrawable) drawable).getBitmapRef();
                    Bitmap.Config config = bitmapRef.getConfig();
                    ImageManager imageManager = ImageManager.getInstance();
                    if (config == null) {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    BitmapReference bitmap = imageManager.getBitmap(i16, min2, config);
                    Canvas canvas = new Canvas(bitmap.getBitmap());
                    Matrix matrix = new Matrix();
                    ScaleDrawable.getMatrix(matrix, 10, bitmapRef.getWidth(), bitmapRef.getHeight(), i16, min2, this.mPivotXRate, this.mPivotYRate);
                    canvas.drawBitmap(bitmapRef.getBitmap(), matrix, new Paint());
                    if (!bitmapRef.isRecycled()) {
                        bitmapRef.release();
                    }
                    return new SpecifiedBitmapDrawable(bitmap);
                } catch (OutOfMemoryError e16) {
                    e16.printStackTrace();
                    return null;
                }
            }
            ScaleDrawable scaleDrawable = new ScaleDrawable(drawable, 10);
            scaleDrawable.setPivot(this.mPivotXRate, this.mPivotYRate);
            return new SpecifiedDrawable(scaleDrawable, i16, min2);
        }
        return drawable;
    }

    public void setMaxScale(float f16) {
        this.mMaxScale = f16;
    }

    public FeedThumbnailProcessor(int i3, int i16, float f16, float f17) {
        this(i3, i16);
        setPivotRate(f16, f17);
    }
}
