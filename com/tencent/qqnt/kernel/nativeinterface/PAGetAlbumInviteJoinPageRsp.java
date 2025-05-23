package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAGetAlbumInviteJoinPageRsp {
    public int inviteStatus;
    public int loginUserStatus;
    public int result;
    public int seq;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public StUser inviter = new StUser();
    public AlbumInfo album = new AlbumInfo();
    public StUser invitee = new StUser();
    public String entranceAlbumId = "";
    public StUser entranceAlbumOwner = new StUser();

    public AlbumInfo getAlbum() {
        return this.album;
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

    public int getInviteStatus() {
        return this.inviteStatus;
    }

    public StUser getInvitee() {
        return this.invitee;
    }

    public StUser getInviter() {
        return this.inviter;
    }

    public int getLoginUserStatus() {
        return this.loginUserStatus;
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
