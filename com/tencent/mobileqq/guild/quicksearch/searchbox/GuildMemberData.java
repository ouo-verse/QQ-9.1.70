package com.tencent.mobileqq.guild.quicksearch.searchbox;

import com.tencent.mobileqq.guild.quicksearch.searchbox.SearchBarExtData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0012\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/searchbox/f;", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData$a;", "a", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData$a;", "()Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData$a;", "data", "b", "Z", "()Z", "isInDelete", "<init>", "(Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData$a;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.quicksearch.searchbox.f, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildMemberData extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final SearchBarExtData.GuildMemberExtData data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isInDelete;

    public GuildMemberData(@NotNull SearchBarExtData.GuildMemberExtData data, boolean z16) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.isInDelete = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final SearchBarExtData.GuildMemberExtData getData() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsInDelete() {
        return this.isInDelete;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMemberData)) {
            return false;
        }
        GuildMemberData guildMemberData = (GuildMemberData) other;
        if (Intrinsics.areEqual(this.data, guildMemberData.data) && this.isInDelete == guildMemberData.isInDelete) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.data.hashCode() * 31;
        boolean z16 = this.isInDelete;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "GuildMemberData(data=" + this.data + ", isInDelete=" + this.isInDelete + ")";
    }
}
