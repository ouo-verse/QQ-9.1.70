package com.tencent.timi.game.api.strategy;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes26.dex */
public interface IPlayerStrategy extends QRouteApi {

    /* loaded from: classes26.dex */
    public interface NetworkListener {
        void onNetworkChange(boolean z16, boolean z17);
    }

    void addNetworkListener(NetworkListener networkListener);

    void destroy();

    void init();

    boolean isPreloadEnable();

    boolean isWeakNetwork();

    void onLiveHallHippyPause();

    void onLiveHallHippyResume();

    void onPageIn(long j3);

    void onPageOut(long j3);

    void removeNetworkListener(NetworkListener networkListener);
}
