package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildDirectMsgChannelApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildDirectMsgChannelApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildDirectMsgChannelApi;", "()V", "getDirectMsgAioFactoryName", "", "getGlobalNoticeAioFactoryName", "isDirectMsgChannelFactoryName", "", "factoryName", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildDirectMsgChannelApiImpl implements IGuildDirectMsgChannelApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildDirectMsgChannelApi
    @NotNull
    public String getDirectMsgAioFactoryName() {
        String name = com.tencent.qqguild.directmessage.aio.a.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "AioFactory::class.java.name");
        return name;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDirectMsgChannelApi
    @NotNull
    public String getGlobalNoticeAioFactoryName() {
        String name = com.tencent.mobileqq.guild.main.announcement.detail.aio.a.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GlobalNoticeAioFactory::class.java.name");
        return name;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDirectMsgChannelApi
    public boolean isDirectMsgChannelFactoryName(@NotNull String factoryName) {
        Intrinsics.checkNotNullParameter(factoryName, "factoryName");
        return Intrinsics.areEqual(factoryName, getDirectMsgAioFactoryName());
    }
}
