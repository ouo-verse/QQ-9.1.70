package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBaseOIDBRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import o25.e;
import p35.ah;
import x25.g;
import x25.h;

/* loaded from: classes31.dex */
public final class GetPoiDetailRequest extends NearbyBaseOIDBRequest<g, h> {
    public final e coord;
    public final ah poiInfo;

    public GetPoiDetailRequest(ah ahVar, e eVar) {
        this.poiInfo = ahVar;
        this.coord = eVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return 37671;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final c45.e getRequest() {
        return new g(UserDataManager.INSTANCE.getCommonExtInfo(), this.poiInfo, this.coord);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final c45.e decodeResponse(byte[] bArr) {
        int i3 = 3;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        try {
            return (h) i.b(new h(null, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("NBPPOIRepo", "decode GetPoiDetailRsp error: " + th5);
            return new h(b18 == true ? 1 : 0, b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0);
        }
    }
}
