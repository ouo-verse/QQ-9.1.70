package com.tencent.mobileqq.guild.discovery.mine.util;

import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b\u0016\u0010\f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/mine/util/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "guildId", "channelId", "c", "d", "joinGuildSig", "joinGuildMainSource", "e", "joinGuildSubSource", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "f", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "getCompleteGuildInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "completeGuildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "g", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "getCompleteChannelInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "completeChannelInfo", h.F, "traceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.discovery.mine.util.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class MediaChannelParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String joinGuildSig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String joinGuildMainSource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String joinGuildSubSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IGProGuildInfo completeGuildInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IGProChannelInfo completeChannelInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String traceId;

    public MediaChannelParams(@NotNull String guildId, @NotNull String channelId, @NotNull String joinGuildSig, @NotNull String joinGuildMainSource, @NotNull String joinGuildSubSource, @Nullable IGProGuildInfo iGProGuildInfo, @Nullable IGProChannelInfo iGProChannelInfo, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(joinGuildSig, "joinGuildSig");
        Intrinsics.checkNotNullParameter(joinGuildMainSource, "joinGuildMainSource");
        Intrinsics.checkNotNullParameter(joinGuildSubSource, "joinGuildSubSource");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.guildId = guildId;
        this.channelId = channelId;
        this.joinGuildSig = joinGuildSig;
        this.joinGuildMainSource = joinGuildMainSource;
        this.joinGuildSubSource = joinGuildSubSource;
        this.completeGuildInfo = iGProGuildInfo;
        this.completeChannelInfo = iGProChannelInfo;
        this.traceId = traceId;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getJoinGuildMainSource() {
        return this.joinGuildMainSource;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getJoinGuildSubSource() {
        return this.joinGuildSubSource;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaChannelParams)) {
            return false;
        }
        MediaChannelParams mediaChannelParams = (MediaChannelParams) other;
        if (Intrinsics.areEqual(this.guildId, mediaChannelParams.guildId) && Intrinsics.areEqual(this.channelId, mediaChannelParams.channelId) && Intrinsics.areEqual(this.joinGuildSig, mediaChannelParams.joinGuildSig) && Intrinsics.areEqual(this.joinGuildMainSource, mediaChannelParams.joinGuildMainSource) && Intrinsics.areEqual(this.joinGuildSubSource, mediaChannelParams.joinGuildSubSource) && Intrinsics.areEqual(this.completeGuildInfo, mediaChannelParams.completeGuildInfo) && Intrinsics.areEqual(this.completeChannelInfo, mediaChannelParams.completeChannelInfo) && Intrinsics.areEqual(this.traceId, mediaChannelParams.traceId)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.joinGuildSig.hashCode()) * 31) + this.joinGuildMainSource.hashCode()) * 31) + this.joinGuildSubSource.hashCode()) * 31;
        IGProGuildInfo iGProGuildInfo = this.completeGuildInfo;
        int i3 = 0;
        if (iGProGuildInfo == null) {
            hashCode = 0;
        } else {
            hashCode = iGProGuildInfo.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        IGProChannelInfo iGProChannelInfo = this.completeChannelInfo;
        if (iGProChannelInfo != null) {
            i3 = iGProChannelInfo.hashCode();
        }
        return ((i16 + i3) * 31) + this.traceId.hashCode();
    }

    @NotNull
    public String toString() {
        return "MediaChannelParams(guildId=" + this.guildId + ", channelId=" + this.channelId + ", joinGuildSig=" + this.joinGuildSig + ", joinGuildMainSource=" + this.joinGuildMainSource + ", joinGuildSubSource=" + this.joinGuildSubSource + ", completeGuildInfo=" + this.completeGuildInfo + ", completeChannelInfo=" + this.completeChannelInfo + ", traceId=" + this.traceId + ")";
    }
}
