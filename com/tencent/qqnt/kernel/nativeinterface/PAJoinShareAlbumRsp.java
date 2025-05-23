package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PAJoinShareAlbumRsp {
    public int result;
    public int seq;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public ArrayList<ClientAttr> shareUsers = new ArrayList<>();

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

    public ArrayList<ClientAttr> getShareUsers() {
        return this.shareUsers;
    }

    public String getTraceId() {
        return this.traceId;
    }
}
