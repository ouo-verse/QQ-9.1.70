package com.tencent.biz.pubaccount.weishi.util;

import cooperation.qzone.LocalMultiProcConfig;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ai {
    public static boolean a(String str, boolean z16) {
        return LocalMultiProcConfig.getBool("weishi_usergrowth", str, z16);
    }

    public static boolean b(String str, boolean z16) {
        return LocalMultiProcConfig.getBool(h(), e(str), z16);
    }

    public static int c(String str, int i3) {
        return LocalMultiProcConfig.getInt("weishi_usergrowth", str, i3);
    }

    public static int d(String str, int i3) {
        return LocalMultiProcConfig.getInt(h(), e(str), i3);
    }

    public static long f(String str, long j3) {
        return LocalMultiProcConfig.getLong("weishi_usergrowth", str, j3);
    }

    public static long g(String str, long j3) {
        return LocalMultiProcConfig.getLong(h(), e(str), j3);
    }

    private static String h() {
        if (bb.o() == 0) {
            return "weishi_usergrowth";
        }
        return "weishi_usergrowth" + bb.y();
    }

    public static String i(String str, String str2) {
        return LocalMultiProcConfig.getString("weishi_usergrowth", str, str2);
    }

    public static void j(String str, boolean z16) {
        LocalMultiProcConfig.putBool("weishi_usergrowth", str, z16);
    }

    public static void k(String str, boolean z16) {
        LocalMultiProcConfig.putBool(h(), e(str), z16);
    }

    public static void l(String str, int i3) {
        LocalMultiProcConfig.putInt("weishi_usergrowth", str, i3);
    }

    public static void m(String str, int i3) {
        LocalMultiProcConfig.putInt(h(), e(str), i3);
    }

    public static void n(String str, long j3) {
        LocalMultiProcConfig.putLong("weishi_usergrowth", str, j3);
    }

    public static void o(String str, long j3) {
        LocalMultiProcConfig.putLong(h(), e(str), j3);
    }

    public static void p(String str, String str2) {
        LocalMultiProcConfig.putString("weishi_usergrowth", str, str2);
    }

    private static String e(String str) {
        return str;
    }
}
