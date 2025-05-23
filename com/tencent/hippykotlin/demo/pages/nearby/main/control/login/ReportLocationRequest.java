package com.tencent.hippykotlin.demo.pages.nearby.main.control.login;

import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.kuikly.core.log.KLog;
import n25.k;
import o25.e;
import v25.r;
import v25.s;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ReportLocationRequest extends NearbyBasePbRequest<r, s> {
    public r req;

    public ReportLocationRequest(NBPLatLng nBPLatLng, k kVar) {
        this.req = new r(getCommonExtInfo(), new e((float) nBPLatLng.getLatitude(), (float) nBPLatLng.getLongitude(), 4), kVar);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.map_svr.Map.SsoReportLocation";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e getRequest() {
        return this.req;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e decodeResponse(byte[] bArr) {
        try {
            return (s) i.b(new s(null, 0, 3, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("ReportLocationRequest", "ReportLocationRequest decode error: " + th5);
            return new s(null, 0, 3, null);
        }
    }
}
