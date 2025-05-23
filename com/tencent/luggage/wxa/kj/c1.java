package com.tencent.luggage.wxa.kj;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.kj.b1;
import com.tencent.luggage.wxa.kj.c1;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c1 extends g0 implements b1 {

    /* renamed from: b, reason: collision with root package name */
    public v f132138b;

    /* renamed from: c, reason: collision with root package name */
    public b1.a f132139c;

    /* renamed from: d, reason: collision with root package name */
    public final b0 f132140d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f132141e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f132142f;

    /* renamed from: g, reason: collision with root package name */
    public final LinkedList f132143g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f132144h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f132145i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f132146j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f132147k;

    /* renamed from: l, reason: collision with root package name */
    public String f132148l;

    /* renamed from: m, reason: collision with root package name */
    public long f132149m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends b0 {
        public a(v vVar) {
            super(vVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            if (!c1.this.f132146j.get()) {
                c1.this.f132141e = true;
                c1.this.D();
            }
        }

        @Override // com.tencent.luggage.wxa.kj.b0
        public void b(String str) {
            if (!c1.this.f132141e) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.MPWebViewRenderEngineLegacyImpl", "[perf] PageFrame[%s] ready cost %dms", str, Long.valueOf(com.tencent.luggage.wxa.tn.w0.a() - c1.this.f132149m));
            }
            super.b(str);
            com.tencent.luggage.wxa.uk.l0.a(new Runnable() { // from class: b31.f
                @Override // java.lang.Runnable
                public final void run() {
                    c1.a.this.a();
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements e0 {
        public b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkedList f132152a;

        public c(LinkedList linkedList) {
            this.f132152a = linkedList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f132152a.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ URL f132154a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f132155b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f132156c;

        public d(URL url, String str, ValueCallback valueCallback) {
            this.f132154a = url;
            this.f132155b = str;
            this.f132156c = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String A0;
            int componentId;
            if (c1.this.f132146j.get()) {
                return;
            }
            if (this.f132154a != null) {
                if (c1.this.f132138b == null) {
                    A0 = null;
                } else {
                    A0 = c1.this.f132138b.A0();
                }
                if (c1.this.f132138b == null) {
                    componentId = 0;
                } else {
                    componentId = c1.this.f132138b.getComponentId();
                }
                com.tencent.luggage.wxa.tn.w.d("Luggage.MPWebViewRenderEngineLegacyImpl", "evaluateJavascript sourceURL:%s, componentURL:%s, componentId:%d, hash:%d", this.f132154a, A0, Integer.valueOf(componentId), Integer.valueOf(c1.this.hashCode()));
            }
            c1.this.b(this.f132155b, this.f132156c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132158a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f132159b;

        public e(String str, ValueCallback valueCallback) {
            this.f132158a = str;
            this.f132159b = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            c1.this.C().evaluateJavascript(this.f132158a, this.f132159b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c1.this.f132139c.b(true);
            c1.this.f132145i = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c1.this.f132139c.b(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c1.this.f132139c.c();
        }
    }

    public c1(o0 o0Var) {
        super(o0Var);
        this.f132141e = false;
        this.f132142f = false;
        this.f132143g = new LinkedList();
        this.f132144h = false;
        this.f132145i = false;
        this.f132146j = new AtomicBoolean(false);
        this.f132147k = false;
        this.f132148l = null;
        this.f132149m = 0L;
        a aVar = new a(null);
        this.f132140d = aVar;
        o0Var.setAppBrandWebViewClient(aVar);
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        super.destroy();
    }

    public final void D() {
        LinkedList linkedList = new LinkedList(this.f132143g);
        this.f132143g.clear();
        com.tencent.luggage.wxa.tn.w.d("Luggage.MPWebViewRenderEngineLegacyImpl", "executeDeferredEvaluations %s size %d, hash[%d]", this.f132148l, Integer.valueOf(linkedList.size()), Integer.valueOf(hashCode()));
        com.tencent.luggage.wxa.e5.g.a("executeDeferredEvaluations", new c(linkedList));
    }

    public final void F() {
        this.f132143g.clear();
    }

    public final void G() {
        if (C().a(com.tencent.luggage.wxa.mj.f.class) != null) {
            return;
        }
        C().setOnTrimListener(new b());
    }

    @Override // com.tencent.luggage.wxa.kj.g0, com.tencent.luggage.wxa.kj.o0, com.tencent.luggage.wxa.ei.j
    public void destroy() {
        if (!this.f132146j.getAndSet(true)) {
            if ((this.f132138b.getRuntime() instanceof com.tencent.luggage.wxa.c5.e) && ((com.tencent.luggage.wxa.c5.e) this.f132138b.getRuntime()).z1()) {
                F();
                super.evaluateJavascript("\n        ;(function() {\n            let data = (globalThis || {}).__coverage__ || new Function(\"return this\")().__coverage__;\n            if (typeof data === 'string' || typeof data === 'undefined') {\n                return data;\n            } else {\n                return JSON.stringify(data);\n            }\n        })();\n    ", new ValueCallback() { // from class: b31.e
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        c1.this.a((String) obj);
                    }
                });
            } else {
                super.destroy();
                F();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.kj.g0, com.tencent.luggage.wxa.ei.p
    public final void evaluateJavascript(String str, ValueCallback valueCallback) {
        a(null, str, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.kj.g0, com.tencent.luggage.wxa.kj.o0
    public v getPageView() {
        return this.f132138b;
    }

    @Override // com.tencent.luggage.wxa.kj.b1
    public void i() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.MPWebViewRenderEngineLegacyImpl", "dispatchPreload");
        b(true);
        e(new f());
    }

    @Override // com.tencent.luggage.wxa.kj.b1
    public boolean k() {
        return this.f132144h;
    }

    @Override // com.tencent.luggage.wxa.kj.b1
    public boolean l() {
        return this.f132145i;
    }

    @Override // com.tencent.luggage.wxa.kj.g0, com.tencent.luggage.wxa.kj.o0
    public void onBackground() {
        super.onBackground();
    }

    @Override // com.tencent.luggage.wxa.kj.g0, com.tencent.luggage.wxa.kj.o0
    public void onForeground() {
        super.onForeground();
        u();
    }

    @Override // com.tencent.luggage.wxa.kj.b1
    public boolean r() {
        return this.f132141e;
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setAppBrandInfo(Map map) {
        C().setAppBrandInfo(map);
    }

    @Override // com.tencent.luggage.wxa.kj.o0
    public void setOnTrimListener(e0 e0Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.tencent.luggage.wxa.q4.a
    public boolean u() {
        if (!this.f132147k) {
            return false;
        }
        this.f132142f = false;
        this.f132141e = false;
        y();
        e(new h());
        return true;
    }

    @Override // com.tencent.luggage.wxa.kj.b1
    public void y() {
        this.f132147k = false;
        this.f132144h = false;
        b0 b0Var = this.f132140d;
        String b16 = this.f132139c.b();
        this.f132148l = b16;
        b0Var.d(b16);
        G();
        com.tencent.luggage.wxa.tn.w.d("Luggage.MPWebViewRenderEngineLegacyImpl", "dispatchInit %s, mPageFrameReady %b, mPageFrameLoaded %b", this.f132148l, Boolean.valueOf(this.f132141e), Boolean.valueOf(this.f132142f));
        b(false);
        e(new g());
    }

    public final void e(Runnable runnable) {
        if (this.f132141e) {
            D();
            runnable.run();
        } else {
            this.f132143g.addLast(runnable);
        }
    }

    @Override // com.tencent.luggage.wxa.ei.j
    public final void a(URL url, String str, ValueCallback valueCallback) {
        if (!TextUtils.isEmpty(str) && !this.f132146j.get()) {
            com.tencent.luggage.wxa.tk.l.a(new d(url, str, valueCallback));
        } else if (valueCallback != null) {
            valueCallback.onReceiveValue("FATAL");
        }
    }

    @Override // com.tencent.luggage.wxa.kj.b1
    public void b(String str, ValueCallback valueCallback) {
        if (this.f132141e) {
            C().evaluateJavascript(str, valueCallback);
        } else {
            this.f132143g.addLast(new e(str, valueCallback));
        }
    }

    @Override // com.tencent.luggage.wxa.kj.b1
    public void a(b1.a aVar) {
        v a16 = aVar.a();
        this.f132138b = a16;
        this.f132139c = aVar;
        this.f132140d.a(a16);
        F();
    }

    @Override // com.tencent.luggage.wxa.kj.b1
    public void b(Runnable runnable) {
        if (this.f132141e) {
            D();
            runnable.run();
        } else {
            this.f132143g.addLast(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        com.tencent.luggage.wxa.xd.h0.a(this.f132138b, this, str);
        com.tencent.luggage.wxa.zp.h.f146825d.a(new Runnable() { // from class: b31.d
            @Override // java.lang.Runnable
            public final void run() {
                c1.this.E();
            }
        });
    }

    public final void b(boolean z16) {
        if (this.f132142f) {
            return;
        }
        this.f132149m = com.tencent.luggage.wxa.tn.w0.a();
        this.f132139c.a(z16);
        this.f132142f = true;
        if (z16) {
            this.f132144h = true;
        }
    }
}
