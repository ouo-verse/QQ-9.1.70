package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchAppendingInfo {
    public SearchTabContent tabContent = new SearchTabContent();
    public String docId = "";

    public String getDocId() {
        return this.docId;
    }

    public SearchTabContent getTabContent() {
        return this.tabContent;
    }

    public String toString() {
        return "SearchAppendingInfo{tabContent=" + this.tabContent + ",docId=" + this.docId + ",}";
    }
}
