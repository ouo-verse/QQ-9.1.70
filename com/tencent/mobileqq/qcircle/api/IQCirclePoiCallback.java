package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.LbsDataV2;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCirclePoiCallback extends QRouteApi {
    void onPoiResultBack(LbsDataV2.PoiList poiList, int i3);
}
