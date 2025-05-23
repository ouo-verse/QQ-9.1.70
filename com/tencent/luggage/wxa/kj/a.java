package com.tencent.luggage.wxa.kj;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.fd.b;
import com.tencent.luggage.wxa.kj.z;
import com.tencent.luggage.wxa.m4.c;
import com.tencent.luggage.wxa.mj.g;
import com.tencent.luggage.wxa.uk.x;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang.ArrayUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends com.tencent.luggage.wxa.p4.a implements com.tencent.luggage.wxa.m4.c, com.tencent.luggage.wxa.mj.d {
    public j C;
    public q0 D;
    public g E;
    public t0 F;

    /* renamed from: c, reason: collision with root package name */
    public ViewGroup f132042c;

    /* renamed from: d, reason: collision with root package name */
    public o0 f132043d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f132044e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f132045f;

    /* renamed from: g, reason: collision with root package name */
    public String f132046g;

    /* renamed from: h, reason: collision with root package name */
    public String f132047h;

    /* renamed from: i, reason: collision with root package name */
    public z f132048i;

    /* renamed from: j, reason: collision with root package name */
    public r0 f132049j;

    /* renamed from: k, reason: collision with root package name */
    public c0 f132050k;

    /* renamed from: l, reason: collision with root package name */
    public a1 f132051l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f132052m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements p0 {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.kj.p0
        public void a(r rVar) {
            if (((com.tencent.luggage.wxa.m4.b) a.this.t()).b0() == null) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.AbstractMPPageViewRenderer", "FullScreenViewAttach getContainerPage is null, check time sequence, err, appId[%s], url[%s]", a.this.u(), a.this.F());
            } else {
                ((com.tencent.luggage.wxa.m4.b) a.this.t()).b0().a((v) a.this.t(), rVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements com.tencent.luggage.wxa.qj.g {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.qj.g
        @JavascriptInterface
        public void notifyLongTask(long j3) {
            com.tencent.luggage.wxa.tn.w.a("Luggage.AbstractMPPageViewRenderer", "notifyLongTask :%d", Long.valueOf(j3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements x.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.a f132059a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f132060b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f132061c;

        public e(c.a aVar, long j3, int i3) {
            this.f132059a = aVar;
            this.f132060b = j3;
            this.f132061c = i3;
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void a(String str) {
            a(true);
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void b(String str) {
            a(false);
        }

        public final void a(boolean z16) {
            a.this.a(this.f132059a, z16, this.f132060b, System.currentTimeMillis(), null);
            com.tencent.luggage.wxa.lk.j.b(a.this.u(), this.f132061c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f extends com.tencent.luggage.wxa.uk.o {
        @Override // com.tencent.luggage.wxa.uk.o, java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.AbstractMPPageViewRenderer", "DummyPullDownExtension: invoke(%s), args=%s", method.getName(), ArrayUtils.toString(objArr, "NULL"));
            return super.invoke(obj, method, objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface g {
        void a();

        void a(String str);

        boolean b(String str);

        void c(String str);

        String name();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class h implements g {
        public h() {
        }

        @Override // com.tencent.luggage.wxa.kj.a.g
        public void a(String str) {
        }

        @Override // com.tencent.luggage.wxa.kj.a.g
        public boolean b(String str) {
            return "webview.app.js".equals(str);
        }

        @Override // com.tencent.luggage.wxa.kj.a.g
        public void c(String str) {
            if (!a.this.w().W().b()) {
                return;
            }
            String a16 = a.this.w().W().a(str);
            if (ModulePkgInfo.MAIN_MODULE_NAME.equals(a16)) {
                return;
            }
            a.this.F.a(a16, true);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(a16);
            String str2 = "/";
            if (a16.endsWith("/")) {
                str2 = "";
            }
            sb5.append(str2);
            String sb6 = sb5.toString();
            d(sb6 + "common.app.js");
            d(sb6 + "webview.app.js");
        }

        public final void d(String str) {
            String a16 = a.this.E().a(str);
            if (!TextUtils.isEmpty(a16)) {
                a.this.a(str, a16);
                return;
            }
            throw new com.tencent.luggage.wxa.mc.s(str);
        }

        @Override // com.tencent.luggage.wxa.kj.a.g
        public String name() {
            return "LazyCodeLoading";
        }

        public /* synthetic */ h(a aVar, ViewOnAttachStateChangeListenerC6388a viewOnAttachStateChangeListenerC6388a) {
            this();
        }

        @Override // com.tencent.luggage.wxa.kj.a.g
        public void a() {
            a.this.F.a(ModulePkgInfo.MAIN_MODULE_NAME, true);
            d("common.app.js");
            d("webview.app.js");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class i implements g {
        public i() {
        }

        @Override // com.tencent.luggage.wxa.kj.a.g
        public void a() {
            a.this.F.a(ModulePkgInfo.MAIN_MODULE_NAME, false);
            if (a.this.w().W().b()) {
                String a16 = a.this.E().a("app-wxss.js");
                if (!TextUtils.isEmpty(a16)) {
                    a.this.a("app-wxss.js", a16);
                    return;
                }
                throw new com.tencent.luggage.wxa.mc.s("app-wxss.js");
            }
            a.this.a("page-frame.html", a.this.E().a("page-frame.html"));
        }

        @Override // com.tencent.luggage.wxa.kj.a.g
        public boolean b(String str) {
            if (!"app-wxss.js".equals(str) && !"page-frame.html".equals(str)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.luggage.wxa.kj.a.g
        public void c(String str) {
            if (!a.this.w().W().b()) {
                return;
            }
            String a16 = a.this.w().W().a(str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(a16);
            String str2 = "/";
            if (a16.endsWith("/")) {
                str2 = "";
            }
            sb5.append(str2);
            sb5.append("page-frame.js");
            String sb6 = sb5.toString();
            String a17 = a.this.E().a(sb6);
            if (!TextUtils.isEmpty(a17)) {
                a.this.F.a(a16, false);
                a.this.a(sb6, a17);
                return;
            }
            throw new com.tencent.luggage.wxa.mc.s(sb6);
        }

        @Override // com.tencent.luggage.wxa.kj.a.g
        public String name() {
            return "Legacy";
        }

        public /* synthetic */ i(a aVar, ViewOnAttachStateChangeListenerC6388a viewOnAttachStateChangeListenerC6388a) {
            this();
        }

        @Override // com.tencent.luggage.wxa.kj.a.g
        public void a(String str) {
            a.this.a(str, a.this.E().a(str));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class j extends l0 {
        public j(Context context) {
            super(context);
        }

        public final float a() {
            com.tencent.luggage.wxa.wj.c cVar;
            int i3;
            if (a.this.w() != null) {
                cVar = a.this.w().n0();
            } else if (a.this.t() != null) {
                cVar = ((com.tencent.luggage.wxa.m4.b) a.this.t()).D();
            } else {
                com.tencent.luggage.wxa.tn.w.f("Luggage.AbstractMPPageViewRenderer", "__DeviceInfo.widthFromMetricsInDP() null window");
                cVar = null;
            }
            if (cVar != null) {
                i3 = cVar.getVDisplayMetrics().widthPixels;
            } else {
                i3 = com.tencent.luggage.wxa.tn.z.j().getDisplayMetrics().widthPixels;
            }
            return (float) Math.ceil(i3 / getPixelRatio());
        }

        @Override // com.tencent.luggage.wxa.kj.l0
        @JavascriptInterface
        public float getWidth() {
            try {
                float a16 = a();
                float ceil = (float) Math.ceil(a.this.f132042c.getWidth() / super.getPixelRatio());
                if (ceil > 0.0f && ceil != a16) {
                    com.tencent.luggage.wxa.tn.w.h("Luggage.AbstractMPPageViewRenderer", "__deviceInfo.getWidth(), resources[%f] != view[%f], may in pad env", Float.valueOf(a16), Float.valueOf(ceil));
                }
                return a16;
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.tn.w.a("Luggage.AbstractMPPageViewRenderer", th5, "__DeviceInfo.getWidth()", new Object[0]);
                throw th5;
            }
        }
    }

    public a(@NonNull com.tencent.luggage.wxa.m4.b bVar) {
        super(bVar);
        this.f132044e = false;
        this.f132045f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        if (t() == null) {
            return;
        }
        ((com.tencent.luggage.wxa.m4.b) t()).a(PageWebviewContainer.EVENT_TO_SERVICE_ON_PULLDOWN_REFRESH, (String) null, new int[]{((com.tencent.luggage.wxa.m4.b) t()).getComponentId()});
    }

    public static com.tencent.luggage.wxa.mj.g x() {
        return (com.tencent.luggage.wxa.mj.g) Proxy.newProxyInstance(com.tencent.luggage.wxa.mj.g.class.getClassLoader(), new Class[]{com.tencent.luggage.wxa.mj.g.class}, new f());
    }

    public final void A() {
        if (!TextUtils.isEmpty("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);")) {
            ((com.tencent.luggage.wxa.m4.b) t()).getJsRuntime().evaluateJavascript("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);", null);
        } else if (!((com.tencent.luggage.wxa.m4.b) t()).b()) {
        } else {
            throw new IllegalAccessError("Cannot find object_polyfill.js");
        }
    }

    public final void B() {
        if (H() == null) {
            ((com.tencent.luggage.wxa.m4.b) t()).r();
        }
        H().a(v());
        H().setFullscreenImpl(((com.tencent.luggage.wxa.m4.b) t()).h0());
    }

    public final JSONObject C() {
        boolean z16;
        JSONObject a16 = com.tencent.luggage.wxa.e5.f.a(w().h0().I());
        try {
            a16.put("isFirstPage", ((com.tencent.luggage.wxa.m4.b) t()).J0());
        } catch (JSONException e16) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.AbstractMPPageViewRenderer", "generateWxConfig appId[%s] put isFirstPage e=%s", u(), e16);
        }
        try {
            if (w().S().G0 == com.tencent.luggage.wxa.v4.i.PRE_RENDER) {
                z16 = true;
            } else {
                z16 = false;
            }
            a16.put("prerender", z16);
        } catch (JSONException e17) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.AbstractMPPageViewRenderer", "generateWxConfig appId[%s] put prerender e=%s", u(), e17);
        }
        a16.remove(QCircleDaTongConstant.ElementParamValue.PERMISSION);
        a16.remove("subpackages");
        a16.remove("pages");
        return a16;
    }

    public final l0 D() {
        return this.C;
    }

    public final q0 E() {
        if (this.D == null) {
            q0 O = O();
            this.D = O;
            if (O == null) {
                this.D = new u0(this);
            }
        }
        return this.D;
    }

    public final String F() {
        return this.f132046g;
    }

    public final View G() {
        return this.f132042c;
    }

    public final o0 H() {
        return this.f132043d;
    }

    public final void I() {
        if (this.f132044e) {
            return;
        }
        try {
            c("injectAppSharedPageFrameScript").a();
            this.f132044e = true;
        } catch (com.tencent.luggage.wxa.mc.s unused) {
        }
    }

    public final void J() {
        JSONObject jSONObject = new JSONObject();
        DisplayMetrics vDisplayMetrics = ((com.tencent.luggage.wxa.m4.b) t()).D().getVDisplayMetrics();
        int i3 = vDisplayMetrics.widthPixels;
        int i16 = vDisplayMetrics.heightPixels;
        a(jSONObject, "width", Integer.valueOf((int) Math.ceil(i3 / vDisplayMetrics.density)));
        a(jSONObject, "pixelRatio", Float.valueOf(vDisplayMetrics.density));
        com.tencent.luggage.wxa.tn.w.d("Luggage.AbstractMPPageViewRenderer", "__deviceInfo__:%s", jSONObject.toString());
        ((com.tencent.luggage.wxa.m4.b) t()).getJsRuntime().evaluateJavascript(String.format(Locale.US, ";if(typeof __deviceInfo__ ==='undefined'){ var __deviceInfo__ = %s; } else {Object.assign(__deviceInfo__, %s)};", jSONObject.toString(), jSONObject.toString()), null);
        ViewGroup viewGroup = this.f132042c;
        if (viewGroup == null || !ViewCompat.isAttachedToWindow(viewGroup)) {
            H().a(i3, i16);
        }
    }

    public final boolean K() {
        return this.f132052m;
    }

    public final boolean L() {
        com.tencent.luggage.wxa.m4.b bVar = (com.tencent.luggage.wxa.m4.b) t();
        if (bVar != null && bVar.isRunning()) {
            return true;
        }
        return false;
    }

    public final void N() {
        if (System.currentTimeMillis() % 1000 == 1 || com.tencent.luggage.wxa.tn.x0.a() || com.tencent.luggage.wxa.tn.e.f141565g) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.AbstractMPPageViewRenderer", "do observeLongTask");
            this.f132043d.addJavascriptInterface(y(), "PageLongTaskReporter");
            this.f132052m = true;
        }
    }

    public q0 O() {
        return null;
    }

    public g P() {
        ViewOnAttachStateChangeListenerC6388a viewOnAttachStateChangeListenerC6388a = null;
        if (((t) ((com.tencent.luggage.wxa.m4.b) t()).a(t.class)).a()) {
            return new h(this, viewOnAttachStateChangeListenerC6388a);
        }
        return new i(this, viewOnAttachStateChangeListenerC6388a);
    }

    public t0 Q() {
        return t0.f132415a.a(this);
    }

    public void R() {
        ((com.tencent.luggage.wxa.m4.b) t()).w();
    }

    public final void S() {
        this.f132044e = false;
        t0 t0Var = this.F;
        if (t0Var != null) {
            t0Var.a();
        }
        a(this.f132047h, k1.RELOAD);
    }

    public final void T() {
        this.f132050k.a(new b());
    }

    public final void U() {
        if (this.f132051l != null) {
            FrameLayout frameLayout = (FrameLayout) G();
            if (this.f132051l.getParent() != frameLayout) {
                boolean l3 = ((com.tencent.luggage.wxa.m4.b) t()).W().l();
                ((com.tencent.luggage.wxa.m4.b) t()).W().setLoadingIconVisibility(true);
                ((com.tencent.luggage.wxa.m4.b) t()).W().setNavLoadingIconVisibilityResetListener(this.f132051l);
                this.f132051l.a(l3);
                if (this.f132051l.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.f132051l.getParent()).removeView(this.f132051l);
                }
                frameLayout.addView(this.f132051l, new FrameLayout.LayoutParams(-1, -1));
            }
            this.f132051l.a(v());
            this.f132051l.d();
            this.f132051l.bringToFront();
            com.tencent.luggage.wxa.tn.w.d("Luggage.AbstractMPPageViewRenderer", "revealWaitingReadyCover appId:%s, url:%s", u(), F());
        }
    }

    public final void V() {
        if (!L()) {
            return;
        }
        Objects.requireNonNull((com.tencent.luggage.wxa.m4.b) t());
        Objects.requireNonNull(((com.tencent.luggage.wxa.m4.b) t()).r0());
        Objects.requireNonNull(((com.tencent.luggage.wxa.m4.b) t()).getRuntime());
        H().setBackgroundColor(a(((com.tencent.luggage.wxa.m4.b) t()).r0(), ((com.tencent.luggage.wxa.m4.b) t()).getRuntime().E().l(), ((com.tencent.luggage.wxa.m4.b) t()).getRuntime().S().t(), false));
    }

    public boolean W() {
        return true;
    }

    public void a(c.a aVar, boolean z16, long j3, long j16, Object obj) {
    }

    public abstract o0 b(Context context);

    @Override // com.tencent.luggage.wxa.kj.x
    public boolean e() {
        return false;
    }

    public void f(String str) {
        ((com.tencent.luggage.wxa.m4.b) t()).f(str);
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public final r0 g() {
        return this.f132049j;
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public final c0 getCustomViewContainer() {
        return this.f132050k;
    }

    @Override // com.tencent.luggage.wxa.p4.a, com.tencent.luggage.wxa.kj.x
    public void h() {
        super.h();
        H().onBackground();
    }

    @Override // com.tencent.luggage.wxa.p4.a, com.tencent.luggage.wxa.kj.x
    public void m() {
        super.m();
        super.a(com.tencent.luggage.wxa.mj.e.class, new w0((v) t()));
        super.a(com.tencent.luggage.wxa.mj.i.class, new z0((v) t()));
        super.a(com.tencent.luggage.wxa.mj.g.class, x());
        com.tencent.luggage.wxa.p4.b.a((v) t());
    }

    @Override // com.tencent.luggage.wxa.p4.a, com.tencent.luggage.wxa.kj.x
    public void o() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.AbstractMPPageViewRenderer", "dispatchForeground appId:%s, url:%s, mIsPageReady:%b", u(), F(), Boolean.valueOf(this.f132045f));
        super.o();
        H().onForeground();
        ((com.tencent.luggage.wxa.m4.b) t()).y1();
        if (!this.f132045f) {
            U();
        }
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public void p() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.AbstractMPPageViewRenderer", "dispatchPageReady appId:%s, url:%s", u(), F());
        this.f132045f = true;
        z();
    }

    @Override // com.tencent.luggage.wxa.mj.d
    public Map q() {
        return new com.tencent.luggage.wxa.h4.a().b();
    }

    public com.tencent.luggage.wxa.qj.g y() {
        return new d();
    }

    public final void z() {
        a1 a1Var = this.f132051l;
        if (a1Var != null) {
            a1Var.setVisibility(8);
            if (ViewCompat.isAttachedToWindow(this.f132051l)) {
                ((com.tencent.luggage.wxa.m4.b) t()).W().setNavLoadingIconVisibilityResetListener(null);
                ((com.tencent.luggage.wxa.m4.b) t()).W().setLoadingIconVisibility(this.f132051l.f132072d);
                ((ViewGroup) this.f132051l.getParent()).removeView(this.f132051l);
                com.tencent.luggage.wxa.tn.w.d("Luggage.AbstractMPPageViewRenderer", "dismissWaitingReadyCover appId:%s, url:%s", u(), F());
            }
            this.f132051l.a();
            this.f132051l = null;
        }
    }

    @Override // com.tencent.luggage.wxa.mj.d
    public boolean a(int i3, String str) {
        return false;
    }

    public final g c(String str) {
        if (this.E == null) {
            this.E = P();
            this.F = Q();
            com.tencent.luggage.wxa.tn.w.d("Luggage.AbstractMPPageViewRenderer", "getInjectionMode created mode name = %s, appId = %s, reason = %s", this.E.name(), u(), str);
        }
        return this.E;
    }

    public final void d(String str) {
        try {
            c(String.format(Locale.ENGLISH, "injectModuleSharedPageFrameScript(%s)", str)).c(str);
        } catch (com.tencent.luggage.wxa.mc.s unused) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.AbstractMPPageViewRenderer", "injectModuleSharedPageFrameScript appId[%s] path[%s] ScriptNotFoundException", u(), str);
        }
    }

    public final void e(String str) {
        try {
            c(String.format(Locale.ENGLISH, "injectPageScript(%s)", str)).a(str);
        } catch (com.tencent.luggage.wxa.mc.s unused) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.AbstractMPPageViewRenderer", "injectPageScript appId[%s] url[%s] ScriptNotFoundException", u(), str);
        }
    }

    @Override // com.tencent.luggage.wxa.mj.d
    public boolean a(String str, String str2, int i3) {
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends x0 {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.kj.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6389a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f132056a;

            public RunnableC6389a(int i3) {
                this.f132056a = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.t() != null && ((com.tencent.luggage.wxa.m4.b) a.this.t()).getContentView() != null) {
                    ((com.tencent.luggage.wxa.m4.b) a.this.t()).getContentView().setBackgroundColor(this.f132056a);
                }
                if (a.this.f132051l != null) {
                    a.this.f132051l.setBackgroundColor(this.f132056a);
                }
            }
        }

        public c(v vVar, z zVar) {
            super(vVar, zVar);
        }

        @Override // com.tencent.luggage.wxa.mj.g
        public void a(String str, String str2) {
            int a16;
            boolean l3 = a.this.w().E().l();
            if (a.this.w().S().t() == com.tencent.luggage.wxa.fd.j0.TRANSPARENT) {
                a16 = 0;
            } else {
                a16 = com.tencent.luggage.wxa.tk.g.a(str2, ContextCompat.getColor(a.this.v(), l3 ? R.color.aqr : R.color.f156699b25));
            }
            a(g.a.a(str, l3), a16);
        }

        @Override // com.tencent.luggage.wxa.kj.x0, com.tencent.luggage.wxa.mj.g
        public void a(g.a aVar, int i3) {
            super.a(aVar, i3);
            if (a.this.t() == null) {
                return;
            }
            ((com.tencent.luggage.wxa.m4.b) a.this.t()).a(new RunnableC6389a(i3));
        }
    }

    @Override // com.tencent.luggage.wxa.mj.d
    public boolean a(String str, String str2, int[] iArr) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public boolean d() {
        if (TextUtils.isEmpty(this.f132046g)) {
            this.f132046g = ((com.tencent.luggage.wxa.m4.b) t()).A0();
            this.f132047h = ((com.tencent.luggage.wxa.m4.b) t()).B0();
        } else {
            com.tencent.luggage.wxa.er.a.a(this.f132046g, ((com.tencent.luggage.wxa.m4.b) t()).A0());
        }
        return !((com.tencent.luggage.wxa.m4.b) t()).C().a(this.f132046g, true);
    }

    @Override // com.tencent.luggage.wxa.m4.a
    public Object a(Class cls) {
        if (com.tencent.luggage.wxa.rc.q.class.equals(cls)) {
            return cls.cast(((com.tencent.luggage.wxa.m4.b) t()).i());
        }
        if (cls.isInstance(this)) {
            return cls.cast(this);
        }
        return super.a(cls);
    }

    public boolean a(k1 k1Var) {
        return (t() == null || !((com.tencent.luggage.wxa.m4.b) t()).J0()) && ((com.tencent.luggage.wxa.m4.b) t()).getRuntime().S().t() != com.tencent.luggage.wxa.fd.j0.TRANSPARENT && k1.AUTO_RE_LAUNCH == k1Var;
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public View a(LayoutInflater layoutInflater) {
        return new FrameLayout(layoutInflater.getContext().getApplicationContext());
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public void a(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        this.f132042c = frameLayout;
        frameLayout.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC6388a());
        this.f132049j = new com.tencent.luggage.wxa.ol.c1((v) t());
        B();
        H().setOnScrollChangedListener(this.f132049j);
        H().setWebViewLayoutListener(this.f132049j);
        this.f132049j.setupWebViewTouchInterceptor(H());
        if (!W()) {
            this.f132048i = null;
            this.f132042c.addView(H().getWrapperView());
            this.f132042c.addView(this.f132049j.getContainer());
        } else {
            z a16 = a(H());
            this.f132048i = a16;
            a16.addView(this.f132049j.getContainer());
            this.f132048i.setOnPullDownOffsetListener(this.f132049j);
            this.f132048i.setOnPullDownListener(new z.a() { // from class: b31.a
                @Override // com.tencent.luggage.wxa.kj.z.a
                public final void a() {
                    com.tencent.luggage.wxa.kj.a.this.M();
                }
            });
            this.f132042c.addView(this.f132048i);
        }
        c0 c0Var = new c0(this.f132049j.getContainer());
        this.f132050k = c0Var;
        c0Var.a(((com.tencent.luggage.wxa.m4.b) t()).h0());
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kj.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnAttachStateChangeListenerC6388a implements View.OnAttachStateChangeListener {
        public ViewOnAttachStateChangeListenerC6388a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a.this.getCustomViewContainer().b();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public RelativeLayout.LayoutParams a(View view, View view2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (view2 != null) {
            if (view2.getId() == -1) {
                view2.setId(R.id.sri);
            }
            layoutParams.addRule(2, view2.getId());
        }
        return layoutParams;
    }

    public final z a(o0 o0Var) {
        Context v3;
        if (w() != null) {
            v3 = w().F();
        } else {
            v3 = v();
        }
        return new z(v3, o0Var);
    }

    public final void a(z zVar) {
        super.a(com.tencent.luggage.wxa.mj.g.class, new c((v) t(), zVar));
    }

    public final void a(JSONObject jSONObject, String str, Object obj) {
        ((com.tencent.luggage.wxa.m4.b) t()).a(jSONObject, str, obj);
    }

    @Override // com.tencent.luggage.wxa.mj.d
    public final o0 a(Context context) {
        if (context == null) {
            context = v();
        }
        this.f132043d = b(context);
        N();
        o0 o0Var = this.f132043d;
        j jVar = new j(context);
        this.C = jVar;
        o0Var.addJavascriptInterface(jVar, "__deviceInfo");
        return this.f132043d;
    }

    public final void a(String str, String str2) {
        URL url;
        if (TextUtils.isEmpty(str2)) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.AbstractMPPageViewRenderer", "[!]injectScript appId[%s] name[%s] url[%s] hash[%d] source EMPTY", u(), str, F(), Integer.valueOf(hashCode()));
            return;
        }
        c.a aVar = new c.a();
        aVar.f134095i = str;
        aVar.f134096j = str2;
        aVar.f134097k = str2.length();
        long currentTimeMillis = System.currentTimeMillis();
        int b16 = com.tencent.luggage.wxa.lk.j.b(u(), "public:inject", "\u4ee3\u7801\u6ce8\u5165-" + str);
        com.tencent.luggage.wxa.tn.w.d("Luggage.AbstractMPPageViewRenderer", "injectScript start, appId[%s] name[%s] url[%s] hash[%d]", u(), str, F(), Integer.valueOf(hashCode()));
        if (!TextUtils.isEmpty(str)) {
            url = new URL("https", com.tencent.luggage.wxa.tn.y0.a(R.string.f159111rf), str);
            com.tencent.luggage.wxa.uk.x.a(((com.tencent.luggage.wxa.m4.b) t()).getJsRuntime(), url, str2, new e(aVar, currentTimeMillis, b16));
        } else {
            com.tencent.luggage.wxa.tn.w.h("Luggage.AbstractMPPageViewRenderer", "[!] injectScript, valid name is required, appId:%s, url:%s", u(), F());
            url = null;
            com.tencent.luggage.wxa.uk.x.a(((com.tencent.luggage.wxa.m4.b) t()).getJsRuntime(), url, str2, new e(aVar, currentTimeMillis, b16));
        }
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public boolean a(String str, k1 k1Var) {
        this.f132046g = ((com.tencent.luggage.wxa.m4.b) t()).A0();
        this.f132047h = ((com.tencent.luggage.wxa.m4.b) t()).B0();
        if (W()) {
            z zVar = this.f132048i;
            Objects.requireNonNull(zVar);
            a(zVar);
        }
        T();
        ((com.tencent.luggage.wxa.m4.b) t()).a(k1Var);
        V();
        v0 v0Var = new v0((v) t());
        super.a(com.tencent.luggage.wxa.mj.a.class, v0Var);
        v0Var.a();
        if (d()) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.AbstractMPPageViewRenderer", "Empty page content, appId[%s] url[%s], abort inject", u(), str);
            f(str);
            return false;
        }
        if (a(k1Var)) {
            this.f132051l = new a1(w().F(), (v) t());
        }
        R();
        I();
        d(this.f132046g);
        e(this.f132046g);
        return true;
    }

    public static int a(b.e eVar, boolean z16, com.tencent.luggage.wxa.fd.j0 j0Var, boolean z17) {
        com.tencent.luggage.wxa.fd.j0 j0Var2 = com.tencent.luggage.wxa.fd.j0.TRANSPARENT;
        int i3 = 0;
        int a16 = com.tencent.luggage.wxa.tk.g.a(eVar.f125689i, j0Var == j0Var2 ? 0 : z16 ? -15132391 : -1);
        if (j0Var != j0Var2 && !z17) {
            i3 = -16777216;
        }
        return a16 | i3;
    }

    @Override // com.tencent.luggage.wxa.p4.a, com.tencent.luggage.wxa.kj.x
    public void a() {
        super.a();
        this.f132049j.a(H());
        H().destroy();
        this.f132043d = null;
        this.f132042c.removeAllViewsInLayout();
        z zVar = this.f132048i;
        if (zVar != null) {
            zVar.removeAllViewsInLayout();
            this.f132048i = null;
        }
        this.f132049j = null;
    }
}
