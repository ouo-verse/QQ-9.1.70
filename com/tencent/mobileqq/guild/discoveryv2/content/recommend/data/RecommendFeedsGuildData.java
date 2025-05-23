package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeedsGuild;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0015\u00a2\u0006\u0004\b9\u0010:J-\u0010\u0006\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\u0096\u0001J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\t\u0010\r\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u000eH\u00c6\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0013H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0015H\u00c6\u0003JA\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u0015H\u00c6\u0001J\t\u0010\u001e\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010 H\u00d6\u0003R\u001a\u0010\u0017\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010\u0018\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010(R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0017\u0010\u001a\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b/\u00100R\u0017\u0010\u001b\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001b\u00101\u001a\u0004\b2\u00103R\u0019\u00105\u001a\u0004\u0018\u0001048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendFeedsGuildData;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeedsGuild;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "kotlin.jvm.PlatformType", "getFeeds", "", "getItemType", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "newItem", "", "areContentsTheSame", "component1", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "component2", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendAbsFeedData;", "component3", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/j;", "component4", "", "component5", "recommendItem", "recommendExtData", "recommendFeeds", "layoutParams", "seq", "copy", "", "toString", "hashCode", "", "other", "equals", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeedsGuild;", "getRecommendItem", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeedsGuild;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "getRecommendExtData", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "Ljava/util/List;", "getRecommendFeeds", "()Ljava/util/List;", "setRecommendFeeds", "(Ljava/util/List;)V", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/j;", "getLayoutParams", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/j;", "J", "getSeq", "()J", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProFeedGuildInfo;", "feedGuildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProFeedGuildInfo;", "getFeedGuildInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProFeedGuildInfo;", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeedsGuild;Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;Ljava/util/List;Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/j;J)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class RecommendFeedsGuildData implements l<IGProContentRecommendFeedsGuild>, IGProContentRecommendFeedsGuild {
    private final /* synthetic */ IGProContentRecommendFeedsGuild $$delegate_0;

    @Nullable
    private final IGProFeedGuildInfo feedGuildInfo;

    @NotNull
    private final j layoutParams;

    @NotNull
    private final RecommendExtData recommendExtData;

    @NotNull
    private List<? extends RecommendAbsFeedData> recommendFeeds;

    @NotNull
    private final IGProContentRecommendFeedsGuild recommendItem;
    private final long seq;

    public RecommendFeedsGuildData(@NotNull IGProContentRecommendFeedsGuild recommendItem, @NotNull RecommendExtData recommendExtData, @NotNull List<? extends RecommendAbsFeedData> recommendFeeds, @NotNull j layoutParams, long j3) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(recommendItem, "recommendItem");
        Intrinsics.checkNotNullParameter(recommendExtData, "recommendExtData");
        Intrinsics.checkNotNullParameter(recommendFeeds, "recommendFeeds");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        this.recommendItem = recommendItem;
        this.recommendExtData = recommendExtData;
        this.recommendFeeds = recommendFeeds;
        this.layoutParams = layoutParams;
        this.seq = j3;
        this.$$delegate_0 = recommendItem;
        ArrayList<IGProContentRecommendFeed> feeds = getRecommendItem().getFeeds();
        Intrinsics.checkNotNullExpressionValue(feeds, "recommendItem.feeds");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) feeds);
        IGProContentRecommendFeed iGProContentRecommendFeed = (IGProContentRecommendFeed) firstOrNull;
        this.feedGuildInfo = iGProContentRecommendFeed != null ? iGProContentRecommendFeed.getGuildInfo() : null;
    }

    public static /* synthetic */ RecommendFeedsGuildData copy$default(RecommendFeedsGuildData recommendFeedsGuildData, IGProContentRecommendFeedsGuild iGProContentRecommendFeedsGuild, RecommendExtData recommendExtData, List list, j jVar, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            iGProContentRecommendFeedsGuild = recommendFeedsGuildData.getRecommendItem();
        }
        if ((i3 & 2) != 0) {
            recommendExtData = recommendFeedsGuildData.getRecommendExtData();
        }
        RecommendExtData recommendExtData2 = recommendExtData;
        if ((i3 & 4) != 0) {
            list = recommendFeedsGuildData.recommendFeeds;
        }
        List list2 = list;
        if ((i3 & 8) != 0) {
            jVar = recommendFeedsGuildData.layoutParams;
        }
        j jVar2 = jVar;
        if ((i3 & 16) != 0) {
            j3 = recommendFeedsGuildData.seq;
        }
        return recommendFeedsGuildData.copy(iGProContentRecommendFeedsGuild, recommendExtData2, list2, jVar2, j3);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if ((newItem instanceof RecommendFeedsGuildData) && l.a.a(this, newItem) && ((RecommendFeedsGuildData) newItem).seq == this.seq) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h hVar) {
        return l.a.b(this, hVar);
    }

    @NotNull
    public final IGProContentRecommendFeedsGuild component1() {
        return getRecommendItem();
    }

    @NotNull
    public final RecommendExtData component2() {
        return getRecommendExtData();
    }

    @NotNull
    public final List<RecommendAbsFeedData> component3() {
        return this.recommendFeeds;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final j getLayoutParams() {
        return this.layoutParams;
    }

    /* renamed from: component5, reason: from getter */
    public final long getSeq() {
        return this.seq;
    }

    @NotNull
    public final RecommendFeedsGuildData copy(@NotNull IGProContentRecommendFeedsGuild recommendItem, @NotNull RecommendExtData recommendExtData, @NotNull List<? extends RecommendAbsFeedData> recommendFeeds, @NotNull j layoutParams, long seq) {
        Intrinsics.checkNotNullParameter(recommendItem, "recommendItem");
        Intrinsics.checkNotNullParameter(recommendExtData, "recommendExtData");
        Intrinsics.checkNotNullParameter(recommendFeeds, "recommendFeeds");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        return new RecommendFeedsGuildData(recommendItem, recommendExtData, recommendFeeds, layoutParams, seq);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecommendFeedsGuildData)) {
            return false;
        }
        RecommendFeedsGuildData recommendFeedsGuildData = (RecommendFeedsGuildData) other;
        if (Intrinsics.areEqual(getRecommendItem(), recommendFeedsGuildData.getRecommendItem()) && Intrinsics.areEqual(getRecommendExtData(), recommendFeedsGuildData.getRecommendExtData()) && Intrinsics.areEqual(this.recommendFeeds, recommendFeedsGuildData.recommendFeeds) && Intrinsics.areEqual(this.layoutParams, recommendFeedsGuildData.layoutParams) && this.seq == recommendFeedsGuildData.seq) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h hVar) {
        return l.a.c(this, hVar);
    }

    @Nullable
    public final IGProFeedGuildInfo getFeedGuildInfo() {
        return this.feedGuildInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeedsGuild
    public ArrayList<IGProContentRecommendFeed> getFeeds() {
        return this.$$delegate_0.getFeeds();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l, com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public long getItemId() {
        return l.a.d(this);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public int getItemType() {
        return com.tencent.mobileqq.guild.discoveryv2.content.base.h.INSTANCE.r();
    }

    @NotNull
    public final j getLayoutParams() {
        return this.layoutParams;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    public RecommendExtData getRecommendExtData() {
        return this.recommendExtData;
    }

    @NotNull
    public final List<RecommendAbsFeedData> getRecommendFeeds() {
        return this.recommendFeeds;
    }

    public final long getSeq() {
        return this.seq;
    }

    public int hashCode() {
        return (((((((getRecommendItem().hashCode() * 31) + getRecommendExtData().hashCode()) * 31) + this.recommendFeeds.hashCode()) * 31) + this.layoutParams.hashCode()) * 31) + androidx.fragment.app.a.a(this.seq);
    }

    public final void setRecommendFeeds(@NotNull List<? extends RecommendAbsFeedData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.recommendFeeds = list;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeedsGuild
    @NotNull
    public String toString() {
        return "RecommendFeedsGuildData(recommendItem=" + getRecommendItem() + ", recommendExtData=" + getRecommendExtData() + ", recommendFeeds=" + this.recommendFeeds + ", layoutParams=" + this.layoutParams + ", seq=" + this.seq + ")";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    public IGProContentRecommendFeedsGuild getRecommendItem() {
        return this.recommendItem;
    }

    public /* synthetic */ RecommendFeedsGuildData(IGProContentRecommendFeedsGuild iGProContentRecommendFeedsGuild, RecommendExtData recommendExtData, List list, j jVar, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(iGProContentRecommendFeedsGuild, recommendExtData, (i3 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, jVar, (i3 & 16) != 0 ? 0L : j3);
    }
}
