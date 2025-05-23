package com.qq.e.comm.plugin.base.ad.clickcomponent.c;

import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.net.ZipCompress;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.j.e;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.k.z;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {
    public static void a(int i3, ClickInfo clickInfo) {
        a(i3, clickInfo, -1L);
    }

    public static int b(ClickInfo clickInfo) {
        if (clickInfo == null) {
            return -2001;
        }
        if (clickInfo.b() == null) {
            return -2002;
        }
        if (clickInfo.b().a() == null) {
            return -2003;
        }
        if (clickInfo.c() == null) {
            return -2004;
        }
        if (!y.a(clickInfo.j())) {
            return -2005;
        }
        return -1000;
    }

    private static boolean c(ClickInfo clickInfo) {
        if (clickInfo == null || clickInfo.c() == null || TextUtils.isEmpty(clickInfo.c().f38511c) || e.a().a(clickInfo.c().f38511c, "clickEventReport", 0) == 1) {
            return true;
        }
        return false;
    }

    public static void a(int i3, ClickInfo clickInfo, long j3) {
        if (c(clickInfo)) {
            com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
            cVar.a("appID", GDTADManager.getInstance().getAppStatus().getAPPID());
            a(clickInfo, cVar);
            if (j3 != -1) {
                cVar.a("cost_time", Long.valueOf(j3));
            }
            StatTracer.trackEvent(i3, 0, a(clickInfo), cVar);
        }
    }

    public static void a(ClickInfo clickInfo, int i3, String str, int i16) {
        a(clickInfo, i3, str, i16, (String) null);
    }

    public static void a(ClickInfo clickInfo, int i3, String str, int i16, String str2) {
        if (c(clickInfo)) {
            com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
            cVar.a("appID", GDTADManager.getInstance().getAppStatus().getAPPID());
            cVar.a("error_code", Integer.valueOf(i3));
            cVar.a("subErrorCode", Integer.valueOf(i16));
            cVar.a("nodeTag", Integer.valueOf(b.a(str)));
            if (!TextUtils.isEmpty(str2)) {
                cVar.a("msg", ZipCompress.compressByGzipAndBase64(str2));
            }
            a(clickInfo, cVar);
            StatTracer.trackEvent(133005, i3, a(clickInfo), cVar);
        }
    }

    public static void a(int i3, ClickInfo clickInfo, String str, long j3) {
        a(i3, clickInfo, b.a(str), j3);
    }

    public static void a(int i3, ClickInfo clickInfo, int i16, long j3) {
        if (c(clickInfo)) {
            com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
            cVar.a("appID", GDTADManager.getInstance().getAppStatus().getAPPID());
            cVar.a("nodeTag", Integer.valueOf(i16));
            cVar.a("cost_time", Long.valueOf(j3));
            a(clickInfo, cVar);
            StatTracer.trackEvent(i3, 0, a(clickInfo), cVar);
        }
    }

    public static void a(int i3, ClickInfo clickInfo, int i16, int i17) {
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("appID", GDTADManager.getInstance().getAppStatus().getAPPID());
        cVar.a(AdMetricTag.Report.TYPE, Integer.valueOf(i16));
        cVar.a("httpErrorCode", Integer.valueOf(i17));
        a(clickInfo, cVar);
        JSONObject jSONObject = new JSONObject();
        if ((i3 == 4000001 || i3 == 4000003) && clickInfo.m() != 0) {
            try {
                jSONObject.putOpt("cost_time", Long.valueOf(System.currentTimeMillis() - clickInfo.m()));
            } catch (JSONException e16) {
                GDTLogger.d(e16.getMessage());
            }
        }
        StatTracer.trackEvent(i3, i17, z.a(clickInfo, jSONObject), cVar);
    }

    public static void a(int i3, ClickInfo clickInfo, JSONObject jSONObject, long j3, int i16) {
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("appID", GDTADManager.getInstance().getAppStatus().getAPPID());
        cVar.a(AdMetricTag.Report.TYPE, Integer.valueOf(i16));
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if ((i3 == 4000001 || i3 == 4000003) && j3 != 0) {
            try {
                jSONObject.putOpt("cost_time", Long.valueOf(System.currentTimeMillis() - j3));
            } catch (JSONException e16) {
                GDTLogger.d(e16.getMessage());
            }
        }
        StatTracer.trackEvent(i3, 0, z.a(clickInfo, jSONObject), cVar);
    }

    public static com.qq.e.comm.plugin.stat.b a(ClickInfo clickInfo) {
        if (clickInfo == null) {
            return null;
        }
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(clickInfo.c().f38511c);
        bVar.c(clickInfo.e());
        bVar.b(clickInfo.j().optString("cl"));
        bVar.c(clickInfo.j().optInt("producttype"));
        return bVar;
    }

    public static void a(ClickInfo clickInfo, com.qq.e.comm.plugin.stat.c cVar) {
        if (clickInfo != null) {
            cVar.a("chainType", Integer.valueOf(clickInfo.g()));
            if (clickInfo.c() != null) {
                com.qq.e.comm.plugin.base.ad.b bVar = clickInfo.c().f38510b;
                if (bVar == null) {
                    bVar = com.qq.e.comm.plugin.base.ad.b.IDLE_AD;
                }
                cVar.a(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, Integer.valueOf(bVar.b()));
            }
            if (clickInfo.d() != null && y.a(clickInfo.j())) {
                cVar.a("isContract", Integer.valueOf(a.b(clickInfo) ? 1 : 0));
                cVar.a("actionType", Integer.valueOf(a.a(clickInfo)));
            }
            try {
                if (clickInfo.b().a() instanceof View) {
                    cVar.a("viewId", Integer.valueOf(((View) clickInfo.b().a()).getId()));
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }
}
