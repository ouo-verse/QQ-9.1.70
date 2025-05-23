package com.tencent.luggage.wxa.r4;

import android.content.res.AssetFileDescriptor;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.eclipsesource.mmv8.V8;
import com.tencent.luggage.sdk.jsapi.component.webaudio.WxAudioNativeInstallHelper;
import com.tencent.luggage.wxa.b9.g0;
import com.tencent.luggage.wxa.b9.t;
import com.tencent.luggage.wxa.hn.mc;
import com.tencent.luggage.wxa.ic.f0;
import com.tencent.luggage.wxa.ic.r0;
import com.tencent.luggage.wxa.m4.c;
import com.tencent.luggage.wxa.mc.k0;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.x;
import com.tencent.luggage.wxa.uk.y;
import com.tencent.luggage.wxa.xd.h0;
import com.tencent.luggage.wxa.xd.h1;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.debugger.RemoteDebugJsEngine;
import com.tencent.qqmini.miniapp.util.DebugUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.r4.f implements com.tencent.luggage.wxa.id.c {
    public com.tencent.luggage.wxa.o4.e C;
    public final int[] D;
    public com.tencent.luggage.sdk.jsapi.component.network.b E;
    public WxAudioNativeInstallHelper F;
    public RemoteDebugJsEngine G;
    public p H;
    public CronetLogic.CronetTaskNetworkStateCallback I;
    public final f0 J;
    public final Map K;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f139135i;

    /* renamed from: j, reason: collision with root package name */
    public final n f139136j;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f139137k;

    /* renamed from: l, reason: collision with root package name */
    public volatile boolean f139138l;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.o4.f f139139m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.ei.i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ei.j f139140a;

        public a(com.tencent.luggage.wxa.ei.j jVar) {
            this.f139140a = jVar;
        }

        @Override // com.tencent.luggage.wxa.ei.i
        public void a(String str, String str2) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandMiniProgramServiceLogicImp", "hy: wxa main context exception %s %s", str, str2);
            String format = String.format("{'message':'%s', 'stack': '%s'}", com.tencent.luggage.wxa.uk.w.a(str), com.tencent.luggage.wxa.uk.w.a(str2));
            h1.a(this.f139140a, "onError", format, 0);
            c.this.a(str, str2);
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.JsRuntimeException", format);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements CronetLogic.CronetTaskNetworkStateCallback {
        public b() {
        }

        @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskNetworkStateCallback
        public void onNetWeakChange(boolean z16) {
            com.tencent.luggage.wxa.jg.b.a(c.this.t(), z16);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.r4.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6671c implements x.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f139143a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f139144b;

        public C6671c(long j3, boolean z16) {
            this.f139143a = j3;
            this.f139144b = z16;
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void a(String str) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Success");
            com.tencent.luggage.wxa.r4.d dVar = (com.tencent.luggage.wxa.r4.d) c.this.t();
            if (dVar == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f139143a;
            boolean z16 = this.f139144b;
            g0.a(3, currentTimeMillis, z16 ? 1 : 0, dVar.getAppId(), -1, 0, dVar.i().w());
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void b(String str) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Failed");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends g {

        /* renamed from: m, reason: collision with root package name */
        public String f139146m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f139147n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ Runnable f139148o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, AssetFileDescriptor assetFileDescriptor, com.tencent.luggage.wxa.r4.d dVar, c cVar, boolean z16, Runnable runnable) {
            super(str, assetFileDescriptor, dVar, cVar, z16, (a) null);
            this.f139148o = runnable;
        }

        @Override // com.tencent.luggage.wxa.r4.c.g, com.tencent.luggage.wxa.uk.x.f
        public void a(t.C6044t c6044t) {
            super.a(c6044t);
            if (this.f139147n && "Abort for empty source".equals(this.f139146m)) {
                this.f139148o.run();
            } else {
                super.b(this.f139146m);
            }
        }

        @Override // com.tencent.luggage.wxa.r4.c.g, com.tencent.luggage.wxa.uk.x.e
        public void b(String str) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandMiniProgramServiceLogicImp", "execInternalInitScript with fd, onFailure:%s", str);
            this.f139146m = str;
            this.f139147n = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.G = com.tencent.luggage.wxa.id.g.b().a((com.tencent.luggage.wxa.r4.d) c.this.t());
            if (c.this.H != null) {
                c.this.H.a(c.this.G);
            }
            c cVar = c.this;
            cVar.a(cVar.G);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public String f139151a;

        /* renamed from: b, reason: collision with root package name */
        public AssetFileDescriptor f139152b;

        /* renamed from: c, reason: collision with root package name */
        public String f139153c;

        /* renamed from: d, reason: collision with root package name */
        public String f139154d;

        /* renamed from: e, reason: collision with root package name */
        public String f139155e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f139156f = false;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class g implements x.f {

        /* renamed from: a, reason: collision with root package name */
        public final String f139157a;

        /* renamed from: b, reason: collision with root package name */
        public final String f139158b;

        /* renamed from: c, reason: collision with root package name */
        public final long f139159c;

        /* renamed from: d, reason: collision with root package name */
        public final com.tencent.luggage.wxa.r4.d f139160d;

        /* renamed from: e, reason: collision with root package name */
        public final c f139161e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f139162f;

        /* renamed from: g, reason: collision with root package name */
        public final AssetFileDescriptor f139163g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f139164h;

        /* renamed from: i, reason: collision with root package name */
        public t.C6044t f139165i;

        /* renamed from: j, reason: collision with root package name */
        public final AtomicInteger f139166j;

        /* renamed from: k, reason: collision with root package name */
        public final long f139167k;

        /* renamed from: l, reason: collision with root package name */
        public final int f139168l;

        public /* synthetic */ g(String str, AssetFileDescriptor assetFileDescriptor, com.tencent.luggage.wxa.r4.d dVar, c cVar, boolean z16, a aVar) {
            this(str, assetFileDescriptor, dVar, cVar, z16);
        }

        @Override // com.tencent.luggage.wxa.uk.x.f
        public void a(t.C6044t c6044t) {
            this.f139165i = c6044t;
            a();
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void b(String str) {
            this.f139164h = false;
            a();
        }

        public /* synthetic */ g(String str, String str2, com.tencent.luggage.wxa.r4.d dVar, c cVar, boolean z16, a aVar) {
            this(str, str2, dVar, cVar, z16);
        }

        public g(String str, String str2, com.tencent.luggage.wxa.r4.d dVar, c cVar, boolean z16) {
            this.f139164h = false;
            this.f139165i = null;
            this.f139166j = new AtomicInteger(2);
            this.f139157a = str;
            this.f139158b = str2;
            this.f139159c = w0.d(str2).length();
            this.f139163g = null;
            this.f139160d = dVar;
            this.f139161e = cVar;
            this.f139162f = z16;
            this.f139167k = System.currentTimeMillis();
            this.f139168l = com.tencent.luggage.wxa.lk.j.b(dVar.getComponentId() + "", "public:inject", "\u4ee3\u7801\u6ce8\u5165-" + str);
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void a(String str) {
            this.f139164h = true;
            a();
            if (this.f139157a.equals("WAService.js")) {
                long currentTimeMillis = System.currentTimeMillis() - this.f139167k;
                boolean z16 = this.f139162f;
                g0.a(2, currentTimeMillis, z16 ? 1 : 0, this.f139160d.getAppId(), -1, 0, this.f139160d.i().w());
            }
        }

        public final void a() {
            if (this.f139166j.decrementAndGet() == 0) {
                t.C6044t c6044t = this.f139165i;
                long j3 = c6044t == null ? this.f139167k : c6044t.f122340a;
                long currentTimeMillis = c6044t == null ? System.currentTimeMillis() : c6044t.f122341b;
                c.a aVar = new c.a();
                aVar.f134095i = this.f139157a;
                aVar.f134096j = this.f139158b;
                aVar.f134097k = this.f139159c;
                this.f139160d.a(aVar, this.f139164h, j3, currentTimeMillis, this.f139165i);
                this.f139161e.a(this.f139164h, this.f139157a, this.f139165i);
                com.tencent.luggage.wxa.lk.j.b(this.f139160d.getAppId(), this.f139168l);
            }
        }

        public g(String str, AssetFileDescriptor assetFileDescriptor, com.tencent.luggage.wxa.r4.d dVar, c cVar, boolean z16) {
            this.f139164h = false;
            this.f139165i = null;
            this.f139166j = new AtomicInteger(2);
            this.f139157a = str;
            this.f139158b = null;
            this.f139163g = assetFileDescriptor;
            this.f139159c = assetFileDescriptor.getLength();
            this.f139160d = dVar;
            this.f139161e = cVar;
            this.f139162f = z16;
            this.f139167k = System.currentTimeMillis();
            this.f139168l = com.tencent.luggage.wxa.lk.j.b(dVar.getComponentId() + "", "public:inject", "\u4ee3\u7801\u6ce8\u5165-" + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class h implements x.f {

        /* renamed from: a, reason: collision with root package name */
        public final String f139169a;

        /* renamed from: b, reason: collision with root package name */
        public final com.tencent.luggage.wxa.r4.d f139170b;

        /* renamed from: c, reason: collision with root package name */
        public int f139171c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f139172d;

        /* renamed from: e, reason: collision with root package name */
        public t.C6044t f139173e;

        /* renamed from: f, reason: collision with root package name */
        public final AtomicInteger f139174f;

        /* renamed from: g, reason: collision with root package name */
        public final long f139175g;

        /* renamed from: h, reason: collision with root package name */
        public final int f139176h;

        public /* synthetic */ h(String str, com.tencent.luggage.wxa.r4.d dVar, a aVar) {
            this(str, dVar);
        }

        @Override // com.tencent.luggage.wxa.uk.x.f
        public void a(t.C6044t c6044t) {
            this.f139173e = c6044t;
            this.f139171c = c6044t.sourceLength;
            a();
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void b(String str) {
            this.f139172d = false;
            a();
        }

        public h(String str, com.tencent.luggage.wxa.r4.d dVar) {
            this.f139171c = 0;
            this.f139172d = false;
            this.f139173e = null;
            this.f139174f = new AtomicInteger(2);
            this.f139169a = str;
            this.f139170b = dVar;
            this.f139175g = System.currentTimeMillis();
            this.f139176h = com.tencent.luggage.wxa.lk.j.b(dVar.getComponentId() + "", "public:inject", "\u4ee3\u7801\u6ce8\u5165-" + str);
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void a(String str) {
            this.f139172d = true;
            a();
        }

        public final void a() {
            if (this.f139174f.decrementAndGet() == 0) {
                t.C6044t c6044t = this.f139173e;
                long j3 = c6044t == null ? this.f139175g : c6044t.f122340a;
                long currentTimeMillis = c6044t == null ? System.currentTimeMillis() : c6044t.f122341b;
                c.a aVar = new c.a();
                aVar.f134095i = this.f139169a;
                aVar.f134097k = this.f139171c;
                this.f139170b.a(aVar, this.f139172d, j3, currentTimeMillis, this.f139173e);
                com.tencent.luggage.wxa.lk.j.b(this.f139170b.getComponentId() + "", this.f139176h);
            }
        }
    }

    public c(com.tencent.luggage.wxa.r4.d dVar) {
        super(dVar);
        this.f139135i = false;
        this.f139137k = false;
        this.f139138l = false;
        this.D = new int[]{-1};
        this.G = null;
        this.I = null;
        this.J = new f0() { // from class: com.tencent.luggage.wxa.r4.x
            @Override // com.tencent.luggage.wxa.ic.f0
            public final void a(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.fd.i iVar) {
                c.this.a(gVar, iVar);
            }
        };
        this.K = new HashMap();
        this.f139136j = new n(this);
        a(com.tencent.luggage.wxa.id.c.class, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(String str) {
        if (L()) {
            try {
                com.tencent.luggage.wxa.r4.h hVar = new com.tencent.luggage.wxa.r4.h(str);
                com.tencent.luggage.wxa.r4.d dVar = (com.tencent.luggage.wxa.r4.d) t();
                Objects.requireNonNull(dVar);
                hVar.a(dVar);
                return;
            } catch (Exception unused) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandMiniProgramServiceLogicImp", "loadModule using isolate context, notify but get exception %s");
                return;
            }
        }
        if (ModulePkgInfo.MAIN_MODULE_NAME.equals(str)) {
            a0();
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(str.endsWith("/") ? "" : "/");
        sb5.append("app-service.js");
        String sb6 = sb5.toString();
        com.tencent.luggage.wxa.uk.y.a(((com.tencent.luggage.wxa.r4.d) t()).getRuntime(), ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), k0.b(((com.tencent.luggage.wxa.r4.d) t()).getRuntime()).e(sb6).d(), sb6, "", "", y.e.USR, new h(sb6, (com.tencent.luggage.wxa.r4.d) t(), null));
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void F() {
        super.F();
        if (((com.tencent.luggage.wxa.r4.d) t()).getRuntime() != null && ((com.tencent.luggage.wxa.r4.d) t()).getRuntime().R1() && com.tencent.luggage.wxa.id.l.a(((com.tencent.luggage.wxa.r4.d) t()).getRuntime().S().P)) {
            g0();
            V8.setBreakOnStart(Boolean.FALSE);
            com.tencent.luggage.wxa.uk.y.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), "xdebug", true);
            if (((com.tencent.luggage.wxa.r4.d) t()).z()) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandMiniProgramServiceLogicImp", "debugBreakForPreload");
                com.tencent.luggage.wxa.uk.y.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), ((com.tencent.luggage.wxa.r4.d) t()).M());
            }
        }
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public boolean L() {
        return this.f139135i;
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void P() {
        com.tencent.luggage.wxa.lk.j.a(z(), "public:prepare", "\u6ce8\u5165WXConfig");
        h0();
        com.tencent.luggage.wxa.lk.j.c(z());
        com.tencent.luggage.wxa.lk.j.a(z(), "public:prepare", "\u57fa\u7840\u5e93\u6ce8\u5165");
        a(false);
        com.tencent.luggage.wxa.lk.j.c(z());
        com.tencent.luggage.wxa.lk.j.a(z(), "public:prepare", "\u4ee3\u7801\u6ce8\u5165(\u5982\u6709\u5fc5\u8981)");
        a0();
        com.tencent.luggage.wxa.lk.j.c(z());
        w();
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void Q() {
        ((com.tencent.luggage.wxa.r4.d) t()).q();
        a(true);
        a(new ValueCallback() { // from class: com.tencent.luggage.wxa.r4.ac
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                ((e) obj).d();
            }
        });
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void R() {
        super.R();
        m0();
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void S() {
        super.S();
        l0();
        RemoteDebugJsEngine remoteDebugJsEngine = this.G;
        if (remoteDebugJsEngine != null) {
            remoteDebugJsEngine.J();
        }
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void T() {
        super.T();
        RemoteDebugJsEngine remoteDebugJsEngine = this.G;
        if (remoteDebugJsEngine != null) {
            remoteDebugJsEngine.destroy();
        }
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void U() {
        com.tencent.luggage.wxa.r4.b a16;
        super.U();
        com.tencent.luggage.wxa.ei.j jsRuntime = ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime();
        com.tencent.luggage.wxa.ei.t tVar = (com.tencent.luggage.wxa.ei.t) jsRuntime.a(com.tencent.luggage.wxa.ei.t.class);
        if (tVar != null && (a16 = a(jsRuntime, tVar)) != null) {
            jsRuntime.addJavascriptInterface(a16, "WeixinJSContext");
            jsRuntime.evaluateJavascript(m.f139227b, null);
            a16.f();
            this.f139135i = true;
        } else {
            this.f139135i = false;
        }
        if (B() != null && B().R1()) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandMiniProgramServiceLogicImp", "run in debug mode, add MPRemoteDebugJSContextInterface");
            p pVar = new p((com.tencent.luggage.wxa.r4.d) t());
            this.H = pVar;
            jsRuntime.addJavascriptInterface(pVar, "DebuggerConnection");
            RemoteDebugJsEngine remoteDebugJsEngine = this.G;
            if (remoteDebugJsEngine != null) {
                this.H.a(remoteDebugJsEngine);
            }
        }
        jsRuntime.setJsExceptionHandler(new a(jsRuntime));
        if (!p0()) {
            com.tencent.luggage.wxa.o4.f fVar = new com.tencent.luggage.wxa.o4.f();
            this.f139139m = fVar;
            fVar.a(jsRuntime, t());
        }
        if (!o0()) {
            com.tencent.luggage.wxa.o4.e eVar = new com.tencent.luggage.wxa.o4.e();
            this.C = eVar;
            eVar.a(jsRuntime, t());
        }
        if (!r0()) {
            com.tencent.luggage.sdk.jsapi.component.network.b bVar = new com.tencent.luggage.sdk.jsapi.component.network.b();
            this.E = bVar;
            bVar.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), t(), 0);
        }
        if (!q0()) {
            WxAudioNativeInstallHelper wxAudioNativeInstallHelper = new WxAudioNativeInstallHelper();
            this.F = wxAudioNativeInstallHelper;
            wxAudioNativeInstallHelper.createWxAudioBinding(jsRuntime, t());
        }
    }

    public void a(com.tencent.luggage.wxa.zj.c cVar) {
    }

    public final void a0() {
        try {
            if (L()) {
                return;
            }
            if (this.f139138l) {
                return;
            }
            Z();
            String str = ((com.tencent.luggage.wxa.r4.d) t()).getRuntime().j0().f125966l.pkgPath;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.tencent.luggage.wxa.uk.y.a(((com.tencent.luggage.wxa.r4.d) t()).getRuntime(), ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), str, "app-service.js", "", "", y.e.USR, new h("app-service.js", (com.tencent.luggage.wxa.r4.d) t(), null));
            this.f139138l = true;
        } finally {
            this.f139136j.b();
        }
    }

    public final void b0() {
        if (this.f139137k) {
            return;
        }
        ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime().evaluateJavascript(com.tencent.luggage.wxa.tk.c.b("wxa_library/android.js"), null);
    }

    public f c0() {
        String[] strArr;
        AssetFileDescriptor assetFileDescriptor;
        if (L()) {
            strArr = new String[]{"WAServiceMainContext.js", "WAService.js"};
        } else {
            strArr = new String[]{"WAService.js"};
        }
        for (String str : strArr) {
            if (k0()) {
                assetFileDescriptor = ((com.tencent.luggage.wxa.r4.d) t()).i().d(str);
            } else {
                assetFileDescriptor = null;
            }
            if (assetFileDescriptor != null) {
                f fVar = new f();
                fVar.f139151a = str;
                fVar.f139152b = assetFileDescriptor;
                return fVar;
            }
            String g16 = ((com.tencent.luggage.wxa.r4.d) t()).i().g(str);
            if (!TextUtils.isEmpty(g16)) {
                f fVar2 = new f();
                fVar2.f139151a = str;
                fVar2.f139153c = g16;
                return fVar2;
            }
        }
        throw new IllegalStateException(String.format(Locale.US, "boostrap(%s) scripts not found", ArrayUtils.toString(strArr)));
    }

    public String d0() {
        String str = "" + com.tencent.luggage.wxa.tk.c.b("wxa_library/android.js");
        com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandMiniProgramServiceLogicImp", "getEnvBootstrapScript, android.js.length=%d", Integer.valueOf(str.length()));
        String str2 = ((str + "\n;(function(global){ delete global.NativeGlobal.invokeHandler; })(this);\n") + com.tencent.luggage.wxa.tk.c.b("wxa_library/shared_buffer.js")) + com.tencent.luggage.wxa.tk.c.b("wxa_library/lazy_load.js");
        LinkedList linkedList = new LinkedList();
        if (q0()) {
            linkedList.add("WXAUDIO");
        }
        if (o0()) {
            linkedList.add("TCP");
        }
        if (p0()) {
            linkedList.add("UDP");
        }
        if (r0()) {
            linkedList.add("WSS");
        }
        if (!linkedList.isEmpty()) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                str2 = str2 + com.tencent.luggage.wxa.tk.c.b("wxa_library/wx_global_ctor_module_lazy_load.js").replaceFirst(Pattern.quote("${__module__}"), (String) it.next());
            }
        }
        return str2;
    }

    public final boolean e(final String str) {
        Boolean bool = (Boolean) this.K.get(str);
        if (bool != null && bool.booleanValue()) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandMiniProgramServiceLogicImp", "guardedCheckLoadModule appId:%s, name:%s, module already injected", x(), str);
            return false;
        }
        this.K.put(str, Boolean.TRUE);
        com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandMiniProgramServiceLogicImp", "guardedCheckLoadModule appId:%s, name:%s, before injection", x(), str);
        this.f139136j.a(new Runnable() { // from class: com.tencent.luggage.wxa.r4.ab
            @Override // java.lang.Runnable
            public final void run() {
                c.this.f(str);
            }
        });
        return true;
    }

    public int e0() {
        return 0;
    }

    public final com.tencent.luggage.wxa.ei.j f0() {
        return ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime();
    }

    public final void g0() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandMiniProgramServiceLogicImp", "initRemoteDebug");
        c0.a(new e());
    }

    public final void h0() {
        b0();
        ((com.tencent.luggage.wxa.r4.d) t()).O();
    }

    public final void i0() {
        com.tencent.luggage.wxa.c5.e B = B();
        if (B == null) {
            return;
        }
        B.a(this.J);
    }

    public final boolean j0() {
        com.tencent.luggage.wxa.c5.e B = B();
        if (B == null) {
            return false;
        }
        return B.x1();
    }

    public boolean k0() {
        return true;
    }

    public final void l0() {
        com.tencent.luggage.wxa.ei.q qVar;
        int i3;
        try {
            com.tencent.luggage.wxa.ei.j jsRuntime = ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime();
            if (jsRuntime != null && (qVar = (com.tencent.luggage.wxa.ei.q) jsRuntime.a(com.tencent.luggage.wxa.ei.q.class)) != null) {
                if (j0()) {
                    i3 = -4;
                } else {
                    i3 = -2;
                }
                com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandMiniProgramServiceLogicImp", "setJSThreadHighPriority, priority: %d", Integer.valueOf(i3));
                qVar.a(i3);
            }
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.tn.w.a("Luggage.AppBrandMiniProgramServiceLogicImp", th5, "[CAPTURED CRASH]", new Object[0]);
        }
    }

    public final void m0() {
        com.tencent.luggage.wxa.ei.q qVar;
        try {
            com.tencent.luggage.wxa.ei.j jsRuntime = ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime();
            if (jsRuntime != null && (qVar = (com.tencent.luggage.wxa.ei.q) jsRuntime.a(com.tencent.luggage.wxa.ei.q.class)) != null) {
                qVar.a(10);
            }
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.tn.w.a("Luggage.AppBrandMiniProgramServiceLogicImp", th5, "[CAPTURED CRASH]", new Object[0]);
        }
    }

    public boolean n0() {
        return false;
    }

    public final boolean o0() {
        return true;
    }

    public final boolean p0() {
        return true;
    }

    public final boolean q0() {
        return true;
    }

    public final boolean r0() {
        boolean z16;
        int i3;
        synchronized (this.D) {
            int[] iArr = this.D;
            z16 = false;
            if (iArr[0] == -1) {
                if (t() != null && ((com.tencent.luggage.wxa.r4.d) t()).e0() == com.tencent.luggage.wxa.dk.a.PreloadOnProcessCreated) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                iArr[0] = i3;
            }
            if (this.D[0] == 1) {
                z16 = true;
            }
        }
        return z16;
    }

    public final void s0() {
        com.tencent.luggage.wxa.c5.e B = B();
        if (B == null) {
            return;
        }
        B.b(this.J);
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void u() {
        super.u();
        if (B() != null && B().R1()) {
            com.tencent.luggage.wxa.uk.y.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime());
        }
        s0();
        com.tencent.luggage.wxa.o4.f fVar = this.f139139m;
        if (fVar != null) {
            fVar.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime());
        }
        com.tencent.luggage.wxa.o4.e eVar = this.C;
        if (eVar != null) {
            eVar.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime());
        }
        com.tencent.luggage.sdk.jsapi.component.network.b bVar = this.E;
        if (bVar != null) {
            bVar.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime());
        }
        WxAudioNativeInstallHelper wxAudioNativeInstallHelper = this.F;
        if (wxAudioNativeInstallHelper != null) {
            wxAudioNativeInstallHelper.destroyWxAudioBinding(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime());
        }
        CronetLogic.CronetTaskNetworkStateCallback cronetTaskNetworkStateCallback = this.I;
        if (cronetTaskNetworkStateCallback != null) {
            CronetLogic.removeCronetTaskNetworkStateCallback(cronetTaskNetworkStateCallback);
        }
        if (B() != null && B().z1()) {
            com.tencent.luggage.wxa.ei.j jsRuntime = ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime();
            final com.tencent.luggage.wxa.ic.d dVar = (com.tencent.luggage.wxa.ic.d) t();
            List<com.tencent.luggage.wxa.ei.h> a16 = ((com.tencent.luggage.wxa.ei.t) jsRuntime.a(com.tencent.luggage.wxa.ei.t.class)).a(true);
            com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandMiniProgramServiceLogicImp", "post report coverage task for appId:%s, contexts.size:%d", x(), Integer.valueOf(a16.size()));
            final CountDownLatch countDownLatch = new CountDownLatch(a16.size());
            for (final com.tencent.luggage.wxa.ei.h hVar : a16) {
                hVar.evaluateJavascript("\n        ;(function() {\n            let data = (globalThis || {}).__coverage__ || new Function(\"return this\")().__coverage__;\n            if (typeof data === 'string' || typeof data === 'undefined') {\n                return data;\n            } else {\n                return JSON.stringify(data);\n            }\n        })();\n    ", new ValueCallback() { // from class: com.tencent.luggage.wxa.r4.y
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        c.a(com.tencent.luggage.wxa.ic.d.this, hVar, countDownLatch, (String) obj);
                    }
                });
            }
            try {
                try {
                    countDownLatch.await(3L, TimeUnit.SECONDS);
                    com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandMiniProgramServiceLogicImp", "post report coverage task for appId:%s latch await end", x());
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandMiniProgramServiceLogicImp", "post report coverage task for appId:%s latch await failed:%s", x(), e16);
                    com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandMiniProgramServiceLogicImp", "post report coverage task for appId:%s latch await end", x());
                }
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandMiniProgramServiceLogicImp", "post report coverage task for appId:%s latch await end", x());
                throw th5;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public com.tencent.luggage.wxa.ei.j v() {
        return new com.tencent.luggage.wxa.ei.d(null, null);
    }

    public void a(String str, String str2) {
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void b(com.tencent.luggage.wxa.ic.g gVar) {
        super.b(gVar);
        Objects.requireNonNull((com.tencent.luggage.wxa.r4.d) t());
        com.tencent.luggage.sdk.jsapi.component.network.b bVar = this.E;
        if (bVar != null) {
            bVar.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), (com.tencent.luggage.wxa.xd.i) t());
        }
        WxAudioNativeInstallHelper wxAudioNativeInstallHelper = this.F;
        if (wxAudioNativeInstallHelper != null) {
            wxAudioNativeInstallHelper.initConfigWXAudio(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), (com.tencent.luggage.wxa.xd.i) t());
        }
        l0();
        i0();
        gVar.a(com.tencent.luggage.wxa.ok.n.class, new com.tencent.luggage.wxa.ok.r(gVar));
        WxAudioNativeInstallHelper wxAudioNativeInstallHelper2 = this.F;
        if (wxAudioNativeInstallHelper2 != null) {
            wxAudioNativeInstallHelper2.listenLifeCycle(t());
        }
        b bVar2 = new b();
        this.I = bVar2;
        CronetLogic.addCronetTaskNetworkStateCallback(bVar2);
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public String c(String str) {
        return J() ? com.tencent.luggage.wxa.id.l.a(str, ((com.tencent.luggage.wxa.r4.d) t()).getRuntime()) : "";
    }

    public void a(boolean z16, String str, t.C6044t c6044t) {
    }

    public com.tencent.luggage.wxa.r4.b a(com.tencent.luggage.wxa.ei.j jVar, com.tencent.luggage.wxa.ei.t tVar) {
        return new o((com.tencent.luggage.wxa.r4.d) t(), tVar);
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public boolean a(String str, JSONObject jSONObject) {
        if (StringUtils.equalsIgnoreCase("WXAUDIO", str)) {
            if (!q0()) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandMiniProgramServiceLogicImp", "WXAUDIO LazyLoad is not supported! appId:%s", x());
                return false;
            }
            WxAudioNativeInstallHelper wxAudioNativeInstallHelper = new WxAudioNativeInstallHelper();
            this.F = wxAudioNativeInstallHelper;
            wxAudioNativeInstallHelper.createWxAudioBinding(f0(), t());
            this.F.initConfigWXAudio(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), (com.tencent.luggage.wxa.xd.i) t());
            if (B() != null) {
                this.F.listenLifeCycle(t());
            }
            return true;
        }
        if (StringUtils.equalsIgnoreCase("TCP", str)) {
            if (!o0()) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandMiniProgramServiceLogicImp", "TCP LazyLoad is not supported! appId:%s", x());
                return false;
            }
            com.tencent.luggage.wxa.o4.e eVar = new com.tencent.luggage.wxa.o4.e();
            this.C = eVar;
            eVar.a(f0(), t());
            return true;
        }
        if (StringUtils.equalsIgnoreCase("UDP", str)) {
            if (!p0()) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandMiniProgramServiceLogicImp", "UDP LazyLoad is not supported! appId:%s", x());
                return false;
            }
            com.tencent.luggage.wxa.o4.f fVar = new com.tencent.luggage.wxa.o4.f();
            this.f139139m = fVar;
            fVar.a(f0(), t());
            return true;
        }
        if (StringUtils.equalsIgnoreCase("WSS", str)) {
            if (!r0()) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandMiniProgramServiceLogicImp", "WSS LazyLoad is not supported! appId:%s", x());
                return false;
            }
            com.tencent.luggage.sdk.jsapi.component.network.b bVar = new com.tencent.luggage.sdk.jsapi.component.network.b();
            this.E = bVar;
            bVar.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), t(), 0);
            if (B() != null) {
                this.E.a(f0(), (com.tencent.luggage.wxa.xd.i) t());
            }
            return true;
        }
        return super.a(str, jSONObject);
    }

    @Override // com.tencent.luggage.wxa.id.c
    public String f() {
        return String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", ((com.tencent.luggage.wxa.r4.d) t()).I().toString(), ((com.tencent.luggage.wxa.r4.d) t()).getRuntime().E().S);
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void b(JSONObject jSONObject) {
        super.b(jSONObject);
        Objects.requireNonNull((com.tencent.luggage.wxa.r4.d) t());
        Objects.requireNonNull(((com.tencent.luggage.wxa.r4.d) t()).getRuntime());
        ((com.tencent.luggage.wxa.r4.d) t()).a(jSONObject, "isLazyLoad", Boolean.valueOf(((com.tencent.luggage.wxa.kj.t) ((com.tencent.luggage.wxa.r4.d) t()).getRuntime().a(com.tencent.luggage.wxa.kj.t.class)).a()));
    }

    @Override // com.tencent.luggage.wxa.xi.e
    public final boolean b(String str) {
        boolean e16;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.K) {
            e16 = e(str);
        }
        return e16;
    }

    public void Z() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.fd.i iVar) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandMiniProgramServiceLogicImp", "onRuntimeInitConfigUpdated");
        if (gVar == null || !gVar.B0()) {
            return;
        }
        l0();
    }

    public static /* synthetic */ void a(com.tencent.luggage.wxa.ic.d dVar, com.tencent.luggage.wxa.ei.h hVar, CountDownLatch countDownLatch, String str) {
        h0.a(dVar, hVar, str);
        countDownLatch.countDown();
    }

    public final void a(final boolean z16) {
        String str;
        String str2;
        String str3;
        String a16;
        String str4;
        if (this.f139137k) {
            return;
        }
        ((com.tencent.luggage.wxa.r4.d) t()).w();
        com.tencent.luggage.wxa.ic.l lVar = (com.tencent.luggage.wxa.ic.l) t();
        Object[] objArr = new Object[3];
        objArr[0] = x();
        objArr[1] = Integer.valueOf(lVar == null ? 0 : lVar.getComponentId());
        objArr[2] = Boolean.valueOf(z16);
        com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandMiniProgramServiceLogicImp", "execInternalInitScript, appId:%s, id:%d, preload:%b", objArr);
        r0.a((com.tencent.luggage.wxa.ic.d) t(), ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime());
        com.tencent.luggage.wxa.uk.x.a(((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), d0(), new C6671c(System.currentTimeMillis(), z16));
        final f c06 = c0();
        final String str5 = c06.f139151a;
        AssetFileDescriptor assetFileDescriptor = c06.f139152b;
        if (c06.f139156f) {
            str = null;
        } else {
            str = TextUtils.isEmpty(c06.f139154d) ? str5 : c06.f139154d;
        }
        if (c06.f139156f) {
            str3 = null;
        } else {
            if (TextUtils.isEmpty(c06.f139155e)) {
                str2 = "v" + ((com.tencent.luggage.wxa.r4.d) t()).i().w();
            } else {
                str2 = c06.f139155e;
            }
            str3 = str2;
        }
        final String str6 = str;
        final String str7 = str3;
        Runnable runnable = new Runnable() { // from class: com.tencent.luggage.wxa.r4.z
            @Override // java.lang.Runnable
            public final void run() {
                c.this.a(c06, str5, str6, str7, z16);
            }
        };
        if (((com.tencent.luggage.wxa.r4.d) t()).getRuntime() != null && ((com.tencent.luggage.wxa.r4.d) t()).getRuntime().R1()) {
            if (assetFileDescriptor == null) {
                a16 = ((com.tencent.luggage.wxa.r4.d) t()).i().g(str5);
            } else {
                a16 = com.tencent.luggage.wxa.tk.c.a(assetFileDescriptor);
            }
            String str8 = a16;
            String g16 = ((com.tencent.luggage.wxa.r4.d) t()).i().g("WAServiceRemoteDebug.js");
            if (TextUtils.isEmpty(g16)) {
                str4 = "";
            } else {
                str4 = g16 + ";";
            }
            com.tencent.luggage.wxa.uk.y.a((com.tencent.luggage.wxa.ic.l) t(), ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), str5, str4 + str8, y.e.LIB, new g(str5, str8, (com.tencent.luggage.wxa.r4.d) t(), this, z16, (a) null));
        } else if (assetFileDescriptor == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandMiniProgramServiceLogicImp", "execInternalInitScript, bootstrap fd is null for name:%s", str5);
            runnable.run();
        } else {
            com.tencent.luggage.wxa.uk.y.a((com.tencent.luggage.wxa.ic.l) t(), ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), str5, str, str3, e0(), assetFileDescriptor, y.e.LIB, new d(str5, assetFileDescriptor, (com.tencent.luggage.wxa.r4.d) t(), this, z16, runnable));
        }
        this.f139137k = true;
        this.f139136j.c();
        a(new ValueCallback() { // from class: com.tencent.luggage.wxa.r4.aa
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                ((e) obj).b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(f fVar, String str, String str2, String str3, boolean z16) {
        String g16;
        if (!TextUtils.isEmpty(fVar.f139153c)) {
            g16 = fVar.f139153c;
        } else {
            g16 = ((com.tencent.luggage.wxa.r4.d) t()).i().g(str);
        }
        com.tencent.luggage.wxa.uk.y.a((com.tencent.luggage.wxa.ic.l) t(), ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime(), str, str2, str3, e0(), g16, y.e.LIB, new g(str, g16, (com.tencent.luggage.wxa.r4.d) t(), this, z16, (a) null));
    }

    @Override // com.tencent.luggage.wxa.id.c
    public void a(String str) {
        com.tencent.luggage.wxa.tn.w.a("Luggage.AppBrandMiniProgramServiceLogicImp", "RemoteDebugInfo %s", str);
        mc mcVar = new mc();
        mcVar.f128203e = ((com.tencent.luggage.wxa.r4.d) t()).J().getComponentId();
        mcVar.f128202d = str;
        com.tencent.luggage.wxa.id.h a16 = com.tencent.luggage.wxa.id.l.a(mcVar, this.G.D(), DebugUtils.Command.DOM_EVENT);
        RemoteDebugJsEngine remoteDebugJsEngine = this.G;
        if (remoteDebugJsEngine != null) {
            remoteDebugJsEngine.a(a16);
        }
    }
}
