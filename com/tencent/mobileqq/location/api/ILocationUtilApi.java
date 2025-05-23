package com.tencent.mobileqq.location.api;

import com.tencent.mobileqq.location.data.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Collection;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILocationUtilApi extends QRouteApi {
    LatLng getCenterLatLng(Collection<a> collection);

    String getClassName();

    double getDistance(LatLng latLng, LatLng latLng2);

    String getDurationText(double d16);
}
