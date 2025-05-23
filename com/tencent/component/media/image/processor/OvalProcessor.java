package com.tencent.component.media.image.processor;

import android.annotation.TargetApi;
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
public class OvalProcessor extends ImageProcessor {
    @Override // com.tencent.component.media.image.ImageProcessor
    public int getType() {
        return 3;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    @TargetApi(12)
    public Drawable process(Drawable drawable) {
        BitmapReference bitmapReference;
        BitmapReference drawableToBitmap = ImageManagerEnv.g().drawableToBitmap(drawable);
        if (drawableToBitmap == null) {
            return drawable;
        }
        try {
            bitmapReference = ImageManager.getInstance().getBitmap(drawableToBitmap.getWidth(), drawableToBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            bitmapReference = BitmapReference.getBitmapReference(Bitmap.createBitmap(drawableToBitmap.getWidth(), drawableToBitmap.getHeight(), Bitmap.Config.ARGB_4444));
        }
        bitmapReference.getBitmap().setHasAlpha(true);
        Canvas canvas = new Canvas(bitmapReference.getBitmap());
        RectF rectF = new RectF(0.0f, 0.0f, drawableToBitmap.getWidth(), drawableToBitmap.getHeight());
        Path path = new Path();
        Paint paint = new Paint();
        path.addOval(rectF, Path.Direction.CW);
        paint.setAntiAlias(true);
        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(drawableToBitmap.getBitmap(), (Rect) null, rectF, paint);
        drawableToBitmap.release();
        return new BitmapRefDrawable(bitmapReference);
    }
}
