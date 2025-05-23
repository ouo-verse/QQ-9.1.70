package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchAtMeChatsResult {
    public boolean hasMore;
    public ArrayList<SearchAtMeChatItem> resultItems;
    public int searchId;

    public SearchAtMeChatsResult() {
        this.resultItems = new ArrayList<>();
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public ArrayList<SearchAtMeChatItem> getResultItems() {
        return this.resultItems;
    }

    public int getSearchId() {
        return this.searchId;
    }

    public String toString() {
        return "SearchAtMeChatsResult{searchId=" + this.searchId + ",hasMore=" + this.hasMore + ",resultItems=" + this.resultItems + ",}";
    }

    public SearchAtMeChatsResult(int i3, boolean z16, ArrayList<SearchAtMeChatItem> arrayList) {
        new ArrayList();
        this.searchId = i3;
        this.hasMore = z16;
        this.resultItems = arrayList;
    }
}
