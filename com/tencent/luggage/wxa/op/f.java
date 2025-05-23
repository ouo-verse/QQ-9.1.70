package com.tencent.luggage.wxa.op;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public CountDownLatch f137083a = null;

    public void a() {
        CountDownLatch countDownLatch = this.f137083a;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public void a(long j3, Runnable runnable) {
        com.tencent.luggage.wxa.np.e.c("Soter.SyncJob", "doAsSyncJob", new Object[0]);
        if (runnable == null) {
            return;
        }
        this.f137083a = new CountDownLatch(1);
        runnable.run();
        CountDownLatch countDownLatch = this.f137083a;
        if (countDownLatch != null) {
            try {
                countDownLatch.await(j3, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e16) {
                com.tencent.luggage.wxa.np.e.a("Soter.SyncJob", e16, "");
            }
        }
    }
}
