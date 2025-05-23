package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.nearby.api.INearbyManagerHelper;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    public static a a(Object obj) {
        return ((INearbyManagerHelper) QRoute.api(INearbyManagerHelper.class)).getNearbyGeneralManager(obj);
    }

    public static com.tencent.mobileqq.nearby.api.a b(Object obj) {
        return ((INearbyManagerHelper) QRoute.api(INearbyManagerHelper.class)).getNearbyProxy(obj);
    }
}
