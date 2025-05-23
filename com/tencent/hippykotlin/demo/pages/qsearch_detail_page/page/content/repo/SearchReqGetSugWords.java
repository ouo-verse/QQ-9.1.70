package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo;

import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.m;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.n;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.u;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class SearchReqGetSugWords extends BaseOIDBRequest<m, n> {
    public final String extension;
    public final String keyWord;
    public final UnifySearchTabInfo tab;

    public SearchReqGetSugWords(String str, UnifySearchTabInfo unifySearchTabInfo, String str2) {
        this.keyWord = str;
        this.tab = unifySearchTabInfo;
        this.extension = str2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final n decodeResponse(byte[] bArr) {
        return (n) i.a(n.f413228f, bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return 37269;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbServiceType() {
        return 1;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final m getRequest() {
        byte[] encodeToByteArray;
        UnifySearchTabInfo unifySearchTabInfo = this.tab;
        u uVar = unifySearchTabInfo != null ? new u(unifySearchTabInfo.tabName, unifySearchTabInfo.tabMask, 4) : null;
        String str = this.keyWord;
        encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(this.extension);
        a aVar = new a(encodeToByteArray);
        MapsKt__MapsKt.emptyMap();
        return new m(str, 1, uVar, aVar);
    }
}
