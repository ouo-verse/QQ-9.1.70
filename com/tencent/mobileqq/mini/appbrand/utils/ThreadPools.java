package com.tencent.mobileqq.mini.appbrand.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/mini/appbrand/utils/ThreadPools;", "", "()V", "IO_POOL_MIN_COUNT", "", "computationThreadPool", "Ljava/util/concurrent/ExecutorService;", "getComputationThreadPool$annotations", "getComputationThreadPool", "()Ljava/util/concurrent/ExecutorService;", "diskIOThreadPool", "Ljava/util/concurrent/Executor;", "getDiskIOThreadPool$annotations", "getDiskIOThreadPool", "()Ljava/util/concurrent/Executor;", "mainThreadExecutor", "getMainThreadExecutor$annotations", "getMainThreadExecutor", "mainThreadHandler", "Landroid/os/Handler;", "getMainThreadHandler$annotations", "getMainThreadHandler", "()Landroid/os/Handler;", "networkIOThreadPool", "getNetworkIOThreadPool$annotations", "getNetworkIOThreadPool", "TF", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ThreadPools {
    private static final int IO_POOL_MIN_COUNT = 4;
    private static final ExecutorService computationThreadPool;
    private static final Executor diskIOThreadPool;
    private static final Executor networkIOThreadPool;
    public static final ThreadPools INSTANCE = new ThreadPools();
    private static final Executor mainThreadExecutor = new Executor() { // from class: com.tencent.mobileqq.mini.appbrand.utils.ThreadPools$mainThreadExecutor$1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            Intrinsics.checkNotNullParameter(command, "command");
            ThreadPools.getMainThreadHandler().post(command);
        }
    };
    private static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/mini/appbrand/utils/ThreadPools$TF;", "Ljava/util/concurrent/ThreadFactory;", "name", "", "priority", "", "(Ljava/lang/String;I)V", "id", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class TF implements ThreadFactory {
        private final AtomicInteger id;
        private final String name;
        private final int priority;

        public TF(String name, int i3) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.priority = i3;
            this.id = new AtomicInteger();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void newThread$lambda$0(TF this$0, Runnable runnable) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(runnable, "$runnable");
            Process.setThreadPriority(this$0.priority);
            runnable.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            return new BaseThread(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.p
                @Override // java.lang.Runnable
                public final void run() {
                    ThreadPools.TF.newThread$lambda$0(ThreadPools.TF.this, runnable);
                }
            }, this.name + "-" + this.id.getAndIncrement());
        }
    }

    static {
        int coerceAtLeast;
        int coerceAtLeast2;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(availableProcessors, 4);
        TimeUnit timeUnit = TimeUnit.MINUTES;
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(coerceAtLeast, coerceAtLeast, 1L, timeUnit, new LinkedBlockingQueue(), new TF("DiskIO", 11));
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
        diskIOThreadPool = baseThreadPoolExecutor;
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(availableProcessors * 2, 4);
        BaseThreadPoolExecutor baseThreadPoolExecutor2 = new BaseThreadPoolExecutor(coerceAtLeast2, coerceAtLeast2, 1L, timeUnit, new LinkedBlockingQueue(), new TF("NetworkIO", 11));
        baseThreadPoolExecutor2.allowCoreThreadTimeOut(true);
        networkIOThreadPool = baseThreadPoolExecutor2;
        BaseThreadPoolExecutor baseThreadPoolExecutor3 = new BaseThreadPoolExecutor(availableProcessors, availableProcessors, 1L, timeUnit, new LinkedBlockingQueue(), new TF("Computation", 9));
        baseThreadPoolExecutor3.allowCoreThreadTimeOut(true);
        computationThreadPool = baseThreadPoolExecutor3;
    }

    ThreadPools() {
    }

    public static final ExecutorService getComputationThreadPool() {
        return computationThreadPool;
    }

    public static final Executor getDiskIOThreadPool() {
        return diskIOThreadPool;
    }

    public static final Executor getMainThreadExecutor() {
        return mainThreadExecutor;
    }

    public static final Handler getMainThreadHandler() {
        return mainThreadHandler;
    }

    public static final Executor getNetworkIOThreadPool() {
        return networkIOThreadPool;
    }

    @JvmStatic
    public static /* synthetic */ void getComputationThreadPool$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDiskIOThreadPool$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getMainThreadExecutor$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getMainThreadHandler$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getNetworkIOThreadPool$annotations() {
    }
}
