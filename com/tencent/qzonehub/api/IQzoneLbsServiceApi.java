package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.model.GpsInfo4LocalImage;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneLbsServiceApi extends QRouteApi {
    void getBatchPoiFromServer(ArrayList<GpsInfo4LocalImage> arrayList, boolean z16);

    void getBatchPoiFromServerForRecom(ArrayList<GpsInfo4LocalImage> arrayList, int i3);

    void getBatchPoiFromServerWithoutLocation(ArrayList<GpsInfo4LocalImage> arrayList);

    void refreshPoiList();
}
