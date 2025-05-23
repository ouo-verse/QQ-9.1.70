package com.tencent.component.media.image.processor;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.utils.ImageManagerLog;

@Public
/* loaded from: classes5.dex */
public class RoundCornerProcessor extends ImageProcessor {
    private static final String TAG = "RoundCornerProcessor";
    private float mRadius = -1.0f;
    private float[] mRadiusArray;

    @Public
    public RoundCornerProcessor(float f16) {
        setRadius(f16);
    }

    public static BitmapReference getRoundedCornerBitmap(BitmapReference bitmapReference, float[] fArr) {
        BitmapReference bitmap;
        try {
            bitmap = ImageManager.getInstance().getBitmap(bitmapReference.getWidth(), bitmapReference.getHeight(), Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e16) {
            ImageManagerLog.e(TAG, "OOM," + e16.toString());
            bitmap = ImageManager.getInstance().getBitmap(bitmapReference.getWidth(), bitmapReference.getHeight(), Bitmap.Config.ARGB_4444);
        }
        Canvas canvas = new Canvas(bitmap.getBitmap());
        RectF rectF = new RectF(0.0f, 0.0f, bitmapReference.getWidth(), bitmapReference.getHeight());
        Path path = new Path();
        Paint paint = new Paint();
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        paint.setAntiAlias(true);
        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmapReference.getBitmap(), (Rect) null, rectF, paint);
        return bitmap;
    }

    @Public
    public float getRadius() {
        float f16 = this.mRadius;
        if (f16 <= 0.0f) {
            return 0.0f;
        }
        return f16;
    }

    @Public
    public float[] getRadiusArray() {
        return this.mRadiusArray;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public int getType() {
        return 2;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        ImageProcessor imageProcessor = this.mPreProcessor;
        if (imageProcessor != null) {
            drawable = imageProcessor.process(drawable);
        }
        if (this.mRadiusArray == null) {
            return drawable;
        }
        BitmapReference drawableToBitmap = ImageManagerEnv.g().drawableToBitmap(drawable);
        if (drawableToBitmap == null) {
            return drawable;
        }
        BitmapReference roundedCornerBitmap = getRoundedCornerBitmap(drawableToBitmap, this.mRadiusArray);
        if (roundedCornerBitmap == null) {
            return null;
        }
        return new SpecifiedBitmapDrawable(roundedCornerBitmap);
    }

    @Public
    public void setRadius(float f16) {
        this.mRadius = f16;
        this.mRadiusArray = new float[8];
        int i3 = 0;
        while (true) {
            float[] fArr = this.mRadiusArray;
            if (i3 < fArr.length) {
                fArr[i3] = f16;
                i3++;
            } else {
                return;
            }
        }
    }

    @Public
    public void setRadiusArray(float[] fArr) {
        this.mRadiusArray = fArr;
    }

    @Public
    public RoundCornerProcessor(float[] fArr) {
        setRadiusArray(fArr);
    }
}
