package com.tencent.av.mcqq.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAVPadOrientationSwitchApi extends QRouteApi {
    Boolean isNeedRotate90();
}
