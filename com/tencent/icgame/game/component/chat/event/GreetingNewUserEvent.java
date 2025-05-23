package com.tencent.icgame.game.component.chat.event;

import com.heytap.mcssdk.a.a;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/icgame/game/component/chat/event/GreetingNewUserEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", a.f36093c, "", "roomId", "", "(Ljava/lang/String;J)V", "getMessageID", "()Ljava/lang/String;", "getRoomId", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class GreetingNewUserEvent extends SimpleBaseEvent {

    @NotNull
    private final String messageID;
    private final long roomId;

    public GreetingNewUserEvent(@NotNull String messageID, long j3) {
        Intrinsics.checkNotNullParameter(messageID, "messageID");
        this.messageID = messageID;
        this.roomId = j3;
    }

    public static /* synthetic */ GreetingNewUserEvent copy$default(GreetingNewUserEvent greetingNewUserEvent, String str, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = greetingNewUserEvent.messageID;
        }
        if ((i3 & 2) != 0) {
            j3 = greetingNewUserEvent.roomId;
        }
        return greetingNewUserEvent.copy(str, j3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getMessageID() {
        return this.messageID;
    }

    /* renamed from: component2, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    @NotNull
    public final GreetingNewUserEvent copy(@NotNull String messageID, long roomId) {
        Intrinsics.checkNotNullParameter(messageID, "messageID");
        return new GreetingNewUserEvent(messageID, roomId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GreetingNewUserEvent)) {
            return false;
        }
        GreetingNewUserEvent greetingNewUserEvent = (GreetingNewUserEvent) other;
        if (Intrinsics.areEqual(this.messageID, greetingNewUserEvent.messageID) && this.roomId == greetingNewUserEvent.roomId) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getMessageID() {
        return this.messageID;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public int hashCode() {
        return (this.messageID.hashCode() * 31) + androidx.fragment.app.a.a(this.roomId);
    }

    @NotNull
    public String toString() {
        return "GreetingNewUserEvent(messageID=" + this.messageID + ", roomId=" + this.roomId + ")";
    }
}
