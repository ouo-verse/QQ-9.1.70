package com.tencent.gdt.tangram.ad.qzone;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.util.j;

/* compiled from: P */
/* loaded from: classes31.dex */
public class d {
    private static String a(String str) {
        return e() + g() + ":" + str;
    }

    public static void b(String str, String str2) {
        if (j()) {
            j.a(d(str), f(-1), a(str2));
        }
    }

    public static void c(String str, String str2) {
        if (j()) {
            j.c(d(str), a(str2));
        }
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "GdtAd_";
        }
        return "GdtAd_" + str;
    }

    public static String e() {
        StringBuilder sb5 = new StringBuilder();
        try {
            sb5.append("[ClassName==");
            sb5.append(Thread.currentThread().getStackTrace()[5].getClassName());
            sb5.append("][LineNumber==");
            sb5.append(Thread.currentThread().getStackTrace()[5].getLineNumber());
            sb5.append("]");
        } catch (Exception unused) {
        }
        return sb5.toString();
    }

    public static String g() {
        StringBuilder sb5 = new StringBuilder();
        try {
            sb5.append("[MethodName==");
            sb5.append(Thread.currentThread().getStackTrace()[5].getMethodName());
            sb5.append("]");
        } catch (Exception unused) {
        }
        return sb5.toString();
    }

    public static void h(String str, int i3, String str2) {
        if (j()) {
            j.e(d(str), f(i3), a(str2));
        }
    }

    public static void i(String str, String str2) {
        if (j()) {
            j.e(d(str), f(-1), a(str2));
        }
    }

    private static boolean j() {
        return j.h() || j.g();
    }

    private static int f(int i3) {
        return i3 > 0 ? i3 : j.h() ? 1 : 2;
    }
}
