package com.tencent.luggage.wxa.he;

import androidx.core.app.NotificationCompat;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 180;
    private static final String NAME = "createBLEConnection";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.ne.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f127036a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127037b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f127038c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f127039d;

        public a(String str, com.tencent.luggage.wxa.xd.d dVar, int i3, String str2) {
            this.f127036a = str;
            this.f127037b = dVar;
            this.f127038c = i3;
            this.f127039d = str2;
        }

        @Override // com.tencent.luggage.wxa.ne.b
        public void a(com.tencent.luggage.wxa.ne.k kVar) {
            w.d("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection result:%s", this.f127036a, kVar);
            if (kVar.f135767a != 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(kVar.f135767a));
                this.f127037b.a(this.f127038c, c.this.makeReturnJson(kVar.f135768b, kVar.f135769c, hashMap));
                c.this.a(this.f127037b, this.f127039d, false);
                com.tencent.luggage.wxa.ge.f.a(27);
                return;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 0);
            this.f127037b.a(this.f127038c, c.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a, hashMap2));
            c.this.a(this.f127037b, this.f127039d, true);
            com.tencent.luggage.wxa.ge.f.a(26);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.ge.f.a(25);
        if (jSONObject == null) {
            w.b("MicroMsg.JsApiCreateBLEConnection", "createBLEConnection data is null, err");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 10013);
            dVar.a(i3, makeReturnJson("fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k, hashMap));
            return;
        }
        String appId = dVar.getAppId();
        w.d("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection data %s", appId, jSONObject.toString());
        com.tencent.luggage.wxa.ge.b b16 = com.tencent.luggage.wxa.ge.a.b(dVar.getAppId());
        if (b16 == null) {
            w.b("MicroMsg.JsApiCreateBLEConnection", "bleWorker is null, may not open ble");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", 10000);
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.f121225a, hashMap2));
            com.tencent.luggage.wxa.ge.f.a(27, 30);
            return;
        }
        if (!b16.e()) {
            w.b("MicroMsg.JsApiCreateBLEConnection", "bleWorker is disable, may not open ble");
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errCode", 10001);
            dVar.a(i3, makeReturnJson("fail:not available", com.tencent.luggage.wxa.af.b.f121227b, hashMap3));
            com.tencent.luggage.wxa.ge.f.a(27, 32);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("debug", false);
        boolean optBoolean2 = jSONObject.optBoolean("mainThread", true);
        boolean optBoolean3 = jSONObject.optBoolean("autoConnect", false);
        String optString = jSONObject.optString(NotificationCompat.CATEGORY_TRANSPORT, "LE");
        long optLong = jSONObject.optLong("discoverDelay", 0L);
        String optString2 = jSONObject.optString("connectionPriority", null);
        String optString3 = jSONObject.optString(Constants.SP_DEVICE_ID);
        boolean optBoolean4 = jSONObject.optBoolean("doDiscover", true);
        w.d("MicroMsg.JsApiCreateBLEConnection", "deviceId: %s, doDiscover: %b", optString3, Boolean.valueOf(optBoolean4));
        com.tencent.luggage.wxa.le.b bVar = new com.tencent.luggage.wxa.le.b(optString3);
        bVar.f135715f = optBoolean;
        bVar.f135716g = optBoolean2;
        bVar.f133301o = optBoolean3;
        bVar.f133302p = optString;
        bVar.f133303q = optLong;
        bVar.f133304r = optString2;
        bVar.f133305s = optBoolean4;
        b16.a(optString3, bVar, new a(appId, dVar, i3, optString3));
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar, String str, boolean z16) {
    }
}
