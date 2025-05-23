package com.tencent.qqmini.sdk.task;

import com.tencent.qqmini.sdk.task.BaseTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0006\u0010\u0017\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\u00038F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqmini/sdk/task/TaskSteps;", "", "containerTask", "Lcom/tencent/qqmini/sdk/task/BaseTask;", "subTasks", "", "(Lcom/tencent/qqmini/sdk/task/BaseTask;Ljava/util/List;)V", "currentStep", "getCurrentStep", "()Lcom/tencent/qqmini/sdk/task/BaseTask;", "currentStepIndex", "", "currentStepOrNull", "getCurrentStepOrNull", "isExecuting", "", "()Z", "executeNextStep", "", "getStepExecutionStatics", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "onStepDone", "task", "start", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class TaskSteps {
    private final BaseTask containerTask;
    private int currentStepIndex;
    private final List<BaseTask> subTasks;

    /* JADX WARN: Multi-variable type inference failed */
    public TaskSteps(@NotNull BaseTask containerTask, @NotNull List<? extends BaseTask> subTasks) {
        Intrinsics.checkParameterIsNotNull(containerTask, "containerTask");
        Intrinsics.checkParameterIsNotNull(subTasks, "subTasks");
        this.containerTask = containerTask;
        this.subTasks = subTasks;
        this.currentStepIndex = -1;
        BaseTask.Callback callback = new BaseTask.Callback() { // from class: com.tencent.qqmini.sdk.task.TaskSteps$callback$1
            @Override // com.tencent.qqmini.sdk.task.BaseTask.Callback
            public void onTaskBegin(@NotNull BaseTask task) {
                Intrinsics.checkParameterIsNotNull(task, "task");
            }

            @Override // com.tencent.qqmini.sdk.task.BaseTask.Callback
            public void onTaskEnd(@NotNull BaseTask task) {
                Intrinsics.checkParameterIsNotNull(task, "task");
                TaskSteps.this.onStepDone(task);
            }
        };
        Iterator it = subTasks.iterator();
        while (it.hasNext()) {
            ((BaseTask) it.next()).setCallback(callback);
        }
    }

    private final void executeNextStep() {
        int i3 = this.currentStepIndex + 1;
        this.currentStepIndex = i3;
        if (i3 >= this.subTasks.size()) {
            this.containerTask.onTaskSucceed();
        } else {
            getCurrentStep().run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onStepDone(BaseTask task) {
        if (task.isSucceed()) {
            executeNextStep();
        } else {
            this.currentStepIndex = -1;
            this.containerTask.onTaskFailed(task.retCode, task.f348348msg);
        }
    }

    @NotNull
    public final BaseTask getCurrentStep() {
        return this.subTasks.get(this.currentStepIndex);
    }

    @Nullable
    public final BaseTask getCurrentStepOrNull() {
        int size = this.subTasks.size();
        int i3 = this.currentStepIndex;
        if (i3 >= 0 && size > i3) {
            return this.subTasks.get(i3);
        }
        return null;
    }

    @NotNull
    public final List<TaskExecutionStatics> getStepExecutionStatics() {
        int collectionSizeOrDefault;
        List<BaseTask> list = this.subTasks;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((BaseTask) it.next()).getExecutionStatics());
        }
        return arrayList;
    }

    public final boolean isExecuting() {
        int size = this.subTasks.size();
        int i3 = this.currentStepIndex;
        if (i3 >= 0 && size > i3) {
            return true;
        }
        return false;
    }

    public final void start() {
        if (this.currentStepIndex == -1) {
            executeNextStep();
            return;
        }
        throw new IllegalStateException("already executing " + getCurrentStep() + '!');
    }
}
