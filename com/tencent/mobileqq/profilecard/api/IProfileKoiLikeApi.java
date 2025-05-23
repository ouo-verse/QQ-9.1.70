package com.tencent.mobileqq.profilecard.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IProfileKoiLikeApi extends QRouteApi {
    int getSpecialPersonalLabelTextColor(long j3);

    boolean isSpecialPersonalLabel(long j3);
}
