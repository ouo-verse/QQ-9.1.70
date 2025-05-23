package com.tencent.luggage.wxa.kj;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.luggage.wxa.kj.b1;
import com.tencent.luggage.wxa.m4.c;
import com.tencent.mobileqq.R;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public class y0 extends com.tencent.luggage.wxa.kj.a implements com.tencent.luggage.wxa.mj.h {
    public static final String[] O = {"custom_event_GenerateFuncReady", "custom_event_tapAnyWhere", "custom_event_vdSync", "onAppRoute", "onAppRouteDone"};
    public boolean G;
    public boolean H;
    public boolean I;
    public com.tencent.luggage.wxa.mj.f J;
    public String K;
    public boolean L;
    public d M;
    public final b1.a N;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.mj.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.mj.f f132585a;

        public a(com.tencent.luggage.wxa.mj.f fVar) {
            this.f132585a = fVar;
        }

        @Override // com.tencent.luggage.wxa.mj.f
        public void t() {
            this.f132585a.t();
        }

        @Override // com.tencent.luggage.wxa.mj.f
        public void v() {
            this.f132585a.v();
            if (!TextUtils.isEmpty(y0.this.K) && y0.this.Y().x()) {
                b1 Y = y0.this.Y();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("document.title=\"");
                sb5.append(com.tencent.luggage.wxa.uk.w.a(y0.this.K + "(PAUSED)"));
                sb5.append("\"");
                Y.evaluateJavascript(sb5.toString(), null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f132588a;

            public a(View view) {
                this.f132588a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ViewCompat.isAttachedToWindow(this.f132588a) && !ViewCompat.isLaidOut(this.f132588a)) {
                    com.tencent.luggage.wxa.tn.w.a("Luggage.MPPageViewRenderer", "loadURL[page], PageView(%s) not laid out, forceLayout", y0.this.F());
                    this.f132588a.forceLayout();
                    ViewParent parent = this.f132588a.getParent();
                    do {
                        ((View) parent).forceLayout();
                        parent = parent.getParent();
                    } while (parent instanceof View);
                    if (parent != null) {
                        parent.requestLayout();
                    }
                }
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View G = y0.this.G();
            if (ViewCompat.isAttachedToWindow(G)) {
                ((com.tencent.luggage.wxa.m4.b) y0.this.t()).c(new a(G));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f132600a;

        /* renamed from: b, reason: collision with root package name */
        public long f132601b;

        /* renamed from: c, reason: collision with root package name */
        public long f132602c;

        public d() {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public y0(@NonNull com.tencent.luggage.wxa.m4.b bVar) {
        super(bVar);
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = null;
        this.N = new c();
    }

    @Override // com.tencent.luggage.wxa.kj.a
    public q0 O() {
        return super.O();
    }

    @Override // com.tencent.luggage.wxa.kj.a
    public void R() {
        super.R();
        com.tencent.luggage.wxa.k0.d.a(((com.tencent.luggage.wxa.m4.b) t()).b(com.tencent.luggage.wxa.pj.a.class));
    }

    public b1 Y() {
        return (b1) H();
    }

    public void a(String str, long j3, long j16) {
    }

    public o0 d(Context context) {
        return new j0(context);
    }

    @Override // com.tencent.luggage.wxa.kj.a, com.tencent.luggage.wxa.p4.a, com.tencent.luggage.wxa.kj.x
    public void h() {
        super.h();
        a(u(), F(), "INVISIBLE");
    }

    @Override // com.tencent.luggage.wxa.mj.h
    public void i() {
        ((com.tencent.luggage.wxa.m4.b) t()).r();
        Y().i();
        ((com.tencent.luggage.wxa.m4.b) t()).q();
    }

    @Override // com.tencent.luggage.wxa.mj.h
    public boolean k() {
        if (Y() != null && Y().k()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.mj.h
    public boolean l() {
        if (Y() != null && Y().l()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.kj.a, com.tencent.luggage.wxa.p4.a, com.tencent.luggage.wxa.kj.x
    public void m() {
        super.m();
        Y().y();
    }

    @Override // com.tencent.luggage.wxa.kj.a, com.tencent.luggage.wxa.p4.a, com.tencent.luggage.wxa.kj.x
    public void o() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewRenderer", "dispatchForeground appId[%s] url[%s]", u(), F());
        super.o();
        a(u(), F(), ParseCommon.VISIBLE);
    }

    @Override // com.tencent.luggage.wxa.kj.a, com.tencent.luggage.wxa.kj.x
    public void p() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewRenderer", "dispatchPageReady url[%s]", F());
        this.L = true;
        super.p();
        G().invalidate();
        if (((com.tencent.luggage.wxa.m4.b) t()).J0()) {
            com.tencent.luggage.wxa.gi.b.b(u(), com.tencent.luggage.wxa.ik.a.N);
            com.tencent.luggage.wxa.gi.b.b(u(), com.tencent.luggage.wxa.ik.a.E);
        }
    }

    @Override // com.tencent.luggage.wxa.kj.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b1 b(Context context) {
        c1 c1Var = new c1(d(context));
        c1Var.a(this.N);
        super.a(com.tencent.luggage.wxa.q4.a.class, c1Var);
        return c1Var;
    }

    public static URL h(String str) {
        try {
            return new URL("https", com.tencent.luggage.wxa.tn.y0.a(R.string.f159111rf), str);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.kj.a, com.tencent.luggage.wxa.m4.a
    public Object a(Class cls) {
        com.tencent.luggage.wxa.mj.f fVar;
        if (com.tencent.luggage.wxa.mj.f.class == cls) {
            if (this.J == null && (fVar = (com.tencent.luggage.wxa.mj.f) H().a(com.tencent.luggage.wxa.mj.f.class)) != null) {
                a aVar = new a(fVar);
                this.J = aVar;
                return cls.cast(aVar);
            }
            return cls.cast(this.J);
        }
        return super.a(cls);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements b1.a {

        /* renamed from: a, reason: collision with root package name */
        public final String f132590a = "page-frame.html";

        /* renamed from: b, reason: collision with root package name */
        public boolean f132591b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f132592c = false;

        /* renamed from: d, reason: collision with root package name */
        public boolean f132593d = false;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements ValueCallback {
            public a() {
            }

            @Override // android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
                if (!y0.this.L()) {
                    return;
                }
                if (!"undefined".equals(str)) {
                    float a16 = com.tencent.luggage.wxa.tn.w0.a(str, -1.0f);
                    if (a16 > 0.0f) {
                        com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewRenderer", "[%s] update density with window.devicePixelRatio = %s", c.this.b(), str);
                        float pixelRatio = y0.this.D().getPixelRatio();
                        if (a16 != pixelRatio) {
                            com.tencent.luggage.wxa.tn.w.h("Luggage.MPPageViewRenderer", "[%s] mismatch devicePixelRatio!!! interface[%f], WebView[%f]", c.this.b(), Float.valueOf(pixelRatio), Float.valueOf(a16));
                        }
                        com.tencent.luggage.wxa.tk.g.c(a16);
                        return;
                    }
                }
                com.tencent.luggage.wxa.tn.w.h("Luggage.MPPageViewRenderer", "[%s] invalid window.devicePixelRatio %s", c.this.b(), str);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements ValueCallback {
            public b() {
            }

            @Override // android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate assignWxConfig end, hash=%d", Integer.valueOf(y0.this.hashCode()));
                y0.this.M.f132602c = System.currentTimeMillis();
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.kj.y0$c$c, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6397c implements ValueCallback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f132597a;

            public C6397c(long j3) {
                this.f132597a = j3;
            }

            @Override // android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
                boolean parseBoolean = Boolean.parseBoolean(str);
                if (parseBoolean) {
                    y0.this.M.f132601b = this.f132597a;
                    y0.this.M.f132602c = System.currentTimeMillis();
                }
                com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate onWxConfigReady end, applied=%b, hash=%d, reportWxConfigInjectEnd cost=%dms", Boolean.valueOf(parseBoolean), Integer.valueOf(y0.this.hashCode()), Long.valueOf(y0.this.M.f132602c - y0.this.M.f132601b));
                y0 y0Var = y0.this;
                y0Var.a(y0Var.M.f132600a, y0.this.M.f132601b, y0.this.M.f132602c);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.luggage.wxa.gi.b.b(y0.this.u(), com.tencent.luggage.wxa.ik.a.I);
            }
        }

        public c() {
        }

        @Override // com.tencent.luggage.wxa.kj.b1.a
        public void a(boolean z16) {
            String f16;
            if (z16) {
                f16 = com.tencent.luggage.wxa.m4.c.f134091t + "preload/page-frame.html";
            } else {
                f16 = f();
            }
            String g16 = ((com.tencent.luggage.wxa.m4.b) y0.this.t()).i().g("WAPageFrame.html");
            com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewRenderer", "loadPageFrame url[%s] preload[%b]", f16, Boolean.valueOf(z16));
            if (!z16) {
                com.tencent.luggage.wxa.gi.b.c(y0.this.u(), com.tencent.luggage.wxa.ik.a.I);
                y0.this.Y().b(new d());
            }
            y0.this.Y().a(f16, g16);
        }

        @Override // com.tencent.luggage.wxa.kj.b1.a
        public void b(boolean z16) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewRenderer", "injectEnvFields preload=%b, hash=%d, viewEngine.hash=%d", Boolean.valueOf(z16), Integer.valueOf(y0.this.hashCode()), Integer.valueOf(y0.this.Y().hashCode()));
            if (z16) {
                ((com.tencent.luggage.wxa.m4.b) y0.this.t()).c(((com.tencent.luggage.wxa.m4.b) y0.this.t()).x());
                h();
                return;
            }
            y0.this.A();
            i();
            d();
            String jSONObject = y0.this.C().toString();
            Locale locale = Locale.US;
            String format = String.format(locale, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);", jSONObject);
            long currentTimeMillis = System.currentTimeMillis();
            y0.this.M = new d(null);
            y0.this.M.f132600a = jSONObject;
            y0.this.M.f132601b = currentTimeMillis;
            com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate assignWxConfig start, hash=%d", Integer.valueOf(y0.this.hashCode()));
            y0.this.Y().a(y0.h("assignWxConfig"), format, new b());
            h();
            g();
            String format2 = String.format(locale, ";(function(){ if(__wxConfig.preload) { %s; return true; } else { return false; }})();", com.tencent.luggage.wxa.xd.h1.a("onWxConfigReady", "", 0));
            com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate onWxConfigReady start, hash=%d", Integer.valueOf(y0.this.hashCode()));
            y0.this.Y().a(y0.h("onWxConfigReady"), format2, new C6397c(System.currentTimeMillis()));
            y0.this.I = false;
            y0.this.I();
        }

        @Override // com.tencent.luggage.wxa.kj.b1.a
        public void c() {
            u.a((v) y0.this.t());
            y0.this.S();
            new k().a((v) y0.this.t(), ((com.tencent.luggage.wxa.m4.b) y0.this.t()).y0());
        }

        public final void d() {
            y0.this.Y().b(";(function(){return window.devicePixelRatio})();", new a());
        }

        public final String e() {
            return com.tencent.luggage.wxa.m4.c.f134091t + String.format(Locale.US, "%s/%d/", y0.this.u(), Integer.valueOf(y0.this.w().j0().f125966l.pkgVersion));
        }

        public final String f() {
            return e() + "page-frame.html";
        }

        public final void g() {
            if (y0.this.w().j0().F && !y0.this.w().R1()) {
                y0 y0Var = y0.this;
                y0Var.a("WAVConsole.js", ((com.tencent.luggage.wxa.rc.q) y0Var.b(com.tencent.luggage.wxa.rc.q.class)).g("WAVConsole.js"));
            }
            if (com.tencent.luggage.wxa.qj.b.d(y0.this.w())) {
                y0 y0Var2 = y0.this;
                y0Var2.a("WAPerf.js", ((com.tencent.luggage.wxa.rc.q) y0Var2.b(com.tencent.luggage.wxa.rc.q.class)).g("WAPerf.js"));
            }
            if (y0.this.w().R1()) {
                y0 y0Var3 = y0.this;
                y0Var3.a("WARemoteDebug.js", ((com.tencent.luggage.wxa.rc.q) y0Var3.b(com.tencent.luggage.wxa.rc.q.class)).g("WARemoteDebug.js"));
            }
        }

        public final void h() {
            y0.this.J();
            if (!this.f132593d) {
                if (y0.this.K()) {
                    y0.this.a("wxa_library/webview_pf.js", com.tencent.luggage.wxa.tk.c.b("wxa_library/webview_pf.js"));
                }
                this.f132593d = true;
            }
            if (!this.f132591b) {
                y0.this.a("wxa_library/android-webview.js", com.tencent.luggage.wxa.tk.c.b("wxa_library/android-webview.js"));
                this.f132591b = true;
            }
            if (!this.f132592c) {
                y0 y0Var = y0.this;
                y0Var.a("WAWebview.js", y0Var.E().a("WAWebview.js"));
                this.f132592c = true;
            }
            y0.this.X();
        }

        public final void i() {
            y0.this.Y().evaluateJavascript(String.format(Locale.US, "history.pushState({},\"\",\"%s\");", f()), null);
        }

        @Override // com.tencent.luggage.wxa.kj.b1.a
        public v a() {
            return (v) y0.this.t();
        }

        @Override // com.tencent.luggage.wxa.kj.b1.a
        public String b() {
            return e();
        }
    }

    @Override // com.tencent.luggage.wxa.kj.a, com.tencent.luggage.wxa.mj.d
    public boolean a(String str, String str2, int i3) {
        if (!this.L && str.startsWith("custom_event_")) {
            if (str.startsWith("custom_event_vdSync") || str.startsWith("custom_event_vdSyncBatch")) {
                if (((com.tencent.luggage.wxa.m4.b) t()).J0()) {
                    if (!this.G) {
                        com.tencent.luggage.wxa.gi.b.b(u(), com.tencent.luggage.wxa.ik.a.M);
                        this.G = true;
                    }
                    if (this.H) {
                        com.tencent.luggage.wxa.gi.b.b(u(), com.tencent.luggage.wxa.ik.a.L);
                        this.H = false;
                    }
                }
                com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewRenderer", "dispatch critical vdSync appId[%s] url[%s] event[%s] content[%s] src[%d]", u(), F(), str, StringUtils.substring(str2, 0, 20), Integer.valueOf(i3));
            } else {
                com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewRenderer", "dispatch critical appId[%s] url[%s] event[%s] size[%d] src[%d]", u(), F(), str, Integer.valueOf(com.tencent.luggage.wxa.tn.w0.d(str2).length()), Integer.valueOf(i3));
            }
        }
        return false;
    }

    public void X() {
    }

    @Override // com.tencent.luggage.wxa.kj.a, com.tencent.luggage.wxa.mj.d
    public boolean a(String str, String str2, int[] iArr) {
        com.tencent.luggage.wxa.m4.b bVar;
        if (ArrayUtils.contains(O, str)) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.MPPageViewRenderer", "publish critical appId[%s] url[%s] event[%s]", u(), F(), str);
            if (t() != null && ((com.tencent.luggage.wxa.m4.b) t()).J0() && "custom_event_GenerateFuncReady".equals(str)) {
                this.H = true;
                com.tencent.luggage.wxa.gi.b.c(u(), com.tencent.luggage.wxa.ik.a.L);
                if (this.G) {
                    com.tencent.luggage.wxa.gi.b.b(u(), com.tencent.luggage.wxa.ik.a.L);
                    this.H = false;
                }
            }
        }
        if (j1.f132231a.contains(str) && (bVar = (com.tencent.luggage.wxa.m4.b) t()) != null) {
            bVar.a(str, str2, bVar.getComponentId());
        }
        return false;
    }

    public final void a(String str, String str2, String str3) {
        String join = StringUtils.join(new String[]{str, str2, str3}, ":");
        if (TextUtils.isEmpty(join)) {
            return;
        }
        this.K = join;
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put("appUrl", str2);
        hashMap.put("appStatus", str3);
        Y().setAppBrandInfo(hashMap);
        if (Y().x()) {
            Y().evaluateJavascript("document.title=\"" + com.tencent.luggage.wxa.uk.w.a(join) + "\"", null);
        }
    }

    @Override // com.tencent.luggage.wxa.kj.a, com.tencent.luggage.wxa.kj.x
    public boolean a(String str, k1 k1Var) {
        this.L = false;
        this.G = false;
        this.H = false;
        Y().b(new b());
        boolean a16 = super.a(str, k1Var);
        a(u(), F(), "INITIAL");
        return a16;
    }

    @Override // com.tencent.luggage.wxa.p4.a, com.tencent.luggage.wxa.kj.x
    public void a(Map map, k1 k1Var) {
        super.a(map, k1Var);
        Objects.requireNonNull((com.tencent.luggage.wxa.m4.b) t());
        if (k1.NAVIGATE_BACK != k1Var) {
            com.tencent.luggage.wxa.k0.d.a(((com.tencent.luggage.wxa.m4.b) t()).b(com.tencent.luggage.wxa.pj.a.class));
        }
        Map map2 = (Map) map.get("qualityData");
        if (map2 == null) {
            map2 = new HashMap();
            map.put("qualityData", map2);
        }
        map2.put("navId", String.format(Locale.ENGLISH, "%d_%d", Integer.valueOf(((com.tencent.luggage.wxa.m4.b) t()).getComponentId()), Long.valueOf(com.tencent.luggage.wxa.tn.w0.c())));
        map2.put("isWebviewPreload", Boolean.valueOf(Y().r()));
        map2.put("isPreloadPageFrame", Boolean.valueOf(this.I));
        map.put("prerender", Boolean.valueOf(w().y1()));
    }

    @Override // com.tencent.luggage.wxa.kj.a
    public void a(c.a aVar, boolean z16, long j3, long j16, Object obj) {
        super.a(aVar, z16, j3, j16, obj);
        if ("WAPageFrame.html".equals(aVar.f134095i) && !TextUtils.isEmpty(u())) {
            com.tencent.luggage.wxa.gi.b.a(u(), com.tencent.luggage.wxa.ik.a.J, "", j3, j16);
        }
        if (this.I || t() == null || ((com.tencent.luggage.wxa.m4.b) t()).getRuntime() == null || !c("checkIsAppSharedPageFrameExecutionFinished").b(aVar.f134095i)) {
            return;
        }
        this.I = true;
    }
}
