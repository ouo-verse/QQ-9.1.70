package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchAppendingItem {
    public String cardInfoId = "";
    public String docId = "";
    public int itemType;

    public String getCardInfoId() {
        return this.cardInfoId;
    }

    public String getDocId() {
        return this.docId;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String toString() {
        return "SearchAppendingItem{cardInfoId=" + this.cardInfoId + ",itemType=" + this.itemType + ",docId=" + this.docId + ",}";
    }
}
