package com.qq.e.comm.plugin.base.ad.e;

import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.view.FilterEnum;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static void a(String str, com.qq.e.comm.plugin.base.ad.model.f fVar, JSONObject jSONObject) {
        a(326, str, a(jSONObject));
    }

    public static void b(String str, com.qq.e.comm.plugin.base.ad.model.f fVar, JSONObject jSONObject) {
        a(327, str, a(jSONObject));
    }

    public static void c(String str, com.qq.e.comm.plugin.base.ad.model.f fVar, JSONObject jSONObject) {
        a(AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, str, a(jSONObject));
    }

    public static void d(String str, com.qq.e.comm.plugin.base.ad.model.f fVar, JSONObject jSONObject) {
        a(245, str, a(jSONObject));
    }

    public static void e(String str, com.qq.e.comm.plugin.base.ad.model.f fVar, JSONObject jSONObject) {
        a(246, str, a(jSONObject));
    }

    public static void f(String str, com.qq.e.comm.plugin.base.ad.model.f fVar, JSONObject jSONObject) {
        a(247, str, a(jSONObject));
    }

    public static void g(String str, com.qq.e.comm.plugin.base.ad.model.f fVar, JSONObject jSONObject) {
        a(248, str, a(jSONObject));
    }

    public static void h(String str, com.qq.e.comm.plugin.base.ad.model.f fVar, JSONObject jSONObject) {
        a(290, str, a(jSONObject));
    }

    public static void i(String str, com.qq.e.comm.plugin.base.ad.model.f fVar, JSONObject jSONObject) {
        a(291, str, a(jSONObject));
    }

    public static void a(boolean z16, boolean z17, String str, com.qq.e.comm.plugin.base.ad.model.f fVar, JSONObject jSONObject) {
        a(z16 ? z17 ? 266 : 267 : z17 ? FilterEnum.MIC_PTU_BAIXI : 283, str, a(jSONObject));
    }

    public static void a(boolean z16, String str, JSONObject jSONObject) {
        a(z16 ? 320 : 321, str, a(jSONObject));
    }

    private static void a(int i3, String str, String str2) {
        if (StringUtil.isEmpty(str)) {
            GDTLogger.e(String.format("trace report params error. clickId: %s, effectUrl: %s", str, str2));
            return;
        }
        GDTLogger.d("trace type = " + i3);
        if (StringUtil.isEmpty(str2)) {
            return;
        }
        String a16 = com.qq.e.comm.plugin.k.b.a(str2, i3, str);
        if (a16 != null) {
            NetworkClientImpl.getInstance().submit(new PlainRequest(a16, 1, (byte[]) null), 1);
        } else {
            GDTLogger.e("getEffectUrl error. traceReportUrl is null");
        }
    }

    private static String a(JSONObject jSONObject) {
        if (jSONObject == null) {
            GDTLogger.e("getEffectUrlFromAdInfo adInfo is null");
            return null;
        }
        try {
            return jSONObject.optString("effect_url");
        } catch (Throwable th5) {
            GDTLogger.e("getEffectUrlFromAdInfo adInfo optString failed", th5);
            return null;
        }
    }
}
