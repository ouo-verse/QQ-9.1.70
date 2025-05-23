package com.tencent.mobileqq.guild.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/config/t;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getId", "()I", "id", "b", "getOrder", "order", "c", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "d", "getHintText", "hintText", "e", "getIconUrl", "iconUrl", "f", "getWelcomeIconUrl", "welcomeIconUrl", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.config.t, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildTextChannelSubType {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int order;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String hintText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String iconUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String welcomeIconUrl;

    public GuildTextChannelSubType(int i3, int i16, @NotNull String name, @NotNull String hintText, @NotNull String iconUrl, @NotNull String welcomeIconUrl) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(hintText, "hintText");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(welcomeIconUrl, "welcomeIconUrl");
        this.id = i3;
        this.order = i16;
        this.name = name;
        this.hintText = hintText;
        this.iconUrl = iconUrl;
        this.welcomeIconUrl = welcomeIconUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildTextChannelSubType)) {
            return false;
        }
        GuildTextChannelSubType guildTextChannelSubType = (GuildTextChannelSubType) other;
        if (this.id == guildTextChannelSubType.id && this.order == guildTextChannelSubType.order && Intrinsics.areEqual(this.name, guildTextChannelSubType.name) && Intrinsics.areEqual(this.hintText, guildTextChannelSubType.hintText) && Intrinsics.areEqual(this.iconUrl, guildTextChannelSubType.iconUrl) && Intrinsics.areEqual(this.welcomeIconUrl, guildTextChannelSubType.welcomeIconUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.id * 31) + this.order) * 31) + this.name.hashCode()) * 31) + this.hintText.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.welcomeIconUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildTextChannelSubType(id=" + this.id + ", order=" + this.order + ", name=" + this.name + ", hintText=" + this.hintText + ", iconUrl=" + this.iconUrl + ", welcomeIconUrl=" + this.welcomeIconUrl + ")";
    }
}
