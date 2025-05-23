package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* loaded from: classes15.dex */
public interface IMsfProxy {
    int getMsfConnectedIPFamily();

    int getMsfConnectedNetType();

    void init(MsfServiceSdk msfServiceSdk);

    void initMsfService();

    int onApplicationBackground();

    int onApplicationForeground();

    int onKillProcess();

    int onProcessViewableChanged(boolean z16, long j3, String str);

    int registerMsfService(boolean z16, boolean z17);

    void registerProxyDone();

    int sendMsg(ToServiceMsg toServiceMsg);

    boolean serviceConnected();

    void startMsfService();

    void stopMsfService();

    int unRegisterMsfService(Boolean bool);

    void unbindMsfService();
}
