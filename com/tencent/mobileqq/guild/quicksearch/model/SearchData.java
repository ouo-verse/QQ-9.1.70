package com.tencent.mobileqq.guild.quicksearch.model;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001a\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/model/d;", "", "", "d", "e", "", "toString", "", "hashCode", "other", "equals", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;", "setAiSearchInfo", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;)V", "aiSearchInfo", "", "Lzg1/a;", "b", "Ljava/util/List;", "()Ljava/util/List;", "setFeedList", "(Ljava/util/List;)V", "feedList", "Lcom/tencent/mobileqq/guild/quicksearch/model/GuildSearchActionSource;", "c", "Lcom/tencent/mobileqq/guild/quicksearch/model/GuildSearchActionSource;", "()Lcom/tencent/mobileqq/guild/quicksearch/model/GuildSearchActionSource;", "source", "Z", "getNoMoreFeed", "()Z", "noMoreFeed", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;Ljava/util/List;Lcom/tencent/mobileqq/guild/quicksearch/model/GuildSearchActionSource;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.quicksearch.model.d, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class SearchData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private IGProGuildSearchAISearchInfo aiSearchInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<zg1.a> feedList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GuildSearchActionSource source;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean noMoreFeed;

    public SearchData() {
        this(null, null, null, false, 15, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final IGProGuildSearchAISearchInfo getAiSearchInfo() {
        return this.aiSearchInfo;
    }

    @NotNull
    public final List<zg1.a> b() {
        return this.feedList;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final GuildSearchActionSource getSource() {
        return this.source;
    }

    public final boolean d() {
        if (this.aiSearchInfo == null && this.feedList.isEmpty()) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        if (this.noMoreFeed && !d()) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchData)) {
            return false;
        }
        SearchData searchData = (SearchData) other;
        if (Intrinsics.areEqual(this.aiSearchInfo, searchData.aiSearchInfo) && Intrinsics.areEqual(this.feedList, searchData.feedList) && this.source == searchData.source && this.noMoreFeed == searchData.noMoreFeed) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IGProGuildSearchAISearchInfo iGProGuildSearchAISearchInfo = this.aiSearchInfo;
        if (iGProGuildSearchAISearchInfo == null) {
            hashCode = 0;
        } else {
            hashCode = iGProGuildSearchAISearchInfo.hashCode();
        }
        int hashCode2 = ((((hashCode * 31) + this.feedList.hashCode()) * 31) + this.source.hashCode()) * 31;
        boolean z16 = this.noMoreFeed;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode2 + i3;
    }

    @NotNull
    public String toString() {
        return "SearchData(aiSearchInfo=" + this.aiSearchInfo + ", feedList=" + this.feedList + ", source=" + this.source + ", noMoreFeed=" + this.noMoreFeed + ")";
    }

    public SearchData(@Nullable IGProGuildSearchAISearchInfo iGProGuildSearchAISearchInfo, @NotNull List<zg1.a> feedList, @NotNull GuildSearchActionSource source, boolean z16) {
        Intrinsics.checkNotNullParameter(feedList, "feedList");
        Intrinsics.checkNotNullParameter(source, "source");
        this.aiSearchInfo = iGProGuildSearchAISearchInfo;
        this.feedList = feedList;
        this.source = source;
        this.noMoreFeed = z16;
    }

    public /* synthetic */ SearchData(IGProGuildSearchAISearchInfo iGProGuildSearchAISearchInfo, List list, GuildSearchActionSource guildSearchActionSource, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : iGProGuildSearchAISearchInfo, (i3 & 2) != 0 ? new ArrayList() : list, (i3 & 4) != 0 ? GuildSearchActionSource.DEFAULT : guildSearchActionSource, (i3 & 8) != 0 ? true : z16);
    }
}
