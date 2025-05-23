package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsStGuildStateInfo {
    public long guildId;
    public int state;
    public int type;
    public String jumpUrl = "";
    public String iconUrl = "";
    public String aroundUrl = "";
    public String reportData = "";

    public String getAroundUrl() {
        return this.aroundUrl;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getReportData() {
        return this.reportData;
    }

    public int getState() {
        return this.state;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "UfsStGuildStateInfo{guildId=" + this.guildId + ",type=" + this.type + ",state=" + this.state + ",jumpUrl=" + this.jumpUrl + ",iconUrl=" + this.iconUrl + ",aroundUrl=" + this.aroundUrl + ",reportData=" + this.reportData + ",}";
    }
}
