package com.tenpay.sdk.net.core.task.base;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tenpay/sdk/net/core/task/base/Task;", "Ljava/lang/Runnable;", "cancel", "", "id", "", "isCanceled", "", "onTaskFinishCallback", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public interface Task extends Runnable {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\bH&\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tenpay/sdk/net/core/task/base/Task$onTaskFinishCallback;", "T", "Lcom/tenpay/sdk/net/core/task/base/Task;", "", "onTaskFinish", "", "task", "removeTask", "", "(Lcom/tenpay/sdk/net/core/task/base/Task;Z)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public interface onTaskFinishCallback<T extends Task> {
        void onTaskFinish(@NotNull T task, boolean removeTask);
    }

    void cancel();

    @NotNull
    String id();

    boolean isCanceled();
}
