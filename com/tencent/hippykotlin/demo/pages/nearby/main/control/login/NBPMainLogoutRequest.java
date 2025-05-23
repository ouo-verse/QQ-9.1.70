package com.tencent.hippykotlin.demo.pages.nearby.main.control.login;

import c45.e;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import f35.h;
import f35.i;
import m25.c;

/* loaded from: classes31.dex */
public final class NBPMainLogoutRequest extends NearbyBasePbRequest<h, i> {
    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.user_manager_svr.User.SsoLogout";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        NBPUserSelfInfo userSelfInfo = userDataManager.getUserSelfInfo();
        c commonExtInfo = userDataManager.getCommonExtInfo();
        NBPLatLng nBPLatLng = userSelfInfo.latLng;
        return new h(commonExtInfo, new o25.e((float) nBPLatLng.latitude, (float) nBPLatLng.longitude, 4), userSelfInfo.locationAddress);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        try {
            return (i) c45.i.b(new i(null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("NBPMainLogoutRequest", "NBPMainLogoutRequest decode error: " + th5);
            return new i(null);
        }
    }
}
