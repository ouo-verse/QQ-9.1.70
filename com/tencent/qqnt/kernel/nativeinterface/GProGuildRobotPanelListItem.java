package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* loaded from: classes24.dex */
public final class GProGuildRobotPanelListItem {
    public String availableRangeDesc;
    public String desc;
    public boolean hot;

    /* renamed from: id, reason: collision with root package name */
    public int f359175id;
    public int isSet;
    public long mark;
    public GProGuildRobotPanelListItemInfo offInfo;
    public GProGuildRobotPanelListItemInfo onInfo;
    public String settingUrl;
    public int status;
    public int type;
    public int version;

    public GProGuildRobotPanelListItem() {
        this.offInfo = new GProGuildRobotPanelListItemInfo();
        this.onInfo = new GProGuildRobotPanelListItemInfo();
        this.settingUrl = "";
        this.desc = "";
        this.availableRangeDesc = "";
    }

    public String getAvailableRangeDesc() {
        return this.availableRangeDesc;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean getHot() {
        return this.hot;
    }

    public int getId() {
        return this.f359175id;
    }

    public int getIsSet() {
        return this.isSet;
    }

    public long getMark() {
        return this.mark;
    }

    public GProGuildRobotPanelListItemInfo getOffInfo() {
        return this.offInfo;
    }

    public GProGuildRobotPanelListItemInfo getOnInfo() {
        return this.onInfo;
    }

    public String getSettingUrl() {
        return this.settingUrl;
    }

    public int getStatus() {
        return this.status;
    }

    public int getType() {
        return this.type;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        return "GProGuildRobotPanelListItem{offInfo=" + this.offInfo + ",onInfo=" + this.onInfo + ",hot=" + this.hot + ",id=" + this.f359175id + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",mark=" + this.mark + ",settingUrl=" + this.settingUrl + ",desc=" + this.desc + ",type=" + this.type + ",isSet=" + this.isSet + ",status=" + this.status + ",availableRangeDesc=" + this.availableRangeDesc + ",}";
    }

    public GProGuildRobotPanelListItem(GProGuildRobotPanelListItemInfo gProGuildRobotPanelListItemInfo, GProGuildRobotPanelListItemInfo gProGuildRobotPanelListItemInfo2, boolean z16, int i3, int i16, long j3, String str, String str2, int i17, int i18, int i19, String str3) {
        this.offInfo = new GProGuildRobotPanelListItemInfo();
        new GProGuildRobotPanelListItemInfo();
        this.offInfo = gProGuildRobotPanelListItemInfo;
        this.onInfo = gProGuildRobotPanelListItemInfo2;
        this.hot = z16;
        this.f359175id = i3;
        this.version = i16;
        this.mark = j3;
        this.settingUrl = str;
        this.desc = str2;
        this.type = i17;
        this.isSet = i18;
        this.status = i19;
        this.availableRangeDesc = str3;
    }
}
