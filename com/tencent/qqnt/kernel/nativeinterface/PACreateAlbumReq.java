package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PACreateAlbumReq {
    public int familyRole;
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public AlbumInfo album = new AlbumInfo();

    public AlbumInfo getAlbum() {
        return this.album;
    }

    public int getFamilyRole() {
        return this.familyRole;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }
}
