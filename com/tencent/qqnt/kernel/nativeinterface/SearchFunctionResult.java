package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchFunctionResult {
    public boolean hasMore;
    public ArrayList<SearchFunctionItem> resultItems = new ArrayList<>();
    public int searchId;

    public boolean getHasMore() {
        return this.hasMore;
    }

    public ArrayList<SearchFunctionItem> getResultItems() {
        return this.resultItems;
    }

    public int getSearchId() {
        return this.searchId;
    }

    public String toString() {
        return "SearchFunctionResult{searchId=" + this.searchId + ",hasMore=" + this.hasMore + ",resultItems=" + this.resultItems + ",}";
    }
}
