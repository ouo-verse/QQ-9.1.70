package com.tencent.mobileqq.guild.message.directmessage.model.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0017\u0010\rR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0019\u0010\r\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/model/data/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "b", "setGuildName", "guildName", "c", "e", "setTinyId", "tinyId", "d", "setNickName", "nickName", "setRemarkName", "remarkName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.message.directmessage.model.data.d, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class MessageSource {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String guildName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String tinyId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String nickName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String remarkName;

    public MessageSource(@NotNull String guildId, @NotNull String guildName, @NotNull String tinyId, @NotNull String nickName, @NotNull String remarkName) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(remarkName, "remarkName");
        this.guildId = guildId;
        this.guildName = guildName;
        this.tinyId = tinyId;
        this.nickName = nickName;
        this.remarkName = remarkName;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getRemarkName() {
        return this.remarkName;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTinyId() {
        return this.tinyId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageSource)) {
            return false;
        }
        MessageSource messageSource = (MessageSource) other;
        if (Intrinsics.areEqual(this.guildId, messageSource.guildId) && Intrinsics.areEqual(this.guildName, messageSource.guildName) && Intrinsics.areEqual(this.tinyId, messageSource.tinyId) && Intrinsics.areEqual(this.nickName, messageSource.nickName) && Intrinsics.areEqual(this.remarkName, messageSource.remarkName)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.guildId.hashCode() * 31) + this.guildName.hashCode()) * 31) + this.tinyId.hashCode()) * 31) + this.nickName.hashCode()) * 31) + this.remarkName.hashCode();
    }

    @NotNull
    public String toString() {
        return "MessageSource(guildId=" + this.guildId + ", guildName=" + this.guildName + ", tinyId=" + this.tinyId + ", nickName=" + this.nickName + ", remarkName=" + this.remarkName + ")";
    }
}
