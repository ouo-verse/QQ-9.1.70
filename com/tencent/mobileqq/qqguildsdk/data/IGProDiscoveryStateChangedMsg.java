package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetPrefetchRecommendGuildsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMyRecommendMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopGuildRecommendMsg;
import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProDiscoveryStateChangedMsg extends Serializable {
    GProMyRecommendMsg getMyRecommendMsg();

    GProGetPrefetchRecommendGuildsRsp getPrefetchRecommendMsg();

    int getSceneType();

    GProTopGuildRecommendMsg getTopGuildRecommendMsg();
}
