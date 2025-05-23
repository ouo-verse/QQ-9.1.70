package com.tencent.mobileqq.qqexpand.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a {
    public static Bitmap a(Resources resources, Bitmap bitmap, int i3, float f16, boolean z16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        try {
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            if (!z16) {
                RectF rectF = new RectF(0.0f, 0.0f, width, height);
                Paint paint = new Paint(1);
                paint.setColor(i3);
                paint.setAlpha((int) (f16 * 255.0f));
                float f17 = BaseAIOUtils.f(2.0f, resources);
                canvas.drawRoundRect(rectF, f17, f17, paint);
            } else {
                Paint paint2 = new Paint(1);
                paint2.setAlpha((int) (f16 * 255.0f));
                paint2.setColor(i3);
                paint2.setStyle(Paint.Style.FILL);
                float f18 = width / 2;
                canvas.drawCircle(f18, f18, f18, paint2);
            }
            canvas.save();
            canvas.restore();
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            QLog.e("BackgroundUtil", 1, "get OOM when create ret, return target");
            return bitmap;
        }
    }

    public static Bitmap b(int i3, int i16, float f16) {
        int i17 = i3 * 2;
        Bitmap createBitmap = Bitmap.createBitmap(i17, i17, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setAlpha((int) (f16 * 255.0f));
        paint.setColor(i16);
        paint.setStyle(Paint.Style.FILL);
        float f17 = i3;
        canvas.drawCircle(f17, f17, f17, paint);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }
}
