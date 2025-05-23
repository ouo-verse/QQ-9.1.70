package com.tencent.aio.stranger.api;

import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/aio/stranger/api/IStrangerAssistantAdapterApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getMiniCardAppId", "", "isLittleAssistant", "", "contact", "Lcom/tencent/aio/data/AIOContact;", "aio_stranger_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IStrangerAssistantAdapterApi extends QRouteApi {
    @NotNull
    String getMiniCardAppId();

    boolean isLittleAssistant(@NotNull AIOContact contact);
}
