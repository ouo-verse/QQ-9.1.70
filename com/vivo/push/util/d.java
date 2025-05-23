package com.vivo.push.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class d {
    public static Bitmap a(Bitmap bitmap, int i3, int i16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f16 = i3 / width;
        float f17 = i16 / height;
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(f16, f17);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (Exception unused) {
            return bitmap;
        }
    }
}
