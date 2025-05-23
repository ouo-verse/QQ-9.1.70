package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* loaded from: classes24.dex */
public final class PanelItem {
    public boolean hot;
    public int isSet;
    public long mark;
    public int pId;
    public int status;
    public int version;
    public PanelItemInfo offInfo = new PanelItemInfo();
    public PanelItemInfo onInfo = new PanelItemInfo();
    public String settingUrl = "";
    public String desc = "";
    public String availableRangeDesc = "";

    public String getAvailableRangeDesc() {
        return this.availableRangeDesc;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean getHot() {
        return this.hot;
    }

    public int getIsSet() {
        return this.isSet;
    }

    public long getMark() {
        return this.mark;
    }

    public PanelItemInfo getOffInfo() {
        return this.offInfo;
    }

    public PanelItemInfo getOnInfo() {
        return this.onInfo;
    }

    public int getPId() {
        return this.pId;
    }

    public String getSettingUrl() {
        return this.settingUrl;
    }

    public int getStatus() {
        return this.status;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        return "PanelItem{offInfo=" + this.offInfo + ",onInfo=" + this.onInfo + ",hot=" + this.hot + ",pId=" + this.pId + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",mark=" + this.mark + ",settingUrl=" + this.settingUrl + ",desc=" + this.desc + ",isSet=" + this.isSet + ",status=" + this.status + ",availableRangeDesc=" + this.availableRangeDesc + ",}";
    }
}
