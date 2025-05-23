package com.tencent.mobileqq.qqfloatingwindow;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f264316a;

    /* renamed from: b, reason: collision with root package name */
    private static long f264317b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35656);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f264316a = 0;
            f264317b = 0L;
        }
    }

    public static int a(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 != 1) {
            if (i3 != 1000 && i3 != 1004 && i3 != 1020) {
                if (i3 == 3000) {
                    return 4;
                }
                return i3;
            }
            return 3;
        }
        return 2;
    }

    public static void b() {
        ReportController.o(null, "dc00898", "", "", "0X800A495", "0X800A495", 0, 0, "", "", "", "");
    }

    public static void c() {
        ReportController.o(null, "dc00898", "", "", "0X800A494", "0X800A494", 0, 0, "", "", "", "");
    }

    public static void d() {
        ReportController.o(null, "dc00898", "", "", "0X800A20C", "0X800A20C", 0, 0, "", "", "", "");
        k(1);
    }

    public static void e(int i3) {
        f264316a = i3;
        ReportController.o(null, "dc00898", "", "", "0X800A20B", "0X800A20B", i3, 0, String.valueOf(i3), "", "", "");
    }

    public static void f() {
        ReportController.o(null, "dc00898", "", "", "0X800A210", "0X800A210", 0, 0, "", "", "", "");
    }

    public static void g() {
        ReportController.o(null, "dc00898", "", "", "0X800A20F", "0X800A20F", 0, 0, "", "", "", "");
        n(1);
    }

    public static void h() {
        ReportController.o(null, "dc00898", "", "", "0X800A20E", "0X800A20E", 0, 0, "", "", "", "");
        n(2);
        q();
    }

    public static void i() {
        ReportController.o(null, "dc00898", "", "", "0X800A20D", "0X800A20D", 0, 0, "", "", "", "");
        k(2);
        q();
    }

    public static void j() {
        ReportController.o(null, "dc00898", "", "", "0X800A87F", "0X800A87F", f264316a, 0, "", "", "", "");
    }

    public static void k(int i3) {
        if (f264317b == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - f264317b;
        f264317b = 0L;
        ReportController.o(null, "dc00898", "", "", "0X800A87D", "0X800A87D", i3, 0, String.valueOf(currentTimeMillis / 1000), "", "", "");
    }

    public static void l() {
        ReportController.o(null, "dc00898", "", "", "0X800A881", "0X800A881", f264316a, 0, "", "", "", "");
        n(1);
    }

    public static void m() {
        ReportController.o(null, "dc00898", "", "", "0X800A880", "0X800A880", f264316a, 0, "", "", "", "");
    }

    public static void n(int i3) {
        if (f264317b == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - f264317b;
        f264317b = 0L;
        ReportController.o(null, "dc00898", "", "", "0X800A87E", "0X800A87E", i3, 0, String.valueOf(currentTimeMillis / 1000), "", "", "");
    }

    public static void o(int i3) {
        ReportController.o(null, "dc00898", "", "", "0X800A496", "0X800A496", i3, 0, String.valueOf(i3), "", "", "");
    }

    public static void p(int i3) {
        ReportController.o(null, "dc00898", "", "", "0X800A87C", "0X800A87C", f264316a, 0, String.valueOf(i3 / 1000), "", "", "");
    }

    public static void q() {
        f264317b = System.currentTimeMillis();
    }
}
