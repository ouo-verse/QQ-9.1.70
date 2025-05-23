package com.tencent.hippykotlin.demo.pages.nearby.aio.repository;

import com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest;
import com.tencent.mobileqq.msf.core.c0.g;
import kotlin.collections.MapsKt__MapsKt;
import kuikly.trpc.relation.blacklist.a;
import kuikly.trpc.relation.blacklist.f;
import kuikly.trpc.relation.blacklist.h;
import kuikly.trpc.relation.blacklist.i;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetUnblockRequest extends BaseOIDBRequest<h, i> {
    public final String tid;

    public GetUnblockRequest(String str) {
        this.tid = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final i decodeResponse(byte[] bArr) {
        return (i) c45.i.a(i.f413297h, bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return g.P1;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbServiceType() {
        return 0;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final h getRequest() {
        a aVar = new a(6, new kuikly.trpc.relation.blacklist.g(Long.parseLong(this.tid), 1600001631L, 4), 94);
        f fVar = new f("GeneralExtend", "1_174", 4);
        MapsKt__MapsKt.emptyMap();
        return new h(aVar, fVar);
    }
}
