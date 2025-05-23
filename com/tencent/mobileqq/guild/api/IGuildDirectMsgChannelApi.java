package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildDirectMsgChannelApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDirectMsgAioFactoryName", "", "getGlobalNoticeAioFactoryName", "isDirectMsgChannelFactoryName", "", "factoryName", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGuildDirectMsgChannelApi extends QRouteApi {
    @NotNull
    String getDirectMsgAioFactoryName();

    @NotNull
    String getGlobalNoticeAioFactoryName();

    boolean isDirectMsgChannelFactoryName(@NotNull String factoryName);
}
