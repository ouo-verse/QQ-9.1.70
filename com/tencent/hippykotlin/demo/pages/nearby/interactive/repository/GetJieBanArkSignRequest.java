package com.tencent.hippykotlin.demo.pages.nearby.interactive.repository;

import c45.a;
import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.kuikly.core.log.KLog;
import j35.g;
import j35.h;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetJieBanArkSignRequest extends NearbyBasePbRequest<g, h> {
    public final g params;

    public GetJieBanArkSignRequest(g gVar) {
        this.params = gVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        a aVar = a.f30290b;
        h hVar = new h(aVar);
        try {
            return (h) i.b(new h(aVar), bArr);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("GetKuolieArkSignRsp parse error: ", th5, KLog.INSTANCE, "GetKuolieArkSignRsp");
            return hVar;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.interact_svr.Interact.SsoGetKuolieArkSign";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        g gVar = this.params;
        return new g(gVar.f409221d, gVar.f409222e, gVar.f409223f);
    }
}
