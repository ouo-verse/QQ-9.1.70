package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.expression;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ExpressionItemsModel implements ISearchItemModel {
    public List<ExpressionInfo> itemList = new ArrayList();

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean canPlay() {
        return false;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final void appendFeedPbToken(ArrayList<String> arrayList) {
    }
}
