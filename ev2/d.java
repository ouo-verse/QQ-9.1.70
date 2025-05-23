package ev2;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final int f397196a;

    /* renamed from: b, reason: collision with root package name */
    private static final Executor f397197b;

    /* renamed from: c, reason: collision with root package name */
    private static final Executor f397198c;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        private final AtomicInteger f397199d = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new BaseThread(null, runnable, "Task-Thread-" + this.f397199d.getAndIncrement(), 65536L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        private final AtomicInteger f397200d = new AtomicInteger(1);

        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new BaseThread(null, runnable, "IO-Thread-" + this.f397200d.getAndIncrement(), 65536L);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f397196a = availableProcessors;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f397197b = new BaseThreadPoolExecutor(availableProcessors, 50, 10L, timeUnit, new ArrayBlockingQueue(50), new a());
        f397198c = new BaseThreadPoolExecutor(0, Integer.MAX_VALUE, 10L, timeUnit, new SynchronousQueue(), new b());
    }

    public static Executor a() {
        ExecutorService executorService;
        hv2.e b16 = b();
        if (b16 != null) {
            executorService = b16.a();
        } else {
            executorService = null;
        }
        if (executorService == null) {
            return f397198c;
        }
        return executorService;
    }

    private static hv2.e b() {
        return (hv2.e) dv2.b.d().a(hv2.e.class);
    }

    public static Executor c() {
        ExecutorService executorService;
        hv2.e b16 = b();
        if (b16 != null) {
            executorService = b16.a();
        } else {
            executorService = null;
        }
        if (executorService == null) {
            return f397197b;
        }
        return executorService;
    }
}
