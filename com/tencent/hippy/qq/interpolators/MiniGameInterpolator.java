package com.tencent.hippy.qq.interpolators;

import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MiniGameInterpolator extends HippyInterpolator {
    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public boolean hasNewMessage() {
        return ((IMiniGamePublicAccountApi) QRoute.api(IMiniGamePublicAccountApi.class)).hasNewMessage();
    }

    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public boolean isCanPreload() {
        return ((IMiniGamePublicAccountApi) QRoute.api(IMiniGamePublicAccountApi.class)).canPreloadHippy();
    }
}
