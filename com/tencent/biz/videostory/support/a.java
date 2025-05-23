package com.tencent.biz.videostory.support;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.aelight.camera.util.api.IVSConfigManager;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.pic.f;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    private static float a(int i3, int i16) {
        if (i3 <= i16) {
            return 1.0f;
        }
        return (i16 * 1.0f) / i3;
    }

    public static Bitmap b(Bitmap bitmap) {
        float a16;
        if (bitmap != null && !bitmap.isRecycled()) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0 && height > 0) {
                int intValue = ((Long) VSConfigManager.c().e(IVSConfigManager.SMART_CUT_PIC_WIDTH, 224L)).intValue();
                if (width <= height) {
                    a16 = a(width, intValue);
                } else {
                    a16 = a(height, intValue);
                }
                int i3 = (int) a16;
                f.c("Q.videostory", "Q.videostory.capture", "resizeImage", (i3 * width) + " " + (i3 * height));
                Matrix matrix = new Matrix();
                matrix.postScale(a16, a16);
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            }
            return bitmap;
        }
        return bitmap;
    }
}
