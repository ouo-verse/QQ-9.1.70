package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class SearchMiniAppCardItemModel extends BaseSearchItemModel {
    public final List<SearchMiniAppItemModel> miniAppList = new ArrayList();

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppItemModel>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return (this.miniAppList.isEmpty() ^ true) && Utils.INSTANCE.currentBridgeModule().canOpenMiniApp();
    }
}
