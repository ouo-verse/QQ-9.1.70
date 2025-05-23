package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo;

import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest;
import kotlin.collections.MapsKt__MapsKt;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.c;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.j;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.k;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class SearchReqGetTabs extends BaseOIDBRequest<j, k> {
    public final c deviceInfo;
    public final a extension;
    public final String version;

    public SearchReqGetTabs(String str, c cVar, a aVar) {
        this.version = str;
        this.deviceInfo = cVar;
        this.extension = aVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final k decodeResponse(byte[] bArr) {
        return (k) i.a(k.f413213m, bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return 37270;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbServiceType() {
        return 1;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final j getRequest() {
        String str = this.version;
        c cVar = this.deviceInfo;
        a aVar = this.extension;
        MapsKt__MapsKt.emptyMap();
        return new j(str, cVar, aVar);
    }
}
