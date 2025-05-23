package com.tencent.luggage.wxa.ic;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.luggage.wxa.ic.u0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.g;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i0 implements com.tencent.luggage.wxa.jq.g {

    /* renamed from: g, reason: collision with root package name */
    public static final a f129838g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.r5.a f129839a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.bk.e f129840b;

    /* renamed from: c, reason: collision with root package name */
    public final int f129841c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.kc.a f129842d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.d6.b f129843e;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.luggage.wxa.v4.i f129844f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final com.tencent.luggage.wxa.kj.v a(com.tencent.luggage.wxa.p5.f fVar) {
            com.tencent.luggage.wxa.kj.n currentPage;
            Intrinsics.checkNotNullParameter(fVar, "<this>");
            com.tencent.luggage.wxa.y4.b Y = fVar.Y();
            if (Y != null && (currentPage = Y.getCurrentPage()) != null) {
                return currentPage.getCurrentPageView();
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements g.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129845a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i0 f129846b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129847a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i0 f129848b;

            public a(com.tencent.luggage.wxa.p5.f fVar, i0 i0Var) {
                this.f129847a = fVar;
                this.f129848b = i0Var;
            }

            @Override // java.lang.Runnable
            public final void run() {
                i0.b(this.f129847a, this.f129848b);
            }
        }

        public b(com.tencent.luggage.wxa.p5.f fVar, i0 i0Var) {
            this.f129845a = fVar;
            this.f129846b = i0Var;
        }

        @Override // com.tencent.luggage.wxa.xd.g.f
        public final void onReady() {
            com.tencent.luggage.wxa.tn.c0.a(new a(this.f129845a, this.f129846b));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129849a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i0 f129850b;

        public c(com.tencent.luggage.wxa.p5.f fVar, i0 i0Var) {
            this.f129849a = fVar;
            this.f129850b = i0Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i0.b(this.f129849a, this.f129850b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements g0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f129851a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129852b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i0 f129853c;

        public d(AtomicBoolean atomicBoolean, com.tencent.luggage.wxa.p5.f fVar, i0 i0Var) {
            this.f129851a = atomicBoolean;
            this.f129852b = fVar;
            this.f129853c = i0Var;
        }

        @Override // com.tencent.luggage.wxa.ic.g0
        public final void a() {
            this.f129851a.set(true);
            i0.b(this.f129852b, this.f129853c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements m0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129855b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f129856c;

        public e(com.tencent.luggage.wxa.p5.f fVar, AtomicBoolean atomicBoolean) {
            this.f129855b = fVar;
            this.f129856c = atomicBoolean;
        }

        @Override // com.tencent.luggage.wxa.ic.m0
        public void a() {
        }

        @Override // com.tencent.luggage.wxa.ic.m0
        public /* synthetic */ void a(int i3) {
            as.b(this, i3);
        }

        @Override // com.tencent.luggage.wxa.ic.m0
        public void a(String str) {
            com.tencent.luggage.wxa.kc.a aVar;
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPreRenderColdStartService.RemoteLoader", "initRuntime()-onResourcePrepareInterrupted reason:" + str + " id:" + i0.this.f129841c + " appId:" + this.f129855b.getAppId() + " instanceId:" + i0.this.f129839a.k() + TokenParser.SP);
            if (this.f129856c.getAndSet(true) || (aVar = i0.this.f129842d) == null) {
                return;
            }
            z21.a.a(aVar, -7, null, 2, null);
        }

        @Override // com.tencent.luggage.wxa.ic.m0
        public void b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f129857a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i0 f129858b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129859c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AtomicBoolean f129860a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i0 f129861b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.p5.f f129862c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(AtomicBoolean atomicBoolean, i0 i0Var, com.tencent.luggage.wxa.p5.f fVar) {
                super(0);
                this.f129860a = atomicBoolean;
                this.f129861b = i0Var;
                this.f129862c = fVar;
            }

            public final void a() {
                if (!this.f129860a.getAndSet(true)) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPreRenderColdStartService.RemoteLoader", "initRuntime()-onDestroy before callback, maybe reload() invoked, id:" + this.f129861b.f129841c + " appId:" + this.f129862c.getAppId() + " instanceId:" + this.f129861b.f129839a.k() + TokenParser.SP);
                    com.tencent.luggage.wxa.kc.a aVar = this.f129861b.f129842d;
                    if (aVar != null) {
                        z21.a.a(aVar, -12, null, 2, null);
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(AtomicBoolean atomicBoolean, i0 i0Var, com.tencent.luggage.wxa.p5.f fVar) {
            super(1);
            this.f129857a = atomicBoolean;
            this.f129858b = i0Var;
            this.f129859c = fVar;
        }

        public final void a(com.tencent.luggage.wxa.e5.h lifecycle) {
            Intrinsics.checkNotNullParameter(lifecycle, "$this$lifecycle");
            lifecycle.b(new a(this.f129857a, this.f129858b, this.f129859c));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.e5.h) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0004\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/tencent/luggage/wxa/va/e;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "Lcom/tencent/luggage/wxa/ka/i;", "callback", "", "a", "(Lcom/tencent/luggage/wxa/va/e;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class g<InputType, ResultType> implements com.tencent.luggage.wxa.ka.f {

        /* renamed from: a, reason: collision with root package name */
        public static final g f129863a = new g();

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(com.tencent.luggage.wxa.va.e eVar, com.tencent.luggage.wxa.ka.i iVar) {
            if (iVar != null) {
                iVar.a(com.tencent.luggage.wxa.va.e.f143316a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements com.tencent.luggage.wxa.ka.j {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f129865b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i0 f129866a;

            public a(i0 i0Var) {
                this.f129866a = i0Var;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f129866a.a();
            }
        }

        public h(long j3) {
            this.f129865b = j3;
        }

        @Override // com.tencent.luggage.wxa.ka.j
        public /* synthetic */ void a() {
            com.tencent.luggage.wxa.ka.aa.a(this);
        }

        @Override // com.tencent.luggage.wxa.ka.j
        public void b() {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPreRenderColdStartService.RemoteLoader", "bindRemoteProcess->bindMainProcess, onBridgeNotFound, id:" + i0.this.f129841c + ", cost:" + (w0.a() - this.f129865b) + "ms");
            com.tencent.luggage.wxa.kc.a aVar = i0.this.f129842d;
            if (aVar != null) {
                z21.a.a(aVar, -11, null, 2, null);
            }
        }

        @Override // com.tencent.luggage.wxa.ka.j
        public /* synthetic */ void a(String str) {
            com.tencent.luggage.wxa.ka.aa.b(this, str);
        }

        @Override // com.tencent.luggage.wxa.ka.i
        public void a(com.tencent.luggage.wxa.va.e eVar) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaPreRenderColdStartService.RemoteLoader", "bindRemoteProcess->bindMainProcess, bind ok, id:" + i0.this.f129841c + ", cost:" + (w0.a() - this.f129865b) + "ms");
            com.tencent.luggage.wxa.zp.h.f146825d.a(new a(i0.this));
        }

        @Override // com.tencent.luggage.wxa.ka.j
        public void a(Exception e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaPreRenderColdStartService.RemoteLoader", "bindRemoteProcess->bindMainProcess, onCaughtInvokeException(" + e16 + "), id:" + i0.this.f129841c + ", cost:" + (w0.a() - this.f129865b) + "ms");
            com.tencent.luggage.wxa.kc.a aVar = i0.this.f129842d;
            if (aVar != null) {
                z21.a.a(aVar, -11, null, 2, null);
            }
        }
    }

    public i0(com.tencent.luggage.wxa.r5.a config, com.tencent.luggage.wxa.bk.e stat, int i3, com.tencent.luggage.wxa.kc.a aVar, com.tencent.luggage.wxa.d6.b action, com.tencent.luggage.wxa.v4.i wxaColdStartMode) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(stat, "stat");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(wxaColdStartMode, "wxaColdStartMode");
        this.f129839a = config;
        this.f129840b = stat;
        this.f129841c = i3;
        this.f129842d = aVar;
        this.f129843e = action;
        this.f129844f = wxaColdStartMode;
    }

    @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
    public String getKey() {
        return "WxaPreRenderColdStartService.RemoteLoader-" + this.f129841c;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.luggage.wxa.ka.o.a(com.tencent.luggage.wxa.tn.z.g(), com.tencent.luggage.wxa.va.e.f143316a, g.f129863a.getClass(), new h(w0.a()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if (r0.B() == true) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(com.tencent.luggage.wxa.p5.f fVar, i0 i0Var) {
        v e06 = fVar.e0();
        j jVar = e06 instanceof j ? (j) e06 : null;
        boolean z16 = jVar != null;
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaPreRenderColdStartService.RemoteLoader", "initRuntime()-callbackOnPreRenderComplete id:" + i0Var.f129841c + ", appId:" + fVar.getAppId() + ", instanceId:" + fVar.S().k() + ", hasResumedContainer:" + z16);
        if (z16) {
            com.tencent.luggage.wxa.kc.a aVar = i0Var.f129842d;
            if (aVar != null) {
                aVar.onSuccess();
                return;
            }
            return;
        }
        fVar.y();
        u0.a.f130002a.a(fVar, i0Var.f129843e);
        com.tencent.luggage.wxa.kc.a aVar2 = i0Var.f129842d;
        if (aVar2 != null) {
            aVar2.onSuccess();
        }
    }

    public static final void c(com.tencent.luggage.wxa.p5.f fVar, i0 i0Var) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaPreRenderColdStartService.RemoteLoader", "initRuntime()-waitForRuntimeInitReady id:" + i0Var.f129841c + ", appId:" + fVar.getAppId() + ", instanceId:" + i0Var.f129839a.k() + ", runtime.isLaunched:" + fVar.A0());
        fVar.a((g0) new d(atomicBoolean, fVar, i0Var));
        fVar.a((m0) new e(fVar, atomicBoolean));
        com.tencent.luggage.wxa.e5.l.f124555a.a(fVar, new f(atomicBoolean, i0Var, fVar));
        if (fVar.A0()) {
            return;
        }
        fVar.F0();
        com.tencent.luggage.wxa.wj.c n06 = fVar.n0();
        Intrinsics.checkNotNull(n06, "null cannot be cast to non-null type com.tencent.luggage.ui.WxaPreRenderCustomWindowAndroid");
        DisplayMetrics vDisplayMetrics = ((com.tencent.luggage.wxa.f6.g) n06).getVDisplayMetrics();
        fVar.K().measure(View.MeasureSpec.makeMeasureSpec(vDisplayMetrics.widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(vDisplayMetrics.heightPixels, Integer.MIN_VALUE));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
    
        if (r3.a() > 1) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        com.tencent.luggage.wxa.r5.a aVar = this.f129839a;
        aVar.f125813f = com.tencent.luggage.wxa.ki.a.a(aVar.f125813f);
        com.tencent.luggage.wxa.p5.f b16 = com.tencent.luggage.wxa.p6.h.b(this.f129839a.f125808a);
        boolean z16 = true;
        if (b16 != null && !b16.w0() && !b16.t0() && b16.z0()) {
            if (b16.z0()) {
                v e06 = b16.e0();
                Intrinsics.checkNotNull(e06);
            }
            b16.B0();
            z16 = false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initRuntime()-shouldReRender:");
        sb5.append(z16);
        sb5.append(", existedRt:");
        sb5.append(b16);
        sb5.append(", initialized:");
        sb5.append(b16 != null ? b16.s0() : false);
        sb5.append(", isResumed:");
        sb5.append(b16 != null ? b16.B0() : false);
        sb5.append(", isFinishing:");
        sb5.append(b16 != null ? b16.w0() : false);
        sb5.append(", destroyed:");
        sb5.append(b16 != null ? b16.t0() : false);
        sb5.append(", versionType:");
        sb5.append(b16 != null ? b16.l0() : -1);
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaPreRenderColdStartService.RemoteLoader", sb5.toString());
        if (!z16) {
            com.tencent.luggage.wxa.kc.a aVar2 = this.f129842d;
            if (aVar2 != null) {
                z21.a.a(aVar2, -2, null, 2, null);
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.r5.a aVar3 = this.f129839a;
        aVar3.G0 = this.f129844f;
        aVar3.a(this.f129840b);
        if (b16 != null && b16.s0() && b16.l0() == this.f129839a.d() && !b16.t0() && !b16.w0()) {
            v e07 = b16.e0();
            if (b16.B0()) {
                b16.y();
            }
            if (e07 != null) {
                e07.d(b16);
            }
            if (b16.w0() && !b16.t0()) {
                b16.x();
            }
            ViewParent parent = b16.K().getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(b16.K());
            }
            com.tencent.luggage.wxa.c5.d dVar = e07 instanceof com.tencent.luggage.wxa.c5.d ? (com.tencent.luggage.wxa.c5.d) e07 : null;
            if (dVar != null) {
                dVar.d();
            }
            com.tencent.luggage.wxa.r5.a aVar4 = this.f129839a;
            Point point = aVar4.U0;
            int i3 = aVar4.T0;
            Function0 a16 = u0.b.f130007a.a();
            b16.a((com.tencent.luggage.wxa.wj.c) new com.tencent.luggage.wxa.f6.g(point, i3, a16 != null ? (Context) a16.invoke() : null));
            b16.a((com.tencent.luggage.wxa.fd.i) this.f129839a);
            boolean s16 = b16.s1();
            boolean t16 = b16.t1();
            b16.A();
            if (t16) {
                if (b16.t0()) {
                    com.tencent.luggage.wxa.kc.a aVar5 = this.f129842d;
                    if (aVar5 != null) {
                        z21.a.a(aVar5, -6, null, 2, null);
                        return;
                    }
                    return;
                }
                c(b16, this);
                return;
            }
            if (s16) {
                com.tencent.luggage.wxa.kj.v a17 = f129838g.a(b16);
                if (a17 != null) {
                    a17.a(new b(b16, this));
                    return;
                }
                return;
            }
            com.tencent.luggage.wxa.tn.c0.a(new c(b16, this));
            return;
        }
        u0.b bVar = u0.b.f130007a;
        if (bVar.b() == null) {
            com.tencent.luggage.wxa.kc.a aVar6 = this.f129842d;
            if (aVar6 != null) {
                z21.a.a(aVar6, -6, null, 2, null);
                return;
            }
            return;
        }
        Function1 b17 = bVar.b();
        Intrinsics.checkNotNull(b17);
        com.tencent.luggage.wxa.d6.b bVar2 = this.f129843e;
        com.tencent.luggage.wxa.p5.f fVar = (com.tencent.luggage.wxa.p5.f) b17.invoke(new com.tencent.luggage.wxa.f6.g(new Point(bVar2.f124102t, bVar2.f124103u), 0, null, 6, null));
        fVar.b((com.tencent.luggage.wxa.fd.i) this.f129839a);
        c(fVar, this);
        u0.a.f130002a.a(fVar, this.f129843e);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i0(p data, com.tencent.luggage.wxa.kc.a aVar) {
        this(data.b(), data.d(), data.c(), aVar, data.a().a(), data.e());
        Intrinsics.checkNotNullParameter(data, "data");
    }
}
