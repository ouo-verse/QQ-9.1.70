package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyManagerHelper extends QRouteApi {
    com.tencent.mobileqq.nearby.b getNearbyCardManager(Object obj);

    com.tencent.mobileqq.nearby.a getNearbyGeneralManager(Object obj);

    a getNearbyProxy(Object obj);
}
