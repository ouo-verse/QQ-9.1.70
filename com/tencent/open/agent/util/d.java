package com.tencent.open.agent.util;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static j f340603a;

    public static void A(j jVar) {
        f340603a = jVar;
    }

    public static void B(String str) {
        j jVar = f340603a;
        if (jVar != null) {
            jVar.a(str);
        }
    }

    public static HashMap<String, String> a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("open_app_id", str);
        return hashMap;
    }

    public static void b(Context context, String str, String str2, String str3, long j3, String str4, String str5) {
        try {
            StatisticCollector.getInstance(context).collectPerformance(str2, str3, false, j3, 0L, g.d("appid", str, "p1", str4, "p2", str5, "autologin", "0"), "");
        } catch (Exception e16) {
            t.d("AuthReporter", "Exception", e16);
        }
    }

    public static void c(Context context, String str, String str2, long j3, boolean z16, boolean z17) {
        String str3;
        String str4;
        if (z16) {
            str3 = "notlogged";
        } else {
            str3 = "logged";
        }
        if (z17) {
            str4 = WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH;
        } else {
            str4 = "uauth";
        }
        try {
            StatisticCollector.getInstance(context).collectPerformance(str2, "connect_sso_lognback", true, j3, 0L, g.d("appid", str, "p1", str3, "p2", str4, "autologin", "0"), "");
        } catch (Exception e16) {
            t.d("AuthReporter", "Exception", e16);
        }
    }

    public static String d() {
        NetworkInfo recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
        if (recentNetworkInfo == null) {
            return "";
        }
        if (NetworkMonitor.getType(recentNetworkInfo) == 1) {
            return "wifi";
        }
        if (NetworkMonitor.getType(recentNetworkInfo) != 0) {
            return "";
        }
        int subtype = NetworkMonitor.getSubtype(recentNetworkInfo);
        if (subtype != 3 && subtype != 8 && subtype != 5 && subtype != 6) {
            return "2G";
        }
        return "3G";
    }

    public static void e(String str, long j3) {
        j jVar = f340603a;
        if (jVar != null) {
            jVar.b(str, j3);
        }
    }

    public static void f(String str, com.tencent.open.model.a aVar) {
        j jVar = f340603a;
        if (jVar != null) {
            jVar.d(str, aVar);
        }
    }

    public static void g(String str, com.tencent.open.model.a aVar, HashMap<String, String> hashMap, boolean z16) {
        j jVar = f340603a;
        if (jVar != null) {
            jVar.c(str, aVar, hashMap, z16);
        }
    }

    public static void h(String str, com.tencent.open.model.a aVar, boolean z16) {
        j jVar = f340603a;
        if (jVar != null) {
            jVar.e(str, aVar, z16);
        }
    }

    public static void i(String str, String str2, long j3, HashMap<String, String> hashMap, boolean z16) {
        j jVar = f340603a;
        if (jVar != null) {
            jVar.f(str, str2, j3, hashMap, z16);
        }
    }

    public static void j(String str, String str2, boolean z16) {
        j jVar = f340603a;
        if (jVar != null) {
            jVar.g(str, str2, z16);
        }
    }

    public static void k(Context context, int i3, String str, String str2, String str3) {
        m(context, i3, str, str2, str3, new HashMap());
    }

    public static void l(Context context, int i3, String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("errordetail", str4);
        m(context, i3, str, str2, str3, hashMap);
    }

    public static void m(Context context, int i3, String str, String str2, String str3, HashMap<String, String> hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        HashMap<String, String> hashMap2 = hashMap;
        hashMap2.put("appid", str3);
        hashMap2.put("errorcode", String.valueOf(i3));
        hashMap2.put("errormsg", str);
        String d16 = d();
        if (!TextUtils.isEmpty(d16)) {
            hashMap2.put("network", d16);
        }
        StatisticCollector.getInstance(context).collectPerformance(str2, "connect_sso_authfail", false, 0L, 0L, hashMap2, "");
    }

    public static void n(int i3, com.tencent.open.model.a aVar, String str) {
        HashMap<String, String> a16 = a(str);
        boolean z16 = true;
        g("KEY_LOGIN_STAGE_3_TOTAL", aVar, a16, true);
        a16.put("PARAM_ERROR_CODE", Integer.toString(i3));
        if (i3 != 0) {
            z16 = false;
        }
        g("KEY_AUTHORITY_TOTAL", aVar, a16, z16);
    }

    public static void o(String str, long j3, long j16, long j17, int i3, String str2, String str3) {
        try {
            ReportManager.h().k(str, j3, j16, j17, i3, Long.parseLong(str2), "1000069", str3, true);
        } catch (Exception e16) {
            t.d("AuthReporter", "Exception", e16);
        }
    }

    public static void p(String str, int i3) {
        ReportController.o(null, "dc00898", "", "", str, str, i3, 0, "", "", "", "");
    }

    public static void q(long j3, int i3, String str, String str2) {
        y(g.c(TVKDataBinder.KEY_REPORT_TYPE, 103, "act_type", 10, "stringext_1", "GetTicketNoPassword", "intext_2", Integer.valueOf(i3), "intext_5", Long.valueOf(j3)), str, str2);
    }

    public static void r(int i3, String str, String str2, String str3, int i16, String str4) {
        try {
            com.tencent.open.business.viareport.c.a().b(i3, str, str2, str3, null, Long.valueOf(SystemClock.elapsedRealtime()), i16, 1, str4);
        } catch (Exception e16) {
            t.d("AuthReporter", "Exception", e16);
        }
    }

    public static void s(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equals(up3.b.i())) {
            ReportController.o(null, "dc00898", "", str, str2, str2, 0, 0, "", "", "", "");
        }
    }

    public static void t(int i3, String str, String str2) {
        String str3;
        t.b("AuthReporter", "reportLoginResult, errorCode=", Integer.valueOf(i3), ", appId=", str, ", uin=*", g.C(str2));
        if (i3 == 0) {
            str3 = "0";
        } else {
            str3 = "1";
        }
        try {
            ReportCenter.f().q(str2, "", str, "1", "3", str3, true, true);
        } catch (Exception e16) {
            t.d("AuthReporter", "reportLoginResult, error: ", e16);
        }
    }

    public static void u(long j3, int i3, String str, String str2) {
        try {
            y(g.c(TVKDataBinder.KEY_REPORT_TYPE, 103, "act_type", Integer.valueOf(i3), "intext_5", Long.valueOf(j3)), str, str2);
        } catch (Exception e16) {
            t.d("AuthReporter", "Exception", e16);
        }
    }

    public static void v(Bundle bundle, long j3, int i3, int i16, String str, String str2, String str3) {
        String str4;
        boolean z16 = bundle.getBoolean("isShort", false);
        Object[] objArr = new Object[12];
        objArr[0] = TVKDataBinder.KEY_REPORT_TYPE;
        objArr[1] = 103;
        objArr[2] = "act_type";
        objArr[3] = Integer.valueOf(i16);
        objArr[4] = "intext_3";
        if (z16) {
            str4 = "2";
        } else {
            str4 = "1";
        }
        objArr[5] = str4;
        objArr[6] = "stringext_1";
        objArr[7] = str;
        objArr[8] = "intext_2";
        objArr[9] = Integer.valueOf(i3);
        objArr[10] = "intext_5";
        objArr[11] = Long.valueOf(j3);
        y(g.c(objArr), str2, str3);
    }

    public static void w(String str, String str2, String str3, String str4) {
        if (str3 == null) {
            str3 = "";
        }
        if (str4 == null) {
            str4 = "";
        }
        Bundle bundle = new Bundle();
        bundle.putString("uin", str);
        bundle.putString("openid", "");
        bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, "1");
        bundle.putString("act_type", "7");
        bundle.putString("via", "2");
        bundle.putString("app_id", str2);
        bundle.putString("packagename", str3);
        bundle.putString("stringext_1", str4);
        bundle.putString("result", "0");
        y(bundle, str2, str);
    }

    public static void x(AppRuntime appRuntime, String str, String str2) {
        StatisticCollector.getInstance(BaseApplication.getContext()).reportToAds(appRuntime, str, str2);
    }

    private static void y(Bundle bundle, String str, String str2) {
        try {
            ReportCenter.f().m(bundle, str, str2, false, true);
        } catch (Exception e16) {
            t.d("AuthReporter", "Exception", e16);
        }
    }

    public static void z(String str, String str2, String str3, String str4, boolean z16) {
        try {
            ReportCenter.f().q(str, "", str2, "1", str3, str4, z16, true);
        } catch (Exception e16) {
            t.d("AuthReporter", "Exception", e16);
        }
    }
}
