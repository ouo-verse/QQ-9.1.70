package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProTopRecommendInfo implements Serializable {
    public String categoryName;
    public ArrayList<Long> recommendedGuildList;
    long serialVersionUID;

    public GProTopRecommendInfo() {
        this.serialVersionUID = 1L;
        this.categoryName = "";
        this.recommendedGuildList = new ArrayList<>();
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public ArrayList<Long> getRecommendedGuildList() {
        return this.recommendedGuildList;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setRecommendedGuildList(ArrayList<Long> arrayList) {
        this.recommendedGuildList = arrayList;
    }

    public String toString() {
        return "GProTopRecommendInfo{categoryName=" + this.categoryName + ",recommendedGuildList=" + this.recommendedGuildList + ",}";
    }

    public GProTopRecommendInfo(String str, ArrayList<Long> arrayList) {
        this.serialVersionUID = 1L;
        this.categoryName = "";
        new ArrayList();
        this.categoryName = str;
        this.recommendedGuildList = arrayList;
    }
}
