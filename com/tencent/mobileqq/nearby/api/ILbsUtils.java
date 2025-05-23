package com.tencent.mobileqq.nearby.api;

import NearbyGroup.LBSInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILbsUtils extends QRouteApi {
    LBSInfo createLbsInfo(boolean z16, SosoLbsInfo sosoLbsInfo);

    Object getLbsInfo(String str);

    LBSInfo getRawLbsInfo();
}
