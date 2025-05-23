package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTroopTabContentViewModel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class TroopSingleItemAttr extends QSearchBaseSingleItemAttr {
    public SearchTroopItemModel data;
    public QSearchTroopTabContentViewModel viewModel;

    public final SearchTroopItemModel getData() {
        SearchTroopItemModel searchTroopItemModel = this.data;
        if (searchTroopItemModel != null) {
            return searchTroopItemModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }
}
