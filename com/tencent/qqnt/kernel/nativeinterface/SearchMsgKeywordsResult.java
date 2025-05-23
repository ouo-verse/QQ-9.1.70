package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchMsgKeywordsResult implements IKernelModel {
    public boolean hasMore;
    public ArrayList<SearchMsgItem> resultItems;
    public int searchId;

    public SearchMsgKeywordsResult() {
        this.resultItems = new ArrayList<>();
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public ArrayList<SearchMsgItem> getResultItems() {
        return this.resultItems;
    }

    public int getSearchId() {
        return this.searchId;
    }

    public String toString() {
        return "SearchMsgKeywordsResult{searchId=" + this.searchId + ",hasMore=" + this.hasMore + ",resultItems=" + this.resultItems + ",}";
    }

    public SearchMsgKeywordsResult(int i3, boolean z16, ArrayList<SearchMsgItem> arrayList) {
        new ArrayList();
        this.searchId = i3;
        this.hasMore = z16;
        this.resultItems = arrayList;
    }
}
