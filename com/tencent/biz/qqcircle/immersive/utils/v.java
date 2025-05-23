package com.tencent.biz.qqcircle.immersive.utils;

import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class v {
    public static ImageView.ScaleType a(int i3, int i16) {
        float f16 = i3 / i16;
        if (c(f16)) {
            return ImageView.ScaleType.FIT_CENTER;
        }
        if (b(f16)) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        return ImageView.ScaleType.FIT_CENTER;
    }

    private static boolean b(float f16) {
        double d16 = f16;
        if (d16 >= 0.375d && d16 <= 0.6666666865348816d) {
            return true;
        }
        return false;
    }

    private static boolean c(float f16) {
        double d16 = f16;
        if (d16 > 0.6666666865348816d && d16 <= 2.200000047683716d) {
            return true;
        }
        return false;
    }
}
