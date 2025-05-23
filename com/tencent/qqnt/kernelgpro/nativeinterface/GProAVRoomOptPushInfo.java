package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAVRoomOptPushInfo {
    public long channelId;
    public String delRoomId;
    public long guildId;
    public int optType;
    public GProAVRoomAddUpInfo roomAddUpInfo;
    public GProAVShowMsgInfo showInfo;
    public String switchRoomId;

    public GProAVRoomOptPushInfo() {
        this.showInfo = new GProAVShowMsgInfo();
        this.roomAddUpInfo = new GProAVRoomAddUpInfo();
        this.delRoomId = "";
        this.switchRoomId = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getDelRoomId() {
        return this.delRoomId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getOptType() {
        return this.optType;
    }

    public GProAVRoomAddUpInfo getRoomAddUpInfo() {
        return this.roomAddUpInfo;
    }

    public GProAVShowMsgInfo getShowInfo() {
        return this.showInfo;
    }

    public String getSwitchRoomId() {
        return this.switchRoomId;
    }

    public String toString() {
        return "GProAVRoomOptPushInfo{optType=" + this.optType + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",showInfo=" + this.showInfo + ",roomAddUpInfo=" + this.roomAddUpInfo + ",delRoomId=" + this.delRoomId + ",switchRoomId=" + this.switchRoomId + ",}";
    }

    public GProAVRoomOptPushInfo(int i3, long j3, long j16, GProAVShowMsgInfo gProAVShowMsgInfo, GProAVRoomAddUpInfo gProAVRoomAddUpInfo, String str, String str2) {
        this.showInfo = new GProAVShowMsgInfo();
        new GProAVRoomAddUpInfo();
        this.optType = i3;
        this.guildId = j3;
        this.channelId = j16;
        this.showInfo = gProAVShowMsgInfo;
        this.roomAddUpInfo = gProAVRoomAddUpInfo;
        this.delRoomId = str;
        this.switchRoomId = str2;
    }
}
