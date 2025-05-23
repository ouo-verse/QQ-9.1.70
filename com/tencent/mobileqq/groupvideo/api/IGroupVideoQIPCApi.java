package com.tencent.mobileqq.groupvideo.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGroupVideoQIPCApi extends QRouteApi {
    public static final String NAME = "GroupVideoQIPCServer";

    QIPCModule getTroopIPCModule();
}
