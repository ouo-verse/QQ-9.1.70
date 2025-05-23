package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import cooperation.qzone.LbsDataV2;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ISosoUtils extends QRouteApi {
    LbsDataV2.GpsInfo convertFromSoso(SosoLocation sosoLocation);
}
