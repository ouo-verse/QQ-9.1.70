package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProNavigationV2Info {
    public String appId;
    public long beginVersion;
    public String bubbleDesc;
    public long categoryId;
    public long endVersion;
    public GProNavigationItemExt extInfo;
    public long iconId;
    public String iconUrl;
    public String jumpUrl;
    public String jumpUrlAuditDesc;
    public int jumpUrlAuditStatus;
    public int jumpUrlType;
    public int platForm;
    public boolean showBubble;
    public String title;
    public String titleAuditDesc;
    public int titleAuditStatus;
    public String uuid;

    public GProNavigationV2Info() {
        this.iconUrl = "";
        this.title = "";
        this.jumpUrl = "";
        this.bubbleDesc = "";
        this.jumpUrlAuditDesc = "";
        this.titleAuditDesc = "";
        this.uuid = "";
        this.extInfo = new GProNavigationItemExt();
        this.appId = "";
    }

    public String getAppId() {
        return this.appId;
    }

    public long getBeginVersion() {
        return this.beginVersion;
    }

    public String getBubbleDesc() {
        return this.bubbleDesc;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public long getEndVersion() {
        return this.endVersion;
    }

    public GProNavigationItemExt getExtInfo() {
        return this.extInfo;
    }

    public long getIconId() {
        return this.iconId;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getJumpUrlAuditDesc() {
        return this.jumpUrlAuditDesc;
    }

    public int getJumpUrlAuditStatus() {
        return this.jumpUrlAuditStatus;
    }

    public int getJumpUrlType() {
        return this.jumpUrlType;
    }

    public int getPlatForm() {
        return this.platForm;
    }

    public boolean getShowBubble() {
        return this.showBubble;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitleAuditDesc() {
        return this.titleAuditDesc;
    }

    public int getTitleAuditStatus() {
        return this.titleAuditStatus;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String toString() {
        return "GProNavigationV2Info{iconId=" + this.iconId + ",iconUrl=" + this.iconUrl + ",title=" + this.title + ",jumpUrl=" + this.jumpUrl + ",jumpUrlType=" + this.jumpUrlType + ",showBubble=" + this.showBubble + ",bubbleDesc=" + this.bubbleDesc + ",beginVersion=" + this.beginVersion + ",endVersion=" + this.endVersion + ",platForm=" + this.platForm + ",jumpUrlAuditStatus=" + this.jumpUrlAuditStatus + ",jumpUrlAuditDesc=" + this.jumpUrlAuditDesc + ",titleAuditStatus=" + this.titleAuditStatus + ",titleAuditDesc=" + this.titleAuditDesc + ",uuid=" + this.uuid + ",extInfo=" + this.extInfo + ",appId=" + this.appId + ",categoryId=" + this.categoryId + ",}";
    }

    public GProNavigationV2Info(long j3, String str, String str2, String str3, int i3, boolean z16, String str4, long j16, long j17, int i16, int i17, String str5, int i18, String str6, String str7, GProNavigationItemExt gProNavigationItemExt, String str8) {
        this.iconUrl = "";
        this.title = "";
        this.jumpUrl = "";
        this.bubbleDesc = "";
        this.jumpUrlAuditDesc = "";
        this.titleAuditDesc = "";
        this.uuid = "";
        new GProNavigationItemExt();
        this.iconId = j3;
        this.iconUrl = str;
        this.title = str2;
        this.jumpUrl = str3;
        this.jumpUrlType = i3;
        this.showBubble = z16;
        this.bubbleDesc = str4;
        this.beginVersion = j16;
        this.endVersion = j17;
        this.platForm = i16;
        this.jumpUrlAuditStatus = i17;
        this.jumpUrlAuditDesc = str5;
        this.titleAuditStatus = i18;
        this.titleAuditDesc = str6;
        this.uuid = str7;
        this.extInfo = gProNavigationItemExt;
        this.appId = str8;
    }
}
