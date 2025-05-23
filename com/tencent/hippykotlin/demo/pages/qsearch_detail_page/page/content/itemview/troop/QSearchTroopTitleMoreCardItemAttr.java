package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchTroopCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemAttr;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchTroopTitleMoreCardItemAttr extends QSearchBaseTitleMoreCardItemAttr {
    public SearchTroopCardItemModel data;

    public final SearchTroopCardItemModel getData() {
        SearchTroopCardItemModel searchTroopCardItemModel = this.data;
        if (searchTroopCardItemModel != null) {
            return searchTroopCardItemModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }
}
