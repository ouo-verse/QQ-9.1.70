package com.tencent.luggage.wxa.r6;

import android.text.TextUtils;
import com.tencent.luggage.wxa.e5.l;
import com.tencent.luggage.wxa.fd.q;
import com.tencent.luggage.wxa.r6.c;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f139268a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f139269b = new HashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f139270a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.bk.a f139271b;

        public a(String str, com.tencent.luggage.wxa.bk.a aVar) {
            this.f139270a = str;
            this.f139271b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.b bVar;
            com.tencent.luggage.wxa.dk.b a16 = b.a(this.f139270a);
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.luggage.wxa.report.QualitySessionRuntime");
            g gVar = (g) a16;
            if (this.f139271b != null) {
                w.d("MicroMsg.AppBrandQualitySystem", "perfSample: " + this.f139271b.b());
                if (this.f139271b.a() != null) {
                    int i3 = this.f139271b.a().f128209d;
                    if (i3 != 3) {
                        if (i3 != 4) {
                            w.b("MicroMsg.AppBrandQualitySystem", "hy: invalid type!!");
                            bVar = null;
                        } else {
                            bVar = c.b.NewFull;
                        }
                    } else {
                        bVar = c.b.NewLight;
                    }
                    if (bVar != null) {
                        gVar.a().a(gVar, this.f139271b.a().f128210e, bVar);
                        return;
                    } else {
                        w.a("MicroMsg.AppBrandQualitySystem", "no inspect");
                        return;
                    }
                }
                return;
            }
            w.d("MicroMsg.AppBrandQualitySystem", "hy: not need do sample");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.r6.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class RunnableC6677b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f139272a;

        public RunnableC6677b(g gVar) {
            this.f139272a = gVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f139272a.a(com.tencent.luggage.wxa.u1.h.INST.c());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.p5.f f139273a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.p5.f f139274a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.tencent.luggage.wxa.p5.f fVar) {
                super(0);
                this.f139274a = fVar;
            }

            public final void a() {
                HashMap hashMap = b.f139269b;
                com.tencent.luggage.wxa.p5.f fVar = this.f139274a;
                synchronized (hashMap) {
                    Object obj = b.f139269b.get(fVar.getAppId());
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.luggage.wxa.report.QualitySessionRuntime");
                    if (Intrinsics.areEqual(((g) obj).b(), fVar)) {
                        b.f139269b.remove(fVar.getAppId());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.tencent.luggage.wxa.p5.f fVar) {
            super(1);
            this.f139273a = fVar;
        }

        public final void a(com.tencent.luggage.wxa.e5.h lifecycle) {
            Intrinsics.checkNotNullParameter(lifecycle, "$this$lifecycle");
            lifecycle.b(new a(this.f139273a));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.e5.h) obj);
            return Unit.INSTANCE;
        }
    }

    public static final void b(com.tencent.luggage.wxa.p5.f runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        String appId = runtime.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "runtime.getAppId()");
        if (TextUtils.isEmpty(appId)) {
            return;
        }
        com.tencent.luggage.wxa.dk.b a16 = a(appId);
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.luggage.wxa.report.QualitySessionRuntime");
        g gVar = (g) a16;
        if (gVar.b() != runtime) {
            return;
        }
        gVar.a().e();
    }

    public static final void c(com.tencent.luggage.wxa.p5.f rt5) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        HashMap hashMap = f139269b;
        String appId = rt5.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "rt.appId");
        String k3 = rt5.S().k();
        Intrinsics.checkNotNullExpressionValue(k3, "rt.initConfig.wxaLaunchInstanceId");
        com.tencent.luggage.wxa.r5.a S = rt5.S();
        Intrinsics.checkNotNullExpressionValue(S, "rt.initConfig");
        com.tencent.luggage.wxa.bk.e L1 = rt5.L1();
        Intrinsics.checkNotNullExpressionValue(L1, "rt.statObject");
        g gVar = new g(k3, S, L1);
        gVar.a(rt5);
        gVar.a(rt5.Q1());
        gVar.a(System.currentTimeMillis());
        com.tencent.luggage.wxa.zp.h.f146825d.execute(new RunnableC6677b(gVar));
        hashMap.put(appId, gVar);
        l.f124555a.a(rt5, new c(rt5));
    }

    public static final com.tencent.luggage.wxa.dk.b a(String appId) {
        com.tencent.luggage.wxa.dk.b bVar;
        Intrinsics.checkNotNullParameter(appId, "appId");
        HashMap hashMap = f139269b;
        synchronized (hashMap) {
            bVar = (com.tencent.luggage.wxa.dk.b) hashMap.get(appId);
        }
        return bVar;
    }

    public static final void a(String appId, com.tencent.luggage.wxa.bk.a sampleMgr, q sysConfig) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(sampleMgr, "sampleMgr");
        Intrinsics.checkNotNullParameter(sysConfig, "sysConfig");
        com.tencent.luggage.wxa.tk.l.a(new a(appId, sampleMgr));
    }

    public static final void a(com.tencent.luggage.wxa.p5.f runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        String appId = runtime.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "runtime.appId");
        if (TextUtils.isEmpty(appId)) {
            return;
        }
        com.tencent.luggage.wxa.dk.b a16 = a(appId);
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.luggage.wxa.report.QualitySessionRuntime");
        g gVar = (g) a16;
        if (gVar.b() != runtime) {
            return;
        }
        gVar.a().d();
    }
}
