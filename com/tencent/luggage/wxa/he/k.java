package com.tencent.luggage.wxa.he;

import android.util.Base64;
import com.tencent.bugly.common.constants.Constants;
import java.util.Arrays;
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
public final class k extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 815;

    @NotNull
    public static final String NAME = "makeBluetoothPair";

    /* renamed from: a, reason: collision with root package name */
    public static final a f127053a = new a(null);

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
        public final /* synthetic */ String f127054a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f127055b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f127056c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127057d;

        public b(String str, k kVar, int i3, com.tencent.luggage.wxa.xd.d dVar) {
            this.f127054a = str;
            this.f127055b = kVar;
            this.f127056c = i3;
            this.f127057d = dVar;
        }

        @Override // com.tencent.luggage.wxa.ne.b
        public final void a(com.tencent.luggage.wxa.ne.k kVar) {
            Map<String, ? extends Object> mutableMapOf;
            com.tencent.luggage.wxa.pe.a.c("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "appId: " + this.f127054a + ", result: " + kVar, new Object[0]);
            int i3 = kVar.f135767a;
            if (i3 == 0) {
                com.tencent.luggage.wxa.pe.b.a(this.f127055b, this.f127056c, this.f127057d, (HashMap) null, 4, (Object) null);
                return;
            }
            k kVar2 = this.f127055b;
            String str = kVar.f135768b;
            com.tencent.luggage.wxa.af.c cVar = kVar.f135769c;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("errCode", Integer.valueOf(i3)));
            this.f127057d.a(this.f127056c, kVar2.makeReturnJson(str, cVar, mutableMapOf));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        Map<String, ? extends Object> mutableMapOf;
        Map<String, ? extends Object> mutableMapOf2;
        byte[] decode;
        Map<String, ? extends Object> mutableMapOf3;
        Map<String, ? extends Object> mutableMapOf4;
        if (dVar == null) {
            com.tencent.luggage.wxa.pe.a.d("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "env is null", new Object[0]);
            return;
        }
        if (jSONObject != null && jSONObject.has(Constants.SP_DEVICE_ID)) {
            String appId = dVar.getAppId();
            com.tencent.luggage.wxa.pe.a.c("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "appId: " + appId + ", data: " + jSONObject, new Object[0]);
            com.tencent.luggage.wxa.ge.b b16 = com.tencent.luggage.wxa.ge.a.b(appId);
            if (b16 == null) {
                com.tencent.luggage.wxa.pe.a.d("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "bleWorker is null", new Object[0]);
                com.tencent.luggage.wxa.af.c cVar = com.tencent.luggage.wxa.af.b.f121225a;
                mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("errCode", 10000));
                dVar.a(i3, makeReturnJson(cVar, mutableMapOf4));
                return;
            }
            String str = null;
            String optString = jSONObject.optString(Constants.SP_DEVICE_ID, null);
            if (optString == null) {
                com.tencent.luggage.wxa.pe.a.d("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "deviceId is null", new Object[0]);
                com.tencent.luggage.wxa.af.c cVar2 = com.tencent.luggage.wxa.af.e.f121315k;
                mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("errCode", 10013));
                dVar.a(i3, makeReturnJson("fail:invalid data", cVar2, mutableMapOf3));
                return;
            }
            String optString2 = jSONObject.optString("pin", null);
            if (optString2 == null) {
                decode = null;
            } else {
                try {
                    decode = Base64.decode(optString2, 2);
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.pe.a.d("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "decode pin fail since " + e16, new Object[0]);
                    com.tencent.luggage.wxa.af.c cVar3 = com.tencent.luggage.wxa.af.e.f121315k;
                    mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("errCode", 10013));
                    dVar.a(i3, makeReturnJson("fail:invalid data", cVar3, mutableMapOf2));
                    return;
                }
            }
            long optLong = jSONObject.optLong("timeout", 20000L);
            boolean optBoolean = jSONObject.optBoolean("forcePair", false);
            boolean optBoolean2 = jSONObject.optBoolean("useOldImpl", false);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("deviceId: ");
            sb5.append(optString);
            sb5.append(", pin: ");
            if (decode != null) {
                str = Arrays.toString(decode);
                Intrinsics.checkNotNullExpressionValue(str, "toString(this)");
            }
            sb5.append(str);
            sb5.append(", timeoutMs: ");
            sb5.append(optLong);
            sb5.append(", forcePair: ");
            sb5.append(optBoolean);
            sb5.append(", useOldImpl: ");
            sb5.append(optBoolean2);
            com.tencent.luggage.wxa.pe.a.c("MicroMsg.AppBrand.JsApiMakeBluetoothPair", sb5.toString(), new Object[0]);
            b16.a(optString, new com.tencent.luggage.wxa.le.g(optString, decode, optLong, optBoolean, optBoolean2), new b(appId, this, i3, dVar));
            return;
        }
        com.tencent.luggage.wxa.pe.a.d("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "data is null or do not have key: deviceId", new Object[0]);
        com.tencent.luggage.wxa.af.c cVar4 = com.tencent.luggage.wxa.af.e.f121315k;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("errCode", 10013));
        dVar.a(i3, makeReturnJson("fail:invalid data", cVar4, mutableMapOf));
    }
}
