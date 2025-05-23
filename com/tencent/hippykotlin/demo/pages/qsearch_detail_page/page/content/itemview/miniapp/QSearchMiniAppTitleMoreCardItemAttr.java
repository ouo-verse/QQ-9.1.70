package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.miniapp;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.miniapp.SearchMiniAppCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemAttr;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchMiniAppTitleMoreCardItemAttr extends QSearchBaseTitleMoreCardItemAttr {
    public SearchMiniAppCardItemModel data;

    public final SearchMiniAppCardItemModel getData() {
        SearchMiniAppCardItemModel searchMiniAppCardItemModel = this.data;
        if (searchMiniAppCardItemModel != null) {
            return searchMiniAppCardItemModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }
}
