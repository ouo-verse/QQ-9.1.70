package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class SearchCorrectionQueryCardItemModel implements ISearchItemModel {
    public String keyWord = "";
    public String correctionQuery = "";

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean canPlay() {
        return false;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final boolean isValid() {
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public final void appendFeedPbToken(ArrayList<String> arrayList) {
    }
}
