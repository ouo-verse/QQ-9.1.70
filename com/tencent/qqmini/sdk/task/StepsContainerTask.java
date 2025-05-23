package com.tencent.qqmini.sdk.task;

import android.content.Context;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0014J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\t\u001a\u00020\nX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqmini/sdk/task/StepsContainerTask;", "Lcom/tencent/qqmini/sdk/task/BaseTask;", "context", "Landroid/content/Context;", "runtimeLoader", "Lcom/tencent/qqmini/sdk/runtime/BaseRuntimeLoader;", "subSteps", "", "(Landroid/content/Context;Lcom/tencent/qqmini/sdk/runtime/BaseRuntimeLoader;Ljava/util/List;)V", "steps", "Lcom/tencent/qqmini/sdk/task/TaskSteps;", "getSteps", "()Lcom/tencent/qqmini/sdk/task/TaskSteps;", "execute", "", "getSubTaskExecutionStatics", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "getTotalRunDurationMs", "", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public class StepsContainerTask extends BaseTask {

    @NotNull
    private final TaskSteps steps;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepsContainerTask(@NotNull Context context, @Nullable BaseRuntimeLoader baseRuntimeLoader, @NotNull List<? extends BaseTask> subSteps) {
        super(context, baseRuntimeLoader);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(subSteps, "subSteps");
        this.steps = new TaskSteps(this, subSteps);
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    protected void execute() {
        this.steps.start();
    }

    @NotNull
    protected final TaskSteps getSteps() {
        return this.steps;
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    @NotNull
    protected List<TaskExecutionStatics> getSubTaskExecutionStatics() {
        return this.steps.getStepExecutionStatics();
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public long getTotalRunDurationMs() {
        return getRunDurationMs();
    }
}
