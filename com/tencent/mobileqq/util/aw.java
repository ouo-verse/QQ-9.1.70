package com.tencent.mobileqq.util;

/* compiled from: P */
/* loaded from: classes20.dex */
public class aw {
    public static String a(String str) {
        if (str != null && str.length() != 0) {
            return str.charAt(0) + "|" + str.length();
        }
        return "0|0";
    }
}
