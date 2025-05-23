package com.tencent.mobileqq.qqlivehall.iv.api.hippy;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQIvLiveHallHippyApi extends QRouteApi {
    HippyAPIProvider getQQIvLiveHallHippyAPIProvider();

    boolean hasNewMessage();

    boolean isCanPreload();

    boolean isQQIvLiveHallModule(String str);
}
