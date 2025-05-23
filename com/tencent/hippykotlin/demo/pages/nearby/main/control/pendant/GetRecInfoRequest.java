package com.tencent.hippykotlin.demo.pages.nearby.main.control.pendant;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.kuikly.core.log.KLog;
import n25.k;
import v25.l;
import v25.m;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetRecInfoRequest extends NearbyBasePbRequest<l, m> {
    public l req;

    public GetRecInfoRequest(k kVar) {
        this.req = new l(getCommonExtInfo(), kVar);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        m mVar = new m(null, null, null, 7, null);
        try {
            return (m) i.b(new m(null, null, null, 7, null), bArr);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("GetRecInfoRequest decode error: ", th5, KLog.INSTANCE, "GetRecInfoRequest");
            return mVar;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.map_svr.Map.SsoGetRecInfo";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return this.req;
    }
}
