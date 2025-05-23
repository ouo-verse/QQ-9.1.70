package com.tencent.rdelivery.reshub.core;

import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.reshub.util.ThreadUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u000b\u0010\u0005\u001a\u00070\u0006\u00a2\u0006\u0002\b\u00072\u000b\u0010\b\u001a\u00070\t\u00a2\u0006\u0002\b\u0007H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/rdelivery/reshub/core/DefaultTaskExecutorDelegateImpl;", "Lcom/tencent/raft/standard/task/IRTask;", "()V", "startTask", "", "taskType", "Lcom/tencent/raft/standard/task/IRTask$TaskType;", "Lorg/jetbrains/annotations/NotNull;", "task", "Lcom/tencent/raft/standard/task/IRTask$Task;", "reshub_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes25.dex */
public final class DefaultTaskExecutorDelegateImpl implements IRTask {
    @Override // com.tencent.raft.standard.task.IRTask
    public void startTask(@NotNull IRTask.TaskType taskType, @NotNull final IRTask.Task task) {
        Intrinsics.checkParameterIsNotNull(taskType, "taskType");
        Intrinsics.checkParameterIsNotNull(task, "task");
        ThreadUtil.f364593c.a().submit(new Runnable() { // from class: com.tencent.rdelivery.reshub.core.DefaultTaskExecutorDelegateImpl$startTask$1
            @Override // java.lang.Runnable
            public final void run() {
                Object m476constructorimpl;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    IRTask.Task.this.run();
                    m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    jz3.d.d("ResHub_DefaultTaskExecutor", "executeTask err", m479exceptionOrNullimpl);
                }
            }
        });
    }
}
