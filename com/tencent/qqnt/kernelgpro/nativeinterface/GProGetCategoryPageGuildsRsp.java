package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetCategoryPageGuildsRsp {
    public ArrayList<GProRecommendCategory> categories;
    public boolean isEnd;
    public ArrayList<GProRecommendItem> items;
    public String traceId;

    public GProGetCategoryPageGuildsRsp() {
        this.categories = new ArrayList<>();
        this.items = new ArrayList<>();
        this.traceId = "";
    }

    public ArrayList<GProRecommendCategory> getCategories() {
        return this.categories;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<GProRecommendItem> getItems() {
        return this.items;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProGetCategoryPageGuildsRsp{categories=" + this.categories + ",items=" + this.items + ",traceId=" + this.traceId + ",isEnd=" + this.isEnd + ",}";
    }

    public GProGetCategoryPageGuildsRsp(ArrayList<GProRecommendCategory> arrayList, ArrayList<GProRecommendItem> arrayList2, String str, boolean z16) {
        this.categories = new ArrayList<>();
        new ArrayList();
        this.categories = arrayList;
        this.items = arrayList2;
        this.traceId = str;
        this.isEnd = z16;
    }
}
