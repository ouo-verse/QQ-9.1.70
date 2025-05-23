package com.tencent.mobileqq.qqguildsdk.api.impl;

import com.tencent.mobileqq.qqguildsdk.api.IGuildMsgService;
import com.tencent.mobileqq.qqguildsdk.data.GProAbstractUpdateData;
import com.tencent.mobileqq.qqguildsdk.data.GProUnreadCntUpData;
import com.tencent.mobileqq.qqguildsdk.manager.GuildMsgServiceMgr;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNewPostAndSystemPromptNotifyFeedEventData;
import kotlin.Metadata;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0017J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0017J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H\u0017\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/GuildMsgServiceImpl;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGuildMsgService;", "Luh2/c;", "service", "", "init", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/qqguildsdk/data/t;", "registerMsgAbstractUpdateFlow", "Lcom/tencent/mobileqq/qqguildsdk/data/cd;", "registerUnreadCntInfoUpdateFlow", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProNewPostAndSystemPromptNotifyFeedEventData;", "registerGuildNewPostFlow", "<init>", "()V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GuildMsgServiceImpl implements IGuildMsgService {
    @Override // com.tencent.mobileqq.qqguildsdk.api.IGuildMsgService
    public void init(@Nullable uh2.c service) {
        GuildMsgServiceMgr.f268418a.d(service);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGuildMsgService
    @ExperimentalCoroutinesApi
    @NotNull
    public Flow<GProNewPostAndSystemPromptNotifyFeedEventData> registerGuildNewPostFlow() {
        return GuildMsgServiceMgr.f268418a.e();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGuildMsgService
    @ExperimentalCoroutinesApi
    @NotNull
    public Flow<GProAbstractUpdateData> registerMsgAbstractUpdateFlow() {
        return GuildMsgServiceMgr.f268418a.f();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGuildMsgService
    @ExperimentalCoroutinesApi
    @NotNull
    public Flow<GProUnreadCntUpData> registerUnreadCntInfoUpdateFlow() {
        return GuildMsgServiceMgr.f268418a.g();
    }
}
