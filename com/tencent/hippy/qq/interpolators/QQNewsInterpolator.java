package com.tencent.hippy.qq.interpolators;

import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.mobileqq.qqnews.api.IQQNewsHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/hippy/qq/interpolators/QQNewsInterpolator;", "Lcom/tencent/hippy/qq/api/HippyInterpolator;", "()V", "hasNewMessage", "", "isCanPreload", "hippy-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class QQNewsInterpolator extends HippyInterpolator {
    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public boolean hasNewMessage() {
        return ((IQQNewsHippyApi) QRoute.api(IQQNewsHippyApi.class)).hasNewMessage();
    }

    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public boolean isCanPreload() {
        return ((IQQNewsHippyApi) QRoute.api(IQQNewsHippyApi.class)).isCanPreload();
    }
}
