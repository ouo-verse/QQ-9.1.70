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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends com.tencent.luggage.wxa.xd.a {

    /* renamed from: b, reason: collision with root package name */
    public static final C6798a f142306b = new C6798a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Function3 f142307a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.uf.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6798a {
        public C6798a() {
        }

        public /* synthetic */ C6798a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f142308a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f142309b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f142310c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.tencent.luggage.wxa.xd.d dVar, int i3, a aVar) {
            super(1);
            this.f142308a = dVar;
            this.f142309b = i3;
            this.f142310c = aVar;
        }

        public final void a(com.tencent.luggage.wxa.vf.g result) {
            HashMap hashMapOf;
            Intrinsics.checkNotNullParameter(result, "result");
            w.a("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "transceive, result: " + result);
            if (result instanceof g.b) {
                this.f142308a.a(this.f142309b, com.tencent.luggage.wxa.rf.j.a(this.f142310c, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, null, 4, null));
                return;
            }
            if (result instanceof g.a) {
                com.tencent.luggage.wxa.xd.d dVar = this.f142308a;
                int i3 = this.f142309b;
                a aVar = this.f142310c;
                g.a aVar2 = (g.a) result;
                int a16 = aVar2.a();
                String str = "fail:" + aVar2.b();
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", Integer.valueOf(aVar2.a())));
                dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(aVar, a16, str, hashMapOf));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.vf.g) obj);
            return Unit.INSTANCE;
        }
    }

    public a(Function3 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.f142307a = function;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        HashMap hashMapOf;
        HashMap hashMapOf2;
        HashMap hashMapOf3;
        if (dVar == null) {
            w.f("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, env is null");
            return;
        }
        if (jSONObject == null) {
            w.f("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, data is null");
            hashMapOf3 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13011));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13011, "fail:invalid parameter", hashMapOf3));
            return;
        }
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(f0.class));
        com.tencent.luggage.wxa.vf.f a16 = com.tencent.luggage.wxa.vf.f.f143434c.a(dVar);
        if (a16 == null) {
            w.f("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, can not get activity");
            hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13010));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13010, "fail:unknown", hashMapOf2));
            return;
        }
        w.a("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, appId: " + dVar.getAppId() + ", data: " + jSONObject);
        try {
            String tech = jSONObject.getString("tech");
            Function3 function3 = this.f142307a;
            Intrinsics.checkNotNullExpressionValue(tech, "tech");
            function3.invoke(a16, tech, new b(dVar, i3, this));
        } catch (Exception unused) {
            w.f("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "parse tech failed");
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13011));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13011, "fail:invalid parameter", hashMapOf));
        }
    }
}
