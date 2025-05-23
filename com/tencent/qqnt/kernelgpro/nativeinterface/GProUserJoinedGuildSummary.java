package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProUserJoinedGuildSummary {
    public String joinedCountStr = "";
    public ArrayList<GProRecommendChannelInfo> guildList = new ArrayList<>();

    public ArrayList<GProRecommendChannelInfo> getGuildList() {
        return this.guildList;
    }

    public String getJoinedCountStr() {
        return this.joinedCountStr;
    }

    public String toString() {
        return "GProUserJoinedGuildSummary{joinedCountStr=" + this.joinedCountStr + ",guildList=" + this.guildList + ",}";
    }
}
