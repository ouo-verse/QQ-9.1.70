package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PASendAlbumInvitationReq {
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public ArrayList<StUser> receivers = new ArrayList<>();
    public ArrayList<String> groupList = new ArrayList<>();
    public String albumId = "";
    public StUser albumOwner = new StUser();

    public String getAlbumId() {
        return this.albumId;
    }

    public StUser getAlbumOwner() {
        return this.albumOwner;
    }

    public ArrayList<String> getGroupList() {
        return this.groupList;
    }

    public ArrayList<StUser> getReceivers() {
        return this.receivers;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }
}
