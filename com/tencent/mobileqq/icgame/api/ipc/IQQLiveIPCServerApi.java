package com.tencent.mobileqq.icgame.api.ipc;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes15.dex */
public interface IQQLiveIPCServerApi extends QRouteApi {
    public static final String MODULE_NAME_LIVE = "ICGameLiveServerQIPCModule";

    QIPCModule getQQLiveServerIPCModule();
}
