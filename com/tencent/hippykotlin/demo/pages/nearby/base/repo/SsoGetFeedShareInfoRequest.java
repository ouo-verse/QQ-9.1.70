package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import v25.d;
import v25.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SsoGetFeedShareInfoRequest extends NearbyBasePbRequest<d, e> {
    public d req;

    public SsoGetFeedShareInfoRequest(String str, String str2, boolean z16) {
        UserDataManager.INSTANCE.getUserSelfInfo();
        this.req = new d(getCommonExtInfo(), str, str2, z16);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e decodeResponse(byte[] bArr) {
        e eVar = new e(null, null, 0, 7, null);
        try {
            return (e) i.b(new e(null, null, 0, 7, null), bArr);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("GetFeedShareInfoRsp error: ", th5, KLog.INSTANCE, "GetFeedShareInfoRsp");
            return eVar;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.map_svr.Map.SsoGetFeedShareInfo";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e getRequest() {
        return this.req;
    }
}
