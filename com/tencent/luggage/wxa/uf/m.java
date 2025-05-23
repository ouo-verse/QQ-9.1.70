package com.tencent.luggage.wxa.uf;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.c0;
import com.tencent.luggage.wxa.vf.g;
import com.tencent.luggage.wxa.xd.f0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 789;

    @NotNull
    public static final String NAME = "startNFCDiscovery";

    /* renamed from: b, reason: collision with root package name */
    public static final a f142346b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Lazy f142347a;

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
        public final /* synthetic */ ArrayList f142348a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ArrayList arrayList) {
            super(1);
            this.f142348a = arrayList;
        }

        public final void a(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            com.tencent.luggage.wxa.wf.b bVar = com.tencent.luggage.wxa.wf.b.f144219h;
            if (Intrinsics.areEqual(it, bVar.f())) {
                this.f142348a.add(bVar);
                return;
            }
            com.tencent.luggage.wxa.wf.b bVar2 = com.tencent.luggage.wxa.wf.b.f144220i;
            if (Intrinsics.areEqual(it, bVar2.f())) {
                this.f142348a.add(bVar2);
                return;
            }
            com.tencent.luggage.wxa.wf.b bVar3 = com.tencent.luggage.wxa.wf.b.f144222k;
            if (Intrinsics.areEqual(it, bVar3.f())) {
                this.f142348a.add(bVar3);
                return;
            }
            com.tencent.luggage.wxa.wf.b bVar4 = com.tencent.luggage.wxa.wf.b.f144223l;
            if (Intrinsics.areEqual(it, bVar4.f())) {
                this.f142348a.add(bVar4);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f142349a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f142350b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m f142351c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.vf.f f142352d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function3 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xd.d f142353a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ m f142354b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.tencent.luggage.wxa.xd.d dVar, m mVar) {
                super(3);
                this.f142353a = dVar;
                this.f142354b = mVar;
            }

            public final void a(byte[] bArr, List techs, List list) {
                Intrinsics.checkNotNullParameter(techs, "techs");
                if (list != null) {
                    HashMap hashMap = new HashMap(com.tencent.luggage.wxa.wf.c.f144231a.a(list));
                    if (c0.b.FAIL_SIZE_EXCEED_LIMIT == c0.a(this.f142353a.getJsRuntime(), hashMap, (c0.a) this.f142353a.a(c0.a.class))) {
                        w.f("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "invoke, convert NativeBuffer fail");
                        return;
                    } else {
                        this.f142354b.e().setContext(this.f142353a).a(bArr, techs, hashMap);
                        return;
                    }
                }
                com.tencent.luggage.wxa.uf.c.a(this.f142354b.e().setContext(this.f142353a), bArr, techs, null, 4, null);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                a((byte[]) obj, (List) obj2, (List) obj3);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.tencent.luggage.wxa.xd.d dVar, int i3, m mVar, com.tencent.luggage.wxa.vf.f fVar) {
            super(1);
            this.f142349a = dVar;
            this.f142350b = i3;
            this.f142351c = mVar;
            this.f142352d = fVar;
        }

        public final void a(com.tencent.luggage.wxa.vf.g result) {
            HashMap hashMapOf;
            Intrinsics.checkNotNullParameter(result, "result");
            w.a("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "invoke, result: " + result);
            if (result instanceof g.b) {
                this.f142349a.a(this.f142350b, com.tencent.luggage.wxa.rf.j.a(this.f142351c, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, null, 4, null));
                this.f142352d.a(new a(this.f142349a, this.f142351c));
                return;
            }
            if (result instanceof g.a) {
                com.tencent.luggage.wxa.xd.d dVar = this.f142349a;
                int i3 = this.f142350b;
                m mVar = this.f142351c;
                g.a aVar = (g.a) result;
                int a16 = aVar.a();
                String str = "fail:" + aVar.b();
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", Integer.valueOf(aVar.a())));
                dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(mVar, a16, str, hashMapOf));
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
    public static final class d extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final d f142355a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.uf.c invoke() {
            return new com.tencent.luggage.wxa.uf.c();
        }
    }

    public m() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(d.f142355a);
        this.f142347a = lazy;
    }

    public final com.tencent.luggage.wxa.uf.c e() {
        return (com.tencent.luggage.wxa.uf.c) this.f142347a.getValue();
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        HashMap hashMapOf;
        HashMap hashMapOf2;
        if (dVar == null) {
            return;
        }
        if (!com.tencent.luggage.wxa.tf.d.d()) {
            hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13001));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13001, "fail:system NFC switch not opened", hashMapOf2));
            return;
        }
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(f0.class));
        com.tencent.luggage.wxa.vf.f a16 = com.tencent.luggage.wxa.vf.f.f143434c.a(dVar);
        if (a16 == null) {
            w.f("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "invoke, can not get activity");
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("errCode", 13010));
            dVar.a(i3, com.tencent.luggage.wxa.rf.j.a(this, 13010, "fail:unknown", hashMapOf));
            return;
        }
        if (jSONObject != null) {
            try {
                a16.a(jSONObject.getBoolean("requireForegroundDispatch"));
            } catch (Exception unused) {
                w.a("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "parse requireForegroundDispatch failed");
            }
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray filtersJson = jSONObject.getJSONArray("filters");
                Intrinsics.checkNotNullExpressionValue(filtersJson, "filtersJson");
                com.tencent.luggage.wxa.qn.a.a(filtersJson, new b(arrayList));
                if (arrayList.size() > 0) {
                    a16.a(arrayList);
                }
            } catch (Exception unused2) {
                w.a("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "parse filters failed");
            }
        }
        a16.a(new c(dVar, i3, this, a16));
    }
}
