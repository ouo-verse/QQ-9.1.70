package com.tencent.luggage.wxa.he;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 186;
    private static final String NAME = "notifyBLECharacteristicValueChanged";

    /* renamed from: a, reason: collision with root package name */
    public static String f127058a = "notification";

    /* renamed from: b, reason: collision with root package name */
    public static String f127059b = "indication";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.ne.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127060a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f127061b;

        public a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f127060a = dVar;
            this.f127061b = i3;
        }

        @Override // com.tencent.luggage.wxa.ne.b
        public void a(com.tencent.luggage.wxa.ne.k kVar) {
            if (kVar.f135767a != 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(kVar.f135767a));
                this.f127060a.a(this.f127061b, l.this.makeReturnJson(kVar.f135768b, kVar.f135769c, hashMap));
                com.tencent.luggage.wxa.ge.f.a(43);
                return;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 0);
            this.f127060a.a(this.f127061b, l.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap2));
            com.tencent.luggage.wxa.ge.f.a(42);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.ne.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f127063a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127064b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f127065c;

        public b(String str, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f127063a = str;
            this.f127064b = dVar;
            this.f127065c = i3;
        }

        @Override // com.tencent.luggage.wxa.ne.b
        public void a(com.tencent.luggage.wxa.ne.k kVar) {
            w.d("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged result:%s", this.f127063a, kVar);
            if (kVar.f135767a != 0) {
                new HashMap().put("errCode", Integer.valueOf(kVar.f135767a));
                this.f127064b.a(this.f127065c, l.this.makeReturnJson(kVar.f135768b, kVar.f135769c));
                com.tencent.luggage.wxa.ge.f.a(43);
            } else {
                new HashMap().put("errCode", 0);
                this.f127064b.a(this.f127065c, l.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
                com.tencent.luggage.wxa.ge.f.a(42);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0121  */
    @Override // com.tencent.luggage.wxa.xd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        Integer valueOf;
        com.tencent.luggage.wxa.ne.c a16;
        boolean z16;
        boolean z17;
        com.tencent.luggage.wxa.ge.f.a(71);
        if (jSONObject == null) {
            w.b("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "JsApiNotifyBLECharacteristicValueChanged data is null");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10013);
            dVar.a(i3, makeReturnJson("fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k, hashMap));
            com.tencent.luggage.wxa.ge.f.a(73, 74);
            return;
        }
        String appId = dVar.getAppId();
        w.d("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged data %s", appId, jSONObject.toString());
        com.tencent.luggage.wxa.ge.b b16 = com.tencent.luggage.wxa.ge.a.b(dVar.getAppId());
        if (b16 == null) {
            w.b("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleWorker is null, may not open ble");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10000);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.f121225a, hashMap2));
            com.tencent.luggage.wxa.ge.f.a(73, 76);
            return;
        }
        if (!b16.e()) {
            w.b("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "adapter is null or not enabled!");
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errCode", 10001);
            dVar.a(i3, makeReturnJson("fail:not available", com.tencent.luggage.wxa.af.b.f121227b, hashMap3));
            com.tencent.luggage.wxa.ge.f.a(73, 79);
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
            boolean optBoolean = jSONObject.optBoolean("state");
            String optString4 = jSONObject.optString("type", f127059b);
            boolean optBoolean2 = jSONObject.optBoolean("debug", false);
            boolean optBoolean3 = jSONObject.optBoolean("mainThread", false);
            a16 = b16.a(optString, optString2, optString3, valueOf);
            if (a16 != null) {
                w.b("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "bleCharacteristic is null, may not connect");
                HashMap hashMap4 = new HashMap();
                hashMap4.put("errCode", 10005);
                dVar.a(i3, makeReturnJson("fail:no characteristic", com.tencent.luggage.wxa.af.b.X, hashMap4));
                com.tencent.luggage.wxa.ge.f.a(73);
                return;
            }
            boolean z18 = a16.f135730e;
            if ((z18 && !a16.f135731f) || (z18 && a16.f135731f && optString4.toLowerCase().equals(f127058a))) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean z19 = a16.f135730e;
            if ((!z19 && a16.f135731f) || (z19 && a16.f135731f && optString4.toLowerCase().equals(f127059b))) {
                z17 = true;
            } else {
                z17 = false;
            }
            w.d("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged isNotify:%b isIndicate:%b", appId, Boolean.valueOf(z16), Boolean.valueOf(z17));
            if (z16) {
                com.tencent.luggage.wxa.le.f fVar = new com.tencent.luggage.wxa.le.f(optString2, optString3, valueOf, optBoolean);
                fVar.f135715f = optBoolean2;
                fVar.f135716g = optBoolean3;
                b16.a(optString, fVar, new a(dVar, i3));
                return;
            }
            if (z17) {
                com.tencent.luggage.wxa.le.e eVar = new com.tencent.luggage.wxa.le.e(optString2, optString3, optBoolean);
                eVar.f135715f = optBoolean2;
                eVar.f135716g = optBoolean3;
                b16.a(optString, eVar, new b(appId, dVar, i3));
                return;
            }
            w.d("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "not support notify and not support indicate...");
            HashMap hashMap5 = new HashMap();
            hashMap5.put("errCode", 10007);
            dVar.a(i3, makeReturnJson("fail:internal error", com.tencent.luggage.wxa.af.b.Z, hashMap5));
            com.tencent.luggage.wxa.ge.f.a(73, 82);
            return;
        }
        valueOf = null;
        boolean optBoolean4 = jSONObject.optBoolean("state");
        String optString42 = jSONObject.optString("type", f127059b);
        boolean optBoolean22 = jSONObject.optBoolean("debug", false);
        boolean optBoolean32 = jSONObject.optBoolean("mainThread", false);
        a16 = b16.a(optString, optString2, optString3, valueOf);
        if (a16 != null) {
        }
    }
}
