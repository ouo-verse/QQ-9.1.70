package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qqguildsdk.data.GProAbstractUpdateData;
import com.tencent.mobileqq.qqguildsdk.data.GProUnreadCntUpData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNewPostAndSystemPromptNotifyFeedEventData;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uh2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/IGuildMsgService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Luh2/c;", "service", "", "init", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/qqguildsdk/data/t;", "registerMsgAbstractUpdateFlow", "Lcom/tencent/mobileqq/qqguildsdk/data/cd;", "registerUnreadCntInfoUpdateFlow", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProNewPostAndSystemPromptNotifyFeedEventData;", "registerGuildNewPostFlow", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IGuildMsgService extends QRouteApi {
    void init(@Nullable c service);

    @NotNull
    Flow<GProNewPostAndSystemPromptNotifyFeedEventData> registerGuildNewPostFlow();

    @NotNull
    Flow<GProAbstractUpdateData> registerMsgAbstractUpdateFlow();

    @NotNull
    Flow<GProUnreadCntUpData> registerUnreadCntInfoUpdateFlow();
}
