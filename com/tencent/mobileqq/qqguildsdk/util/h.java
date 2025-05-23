package com.tencent.mobileqq.qqguildsdk.util;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class h {
    public static int a(String str, boolean z16, String str2, String str3, int i3) {
        String str4;
        String a16 = j.a(str3);
        StringBuilder sb5 = new StringBuilder();
        if (i3 != -1) {
            str4 = "(seq: " + i3 + ") ";
        } else {
            str4 = "";
        }
        sb5.append(str4);
        sb5.append(a16);
        i(str, z16, str2, sb5.toString());
        return i3;
    }

    public static int b(String str, boolean z16, String str2, String str3, String str4, int i3) {
        return a(str, z16, str2, "[" + str3 + "] " + j.a(str4), i3);
    }

    public static int c(String str, boolean z16, String str2, String str3, String str4, int i3, String str5, String str6) {
        return d(str, z16, str2, str3, str4, i3, str5, str6, -1);
    }

    public static int d(String str, boolean z16, String str2, String str3, String str4, int i3, String str5, String str6, int i16) {
        String str7;
        String a16 = j.a(str5);
        String a17 = j.a(str6);
        StringBuilder sb5 = new StringBuilder();
        if (a16 != null) {
            str7 = "[result\uff1a" + i3 + ", errMsg: " + a16 + "]";
        } else {
            str7 = "";
        }
        sb5.append(str7);
        sb5.append(a17);
        return f(str, z16, str2, str3, str4, sb5.toString(), i16);
    }

    public static int e(String str, boolean z16, String str2, String str3, String str4, String str5) {
        return f(str, z16, str2, str3, str4, str5, -1);
    }

    public static int f(String str, boolean z16, String str2, String str3, String str4, String str5, int i3) {
        return b(str, z16, str2, str3, "(desc:" + str4 + ") " + j.a(str5), i3);
    }

    public static void g(String str, int i3, String str2) {
        if (i3 != 1) {
            if (QLog.isColorLevel()) {
                QLog.d("[gpro_sdk]" + str, i3, str2);
                return;
            }
            return;
        }
        QLog.d("[gpro_sdk]" + str, i3, str2);
    }

    public static void h(String str, boolean z16, String str2) {
        int i3;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        g(str, i3, str2);
    }

    public static void i(String str, boolean z16, String str2, String str3) {
        h(str, z16, "[" + str2 + "] " + j.a(str3));
    }

    public static void j(String str, int i3, String str2) {
        if (i3 != 1) {
            if (QLog.isColorLevel()) {
                QLog.e("[gpro_sdk]" + str, i3, str2);
                return;
            }
            return;
        }
        QLog.e("[gpro_sdk]" + str, i3, str2);
    }

    public static void k(String str, int i3, String str2, String str3) {
        j(str, i3, "[" + str2 + "] " + j.a(str3));
    }

    public static int l(String str, boolean z16, String str2, String str3, int i3) {
        String str4;
        String a16 = j.a(str3);
        StringBuilder sb5 = new StringBuilder();
        if (i3 != -1) {
            str4 = "(seq: " + i3 + ") ";
        } else {
            str4 = "";
        }
        sb5.append(str4);
        sb5.append(a16);
        u(str, z16, str2, sb5.toString());
        return i3;
    }

    public static int m(String str, boolean z16, String str2, String str3, String str4, int i3) {
        return l(str, z16, str2, "[" + str3 + "] " + j.a(str4), i3);
    }

    public static int n(String str, boolean z16, String str2, String str3, String str4, int i3, String str5, String str6) {
        return o(str, z16, str2, str3, str4, i3, str5, str6, -1);
    }

    public static int o(String str, boolean z16, String str2, String str3, String str4, int i3, String str5, String str6, int i16) {
        String str7;
        String a16 = j.a(str5);
        String a17 = j.a(str6);
        StringBuilder sb5 = new StringBuilder();
        if (a16 != null) {
            str7 = "[result\uff1a" + i3 + ", errMsg: " + a16 + "]";
        } else {
            str7 = "";
        }
        sb5.append(str7);
        sb5.append(a17);
        return q(str, z16, str2, str3, str4, sb5.toString(), i16);
    }

    public static int p(String str, boolean z16, String str2, String str3, String str4, String str5) {
        return q(str, z16, str2, str3, str4, str5, -1);
    }

    public static int q(String str, boolean z16, String str2, String str3, String str4, String str5, int i3) {
        return m(str, z16, str2, str3, "(desc:" + str4 + ") " + j.a(str5), i3);
    }

    public static void r(String str, int i3, String str2) {
        if (i3 != 1) {
            if (QLog.isColorLevel()) {
                QLog.i("[gpro_sdk]" + str, i3, str2);
                return;
            }
            return;
        }
        QLog.i("[gpro_sdk]" + str, i3, str2);
    }

    public static void s(String str, int i3, String str2, String str3) {
        r(str, i3, "[" + str2 + "] " + j.a(str3));
    }

    public static void t(String str, boolean z16, String str2) {
        int i3;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        r(str, i3, str2);
    }

    public static void u(String str, boolean z16, String str2, String str3) {
        t(str, z16, "[" + str2 + "] " + j.a(str3));
    }

    public static int v(String str, String str2, String str3) {
        return m(str, true, "parameter error", str2, str3, -1);
    }
}
