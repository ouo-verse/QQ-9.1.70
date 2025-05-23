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
public class SingleFeedImageProcessor extends CropByPivotProcessor {
    private static final float DEFAULT_FEED_SCALE = 1.1f;
    private static final float MAX_WIDTH_SCALE = 2.0f;
    private static final Paint mPaint = new Paint(6);
    private final int mMaxHeight;
    private float mMaxScale;
    private final int mMaxWidth;

    public SingleFeedImageProcessor(int i3, int i16) {
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
            if (intrinsicWidth >= intrinsicHeight) {
                int i3 = this.mMaxWidth;
                if (intrinsicWidth > i3) {
                    intrinsicHeight = (int) (intrinsicHeight * (i3 / intrinsicWidth));
                    intrinsicWidth = i3;
                }
            } else {
                int i16 = this.mMaxHeight;
                if (intrinsicHeight > i16) {
                    intrinsicWidth = (int) (intrinsicWidth * (i16 / intrinsicHeight));
                    intrinsicHeight = i16;
                }
            }
            boolean z16 = drawable instanceof ImageDrawable;
            if (z16) {
                ImageDrawable imageDrawable = (ImageDrawable) drawable;
                int bitmapWidth = imageDrawable.getBitmapWidth();
                int bitmapHeight = imageDrawable.getBitmapHeight();
                if (bitmapWidth > 0 && bitmapHeight > 0) {
                    float f16 = bitmapWidth;
                    if (intrinsicWidth / f16 > this.mMaxScale) {
                        int i17 = this.mMaxHeight;
                        float f17 = 1.1f;
                        if (intrinsicHeight >= i17) {
                            float f18 = i17 / bitmapHeight;
                            if (1.1f < f18) {
                                f17 = f18;
                            }
                        }
                        intrinsicWidth = (int) (f16 * f17);
                        intrinsicHeight = (int) (bitmapHeight * f17);
                    }
                }
            }
            int i18 = intrinsicWidth;
            int i19 = intrinsicHeight;
            if (z16) {
                try {
                    BitmapReference bitmapRef = ((ImageDrawable) drawable).getBitmapRef();
                    Bitmap.Config config = bitmapRef.getConfig();
                    ImageManager imageManager = ImageManager.getInstance();
                    if (config == null) {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    BitmapReference bitmap = imageManager.getBitmap(i18, i19, config);
                    Canvas canvas = new Canvas(bitmap.getBitmap());
                    Matrix matrix = new Matrix();
                    ScaleDrawable.getMatrix(matrix, 10, bitmapRef.getWidth(), bitmapRef.getHeight(), i18, i19, this.mPivotXRate, this.mPivotYRate);
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
            ScaleDrawable scaleDrawable = new ScaleDrawable(drawable, 10);
            scaleDrawable.setPivot(this.mPivotXRate, this.mPivotYRate);
            return new SpecifiedDrawable(scaleDrawable, i18, i19);
        }
        return drawable;
    }

    public SingleFeedImageProcessor(int i3, int i16, float f16, float f17, float f18) {
        this(i3, i16);
        setPivotRate(f16, f17);
        if (f18 <= 0.0f) {
            this.mMaxScale = 2.0f;
        } else {
            this.mMaxScale = f18;
        }
    }
}
