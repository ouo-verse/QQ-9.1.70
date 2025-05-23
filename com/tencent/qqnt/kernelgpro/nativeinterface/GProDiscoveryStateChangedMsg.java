package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProDiscoveryStateChangedMsg implements Serializable {
    public GProMyRecommendMsg myRecommendMsg;
    public GProGetPrefetchRecommendGuildsRsp prefetchRecommendMsg;
    public int sceneType;
    long serialVersionUID;
    public GProTopGuildRecommendMsg topGuildRecommendMsg;

    public GProDiscoveryStateChangedMsg() {
        this.serialVersionUID = 1L;
        this.myRecommendMsg = new GProMyRecommendMsg();
        this.prefetchRecommendMsg = new GProGetPrefetchRecommendGuildsRsp();
        this.topGuildRecommendMsg = new GProTopGuildRecommendMsg();
    }

    public GProMyRecommendMsg getMyRecommendMsg() {
        return this.myRecommendMsg;
    }

    public GProGetPrefetchRecommendGuildsRsp getPrefetchRecommendMsg() {
        return this.prefetchRecommendMsg;
    }

    public int getSceneType() {
        return this.sceneType;
    }

    public GProTopGuildRecommendMsg getTopGuildRecommendMsg() {
        return this.topGuildRecommendMsg;
    }

    public String toString() {
        return "GProDiscoveryStateChangedMsg{sceneType=" + this.sceneType + ",myRecommendMsg=" + this.myRecommendMsg + ",prefetchRecommendMsg=" + this.prefetchRecommendMsg + ",topGuildRecommendMsg=" + this.topGuildRecommendMsg + ",}";
    }

    public GProDiscoveryStateChangedMsg(int i3, GProMyRecommendMsg gProMyRecommendMsg, GProGetPrefetchRecommendGuildsRsp gProGetPrefetchRecommendGuildsRsp, GProTopGuildRecommendMsg gProTopGuildRecommendMsg) {
        this.serialVersionUID = 1L;
        this.myRecommendMsg = new GProMyRecommendMsg();
        this.prefetchRecommendMsg = new GProGetPrefetchRecommendGuildsRsp();
        new GProTopGuildRecommendMsg();
        this.sceneType = i3;
        this.myRecommendMsg = gProMyRecommendMsg;
        this.prefetchRecommendMsg = gProGetPrefetchRecommendGuildsRsp;
        this.topGuildRecommendMsg = gProTopGuildRecommendMsg;
    }
}
