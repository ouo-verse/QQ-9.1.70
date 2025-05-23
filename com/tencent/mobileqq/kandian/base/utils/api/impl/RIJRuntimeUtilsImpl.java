package com.tencent.mobileqq.kandian.base.utils.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import kotlin.Metadata;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/RIJRuntimeUtilsImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IRIJRuntimeUtils;", "()V", "getAppRuntime", "Lmqq/app/AppRuntime;", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class RIJRuntimeUtilsImpl implements IRIJRuntimeUtils {
    @Override // com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils
    public AppRuntime getAppRuntime() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            return application.getRuntime();
        }
        return null;
    }
}
