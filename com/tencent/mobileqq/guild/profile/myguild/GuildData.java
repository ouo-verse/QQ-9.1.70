package com.tencent.mobileqq.guild.profile.myguild;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010R\u0017\u0010\u001a\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001c\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/myguild/c;", "Lcom/tencent/mobileqq/guild/profile/myguild/a;", "", "g", "", "d", "", "toString", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "id", "c", "e", "guildName", "i", "url", "Z", tl.h.F, "()Z", "unNotifyIsOpen", "j", "isTop", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.profile.myguild.c, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean unNotifyIsOpen;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isTop;

    public GuildData(@NotNull String id5, @NotNull String guildName, @NotNull String url, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        Intrinsics.checkNotNullParameter(url, "url");
        this.id = id5;
        this.guildName = guildName;
        this.url = url;
        this.unNotifyIsOpen = z16;
        this.isTop = z17;
    }

    @Override // com.tencent.mobileqq.guild.profile.myguild.a
    public long d() {
        return Objects.hash(Integer.valueOf(g()), this.id, this.guildName, this.url, Boolean.valueOf(this.unNotifyIsOpen));
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildData)) {
            return false;
        }
        GuildData guildData = (GuildData) other;
        if (Intrinsics.areEqual(this.id, guildData.id) && Intrinsics.areEqual(this.guildName, guildData.guildName) && Intrinsics.areEqual(this.url, guildData.url) && this.unNotifyIsOpen == guildData.unNotifyIsOpen && this.isTop == guildData.isTop) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public int g() {
        return 2;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getUnNotifyIsOpen() {
        return this.unNotifyIsOpen;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.guildName.hashCode()) * 31) + this.url.hashCode()) * 31;
        boolean z16 = this.unNotifyIsOpen;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.isTop;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i17 + i3;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsTop() {
        return this.isTop;
    }

    @NotNull
    public String toString() {
        return "GuildData(id=" + this.id + ", guildName=" + this.guildName + ", url=" + this.url + ", unNotifyIsOpen=" + this.unNotifyIsOpen + ", isTop=" + this.isTop + ")";
    }
}
