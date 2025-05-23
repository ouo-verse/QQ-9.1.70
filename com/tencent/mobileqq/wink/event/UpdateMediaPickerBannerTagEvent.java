package com.tencent.mobileqq.wink.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/event/UpdateMediaPickerBannerTagEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "topic", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "(Ljava/lang/String;Ljava/lang/String;)V", "getTaskId", "()Ljava/lang/String;", "getTopic", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class UpdateMediaPickerBannerTagEvent extends SimpleBaseEvent {

    @NotNull
    private final String taskId;

    @NotNull
    private final String topic;

    public UpdateMediaPickerBannerTagEvent(@NotNull String topic, @NotNull String taskId) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.topic = topic;
        this.taskId = taskId;
    }

    @NotNull
    public final String getTaskId() {
        return this.taskId;
    }

    @NotNull
    public final String getTopic() {
        return this.topic;
    }

    public /* synthetic */ UpdateMediaPickerBannerTagEvent(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? "" : str2);
    }
}
