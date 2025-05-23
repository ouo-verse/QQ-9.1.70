package com.tencent.thread.monitor.plugin.manager;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.api.DumpThreadInfo;
import com.tencent.thread.monitor.plugin.api.HitState;
import com.tencent.thread.monitor.plugin.api.IThreadInfo;
import java.lang.Thread;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0000J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/thread/monitor/plugin/manager/ThreadInfo;", "Lcom/tencent/thread/monitor/plugin/api/IThreadInfo;", "()V", "copy", "update", "", MosaicConstants$JsProperty.PROP_THREAD, "Ljava/lang/Thread;", "updateFromPoolCreateThread", "poolName", "", "updateFromPoolRun", "poolTask", "Lcom/tencent/thread/monitor/plugin/manager/ProxyTask;", "taskInfo", "Lcom/tencent/thread/monitor/plugin/manager/TaskInfo;", "updateFromRefresh", "threadInfo", "Lcom/tencent/thread/monitor/plugin/api/DumpThreadInfo;", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class ThreadInfo extends IThreadInfo {
    static IPatchRedirector $redirector_;

    public ThreadInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @NotNull
    public final ThreadInfo copy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ThreadInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ThreadInfo threadInfo = new ThreadInfo();
        threadInfo.setId(getId());
        threadInfo.setName(getName());
        threadInfo.setState(getState());
        threadInfo.setStartTime(getStartTime());
        threadInfo.setRunningStack(getRunningStack());
        threadInfo.setHit(getHit());
        threadInfo.setCallStack(getCallStack());
        threadInfo.setCallThreadId(getCallThreadId());
        threadInfo.setPoolName(getPoolName());
        return threadInfo;
    }

    public final void update(@NotNull Thread thread) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) thread);
            return;
        }
        Intrinsics.checkNotNullParameter(thread, "thread");
        setId(thread.getId());
        String name = thread.getName();
        Intrinsics.checkNotNullExpressionValue(name, "thread.name");
        setName(name);
        Thread.State state = thread.getState();
        Intrinsics.checkNotNullExpressionValue(state, "thread.state");
        setState(state);
        setCallStack(ProxyManager.getStackString$default(false, 1, null));
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        setCallThreadId(currentThread.getId());
    }

    public final void updateFromPoolCreateThread(@NotNull Thread thread, @NotNull String poolName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) thread, (Object) poolName);
            return;
        }
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(poolName, "poolName");
        setId(thread.getId());
        String name = thread.getName();
        Intrinsics.checkNotNullExpressionValue(name, "thread.name");
        setName(name);
        Thread.State state = thread.getState();
        Intrinsics.checkNotNullExpressionValue(state, "thread.state");
        setState(state);
        setPoolName(poolName);
    }

    public final void updateFromPoolRun(@NotNull Thread thread, @NotNull ProxyTask poolTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) thread, (Object) poolTask);
            return;
        }
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(poolTask, "poolTask");
        setId(thread.getId());
        String name = thread.getName();
        Intrinsics.checkNotNullExpressionValue(name, "thread.name");
        setName(name);
        Thread.State state = thread.getState();
        Intrinsics.checkNotNullExpressionValue(state, "thread.state");
        setState(state);
        setCallStack(poolTask.getCallStack$plugincode_debug());
        setCallThreadId(poolTask.getCallThreadId$plugincode_debug());
        if (getPoolName() == null) {
            setPoolName(poolTask.getPoolName$plugincode_debug());
        }
    }

    public final void updateFromRefresh(@NotNull DumpThreadInfo threadInfo) {
        ThreadPoolInfo poolInfo;
        ArrayList<Long> threadIds;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) threadInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(threadInfo, "threadInfo");
        setId(threadInfo.getThread().getId());
        String name = threadInfo.getThread().getName();
        Intrinsics.checkNotNullExpressionValue(name, "threadInfo.thread.name");
        setName(name);
        Thread.State state = threadInfo.getThread().getState();
        Intrinsics.checkNotNullExpressionValue(state, "threadInfo.thread.state");
        setState(state);
        setHit(HitState.Yes);
        String poolName = getPoolName();
        if (poolName != null && (poolInfo = ProxyManager.getPoolInfo(poolName)) != null && (threadIds = poolInfo.getThreadIds()) != null) {
            threadIds.add(Long.valueOf(getId()));
        }
    }

    public final void updateFromPoolRun(@NotNull Thread thread, @NotNull String poolName, @NotNull TaskInfo taskInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, thread, poolName, taskInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(poolName, "poolName");
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        setId(thread.getId());
        String name = thread.getName();
        Intrinsics.checkNotNullExpressionValue(name, "thread.name");
        setName(name);
        Thread.State state = thread.getState();
        Intrinsics.checkNotNullExpressionValue(state, "thread.state");
        setState(state);
        setCallStack(taskInfo.getCallStack());
        setCallThreadId(taskInfo.getCallThreadId());
        if (getPoolName() == null) {
            setPoolName(poolName);
        }
    }
}
