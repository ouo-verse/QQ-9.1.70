package kotlinx.coroutines;

import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\u0082\b\u00a2\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u001c\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\n\u0010\u0013\u001a\u00060\u001ej\u0002`\u001fH\u0016J\b\u0010 \u001a\u00020\u0006H\u0002J!\u0010!\u001a\u00020\u00102\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#2\u0006\u0010\u0005\u001a\u00020\u0019H\u0000\u00a2\u0006\u0002\b$J\r\u0010%\u001a\u00020\u0017H\u0000\u00a2\u0006\u0002\b&J\u0015\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0000\u00a2\u0006\u0002\b*J\b\u0010+\u001a\u00020\u0004H\u0016J\r\u0010\u000f\u001a\u00020\u0017H\u0000\u00a2\u0006\u0002\b,R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lkotlinx/coroutines/CommonPool;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "DEFAULT_PARALLELISM_PROPERTY_NAME", "", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "parallelism", "", "getParallelism", "()I", "pool", "requestedParallelism", "usePrivatePool", "", "Try", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "close", "", "createPlainPool", "Ljava/util/concurrent/ExecutorService;", "createPool", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "getOrCreatePoolSync", "isGoodCommonPool", "fjpClass", "Ljava/lang/Class;", "isGoodCommonPool$kotlinx_coroutines_core", CanvasView.ACTION_RESTORE, "restore$kotlinx_coroutines_core", "shutdown", "timeout", "", "shutdown$kotlinx_coroutines_core", "toString", "usePrivatePool$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class CommonPool extends ExecutorCoroutineDispatcher {

    @NotNull
    private static final String DEFAULT_PARALLELISM_PROPERTY_NAME = "kotlinx.coroutines.default.parallelism";

    @NotNull
    public static final CommonPool INSTANCE = new CommonPool();

    @Nullable
    private static volatile Executor pool;
    private static final int requestedParallelism;
    private static boolean usePrivatePool;

    static {
        String str;
        Integer intOrNull;
        int intValue;
        try {
            str = System.getProperty(DEFAULT_PARALLELISM_PROPERTY_NAME);
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null) {
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
            if (intOrNull != null && intOrNull.intValue() >= 1) {
                intValue = intOrNull.intValue();
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", str).toString());
            }
        } else {
            intValue = -1;
        }
        requestedParallelism = intValue;
    }

    CommonPool() {
    }

    private final <T> T Try(Function0<? extends T> block) {
        try {
            return block.invoke();
        } catch (Throwable unused) {
            return null;
        }
    }

    private final ExecutorService createPlainPool() {
        final AtomicInteger atomicInteger = new AtomicInteger();
        return ProxyExecutors.newFixedThreadPool(getParallelism(), new ThreadFactory() { // from class: kotlinx.coroutines.a
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread m1984createPlainPool$lambda12;
                m1984createPlainPool$lambda12 = CommonPool.m1984createPlainPool$lambda12(atomicInteger, runnable);
                return m1984createPlainPool$lambda12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createPlainPool$lambda-12, reason: not valid java name */
    public static final Thread m1984createPlainPool$lambda12(AtomicInteger atomicInteger, Runnable runnable) {
        BaseThread baseThread = new BaseThread(runnable, Intrinsics.stringPlus("CommonPool-worker-", Integer.valueOf(atomicInteger.incrementAndGet())));
        baseThread.setDaemon(true);
        return baseThread;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ExecutorService createPool() {
        Class<?> cls;
        ExecutorService executorService;
        Object invoke;
        if (System.getSecurityManager() != null) {
            return createPlainPool();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return createPlainPool();
        }
        if (!usePrivatePool && requestedParallelism < 0) {
            try {
                invoke = cls.getMethod("commonPool", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable unused2) {
            }
            if (invoke instanceof ExecutorService) {
                executorService = (ExecutorService) invoke;
                if (executorService != null) {
                    if (!INSTANCE.isGoodCommonPool$kotlinx_coroutines_core(cls, executorService)) {
                        executorService = null;
                    }
                    if (executorService != null) {
                        return executorService;
                    }
                }
            }
            executorService = null;
            if (executorService != null) {
            }
        }
        try {
            Object newInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(INSTANCE.getParallelism()));
            if (newInstance instanceof ExecutorService) {
                executorService2 = (ExecutorService) newInstance;
            }
        } catch (Throwable unused3) {
        }
        if (executorService2 == null) {
            return createPlainPool();
        }
        return executorService2;
    }

    private final synchronized Executor getOrCreatePoolSync() {
        Executor executor;
        executor = pool;
        if (executor == null) {
            executor = createPool();
            pool = executor;
        }
        return executor;
    }

    private final int getParallelism() {
        boolean z16;
        int coerceAtLeast;
        Integer valueOf = Integer.valueOf(requestedParallelism);
        if (valueOf.intValue() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            valueOf = null;
        }
        if (valueOf == null) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Runtime.getRuntime().availableProcessors() - 1, 1);
            return coerceAtLeast;
        }
        return valueOf.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shutdown$lambda-16, reason: not valid java name */
    public static final void m1986shutdown$lambda16(Runnable runnable) {
        throw new RejectedExecutionException("CommonPool was shutdown");
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public void mo2047dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        Runnable wrapTask;
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = getOrCreatePoolSync();
            }
            AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource == null) {
                wrapTask = block;
            } else {
                wrapTask = timeSource.wrapTask(block);
            }
            executor.execute(wrapTask);
        } catch (RejectedExecutionException unused) {
            AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
            if (timeSource2 != null) {
                timeSource2.unTrackTask();
            }
            DefaultExecutor.INSTANCE.enqueue(block);
        }
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @NotNull
    public Executor getExecutor() {
        Executor executor = pool;
        if (executor == null) {
            return getOrCreatePoolSync();
        }
        return executor;
    }

    public final boolean isGoodCommonPool$kotlinx_coroutines_core(@NotNull Class<?> fjpClass, @NotNull ExecutorService executor) {
        executor.submit(new Runnable() { // from class: kotlinx.coroutines.b
            @Override // java.lang.Runnable
            public final void run() {
                CommonPool.m1985isGoodCommonPool$lambda9();
            }
        });
        Integer num = null;
        try {
            Object invoke = fjpClass.getMethod("getPoolSize", new Class[0]).invoke(executor, new Object[0]);
            if (invoke instanceof Integer) {
                num = (Integer) invoke;
            }
        } catch (Throwable unused) {
        }
        if (num == null || num.intValue() < 1) {
            return false;
        }
        return true;
    }

    public final synchronized void restore$kotlinx_coroutines_core() {
        shutdown$kotlinx_coroutines_core(0L);
        usePrivatePool = false;
        pool = null;
    }

    public final synchronized void shutdown$kotlinx_coroutines_core(long timeout) {
        ExecutorService executorService;
        Executor executor = pool;
        if (executor instanceof ExecutorService) {
            executorService = (ExecutorService) executor;
        } else {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
            if (timeout > 0) {
                executorService.awaitTermination(timeout, TimeUnit.MILLISECONDS);
            }
            Iterator<T> it = executorService.shutdownNow().iterator();
            while (it.hasNext()) {
                DefaultExecutor.INSTANCE.enqueue((Runnable) it.next());
            }
        }
        pool = new Executor() { // from class: kotlinx.coroutines.c
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                CommonPool.m1986shutdown$lambda16(runnable);
            }
        };
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return "CommonPool";
    }

    public final synchronized void usePrivatePool$kotlinx_coroutines_core() {
        shutdown$kotlinx_coroutines_core(0L);
        usePrivatePool = true;
        pool = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isGoodCommonPool$lambda-9, reason: not valid java name */
    public static final void m1985isGoodCommonPool$lambda9() {
    }
}
