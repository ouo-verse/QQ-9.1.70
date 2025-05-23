package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemAttr;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class MiniAppSingleItemAttr extends QSearchBaseSingleItemAttr {
    public SearchMiniAppItemModel data;

    public final SearchMiniAppItemModel getData() {
        SearchMiniAppItemModel searchMiniAppItemModel = this.data;
        if (searchMiniAppItemModel != null) {
            return searchMiniAppItemModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }
}
