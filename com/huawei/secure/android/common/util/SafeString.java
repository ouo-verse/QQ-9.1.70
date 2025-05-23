package com.huawei.secure.android.common.util;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SafeString {

    /* renamed from: a, reason: collision with root package name */
    private static final String f38016a = "SafeString";

    /* renamed from: b, reason: collision with root package name */
    private static final String f38017b = "";

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (str != null && charSequence != null && charSequence2 != null) {
            try {
                return str.replace(charSequence, charSequence2);
            } catch (Exception e16) {
                Log.e(f38016a, "replace: " + e16.getMessage());
            }
        }
        return str;
    }

    public static String substring(String str, int i3) {
        if (str != null && str.length() >= i3 && i3 >= 0) {
            try {
                return str.substring(i3);
            } catch (Exception e16) {
                Log.e(f38016a, "substring exception: " + e16.getMessage());
            }
        }
        return "";
    }

    public static String substring(String str, int i3, int i16) {
        if (str != null && i3 >= 0 && i16 <= str.length() && i16 >= i3) {
            try {
                return str.substring(i3, i16);
            } catch (Exception e16) {
                Log.e(f38016a, "substring: " + e16.getMessage());
            }
        }
        return "";
    }
}
