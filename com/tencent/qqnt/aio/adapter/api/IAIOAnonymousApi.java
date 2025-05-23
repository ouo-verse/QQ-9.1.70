package com.tencent.qqnt.aio.adapter.api;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOAnonymousApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isSupportRevokeAnonymousMsg", "Lcom/tencent/aio/api/runtime/a;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "openAnonymousMemberProfile", "", "memberUin", "", "getRobotDrawableId", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOAnonymousApi extends QRouteApi {
    int getRobotDrawableId(@NotNull String memberUin);

    boolean isSupportRevokeAnonymousMsg();

    void openAnonymousMemberProfile(@NotNull com.tencent.aio.api.runtime.a context, @NotNull AIOMsgItem msgItem);
}
