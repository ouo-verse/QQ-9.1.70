package com.tencent.qqnt.aio.adapter.api;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J(\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&J\b\u0010\u0010\u001a\u00020\bH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOIceBreakApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lmqq/app/AppRuntime;", "app", "", "respRaw", "", "cmd", "", "handleGetIceBreakHotPicResponse", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "senderUid", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "troopUin", "handleIceBreakBubbleWelcomeClick", "handlePreloadWelcomeWording", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOIceBreakApi extends QRouteApi {
    void handleGetIceBreakHotPicResponse(@NotNull AppRuntime app, @NotNull byte[] respRaw, @NotNull String cmd);

    void handleIceBreakBubbleWelcomeClick(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull String senderUid, @NotNull String senderUin, @NotNull String troopUin);

    void handlePreloadWelcomeWording();
}
