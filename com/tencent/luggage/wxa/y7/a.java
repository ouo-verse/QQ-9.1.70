package com.tencent.luggage.wxa.y7;

import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.hn.k1;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.ii.c;
import com.tencent.luggage.wxa.ii.j;
import com.tencent.luggage.wxa.ii.m;
import com.tencent.luggage.wxa.kj.t;
import com.tencent.luggage.wxa.mc.g0;
import com.tencent.luggage.wxa.p5.f;
import com.tencent.luggage.wxa.rc.q;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xi.d;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a implements d {

    /* renamed from: d, reason: collision with root package name */
    public static final C6940a f145440d = new C6940a(null);

    /* renamed from: a, reason: collision with root package name */
    public final g f145441a;

    /* renamed from: b, reason: collision with root package name */
    public final String f145442b;

    /* renamed from: c, reason: collision with root package name */
    public d.b f145443c;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.y7.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6940a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.y7.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C6941a extends d.c {
            @Override // com.tencent.luggage.wxa.xi.d.c
            public void a(String str) {
            }

            @Override // com.tencent.luggage.wxa.xi.d.c
            public d a(g runtime, String requestModuleName, String str) {
                Intrinsics.checkNotNullParameter(runtime, "runtime");
                Intrinsics.checkNotNullParameter(requestModuleName, "requestModuleName");
                return new a(runtime, requestModuleName);
            }
        }

        public C6940a() {
        }

        public /* synthetic */ C6940a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            d.c.f145009a = new C6941a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements Runnable {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.y7.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C6942a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f145445a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6942a(a aVar) {
                super(1);
                this.f145445a = aVar;
            }

            public final void a(List resultPkgList) {
                Intrinsics.checkNotNullParameter(resultPkgList, "resultPkgList");
                d.b bVar = this.f145445a.f145443c;
                if (bVar != null) {
                    bVar.a(true, resultPkgList);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((List) obj);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.y7.a$b$b, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C6943b extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f145446a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6943b(a aVar) {
                super(1);
                this.f145446a = aVar;
            }

            public final void a(g0 it) {
                Intrinsics.checkNotNullParameter(it, "it");
                d.b bVar = this.f145446a.f145443c;
                if (bVar != null) {
                    bVar.a(it);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((g0) obj);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class c extends Lambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f145447a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(a aVar) {
                super(2);
                this.f145447a = aVar;
            }

            public final void a(int i3, Throwable th5) {
                List emptyList;
                Intrinsics.checkNotNullParameter(th5, "<anonymous parameter 1>");
                d.b bVar = this.f145447a.f145443c;
                if (bVar != null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    bVar.a(false, emptyList);
                }
                w.b("Luggage.WxaRuntimeModularizingPkgRetrieverNew", "waitForPkgList Error");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a(((Number) obj).intValue(), (Throwable) obj2);
                return Unit.INSTANCE;
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            List listOf;
            boolean z16;
            boolean z17;
            g gVar = a.this.f145441a;
            Intrinsics.checkNotNull(gVar, "null cannot be cast to non-null type com.tencent.luggage.standalone_ext.Runtime");
            m mVar = m.f130565a;
            String appId = ((f) a.this.f145441a).getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "rt.appId");
            boolean a16 = mVar.a(appId, ((f) a.this.f145441a).l0(), ((f) a.this.f145441a).C1(), ((f) a.this.f145441a).Q1(), ((f) a.this.f145441a).i());
            boolean R1 = ((f) a.this.f145441a).R1();
            boolean Q1 = ((f) a.this.f145441a).Q1();
            q b26 = ((f) a.this.f145441a).b2();
            if (b26 == null) {
                w.b("Luggage.WxaRuntimeModularizingPkgRetrieverNew", "LibReader is null");
                return;
            }
            String appId2 = ((f) a.this.f145441a).getAppId();
            Intrinsics.checkNotNullExpressionValue(appId2, "rt.appId");
            com.tencent.luggage.wxa.dk.b a17 = com.tencent.luggage.wxa.r6.b.a(appId2);
            Intrinsics.checkNotNull(a17);
            k1 k1Var = new k1();
            k1Var.f127976d = ((f) a.this.f145441a).L1().f122984c;
            k1Var.f127977e = ((f) a.this.f145441a).y1();
            k1Var.f127978f = 101;
            com.tencent.luggage.wxa.ii.c cVar = com.tencent.luggage.wxa.ii.c.f130433a;
            String appId3 = ((f) a.this.f145441a).getAppId();
            int C1 = ((f) a.this.f145441a).C1();
            int l06 = ((f) a.this.f145441a).l0();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(a.this.f145442b);
            n0.g gVar2 = ((f) a.this.f145441a).S().X;
            Intrinsics.checkNotNullExpressionValue(gVar2, "rt.initConfig.wxaVersionInfo");
            String appId4 = ((f) a.this.f145441a).getAppId();
            Intrinsics.checkNotNullExpressionValue(appId4, "rt.appId");
            Map a18 = mVar.a(gVar2, appId4, a16);
            if (!R1 && j.a.f130506a.a(Q1)) {
                if (t.INSTANCE.a(b26)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = false;
                    c.a a19 = m.a(mVar, a17, false, ((f) a.this.f145441a).y1(), null, 8, null);
                    Intrinsics.checkNotNullExpressionValue(appId3, "appId");
                    cVar.a(appId3, C1, l06, listOf, a18, a17, new C6942a(a.this), new C6943b(a.this), (r30 & 256) != 0 ? c.d.f130444a : new c(a.this), z16, k1Var, (r30 & 2048) != 0 ? null : a19, (r30 & 4096) != 0 ? null : null);
                }
            }
            z16 = true;
            c.a a192 = m.a(mVar, a17, false, ((f) a.this.f145441a).y1(), null, 8, null);
            Intrinsics.checkNotNullExpressionValue(appId3, "appId");
            cVar.a(appId3, C1, l06, listOf, a18, a17, new C6942a(a.this), new C6943b(a.this), (r30 & 256) != 0 ? c.d.f130444a : new c(a.this), z16, k1Var, (r30 & 2048) != 0 ? null : a192, (r30 & 4096) != 0 ? null : null);
        }
    }

    public a(g rt5, String moduleName) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        this.f145441a = rt5;
        this.f145442b = moduleName;
    }

    public static final void a() {
        f145440d.a();
    }

    @Override // com.tencent.luggage.wxa.xi.d
    public void a(Executor executor) {
        if (executor == null) {
            executor = d.a.f145008c;
        }
        executor.execute(new b());
    }

    @Override // com.tencent.luggage.wxa.xi.d
    public void a(d.b bVar) {
        this.f145443c = bVar;
    }
}
