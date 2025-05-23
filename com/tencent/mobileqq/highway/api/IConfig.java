package com.tencent.mobileqq.highway.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes9.dex */
public interface IConfig extends QRouteApi {
    boolean isAllUseKernel();

    boolean isUseKernel(int i3);
}
