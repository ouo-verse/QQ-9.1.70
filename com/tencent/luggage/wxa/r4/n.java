package com.tencent.luggage.wxa.r4;

import android.webkit.ValueCallback;
import java.util.LinkedList;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final c f139228a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f139229b = false;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ln.a f139230c = new com.tencent.luggage.wxa.ln.a(1, new Runnable() { // from class: com.tencent.luggage.wxa.r4.ao
        @Override // java.lang.Runnable
        public final void run() {
            n.this.a();
        }
    });

    /* renamed from: d, reason: collision with root package name */
    public final LinkedList f139231d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f139232e = false;

    public n(c cVar) {
        this.f139228a = cVar;
    }

    public void b() {
        this.f139230c.b();
    }

    public void c() {
        if (this.f139228a.L() && this.f139229b) {
            if (this.f139228a.n0()) {
                this.f139228a.f0().evaluateJavascript("(function() {\n    if (typeof __wxConfig !== 'undefined') {\n        __wxConfig.exportBaseMethods = true;\n    }\n})();", new ValueCallback() { // from class: com.tencent.luggage.wxa.r4.an
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandMiniProgramServiceLogicImp.LoadSubPackageSafeControl", "onInternalBootstrapScriptsInjected assign __wxConfig.exportBaseMethods end");
                    }
                });
            }
            this.f139230c.b();
        }
    }

    public final void a() {
        LinkedList linkedList;
        synchronized (this.f139231d) {
            linkedList = new LinkedList(this.f139231d);
            this.f139231d.clear();
            this.f139232e = true;
        }
        while (!linkedList.isEmpty()) {
            Runnable runnable = (Runnable) linkedList.pollFirst();
            Objects.requireNonNull(runnable);
            runnable.run();
        }
    }

    public void a(Runnable runnable) {
        synchronized (this.f139231d) {
            if (!this.f139232e) {
                this.f139231d.addLast(runnable);
            } else {
                runnable.run();
            }
        }
    }
}
