package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PADoLikeReq {
    public int likeType;
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String albumId = "";
    public String mediaId = "";
    public StUser albumOwner = new StUser();
    public String likeKey = "";

    public String getAlbumId() {
        return this.albumId;
    }

    public StUser getAlbumOwner() {
        return this.albumOwner;
    }

    public String getLikeKey() {
        return this.likeKey;
    }

    public int getLikeType() {
        return this.likeType;
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
