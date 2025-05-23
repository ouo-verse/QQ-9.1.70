package com.tencent.thread.monitor.plugin.proxy;

import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.api.ProxyController;
import java.lang.reflect.Proxy;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\r\u001a\u00020\u0004H\u0007J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\u000e\u001a\u00020\u000bH\u0007J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\u000f\u001a\u00020\u0004H\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/thread/monitor/plugin/proxy/ProxyExecutors;", "", "()V", "newCachedThreadPool", "Ljava/util/concurrent/ExecutorService;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "newFixedThreadPool", "nThreads", "", "newScheduledThreadPool", "Ljava/util/concurrent/ScheduledExecutorService;", "corePoolSize", "newSingleThreadExecutor", "newSingleThreadScheduledExecutor", "newWorkStealingPool", "parallelism", "proxy", "executorService", "unconfigurableExecutorService", "executor", "unconfigurableScheduledExecutorService", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class ProxyExecutors {
    static IPatchRedirector $redirector_;
    public static final ProxyExecutors INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9443);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new ProxyExecutors();
        }
    }

    ProxyExecutors() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final ExecutorService newCachedThreadPool() {
        if (!ProxyController.INSTANCE.getEnabled()) {
            ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
            Intrinsics.checkNotNullExpressionValue(newCachedThreadPool, "Executors.newCachedThreadPool()");
            return newCachedThreadPool;
        }
        return new BaseThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue());
    }

    @JvmStatic
    @NotNull
    public static final ExecutorService newFixedThreadPool(int nThreads) {
        if (!ProxyController.INSTANCE.getEnabled()) {
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(nThreads);
            Intrinsics.checkNotNullExpressionValue(newFixedThreadPool, "Executors.newFixedThreadPool(nThreads)");
            return newFixedThreadPool;
        }
        return new BaseThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    @JvmStatic
    @NotNull
    public static final ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        if (!ProxyController.INSTANCE.getEnabled()) {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(corePoolSize);
            Intrinsics.checkNotNullExpressionValue(newScheduledThreadPool, "Executors.newScheduledThreadPool(corePoolSize)");
            return newScheduledThreadPool;
        }
        return new BaseScheduledThreadPoolExecutor(corePoolSize);
    }

    @JvmStatic
    @NotNull
    public static final ExecutorService newSingleThreadExecutor() {
        if (!ProxyController.INSTANCE.getEnabled()) {
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "Executors.newSingleThreadExecutor()");
            return newSingleThreadExecutor;
        }
        ProxyExecutors proxyExecutors = INSTANCE;
        ExecutorService newSingleThreadExecutor2 = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor2, "Executors.newSingleThreadExecutor()");
        return proxyExecutors.proxy(newSingleThreadExecutor2);
    }

    @JvmStatic
    @NotNull
    public static final ScheduledExecutorService newSingleThreadScheduledExecutor() {
        if (!ProxyController.INSTANCE.getEnabled()) {
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            Intrinsics.checkNotNullExpressionValue(newSingleThreadScheduledExecutor, "Executors.newSingleThreadScheduledExecutor()");
            return newSingleThreadScheduledExecutor;
        }
        ProxyExecutors proxyExecutors = INSTANCE;
        ScheduledExecutorService newSingleThreadScheduledExecutor2 = Executors.newSingleThreadScheduledExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadScheduledExecutor2, "Executors.newSingleThreadScheduledExecutor()");
        return proxyExecutors.proxy(newSingleThreadScheduledExecutor2);
    }

    @JvmStatic
    @RequiresApi(api = 24)
    @NotNull
    public static final ExecutorService newWorkStealingPool(int parallelism) {
        ExecutorService newWorkStealingPool;
        newWorkStealingPool = Executors.newWorkStealingPool(parallelism);
        Intrinsics.checkNotNullExpressionValue(newWorkStealingPool, "Executors.newWorkStealingPool(parallelism)");
        return newWorkStealingPool;
    }

    private final ExecutorService proxy(ExecutorService executorService) {
        Object newProxyInstance = Proxy.newProxyInstance(executorService.getClass().getClassLoader(), AbstractExecutorService.class.getInterfaces(), new ProxyExecutorService(executorService));
        if (newProxyInstance != null) {
            return (ExecutorService) newProxyInstance;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.ExecutorService");
    }

    @JvmStatic
    @NotNull
    public static final ExecutorService unconfigurableExecutorService(@NotNull ExecutorService executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        if (!ProxyController.INSTANCE.getEnabled()) {
            ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(executor);
            Intrinsics.checkNotNullExpressionValue(unconfigurableExecutorService, "Executors.unconfigurableExecutorService(executor)");
            return unconfigurableExecutorService;
        }
        ProxyExecutors proxyExecutors = INSTANCE;
        ExecutorService unconfigurableExecutorService2 = Executors.unconfigurableExecutorService(executor);
        Intrinsics.checkNotNullExpressionValue(unconfigurableExecutorService2, "Executors.unconfigurableExecutorService(executor)");
        return proxyExecutors.proxy(unconfigurableExecutorService2);
    }

    @JvmStatic
    @NotNull
    public static final ScheduledExecutorService unconfigurableScheduledExecutorService(@NotNull ScheduledExecutorService executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        if (!ProxyController.INSTANCE.getEnabled()) {
            ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(executor);
            Intrinsics.checkNotNullExpressionValue(unconfigurableScheduledExecutorService, "Executors.unconfigurable\u2026ExecutorService(executor)");
            return unconfigurableScheduledExecutorService;
        }
        ProxyExecutors proxyExecutors = INSTANCE;
        ScheduledExecutorService unconfigurableScheduledExecutorService2 = Executors.unconfigurableScheduledExecutorService(executor);
        Intrinsics.checkNotNullExpressionValue(unconfigurableScheduledExecutorService2, "Executors.unconfigurable\u2026ExecutorService(executor)");
        return proxyExecutors.proxy(unconfigurableScheduledExecutorService2);
    }

    @JvmStatic
    @RequiresApi(api = 24)
    @NotNull
    public static final ExecutorService newWorkStealingPool() {
        ExecutorService newWorkStealingPool;
        newWorkStealingPool = Executors.newWorkStealingPool();
        Intrinsics.checkNotNullExpressionValue(newWorkStealingPool, "Executors.newWorkStealingPool()");
        return newWorkStealingPool;
    }

    @JvmStatic
    @NotNull
    public static final ScheduledExecutorService newScheduledThreadPool(int corePoolSize, @NotNull ThreadFactory threadFactory) {
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
        if (!ProxyController.INSTANCE.getEnabled()) {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(corePoolSize, threadFactory);
            Intrinsics.checkNotNullExpressionValue(newScheduledThreadPool, "Executors.newScheduledTh\u2026ePoolSize, threadFactory)");
            return newScheduledThreadPool;
        }
        return new BaseScheduledThreadPoolExecutor(corePoolSize, threadFactory);
    }

    @JvmStatic
    @NotNull
    public static final ExecutorService newSingleThreadExecutor(@Nullable ThreadFactory threadFactory) {
        if (!ProxyController.INSTANCE.getEnabled()) {
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(threadFactory);
            Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "Executors.newSingleThreadExecutor(threadFactory)");
            return newSingleThreadExecutor;
        }
        ProxyExecutors proxyExecutors = INSTANCE;
        ExecutorService newSingleThreadExecutor2 = Executors.newSingleThreadExecutor(threadFactory);
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor2, "Executors.newSingleThreadExecutor(threadFactory)");
        return proxyExecutors.proxy(newSingleThreadExecutor2);
    }

    @JvmStatic
    @NotNull
    public static final ScheduledExecutorService newSingleThreadScheduledExecutor(@Nullable ThreadFactory threadFactory) {
        if (!ProxyController.INSTANCE.getEnabled()) {
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(threadFactory);
            Intrinsics.checkNotNullExpressionValue(newSingleThreadScheduledExecutor, "Executors.newSingleThrea\u2026edExecutor(threadFactory)");
            return newSingleThreadScheduledExecutor;
        }
        ProxyExecutors proxyExecutors = INSTANCE;
        ScheduledExecutorService newSingleThreadScheduledExecutor2 = Executors.newSingleThreadScheduledExecutor(threadFactory);
        Intrinsics.checkNotNullExpressionValue(newSingleThreadScheduledExecutor2, "Executors.newSingleThrea\u2026edExecutor(threadFactory)");
        return proxyExecutors.proxy(newSingleThreadScheduledExecutor2);
    }

    private final ScheduledExecutorService proxy(ScheduledExecutorService executorService) {
        Object newProxyInstance = Proxy.newProxyInstance(executorService.getClass().getClassLoader(), ScheduledThreadPoolExecutor.class.getInterfaces(), new ProxyExecutorService(executorService));
        if (newProxyInstance != null) {
            return (ScheduledExecutorService) newProxyInstance;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.ScheduledExecutorService");
    }

    @JvmStatic
    @NotNull
    public static final ExecutorService newCachedThreadPool(@NotNull ThreadFactory threadFactory) {
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
        if (!ProxyController.INSTANCE.getEnabled()) {
            ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(threadFactory);
            Intrinsics.checkNotNullExpressionValue(newCachedThreadPool, "Executors.newCachedThreadPool(threadFactory)");
            return newCachedThreadPool;
        }
        return new BaseThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
    }

    @JvmStatic
    @NotNull
    public static final ExecutorService newFixedThreadPool(int nThreads, @NotNull ThreadFactory threadFactory) {
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
        if (!ProxyController.INSTANCE.getEnabled()) {
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(nThreads, threadFactory);
            Intrinsics.checkNotNullExpressionValue(newFixedThreadPool, "Executors.newFixedThread\u2026(nThreads, threadFactory)");
            return newFixedThreadPool;
        }
        return new BaseThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory);
    }
}
