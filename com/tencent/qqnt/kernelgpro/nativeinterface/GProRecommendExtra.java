package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendExtra implements Serializable {
    public ArrayList<GProRecommendEntry> bizData;
    public GProItemCbData callback;
    public ArrayList<GProRecommendEntry> reports;
    long serialVersionUID;
    public ArrayList<GProRecommendTag> tags;

    public GProRecommendExtra() {
        this.serialVersionUID = 1L;
        this.tags = new ArrayList<>();
        this.reports = new ArrayList<>();
        this.bizData = new ArrayList<>();
        this.callback = new GProItemCbData();
    }

    public ArrayList<GProRecommendEntry> getBizData() {
        return this.bizData;
    }

    public GProItemCbData getCallback() {
        return this.callback;
    }

    public ArrayList<GProRecommendEntry> getReports() {
        return this.reports;
    }

    public ArrayList<GProRecommendTag> getTags() {
        return this.tags;
    }

    public String toString() {
        return "GProRecommendExtra{tags=" + this.tags + ",reports=" + this.reports + ",bizData=" + this.bizData + ",callback=" + this.callback + ",}";
    }

    public GProRecommendExtra(ArrayList<GProRecommendTag> arrayList, ArrayList<GProRecommendEntry> arrayList2, ArrayList<GProRecommendEntry> arrayList3, GProItemCbData gProItemCbData) {
        this.serialVersionUID = 1L;
        this.tags = new ArrayList<>();
        this.reports = new ArrayList<>();
        this.bizData = new ArrayList<>();
        new GProItemCbData();
        this.tags = arrayList;
        this.reports = arrayList2;
        this.bizData = arrayList3;
        this.callback = gProItemCbData;
    }
}
