package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAGetShareInfoReq {
    public boolean canReadCache;
    public boolean enableCache;
    public int scene;
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public StUser owner = new StUser();
    public String albumId = "";
    public String lloc = "";
    public String vid = "";

    public String getAlbumId() {
        return this.albumId;
    }

    public boolean getCanReadCache() {
        return this.canReadCache;
    }

    public boolean getEnableCache() {
        return this.enableCache;
    }

    public String getLloc() {
        return this.lloc;
    }

    public StUser getOwner() {
        return this.owner;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getScene() {
        return this.scene;
    }

    public int getSeq() {
        return this.seq;
    }

    public String getVid() {
        return this.vid;
    }
}
