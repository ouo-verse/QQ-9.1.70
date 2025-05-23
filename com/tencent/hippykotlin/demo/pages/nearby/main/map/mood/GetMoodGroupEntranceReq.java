package com.tencent.hippykotlin.demo.pages.nearby.main.map.mood;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.kuikly.core.log.KLog;
import w25.b;
import w25.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetMoodGroupEntranceReq extends NearbyBasePbRequest<b, c> {
    public final int moodId;

    public GetMoodGroupEntranceReq(int i3) {
        this.moodId = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        c cVar = new c(null, null, 3, null);
        try {
            return (c) i.b(new c(null, null, 3, null), bArr);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("GetMoodGroupEntranceReq error: ", th5, KLog.INSTANCE, "GetMoodGroupEntranceReq");
            return cVar;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.mood_svr.MoodSvr.SsoGetEntrance";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        m25.c commonExtInfo = userDataManager.getCommonExtInfo();
        int i3 = this.moodId;
        userDataManager.getUserSelfInfo();
        o25.e coord = NearbyProUtilsKt.getCoord();
        userDataManager.getUserSelfInfo();
        return new b(commonExtInfo, i3, coord, NearbyProUtilsKt.getPOI());
    }
}
