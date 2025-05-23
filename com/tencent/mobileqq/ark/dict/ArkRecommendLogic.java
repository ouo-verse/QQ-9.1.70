package com.tencent.mobileqq.ark.dict;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.app.bd;
import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkRecommendLogic {

    /* renamed from: a, reason: collision with root package name */
    private static final ArkWordSegmentThread f199430a = new ArkWordSegmentThread();

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f199431b = false;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class ArkWordSegmentThread {

        /* renamed from: a, reason: collision with root package name */
        private bd f199432a;

        /* renamed from: b, reason: collision with root package name */
        private bc f199433b;

        /* compiled from: P */
        /* loaded from: classes11.dex */
        private static final class BlockingRunnable implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            private final Runnable f199434d;

            /* renamed from: e, reason: collision with root package name */
            private final ArkWordSegmentThread f199435e;

            /* renamed from: f, reason: collision with root package name */
            private volatile boolean f199436f = false;

            public BlockingRunnable(ArkWordSegmentThread arkWordSegmentThread, Runnable runnable) {
                this.f199434d = runnable;
                this.f199435e = arkWordSegmentThread;
            }

            public void e() {
                synchronized (this) {
                    this.f199435e.a().post(this);
                    while (!this.f199436f) {
                        try {
                            LockMethodProxy.wait(this);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f199434d.run();
                    synchronized (this) {
                        this.f199436f = true;
                        notifyAll();
                    }
                } catch (Throwable th5) {
                    synchronized (this) {
                        this.f199436f = true;
                        notifyAll();
                        throw th5;
                    }
                }
            }
        }

        public synchronized bc a() {
            if (this.f199432a == null) {
                bd newHandlerRecycleThread = ThreadManagerV2.newHandlerRecycleThread("ArkAnalyseThread", -1);
                this.f199432a = newHandlerRecycleThread;
                this.f199433b = newHandlerRecycleThread.b();
            }
            return this.f199433b;
        }

        public boolean b() {
            return a().j();
        }

        public void c(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            if (b()) {
                runnable.run();
            } else {
                new BlockingRunnable(this, runnable).e();
            }
        }
    }

    public static synchronized bc a() {
        bc a16;
        synchronized (ArkRecommendLogic.class) {
            if (!f199431b) {
                f199431b = true;
                b().a().post(new Runnable() { // from class: com.tencent.mobileqq.ark.dict.ArkRecommendLogic.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArkAiDictMgr.j(null);
                    }
                });
            }
            a16 = f199430a.a();
        }
        return a16;
    }

    public static ArkWordSegmentThread b() {
        return f199430a;
    }
}
