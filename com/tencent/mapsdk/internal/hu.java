package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class hu {

    /* renamed from: a, reason: collision with root package name */
    private static final a f148745a = new a("sw");

    /* renamed from: b, reason: collision with root package name */
    private static final a f148746b = new a("lw");

    /* renamed from: c, reason: collision with root package name */
    private static final a f148747c = new a("mlw");

    /* renamed from: d, reason: collision with root package name */
    private static final a f148748d = new a("qw");

    /* renamed from: e, reason: collision with root package name */
    private static final a f148749e = new a("mqw");

    /* renamed from: f, reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f148750f;

    /* renamed from: g, reason: collision with root package name */
    private static ThreadPoolExecutor f148751g;

    /* renamed from: h, reason: collision with root package name */
    private static ThreadPoolExecutor f148752h;

    /* renamed from: i, reason: collision with root package name */
    private static ThreadPoolExecutor f148753i;

    /* renamed from: j, reason: collision with root package name */
    private static ThreadPoolExecutor f148754j;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private String f148755a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f148756b = new AtomicInteger(0);

        public a(String str) {
            this.f148755a = str;
            if (TextUtils.isEmpty(str)) {
                this.f148755a = "def";
            }
        }

        private int b() {
            return this.f148756b.get();
        }

        final a a() {
            this.f148756b.set(0);
            return this;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            BaseThread baseThread = new BaseThread(runnable, "tms-" + this.f148755a + "-" + this.f148756b.incrementAndGet());
            LogUtil.a("\u521b\u5efa\u7ebf\u7a0b\uff1a".concat(String.valueOf(baseThread)));
            return baseThread;
        }
    }

    public static synchronized ScheduledThreadPoolExecutor a() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (hu.class) {
            if (a(f148750f)) {
                f148750f = new BaseScheduledThreadPoolExecutor(2, f148745a.a(), new ThreadPoolExecutor.DiscardPolicy());
            }
            scheduledThreadPoolExecutor = f148750f;
        }
        return scheduledThreadPoolExecutor;
    }

    public static synchronized ThreadPoolExecutor b() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (hu.class) {
            if (a(f148751g)) {
                f148751g = new BaseThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), f148748d.a(), new ThreadPoolExecutor.DiscardPolicy());
            }
            threadPoolExecutor = f148751g;
        }
        return threadPoolExecutor;
    }

    public static synchronized ThreadPoolExecutor c() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (hu.class) {
            if (a(f148752h)) {
                int max = Math.max(4, Runtime.getRuntime().availableProcessors());
                f148752h = new BaseThreadPoolExecutor(max / 2, max, 2L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f148749e.a(), new ThreadPoolExecutor.DiscardPolicy());
            }
            threadPoolExecutor = f148752h;
        }
        return threadPoolExecutor;
    }

    public static synchronized ThreadPoolExecutor d() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (hu.class) {
            if (a(f148753i)) {
                f148753i = new BaseThreadPoolExecutor(0, 1, 2L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f148746b.a(), new ThreadPoolExecutor.DiscardPolicy());
            }
            threadPoolExecutor = f148753i;
        }
        return threadPoolExecutor;
    }

    private static synchronized ThreadPoolExecutor e() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (hu.class) {
            if (a(f148754j)) {
                f148754j = new BaseThreadPoolExecutor(0, Math.max(4, Runtime.getRuntime().availableProcessors()) / 2, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f148747c.a(), new ThreadPoolExecutor.DiscardPolicy());
            }
            threadPoolExecutor = f148754j;
        }
        return threadPoolExecutor;
    }

    private static String f() {
        Thread currentThread = Thread.currentThread();
        return currentThread + ";" + currentThread.getState() + ";interrupted=" + Thread.interrupted() + "|" + currentThread.isInterrupted();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean a(ExecutorService executorService) {
        boolean z16;
        synchronized (hu.class) {
            if (executorService != null) {
                try {
                    if (!executorService.isShutdown() && !executorService.isTerminated()) {
                        z16 = true;
                        if (executorService instanceof ThreadPoolExecutor) {
                            if (z16) {
                                if (!((ThreadPoolExecutor) executorService).isTerminating()) {
                                    z16 = true;
                                }
                            }
                            z16 = false;
                        }
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
            z16 = false;
            if (executorService instanceof ThreadPoolExecutor) {
            }
        }
        return !z16;
    }
}
