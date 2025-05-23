package com.tencent.av.config.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IVideoEffectConfigParser extends QRouteApi {
    public static final int TEST_DISABLE = 0;
    public static final int TEST_ENABLE = 1;

    int getVideoEffectTestFlag(IConfigParser iConfigParser);
}
