package com.tencent.timi.game.api.ipc;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes26.dex */
public interface ITGIPCServerApi extends QRouteApi {
    public static final String MODULE_NAME_HALL = "TGHallServerQIPCModule";
    public static final String MODULE_NAME_LIVE = "TGLiveServerQIPCModule";

    QIPCModule getHallServerIPCModule();

    QIPCModule getLiveServerIPCModule();
}
