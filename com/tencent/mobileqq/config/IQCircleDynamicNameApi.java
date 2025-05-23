package com.tencent.mobileqq.config;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IQCircleDynamicNameApi extends QRouteApi {
    boolean isDynamicIconExp();

    boolean isDynamicNewNameExp();

    String obtainDynamicBusinessName();

    String obtainExpDynamicIniUrl();

    String replaceToDynamicNameText(String str);

    void updateDynamicIconExp(boolean z16);
}
