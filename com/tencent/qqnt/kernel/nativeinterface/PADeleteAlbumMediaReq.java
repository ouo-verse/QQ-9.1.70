package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PADeleteAlbumMediaReq {
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String albumId = "";
    public ArrayList<String> picidList = new ArrayList<>();
    public ArrayList<String> vids = new ArrayList<>();

    public String getAlbumId() {
        return this.albumId;
    }

    public ArrayList<String> getPicidList() {
        return this.picidList;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }

    public ArrayList<String> getVids() {
        return this.vids;
    }
}
