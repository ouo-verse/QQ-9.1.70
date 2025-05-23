package com.tencent.mobileqq.guild.live.config;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.oskplayer.util.SecretUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/live/config/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", SecretUtils.DES, "", "Lcom/tencent/mobileqq/guild/live/config/d;", "b", "Ljava/util/List;", "()Ljava/util/List;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.live.config.c, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildLiveTipsContent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String des;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<GuildLiveTipsContentItem> item;

    public GuildLiveTipsContent(@NotNull String des, @NotNull List<GuildLiveTipsContentItem> item) {
        Intrinsics.checkNotNullParameter(des, "des");
        Intrinsics.checkNotNullParameter(item, "item");
        this.des = des;
        this.item = item;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDes() {
        return this.des;
    }

    @NotNull
    public final List<GuildLiveTipsContentItem> b() {
        return this.item;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildLiveTipsContent)) {
            return false;
        }
        GuildLiveTipsContent guildLiveTipsContent = (GuildLiveTipsContent) other;
        if (Intrinsics.areEqual(this.des, guildLiveTipsContent.des) && Intrinsics.areEqual(this.item, guildLiveTipsContent.item)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.des.hashCode() * 31) + this.item.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildLiveTipsContent(des=" + this.des + ", item=" + this.item + ")";
    }
}
