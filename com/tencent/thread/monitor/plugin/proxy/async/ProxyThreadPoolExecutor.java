package com.tencent.thread.monitor.plugin.proxy.async;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.thread.monitor.plugin.api.ProxyController;
import com.tencent.thread.monitor.plugin.manager.ProxyManager;
import com.tencent.thread.monitor.plugin.manager.ProxyTask;
import com.tencent.thread.monitor.plugin.manager.ThreadPoolInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadFactory;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\b\u0010 \u001a\u00020!H\u0016J0\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H%0$0#\"\u0004\b\u0000\u0010%2\u0014\u0010&\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H%0(0'H\u0016J@\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H%0$0#\"\u0004\b\u0000\u0010%2\u0014\u0010&\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H%0(0'2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J)\u0010)\u001a\u0002H%\"\u0004\b\u0000\u0010%2\u0014\u0010&\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H%0(0'H\u0016\u00a2\u0006\u0002\u0010*J9\u0010)\u001a\u0002H%\"\u0004\b\u0000\u0010%2\u0014\u0010&\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H%0(0'2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016\u00a2\u0006\u0002\u0010+J\b\u0010,\u001a\u00020\tH\u0016J\b\u0010-\u001a\u00020\tH\u0016J\b\u0010.\u001a\u00020\tH\u0016J\b\u0010/\u001a\u00020\u0014H\u0016J\b\u00100\u001a\u00020\tH\u0016J\b\u00101\u001a\u00020\u0007H\u0016J\u0012\u00102\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0014H\u0016J\u001a\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0014H\u0016J\u0012\u0010:\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010<\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010!H\u0016J\b\u0010>\u001a\u00020\u0007H\u0016J\u000e\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00120#H\u0016J\u0014\u0010@\u001a\u0006\u0012\u0002\b\u00030$2\u0006\u00103\u001a\u00020\u0012H\u0016J)\u0010@\u001a\b\u0012\u0004\u0012\u0002H%0$\"\u0004\b\u0000\u0010%2\u0006\u00103\u001a\u00020\u00122\u0006\u0010A\u001a\u0002H%H\u0016\u00a2\u0006\u0002\u0010BJ\"\u0010@\u001a\b\u0012\u0004\u0012\u0002H%0$\"\u0004\b\u0000\u0010%2\f\u00103\u001a\b\u0012\u0004\u0012\u0002H%0(H\u0016J\b\u0010C\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2 = {"Lcom/tencent/thread/monitor/plugin/proxy/async/ProxyThreadPoolExecutor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "real", "(Ljava/util/concurrent/ThreadPoolExecutor;)V", "poolName", "", "allowCoreThreadTimeOut", "", "value", "", "allowsCoreThreadTimeOut", "awaitTermination", "timeout", "", "unit", "Ljava/util/concurrent/TimeUnit;", "execute", "command", "Ljava/lang/Runnable;", "getActiveCount", "", "getCompletedTaskCount", "getCorePoolSize", "getKeepAliveTime", "getLargestPoolSize", "getMaximumPoolSize", "getPoolSize", "getQueue", "Ljava/util/concurrent/BlockingQueue;", "getRejectedExecutionHandler", "Ljava/util/concurrent/RejectedExecutionHandler;", "getTaskCount", "getThreadFactory", "Ljava/util/concurrent/ThreadFactory;", "invokeAll", "", "Ljava/util/concurrent/Future;", "T", Constants.Raft.TASKS, "", "Ljava/util/concurrent/Callable;", "invokeAny", "(Ljava/util/Collection;)Ljava/lang/Object;", "(Ljava/util/Collection;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "isShutdown", "isTerminated", "isTerminating", "prestartAllCoreThreads", "prestartCoreThread", "purge", "remove", "task", "setCorePoolSize", "corePoolSize", "setKeepAliveTime", "time", "setMaximumPoolSize", "maximumPoolSize", "setRejectedExecutionHandler", "handler", "setThreadFactory", "threadFactory", "shutdown", "shutdownNow", "submit", "result", "(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurrent/Future;", "toString", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public class ProxyThreadPoolExecutor extends ThreadPoolExecutor {
    static IPatchRedirector $redirector_;
    private String poolName;
    private final ThreadPoolExecutor real;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProxyThreadPoolExecutor(@NotNull ThreadPoolExecutor real) {
        super(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        Intrinsics.checkNotNullParameter(real, "real");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) real);
            return;
        }
        this.real = real;
        this.poolName = "";
        ThreadPoolInfo threadPoolInfo = new ThreadPoolInfo(real);
        ProxyManager.putPoolInfo(threadPoolInfo);
        this.poolName = threadPoolInfo.getPoolName();
        ThreadFactory threadFactory = real.getThreadFactory();
        Intrinsics.checkNotNullExpressionValue(threadFactory, "real.threadFactory");
        real.setThreadFactory(new BaseThreadFactory(threadFactory, this.poolName));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, value);
        } else {
            this.real.allowCoreThreadTimeOut(value);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public boolean allowsCoreThreadTimeOut() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        return this.real.allowsCoreThreadTimeOut();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public boolean awaitTermination(long timeout, @NotNull TimeUnit unit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, Long.valueOf(timeout), unit)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(unit, "unit");
        return this.real.awaitTermination(timeout, unit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(@NotNull Runnable command) {
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) command);
            return;
        }
        Intrinsics.checkNotNullParameter(command, "command");
        if (!ProxyController.INSTANCE.getEnabled()) {
            this.real.execute(command);
            return;
        }
        String stackString = ProxyManager.getStackString(true);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) stackString, (CharSequence) "AsyncTask$SerialExecutor.scheduleNext", false, 2, (Object) null);
        if (!contains$default) {
            command = new ProxyTask(command, this.poolName, stackString);
        }
        this.real.execute(command);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public int getActiveCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        return this.real.getActiveCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public long getCompletedTaskCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.real.getCompletedTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public int getCorePoolSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.real.getCorePoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public long getKeepAliveTime(@Nullable TimeUnit unit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Long) iPatchRedirector.redirect((short) 24, (Object) this, (Object) unit)).longValue();
        }
        return this.real.getKeepAliveTime(unit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public int getLargestPoolSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.real.getLargestPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public int getMaximumPoolSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return this.real.getMaximumPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public int getPoolSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.real.getPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    @NotNull
    public BlockingQueue<Runnable> getQueue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (BlockingQueue) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        BlockingQueue<Runnable> queue = this.real.getQueue();
        Intrinsics.checkNotNullExpressionValue(queue, "real.queue");
        return queue;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    @NotNull
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (RejectedExecutionHandler) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        RejectedExecutionHandler rejectedExecutionHandler = this.real.getRejectedExecutionHandler();
        Intrinsics.checkNotNullExpressionValue(rejectedExecutionHandler, "real.rejectedExecutionHandler");
        return rejectedExecutionHandler;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public long getTaskCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.real.getTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    @NotNull
    public ThreadFactory getThreadFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ThreadFactory) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        ThreadFactory threadFactory = this.real.getThreadFactory();
        Intrinsics.checkNotNullExpressionValue(threadFactory, "real.threadFactory");
        return threadFactory;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NotNull
    public <T> List<Future<T>> invokeAll(@NotNull Collection<? extends Callable<T>> tasks) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (List) iPatchRedirector.redirect((short) 33, (Object) this, (Object) tasks);
        }
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        List<Future<T>> invokeAll = this.real.invokeAll(tasks);
        Intrinsics.checkNotNullExpressionValue(invokeAll, "real.invokeAll(tasks)");
        return invokeAll;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NotNull Collection<? extends Callable<T>> tasks) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (T) iPatchRedirector.redirect((short) 6, (Object) this, (Object) tasks);
        }
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        return (T) this.real.invokeAny(tasks);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return this.real.isShutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.real.isTerminated();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public boolean isTerminating() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this)).booleanValue();
        }
        return this.real.isTerminating();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public int prestartAllCoreThreads() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.real.prestartAllCoreThreads();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public boolean prestartCoreThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.real.prestartCoreThread();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void purge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            this.real.purge();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public boolean remove(@Nullable Runnable task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) task)).booleanValue();
        }
        return this.real.remove(task);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setCorePoolSize(int corePoolSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, corePoolSize);
        } else {
            this.real.setCorePoolSize(corePoolSize);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setKeepAliveTime(long time, @Nullable TimeUnit unit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Long.valueOf(time), unit);
        } else {
            this.real.setKeepAliveTime(time, unit);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setMaximumPoolSize(int maximumPoolSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, maximumPoolSize);
        } else {
            this.real.setMaximumPoolSize(maximumPoolSize);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setRejectedExecutionHandler(@Nullable RejectedExecutionHandler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) handler);
        } else {
            this.real.setRejectedExecutionHandler(handler);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(@Nullable ThreadFactory threadFactory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) threadFactory);
        } else {
            this.real.setThreadFactory(threadFactory);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            this.real.shutdown();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    @NotNull
    public List<Runnable> shutdownNow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (List) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        List<Runnable> shutdownNow = this.real.shutdownNow();
        Intrinsics.checkNotNullExpressionValue(shutdownNow, "real.shutdownNow()");
        return shutdownNow;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NotNull
    public Future<?> submit(@NotNull Runnable task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Future) iPatchRedirector.redirect((short) 2, (Object) this, (Object) task);
        }
        Intrinsics.checkNotNullParameter(task, "task");
        Future<?> submit = this.real.submit(task);
        Intrinsics.checkNotNullExpressionValue(submit, "real.submit(task)");
        return submit;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        String threadPoolExecutor = this.real.toString();
        Intrinsics.checkNotNullExpressionValue(threadPoolExecutor, "real.toString()");
        return threadPoolExecutor;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NotNull
    public <T> List<Future<T>> invokeAll(@NotNull Collection<? extends Callable<T>> tasks, long timeout, @NotNull TimeUnit unit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (List) iPatchRedirector.redirect((short) 34, this, tasks, Long.valueOf(timeout), unit);
        }
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(unit, "unit");
        List<Future<T>> invokeAll = this.real.invokeAll(tasks, timeout, unit);
        Intrinsics.checkNotNullExpressionValue(invokeAll, "real.invokeAll(tasks, timeout, unit)");
        return invokeAll;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NotNull Collection<? extends Callable<T>> tasks, long timeout, @NotNull TimeUnit unit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (T) iPatchRedirector.redirect((short) 7, this, tasks, Long.valueOf(timeout), unit);
        }
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (T) this.real.invokeAny(tasks, timeout, unit);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NotNull
    public <T> Future<T> submit(@NotNull Runnable task, T result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Future) iPatchRedirector.redirect((short) 3, (Object) this, (Object) task, (Object) result);
        }
        Intrinsics.checkNotNullParameter(task, "task");
        Future<T> submit = this.real.submit(task, result);
        Intrinsics.checkNotNullExpressionValue(submit, "real.submit(task, result)");
        return submit;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NotNull
    public <T> Future<T> submit(@NotNull Callable<T> task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Future) iPatchRedirector.redirect((short) 4, (Object) this, (Object) task);
        }
        Intrinsics.checkNotNullParameter(task, "task");
        Future<T> submit = this.real.submit(task);
        Intrinsics.checkNotNullExpressionValue(submit, "real.submit(task)");
        return submit;
    }
}
