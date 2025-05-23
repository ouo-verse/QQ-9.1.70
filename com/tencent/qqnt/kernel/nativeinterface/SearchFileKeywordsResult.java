package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchFileKeywordsResult {
    public boolean hasMore;
    public ArrayList<SearchFileItem> resultItems;
    public int searchId;

    public SearchFileKeywordsResult() {
        this.resultItems = new ArrayList<>();
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public ArrayList<SearchFileItem> getResultItems() {
        return this.resultItems;
    }

    public int getSearchId() {
        return this.searchId;
    }

    public String toString() {
        return "SearchFileKeywordsResult{searchId=" + this.searchId + ",hasMore=" + this.hasMore + ",resultItems=" + this.resultItems + ",}";
    }

    public SearchFileKeywordsResult(int i3, boolean z16, ArrayList<SearchFileItem> arrayList) {
        new ArrayList();
        this.searchId = i3;
        this.hasMore = z16;
        this.resultItems = arrayList;
    }
}
