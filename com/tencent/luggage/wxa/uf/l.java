package com.tencent.luggage.wxa.uf;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.c0;
import com.tencent.luggage.wxa.vf.g;
import com.tencent.luggage.wxa.xd.f0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 792;

    @NotNull
    public static final String NAME = "NFCTransceive";

    /* renamed from: a, reason: collision with root package name */
    public static final a f142342a = new a(null);

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
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f142343a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f142344b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l f142345c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.tencent.luggage.wxa.xd.d dVar, int i3, l lVar) {
            super(1);
            this.f142343a = dVar;
            this.f142344b = i3;
            this.f142345c = lVar;
        }

        public final void a(com.tencent.luggage.wxa.vf.g result) {
            HashMap hashMapOf;
            Map<String, ? extends Object> mutableMapOf;
            Intrinsics.checkNotNullParameter(result, "result");
            w.a("MicroMsg.AppBrand.JsApiNFCTransceive", "transceive, result: " + result);
            if (result instanceof g.b) {
                com.tencent.luggage.wxa.xd.d dVar = this.f142343a;
                int i3 = this.f142344b;
                l lVar = this.f142345c;
                com.tencent.luggage.wxa.af.c cVar = com.tencent.luggage.wxa.af.e.f121305a;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("data", c0.a((byte[]) ((g.b) result).a())));
                dVar.a(i3, lVar.makeReturnJsonWithNativeBuffer(dVar, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, cVar, mutableMapOf));
                return;
            }
            if (result instanceof g.a) {
                com.tencent.luggage.wxa.xd.d dVar2 = this.f142343a;
                int i16 = this.f142344b;
                l lVar2 = this.f142345c;
                g.a aVar = (g.a) result;
                int a16 = aVar.a();
                String str = "fail:" + aVar.b();
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", Integer.valueOf(aVar.a())));
                dVar2.a(i16, com.tencent.luggage.wxa.rf.j.a(lVar2, a16, str, hashMapOf));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.vf.g) obj);
            return Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        HashMap hashMapOf;
        HashMap hashMapOf2;
        HashMap hashMapOf3;
        HashMap hashMapOf4;
        if (dVar == null) {
            w.f("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, env is null");
            return;
        }
        if (jSONObject == null) {
            w.f("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, data is null");
            hashMapOf4 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13011));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13011, "fail:invalid parameter", hashMapOf4));
            return;
        }
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(f0.class));
        com.tencent.luggage.wxa.vf.f a16 = com.tencent.luggage.wxa.vf.f.f143434c.a(dVar);
        if (a16 == null) {
            w.f("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, can not get activity");
            hashMapOf3 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13010));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13010, "fail:unknown", hashMapOf3));
            return;
        }
        w.a("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, appId: " + dVar.getAppId() + ", data: " + jSONObject);
        try {
            String tech = jSONObject.getString("tech");
            try {
                Object obj = jSONObject.get("data");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.nio.ByteBuffer");
                byte[] a17 = com.tencent.luggage.wxa.tk.c.a((ByteBuffer) obj);
                Intrinsics.checkNotNullExpressionValue(a17, "try {\n                Ap\u2026     return\n            }");
                Intrinsics.checkNotNullExpressionValue(tech, "tech");
                a16.a(tech, a17, new b(dVar, i3, this));
            } catch (Exception e16) {
                w.f("MicroMsg.AppBrand.JsApiNFCTransceive", "parse data failed since " + e16);
                hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13011));
                dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13011, "fail:invalid parameter", hashMapOf2));
            }
        } catch (Exception unused) {
            w.f("MicroMsg.AppBrand.JsApiNFCTransceive", "parse tech failed");
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13011));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13011, "fail:invalid parameter", hashMapOf));
        }
    }
}
