package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetProfileFeedsRsp {
    public int count;
    public int isFinish;
    public ArrayList<GProStFeed> vecFeedList = new ArrayList<>();
    public GProStUser user = new GProStUser();
    public String feedAttchInfo = "";
    public String strCount = "";

    public int getCount() {
        return this.count;
    }

    public String getFeedAttchInfo() {
        return this.feedAttchInfo;
    }

    public int getIsFinish() {
        return this.isFinish;
    }

    public String getStrCount() {
        return this.strCount;
    }

    public GProStUser getUser() {
        return this.user;
    }

    public ArrayList<GProStFeed> getVecFeedList() {
        return this.vecFeedList;
    }

    public String toString() {
        return "GProGetProfileFeedsRsp{vecFeedList=" + this.vecFeedList + ",isFinish=" + this.isFinish + ",user=" + this.user + ",feedAttchInfo=" + this.feedAttchInfo + ",count=" + this.count + ",strCount=" + this.strCount + ",}";
    }
}
