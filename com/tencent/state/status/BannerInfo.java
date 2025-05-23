package com.tencent.state.status;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0007H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003Jm\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00105\u001a\u000206H\u00d6\u0001J\t\u00107\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012\u00a8\u00068"}, d2 = {"Lcom/tencent/state/status/BannerInfo;", "", "title", "", "desc", "btnName", "linkType", "Lcom/tencent/state/status/PanelTaskBannerLinkType;", "linkUrl", "sucTitle", "sucDesc", "sucCancelBntName", "sucConfirmBntName", "sucHeadIcon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/state/status/PanelTaskBannerLinkType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBtnName", "()Ljava/lang/String;", "setBtnName", "(Ljava/lang/String;)V", "getDesc", "setDesc", "getLinkType", "()Lcom/tencent/state/status/PanelTaskBannerLinkType;", "setLinkType", "(Lcom/tencent/state/status/PanelTaskBannerLinkType;)V", "getLinkUrl", "setLinkUrl", "getSucCancelBntName", "setSucCancelBntName", "getSucConfirmBntName", "setSucConfirmBntName", "getSucDesc", "setSucDesc", "getSucHeadIcon", "setSucHeadIcon", "getSucTitle", "setSucTitle", "getTitle", "setTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class BannerInfo {
    private String btnName;
    private String desc;
    private PanelTaskBannerLinkType linkType;
    private String linkUrl;
    private String sucCancelBntName;
    private String sucConfirmBntName;
    private String sucDesc;
    private String sucHeadIcon;
    private String sucTitle;
    private String title;

    public BannerInfo() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component10, reason: from getter */
    public final String getSucHeadIcon() {
        return this.sucHeadIcon;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBtnName() {
        return this.btnName;
    }

    /* renamed from: component4, reason: from getter */
    public final PanelTaskBannerLinkType getLinkType() {
        return this.linkType;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLinkUrl() {
        return this.linkUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSucTitle() {
        return this.sucTitle;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSucDesc() {
        return this.sucDesc;
    }

    /* renamed from: component8, reason: from getter */
    public final String getSucCancelBntName() {
        return this.sucCancelBntName;
    }

    /* renamed from: component9, reason: from getter */
    public final String getSucConfirmBntName() {
        return this.sucConfirmBntName;
    }

    public final BannerInfo copy(String title, String desc, String btnName, PanelTaskBannerLinkType linkType, String linkUrl, String sucTitle, String sucDesc, String sucCancelBntName, String sucConfirmBntName, String sucHeadIcon) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(btnName, "btnName");
        Intrinsics.checkNotNullParameter(linkType, "linkType");
        Intrinsics.checkNotNullParameter(linkUrl, "linkUrl");
        Intrinsics.checkNotNullParameter(sucTitle, "sucTitle");
        Intrinsics.checkNotNullParameter(sucDesc, "sucDesc");
        Intrinsics.checkNotNullParameter(sucCancelBntName, "sucCancelBntName");
        Intrinsics.checkNotNullParameter(sucConfirmBntName, "sucConfirmBntName");
        Intrinsics.checkNotNullParameter(sucHeadIcon, "sucHeadIcon");
        return new BannerInfo(title, desc, btnName, linkType, linkUrl, sucTitle, sucDesc, sucCancelBntName, sucConfirmBntName, sucHeadIcon);
    }

    public final String getBtnName() {
        return this.btnName;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final PanelTaskBannerLinkType getLinkType() {
        return this.linkType;
    }

    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public final String getSucCancelBntName() {
        return this.sucCancelBntName;
    }

    public final String getSucConfirmBntName() {
        return this.sucConfirmBntName;
    }

    public final String getSucDesc() {
        return this.sucDesc;
    }

    public final String getSucHeadIcon() {
        return this.sucHeadIcon;
    }

    public final String getSucTitle() {
        return this.sucTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.desc;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.btnName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        PanelTaskBannerLinkType panelTaskBannerLinkType = this.linkType;
        int hashCode4 = (hashCode3 + (panelTaskBannerLinkType != null ? panelTaskBannerLinkType.hashCode() : 0)) * 31;
        String str4 = this.linkUrl;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.sucTitle;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.sucDesc;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.sucCancelBntName;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.sucConfirmBntName;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.sucHeadIcon;
        return hashCode9 + (str9 != null ? str9.hashCode() : 0);
    }

    public final void setBtnName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.btnName = str;
    }

    public final void setDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void setLinkType(PanelTaskBannerLinkType panelTaskBannerLinkType) {
        Intrinsics.checkNotNullParameter(panelTaskBannerLinkType, "<set-?>");
        this.linkType = panelTaskBannerLinkType;
    }

    public final void setLinkUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.linkUrl = str;
    }

    public final void setSucCancelBntName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sucCancelBntName = str;
    }

    public final void setSucConfirmBntName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sucConfirmBntName = str;
    }

    public final void setSucDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sucDesc = str;
    }

    public final void setSucHeadIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sucHeadIcon = str;
    }

    public final void setSucTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sucTitle = str;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public String toString() {
        return "BannerInfo(title=" + this.title + ", desc=" + this.desc + ", btnName=" + this.btnName + ", linkType=" + this.linkType + ", linkUrl=" + this.linkUrl + ", sucTitle=" + this.sucTitle + ", sucDesc=" + this.sucDesc + ", sucCancelBntName=" + this.sucCancelBntName + ", sucConfirmBntName=" + this.sucConfirmBntName + ", sucHeadIcon=" + this.sucHeadIcon + ")";
    }

    public BannerInfo(String title, String desc, String btnName, PanelTaskBannerLinkType linkType, String linkUrl, String sucTitle, String sucDesc, String sucCancelBntName, String sucConfirmBntName, String sucHeadIcon) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(btnName, "btnName");
        Intrinsics.checkNotNullParameter(linkType, "linkType");
        Intrinsics.checkNotNullParameter(linkUrl, "linkUrl");
        Intrinsics.checkNotNullParameter(sucTitle, "sucTitle");
        Intrinsics.checkNotNullParameter(sucDesc, "sucDesc");
        Intrinsics.checkNotNullParameter(sucCancelBntName, "sucCancelBntName");
        Intrinsics.checkNotNullParameter(sucConfirmBntName, "sucConfirmBntName");
        Intrinsics.checkNotNullParameter(sucHeadIcon, "sucHeadIcon");
        this.title = title;
        this.desc = desc;
        this.btnName = btnName;
        this.linkType = linkType;
        this.linkUrl = linkUrl;
        this.sucTitle = sucTitle;
        this.sucDesc = sucDesc;
        this.sucCancelBntName = sucCancelBntName;
        this.sucConfirmBntName = sucConfirmBntName;
        this.sucHeadIcon = sucHeadIcon;
    }

    public /* synthetic */ BannerInfo(String str, String str2, String str3, PanelTaskBannerLinkType panelTaskBannerLinkType, String str4, String str5, String str6, String str7, String str8, String str9, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? PanelTaskBannerLinkType.LINK_TYPE_NIL : panelTaskBannerLinkType, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? "" : str5, (i3 & 64) != 0 ? "" : str6, (i3 & 128) != 0 ? "" : str7, (i3 & 256) != 0 ? "" : str8, (i3 & 512) == 0 ? str9 : "");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BannerInfo)) {
            return false;
        }
        BannerInfo bannerInfo = (BannerInfo) other;
        return Intrinsics.areEqual(this.title, bannerInfo.title) && Intrinsics.areEqual(this.desc, bannerInfo.desc) && Intrinsics.areEqual(this.btnName, bannerInfo.btnName) && Intrinsics.areEqual(this.linkType, bannerInfo.linkType) && Intrinsics.areEqual(this.linkUrl, bannerInfo.linkUrl) && Intrinsics.areEqual(this.sucTitle, bannerInfo.sucTitle) && Intrinsics.areEqual(this.sucDesc, bannerInfo.sucDesc) && Intrinsics.areEqual(this.sucCancelBntName, bannerInfo.sucCancelBntName) && Intrinsics.areEqual(this.sucConfirmBntName, bannerInfo.sucConfirmBntName) && Intrinsics.areEqual(this.sucHeadIcon, bannerInfo.sucHeadIcon);
    }
}
