package com.tencent.luggage.wxa.he;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class o extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 738;

    @NotNull
    private static final String NAME = "setBLEMTU";

    /* renamed from: a, reason: collision with root package name */
    public static final a f127080a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements com.tencent.luggage.wxa.ne.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f127081a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f127082b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f127083c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127084d;

        public b(String str, o oVar, int i3, com.tencent.luggage.wxa.xd.d dVar) {
            this.f127081a = str;
            this.f127082b = oVar;
            this.f127083c = i3;
            this.f127084d = dVar;
        }

        @Override // com.tencent.luggage.wxa.ne.b
        public final void a(com.tencent.luggage.wxa.ne.k kVar) {
            Integer num;
            HashMap hashMapOf;
            String makeReturnJson;
            Map<String, ? extends Object> mutableMapOf;
            HashMap hashMapOf2;
            w.a("MicroMsg.JsApiSetBLEMtu", "invoke: appid %s setMtuSize result = %s", this.f127081a, kVar);
            Object obj = kVar.f135770d;
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            int i3 = kVar.f135767a;
            if (i3 == 0) {
                if (num != null) {
                    o oVar = this.f127082b;
                    int i16 = this.f127083c;
                    com.tencent.luggage.wxa.xd.d dVar = this.f127084d;
                    hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("mtu", num));
                    com.tencent.luggage.wxa.pe.b.a(oVar, i16, dVar, hashMapOf2);
                    return;
                }
                com.tencent.luggage.wxa.pe.b.a(this.f127082b, this.f127083c, this.f127084d, (HashMap) null, 4, (Object) null);
                return;
            }
            if (num != null) {
                o oVar2 = this.f127082b;
                String str = kVar.f135768b;
                com.tencent.luggage.wxa.af.c cVar = kVar.f135769c;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("errCode", Integer.valueOf(i3)));
                makeReturnJson = oVar2.makeReturnJson(str, cVar, mutableMapOf);
            } else {
                o oVar3 = this.f127082b;
                String str2 = kVar.f135768b;
                com.tencent.luggage.wxa.af.c cVar2 = kVar.f135769c;
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", Integer.valueOf(i3)), TuplesKt.to("mtu", num));
                makeReturnJson = oVar3.makeReturnJson(str2, cVar2, hashMapOf);
            }
            this.f127084d.a(this.f127083c, makeReturnJson);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d service, JSONObject jSONObject, int i3) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (jSONObject != null && jSONObject.has(Constants.SP_DEVICE_ID) && jSONObject.has("mtu")) {
            String appId = service.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "service.appId");
            w.d("MicroMsg.JsApiSetBLEMtu", "appId:%s setBLEMTU data %s", appId, jSONObject.toString());
            com.tencent.luggage.wxa.ge.b b16 = com.tencent.luggage.wxa.ge.a.b(service.getAppId());
            if (b16 == null) {
                w.b("MicroMsg.JsApiSetBLEMtu", "bleWorker is null, may not open ble");
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", 10000);
                service.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.b.f121225a, hashMap));
                com.tencent.luggage.wxa.ge.f.a(27, 30);
                return;
            }
            if (!b16.e()) {
                w.b("MicroMsg.JsApiSetBLEMtu", "bleWorker is disable, may not open ble");
                HashMap hashMap2 = new HashMap();
                hashMap2.put("errCode", 10001);
                service.a(i3, makeReturnJson("fail:not available", com.tencent.luggage.wxa.af.b.f121227b, hashMap2));
                com.tencent.luggage.wxa.ge.f.a(27, 32);
                return;
            }
            String optString = jSONObject.optString(Constants.SP_DEVICE_ID);
            b16.a(optString, new com.tencent.luggage.wxa.le.i(Integer.valueOf(jSONObject.optInt("mtu")), optString), new b(appId, this, i3, service));
            return;
        }
        w.b("MicroMsg.JsApiSetBLEMtu", "setBLEMTU data is null, err");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("errCode", 10013);
        service.a(i3, makeReturnJson("fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k, hashMap3));
    }
}
