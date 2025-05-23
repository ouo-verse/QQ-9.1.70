package com.qzone.reborn.repair.bean;

import com.qzone.reborn.bean.QZoneInitBean;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010%\u001a\u00020\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\u0004R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\u0004\u00a8\u0006&"}, d2 = {"Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;", "Lcom/qzone/reborn/bean/QZoneInitBean;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "(Ljava/lang/String;)V", "albumId", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "isNeedDoSRReq", "", "()Ljava/lang/Boolean;", "setNeedDoSRReq", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isSilentRepair", "()Z", "setSilentRepair", "(Z)V", "lloc", "getLloc", "setLloc", "srOriginUrl", "getSrOriginUrl", "setSrOriginUrl", "srStatus", "", "getSrStatus", "()Ljava/lang/Integer;", "setSrStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "srUrl", "getSrUrl", "setSrUrl", "getTaskId", "setTaskId", "toString", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneRepairTaskStateBean extends QZoneInitBean {
    private String albumId;
    private Boolean isNeedDoSRReq;
    private boolean isSilentRepair;
    private String lloc;
    private String srOriginUrl;
    private Integer srStatus;
    private String srUrl;
    private String taskId;

    public QZoneRepairTaskStateBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final String getLloc() {
        return this.lloc;
    }

    public final String getSrOriginUrl() {
        return this.srOriginUrl;
    }

    public final Integer getSrStatus() {
        return this.srStatus;
    }

    public final String getSrUrl() {
        return this.srUrl;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: isNeedDoSRReq, reason: from getter */
    public final Boolean getIsNeedDoSRReq() {
        return this.isNeedDoSRReq;
    }

    /* renamed from: isSilentRepair, reason: from getter */
    public final boolean getIsSilentRepair() {
        return this.isSilentRepair;
    }

    public final void setAlbumId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void setLloc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lloc = str;
    }

    public final void setNeedDoSRReq(Boolean bool) {
        this.isNeedDoSRReq = bool;
    }

    public final void setSilentRepair(boolean z16) {
        this.isSilentRepair = z16;
    }

    public final void setSrOriginUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.srOriginUrl = str;
    }

    public final void setSrStatus(Integer num) {
        this.srStatus = num;
    }

    public final void setSrUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.srUrl = str;
    }

    public final void setTaskId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.taskId = str;
    }

    public String toString() {
        return "QZoneRepairTaskStateBean( albumId='" + this.albumId + "', lloc='" + this.lloc + "', taskId='" + this.taskId + "', srStatus=" + this.srStatus + ", isNeedDoSRReq=" + this.isNeedDoSRReq + ", isSilentRepair=" + this.isSilentRepair + ", srOriginUrl='" + this.srOriginUrl + "', srUrl='" + this.srUrl + "')";
    }

    public QZoneRepairTaskStateBean(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.taskId = taskId;
        this.albumId = "";
        this.lloc = "";
        this.srOriginUrl = "";
        this.srUrl = "";
    }

    public /* synthetic */ QZoneRepairTaskStateBean(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
    }
}
