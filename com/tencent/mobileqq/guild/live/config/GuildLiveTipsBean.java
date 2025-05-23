package com.tencent.mobileqq.guild.live.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\t\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/live/config/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "enable", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "title", "Lcom/tencent/mobileqq/guild/live/config/c;", "Lcom/tencent/mobileqq/guild/live/config/c;", "()Lcom/tencent/mobileqq/guild/live/config/c;", "content", "<init>", "(ZLjava/lang/String;Lcom/tencent/mobileqq/guild/live/config/c;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.live.config.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildLiveTipsBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GuildLiveTipsContent content;

    public GuildLiveTipsBean(boolean z16, @NotNull String title, @NotNull GuildLiveTipsContent content) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        this.enable = z16;
        this.title = title;
        this.content = content;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final GuildLiveTipsContent getContent() {
        return this.content;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildLiveTipsBean)) {
            return false;
        }
        GuildLiveTipsBean guildLiveTipsBean = (GuildLiveTipsBean) other;
        if (this.enable == guildLiveTipsBean.enable && Intrinsics.areEqual(this.title, guildLiveTipsBean.title) && Intrinsics.areEqual(this.content, guildLiveTipsBean.content)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.enable;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.title.hashCode()) * 31) + this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildLiveTipsBean(enable=" + this.enable + ", title=" + this.title + ", content=" + this.content + ")";
    }
}
