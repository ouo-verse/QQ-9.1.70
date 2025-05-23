package com.tencent.mobileqq.tianshu.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ITianShuLifeCircleManager extends QRouteApi {
    void onAccountChange();

    void onEnterBackground();

    void onEnterForeground();

    void onLogout();

    void onNetworkStateChange();
}
