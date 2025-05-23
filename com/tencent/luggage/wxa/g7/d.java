package com.tencent.luggage.wxa.g7;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.luggage.wxa.i3.x;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.ic.v;
import com.tencent.luggage.wxa.kj.i1;
import com.tencent.luggage.wxa.kj.p;
import com.tencent.luggage.wxa.p5.i;
import com.tencent.luggage.wxa.p5.j;
import com.tencent.luggage.wxa.q7.r;
import com.tencent.luggage.wxa.q7.s;
import com.tencent.luggage.wxa.qc.c;
import com.tencent.luggage.wxa.s6.f;
import com.tencent.luggage.wxa.standalone_open_runtime.report.KVReport_CALL_TRANSFER_API_10054;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.v3.m;
import com.tencent.luggage.wxa.xd.l;
import com.tencent.luggage.wxaapi.internal.WxaBackgroundAudioApiImpl;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibCheckerIPC;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 A2\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010>\u001a\u00020=\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0002H\u0014J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0012\u001a\u00020\u0002H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0014J\b\u0010\u0016\u001a\u00020\u0002H\u0014J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u001c\u0010\u001e\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0014J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\u0002H\u0014J\b\u0010#\u001a\u00020\u0002H\u0002R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0017\u00104\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R$\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u000206\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006B"}, d2 = {"Lcom/tencent/luggage/wxa/g7/d;", "Lcom/tencent/luggage/wxa/p5/f;", "", "J0", SemanticAttributes.DbSystemValues.H2, "l2", "P0", "i2", "Lcom/tencent/luggage/wxa/fd/i;", DownloadInfo.spKey_Config, "d", "K0", "Lcom/tencent/luggage/wxa/ok/j;", "r", "Lcom/tencent/luggage/wxa/kj/p;", "t", "Lcom/tencent/luggage/wxa/h7/b;", "m2", "N0", "Lcom/tencent/luggage/wxa/kj/i1;", "M", "T0", "I0", "Landroid/content/res/Configuration;", "newConfig", "b", "Lcom/tencent/luggage/wxa/wj/c;", "n0", "", "reason", "a", "j2", "", "z1", "Y0", "o2", "Lcom/tencent/luggage/wxa/c5/f;", "Lcom/tencent/luggage/wxa/j4/d;", "Lcom/tencent/luggage/wxa/c5/f;", "windowLayoutManager", "Lcom/tencent/luggage/wxa/f7/d;", "Z0", "Lcom/tencent/luggage/wxa/f7/d;", "reportUserCloseWeAppWhenLoading", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Z", "isLaunchWithPkgDownload", "Lcom/tencent/luggage/wxa/z6/a;", "b1", "Lcom/tencent/luggage/wxa/z6/a;", ICustomDataEditor.NUMBER_PARAM_2, "()Lcom/tencent/luggage/wxa/z6/a;", "apiReporter", "Lcom/tencent/luggage/wxa/p5/i;", "Lcom/tencent/luggage/wxa/s6/h;", "c1", "Lcom/tencent/luggage/wxa/p5/i;", "boostPrepareProcess", "d1", "Lcom/tencent/luggage/wxa/kj/i1;", "wxaDecorWidgetFactory", "Lcom/tencent/luggage/wxa/ic/v;", ParseCommon.CONTAINER, "<init>", "(Lcom/tencent/luggage/wxa/ic/v;)V", "e1", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.p5.f {

    /* renamed from: Y0, reason: from kotlin metadata */
    public com.tencent.luggage.wxa.c5.f windowLayoutManager;

    /* renamed from: Z0, reason: from kotlin metadata */
    public com.tencent.luggage.wxa.f7.d reportUserCloseWeAppWhenLoading;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    public boolean isLaunchWithPkgDownload;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    public final com.tencent.luggage.wxa.z6.a apiReporter;

    /* renamed from: c1, reason: collision with root package name and from kotlin metadata */
    public i boostPrepareProcess;

    /* renamed from: d1, reason: collision with root package name and from kotlin metadata */
    public i1 wxaDecorWidgetFactory;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends com.tencent.luggage.wxa.j7.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.j7.b
        public void a(String appId, int i3) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            if (Intrinsics.areEqual(appId, d.this.getAppId()) && i3 == d.this.l0()) {
                d.this.D();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f126597a;

        static {
            int[] iArr = new int[e.d.values().length];
            iArr[e.d.CLOSE.ordinal()] = 1;
            iArr[e.d.BACK.ordinal()] = 2;
            f126597a = iArr;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.g7.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6236d implements c.InterfaceC6640c {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.g7.d$d$a */
        /* loaded from: classes8.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f126599a;

            static {
                int[] iArr = new int[com.tencent.luggage.wxa.qc.b.values().length];
                iArr[com.tencent.luggage.wxa.qc.b.SUSPEND.ordinal()] = 1;
                iArr[com.tencent.luggage.wxa.qc.b.DESTROYED.ordinal()] = 2;
                f126599a = iArr;
            }
        }

        public C6236d() {
        }

        @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
        public final void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
            int i3;
            if (bVar == null) {
                i3 = -1;
            } else {
                i3 = a.f126599a[bVar.ordinal()];
            }
            if (i3 != 1) {
                if (i3 == 2) {
                    d.this.getApiReporter().a();
                    return;
                }
                return;
            }
            d.this.getApiReporter().b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            w.d("Luggage.WxaRuntime", "capsuleBarLogicWhenSplashRemoved");
            if (!d.this.t0() && !d.this.w0()) {
                com.tencent.luggage.wxa.c7.a.f123350a.b(d.this);
                return;
            }
            w.f("Luggage.WxaRuntime", "capsuleBarLogicWhenSplashRemoved fail, isDestroyed:" + d.this.w0() + " isFinishing:" + d.this.t0());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function0 {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.h7.b invoke() {
            if (d.this.Q1()) {
                return com.tencent.luggage.wxa.h7.b.INSTANCE.b();
            }
            return com.tencent.luggage.wxa.h7.b.INSTANCE.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function0 {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.s6.h invoke() {
            if (d.this.Q1()) {
                return null;
            }
            return com.tencent.luggage.wxa.s6.h.INSTANCE.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends g.x {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f126604a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f126605b;

            public a(d dVar, h hVar) {
                this.f126604a = dVar;
                this.f126605b = hVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                l a16 = this.f126604a.a(com.tencent.luggage.wxa.g7.e.class, true);
                Intrinsics.checkNotNull(a16);
                ((com.tencent.luggage.wxa.g7.e) a16).a(m.f143124a.a("sdk_openGrowthCare"));
                j.f137350a.a(this.f126604a);
                this.f126605b.d();
            }
        }

        public h() {
        }

        @Override // com.tencent.luggage.wxa.ic.g.x
        public void c() {
            d dVar = d.this;
            dVar.d(new a(dVar, this));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull v container) {
        super(container);
        Intrinsics.checkNotNullParameter(container, "container");
        if (r.f138048a.e()) {
            com.tencent.luggage.wxa.j7.a.f130880a.a(new a());
        }
        KVReport_CALL_TRANSFER_API_10054.f140728i.a();
        WxaCommLibCheckerIPC.f151841a.a();
        this.apiReporter = new com.tencent.luggage.wxa.z6.a();
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void I0() {
        super.I0();
        if (w0()) {
            x xVar = x.f129431a;
            String k3 = S().k();
            Intrinsics.checkNotNullExpressionValue(k3, "initConfig.wxaLaunchInstanceId");
            x.a(xVar, k3, x.d.CLOSE_BEFORE_START, null, 4, null);
        }
    }

    @Override // com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.c5.e, com.tencent.luggage.wxa.ic.g
    public void J0() {
        this.wxaDecorWidgetFactory = new com.tencent.luggage.wxa.f6.i();
        try {
            super.J0();
        } catch (RuntimeException e16) {
            if (Intrinsics.areEqual("Mini-game is not support in this SDK version.", e16.getMessage())) {
                com.tencent.luggage.wxa.u7.c cVar = com.tencent.luggage.wxa.u7.c.f142142a;
                String k3 = S().k();
                Intrinsics.checkNotNullExpressionValue(k3, "initConfig.wxaLaunchInstanceId");
                cVar.a(k3, S().T);
                D();
                return;
            }
        }
        c0().a(new C6236d());
        String k16 = S().k();
        Intrinsics.checkNotNullExpressionValue(k16, "initConfig.wxaLaunchInstanceId");
        String str = S().f125808a;
        Intrinsics.checkNotNullExpressionValue(str, "initConfig.appId");
        this.reportUserCloseWeAppWhenLoading = new com.tencent.luggage.wxa.f7.d(k16, str, false, 4, null);
    }

    @Override // com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.c5.e, com.tencent.luggage.wxa.ic.g
    public void K0() {
        com.tencent.luggage.wxa.f7.d dVar;
        super.K0();
        this.isLaunchWithPkgDownload = false;
        this.boostPrepareProcess = null;
        int i3 = c.f126597a[com.tencent.luggage.wxa.ic.e.d(getAppId()).ordinal()];
        if ((i3 == 1 || i3 == 2) && (dVar = this.reportUserCloseWeAppWhenLoading) != null) {
            dVar.c();
        }
        this.reportUserCloseWeAppWhenLoading = null;
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public i1 M() {
        i1 i1Var = this.wxaDecorWidgetFactory;
        if (i1Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wxaDecorWidgetFactory");
            return null;
        }
        return i1Var;
    }

    @Override // com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.c5.e, com.tencent.luggage.wxa.ic.g
    public void N0() {
        super.N0();
        com.tencent.luggage.wxa.uc.a.a(this);
    }

    @Override // com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.c5.e, com.tencent.luggage.wxa.ic.g
    public void P0() {
        com.tencent.luggage.wxa.wj.e orientationHandler = super.n0().getOrientationHandler();
        Intrinsics.checkNotNullExpressionValue(orientationHandler, "super.getWindowAndroid().orientationHandler");
        com.tencent.luggage.wxa.wj.c n06 = super.n0();
        Intrinsics.checkNotNullExpressionValue(n06, "super.getWindowAndroid()");
        b bVar = new b(this, orientationHandler, n06);
        this.windowLayoutManager = bVar;
        com.tencent.luggage.wxa.r5.a initConfig = S();
        Intrinsics.checkNotNullExpressionValue(initConfig, "initConfig");
        bVar.init(initConfig);
        this.isLaunchWithPkgDownload = false;
        super.P0();
    }

    @Override // com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.c5.e, com.tencent.luggage.wxa.ic.g
    public void T0() {
        boolean z16;
        boolean z17;
        boolean z18;
        super.T0();
        i iVar = this.boostPrepareProcess;
        if (iVar != null && iVar.i()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i iVar2 = this.boostPrepareProcess;
            if (iVar2 != null && iVar2.h()) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                z17 = false;
                boolean z19 = !this.isLaunchWithPkgDownload;
                com.tencent.luggage.wxa.u7.c cVar = com.tencent.luggage.wxa.u7.c.f142142a;
                String k3 = S().k();
                Intrinsics.checkNotNullExpressionValue(k3, "initConfig.wxaLaunchInstanceId");
                cVar.a(k3, S().T, z17, z19);
                this.reportUserCloseWeAppWhenLoading = null;
            }
        }
        z17 = true;
        boolean z192 = !this.isLaunchWithPkgDownload;
        com.tencent.luggage.wxa.u7.c cVar2 = com.tencent.luggage.wxa.u7.c.f142142a;
        String k36 = S().k();
        Intrinsics.checkNotNullExpressionValue(k36, "initConfig.wxaLaunchInstanceId");
        cVar2.a(k36, S().T, z17, z192);
        this.reportUserCloseWeAppWhenLoading = null;
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void Y0() {
        super.Y0();
        o2();
    }

    @Override // com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.ic.g
    public void a(com.tencent.luggage.wxa.fd.i newConfig, String reason) {
        if (com.tencent.luggage.wxa.p6.h.f137365a.c() <= 1) {
            com.tencent.luggage.wxa.q5.e.f();
        }
        super.a(newConfig, reason);
    }

    @Override // com.tencent.luggage.wxa.ic.g
    public void b(Configuration newConfig) {
        com.tencent.luggage.wxa.c5.f fVar;
        if (newConfig != null && (fVar = this.windowLayoutManager) != null) {
            fVar.onConfigurationChanged(newConfig);
        }
        super.b(newConfig);
    }

    @Override // com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.c5.e, com.tencent.luggage.wxa.ic.g
    public void d(com.tencent.luggage.wxa.fd.i config) {
        com.tencent.luggage.wxa.c5.f fVar;
        if (config != null && (fVar = this.windowLayoutManager) != null) {
            fVar.onInitConfigUpdated((com.tencent.luggage.wxa.j4.d) config);
        }
        super.d(config);
        if (!t1() && s0()) {
            Intrinsics.checkNotNull(config, "null cannot be cast to non-null type com.tencent.luggage.sdk.config.AppBrandInitConfigLU");
            com.tencent.luggage.wxa.j4.d dVar = (com.tencent.luggage.wxa.j4.d) config;
            com.tencent.luggage.wxa.u7.c cVar = com.tencent.luggage.wxa.u7.c.f142142a;
            String k3 = dVar.k();
            Intrinsics.checkNotNullExpressionValue(k3, "config.wxaLaunchInstanceId");
            cVar.a(k3, dVar.T, dVar.f125808a, dVar.G);
        }
    }

    @Override // com.tencent.luggage.wxa.p5.f
    public void h2() {
        super.h2();
        this.isLaunchWithPkgDownload = true;
    }

    @Override // com.tencent.luggage.wxa.p5.f
    public void i2() {
        com.tencent.luggage.wxa.c5.f fVar = this.windowLayoutManager;
        if (fVar != null) {
            com.tencent.luggage.wxa.fd.b appConfig = E();
            Intrinsics.checkNotNullExpressionValue(appConfig, "appConfig");
            fVar.onAppConfigGot(appConfig);
        }
        super.i2();
    }

    @Override // com.tencent.luggage.wxa.p5.f
    public void j2() {
        super.j2();
        if (!WxaBackgroundAudioApiImpl.f146882a.b()) {
            ((com.tencent.luggage.wxa.qc.a) a(com.tencent.luggage.wxa.qc.a.class)).f138598a = false;
        }
    }

    @Override // com.tencent.luggage.wxa.p5.f
    public void l2() {
        com.tencent.luggage.wxa.q5.a aVar;
        super.l2();
        String appId = getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "appId");
        boolean Q1 = Q1();
        boolean z16 = !Q1();
        if (Q1()) {
            aVar = com.tencent.luggage.wxa.g7.c.f126580a;
        } else {
            aVar = com.tencent.luggage.wxa.g7.a.f126576i;
        }
        i iVar = new i(appId, Q1, z16, aVar, new f(), new g());
        this.boostPrepareProcess = iVar;
        b((g.x) iVar);
        b(new h());
    }

    @Override // com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.ic.g
    /* renamed from: m2, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.h7.b u() {
        i iVar = this.boostPrepareProcess;
        Intrinsics.checkNotNull(iVar);
        com.tencent.luggage.wxa.a6.a g16 = iVar.g();
        Intrinsics.checkNotNull(g16);
        return (com.tencent.luggage.wxa.h7.b) g16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        if (r0.shouldInLargeScreenCompatMode() == true) goto L12;
     */
    @Override // com.tencent.luggage.wxa.ic.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.luggage.wxa.wj.c n0() {
        boolean z16;
        if (e0() == null) {
            com.tencent.luggage.wxa.wj.c n06 = super.n0();
            Intrinsics.checkNotNullExpressionValue(n06, "super.getWindowAndroid()");
            return n06;
        }
        b bVar = (b) this.windowLayoutManager;
        if (bVar != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            com.tencent.luggage.wxa.c5.f fVar = this.windowLayoutManager;
            Intrinsics.checkNotNull(fVar, "null cannot be cast to non-null type com.tencent.luggage.wxa.standalone_open_runtime.runtime.WxaCenterInsideWindowLayoutManager");
            return (b) fVar;
        }
        com.tencent.luggage.wxa.wj.c n07 = super.n0();
        Intrinsics.checkNotNullExpressionValue(n07, "super.getWindowAndroid()");
        return n07;
    }

    /* renamed from: n2, reason: from getter */
    public final com.tencent.luggage.wxa.z6.a getApiReporter() {
        return this.apiReporter;
    }

    public final void o2() {
        c(new e());
    }

    @Override // com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.ic.g
    public com.tencent.luggage.wxa.ok.j r() {
        Context L = L();
        if (L == null) {
            L = F();
        }
        Intrinsics.checkNotNullExpressionValue(L, "context ?: appContext");
        return new com.tencent.luggage.wxa.k7.h(L, this, Q1());
    }

    @Override // com.tencent.luggage.wxa.p5.f, com.tencent.luggage.wxa.ic.g
    public p t() {
        com.tencent.luggage.wxa.s6.f a16;
        if (Q1()) {
            f.a aVar = com.tencent.luggage.wxa.s6.f.W;
            Context L = L();
            if (L == null) {
                L = F();
            }
            Intrinsics.checkNotNullExpressionValue(L, "context ?: appContext");
            a16 = aVar.a(L, this);
        } else {
            f.a aVar2 = com.tencent.luggage.wxa.s6.f.W;
            Context L2 = L();
            if (L2 == null) {
                L2 = F();
            }
            Intrinsics.checkNotNullExpressionValue(L2, "context ?: appContext");
            i iVar = this.boostPrepareProcess;
            Intrinsics.checkNotNull(iVar);
            com.tencent.luggage.wxa.p5.e f16 = iVar.f();
            Intrinsics.checkNotNull(f16);
            a16 = aVar2.a(L2, this, (com.tencent.luggage.wxa.s6.h) f16);
        }
        a16.setDecorWidgetFactory(M());
        return a16;
    }

    @Override // com.tencent.luggage.wxa.c5.e
    public boolean z1() {
        boolean z16;
        com.tencent.luggage.wxaapi.a debugApi;
        if (super.z1()) {
            return true;
        }
        s d16 = s.d.f138074a.d();
        if (d16 != null && (debugApi = d16.getDebugApi()) != null && debugApi.isRunningWithJSCoverageCollect()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return false;
    }
}
