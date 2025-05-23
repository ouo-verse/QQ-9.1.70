package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PARemoveAlbumMemberReq {
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String albumId = "";
    public ClientAttr removeUser = new ClientAttr();

    public String getAlbumId() {
        return this.albumId;
    }

    public ClientAttr getRemoveUser() {
        return this.removeUser;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }
}
