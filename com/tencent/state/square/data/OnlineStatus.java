package com.tencent.state.square.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u000fJ\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0007H\u00c6\u0003J\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0007H\u00c6\u0003J\t\u0010*\u001a\u00020\u0007H\u00c6\u0003J\t\u0010+\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\t\u0010-\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003Jq\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007H\u00c6\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u00020\u0003H\u00d6\u0001J\t\u00104\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0011\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0014R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010!\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001b\u00a8\u00065"}, d2 = {"Lcom/tencent/state/square/data/OnlineStatus;", "", "id", "", "topStatusId", "richStatus", "title", "", "icon", "bigIcon", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/state/square/data/SpecialStatus;", "customText", "publishTimeTips", "panelPreviewIcon", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/state/square/data/SpecialStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBigIcon", "()Ljava/lang/String;", "getCustomText", "setCustomText", "(Ljava/lang/String;)V", "getExtraData", "()Lcom/tencent/state/square/data/SpecialStatus;", "setExtraData", "(Lcom/tencent/state/square/data/SpecialStatus;)V", "getIcon", "getId", "()I", "getPanelPreviewIcon", "setPanelPreviewIcon", "getPublishTimeTips", "setPublishTimeTips", "getRichStatus", "shortDes", "getShortDes", "getTitle", "getTopStatusId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class OnlineStatus {
    private final String bigIcon;
    private String customText;
    private SpecialStatus extraData;
    private final String icon;
    private final int id;
    private String panelPreviewIcon;
    private String publishTimeTips;
    private final int richStatus;
    private final String shortDes;
    private final String title;
    private final int topStatusId;

    public OnlineStatus() {
        this(0, 0, 0, null, null, null, null, null, null, null, 1023, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getPanelPreviewIcon() {
        return this.panelPreviewIcon;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTopStatusId() {
        return this.topStatusId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRichStatus() {
        return this.richStatus;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component5, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBigIcon() {
        return this.bigIcon;
    }

    /* renamed from: component7, reason: from getter */
    public final SpecialStatus getExtraData() {
        return this.extraData;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCustomText() {
        return this.customText;
    }

    /* renamed from: component9, reason: from getter */
    public final String getPublishTimeTips() {
        return this.publishTimeTips;
    }

    public final OnlineStatus copy(int id5, int topStatusId, int richStatus, String title, String icon, String bigIcon, SpecialStatus extraData, String customText, String publishTimeTips, String panelPreviewIcon) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(bigIcon, "bigIcon");
        Intrinsics.checkNotNullParameter(customText, "customText");
        Intrinsics.checkNotNullParameter(panelPreviewIcon, "panelPreviewIcon");
        return new OnlineStatus(id5, topStatusId, richStatus, title, icon, bigIcon, extraData, customText, publishTimeTips, panelPreviewIcon);
    }

    public final String getBigIcon() {
        return this.bigIcon;
    }

    public final String getCustomText() {
        return this.customText;
    }

    public final SpecialStatus getExtraData() {
        return this.extraData;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPanelPreviewIcon() {
        return this.panelPreviewIcon;
    }

    public final String getPublishTimeTips() {
        return this.publishTimeTips;
    }

    public final int getRichStatus() {
        return this.richStatus;
    }

    public final String getShortDes() {
        return this.shortDes;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTopStatusId() {
        return this.topStatusId;
    }

    public int hashCode() {
        int i3 = ((((this.id * 31) + this.topStatusId) * 31) + this.richStatus) * 31;
        String str = this.title;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.icon;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.bigIcon;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        SpecialStatus specialStatus = this.extraData;
        int hashCode4 = (hashCode3 + (specialStatus != null ? specialStatus.hashCode() : 0)) * 31;
        String str4 = this.customText;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.publishTimeTips;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.panelPreviewIcon;
        return hashCode6 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setCustomText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.customText = str;
    }

    public final void setExtraData(SpecialStatus specialStatus) {
        this.extraData = specialStatus;
    }

    public final void setPanelPreviewIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.panelPreviewIcon = str;
    }

    public final void setPublishTimeTips(String str) {
        this.publishTimeTips = str;
    }

    public String toString() {
        return "OnlineStatus(id=" + this.id + ", topStatusId=" + this.topStatusId + ", richStatus=" + this.richStatus + ", title=" + this.title + ", icon=" + this.icon + ", bigIcon=" + this.bigIcon + ", extraData=" + this.extraData + ", customText=" + this.customText + ", publishTimeTips=" + this.publishTimeTips + ", panelPreviewIcon=" + this.panelPreviewIcon + ")";
    }

    public OnlineStatus(int i3, int i16, int i17, String title, String icon, String bigIcon, SpecialStatus specialStatus, String customText, String str, String panelPreviewIcon) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(bigIcon, "bigIcon");
        Intrinsics.checkNotNullParameter(customText, "customText");
        Intrinsics.checkNotNullParameter(panelPreviewIcon, "panelPreviewIcon");
        this.id = i3;
        this.topStatusId = i16;
        this.richStatus = i17;
        this.title = title;
        this.icon = icon;
        this.bigIcon = bigIcon;
        this.extraData = specialStatus;
        this.customText = customText;
        this.publishTimeTips = str;
        this.panelPreviewIcon = panelPreviewIcon;
        this.shortDes = "OnlineStatus(id:" + i3 + ", topId:" + i16 + ", richId:" + i17 + ", title:" + title + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnlineStatus)) {
            return false;
        }
        OnlineStatus onlineStatus = (OnlineStatus) other;
        return this.id == onlineStatus.id && this.topStatusId == onlineStatus.topStatusId && this.richStatus == onlineStatus.richStatus && Intrinsics.areEqual(this.title, onlineStatus.title) && Intrinsics.areEqual(this.icon, onlineStatus.icon) && Intrinsics.areEqual(this.bigIcon, onlineStatus.bigIcon) && Intrinsics.areEqual(this.extraData, onlineStatus.extraData) && Intrinsics.areEqual(this.customText, onlineStatus.customText) && Intrinsics.areEqual(this.publishTimeTips, onlineStatus.publishTimeTips) && Intrinsics.areEqual(this.panelPreviewIcon, onlineStatus.panelPreviewIcon);
    }

    public /* synthetic */ OnlineStatus(int i3, int i16, int i17, String str, String str2, String str3, SpecialStatus specialStatus, String str4, String str5, String str6, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? 11 : i16, (i18 & 4) == 0 ? i17 : 0, (i18 & 8) != 0 ? "" : str, (i18 & 16) != 0 ? "" : str2, (i18 & 32) != 0 ? "" : str3, (i18 & 64) != 0 ? null : specialStatus, (i18 & 128) != 0 ? "" : str4, (i18 & 256) != 0 ? "" : str5, (i18 & 512) == 0 ? str6 : "");
    }
}
