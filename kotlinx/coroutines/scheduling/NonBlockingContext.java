package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lkotlinx/coroutines/scheduling/NonBlockingContext;", "Lkotlinx/coroutines/scheduling/TaskContext;", "()V", "taskMode", "", "getTaskMode", "()I", "afterTask", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class NonBlockingContext implements TaskContext {

    @NotNull
    public static final NonBlockingContext INSTANCE = new NonBlockingContext();
    private static final int taskMode = 0;

    NonBlockingContext() {
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int getTaskMode() {
        return taskMode;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void afterTask() {
    }
}
