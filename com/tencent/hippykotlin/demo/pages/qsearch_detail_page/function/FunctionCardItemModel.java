package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.function;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class FunctionCardItemModel implements ISearchItemModel {
    public String cardId = "";
    public String name = "";
    public String iconUrl = "";

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean canPlay() {
        return false;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return this.name.length() > 0;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final void appendFeedPbToken(ArrayList<String> arrayList) {
    }
}
