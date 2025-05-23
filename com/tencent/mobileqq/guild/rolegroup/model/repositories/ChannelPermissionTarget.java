package com.tencent.mobileqq.guild.rolegroup.model.repositories;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0010\u0010\u000eR\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "setChannelId", "channelId", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/ChannelPermissionType;", "c", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/ChannelPermissionType;", "()Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/ChannelPermissionType;", "setType", "(Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/ChannelPermissionType;)V", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/ChannelPermissionType;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.model.repositories.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class ChannelPermissionTarget {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ChannelPermissionType type;

    public ChannelPermissionTarget(@NotNull String guildId, @NotNull String channelId, @NotNull ChannelPermissionType type) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(type, "type");
        this.guildId = guildId;
        this.channelId = channelId;
        this.type = type;
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
    public final ChannelPermissionType getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelPermissionTarget)) {
            return false;
        }
        ChannelPermissionTarget channelPermissionTarget = (ChannelPermissionTarget) other;
        if (Intrinsics.areEqual(this.guildId, channelPermissionTarget.guildId) && Intrinsics.areEqual(this.channelId, channelPermissionTarget.channelId) && this.type == channelPermissionTarget.type) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.type.hashCode();
    }

    @NotNull
    public String toString() {
        return "ChannelPermissionTarget(guildId=" + this.guildId + ", channelId=" + this.channelId + ", type=" + this.type + ")";
    }
}
