package com.tencent.mobileqq.kandian.base.image.imageloader;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    @TargetApi(19)
    public static boolean a(Bitmap bitmap, BitmapFactory.Options options) {
        if (bitmap == null || bitmap.isRecycled() || !bitmap.isMutable()) {
            return false;
        }
        if (c() && !g(options)) {
            if (((int) Math.ceil((options.outWidth * 1.0d) / options.inSampleSize)) * ((int) Math.ceil((options.outHeight * 1.0d) / options.inSampleSize)) * b(bitmap.getConfig()) > bitmap.getAllocationByteCount()) {
                return false;
            }
            return true;
        }
        if (bitmap.getWidth() != options.outWidth || bitmap.getHeight() != options.outHeight || options.inSampleSize != 1) {
            return false;
        }
        return true;
    }

    public static int b(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            return 4;
        }
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
            return 2;
        }
        Bitmap.Config config2 = Bitmap.Config.ALPHA_8;
        return 1;
    }

    public static boolean c() {
        return true;
    }

    public static boolean d() {
        return true;
    }

    public static void e(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2);
        }
    }

    public static void f(String str, String str2, boolean z16) {
        if (z16) {
            e(str, str2 + " " + new RuntimeException("getStack").getStackTrace()[2].getMethodName());
            return;
        }
        e(str, str2);
    }

    public static boolean g(BitmapFactory.Options options) {
        if (options.outWidth <= 2048 && options.outHeight <= 2048) {
            return false;
        }
        return true;
    }
}
