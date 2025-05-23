package com.tencent.mobileqq.statistics;

import android.content.Intent;
import android.telephony.TelephonyManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ReportController {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap<String, b> f289909d;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements PluginRuntime.IClickEventReportor {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.PluginRuntime.IClickEventReportor
        public void reportClickEvent(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), str6, str7, str8, str9);
            } else {
                ReportController.o(null, str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.PluginRuntime.IClickEventReportor
        public void reportClickEventRuntime(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), str6, str7, str8, str9);
            } else {
                ReportController.r(null, str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void a(Reporting reporting);

        void b();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36163);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        HashMap<String, b> hashMap = new HashMap<>();
        f289909d = hashMap;
        try {
            z91.b b16 = com.tencent.mobileqq.bridge.a.b();
            if (b16 != null && b16.a() != null) {
                hashMap.put("dc01160", (b) b16.a());
            }
        } catch (Exception e16) {
            QLog.e("ReportController", 1, "getTag1160ReportController error: " + e16.toString());
        }
    }

    public ReportController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean B(AppRuntime appRuntime, boolean z16) {
        ReportController reportController;
        if (QLog.isColorLevel()) {
            QLog.d("ReportController", 2, "startReportLooper");
        }
        z91.b b16 = com.tencent.mobileqq.bridge.a.b();
        if (b16 != null) {
            reportController = (ReportController) b16.b(appRuntime);
        } else {
            reportController = null;
        }
        if (reportController != null) {
            reportController.A(!z16);
        }
        return true;
    }

    public static void D(AppRuntime appRuntime) {
        ReportController reportController;
        if (QLog.isColorLevel()) {
            QLog.d("ReportController", 2, "stopReportLooper");
        }
        z91.b b16 = com.tencent.mobileqq.bridge.a.b();
        if (b16 != null) {
            reportController = (ReportController) b16.b(appRuntime);
        } else {
            reportController = null;
        }
        if (reportController != null) {
            reportController.C();
        }
    }

    public static void c(PluginRuntime pluginRuntime) {
        pluginRuntime.setClickEventReportor(new a());
    }

    private static String g(boolean z16, String str, String str2, String str3, String str4, String str5, int i3, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        String str15 = NetConnInfoCenter.getServerTime() + "|" + AppSetting.f() + "|android|" + str + "|" + str2 + "|" + str3 + "|" + str4 + "|" + str5 + "|" + i3 + "|" + str6 + "|" + ah.z() + "||" + ah.C() + "|" + ah.F() + "|" + (z16 ? NetConnInfoCenter.getSystemNetStateString() : "") + "|" + ah.t() + "|" + ROMUtil.getRomDetailInfo() + "|" + str7 + "|" + str8 + "|" + str9 + "|" + str10 + "|" + str11 + "|" + str12 + "|" + str13 + "|" + str14 + "|";
        if (QLog.isColorLevel()) {
            QLog.d("ReportController", 2, "getDC04272ReportDetail=" + str15);
        }
        return str15;
    }

    private static String h() {
        int n3 = ah.n();
        long c16 = (com.tencent.mobileqq.utils.m.c() / 1024) / 1024;
        long[] T = ah.T();
        String networkOperator = DeviceInfoMonitor.getNetworkOperator((TelephonyManager) BaseApplication.getContext().getSystemService("phone"));
        if (networkOperator == null) {
            networkOperator = "";
        }
        String str = n3 + ";" + c16 + ";" + T[0] + ";" + T[1] + ";" + networkOperator.replaceAll(";", "") + ";" + String.format("%.2f", Double.valueOf(ah.W())) + ";" + ah.M() + ";" + ah.L() + ";";
        if (QLog.isColorLevel()) {
            QLog.d("ReportController", 2, "getExtraDeviceInfo=" + str);
        }
        return str;
    }

    private static String i(String str, String str2, String str3, String str4, String str5, String str6, int i3, int i16, int i17, String str7, String str8, String str9, String str10) {
        d(str, str2, str5, str6);
        e(str, i16, str7, str8);
        StringBuilder sb5 = new StringBuilder(64);
        if (str2 != null && str2.length() > 0) {
            sb5.append(str2);
            sb5.append(QbAddrData.DATA_SPLITER);
        }
        if (str.equals("dc01440")) {
            sb5.append("0");
            sb5.append(QbAddrData.DATA_SPLITER);
        }
        sb5.append(str3);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str4);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str5);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str6);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(i3);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append("${count_unknown}");
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(i17);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str7);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str8);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str9);
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(str10);
        sb5.append(QbAddrData.DATA_SPLITER);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, String str6, String str7, String str8, String str9, z91.c cVar, int i18) {
        String i19 = i(str, str2, "${uin_unknown}", str3, str4, str5, i3, i16, i17, str6, str7, str8, str9);
        Intent intent = new Intent();
        intent.setClassName(BaseApplication.getContext(), "com.tencent.mobileqq.statistics.ReportReceiver");
        intent.putExtra("reporting_tag", str);
        intent.putExtra("reporting_detail", i19);
        intent.putExtra("reporting_count", i16);
        intent.putExtra("is_runtime", i18);
        BaseApplication.getContext().sendBroadcast(intent);
        if (cVar != null) {
            cVar.b(str, str4, i19);
        }
    }

    public static void m(AppRuntime appRuntime, String str, String str2, int i3) {
        ReportController reportController;
        if (str2 != null) {
            z91.b b16 = com.tencent.mobileqq.bridge.a.b();
            if (b16 != null) {
                reportController = (ReportController) b16.b(appRuntime);
            } else {
                reportController = null;
            }
            if (reportController != null) {
                if (str2.contains("${uin_unknown}")) {
                    str2 = str2.replace("${uin_unknown}", appRuntime.getAccount());
                }
                reportController.b(str, str2, i3);
            }
        }
    }

    public static void n(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, String str6, String str7, String str8, String str9) {
        z91.c c16 = com.tencent.mobileqq.bridge.a.c();
        AppRuntime appRuntime2 = appRuntime;
        if (c16 != null) {
            appRuntime2 = c16.c(appRuntime2);
        }
        AppRuntime appRuntime3 = appRuntime2;
        if (appRuntime3 == null) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102796", true)) {
                ThreadManagerV2.excute(new Runnable(str, str2, str3, str4, str5, i3, i16, i17, str6, str7, str8, str9, c16) { // from class: com.tencent.mobileqq.statistics.ReportController.3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int C;
                    final /* synthetic */ int D;
                    final /* synthetic */ String E;
                    final /* synthetic */ String F;
                    final /* synthetic */ String G;
                    final /* synthetic */ String H;
                    final /* synthetic */ z91.c I;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f289916d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f289917e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f289918f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ String f289919h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ String f289920i;

                    /* renamed from: m, reason: collision with root package name */
                    final /* synthetic */ int f289921m;

                    {
                        this.f289916d = str;
                        this.f289917e = str2;
                        this.f289918f = str3;
                        this.f289919h = str4;
                        this.f289920i = str5;
                        this.f289921m = i3;
                        this.C = i16;
                        this.D = i17;
                        this.E = str6;
                        this.F = str7;
                        this.G = str8;
                        this.H = str9;
                        this.I = c16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str6, str7, str8, str9, c16);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            ReportController.l(this.f289916d, this.f289917e, this.f289918f, this.f289919h, this.f289920i, this.f289921m, this.C, this.D, this.E, this.F, this.G, this.H, this.I, 0);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                }, 16, null, false);
                return;
            } else {
                l(str, str2, str3, str4, str5, i3, i16, i17, str6, str7, str8, str9, c16, 0);
                return;
            }
        }
        String i18 = i(str, str2, appRuntime3.getAccount(), str3, str4, str5, i3, i16, i17, str6, str7, str8, str9);
        m(appRuntime3, str, i18, i16);
        if (c16 != null) {
            c16.b(str, str4, i18);
        }
    }

    public static void o(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        n(appRuntime, str, str2, str3, str4, str5, i3, 1, i16, str6, str7, str8, str9);
    }

    public static void p(AppRuntime appRuntime, String str, String str2, int i3) {
        if (str2.contains("${uin_unknown}")) {
            String account = appRuntime.getAccount();
            if (account == null) {
                account = "";
            }
            str2 = str2.replace("${uin_unknown}", account);
        }
        String replace = str2.replace("${count_unknown}", Integer.toString(i3));
        if (QLog.isColorLevel()) {
            QLog.d("ReportController", 2, "ReportRuntime: " + str + ", " + replace);
        } else if (!appRuntime.isLogin()) {
            QLog.d("ReportController", 1, "ReportRuntime: " + str + ", " + replace);
        }
        try {
            NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.mobileqq.servlet.q.class);
            newIntent.putExtra("sendType", 2);
            newIntent.putExtra("tag", str);
            newIntent.putExtra("content", replace);
            newIntent.setWithouLogin(true);
            appRuntime.startServlet(newIntent);
        } catch (Exception e16) {
            QLog.e("ReportController", 1, e16, new Object[0]);
        }
    }

    public static void q(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, String str6, String str7, String str8, String str9) {
        String str10;
        String str11;
        z91.c c16 = com.tencent.mobileqq.bridge.a.c();
        AppRuntime appRuntime2 = appRuntime;
        if (c16 != null) {
            appRuntime2 = c16.c(appRuntime2);
        }
        if (appRuntime2 == null) {
            appRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        }
        AppRuntime appRuntime3 = appRuntime2;
        if (appRuntime3 == null) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102796", true)) {
                ThreadManagerV2.excute(new Runnable(str, str2, str3, str4, str5, i3, i17, i16, str6, str7, str8, str9, c16) { // from class: com.tencent.mobileqq.statistics.ReportController.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int C;
                    final /* synthetic */ int D;
                    final /* synthetic */ String E;
                    final /* synthetic */ String F;
                    final /* synthetic */ String G;
                    final /* synthetic */ String H;
                    final /* synthetic */ z91.c I;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f289910d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f289911e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f289912f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ String f289913h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ String f289914i;

                    /* renamed from: m, reason: collision with root package name */
                    final /* synthetic */ int f289915m;

                    {
                        this.f289910d = str;
                        this.f289911e = str2;
                        this.f289912f = str3;
                        this.f289913h = str4;
                        this.f289914i = str5;
                        this.f289915m = i3;
                        this.C = i17;
                        this.D = i16;
                        this.E = str6;
                        this.F = str7;
                        this.G = str8;
                        this.H = str9;
                        this.I = c16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i17), Integer.valueOf(i16), str6, str7, str8, str9, c16);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            ReportController.l(this.f289910d, this.f289911e, this.f289912f, this.f289913h, this.f289914i, this.f289915m, this.C, this.D, this.E, this.F, this.G, this.H, this.I, 1);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                }, 16, null, false);
                return;
            } else {
                l(str, str2, str3, str4, str5, i3, i17, i16, str6, str7, str8, str9, c16, 1);
                return;
            }
        }
        List<String> arrayList = new ArrayList<>();
        List<String> arrayList2 = new ArrayList<>();
        z91.b b16 = com.tencent.mobileqq.bridge.a.b();
        if (b16 != null) {
            arrayList = b16.c();
            arrayList2 = b16.f();
        }
        if (!arrayList.contains(str4) && !arrayList2.contains(str4)) {
            str11 = str3;
            str10 = appRuntime3.getAccount();
        } else {
            str10 = str3;
            str11 = "";
        }
        String i18 = i(str, str2, str10, str11, str4, str5, i3, i17, i16, str6, str7, str8, str9);
        p(appRuntime3, str, i18, i17);
        if (c16 != null) {
            c16.b(str, str4, i18);
        }
    }

    public static void r(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        q(appRuntime, str, str2, str3, str4, str5, i3, i16, 1, str6, str7, str8, str9);
    }

    public static void s(AppRuntime appRuntime, String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        AppRuntime appRuntime2;
        z91.c c16 = com.tencent.mobileqq.bridge.a.c();
        if (c16 != null) {
            appRuntime2 = c16.c(appRuntime);
        } else {
            appRuntime2 = appRuntime;
        }
        if (appRuntime2 == null) {
            String g16 = g(true, "${uin_unknown}", str, str2, str3, str4, i3, str5, str6, str7, str8, str9, str10, str11, str12, str13);
            Intent intent = new Intent();
            intent.setClassName(BaseApplication.getContext(), "com.tencent.mobileqq.statistics.ReportReceiver");
            intent.putExtra("reporting_tag", com.tencent.mobileqq.msf.core.c0.a.f247563b);
            intent.putExtra("reporting_detail", g16);
            intent.putExtra("reporting_count", i3);
            intent.putExtra("is_runtime", 0);
            BaseApplication.getContext().sendBroadcast(intent);
            return;
        }
        m(appRuntime2, com.tencent.mobileqq.msf.core.c0.a.f247563b, g(true, appRuntime2.getAccount(), str, str2, str3, str4, i3, str5, str6, str7, str8, str9, str10, str11, str12, str13), i3);
    }

    public static void t(AppRuntime appRuntime, String str, String str2, String str3, String str4, int i3, String str5) {
        u(appRuntime, str, str2, str3, str4, i3, str5, "", "", "", "", "", "", "", "");
    }

    public static void u(AppRuntime appRuntime, String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        AppRuntime appRuntime2;
        z91.c c16 = com.tencent.mobileqq.bridge.a.c();
        if (c16 != null) {
            appRuntime2 = c16.c(appRuntime);
        } else {
            appRuntime2 = appRuntime;
        }
        if (appRuntime2 == null) {
            String g16 = g(true, "${uin_unknown}", str, str2, str3, str4, i3, str5, str6, str7, str8, str9, str10, str11, str12, str13);
            Intent intent = new Intent();
            intent.setClassName(BaseApplication.getContext(), "com.tencent.mobileqq.statistics.ReportReceiver");
            intent.putExtra("reporting_tag", com.tencent.mobileqq.msf.core.c0.a.f247563b);
            intent.putExtra("reporting_detail", g16);
            intent.putExtra("reporting_count", i3);
            intent.putExtra("is_runtime", 1);
            BaseApplication.getContext().sendBroadcast(intent);
            return;
        }
        p(appRuntime2, com.tencent.mobileqq.msf.core.c0.a.f247563b, g(true, appRuntime2.getAccount(), str, str2, str3, str4, i3, str5, str6, str7, str8, str9, str10, str11, str12, str13), i3);
    }

    public static void v(AppRuntime appRuntime, String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        s(appRuntime, str, str2, str3, str4, i3, str5, h(), str6, str7, str8, str9, str10, str11, str12);
    }

    public static void w(AppRuntime appRuntime, String str, String str2, String str3, String str4, int i3, String str5) {
        u(appRuntime, str, str2, str3, str4, i3, str5, h(), "", "", "", "", "", "", "");
    }

    public static void x(AppRuntime appRuntime, boolean z16, String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        z91.c c16 = com.tencent.mobileqq.bridge.a.c();
        AppRuntime c17 = c16 != null ? c16.c(appRuntime) : appRuntime;
        if (c17 == null) {
            String g16 = g(z16, "${uin_unknown}", str, str2, str3, str4, i3, str5, str6, str7, str8, str9, str10, str11, str12, str13);
            Intent intent = new Intent();
            intent.setClassName(BaseApplication.getContext(), "com.tencent.mobileqq.statistics.ReportReceiver");
            intent.putExtra("reporting_tag", com.tencent.mobileqq.msf.core.c0.a.f247563b);
            intent.putExtra("reporting_detail", g16);
            intent.putExtra("reporting_count", i3);
            intent.putExtra("is_runtime", 1);
            BaseApplication.getContext().sendBroadcast(intent);
            return;
        }
        p(c17, com.tencent.mobileqq.msf.core.c0.a.f247563b, g(z16, c17.getAccount(), str, str2, str3, str4, i3, str5, str6, str7, str8, str9, str10, str11, str12, str13), i3);
    }

    public static void y(AppRuntime appRuntime, String str) {
        o(appRuntime, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }

    public static boolean z(String str) {
        if (!"P_CliOper".equals(str) && !"CliOper".equals(str) && !"on_off".equals(str) && !"CliStatus".equals(str)) {
            return false;
        }
        return true;
    }

    protected void A(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
    }

    protected void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        HashMap<String, b> hashMap = f289909d;
        if (hashMap.containsKey(str)) {
            return hashMap.get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        z91.b b16 = com.tencent.mobileqq.bridge.a.b();
        if (b16 != null && b16.d(str)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Iterator<String> it = f289909d.keySet().iterator();
        while (it.hasNext()) {
            b bVar = f289909d.get(it.next());
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    private static void d(String str, String str2, String str3, String str4) {
    }

    private static void e(String str, int i3, String str2, String str3) {
    }
}
