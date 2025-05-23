package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAGetAlbumListReq {
    public boolean canReadCache;
    public int count;
    public boolean enableCache;
    public int scene;
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public StUser user = new StUser();
    public String attachInfo = "";

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public boolean getCanReadCache() {
        return this.canReadCache;
    }

    public int getCount() {
        return this.count;
    }

    public boolean getEnableCache() {
        return this.enableCache;
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

    public StUser getUser() {
        return this.user;
    }
}
