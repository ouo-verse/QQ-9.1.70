package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.contact;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemAttr;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ContactSingleItemAttr extends QSearchBaseSingleItemAttr {
    public SearchContactItemModel data;

    public final SearchContactItemModel getData() {
        SearchContactItemModel searchContactItemModel = this.data;
        if (searchContactItemModel != null) {
            return searchContactItemModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }
}
