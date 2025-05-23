package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStUserRecomInfo {
    public GProStUser user = new GProStUser();
    public ArrayList<GProStFeedAbstract> feedListList = new ArrayList<>();
    public byte[] busiData = new byte[0];

    public byte[] getBusiData() {
        return this.busiData;
    }

    public ArrayList<GProStFeedAbstract> getFeedListList() {
        return this.feedListList;
    }

    public GProStUser getUser() {
        return this.user;
    }

    public String toString() {
        return "GProStUserRecomInfo{user=" + this.user + ",feedListList=" + this.feedListList + ",busiData=" + this.busiData + ",}";
    }
}
