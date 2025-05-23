package com.tencent.timi.game.ad.ui.event;

import androidx.fragment.app.a;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/ad/ui/event/ToTargetTabEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "roomId", "", "tabId", "", "(JI)V", "getRoomId", "()J", "getTabId", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final /* data */ class ToTargetTabEvent extends SimpleBaseEvent {
    private final long roomId;
    private final int tabId;

    public ToTargetTabEvent(long j3, int i3) {
        this.roomId = j3;
        this.tabId = i3;
    }

    public static /* synthetic */ ToTargetTabEvent copy$default(ToTargetTabEvent toTargetTabEvent, long j3, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            j3 = toTargetTabEvent.roomId;
        }
        if ((i16 & 2) != 0) {
            i3 = toTargetTabEvent.tabId;
        }
        return toTargetTabEvent.copy(j3, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTabId() {
        return this.tabId;
    }

    @NotNull
    public final ToTargetTabEvent copy(long roomId, int tabId) {
        return new ToTargetTabEvent(roomId, tabId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToTargetTabEvent)) {
            return false;
        }
        ToTargetTabEvent toTargetTabEvent = (ToTargetTabEvent) other;
        if (this.roomId == toTargetTabEvent.roomId && this.tabId == toTargetTabEvent.tabId) {
            return true;
        }
        return false;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final int getTabId() {
        return this.tabId;
    }

    public int hashCode() {
        return (a.a(this.roomId) * 31) + this.tabId;
    }

    @NotNull
    public String toString() {
        return "ToTargetTabEvent(roomId=" + this.roomId + ", tabId=" + this.tabId + ")";
    }
}
