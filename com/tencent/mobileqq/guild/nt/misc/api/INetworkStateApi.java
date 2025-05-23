package com.tencent.mobileqq.guild.nt.misc.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface INetworkStateApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void onNetworkConnect(boolean z16);
    }

    void addConnectStateListener(a aVar);

    String getNetworkTypeString();

    boolean isNetworkAvailable();

    void removeConnectStateListener(a aVar);
}
