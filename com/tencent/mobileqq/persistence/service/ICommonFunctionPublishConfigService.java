package com.tencent.mobileqq.persistence.service;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface ICommonFunctionPublishConfigService extends QRouteApi {
    boolean isCopyDBCommandEnable();

    boolean isIgnoreInvalidUnreadMark();

    boolean isLocalized();

    boolean isNewUnreadCountEnable();

    boolean isTuringRiskDetectEnable();

    boolean isUseNewInvalidUnreadMarkThreshold();

    boolean isWalEnable();
}
