package com.tencent.qqnt.aio.adapter.api;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0004H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOZPlanShowMsgApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "onMsgClick", "onPlayAction", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "onEnterAIO", "onExitAIO", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOZPlanShowMsgApi extends QRouteApi {
    void onEnterAIO(@NotNull com.tencent.aio.api.runtime.a aioContext);

    void onExitAIO();

    void onMsgClick(@NotNull AIOMsgItem msgItem);

    void onPlayAction(@NotNull AIOMsgItem msgItem);
}
