package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.repo;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchNetSugWordsRsp;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.n;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class NetSugWordsRspWrapper {
    public final UnifySearchNetSugWordsRsp msfRsp;
    public final n oidbRsp;

    public NetSugWordsRspWrapper(n nVar, UnifySearchNetSugWordsRsp unifySearchNetSugWordsRsp) {
        this.oidbRsp = nVar;
        this.msfRsp = unifySearchNetSugWordsRsp;
    }
}
