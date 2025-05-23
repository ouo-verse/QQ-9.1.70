package com.tencent.luggage.wxa.b9;

import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m extends i0 {

    /* renamed from: r, reason: collision with root package name */
    public static final ThreadLocal f122249r = new ThreadLocal();

    /* renamed from: p, reason: collision with root package name */
    public final a f122250p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f122251q;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a();

        boolean a(boolean z16);

        void b();
    }

    public m(a aVar, boolean z16) {
        super("MicroMsg.NodeJSRuntimeLooper", z16);
        this.f122250p = aVar;
        this.f122251q = true;
    }

    public static m a(a aVar, boolean z16) {
        ThreadLocal threadLocal = f122249r;
        if (threadLocal.get() == null) {
            m mVar = new m(aVar, z16);
            threadLocal.set(mVar);
            return mVar;
        }
        throw new RuntimeException("Only one Looper may be created per thread");
    }

    @Override // com.tencent.luggage.wxa.b9.i0
    public void h() {
        super.h();
        this.f122251q = this.f122250p.a(true);
    }

    @Override // com.tencent.luggage.wxa.b9.i0
    public void p() {
        super.p();
        this.f122251q = this.f122250p.a(false);
        a(new Function0() { // from class: com.tencent.luggage.wxa.b9.ak
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String w3;
                w3 = m.this.w();
                return w3;
            }
        });
    }

    @Override // com.tencent.luggage.wxa.b9.i0
    public void q() {
        super.q();
        a aVar = this.f122250p;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.luggage.wxa.b9.i0
    public void r() {
        if (this.f122250p != null) {
            com.tencent.luggage.wxa.tn.w.d(this.f122208a, "onQuit wakeUpUVLoop");
            this.f122250p.b();
        }
    }

    @Override // com.tencent.luggage.wxa.b9.i0
    public void s() {
        a aVar = this.f122250p;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.tencent.luggage.wxa.b9.i0
    public void t() {
        if (this.f122250p != null && !j()) {
            this.f122250p.b();
        }
    }

    @Override // com.tencent.luggage.wxa.b9.i0
    public boolean v() {
        if (!this.f122251q && super.v()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String w() {
        return "loopTask end: UvLoopAlive=" + this.f122251q;
    }
}
