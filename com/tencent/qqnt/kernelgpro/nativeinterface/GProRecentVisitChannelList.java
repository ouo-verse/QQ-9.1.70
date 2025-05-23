package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecentVisitChannelList {
    public long guildId;
    public int maxRecentVisitConfigCount;
    public ArrayList<GProRecentVisitChannelInfo> recentList = new ArrayList<>();

    public long getGuildId() {
        return this.guildId;
    }

    public int getMaxRecentVisitConfigCount() {
        return this.maxRecentVisitConfigCount;
    }

    public ArrayList<GProRecentVisitChannelInfo> getRecentList() {
        return this.recentList;
    }

    public String toString() {
        return "GProRecentVisitChannelList{guildId=" + this.guildId + ",recentList=" + this.recentList + ",maxRecentVisitConfigCount=" + this.maxRecentVisitConfigCount + ",}";
    }
}
