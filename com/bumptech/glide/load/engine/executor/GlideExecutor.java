package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GlideExecutor implements ExecutorService {

    /* renamed from: e, reason: collision with root package name */
    private static final long f31670e = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: f, reason: collision with root package name */
    private static volatile int f31671f;

    /* renamed from: d, reason: collision with root package name */
    private final ExecutorService f31672d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class DefaultThreadFactory implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        private final String f31673d;

        /* renamed from: e, reason: collision with root package name */
        final b f31674e;

        /* renamed from: f, reason: collision with root package name */
        final boolean f31675f;

        /* renamed from: h, reason: collision with root package name */
        private int f31676h;

        DefaultThreadFactory(String str, b bVar, boolean z16) {
            this.f31673d = str;
            this.f31674e = bVar;
            this.f31675f = z16;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            BaseThread baseThread;
            baseThread = new BaseThread(runnable, "glide-" + this.f31673d + "-thread-" + this.f31676h) { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.DefaultThreadFactory.1
                @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(9);
                    if (DefaultThreadFactory.this.f31675f) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th5) {
                        DefaultThreadFactory.this.f31674e.a(th5);
                    }
                }
            };
            this.f31676h = this.f31676h + 1;
            return baseThread;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f31677a;

        /* renamed from: b, reason: collision with root package name */
        private int f31678b;

        /* renamed from: c, reason: collision with root package name */
        private int f31679c;

        /* renamed from: d, reason: collision with root package name */
        @NonNull
        private b f31680d = b.f31686d;

        /* renamed from: e, reason: collision with root package name */
        private String f31681e;

        /* renamed from: f, reason: collision with root package name */
        private long f31682f;

        a(boolean z16) {
            this.f31677a = z16;
        }

        public GlideExecutor a() {
            if (!TextUtils.isEmpty(this.f31681e)) {
                BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(this.f31678b, this.f31679c, this.f31682f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(this.f31681e, this.f31680d, this.f31677a));
                if (this.f31682f != 0) {
                    baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new GlideExecutor(baseThreadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f31681e);
        }

        public a b(String str) {
            this.f31681e = str;
            return this;
        }

        public a c(@IntRange(from = 1) int i3) {
            this.f31678b = i3;
            this.f31679c = i3;
            return this;
        }
    }

    @VisibleForTesting
    GlideExecutor(ExecutorService executorService) {
        this.f31672d = executorService;
    }

    public static int a() {
        if (f31671f == 0) {
            f31671f = Math.min(4, com.bumptech.glide.load.engine.executor.a.a());
        }
        return f31671f;
    }

    public static a b() {
        int i3;
        if (a() >= 4) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        return new a(true).c(i3).b("animation");
    }

    public static GlideExecutor c() {
        return b().a();
    }

    public static a e() {
        return new a(true).c(1).b("disk-cache");
    }

    public static GlideExecutor g() {
        return e().a();
    }

    public static a h() {
        return new a(false).c(a()).b("source");
    }

    public static GlideExecutor i() {
        return h().a();
    }

    public static GlideExecutor j() {
        return new GlideExecutor(new BaseThreadPoolExecutor(0, Integer.MAX_VALUE, f31670e, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory("source-unlimited", b.f31686d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j3, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f31672d.awaitTermination(j3, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f31672d.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f31672d.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.f31672d.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f31672d.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f31672d.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f31672d.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f31672d.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f31672d.submit(runnable);
    }

    public String toString() {
        return this.f31672d.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j3, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f31672d.invokeAll(collection, j3, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j3, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.f31672d.invokeAny(collection, j3, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t16) {
        return this.f31672d.submit(runnable, t16);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f31672d.submit(callable);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f31683a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final b f31684b;

        /* renamed from: c, reason: collision with root package name */
        public static final b f31685c;

        /* renamed from: d, reason: collision with root package name */
        public static final b f31686d;

        /* compiled from: P */
        /* renamed from: com.bumptech.glide.load.engine.executor.GlideExecutor$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0216b implements b {
            C0216b() {
            }

            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.b
            public void a(Throwable th5) {
                if (th5 != null && Log.isLoggable("GlideExecutor", 6)) {
                    Log.e("GlideExecutor", "Request threw uncaught throwable", th5);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes.dex */
        class c implements b {
            c() {
            }

            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.b
            public void a(Throwable th5) {
                if (th5 == null) {
                } else {
                    throw new RuntimeException("Request threw uncaught throwable", th5);
                }
            }
        }

        static {
            C0216b c0216b = new C0216b();
            f31684b = c0216b;
            f31685c = new c();
            f31686d = c0216b;
        }

        void a(Throwable th5);

        /* compiled from: P */
        /* loaded from: classes.dex */
        class a implements b {
            a() {
            }

            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.b
            public void a(Throwable th5) {
            }
        }
    }
}
