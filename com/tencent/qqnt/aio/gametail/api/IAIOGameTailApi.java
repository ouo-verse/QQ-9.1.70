package com.tencent.qqnt.aio.gametail.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/gametail/api/IAIOGameTailApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "appId", "", "appType", "msgTimestamp", "Lcom/tencent/qqnt/aio/gametail/api/a;", "getGamePicTailInfo", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOGameTailApi extends QRouteApi {
    @Nullable
    a getGamePicTailInfo(long appId, int appType, long msgTimestamp);
}
