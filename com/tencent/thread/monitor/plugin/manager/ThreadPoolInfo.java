package com.tencent.thread.monitor.plugin.manager;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.api.IExecutor;
import com.tencent.thread.monitor.plugin.api.ILog;
import com.tencent.thread.monitor.plugin.api.IThreadPoolInfo;
import com.tencent.thread.monitor.plugin.api.ProxyController;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u0000J\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0016J\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0016J\u0006\u0010\u001f\u001a\u00020\u0012J\u0016\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u0019R\u001e\u0010\u0005\u001a\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006$"}, d2 = {"Lcom/tencent/thread/monitor/plugin/manager/ThreadPoolInfo;", "Lcom/tencent/thread/monitor/plugin/api/IThreadPoolInfo;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "executorRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "lastTaskCompleteTime", "", "getLastTaskCompleteTime", "()J", "setLastTaskCompleteTime", "(J)V", "copy", "getIdleCoreThreadSize", "", "putTask", "", "task", "", "isSchedule", "", "removeTask", "runnable", "Ljava/lang/Runnable;", "shrinkTaskList", "shutDown", "immediate", "trimThread", "fromOOM", "updateAfterExecute", "updateBeforeExecute", MosaicConstants$JsProperty.PROP_THREAD, "Ljava/lang/Thread;", "Companion", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class ThreadPoolInfo extends IThreadPoolInfo {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final long DEFAULT_KEEP_ALIVE = 30000;
    private static final String TAG = "ThreadProxy_plugin";
    private final WeakReference<Executor> executorRef;
    private long lastTaskCompleteTime;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/thread/monitor/plugin/manager/ThreadPoolInfo$Companion;", "", "()V", "DEFAULT_KEEP_ALIVE", "", "TAG", "", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8428);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ThreadPoolInfo(@Nullable Executor executor) {
        super(executor);
        WeakReference<Executor> weakReference;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) executor);
            return;
        }
        if (executor != null) {
            weakReference = new WeakReference<>(executor);
        } else {
            weakReference = null;
        }
        this.executorRef = weakReference;
    }

    public static /* synthetic */ void putTask$default(ThreadPoolInfo threadPoolInfo, Object obj, boolean z16, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        threadPoolInfo.putTask(obj, z16);
    }

    private final void shrinkTaskList() {
        Iterator<Map.Entry<Integer, TaskInfo>> it = getTaskHashCodeToInfo().entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().getWeakTask().get() == null) {
                it.remove();
            }
        }
    }

    @NotNull
    public final ThreadPoolInfo copy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ThreadPoolInfo) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        ThreadPoolInfo threadPoolInfo = new ThreadPoolInfo(null);
        threadPoolInfo.setPoolName(getPoolName());
        threadPoolInfo.setShutDown(getShutDown());
        threadPoolInfo.setThreadIds(new ArrayList<>(getThreadIds()));
        threadPoolInfo.setCreateStack(getCreateStack());
        threadPoolInfo.setCreateThreadId(getCreateThreadId());
        return threadPoolInfo;
    }

    public final int getIdleCoreThreadSize() {
        Executor executor;
        int coerceAtMost;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        WeakReference<Executor> weakReference = this.executorRef;
        int i3 = 0;
        if (weakReference != null && (executor = weakReference.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(executor, "executorRef?.get() ?: return 0");
            if (executor instanceof ThreadPoolExecutor) {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
                if (threadPoolExecutor.getCorePoolSize() > 0) {
                    int activeCount = threadPoolExecutor.getActiveCount();
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(threadPoolExecutor.getCorePoolSize(), threadPoolExecutor.getPoolSize());
                    i3 = RangesKt___RangesKt.coerceAtLeast(coerceAtMost - activeCount, 0);
                    ProxyController proxyController = ProxyController.INSTANCE;
                    if (proxyController.getDebugMode()) {
                        proxyController.getLogger().d("ThreadProxy_plugin", "getIdleCoreThreadSize, " + executor.hashCode() + ", " + i3 + ", " + activeCount);
                    }
                }
            }
        }
        return i3;
    }

    public final long getLastTaskCompleteTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Long) iPatchRedirector.redirect((short) 1, (Object) this)).longValue();
        }
        return this.lastTaskCompleteTime;
    }

    public final void putTask(@NotNull Object task, boolean isSchedule) {
        String stackTraceToString;
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, task, Boolean.valueOf(isSchedule));
            return;
        }
        Intrinsics.checkNotNullParameter(task, "task");
        ProxyController proxyController = ProxyController.INSTANCE;
        if (!proxyController.getEnabled()) {
            return;
        }
        if (task instanceof FutureTask) {
            String name = ((FutureTask) task).getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "task.javaClass.name");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name, "android.os.AsyncTask$", false, 2, null);
            if (startsWith$default && (task = FutureTaskParser.INSTANCE.getOriginalFromSubmitWrapper(task)) != null) {
                Intrinsics.checkNotNullExpressionValue(task.getClass().getSuperclass(), "runnable.javaClass.superclass");
                if (!Intrinsics.areEqual(r1.getName(), "android.os.AsyncTask$WorkerRunnable")) {
                    return;
                }
                if (proxyController.getDebugMode()) {
                    proxyController.getLogger().d("ThreadProxy_plugin", "putTask, task is WorkerRunnable");
                }
            } else {
                return;
            }
        }
        if (!(task instanceof Runnable) && !(task instanceof Callable)) {
            return;
        }
        if (getTaskHashCodeToInfo().putIfAbsent(Integer.valueOf(task.hashCode()), new TaskInfo(task, isSchedule)) != null && proxyController.getDebugMode()) {
            ILog logger = proxyController.getLogger();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("putTask twice, ");
            sb5.append(task);
            sb5.append(", ");
            sb5.append(getTaskHashCodeToInfo().size());
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(new Exception());
            sb5.append(stackTraceToString);
            logger.d("ThreadProxy_plugin", sb5.toString());
        }
        if (proxyController.getDebugMode()) {
            proxyController.getLogger().d("ThreadProxy_plugin", "putTask, " + task + ", " + getTaskHashCodeToInfo().size());
        }
    }

    public final void removeTask(@Nullable Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
        } else if (ProxyController.INSTANCE.getEnabled() && runnable != null) {
            getTaskHashCodeToInfo().remove(Integer.valueOf(runnable.hashCode()));
        }
    }

    public final void setLastTaskCompleteTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.lastTaskCompleteTime = j3;
        }
    }

    public final void shutDown(boolean immediate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, immediate);
        } else {
            if (!ProxyController.INSTANCE.getEnabled()) {
                return;
            }
            setShutDown(true);
            if (immediate) {
                getTaskHashCodeToInfo().clear();
            }
        }
    }

    public final void trimThread(boolean fromOOM) {
        Executor executor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, fromOOM);
            return;
        }
        WeakReference<Executor> weakReference = this.executorRef;
        if (weakReference != null && (executor = weakReference.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(executor, "executorRef?.get() ?: return");
            boolean z16 = executor instanceof ThreadPoolExecutor;
            if ((!z16 || !((ThreadPoolExecutor) executor).isShutdown()) && z16) {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
                if (threadPoolExecutor.getCorePoolSize() > 0 && !threadPoolExecutor.isShutdown()) {
                    boolean allowsCoreThreadTimeOut = threadPoolExecutor.allowsCoreThreadTimeOut();
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    long keepAliveTime = threadPoolExecutor.getKeepAliveTime(timeUnit);
                    if (fromOOM && allowsCoreThreadTimeOut) {
                        threadPoolExecutor.allowCoreThreadTimeOut(false);
                    }
                    if (!threadPoolExecutor.allowsCoreThreadTimeOut()) {
                        ProxyController proxyController = ProxyController.INSTANCE;
                        if (proxyController.getDebugMode()) {
                            proxyController.getLogger().d("ThreadProxy_plugin", "trimThread, executor: " + executor.hashCode() + ", fromOOM:" + fromOOM + ", " + allowsCoreThreadTimeOut + ", " + keepAliveTime);
                        }
                        if (fromOOM) {
                            threadPoolExecutor.setKeepAliveTime(1L, TimeUnit.NANOSECONDS);
                        } else if (keepAliveTime <= 0) {
                            threadPoolExecutor.setKeepAliveTime(30000L, timeUnit);
                        }
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        if (fromOOM && (true ^ Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))) {
                            try {
                                LockMethodProxy.sleep(proxyController.getTimeThreadWaitTime());
                            } catch (InterruptedException unused) {
                            }
                        }
                        IExecutor iExecutor = ProxyController.INSTANCE.getIExecutor();
                        if (iExecutor != null) {
                            Runnable runnable = new Runnable(executor, allowsCoreThreadTimeOut, keepAliveTime, fromOOM) { // from class: com.tencent.thread.monitor.plugin.manager.ThreadPoolInfo$trimThread$1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ Executor $executor;
                                final /* synthetic */ boolean $fromOOM;
                                final /* synthetic */ boolean $originAllowCoreThreadTimeout;
                                final /* synthetic */ long $originKeepAliveTime;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    this.$executor = executor;
                                    this.$originAllowCoreThreadTimeout = allowsCoreThreadTimeOut;
                                    this.$originKeepAliveTime = keepAliveTime;
                                    this.$fromOOM = fromOOM;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, this, executor, Boolean.valueOf(allowsCoreThreadTimeOut), Long.valueOf(keepAliveTime), Boolean.valueOf(fromOOM));
                                    }
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this);
                                        return;
                                    }
                                    ((ThreadPoolExecutor) this.$executor).allowCoreThreadTimeOut(this.$originAllowCoreThreadTimeout);
                                    if (this.$originAllowCoreThreadTimeout && this.$originKeepAliveTime == 0) {
                                        ProxyController.INSTANCE.getLogger().e(ProxyManager.TAG, "trimThread, origin params error, use default keepAliveTime");
                                        ((ThreadPoolExecutor) this.$executor).setKeepAliveTime(30000L, TimeUnit.MILLISECONDS);
                                    } else {
                                        ((ThreadPoolExecutor) this.$executor).setKeepAliveTime(this.$originKeepAliveTime, TimeUnit.MILLISECONDS);
                                    }
                                    ProxyController proxyController2 = ProxyController.INSTANCE;
                                    if (proxyController2.getDebugMode()) {
                                        proxyController2.getLogger().i(ProxyManager.TAG, "trimThread complete, executor: " + this.$executor.hashCode() + ", fromOOM:" + this.$fromOOM + ", " + this.$originAllowCoreThreadTimeout + ", " + this.$originKeepAliveTime);
                                    }
                                }
                            };
                            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
                            iExecutor.schedule(runnable, threadPoolExecutor.getKeepAliveTime(timeUnit2) + 100, timeUnit2);
                        }
                    }
                }
            }
        }
    }

    public final void updateAfterExecute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.lastTaskCompleteTime = SystemClock.elapsedRealtime();
        shrinkTaskList();
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        ThreadInfo threadInfo = ProxyManager.getThreadInfo(currentThread.getId());
        if (threadInfo != null) {
            threadInfo.setCallStack("");
            threadInfo.setCallThreadId(-1L);
            ProxyController proxyController = ProxyController.INSTANCE;
            if (proxyController.getDebugMode()) {
                proxyController.getLogger().d("ThreadProxy_plugin", "updateAfterExecute, " + getTaskHashCodeToInfo().size());
            }
        }
    }

    public final void updateBeforeExecute(@NotNull Thread r85, @NotNull Runnable runnable) {
        TaskInfo taskInfo;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) r85, (Object) runnable);
            return;
        }
        Intrinsics.checkNotNullParameter(r85, "thread");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        long currentTimeMillis = System.currentTimeMillis();
        Object original = FutureTaskParser.INSTANCE.getOriginal(runnable);
        if (original != null && (taskInfo = getTaskHashCodeToInfo().get(Integer.valueOf(original.hashCode()))) != null) {
            Intrinsics.checkNotNullExpressionValue(taskInfo, "taskHashCodeToInfo[result.hashCode()]  ?: return");
            if (!taskInfo.isSchedule() && getTaskHashCodeToInfo().remove(Integer.valueOf(original.hashCode())) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                ProxyController proxyController = ProxyController.INSTANCE;
                if (proxyController.getDebugMode()) {
                    proxyController.getLogger().d("ThreadProxy_plugin", "updateBeforeExecute, remove task fail, isSchedule: " + taskInfo.isSchedule() + ", " + original);
                }
            }
            if (taskInfo.getWeakTask().get() != null) {
                ThreadInfo threadInfo = ProxyManager.getThreadInfo(r85.getId());
                if (threadInfo != null) {
                    threadInfo.updateFromPoolRun(r85, getPoolName(), taskInfo);
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                ProxyController proxyController2 = ProxyController.INSTANCE;
                if (proxyController2.getDebugMode()) {
                    proxyController2.getLogger().d("ThreadProxy_plugin", "updateBeforeExecute, " + original + ", cost:" + currentTimeMillis2);
                }
            }
        }
    }
}
