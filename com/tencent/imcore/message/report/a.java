package com.tencent.imcore.message.report;

import com.tencent.imcore.message.aj;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f116723a;

    /* renamed from: b, reason: collision with root package name */
    public static Set<String> f116724b;

    /* renamed from: c, reason: collision with root package name */
    public static Set<String> f116725c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f116726d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f116727e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37539);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f116723a = "2";
        f116724b = new ConcurrentSkipListSet();
        f116725c = new ConcurrentSkipListSet();
        f116726d = true;
        f116727e = false;
    }

    public static void a(String str) {
        try {
            if (f116727e) {
                f116724b.add(str);
            }
        } catch (Exception e16) {
            QLog.i("MessageReport", 1, "addRegisterProxyFriend", e16);
        }
    }

    public static void b(String str) {
        try {
            if (f116727e) {
                f116725c.add(str);
            }
        } catch (Exception e16) {
            QLog.i("MessageReport", 1, "addRegisterProxyTroop", e16);
        }
    }

    private static int c(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 != 1) {
            return 3;
        }
        return 2;
    }

    public static boolean d() {
        QLog.i("MessageReport", 1, "isNeedReport=" + f116726d);
        return f116726d;
    }

    public static void e(AppRuntime appRuntime, aj ajVar) {
        int i3;
        if (appRuntime == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("uinType", String.valueOf(c(ajVar.f116542t)));
        hashMap.put("msgCount", String.valueOf(ajVar.D + ajVar.E));
        if (ajVar.f116542t == 0) {
            i3 = ajVar.f116538p;
        } else {
            i3 = 0;
        }
        hashMap.put("pullCount", String.valueOf(i3));
        hashMap.put("duration", String.valueOf(System.currentTimeMillis() - ajVar.C));
        hashMap.put("localCount", String.valueOf(ajVar.E));
        hashMap.put("netCount", String.valueOf(ajVar.D));
        if (QLog.isDevelopLevel()) {
            QLog.d("MessageReport", 4, "reportRefreshHead params=" + hashMap);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(appRuntime.getCurrentAccountUin(), "aio_pull_head_msg", true, 0L, 0L, hashMap, null);
    }

    public static void f(AppRuntime appRuntime, int i3, int i16) {
        try {
            if (!f116726d) {
                QLog.i("MessageReport", 2, "reportSearchBarClick return because switch");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("MessageReport", 2, "reportSearchBarClick from=" + i3 + ",sessionType=" + i16);
            }
            ReportController.o(appRuntime, "dc00898", "", "", "0X800BBF6", "0X800BBF6", i3, 0, String.valueOf(i16), "", "", "");
        } catch (Exception e16) {
            QLog.i("MessageReport", 1, "reportSearchBarClick", e16);
        }
    }

    public static void g(AppRuntime appRuntime, int i3, int i16) {
        try {
            if (!f116726d) {
                QLog.i("MessageReport", 2, "reportSearchPageExposure return because switch");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("MessageReport", 2, "reportSearchPageExposure from=" + i3 + ",sessionType=" + i16);
            }
            ReportController.o(appRuntime, "dc00898", "", "", "0X800C36A", "0X800C36A", i3, 0, String.valueOf(i16), "", "", "");
        } catch (Exception e16) {
            QLog.i("MessageReport", 1, "reportSearchPageExposure", e16);
        }
    }

    public static void h(AppRuntime appRuntime, int i3, int i16) {
        try {
            if (!f116726d) {
                QLog.i("MessageReport", 2, "reportSearchPageItemClick return because switch");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("MessageReport", 2, "reportSearchPageItemClick from=" + i3 + ",sessionType=" + i16);
            }
            ReportController.o(appRuntime, "dc00898", "", "", "0X800C36B", "0X800C36B", i3, 0, String.valueOf(i16), "", "", "");
        } catch (Exception e16) {
            QLog.i("MessageReport", 1, "reportSearchPageItemClick", e16);
        }
    }

    public static void i(AppRuntime appRuntime, int i3, int i16) {
        try {
            if (!f116726d) {
                QLog.i("MessageReport", 2, "reportTabItemClick return because switch");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("MessageReport", 2, "reportTabExposure from=" + i3 + ",sessionType=" + i16);
            }
            ReportController.o(appRuntime, "dc00898", "", "", "0X800C368", "0X800C368", i3, 0, String.valueOf(i16), "", "", "");
        } catch (Exception e16) {
            QLog.i("MessageReport", 1, "reportTabExposure", e16);
        }
    }

    public static void j(AppRuntime appRuntime, int i3, int i16) {
        try {
            if (!f116726d) {
                QLog.i("MessageReport", 2, "reportTabItemClick return because switch");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("MessageReport", 2, "reportTabItemClick from=" + i3 + ",sessionType=" + i16);
            }
            ReportController.o(appRuntime, "dc00898", "", "", "0X800C369", "0X800C369", i3, 0, String.valueOf(i16), "", "", "");
        } catch (Exception e16) {
            QLog.i("MessageReport", 1, "reportTabItemClick", e16);
        }
    }

    public static void k(boolean z16) {
        QLog.i("MessageReport", 1, "setNeedReport=" + z16);
        f116726d = z16;
    }
}
