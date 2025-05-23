package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAQueryAlbumReq {
    public boolean canReadCache;
    public boolean enableCache;
    public int reqSharedAlbum;
    public int reqType;
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String albumId = "";
    public StUser owner = new StUser();
    public String accessKey = "";
    public String shareCiphertext = "";

    public String getAccessKey() {
        return this.accessKey;
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public boolean getCanReadCache() {
        return this.canReadCache;
    }

    public boolean getEnableCache() {
        return this.enableCache;
    }

    public StUser getOwner() {
        return this.owner;
    }

    public int getReqSharedAlbum() {
        return this.reqSharedAlbum;
    }

    public int getReqType() {
        return this.reqType;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }

    public String getShareCiphertext() {
        return this.shareCiphertext;
    }
}
