package com.tencent.mobileqq.onlinestatus.tempapi;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IOnlineStatusAIOTempApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
    }

    BusinessObserver getPaiYiPaiObserver(AppInterface appInterface, a aVar);

    Manager helpGetFriendsManager(AppRuntime appRuntime);

    void sendPaiYiPaiReq(AppInterface appInterface, String str, String str2);
}
