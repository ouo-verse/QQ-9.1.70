package com.tencent.mobileqq.guild.feed.performance.report;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0011\b\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u0014\u0010\tR$\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/performance/report/d;", "", "", "toString", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setMFeedId$qqguild_feed_impl_release", "(Ljava/lang/String;)V", "mFeedId", "d", "setMGuildId$qqguild_feed_impl_release", "mGuildId", "c", "setMChannelId$qqguild_feed_impl_release", "mChannelId", "e", "setMPosterTinyId$qqguild_feed_impl_release", "mPosterTinyId", "setMFrom$qqguild_feed_impl_release", "mFrom", "", "f", "Ljava/lang/Long;", "()Ljava/lang/Long;", "setMStartTime$qqguild_feed_impl_release", "(Ljava/lang/Long;)V", "mStartTime", "Lcom/tencent/mobileqq/guild/feed/performance/report/d$a;", "builder", "<init>", "(Lcom/tencent/mobileqq/guild/feed/performance/report/d$a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.performance.report.d, reason: from toString */
/* loaded from: classes13.dex */
public final class GuildFeedDetailInitData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String mFeedId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String mGuildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String mChannelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String mPosterTinyId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String mFrom;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Long mStartTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\"\u0010\u0016R$\u0010)\u001a\u0004\u0018\u00010\r8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/performance/report/d$a;", "", "", "feedId", "i", "guildId", "k", "channelId", tl.h.F, "posterTinyId", "l", "from", "j", "", "startTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/performance/report/d;", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setMFeedId$qqguild_feed_impl_release", "(Ljava/lang/String;)V", "mFeedId", "b", "e", "setMGuildId$qqguild_feed_impl_release", "mGuildId", "setMChannelId$qqguild_feed_impl_release", "mChannelId", "d", "f", "setMPosterTinyId$qqguild_feed_impl_release", "mPosterTinyId", "setMFrom$qqguild_feed_impl_release", "mFrom", "Ljava/lang/Long;", "g", "()Ljava/lang/Long;", "setMStartTime$qqguild_feed_impl_release", "(Ljava/lang/Long;)V", "mStartTime", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.performance.report.d$a */
    /* loaded from: classes13.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String mFeedId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String mGuildId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String mChannelId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String mPosterTinyId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String mFrom;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Long mStartTime;

        @NotNull
        public final GuildFeedDetailInitData a() {
            return new GuildFeedDetailInitData(this, null);
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getMChannelId() {
            return this.mChannelId;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getMFeedId() {
            return this.mFeedId;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getMFrom() {
            return this.mFrom;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final String getMGuildId() {
            return this.mGuildId;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final String getMPosterTinyId() {
            return this.mPosterTinyId;
        }

        @Nullable
        /* renamed from: g, reason: from getter */
        public final Long getMStartTime() {
            return this.mStartTime;
        }

        @NotNull
        public final a h(@NotNull String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.mChannelId = channelId;
            return this;
        }

        @NotNull
        public final a i(@NotNull String feedId) {
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            this.mFeedId = feedId;
            return this;
        }

        @NotNull
        public final a j(@NotNull String from) {
            Intrinsics.checkNotNullParameter(from, "from");
            this.mFrom = from;
            return this;
        }

        @NotNull
        public final a k(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            this.mGuildId = guildId;
            return this;
        }

        @NotNull
        public final a l(@NotNull String posterTinyId) {
            Intrinsics.checkNotNullParameter(posterTinyId, "posterTinyId");
            this.mPosterTinyId = posterTinyId;
            return this;
        }

        @NotNull
        public final a m(long startTime) {
            this.mStartTime = Long.valueOf(startTime);
            return this;
        }
    }

    public /* synthetic */ GuildFeedDetailInitData(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getMChannelId() {
        return this.mChannelId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getMFeedId() {
        return this.mFeedId;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getMFrom() {
        return this.mFrom;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getMGuildId() {
        return this.mGuildId;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getMPosterTinyId() {
        return this.mPosterTinyId;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final Long getMStartTime() {
        return this.mStartTime;
    }

    @NotNull
    public String toString() {
        return "GuildFeedDetailInitData(mFeedId=" + this.mFeedId + ", mGuildId=" + this.mGuildId + ", mChannelId=" + this.mChannelId + ", mPosterTinyId=" + this.mPosterTinyId + ", mFrom=" + this.mFrom + ", mStartTime=" + this.mStartTime + ")";
    }

    GuildFeedDetailInitData(a aVar) {
        this.mFeedId = aVar.getMFeedId();
        this.mGuildId = aVar.getMGuildId();
        this.mChannelId = aVar.getMChannelId();
        this.mPosterTinyId = aVar.getMPosterTinyId();
        this.mFrom = aVar.getMFrom();
        this.mStartTime = aVar.getMStartTime();
    }
}
