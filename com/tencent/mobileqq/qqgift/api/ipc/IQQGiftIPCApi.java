package com.tencent.mobileqq.qqgift.api.ipc;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGiftIPCApi extends QRouteApi {
    QIPCModule getServerIPCModule();
}
