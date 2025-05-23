package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildNavigationInfo {
    public int auditStatus;
    public int compatibleFlag;
    public long guildId;
    public String guildName;
    public String iconSelectorColor;
    public String iconSelectorUrl;
    public ArrayList<GProNavigationV2Info> navigationList;
    public long version;

    public GProGuildNavigationInfo() {
        this.iconSelectorColor = "";
        this.navigationList = new ArrayList<>();
        this.guildName = "";
        this.iconSelectorUrl = "";
    }

    public int getAuditStatus() {
        return this.auditStatus;
    }

    public int getCompatibleFlag() {
        return this.compatibleFlag;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getIconSelectorColor() {
        return this.iconSelectorColor;
    }

    public String getIconSelectorUrl() {
        return this.iconSelectorUrl;
    }

    public ArrayList<GProNavigationV2Info> getNavigationList() {
        return this.navigationList;
    }

    public long getVersion() {
        return this.version;
    }

    public String toString() {
        return "GProGuildNavigationInfo{guildId=" + this.guildId + ",iconSelectorColor=" + this.iconSelectorColor + ",navigationList=" + this.navigationList + ",auditStatus=" + this.auditStatus + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",compatibleFlag=" + this.compatibleFlag + ",guildName=" + this.guildName + ",iconSelectorUrl=" + this.iconSelectorUrl + ",}";
    }

    public GProGuildNavigationInfo(long j3, String str, ArrayList<GProNavigationV2Info> arrayList, int i3, long j16, int i16, String str2, String str3) {
        this.iconSelectorColor = "";
        new ArrayList();
        this.guildId = j3;
        this.iconSelectorColor = str;
        this.navigationList = arrayList;
        this.auditStatus = i3;
        this.version = j16;
        this.compatibleFlag = i16;
        this.guildName = str2;
        this.iconSelectorUrl = str3;
    }
}
