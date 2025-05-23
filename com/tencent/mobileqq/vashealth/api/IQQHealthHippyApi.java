package com.tencent.mobileqq.vashealth.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IQQHealthHippyApi extends QRouteApi {
    boolean canPreloadHippy();

    HippyAPIProvider createHippyProvider();

    boolean hasNewMessage();

    boolean isHealthModule(String str);
}
