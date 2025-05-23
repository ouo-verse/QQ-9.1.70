package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBaseOIDBRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import o25.e;
import p35.ah;
import x25.a;
import x25.b;

/* loaded from: classes31.dex */
public final class ActivatePoi extends NearbyBaseOIDBRequest<a, b> {
    public final e coord;

    /* renamed from: op, reason: collision with root package name */
    public final int f114207op = 0;
    public final ah poiInfo;

    public ActivatePoi(ah ahVar, e eVar) {
        this.poiInfo = ahVar;
        this.coord = eVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return 37681;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final c45.e getRequest() {
        return new a(UserDataManager.INSTANCE.getCommonExtInfo(), this.poiInfo, this.coord, this.f114207op);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final c45.e decodeResponse(byte[] bArr) {
        try {
            return (b) i.b(new b(null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("NBPPOIRepo", "decode ActivateRsp error: " + th5);
            return new b(null);
        }
    }
}
