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
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends com.tencent.luggage.wxa.xd.a {

    /* renamed from: e, reason: collision with root package name */
    public static final C6799b f142311e = new C6799b(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f142312a;

    /* renamed from: b, reason: collision with root package name */
    public final String f142313b;

    /* renamed from: c, reason: collision with root package name */
    public final String f142314c;

    /* renamed from: d, reason: collision with root package name */
    public final Function1 f142315d;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.uf.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6799b {
        public C6799b() {
        }

        public /* synthetic */ C6799b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f142317a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f142318b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f142319c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.tencent.luggage.wxa.xd.d dVar, int i3, b bVar) {
            super(1);
            this.f142317a = dVar;
            this.f142318b = i3;
            this.f142319c = bVar;
        }

        public final void a(com.tencent.luggage.wxa.vf.g result) {
            HashMap hashMapOf;
            HashMap hashMapOf2;
            Intrinsics.checkNotNullParameter(result, "result");
            w.a("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, result: " + result);
            if (result instanceof g.b) {
                com.tencent.luggage.wxa.xd.d dVar = this.f142317a;
                int i3 = this.f142318b;
                b bVar = this.f142319c;
                hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(bVar.f142314c, this.f142319c.f142315d.invoke(((g.b) result).a())));
                dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(bVar, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMapOf2));
                return;
            }
            if (result instanceof g.a) {
                com.tencent.luggage.wxa.xd.d dVar2 = this.f142317a;
                int i16 = this.f142318b;
                b bVar2 = this.f142319c;
                g.a aVar = (g.a) result;
                int a16 = aVar.a();
                String str = "fail:" + aVar.b();
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", Integer.valueOf(aVar.a())));
                dVar2.a(i16, com.tencent.luggage.wxa.rf.j.a(bVar2, a16, str, hashMapOf));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.vf.g) obj);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ b(String str, String str2, String str3, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i3 & 8) != 0 ? a.f142316a : function1);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        HashMap hashMapOf;
        if (dVar == null) {
            w.f("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, env is null");
            return;
        }
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(f0.class));
        com.tencent.luggage.wxa.vf.f a16 = com.tencent.luggage.wxa.vf.f.f143434c.a(dVar);
        if (a16 == null) {
            w.f("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, can not get activity");
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13010));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13010, "fail:unknown", hashMapOf));
        } else {
            w.d("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, appId: " + dVar.getAppId());
            a16.a(this.f142312a, this.f142313b, null, new c(dVar, i3, this));
        }
    }

    public b(String techName, String function, String resultKey, Function1 retConverter) {
        Intrinsics.checkNotNullParameter(techName, "techName");
        Intrinsics.checkNotNullParameter(function, "function");
        Intrinsics.checkNotNullParameter(resultKey, "resultKey");
        Intrinsics.checkNotNullParameter(retConverter, "retConverter");
        this.f142312a = techName;
        this.f142313b = function;
        this.f142314c = resultKey;
        this.f142315d = retConverter;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f142316a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return obj;
        }
    }
}
