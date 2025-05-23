package com.tencent.luggage.wxa.a6;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.c0;
import com.tencent.luggage.wxa.kj.p1;
import com.tencent.luggage.wxa.se.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.magicbrush.b;
import com.tencent.magicbrush.handler.fs.IMBFileSystem;
import com.tencent.magicbrush.ui.a;
import com.tencent.magicbrush.ui.g;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements g, com.tencent.luggage.wxa.w1.c {

    /* renamed from: d, reason: collision with root package name */
    public static final C5987b f120854d = new C5987b(null);

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.a6.e f120855a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.q1.c f120856b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f120857c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends com.tencent.luggage.wxa.sd.d {
        @Override // com.tencent.luggage.wxa.sd.d, com.tencent.luggage.wxa.k8.c
        public com.tencent.luggage.wxa.k8.b f(String str) {
            if (Intrinsics.areEqual("webgl", str)) {
                return new com.tencent.luggage.wxa.te.a();
            }
            if (Intrinsics.areEqual("video", str)) {
                com.tencent.luggage.wxa.j6.d dVar = new com.tencent.luggage.wxa.j6.d();
                com.tencent.luggage.wxa.i8.e eVar = new com.tencent.luggage.wxa.i8.e(true, dVar);
                dVar.a(eVar);
                eVar.a(new com.tencent.luggage.wxa.ai.c());
                return eVar;
            }
            com.tencent.luggage.wxa.k8.b f16 = super.f(str);
            Intrinsics.checkNotNullExpressionValue(f16, "super.createHandler(type)");
            return f16;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.a6.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C5987b {
        public C5987b() {
        }

        public /* synthetic */ C5987b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class c {
        public c() {
        }

        @JavascriptInterface
        public final int exec(int i3) {
            com.tencent.luggage.wxa.a6.e eVar = null;
            try {
                a.b bVar = com.tencent.luggage.wxa.se.a.f140284c;
                com.tencent.luggage.wxa.a6.e eVar2 = b.this.f120855a;
                if (eVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mpServiceLogic");
                    eVar2 = null;
                }
                String x16 = eVar2.x();
                Intrinsics.checkNotNullExpressionValue(x16, "mpServiceLogic.appId");
                return bVar.a(x16).b(i3);
            } catch (Exception e16) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("MBViewIdTransfer failed, canvasId:");
                sb5.append(i3);
                sb5.append(", appId:");
                com.tencent.luggage.wxa.a6.e eVar3 = b.this.f120855a;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mpServiceLogic");
                } else {
                    eVar = eVar3;
                }
                sb5.append(eVar.x());
                w.a("Luggage.MBInstallerDelegateImplForMiniProgram", e16, sb5.toString(), new Object[0]);
                return -1;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends com.tencent.luggage.wxa.q1.c {

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ j f120859f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ b f120860g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.r4.d f120861h;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements IMBFileSystem {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WeakReference f120862a;

            public a(WeakReference weakReference) {
                this.f120862a = weakReference;
            }

            @Override // com.tencent.magicbrush.handler.fs.IMBFileSystem
            public final byte[] readDataFromURLSync(String str) {
                return com.tencent.luggage.wxa.s1.a.f139989a.a(str, (l) this.f120862a.get());
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.a6.b$d$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C5988b implements b.e {

            /* renamed from: a, reason: collision with root package name */
            public FrameLayout f120863a;

            /* renamed from: b, reason: collision with root package name */
            public final com.tencent.luggage.wxa.w8.e f120864b = new com.tencent.luggage.wxa.w8.e();

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f120865c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ d f120866d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.r4.d f120867e;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.a6.b$d$b$a */
            /* loaded from: classes8.dex */
            public static final class a extends Lambda implements Function0 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ b f120868a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ C5988b f120869b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.r4.d f120870c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ com.tencent.magicbrush.ui.g f120871d;

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ int f120872e;

                /* renamed from: f, reason: collision with root package name */
                public final /* synthetic */ int f120873f;

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ int f120874g;

                /* renamed from: h, reason: collision with root package name */
                public final /* synthetic */ int f120875h;

                /* renamed from: i, reason: collision with root package name */
                public final /* synthetic */ int f120876i;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(b bVar, C5988b c5988b, com.tencent.luggage.wxa.r4.d dVar, com.tencent.magicbrush.ui.g gVar, int i3, int i16, int i17, int i18, int i19) {
                    super(0);
                    this.f120868a = bVar;
                    this.f120869b = c5988b;
                    this.f120870c = dVar;
                    this.f120871d = gVar;
                    this.f120872e = i3;
                    this.f120873f = i16;
                    this.f120874g = i17;
                    this.f120875h = i18;
                    this.f120876i = i19;
                }

                public final void a() {
                    Context c16;
                    com.tencent.luggage.wxa.a6.e eVar = this.f120868a.f120855a;
                    if (eVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mpServiceLogic");
                        eVar = null;
                    }
                    com.tencent.luggage.wxa.c5.e B = eVar.B();
                    if (B == null || (c16 = B.F()) == null) {
                        c16 = z.c();
                    }
                    if (this.f120869b.f120863a == null) {
                        this.f120869b.f120863a = new FrameLayout(c16);
                        c0 customViewContainer = this.f120870c.J().getCustomViewContainer();
                        FrameLayout frameLayout = this.f120869b.f120863a;
                        Intrinsics.checkNotNull(frameLayout);
                        p1.a(customViewContainer, frameLayout);
                    }
                    com.tencent.luggage.wxa.w8.e eVar2 = this.f120869b.f120864b;
                    FrameLayout frameLayout2 = this.f120869b.f120863a;
                    Intrinsics.checkNotNull(frameLayout2);
                    int a16 = eVar2.a(frameLayout2, this.f120871d, this.f120872e);
                    this.f120871d.setOpaque(false);
                    this.f120871d.setLeft(this.f120873f);
                    this.f120871d.setTop(this.f120874g);
                    this.f120871d.setOpaque(false);
                    float f16 = c16.getResources().getDisplayMetrics().density;
                    int i3 = this.f120875h;
                    if (i3 <= 0) {
                        i3 = (int) (100 * f16);
                    }
                    int i16 = this.f120876i;
                    if (i16 <= 0) {
                        i16 = (int) (100 * f16);
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i16);
                    layoutParams.setMargins(this.f120873f, this.f120874g, 0, 0);
                    FrameLayout frameLayout3 = this.f120869b.f120863a;
                    Intrinsics.checkNotNull(frameLayout3);
                    frameLayout3.addView(this.f120871d, a16, layoutParams);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return Unit.INSTANCE;
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.a6.b$d$b$b, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C5989b extends Lambda implements Function0 {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ com.tencent.magicbrush.ui.g f120878b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C5989b(com.tencent.magicbrush.ui.g gVar) {
                    super(0);
                    this.f120878b = gVar;
                }

                public final void a() {
                    C5988b.this.f120864b.a(this.f120878b);
                    FrameLayout frameLayout = C5988b.this.f120863a;
                    Intrinsics.checkNotNull(frameLayout);
                    frameLayout.removeView(this.f120878b);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return Unit.INSTANCE;
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.a6.b$d$b$c */
            /* loaded from: classes8.dex */
            public static final class c extends Lambda implements Function0 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ int f120879a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ int f120880b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ int f120881c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ int f120882d;

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ C5988b f120883e;

                /* renamed from: f, reason: collision with root package name */
                public final /* synthetic */ com.tencent.magicbrush.ui.g f120884f;

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ int f120885g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public c(int i3, int i16, int i17, int i18, C5988b c5988b, com.tencent.magicbrush.ui.g gVar, int i19) {
                    super(0);
                    this.f120879a = i3;
                    this.f120880b = i16;
                    this.f120881c = i17;
                    this.f120882d = i18;
                    this.f120883e = c5988b;
                    this.f120884f = gVar;
                    this.f120885g = i19;
                }

                public final void a() {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f120879a, this.f120880b);
                    layoutParams.setMargins(this.f120881c, this.f120882d, 0, 0);
                    com.tencent.luggage.wxa.w8.e eVar = this.f120883e.f120864b;
                    FrameLayout frameLayout = this.f120883e.f120863a;
                    Intrinsics.checkNotNull(frameLayout);
                    int a16 = eVar.a(frameLayout, this.f120884f, this.f120885g);
                    if (a16 != -2) {
                        FrameLayout frameLayout2 = this.f120883e.f120863a;
                        Intrinsics.checkNotNull(frameLayout2);
                        frameLayout2.removeView(this.f120884f);
                        FrameLayout frameLayout3 = this.f120883e.f120863a;
                        Intrinsics.checkNotNull(frameLayout3);
                        frameLayout3.addView(this.f120884f, a16, layoutParams);
                    } else {
                        this.f120884f.setLayoutParams(layoutParams);
                        this.f120884f.requestLayout();
                    }
                    this.f120884f.setOpaque(false);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return Unit.INSTANCE;
                }
            }

            public C5988b(b bVar, d dVar, com.tencent.luggage.wxa.r4.d dVar2) {
                this.f120865c = bVar;
                this.f120866d = dVar;
                this.f120867e = dVar2;
            }

            @Override // com.tencent.magicbrush.b.e
            public void a(com.tencent.magicbrush.ui.g view, float[] left, float[] top, float[] width, float[] height) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(left, "left");
                Intrinsics.checkNotNullParameter(top, "top");
                Intrinsics.checkNotNullParameter(width, "width");
                Intrinsics.checkNotNullParameter(height, "height");
            }

            @Override // com.tencent.magicbrush.b.e
            public void b(com.tencent.magicbrush.ui.g view, int i3, int i16, int i17, int i18, int i19) {
                Intrinsics.checkNotNullParameter(view, "view");
                com.tencent.luggage.wxa.bb.a.a(new a(this.f120865c, this, this.f120867e, view, i19, i3, i16, i17, i18));
            }

            @Override // com.tencent.magicbrush.b.e
            public com.tencent.magicbrush.ui.g a() {
                Context context;
                com.tencent.luggage.wxa.a6.e eVar = this.f120865c.f120855a;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mpServiceLogic");
                    eVar = null;
                }
                com.tencent.luggage.wxa.c5.e B = eVar.B();
                if (B == null || (context = B.F()) == null) {
                    context = z.c();
                }
                Intrinsics.checkNotNullExpressionValue(context, "context");
                com.tencent.magicbrush.ui.g gVar = new com.tencent.magicbrush.ui.g(context, g.h.f147524b);
                gVar.setMagicBrush(this.f120866d.d());
                gVar.setUseRawAxisTouchEvent(true);
                return gVar;
            }

            @Override // com.tencent.magicbrush.b.e
            public void a(com.tencent.magicbrush.ui.g view, int i3, int i16, int i17, int i18, int i19) {
                Intrinsics.checkNotNullParameter(view, "view");
                com.tencent.luggage.wxa.bb.a.a(new c(i17, i18, i3, i16, this, view, i19));
            }

            @Override // com.tencent.magicbrush.b.e
            public void a(com.tencent.magicbrush.ui.g view) {
                Intrinsics.checkNotNullParameter(view, "view");
                com.tencent.luggage.wxa.bb.a.a(new C5989b(view));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(j jVar, b bVar, com.tencent.luggage.wxa.r4.d dVar, Context context) {
            super(context, jVar);
            this.f120859f = jVar;
            this.f120860g = bVar;
            this.f120861h = dVar;
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        }

        @Override // com.tencent.luggage.wxa.q1.c, com.tencent.luggage.wxa.q1.d
        public void a(com.tencent.magicbrush.c builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            super.a(builder);
            builder.d(true);
            if (this.f120859f instanceof com.tencent.luggage.wxa.ei.w) {
                builder.a(a.b.f147488e);
            }
            com.tencent.luggage.wxa.a6.e eVar = this.f120860g.f120855a;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mpServiceLogic");
                eVar = null;
            }
            builder.a(eVar.y().c().getNativeHandle());
            builder.b(true);
            builder.a(new a(new WeakReference(this.f120861h)));
            builder.a(new C5988b(this.f120860g, this, this.f120861h));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements ValueCallback {
        public e() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceiveValue(String str) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("run NativeGlobal-WAService.js for ");
            com.tencent.luggage.wxa.a6.e eVar = b.this.f120855a;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mpServiceLogic");
                eVar = null;
            }
            sb5.append(eVar.x());
            sb5.append(" result:");
            sb5.append(str);
            w.d("Luggage.MBInstallerDelegateImplForMiniProgram", sb5.toString());
        }
    }

    static {
        com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k8.c.class, new a());
    }

    public b() {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("MediaToolKit", ""), TuplesKt.to("Image", ""), TuplesKt.to("OffscreenCanvas", ""), TuplesKt.to("Profiler", ""), TuplesKt.to("Box2D", "mmbox2d"), TuplesKt.to("Phys3D", "mmphysx"));
        this.f120857c = mapOf;
    }

    public final synchronized com.tencent.luggage.wxa.q1.c b() {
        com.tencent.luggage.wxa.q1.c cVar = this.f120856b;
        if (cVar != null) {
            return cVar;
        }
        com.tencent.luggage.wxa.a6.e eVar = this.f120855a;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mpServiceLogic");
            eVar = null;
        }
        com.tencent.luggage.wxa.xd.d t16 = eVar.t();
        Intrinsics.checkNotNull(t16);
        com.tencent.luggage.wxa.r4.d dVar = (com.tencent.luggage.wxa.r4.d) t16;
        j jsRuntime = dVar.getJsRuntime();
        Intrinsics.checkNotNull(jsRuntime);
        d dVar2 = new d(jsRuntime, this, dVar, z.c());
        dVar2.b();
        if (dVar.isRunning()) {
            com.tencent.luggage.wxa.c5.e runtime = dVar.getRuntime();
            Intrinsics.checkNotNullExpressionValue(runtime, "component.runtime");
            dVar2.a(runtime);
            com.tencent.luggage.wxa.s1.a.f139989a.a(dVar2.d(), dVar.getRuntime());
        }
        jsRuntime.addJavascriptInterface(new c(), "MagicBrushViewIdTransfer");
        jsRuntime.evaluateJavascript(com.tencent.luggage.wxa.tk.c.b("wxa_library/NativeGlobal-WAService.js"), new e());
        this.f120856b = dVar2;
        return dVar2;
    }

    @Override // com.tencent.luggage.wxa.w1.c
    public com.tencent.magicbrush.b n() {
        try {
            return b().d();
        } catch (Exception e16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("IMagicBrushExtension.getMagicBrush() for ");
            com.tencent.luggage.wxa.a6.e eVar = this.f120855a;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mpServiceLogic");
                eVar = null;
            }
            sb5.append(eVar.x());
            sb5.append(" failed:");
            sb5.append(e16);
            w.b("Luggage.MBInstallerDelegateImplForMiniProgram", sb5.toString());
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.a6.g
    public void a(com.tencent.luggage.wxa.a6.e mpServiceLogic) {
        Intrinsics.checkNotNullParameter(mpServiceLogic, "mpServiceLogic");
        this.f120855a = mpServiceLogic;
        com.tencent.luggage.wxa.aa.h.g("mmskia");
        com.tencent.luggage.wxa.aa.h.g("commonimgdec");
        com.tencent.luggage.wxa.aa.h.g("native-iv");
        com.tencent.luggage.wxa.aa.h.g("mmnode");
        b();
    }

    @Override // com.tencent.luggage.wxa.a6.g
    public void a() {
        com.tencent.luggage.wxa.q1.c cVar = this.f120856b;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // com.tencent.luggage.wxa.a6.g
    public void a(com.tencent.luggage.wxa.ic.g rt5) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        if (this.f120856b != null) {
            com.tencent.luggage.wxa.q1.c b16 = b();
            com.tencent.luggage.wxa.a6.e eVar = this.f120855a;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mpServiceLogic");
                eVar = null;
            }
            com.tencent.luggage.wxa.xd.d t16 = eVar.t();
            Intrinsics.checkNotNull(t16);
            b16.a(rt5);
            com.tencent.luggage.wxa.s1.a.f139989a.a(b16.d(), ((com.tencent.luggage.wxa.r4.d) t16).getRuntime());
        }
    }

    @Override // com.tencent.luggage.wxa.a6.g
    public boolean a(String str, JSONObject jSONObject) {
        if (!this.f120857c.containsKey(str)) {
            return false;
        }
        com.tencent.magicbrush.b d16 = b().d();
        String str2 = (String) this.f120857c.get(str);
        if (!(str2 == null || str2.length() == 0)) {
            d16.a(str2);
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.a6.g
    public Object a(Class cls) {
        if (Intrinsics.areEqual(cls, com.tencent.luggage.wxa.w1.c.class)) {
            return this;
        }
        return null;
    }
}
