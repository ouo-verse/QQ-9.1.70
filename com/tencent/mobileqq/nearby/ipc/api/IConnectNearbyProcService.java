package com.tencent.mobileqq.nearby.ipc.api;

import android.os.Message;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IConnectNearbyProcService extends QRouteApi {
    boolean isNearbyReady();

    Message sendIPCMessage(Message message);

    Object[] sendIPCMessage(int i3);

    Object[] sendIPCMessage(int i3, Object... objArr);
}
