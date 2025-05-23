package com.tencent.mobileqq.guild.openentrance.eventbus;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/openentrance/eventbus/GuildJumpLeftNodeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "type", "", "guildId", "", "(ILjava/lang/String;)V", "getGuildId", "()Ljava/lang/String;", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final /* data */ class GuildJumpLeftNodeEvent extends SimpleBaseEvent {

    @NotNull
    private final String guildId;
    private final int type;

    public /* synthetic */ GuildJumpLeftNodeEvent(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str);
    }

    public static /* synthetic */ GuildJumpLeftNodeEvent copy$default(GuildJumpLeftNodeEvent guildJumpLeftNodeEvent, int i3, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = guildJumpLeftNodeEvent.type;
        }
        if ((i16 & 2) != 0) {
            str = guildJumpLeftNodeEvent.guildId;
        }
        return guildJumpLeftNodeEvent.copy(i3, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final GuildJumpLeftNodeEvent copy(int type, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return new GuildJumpLeftNodeEvent(type, guildId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildJumpLeftNodeEvent)) {
            return false;
        }
        GuildJumpLeftNodeEvent guildJumpLeftNodeEvent = (GuildJumpLeftNodeEvent) other;
        if (this.type == guildJumpLeftNodeEvent.type && Intrinsics.areEqual(this.guildId, guildJumpLeftNodeEvent.guildId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type * 31) + this.guildId.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildJumpLeftNodeEvent(type=" + this.type + ", guildId=" + this.guildId + ")";
    }

    public GuildJumpLeftNodeEvent(int i3, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.type = i3;
        this.guildId = guildId;
    }
}
