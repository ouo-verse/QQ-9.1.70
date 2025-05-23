package com.tencent.mobileqq.vas.transit;

import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/vas/transit/MasterInfo;", "Ljava/io/Serializable;", "()V", "groupId", "", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "guildId", "getGuildId", "setGuildId", ISchemeApi.KEY_GUILD_ID_TYPE, "", "getGuildIdType", "()I", "setGuildIdType", "(I)V", "nickName", "getNickName", "setNickName", "ranking", "getRanking", "setRanking", ISchemeApi.KEY_TINY_AVATAR, "getTinyAvatar", "setTinyAvatar", ISchemeApi.KEY_TINY_NICK, "getTinyNick", "setTinyNick", "uin", "getUin", "setUin", "toString", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class MasterInfo implements Serializable {

    @Nullable
    private String groupId;

    @Nullable
    private String guildId;
    private int guildIdType = 1;

    @Nullable
    private String nickName;
    private int ranking;

    @Nullable
    private String tinyAvatar;

    @Nullable
    private String tinyNick;

    @Nullable
    private String uin;

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final String getGuildId() {
        return this.guildId;
    }

    public final int getGuildIdType() {
        return this.guildIdType;
    }

    @Nullable
    public final String getNickName() {
        return this.nickName;
    }

    public final int getRanking() {
        return this.ranking;
    }

    @Nullable
    public final String getTinyAvatar() {
        return this.tinyAvatar;
    }

    @Nullable
    public final String getTinyNick() {
        return this.tinyNick;
    }

    @Nullable
    public final String getUin() {
        return this.uin;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setGuildId(@Nullable String str) {
        this.guildId = str;
    }

    public final void setGuildIdType(int i3) {
        this.guildIdType = i3;
    }

    public final void setNickName(@Nullable String str) {
        this.nickName = str;
    }

    public final void setRanking(int i3) {
        this.ranking = i3;
    }

    public final void setTinyAvatar(@Nullable String str) {
        this.tinyAvatar = str;
    }

    public final void setTinyNick(@Nullable String str) {
        this.tinyNick = str;
    }

    public final void setUin(@Nullable String str) {
        this.uin = str;
    }

    @NotNull
    public String toString() {
        return "MasterInfo(uin=" + this.uin + ", nickName=" + this.nickName + ", groupId=" + this.groupId + ", ranking=" + this.ranking + ", guildIdType=" + this.guildIdType + ", tinyNick=" + this.tinyNick + ", tinyAvatar=" + this.tinyAvatar + ", guildId=" + this.guildId + ')';
    }
}
