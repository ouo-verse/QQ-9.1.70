package com.tencent.mobileqq.util;

import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ab {
    public static boolean a() {
        return ((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("historicalFunctionalityBug_8_9_30");
    }
}
