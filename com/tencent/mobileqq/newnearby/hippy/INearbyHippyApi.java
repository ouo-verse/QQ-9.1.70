package com.tencent.mobileqq.newnearby.hippy;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyHippyApi extends QRouteApi {
    HippyAPIProvider getNearbyHippyAPIProvider();

    boolean hasNewMessage();

    boolean isCanPreload();

    boolean isNearbyModule(String str);
}
