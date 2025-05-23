package com.tencent.mobileqq.onlinestatus.utils;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class z {
    public static void A(boolean z16, long j3) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800C419", "0X800C419", 0, 0, str, String.valueOf(j3), "", "");
    }

    public static void B(int i3) {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C040", "0X800C040", i3, 0, "", "", "", "");
    }

    public static void C(int i3) {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C041", "0X800C041", i3, 0, "", "", "", "");
    }

    private static String a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getCurrentUin();
        }
        return "";
    }

    public static void b(boolean z16, int i3) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800C417", "0X800C417", 0, 0, str, String.valueOf(i3), "", "");
    }

    public static void c(String str) {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }

    public static void d() {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C249", "0X800C249", 0, 0, "", "", "", "");
    }

    public static void e(int i3) {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800BFA1", "0X800BFA1", i3, 0, "", "", "", "");
    }

    public static void f(int i3) {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800BFA2", "0X800BFA2", i3, 0, "", "", "", "");
    }

    public static void g(int i3, int i16, String str) {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C024", "0X800C024", 0, 0, Integer.toString(i3), Integer.toString(i16), str, "");
    }

    public static void h(int i3) {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800BFA3", "0X800BFA3", i3, 0, "", "", "", "");
    }

    public static void i(boolean z16, int i3, int i16) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800C421", "0X800C421", 0, 0, str, String.valueOf(i3), String.valueOf(i16), "");
    }

    public static void j(boolean z16, int i3, int i16, int i17) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800C423", "0X800C423", 0, 0, str, String.valueOf(i3), String.valueOf(i16), String.valueOf(i17));
    }

    public static void k(boolean z16, int i3, int i16) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800C422", "0X800C422", 0, 0, str, String.valueOf(i3), String.valueOf(i16), "");
    }

    public static void l(int i3) {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800BFA7", "0X800BFA7", 1, i3, "", "", "", "");
    }

    public static void m() {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800BFA6", "0X800BFA6", 1, 0, "", "", "", "");
    }

    public static void n() {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800BFA8", "0X800BFA8", 1, 0, "", "", "", "");
    }

    public static void o() {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800BFA9", "0X800BFA9", 1, 0, "", "", "", "");
    }

    public static void p() {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C1E4", "0X800C1E4", 0, 0, "", "", "", "");
    }

    public static void q() {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800BFAA", "0X800BFAA", 0, 0, "", "", "", "");
    }

    public static void r() {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800BFA4", "0X800BFA4", 1, 0, "", "", "", "");
    }

    public static void s(int i3) {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800BFA5", "0X800BFA5", 1, i3, "", "", "", "");
    }

    public static void t(String str, boolean z16, boolean z17, int i3, long j3, long j16) {
        String str2;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_user_uin ", a());
        String str3 = "0";
        if (z17) {
            str2 = "0";
        } else {
            str2 = "-1";
        }
        hashMap.put("param_error_code", str2);
        hashMap.put("param_scene_type", str);
        if (z16) {
            str3 = "1";
        }
        hashMap.put("param_is_first_time", str3);
        hashMap.put(ReportConstant.KEY_TIME_COST, String.valueOf(j3));
        hashMap.put("param_load_error_code", String.valueOf(i3));
        hashMap.put("param_total_time_cost", String.valueOf(j16));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "online_status_avatar_render_time_cost", z17, 0L, 0L, hashMap, "", false);
    }

    public static void u(boolean z16, long j3) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_user_uin ", a());
        if (z16) {
            str = "0";
        } else {
            str = "-1";
        }
        hashMap.put("param_error_code", str);
        hashMap.put(ReportConstant.KEY_TIME_COST, String.valueOf(j3));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "online_status_avatar_res_download_time_cost", z16, 0L, 0L, hashMap, "", false);
    }

    public static void v(boolean z16, long j3, int i3) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800C418", "0X800C418", 0, 0, str, String.valueOf(j3), String.valueOf(i3), "");
    }

    public static void w(int i3) {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800BDEC", "0X800BDEC", i3, 0, "", "", "", "");
    }

    public static void x() {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C41E", "0X800C41E", 0, 0, "", "", "", "");
    }

    public static void y(int i3) {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C41A", "0X800C41A", 0, 0, String.valueOf(i3), "", "", "");
    }

    public static void z(boolean z16) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (z16) {
            str = "0";
        } else {
            str = "1";
        }
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800C41B", "0X800C41B", 0, 0, str, "", "", "");
    }
}
