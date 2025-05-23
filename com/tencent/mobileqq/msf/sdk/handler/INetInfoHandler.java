package com.tencent.mobileqq.msf.sdk.handler;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface INetInfoHandler extends IMsfHandler {
    void onNetMobile2None();

    void onNetMobile2Wifi(String str);

    void onNetNone2Mobile(String str);

    void onNetNone2Wifi(String str);

    void onNetWifi2Mobile(String str);

    void onNetWifi2None();
}
