package com.tencent.mobileqq.qwallet.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPayInterceptApi extends QRouteApi {
    boolean tryIntercept(String str, Object obj);
}
