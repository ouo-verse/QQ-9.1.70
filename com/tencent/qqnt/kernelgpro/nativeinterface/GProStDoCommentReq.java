package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* loaded from: classes24.dex */
public final class GProStDoCommentReq {
    public int commentType;
    public int from;
    public boolean needSyncGroup;
    public int src;
    public GProStCommonExt extInfo = new GProStCommonExt();
    public GProStComment comment = new GProStComment();
    public GProStFeed feed = new GProStFeed();
    public byte[] busiReqData = new byte[0];
    public GProStRichText commentContent = new GProStRichText();
    public String jsonComment = "";

    public byte[] getBusiReqData() {
        return this.busiReqData;
    }

    public GProStComment getComment() {
        return this.comment;
    }

    public GProStRichText getCommentContent() {
        return this.commentContent;
    }

    public int getCommentType() {
        return this.commentType;
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

    public String getJsonComment() {
        return this.jsonComment;
    }

    public boolean getNeedSyncGroup() {
        return this.needSyncGroup;
    }

    public int getSrc() {
        return this.src;
    }

    public String toString() {
        return "GProStDoCommentReq{extInfo=" + this.extInfo + ",commentType=" + this.commentType + ",comment=" + this.comment + ",feed=" + this.feed + MttLoader.QQBROWSER_PARAMS_FROME + this.from + ",busiReqData=" + this.busiReqData + ",src=" + this.src + ",commentContent=" + this.commentContent + ",jsonComment=" + this.jsonComment + ",needSyncGroup=" + this.needSyncGroup + ",}";
    }
}
