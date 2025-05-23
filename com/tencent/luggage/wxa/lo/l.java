package com.tencent.luggage.wxa.lo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class l {
    public static Bitmap a(Bitmap bitmap, boolean z16, float f16, boolean z17) {
        if (bitmap != null && !bitmap.isRecycled()) {
            Bitmap a16 = a(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888, z17);
            if (a16 == null) {
                return null;
            }
            Canvas canvas = new Canvas(a16);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectF = new RectF(rect);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-4144960);
            canvas.drawRoundRect(rectF, f16, f16, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            if (z16) {
                n.c("WeUIBitmapUtil", "getRoundedCornerBitmap bitmap recycle %s", bitmap);
                bitmap.recycle();
            }
            return a16;
        }
        n.b("WeUIBitmapUtil", "getRoundedCornerBitmap in bitmap is null", new Object[0]);
        return null;
    }

    public static Bitmap a(int i3, int i16, Bitmap.Config config, boolean z16) {
        try {
            return Bitmap.createBitmap(i3, i16, config);
        } catch (Throwable unused) {
            if (z16) {
            }
            return null;
        }
    }
}
