package com.tenpay.sdk.net.core.dispatcher;

import com.tenpay.sdk.net.core.task.base.Task;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\nJ\b\u0010\u0004\u001a\u00020\u0005H&J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tenpay/sdk/net/core/dispatcher/Executor;", "T", "Lcom/tenpay/sdk/net/core/task/base/Task;", "", "cancel", "", "execute", "", "task", "(Lcom/tenpay/sdk/net/core/task/base/Task;)V", "IExecuteCallback", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public interface Executor<T extends Task> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00020\bH&\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tenpay/sdk/net/core/dispatcher/Executor$IExecuteCallback;", "T", "Lcom/tenpay/sdk/net/core/task/base/Task;", "", "onExecuteFinish", "", "task", "removeTask", "", "(Lcom/tenpay/sdk/net/core/task/base/Task;Z)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public interface IExecuteCallback<T extends Task> {
        void onExecuteFinish(@NotNull T task, boolean removeTask);
    }

    boolean cancel();

    void execute(@NotNull T task);
}
