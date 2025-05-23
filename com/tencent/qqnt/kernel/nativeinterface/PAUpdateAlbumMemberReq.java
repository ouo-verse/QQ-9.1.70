package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAUpdateAlbumMemberReq {
    public int seq;
    public int updateDesc;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String albumId = "";
    public ClientAttr changeUser = new ClientAttr();
    public StUser albumOwner = new StUser();

    public String getAlbumId() {
        return this.albumId;
    }

    public StUser getAlbumOwner() {
        return this.albumOwner;
    }

    public ClientAttr getChangeUser() {
        return this.changeUser;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }

    public int getUpdateDesc() {
        return this.updateDesc;
    }
}
