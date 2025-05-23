package com.tencent.mapsdk.internal;

import android.animation.ObjectAnimator;
import android.view.View;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class kl {
    private static void a(View view, float f16) {
        view.setAlpha(f16);
    }

    private static boolean b(String str, String str2, int i3) {
        if (a(str, str2, i3) > 0) {
            return true;
        }
        return false;
    }

    private static boolean c(String str, String str2, int i3) {
        if (a(str, str2, i3) == 0) {
            return true;
        }
        return false;
    }

    private static void a(View view, float f16, float f17) {
        view.setScaleX(f16);
        view.setScaleY(f17);
    }

    private static void a(Object obj, String str, int i3, float... fArr) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(obj, str, fArr[0], fArr[1]);
        ofFloat.setDuration(i3);
        ofFloat.start();
    }

    public static boolean a(String str, String str2) {
        return a(str, str2, 3) < 0;
    }

    public static int a(String str, String str2, int i3) {
        int i16 = 0;
        if (hs.a(str) || hs.a(str2) || str.equals(str2)) {
            return 0;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i17 = 0;
        while (i16 < i3) {
            try {
                i17 = Integer.valueOf(Integer.parseInt(i16 < split.length ? split[i16] : "0")).compareTo(Integer.valueOf(Integer.parseInt(i16 < split2.length ? split2[i16] : "0")));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (i17 != 0) {
                break;
            }
            i16++;
        }
        return i17;
    }
}
