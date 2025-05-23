package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.utils;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import pw2.n;
import qv2.b;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class BaseTimerRunnable implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    private static final String f303667e = "BaseTimerRunnable";

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f303668d;

    protected abstract void e();

    protected abstract void f();

    public synchronized boolean g() {
        return this.f303668d;
    }

    protected int h() {
        return 100;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f303668d = true;
        e();
        while (this.f303668d) {
            try {
                f();
                LockMethodProxy.sleep(h());
            } catch (Exception e16) {
                this.f303668d = false;
                n.c(f303667e, e16);
                if (b.e()) {
                    try {
                        throw e16;
                    } catch (InterruptedException e17) {
                        e17.printStackTrace();
                        return;
                    }
                }
                return;
            }
        }
        n.a(f303667e, "CountDownRunnable FINISH");
    }

    public synchronized void stop() {
        this.f303668d = false;
    }
}
