package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchResultGroup {
    public long groupMask;
    public String groupName;
    public ArrayList<String> highlightWords;
    public String moreName;
    public String moreUrl;
    public ArrayList<SearchResultItem> resultItem;
    public int totalCount;

    public SearchResultGroup() {
        this.resultItem = new ArrayList<>();
        this.groupName = "";
        this.moreUrl = "";
        this.moreName = "";
        this.highlightWords = new ArrayList<>();
    }

    public long getGroupMask() {
        return this.groupMask;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public ArrayList<String> getHighlightWords() {
        return this.highlightWords;
    }

    public String getMoreName() {
        return this.moreName;
    }

    public String getMoreUrl() {
        return this.moreUrl;
    }

    public ArrayList<SearchResultItem> getResultItem() {
        return this.resultItem;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public String toString() {
        return "SearchResultGroup{groupMask=" + this.groupMask + ",resultItem=" + this.resultItem + ",groupName=" + this.groupName + ",totalCount=" + this.totalCount + ",moreUrl=" + this.moreUrl + ",moreName=" + this.moreName + ",highlightWords=" + this.highlightWords + ",}";
    }

    public SearchResultGroup(long j3, ArrayList<SearchResultItem> arrayList, String str, int i3, String str2, String str3, ArrayList<String> arrayList2) {
        this.resultItem = new ArrayList<>();
        this.groupName = "";
        this.moreUrl = "";
        this.moreName = "";
        new ArrayList();
        this.groupMask = j3;
        this.resultItem = arrayList;
        this.groupName = str;
        this.totalCount = i3;
        this.moreUrl = str2;
        this.moreName = str3;
        this.highlightWords = arrayList2;
    }
}
