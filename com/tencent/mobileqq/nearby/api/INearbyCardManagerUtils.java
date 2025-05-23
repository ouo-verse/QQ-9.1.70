package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyCardManagerUtils extends QRouteApi {
    boolean isTinyId(String str);

    void updateNearbyPeopleCard(Object obj, String str, Object obj2, Object obj3);
}
