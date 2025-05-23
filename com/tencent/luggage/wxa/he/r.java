package com.tencent.luggage.wxa.he;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class r extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 184;
    private static final String NAME = "writeBLECharacteristicValue";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.ne.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127091a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f127092b;

        public a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f127091a = dVar;
            this.f127092b = i3;
        }

        @Override // com.tencent.luggage.wxa.ne.b
        public void a(com.tencent.luggage.wxa.ne.k kVar) {
            if (kVar.f135767a != 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(kVar.f135767a));
                this.f127091a.a(this.f127092b, r.this.makeReturnJson(kVar.f135768b, kVar.f135769c, hashMap));
                com.tencent.luggage.wxa.ge.f.a(58);
                return;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 0);
            this.f127091a.a(this.f127092b, r.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap2));
            com.tencent.luggage.wxa.ge.f.a(58);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        Integer valueOf;
        com.tencent.luggage.wxa.ge.f.a(56);
        if (jSONObject == null) {
            w.b("MicroMsg.JsApiWriteBLECharacteristicValue", "JsApiWriteBLECharacteristicValue data is null");
            dVar.a(i3, makeReturnJson("fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k));
            com.tencent.luggage.wxa.ge.f.a(58, 59);
            return;
        }
        w.d("MicroMsg.JsApiWriteBLECharacteristicValue", "appId:%s writeBLECharacteristicValue data %s", dVar.getAppId(), jSONObject.toString());
        com.tencent.luggage.wxa.ge.b b16 = com.tencent.luggage.wxa.ge.a.b(dVar.getAppId());
        if (b16 == null) {
            w.b("MicroMsg.JsApiWriteBLECharacteristicValue", "bleWorker is null, may not open ble");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10000);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.f121225a, hashMap));
            com.tencent.luggage.wxa.ge.f.a(58, 61);
            return;
        }
        if (!b16.e()) {
            w.b("MicroMsg.JsApiWriteBLECharacteristicValue", "adapter is null or not enabled!");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10001);
            dVar.a(i3, makeReturnJson("fail:not available", com.tencent.luggage.wxa.af.b.f121227b, hashMap2));
            com.tencent.luggage.wxa.ge.f.a(58, 63);
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
            Integer num = valueOf;
            String optString4 = jSONObject.optString("value");
            boolean optBoolean = jSONObject.optBoolean("debug", false);
            boolean optBoolean2 = jSONObject.optBoolean("mainThread", false);
            com.tencent.luggage.wxa.le.j jVar = new com.tencent.luggage.wxa.le.j(optString2, optString3, num, com.tencent.luggage.wxa.le.j.a(jSONObject), optString4);
            jVar.f135715f = optBoolean;
            jVar.f135716g = optBoolean2;
            b16.a(optString, jVar, new a(dVar, i3));
        }
        valueOf = null;
        Integer num2 = valueOf;
        String optString42 = jSONObject.optString("value");
        boolean optBoolean3 = jSONObject.optBoolean("debug", false);
        boolean optBoolean22 = jSONObject.optBoolean("mainThread", false);
        com.tencent.luggage.wxa.le.j jVar2 = new com.tencent.luggage.wxa.le.j(optString2, optString3, num2, com.tencent.luggage.wxa.le.j.a(jSONObject), optString42);
        jVar2.f135715f = optBoolean3;
        jVar2.f135716g = optBoolean22;
        b16.a(optString, jVar2, new a(dVar, i3));
    }
}
