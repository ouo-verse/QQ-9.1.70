package com.qzone.misc.network.report;

import android.content.Intent;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {
    public static void b(ro.a aVar) {
        ClickReport.q("586", "7", a(aVar), true);
    }

    public static void c(ro.a aVar) {
        ClickReport.q("586", "2", a(aVar), true);
    }

    public static void d() {
        ClickReport.q("585", "1", "", true);
    }

    public static void e(ro.a aVar) {
        ClickReport.q("586", "8", a(aVar), true);
    }

    public static void f(ro.a aVar) {
        ClickReport.q("586", "13", a(aVar), true);
    }

    public static void g(ro.a aVar) {
        ClickReport.q("586", "12", a(aVar), true);
    }

    public static void h(ro.a aVar, Intent intent) {
        ClickReport.q("586", "1", a(aVar), true);
        i(intent, 1);
    }

    public static void j(ro.a aVar) {
        ClickReport.q("586", "44", a(aVar), true);
    }

    public static void k(ro.a aVar) {
        ClickReport.q("586", "16", a(aVar), true);
    }

    public static void l(ro.a aVar) {
        ClickReport.q("586", "15", a(aVar), true);
    }

    public static void m(ro.a aVar) {
        ClickReport.q("586", "5", a(aVar), true);
    }

    public static void n(ro.a aVar) {
        ClickReport.q("586", "4", a(aVar), true);
    }

    public static void o(ro.a aVar) {
        ClickReport.q("586", "14", a(aVar), true);
    }

    public static void p(ro.a aVar) {
        ClickReport.q("586", "9", a(aVar), true);
    }

    public static void q(ro.a aVar) {
        ClickReport.q("586", "10", a(aVar), true);
    }

    public static void r(ro.a aVar) {
        ClickReport.q("586", "6", a(aVar), true);
    }

    public static String a(ro.a aVar) {
        String b16 = aVar != null ? aVar.b() : null;
        if ("shuoshuoPlus".equals(b16)) {
            return "1";
        }
        if ("shuoshuoList".equals(b16)) {
            return "2";
        }
        if ("shuoshuoFeeds".equals(b16)) {
            return "3";
        }
        if ("shuoshuoFeedsBubble".equals(b16)) {
            return "4";
        }
        return "5";
    }

    public static void i(Intent intent, int i3) {
        if (intent != null && intent.hasExtra(QQWinkConstants.KEY_QZONE_LIBTEMPLATE_MATERIAL_NAME) && intent.hasExtra(QQWinkConstants.KEY_QZONE_LIBTEMPLATE_MATERIAL_TYPE)) {
            LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
            lpReportInfo_pf00064.actionType = 3000;
            lpReportInfo_pf00064.subactionType = 1;
            lpReportInfo_pf00064.reserves = i3;
            lpReportInfo_pf00064.reserves3 = intent.getStringExtra(QQWinkConstants.KEY_QZONE_LIBTEMPLATE_MATERIAL_NAME);
            lpReportInfo_pf00064.reserves4 = intent.getStringExtra(QQWinkConstants.KEY_QZONE_LIBTEMPLATE_MATERIAL_TYPE);
            LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
        }
    }
}
