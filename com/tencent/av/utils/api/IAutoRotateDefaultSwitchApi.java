package com.tencent.av.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAutoRotateDefaultSwitchApi extends QRouteApi {
    boolean enableUseDefaultValue();

    int getDefaultValue();
}
