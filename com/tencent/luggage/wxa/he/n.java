package com.tencent.luggage.wxa.he;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 185;
    private static final String NAME = "readBLECharacteristicValue";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.ne.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127077a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f127078b;

        public a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f127077a = dVar;
            this.f127078b = i3;
        }

        @Override // com.tencent.luggage.wxa.ne.b
        public void a(com.tencent.luggage.wxa.ne.k kVar) {
            if (kVar.f135767a != 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(kVar.f135767a));
                this.f127077a.a(this.f127078b, n.this.makeReturnJson(kVar.f135768b, kVar.f135769c, hashMap));
                com.tencent.luggage.wxa.ge.f.a(43);
                return;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 0);
            this.f127077a.a(this.f127078b, n.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap2));
            com.tencent.luggage.wxa.ge.f.a(42);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        Integer valueOf;
        com.tencent.luggage.wxa.ge.f.a(41);
        if (jSONObject == null) {
            w.b("MicroMsg.JsApiReadBLECharacteristicValue", "JsApiReadBLECharacteristicValue data is null");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10013);
            dVar.a(i3, makeReturnJson("fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k, hashMap));
            com.tencent.luggage.wxa.ge.f.a(43, 44);
            return;
        }
        w.d("MicroMsg.JsApiReadBLECharacteristicValue", "appId:%s readBLECharacteristicValue data %s", dVar.getAppId(), jSONObject.toString());
        com.tencent.luggage.wxa.ge.b b16 = com.tencent.luggage.wxa.ge.a.b(dVar.getAppId());
        if (b16 == null) {
            w.b("MicroMsg.JsApiReadBLECharacteristicValue", "bleWorker is null, may not open ble");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10000);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.f121225a, hashMap2));
            com.tencent.luggage.wxa.ge.f.a(43, 46);
            return;
        }
        if (!b16.e()) {
            w.b("MicroMsg.JsApiReadBLECharacteristicValue", "adapter is null or not enabled!");
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errCode", 10001);
            dVar.a(i3, makeReturnJson("fail:not available", com.tencent.luggage.wxa.af.b.f121227b, hashMap3));
            com.tencent.luggage.wxa.ge.f.a(43, 48);
            return;
        }
        String optString = jSONObject.optString(Constants.SP_DEVICE_ID);
        String optString2 = jSONObject.optString("serviceId");
        String optString3 = jSONObject.optString("characteristicId");
        if (jSONObject.has("handle")) {
            try {
                valueOf = Integer.valueOf(jSONObject.getInt("handle"));
            } catch (Exception unused) {
            }
            boolean optBoolean = jSONObject.optBoolean("debug", false);
            boolean optBoolean2 = jSONObject.optBoolean("mainThread", false);
            com.tencent.luggage.wxa.le.h hVar = new com.tencent.luggage.wxa.le.h(optString2, optString3, valueOf);
            hVar.f135715f = optBoolean;
            hVar.f135716g = optBoolean2;
            b16.a(optString, hVar, new a(dVar, i3));
        }
        valueOf = null;
        boolean optBoolean3 = jSONObject.optBoolean("debug", false);
        boolean optBoolean22 = jSONObject.optBoolean("mainThread", false);
        com.tencent.luggage.wxa.le.h hVar2 = new com.tencent.luggage.wxa.le.h(optString2, optString3, valueOf);
        hVar2.f135715f = optBoolean3;
        hVar2.f135716g = optBoolean22;
        b16.a(optString, hVar2, new a(dVar, i3));
    }
}
