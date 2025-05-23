package com.tencent.biz.pubaccount.util.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountH5AbilityPtt extends QRouteApi {
    void setLocalPathForPtt(String str);

    void setServerIdForPtt(String str);
}
