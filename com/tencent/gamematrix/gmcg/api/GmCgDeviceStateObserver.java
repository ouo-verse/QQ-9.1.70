package com.tencent.gamematrix.gmcg.api;

import com.tencent.gamematrix.gmcg.api.model.GmCgColdStartDeviceInfo;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface GmCgDeviceStateObserver {
    void onEnterGmCgDeviceState(GmCgDeviceState gmCgDeviceState);

    void onGmCgDeviceColdStartUpdate(GmCgColdStartDeviceInfo gmCgColdStartDeviceInfo);

    void onGmCgDeviceQueueUpdate(int i3, int i16, int i17);

    void onLeaveGmCgDeviceState(GmCgDeviceState gmCgDeviceState);

    void onTimerUpdateOfGmCgDeviceAliveAfterUse(long j3);

    void onTimerUpdateOfGmCgDeviceAliveBeforeUse(long j3);
}
