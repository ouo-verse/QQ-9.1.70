package com.tencent.component.network.utils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StringUtil {
    StringUtil() {
    }

    public static boolean startsWithIgnoreCase(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str != null && str2 != null) {
            return str.regionMatches(true, 0, str2, 0, str2.length());
        }
        return false;
    }
}
