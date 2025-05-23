package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStDoLikeRsp {
    public GProStCommonExt extInfo = new GProStCommonExt();
    public GProStLike like = new GProStLike();
    public byte[] busiRspData = new byte[0];
    public GProStEmotionReactionInfo emotionReaction = new GProStEmotionReactionInfo();

    public byte[] getBusiRspData() {
        return this.busiRspData;
    }

    public GProStEmotionReactionInfo getEmotionReaction() {
        return this.emotionReaction;
    }

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public GProStLike getLike() {
        return this.like;
    }

    public String toString() {
        return "GProStDoLikeRsp{extInfo=" + this.extInfo + ",like=" + this.like + ",busiRspData=" + this.busiRspData + ",emotionReaction=" + this.emotionReaction + ",}";
    }
}
