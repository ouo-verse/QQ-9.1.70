package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PAGetAlbumMemberListRsp {
    public int result;
    public int seq;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public AlbumInfo album = new AlbumInfo();
    public ArrayList<ClientAttr> sharers = new ArrayList<>();

    public AlbumInfo getAlbum() {
        return this.album;
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

    public ArrayList<ClientAttr> getSharers() {
        return this.sharers;
    }

    public String getTraceId() {
        return this.traceId;
    }
}
