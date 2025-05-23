package com.tencent.rtmp.video.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes25.dex */
final /* synthetic */ class c implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f368827a;

    /* renamed from: b, reason: collision with root package name */
    private final CountDownLatch f368828b;

    c(Runnable runnable, CountDownLatch countDownLatch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable, (Object) countDownLatch);
        } else {
            this.f368827a = runnable;
            this.f368828b = countDownLatch;
        }
    }

    public static Runnable a(Runnable runnable, CountDownLatch countDownLatch) {
        return new c(runnable, countDownLatch);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.f368827a;
        CountDownLatch countDownLatch = this.f368828b;
        runnable.run();
        countDownLatch.countDown();
    }
}
