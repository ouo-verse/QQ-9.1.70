package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.expression;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ExpressionItemModel implements ISearchItemModel {
    public List<ExpressionInfo> itemList = new ArrayList();

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean canPlay() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return !this.itemList.isEmpty();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final void appendFeedPbToken(ArrayList<String> arrayList) {
    }
}
