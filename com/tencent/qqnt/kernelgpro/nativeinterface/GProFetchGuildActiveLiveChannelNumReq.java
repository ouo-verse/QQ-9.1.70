package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProFetchGuildActiveLiveChannelNumReq {
    public ArrayList<Long> channelId = new ArrayList<>();
    public long guildId;

    public ArrayList<Long> getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProFetchGuildActiveLiveChannelNumReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",}";
    }
}
