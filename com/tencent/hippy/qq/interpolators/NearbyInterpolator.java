package com.tencent.hippy.qq.interpolators;

import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.mobileqq.newnearby.hippy.INearbyHippyApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes7.dex */
public class NearbyInterpolator extends HippyInterpolator {
    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public boolean hasNewMessage() {
        return ((INearbyHippyApi) QRoute.api(INearbyHippyApi.class)).hasNewMessage();
    }

    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public boolean isCanPreload() {
        return ((INearbyHippyApi) QRoute.api(INearbyHippyApi.class)).isCanPreload();
    }
}
