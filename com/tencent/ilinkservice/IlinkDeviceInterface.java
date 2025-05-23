package com.tencent.ilinkservice;

import com.tencent.ilinkservice.IlinkServiceProto;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IlinkDeviceInterface {
    void autoLogin();

    void changeDomain(int i3);

    String getIlinkServiceVersion();

    byte[] getProfile();

    String getToken();

    boolean isAlreadyGetStrategy();

    int sendIotMessage(String str, String str2, String str3, String str4);

    void setCallback(IlinkDeviceCallback ilinkDeviceCallback);

    void setConsoleLogOpen(boolean z16);

    void setLogLevel(int i3);

    void setLonglinkIplist(IlinkServiceProto.ServerIplist serverIplist);

    void setProxyInfo(int i3, String str, int i16, String str2, String str3);

    void setShortlinkIplist(IlinkServiceProto.ServerIplist serverIplist);

    void startUploadLog(IlinkServiceProto.IlinkUploadLogInfo ilinkUploadLogInfo);

    void updateDeviceInfo(int i3, String str, int i16);
}
