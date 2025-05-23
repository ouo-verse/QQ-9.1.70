package com.tencent.state.square.data;

import com.tencent.state.status.PanelStatusTaskInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\bH\u00c6\u0003J\t\u0010 \u001a\u00020\u000bH\u00c6\u0003J\t\u0010!\u001a\u00020\bH\u00c6\u0003J\t\u0010\"\u001a\u00020\u000eH\u00c6\u0003JU\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00c6\u0001J\u0013\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020'H\u00d6\u0001J\t\u0010(\u001a\u00020\bH\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006)"}, d2 = {"Lcom/tencent/state/square/data/StatusActionInfo;", "", "statusInfo", "Lcom/tencent/state/square/data/OnlineStatus;", "actionList", "", "Lcom/tencent/state/square/data/BaseResourceInfo;", "cornerUrl", "", "cornerName", "showMultiActionPickIcon", "", "multiActionPickIcon", "panelStatusTaskInfo", "Lcom/tencent/state/status/PanelStatusTaskInfo;", "(Lcom/tencent/state/square/data/OnlineStatus;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/tencent/state/status/PanelStatusTaskInfo;)V", "getActionList", "()Ljava/util/List;", "getCornerName", "()Ljava/lang/String;", "getCornerUrl", "getMultiActionPickIcon", "getPanelStatusTaskInfo", "()Lcom/tencent/state/status/PanelStatusTaskInfo;", "getShowMultiActionPickIcon", "()Z", "getStatusInfo", "()Lcom/tencent/state/square/data/OnlineStatus;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class StatusActionInfo {
    private final List<BaseResourceInfo> actionList;
    private final String cornerName;
    private final String cornerUrl;
    private final String multiActionPickIcon;
    private final PanelStatusTaskInfo panelStatusTaskInfo;
    private final boolean showMultiActionPickIcon;
    private final OnlineStatus statusInfo;

    public StatusActionInfo() {
        this(null, null, null, null, false, null, null, 127, null);
    }

    /* renamed from: component1, reason: from getter */
    public final OnlineStatus getStatusInfo() {
        return this.statusInfo;
    }

    public final List<BaseResourceInfo> component2() {
        return this.actionList;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCornerUrl() {
        return this.cornerUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCornerName() {
        return this.cornerName;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getShowMultiActionPickIcon() {
        return this.showMultiActionPickIcon;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMultiActionPickIcon() {
        return this.multiActionPickIcon;
    }

    /* renamed from: component7, reason: from getter */
    public final PanelStatusTaskInfo getPanelStatusTaskInfo() {
        return this.panelStatusTaskInfo;
    }

    public final StatusActionInfo copy(OnlineStatus statusInfo, List<? extends BaseResourceInfo> actionList, String cornerUrl, String cornerName, boolean showMultiActionPickIcon, String multiActionPickIcon, PanelStatusTaskInfo panelStatusTaskInfo) {
        Intrinsics.checkNotNullParameter(statusInfo, "statusInfo");
        Intrinsics.checkNotNullParameter(actionList, "actionList");
        Intrinsics.checkNotNullParameter(cornerUrl, "cornerUrl");
        Intrinsics.checkNotNullParameter(cornerName, "cornerName");
        Intrinsics.checkNotNullParameter(multiActionPickIcon, "multiActionPickIcon");
        Intrinsics.checkNotNullParameter(panelStatusTaskInfo, "panelStatusTaskInfo");
        return new StatusActionInfo(statusInfo, actionList, cornerUrl, cornerName, showMultiActionPickIcon, multiActionPickIcon, panelStatusTaskInfo);
    }

    public final List<BaseResourceInfo> getActionList() {
        return this.actionList;
    }

    public final String getCornerName() {
        return this.cornerName;
    }

    public final String getCornerUrl() {
        return this.cornerUrl;
    }

    public final String getMultiActionPickIcon() {
        return this.multiActionPickIcon;
    }

    public final PanelStatusTaskInfo getPanelStatusTaskInfo() {
        return this.panelStatusTaskInfo;
    }

    public final boolean getShowMultiActionPickIcon() {
        return this.showMultiActionPickIcon;
    }

    public final OnlineStatus getStatusInfo() {
        return this.statusInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        OnlineStatus onlineStatus = this.statusInfo;
        int hashCode = (onlineStatus != null ? onlineStatus.hashCode() : 0) * 31;
        List<BaseResourceInfo> list = this.actionList;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.cornerUrl;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.cornerName;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z16 = this.showMultiActionPickIcon;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode4 + i3) * 31;
        String str3 = this.multiActionPickIcon;
        int hashCode5 = (i16 + (str3 != null ? str3.hashCode() : 0)) * 31;
        PanelStatusTaskInfo panelStatusTaskInfo = this.panelStatusTaskInfo;
        return hashCode5 + (panelStatusTaskInfo != null ? panelStatusTaskInfo.hashCode() : 0);
    }

    public String toString() {
        return "StatusActionInfo(statusInfo=" + this.statusInfo + ", actionList=" + this.actionList + ", cornerUrl=" + this.cornerUrl + ", cornerName=" + this.cornerName + ", showMultiActionPickIcon=" + this.showMultiActionPickIcon + ", multiActionPickIcon=" + this.multiActionPickIcon + ", panelStatusTaskInfo=" + this.panelStatusTaskInfo + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StatusActionInfo(OnlineStatus statusInfo, List<? extends BaseResourceInfo> actionList, String cornerUrl, String cornerName, boolean z16, String multiActionPickIcon, PanelStatusTaskInfo panelStatusTaskInfo) {
        Intrinsics.checkNotNullParameter(statusInfo, "statusInfo");
        Intrinsics.checkNotNullParameter(actionList, "actionList");
        Intrinsics.checkNotNullParameter(cornerUrl, "cornerUrl");
        Intrinsics.checkNotNullParameter(cornerName, "cornerName");
        Intrinsics.checkNotNullParameter(multiActionPickIcon, "multiActionPickIcon");
        Intrinsics.checkNotNullParameter(panelStatusTaskInfo, "panelStatusTaskInfo");
        this.statusInfo = statusInfo;
        this.actionList = actionList;
        this.cornerUrl = cornerUrl;
        this.cornerName = cornerName;
        this.showMultiActionPickIcon = z16;
        this.multiActionPickIcon = multiActionPickIcon;
        this.panelStatusTaskInfo = panelStatusTaskInfo;
    }

    public /* synthetic */ StatusActionInfo(OnlineStatus onlineStatus, List list, String str, String str2, boolean z16, String str3, PanelStatusTaskInfo panelStatusTaskInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new OnlineStatus(0, 0, 0, null, null, null, null, null, null, null, 1023, null) : onlineStatus, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? false : z16, (i3 & 32) == 0 ? str3 : "", (i3 & 64) != 0 ? new PanelStatusTaskInfo(0, 0, null, null, 0, 31, null) : panelStatusTaskInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatusActionInfo)) {
            return false;
        }
        StatusActionInfo statusActionInfo = (StatusActionInfo) other;
        return Intrinsics.areEqual(this.statusInfo, statusActionInfo.statusInfo) && Intrinsics.areEqual(this.actionList, statusActionInfo.actionList) && Intrinsics.areEqual(this.cornerUrl, statusActionInfo.cornerUrl) && Intrinsics.areEqual(this.cornerName, statusActionInfo.cornerName) && this.showMultiActionPickIcon == statusActionInfo.showMultiActionPickIcon && Intrinsics.areEqual(this.multiActionPickIcon, statusActionInfo.multiActionPickIcon) && Intrinsics.areEqual(this.panelStatusTaskInfo, statusActionInfo.panelStatusTaskInfo);
    }

    public static /* synthetic */ StatusActionInfo copy$default(StatusActionInfo statusActionInfo, OnlineStatus onlineStatus, List list, String str, String str2, boolean z16, String str3, PanelStatusTaskInfo panelStatusTaskInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            onlineStatus = statusActionInfo.statusInfo;
        }
        if ((i3 & 2) != 0) {
            list = statusActionInfo.actionList;
        }
        List list2 = list;
        if ((i3 & 4) != 0) {
            str = statusActionInfo.cornerUrl;
        }
        String str4 = str;
        if ((i3 & 8) != 0) {
            str2 = statusActionInfo.cornerName;
        }
        String str5 = str2;
        if ((i3 & 16) != 0) {
            z16 = statusActionInfo.showMultiActionPickIcon;
        }
        boolean z17 = z16;
        if ((i3 & 32) != 0) {
            str3 = statusActionInfo.multiActionPickIcon;
        }
        String str6 = str3;
        if ((i3 & 64) != 0) {
            panelStatusTaskInfo = statusActionInfo.panelStatusTaskInfo;
        }
        return statusActionInfo.copy(onlineStatus, list2, str4, str5, z17, str6, panelStatusTaskInfo);
    }
}
