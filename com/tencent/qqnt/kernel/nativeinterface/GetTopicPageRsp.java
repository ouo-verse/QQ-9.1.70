package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GetTopicPageRsp {
    public boolean isEnd;
    public GroupSquareBannerItem bannerInfo = new GroupSquareBannerItem();
    public ArrayList<GroupSquareGroupInfoItem> groupList = new ArrayList<>();
    public String cookies = "";

    public GroupSquareBannerItem getBannerInfo() {
        return this.bannerInfo;
    }

    public String getCookies() {
        return this.cookies;
    }

    public ArrayList<GroupSquareGroupInfoItem> getGroupList() {
        return this.groupList;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public String toString() {
        return "GetTopicPageRsp{bannerInfo=" + this.bannerInfo + ",groupList=" + this.groupList + ",cookies=" + this.cookies + ",isEnd=" + this.isEnd + ",}";
    }
}
