package com.tencent.qqnt.aio.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAIOFactoryExtApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/api/factory/f;", "businessApi", "buildBusinessLevelCompactInputHeight", "Lcom/tencent/aio/api/help/d;", "buildStrangerHelperProvider", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOFactoryExtApi extends QRouteApi {
    @NotNull
    com.tencent.aio.api.factory.f buildBusinessLevelCompactInputHeight(@NotNull com.tencent.aio.api.factory.f businessApi);

    @NotNull
    com.tencent.aio.api.help.d buildStrangerHelperProvider();
}
