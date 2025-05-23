package com.tencent.luggage.wxa.bo;

import android.os.Build;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static boolean a() {
        String str;
        String str2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 > 33) {
            return true;
        }
        if (i3 >= 30) {
            str = Build.VERSION.RELEASE_OR_CODENAME;
            if (!"UpsideDownCake".equals(str)) {
                str2 = Build.VERSION.RELEASE_OR_CODENAME;
                if ("14".equals(str2)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean b() {
        String str;
        String str2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 > 34) {
            return true;
        }
        if (i3 == 34) {
            str = Build.VERSION.RELEASE_OR_CODENAME;
            if (!"VanillaIceCream".equals(str)) {
                str2 = Build.VERSION.RELEASE_OR_CODENAME;
                if ("15".equals(str2)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }
}
