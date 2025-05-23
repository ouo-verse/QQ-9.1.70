package com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.kuikly.core.log.KLog;
import k35.a;
import k35.m;
import k35.n;
import m25.c;
import o25.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetMatchRequest extends NearbyBasePbRequest<m, n> {
    public final e coord;
    public final a gameData;
    public final int mid;

    public GetMatchRequest(int i3, e eVar, a aVar) {
        this.mid = i3;
        this.coord = eVar;
        this.gameData = aVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e decodeResponse(byte[] bArr) {
        return (n) i.b(new n(0L, 0, null, null, 15, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.mood_svr.MoodSvr.SsoMatch";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e getRequest() {
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("poiInfo: ");
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        userDataManager.getUserSelfInfo();
        m3.append(NearbyProUtilsKt.getPOI().Q);
        kLog.i("NBPShootResultPage", m3.toString());
        c commonExtInfo = userDataManager.getCommonExtInfo();
        int i3 = this.mid;
        e eVar = this.coord;
        a aVar = this.gameData;
        userDataManager.getUserSelfInfo();
        return new m(commonExtInfo, i3, eVar, aVar, NearbyProUtilsKt.getPOI());
    }
}
