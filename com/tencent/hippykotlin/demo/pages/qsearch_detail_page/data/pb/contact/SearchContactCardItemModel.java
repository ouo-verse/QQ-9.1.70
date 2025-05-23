package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.BaseSearchItemModel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class SearchContactCardItemModel extends BaseSearchItemModel {
    public final List<SearchContactItemModel> contactList = new ArrayList();

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.contact.SearchContactItemModel>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return !this.contactList.isEmpty();
    }
}
