package com.tencent.map.geolocation.sapp;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TencentLocationManagerOptions {
    private static String mKey = "";
    private static boolean sLoadLibrary = true;

    public static String getKey() {
        return mKey;
    }

    public static boolean isLoadLibraryEnabled() {
        return sLoadLibrary;
    }

    public static boolean setKey(String str) {
        if (str != null && !str.equals("")) {
            mKey = str;
            return true;
        }
        return false;
    }

    public static void setLoadLibraryEnabled(boolean z16) {
        sLoadLibrary = z16;
    }
}
