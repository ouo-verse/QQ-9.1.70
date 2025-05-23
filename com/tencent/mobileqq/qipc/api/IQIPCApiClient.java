package com.tencent.mobileqq.qipc.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQIPCApiClient extends QRouteApi {
    QIPCApiResult callServer(String str, String str2, Bundle bundle);

    void callServer(String str, String str2, Bundle bundle, QIPCApiCallback qIPCApiCallback);

    void register(QIPCApiModule qIPCApiModule);

    void unRegisterModule(QIPCApiModule qIPCApiModule);
}
