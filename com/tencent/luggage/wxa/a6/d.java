package com.tencent.luggage.wxa.a6;

import com.tencent.luggage.wxa.fj.b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.fj.a {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements b.a {
        @Override // com.tencent.luggage.wxa.fj.b.a
        public void a(com.tencent.luggage.wxa.ic.g gVar, JSONObject jSONObject) {
            try {
                jSONObject.put("notSupport", false);
                jSONObject.put("switchWebsocket", false);
                jSONObject.put("switchFs", true);
            } catch (JSONException unused) {
            }
        }
    }

    static {
        c();
    }

    public static void c() {
        com.tencent.luggage.wxa.fj.b.a(new a());
    }

    @Override // com.tencent.luggage.wxa.fj.a
    public void a(StringBuffer stringBuffer) {
        super.a(stringBuffer);
        stringBuffer.append(";const _clicfg_android_appbrand_permission_bytes_jsapi_nodejs_impl = true;");
    }
}
