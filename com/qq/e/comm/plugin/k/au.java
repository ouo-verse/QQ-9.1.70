package com.qq.e.comm.plugin.k;

import android.text.TextUtils;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.net.ZipCompress;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class au {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f39626a = com.qq.e.comm.plugin.j.c.a("monitor_and_report", 1, 1);

    /* renamed from: b, reason: collision with root package name */
    private static String f39627b;

    private static com.qq.e.comm.plugin.stat.b a(String str, String str2) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        if (!TextUtils.isEmpty(str)) {
            bVar.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return bVar;
        }
        try {
            return a(str, new JSONObject(str2));
        } catch (Exception e16) {
            e16.printStackTrace();
            return bVar;
        }
    }

    private static boolean b() {
        if (new Random().nextInt(10000) < com.qq.e.comm.plugin.j.c.a("reportHardWareRate", 10)) {
            return true;
        }
        return false;
    }

    private static com.qq.e.comm.plugin.stat.b a(String str, JSONObject jSONObject) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        if (!TextUtils.isEmpty(str)) {
            bVar.a(str);
        }
        if (jSONObject != null) {
            bVar.b(jSONObject.optString("cl"));
            bVar.c(jSONObject.optString("traceid"));
            bVar.a(jSONObject.optInt("ad_first_category"));
            bVar.b(jSONObject.optInt("advertiser_id"));
            bVar.c(jSONObject.optInt("producttype"));
            bVar.d(jSONObject.optInt("inner_adshowtype"));
            bVar.d(f39627b);
        }
        return bVar;
    }

    public static void a(int i3, int i16, String str, String str2) {
        StatTracer.trackEvent(i3, i16, a(str, str2));
    }

    public static void a(Response response, com.qq.e.comm.plugin.base.ad.model.b bVar, long j3, int i3, String str, int i16, String str2) {
        a(bVar, j3, i16, response != null ? response.getStatusCode() : -1, str2, i3, str);
    }

    public static void a(int i3, int i16, String str, int i17) {
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        cVar.a("cost_time", Integer.valueOf(i17));
        StatTracer.trackEvent(i3, i16, bVar, cVar);
    }

    public static void a(int i3, String str, com.qq.e.comm.plugin.stat.c cVar) {
        try {
            StatTracer.trackEvent(i3, 0, a(str, ""), cVar);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void a(int i3, String str, boolean z16, LoadAdParams loadAdParams, boolean z17, int i16) {
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("splash_fetchDelay", Integer.valueOf(i16));
        cVar.a("splash_hotlaunch", Integer.valueOf(z16 ? 1 : 0));
        if (loadAdParams != null) {
            cVar.a("splash_blockEffect", Integer.valueOf(loadAdParams.getBlockEffectValue()));
            cVar.a("splash_firstPlayOneshotAdDisable", Integer.valueOf(loadAdParams.getFilterOneShotFlag() ? 1 : 0));
        }
        cVar.a("splash_customWebview", Integer.valueOf(GlobalSetting.getCustomLandingPageListener() != null ? 1 : 0));
        cVar.a("splash_customPlayer", Integer.valueOf(!z17 ? 1 : 0));
        StatTracer.trackEvent(i3, 0, a(str, ""), cVar);
    }

    public static void a(com.qq.e.comm.plugin.base.ad.model.b bVar) {
        if (f39626a) {
            try {
                x xVar = new x();
                if (!TextUtils.isEmpty(bVar.g())) {
                    xVar.a("pid", bVar.g());
                }
                x xVar2 = new x();
                xVar2.a(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, bVar.m());
                a(1000, xVar.a(), xVar2.a());
            } catch (Throwable th5) {
                GDTLogger.e(" reportAdReqStart error :", th5);
            }
        }
    }

    public static void a(com.qq.e.comm.plugin.base.ad.model.b bVar, long j3, boolean z16, int i3, int i16, String str, int i17) {
        if (f39626a) {
            try {
                x xVar = new x();
                if (bVar != null && !TextUtils.isEmpty(bVar.g())) {
                    xVar.a("pid", bVar.g());
                }
                JSONObject jSONObject = new JSONObject();
                int i18 = z16 ? 1001 : 1002;
                jSONObject.put("cost_time", j3);
                if (bVar != null) {
                    jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, bVar.m());
                }
                if (i3 != Integer.MIN_VALUE) {
                    jSONObject.put("error_code", i3);
                }
                if (i16 != Integer.MIN_VALUE) {
                    jSONObject.put("httpErrorCode", i16);
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("internalErrorMessage", str);
                }
                if (i17 != Integer.MIN_VALUE) {
                    jSONObject.put("retCode", i17);
                }
                a(i18, xVar.a(), jSONObject);
            } catch (Throwable th5) {
                GDTLogger.e(" reportAdReqResult error :", th5);
            }
        }
    }

    public static void a(com.qq.e.comm.plugin.base.ad.model.b bVar, long j3, int i3, int i16, String str, int i17, String str2) {
        a(bVar != null ? bVar.g() : null, bVar != null ? bVar.m() : 0, j3, i3, i16, str, i17, str2);
    }

    public static void a(String str, int i3, long j3, int i16, int i17, String str2, int i18, String str3) {
        if (f39626a) {
            try {
                x xVar = new x();
                if (!TextUtils.isEmpty(str)) {
                    xVar.a("pid", str);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cost_time", j3);
                if (i3 != 0) {
                    jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, i3);
                }
                if (i16 != Integer.MIN_VALUE) {
                    jSONObject.put("error_code", i16);
                }
                if (i17 != Integer.MIN_VALUE) {
                    jSONObject.put("httpErrorCode", i17);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("internalErrorMessage", str2);
                }
                if (i18 != Integer.MIN_VALUE) {
                    jSONObject.put("retCode", i18);
                }
                if (!TextUtils.isEmpty(str3) && SDKStatus.getSDKVersionCode() >= 120) {
                    jSONObject.put("ej", ZipCompress.compressByGzipAndBase64(str3));
                }
                a(1002, xVar.a(), jSONObject);
            } catch (Throwable th5) {
                GDTLogger.e(" reportAdReqResultWithJsonException error :", th5);
            }
        }
    }

    public static void a(com.qq.e.comm.plugin.base.ad.model.a aVar, long j3, int i3, int i16) {
        if (f39626a) {
            try {
                x xVar = new x();
                if (!TextUtils.isEmpty(aVar.f38906b)) {
                    xVar.a("pid", aVar.f38906b);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cost_time", j3);
                jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, aVar.f38907c.b());
                if (i3 != Integer.MIN_VALUE) {
                    jSONObject.put("error_code", i3);
                }
                if (i16 != Integer.MIN_VALUE) {
                    jSONObject.put("httpErrorCode", i16);
                }
                a(1007, xVar.a(), jSONObject);
            } catch (Throwable th5) {
                GDTLogger.e(" reportExposure error :", th5);
            }
        }
    }

    private static void a(int i3, JSONObject jSONObject, JSONObject jSONObject2) {
        StatTracer.trackEvent(i3, jSONObject, jSONObject2);
    }

    public static void a(int i3) {
        StatTracer.trackEvent(i3, 0, new com.qq.e.comm.plugin.stat.b(), new com.qq.e.comm.plugin.stat.c());
    }

    public static void a(int i3, int i16, com.qq.e.comm.plugin.stat.b bVar, com.qq.e.comm.plugin.stat.c cVar, int i17) {
        if (cVar != null && i17 != 0) {
            cVar.a("error_code", Integer.valueOf(i17));
        }
        GDTLogger.d("TangramReportService trackEvent eventId:" + i3 + "  statusCode:" + i17);
        StatTracer.trackEvent(i3, i16, bVar, cVar);
    }

    public static void a() {
        if (b()) {
            JSONObject a16 = y.a();
            y.a(a16, "mem_status", ai.i());
            StatTracer.trackEvent(1330000, y.a(), a16);
        }
    }

    public static void a(int i3, int i16) {
        if (com.qq.e.comm.plugin.j.c.a("needReportSensorStatus", 0, 0)) {
            return;
        }
        GDTLogger.d("[reportSensorStatus] report sensor status ");
        JSONObject a16 = y.a();
        y.a(a16, "s_status", v.b(i16));
        StatTracer.trackEvent(1330001, i3, (com.qq.e.comm.plugin.stat.b) null, new com.qq.e.comm.plugin.stat.c(a16));
    }
}
