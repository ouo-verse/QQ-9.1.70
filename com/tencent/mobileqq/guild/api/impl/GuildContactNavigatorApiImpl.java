package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.activity.home.chats.biz.guild.GuildSlideCoordinator;
import com.tencent.mobileqq.guild.api.IGuildContactNavigatorApi;
import com.tencent.mobileqq.guild.api.IGuildLayoutApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildContactNavigatorApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildContactNavigatorApi;", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$d;", "progressAware", "", "addProgressAware", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildContactNavigatorApiImpl implements IGuildContactNavigatorApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildContactNavigatorApi
    public void addProgressAware(@NotNull IGuildLayoutApi.d progressAware) {
        Intrinsics.checkNotNullParameter(progressAware, "progressAware");
        GuildSlideCoordinator.k(progressAware);
    }
}
