package com.tenpay.sdk.net.core.dispatcher;

import com.tenpay.sdk.net.core.dispatcher.Executor;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.core.task.NetTask;
import com.tenpay.sdk.net.core.task.base.Task;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0014\u0010\u0010\u001a\u00020\u00112\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u001c\u0010\u0012\u001a\u00020\u00112\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tenpay/sdk/net/core/dispatcher/TaskExecutor;", "Lcom/tenpay/sdk/net/core/dispatcher/Executor;", "Lcom/tenpay/sdk/net/core/task/NetTask;", "Lcom/tenpay/sdk/net/core/task/base/Task$onTaskFinishCallback;", "executorService", "Ljava/util/concurrent/ThreadPoolExecutor;", "aliasName", "", "callback", "Lcom/tenpay/sdk/net/core/dispatcher/Executor$IExecuteCallback;", "(Ljava/util/concurrent/ThreadPoolExecutor;Ljava/lang/String;Lcom/tenpay/sdk/net/core/dispatcher/Executor$IExecuteCallback;)V", "futureTask", "Ljava/util/concurrent/Future;", "task", "cancel", "", "execute", "", "onTaskFinish", "removeTask", "tag", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class TaskExecutor implements Executor<NetTask<?>>, Task.onTaskFinishCallback<NetTask<?>> {

    @NotNull
    private final String aliasName;

    @NotNull
    private final Executor.IExecuteCallback<NetTask<?>> callback;

    @NotNull
    private final ThreadPoolExecutor executorService;

    @Nullable
    private Future<?> futureTask;

    @Nullable
    private volatile NetTask<?> task;

    public TaskExecutor(@NotNull ThreadPoolExecutor executorService, @NotNull String aliasName, @NotNull Executor.IExecuteCallback<NetTask<?>> callback) {
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(aliasName, "aliasName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.executorService = executorService;
        this.aliasName = aliasName;
        this.callback = callback;
    }

    private final String tag() {
        return "Executor(" + this.aliasName + ")";
    }

    @Override // com.tenpay.sdk.net.core.dispatcher.Executor
    public boolean cancel() {
        String str;
        DLog dLog = DLog.INSTANCE;
        String tag = tag();
        NetTask<?> netTask = this.task;
        if (netTask != null) {
            str = netTask.id();
        } else {
            str = null;
        }
        ILogAgent.DefaultImpls.i$default(dLog, tag, "cancel [" + str + "]", null, 4, null);
        synchronized (this) {
            Future<?> future = this.futureTask;
            if (future != null) {
                future.cancel(true);
            }
        }
        NetTask<?> netTask2 = this.task;
        if (netTask2 != null) {
            netTask2.cancel();
        }
        return true;
    }

    @Override // com.tenpay.sdk.net.core.dispatcher.Executor
    public void execute(@NotNull NetTask<?> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, tag(), "execute--->[" + task.id() + "]", null, 4, null);
        this.task = task;
        task.addTaskExecutorObserver(this);
        synchronized (this) {
            this.futureTask = this.executorService.submit(task);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tenpay.sdk.net.core.task.base.Task.onTaskFinishCallback
    public void onTaskFinish(@NotNull NetTask<?> task, boolean removeTask) {
        Intrinsics.checkNotNullParameter(task, "task");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, tag(), "done<---[" + task.id() + ", status=" + task.getStatus().name() + "]", null, 4, null);
        this.task = null;
        this.callback.onExecuteFinish(task, removeTask);
    }
}
