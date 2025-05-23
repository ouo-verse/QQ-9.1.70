package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.e;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import s25.i;
import s25.j;

/* loaded from: classes31.dex */
public final class NBPTipOffReportRequest extends NearbyBasePbRequest<i, j> {
    public final String feedId;
    public final int tipOffType = 1;

    public NBPTipOffReportRequest(String str) {
        this.feedId = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        j jVar = new j(null);
        try {
            return (j) c45.i.b(new j(null), bArr);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("decodeResponse error: ", th5, KLog.INSTANCE, "NBPTipOffReportRequest");
            return jVar;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.map_svr.Map.SsoGetFeedShareInfo";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return new i(UserDataManager.INSTANCE.getCommonExtInfo(), this.tipOffType, this.feedId);
    }
}
