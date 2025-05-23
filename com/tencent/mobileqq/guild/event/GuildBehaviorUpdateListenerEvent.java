package com.tencent.mobileqq.guild.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.home.subhome.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J1\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\bH\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\r\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/event/GuildBehaviorUpdateListenerEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "component1", "", "component2", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "component3", "", "component4", "guildId", "activityId", "listener", "isAdd", "copy", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "I", "getActivityId", "()I", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "getListener", "()Lcom/tencent/mobileqq/guild/home/subhome/g;", "Z", "()Z", "<init>", "(Ljava/lang/String;ILcom/tencent/mobileqq/guild/home/subhome/g;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class GuildBehaviorUpdateListenerEvent extends SimpleBaseEvent {
    private final int activityId;

    @NotNull
    private final String guildId;
    private final boolean isAdd;

    @NotNull
    private final g listener;

    public GuildBehaviorUpdateListenerEvent(@NotNull String guildId, int i3, @NotNull g listener, boolean z16) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.guildId = guildId;
        this.activityId = i3;
        this.listener = listener;
        this.isAdd = z16;
    }

    public static /* synthetic */ GuildBehaviorUpdateListenerEvent copy$default(GuildBehaviorUpdateListenerEvent guildBehaviorUpdateListenerEvent, String str, int i3, g gVar, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = guildBehaviorUpdateListenerEvent.guildId;
        }
        if ((i16 & 2) != 0) {
            i3 = guildBehaviorUpdateListenerEvent.activityId;
        }
        if ((i16 & 4) != 0) {
            gVar = guildBehaviorUpdateListenerEvent.listener;
        }
        if ((i16 & 8) != 0) {
            z16 = guildBehaviorUpdateListenerEvent.isAdd;
        }
        return guildBehaviorUpdateListenerEvent.copy(str, i3, gVar, z16);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getActivityId() {
        return this.activityId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final g getListener() {
        return this.listener;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsAdd() {
        return this.isAdd;
    }

    @NotNull
    public final GuildBehaviorUpdateListenerEvent copy(@NotNull String guildId, int activityId, @NotNull g listener, boolean isAdd) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return new GuildBehaviorUpdateListenerEvent(guildId, activityId, listener, isAdd);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildBehaviorUpdateListenerEvent)) {
            return false;
        }
        GuildBehaviorUpdateListenerEvent guildBehaviorUpdateListenerEvent = (GuildBehaviorUpdateListenerEvent) other;
        if (Intrinsics.areEqual(this.guildId, guildBehaviorUpdateListenerEvent.guildId) && this.activityId == guildBehaviorUpdateListenerEvent.activityId && Intrinsics.areEqual(this.listener, guildBehaviorUpdateListenerEvent.listener) && this.isAdd == guildBehaviorUpdateListenerEvent.isAdd) {
            return true;
        }
        return false;
    }

    public final int getActivityId() {
        return this.activityId;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final g getListener() {
        return this.listener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.guildId.hashCode() * 31) + this.activityId) * 31) + this.listener.hashCode()) * 31;
        boolean z16 = this.isAdd;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final boolean isAdd() {
        return this.isAdd;
    }

    @NotNull
    public String toString() {
        return "GuildBehaviorUpdateListenerEvent(guildId=" + this.guildId + ", activityId=" + this.activityId + ", listener=" + this.listener + ", isAdd=" + this.isAdd + ")";
    }
}
