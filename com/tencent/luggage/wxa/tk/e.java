package com.tencent.luggage.wxa.tk;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {
    public static Bitmap a(Bitmap bitmap, RectF rectF, RectF rectF2, Region.Op op5) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.clipRect(rectF);
        canvas.clipRect(rectF2, op5);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return createBitmap;
    }
}
