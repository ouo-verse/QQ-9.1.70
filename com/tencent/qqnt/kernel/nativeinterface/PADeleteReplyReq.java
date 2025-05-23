package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PADeleteReplyReq {
    public long batchId;
    public int commentType;
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String albumId = "";
    public String mediaId = "";
    public String commentId = "";
    public String replyId = "";
    public StUser albumOwner = new StUser();

    public String getAlbumId() {
        return this.albumId;
    }

    public StUser getAlbumOwner() {
        return this.albumOwner;
    }

    public long getBatchId() {
        return this.batchId;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public int getCommentType() {
        return this.commentType;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public String getReplyId() {
        return this.replyId;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }
}
