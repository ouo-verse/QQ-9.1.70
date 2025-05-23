package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchNetResultTabsRsp;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.k;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class NetReqTabRsp {
    public final UnifySearchNetResultTabsRsp msfRsp;
    public final k oidbRsp;

    public NetReqTabRsp(k kVar, UnifySearchNetResultTabsRsp unifySearchNetResultTabsRsp) {
        this.oidbRsp = kVar;
        this.msfRsp = unifySearchNetResultTabsRsp;
    }
}
