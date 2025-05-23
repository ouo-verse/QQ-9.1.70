package com.tencent.luggage.wxa.n3;

import com.tencent.luggage.wxa.bj.a;
import com.tencent.luggage.wxa.hn.s8;
import com.tencent.luggage.wxa.hn.t8;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public class o0 implements com.tencent.luggage.wxa.bj.c {

    /* renamed from: a, reason: collision with root package name */
    public static final o0 f135228a = new o0();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements i0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f135229a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f135230b;

        public a(AtomicReference atomicReference, CountDownLatch countDownLatch) {
            this.f135229a = atomicReference;
            this.f135230b = countDownLatch;
        }

        @Override // com.tencent.luggage.wxa.n3.i0
        public void a(t8 t8Var) {
            this.f135229a.set(t8Var);
            this.f135230b.countDown();
        }

        @Override // com.tencent.luggage.wxa.n3.i0
        public void a(a.EnumC6074a enumC6074a, int i3, String str) {
            this.f135229a.set(null);
            this.f135230b.countDown();
        }
    }

    @Override // com.tencent.luggage.wxa.bj.c
    public t8 a(String str, String str2, com.tencent.luggage.wxa.fn.b bVar, Class cls) {
        AtomicReference atomicReference = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            k0.a(str, str2, (s8) bVar, cls, new a(atomicReference, countDownLatch));
        } catch (IOException unused) {
            atomicReference.set(null);
            countDownLatch.countDown();
        }
        try {
            if (!countDownLatch.await(60L, TimeUnit.SECONDS)) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaSessionKeyCgiService", "sync [%s] timeout", str);
            }
        } catch (InterruptedException unused2) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaSessionKeyCgiService", "interrupted");
            Thread.currentThread().interrupt();
        }
        return (t8) atomicReference.get();
    }

    @Override // com.tencent.luggage.wxa.bj.c
    public com.tencent.luggage.wxa.xo.d b(String str, String str2, com.tencent.luggage.wxa.fn.b bVar, Class cls) {
        return k0.c(str, str2, (s8) bVar, cls);
    }
}
