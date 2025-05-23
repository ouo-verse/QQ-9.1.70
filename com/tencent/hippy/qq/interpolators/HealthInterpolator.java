package com.tencent.hippy.qq.interpolators;

import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthHippyApi;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HealthInterpolator extends HippyInterpolator {
    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public boolean hasNewMessage() {
        return ((IQQHealthHippyApi) QRoute.api(IQQHealthHippyApi.class)).hasNewMessage();
    }

    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public boolean isCanPreload() {
        return ((IQQHealthHippyApi) QRoute.api(IQQHealthHippyApi.class)).canPreloadHippy();
    }
}
