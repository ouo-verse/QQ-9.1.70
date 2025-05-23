package com.tencent.qqnt.aio.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JO\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H&\u00a2\u0006\u0004\b\u000b\u0010\fJO\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00042\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0004\"\u00020\rH&\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/api/IHelperProviderCompose;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/api/help/a;", "param", "", "Lcom/tencent/aio/main/businesshelper/h;", "helpers", "extHelpers", "", "", "Lkotlin/Function0;", "composeLifecycleHelpers", "(Lcom/tencent/aio/api/help/a;[Lcom/tencent/aio/main/businesshelper/h;[Lcom/tencent/aio/main/businesshelper/h;)Ljava/util/Map;", "Lcom/tencent/aio/main/businesshelper/e;", "composeAllNormalHelpers", "(Lcom/tencent/aio/api/help/a;[Lcom/tencent/aio/main/businesshelper/e;[Lcom/tencent/aio/main/businesshelper/e;)Ljava/util/Map;", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IHelperProviderCompose extends QRouteApi {
    @Nullable
    Map<String, Function0<com.tencent.aio.main.businesshelper.e>> composeAllNormalHelpers(@NotNull com.tencent.aio.api.help.a param, @Nullable com.tencent.aio.main.businesshelper.e[] helpers, @NotNull com.tencent.aio.main.businesshelper.e... extHelpers);

    @Nullable
    Map<String, Function0<com.tencent.aio.main.businesshelper.h>> composeLifecycleHelpers(@NotNull com.tencent.aio.api.help.a param, @Nullable com.tencent.aio.main.businesshelper.h[] helpers, @NotNull com.tencent.aio.main.businesshelper.h... extHelpers);
}
