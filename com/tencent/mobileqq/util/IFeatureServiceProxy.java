package com.tencent.mobileqq.util;

import android.util.Pair;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IFeatureServiceProxy extends QRouteApi {
    Pair<Boolean, String> getSwitchAndValue(String str);

    boolean isAppRuntimeNull();

    boolean isFeatureSwitchOn(String str);

    boolean isFeatureSwitchOn(String str, boolean z16);
}
