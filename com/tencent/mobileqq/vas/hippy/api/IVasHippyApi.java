package com.tencent.mobileqq.vas.hippy.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasHippyApi extends QRouteApi {
    HippyAPIProvider createHippyAPIProvider();

    HippyCustomViewCreator createHippyCustomViewCreator();

    boolean isVasModuleNeedToBeAdd(String str);
}
