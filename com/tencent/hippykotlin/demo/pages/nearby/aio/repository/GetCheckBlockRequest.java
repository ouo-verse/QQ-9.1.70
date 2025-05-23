package com.tencent.hippykotlin.demo.pages.nearby.aio.repository;

import c45.i;
import com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest;
import com.tencent.mobileqq.msf.core.c0.g;
import kotlin.collections.MapsKt__MapsKt;
import kuikly.trpc.relation.blacklist.a;
import kuikly.trpc.relation.blacklist.d;
import kuikly.trpc.relation.blacklist.e;
import kuikly.trpc.relation.blacklist.f;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetCheckBlockRequest extends BaseOIDBRequest<d, e> {
    public final String tid;

    public GetCheckBlockRequest(String str) {
        this.tid = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final e decodeResponse(byte[] bArr) {
        return (e) i.a(e.f413284h, bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return g.Q1;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbServiceType() {
        return 0;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final d getRequest() {
        a aVar = new a(6, new kuikly.trpc.relation.blacklist.g(Long.parseLong(this.tid), 1600001631L, 4), 94);
        f fVar = new f("GeneralExtend", "1_174", 4);
        MapsKt__MapsKt.emptyMap();
        return new d(aVar, true, true, fVar);
    }
}
