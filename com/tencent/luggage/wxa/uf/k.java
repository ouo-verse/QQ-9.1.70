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
public final class k extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 814;

    @NotNull
    public static final String NAME = "NFCSetTimeout";

    /* renamed from: a, reason: collision with root package name */
    public static final a f142338a = new a(null);

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
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f142339a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f142340b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f142341c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.tencent.luggage.wxa.xd.d dVar, int i3, k kVar) {
            super(1);
            this.f142339a = dVar;
            this.f142340b = i3;
            this.f142341c = kVar;
        }

        public final void a(com.tencent.luggage.wxa.vf.g result) {
            HashMap hashMapOf;
            Intrinsics.checkNotNullParameter(result, "result");
            w.a("MicroMsg.AppBrand.JsApiNFCSetTimeout", "transceive, result: " + result);
            if (result instanceof g.b) {
                this.f142339a.a(this.f142340b, com.tencent.luggage.wxa.rf.j.a(this.f142341c, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, null, 4, null));
                return;
            }
            if (result instanceof g.a) {
                com.tencent.luggage.wxa.xd.d dVar = this.f142339a;
                int i3 = this.f142340b;
                k kVar = this.f142341c;
                g.a aVar = (g.a) result;
                int a16 = aVar.a();
                String str = "fail:" + aVar.b();
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", Integer.valueOf(aVar.a())));
                dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(kVar, a16, str, hashMapOf));
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
            w.f("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, env is null");
            return;
        }
        if (jSONObject == null) {
            w.f("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, data is null");
            hashMapOf4 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13011));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13011, "fail:invalid parameter", hashMapOf4));
            return;
        }
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(f0.class));
        com.tencent.luggage.wxa.vf.f a16 = com.tencent.luggage.wxa.vf.f.f143434c.a(dVar);
        if (a16 == null) {
            w.f("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, can not get activity");
            hashMapOf3 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13010));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13010, "fail:unknown", hashMapOf3));
            return;
        }
        w.a("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, appId: " + dVar.getAppId() + ", data: " + jSONObject);
        try {
            String tech = jSONObject.getString("tech");
            try {
                int i16 = jSONObject.getInt("timeout");
                Intrinsics.checkNotNullExpressionValue(tech, "tech");
                a16.a(tech, i16, new b(dVar, i3, this));
            } catch (Exception unused) {
                w.f("MicroMsg.AppBrand.JsApiNFCSetTimeout", "parse timeout failed");
                hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13011));
                dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13011, "fail:invalid parameter", hashMapOf2));
            }
        } catch (Exception unused2) {
            w.f("MicroMsg.AppBrand.JsApiNFCSetTimeout", "parse tech failed");
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13011));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13011, "fail:invalid parameter", hashMapOf));
        }
    }
}
