package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StFeedCellSummary {
    public boolean hasMore;
    public ArrayList<StRichMsg> summary = new ArrayList<>();

    public boolean getHasMore() {
        return this.hasMore;
    }

    public ArrayList<StRichMsg> getSummary() {
        return this.summary;
    }

    public void setHasMore(boolean z16) {
        this.hasMore = z16;
    }

    public void setSummary(ArrayList<StRichMsg> arrayList) {
        this.summary = arrayList;
    }
}
