package com.tencent.component.media.image.processor;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
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
public class BubbleProcessor extends ImageProcessor {
    private Bitmap mMask;

    public BubbleProcessor(Bitmap bitmap) {
        if (bitmap != null) {
            this.mMask = bitmap;
            return;
        }
        throw new IllegalArgumentException("mask bitmap can not be null for BubbleProcessor");
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public int getType() {
        return 6;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        BitmapReference bitmapReference;
        BitmapReference drawableToBitmap = ImageManagerEnv.g().drawableToBitmap(drawable);
        if (drawableToBitmap != null) {
            if (this.mMask != null) {
                try {
                    BitmapReference bitmapReference2 = BitmapReference.getBitmapReference(Bitmap.createScaledBitmap(drawableToBitmap.getBitmap(), this.mMask.getWidth(), this.mMask.getHeight(), true));
                    try {
                        bitmapReference = ImageManager.getInstance().getBitmap(bitmapReference2.getWidth(), bitmapReference2.getHeight(), Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError unused) {
                        bitmapReference = BitmapReference.getBitmapReference(Bitmap.createBitmap(bitmapReference2.getWidth(), bitmapReference2.getHeight(), Bitmap.Config.ARGB_4444));
                    }
                    Canvas canvas = new Canvas(bitmapReference.getBitmap());
                    RectF rectF = new RectF(0.0f, 0.0f, bitmapReference2.getWidth(), bitmapReference2.getHeight());
                    Paint paint = new Paint();
                    paint.setAntiAlias(true);
                    canvas.drawBitmap(this.mMask, (Rect) null, rectF, paint);
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                    canvas.drawBitmap(bitmapReference2.getBitmap(), (Rect) null, rectF, paint);
                } catch (Exception unused2) {
                    return drawable;
                }
            }
            return new BitmapRefDrawable(bitmapReference);
        }
        return drawable;
    }
}
