package com.tencent.qqnt.aio.adapter.api;

import com.tencent.mobileqq.aio.title.ai;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOSubTitleApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/aio/title/ai;", "getSubTitleSync", "", "onRoamLoadingEnd", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOSubTitleApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        @Nullable
        public static ai a(@NotNull IAIOSubTitleApi iAIOSubTitleApi, @NotNull com.tencent.aio.api.runtime.a aioContext) {
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            return null;
        }
    }

    @Nullable
    ai getSubTitleSync(@NotNull com.tencent.aio.api.runtime.a aioContext);

    void onRoamLoadingEnd(@NotNull com.tencent.aio.api.runtime.a aioContext);
}
