package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetCategoryPageGuildsReq {
    public GProRecommendCategory category;
    public ArrayList<GProItemIdInfo> itemList;
    public int refreshNum;
    public GProBottomTabSourceInfo source;

    public GProGetCategoryPageGuildsReq() {
        this.category = new GProRecommendCategory();
        this.source = new GProBottomTabSourceInfo();
        this.itemList = new ArrayList<>();
    }

    public GProRecommendCategory getCategory() {
        return this.category;
    }

    public ArrayList<GProItemIdInfo> getItemList() {
        return this.itemList;
    }

    public int getRefreshNum() {
        return this.refreshNum;
    }

    public GProBottomTabSourceInfo getSource() {
        return this.source;
    }

    public void setCategory(GProRecommendCategory gProRecommendCategory) {
        this.category = gProRecommendCategory;
    }

    public void setItemList(ArrayList<GProItemIdInfo> arrayList) {
        this.itemList = arrayList;
    }

    public void setRefreshNum(int i3) {
        this.refreshNum = i3;
    }

    public void setSource(GProBottomTabSourceInfo gProBottomTabSourceInfo) {
        this.source = gProBottomTabSourceInfo;
    }

    public String toString() {
        return "GProGetCategoryPageGuildsReq{category=" + this.category + ",source=" + this.source + ",refreshNum=" + this.refreshNum + ",itemList=" + this.itemList + ",}";
    }

    public GProGetCategoryPageGuildsReq(GProRecommendCategory gProRecommendCategory, GProBottomTabSourceInfo gProBottomTabSourceInfo, int i3, ArrayList<GProItemIdInfo> arrayList) {
        this.category = new GProRecommendCategory();
        this.source = new GProBottomTabSourceInfo();
        new ArrayList();
        this.category = gProRecommendCategory;
        this.source = gProBottomTabSourceInfo;
        this.refreshNum = i3;
        this.itemList = arrayList;
    }
}
