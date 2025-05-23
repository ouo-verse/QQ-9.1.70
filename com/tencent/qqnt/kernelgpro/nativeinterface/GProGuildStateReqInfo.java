package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildStateReqInfo {
    public ArrayList<Long> channelIdList;
    public long guildId;
    public long stateSeq;

    public GProGuildStateReqInfo() {
        this.channelIdList = new ArrayList<>();
    }

    public ArrayList<Long> getChannelIdList() {
        return this.channelIdList;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getStateSeq() {
        return this.stateSeq;
    }

    public String toString() {
        return "GProGuildStateReqInfo{guildId=" + this.guildId + ",channelIdList=" + this.channelIdList + ",stateSeq=" + this.stateSeq + ",}";
    }

    public GProGuildStateReqInfo(long j3, ArrayList<Long> arrayList, long j16) {
        new ArrayList();
        this.guildId = j3;
        this.channelIdList = arrayList;
        this.stateSeq = j16;
    }
}
