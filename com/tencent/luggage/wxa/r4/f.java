package com.tencent.luggage.wxa.r4;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ei.n;
import com.tencent.luggage.wxa.qc.c;
import com.tencent.luggage.wxa.r4.a;
import com.tencent.luggage.wxa.r4.f;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.magicar.LibLoadDelegate;
import com.tencent.magicar.MagicAR;
import com.tencent.magicar.MagicARCallback;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJniParams;
import com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager;
import com.tencent.mm.libmmwebrtc.MMWebRTCBinding;
import com.tencent.mm.libmmwebrtc.delegate.LoadDelegate;
import com.tencent.mm.libmmwebrtc.delegate.LogDelegate;
import com.tencent.mm.wemedia.WeMediaBinding;
import com.tencent.mm.wemedia.WeMediaCallback;
import com.tencent.mm.wemedia.delegate.WeMediaLoadDelegate;
import com.tencent.mm.wemedia.delegate.WeMediaLogDelegate;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f extends com.tencent.luggage.wxa.m4.a implements com.tencent.luggage.wxa.xi.e {

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.r4.a f139179c;

    /* renamed from: d, reason: collision with root package name */
    public final a.AbstractC6666a f139180d;

    /* renamed from: e, reason: collision with root package name */
    public MMWebRTCBinding f139181e;

    /* renamed from: f, reason: collision with root package name */
    public WeMediaBinding f139182f;

    /* renamed from: g, reason: collision with root package name */
    public MagicAR f139183g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.r4.g f139184h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f139185a;

        public a(com.tencent.luggage.wxa.ic.g gVar) {
            this.f139185a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            AppBrandCommonBindingJni c16 = f.this.f139179c.c();
            String x16 = f.this.x();
            String str2 = this.f139185a.j0().f125966l.md5;
            if (f.this.t() != null && ((com.tencent.luggage.wxa.r4.d) f.this.t()).i() != null) {
                str = "v" + ((com.tencent.luggage.wxa.r4.d) f.this.t()).i().w();
            } else {
                str = "";
            }
            c16.notifyRuntimeReady(x16, str2, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements c.InterfaceC6640c {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.f139179c.c().notifySuspend();
                if (f.this.f139184h != null) {
                    f.this.f139184h.c();
                }
            }
        }

        public b() {
        }

        @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
        public void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
            if (com.tencent.luggage.wxa.qc.b.SUSPEND == bVar) {
                f.this.a(new a());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements n.a {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.ei.n.a
        public void onDestroy() {
            com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "hy: bindings triggered destroy");
            if (f.this.f139181e != null) {
                f.this.f139181e.destroy();
            }
            if (f.this.f139182f != null) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "uint wemedia");
                f.this.f139182f.uint();
                f.this.f139182f = null;
                com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "uint wemedia done");
            }
            if (f.this.f139179c != null) {
                f.this.f139179c.b().a();
                f.this.f139179c.c().notifyDestroy();
            }
            if (f.this.f139183g != null) {
                f.this.f139183g.destroy();
            }
            f.this.f139183g = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f139179c.c().notifyPause();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f139179c.c().notifyResume();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.r4.f$f, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C6672f {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f139192a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.qc.b.values().length];
            f139192a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.qc.b.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f139192a[com.tencent.luggage.wxa.qc.b.FOREGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f139192a[com.tencent.luggage.wxa.qc.b.BACKGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g extends a.AbstractC6666a {
        public g(com.tencent.luggage.wxa.xd.e eVar) {
            super(eVar);
        }

        @Override // com.tencent.luggage.wxa.r4.a.AbstractC6666a, com.tencent.luggage.wxa.a9.a
        public boolean a(String str, String str2) {
            JSONObject jSONObject;
            com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "syncInitModule appId:%s, module:%s, params:%s", f.this.x(), str, str2);
            if (!w0.c(str2)) {
                try {
                    jSONObject = new JSONObject(str2);
                } catch (JSONException e16) {
                    com.tencent.luggage.wxa.tn.w.a("Luggage.BaseAppBrandServiceLogic", e16, "hy: param is not in json format", new Object[0]);
                }
                return f.this.a(str, jSONObject);
            }
            jSONObject = null;
            return f.this.a(str, jSONObject);
        }

        @Override // com.tencent.luggage.wxa.a9.a
        public void b() {
            if (f.this.t() != null) {
                com.tencent.luggage.wxa.ei.q A = f.this.A();
                if (A == null) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "hy: js thread handler not installed");
                    return;
                } else {
                    A.b();
                    return;
                }
            }
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "hy: component released when resumeLoopTasks");
        }

        @Override // com.tencent.luggage.wxa.a9.a
        public boolean c() {
            if (f.this.t() != null) {
                com.tencent.luggage.wxa.ei.q A = f.this.A();
                if (A == null) {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "hy: js thread handler not installed");
                    return true;
                }
                return A.c();
            }
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "hy: component released when doInnerLoopTask");
            return true;
        }

        @Override // com.tencent.luggage.wxa.r4.a.AbstractC6666a, com.tencent.luggage.wxa.a9.a
        public void d(String str) {
            f.this.d(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements LogDelegate.ILog {
        public i() {
        }

        public void d(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.a(str, str2, objArr);
        }

        public void e(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.b(str, str2, objArr);
        }

        public void i(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.d(str, str2, objArr);
        }

        public void printStackTrace(String str, Throwable th5, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.a(str, th5, str2, objArr);
        }

        public void v(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.g(str, str2, objArr);
        }

        public void w(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.h(str, str2, objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements WeMediaLoadDelegate.ILoadLibrary {
        public j() {
        }

        public void loadLibrary(String str) {
            com.tencent.luggage.wxa.aa.h.g(str);
        }

        public void loadLibrary(String str, ClassLoader classLoader) {
            com.tencent.luggage.wxa.aa.h.b(str, classLoader);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements WeMediaLogDelegate.ILog {
        public k() {
        }

        public void d(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.a(str, str2, objArr);
        }

        public void e(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.b(str, str2, objArr);
        }

        public void i(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.d(str, str2, objArr);
        }

        public void printStackTrace(String str, Throwable th5, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.a(str, th5, str2, objArr);
        }

        public void v(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.g(str, str2, objArr);
        }

        public void w(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.h(str, str2, objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n implements MagicARCallback {
        public n() {
        }

        public String getFilePath(String str) {
            String g16;
            if (f.this.t() == null || ((com.tencent.luggage.wxa.r4.d) f.this.t()).getFileSystem() == null || ((com.tencent.luggage.wxa.r4.d) f.this.t()).getFileSystem().getAbsoluteFile(str) == null || (g16 = ((com.tencent.luggage.wxa.r4.d) f.this.t()).getFileSystem().getAbsoluteFile(str).g()) == null) {
                return "";
            }
            return g16;
        }

        public String getWAAppInfo_appId() {
            return f.this.x();
        }

        public boolean getWAAppInfo_isGame() {
            if (f.this.B() != null && f.this.B().S() != null && f.this.B().S().l()) {
                return true;
            }
            return false;
        }

        public String getWAAppInfo_path() {
            if (f.this.B() != null && f.this.B().Y() != null) {
                return f.this.B().Y().getCurrentUrl();
            }
            return "";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class o implements Runnable {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a extends com.tencent.luggage.wxa.ei.a {
            public a() {
                f.this.f139179c.b().a(new BufferURLManager.a() { // from class: com.tencent.luggage.wxa.r4.am
                    @Override // com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager.a
                    public final void a(String str) {
                        f.o.a.this.b(str);
                    }
                });
            }

            @Override // com.tencent.luggage.wxa.ei.x
            public ByteBuffer a(String str) {
                return f.this.f139179c.b().a(str);
            }
        }

        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "hy: base service js runtime post created run");
            com.tencent.luggage.wxa.ei.v vVar = (com.tencent.luggage.wxa.ei.v) f.this.b(com.tencent.luggage.wxa.ei.v.class);
            if (vVar == null) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "hy: v8 not ready or released!");
                return;
            }
            if (f.this.f139184h != null) {
                if (vVar.j() != 0) {
                    f.this.f139184h.a(vVar.f(), vVar.B(), vVar.j());
                } else {
                    com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "uv_ptr is null. cronet binding init failed");
                    f.this.f139184h = null;
                }
            }
            f.this.f139179c.c().notifyBindTo(vVar.f(), vVar.B(), vVar.j());
            if (f.this.I()) {
                f.this.f139179c.c().notifyBindConsoleTo(vVar.f(), vVar.B(), vVar.j());
            }
            f.this.f139179c.b().a(vVar.f(), vVar.B());
            com.tencent.luggage.wxa.ei.l lVar = (com.tencent.luggage.wxa.ei.l) f.this.b(com.tencent.luggage.wxa.ei.l.class);
            if (lVar != null) {
                lVar.a(new a());
            } else {
                com.tencent.luggage.wxa.tn.w.f("Luggage.BaseAppBrandServiceLogic", "hy: buffer url addon not exist!");
            }
        }
    }

    public f(@NonNull com.tencent.luggage.wxa.r4.d dVar) {
        super(dVar);
        this.f139183g = null;
        if (G()) {
            a.AbstractC6666a V = V();
            this.f139180d = V;
            this.f139179c = new com.tencent.luggage.wxa.r4.a(V);
        } else {
            this.f139179c = null;
            this.f139180d = null;
        }
        if (K()) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "use cronet, create cronet");
            this.f139184h = new com.tencent.luggage.wxa.r4.g();
        } else {
            com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "not use cronet, create cronet");
            this.f139184h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        if (this.f139184h != null) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "start destroy cronet");
            this.f139184h.a();
        }
    }

    public final com.tencent.luggage.wxa.ei.q A() {
        com.tencent.luggage.wxa.ei.j jsRuntime = ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime();
        if (jsRuntime == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "hy: js runtime not installed");
            return null;
        }
        return (com.tencent.luggage.wxa.ei.q) jsRuntime.a(com.tencent.luggage.wxa.ei.q.class);
    }

    public com.tencent.luggage.wxa.c5.e B() {
        if (t() == null) {
            return null;
        }
        return ((com.tencent.luggage.wxa.r4.d) t()).getRuntime();
    }

    public String C() {
        return "";
    }

    public int D() {
        return -2;
    }

    public synchronized MMWebRTCBinding E() {
        return this.f139181e;
    }

    public boolean G() {
        return true;
    }

    public boolean H() {
        return false;
    }

    public boolean I() {
        com.tencent.luggage.wxa.ei.m mVar = (com.tencent.luggage.wxa.ei.m) b(com.tencent.luggage.wxa.ei.m.class);
        if (!com.tencent.luggage.wxa.b9.t.d()) {
            if (mVar == null || mVar.w()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean J() {
        return false;
    }

    public boolean K() {
        return false;
    }

    public abstract boolean L();

    public void N() {
        if (this.f139183g != null) {
            return;
        }
        if (t() == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "lazyLoadMagicARSync, getComponent lost");
            return;
        }
        com.tencent.luggage.wxa.ei.j jsRuntime = ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime();
        if (jsRuntime == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "lazyLoadMagicARSync, js runtime lost");
            return;
        }
        com.tencent.luggage.wxa.ei.v vVar = (com.tencent.luggage.wxa.ei.v) jsRuntime.a(com.tencent.luggage.wxa.ei.v.class);
        if (vVar == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "lazyLoadMagicARSync, v8 addon lost");
            return;
        }
        if (!s.a("magicar", 10000L, "ilinkres_d7d2cdfe")) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "libmagciar.so download fail");
            return;
        }
        String a16 = s.a("magicar", "ilinkres_d7d2cdfe");
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "libmagciar.so path is null");
            return;
        }
        if (!s.a("weslam", 10000L, "ilinkres_d7d2cdfe")) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "libweslam.so download fail");
            return;
        }
        String a17 = s.a("weslam", "ilinkres_d7d2cdfe");
        if (a17 == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "libweslam.so path is null");
            return;
        }
        LibLoadDelegate.setInstance(new m(a16, a17));
        com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "triggerBindingMagicAR");
        MagicAR magicAR = new MagicAR(com.tencent.luggage.wxa.tn.z.c());
        this.f139183g = magicAR;
        magicAR.bindTo(vVar.f(), vVar.B(), vVar.j());
        this.f139183g.setMagicARCallback(new n());
        com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "lazyLoadMagicARSync, lazy load magic-ar ok");
    }

    public abstract void P();

    public abstract void Q();

    public void R() {
        if (G()) {
            a(new d());
        }
    }

    public void S() {
        if (G()) {
            a(new e());
        }
    }

    public void T() {
        super.r();
        a.AbstractC6666a abstractC6666a = this.f139180d;
        if (abstractC6666a != null) {
            abstractC6666a.f("fail invalid running state : 4");
        }
        a(new ValueCallback() { // from class: com.tencent.luggage.wxa.r4.ag
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                ((e) obj).c();
            }
        });
    }

    public void U() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "hy: base service js runtime post created");
        if (G()) {
            com.tencent.luggage.wxa.r4.a aVar = this.f139179c;
            Objects.requireNonNull(aVar);
            aVar.c().notifyCreate(W());
            a(new o());
        }
        a(new ValueCallback() { // from class: com.tencent.luggage.wxa.r4.ai
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                f.this.a((e) obj);
            }
        });
    }

    public final a.AbstractC6666a V() {
        return new g((com.tencent.luggage.wxa.xd.e) t());
    }

    public AppBrandCommonBindingJniParams W() {
        if (((com.tencent.luggage.wxa.ei.v) b(com.tencent.luggage.wxa.ei.v.class)) == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "add on v8 not ready!");
            return null;
        }
        AppBrandCommonBindingJniParams appBrandCommonBindingJniParams = new AppBrandCommonBindingJniParams();
        String C = C();
        appBrandCommonBindingJniParams.wasmCachePath = C;
        if (!TextUtils.isEmpty(C)) {
            appBrandCommonBindingJniParams.wasmCachePath = com.tencent.luggage.wxa.cp.x.b(appBrandCommonBindingJniParams.wasmCachePath, true);
        }
        appBrandCommonBindingJniParams.wasmOptState = D();
        return appBrandCommonBindingJniParams;
    }

    public synchronized boolean X() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "triggerBindingWeMedia");
        if (this.f139182f != null) {
            return true;
        }
        if (t() == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "triggerBindingWeMedia, getComponent lost");
            return false;
        }
        com.tencent.luggage.wxa.ei.j jsRuntime = ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime();
        if (jsRuntime == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "triggerBindingWeMedia, js runtime lost");
            return false;
        }
        com.tencent.luggage.wxa.ei.v vVar = (com.tencent.luggage.wxa.ei.v) jsRuntime.a(com.tencent.luggage.wxa.ei.v.class);
        if (vVar == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "triggerBindingWeMedia, v8 addon lost");
            return false;
        }
        com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "triggerBindingWeMedia");
        WeMediaLoadDelegate.setInstance(new j());
        WeMediaLogDelegate.setImp(new k());
        WeMediaBinding weMediaBinding = new WeMediaBinding(com.tencent.luggage.wxa.tn.z.c());
        this.f139182f = weMediaBinding;
        weMediaBinding.init(vVar.f(), vVar.B(), vVar.j(), com.tencent.luggage.wxa.db.a.e() + "/appbrand/", new l());
        this.f139182f.onForeground();
        if (((com.tencent.luggage.wxa.r4.d) t()).getRuntime() != null) {
            ((com.tencent.luggage.wxa.r4.d) t()).getRuntime().c0().a(new c.InterfaceC6640c() { // from class: com.tencent.luggage.wxa.r4.al
                @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
                public final void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
                    f.this.a(str, bVar);
                }
            });
        } else {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "runtime not created!! will not trigger runtime lifecycle listening");
        }
        com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "triggerBindingWeMedia done");
        return true;
    }

    public synchronized boolean Y() {
        boolean z16;
        com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "hy: test trigger binding webrtc");
        if (this.f139181e != null) {
            return true;
        }
        com.tencent.luggage.wxa.ei.j jsRuntime = ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime();
        if (jsRuntime == null) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "hy: js runtime lost");
            return false;
        }
        com.tencent.luggage.wxa.ei.v vVar = (com.tencent.luggage.wxa.ei.v) jsRuntime.a(com.tencent.luggage.wxa.ei.v.class);
        if (vVar == null) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "hy: v8 addon lost");
            return false;
        }
        try {
            z16 = s.a("libmmwebrtc", 10000L, "ilinkres_ae0cf48a");
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "checkSync failed: %s", th5.getMessage());
            z16 = false;
        }
        if (!z16) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "libmmwebrtc.so download fail");
            return false;
        }
        String a16 = s.a("libmmwebrtc", "ilinkres_ae0cf48a");
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "libmmwebrtc.so path is null");
            return false;
        }
        LoadDelegate.setInstance(new h(a16));
        this.f139181e = new MMWebRTCBinding(com.tencent.luggage.wxa.tn.z.c());
        LogDelegate.Log.INSTANCE.setImp(new i());
        this.f139181e.create(vVar.f(), vVar.B(), vVar.j());
        this.f139181e.enterForeground();
        if (((com.tencent.luggage.wxa.r4.d) t()).getRuntime() != null) {
            ((com.tencent.luggage.wxa.r4.d) t()).getRuntime().c0().a(new c.InterfaceC6640c() { // from class: com.tencent.luggage.wxa.r4.ah
                @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
                public final void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
                    f.this.b(str, bVar);
                }
            });
        } else {
            com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "hy: runtime not created!! will not trigger runtime lifecycle listening");
        }
        return true;
    }

    public void a(JSONObject jSONObject) {
    }

    public String c(String str) {
        return null;
    }

    public void d(String str) {
    }

    public Map q() {
        return null;
    }

    public void u() {
        if (t() != null && ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime() != null) {
            a(new ValueCallback() { // from class: com.tencent.luggage.wxa.r4.ae
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    ((e) obj).a();
                }
            });
            com.tencent.luggage.wxa.ei.n nVar = (com.tencent.luggage.wxa.ei.n) b(com.tencent.luggage.wxa.ei.n.class);
            if (nVar == null) {
                com.tencent.luggage.wxa.tn.w.f("Luggage.BaseAppBrandServiceLogic", "hy: no AppBrandJsRuntimeAddonDestroyListener");
                return;
            } else {
                nVar.a(new c(), true);
                nVar.a(new n.a() { // from class: com.tencent.luggage.wxa.r4.af
                    @Override // com.tencent.luggage.wxa.ei.n.a
                    public final void onDestroy() {
                        f.this.M();
                    }
                });
                return;
            }
        }
        com.tencent.luggage.wxa.tn.w.b("Luggage.BaseAppBrandServiceLogic", "hy: js runtime released when destroy");
    }

    public com.tencent.luggage.wxa.ei.j v() {
        return null;
    }

    public final void w() {
        ((com.tencent.luggage.wxa.r4.d) t()).d0();
    }

    public String x() {
        return ((com.tencent.luggage.wxa.r4.d) t()).getAppId();
    }

    public com.tencent.luggage.wxa.r4.a y() {
        if (G()) {
            com.tencent.luggage.wxa.r4.a aVar = this.f139179c;
            Objects.requireNonNull(aVar);
            return aVar;
        }
        return null;
    }

    public String z() {
        return ((com.tencent.luggage.wxa.r4.d) t()).getComponentId() + "";
    }

    public boolean a(String str, String str2, int i3, int i16) {
        return false;
    }

    public void b(JSONObject jSONObject) {
    }

    public boolean b(int i3, String str) {
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements LoadDelegate.ILoadLibrary {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f139194a;

        public h(String str) {
            this.f139194a = str;
        }

        public void loadLibrary(String str) {
            if (str.equals("mmwebrtc")) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "load libmmwebrtc.so by path: %s", this.f139194a);
                System.load(this.f139194a);
            } else {
                System.loadLibrary(str);
            }
        }

        public void loadLibrary(String str, ClassLoader classLoader) {
            System.loadLibrary(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, com.tencent.luggage.wxa.qc.b bVar) {
        int i3 = C6672f.f139192a[bVar.ordinal()];
        if (i3 == 1) {
            this.f139181e.enterSuspend();
        } else if (i3 == 2) {
            this.f139181e.enterForeground();
        } else {
            if (i3 != 3) {
                return;
            }
            this.f139181e.enterBackground();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements LibLoadDelegate.ILoadLibrary {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f139200a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f139201b;

        public m(String str, String str2) {
            this.f139200a = str;
            this.f139201b = str2;
        }

        public void loadLibrary(String str) {
            if (str.equals("magicar")) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "load libmagciar.so by path: %s", this.f139200a);
                com.tencent.luggage.wxa.aa.h.i(this.f139200a);
            } else if (str.equals("weslam")) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.BaseAppBrandServiceLogic", "load libweslam.so by path: %s", this.f139201b);
                com.tencent.luggage.wxa.aa.h.i(this.f139201b);
            } else {
                System.loadLibrary(str);
            }
        }

        public void loadLibrary(String str, ClassLoader classLoader) {
            System.loadLibrary(str);
        }
    }

    public void a(ValueCallback valueCallback) {
        Iterator it = s().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public boolean a(String str, JSONObject jSONObject) {
        if ("WebRTC".equals(str)) {
            return Y();
        }
        if ("WeMedia".equals(str)) {
            return X();
        }
        if (!"ARSession".equals(str)) {
            return false;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 24) {
            com.tencent.luggage.wxa.tn.w.f("Luggage.BaseAppBrandServiceLogic", "api version is " + i3 + ", can't use ar");
            return true;
        }
        N();
        return true;
    }

    public final com.tencent.luggage.wxa.ei.k b(Class cls) {
        if (t() != null && ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime() != null) {
            return ((com.tencent.luggage.wxa.r4.d) t()).getJsRuntime().a(cls);
        }
        com.tencent.luggage.wxa.tn.w.f("Luggage.BaseAppBrandServiceLogic", "hy: js runtime not ready");
        return null;
    }

    public void b(final com.tencent.luggage.wxa.ic.g gVar) {
        if (G()) {
            a(new a(gVar));
            gVar.c0().a(new b());
        }
        a(new Runnable() { // from class: com.tencent.luggage.wxa.r4.aj
            @Override // java.lang.Runnable
            public final void run() {
                f.this.a(gVar);
            }
        });
        a(new ValueCallback() { // from class: com.tencent.luggage.wxa.r4.ak
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                f.this.a(gVar, (e) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
        int i3 = C6672f.f139192a[bVar.ordinal()];
        if (i3 == 1) {
            this.f139182f.onSuspend();
        } else if (i3 == 2) {
            this.f139182f.onForeground();
        } else {
            if (i3 != 3) {
                return;
            }
            this.f139182f.onBackground();
        }
    }

    @Override // com.tencent.luggage.wxa.m4.a
    public Object a(Class cls) {
        if (com.tencent.luggage.wxa.rc.q.class.equals(cls)) {
            return cls.cast(((com.tencent.luggage.wxa.r4.d) t()).i());
        }
        if (cls.isInstance(this)) {
            return cls.cast(this);
        }
        return super.a(cls);
    }

    public void F() {
    }

    public void O() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.tencent.luggage.wxa.r4.e eVar) {
        com.tencent.luggage.wxa.r4.d dVar = (com.tencent.luggage.wxa.r4.d) t();
        Objects.requireNonNull(dVar);
        eVar.a(dVar);
    }

    public void a(Runnable runnable) {
        com.tencent.luggage.wxa.ei.q qVar = (com.tencent.luggage.wxa.ei.q) b(com.tencent.luggage.wxa.ei.q.class);
        if (qVar == null) {
            com.tencent.luggage.wxa.tn.w.f("Luggage.BaseAppBrandServiceLogic", "hy: no js thread addon. may be remote debug env");
            return;
        }
        com.tencent.luggage.wxa.c5.e runtime = t() != null ? ((com.tencent.luggage.wxa.r4.d) t()).getRuntime() : null;
        if (runtime != null) {
            runnable = com.tencent.luggage.wxa.uk.z.a(runtime, runnable);
        }
        qVar.a(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.tencent.luggage.wxa.ic.g gVar) {
        com.tencent.luggage.wxa.r4.g gVar2 = this.f139184h;
        if (gVar2 != null) {
            gVar2.a(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.r4.e eVar) {
        com.tencent.luggage.wxa.r4.d dVar = (com.tencent.luggage.wxa.r4.d) t();
        Objects.requireNonNull(dVar);
        eVar.a((com.tencent.luggage.wxa.c5.e) gVar, dVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l implements WeMediaCallback {
        public l() {
        }

        public String getAbTest(String str) {
            return com.tencent.luggage.wxa.im.a.b().a(str, "", true, true);
        }

        public String getAbsolutePath(String str) {
            String g16;
            if (str.startsWith("wxfile://")) {
                if (((com.tencent.luggage.wxa.r4.d) f.this.t()).getFileSystem() == null || ((com.tencent.luggage.wxa.r4.d) f.this.t()).getFileSystem().getAbsoluteFile(str) == null || (g16 = ((com.tencent.luggage.wxa.r4.d) f.this.t()).getFileSystem().getAbsoluteFile(str).g()) == null) {
                    return "";
                }
                return g16;
            }
            return str;
        }

        public boolean getExternalConfig(String str, boolean z16) {
            return com.tencent.luggage.wxa.im.a.b().a(str, z16);
        }

        public void reportEvent(String str, String str2, String str3) {
        }
    }
}
