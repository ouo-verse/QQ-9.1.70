package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildBrowseInfo {
    public ArrayList<Long> channelIds;
    public long guildId;

    public GProGuildBrowseInfo() {
        this.channelIds = new ArrayList<>();
    }

    public ArrayList<Long> getChannelIds() {
        return this.channelIds;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public void setChannelIds(ArrayList<Long> arrayList) {
        this.channelIds = arrayList;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public String toString() {
        return "GProGuildBrowseInfo{guildId=" + this.guildId + ",channelIds=" + this.channelIds + ",}";
    }

    public GProGuildBrowseInfo(long j3, ArrayList<Long> arrayList) {
        new ArrayList();
        this.guildId = j3;
        this.channelIds = arrayList;
    }
}
