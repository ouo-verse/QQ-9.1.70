package com.tencent.luggage.wxa.he;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 182;
    private static final String NAME = "getBLEDeviceServices";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.ne.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f127046a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ge.b f127047b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f127048c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127049d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f127050e;

        public a(String str, com.tencent.luggage.wxa.ge.b bVar, String str2, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f127046a = str;
            this.f127047b = bVar;
            this.f127048c = str2;
            this.f127049d = dVar;
            this.f127050e = i3;
        }

        @Override // com.tencent.luggage.wxa.ne.b
        public void a(com.tencent.luggage.wxa.ne.k kVar) {
            w.d("MicroMsg.JsApiGetBLEDeviceServices", "appId:%s getBLEDeviceServices result:%s", this.f127046a, kVar);
            if (kVar.f135767a == 0) {
                f.this.a(this.f127049d, this.f127050e, this.f127047b.a(this.f127048c, false));
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(kVar.f135767a));
            this.f127049d.a(this.f127050e, f.this.makeReturnJson(kVar.f135768b, kVar.f135769c, hashMap));
            com.tencent.luggage.wxa.ge.f.a(138);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.ge.f.a(136);
        if (jSONObject == null) {
            w.b("MicroMsg.JsApiGetBLEDeviceServices", "getBLEDeviceServices data is null");
            dVar.a(i3, makeReturnJson("fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k));
            com.tencent.luggage.wxa.ge.f.a(138, 139);
            return;
        }
        String appId = dVar.getAppId();
        w.d("MicroMsg.JsApiGetBLEDeviceServices", "appId:%s getBLEDeviceServices data %s", appId, jSONObject.toString());
        com.tencent.luggage.wxa.ge.b b16 = com.tencent.luggage.wxa.ge.a.b(dVar.getAppId());
        if (b16 == null) {
            w.b("MicroMsg.JsApiGetBLEDeviceServices", "bleWorker is null, may not open ble");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10000);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.f121225a, hashMap));
            com.tencent.luggage.wxa.ge.f.a(138, 141);
            return;
        }
        if (!b16.e()) {
            w.b("MicroMsg.JsApiGetBLEDeviceServices", "adapter is null or not enabled!");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10001);
            dVar.a(i3, makeReturnJson("fail:not available", com.tencent.luggage.wxa.af.b.f121227b, hashMap2));
            com.tencent.luggage.wxa.ge.f.a(138, 145);
            return;
        }
        String optString = jSONObject.optString(Constants.SP_DEVICE_ID);
        boolean optBoolean = jSONObject.optBoolean("doDiscover", false);
        w.d("MicroMsg.JsApiGetBLEDeviceServices", "deviceId: %s, doDiscover: %b", optString, Boolean.valueOf(optBoolean));
        if (optBoolean) {
            b16.a(optString, new com.tencent.luggage.wxa.le.c(optString), new a(appId, b16, optString, dVar, i3));
        } else {
            a(dVar, i3, b16.a(optString));
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, int i3, List list) {
        Map<String, ? extends Object> hashMap = new HashMap<>();
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.ne.e eVar = (com.tencent.luggage.wxa.ne.e) it.next();
                if (w0.c(eVar.f135742a)) {
                    w.b("MicroMsg.JsApiGetBLEDeviceServices", "get uuid is null");
                } else {
                    try {
                        jSONArray.mo162put(eVar.a());
                    } catch (JSONException e16) {
                        w.b("MicroMsg.JsApiGetBLEDeviceServices", "JSONException %s", e16.getMessage());
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("services", jSONArray);
                jSONObject.put("errCode", 0);
            } catch (JSONException e17) {
                w.a("MicroMsg.JsApiGetBLEDeviceServices", e17, "", new Object[0]);
            }
            w.d("MicroMsg.JsApiGetBLEDeviceServices", "retJson %s", jSONObject.toString());
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, jSONObject));
            com.tencent.luggage.wxa.ge.f.a(137);
            return;
        }
        w.b("MicroMsg.JsApiGetBLEDeviceServices", "not found services");
        hashMap.put("errCode", 10004);
        dVar.a(i3, makeReturnJson("fail:no service", com.tencent.luggage.wxa.af.b.f121229c, hashMap));
        com.tencent.luggage.wxa.ge.f.a(138, 144);
    }
}
