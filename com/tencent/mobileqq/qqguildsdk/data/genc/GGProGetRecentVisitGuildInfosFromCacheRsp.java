package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetRecentVisitGuildInfosFromCacheRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuild;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGetRecentVisitGuildInfosFromCacheRsp implements IGProGetRecentVisitGuildInfosFromCacheRsp {
    public final GProGetRecentVisitGuildInfosFromCacheRsp mInfo;

    public GGProGetRecentVisitGuildInfosFromCacheRsp(GProGetRecentVisitGuildInfosFromCacheRsp gProGetRecentVisitGuildInfosFromCacheRsp) {
        this.mInfo = gProGetRecentVisitGuildInfosFromCacheRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecentVisitGuildInfosFromCacheRsp
    public boolean getIsAllHitCache() {
        return this.mInfo.getIsAllHitCache();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecentVisitGuildInfosFromCacheRsp
    public ArrayList<IGProGuildInfo> getRecentVisitGuildInfos() {
        ArrayList<GProGuild> recentVisitGuildInfos = this.mInfo.getRecentVisitGuildInfos();
        ArrayList<IGProGuildInfo> arrayList = new ArrayList<>();
        Iterator<GProGuild> it = recentVisitGuildInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProGuildInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecentVisitGuildInfosFromCacheRsp
    public long getTimeStamp() {
        return this.mInfo.getTimeStamp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecentVisitGuildInfosFromCacheRsp
    public ArrayList<Long> getUnHitCacheGuildIds() {
        return this.mInfo.getUnHitCacheGuildIds();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecentVisitGuildInfosFromCacheRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
