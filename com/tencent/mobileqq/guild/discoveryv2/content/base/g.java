package com.tencent.mobileqq.guild.discoveryv2.content.base;

import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.mobileqq.guild.api.FeedPreloadInfo;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/base/g;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/b;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "feed", "Lcom/tencent/mobileqq/guild/api/b;", "j", "", "fromIndex", "toIndex", "", "i", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "b", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "getAdapter", "()Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "adapter", "<init>", "(Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g extends b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AsyncListDifferDelegationAdapter<h> adapter;

    public g(@NotNull AsyncListDifferDelegationAdapter<h> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
    }

    private final FeedPreloadInfo j(IGProContentRecommendFeed feed) {
        String title = feed.getTitle();
        Intrinsics.checkNotNullExpressionValue(title, "feed.title");
        long guildId = feed.getGuildInfo().getGuildId();
        long channelId = feed.getGuildInfo().getChannelId();
        String idd = feed.getIdd();
        Intrinsics.checkNotNullExpressionValue(idd, "feed.idd");
        return new FeedPreloadInfo(title, guildId, channelId, idd, String.valueOf(feed.getPoster().getTinyId()), feed.getCreateTime(), feed.getLastModifiedTime());
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.b
    @NotNull
    public List<FeedPreloadInfo> i(int fromIndex, int toIndex) {
        RecommendAbsFeedData recommendAbsFeedData;
        IGProContentRecommendFeed iGProContentRecommendFeed;
        List<h> items = this.adapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "adapter.items");
        List<h> g16 = g(items, fromIndex, toIndex);
        ArrayList arrayList = new ArrayList();
        for (h hVar : g16) {
            FeedPreloadInfo feedPreloadInfo = null;
            if (hVar instanceof RecommendAbsFeedData) {
                recommendAbsFeedData = (RecommendAbsFeedData) hVar;
            } else {
                recommendAbsFeedData = null;
            }
            if (recommendAbsFeedData != null) {
                iGProContentRecommendFeed = recommendAbsFeedData.getRecommendItem();
            } else {
                iGProContentRecommendFeed = null;
            }
            if (iGProContentRecommendFeed != null && ((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).checkCanPreload(iGProContentRecommendFeed)) {
                feedPreloadInfo = j(iGProContentRecommendFeed);
            }
            if (feedPreloadInfo != null) {
                arrayList.add(feedPreloadInfo);
            }
        }
        return arrayList;
    }
}
