package com.tencent.mobileqq.gamecenter.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes12.dex */
public class k {
    public static Bitmap a(Bitmap bitmap, int i3, int i16) {
        float f16;
        if (bitmap == null) {
            return null;
        }
        float f17 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        int width = bitmap.getWidth();
        if (width > 0) {
            float f18 = width;
            float f19 = i3;
            if (f18 < f17 * f19) {
                f17 = f18 / f19;
            }
        }
        int i17 = (i3 + i16) / 2;
        if (i17 < 35) {
            f16 = 2.0f;
        } else if (i17 < 50) {
            f16 = 3.0f;
        } else if (i17 < 64) {
            f16 = 5.0f;
        } else {
            f16 = 6.0f;
        }
        return b(bitmap, (int) (f16 * f17), (int) (i3 * f17), (int) (i16 * f17));
    }

    public static Bitmap b(Bitmap bitmap, float f16, int i3, int i16) {
        return c(bitmap, f16, false, i3, i16);
    }

    public static Bitmap c(Bitmap bitmap, float f16, boolean z16, int i3, int i16) {
        int i17;
        int i18;
        int i19;
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > height) {
                i19 = (width - height) / 2;
                i3 = i16;
                i17 = height;
                i18 = 0;
            } else if (height > width) {
                i16 = i3;
                i17 = width;
                i18 = (height - width) / 2;
                height = i17;
                i19 = 0;
            } else {
                i17 = height;
                i18 = 0;
                height = width;
                i19 = 0;
            }
            if (!z16) {
                f16 = i3;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            Rect rect = new Rect(i19, i18, height + i19, i17 + i18);
            Rect rect2 = new Rect(0, 0, i3, i16);
            RectF rectF = new RectF(rect2);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, f16, f16, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect2, paint);
            return createBitmap;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
