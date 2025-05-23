package com.tencent.rdelivery.reshub.util;

import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.reshub.core.ResLoadRequestPriority;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\n\u0010\t\u001a\u00020\u0004*\u00020\b\u00a8\u0006\n"}, d2 = {"Lkotlin/Function0;", "", "", "name", "Lcom/tencent/raft/standard/task/IRTask$Priority;", "priority", "Lcom/tencent/raft/standard/task/IRTask$Task;", "a", "Lcom/tencent/rdelivery/reshub/core/ResLoadRequestPriority;", "b", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class RTaskUtilKt {
    @NotNull
    public static final IRTask.Task a(@NotNull final Function0<Unit> toTask, @NotNull final String name, @NotNull final IRTask.Priority priority) {
        Intrinsics.checkParameterIsNotNull(toTask, "$this$toTask");
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(priority, "priority");
        return new IRTask.Task(name, priority) { // from class: com.tencent.rdelivery.reshub.util.RTaskUtilKt$toTask$1
            @Override // java.lang.Runnable
            public void run() {
                Function0.this.invoke();
            }
        };
    }

    @NotNull
    public static final IRTask.Priority b(@NotNull ResLoadRequestPriority toTaskPriority) {
        Intrinsics.checkParameterIsNotNull(toTaskPriority, "$this$toTaskPriority");
        int i3 = h.f364602a[toTaskPriority.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        return IRTask.Priority.MIN_PRIORITY;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return IRTask.Priority.MIN_PRIORITY;
            }
            return IRTask.Priority.NORMAL_PRIORITY;
        }
        return IRTask.Priority.MAX_PRIORITY;
    }
}
