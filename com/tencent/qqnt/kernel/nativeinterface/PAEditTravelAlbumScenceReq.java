package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PAEditTravelAlbumScenceReq {
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public AlbumInfo album = new AlbumInfo();
    public ArrayList<EditTravelAlbumScence> scences = new ArrayList<>();
    public ArrayList<EditPhoto> photos = new ArrayList<>();

    public AlbumInfo getAlbum() {
        return this.album;
    }

    public ArrayList<EditPhoto> getPhotos() {
        return this.photos;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public ArrayList<EditTravelAlbumScence> getScences() {
        return this.scences;
    }

    public int getSeq() {
        return this.seq;
    }
}
