package com.tencent.mobileqq.guild.rolegroup.model.data;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\tB#\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildId", "b", "channelId", "categoryId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.model.data.d, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildTarget {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String categoryId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/d$a;", "", "", "guildId", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/d;", "b", "channelId", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.model.data.d$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final GuildTarget a(@NotNull String guildId, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            return new GuildTarget(guildId, channelId, null, 4, null);
        }

        @JvmStatic
        @NotNull
        public final GuildTarget b(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            return new GuildTarget(guildId, null, null, 6, null);
        }

        Companion() {
        }
    }

    public GuildTarget(@NotNull String guildId, @NotNull String channelId, @NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        this.guildId = guildId;
        this.channelId = channelId;
        this.categoryId = categoryId;
    }

    @JvmStatic
    @NotNull
    public static final GuildTarget d(@NotNull String str, @NotNull String str2) {
        return INSTANCE.a(str, str2);
    }

    @JvmStatic
    @NotNull
    public static final GuildTarget e(@NotNull String str) {
        return INSTANCE.b(str);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildTarget)) {
            return false;
        }
        GuildTarget guildTarget = (GuildTarget) other;
        if (Intrinsics.areEqual(this.guildId, guildTarget.guildId) && Intrinsics.areEqual(this.channelId, guildTarget.channelId) && Intrinsics.areEqual(this.categoryId, guildTarget.categoryId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.categoryId.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildTarget(guildId=" + this.guildId + ", channelId=" + this.channelId + ", categoryId=" + this.categoryId + ")";
    }

    public /* synthetic */ GuildTarget(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3);
    }
}
