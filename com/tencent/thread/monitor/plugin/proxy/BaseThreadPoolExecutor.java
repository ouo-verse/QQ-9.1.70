package com.tencent.thread.monitor.plugin.proxy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.thread.monitor.plugin.api.IReporter;
import com.tencent.thread.monitor.plugin.api.ProxyController;
import com.tencent.thread.monitor.plugin.manager.ProxyManager;
import com.tencent.thread.monitor.plugin.manager.ThreadPoolInfo;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B5\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010\fB=\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fB=\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012BE\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0013J\u001c\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u001c\u0010\u001b\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u0017H\u0002J0\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H$0#0\"\"\u0004\b\u0000\u0010$2\u0014\u0010%\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H$0'0&H\u0016J@\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H$0#0\"\"\u0004\b\u0000\u0010$2\u0014\u0010%\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H$0'0&2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J)\u0010)\u001a\u0002H$\"\u0004\b\u0000\u0010$2\u0014\u0010%\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H$0'0&H\u0016\u00a2\u0006\u0002\u0010*J9\u0010)\u001a\u0002H$\"\u0004\b\u0000\u0010$2\u0014\u0010%\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H$0'0&2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a2\u0006\u0002\u0010+J\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010/\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u00100\u001a\u00020\u0017H\u0016J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020\u000b0\"H\u0016J\u0014\u00102\u001a\u0006\u0012\u0002\b\u00030#2\u0006\u0010.\u001a\u00020\u000bH\u0016J)\u00102\u001a\b\u0012\u0004\u0012\u0002H$0#\"\u0004\b\u0000\u0010$2\u0006\u0010.\u001a\u00020\u000b2\u0006\u00103\u001a\u0002H$H\u0016\u00a2\u0006\u0002\u00104J\"\u00102\u001a\b\u0012\u0004\u0012\u0002H$0#\"\u0004\b\u0000\u0010$2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H$0'H\u0016R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/tencent/thread/monitor/plugin/proxy/BaseThreadPoolExecutor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "corePoolSize", "", "maximumPoolSize", "keepAliveTime", "", "unit", "Ljava/util/concurrent/TimeUnit;", "workQueue", "Ljava/util/concurrent/BlockingQueue;", "Ljava/lang/Runnable;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V", "handler", "Ljava/util/concurrent/RejectedExecutionHandler;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/RejectedExecutionHandler;)V", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;Ljava/util/concurrent/RejectedExecutionHandler;)V", "poolName", "", "afterExecute", "", "r", "t", "", "beforeExecute", "Ljava/lang/Thread;", "execute", "command", "getThreadFactory", "init", "invokeAll", "", "Ljava/util/concurrent/Future;", "T", Constants.Raft.TASKS, "", "Ljava/util/concurrent/Callable;", "timeout", "invokeAny", "(Ljava/util/Collection;)Ljava/lang/Object;", "(Ljava/util/Collection;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "remove", "", "task", "setThreadFactory", "shutdown", "shutdownNow", "submit", "result", "(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurrent/Future;", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public class BaseThreadPoolExecutor extends ThreadPoolExecutor {
    static IPatchRedirector $redirector_;
    private String poolName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseThreadPoolExecutor(int i3, int i16, long j3, @NotNull TimeUnit unit, @NotNull BlockingQueue<Runnable> workQueue) {
        super(i3, i16, j3, unit, workQueue);
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(workQueue, "workQueue");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), unit, workQueue);
        } else {
            this.poolName = "";
            init();
        }
    }

    private final void init() {
        if (!ProxyController.INSTANCE.getEnabled()) {
            return;
        }
        ThreadPoolInfo threadPoolInfo = new ThreadPoolInfo(this);
        ProxyManager.putPoolInfo(threadPoolInfo);
        this.poolName = threadPoolInfo.getPoolName();
        setThreadFactory(new BaseThreadFactory(getThreadFactory(), this.poolName));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(@Nullable Runnable r16, @Nullable Throwable t16) {
        ThreadPoolInfo poolInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) r16, (Object) t16);
            return;
        }
        super.afterExecute(r16, t16);
        if (r16 != null && ProxyController.INSTANCE.getEnabled() && (poolInfo = ProxyManager.getPoolInfo(this.poolName)) != null) {
            poolInfo.updateAfterExecute();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(@Nullable Thread t16, @Nullable Runnable r16) {
        ThreadPoolInfo poolInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) t16, (Object) r16);
            return;
        }
        super.beforeExecute(t16, r16);
        if (t16 != null && r16 != null && ProxyController.INSTANCE.getEnabled() && (poolInfo = ProxyManager.getPoolInfo(this.poolName)) != null) {
            poolInfo.updateBeforeExecute(t16, r16);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(@NotNull Runnable command) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) command);
            return;
        }
        Intrinsics.checkNotNullParameter(command, "command");
        ThreadPoolInfo poolInfo = ProxyManager.getPoolInfo(this.poolName);
        if (poolInfo != null) {
            ThreadPoolInfo.putTask$default(poolInfo, command, false, 2, null);
        }
        try {
            super.execute(command);
        } catch (OutOfMemoryError e16) {
            if (ProxyController.INSTANCE.getEnableOptimized()) {
                ProxyController proxyController = ProxyController.INSTANCE;
                proxyController.trimThreads(true);
                super.execute(command);
                IReporter iReporter = proxyController.getIReporter();
                if (iReporter != null) {
                    iReporter.reportFixOOM();
                    return;
                }
                return;
            }
            throw e16;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    @NotNull
    public ThreadFactory getThreadFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ThreadFactory) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ThreadFactory superThreadFactory = super.getThreadFactory();
        if (superThreadFactory instanceof BaseThreadFactory) {
            return ((BaseThreadFactory) superThreadFactory).getReal();
        }
        Intrinsics.checkNotNullExpressionValue(superThreadFactory, "superThreadFactory");
        return superThreadFactory;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NotNull
    public <T> List<Future<T>> invokeAll(@NotNull Collection<? extends Callable<T>> tasks) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this, (Object) tasks);
        }
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        ProxyManager.INSTANCE.putPoolTaskList(tasks, this.poolName);
        List<Future<T>> invokeAll = super.invokeAll(tasks);
        Intrinsics.checkNotNullExpressionValue(invokeAll, "super.invokeAll(tasks)");
        return invokeAll;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NotNull Collection<? extends Callable<T>> tasks) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (T) iPatchRedirector.redirect((short) 8, (Object) this, (Object) tasks);
        }
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        ProxyManager.INSTANCE.putPoolTaskList(tasks, this.poolName);
        return (T) super.invokeAny(tasks);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public boolean remove(@Nullable Runnable task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) task)).booleanValue();
        }
        ThreadPoolInfo poolInfo = ProxyManager.getPoolInfo(this.poolName);
        if (poolInfo != null) {
            poolInfo.removeTask(task);
        }
        return super.remove(task);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(@NotNull ThreadFactory threadFactory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) threadFactory);
            return;
        }
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
        if (!ProxyController.INSTANCE.getEnabled()) {
            super.setThreadFactory(threadFactory);
        } else {
            super.setThreadFactory(new BaseThreadFactory(threadFactory, this.poolName));
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        ThreadPoolInfo poolInfo = ProxyManager.getPoolInfo(this.poolName);
        if (poolInfo != null) {
            poolInfo.shutDown(false);
        }
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    @NotNull
    public List<Runnable> shutdownNow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        ThreadPoolInfo poolInfo = ProxyManager.getPoolInfo(this.poolName);
        if (poolInfo != null) {
            poolInfo.shutDown(true);
        }
        List<Runnable> shutdownNow = super.shutdownNow();
        Intrinsics.checkNotNullExpressionValue(shutdownNow, "super.shutdownNow()");
        return shutdownNow;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NotNull
    public Future<?> submit(@NotNull Runnable task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Future) iPatchRedirector.redirect((short) 5, (Object) this, (Object) task);
        }
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadPoolInfo poolInfo = ProxyManager.getPoolInfo(this.poolName);
        if (poolInfo != null) {
            ThreadPoolInfo.putTask$default(poolInfo, task, false, 2, null);
        }
        Future<?> submit = super.submit(task);
        Intrinsics.checkNotNullExpressionValue(submit, "super.submit(task)");
        return submit;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NotNull
    public <T> List<Future<T>> invokeAll(@NotNull Collection<? extends Callable<T>> tasks, long timeout, @NotNull TimeUnit unit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, this, tasks, Long.valueOf(timeout), unit);
        }
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(unit, "unit");
        ProxyManager.INSTANCE.putPoolTaskList(tasks, this.poolName);
        List<Future<T>> invokeAll = super.invokeAll(tasks, timeout, unit);
        Intrinsics.checkNotNullExpressionValue(invokeAll, "super.invokeAll(tasks, timeout, unit)");
        return invokeAll;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NotNull Collection<? extends Callable<T>> tasks, long timeout, @NotNull TimeUnit unit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (T) iPatchRedirector.redirect((short) 9, this, tasks, Long.valueOf(timeout), unit);
        }
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(unit, "unit");
        ProxyManager.INSTANCE.putPoolTaskList(tasks, this.poolName);
        return (T) super.invokeAny(tasks, timeout, unit);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NotNull
    public <T> Future<T> submit(@NotNull Callable<T> task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Future) iPatchRedirector.redirect((short) 6, (Object) this, (Object) task);
        }
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadPoolInfo poolInfo = ProxyManager.getPoolInfo(this.poolName);
        if (poolInfo != null) {
            ThreadPoolInfo.putTask$default(poolInfo, task, false, 2, null);
        }
        Future<T> submit = super.submit(task);
        Intrinsics.checkNotNullExpressionValue(submit, "super.submit(task)");
        return submit;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseThreadPoolExecutor(int i3, int i16, long j3, @NotNull TimeUnit unit, @NotNull BlockingQueue<Runnable> workQueue, @NotNull ThreadFactory threadFactory) {
        super(i3, i16, j3, unit, workQueue, threadFactory);
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(workQueue, "workQueue");
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), unit, workQueue, threadFactory);
        } else {
            this.poolName = "";
            init();
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NotNull
    public <T> Future<T> submit(@NotNull Runnable task, T result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Future) iPatchRedirector.redirect((short) 7, (Object) this, (Object) task, (Object) result);
        }
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadPoolInfo poolInfo = ProxyManager.getPoolInfo(this.poolName);
        if (poolInfo != null) {
            ThreadPoolInfo.putTask$default(poolInfo, task, false, 2, null);
        }
        Future<T> submit = super.submit(task, result);
        Intrinsics.checkNotNullExpressionValue(submit, "super.submit(task, result)");
        return submit;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseThreadPoolExecutor(int i3, int i16, long j3, @NotNull TimeUnit unit, @NotNull BlockingQueue<Runnable> workQueue, @NotNull RejectedExecutionHandler handler) {
        super(i3, i16, j3, unit, workQueue, handler);
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(workQueue, "workQueue");
        Intrinsics.checkNotNullParameter(handler, "handler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), unit, workQueue, handler);
        } else {
            this.poolName = "";
            init();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseThreadPoolExecutor(int i3, int i16, long j3, @NotNull TimeUnit unit, @NotNull BlockingQueue<Runnable> workQueue, @NotNull ThreadFactory threadFactory, @NotNull RejectedExecutionHandler handler) {
        super(i3, i16, j3, unit, workQueue, threadFactory, handler);
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(workQueue, "workQueue");
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
        Intrinsics.checkNotNullParameter(handler, "handler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), unit, workQueue, threadFactory, handler);
        } else {
            this.poolName = "";
            init();
        }
    }
}
