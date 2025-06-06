package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchDiscussInfoItem {
    public long discussCode;
    public String discussName = "";
    public ArrayList<SearchHitInfo> discussNameHits = new ArrayList<>();

    public long getDiscussCode() {
        return this.discussCode;
    }

    public String getDiscussName() {
        return this.discussName;
    }

    public ArrayList<SearchHitInfo> getDiscussNameHits() {
        return this.discussNameHits;
    }

    public String toString() {
        return "SearchDiscussInfoItem{discussCode=" + this.discussCode + ",discussName=" + this.discussName + ",discussNameHits=" + this.discussNameHits + ",}";
    }
}
