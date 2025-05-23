package com.tencent.component.media.image.processor;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;

/* loaded from: classes5.dex */
public class MarkProcessor extends ImageProcessor {
    private Bitmap mMarker;
    private float mPercent;
    private int mType;

    /* loaded from: classes5.dex */
    public static class MARKTYPE {
        public static final int BOTTOMLEFT = 2;
        public static final int BOTTOMRIGT = 3;
        public static final int TOPLEFT = 0;
        public static final int TOPRIGHT = 1;
    }

    public MarkProcessor(Bitmap bitmap, int i3, float f16) {
        this.mMarker = bitmap;
        this.mType = i3;
        this.mPercent = f16;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public int getType() {
        return 7;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    @TargetApi(12)
    public Drawable process(Drawable drawable) {
        BitmapReference bitmap;
        RectF rectF;
        RectF rectF2;
        BitmapReference drawableToBitmap = ImageManagerEnv.g().drawableToBitmap(drawable);
        if (drawableToBitmap == null) {
            return drawable;
        }
        try {
            bitmap = ImageManager.getInstance().getBitmap(drawableToBitmap.getWidth(), drawableToBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            bitmap = ImageManager.getInstance().getBitmap(drawableToBitmap.getWidth(), drawableToBitmap.getHeight(), Bitmap.Config.ARGB_4444);
        }
        Canvas canvas = new Canvas(bitmap.getBitmap());
        RectF rectF3 = new RectF(0.0f, 0.0f, drawableToBitmap.getWidth(), drawableToBitmap.getHeight());
        float width = drawableToBitmap.getWidth() * this.mPercent;
        float height = drawableToBitmap.getHeight() * this.mPercent;
        int i3 = this.mType;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        rectF2 = null;
                    } else {
                        rectF2 = new RectF(drawableToBitmap.getWidth() - width, drawableToBitmap.getHeight() - height, drawableToBitmap.getWidth(), drawableToBitmap.getHeight());
                    }
                    Paint paint = new Paint();
                    paint.setAntiAlias(true);
                    canvas.drawBitmap(drawableToBitmap.getBitmap(), (Rect) null, rectF3, paint);
                    canvas.drawBitmap(this.mMarker, (Rect) null, rectF2, paint);
                    return new BitmapRefDrawable(bitmap);
                }
                rectF = new RectF(0.0f, drawableToBitmap.getHeight() - height, width, drawableToBitmap.getHeight());
            } else {
                rectF = new RectF(drawableToBitmap.getWidth() - width, 0.0f, drawableToBitmap.getWidth(), height);
            }
        } else {
            rectF = new RectF(0.0f, 0.0f, width, height);
        }
        rectF2 = rectF;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        canvas.drawBitmap(drawableToBitmap.getBitmap(), (Rect) null, rectF3, paint2);
        canvas.drawBitmap(this.mMarker, (Rect) null, rectF2, paint2);
        return new BitmapRefDrawable(bitmap);
    }
}
