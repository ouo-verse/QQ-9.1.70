package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetRecommendQuickJoinRsp {
    public ArrayList<GProRecommendQuickJoinItem> recommendQuickJoinItems;

    public GProGetRecommendQuickJoinRsp() {
        this.recommendQuickJoinItems = new ArrayList<>();
    }

    public ArrayList<GProRecommendQuickJoinItem> getRecommendQuickJoinItems() {
        return this.recommendQuickJoinItems;
    }

    public String toString() {
        return "GProGetRecommendQuickJoinRsp{recommendQuickJoinItems=" + this.recommendQuickJoinItems + ",}";
    }

    public GProGetRecommendQuickJoinRsp(ArrayList<GProRecommendQuickJoinItem> arrayList) {
        new ArrayList();
        this.recommendQuickJoinItems = arrayList;
    }
}
