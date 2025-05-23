package com.tencent.liteav.base.util;

import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f119011a;

    /* renamed from: b, reason: collision with root package name */
    private final CountDownLatch f119012b;

    a(Runnable runnable, CountDownLatch countDownLatch) {
        this.f119011a = runnable;
        this.f119012b = countDownLatch;
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new a(runnable, countDownLatch);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CustomHandler.lambda$runAndWaitDone$0(this.f119011a, this.f119012b);
    }
}
