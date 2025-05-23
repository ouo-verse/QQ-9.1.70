package com.huawei.secure.android.common.util;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SafeStringBuffer {

    /* renamed from: a, reason: collision with root package name */
    private static final String f38018a = "SafeStringBuffer";

    /* renamed from: b, reason: collision with root package name */
    private static final String f38019b = "";

    public static String substring(StringBuffer stringBuffer, int i3) {
        if (stringBuffer != null && stringBuffer.length() >= i3 && i3 >= 0) {
            try {
                return stringBuffer.substring(i3);
            } catch (Exception e16) {
                Log.e(f38018a, "substring exception: " + e16.getMessage());
            }
        }
        return "";
    }

    public static String substring(StringBuffer stringBuffer, int i3, int i16) {
        if (stringBuffer != null && i3 >= 0 && i16 <= stringBuffer.length() && i16 >= i3) {
            try {
                return stringBuffer.substring(i3, i16);
            } catch (Exception e16) {
                Log.e(f38018a, "substring: " + e16.getMessage());
            }
        }
        return "";
    }
}
