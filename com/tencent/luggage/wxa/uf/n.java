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
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 794;

    @NotNull
    public static final String NAME = "stopNFCDiscovery";

    /* renamed from: a, reason: collision with root package name */
    public static final a f142356a = new a(null);

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
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f142357a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f142358b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ n f142359c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.vf.f f142360d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.tencent.luggage.wxa.xd.d dVar, int i3, n nVar, com.tencent.luggage.wxa.vf.f fVar) {
            super(1);
            this.f142357a = dVar;
            this.f142358b = i3;
            this.f142359c = nVar;
            this.f142360d = fVar;
        }

        public final void a(com.tencent.luggage.wxa.vf.g result) {
            HashMap hashMapOf;
            Intrinsics.checkNotNullParameter(result, "result");
            w.a("MicroMsg.AppBrand.JsApiStopNFCDiscovery", "stopNFCDiscovery, result: " + result);
            if (result instanceof g.b) {
                this.f142357a.a(this.f142358b, com.tencent.luggage.wxa.rf.j.a(this.f142359c, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, null, 4, null));
                this.f142360d.a((Function3) null);
                return;
            }
            if (result instanceof g.a) {
                com.tencent.luggage.wxa.xd.d dVar = this.f142357a;
                int i3 = this.f142358b;
                n nVar = this.f142359c;
                g.a aVar = (g.a) result;
                int a16 = aVar.a();
                String str = "fail:" + aVar.b();
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", Integer.valueOf(aVar.a())));
                dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(nVar, a16, str, hashMapOf));
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
        if (dVar == null) {
            return;
        }
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(f0.class));
        com.tencent.luggage.wxa.vf.f a16 = com.tencent.luggage.wxa.vf.f.f143434c.a(dVar);
        if (a16 == null) {
            w.f("MicroMsg.AppBrand.JsApiStopNFCDiscovery", "invoke, can not get activity");
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13010));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13010, "fail:unknown", hashMapOf));
            return;
        }
        a16.b(new b(dVar, i3, this, a16));
    }
}
