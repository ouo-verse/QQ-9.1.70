package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PAAddReplyReq {
    public long batchId;
    public int commentType;
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String albumId = "";
    public String mediaId = "";
    public String commentId = "";
    public ArrayList<StRichMsg> content = new ArrayList<>();
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

    public ArrayList<StRichMsg> getContent() {
        return this.content;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }
}
