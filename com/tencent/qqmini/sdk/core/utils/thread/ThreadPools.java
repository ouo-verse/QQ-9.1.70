package com.tencent.qqmini.sdk.core.utils.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.tencent.qqmini.sdk.core.utils.thread.ThreadPools;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R!\u0010\u0005\u001a\u00020\u00068FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\r\u001a\u00020\u00068FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\tR\u001c\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00178\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u001aR!\u0010\u001b\u001a\u00020\u00068FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\t\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqmini/sdk/core/utils/thread/ThreadPools;", "", "()V", "IO_POOL_MIN_COUNT", "", "computationThreadPool", "Ljava/util/concurrent/ExecutorService;", "computationThreadPool$annotations", "getComputationThreadPool", "()Ljava/util/concurrent/ExecutorService;", "computationThreadPool$delegate", "Lkotlin/Lazy;", "cores", "diskIOThreadPool", "diskIOThreadPool$annotations", "getDiskIOThreadPool", "diskIOThreadPool$delegate", "mainThreadExecutor", "Ljava/util/concurrent/Executor;", "mainThreadExecutor$annotations", "getMainThreadExecutor", "()Ljava/util/concurrent/Executor;", "mainThreadHandler", "Landroid/os/Handler;", "mainThreadHandler$annotations", "getMainThreadHandler", "()Landroid/os/Handler;", "networkIOThreadPool", "networkIOThreadPool$annotations", "getNetworkIOThreadPool", "networkIOThreadPool$delegate", "TF", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class ThreadPools {
    private static final int IO_POOL_MIN_COUNT = 4;
    public static final ThreadPools INSTANCE = new ThreadPools();

    @NotNull
    private static final Executor mainThreadExecutor = new Executor() { // from class: com.tencent.qqmini.sdk.core.utils.thread.ThreadPools$mainThreadExecutor$1
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            ThreadPools.getMainThreadHandler().post(runnable);
        }
    };

    @NotNull
    private static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private static final int cores = Runtime.getRuntime().availableProcessors();

    /* renamed from: diskIOThreadPool$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy diskIOThreadPool = LazyKt.lazy(new Function0<ThreadPoolExecutor>() { // from class: com.tencent.qqmini.sdk.core.utils.thread.ThreadPools$diskIOThreadPool$2
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ThreadPoolExecutor invoke() {
            int i3;
            int coerceAtLeast;
            ThreadPools threadPools = ThreadPools.INSTANCE;
            i3 = ThreadPools.cores;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3 * 2, 4);
            BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(coerceAtLeast, coerceAtLeast, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new ThreadPools.TF("Mini-IO", 11));
            baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
            return baseThreadPoolExecutor;
        }
    });

    /* renamed from: networkIOThreadPool$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy networkIOThreadPool = LazyKt.lazy(new Function0<ThreadPoolExecutor>() { // from class: com.tencent.qqmini.sdk.core.utils.thread.ThreadPools$networkIOThreadPool$2
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ThreadPoolExecutor invoke() {
            int i3;
            int coerceAtLeast;
            ThreadPools threadPools = ThreadPools.INSTANCE;
            i3 = ThreadPools.cores;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3 * 2, 4);
            BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(coerceAtLeast, coerceAtLeast, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new ThreadPools.TF("Mini-Net", 11));
            baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
            return baseThreadPoolExecutor;
        }
    });

    /* renamed from: computationThreadPool$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy computationThreadPool = LazyKt.lazy(new Function0<ThreadPoolExecutor>() { // from class: com.tencent.qqmini.sdk.core.utils.thread.ThreadPools$computationThreadPool$2
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ThreadPoolExecutor invoke() {
            int i3;
            int i16;
            ThreadPools threadPools = ThreadPools.INSTANCE;
            i3 = ThreadPools.cores;
            i16 = ThreadPools.cores;
            BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(i3, i16, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new ThreadPools.TF("Mini-Computation", 9));
            baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
            return baseThreadPoolExecutor;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqmini/sdk/core/utils/thread/ThreadPools$TF;", "Ljava/util/concurrent/ThreadFactory;", "name", "", "priority", "", "(Ljava/lang/String;I)V", "id", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class TF implements ThreadFactory {
        private final AtomicInteger id;
        private final String name;
        private final int priority;

        public TF(@NotNull String name, int i3) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            this.name = name;
            this.priority = i3;
            this.id = new AtomicInteger();
        }

        @Override // java.util.concurrent.ThreadFactory
        @NotNull
        public Thread newThread(@NotNull final Runnable runnable) {
            Intrinsics.checkParameterIsNotNull(runnable, "runnable");
            return new BaseThread(new Runnable() { // from class: com.tencent.qqmini.sdk.core.utils.thread.ThreadPools$TF$newThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    int i3;
                    i3 = ThreadPools.TF.this.priority;
                    Process.setThreadPriority(i3);
                    runnable.run();
                }
            }, this.name + '-' + this.id.getAndIncrement());
        }
    }

    ThreadPools() {
    }

    @NotNull
    public static final ExecutorService getComputationThreadPool() {
        return (ExecutorService) computationThreadPool.getValue();
    }

    @NotNull
    public static final ExecutorService getDiskIOThreadPool() {
        return (ExecutorService) diskIOThreadPool.getValue();
    }

    @NotNull
    public static final Executor getMainThreadExecutor() {
        return mainThreadExecutor;
    }

    @NotNull
    public static final Handler getMainThreadHandler() {
        return mainThreadHandler;
    }

    @NotNull
    public static final ExecutorService getNetworkIOThreadPool() {
        return (ExecutorService) networkIOThreadPool.getValue();
    }

    @JvmStatic
    public static /* synthetic */ void computationThreadPool$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void diskIOThreadPool$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void mainThreadExecutor$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void mainThreadHandler$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void networkIOThreadPool$annotations() {
    }
}
