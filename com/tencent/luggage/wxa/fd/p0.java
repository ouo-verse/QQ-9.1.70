package com.tencent.luggage.wxa.fd;

import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.tn.w0;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public static final p0 f125954a = new p0();

    /* JADX WARN: Removed duplicated region for block: B:5:0x0011 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012 A[Catch: JSONException -> 0x0081, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0081, blocks: (B:17:0x0005, B:7:0x0012), top: B:16:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final n0.g a(String str) {
        boolean z16;
        String str2;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    n0.g gVar = new n0.g();
                    gVar.f125920a = 0;
                    gVar.f125928i = n0.h.a(jSONObject.optString("module_list"));
                    gVar.C = n0.i.a(jSONObject.optString("widget_list"));
                    boolean z17 = !w0.a(gVar.f125928i);
                    gVar.f125929j = z17;
                    if (z17) {
                        str2 = jSONObject.optString("entrance_module");
                    } else {
                        str2 = "";
                    }
                    gVar.f125930k = str2;
                    gVar.f125926g = n0.e.a(gVar.C, jSONObject.optString("separated_plugin_list"), 22);
                    gVar.f125931l = jSONObject.optString("client_js_ext_info");
                    gVar.f125924e = jSONObject.optString("device_orientation");
                    gVar.P = n0.c.a(jSONObject.optJSONArray("chat_tools"));
                    return gVar;
                }
            } catch (JSONException unused) {
                return null;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }
}
