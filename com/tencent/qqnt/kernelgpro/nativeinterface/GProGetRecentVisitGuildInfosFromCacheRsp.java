package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetRecentVisitGuildInfosFromCacheRsp {
    public boolean isAllHitCache;
    public long timeStamp;
    public ArrayList<GProGuild> recentVisitGuildInfos = new ArrayList<>();
    public ArrayList<Long> unHitCacheGuildIds = new ArrayList<>();

    public boolean getIsAllHitCache() {
        return this.isAllHitCache;
    }

    public ArrayList<GProGuild> getRecentVisitGuildInfos() {
        return this.recentVisitGuildInfos;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public ArrayList<Long> getUnHitCacheGuildIds() {
        return this.unHitCacheGuildIds;
    }

    public String toString() {
        return "GProGetRecentVisitGuildInfosFromCacheRsp{recentVisitGuildInfos=" + this.recentVisitGuildInfos + ",timeStamp=" + this.timeStamp + ",isAllHitCache=" + this.isAllHitCache + ",unHitCacheGuildIds=" + this.unHitCacheGuildIds + ",}";
    }
}
