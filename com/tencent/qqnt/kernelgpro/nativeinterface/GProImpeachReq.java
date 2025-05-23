package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProImpeachReq {
    public int impeachType;
    public GProStCommonExt extInfo = new GProStCommonExt();
    public GProStFeed feed = new GProStFeed();
    public GProStComment comment = new GProStComment();
    public GProStReply reply = new GProStReply();

    public GProStComment getComment() {
        return this.comment;
    }

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public GProStFeed getFeed() {
        return this.feed;
    }

    public int getImpeachType() {
        return this.impeachType;
    }

    public GProStReply getReply() {
        return this.reply;
    }

    public String toString() {
        return "GProImpeachReq{extInfo=" + this.extInfo + ",impeachType=" + this.impeachType + ",feed=" + this.feed + ",comment=" + this.comment + ",reply=" + this.reply + ",}";
    }
}
