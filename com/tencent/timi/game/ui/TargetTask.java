package com.tencent.timi.game.ui;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/timi/game/ui/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Runnable;", "a", "Ljava/lang/Runnable;", "()Ljava/lang/Runnable;", "task", "b", "Ljava/lang/String;", "()Ljava/lang/String;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "<init>", "(Ljava/lang/Runnable;Ljava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.timi.game.ui.d, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class TargetTask {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Runnable task;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String taskId;

    public TargetTask(@NotNull Runnable task, @NotNull String taskId) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.task = task;
        this.taskId = taskId;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Runnable getTask() {
        return this.task;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TargetTask)) {
            return false;
        }
        TargetTask targetTask = (TargetTask) other;
        if (Intrinsics.areEqual(this.task, targetTask.task) && Intrinsics.areEqual(this.taskId, targetTask.taskId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.task.hashCode() * 31) + this.taskId.hashCode();
    }

    @NotNull
    public String toString() {
        return "TargetTask(task=" + this.task + ", taskId=" + this.taskId + ")";
    }

    public /* synthetic */ TargetTask(Runnable runnable, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(runnable, (i3 & 2) != 0 ? c.b() : str);
    }
}
