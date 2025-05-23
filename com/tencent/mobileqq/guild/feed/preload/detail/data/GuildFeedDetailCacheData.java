package com.tencent.mobileqq.guild.feed.preload.detail.data;

import androidx.annotation.Keep;
import androidx.fragment.app.a;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\u0006\u0010\u001b\u001a\u00020\u0017J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailCacheData;", "", "feedId", "", "feedJson", "feedContentBean", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "lastModifyTime", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;J)V", "getFeedContentBean", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "getFeedId", "()Ljava/lang/String;", "getFeedJson", "getLastModifyTime", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", AppConstants.Key.COLUMN_IS_VALID, "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class GuildFeedDetailCacheData {

    @Nullable
    private final GProStFeed feedContentBean;

    @NotNull
    private final String feedId;

    @NotNull
    private final String feedJson;
    private final long lastModifyTime;

    public GuildFeedDetailCacheData(@NotNull String feedId, @NotNull String feedJson, @Nullable GProStFeed gProStFeed, long j3) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(feedJson, "feedJson");
        this.feedId = feedId;
        this.feedJson = feedJson;
        this.feedContentBean = gProStFeed;
        this.lastModifyTime = j3;
    }

    public static /* synthetic */ GuildFeedDetailCacheData copy$default(GuildFeedDetailCacheData guildFeedDetailCacheData, String str, String str2, GProStFeed gProStFeed, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = guildFeedDetailCacheData.feedId;
        }
        if ((i3 & 2) != 0) {
            str2 = guildFeedDetailCacheData.feedJson;
        }
        String str3 = str2;
        if ((i3 & 4) != 0) {
            gProStFeed = guildFeedDetailCacheData.feedContentBean;
        }
        GProStFeed gProStFeed2 = gProStFeed;
        if ((i3 & 8) != 0) {
            j3 = guildFeedDetailCacheData.lastModifyTime;
        }
        return guildFeedDetailCacheData.copy(str, str3, gProStFeed2, j3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getFeedJson() {
        return this.feedJson;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final GProStFeed getFeedContentBean() {
        return this.feedContentBean;
    }

    /* renamed from: component4, reason: from getter */
    public final long getLastModifyTime() {
        return this.lastModifyTime;
    }

    @NotNull
    public final GuildFeedDetailCacheData copy(@NotNull String feedId, @NotNull String feedJson, @Nullable GProStFeed feedContentBean, long lastModifyTime) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(feedJson, "feedJson");
        return new GuildFeedDetailCacheData(feedId, feedJson, feedContentBean, lastModifyTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildFeedDetailCacheData)) {
            return false;
        }
        GuildFeedDetailCacheData guildFeedDetailCacheData = (GuildFeedDetailCacheData) other;
        if (Intrinsics.areEqual(this.feedId, guildFeedDetailCacheData.feedId) && Intrinsics.areEqual(this.feedJson, guildFeedDetailCacheData.feedJson) && Intrinsics.areEqual(this.feedContentBean, guildFeedDetailCacheData.feedContentBean) && this.lastModifyTime == guildFeedDetailCacheData.lastModifyTime) {
            return true;
        }
        return false;
    }

    @Nullable
    public final GProStFeed getFeedContentBean() {
        return this.feedContentBean;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    public final String getFeedJson() {
        return this.feedJson;
    }

    public final long getLastModifyTime() {
        return this.lastModifyTime;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.feedId.hashCode() * 31) + this.feedJson.hashCode()) * 31;
        GProStFeed gProStFeed = this.feedContentBean;
        if (gProStFeed == null) {
            hashCode = 0;
        } else {
            hashCode = gProStFeed.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + a.a(this.lastModifyTime);
    }

    public final boolean isValid() {
        boolean z16;
        boolean z17;
        if (this.feedId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (this.feedJson.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && this.lastModifyTime > 0) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "GuildFeedDetailCacheData(feedId=" + this.feedId + ", feedJson=" + this.feedJson + ", feedContentBean=" + this.feedContentBean + ", lastModifyTime=" + this.lastModifyTime + ")";
    }

    public /* synthetic */ GuildFeedDetailCacheData(String str, String str2, GProStFeed gProStFeed, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? null : gProStFeed, j3);
    }
}
