package com.tencent.mobileqq.qfix;

/* loaded from: classes16.dex */
public class Properties {
    private static final String UNKNOWN = "unknown";

    public static String getString(String str) {
        return nativeGet(str, "unknown");
    }

    private static native String nativeGet(String str, String str2);
}
