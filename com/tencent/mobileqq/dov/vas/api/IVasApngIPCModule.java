package com.tencent.mobileqq.dov.vas.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IVasApngIPCModule extends QRouteApi {
    void download();

    boolean loadSoLib();
}
