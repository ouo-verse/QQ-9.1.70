package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAEditAlbumReq {
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public AlbumInfo album = new AlbumInfo();
    public QzoneAlbumModifyDesc modifyDesc = new QzoneAlbumModifyDesc();

    public AlbumInfo getAlbum() {
        return this.album;
    }

    public QzoneAlbumModifyDesc getModifyDesc() {
        return this.modifyDesc;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }
}
