package com.tencent.hippykotlin.demo.pages.nearby.aio.repository;

import c45.i;
import com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest;
import com.tencent.mobileqq.msf.core.c0.g;
import kotlin.collections.MapsKt__MapsKt;
import kuikly.trpc.relation.blacklist.a;
import kuikly.trpc.relation.blacklist.b;
import kuikly.trpc.relation.blacklist.c;
import kuikly.trpc.relation.blacklist.f;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetBlockRequest extends BaseOIDBRequest<b, c> {
    public final String tid;

    public GetBlockRequest(String str) {
        this.tid = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final c decodeResponse(byte[] bArr) {
        return (c) i.a(c.f413275h, bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return g.O1;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbServiceType() {
        return 0;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final b getRequest() {
        a aVar = new a(6, new kuikly.trpc.relation.blacklist.g(Long.parseLong(this.tid), 1600001631L, 4), 94);
        f fVar = new f("GeneralExtend", "1_174", 4);
        MapsKt__MapsKt.emptyMap();
        return new b(aVar, 0L, fVar);
    }
}
