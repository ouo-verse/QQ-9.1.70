package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class SearchGuildDoubleItemModel implements ISearchItemModel {
    public final List<SearchGuildBaseItemModel> modelList = new ArrayList();
    public int type;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final void appendFeedPbToken(ArrayList<String> arrayList) {
        Iterator it = this.modelList.iterator();
        while (it.hasNext()) {
            ((SearchGuildBaseItemModel) it.next()).appendFeedPbToken(arrayList);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean canPlay() {
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return true;
    }
}
