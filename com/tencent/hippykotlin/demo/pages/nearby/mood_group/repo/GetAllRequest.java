package com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import k35.b;
import k35.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetAllRequest extends NearbyBasePbRequest<b, c> {
    public final int mid;

    public GetAllRequest(int i3) {
        this.mid = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        return (c) i.b(new c(null, null, 0L, 0L, null, 31, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.mood_svr.MoodSvr.SsoGetAll";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        m25.c commonExtInfo = userDataManager.getCommonExtInfo();
        int i3 = this.mid;
        userDataManager.getUserSelfInfo();
        o25.e coord = NearbyProUtilsKt.getCoord();
        userDataManager.getUserSelfInfo();
        return new b(commonExtInfo, i3, coord, NearbyProUtilsKt.getPOI());
    }
}
