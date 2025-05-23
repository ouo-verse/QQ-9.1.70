package com.tencent.luggage.wxa.aa;

import android.os.Build;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static boolean a(int i3) {
        if (Build.VERSION.SDK_INT < i3) {
            return true;
        }
        return false;
    }

    public static boolean b(int i3) {
        if (Build.VERSION.SDK_INT > i3) {
            return true;
        }
        return false;
    }

    public static boolean c(int i3) {
        if (Build.VERSION.SDK_INT >= i3) {
            return true;
        }
        return false;
    }
}
