package com.tencent.mobileqq.guild.config;

import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/config/u;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/config/t;", "a", "Lcom/tencent/mobileqq/guild/config/t;", "getSubType", "()Lcom/tencent/mobileqq/guild/config/t;", QCircleLpReportDc010001.KEY_SUBTYPE, "", "b", "Ljava/util/Set;", "getGuildIdSet", "()Ljava/util/Set;", "guildIdSet", "<init>", "(Lcom/tencent/mobileqq/guild/config/t;Ljava/util/Set;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.config.u, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildTextChannelSubTypeWithFilterId {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GuildTextChannelSubType subType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Set<String> guildIdSet;

    public GuildTextChannelSubTypeWithFilterId(@NotNull GuildTextChannelSubType subType, @NotNull Set<String> guildIdSet) {
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(guildIdSet, "guildIdSet");
        this.subType = subType;
        this.guildIdSet = guildIdSet;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildTextChannelSubTypeWithFilterId)) {
            return false;
        }
        GuildTextChannelSubTypeWithFilterId guildTextChannelSubTypeWithFilterId = (GuildTextChannelSubTypeWithFilterId) other;
        if (Intrinsics.areEqual(this.subType, guildTextChannelSubTypeWithFilterId.subType) && Intrinsics.areEqual(this.guildIdSet, guildTextChannelSubTypeWithFilterId.guildIdSet)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.subType.hashCode() * 31) + this.guildIdSet.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildTextChannelSubTypeWithFilterId(subType=" + this.subType + ", guildIdSet=" + this.guildIdSet + ")";
    }
}
