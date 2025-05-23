package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildRobotPlusPanelReq {
    public long channelId;
    public GProGuildRobotClientInfo clientInfo;
    public int filter;
    public long guildId;
    public int page;
    public int pageSize;

    public GProGuildRobotPlusPanelReq() {
        this.clientInfo = new GProGuildRobotClientInfo();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public GProGuildRobotClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public int getFilter() {
        return this.filter;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getPage() {
        return this.page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public String toString() {
        return "GProGuildRobotPlusPanelReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",filter=" + this.filter + ",page=" + this.page + ",clientInfo=" + this.clientInfo + ",pageSize=" + this.pageSize + ",}";
    }

    public GProGuildRobotPlusPanelReq(long j3, long j16, int i3, int i16, GProGuildRobotClientInfo gProGuildRobotClientInfo, int i17) {
        new GProGuildRobotClientInfo();
        this.guildId = j3;
        this.channelId = j16;
        this.filter = i3;
        this.page = i16;
        this.clientInfo = gProGuildRobotClientInfo;
        this.pageSize = i17;
    }
}
