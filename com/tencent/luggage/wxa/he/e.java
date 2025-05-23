package com.tencent.luggage.wxa.he;

import com.tencent.bugly.common.constants.Constants;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 777;

    @NotNull
    public static final String NAME = "getBLEDeviceRSSI";

    /* renamed from: a, reason: collision with root package name */
    public static final a f127041a = new a(null);

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
        public final /* synthetic */ String f127042a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f127043b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f127044c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127045d;

        public b(String str, e eVar, int i3, com.tencent.luggage.wxa.xd.d dVar) {
            this.f127042a = str;
            this.f127043b = eVar;
            this.f127044c = i3;
            this.f127045d = dVar;
        }

        @Override // com.tencent.luggage.wxa.ne.b
        public final void a(com.tencent.luggage.wxa.ne.k kVar) {
            Map<String, ? extends Object> mutableMapOf;
            Integer num;
            HashMap hashMapOf;
            Map<String, ? extends Object> mutableMapOf2;
            com.tencent.luggage.wxa.pe.a.c("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "appId: " + this.f127042a + ", result: " + kVar, new Object[0]);
            int i3 = kVar.f135767a;
            if (i3 == 0) {
                Object obj = kVar.f135770d;
                if (obj instanceof Integer) {
                    num = (Integer) obj;
                } else {
                    num = null;
                }
                if (num == null) {
                    e eVar = this.f127043b;
                    com.tencent.luggage.wxa.af.c cVar = com.tencent.luggage.wxa.af.b.V;
                    mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("errCode", -1));
                    this.f127045d.a(this.f127044c, eVar.makeReturnJson("fail:internal error", cVar, mutableMapOf2));
                    return;
                }
                e eVar2 = this.f127043b;
                int i16 = this.f127044c;
                com.tencent.luggage.wxa.xd.d dVar = this.f127045d;
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("RSSI", num));
                com.tencent.luggage.wxa.pe.b.a(eVar2, i16, dVar, hashMapOf);
                return;
            }
            e eVar3 = this.f127043b;
            String str = kVar.f135768b;
            com.tencent.luggage.wxa.af.c cVar2 = kVar.f135769c;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("errCode", Integer.valueOf(i3)));
            this.f127045d.a(this.f127044c, eVar3.makeReturnJson(str, cVar2, mutableMapOf));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        Map<String, ? extends Object> mutableMapOf;
        Map<String, ? extends Object> mutableMapOf2;
        Map<String, ? extends Object> mutableMapOf3;
        if (dVar == null) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "env is null", new Object[0]);
            return;
        }
        if (jSONObject != null && jSONObject.has(Constants.SP_DEVICE_ID)) {
            String appId = dVar.getAppId();
            com.tencent.luggage.wxa.pe.a.c("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "appId: " + appId + ", data: " + jSONObject, new Object[0]);
            com.tencent.luggage.wxa.ge.b b16 = com.tencent.luggage.wxa.ge.a.b(appId);
            if (b16 == null) {
                com.tencent.luggage.wxa.pe.a.d("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "bleWorker is null", new Object[0]);
                com.tencent.luggage.wxa.af.c cVar = com.tencent.luggage.wxa.af.b.f121225a;
                mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("errCode", 10000));
                dVar.a(i3, makeReturnJson(cVar, mutableMapOf3));
                return;
            }
            String optString = jSONObject.optString(Constants.SP_DEVICE_ID);
            if (optString == null) {
                com.tencent.luggage.wxa.pe.a.d("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "deviceId is null", new Object[0]);
                com.tencent.luggage.wxa.af.c cVar2 = com.tencent.luggage.wxa.af.e.f121315k;
                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("errCode", 10013));
                dVar.a(i3, makeReturnJson("fail:invalid data", cVar2, mutableMapOf2));
                return;
            }
            b16.a(optString, new com.tencent.luggage.wxa.le.d(), new b(appId, this, i3, dVar));
            return;
        }
        com.tencent.luggage.wxa.pe.a.d("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "data is null or do not have key: deviceId", new Object[0]);
        com.tencent.luggage.wxa.af.c cVar3 = com.tencent.luggage.wxa.af.e.f121315k;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("errCode", 10013));
        dVar.a(i3, makeReturnJson("fail:invalid data", cVar3, mutableMapOf));
    }
}
