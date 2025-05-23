package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0010\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BM\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\u0006\u0010\u001e\u001a\u00020\b\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020\b\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\u001e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013R\u0017\u0010!\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001f\u001a\u0004\b\u0016\u0010 R\u0017\u0010\"\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/d;", "T", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildId", "b", "channelId", "Z", tl.h.F, "()Z", "isSquare", "", "d", "Ljava/util/List;", "()Ljava/util/List;", "feedList", "e", "f", "isFinish", "g", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "I", "()I", "sortMode", QAdRewardDefine$VideoParams.ISCACHE, "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;ZZIZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class d<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isSquare;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<T> feedList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isFinish;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isLoadMore;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int sortMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isCache;

    public d(@NotNull String guildId, @NotNull String channelId, boolean z16, @NotNull List<T> feedList, boolean z17, boolean z18, int i3, boolean z19) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(feedList, "feedList");
        this.guildId = guildId;
        this.channelId = channelId;
        this.isSquare = z16;
        this.feedList = feedList;
        this.isFinish = z17;
        this.isLoadMore = z18;
        this.sortMode = i3;
        this.isCache = z19;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final List<T> b() {
        return this.feedList;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: d, reason: from getter */
    public final int getSortMode() {
        return this.sortMode;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsCache() {
        return this.isCache;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (Intrinsics.areEqual(this.guildId, dVar.guildId) && Intrinsics.areEqual(this.channelId, dVar.channelId) && this.isSquare == dVar.isSquare && Intrinsics.areEqual(this.feedList, dVar.feedList) && this.isFinish == dVar.isFinish && this.isLoadMore == dVar.isLoadMore && this.sortMode == dVar.sortMode && this.isCache == dVar.isCache) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsFinish() {
        return this.isFinish;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsLoadMore() {
        return this.isLoadMore;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsSquare() {
        return this.isSquare;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31;
        boolean z16 = this.isSquare;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode2 = (((hashCode + i16) * 31) + this.feedList.hashCode()) * 31;
        boolean z17 = this.isFinish;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int i18 = (hashCode2 + i17) * 31;
        boolean z18 = this.isLoadMore;
        int i19 = z18;
        if (z18 != 0) {
            i19 = 1;
        }
        int i26 = (((i18 + i19) * 31) + this.sortMode) * 31;
        boolean z19 = this.isCache;
        if (!z19) {
            i3 = z19 ? 1 : 0;
        }
        return i26 + i3;
    }

    @NotNull
    public String toString() {
        return "guildId:" + this.guildId + " channelId:" + this.channelId + " isSquare:" + this.isSquare + " feedListSize:" + this.feedList.size() + " isFinish:" + this.isFinish + " isLoadMore:" + this.isLoadMore + " sortMode:" + this.sortMode + " isCache:" + this.isCache;
    }
}
