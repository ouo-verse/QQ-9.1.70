package com.tencent.state.status;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.state.square.data.OnlineStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b4\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0011H\u00c6\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\t\u00107\u001a\u00020\u0005H\u00c6\u0003J\t\u00108\u001a\u00020\u0005H\u00c6\u0003J\t\u00109\u001a\u00020\bH\u00c6\u0003J\t\u0010:\u001a\u00020\u0005H\u00c6\u0003J\t\u0010;\u001a\u00020\u000bH\u00c6\u0003J\t\u0010<\u001a\u00020\rH\u00c6\u0003J\t\u0010=\u001a\u00020\u000bH\u00c6\u0003J\t\u0010>\u001a\u00020\u0005H\u00c6\u0003J~\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u000b2\b\u0010B\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010C\u001a\u00020\u0003H\u00d6\u0001J\t\u0010D\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017\u00a8\u0006E"}, d2 = {"Lcom/tencent/state/status/StatusPanelData;", "", "pageIndex", "", "titleId", "", "titleName", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "cornerUrl", "isSelect", "", "reportData", "Lcom/tencent/state/status/ReportData;", "showTipsIcon", "tipsUrl", "taskInfo", "Lcom/tencent/state/status/PanelStatusTaskInfo;", "selectActionId", "(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/state/square/data/OnlineStatus;Ljava/lang/String;ZLcom/tencent/state/status/ReportData;ZLjava/lang/String;Lcom/tencent/state/status/PanelStatusTaskInfo;Ljava/lang/Integer;)V", "getCornerUrl", "()Ljava/lang/String;", "setCornerUrl", "(Ljava/lang/String;)V", "()Z", "setSelect", "(Z)V", "getPageIndex", "()I", "setPageIndex", "(I)V", "getReportData", "()Lcom/tencent/state/status/ReportData;", "getSelectActionId", "()Ljava/lang/Integer;", "setSelectActionId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getShowTipsIcon", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()Lcom/tencent/state/square/data/OnlineStatus;", "setStatus", "(Lcom/tencent/state/square/data/OnlineStatus;)V", "getTaskInfo", "()Lcom/tencent/state/status/PanelStatusTaskInfo;", "setTaskInfo", "(Lcom/tencent/state/status/PanelStatusTaskInfo;)V", "getTipsUrl", "getTitleId", "setTitleId", "getTitleName", "setTitleName", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/state/square/data/OnlineStatus;Ljava/lang/String;ZLcom/tencent/state/status/ReportData;ZLjava/lang/String;Lcom/tencent/state/status/PanelStatusTaskInfo;Ljava/lang/Integer;)Lcom/tencent/state/status/StatusPanelData;", "equals", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class StatusPanelData {
    private String cornerUrl;
    private boolean isSelect;
    private int pageIndex;
    private final ReportData reportData;
    private Integer selectActionId;
    private final boolean showTipsIcon;
    private OnlineStatus status;
    private PanelStatusTaskInfo taskInfo;
    private final String tipsUrl;
    private String titleId;
    private String titleName;

    public StatusPanelData(int i3, String titleId, String titleName, OnlineStatus status, String cornerUrl, boolean z16, ReportData reportData, boolean z17, String tipsUrl, PanelStatusTaskInfo taskInfo, Integer num) {
        Intrinsics.checkNotNullParameter(titleId, "titleId");
        Intrinsics.checkNotNullParameter(titleName, "titleName");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(cornerUrl, "cornerUrl");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        Intrinsics.checkNotNullParameter(tipsUrl, "tipsUrl");
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        this.pageIndex = i3;
        this.titleId = titleId;
        this.titleName = titleName;
        this.status = status;
        this.cornerUrl = cornerUrl;
        this.isSelect = z16;
        this.reportData = reportData;
        this.showTipsIcon = z17;
        this.tipsUrl = tipsUrl;
        this.taskInfo = taskInfo;
        this.selectActionId = num;
    }

    /* renamed from: component1, reason: from getter */
    public final int getPageIndex() {
        return this.pageIndex;
    }

    /* renamed from: component10, reason: from getter */
    public final PanelStatusTaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getSelectActionId() {
        return this.selectActionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitleId() {
        return this.titleId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitleName() {
        return this.titleName;
    }

    /* renamed from: component4, reason: from getter */
    public final OnlineStatus getStatus() {
        return this.status;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCornerUrl() {
        return this.cornerUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    /* renamed from: component7, reason: from getter */
    public final ReportData getReportData() {
        return this.reportData;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getShowTipsIcon() {
        return this.showTipsIcon;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTipsUrl() {
        return this.tipsUrl;
    }

    public final StatusPanelData copy(int pageIndex, String titleId, String titleName, OnlineStatus status, String cornerUrl, boolean isSelect, ReportData reportData, boolean showTipsIcon, String tipsUrl, PanelStatusTaskInfo taskInfo, Integer selectActionId) {
        Intrinsics.checkNotNullParameter(titleId, "titleId");
        Intrinsics.checkNotNullParameter(titleName, "titleName");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(cornerUrl, "cornerUrl");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        Intrinsics.checkNotNullParameter(tipsUrl, "tipsUrl");
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        return new StatusPanelData(pageIndex, titleId, titleName, status, cornerUrl, isSelect, reportData, showTipsIcon, tipsUrl, taskInfo, selectActionId);
    }

    public final String getCornerUrl() {
        return this.cornerUrl;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final ReportData getReportData() {
        return this.reportData;
    }

    public final Integer getSelectActionId() {
        return this.selectActionId;
    }

    public final boolean getShowTipsIcon() {
        return this.showTipsIcon;
    }

    public final OnlineStatus getStatus() {
        return this.status;
    }

    public final PanelStatusTaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    public final String getTipsUrl() {
        return this.tipsUrl;
    }

    public final String getTitleId() {
        return this.titleId;
    }

    public final String getTitleName() {
        return this.titleName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.pageIndex * 31;
        String str = this.titleId;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.titleName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        OnlineStatus onlineStatus = this.status;
        int hashCode3 = (hashCode2 + (onlineStatus != null ? onlineStatus.hashCode() : 0)) * 31;
        String str3 = this.cornerUrl;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z16 = this.isSelect;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode4 + i16) * 31;
        ReportData reportData = this.reportData;
        int hashCode5 = (i17 + (reportData != null ? reportData.hashCode() : 0)) * 31;
        boolean z17 = this.showTipsIcon;
        int i18 = (hashCode5 + (z17 ? 1 : z17 ? 1 : 0)) * 31;
        String str4 = this.tipsUrl;
        int hashCode6 = (i18 + (str4 != null ? str4.hashCode() : 0)) * 31;
        PanelStatusTaskInfo panelStatusTaskInfo = this.taskInfo;
        int hashCode7 = (hashCode6 + (panelStatusTaskInfo != null ? panelStatusTaskInfo.hashCode() : 0)) * 31;
        Integer num = this.selectActionId;
        return hashCode7 + (num != null ? num.hashCode() : 0);
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setCornerUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cornerUrl = str;
    }

    public final void setPageIndex(int i3) {
        this.pageIndex = i3;
    }

    public final void setSelect(boolean z16) {
        this.isSelect = z16;
    }

    public final void setSelectActionId(Integer num) {
        this.selectActionId = num;
    }

    public final void setStatus(OnlineStatus onlineStatus) {
        Intrinsics.checkNotNullParameter(onlineStatus, "<set-?>");
        this.status = onlineStatus;
    }

    public final void setTaskInfo(PanelStatusTaskInfo panelStatusTaskInfo) {
        Intrinsics.checkNotNullParameter(panelStatusTaskInfo, "<set-?>");
        this.taskInfo = panelStatusTaskInfo;
    }

    public final void setTitleId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.titleId = str;
    }

    public final void setTitleName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.titleName = str;
    }

    public String toString() {
        return "StatusPanelData(pageIndex=" + this.pageIndex + ", titleId=" + this.titleId + ", titleName=" + this.titleName + ", status=" + this.status + ", cornerUrl=" + this.cornerUrl + ", isSelect=" + this.isSelect + ", reportData=" + this.reportData + ", showTipsIcon=" + this.showTipsIcon + ", tipsUrl=" + this.tipsUrl + ", taskInfo=" + this.taskInfo + ", selectActionId=" + this.selectActionId + ")";
    }

    public /* synthetic */ StatusPanelData(int i3, String str, String str2, OnlineStatus onlineStatus, String str3, boolean z16, ReportData reportData, boolean z17, String str4, PanelStatusTaskInfo panelStatusTaskInfo, Integer num, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, onlineStatus, str3, z16, (i16 & 64) != 0 ? new ReportData(false, false, null, 0, 0, 0, 63, null) : reportData, z17, str4, panelStatusTaskInfo, (i16 & 1024) != 0 ? null : num);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatusPanelData)) {
            return false;
        }
        StatusPanelData statusPanelData = (StatusPanelData) other;
        return this.pageIndex == statusPanelData.pageIndex && Intrinsics.areEqual(this.titleId, statusPanelData.titleId) && Intrinsics.areEqual(this.titleName, statusPanelData.titleName) && Intrinsics.areEqual(this.status, statusPanelData.status) && Intrinsics.areEqual(this.cornerUrl, statusPanelData.cornerUrl) && this.isSelect == statusPanelData.isSelect && Intrinsics.areEqual(this.reportData, statusPanelData.reportData) && this.showTipsIcon == statusPanelData.showTipsIcon && Intrinsics.areEqual(this.tipsUrl, statusPanelData.tipsUrl) && Intrinsics.areEqual(this.taskInfo, statusPanelData.taskInfo) && Intrinsics.areEqual(this.selectActionId, statusPanelData.selectActionId);
    }
}
