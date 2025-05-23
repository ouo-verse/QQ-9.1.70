package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class DoubleVideoItemModel extends BaseSearchItemModel {
    public List<StFeedEx> dataList = new ArrayList();

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final void appendFeedPbToken(ArrayList<String> arrayList) {
        Iterator it = this.dataList.iterator();
        while (it.hasNext()) {
            arrayList.add(((StFeedEx) it.next()).feedPbToken);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean canPlay() {
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return !this.dataList.isEmpty();
    }
}
