package com.tencent.mobileqq.guild.forward.guildselector;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\nB'\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/forward/guildselector/c;", "Lcom/tencent/mobileqq/guild/forward/guildselector/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "guildId", "b", "e", "guildName", "c", "g", "url", "I", "f", "()I", "nodeType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.forward.guildselector.c, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class GuildData extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String guildName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String url;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int nodeType;

    public GuildData(String guildId, String guildName, String url, int i3) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        Intrinsics.checkNotNullParameter(url, "url");
        this.guildId = guildId;
        this.guildName = guildName;
        this.url = url;
        this.nodeType = i3;
    }

    /* renamed from: d, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: e, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    /* renamed from: f, reason: from getter */
    public final int getNodeType() {
        return this.nodeType;
    }

    /* renamed from: g, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((this.guildId.hashCode() * 31) + this.guildName.hashCode()) * 31) + this.url.hashCode()) * 31) + this.nodeType;
    }

    public String toString() {
        return "GuildData(guildId=" + this.guildId + ", guildName=" + this.guildName + ", url=" + this.url + ", nodeType=" + this.nodeType + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildData)) {
            return false;
        }
        GuildData guildData = (GuildData) other;
        return Intrinsics.areEqual(this.guildId, guildData.guildId) && Intrinsics.areEqual(this.guildName, guildData.guildName) && Intrinsics.areEqual(this.url, guildData.url) && this.nodeType == guildData.nodeType;
    }
}
