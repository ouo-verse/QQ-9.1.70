package com.tencent.mobileqq.profilecard.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IProfileCardYuanMengApi extends QRouteApi {
    Class getWangZheProfileCardComponentClazz();

    Class getYuanMengProfileCardComponentClazz();
}
