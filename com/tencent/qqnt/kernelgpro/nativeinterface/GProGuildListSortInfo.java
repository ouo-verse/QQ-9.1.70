package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildListSortInfo {
    public ArrayList<Long> sortList;
    public ArrayList<Long> topList;

    public GProGuildListSortInfo() {
        this.sortList = new ArrayList<>();
        this.topList = new ArrayList<>();
    }

    public ArrayList<Long> getSortList() {
        return this.sortList;
    }

    public ArrayList<Long> getTopList() {
        return this.topList;
    }

    public String toString() {
        return "GProGuildListSortInfo{sortList=" + this.sortList + ",topList=" + this.topList + ",}";
    }

    public GProGuildListSortInfo(ArrayList<Long> arrayList, ArrayList<Long> arrayList2) {
        this.sortList = new ArrayList<>();
        new ArrayList();
        this.sortList = arrayList;
        this.topList = arrayList2;
    }
}
