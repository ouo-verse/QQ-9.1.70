package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsSearchSuggestionsLayoutContent {
    public ArrayList<UfsSearchSuggestItem> searchSuggestList = new ArrayList<>();

    public ArrayList<UfsSearchSuggestItem> getSearchSuggestList() {
        return this.searchSuggestList;
    }

    public String toString() {
        return "UfsSearchSuggestionsLayoutContent{searchSuggestList=" + this.searchSuggestList + ",}";
    }
}
