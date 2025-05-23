package com.tencent.mobileqq.msg.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IFeatureSwitch extends QRouteApi {
    boolean isFeatureSwitchEnable(String str);

    boolean isFeatureSwitchEnable(String str, boolean z16);
}
