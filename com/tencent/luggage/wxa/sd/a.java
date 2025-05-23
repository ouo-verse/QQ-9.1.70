package com.tencent.luggage.wxa.sd;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.z7.f;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static void a(boolean z16, JSONObject jSONObject) {
        a(jSONObject, "abtestXWebCameraEnable", Boolean.valueOf(z16));
    }

    public static void b(boolean z16, JSONObject jSONObject) {
        a(jSONObject, "supportXWebTouch", Boolean.valueOf(z16));
    }

    public static void c(boolean z16, JSONObject jSONObject) {
        a(jSONObject, "supportXWebTextarea", Boolean.valueOf(z16));
    }

    public static void d(boolean z16, JSONObject jSONObject) {
        a(jSONObject, "useXWebVideo", Boolean.valueOf(z16));
        a(jSONObject, "XWebVideoMinVersion", Integer.valueOf(f.b()));
    }

    public static void e(boolean z16, JSONObject jSONObject) {
        a(jSONObject, "useXWebCamera", Boolean.valueOf(z16));
    }

    public static void f(boolean z16, JSONObject jSONObject) {
        a(jSONObject, "useXWebLive", Boolean.valueOf(z16));
    }

    public static void g(boolean z16, JSONObject jSONObject) {
        a(jSONObject, "useXWebMap", Boolean.valueOf(z16));
    }

    public static void h(boolean z16, JSONObject jSONObject) {
        a(jSONObject, "useXWebTextarea", Boolean.valueOf(z16));
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception e16) {
            w.b("MicroMsg.SameLayer.AppBrandExtendPluginUtil", "build json object fail", e16);
        }
    }
}
