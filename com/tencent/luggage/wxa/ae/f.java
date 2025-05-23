package com.tencent.luggage.wxa.ae;

import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.f1;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f implements g {

    /* renamed from: g, reason: collision with root package name */
    public static final b f121066g = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public final k f121067a;

    /* renamed from: b, reason: collision with root package name */
    public final f1 f121068b;

    /* renamed from: c, reason: collision with root package name */
    public final long f121069c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.ae.a f121070d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f121071e;

    /* renamed from: f, reason: collision with root package name */
    public e0 f121072f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements e0.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public final boolean a() {
            w.d("MicroMsg.AppBrandAuthWithTimeoutListener", "timer expired timeout:" + f.this.f121069c + " ms");
            f.this.f121067a.b(f.this.f121068b);
            f fVar = f.this;
            synchronized (fVar) {
                fVar.f121071e = true;
                Unit unit = Unit.INSTANCE;
            }
            com.tencent.luggage.wxa.ae.a a16 = f.this.a();
            if (a16 != null) {
                a16.b();
            }
            f.this.f121072f = null;
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f(k api, f1 invokeContext, long j3) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(invokeContext, "invokeContext");
        this.f121067a = api;
        this.f121068b = invokeContext;
        this.f121069c = j3;
        if (j3 > 0) {
            w.d("MicroMsg.AppBrandAuthWithTimeoutListener", "start timeout timer:" + j3 + " ms");
            new e0(new a(), false).a(j3);
        }
    }

    @Override // com.tencent.luggage.wxa.ae.g
    public void b() {
        w.d("MicroMsg.AppBrandAuthWithTimeoutListener", "onAuthResult queueListener null:" + com.tencent.luggage.wxa.h6.d.b(this.f121070d));
        e0 e0Var = this.f121072f;
        if (e0Var != null) {
            w.a("MicroMsg.AppBrandAuthWithTimeoutListener", "stop timer");
            e0Var.f();
            this.f121072f = null;
        }
        com.tencent.luggage.wxa.ae.a aVar = this.f121070d;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final boolean c() {
        boolean z16;
        synchronized (this) {
            z16 = this.f121071e;
        }
        return z16;
    }

    public final synchronized com.tencent.luggage.wxa.ae.a a() {
        return this.f121070d;
    }

    public final synchronized void a(com.tencent.luggage.wxa.ae.a aVar) {
        this.f121070d = aVar;
    }
}
