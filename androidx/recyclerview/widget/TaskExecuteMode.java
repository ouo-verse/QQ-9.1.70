package androidx.recyclerview.widget;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Landroidx/recyclerview/widget/TaskExecuteMode;", "", "()V", "AT_ONCE", "", "POST", "SUB_THREAD", "argus-recyclerview-preload_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class TaskExecuteMode {
    public static final int AT_ONCE = 0;

    @NotNull
    public static final TaskExecuteMode INSTANCE = new TaskExecuteMode();
    public static final int POST = 1;
    public static final int SUB_THREAD = 2;

    TaskExecuteMode() {
    }
}
