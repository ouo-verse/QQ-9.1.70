package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProDiscoveryStateChangedMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetPrefetchRecommendGuildsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMyRecommendMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopGuildRecommendMsg;

/* loaded from: classes17.dex */
public class GGProDiscoveryStateChangedMsg implements IGProDiscoveryStateChangedMsg {
    public final GProDiscoveryStateChangedMsg mInfo;

    public GGProDiscoveryStateChangedMsg(GProDiscoveryStateChangedMsg gProDiscoveryStateChangedMsg) {
        this.mInfo = gProDiscoveryStateChangedMsg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProDiscoveryStateChangedMsg
    public GProMyRecommendMsg getMyRecommendMsg() {
        return this.mInfo.getMyRecommendMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProDiscoveryStateChangedMsg
    public GProGetPrefetchRecommendGuildsRsp getPrefetchRecommendMsg() {
        return this.mInfo.getPrefetchRecommendMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProDiscoveryStateChangedMsg
    public int getSceneType() {
        return this.mInfo.getSceneType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProDiscoveryStateChangedMsg
    public GProTopGuildRecommendMsg getTopGuildRecommendMsg() {
        return this.mInfo.getTopGuildRecommendMsg();
    }
}
