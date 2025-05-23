package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyAppInterfaceUtils extends QRouteApi {
    void freePartBitmapCache();
}
