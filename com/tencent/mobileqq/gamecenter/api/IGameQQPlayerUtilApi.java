package com.tencent.mobileqq.gamecenter.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGameQQPlayerUtilApi extends QRouteApi {
    String getMsgExtraString(AppRuntime appRuntime, String str);

    void openGameMsgAIO(AppInterface appInterface, Context context, String str, String str2, String str3, String str4, String str5, String str6, long j3, String str7, String str8, int i3, int i16);

    void openGameMsgAIO(AppInterface appInterface, Context context, String str, String str2, String str3, String str4, String str5, String str6, long j3, String str7, String str8, int i3, int i16, String str9);
}
