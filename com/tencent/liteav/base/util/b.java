package com.tencent.liteav.base.util;

import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f119013a;

    /* renamed from: b, reason: collision with root package name */
    private final CountDownLatch f119014b;

    b(Runnable runnable, CountDownLatch countDownLatch) {
        this.f119013a = runnable;
        this.f119014b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new b(runnable, countDownLatch);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CustomHandler.lambda$runAndWaitDone$1(this.f119013a, this.f119014b);
    }
}
