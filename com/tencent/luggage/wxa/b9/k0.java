package com.tencent.luggage.wxa.b9;

import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k0 extends i0 {

    /* renamed from: q, reason: collision with root package name */
    public static final ThreadLocal f122243q = new ThreadLocal();

    /* renamed from: p, reason: collision with root package name */
    public final a f122244p;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    public k0(a aVar, boolean z16) {
        super("MicroMsg.WASMCompatibleV8JSRuntimeLooper", z16);
        this.f122244p = aVar;
    }

    public static k0 a(a aVar, boolean z16) {
        ThreadLocal threadLocal = f122243q;
        if (threadLocal.get() == null) {
            k0 k0Var = new k0(aVar, z16);
            threadLocal.set(k0Var);
            return k0Var;
        }
        throw new RuntimeException("Only one Looper may be created per thread");
    }

    public static /* synthetic */ String w() {
        return "loopTask end";
    }

    @Override // com.tencent.luggage.wxa.b9.i0
    public void p() {
        super.p();
        a aVar = this.f122244p;
        if (aVar != null) {
            aVar.a();
            a(new Function0() { // from class: com.tencent.luggage.wxa.b9.aj
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return k0.w();
                }
            });
        }
    }
}
