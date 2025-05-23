package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo;

import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.c;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.g;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.p;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.r;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.u;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class ReqGetSearchResult extends BaseOIDBRequest<p, r> {
    public final a busiSessionInfo;
    public final kuikly.com.tencent.trpcprotocol.search.unifysearch.a channelConditonFilter;
    public final c deviceInfo;
    public final boolean disableCorrectionQuery;
    public final String extension;
    public final g groupConditionFilter;
    public final String keyWord;
    public final String lbs;
    public final a sessionInfo;
    public final UnifySearchTabInfo tab;
    public final String version;

    public /* synthetic */ ReqGetSearchResult(String str, String str2, UnifySearchTabInfo unifySearchTabInfo, a aVar, c cVar, a aVar2, boolean z16, String str3, String str4, kuikly.com.tencent.trpcprotocol.search.unifysearch.a aVar3, g gVar, int i3) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, unifySearchTabInfo, (i3 & 8) != 0 ? new a(new byte[0]) : aVar, (i3 & 16) != 0 ? null : cVar, (i3 & 32) != 0 ? new a(new byte[0]) : aVar2, (i3 & 64) != 0 ? false : z16, (i3 & 128) != 0 ? "" : str3, (i3 & 256) != 0 ? "" : str4, (i3 & 512) != 0 ? null : aVar3, (i3 & 1024) != 0 ? null : gVar);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final r decodeResponse(byte[] bArr) {
        return (r) i.a(r.F, bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return 37029;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbServiceType() {
        return 3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final p getRequest() {
        byte[] encodeToByteArray;
        String str = this.keyWord;
        String str2 = this.version;
        UnifySearchTabInfo unifySearchTabInfo = this.tab;
        u uVar = new u(unifySearchTabInfo.tabName, unifySearchTabInfo.tabMask, 4);
        a aVar = this.sessionInfo;
        a aVar2 = this.busiSessionInfo;
        c cVar = this.deviceInfo;
        boolean z16 = this.disableCorrectionQuery;
        String str3 = this.lbs;
        encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(this.extension);
        a aVar3 = new a(encodeToByteArray);
        kuikly.com.tencent.trpcprotocol.search.unifysearch.a aVar4 = this.channelConditonFilter;
        g gVar = this.groupConditionFilter;
        MapsKt__MapsKt.emptyMap();
        return new p(str, str2, uVar, aVar, false, cVar, gVar, str3, aVar4, aVar2, z16, aVar3);
    }

    public ReqGetSearchResult(String str, String str2, UnifySearchTabInfo unifySearchTabInfo, a aVar, c cVar, a aVar2, boolean z16, String str3, String str4, kuikly.com.tencent.trpcprotocol.search.unifysearch.a aVar3, g gVar) {
        this.keyWord = str;
        this.version = str2;
        this.tab = unifySearchTabInfo;
        this.sessionInfo = aVar;
        this.deviceInfo = cVar;
        this.busiSessionInfo = aVar2;
        this.disableCorrectionQuery = z16;
        this.lbs = str3;
        this.extension = str4;
        this.channelConditonFilter = aVar3;
        this.groupConditionFilter = gVar;
    }
}
