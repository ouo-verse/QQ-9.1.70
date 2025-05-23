package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetHomeHeadRsp {
    public long selectTab;
    public ArrayList<GroupSquareSearchTipsItem> tipsList = new ArrayList<>();
    public ArrayList<GroupSquareBannerItem> banners = new ArrayList<>();
    public ArrayList<GroupSquareTabItem> tabs = new ArrayList<>();

    public ArrayList<GroupSquareBannerItem> getBanners() {
        return this.banners;
    }

    public long getSelectTab() {
        return this.selectTab;
    }

    public ArrayList<GroupSquareTabItem> getTabs() {
        return this.tabs;
    }

    public ArrayList<GroupSquareSearchTipsItem> getTipsList() {
        return this.tipsList;
    }

    public String toString() {
        return "GetHomeHeadRsp{tipsList=" + this.tipsList + ",banners=" + this.banners + ",tabs=" + this.tabs + ",selectTab=" + this.selectTab + ",}";
    }
}
