package com.tencent.mobileqq.soload.util;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.comm.api.IWadlSoDownloader;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h {
    static IPatchRedirector $redirector_;

    public static void a(LoadParam loadParam, long j3, String str, String str2, String str3, int i3, String str4) {
        if (LoadParam.isCloseReport(loadParam)) {
            return;
        }
        f.w().addReportItem(j3, str, str2, str3, i3, str4);
    }

    private static float b(long j3, long j16) {
        if (j3 > 0) {
            return ((((float) j16) * 1.0f) / 1024.0f) / ((((float) j3) * 1.0f) / 1000.0f);
        }
        return 0.0f;
    }

    public static void c(LoadParam loadParam, long j3, String str, String str2, int i3, String str3) {
        if (LoadParam.isCloseReport(loadParam)) {
            return;
        }
        f.w().endReport(j3, str, str2, i3, str3);
    }

    private static WadlReportBuilder d() {
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("769").setOperId("208518").setModuleType("104705").setBussinessId("1").setPageId("160");
        return wadlReportBuilder;
    }

    public static void e(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9, int i17) {
        ReportController.o(appRuntime, str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
        k(i16, i17, str6);
    }

    public static void f(boolean z16, String str, boolean z17, long j3, long j16, boolean z18, String str2, int i3) {
        String str3;
        String str4;
        WadlReportBuilder d16 = d();
        String str5 = "1";
        if (z16) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        WadlReportBuilder ext = d16.setExt(26, str3).setExt(27, str).setExt(28, i3 + "").setExt(29, "4").setExt(30, j3 + "").setExt(31, j16 + "");
        if (z17) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        WadlReportBuilder ext2 = ext.setExt(32, str4).setExt(33, str2);
        if (!z18) {
            str5 = "0";
        }
        ext2.setExt(35, str5).report();
    }

    public static void g(int i3, int i16, long j3, String str, int i17, int i18, int i19, long j16) {
        String str2;
        WadlReportBuilder ext = d().setExt(26, i3 + "").setExt(27, i16 + "").setExt(28, j3 + "").setExt(29, "5").setExt(30, i17 + "").setExt(31, i19 + "").setExt(32, i18 + "").setExt(33, str);
        if (i17 == 1 && ((IWadlSoDownloader) QRoute.api(IWadlSoDownloader.class)).isWadlDownloader()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        ext.setExt(34, str2).setExt(38, j16 + "").setExt(39, b(j3, j16) + "").report();
    }

    public static void h(String str, String str2) {
        m(null, "SoLoadModule", "SoLoadSingle", "Exception", str, 1, str2);
        i(str2);
    }

    public static void i(String str) {
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("10").setOperId(WadlProxyConsts.OPER_ID_UPDATE_DOWNLOAD).setExt(32, str);
        wadlReportBuilder.report();
    }

    public static void j(String str, int i3, long j3, int i16) {
        d().setExt(26, i3 + "").setExt(27, str).setExt(28, j3 + "").setExt(29, "8").setExt(30, i16 + "").report();
    }

    public static void k(int i3, int i16, String str) {
        if (i16 == 0) {
            return;
        }
        d().setExt(26, i16 + "").setExt(27, str).setExt(28, i3 + "").setExt(29, "7").report();
    }

    public static void l(String str, String str2, int i3) {
        d().setExt(27, str2).setExt(28, i3 + "").setExt(29, "6").setExt(33, str).report();
    }

    public static void m(String str, String str2, String str3, String str4, String str5, int i3, String str6) {
        f.w().singleReport(str, str2, str3, str4, str5, i3, str6);
    }

    public static long n(LoadParam loadParam) {
        long o16 = o(loadParam, null, "SoLoadModule", "SoLoad", "load.start", LoadParam.getReportStr(loadParam), LoadParam.getItemSize(loadParam), null);
        loadParam.mReportSeq = o16;
        return o16;
    }

    public static long o(LoadParam loadParam, String str, String str2, String str3, String str4, String str5, int i3, String str6) {
        if (LoadParam.isCloseReport(loadParam)) {
            return 0L;
        }
        return f.w().startReport(str, str2, str3, str4, str5, i3, str6);
    }
}
