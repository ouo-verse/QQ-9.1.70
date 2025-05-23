package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IFlashTransferServiceDeviceStatusListener {
    void onAvailableStorageChange(int i3, String str, boolean z16);

    void onNetStatusChanged(int i3, String str, NetStatusType netStatusType);

    void showBackToForegroundAlert(int i3, String str);

    void showLowBatterylAlert(int i3, String str);

    void showSleepAlert(int i3, String str);
}
