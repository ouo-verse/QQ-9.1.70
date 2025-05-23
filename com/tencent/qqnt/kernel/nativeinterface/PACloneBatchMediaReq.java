package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PACloneBatchMediaReq {
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String srcAlbumid = "";
    public ArrayList<String> srcMediaIds = new ArrayList<>();
    public String dstAlbumid = "";
    public StUser albumOwner = new StUser();

    public StUser getAlbumOwner() {
        return this.albumOwner;
    }

    public String getDstAlbumid() {
        return this.dstAlbumid;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }

    public String getSrcAlbumid() {
        return this.srcAlbumid;
    }

    public ArrayList<String> getSrcMediaIds() {
        return this.srcMediaIds;
    }
}
