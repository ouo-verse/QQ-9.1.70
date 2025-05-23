package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* loaded from: classes24.dex */
public final class GProStDoReplyReq {
    public int from;
    public boolean needSyncGroup;
    public int replyType;
    public int src;
    public GProStCommonExt extInfo = new GProStCommonExt();
    public GProStReply reply = new GProStReply();
    public GProStComment comment = new GProStComment();
    public GProStFeed feed = new GProStFeed();
    public byte[] busiReqData = new byte[0];
    public GProStRichText replyContent = new GProStRichText();
    public String jsonReply = "";

    public byte[] getBusiReqData() {
        return this.busiReqData;
    }

    public GProStComment getComment() {
        return this.comment;
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

    public String getJsonReply() {
        return this.jsonReply;
    }

    public boolean getNeedSyncGroup() {
        return this.needSyncGroup;
    }

    public GProStReply getReply() {
        return this.reply;
    }

    public GProStRichText getReplyContent() {
        return this.replyContent;
    }

    public int getReplyType() {
        return this.replyType;
    }

    public int getSrc() {
        return this.src;
    }

    public String toString() {
        return "GProStDoReplyReq{extInfo=" + this.extInfo + ",replyType=" + this.replyType + ",reply=" + this.reply + ",comment=" + this.comment + ",feed=" + this.feed + MttLoader.QQBROWSER_PARAMS_FROME + this.from + ",busiReqData=" + this.busiReqData + ",src=" + this.src + ",replyContent=" + this.replyContent + ",jsonReply=" + this.jsonReply + ",needSyncGroup=" + this.needSyncGroup + ",}";
    }
}
