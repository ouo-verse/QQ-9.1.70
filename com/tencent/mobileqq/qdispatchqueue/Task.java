package com.tencent.mobileqq.qdispatchqueue;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes16.dex */
class Task implements Comparable<Task>, Runnable {
    static IPatchRedirector $redirector_;
    private long C;
    private volatile boolean D;
    private final CountDownLatch E;

    /* renamed from: d, reason: collision with root package name */
    private final long f261858d;

    /* renamed from: e, reason: collision with root package name */
    private final long f261859e;

    /* renamed from: f, reason: collision with root package name */
    private final long f261860f;

    /* renamed from: h, reason: collision with root package name */
    private final long f261861h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f261862i;

    /* renamed from: m, reason: collision with root package name */
    private long f261863m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task(long j3, Runnable runnable, long j16, boolean z16) {
        CountDownLatch countDownLatch;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), runnable, Long.valueOf(j16), Boolean.valueOf(z16));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f261860f = currentTimeMillis;
        this.D = false;
        this.f261858d = j3;
        this.f261862i = runnable;
        this.f261859e = j16;
        this.f261861h = currentTimeMillis + j16;
        if (z16) {
            countDownLatch = new CountDownLatch(1);
        } else {
            countDownLatch = null;
        }
        this.E = countDownLatch;
    }

    private static int c(long j3, long j16) {
        if (j3 == j16) {
            return 0;
        }
        if (j3 > j16) {
            return 1;
        }
        return -1;
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(Task task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) task)).intValue();
        }
        long j3 = this.f261861h;
        long j16 = task.f261861h;
        if (j3 == j16) {
            return c(this.f261858d, task.f261858d);
        }
        return c(j3, j16);
    }

    public long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.f261861h;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f261859e != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        CountDownLatch countDownLatch = this.E;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        this.D = true;
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.C = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        this.f261863m = System.currentTimeMillis();
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Runnable runnable = this.f261862i;
        if (runnable != null) {
            runnable.run();
        }
    }
}
