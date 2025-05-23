package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001\nBG\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u001d\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u0018\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014R\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/v;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "f", "()J", "guildId", "b", "channelId", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "feedId", "g", "posterId", "e", WadlProxyConsts.CREATE_TIME, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", QCircleScheme.AttrDetail.FEED_INFO, tl.h.F, "title", "desc", "<init>", "(JJLjava/lang/String;Ljava/lang/String;JLcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;Ljava/lang/String;Ljava/lang/String;)V", "i", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.morepanel.handler.v, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildFeedShareToWXInfo {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String feedId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String posterId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long createTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GProStFeed feedInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ0\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/v$a;", "", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "title", "desc", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/v;", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.morepanel.handler.v$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final GuildFeedShareToWXInfo a(@NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull String title, @NotNull String desc) {
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(desc, "desc");
            if (!(panelContext.j().a() instanceof GProStFeed)) {
                return null;
            }
            long guildId = panelContext.j().getGuildId();
            long channelId = panelContext.j().getChannelId();
            String feedId = panelContext.j().getFeedId();
            String r16 = panelContext.j().r();
            long createTime = panelContext.j().getCreateTime();
            Object a16 = panelContext.j().a();
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
            return new GuildFeedShareToWXInfo(guildId, channelId, feedId, r16, createTime, (GProStFeed) a16, title, desc);
        }

        Companion() {
        }
    }

    public GuildFeedShareToWXInfo(long j3, long j16, @NotNull String feedId, @NotNull String posterId, long j17, @NotNull GProStFeed feedInfo, @NotNull String title, @NotNull String desc) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(posterId, "posterId");
        Intrinsics.checkNotNullParameter(feedInfo, "feedInfo");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.guildId = j3;
        this.channelId = j16;
        this.feedId = feedId;
        this.posterId = posterId;
        this.createTime = j17;
        this.feedInfo = feedInfo;
        this.title = title;
        this.desc = desc;
    }

    /* renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: b, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final GProStFeed getFeedInfo() {
        return this.feedInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildFeedShareToWXInfo)) {
            return false;
        }
        GuildFeedShareToWXInfo guildFeedShareToWXInfo = (GuildFeedShareToWXInfo) other;
        if (this.guildId == guildFeedShareToWXInfo.guildId && this.channelId == guildFeedShareToWXInfo.channelId && Intrinsics.areEqual(this.feedId, guildFeedShareToWXInfo.feedId) && Intrinsics.areEqual(this.posterId, guildFeedShareToWXInfo.posterId) && this.createTime == guildFeedShareToWXInfo.createTime && Intrinsics.areEqual(this.feedInfo, guildFeedShareToWXInfo.feedInfo) && Intrinsics.areEqual(this.title, guildFeedShareToWXInfo.title) && Intrinsics.areEqual(this.desc, guildFeedShareToWXInfo.desc)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getPosterId() {
        return this.posterId;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((((((androidx.fragment.app.a.a(this.guildId) * 31) + androidx.fragment.app.a.a(this.channelId)) * 31) + this.feedId.hashCode()) * 31) + this.posterId.hashCode()) * 31) + androidx.fragment.app.a.a(this.createTime)) * 31) + this.feedInfo.hashCode()) * 31) + this.title.hashCode()) * 31) + this.desc.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildFeedShareToWXInfo(guildId=" + this.guildId + ", channelId=" + this.channelId + ", feedId=" + this.feedId + ", posterId=" + this.posterId + ", createTime=" + this.createTime + ", feedInfo=" + this.feedInfo + ", title=" + this.title + ", desc=" + this.desc + ")";
    }
}
