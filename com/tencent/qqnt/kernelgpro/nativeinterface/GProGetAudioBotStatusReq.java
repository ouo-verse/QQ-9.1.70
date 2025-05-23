package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetAudioBotStatusReq {
    public ArrayList<Long> botIds;
    public long channelId;
    public long guildId;

    public GProGetAudioBotStatusReq() {
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
        return "GProGetAudioBotStatusReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",botIds=" + this.botIds + ",}";
    }

    public GProGetAudioBotStatusReq(long j3, long j16, ArrayList<Long> arrayList) {
        new ArrayList();
        this.guildId = j3;
        this.channelId = j16;
        this.botIds = arrayList;
    }
}
