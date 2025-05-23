package com.tencent.hippy.qq.interpolators;

import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.mobileqq.qqlivehall.iv.api.hippy.IQQIvLiveHallHippyApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes7.dex */
public class QQIvLiveHallInterceptor extends HippyInterpolator {
    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public boolean hasNewMessage() {
        return ((IQQIvLiveHallHippyApi) QRoute.api(IQQIvLiveHallHippyApi.class)).hasNewMessage();
    }

    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public boolean isCanPreload() {
        return ((IQQIvLiveHallHippyApi) QRoute.api(IQQIvLiveHallHippyApi.class)).isCanPreload();
    }
}
