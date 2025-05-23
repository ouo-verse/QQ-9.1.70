package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PARespondToJoinRequestReq {
    public int action;
    public int joinSource;
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String albumId = "";
    public ArrayList<StUser> pendingUsers = new ArrayList<>();
    public StUser albumOwner = new StUser();

    public int getAction() {
        return this.action;
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public StUser getAlbumOwner() {
        return this.albumOwner;
    }

    public int getJoinSource() {
        return this.joinSource;
    }

    public ArrayList<StUser> getPendingUsers() {
        return this.pendingUsers;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }
}
