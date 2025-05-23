package com.tencent.ads.monitor;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.ads.AdManager;
import com.tencent.ads.data.AdItem;
import com.tencent.ads.data.AdParam;
import com.tencent.ads.data.ReportClickItem;
import com.tencent.ads.data.ReportItem;
import com.tencent.ads.utility.SystemUtil;
import com.tencent.ads.utility.Utils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$VersionDefine;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f61668a = "AdPing";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f61669b = true;

    b() {
    }

    public static Map a(AdMonitor adMonitor, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put(AdParam.PF, QAdConfigDefine$VersionDefine.K_QAD_PF);
        hashMap.put(AdParam.LCOUNT, String.valueOf(i3));
        hashMap.put("v", AdManager.SDK_VERSION);
        hashMap.put(AdParam.TY, "web");
        hashMap.put("appversion", AdMonitor.getAppVersion());
        hashMap.put("chid", String.valueOf(AdManager.getChid()));
        if (adMonitor.getAdInfo() != null) {
            hashMap.put(AdParam.DURA, String.valueOf(adMonitor.getAdInfo().getVideoDuration()));
            hashMap.put("vid", adMonitor.getVideoId());
            hashMap.put(AdParam.COVERID, adMonitor.getCoverId());
            hashMap.put("l", adMonitor.getAdInfo().getAid());
            hashMap.put(AdParam.OADID, adMonitor.getAdInfo().getOaid());
            hashMap.put(AdParam.TPID, adMonitor.getAdInfo().getTpid());
        }
        return hashMap;
    }

    private static String b(Throwable th5, String str) {
        String str2;
        String str3;
        JSONObject jSONObject = new JSONObject();
        str2 = "";
        if (th5 != null) {
            jSONObject.put("ex_name", th5.getClass().getName());
            str3 = th5.getCause() != null ? th5.getCause().toString() : "";
            str2 = th5.getMessage() != null ? th5.getMessage() : "";
            StackTraceElement[] stackTrace = th5.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                JSONArray jSONArray = new JSONArray();
                int i3 = 0;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        jSONArray.put(i3, stackTraceElement.toString());
                        i3++;
                    }
                }
                jSONObject.put("ex_callStackSymbols", jSONArray);
            }
        } else {
            str3 = "";
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = String.valueOf(str2) + " " + str;
        }
        if (!TextUtils.isEmpty(str3)) {
            jSONObject.put("ex_reason", str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("ex_msg", str2);
        }
        jSONObject.put(AdParam.MACADDRESS, AdMonitor.getMac());
        jSONObject.put("uin", AdMonitor.getUin());
        jSONObject.put("imei", AdMonitor.getImei());
        jSONObject.put("appname", SystemUtil.getApkName());
        jSONObject.put(AdParam.PF, QAdConfigDefine$VersionDefine.K_QAD_PF);
        return jSONObject.toString();
    }

    private static boolean c() {
        return true;
    }

    private static void a(AdItem adItem, long j3, boolean z16) {
        ReportItem[] reportSdkItem;
        if (adItem == null) {
            Log.i(f61668a, "doOtherPing adItem == null");
            return;
        }
        ReportItem[] reportUrlOther = adItem.getReportUrlOther();
        if (reportUrlOther != null) {
            for (ReportItem reportItem : reportUrlOther) {
                if (reportItem != null && ((j3 >= reportItem.b() || z16) && !reportItem.c())) {
                    HashMap hashMap = new HashMap();
                    String a16 = reportItem.a();
                    reportItem.a(true);
                    e eVar = new e();
                    eVar.a(a16);
                    eVar.a(hashMap);
                    Log.d(f61668a, "onExposed! API " + eVar.a());
                    PingService.getInstance().doPing(eVar);
                }
            }
        }
        if (!a() || (reportSdkItem = adItem.getReportSdkItem()) == null) {
            return;
        }
        for (ReportItem reportItem2 : reportSdkItem) {
            if (reportItem2 != null && !reportItem2.c() && (j3 >= reportItem2.b() || z16)) {
                reportItem2.a(true);
                if (TextUtils.isEmpty(reportItem2.a())) {
                    reportItem2.a(true);
                } else {
                    Log.d(f61668a, "onExposed! SDK " + reportItem2.a());
                    String a17 = reportItem2.a();
                    e eVar2 = new e();
                    eVar2.a(a17);
                    PingService.getInstance().doPing(eVar2);
                }
            }
        }
    }

    private static Map b(AdMonitor adMonitor, int i3) {
        Map a16 = a(adMonitor, i3);
        if (adMonitor.getAdInfo() != null) {
            a16.put("target", adMonitor.getAdInfo().getAid());
        }
        return a16;
    }

    private static void a(ReportItem reportItem, long j3, boolean z16) {
        if ((j3 >= reportItem.b() || z16) && !reportItem.c()) {
            HashMap hashMap = new HashMap();
            String a16 = reportItem.a();
            reportItem.a(true);
            e eVar = new e();
            eVar.a(a16);
            eVar.a(hashMap);
            Log.d(f61668a, "onExposed! API " + eVar.a());
            PingService.getInstance().doPing(eVar);
        }
    }

    private static void b(String str) {
        a((Throwable) null, str);
    }

    public static void a(AdMonitor adMonitor, AdItem adItem) {
        if (adMonitor == null || adItem == null || adItem.getReportItem() == null) {
            return;
        }
        ReportItem reportItem = adItem.getReportItem();
        e eVar = new e();
        eVar.i();
        eVar.a(reportItem.a());
        eVar.a(a(adMonitor, adItem.getLcount()));
        eVar.l();
        eVar.d(adMonitor.getRequestId());
        PingService.getInstance().doPing(eVar);
        a(adItem, 0L, true);
        Log.d(f61668a, "doEmptyPing: " + reportItem.a());
    }

    private static boolean b() {
        return true;
    }

    private static void a(AdMonitor adMonitor, AdItem adItem, long j3, ReportItem reportItem) {
        if (adMonitor == null) {
            return;
        }
        reportItem.a(true);
        e eVar = new e();
        eVar.i();
        Map a16 = a(adMonitor, adItem.getLcount());
        a16.put("t", String.valueOf(j3));
        eVar.a(reportItem.a());
        eVar.a(a16);
        eVar.l();
        eVar.d(adMonitor.getRequestId());
        PingService.getInstance().doPing(eVar);
    }

    public static void a(AdMonitor adMonitor, AdItem adItem, long j3, boolean z16, boolean z17) {
        if (adItem == null) {
            Log.i(f61668a, "handlePing adItem == null");
            return;
        }
        ReportItem reportItem = adItem.getReportItem();
        if ((j3 >= reportItem.b() || z16 || z17) && !reportItem.c()) {
            if (z17 && j3 < reportItem.b()) {
                j3 = reportItem.b();
            }
            Log.d(f61668a, "doInnerPing:" + adItem);
            if (adMonitor != null) {
                reportItem.a(true);
                e eVar = new e();
                eVar.i();
                Map a16 = a(adMonitor, adItem.getLcount());
                a16.put("t", String.valueOf(j3));
                eVar.a(reportItem.a());
                eVar.a(a16);
                eVar.l();
                eVar.d(adMonitor.getRequestId());
                PingService.getInstance().doPing(eVar);
            }
        }
        a(adItem, j3, z17);
    }

    private static void a(String str) {
        if (Utils.isHttpUrl(str)) {
            e eVar = new e();
            eVar.a(str);
            PingService.getInstance().doPing(eVar);
        }
    }

    public static void a(Throwable th5, String str) {
        String str2;
        String str3;
        String str4;
        try {
            JSONObject jSONObject = new JSONObject();
            str3 = "";
            if (th5 != null) {
                jSONObject.put("ex_name", th5.getClass().getName());
                str4 = th5.getCause() != null ? th5.getCause().toString() : "";
                str3 = th5.getMessage() != null ? th5.getMessage() : "";
                StackTraceElement[] stackTrace = th5.getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
                    JSONArray jSONArray = new JSONArray();
                    int i3 = 0;
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        if (stackTraceElement != null) {
                            jSONArray.put(i3, stackTraceElement.toString());
                            i3++;
                        }
                    }
                    jSONObject.put("ex_callStackSymbols", jSONArray);
                }
            } else {
                str4 = "";
            }
            if (!TextUtils.isEmpty(str)) {
                str3 = String.valueOf(str3) + " " + str;
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("ex_reason", str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("ex_msg", str3);
            }
            jSONObject.put(AdParam.MACADDRESS, AdMonitor.getMac());
            jSONObject.put("uin", AdMonitor.getUin());
            jSONObject.put("imei", AdMonitor.getImei());
            jSONObject.put("appname", SystemUtil.getApkName());
            jSONObject.put(AdParam.PF, QAdConfigDefine$VersionDefine.K_QAD_PF);
            str2 = jSONObject.toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        e eVar = new e();
        eVar.a(com.tencent.ads.service.a.a().c());
        eVar.b(str2);
        PingService.getInstance().doPing(eVar);
    }

    public static void a(ReportClickItem[] reportClickItemArr) {
        String c16;
        e eVar;
        if (reportClickItemArr == null || reportClickItemArr.length == 0) {
            return;
        }
        for (ReportClickItem reportClickItem : reportClickItemArr) {
            if (reportClickItem != null && reportClickItem.a() == 1) {
                if (reportClickItem.b() == 1) {
                    Log.d(f61668a, "doClickPing API: " + reportClickItem.c());
                    c16 = reportClickItem.c();
                    if (Utils.isHttpUrl(c16)) {
                        eVar = new e();
                        eVar.a(c16);
                        PingService.getInstance().doPing(eVar);
                    }
                } else if (a()) {
                    Log.d(f61668a, "doClickPing SDK: " + reportClickItem.c());
                    c16 = reportClickItem.c();
                    eVar = new e();
                    eVar.a(c16);
                    PingService.getInstance().doPing(eVar);
                }
            }
        }
    }

    private static boolean a() {
        return com.tencent.ads.service.a.a().b() && f61669b;
    }
}
