package com.tencent.luggage.wxa.he;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 181;
    private static final String NAME = "closeBLEConnection";

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.he.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6262a implements com.tencent.luggage.wxa.ne.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127033a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f127034b;

        public C6262a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f127033a = dVar;
            this.f127034b = i3;
        }

        @Override // com.tencent.luggage.wxa.ne.b
        public void a(com.tencent.luggage.wxa.ne.k kVar) {
            if (kVar.f135767a != 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(kVar.f135767a));
                this.f127033a.a(this.f127034b, a.this.makeReturnJson(kVar.f135768b, kVar.f135769c, hashMap));
                com.tencent.luggage.wxa.ge.f.a(93);
                return;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 0);
            this.f127033a.a(this.f127034b, a.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap2));
            com.tencent.luggage.wxa.ge.f.a(92);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.ge.f.a(91);
        if (jSONObject == null) {
            w.b("MicroMsg.JsApiCloseBLEConnection", "JsApiCloseBLEConnection data is null");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10013);
            dVar.a(i3, makeReturnJson("fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k, hashMap));
            com.tencent.luggage.wxa.ge.f.a(93, 94);
            return;
        }
        w.d("MicroMsg.JsApiCloseBLEConnection", "appId:%s closeBLEConnection data %s", dVar.getAppId(), jSONObject.toString());
        com.tencent.luggage.wxa.ge.b b16 = com.tencent.luggage.wxa.ge.a.b(dVar.getAppId());
        if (b16 == null) {
            w.b("MicroMsg.JsApiCloseBLEConnection", "bleWorker is null, may not open ble");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10000);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.f121225a, hashMap2));
            com.tencent.luggage.wxa.ge.f.a(93, 96);
            return;
        }
        if (!b16.e()) {
            w.b("MicroMsg.JsApiCloseBLEConnection", "adapter is null or not enabled!");
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errCode", 10001);
            dVar.a(i3, makeReturnJson("fail:not available", com.tencent.luggage.wxa.af.b.f121227b, hashMap3));
            com.tencent.luggage.wxa.ge.f.a(93, 98);
            return;
        }
        String optString = jSONObject.optString(Constants.SP_DEVICE_ID);
        boolean optBoolean = jSONObject.optBoolean("debug", false);
        boolean optBoolean2 = jSONObject.optBoolean("mainThread", true);
        com.tencent.luggage.wxa.le.a aVar = new com.tencent.luggage.wxa.le.a();
        aVar.f135715f = optBoolean;
        aVar.f135716g = optBoolean2;
        b16.a(optString, aVar, new C6262a(dVar, i3));
    }
}
