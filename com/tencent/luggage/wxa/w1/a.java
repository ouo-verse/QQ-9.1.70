package com.tencent.luggage.wxa.w1;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.eclipsesource.mmv8.V8;
import com.tencent.luggage.sdk.jsapi.component.webaudio.WxAudioNativeInstallHelper;
import com.tencent.luggage.wxa.b9.d;
import com.tencent.luggage.wxa.b9.t;
import com.tencent.luggage.wxa.ei.q;
import com.tencent.luggage.wxa.ei.t;
import com.tencent.luggage.wxa.hn.mc;
import com.tencent.luggage.wxa.ic.d;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.ic.r0;
import com.tencent.luggage.wxa.m4.c;
import com.tencent.luggage.wxa.p8.b;
import com.tencent.luggage.wxa.r4.p;
import com.tencent.luggage.wxa.r4.s;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.x0;
import com.tencent.luggage.wxa.uk.x;
import com.tencent.luggage.wxa.uk.y;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.luggage.wxa.xd.h0;
import com.tencent.luggage.wxa.xd.h1;
import com.tencent.luggage.wxa.xd.i1;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.b;
import com.tencent.magicbrush.handler.fs.IMBFileSystem;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.a;
import com.tencent.magicbrush.ui.g;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mm.plugin.appbrand.debugger.RemoteDebugJsEngine;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import com.tencent.qqmini.miniapp.util.DebugUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.r4.f implements com.tencent.luggage.wxa.w1.b {
    public boolean C;
    public com.tencent.luggage.wxa.q1.b D;
    public com.tencent.luggage.wxa.o4.f E;
    public com.tencent.luggage.wxa.o4.e F;
    public com.tencent.luggage.wxa.o4.c G;
    public com.tencent.luggage.sdk.jsapi.component.network.b H;
    public WxAudioNativeInstallHelper I;
    public com.tencent.luggage.wxa.u1.e J;
    public CronetLogic.CronetTaskNetworkStateCallback K;
    public int L;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f144014i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f144015j;

    /* renamed from: k, reason: collision with root package name */
    public RemoteDebugJsEngine f144016k;

    /* renamed from: l, reason: collision with root package name */
    public p f144017l;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.id.e f144018m;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.w1.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6860a implements com.tencent.luggage.wxa.ei.i {
        public C6860a() {
        }

        @Override // com.tencent.luggage.wxa.ei.i
        public void a(String str, String str2) {
            com.tencent.luggage.wxa.ei.j jsRuntime;
            com.tencent.luggage.wxa.r4.d dVar = (com.tencent.luggage.wxa.r4.d) a.this.t();
            if (dVar == null) {
                jsRuntime = null;
            } else {
                jsRuntime = dVar.getJsRuntime();
            }
            if (jsRuntime == null) {
                return;
            }
            w.b("Luggage.AppBrandGameServiceLogicImp", "[WAGameJsException] hy: wxa main context exception %s %s", str, str2);
            h1.a(jsRuntime, "onError", String.format("{'message':'%s', 'stack': '%s'}", com.tencent.luggage.wxa.uk.w.a(str), com.tencent.luggage.wxa.uk.w.a(str2)), 0);
            com.tencent.luggage.wxa.hk.c.a().a("WeAppLaunch", str, str2);
            a.this.a(str, str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements CronetLogic.CronetTaskNetworkStateCallback {
        public d() {
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskNetworkStateCallback
        public void onNetWeakChange(boolean z16) {
            com.tencent.luggage.wxa.jg.b.a(a.this.t(), z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements b.c {
        public g() {
        }

        @Override // com.tencent.luggage.wxa.p8.b.c
        public String a(String str) {
            if (str.equals(com.tencent.magicbrush.b.f147362s)) {
                return s.a("libmmbox2d");
            }
            if (str.equals(com.tencent.magicbrush.b.f147363t)) {
                return s.a("libmmphysx");
            }
            return com.tencent.luggage.wxa.aa.h.c(str);
        }

        @Override // com.tencent.luggage.wxa.p8.b.c
        public void loadLibrary(String str) {
            if (str.equals(com.tencent.magicbrush.b.f147362s)) {
                String a16 = s.a("libmmbox2d");
                if (a16 == null) {
                    w.b("Luggage.AppBrandGameServiceLogicImp", "libmmbox2d.so path is null");
                    return;
                } else {
                    w.d("Luggage.AppBrandGameServiceLogicImp", "load libmmbox2d.so by path: %s", a16);
                    System.load(a16);
                    return;
                }
            }
            if (str.equals(com.tencent.magicbrush.b.f147363t)) {
                String a17 = s.a("libmmphysx");
                if (a17 == null) {
                    w.b("Luggage.AppBrandGameServiceLogicImp", "libmmphysx.so path is null");
                    return;
                } else {
                    w.d("Luggage.AppBrandGameServiceLogicImp", "load libmmphysx.so by path: %s", a17);
                    System.load(a17);
                    return;
                }
            }
            System.loadLibrary(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.w();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements x.e {
        public i() {
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void a(String str) {
            w.d("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script suc: %s", str);
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void b(String str) {
            w.b("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script Failed: %s", str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f144016k = com.tencent.luggage.wxa.id.g.b().a((com.tencent.luggage.wxa.r4.d) a.this.t());
            if (a.this.f144017l != null) {
                a.this.f144017l.a(a.this.f144016k);
            }
            a aVar = a.this;
            aVar.a(aVar.f144016k);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k {

        /* renamed from: a, reason: collision with root package name */
        public String f144038a;

        /* renamed from: b, reason: collision with root package name */
        public String f144039b;

        /* renamed from: c, reason: collision with root package name */
        public String f144040c;

        /* renamed from: d, reason: collision with root package name */
        public String f144041d;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l implements b.d, b.InterfaceC7010b {
        public l() {
        }

        @Override // com.tencent.magicbrush.b.d
        public void a(String str) {
            w.d("Luggage.AppBrandGameServiceLogicImp", "[WAGame][CONSOLE] output = [%s]", str);
            com.tencent.luggage.wxa.c5.e runtime = ((com.tencent.luggage.wxa.r4.d) a.this.t()).getRuntime();
            if (runtime == null || runtime.j0() == null || runtime.j0().F) {
                a.this.e(str);
            }
        }

        public /* synthetic */ l(a aVar, C6860a c6860a) {
            this();
        }

        @Override // com.tencent.magicbrush.b.InterfaceC7010b
        public void a(int i3) {
            a.this.l0();
        }

        @Override // com.tencent.magicbrush.b.d
        public void a(String str, String str2, int i3) {
            w.b("Luggage.AppBrandGameServiceLogicImp", "[WAGame][AppBrand] message = [%s] stackTrace = [%s]", str, str2);
            t tVar = (t) ((com.tencent.luggage.wxa.r4.d) a.this.t()).getJsRuntime().a(t.class);
            if (i3 == tVar.s().q()) {
                h1.a(((com.tencent.luggage.wxa.r4.d) a.this.t()).getJsRuntime(), "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", com.tencent.luggage.wxa.uk.w.a(str), com.tencent.luggage.wxa.uk.w.a(str2)), 0);
                return;
            }
            com.tencent.luggage.wxa.ei.h f16 = tVar.f(i3);
            if (f16 != null) {
                i1.b(f16, "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", com.tencent.luggage.wxa.uk.w.a(str), com.tencent.luggage.wxa.uk.w.a(str2)), 0);
                return;
            }
            throw new IllegalStateException("j2v8 not follow the pattern");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements g.c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f144043a;

        public m() {
            this.f144043a = true;
        }

        @Override // com.tencent.magicbrush.ui.g.c
        public void a(Object obj, boolean z16) {
        }

        @Override // com.tencent.magicbrush.ui.g.c
        public void a(Object obj, int i3, int i16, boolean z16, boolean z17) {
            if (this.f144043a) {
                this.f144043a = false;
                com.tencent.luggage.wxa.gi.b.b(a.this.x(), com.tencent.luggage.wxa.ik.a.Y);
            } else {
                a();
            }
        }

        public /* synthetic */ m(a aVar, C6860a c6860a) {
            this();
        }

        @Override // com.tencent.magicbrush.ui.g.c
        public void a(Object obj, int i3, int i16) {
            a();
        }

        public final void a() {
            com.tencent.luggage.wxa.r4.d dVar = (com.tencent.luggage.wxa.r4.d) a.this.t();
            if (dVar != null) {
                w.d("Luggage.AppBrandGameServiceLogicImp", "hy: on resizeWindow");
                dVar.a(new com.tencent.luggage.wxa.kj.m());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n implements g.InterfaceC7017g {
        public n() {
        }

        @Override // com.tencent.magicbrush.ui.g.InterfaceC7017g
        public void a(int i3) {
            if (!((com.tencent.luggage.wxa.r4.d) a.this.t()).A() && !((com.tencent.luggage.wxa.r4.d) a.this.t()).isRunning()) {
                return;
            }
            a.this.a(i3);
        }

        public /* synthetic */ n(a aVar, C6860a c6860a) {
            this();
        }
    }

    public a(com.tencent.luggage.wxa.r4.d dVar) {
        super(dVar);
        this.f144014i = false;
        this.f144015j = false;
        this.f144016k = null;
        this.f144018m = null;
        this.C = false;
        this.D = null;
        this.J = null;
        this.K = null;
        this.L = 0;
        a(com.tencent.luggage.wxa.w1.b.class, this);
        n0();
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void F() {
        super.F();
        if (((com.tencent.luggage.wxa.r4.d) t()).getRuntime() != null && ((com.tencent.luggage.wxa.r4.d) t()).getRuntime().R1()) {
            i0();
            V8.setBreakOnStart(Boolean.FALSE);
            y.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), "xdebug", true);
            if (((com.tencent.luggage.wxa.r4.d) t()).z()) {
                y.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), ((com.tencent.luggage.wxa.r4.d) t()).M());
            }
        }
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public boolean L() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void P() {
        w.d("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.init");
        this.f144014i = true;
        h0();
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void Q() {
        w.d("Luggage.AppBrandGameServiceLogicImp", "start preload");
        Z();
        ((com.tencent.luggage.wxa.r4.d) t()).q();
        a0();
        w.d("Luggage.AppBrandGameServiceLogicImp", "WAGameAppService preloaded.");
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void R() {
        super.R();
        p0();
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void S() {
        w.d("Luggage.AppBrandGameServiceLogicImp", "onRuntimeResume");
        super.S();
        o0();
        RemoteDebugJsEngine remoteDebugJsEngine = this.f144016k;
        if (remoteDebugJsEngine != null) {
            remoteDebugJsEngine.J();
        }
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void T() {
        super.T();
        com.tencent.luggage.wxa.q1.b bVar = this.D;
        if (bVar != null) {
            bVar.a();
        }
        RemoteDebugJsEngine remoteDebugJsEngine = this.f144016k;
        if (remoteDebugJsEngine != null) {
            remoteDebugJsEngine.destroy();
        }
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void U() {
        super.U();
        com.tencent.luggage.wxa.o4.f fVar = new com.tencent.luggage.wxa.o4.f();
        this.E = fVar;
        fVar.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), t());
        com.tencent.luggage.wxa.o4.e eVar = new com.tencent.luggage.wxa.o4.e();
        this.F = eVar;
        eVar.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), t());
        com.tencent.luggage.wxa.o4.c cVar = new com.tencent.luggage.wxa.o4.c();
        this.G = cVar;
        cVar.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), t(), 1004);
        com.tencent.luggage.sdk.jsapi.component.network.b bVar = new com.tencent.luggage.sdk.jsapi.component.network.b();
        this.H = bVar;
        bVar.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), t(), 1);
        WxAudioNativeInstallHelper wxAudioNativeInstallHelper = new WxAudioNativeInstallHelper(true);
        this.I = wxAudioNativeInstallHelper;
        wxAudioNativeInstallHelper.createWxAudioBinding(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), t());
        if (B() != null && B().R1()) {
            w.d("Luggage.AppBrandGameServiceLogicImp", "add MPRemoteDebugJSContextInterface");
            com.tencent.luggage.wxa.ei.j jsRuntime = ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime();
            p pVar = new p((com.tencent.luggage.wxa.r4.d) t());
            this.f144017l = pVar;
            jsRuntime.addJavascriptInterface(pVar, "DebuggerConnection");
            RemoteDebugJsEngine remoteDebugJsEngine = this.f144016k;
            if (remoteDebugJsEngine != null) {
                this.f144017l.a(remoteDebugJsEngine);
            }
        }
    }

    public final void Z() {
        boolean z16 = true;
        Object[] objArr = new Object[1];
        if (this.D == null) {
            z16 = false;
        }
        objArr[0] = Boolean.valueOf(z16);
        w.d("Luggage.AppBrandGameServiceLogicImp", "setup magicbrush. loaded?[%b]", objArr);
        if (this.D != null) {
            return;
        }
        ((com.tencent.luggage.wxa.r4.d) t()).r();
        boolean q06 = q0();
        this.C = q06;
        com.tencent.luggage.wxa.q1.b a16 = a(q06);
        this.D = a16;
        a16.b();
        l lVar = new l(this, null);
        this.D.d().v().a(lVar);
        this.D.d().w().a(lVar);
        this.D.d().x().addListener(new f());
        com.tencent.luggage.wxa.p8.b.a(new g());
    }

    public void a(int i3) {
    }

    public final void a0() {
        int length;
        String str;
        if (this.f144015j) {
            return;
        }
        this.f144015j = true;
        w.d("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame to MainContext");
        b0();
        k d06 = d0();
        r0.a((com.tencent.luggage.wxa.ic.d) t(), ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime());
        m0();
        long currentTimeMillis = System.currentTimeMillis();
        boolean A = ((com.tencent.luggage.wxa.r4.d) t()).A();
        String str2 = d06.f144039b;
        if (str2 == null) {
            length = 0;
        } else {
            length = str2.length();
        }
        int i3 = length;
        if (((com.tencent.luggage.wxa.r4.d) t()).getRuntime() != null && ((com.tencent.luggage.wxa.r4.d) t()).getRuntime().R1()) {
            String g16 = ((com.tencent.luggage.wxa.r4.d) t()).i().g("WAServiceRemoteDebug.js");
            if (!TextUtils.isEmpty(g16)) {
                str = g16 + ";";
            } else {
                str = "";
            }
            d06.f144039b = str + ";(function(global) { var protectedConsole = global.console; Object.defineProperty(global, 'console', { get() { return protectedConsole; }, set() { } }); })(this);" + d06.f144039b;
            com.tencent.luggage.wxa.ic.l lVar = (com.tencent.luggage.wxa.ic.l) t();
            com.tencent.luggage.wxa.ei.j jsRuntime = ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime();
            String str3 = d06.f144038a;
            String str4 = d06.f144039b;
            y.a(lVar, jsRuntime, str3, str4, y.e.LIB, new b(str3, str4, currentTimeMillis, i3, A));
            return;
        }
        com.tencent.luggage.wxa.ic.l lVar2 = (com.tencent.luggage.wxa.ic.l) t();
        com.tencent.luggage.wxa.ei.j jsRuntime2 = ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime();
        String str5 = d06.f144038a;
        String str6 = d06.f144040c;
        String str7 = d06.f144041d;
        int g06 = g0();
        String str8 = d06.f144039b;
        y.a(lVar2, jsRuntime2, str5, str6, str7, g06, str8, y.e.LIB, new b(d06.f144038a, str8, currentTimeMillis, i3, A));
    }

    public final void b0() {
        x.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), f0(), new i());
    }

    public final void c0() {
        if (this.f144015j) {
            return;
        }
        ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime().evaluateJavascript(com.tencent.luggage.wxa.tk.c.b("wxa_library/android.js"), null);
    }

    public k d0() {
        k kVar = new k();
        kVar.f144038a = "WAGame.js";
        kVar.f144039b = ((com.tencent.luggage.wxa.r4.d) t()).i().g("WAGame.js");
        kVar.f144040c = "WAGame.js";
        kVar.f144041d = "v" + ((com.tencent.luggage.wxa.r4.d) t()).i().w();
        return kVar;
    }

    public String e0() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.id.c
    public String f() {
        return String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", ((com.tencent.luggage.wxa.r4.d) t()).I().toString(), ((com.tencent.luggage.wxa.r4.d) t()).getRuntime().E().S);
    }

    public String f0() {
        return com.tencent.luggage.wxa.tk.c.b("wxa_library/android.js") + com.tencent.luggage.wxa.tk.c.b("wxa_library/shared_buffer.js") + com.tencent.luggage.wxa.tk.c.b("wxa_library/lazy_load.js") + com.tencent.luggage.wxa.tk.c.b("wxa_library/puppet_wrapper.js") + com.tencent.luggage.wxa.tk.c.b("wxa_library/NativeGlobal-WAGame.js");
    }

    public int g0() {
        return 0;
    }

    public final void h0() {
        w.d("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl mServiceReady = [%b], isRunning[%b]", Boolean.valueOf(this.f144014i), Boolean.valueOf(((com.tencent.luggage.wxa.r4.d) t()).isRunning()));
        if (this.f144014i && ((com.tencent.luggage.wxa.r4.d) t()).isRunning()) {
            try {
                w.d("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl start");
                j0();
                a0();
                ((com.tencent.luggage.wxa.r4.d) t()).a(new h());
            } catch (NullPointerException e16) {
                if (!((com.tencent.luggage.wxa.r4.d) t()).isRunning()) {
                } else {
                    throw e16;
                }
            }
        }
    }

    public final void i0() {
        c0.a(new j());
    }

    @Override // com.tencent.luggage.wxa.w1.b
    public com.tencent.luggage.wxa.u1.e j() {
        if (this.J == null) {
            synchronized (this) {
                if (this.J == null) {
                    this.J = new com.tencent.luggage.wxa.u1.e();
                }
            }
        }
        return this.J;
    }

    public final void j0() {
        c0();
        ((com.tencent.luggage.wxa.r4.d) t()).O();
    }

    public final void k0() {
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(778L, 14L, 1L, false);
    }

    public final void l0() {
        if (((com.tencent.luggage.wxa.r4.d) t()).A() || ((com.tencent.luggage.wxa.r4.d) t()).isRunning()) {
            String x16 = x();
            if (TextUtils.isEmpty(x16)) {
                return;
            }
            com.tencent.luggage.wxa.c2.a.a(x16).a(n());
        }
    }

    public final void m0() {
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(778L, 13L, 1L, false);
    }

    @Override // com.tencent.luggage.wxa.w1.c
    public com.tencent.magicbrush.b n() {
        return this.D.d();
    }

    public void n0() {
        new com.tencent.luggage.wxa.s1.e().b();
    }

    public final void o0() {
        q qVar;
        try {
            com.tencent.luggage.wxa.ei.j jsRuntime = ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime();
            if (jsRuntime != null && (qVar = (q) jsRuntime.a(q.class)) != null) {
                qVar.a(-8);
            }
        } catch (Throwable th5) {
            w.a("Luggage.AppBrandGameServiceLogicImp", th5, "[CAPTURED CRASH]", new Object[0]);
        }
    }

    public final void p0() {
        q qVar;
        try {
            com.tencent.luggage.wxa.ei.j jsRuntime = ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime();
            if (jsRuntime != null && (qVar = (q) jsRuntime.a(q.class)) != null) {
                qVar.a(10);
            }
        } catch (Throwable th5) {
            w.a("Luggage.AppBrandGameServiceLogicImp", th5, "[CAPTURED CRASH]", new Object[0]);
        }
    }

    public boolean q0() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void u() {
        super.u();
        if (B() != null && B().R1()) {
            y.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime());
        }
        com.tencent.luggage.wxa.q1.b bVar = this.D;
        if (bVar != null) {
            bVar.c();
        }
        com.tencent.luggage.wxa.o4.f fVar = this.E;
        if (fVar != null) {
            fVar.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime());
        }
        com.tencent.luggage.wxa.o4.e eVar = this.F;
        if (eVar != null) {
            eVar.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime());
        }
        com.tencent.luggage.wxa.o4.c cVar = this.G;
        if (cVar != null) {
            cVar.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime());
        }
        com.tencent.luggage.sdk.jsapi.component.network.b bVar2 = this.H;
        if (bVar2 != null) {
            bVar2.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime());
        }
        WxAudioNativeInstallHelper wxAudioNativeInstallHelper = this.I;
        if (wxAudioNativeInstallHelper != null) {
            wxAudioNativeInstallHelper.destroyWxAudioBinding(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime());
        }
        CronetLogic.CronetTaskNetworkStateCallback cronetTaskNetworkStateCallback = this.K;
        if (cronetTaskNetworkStateCallback != null) {
            CronetLogic.removeCronetTaskNetworkStateCallback(cronetTaskNetworkStateCallback);
        }
        if (B() != null && B().z1()) {
            com.tencent.luggage.wxa.ei.j jsRuntime = ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime();
            final com.tencent.luggage.wxa.ic.d dVar = (com.tencent.luggage.wxa.ic.d) t();
            List<com.tencent.luggage.wxa.ei.h> a16 = ((t) jsRuntime.a(t.class)).a(true);
            w.d("Luggage.AppBrandGameServiceLogicImp", "post report coverage task for appId:%s, contexts.size:%d", x(), Integer.valueOf(a16.size()));
            final CountDownLatch countDownLatch = new CountDownLatch(a16.size());
            for (final com.tencent.luggage.wxa.ei.h hVar : a16) {
                try {
                    hVar.evaluateJavascript("\n        ;(function() {\n            let data = (globalThis || {}).__coverage__ || new Function(\"return this\")().__coverage__;\n            if (typeof data === 'string' || typeof data === 'undefined') {\n                return data;\n            } else {\n                return JSON.stringify(data);\n            }\n        })();\n    ", new ValueCallback() { // from class: k41.a
                        @Override // android.webkit.ValueCallback
                        public final void onReceiveValue(Object obj) {
                            com.tencent.luggage.wxa.w1.a.a(d.this, hVar, countDownLatch, (String) obj);
                        }
                    });
                } catch (Throwable th5) {
                    w.d("Luggage.AppBrandGameServiceLogicImp", "post report coverage task for appId:%s latch await end", x());
                    throw th5;
                }
            }
            try {
                countDownLatch.await(3L, TimeUnit.SECONDS);
                w.d("Luggage.AppBrandGameServiceLogicImp", "post report coverage task for appId:%s latch await end", x());
            } catch (Exception e16) {
                w.b("Luggage.AppBrandGameServiceLogicImp", "post report coverage task for appId:%s latch await failed:%s", x(), e16);
                w.d("Luggage.AppBrandGameServiceLogicImp", "post report coverage task for appId:%s latch await end", x());
            }
        }
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public com.tencent.luggage.wxa.ei.j v() {
        w.d("Luggage.AppBrandGameServiceLogicImp", "createJsRuntime");
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.luggage.wxa.ei.j a16 = a(e0(), (byte[]) null);
        com.tencent.luggage.wxa.w1.e a17 = a((com.tencent.luggage.wxa.r4.d) t(), (t) a16.a(t.class));
        a16.setJsExceptionHandler(new C6860a());
        a17.a(a16);
        w.d("Luggage.AppBrandGameServiceLogicImp", "[damonlei] createJsRuntime cost [%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return a16;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements x.f {

        /* renamed from: a, reason: collision with root package name */
        public final String f144020a;

        /* renamed from: b, reason: collision with root package name */
        public final String f144021b;

        /* renamed from: c, reason: collision with root package name */
        public final long f144022c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f144023d = false;

        /* renamed from: e, reason: collision with root package name */
        public t.C6044t f144024e = null;

        /* renamed from: f, reason: collision with root package name */
        public final AtomicInteger f144025f = new AtomicInteger(2);

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f144026g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f144027h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ boolean f144028i;

        public b(String str, String str2, long j3, int i3, boolean z16) {
            this.f144026g = j3;
            this.f144027h = i3;
            this.f144028i = z16;
            this.f144022c = j3;
            this.f144020a = str;
            this.f144021b = str2;
        }

        @Override // com.tencent.luggage.wxa.uk.x.f
        public void a(t.C6044t c6044t) {
            this.f144024e = c6044t;
            a();
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void b(String str) {
            w.b("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script Failed: %s", str);
            a.this.k0();
            this.f144023d = false;
            a();
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void a(String str) {
            w.d("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script suc: %s, filelen: %d", str, Integer.valueOf(this.f144027h));
            a.this.a(this.f144028i, this.f144026g, this.f144027h);
            this.f144023d = true;
            a();
        }

        public final void a() {
            if (this.f144025f.decrementAndGet() == 0) {
                t.C6044t c6044t = this.f144024e;
                long j3 = c6044t == null ? this.f144022c : c6044t.f122340a;
                long currentTimeMillis = c6044t == null ? System.currentTimeMillis() : c6044t.f122341b;
                c.a aVar = new c.a();
                aVar.f134095i = this.f144020a;
                aVar.f134096j = this.f144021b;
                aVar.f134097k = w0.d(r0).length();
                com.tencent.luggage.wxa.r4.d dVar = (com.tencent.luggage.wxa.r4.d) a.this.t();
                if (dVar != null) {
                    dVar.a(aVar, this.f144023d, j3, currentTimeMillis, this.f144024e);
                }
                a.this.a(this.f144023d, this.f144020a, this.f144024e);
            }
        }
    }

    public static boolean c(com.tencent.luggage.wxa.ic.g gVar) {
        if (gVar.n0() instanceof WindowAndroidActivityImpl) {
            return ArrayUtils.contains(new int[]{0, 1}, ((WindowAndroidActivityImpl) gVar.n0()).l().getDefaultDisplay().getRotation()) == (e.b.a(gVar.E().a().f125641a) == e.b.PORTRAIT);
        }
        return true;
    }

    public void a(com.tencent.luggage.wxa.zj.c cVar) {
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void b(JSONObject jSONObject) {
        com.tencent.luggage.wxa.j4.g j06 = ((com.tencent.luggage.wxa.r4.d) t()).getRuntime().j0();
        JSONObject optJSONObject = jSONObject.optJSONObject("wxAppInfo");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        try {
            JSONArray jSONArray = new JSONArray();
            int i3 = 0;
            while (true) {
                String[] strArr = j06.f130831g0.O;
                if (i3 >= strArr.length) {
                    break;
                }
                jSONArray.mo162put(strArr[i3]);
                i3++;
            }
            ((com.tencent.luggage.wxa.r4.d) t()).a(optJSONObject, "subContextImgDomain", jSONArray);
        } catch (Exception unused) {
        }
        ((com.tencent.luggage.wxa.r4.d) t()).a(jSONObject, "wxAppInfo", optJSONObject);
        w.d("Luggage.AppBrandGameServiceLogicImp", "dm.widthPixels %d, dm.heightPixels %d", Integer.valueOf(n().t().e()), Integer.valueOf(n().t().d()));
        if (!c(((com.tencent.luggage.wxa.r4.d) t()).getRuntime())) {
            w.b("Luggage.AppBrandGameServiceLogicImp", "hy: orientation judge failed! maybe because onConfigurationChange judgement and surface degree judgement not match");
            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(808L, 4L, 1L, false);
            ((com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class)).a(18284, 1);
        }
        ((com.tencent.luggage.wxa.r4.d) t()).a(jSONObject, "screenWidth", Integer.valueOf(n().t().e()));
        ((com.tencent.luggage.wxa.r4.d) t()).a(jSONObject, "screenHeight", Integer.valueOf(n().t().d()));
        ((com.tencent.luggage.wxa.r4.d) t()).a(jSONObject, "devicePixelRatio", Float.valueOf(n().t().g()));
    }

    public final void e(String str) {
        j().a(str);
    }

    public void a(String str, String str2) {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends g.d {
        public c() {
        }

        @Override // com.tencent.magicbrush.ui.g.e
        public void a(Object obj) {
            com.tencent.luggage.wxa.c5.e B = a.this.B();
            if (B == null || B.c0() == null) {
                return;
            }
            B.c0().a(true);
            B.c0().d();
        }

        @Override // com.tencent.magicbrush.ui.g.c
        public void a(Object obj, boolean z16) {
            com.tencent.luggage.wxa.c5.e B = a.this.B();
            if (B == null || B.c0() == null) {
                return;
            }
            B.c0().a(false);
        }
    }

    public void a(boolean z16, String str, t.C6044t c6044t) {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e extends com.tencent.luggage.wxa.q1.b {
        public e(Context context, com.tencent.luggage.wxa.ei.j jVar, boolean z16) {
            super(context, jVar, z16);
        }

        @Override // com.tencent.luggage.wxa.q1.b, com.tencent.luggage.wxa.q1.d
        public void a(com.tencent.magicbrush.c cVar) {
            super.a(cVar);
            cVar.a(a.b.f147488e);
            cVar.a(a.this.y().c().getNativeHandle());
            cVar.b(true);
            final WeakReference weakReference = new WeakReference((com.tencent.luggage.wxa.ic.l) a.this.t());
            cVar.a(new IMBFileSystem() { // from class: k41.b
                @Override // com.tencent.magicbrush.handler.fs.IMBFileSystem
                public final byte[] readDataFromURLSync(String str) {
                    byte[] a16;
                    a16 = com.tencent.luggage.wxa.s1.a.f139989a.a(str, (l) weakReference.get());
                    return a16;
                }
            });
            cVar.a(new com.tencent.luggage.wxa.ud.b(a.this));
        }

        @Override // com.tencent.luggage.wxa.q1.d
        public void b(com.tencent.luggage.wxa.ic.g gVar) {
            super.b(gVar);
            com.tencent.luggage.wxa.s1.a.f139989a.a(d(), gVar);
        }
    }

    @Override // com.tencent.luggage.wxa.id.c
    public void a(String str) {
        w.a("Luggage.AppBrandGameServiceLogicImp", "RemoteDebugInfo %s", str);
        mc mcVar = new mc();
        mcVar.f128203e = ((com.tencent.luggage.wxa.r4.d) t()).J().getComponentId();
        mcVar.f128202d = str;
        this.f144016k.a(com.tencent.luggage.wxa.id.l.a(mcVar, this.f144016k.D(), DebugUtils.Command.DOM_EVENT));
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public boolean a(String str, JSONObject jSONObject) {
        if ("Image".equals(str) || "OffscreenCanvas".equals(str) || "MediaToolKit".equals(str) || "Profiler".equals(str)) {
            return true;
        }
        if ("Box2D".equals(str)) {
            if (!s.a("libmmbox2d", 10000L)) {
                w.b("Luggage.AppBrandGameServiceLogicImp", "libmmbox2d.so download fail");
                return false;
            }
            n().a(com.tencent.magicbrush.b.f147362s);
            return true;
        }
        if ("Phys3D".equals(str)) {
            if (!s.a("libmmphysx", 10000L)) {
                w.b("Luggage.AppBrandGameServiceLogicImp", "libmmphysx.so download fail");
                return false;
            }
            n().a(com.tencent.magicbrush.b.f147363t);
            return true;
        }
        return super.a(str, jSONObject);
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void b(com.tencent.luggage.wxa.ic.g gVar) {
        super.b(gVar);
        Z();
        com.tencent.luggage.wxa.q1.b bVar = this.D;
        if (bVar != null) {
            bVar.a(gVar);
            if (MBRuntime.q()) {
                boolean z16 = gVar.l0() == 1;
                if (com.tencent.luggage.wxa.tn.e.f141559a || x0.a()) {
                    z16 = true;
                }
                int b16 = z16 ? com.tencent.luggage.wxa.fd.t.b(x()) : 0;
                if (b16 != 0) {
                    if (b16 == 1) {
                        this.L = 1;
                    } else if (b16 == 2) {
                        this.L = 3;
                    } else if (b16 == 3) {
                        this.L = 2;
                    }
                }
                this.D.d().b(b16);
            }
        }
        com.tencent.luggage.sdk.jsapi.component.network.b bVar2 = this.H;
        if (bVar2 != null) {
            bVar2.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), (com.tencent.luggage.wxa.xd.i) t());
        }
        com.tencent.luggage.wxa.o4.c cVar = this.G;
        if (cVar != null) {
            cVar.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), t());
        }
        WxAudioNativeInstallHelper wxAudioNativeInstallHelper = this.I;
        if (wxAudioNativeInstallHelper != null) {
            wxAudioNativeInstallHelper.initConfigWXAudio(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), (com.tencent.luggage.wxa.xd.i) t());
        }
        o0();
        gVar.a(com.tencent.luggage.wxa.ok.n.class, new com.tencent.luggage.wxa.d2.a(gVar));
        n().x().addSurfaceListenerForAllViews(new c());
        this.I.listenLifeCycle(t());
        this.K = new d();
        CronetLogic.initializeNativeLib();
        CronetLogic.addCronetTaskNetworkStateCallback(this.K);
        CronetLogic.setGoodNetNotifyInterval(com.tencent.luggage.wxa.im.a.b().a("clicfg_android_cronet_weak_net_notify_interval", 5000, true));
    }

    public com.tencent.luggage.wxa.ei.j a(String str, byte[] bArr) {
        d.a aVar = new d.a(str, bArr);
        aVar.f122191g = true;
        aVar.f122190f = "1";
        aVar.f122193i = true;
        aVar.f122199o = new WeakReference((com.tencent.luggage.wxa.xd.e) t());
        return new com.tencent.luggage.wxa.ei.c(aVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements MBViewManager.a {
        public f() {
        }

        @Override // com.tencent.magicbrush.ui.MBViewManager.a
        public void a(com.tencent.magicbrush.ui.g gVar) {
            C6860a c6860a = null;
            gVar.a(new n(a.this, c6860a));
            gVar.a(new m(a.this, c6860a));
        }

        @Override // com.tencent.magicbrush.ui.MBViewManager.a
        public void b(com.tencent.magicbrush.ui.g gVar) {
        }
    }

    public com.tencent.luggage.wxa.w1.e a(com.tencent.luggage.wxa.r4.d dVar, com.tencent.luggage.wxa.ei.t tVar) {
        return new com.tencent.luggage.wxa.w1.e(dVar, tVar);
    }

    public static /* synthetic */ void a(com.tencent.luggage.wxa.ic.d dVar, com.tencent.luggage.wxa.ei.h hVar, CountDownLatch countDownLatch, String str) {
        h0.a(dVar, hVar, str);
        countDownLatch.countDown();
    }

    public com.tencent.luggage.wxa.q1.b a(boolean z16) {
        return new e(((com.tencent.luggage.wxa.r4.d) t()).getContext(), ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), z16);
    }

    public final void a(boolean z16, long j3, int i3) {
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(778L, 15L, 1L, false);
    }

    @Override // com.tencent.luggage.wxa.xi.e
    public final boolean b(String str) {
        w.d("Luggage.AppBrandGameServiceLogicImp", "hy: do nothing in game service when called from modularizing helper");
        return false;
    }
}
