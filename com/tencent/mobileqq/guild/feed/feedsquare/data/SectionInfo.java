package com.tencent.mobileqq.guild.feed.feedsquare.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/data/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "channelId", "b", "guildId", "c", "name", "d", "I", "()I", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.data.m, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class SectionInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    public SectionInfo(@NotNull String channelId, @NotNull String guildId, @NotNull String name, int i3) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(name, "name");
        this.channelId = channelId;
        this.guildId = guildId;
        this.name = name;
        this.type = i3;
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
    public final String getName() {
        return this.name;
    }

    /* renamed from: d, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SectionInfo)) {
            return false;
        }
        SectionInfo sectionInfo = (SectionInfo) other;
        if (Intrinsics.areEqual(this.channelId, sectionInfo.channelId) && Intrinsics.areEqual(this.guildId, sectionInfo.guildId) && Intrinsics.areEqual(this.name, sectionInfo.name) && this.type == sectionInfo.type) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.channelId.hashCode() * 31) + this.guildId.hashCode()) * 31) + this.name.hashCode()) * 31) + this.type;
    }

    @NotNull
    public String toString() {
        return "SectionInfo(channelId=" + this.channelId + ", guildId=" + this.guildId + ", name=" + this.name + ", type=" + this.type + ")";
    }
}
