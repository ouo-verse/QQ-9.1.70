package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import v25.b;
import v25.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GeoNearRequest extends NearbyBasePbRequest<b, c> {
    public final boolean filterMe = false;
    public final float latitude;
    public final float longtitude;
    public final String mapThemeId;

    public GeoNearRequest(float f16, float f17, String str) {
        this.latitude = f16;
        this.longtitude = f17;
        this.mapThemeId = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        return (c) i.b(new c(null, null, null, null, 0, 0, null, null, 255, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.map_svr.Map.SsoGeoNear";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return new b(UserDataManager.INSTANCE.getCommonExtInfo(), new o25.e(this.latitude, this.longtitude, 4), 5000, this.filterMe, this.mapThemeId);
    }
}
