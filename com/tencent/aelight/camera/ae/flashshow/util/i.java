package com.tencent.aelight.camera.ae.flashshow.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.aelight.camera.util.api.IVSConfigManager;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i {
    private static float a(int i3, int i16) {
        if (i3 <= i16) {
            return 1.0f;
        }
        return (i16 * 1.0f) / i3;
    }

    public static Bitmap b(Bitmap bitmap) {
        float a16;
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return bitmap;
        }
        int intValue = ((Long) ((IVSConfigManager) QRoute.api(IVSConfigManager.class)).getValue(IVSConfigManager.SMART_CUT_PIC_WIDTH, 224L)).intValue();
        if (width <= height) {
            a16 = a(width, intValue);
        } else {
            a16 = a(height, intValue);
        }
        Matrix matrix = new Matrix();
        matrix.postScale(a16, a16);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
