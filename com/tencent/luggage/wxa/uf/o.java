package com.tencent.luggage.wxa.uf;

import android.nfc.NdefMessage;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.vf.g;
import com.tencent.luggage.wxa.xd.f0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class o extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 793;

    @NotNull
    public static final String NAME = "writeNdefMessage";

    /* renamed from: a, reason: collision with root package name */
    public static final a f142361a = new a(null);

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
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f142362a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f142363b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f142364c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.tencent.luggage.wxa.xd.d dVar, int i3, o oVar) {
            super(1);
            this.f142362a = dVar;
            this.f142363b = i3;
            this.f142364c = oVar;
        }

        public final void a(com.tencent.luggage.wxa.vf.g result) {
            HashMap hashMapOf;
            Intrinsics.checkNotNullParameter(result, "result");
            w.a("MicroMsg.AppBrand.JsApiWriteNdefMessage", "writeNdefMessage, result: " + result);
            if (result instanceof g.b) {
                this.f142362a.a(this.f142363b, com.tencent.luggage.wxa.rf.j.a(this.f142364c, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, null, 4, null));
                return;
            }
            if (result instanceof g.a) {
                com.tencent.luggage.wxa.xd.d dVar = this.f142362a;
                int i3 = this.f142363b;
                o oVar = this.f142364c;
                g.a aVar = (g.a) result;
                int a16 = aVar.a();
                String str = "fail:" + aVar.b();
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", Integer.valueOf(aVar.a())));
                dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(oVar, a16, str, hashMapOf));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.vf.g) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final c f142365a = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        HashMap hashMapOf;
        HashMap hashMapOf2;
        HashMap hashMapOf3;
        HashMap hashMapOf4;
        JSONObject jSONObject2;
        HashMap hashMapOf5;
        HashMap hashMapOf6;
        HashMap hashMapOf7;
        HashMap hashMapOf8;
        if (dVar == null) {
            w.f("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, env is null");
            return;
        }
        if (jSONObject == null) {
            w.f("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, data is null");
            hashMapOf8 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13011));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13011, "fail:invalid parameter", hashMapOf8));
            return;
        }
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(f0.class));
        com.tencent.luggage.wxa.vf.f a16 = com.tencent.luggage.wxa.vf.f.f143434c.a(dVar);
        if (a16 == null) {
            w.f("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, can not get activity");
            hashMapOf7 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13010));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13010, "fail:unknown", hashMapOf7));
            return;
        }
        b bVar = new b(dVar, i3, this);
        w.a("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, appId: " + dVar.getAppId() + ", data: " + jSONObject);
        String str = "get(index)";
        if (jSONObject.has("uris")) {
            try {
                Object obj = jSONObject.get("uris");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList arrayList = new ArrayList(jSONArray.length());
                int length = jSONArray.length();
                for (int i16 = 0; i16 < length; i16++) {
                    Object obj2 = jSONArray.get(i16);
                    Intrinsics.checkNotNullExpressionValue(obj2, "get(index)");
                    arrayList.add(obj2.toString());
                }
                NdefMessage c16 = com.tencent.luggage.wxa.wf.c.f144231a.c(arrayList);
                if (c16 == null) {
                    hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13012));
                    dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13012, "fail:parse NdefMessage failed", hashMapOf2));
                    return;
                } else {
                    a16.a(c16, bVar);
                    return;
                }
            } catch (Exception e16) {
                w.f("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse uris failed since " + e16);
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13011));
                dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13011, "fail:invalid parameter", hashMapOf));
                return;
            }
        }
        if (jSONObject.has("texts")) {
            try {
                Object obj3 = jSONObject.get("texts");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type org.json.JSONArray");
                JSONArray jSONArray2 = (JSONArray) obj3;
                ArrayList arrayList2 = new ArrayList(jSONArray2.length());
                int length2 = jSONArray2.length();
                int i17 = 0;
                while (i17 < length2) {
                    Object obj4 = jSONArray2.get(i17);
                    Intrinsics.checkNotNullExpressionValue(obj4, str);
                    if (obj4 instanceof JSONObject) {
                        jSONObject2 = (JSONObject) obj4;
                    } else {
                        jSONObject2 = null;
                    }
                    if (jSONObject2 == null) {
                        w.f("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse texts failed since convert jsonObject failed");
                        hashMapOf5 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13011));
                        dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13011, "fail:invalid parameter", hashMapOf5));
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    JSONArray jSONArray3 = jSONArray2;
                    Iterator keys = jSONObject2.keys();
                    int i18 = length2;
                    Intrinsics.checkNotNullExpressionValue(keys, "keys()");
                    while (keys.hasNext()) {
                        String it = (String) keys.next();
                        Iterator it5 = keys;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        Object obj5 = jSONObject2.get(it);
                        Intrinsics.checkNotNullExpressionValue(obj5, "get(it)");
                        hashMap.put(it, obj5.toString());
                        keys = it5;
                        str = str;
                    }
                    String str2 = str;
                    arrayList2.add(hashMap);
                    i17++;
                    jSONArray2 = jSONArray3;
                    length2 = i18;
                    str = str2;
                }
                NdefMessage b16 = com.tencent.luggage.wxa.wf.c.f144231a.b(arrayList2);
                if (b16 == null) {
                    hashMapOf4 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13012));
                    dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13012, "fail:parse NdefMessage failed", hashMapOf4));
                    return;
                } else {
                    a16.a(b16, bVar);
                    return;
                }
            } catch (Exception e17) {
                w.f("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse texts failed since " + e17);
                hashMapOf3 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13011));
                dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13011, "fail:invalid parameter", hashMapOf3));
                return;
            }
        }
        NdefMessage a17 = com.tencent.luggage.wxa.wf.c.f144231a.a(com.tencent.luggage.wxa.xf.a.a(jSONObject, c.f142365a));
        if (a17 == null) {
            hashMapOf6 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13012));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13012, "fail:parse NdefMessage failed", hashMapOf6));
        } else {
            a16.a(a17, bVar);
        }
    }
}
