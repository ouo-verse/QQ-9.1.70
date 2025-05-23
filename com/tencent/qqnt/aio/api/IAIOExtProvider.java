package com.tencent.qqnt.aio.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAIOExtProvider;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "chatType", "Ljava/lang/Class;", "Lcom/tencent/aio/api/factory/g;", "getExtAIOFactoryClz", "getTroopHistoryMsgAIOFactoryClz", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes23.dex */
public interface IAIOExtProvider extends QRouteApi {
    @Nullable
    Class<? extends com.tencent.aio.api.factory.g> getExtAIOFactoryClz(int chatType);

    @NotNull
    Class<? extends com.tencent.aio.api.factory.g> getTroopHistoryMsgAIOFactoryClz();
}
