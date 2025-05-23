package com.tencent.mobileqq.search.util;

/* compiled from: P */
/* loaded from: classes18.dex */
public class as {
    private static boolean a(String str) {
        if (str == null || str.length() <= 6 || !str.substring(0, 7).equalsIgnoreCase("http://")) {
            return false;
        }
        return true;
    }

    private static boolean b(String str) {
        if (str == null || str.length() <= 7 || !str.substring(0, 8).equalsIgnoreCase("https://")) {
            return false;
        }
        return true;
    }

    public static boolean c(String str) {
        if (!a(str) && !b(str)) {
            return false;
        }
        return true;
    }
}
