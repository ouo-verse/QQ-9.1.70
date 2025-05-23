package com.tencent.mobileqq.guild.feed.preload.detail.data;

import androidx.annotation.Keep;
import androidx.fragment.app.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\u0006\u0010!\u001a\u00020\u001dJ\t\u0010\"\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailPreloadParams;", "", "guildId", "", "channelId", "feedId", "", "userId", WadlProxyConsts.CREATE_TIME, "lastModifyTime", "(JJLjava/lang/String;Ljava/lang/String;JJ)V", "getChannelId", "()J", "getCreateTime", "getFeedId", "()Ljava/lang/String;", "getGuildId", "getLastModifyTime", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "covertToStFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "equals", "", "other", "hashCode", "", AppConstants.Key.COLUMN_IS_VALID, "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class GuildFeedDetailPreloadParams {
    private final long channelId;
    private final long createTime;

    @NotNull
    private final String feedId;
    private final long guildId;
    private final long lastModifyTime;

    @NotNull
    private final String userId;

    public GuildFeedDetailPreloadParams(long j3, long j16, @NotNull String feedId, @NotNull String userId, long j17, long j18) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.guildId = j3;
        this.channelId = j16;
        this.feedId = feedId;
        this.userId = userId;
        this.createTime = j17;
        this.lastModifyTime = j18;
    }

    public static /* synthetic */ GuildFeedDetailPreloadParams copy$default(GuildFeedDetailPreloadParams guildFeedDetailPreloadParams, long j3, long j16, String str, String str2, long j17, long j18, int i3, Object obj) {
        long j19;
        long j26;
        String str3;
        String str4;
        long j27;
        long j28;
        if ((i3 & 1) != 0) {
            j19 = guildFeedDetailPreloadParams.guildId;
        } else {
            j19 = j3;
        }
        if ((i3 & 2) != 0) {
            j26 = guildFeedDetailPreloadParams.channelId;
        } else {
            j26 = j16;
        }
        if ((i3 & 4) != 0) {
            str3 = guildFeedDetailPreloadParams.feedId;
        } else {
            str3 = str;
        }
        if ((i3 & 8) != 0) {
            str4 = guildFeedDetailPreloadParams.userId;
        } else {
            str4 = str2;
        }
        if ((i3 & 16) != 0) {
            j27 = guildFeedDetailPreloadParams.createTime;
        } else {
            j27 = j17;
        }
        if ((i3 & 32) != 0) {
            j28 = guildFeedDetailPreloadParams.lastModifyTime;
        } else {
            j28 = j18;
        }
        return guildFeedDetailPreloadParams.copy(j19, j26, str3, str4, j27, j28);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component5, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    /* renamed from: component6, reason: from getter */
    public final long getLastModifyTime() {
        return this.lastModifyTime;
    }

    @NotNull
    public final GuildFeedDetailPreloadParams copy(long guildId, long channelId, @NotNull String feedId, @NotNull String userId, long createTime, long lastModifyTime) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        return new GuildFeedDetailPreloadParams(guildId, channelId, feedId, userId, createTime, lastModifyTime);
    }

    @NotNull
    public final GProStFeed covertToStFeed() {
        GProStFeed gProStFeed = new GProStFeed();
        gProStFeed.idd = this.feedId;
        gProStFeed.createTime = this.createTime;
        gProStFeed.poster.idd = this.userId;
        gProStFeed.meta.lastModifiedTime = this.lastModifyTime;
        GProStChannelSign gProStChannelSign = gProStFeed.channelInfo.sign;
        gProStChannelSign.channelId = this.channelId;
        gProStChannelSign.guildId = this.guildId;
        return gProStFeed;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildFeedDetailPreloadParams)) {
            return false;
        }
        GuildFeedDetailPreloadParams guildFeedDetailPreloadParams = (GuildFeedDetailPreloadParams) other;
        if (this.guildId == guildFeedDetailPreloadParams.guildId && this.channelId == guildFeedDetailPreloadParams.channelId && Intrinsics.areEqual(this.feedId, guildFeedDetailPreloadParams.feedId) && Intrinsics.areEqual(this.userId, guildFeedDetailPreloadParams.userId) && this.createTime == guildFeedDetailPreloadParams.createTime && this.lastModifyTime == guildFeedDetailPreloadParams.lastModifyTime) {
            return true;
        }
        return false;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final long getLastModifyTime() {
        return this.lastModifyTime;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((((((((a.a(this.guildId) * 31) + a.a(this.channelId)) * 31) + this.feedId.hashCode()) * 31) + this.userId.hashCode()) * 31) + a.a(this.createTime)) * 31) + a.a(this.lastModifyTime);
    }

    public final boolean isValid() {
        boolean z16;
        boolean z17;
        if (this.guildId <= 0 || this.channelId <= 0) {
            return false;
        }
        if (this.feedId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (this.userId.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17 || this.createTime <= 0) {
            return false;
        }
        return true;
    }

    @NotNull
    public String toString() {
        return "GuildFeedDetailPreloadParams(guildId=" + this.guildId + ", channelId=" + this.channelId + ", feedId=" + this.feedId + ", userId=" + this.userId + ", createTime=" + this.createTime + ", lastModifyTime=" + this.lastModifyTime + ")";
    }
}
