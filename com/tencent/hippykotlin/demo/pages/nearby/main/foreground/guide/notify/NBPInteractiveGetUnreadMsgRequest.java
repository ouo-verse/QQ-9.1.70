package com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.notify;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import u25.c;
import u25.d;

/* loaded from: classes31.dex */
public final class NBPInteractiveGetUnreadMsgRequest extends NearbyBasePbRequest<c, d> {
    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        d dVar = new d(null, 0, 3, null);
        try {
            return (d) i.b(new d(null, 0, 3, null), bArr);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("parse error: ", th5, KLog.INSTANCE, "NBPInteractiveGetUnreadMsgRequest");
            return dVar;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.like_svr.Like.SsoGetUnreadMsg";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return new c(UserDataManager.INSTANCE.getCommonExtInfo());
    }
}
