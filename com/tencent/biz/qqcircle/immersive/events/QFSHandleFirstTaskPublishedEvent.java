package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/events/QFSHandleFirstTaskPublishedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "taskInfo", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "(Lcom/tencent/mobileqq/winkpublish/TaskInfo;)V", "getTaskInfo", "()Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QFSHandleFirstTaskPublishedEvent extends SimpleBaseEvent {

    @NotNull
    private final TaskInfo taskInfo;

    public QFSHandleFirstTaskPublishedEvent(@NotNull TaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        this.taskInfo = taskInfo;
    }

    public static /* synthetic */ QFSHandleFirstTaskPublishedEvent copy$default(QFSHandleFirstTaskPublishedEvent qFSHandleFirstTaskPublishedEvent, TaskInfo taskInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            taskInfo = qFSHandleFirstTaskPublishedEvent.taskInfo;
        }
        return qFSHandleFirstTaskPublishedEvent.copy(taskInfo);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final TaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    @NotNull
    public final QFSHandleFirstTaskPublishedEvent copy(@NotNull TaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        return new QFSHandleFirstTaskPublishedEvent(taskInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof QFSHandleFirstTaskPublishedEvent) && Intrinsics.areEqual(this.taskInfo, ((QFSHandleFirstTaskPublishedEvent) other).taskInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final TaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    public int hashCode() {
        return this.taskInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "QFSHandleFirstTaskPublishedEvent(taskInfo=" + this.taskInfo + ")";
    }
}
