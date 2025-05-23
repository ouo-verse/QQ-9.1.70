package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAVUserStateChangeInfo {
    public long channelId;
    public long guildId;

    /* renamed from: msg, reason: collision with root package name */
    public String f359278msg;
    public GProAVShowMsgInfo showInfo;
    public long tinyId;
    public GProUserCtlInfo userCtlInfo;

    public GProAVUserStateChangeInfo() {
        this.userCtlInfo = new GProUserCtlInfo();
        this.f359278msg = "";
        this.showInfo = new GProAVShowMsgInfo();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getMsg() {
        return this.f359278msg;
    }

    public GProAVShowMsgInfo getShowInfo() {
        return this.showInfo;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public GProUserCtlInfo getUserCtlInfo() {
        return this.userCtlInfo;
    }

    public String toString() {
        return "GProAVUserStateChangeInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",tinyId=" + this.tinyId + ",userCtlInfo=" + this.userCtlInfo + ",msg=" + this.f359278msg + ",showInfo=" + this.showInfo + ",}";
    }

    public GProAVUserStateChangeInfo(long j3, long j16, long j17, GProUserCtlInfo gProUserCtlInfo, String str, GProAVShowMsgInfo gProAVShowMsgInfo) {
        this.userCtlInfo = new GProUserCtlInfo();
        this.f359278msg = "";
        new GProAVShowMsgInfo();
        this.guildId = j3;
        this.channelId = j16;
        this.tinyId = j17;
        this.userCtlInfo = gProUserCtlInfo;
        this.f359278msg = str;
        this.showInfo = gProAVShowMsgInfo;
    }
}
