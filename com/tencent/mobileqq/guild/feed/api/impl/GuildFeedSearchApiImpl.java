package com.tencent.mobileqq.guild.feed.api.impl;

import com.tencent.mobileqq.guild.feed.api.IGuildFeedSearchApi;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pn1.SearchDataExt;
import zg1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u000b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t0\bH\u0016J,\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedSearchApiImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedSearchApi;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/GProStFeedDetailRspWrapper;", "displayable", "Lpn1/b;", "ext", "Lpn1/a;", "toSearchFeedData", "", "Lzg1/c;", "Lzg1/b;", "getFeedSearchListAdapterDelegates", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "gproStFeed", "", "", "highlightKeywords", "traceId", "Lzg1/a;", "convertToFeedItem", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSearchApiImpl implements IGuildFeedSearchApi {
    private final pn1.a toSearchFeedData(GProStFeedDetailRspWrapper displayable, SearchDataExt ext) {
        int o16 = displayable.o();
        if (o16 != 2) {
            if (o16 != 3) {
                if (o16 != 8) {
                    if (o16 != 9) {
                        return new pn1.d(displayable, ext);
                    }
                    return new pn1.g(displayable, ext);
                }
                return new pn1.h(displayable, ext);
            }
            return new pn1.f(displayable, ext);
        }
        return new pn1.e(displayable, ext);
    }

    static /* synthetic */ pn1.a toSearchFeedData$default(GuildFeedSearchApiImpl guildFeedSearchApiImpl, GProStFeedDetailRspWrapper gProStFeedDetailRspWrapper, SearchDataExt searchDataExt, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            searchDataExt = null;
        }
        return guildFeedSearchApiImpl.toSearchFeedData(gProStFeedDetailRspWrapper, searchDataExt);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedSearchApi
    @Nullable
    public zg1.a convertToFeedItem(@Nullable GProStFeed gproStFeed, @Nullable Collection<String> highlightKeywords, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        if (gproStFeed == null) {
            return null;
        }
        if (gproStFeed.feedType == 2) {
            return new pn1.c(new GProStFeedDetailRspWrapper(gproStFeed, null, 2, null), new SearchDataExt(highlightKeywords, traceId));
        }
        return toSearchFeedData(new GProStFeedDetailRspWrapper(gproStFeed, null, 2, null), new SearchDataExt(highlightKeywords, traceId));
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedSearchApi
    @NotNull
    public List<zg1.c<zg1.b<?>>> getFeedSearchListAdapterDelegates() {
        List<zg1.c<zg1.b<?>>> listOf;
        a.Companion companion = zg1.a.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new zg1.c[]{new qn1.b(companion.c()), new qn1.c(companion.d()), new qn1.d(companion.e()), new qn1.f(companion.g()), new qn1.e(companion.f()), new qn1.a(companion.a())});
        return listOf;
    }
}
