package com.tencent.icgame.game.gift.impl.timi;

import androidx.fragment.app.a;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/icgame/game/gift/impl/timi/TimiGiftPanelEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "roomId", "", "cmd", "", "panelWidth", "panelHeight", "(JIII)V", "getCmd", "()I", "getPanelHeight", "getPanelWidth", "getRoomId", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class TimiGiftPanelEvent extends SimpleBaseEvent {
    private final int cmd;
    private final int panelHeight;
    private final int panelWidth;
    private final long roomId;

    public TimiGiftPanelEvent(long j3, int i3, int i16, int i17) {
        this.roomId = j3;
        this.cmd = i3;
        this.panelWidth = i16;
        this.panelHeight = i17;
    }

    public static /* synthetic */ TimiGiftPanelEvent copy$default(TimiGiftPanelEvent timiGiftPanelEvent, long j3, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            j3 = timiGiftPanelEvent.roomId;
        }
        long j16 = j3;
        if ((i18 & 2) != 0) {
            i3 = timiGiftPanelEvent.cmd;
        }
        int i19 = i3;
        if ((i18 & 4) != 0) {
            i16 = timiGiftPanelEvent.panelWidth;
        }
        int i26 = i16;
        if ((i18 & 8) != 0) {
            i17 = timiGiftPanelEvent.panelHeight;
        }
        return timiGiftPanelEvent.copy(j16, i19, i26, i17);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCmd() {
        return this.cmd;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPanelWidth() {
        return this.panelWidth;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPanelHeight() {
        return this.panelHeight;
    }

    @NotNull
    public final TimiGiftPanelEvent copy(long roomId, int cmd, int panelWidth, int panelHeight) {
        return new TimiGiftPanelEvent(roomId, cmd, panelWidth, panelHeight);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimiGiftPanelEvent)) {
            return false;
        }
        TimiGiftPanelEvent timiGiftPanelEvent = (TimiGiftPanelEvent) other;
        if (this.roomId == timiGiftPanelEvent.roomId && this.cmd == timiGiftPanelEvent.cmd && this.panelWidth == timiGiftPanelEvent.panelWidth && this.panelHeight == timiGiftPanelEvent.panelHeight) {
            return true;
        }
        return false;
    }

    public final int getCmd() {
        return this.cmd;
    }

    public final int getPanelHeight() {
        return this.panelHeight;
    }

    public final int getPanelWidth() {
        return this.panelWidth;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public int hashCode() {
        return (((((a.a(this.roomId) * 31) + this.cmd) * 31) + this.panelWidth) * 31) + this.panelHeight;
    }

    @NotNull
    public String toString() {
        return "TimiGiftPanelEvent(roomId=" + this.roomId + ", cmd=" + this.cmd + ", panelWidth=" + this.panelWidth + ", panelHeight=" + this.panelHeight + ")";
    }
}
