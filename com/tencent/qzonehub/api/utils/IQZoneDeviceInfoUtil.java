package com.tencent.qzonehub.api.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneDeviceInfoUtil extends QRouteApi {
    String getDeviceInfo();
}
