package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetMultiChannelFeedsFilter {
    public ArrayList<Long> channelIds = new ArrayList<>();
    public long guildId;

    public ArrayList<Long> getChannelIds() {
        return this.channelIds;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProGetMultiChannelFeedsFilter{guildId=" + this.guildId + ",channelIds=" + this.channelIds + ",}";
    }
}
