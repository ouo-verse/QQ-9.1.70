package com.github.sisong;

/* loaded from: classes39.dex */
public class HPatch {
    public static native int patch(String str, String str2, String str3, long j3);

    public static int a(String str, String str2, String str3) {
        return patch(str, str2, str3, -1L);
    }
}
