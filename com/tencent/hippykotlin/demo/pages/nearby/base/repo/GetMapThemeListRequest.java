package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.e;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import m25.c;
import n25.k;
import v25.h;
import v25.i;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetMapThemeListRequest extends NearbyBasePbRequest<h, i> {
    public final boolean filterOffline;

    public GetMapThemeListRequest(boolean z16) {
        this.filterOffline = z16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        int i3 = 3;
        i iVar = new i(null, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
        try {
            return (i) c45.i.b(new i(b18 == true ? 1 : 0, b17 == true ? 1 : 0, i3, b16 == true ? 1 : 0), bArr);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("GetMapThemeListRequest error: ", th5, KLog.INSTANCE, "GetMapThemeListRequest");
            return iVar;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.map_svr.Map.SsoGetMapThemeList";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        NBPUserSelfInfo userSelfInfo = userDataManager.getUserSelfInfo();
        c commonExtInfo = userDataManager.getCommonExtInfo();
        String safeStringForRequest = safeStringForRequest(userSelfInfo.locationAddress, "");
        NBPLatLng nBPLatLng = userSelfInfo.latLng;
        double d16 = 1000000;
        return new h(commonExtInfo, new k((String) null, (String) null, 0, (String) null, safeStringForRequest, 0, new n25.i((long) (nBPLatLng.latitude * d16), (long) (nBPLatLng.longitude * d16), 12), 0, 0, (String) null, (String) null, safeStringForRequest(userSelfInfo.locationProvince, userSelfInfo.locationCountry), safeStringForRequest(userSelfInfo.locationCity, userSelfInfo.locationProvince), 0, 0, (String) null, userSelfInfo.locationDistrict, (String) null, (String) null, (String) null, 2025391), this.filterOffline);
    }

    public final String safeStringForRequest(String str, String str2) {
        if (str != null) {
            if (!(str.length() == 0)) {
                return str;
            }
        }
        return str2.length() == 0 ? "Unknown" : str2;
    }
}
