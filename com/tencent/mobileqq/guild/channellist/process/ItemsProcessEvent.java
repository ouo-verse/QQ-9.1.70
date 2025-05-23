package com.tencent.mobileqq.guild.channellist.process;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B7\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0018\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u00150\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R)\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u00150\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\n\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/process/b;", "", "T", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/channellist/process/a;", "Lcom/tencent/mobileqq/guild/channellist/process/a;", "c", "()Lcom/tencent/mobileqq/guild/channellist/process/a;", "processor", "", "Lkotlin/Pair;", "Ljava/util/List;", "()Ljava/util/List;", "channelsData", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/channellist/process/a;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.channellist.process.b, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class ItemsProcessEvent<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final a<T> processor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<Pair<String, T>> channelsData;

    /* JADX WARN: Multi-variable type inference failed */
    public ItemsProcessEvent(@NotNull String guildId, @NotNull a<T> processor, @NotNull List<? extends Pair<String, ? extends T>> channelsData) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(channelsData, "channelsData");
        this.guildId = guildId;
        this.processor = processor;
        this.channelsData = channelsData;
    }

    @NotNull
    public final List<Pair<String, T>> a() {
        return this.channelsData;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final a<T> c() {
        return this.processor;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemsProcessEvent)) {
            return false;
        }
        ItemsProcessEvent itemsProcessEvent = (ItemsProcessEvent) other;
        if (Intrinsics.areEqual(this.guildId, itemsProcessEvent.guildId) && Intrinsics.areEqual(this.processor, itemsProcessEvent.processor) && Intrinsics.areEqual(this.channelsData, itemsProcessEvent.channelsData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.guildId.hashCode() * 31) + this.processor.hashCode()) * 31) + this.channelsData.hashCode();
    }

    @NotNull
    public String toString() {
        return "ItemsProcessEvent(guildId=" + this.guildId + ", processor=" + this.processor + ", channelsData=" + this.channelsData + ")";
    }
}
