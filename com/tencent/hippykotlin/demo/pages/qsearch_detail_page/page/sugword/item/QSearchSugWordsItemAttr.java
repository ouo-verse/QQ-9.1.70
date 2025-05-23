package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.item;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemAttr;
import kotlin.jvm.internal.Intrinsics;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.l;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchSugWordsItemAttr extends QSearchBaseSingleItemAttr {
    public l sugWordInfo;

    public final l getSugWordInfo() {
        l lVar = this.sugWordInfo;
        if (lVar != null) {
            return lVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sugWordInfo");
        return null;
    }
}
