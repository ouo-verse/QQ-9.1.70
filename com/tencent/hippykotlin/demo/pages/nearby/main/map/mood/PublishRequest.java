package com.tencent.hippykotlin.demo.pages.nearby.main.map.mood;

import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import m25.c;
import w25.e;
import w25.f;

/* loaded from: classes31.dex */
public final class PublishRequest extends NearbyBasePbRequest<e, f> {
    public final int mid;

    public PublishRequest(int i3) {
        this.mid = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e decodeResponse(byte[] bArr) {
        return (f) i.b(new f(null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.mood_svr.MoodSvr.SsoPublish";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e getRequest() {
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        c commonExtInfo = userDataManager.getCommonExtInfo();
        int i3 = this.mid;
        userDataManager.getUserSelfInfo();
        o25.e coord = NearbyProUtilsKt.getCoord();
        userDataManager.getUserSelfInfo();
        return new e(commonExtInfo, i3, coord, NearbyProUtilsKt.getPOI());
    }
}
