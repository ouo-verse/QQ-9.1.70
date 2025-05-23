package com.tencent.hippy.qq.api;

import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IHippySSR extends QRouteApi {
    ISSRBundleRequester createSSRBundleRequester();

    int getSSRCommonJsVersion();

    boolean loadSSRCommonJs(HippyQQEngine hippyQQEngine, int i3);

    void updateSSRCommonJs();
}
