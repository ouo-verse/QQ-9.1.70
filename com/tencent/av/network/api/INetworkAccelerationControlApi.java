package com.tencent.av.network.api;

import com.tencent.avcore.jni.net.SocketInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import wu.a;
import zu.b;

/* compiled from: P */
@QRouteFactory(singleton = true)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface INetworkAccelerationControlApi extends a, QRouteApi {
    @Override // wu.a
    /* synthetic */ void bindToNetInterface(SocketInfo socketInfo);

    @Override // wu.a
    /* synthetic */ int getCurManufacture();

    @Override // wu.a
    /* synthetic */ boolean hasFeature(int i3);

    boolean hasInit();

    void initAsync(zu.a aVar);

    @Override // wu.a
    /* synthetic */ boolean isSupportNetworkAcceleration();

    @Override // wu.a
    /* synthetic */ void notifyAPPStateToSys(int i3);

    @Override // wu.a
    /* synthetic */ void registerNetworkEventListener(b bVar);

    @Override // wu.a
    /* synthetic */ void setAppBandwidth(int i3, int i16);

    @Override // wu.a
    /* synthetic */ void unBindToNetInterface(SocketInfo socketInfo);

    @Override // wu.a
    /* synthetic */ void unRegisterNetworkEventListener(b bVar);
}
