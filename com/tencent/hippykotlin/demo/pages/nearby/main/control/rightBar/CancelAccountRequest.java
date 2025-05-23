package com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import f35.a;
import f35.b;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CancelAccountRequest extends NearbyBasePbRequest<a, b> {
    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        return (b) i.b(new b(null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.user_manager_svr.User.SsoCancelAccount";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return new a(UserDataManager.INSTANCE.getCommonExtInfo());
    }
}
