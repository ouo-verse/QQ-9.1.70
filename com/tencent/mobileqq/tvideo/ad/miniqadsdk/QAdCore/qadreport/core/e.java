package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static String f304062a = "QAdReporter";

    public static void a(d dVar, boolean z16, g gVar) {
        b(dVar, z16, gVar, true);
    }

    public static void b(d dVar, boolean z16, g gVar, boolean z17) {
        if (dVar == null) {
            n.b(f304062a, "reportClickEvent info null");
            return;
        }
        if (z17) {
            n.e(f304062a, "reportClickEvent url = " + dVar.q());
            ReportManager.INSTANCE.reportWithSign(dVar, z16, 1, gVar);
        }
        HashMap<String, String> s16 = dVar.s();
        int j3 = dVar.j();
        s16.remove(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL);
        j(dVar.f304048a, dVar.b(), gVar, j3);
    }

    public static void c(d dVar, boolean z16, g gVar) {
        if (dVar == null) {
            return;
        }
        n.e(f304062a, "reportEffectEvent url = " + dVar.q());
        ReportManager.INSTANCE.report(dVar, z16, 3, gVar);
        b.b(dVar);
        dVar.s().remove(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL);
    }

    public static void d(d dVar, boolean z16, g gVar) {
        if (dVar == null) {
            return;
        }
        n.e(f304062a, "reportEmptyAdInfo , url=" + dVar.q());
        dVar.s();
        ReportManager.INSTANCE.report(dVar, z16, 4, gVar);
    }

    public static void e(d dVar, boolean z16, g gVar) {
        f(dVar, z16, gVar, true);
    }

    public static void f(d dVar, boolean z16, g gVar, boolean z17) {
        if (dVar == null) {
            return;
        }
        if (z17) {
            n.e(f304062a, "reportExposure url = " + dVar.q());
            ReportManager.INSTANCE.reportWithSign(dVar, z16, 2, gVar);
        }
        HashMap<String, String> s16 = dVar.s();
        int j3 = dVar.j();
        s16.remove(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL);
        j(dVar.f304048a, dVar.b(), gVar, j3);
    }

    public static void g(d dVar, g gVar) {
        if (dVar == null) {
            n.b(f304062a, "reportMtaAndThirdParty info null");
            return;
        }
        String q16 = dVar.q();
        n.e(f304062a, "reportMTAAndThirdParty url=" + q16);
        i(dVar.f304048a, dVar.b(), gVar);
    }

    public static void h(d dVar, boolean z16, g gVar) {
        if (dVar == null) {
            return;
        }
        n.e(f304062a, "reportPreAdFunnel url = " + dVar.q());
        ReportManager.INSTANCE.report(dVar, z16, 6, gVar);
    }

    public static void i(AdReport adReport, HashMap<String, String> hashMap, g gVar) {
        j(adReport, hashMap, gVar, 0);
    }

    public static void j(AdReport adReport, HashMap<String, String> hashMap, g gVar, int i3) {
        if (adReport == null) {
            n.b(f304062a, "reportThirdParty AdReport null");
        } else {
            k(adReport.apiReportUrl, hashMap, gVar, i3);
        }
    }

    private static void k(ArrayList<String> arrayList, HashMap<String, String> hashMap, g gVar, int i3) {
        if (arrayList == null) {
            n.b(f304062a, "reportThirdPartyAPIUrl url null");
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                new jw2.a(next, hashMap, i3).t(gVar);
            }
            n.e(f304062a, "ThirdParty api url = " + next);
        }
    }
}
