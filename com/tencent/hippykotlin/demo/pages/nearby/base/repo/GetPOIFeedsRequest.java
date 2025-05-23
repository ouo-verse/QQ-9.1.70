package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.e;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBaseOIDBRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import p35.ah;
import x25.i;
import x25.j;

/* loaded from: classes31.dex */
public final class GetPOIFeedsRequest extends NearbyBaseOIDBRequest<i, j> {
    public final String cookies;
    public final int count = 5;
    public final ah poiInfo;

    public GetPOIFeedsRequest(ah ahVar, String str) {
        this.poiInfo = ahVar;
        this.cookies = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final e decodeResponse(byte[] bArr) {
        try {
            return (j) c45.i.b(new j(null, false, null, 7, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("NBPPOIRepo", "decode GetPoiFeedsRsp error: " + th5);
            return new j(null, false, null, 7, null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return 37680;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final e getRequest() {
        return new i(UserDataManager.INSTANCE.getCommonExtInfo(), this.poiInfo, this.count, this.cookies);
    }
}
