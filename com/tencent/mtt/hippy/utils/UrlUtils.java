package com.tencent.mtt.hippy.utils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class UrlUtils {
    public static boolean isFileUrl(String str) {
        if (str == null || str.length() <= 6 || !str.substring(0, 7).equalsIgnoreCase("file://")) {
            return false;
        }
        return true;
    }

    public static boolean isHttpUrl(String str) {
        if (str == null || str.length() <= 6 || !str.substring(0, 7).equalsIgnoreCase("http://")) {
            return false;
        }
        return true;
    }

    public static boolean isHttpsUrl(String str) {
        if (str == null || str.length() <= 7 || !str.substring(0, 8).equalsIgnoreCase("https://")) {
            return false;
        }
        return true;
    }

    public static boolean isWebUrl(String str) {
        if (!isHttpUrl(str) && !isHttpsUrl(str)) {
            return false;
        }
        return true;
    }
}
