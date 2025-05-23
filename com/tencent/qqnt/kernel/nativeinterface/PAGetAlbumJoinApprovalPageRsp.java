package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAGetAlbumJoinApprovalPageRsp {
    public int approvalStatus;
    public int loginUserStatus;
    public int result;
    public int seq;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public StUser pendingUser = new StUser();
    public AlbumInfo album = new AlbumInfo();
    public String entranceAlbumId = "";
    public StUser entranceAlbumOwner = new StUser();

    public AlbumInfo getAlbum() {
        return this.album;
    }

    public int getApprovalStatus() {
        return this.approvalStatus;
    }

    public String getEntranceAlbumId() {
        return this.entranceAlbumId;
    }

    public StUser getEntranceAlbumOwner() {
        return this.entranceAlbumOwner;
    }

    public String getErrMs() {
        return this.errMs;
    }

    public int getLoginUserStatus() {
        return this.loginUserStatus;
    }

    public StUser getPendingUser() {
        return this.pendingUser;
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
