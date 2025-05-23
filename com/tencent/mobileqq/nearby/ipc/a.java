package com.tencent.mobileqq.nearby.ipc;

import com.tencent.mobileqq.nearby.ipc.api.IConnectNearbyProcService;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    public static boolean a() {
        return ((IConnectNearbyProcService) QRoute.api(IConnectNearbyProcService.class)).isNearbyReady();
    }

    public static Object[] b(int i3) {
        return ((IConnectNearbyProcService) QRoute.api(IConnectNearbyProcService.class)).sendIPCMessage(i3);
    }

    public static Object[] c(int i3, Object... objArr) {
        return ((IConnectNearbyProcService) QRoute.api(IConnectNearbyProcService.class)).sendIPCMessage(i3, objArr);
    }
}
