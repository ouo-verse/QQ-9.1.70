package com.tencent.luggage.wxa.uf;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.vf.g;
import com.tencent.luggage.wxa.xd.f0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
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
public final class d extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 821;

    @NotNull
    public static final String NAME = "isNFCTechConnected";

    /* renamed from: a, reason: collision with root package name */
    public static final a f142321a = new a(null);

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
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f142322a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f142323b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f142324c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.tencent.luggage.wxa.xd.d dVar, int i3, d dVar2) {
            super(1);
            this.f142322a = dVar;
            this.f142323b = i3;
            this.f142324c = dVar2;
        }

        public final void a(com.tencent.luggage.wxa.vf.g result) {
            HashMap hashMapOf;
            HashMap hashMapOf2;
            Intrinsics.checkNotNullParameter(result, "result");
            w.a("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "isNFCTechConnected, result: " + result);
            if (result instanceof g.b) {
                com.tencent.luggage.wxa.xd.d dVar = this.f142322a;
                int i3 = this.f142323b;
                d dVar2 = this.f142324c;
                hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("connected", ((g.b) result).a()));
                dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(dVar2, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMapOf2));
                return;
            }
            if (result instanceof g.a) {
                com.tencent.luggage.wxa.xd.d dVar3 = this.f142322a;
                int i16 = this.f142323b;
                d dVar4 = this.f142324c;
                g.a aVar = (g.a) result;
                int a16 = aVar.a();
                String str = "fail:" + aVar.b();
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", Integer.valueOf(aVar.a())));
                dVar3.a(i16, com.tencent.luggage.wxa.rf.j.a(dVar4, a16, str, hashMapOf));
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
        if (dVar == null) {
            w.f("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "invoke, env is null");
            return;
        }
        if (jSONObject == null) {
            w.f("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "invoke, data is null");
            hashMapOf3 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13011));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13011, "fail:invalid parameter", hashMapOf3));
            return;
        }
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(f0.class));
        com.tencent.luggage.wxa.vf.f a16 = com.tencent.luggage.wxa.vf.f.f143434c.a(dVar);
        if (a16 == null) {
            w.f("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "invoke, can not get activity");
            hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13010));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13010, "fail:unknown", hashMapOf2));
            return;
        }
        w.d("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "invoke, appId: " + dVar.getAppId() + ", data: " + jSONObject);
        try {
            String tech = jSONObject.getString("tech");
            Intrinsics.checkNotNullExpressionValue(tech, "tech");
            a16.d(tech, new b(dVar, i3, this));
        } catch (Exception unused) {
            w.f("MicroMsg.AppBrand.JsApiIsNFCTechConnected", "parse tech failed");
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13011));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13011, "fail:invalid parameter", hashMapOf));
        }
    }
}
