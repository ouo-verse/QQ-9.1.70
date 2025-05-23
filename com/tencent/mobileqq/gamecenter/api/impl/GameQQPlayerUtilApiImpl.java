package com.tencent.mobileqq.gamecenter.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameQQPlayerUtilApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class GameQQPlayerUtilApiImpl implements IGameQQPlayerUtilApi {
    @Override // com.tencent.mobileqq.gamecenter.api.IGameQQPlayerUtilApi
    public String getMsgExtraString(AppRuntime appRuntime, String str) {
        return com.tencent.mobileqq.gamecenter.data.h.a(appRuntime, str);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameQQPlayerUtilApi
    public void openGameMsgAIO(AppInterface appInterface, Context context, String str, String str2, String str3, String str4, String str5, String str6, long j3, String str7, String str8, int i3, int i16) {
        openGameMsgAIO(appInterface, context, str, str2, str3, str4, str5, str6, j3, str7, str8, i3, i16, "");
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameQQPlayerUtilApi
    public void openGameMsgAIO(AppInterface appInterface, Context context, String str, String str2, String str3, String str4, String str5, String str6, long j3, String str7, String str8, int i3, int i16, String str9) {
        String createUidFromTinyId = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).createUidFromTinyId(str7, str8);
        ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).enterGameMsgAio(context, createUidFromTinyId, str3, str, str4, str2, str8, str7, j3 + "", str6, str5, i3, i16, true, str9);
    }
}
