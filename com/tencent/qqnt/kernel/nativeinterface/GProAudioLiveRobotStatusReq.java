package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAudioLiveRobotStatusReq {
    public ArrayList<Long> botIds;
    public long channelId;
    public long guildId;

    public GProAudioLiveRobotStatusReq() {
        this.botIds = new ArrayList<>();
    }

    public ArrayList<Long> getBotIds() {
        return this.botIds;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProAudioLiveRobotStatusReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",botIds=" + this.botIds + ",}";
    }

    public GProAudioLiveRobotStatusReq(long j3, long j16, ArrayList<Long> arrayList) {
        new ArrayList();
        this.guildId = j3;
        this.channelId = j16;
        this.botIds = arrayList;
    }
}
