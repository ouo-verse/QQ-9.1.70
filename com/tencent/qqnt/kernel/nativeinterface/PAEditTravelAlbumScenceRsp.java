package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PAEditTravelAlbumScenceRsp {
    public int result;
    public int seq;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public ArrayList<EditTravelAlbumScenceResult> editScenceResults = new ArrayList<>();
    public ArrayList<EditMediaResult> editPhotoResults = new ArrayList<>();

    public ArrayList<EditMediaResult> getEditPhotoResults() {
        return this.editPhotoResults;
    }

    public ArrayList<EditTravelAlbumScenceResult> getEditScenceResults() {
        return this.editScenceResults;
    }

    public String getErrMs() {
        return this.errMs;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getResult() {
        return this.result;
    }

    public int getSeq() {
        return this.seq;
    }

    public String getTraceId() {
        return this.traceId;
    }
}
