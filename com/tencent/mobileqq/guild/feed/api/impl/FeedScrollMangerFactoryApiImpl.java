package com.tencent.mobileqq.guild.feed.api.impl;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.feed.api.IFeedScrollMangerFactoryApi;
import com.tencent.mobileqq.guild.feed.preload.scroller.GuildFeedPreloadDetailInfoScroller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/FeedScrollMangerFactoryApiImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IFeedScrollMangerFactoryApi;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/api/e;", "feedAdapterCenter", "Lcom/tencent/mobileqq/guild/api/d;", "createFeedScrollManager", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedScrollMangerFactoryApiImpl implements IFeedScrollMangerFactoryApi {
    @Override // com.tencent.mobileqq.guild.feed.api.IFeedScrollMangerFactoryApi
    @NotNull
    public com.tencent.mobileqq.guild.api.d createFeedScrollManager(@NotNull Context context, @NotNull RecyclerView recyclerView, @NotNull com.tencent.mobileqq.guild.api.e feedAdapterCenter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(feedAdapterCenter, "feedAdapterCenter");
        com.tencent.mobileqq.guild.feed.manager.a aVar = new com.tencent.mobileqq.guild.feed.manager.a(context, recyclerView, feedAdapterCenter);
        aVar.j(new GuildFeedPreloadDetailInfoScroller());
        return aVar;
    }
}
