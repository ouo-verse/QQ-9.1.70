package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PAAddAlbumPermissionsReq {
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String albumId = "";
    public ArrayList<StUser> addUsers = new ArrayList<>();
    public StUser albumOwner = new StUser();

    public ArrayList<StUser> getAddUsers() {
        return this.addUsers;
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public StUser getAlbumOwner() {
        return this.albumOwner;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }
}
