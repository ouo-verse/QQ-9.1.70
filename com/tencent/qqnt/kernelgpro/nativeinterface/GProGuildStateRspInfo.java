package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildStateRspInfo {
    public long nextTs;
    public ArrayList<GProGuildState> guildStatusList = new ArrayList<>();
    public GProUserChannelState userStateInfo = new GProUserChannelState();

    public ArrayList<GProGuildState> getGuildStatusList() {
        return this.guildStatusList;
    }

    public long getNextTs() {
        return this.nextTs;
    }

    public GProUserChannelState getUserStateInfo() {
        return this.userStateInfo;
    }

    public String toString() {
        return "GProGuildStateRspInfo{guildStatusList=" + this.guildStatusList + ",nextTs=" + this.nextTs + ",userStateInfo=" + this.userStateInfo + ",}";
    }
}
