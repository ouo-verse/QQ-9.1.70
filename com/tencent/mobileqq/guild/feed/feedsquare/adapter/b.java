package com.tencent.mobileqq.guild.feed.feedsquare.adapter;

import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.mobileqq.guild.api.FeedPreloadInfo;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/b;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/b;", "", "fromIndex", "toIndex", "", "Lcom/tencent/mobileqq/guild/api/b;", "i", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "b", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "getAdapter", "()Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "adapter", "<init>", "(Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends com.tencent.mobileqq.guild.discoveryv2.content.base.b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AsyncListDifferDelegationAdapter<com.tencent.mobileqq.guild.feed.feedsquare.data.h> adapter;

    public b(@NotNull AsyncListDifferDelegationAdapter<com.tencent.mobileqq.guild.feed.feedsquare.data.h> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.b
    @NotNull
    public List<FeedPreloadInfo> i(int fromIndex, int toIndex) {
        FeedPreloadInfo feedPreloadInfo;
        List<com.tencent.mobileqq.guild.feed.feedsquare.data.h> items = this.adapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "adapter.items");
        List<com.tencent.mobileqq.guild.feed.feedsquare.data.h> g16 = g(items, fromIndex, toIndex);
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.guild.feed.feedsquare.data.h hVar : g16) {
            IGuildFeedNativeDetailApi iGuildFeedNativeDetailApi = (IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class);
            GProStFeed b16 = hVar.getBlockData().b();
            Intrinsics.checkNotNullExpressionValue(b16, "it.blockData.sourceData");
            if (!iGuildFeedNativeDetailApi.checkCanPreload(b16)) {
                feedPreloadInfo = null;
            } else {
                String str = hVar.getBlockData().b().poster.nick;
                Intrinsics.checkNotNullExpressionValue(str, "it.blockData.sourceData.poster.nick");
                long j3 = hVar.getBlockData().b().channelInfo.sign.guildId;
                long j16 = hVar.getBlockData().b().channelInfo.sign.channelId;
                String str2 = hVar.getBlockData().b().idd;
                Intrinsics.checkNotNullExpressionValue(str2, "it.blockData.sourceData.idd");
                String str3 = hVar.getBlockData().b().poster.idd;
                Intrinsics.checkNotNullExpressionValue(str3, "it.blockData.sourceData.poster.idd");
                feedPreloadInfo = new FeedPreloadInfo(str, j3, j16, str2, str3, hVar.getBlockData().b().createTime, hVar.getBlockData().b().meta.lastModifiedTime);
            }
            if (feedPreloadInfo != null) {
                arrayList.add(feedPreloadInfo);
            }
        }
        return arrayList;
    }
}
