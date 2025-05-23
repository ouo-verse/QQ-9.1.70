package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleHostLbsHelper {
    public static SosoLbsInfo getCachedLbsInfo(String str) {
        return ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("qqcircle");
    }

    public static void startLocation(LbsManagerServiceOnLocationChangeListener lbsManagerServiceOnLocationChangeListener) {
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(lbsManagerServiceOnLocationChangeListener);
    }
}
