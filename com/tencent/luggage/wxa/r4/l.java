package com.tencent.luggage.wxa.r4;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.ei.n;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l implements i {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.l f139218a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ei.t f139219b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Object f139220c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements ValueCallback {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ei.h f139222b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.r4.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6673a implements n.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ l f139223a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ei.h f139224b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Object f139225c;

            public C6673a(l lVar, com.tencent.luggage.wxa.ei.h hVar, Object obj) {
                this.f139223a = lVar;
                this.f139224b = hVar;
                this.f139225c = obj;
            }

            @Override // com.tencent.luggage.wxa.ei.n.a
            public final void onDestroy() {
                this.f139223a.f139220c = null;
                this.f139224b.a(this.f139225c);
            }
        }

        public a(com.tencent.luggage.wxa.ei.h hVar) {
            this.f139222b = hVar;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object obj) {
            com.tencent.luggage.wxa.ei.n nVar;
            l.this.f139220c = obj;
            if (obj == null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.JSContextInterfaceSharer", "onJSContextInterfaceInjected, value is null");
                return;
            }
            com.tencent.luggage.wxa.ei.j jsRuntime = l.this.f139218a.getJsRuntime();
            if (jsRuntime != null) {
                nVar = (com.tencent.luggage.wxa.ei.n) jsRuntime.a(com.tencent.luggage.wxa.ei.n.class);
            } else {
                nVar = null;
            }
            if (nVar == null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.JSContextInterfaceSharer", "onJSContextInterfaceInjected, addOn is null");
            } else {
                nVar.b(new C6673a(l.this, this.f139222b, obj));
            }
        }
    }

    public l(com.tencent.luggage.wxa.ic.l env, com.tencent.luggage.wxa.ei.t contextManager) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(contextManager, "contextManager");
        this.f139218a = env;
        this.f139219b = contextManager;
    }

    @Override // com.tencent.luggage.wxa.r4.i
    public void a() {
        com.tencent.luggage.wxa.ei.h s16 = this.f139219b.s();
        s16.a("WeixinJSContext", (ValueCallback) new a(s16));
    }

    @Override // com.tencent.luggage.wxa.r4.i
    public void a(com.tencent.luggage.wxa.ei.h context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object obj = this.f139220c;
        if (obj == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.JSContextInterfaceSharer", "shareTo, sharedObject is null");
        } else {
            context.a("WeixinJSContext", obj);
        }
    }
}
