package com.tencent.luggage.wxa.ic;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.webkit.ValueCallback;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.luggage.wxa.b9.t;
import com.tencent.luggage.wxa.ei.o;
import com.tencent.luggage.wxa.so.c;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.h1;
import com.tencent.luggage.wxa.xd.k1;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l extends com.tencent.luggage.wxa.ic.d {
    public volatile g M;
    public volatile o O;
    public f S;
    public volatile boolean H = false;
    public volatile boolean I = false;
    public volatile boolean J = false;
    public final boolean[] K = {false};
    public com.tencent.luggage.wxa.wj.c L = new WindowAndroidActivityImpl();
    public final Object N = new byte[0];
    public final y[] P = {new y()};
    public final LinkedList Q = new LinkedList();
    public final com.tencent.luggage.wxa.so.c R = com.tencent.luggage.wxa.so.c.a(new c.a() { // from class: com.tencent.luggage.wxa.ic.ar
        @Override // com.tencent.luggage.wxa.so.c.a
        public final Object a() {
            return l.T();
        }
    });

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements o.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f129919a;

        public a(String str) {
            this.f129919a = str;
        }

        @Override // com.tencent.luggage.wxa.ei.o.a
        public void a(String str, o.b bVar) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandService", "injectConfig end by AddonDirectEvaluation, cost=%dms, hash=%d", Long.valueOf(bVar.f124906b - bVar.f124905a), Integer.valueOf(l.this.getComponentId()));
            l.this.S = new f(null);
            l.this.S.f129929a = this.f129919a;
            l.this.S.f129930b = bVar.f124905a;
            l.this.S.f129931c = bVar.f124906b;
            l.this.S.f129932d = bVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements t.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f129921a;

        public b(String str) {
            this.f129921a = str;
        }

        @Override // com.tencent.luggage.wxa.b9.t.s
        public void a(String str, t.C6044t c6044t) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandService", "injectConfig end by AddonV8, cost=%dms, hash=%d", Long.valueOf(c6044t.f122341b - c6044t.f122340a), Integer.valueOf(l.this.getComponentId()));
            l.this.S = new f(null);
            l.this.S.f129929a = this.f129921a;
            l.this.S.f129930b = c6044t.f122340a;
            l.this.S.f129931c = c6044t.f122341b;
            l.this.S.f129932d = c6044t;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements ValueCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f129923a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f129924b;

        public c(long j3, String str) {
            this.f129923a = j3;
            this.f129924b = str;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            long c16 = w0.c();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandService", "injectConfig end by evaluateJavascript, cost=%dms, hash=%d", Long.valueOf(c16 - this.f129923a), Integer.valueOf(l.this.getComponentId()));
            l.this.S = new f(null);
            l.this.S.f129929a = this.f129924b;
            l.this.S.f129930b = this.f129923a;
            l.this.S.f129931c = c16;
            l.this.S.f129932d = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements t.s {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.b9.t.s
        public void a(String str, t.C6044t c6044t) {
            boolean parseBoolean = Boolean.parseBoolean(str);
            if (parseBoolean) {
                l.this.S.f129930b = c6044t.f122340a;
                l.this.S.f129931c = c6044t.f122341b;
                l.this.S.f129932d = c6044t;
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandService", "notifyWxConfigReadyIfNeed end by AddonV8, applied=%b, hash=%d, reportWxConfigInjectEnd cost=%dms", Boolean.valueOf(parseBoolean), Integer.valueOf(l.this.getComponentId()), Long.valueOf(l.this.S.f129931c - l.this.S.f129930b));
            l lVar = l.this;
            lVar.a(lVar.S.f129929a, l.this.S.f129930b, l.this.S.f129931c, l.this.S.f129932d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements ValueCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f129927a;

        public e(long j3) {
            this.f129927a = j3;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            boolean parseBoolean = Boolean.parseBoolean(str);
            if (parseBoolean) {
                l.this.S.f129930b = this.f129927a;
                l.this.S.f129931c = w0.c();
                l.this.S.f129932d = null;
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandService", "notifyWxConfigReadyIfNeed end by evaluateJavascript, applied=%b, hash=%d, reportWxConfigInjectEnd cost=%dms", Boolean.valueOf(parseBoolean), Integer.valueOf(l.this.getComponentId()), Long.valueOf(l.this.S.f129931c - l.this.S.f129930b));
            l lVar = l.this;
            lVar.a(lVar.S.f129929a, l.this.S.f129930b, l.this.S.f129931c, l.this.S.f129932d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public String f129929a;

        /* renamed from: b, reason: collision with root package name */
        public long f129930b;

        /* renamed from: c, reason: collision with root package name */
        public long f129931c;

        /* renamed from: d, reason: collision with root package name */
        public Object f129932d;

        public f() {
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public static /* synthetic */ com.tencent.luggage.wxa.tn.b0 T() {
        return new com.tencent.luggage.wxa.tn.b0(Looper.getMainLooper());
    }

    @Override // com.tencent.luggage.wxa.xd.j
    public final boolean A() {
        if (getRuntime() == null && !this.H) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.ic.d
    public com.tencent.luggage.wxa.wj.c D() {
        return this.L;
    }

    public final void E() {
        LinkedList linkedList;
        synchronized (this.P) {
            if (this.P[0] != null) {
                linkedList = new LinkedList(this.P[0]);
            } else {
                linkedList = null;
            }
            this.P[0] = null;
        }
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.tencent.luggage.wxa.xd.a0) {
                    com.tencent.luggage.wxa.xd.a0 a0Var = (com.tencent.luggage.wxa.xd.a0) next;
                    b(a0Var.f144733a, a0Var.f144734b, a0Var.f144735c, a0Var.f144736d);
                } else if (next instanceof Runnable) {
                    ((Runnable) next).run();
                }
            }
        }
    }

    public com.tencent.luggage.wxa.kj.i F() {
        return new com.tencent.luggage.wxa.kj.i();
    }

    public o G() {
        return new o(this);
    }

    public String H() {
        return String.format(Locale.US, ";(function(){ if(__wxConfig.preload) { %s; return true; } else { return false; }})();", h1.a("onWxConfigReady", "", 0));
    }

    public JSONObject I() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        com.tencent.luggage.wxa.fd.q j06 = this.M.j0();
        com.tencent.luggage.wxa.fd.b E = this.M.E();
        if (j06 != null && E != null) {
            JSONObject d16 = E.d();
            Iterator keys = d16.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                try {
                    jSONObject.putOpt(str, d16.opt(str));
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandService", e16.getMessage());
                }
            }
            a(jSONObject, MosaicConstants$JsProperty.PROP_ENV, new JSONObject());
            JSONObject jSONObject2 = new JSONObject();
            a(jSONObject2, NodeProps.Z_INDEX, (Object) 1000);
            a(jSONObject2, "viewId", (Object) 1);
            a(jSONObject, "menuButtonInfo", jSONObject2);
            try {
                a(jSONObject, DKEngine.GlobalKey.NET_WORK_TYPE, com.tencent.luggage.wxa.jg.j.a(com.tencent.luggage.wxa.tn.z.c()).f131107a);
            } catch (Exception e17) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandService", "generateWxConfig(%s) set networkType get exception:%s", getAppId(), e17);
            }
            return jSONObject;
        }
        return new JSONObject();
    }

    public com.tencent.luggage.wxa.kj.v J() {
        return f(com.tencent.luggage.wxa.kj.v.class);
    }

    public String K() {
        return "";
    }

    public final Activity L() {
        return g(Activity.class);
    }

    public String M() {
        return "";
    }

    public final o N() {
        o oVar;
        if (!S()) {
            return null;
        }
        synchronized (this.N) {
            oVar = this.O;
        }
        return oVar;
    }

    public void O() {
        JSONObject I = I();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandService", "injectConfig(%s): %s", getAppId(), I.toString());
        String str = this.M.E().S;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandService", "injectConfig start, hash=%d", Integer.valueOf(getComponentId()));
        if (getJsRuntime().a(com.tencent.luggage.wxa.ei.o.class) != null) {
            String jSONObject = I.toString();
            ((com.tencent.luggage.wxa.ei.o) getJsRuntime().a(com.tencent.luggage.wxa.ei.o.class)).a("__native_custom_event__wxConfig_inject", jSONObject, 0, "", new a(jSONObject));
            return;
        }
        long c16 = w0.c();
        String jSONObject2 = I.toString();
        String format = String.format(Locale.ENGLISH, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);var __wxIndexPage = \"%s\";", jSONObject2, str);
        if (getJsRuntime().a(com.tencent.luggage.wxa.ei.v.class) != null) {
            ((com.tencent.luggage.wxa.ei.v) getJsRuntime().a(com.tencent.luggage.wxa.ei.v.class)).a(null, null, null, 0, format, new b(jSONObject2));
        } else {
            getJsRuntime().evaluateJavascript(format, new c(c16, jSONObject2));
        }
    }

    public final void P() {
        if (!S()) {
            return;
        }
        synchronized (this.N) {
            if (this.O == null) {
                this.O = G();
            }
            synchronized (this.Q) {
                LinkedList linkedList = new LinkedList(this.Q);
                this.Q.clear();
                Iterator it = linkedList.iterator();
                if (it.hasNext()) {
                    com.tencent.luggage.wxa.k0.d.a(it.next());
                    throw null;
                }
            }
        }
    }

    public boolean Q() {
        return false;
    }

    public final boolean R() {
        boolean z16;
        synchronized (this.K) {
            z16 = this.K[0];
        }
        return z16;
    }

    public boolean S() {
        return true;
    }

    public final void U() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandService", "notifyWxConfigReadyIfNeed, hash=%d", Integer.valueOf(getComponentId()));
        String H = H();
        if (getJsRuntime().a(com.tencent.luggage.wxa.ei.v.class) != null) {
            ((com.tencent.luggage.wxa.ei.v) getJsRuntime().a(com.tencent.luggage.wxa.ei.v.class)).a(null, null, null, 0, H, new d());
        } else {
            getJsRuntime().evaluateJavascript(H, new e(w0.c()));
        }
    }

    public void V() {
        O();
        E();
    }

    public void X() {
        if (!isRunning()) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandService", "onRuntimePause but not running appId %s", getAppId());
        } else {
            new com.tencent.luggage.wxa.kj.h().a(this.M);
        }
    }

    public final void Y() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandService", "pauseJsThreads appId:%s, serviceId:%d, stack:%s", w0.d(getAppId()), Integer.valueOf(getComponentId()), Log.getStackTraceString(new Throwable()));
        com.tencent.luggage.wxa.tn.b0 b0Var = (com.tencent.luggage.wxa.tn.b0) this.R.d();
        com.tencent.luggage.wxa.ei.u uVar = null;
        if (b0Var != null) {
            b0Var.a((Object) null);
        }
        if (getJsRuntime() != null) {
            uVar = (com.tencent.luggage.wxa.ei.u) getJsRuntime().a(com.tencent.luggage.wxa.ei.u.class);
        }
        if (uVar != null) {
            uVar.pause();
        }
        o N = N();
        if (N != null) {
            N.g();
        }
    }

    public final void Z() {
        r();
        P();
        c(x());
        this.J = true;
        W();
        if (getJsRuntime().a(com.tencent.luggage.wxa.ei.r.class) == null) {
            return;
        }
        com.tencent.luggage.wxa.k0.d.a(getJsRuntime().a(com.tencent.luggage.wxa.ei.r.class));
        throw null;
    }

    public void a(String str, long j3, long j16, Object obj) {
    }

    public final void a0() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandService", "resumeJsThreads appId:%s, serviceId:%d, stack:%s", w0.d(getAppId()), Integer.valueOf(getComponentId()), Log.getStackTraceString(new Throwable()));
        com.tencent.luggage.wxa.tn.b0 b0Var = (com.tencent.luggage.wxa.tn.b0) this.R.d();
        com.tencent.luggage.wxa.ei.u uVar = null;
        if (b0Var != null) {
            b0Var.a((Object) null);
        }
        if (getJsRuntime() != null) {
            uVar = (com.tencent.luggage.wxa.ei.u) getJsRuntime().a(com.tencent.luggage.wxa.ei.u.class);
        }
        if (uVar != null) {
            uVar.a();
        }
        o N = N();
        if (N != null) {
            N.h();
        }
    }

    public void b(g gVar) {
        this.M = gVar;
        a(gVar.n0());
        if (S()) {
            P();
            if (!Q()) {
                o N = N();
                Objects.requireNonNull(N);
                N.f();
            }
        }
        m.a().a(this);
    }

    @Override // com.tencent.luggage.wxa.xd.e
    public String c() {
        return "AppBrandService";
    }

    @Override // com.tencent.luggage.wxa.ic.d, com.tencent.luggage.wxa.xd.e
    public com.tencent.luggage.wxa.xd.l d(Class cls) {
        if (!R()) {
            return null;
        }
        return super.d(cls);
    }

    public String e(String str) {
        return "";
    }

    public boolean f(String str) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.xd.e
    public Map g() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.e, com.tencent.luggage.wxa.xd.d
    public final int getComponentId() {
        return super.getComponentId();
    }

    public g getRuntime() {
        return this.M;
    }

    @Override // com.tencent.luggage.wxa.ic.d, com.tencent.luggage.wxa.xd.d
    public boolean isRunning() {
        if (this.I && !this.H && super.isRunning()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xd.e
    public com.tencent.luggage.wxa.ei.j j() {
        return new com.tencent.luggage.wxa.ei.d(null, null);
    }

    @Override // com.tencent.luggage.wxa.xd.e
    public final void p() {
        super.p();
        P();
        a0();
        this.I = true;
        a(this.M.J());
        V();
    }

    @Override // com.tencent.luggage.wxa.xd.j
    public JSONObject x() {
        return super.x();
    }

    @Override // com.tencent.luggage.wxa.xd.j
    public final boolean z() {
        return this.J;
    }

    public void c(boolean z16) {
        if (isRunning()) {
            F().a(this.M, z16);
        } else {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandService", "onRuntimeResume but not running, appId %s, willRelaunch %b", getAppId(), Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.e
    public void e() {
        this.I = false;
        this.H = true;
        synchronized (this.K) {
            this.K[0] = false;
        }
        this.M = null;
        super.e();
        synchronized (this.N) {
            if (this.O != null) {
                this.O.b();
                this.O = null;
            }
        }
    }

    public com.tencent.luggage.wxa.kj.v f(Class cls) {
        if (this.M == null || this.M.Y() == null) {
            return null;
        }
        if (this.M.Y() == null) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandService", "getCurrentPageView NULL PageContainer, appId=%s", getAppId());
            if (this.M.m1()) {
                return null;
            }
            throw new IllegalStateException("getCurrentPageView NULL PageContainer");
        }
        com.tencent.luggage.wxa.kj.n currentPage = this.M.Y().getCurrentPage();
        if (currentPage == null) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandService", "getCurrentPageView NULL Page, appId=%s", getAppId());
            return null;
        }
        com.tencent.luggage.wxa.kj.v currentPageView = currentPage.getCurrentPageView();
        if (cls.isInstance(currentPageView)) {
            return currentPageView;
        }
        return null;
    }

    public final Activity g(Class cls) {
        Context context;
        if (J() == null) {
            context = getContext();
        } else {
            context = J().getContext();
        }
        if (cls.isInstance(context)) {
            return (Activity) context;
        }
        return null;
    }

    public void a(com.tencent.luggage.wxa.wj.c cVar) {
        this.L = cVar;
    }

    public void a(g gVar) {
        synchronized (this.K) {
            if (!this.K[0] && (this.M == null || gVar == this.M)) {
                b(gVar);
                this.K[0] = true;
            }
        }
    }

    public final void c(Runnable runnable) {
        if (runnable != null) {
            y[] yVarArr = this.P;
            if (yVarArr[0] != null) {
                synchronized (yVarArr) {
                    y yVar = this.P[0];
                    if (yVar != null) {
                        yVar.add(runnable);
                    }
                }
            }
        }
    }

    public final void b(String str, String str2, int i3, int i16) {
        if (c(str)) {
            h1.a(getJsRuntime(), str, str2, i3, i16);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.e, com.tencent.luggage.wxa.xd.d
    public final void a(String str, String str2, int i3) {
        a(str, str2, i3, 0);
    }

    @Override // com.tencent.luggage.wxa.xd.j
    public void b(JSONObject jSONObject) {
        new k1().a(jSONObject);
    }

    public void a(String str, String str2, int i3, int i16) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        if (f(str)) {
            b(str, str2, i3, i16);
            return;
        }
        y[] yVarArr = this.P;
        if (yVarArr[0] != null) {
            synchronized (yVarArr) {
                y yVar = this.P[0];
                if (yVar != null) {
                    yVar.add(com.tencent.luggage.wxa.xd.a0.a(str, str2, i3, i16));
                    return;
                }
            }
        }
        b(str, str2, i3, i16);
    }

    @Override // com.tencent.luggage.wxa.xd.e, com.tencent.luggage.wxa.xd.d
    public final void a(String str, String str2, int[] iArr) {
        if (isRunning()) {
            this.M.Y().a(str, str2, iArr);
        }
    }

    public void W() {
    }

    @Override // com.tencent.luggage.wxa.xd.j
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        if (getJsRuntime() != null) {
            a(jSONObject, "nativeBufferEnabled", Boolean.valueOf(getJsRuntime().a(com.tencent.luggage.wxa.ei.l.class) != null));
        }
    }
}
