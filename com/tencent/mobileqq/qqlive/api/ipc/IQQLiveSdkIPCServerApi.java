package com.tencent.mobileqq.qqlive.api.ipc;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes17.dex */
public interface IQQLiveSdkIPCServerApi extends QRouteApi {
    public static final String MODULE_NAME = "QQLiveSdkServerIPCModule";

    QIPCModule getServerIPCModule();
}
