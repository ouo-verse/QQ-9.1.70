package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import d35.a;
import d35.b;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CheckAIOAccessReqRequest extends NearbyBasePbRequest<a, b> {
    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        return (b) i.b(new b(null, false, null, 0L, 15, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.safety_svr.Safety.SsoCheckAIOAccess";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return new a(UserDataManager.INSTANCE.getCommonExtInfo());
    }
}
