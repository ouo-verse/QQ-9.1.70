package com.tencent.mobileqq.winkpublish.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qzonehub.api.IQZoneJustLocationApi;
import com.tencent.qzonehub.api.IQzoneLbsServiceApi;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.GpsInfo4LocalImage;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkHostLbsHelper {
    public static void getBatchPoiFromServer(ArrayList<GpsInfo4LocalImage> arrayList, boolean z16) {
        ((IQzoneLbsServiceApi) QRoute.api(IQzoneLbsServiceApi.class)).getBatchPoiFromServer(arrayList, z16);
    }

    public static void getBatchPoiFromServerForRecom(ArrayList<GpsInfo4LocalImage> arrayList, int i3) {
        ((IQzoneLbsServiceApi) QRoute.api(IQzoneLbsServiceApi.class)).getBatchPoiFromServerForRecom(arrayList, i3);
    }

    public static void getBatchPoiFromServerWithoutLocation(ArrayList<GpsInfo4LocalImage> arrayList) {
        ((IQzoneLbsServiceApi) QRoute.api(IQzoneLbsServiceApi.class)).getBatchPoiFromServerWithoutLocation(arrayList);
    }

    public static SosoLbsInfo getCachedLbsInfo(String str) {
        return ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("qqcircle");
    }

    public static LbsDataV2.GpsInfo getCurrGps(String str) {
        return ((IQZoneJustLocationApi) QRoute.api(IQZoneJustLocationApi.class)).getCurrGps(str);
    }

    public static void refreshPoiList() {
        ((IQzoneLbsServiceApi) QRoute.api(IQzoneLbsServiceApi.class)).refreshPoiList();
    }

    public static void startLocation(LbsManagerServiceOnLocationChangeListener lbsManagerServiceOnLocationChangeListener) {
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(lbsManagerServiceOnLocationChangeListener);
    }
}
