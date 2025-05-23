package com.tencent.mobileqq.guild.share.util;

import com.tencent.mobileqq.guild.share.y;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\nB1\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\n\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u001aR\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/share/util/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "e", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "c", "I", "()I", "businessType", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "defaultTitle", "desc", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;ILjava/lang/String;Ljava/lang/String;)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.share.util.f, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildShareToWXInfo {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IGProGuildInfo guildInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IGProChannelInfo channelInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int businessType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String defaultTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/share/util/f$a;", "", "Lcom/tencent/mobileqq/guild/share/y;", "shareInfoProvider", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/guild/share/util/f;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.share.util.f$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final GuildShareToWXInfo a(@NotNull y shareInfoProvider, @NotNull IGProGuildInfo guildInfo, @Nullable IGProChannelInfo channelInfo) {
            Intrinsics.checkNotNullParameter(shareInfoProvider, "shareInfoProvider");
            Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
            int h16 = shareInfoProvider.h();
            String q16 = shareInfoProvider.q();
            Intrinsics.checkNotNullExpressionValue(q16, "shareInfoProvider.prompt");
            String d16 = shareInfoProvider.d();
            Intrinsics.checkNotNullExpressionValue(d16, "shareInfoProvider.arkDesc");
            return new GuildShareToWXInfo(guildInfo, channelInfo, h16, q16, d16);
        }

        Companion() {
        }
    }

    public GuildShareToWXInfo(@NotNull IGProGuildInfo guildInfo, @Nullable IGProChannelInfo iGProChannelInfo, int i3, @NotNull String defaultTitle, @NotNull String desc) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(defaultTitle, "defaultTitle");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.guildInfo = guildInfo;
        this.channelInfo = iGProChannelInfo;
        this.businessType = i3;
        this.defaultTitle = defaultTitle;
        this.desc = desc;
    }

    @JvmStatic
    @NotNull
    public static final GuildShareToWXInfo f(@NotNull y yVar, @NotNull IGProGuildInfo iGProGuildInfo, @Nullable IGProChannelInfo iGProChannelInfo) {
        return INSTANCE.a(yVar, iGProGuildInfo, iGProChannelInfo);
    }

    /* renamed from: a, reason: from getter */
    public final int getBusinessType() {
        return this.businessType;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final IGProChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getDefaultTitle() {
        return this.defaultTitle;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final IGProGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildShareToWXInfo)) {
            return false;
        }
        GuildShareToWXInfo guildShareToWXInfo = (GuildShareToWXInfo) other;
        if (Intrinsics.areEqual(this.guildInfo, guildShareToWXInfo.guildInfo) && Intrinsics.areEqual(this.channelInfo, guildShareToWXInfo.channelInfo) && this.businessType == guildShareToWXInfo.businessType && Intrinsics.areEqual(this.defaultTitle, guildShareToWXInfo.defaultTitle) && Intrinsics.areEqual(this.desc, guildShareToWXInfo.desc)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.guildInfo.hashCode() * 31;
        IGProChannelInfo iGProChannelInfo = this.channelInfo;
        if (iGProChannelInfo == null) {
            hashCode = 0;
        } else {
            hashCode = iGProChannelInfo.hashCode();
        }
        return ((((((hashCode2 + hashCode) * 31) + this.businessType) * 31) + this.defaultTitle.hashCode()) * 31) + this.desc.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildShareToWXInfo(guildInfo=" + this.guildInfo + ", channelInfo=" + this.channelInfo + ", businessType=" + this.businessType + ", defaultTitle=" + this.defaultTitle + ", desc=" + this.desc + ")";
    }
}
