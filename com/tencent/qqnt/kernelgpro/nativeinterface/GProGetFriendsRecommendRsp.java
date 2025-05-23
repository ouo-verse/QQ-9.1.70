package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetFriendsRecommendRsp implements Serializable {
    public int friendType;
    public boolean isEnd;
    long serialVersionUID = 1;
    public ArrayList<GProRecommendContentItem> recommendList = new ArrayList<>();
    public GProMVPExtInfo extInfo = new GProMVPExtInfo();

    public GProMVPExtInfo getExtInfo() {
        return this.extInfo;
    }

    public int getFriendType() {
        return this.friendType;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<GProRecommendContentItem> getRecommendList() {
        return this.recommendList;
    }

    public String toString() {
        return "GProGetFriendsRecommendRsp{recommendList=" + this.recommendList + ",friendType=" + this.friendType + ",isEnd=" + this.isEnd + ",extInfo=" + this.extInfo + ",}";
    }
}
