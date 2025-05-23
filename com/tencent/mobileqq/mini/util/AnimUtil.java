package com.tencent.mobileqq.mini.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AnimUtil {
    public static Bitmap toRoundBitmap(Bitmap bitmap) {
        float f16;
        float f17;
        float f18;
        float f19;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            f19 = width / 2;
            f18 = width;
            f16 = 0.0f;
            f17 = f18;
        } else {
            f16 = (width - height) / 2;
            f17 = height;
            f18 = width - f16;
            width = height;
            f19 = height / 2;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect((int) f16, (int) 0.0f, (int) f18, (int) f17);
        Rect rect2 = new Rect((int) 0.0f, (int) 0.0f, (int) f17, (int) f17);
        RectF rectF = new RectF(rect2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f19, f19, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }

    public static void clearAnim(Activity activity) {
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    public static void setCloseAnim(Activity activity) {
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f154698q7, R.anim.f154699q8);
        }
    }

    public static void setCloseAnim4Guild(Activity activity) {
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f154709qc, R.anim.f154713qg);
        }
    }
}
