package com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view_model;

import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBaseOIDBRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import g35.d;
import g35.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SetRemindSwitchRequest extends NearbyBaseOIDBRequest<d, e> {
    public final boolean check;

    public SetRemindSwitchRequest(boolean z16) {
        this.check = z16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final c45.e decodeResponse(byte[] bArr) {
        e eVar = new e();
        try {
            return (e) i.b(new e(), bArr);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("SetRemindSwitchReqest error: ", th5, KLog.INSTANCE, "SetRemindSwitchReqest");
            return eVar;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return 37598;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final c45.e getRequest() {
        return new d(UserDataManager.INSTANCE.getCommonExtInfo(), this.check);
    }
}
