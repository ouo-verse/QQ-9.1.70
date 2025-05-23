package com.qzone.reborn.repair.bean;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/reborn/repair/bean/QZonePhotoRepairSyncStatusEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "srStatus", "", "batchId", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;)V", "getBatchId", "()Ljava/lang/Long;", "setBatchId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSrStatus", "()Ljava/lang/Integer;", "setSrStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZonePhotoRepairSyncStatusEvent extends SimpleBaseEvent {
    private Long batchId;
    private Integer srStatus;
    private String taskId;

    public QZonePhotoRepairSyncStatusEvent() {
        this(null, null, null, 7, null);
    }

    public final Long getBatchId() {
        return this.batchId;
    }

    public final Integer getSrStatus() {
        return this.srStatus;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final void setBatchId(Long l3) {
        this.batchId = l3;
    }

    public final void setSrStatus(Integer num) {
        this.srStatus = num;
    }

    public final void setTaskId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.taskId = str;
    }

    public /* synthetic */ QZonePhotoRepairSyncStatusEvent(String str, Integer num, Long l3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : l3);
    }

    public QZonePhotoRepairSyncStatusEvent(String taskId, Integer num, Long l3) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.taskId = taskId;
        this.srStatus = num;
        this.batchId = l3;
    }
}
