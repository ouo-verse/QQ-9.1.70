package com.tencent.upgrade.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportKey;
import com.tencent.upgrade.bean.ReportParam;

/* compiled from: P */
/* loaded from: classes27.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static void a() {
        com.tencent.upgrade.util.d.a("ReportManager", "reportActive");
        new ReportParam().setEventType("active").setEventResult((byte) 0).report();
    }

    public static void b(boolean z16) {
        com.tencent.upgrade.util.d.a("ReportManager", "reportDownload success = " + z16);
        new ReportParam().setEventType("download").setEventResult(!z16 ? (byte) 1 : (byte) 0).report();
    }

    public static void c(boolean z16) {
        com.tencent.upgrade.util.d.a("ReportManager", "reportInstall success = " + z16);
        new ReportParam().setEventType(VRReportDefine$ReportKey.INSTALL).setEventResult(!z16 ? (byte) 1 : (byte) 0).report();
    }

    public static void d() {
        com.tencent.upgrade.util.d.a("ReportManager", "reportReceive");
        new ReportParam().setEventType("rcv").setEventResult((byte) 0).report();
    }
}
