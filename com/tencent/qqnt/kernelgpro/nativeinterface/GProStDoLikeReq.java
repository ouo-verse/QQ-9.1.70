package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* loaded from: classes24.dex */
public final class GProStDoLikeReq {
    public int from;
    public int likeType;
    public int src;
    public GProStCommonExt extInfo = new GProStCommonExt();
    public GProStLike like = new GProStLike();
    public GProStFeed feed = new GProStFeed();
    public byte[] busiReqData = new byte[0];
    public GProStComment comment = new GProStComment();
    public GProStReply reply = new GProStReply();
    public GProStEmotionReactionInfo emotionReaction = new GProStEmotionReactionInfo();

    public byte[] getBusiReqData() {
        return this.busiReqData;
    }

    public GProStComment getComment() {
        return this.comment;
    }

    public GProStEmotionReactionInfo getEmotionReaction() {
        return this.emotionReaction;
    }

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public GProStFeed getFeed() {
        return this.feed;
    }

    public int getFrom() {
        return this.from;
    }

    public GProStLike getLike() {
        return this.like;
    }

    public int getLikeType() {
        return this.likeType;
    }

    public GProStReply getReply() {
        return this.reply;
    }

    public int getSrc() {
        return this.src;
    }

    public String toString() {
        return "GProStDoLikeReq{extInfo=" + this.extInfo + ",likeType=" + this.likeType + ",like=" + this.like + ",feed=" + this.feed + ",busiReqData=" + this.busiReqData + ",comment=" + this.comment + ",reply=" + this.reply + MttLoader.QQBROWSER_PARAMS_FROME + this.from + ",src=" + this.src + ",emotionReaction=" + this.emotionReaction + ",}";
    }
}
