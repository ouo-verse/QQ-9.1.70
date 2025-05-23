package com.tencent.biz.richframework.animation.drawable;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* compiled from: P */
/* loaded from: classes5.dex */
class BitmapUtil {
    public static int calculateInSampleSize(BitmapFactory.Options options, int i3, int i16) {
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        if (i17 <= i16 && i18 <= i3) {
            return 1;
        }
        int i19 = 2;
        while (true) {
            if (i17 / i19 <= i16 && i18 / i19 <= i3) {
                return i19;
            }
            i19 *= 2;
        }
    }

    @TargetApi(19)
    public static boolean canUseForInBitmap(Bitmap bitmap, BitmapFactory.Options options) {
        int i3 = options.outWidth;
        int i16 = options.inSampleSize;
        if ((i3 / i16) * (options.outHeight / i16) * getBytesPerPixel(bitmap.getConfig()) <= bitmap.getAllocationByteCount()) {
            return true;
        }
        return false;
    }

    public static int getBytesPerPixel(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            return 4;
        }
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
            return 2;
        }
        Bitmap.Config config2 = Bitmap.Config.ALPHA_8;
        return 1;
    }
}
