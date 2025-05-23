package com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap;

import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.kuikly.core.log.KLog;
import o25.e;
import v25.f;
import v25.g;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetHotMapRequest extends NearbyBasePbRequest<f, g> {
    public f req;

    public GetHotMapRequest(String str, NBPLatLng nBPLatLng, int i3) {
        this.req = new f(getCommonExtInfo(), new e((float) nBPLatLng.getLatitude(), (float) nBPLatLng.getLongitude(), 4), i3, str);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e decodeResponse(byte[] bArr) {
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        int i3 = 3;
        g gVar = new g(null, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
        try {
            return (g) i.b(new g(b18 == true ? 1 : 0, b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0), bArr);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("GetHotMapRequest decode error: ", th5, KLog.INSTANCE, "GetHotMapRequest");
            return gVar;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.map_svr.Map.SsoGetHotMap";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e getRequest() {
        return this.req;
    }
}
