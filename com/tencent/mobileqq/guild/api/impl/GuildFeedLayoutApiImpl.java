package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.FeedListDelegateSectionFactory;
import com.tencent.mobileqq.guild.api.IGuildFeedLayoutApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildFeedLayoutApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildFeedLayoutApi;", "()V", "getDefaultFactory", "Lcom/tencent/mobileqq/guild/api/FeedListDelegateSectionFactory;", "getRecommendFeedFactory", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildFeedLayoutApiImpl implements IGuildFeedLayoutApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildFeedLayoutApi
    @NotNull
    public FeedListDelegateSectionFactory getDefaultFactory() {
        return new a();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildFeedLayoutApi
    @NotNull
    public FeedListDelegateSectionFactory getRecommendFeedFactory() {
        return new RecommendFeedListDelegateSectionFactory();
    }
}
