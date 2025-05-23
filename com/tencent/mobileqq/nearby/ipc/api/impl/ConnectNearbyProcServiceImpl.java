package com.tencent.mobileqq.nearby.ipc.api.impl;

import android.os.Message;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.mobileqq.nearby.ipc.api.IConnectNearbyProcService;

/* loaded from: classes33.dex */
public class ConnectNearbyProcServiceImpl implements IConnectNearbyProcService {
    @Override // com.tencent.mobileqq.nearby.ipc.api.IConnectNearbyProcService
    public boolean isNearbyReady() {
        return ConnectNearbyProcService.y();
    }

    @Override // com.tencent.mobileqq.nearby.ipc.api.IConnectNearbyProcService
    public Object[] sendIPCMessage(int i3) {
        return ConnectNearbyProcService.A(i3);
    }

    @Override // com.tencent.mobileqq.nearby.ipc.api.IConnectNearbyProcService
    public Message sendIPCMessage(Message message) {
        return ConnectNearbyProcService.z(message);
    }

    @Override // com.tencent.mobileqq.nearby.ipc.api.IConnectNearbyProcService
    public Object[] sendIPCMessage(int i3, Object... objArr) {
        return ConnectNearbyProcService.B(i3, objArr);
    }
}
