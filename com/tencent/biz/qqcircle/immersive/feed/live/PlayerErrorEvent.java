package com.tencent.biz.qqcircle.immersive.feed.live;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/live/PlayerErrorEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "roomId", "", "code", "", "(JI)V", "getCode", "()I", "getRoomId", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PlayerErrorEvent extends SimpleBaseEvent {
    private final int code;
    private final long roomId;

    public PlayerErrorEvent(long j3, int i3) {
        this.roomId = j3;
        this.code = i3;
    }

    public static /* synthetic */ PlayerErrorEvent copy$default(PlayerErrorEvent playerErrorEvent, long j3, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            j3 = playerErrorEvent.roomId;
        }
        if ((i16 & 2) != 0) {
            i3 = playerErrorEvent.code;
        }
        return playerErrorEvent.copy(j3, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final PlayerErrorEvent copy(long roomId, int code) {
        return new PlayerErrorEvent(roomId, code);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayerErrorEvent)) {
            return false;
        }
        PlayerErrorEvent playerErrorEvent = (PlayerErrorEvent) other;
        if (this.roomId == playerErrorEvent.roomId && this.code == playerErrorEvent.code) {
            return true;
        }
        return false;
    }

    public final int getCode() {
        return this.code;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(this.roomId) * 31) + this.code;
    }

    @NotNull
    public String toString() {
        return "PlayerErrorEvent(roomId=" + this.roomId + ", code=" + this.code + ")";
    }
}
