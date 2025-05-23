package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStPublishFeedRsp {
    public GProStCommonExt extInfo = new GProStCommonExt();
    public GProStFeed feed = new GProStFeed();
    public byte[] busiRspData = new byte[0];

    public byte[] getBusiRspData() {
        return this.busiRspData;
    }

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public GProStFeed getFeed() {
        return this.feed;
    }

    public String toString() {
        return "GProStPublishFeedRsp{extInfo=" + this.extInfo + ",feed=" + this.feed + ",busiRspData=" + this.busiRspData + ",}";
    }
}
