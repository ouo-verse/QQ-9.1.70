package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProScheduleGuildSurface {
    public int fontColor;
    public String guildName = "";
    public String coverUrl = "";
    public String iconUrl = "";
    public String channelName = "";

    public String getChannelName() {
        return this.channelName;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public int getFontColor() {
        return this.fontColor;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String toString() {
        return "GProScheduleGuildSurface{guildName=" + this.guildName + ",coverUrl=" + this.coverUrl + ",iconUrl=" + this.iconUrl + ",fontColor=" + this.fontColor + ",channelName=" + this.channelName + ",}";
    }
}
