package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactCardItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemAttr;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchContactTitleMoreCardItemAttr extends QSearchBaseTitleMoreCardItemAttr {
    public SearchContactCardItemModel data;

    public final SearchContactCardItemModel getData() {
        SearchContactCardItemModel searchContactCardItemModel = this.data;
        if (searchContactCardItemModel != null) {
            return searchContactCardItemModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }
}
