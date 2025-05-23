package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProFeedLikeUserListRsp {
    public boolean hasMore;
    public long totalLikeCnt;
    public ArrayList<GProLikeUserInfo> userList = new ArrayList<>();
    public String attachInfo = "";

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public long getTotalLikeCnt() {
        return this.totalLikeCnt;
    }

    public ArrayList<GProLikeUserInfo> getUserList() {
        return this.userList;
    }

    public String toString() {
        return "GProFeedLikeUserListRsp{userList=" + this.userList + ",attachInfo=" + this.attachInfo + ",hasMore=" + this.hasMore + ",totalLikeCnt=" + this.totalLikeCnt + ",}";
    }
}
