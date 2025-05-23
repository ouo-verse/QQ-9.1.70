package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProFeedLikeUserListReq {
    public long guildId;
    public int pageLimit;
    public String feedId = "";
    public String attachInfo = "";
    public ArrayList<GProLikeUserInfo> needInsertList = new ArrayList<>();

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<GProLikeUserInfo> getNeedInsertList() {
        return this.needInsertList;
    }

    public int getPageLimit() {
        return this.pageLimit;
    }

    public String toString() {
        return "GProFeedLikeUserListReq{feedId=" + this.feedId + ",attachInfo=" + this.attachInfo + ",pageLimit=" + this.pageLimit + ",guildId=" + this.guildId + ",needInsertList=" + this.needInsertList + ",}";
    }
}
