package com.tencent.mobileqq.nearby.profilecard.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes15.dex */
public interface IQQProfileApi extends QRouteApi {
    int getGender(String str);
}
