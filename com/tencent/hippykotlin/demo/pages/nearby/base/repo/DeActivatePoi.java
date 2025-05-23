package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBaseOIDBRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import p35.ah;
import x25.c;
import x25.d;

/* loaded from: classes31.dex */
public final class DeActivatePoi extends NearbyBaseOIDBRequest<c, d> {
    public final ah poiInfo;

    public DeActivatePoi(ah ahVar) {
        this.poiInfo = ahVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final e decodeResponse(byte[] bArr) {
        try {
            return (d) i.b(new d(), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("NBPPOIRepo", "decode DeactivateRsp error: " + th5);
            return new d();
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return 37701;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final e getRequest() {
        return new c(UserDataManager.INSTANCE.getCommonExtInfo(), this.poiInfo);
    }
}
