package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniGameVALaunchApi extends QRouteApi {
    void reportDc87(int i3, String str, String str2, String str3);

    void reportToServerRealTime(String str, String str2, String str3, String str4);

    void restartApp(String str);

    void startYunGame(String str);
}
