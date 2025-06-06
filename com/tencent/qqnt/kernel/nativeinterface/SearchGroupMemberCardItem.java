package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchGroupMemberCardItem {
    public String uid = "";
    public String cardName = "";
    public ArrayList<SearchHitInfo> cardNameHits = new ArrayList<>();

    public String getCardName() {
        return this.cardName;
    }

    public ArrayList<SearchHitInfo> getCardNameHits() {
        return this.cardNameHits;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "SearchGroupMemberCardItem{uid=" + this.uid + ",cardName=" + this.cardName + ",cardNameHits=" + this.cardNameHits + ",}";
    }
}
