package com.tencent.luggage.wxa.yo;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends d {
    public c() {
        com.tencent.luggage.wxa.wo.a.d("Vending.NoLooperScheduler", "This is not a handler thread! %s", Thread.currentThread());
    }

    @Override // com.tencent.luggage.wxa.yo.d
    public void a() {
    }

    @Override // com.tencent.luggage.wxa.yo.d
    public void a(Runnable runnable) {
        com.tencent.luggage.wxa.wo.a.d("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
        runnable.run();
    }

    @Override // com.tencent.luggage.wxa.yo.d
    public void a(Runnable runnable, long j3) {
        com.tencent.luggage.wxa.wo.a.d("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
        runnable.run();
    }
}
