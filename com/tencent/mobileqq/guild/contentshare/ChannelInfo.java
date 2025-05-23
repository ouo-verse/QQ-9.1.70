package com.tencent.mobileqq.guild.contentshare;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "guildId", "b", "getChannelId", "channelId", "c", "(Ljava/lang/String;)V", "shareUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.contentshare.c, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class ChannelInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String shareUrl;

    public ChannelInfo() {
        this(null, null, null, 7, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final void c(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareUrl = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelInfo)) {
            return false;
        }
        ChannelInfo channelInfo = (ChannelInfo) other;
        if (Intrinsics.areEqual(this.guildId, channelInfo.guildId) && Intrinsics.areEqual(this.channelId, channelInfo.channelId) && Intrinsics.areEqual(this.shareUrl, channelInfo.shareUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.shareUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "ChannelInfo(guildId=" + this.guildId + ", channelId=" + this.channelId + ", shareUrl=" + this.shareUrl + ')';
    }

    public ChannelInfo(@NotNull String guildId, @NotNull String channelId, @NotNull String shareUrl) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        this.guildId = guildId;
        this.channelId = channelId;
        this.shareUrl = shareUrl;
    }

    public /* synthetic */ ChannelInfo(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3);
    }
}
