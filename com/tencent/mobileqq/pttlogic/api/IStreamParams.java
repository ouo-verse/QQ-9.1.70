package com.tencent.mobileqq.pttlogic.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IStreamParams extends QRouteApi {
    int getSliceSize(AppRuntime appRuntime, int i3, int i16);

    void initSliceCfg(AppRuntime appRuntime, boolean z16);

    void initSupportCfg(AppRuntime appRuntime, boolean z16);

    void release();

    void saveStreamCfg(AppRuntime appRuntime, String str);

    void saveStreamSliceCfg(AppRuntime appRuntime, String str);
}
