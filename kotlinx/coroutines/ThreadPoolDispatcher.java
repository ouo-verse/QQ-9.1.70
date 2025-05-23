package kotlinx.coroutines;

import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/ThreadPoolDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcherBase;", "nThreads", "", "name", "", "(ILjava/lang/String;)V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "threadNo", "Ljava/util/concurrent/atomic/AtomicInteger;", "close", "", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ThreadPoolDispatcher extends ExecutorCoroutineDispatcherBase {

    @NotNull
    private final Executor executor;
    private final int nThreads;

    @NotNull
    private final String name;

    @NotNull
    private final AtomicInteger threadNo = new AtomicInteger();

    public ThreadPoolDispatcher(int i3, @NotNull String str) {
        this.nThreads = i3;
        this.name = str;
        this.executor = ProxyExecutors.newScheduledThreadPool(i3, new ThreadFactory() { // from class: kotlinx.coroutines.d
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread m1996executor$lambda0;
                m1996executor$lambda0 = ThreadPoolDispatcher.m1996executor$lambda0(ThreadPoolDispatcher.this, runnable);
                return m1996executor$lambda0;
            }
        });
        initFutureCancellation$kotlinx_coroutines_core();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: executor$lambda-0, reason: not valid java name */
    public static final Thread m1996executor$lambda0(ThreadPoolDispatcher threadPoolDispatcher, Runnable runnable) {
        String str;
        if (threadPoolDispatcher.nThreads == 1) {
            str = threadPoolDispatcher.name;
        } else {
            str = threadPoolDispatcher.name + '-' + threadPoolDispatcher.threadNo.incrementAndGet();
        }
        return new PoolThread(threadPoolDispatcher, runnable, str);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcherBase, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((ExecutorService) getExecutor()).shutdown();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @NotNull
    public Executor getExecutor() {
        return this.executor;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcherBase, kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return "ThreadPoolDispatcher[" + this.nThreads + ", " + this.name + ']';
    }
}
