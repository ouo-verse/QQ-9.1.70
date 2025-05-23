package com.huawei.hms.hatool;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b0 {

    /* renamed from: b, reason: collision with root package name */
    private static b0 f37069b;

    /* renamed from: c, reason: collision with root package name */
    private static b0 f37070c;

    /* renamed from: d, reason: collision with root package name */
    private static b0 f37071d;

    /* renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f37072a = new BaseThreadPoolExecutor(0, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b());

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Runnable f37073a;

        public a(Runnable runnable) {
            this.f37073a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f37073a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    v.e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class b implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        private static final AtomicInteger f37074d = new AtomicInteger(1);

        /* renamed from: a, reason: collision with root package name */
        private final ThreadGroup f37075a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f37076b = new AtomicInteger(1);

        /* renamed from: c, reason: collision with root package name */
        private final String f37077c;

        b() {
            ThreadGroup threadGroup;
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.f37075a = threadGroup;
            this.f37077c = "FormalHASDK-base-" + f37074d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new BaseThread(this.f37075a, runnable, this.f37077c + this.f37076b.getAndIncrement(), 0L);
        }
    }

    static {
        new b0();
        new b0();
        f37069b = new b0();
        f37070c = new b0();
        f37071d = new b0();
    }

    b0() {
    }

    public static b0 a() {
        return f37071d;
    }

    public static b0 b() {
        return f37070c;
    }

    public static b0 c() {
        return f37069b;
    }

    public void a(g gVar) {
        try {
            this.f37072a.execute(new a(gVar));
        } catch (RejectedExecutionException unused) {
            v.e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
