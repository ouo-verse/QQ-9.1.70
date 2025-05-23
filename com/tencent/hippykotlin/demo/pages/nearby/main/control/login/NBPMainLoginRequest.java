package com.tencent.hippykotlin.demo.pages.nearby.main.control.login;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import f35.f;
import f35.g;
import m25.c;

/* loaded from: classes31.dex */
public final class NBPMainLoginRequest extends NearbyBasePbRequest<f, g> {
    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        try {
            return (g) i.b(new g(null, null, false, null, null, null, false, null, null, null, 1023, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("NBPMainLoginRequest", "NBPMainLoginRequest decode error: " + th5);
            return new g(null, null, false, null, null, null, false, null, null, null, 1023, null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.user_manager_svr.User.SsoLogin";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        NBPUserSelfInfo userSelfInfo = userDataManager.getUserSelfInfo();
        c commonExtInfo = userDataManager.getCommonExtInfo();
        NBPLatLng nBPLatLng = userSelfInfo.latLng;
        return new f(commonExtInfo, new o25.e((float) nBPLatLng.latitude, (float) nBPLatLng.longitude, 4), userSelfInfo.locationAddress);
    }
}
