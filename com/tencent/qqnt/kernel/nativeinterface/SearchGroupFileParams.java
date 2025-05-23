package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class SearchGroupFileParams {
    public String context;
    public int count;
    public ArrayList<Long> groupIds;
    public ArrayList<String> groupNames;
    public SearchGroupFileSortType sortType;

    public SearchGroupFileParams() {
        this.groupIds = new ArrayList<>();
        this.groupNames = new ArrayList<>();
        this.sortType = SearchGroupFileSortType.values()[0];
        this.context = "";
    }

    public String getContext() {
        return this.context;
    }

    public int getCount() {
        return this.count;
    }

    public ArrayList<Long> getGroupIds() {
        return this.groupIds;
    }

    public ArrayList<String> getGroupNames() {
        return this.groupNames;
    }

    public SearchGroupFileSortType getSortType() {
        return this.sortType;
    }

    public SearchGroupFileParams(ArrayList<Long> arrayList, ArrayList<String> arrayList2, SearchGroupFileSortType searchGroupFileSortType, String str, int i3) {
        this.groupIds = new ArrayList<>();
        this.groupNames = new ArrayList<>();
        SearchGroupFileSortType searchGroupFileSortType2 = SearchGroupFileSortType.values()[0];
        this.groupIds = arrayList;
        this.groupNames = arrayList2;
        this.sortType = searchGroupFileSortType;
        this.context = str;
        this.count = i3;
    }
}
