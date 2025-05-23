package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import m25.c;
import n25.k;
import v25.n;
import v25.o;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyFeedsRcmdRequest extends NearbyBasePbRequest<n, o> {
    public final String anchorFid;
    public final float latitude;
    public final float longtitude;
    public final String mapThemeId;
    public final k poiInfo;
    public final List<String> rptIgnoreFid;

    public NearbyFeedsRcmdRequest(float f16, float f17, k kVar, String str, String str2, List<String> list) {
        this.latitude = f16;
        this.longtitude = f17;
        this.poiInfo = kVar;
        this.mapThemeId = str;
        this.anchorFid = str2;
        this.rptIgnoreFid = list;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        return (o) i.b(new o(null, null, null, null, null, false, null, 127, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.map_svr.Map.SsoNearbyFeedsRcmd";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        List mutableList;
        o25.e eVar = new o25.e(this.latitude, this.longtitude, 4);
        c commonExtInfo = UserDataManager.INSTANCE.getCommonExtInfo();
        k kVar = this.poiInfo;
        String str = this.mapThemeId;
        String str2 = this.anchorFid;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.rptIgnoreFid);
        return new n(commonExtInfo, eVar, kVar, str, str2, mutableList);
    }
}
