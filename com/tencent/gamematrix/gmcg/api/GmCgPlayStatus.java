package com.tencent.gamematrix.gmcg.api;

/* loaded from: classes6.dex */
public enum GmCgPlayStatus {
    StatusStart(0, "Start", "\u5f00\u59cb"),
    StatusCheckingAuth(1, "CheckingAuth", "\u68c0\u67e5\u9274\u6743\u4e2d"),
    StatusCheckingDevice(2, "CheckingDevice", "\u68c0\u67e5\u8bbe\u5907\u4e2d"),
    StatusDeviceAllocated(3, "DeviceAllocated", "\u8bbe\u5907\u5df2\u5206\u914d"),
    StatusTestingDeviceSpeed(4, "TestingDeviceSpeed", "\u7f51\u5173\u6d4b\u901f\u4e2d"),
    StatusAllocatingDevice(5, "AllocatingDevice", "\u8bbe\u5907\u5206\u914d\u4e2d"),
    StatusQueueingDevice(6, "QueueingDevice", "\u8bbe\u5907\u6392\u961f\u4e2d"),
    StatusLoginLaunchingDevice(7, "LoginLaunchingDevice", "\u767b\u5f55\u5e76\u62c9\u8d77\u8bbe\u5907\u4e2d"),
    StatusDeviceReadyToConnect(8, "DeviceReadyToConnect", "\u8bbe\u5907\u5df2\u51c6\u5907\u8fde\u63a5"),
    StatusRTCConnecting(9, "RTCConnecting", "\u8bbe\u5907\u5f00\u59cb\u8fde\u63a5\u4e2d"),
    StatusRTCConnected(10, "RTCConnected", "\u8bbe\u5907\u5df2\u8fde\u63a5"),
    StatusFirstFramedRendered(11, "FirstFramedRendered", "\u9996\u5e27\u5df2\u6e32\u67d3"),
    StatusInStreaming(12, "InStreaming", "\u6b63\u5e38\u63a8\u6d41\u4e2d"),
    StatusServerClosed(13, "ServerClosed", "\u670d\u52a1\u5668\u4e3b\u52a8\u5173\u95ed"),
    StatusDeviceGiveUp(14, "DeviceGiveUp", "\u653e\u5f03\u8bbe\u5907"),
    StatusStopped(15, "Stopped", "\u505c\u6b62"),
    StatusGameConfigGot(16, "GameConfigGot", "\u83b7\u53d6\u5230\u6e38\u620f\u7684\u914d\u7f6e\u4fe1\u606f"),
    StatusLoadingGameArchive(17, "LoadingGameArchive", "\u52a0\u8f7d\u5b58\u6863\u4e2d"),
    StatusCloudGameLogining(18, "CloudGameLogining", "\u4e91\u6e38\u620f\u767b\u5f55\u4e2d"),
    StatusPrepareData(19, "PrepareData", "\u4e91\u6e38\u620f\u51c6\u5907\u4e2d"),
    StatusLoadingFinished(20, "LoadingFinished", "\u4e91\u6e38\u620f\u52a0\u8f7d\u5b8c\u6210"),
    StatusStreamQualityConfigGot(21, "StreamQualityConfigGot", "\u5df2\u83b7\u53d6\u6e05\u6670\u5ea6\u914d\u7f6e"),
    StatusRTCDisconnected(22, "StatusRTCDisconnected", "\u8bbe\u5907\u5df2\u65ad\u5f00\u8fde\u63a5"),
    StatusRestart(23, "StatusRestart", "\u5f00\u59cb\u91cd\u8bd5"),
    RemoteStreamStopped(24, "RemoteStreamStopped", "\u8fdc\u7aef\u505c\u6b62\u63a8\u6d41"),
    RemoteStreamFailed(25, "RemoteStreamFailed", "\u8fdc\u7aef\u63a8\u6d41\u5931\u8d25"),
    StatusErrorHappen(153, "ErrorHappen", "\u5f02\u5e38\u53d1\u751f");

    private final int mStatusCode;
    private final String mStatusDesc;
    private final String mStatusName;

    GmCgPlayStatus(int i3, String str, String str2) {
        this.mStatusCode = i3;
        this.mStatusName = str;
        this.mStatusDesc = str2;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String getStatusDesc() {
        return this.mStatusDesc;
    }

    public String getStatusName() {
        return this.mStatusName;
    }

    public boolean is(GmCgPlayStatus gmCgPlayStatus) {
        if (this.mStatusCode == gmCgPlayStatus.mStatusCode) {
            return true;
        }
        return false;
    }

    public boolean isWebRtcConnected() {
        if (this != StatusRTCConnected && this != StatusFirstFramedRendered && this != StatusInStreaming && this != StatusLoadingFinished && this != StatusStreamQualityConfigGot && this != RemoteStreamStopped) {
            return false;
        }
        return true;
    }

    public boolean not(GmCgPlayStatus gmCgPlayStatus) {
        if (this.mStatusCode != gmCgPlayStatus.mStatusCode) {
            return true;
        }
        return false;
    }
}
