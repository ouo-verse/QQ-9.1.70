package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGetRecentVisitGuildInfosFromCacheRsp extends Serializable {
    boolean getIsAllHitCache();

    ArrayList<IGProGuildInfo> getRecentVisitGuildInfos();

    long getTimeStamp();

    ArrayList<Long> getUnHitCacheGuildIds();

    String toString();
}
