package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PAEditBatchMediaReq {
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String albumId = "";
    public ArrayList<Integer> operations = new ArrayList<>();
    public ArrayList<EditPhoto> editPhotoList = new ArrayList<>();

    public String getAlbumId() {
        return this.albumId;
    }

    public ArrayList<EditPhoto> getEditPhotoList() {
        return this.editPhotoList;
    }

    public ArrayList<Integer> getOperations() {
        return this.operations;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }
}
