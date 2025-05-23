package com.tencent.mobileqq.vas.ipc.remote;

import eipc.EIPCModule;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface ILiveDelivery {
    void followUin(String str, EIPCModule eIPCModule, int i3, EIPCResultCallback eIPCResultCallback);

    long getAccount();

    boolean isFollowUin(String str);

    boolean isWxInstall();

    void openChargePage();

    void openQQBrowser(String str);

    void openSchema(String str);

    void reportAction(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i3, int i16);

    void reportStatistic(String str, HashMap<String, String> hashMap, long j3);

    void reportTianshu(String str, String str2, String str3, int i3, int i16);

    void reqPendantInfo(int i3, int i16, Serializable serializable, EIPCModule eIPCModule, int i17, EIPCResultCallback eIPCResultCallback);

    void requestPbMsfSSO(String str, String str2, EIPCModule eIPCModule, int i3, EIPCResultCallback eIPCResultCallback);

    void unfollowUin(String str, EIPCModule eIPCModule, int i3, EIPCResultCallback eIPCResultCallback);
}
