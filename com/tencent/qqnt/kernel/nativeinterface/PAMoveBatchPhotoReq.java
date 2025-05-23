package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PAMoveBatchPhotoReq {
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String srcAlbumid = "";
    public ArrayList<String> srcPicidList = new ArrayList<>();
    public String dstAlbumid = "";

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

    public ArrayList<String> getSrcPicidList() {
        return this.srcPicidList;
    }
}
