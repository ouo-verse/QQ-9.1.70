package com.tencent.avcore.jni.audiodevice.api;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface ITraeAudioCallback {
    void onBeginConnectDevice(String str);

    void onConnectDeviceRes(int i3, String str, boolean z16);

    void onDeviceChangeableUpdate(boolean z16);

    void onDeviceExternalSwitch(String str);

    void onDeviceListUpdate(long j3, String[] strArr, String str, String str2, String str3);

    void onGetConnectedDeviceRes(int i3, String str);

    void onGetDeviceListRes(int i3, String[] strArr, String str, String str2, String str3);

    void onGetStreamTypeRes(int i3, int i16, int i17);

    void onServiceStateUpdate(long j3, boolean z16);

    void onStreamTypeUpdate(long j3, int i3, int i16);

    void onVoiceCallPreProcessRes(int i3);
}
