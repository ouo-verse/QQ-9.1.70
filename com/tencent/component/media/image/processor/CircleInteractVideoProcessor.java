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
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;

/* loaded from: classes5.dex */
public class CircleInteractVideoProcessor extends ImageProcessor {
    public int mColor;
    public int mRingWidth;

    public CircleInteractVideoProcessor() {
        this.mColor = -1;
        this.mRingWidth = 0;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public int getType() {
        return 8;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        BitmapReference bitmapReference;
        BitmapReference drawableToBitmap = ImageManagerEnv.g().drawableToBitmap(drawable);
        if (drawableToBitmap == null) {
            return drawable;
        }
        int max = Math.max(drawableToBitmap.getWidth(), drawableToBitmap.getHeight());
        try {
            bitmapReference = ImageManager.getInstance().getBitmap(max, max, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            bitmapReference = BitmapReference.getBitmapReference(Bitmap.createBitmap(max, max, Bitmap.Config.ARGB_4444));
        }
        bitmapReference.getBitmap().setHasAlpha(true);
        Canvas canvas = new Canvas(bitmapReference.getBitmap());
        float f16 = max;
        RectF rectF = new RectF(0.0f, 0.0f, f16, f16);
        Path path = new Path();
        Paint paint = new Paint();
        path.addCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, Math.min(canvas.getWidth(), canvas.getHeight()) / 2, Path.Direction.CW);
        paint.setAntiAlias(true);
        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(drawableToBitmap.getBitmap(), (Rect) null, rectF, paint);
        drawableToBitmap.release();
        if (this.mRingWidth > 0.0f) {
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            paint2.setColor(this.mColor);
            paint2.setStrokeWidth(this.mRingWidth);
            paint2.setStyle(Paint.Style.STROKE);
            int i3 = this.mRingWidth;
            canvas.drawOval(new RectF(i3, i3, max - i3, max - i3), paint2);
        }
        return new BitmapRefDrawable(bitmapReference);
    }

    public CircleInteractVideoProcessor(int i3, int i16) {
        this.mColor = i16;
        this.mRingWidth = i3;
    }
}
