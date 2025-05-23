package com.tencent.hippykotlin.demo.pages.nearby.interactive.repository;

import c45.a;
import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import j35.c;
import j35.d;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetArkSignRequest extends NearbyBasePbRequest<c, d> {
    public final c params;

    public GetArkSignRequest(c cVar) {
        this.params = cVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        a aVar = a.f30290b;
        d dVar = new d(aVar);
        try {
            return (d) i.b(new d(aVar), bArr);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("GetArkSignRsp parse error: ", th5, KLog.INSTANCE, "GetArkSignRequest");
            return dVar;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.interact_svr.Interact.SsoGetArkSign";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        m25.c commonExtInfo = UserDataManager.INSTANCE.getCommonExtInfo();
        c cVar = this.params;
        return new c(commonExtInfo, cVar.f409208e, cVar.f409209f, cVar.f409210h, cVar.f409211i, cVar.f409212m, cVar.C);
    }
}
