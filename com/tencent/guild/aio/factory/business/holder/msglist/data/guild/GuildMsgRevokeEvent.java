package com.tencent.guild.aio.factory.business.holder.msglist.data.guild;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgRevokeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "peerId", "", "msgId", "", "(Ljava/lang/String;J)V", "getMsgId", "()J", "getPeerId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class GuildMsgRevokeEvent extends SimpleBaseEvent {
    private final long msgId;

    @NotNull
    private final String peerId;

    public GuildMsgRevokeEvent(@NotNull String peerId, long j3) {
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        this.peerId = peerId;
        this.msgId = j3;
    }

    public static /* synthetic */ GuildMsgRevokeEvent copy$default(GuildMsgRevokeEvent guildMsgRevokeEvent, String str, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = guildMsgRevokeEvent.peerId;
        }
        if ((i3 & 2) != 0) {
            j3 = guildMsgRevokeEvent.msgId;
        }
        return guildMsgRevokeEvent.copy(str, j3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPeerId() {
        return this.peerId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMsgId() {
        return this.msgId;
    }

    @NotNull
    public final GuildMsgRevokeEvent copy(@NotNull String peerId, long msgId) {
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        return new GuildMsgRevokeEvent(peerId, msgId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMsgRevokeEvent)) {
            return false;
        }
        GuildMsgRevokeEvent guildMsgRevokeEvent = (GuildMsgRevokeEvent) other;
        if (Intrinsics.areEqual(this.peerId, guildMsgRevokeEvent.peerId) && this.msgId == guildMsgRevokeEvent.msgId) {
            return true;
        }
        return false;
    }

    public final long getMsgId() {
        return this.msgId;
    }

    @NotNull
    public final String getPeerId() {
        return this.peerId;
    }

    public int hashCode() {
        return (this.peerId.hashCode() * 31) + androidx.fragment.app.a.a(this.msgId);
    }

    @NotNull
    public String toString() {
        return "GuildMsgRevokeEvent(peerId=" + this.peerId + ", msgId=" + this.msgId + ")";
    }
}
