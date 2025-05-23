package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PAAddAlbumPermissionsRsp {
    public int result;
    public int seq;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public ArrayList<AddAlbumPermissionsResultEntry> resultEntryList = new ArrayList<>();

    public String getErrMs() {
        return this.errMs;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getResult() {
        return this.result;
    }

    public ArrayList<AddAlbumPermissionsResultEntry> getResultEntryList() {
        return this.resultEntryList;
    }

    public int getSeq() {
        return this.seq;
    }

    public String getTraceId() {
        return this.traceId;
    }
}
