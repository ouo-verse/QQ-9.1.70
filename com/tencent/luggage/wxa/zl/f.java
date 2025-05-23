package com.tencent.luggage.wxa.zl;

import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class f {
    public static boolean a(int i3) {
        return i3 >= 0 && i3 <= 23;
    }

    public static boolean b(int i3) {
        if (i3 >= 0 && i3 <= 59) {
            return true;
        }
        return false;
    }

    public static int[] a(String str) {
        String[] split;
        if (w0.c(str) || (split = str.split(":")) == null || split.length != 2) {
            return null;
        }
        int a16 = a(split[0], -1);
        int a17 = a(split[1], -1);
        if (a(a16) && b(a17)) {
            return new int[]{a16, a17};
        }
        return null;
    }

    public static int a(String str, int i3) {
        try {
            return Integer.parseInt(str, 10);
        } catch (Exception unused) {
            return i3;
        }
    }
}
