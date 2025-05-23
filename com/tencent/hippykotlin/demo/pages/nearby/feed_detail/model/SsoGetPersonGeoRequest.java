package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.model;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import v25.j;
import v25.k;

/* loaded from: classes31.dex */
public final class SsoGetPersonGeoRequest extends NearbyBasePbRequest<j, k> {
    public final long tinyId;

    public SsoGetPersonGeoRequest(long j3) {
        this.tinyId = j3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        return (k) i.b(new k(null, null, 3, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.map_svr.Map.SsoGetPersonGeo";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return new j(UserDataManager.INSTANCE.getCommonExtInfo(), this.tinyId);
    }
}
