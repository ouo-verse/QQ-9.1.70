package com.tencent.state.status;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001J\u0006\u0010%\u001a\u00020\"J\t\u0010&\u001a\u00020'H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012\u00a8\u0006("}, d2 = {"Lcom/tencent/state/status/PanelStatusTaskInfo;", "", "status", "", "richStatus", "bannerInfo", "Lcom/tencent/state/status/BannerInfo;", "prizeStatus", "Lcom/tencent/state/status/PanelStatusTaskPrizeStatus;", "finishType", "(IILcom/tencent/state/status/BannerInfo;Lcom/tencent/state/status/PanelStatusTaskPrizeStatus;I)V", "getBannerInfo", "()Lcom/tencent/state/status/BannerInfo;", "setBannerInfo", "(Lcom/tencent/state/status/BannerInfo;)V", "getFinishType", "()I", "setFinishType", "(I)V", "getPrizeStatus", "()Lcom/tencent/state/status/PanelStatusTaskPrizeStatus;", "setPrizeStatus", "(Lcom/tencent/state/status/PanelStatusTaskPrizeStatus;)V", "getRichStatus", "setRichStatus", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "setStatus", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "shouldFinishByServer", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class PanelStatusTaskInfo {
    private BannerInfo bannerInfo;
    private int finishType;
    private PanelStatusTaskPrizeStatus prizeStatus;
    private int richStatus;
    private int status;

    public PanelStatusTaskInfo() {
        this(0, 0, null, null, 0, 31, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRichStatus() {
        return this.richStatus;
    }

    /* renamed from: component3, reason: from getter */
    public final BannerInfo getBannerInfo() {
        return this.bannerInfo;
    }

    /* renamed from: component4, reason: from getter */
    public final PanelStatusTaskPrizeStatus getPrizeStatus() {
        return this.prizeStatus;
    }

    /* renamed from: component5, reason: from getter */
    public final int getFinishType() {
        return this.finishType;
    }

    public final PanelStatusTaskInfo copy(int status, int richStatus, BannerInfo bannerInfo, PanelStatusTaskPrizeStatus prizeStatus, int finishType) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(prizeStatus, "prizeStatus");
        return new PanelStatusTaskInfo(status, richStatus, bannerInfo, prizeStatus, finishType);
    }

    public final BannerInfo getBannerInfo() {
        return this.bannerInfo;
    }

    public final int getFinishType() {
        return this.finishType;
    }

    public final PanelStatusTaskPrizeStatus getPrizeStatus() {
        return this.prizeStatus;
    }

    public final int getRichStatus() {
        return this.richStatus;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        int i3 = ((this.status * 31) + this.richStatus) * 31;
        BannerInfo bannerInfo = this.bannerInfo;
        int hashCode = (i3 + (bannerInfo != null ? bannerInfo.hashCode() : 0)) * 31;
        PanelStatusTaskPrizeStatus panelStatusTaskPrizeStatus = this.prizeStatus;
        return ((hashCode + (panelStatusTaskPrizeStatus != null ? panelStatusTaskPrizeStatus.hashCode() : 0)) * 31) + this.finishType;
    }

    public final void setBannerInfo(BannerInfo bannerInfo) {
        Intrinsics.checkNotNullParameter(bannerInfo, "<set-?>");
        this.bannerInfo = bannerInfo;
    }

    public final void setFinishType(int i3) {
        this.finishType = i3;
    }

    public final void setPrizeStatus(PanelStatusTaskPrizeStatus panelStatusTaskPrizeStatus) {
        Intrinsics.checkNotNullParameter(panelStatusTaskPrizeStatus, "<set-?>");
        this.prizeStatus = panelStatusTaskPrizeStatus;
    }

    public final void setRichStatus(int i3) {
        this.richStatus = i3;
    }

    public final void setStatus(int i3) {
        this.status = i3;
    }

    public final boolean shouldFinishByServer() {
        return this.finishType == 2;
    }

    public String toString() {
        return "PanelStatusTaskInfo(status=" + this.status + ", richStatus=" + this.richStatus + ", bannerInfo=" + this.bannerInfo + ", prizeStatus=" + this.prizeStatus + ", finishType=" + this.finishType + ")";
    }

    public PanelStatusTaskInfo(int i3, int i16, BannerInfo bannerInfo, PanelStatusTaskPrizeStatus prizeStatus, int i17) {
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(prizeStatus, "prizeStatus");
        this.status = i3;
        this.richStatus = i16;
        this.bannerInfo = bannerInfo;
        this.prizeStatus = prizeStatus;
        this.finishType = i17;
    }

    public /* synthetic */ PanelStatusTaskInfo(int i3, int i16, BannerInfo bannerInfo, PanelStatusTaskPrizeStatus panelStatusTaskPrizeStatus, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? 0 : i16, (i18 & 4) != 0 ? new BannerInfo(null, null, null, null, null, null, null, null, null, null, 1023, null) : bannerInfo, (i18 & 8) != 0 ? PanelStatusTaskPrizeStatus.PRIZE_STATUS_NIL : panelStatusTaskPrizeStatus, (i18 & 16) == 0 ? i17 : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PanelStatusTaskInfo)) {
            return false;
        }
        PanelStatusTaskInfo panelStatusTaskInfo = (PanelStatusTaskInfo) other;
        return this.status == panelStatusTaskInfo.status && this.richStatus == panelStatusTaskInfo.richStatus && Intrinsics.areEqual(this.bannerInfo, panelStatusTaskInfo.bannerInfo) && Intrinsics.areEqual(this.prizeStatus, panelStatusTaskInfo.prizeStatus) && this.finishType == panelStatusTaskInfo.finishType;
    }

    public static /* synthetic */ PanelStatusTaskInfo copy$default(PanelStatusTaskInfo panelStatusTaskInfo, int i3, int i16, BannerInfo bannerInfo, PanelStatusTaskPrizeStatus panelStatusTaskPrizeStatus, int i17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            i3 = panelStatusTaskInfo.status;
        }
        if ((i18 & 2) != 0) {
            i16 = panelStatusTaskInfo.richStatus;
        }
        int i19 = i16;
        if ((i18 & 4) != 0) {
            bannerInfo = panelStatusTaskInfo.bannerInfo;
        }
        BannerInfo bannerInfo2 = bannerInfo;
        if ((i18 & 8) != 0) {
            panelStatusTaskPrizeStatus = panelStatusTaskInfo.prizeStatus;
        }
        PanelStatusTaskPrizeStatus panelStatusTaskPrizeStatus2 = panelStatusTaskPrizeStatus;
        if ((i18 & 16) != 0) {
            i17 = panelStatusTaskInfo.finishType;
        }
        return panelStatusTaskInfo.copy(i3, i19, bannerInfo2, panelStatusTaskPrizeStatus2, i17);
    }
}
