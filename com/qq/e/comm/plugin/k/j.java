package com.qq.e.comm.plugin.k;

/* compiled from: P */
/* loaded from: classes3.dex */
public class j {
    public static boolean a(double d16) {
        return d16 == 0.0d;
    }

    public static boolean a(Object obj) {
        return obj == null;
    }

    public static boolean a(String str) {
        return a((Object) str) || str.trim().length() == 0;
    }
}
