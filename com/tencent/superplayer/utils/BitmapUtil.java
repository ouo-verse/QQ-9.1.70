package com.tencent.superplayer.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes26.dex */
public class BitmapUtil {
    public static Bitmap scaleBitmap(Bitmap bitmap, boolean z16, float f16) throws IOException {
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width != 0 && height != 0) {
                float f17 = width;
                if (f17 == f16 && height == f16) {
                    return bitmap;
                }
                Matrix matrix = new Matrix();
                matrix.postScale(f16 / f17, f16 / height);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
                if (z16) {
                    bitmap.recycle();
                }
                return createBitmap;
            }
            throw new IOException("invalid image");
        }
        throw new IOException("invalid image");
    }
}
