package com.tencent.mobileqq.guild.setting.member.view;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/view/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "avatarMeta", "b", "nickName", "c", "tinyId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.member.view.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildMemberAvatarInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatarMeta;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nickName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tinyId;

    public GuildMemberAvatarInfo(@NotNull String avatarMeta, @NotNull String nickName, @NotNull String tinyId) {
        Intrinsics.checkNotNullParameter(avatarMeta, "avatarMeta");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        this.avatarMeta = avatarMeta;
        this.nickName = nickName;
        this.tinyId = tinyId;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAvatarMeta() {
        return this.avatarMeta;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTinyId() {
        return this.tinyId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMemberAvatarInfo)) {
            return false;
        }
        GuildMemberAvatarInfo guildMemberAvatarInfo = (GuildMemberAvatarInfo) other;
        if (Intrinsics.areEqual(this.avatarMeta, guildMemberAvatarInfo.avatarMeta) && Intrinsics.areEqual(this.nickName, guildMemberAvatarInfo.nickName) && Intrinsics.areEqual(this.tinyId, guildMemberAvatarInfo.tinyId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.avatarMeta.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.tinyId.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildMemberAvatarInfo(avatarMeta=" + this.avatarMeta + ", nickName=" + this.nickName + ", tinyId=" + this.tinyId + ")";
    }
}
