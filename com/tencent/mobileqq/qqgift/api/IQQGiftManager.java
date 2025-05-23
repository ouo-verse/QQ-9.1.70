package com.tencent.mobileqq.qqgift.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import nh2.c;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGiftManager extends QRouteApi {
    void destroy();

    void destroySDKImpl(int i3);

    c getSDKImpl(int i3);

    c removeSDKImpl(int i3);
}
