package com.tencent.qqmini.v8rt.engine;

import android.os.Build;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Util {
    public static final String DEVICE;
    public static final String MANUFACTURER;
    public static final int SDK_INT;

    static {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') {
            i3 = 26;
        }
        SDK_INT = i3;
        DEVICE = Build.DEVICE;
        MANUFACTURER = Build.MANUFACTURER;
    }
}
