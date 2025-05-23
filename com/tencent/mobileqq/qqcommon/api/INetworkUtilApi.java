package com.tencent.mobileqq.qqcommon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface INetworkUtilApi extends QRouteApi {
    int getConnRetryTimes(int i3);

    boolean is4G();

    boolean is5G();

    boolean isNetworkAvailable();

    boolean isWifi();
}
