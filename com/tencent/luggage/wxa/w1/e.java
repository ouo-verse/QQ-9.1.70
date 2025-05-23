package com.tencent.luggage.wxa.w1;

import android.webkit.JavascriptInterface;
import androidx.annotation.CallSuper;
import com.tencent.luggage.wxa.ei.h;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ei.t;
import com.tencent.luggage.wxa.ei.v;
import com.tencent.luggage.wxa.r4.m;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.x;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.r4.b {

    /* renamed from: e, reason: collision with root package name */
    public boolean f144046e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements x.e {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void a(String str) {
            w.d("MicroMsg.WAGameJsContextInterfaceLU", "Interface port loadJsFiles success");
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void b(String str) {
            w.b("MicroMsg.WAGameJsContextInterfaceLU", "Interface port loadJsFiles fail");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements x.e {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void a(String str) {
            w.d("MicroMsg.WAGameJsContextInterfaceLU", "Interface dl: success");
        }

        @Override // com.tencent.luggage.wxa.uk.x.e
        public void b(String str) {
            w.d("MicroMsg.WAGameJsContextInterfaceLU", "Interface dl: fail");
        }
    }

    public e(com.tencent.luggage.wxa.r4.d dVar, t tVar) {
        super(dVar, tVar);
        this.f144046e = false;
    }

    public void a(j jVar) {
        jVar.addJavascriptInterface(this, "WeixinJSContext");
        x.a(jVar, m.f139227b, new a());
        x.a(jVar, String.format(";(function(){let interface = %s;let alloc = interface.alloc;let allocNativeGlobal = interface.allocNativeGlobal;interface.alloc = function(injectNativeGlobal) {if(injectNativeGlobal){return allocNativeGlobal();}else{return alloc();}}})();", "WeixinJSContext"), new b());
        f();
    }

    @JavascriptInterface
    @CallSuper
    public int allocNativeGlobal() {
        this.f144046e = true;
        int alloc = super.alloc();
        w.d("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%d]", Boolean.valueOf(this.f144046e), Integer.valueOf(alloc));
        this.f144046e = false;
        return alloc;
    }

    @Override // com.tencent.luggage.wxa.r4.b
    public String d() {
        return "WAGameSubContext.js";
    }

    @Override // com.tencent.luggage.wxa.r4.b
    public void f() {
        super.f();
        w.d("MicroMsg.WAGameJsContextInterfaceLU", "hy: injected WAGameJSContextInterface");
    }

    @Override // com.tencent.luggage.wxa.r4.b
    public h a() {
        boolean z16;
        h a16 = super.a();
        if (a16 != null) {
            if (this.f144046e) {
                try {
                    v vVar = (v) a16.a(v.class);
                    com.tencent.luggage.wxa.w1.b bVar = (com.tencent.luggage.wxa.w1.b) c().h(com.tencent.luggage.wxa.w1.b.class);
                    if (bVar != null) {
                        bVar.n().a(vVar.f(), vVar.B(), vVar.j());
                    } else {
                        w.f("MicroMsg.WAGameJsContextInterfaceLU", "No extension found!");
                    }
                } catch (NullPointerException e16) {
                    w.b("MicroMsg.WAGameJsContextInterfaceLU", "injectNativeGlobal failed [%s]", e16);
                    z16 = false;
                }
            }
            z16 = true;
            w.d("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%b]", Boolean.valueOf(this.f144046e), Boolean.valueOf(z16));
        }
        return a16;
    }

    @Override // com.tencent.luggage.wxa.r4.b
    public void a(int i3, String str) {
        super.a(i3, str);
        if (this.f144046e) {
            a(i3).evaluateJavascript(com.tencent.luggage.wxa.tk.c.b("wxa_library/NativeGlobal-WAGame.js"), null);
        }
    }
}
