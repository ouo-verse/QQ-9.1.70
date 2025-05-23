package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetMultiChannelFeedsRsp {
    public boolean isEnd;
    public ArrayList<GProStFeed> vecFeedList = new ArrayList<>();
    public String feedAttachInfo = "";

    public String getFeedAttachInfo() {
        return this.feedAttachInfo;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<GProStFeed> getVecFeedList() {
        return this.vecFeedList;
    }

    public String toString() {
        return "GProGetMultiChannelFeedsRsp{vecFeedList=" + this.vecFeedList + ",isEnd=" + this.isEnd + ",feedAttachInfo=" + this.feedAttachInfo + ",}";
    }
}
