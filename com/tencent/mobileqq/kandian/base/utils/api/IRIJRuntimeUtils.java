package com.tencent.mobileqq.kandian.base.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/utils/api/IRIJRuntimeUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAppRuntime", "Lmqq/app/AppRuntime;", "kandian-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IRIJRuntimeUtils extends QRouteApi {
    @Nullable
    AppRuntime getAppRuntime();
}
