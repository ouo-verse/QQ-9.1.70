package com.tencent.mobileqq.guild.feed.api.impl;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedContainerLifeCycleApi;
import com.tencent.mobileqq.guild.feed.event.GuildFeedTroopLifeCycleEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedContainerLifeCycleApiImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedContainerLifeCycleApi;", "()V", "onSelectFeed", "", "onTroopFeedCreate", "curGuildId", "", "curTroopUin", "onTroopFeedDestroy", "onTroopFeedPause", "onTroopFeedResume", "onTroopFeedShow", "onTroopFeedStop", "onUnSelectFeed", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedContainerLifeCycleApiImpl implements IGuildFeedContainerLifeCycleApi {
    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedContainerLifeCycleApi
    public void onSelectFeed() {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedTroopLifeCycleEvent(6));
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedContainerLifeCycleApi
    public void onTroopFeedCreate(@NotNull String curGuildId, @NotNull String curTroopUin) {
        Intrinsics.checkNotNullParameter(curGuildId, "curGuildId");
        Intrinsics.checkNotNullParameter(curTroopUin, "curTroopUin");
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedContainerLifeCycleApi
    public void onTroopFeedDestroy() {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedTroopLifeCycleEvent(5));
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedContainerLifeCycleApi
    public void onTroopFeedPause() {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedTroopLifeCycleEvent(3));
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedContainerLifeCycleApi
    public void onTroopFeedResume() {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedTroopLifeCycleEvent(0));
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedContainerLifeCycleApi
    public void onTroopFeedStop() {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedTroopLifeCycleEvent(4));
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedContainerLifeCycleApi
    public void onUnSelectFeed() {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedTroopLifeCycleEvent(7));
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedContainerLifeCycleApi
    public void onTroopFeedShow() {
    }
}
