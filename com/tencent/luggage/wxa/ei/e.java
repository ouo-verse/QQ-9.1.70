package com.tencent.luggage.wxa.ei;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.b9.t;
import com.tencent.luggage.wxa.ei.o;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.appbrand.commonjni.AppBrandJsBridgeBinding;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e implements h, l, u, q, o, v, m, s, k {

    /* renamed from: a, reason: collision with root package name */
    public x f124877a;

    /* renamed from: b, reason: collision with root package name */
    public AppBrandJsBridgeBinding f124878b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements t.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f124879a;

        public a(ValueCallback valueCallback) {
            this.f124879a = valueCallback;
        }

        @Override // com.tencent.luggage.wxa.b9.t.s
        public void a(String str, t.C6044t c6044t) {
            this.f124879a.onReceiveValue(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements t.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f124881a;

        public b(ValueCallback valueCallback) {
            this.f124881a = valueCallback;
        }

        @Override // com.tencent.luggage.wxa.b9.t.s
        public void a(String str, t.C6044t c6044t) {
            this.f124881a.onReceiveValue(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements t.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f124883a;

        public c(ValueCallback valueCallback) {
            this.f124883a = valueCallback;
        }

        @Override // com.tencent.luggage.wxa.b9.t.s
        public void a(String str, t.C6044t c6044t) {
            this.f124883a.onReceiveValue(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f124878b != null) {
                e.this.f124878b.destroyRuntime();
                e.this.f124878b = null;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ei.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6172e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f124886a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f124887b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f124888c;

        public RunnableC6172e(int i3, String str, String str2) {
            this.f124886a = i3;
            this.f124887b = str;
            this.f124888c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f124878b == null) {
                e.this.f124878b = new AppBrandJsBridgeBinding();
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by invokeCallbackHandler callbackId[%d]", Integer.valueOf(this.f124886a));
                e.this.f124878b.createRuntime(e.this.f(), e.this.B());
            }
            e.this.f124878b.invokeCallbackHandler(this.f124886a, this.f124887b, this.f124888c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o.a f124890a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f124891b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f124892c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f124893d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f124894e;

        public f(o.a aVar, String str, String str2, int i3, String str3) {
            this.f124890a = aVar;
            this.f124891b = str;
            this.f124892c = str2;
            this.f124893d = i3;
            this.f124894e = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.b bVar;
            if (this.f124890a != null) {
                bVar = new o.b();
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bVar.f124905a = System.currentTimeMillis();
            }
            if (e.this.f124878b == null) {
                e.this.f124878b = new AppBrandJsBridgeBinding();
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by subscribeHandler");
                e.this.f124878b.createRuntime(e.this.f(), e.this.B());
            }
            e.this.f124878b.subscribeHandler(w0.d(this.f124891b), w0.d(this.f124892c), this.f124893d, w0.d(this.f124894e));
            if (bVar != null) {
                bVar.f124906b = System.currentTimeMillis();
                this.f124890a.a("", bVar);
            }
        }
    }

    public long B() {
        return C().f();
    }

    public abstract com.tencent.luggage.wxa.b9.t C();

    @Override // com.tencent.luggage.wxa.ei.j
    public void addJavascriptInterface(Object obj, String str) {
        C().a(obj, str, JavascriptInterface.class);
    }

    public int b(int i3) {
        return C().i().a(i3);
    }

    public boolean c() {
        return u().c();
    }

    @Override // com.tencent.luggage.wxa.ei.q
    public /* synthetic */ void d(Runnable runnable) {
        l21.b.a(this, runnable);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void destroy() {
        u().a(new d());
        C().c();
    }

    public boolean e() {
        return C().e().e();
    }

    @Override // com.tencent.luggage.wxa.ei.p
    public void evaluateJavascript(String str, ValueCallback valueCallback) {
        a aVar;
        if (valueCallback == null) {
            aVar = null;
        } else {
            aVar = new a(valueCallback);
        }
        C().a(str, (t.s) aVar);
    }

    public long f() {
        return u().f();
    }

    public ByteBuffer g(int i3) {
        return C().i().c(i3);
    }

    public void h() {
        C().b();
    }

    public long j() {
        return u().j();
    }

    public x m() {
        return this.f124877a;
    }

    public int p() {
        return C().e().f();
    }

    public void pause() {
        u().pause();
    }

    public abstract com.tencent.luggage.wxa.b9.d u();

    public boolean w() {
        return C().l();
    }

    public void b() {
        u().b();
    }

    public String d() {
        return u().d();
    }

    public void e(int i3) {
        C().i().b(i3);
    }

    public boolean g() {
        return u().i();
    }

    @Override // com.tencent.luggage.wxa.ei.h
    public void a(h hVar, String str) {
        if (hVar instanceof e) {
            C().a(str, ((e) hVar).C());
            return;
        }
        Object[] objArr = new Object[1];
        objArr[0] = hVar == null ? null : hVar.getClass().getName();
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandJ2V8Context", "shareObject with unsupported implementation %s", objArr);
    }

    @Override // com.tencent.luggage.wxa.ei.h
    public void a(String str, ValueCallback valueCallback) {
        C().a(str, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.ei.h
    public void a(String str, Object obj) {
        C().a(str, obj);
    }

    @Override // com.tencent.luggage.wxa.ei.h
    public void a(Object obj) {
        C().a(obj);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void a(URL url, String str, ValueCallback valueCallback) {
        if (url == null) {
            evaluateJavascript(str, valueCallback);
        } else {
            C().a(url.toString(), str, valueCallback == null ? null : new b(valueCallback));
        }
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public void a(URL url, String str, String str2, int i3, String str3, ValueCallback valueCallback) {
        C().a(url != null ? url.toString() : null, str3, valueCallback == null ? null : new c(valueCallback), str, str2, i3);
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public k a(Class cls) {
        if (cls.isInstance(this)) {
            return this;
        }
        return null;
    }

    public void a(int i3, ByteBuffer byteBuffer) {
        C().e().a(i3, byteBuffer);
    }

    public ByteBuffer a(int i3, boolean z16) {
        return C().e().a(i3, z16);
    }

    public void a(x xVar) {
        this.f124877a = xVar;
    }

    public void a(long j3, long j16) {
        C().e().a(j3, j16);
    }

    public void a() {
        u().a();
    }

    public void a(Runnable runnable) {
        a(runnable, false);
    }

    public void a(Runnable runnable, boolean z16) {
        u().a(runnable, 0L, z16);
    }

    public void a(int i3) {
        u().a(i3);
    }

    public void a(URL url, String str, String str2, int i3, String str3, t.s sVar) {
        C().a(url == null ? null : url.toString(), str3, sVar, str, str2, i3);
    }

    public void a(ArrayList arrayList, String str, t.s sVar) {
        C().a(arrayList, str, sVar);
    }

    @Override // com.tencent.luggage.wxa.ei.o
    public final void a(int i3, String str, String str2) {
        u().a(new RunnableC6172e(i3, str, str2));
    }

    @Override // com.tencent.luggage.wxa.ei.o
    public final void a(String str, String str2, int i3, String str3) {
        a(str, str2, i3, str3, null);
    }

    @Override // com.tencent.luggage.wxa.ei.o
    public final void a(String str, String str2, int i3, String str3, o.a aVar) {
        u().a(new f(aVar, str, str2, i3, str3));
    }

    public void a(String str, boolean z16) {
        C().a(str, z16);
    }

    public void a(String str, String str2, ValueCallback valueCallback) {
        C().a(str, str2);
    }
}
