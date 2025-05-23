package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistoryViewModel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchHistoryItemAttr extends QSearchBaseSingleItemAttr {
    public String historyWord;
    public QSearchHistoryViewModel viewModel;

    public final String getHistoryWord() {
        String str = this.historyWord;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("historyWord");
        return null;
    }
}
