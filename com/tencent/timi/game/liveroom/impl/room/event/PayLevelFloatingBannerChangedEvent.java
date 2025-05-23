package com.tencent.timi.game.liveroom.impl.room.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/event/PayLevelFloatingBannerChangedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", NodeProps.VISIBLE, "", "(Z)V", "getVisible", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final /* data */ class PayLevelFloatingBannerChangedEvent extends SimpleBaseEvent {
    private final boolean visible;

    public PayLevelFloatingBannerChangedEvent(boolean z16) {
        this.visible = z16;
    }

    public static /* synthetic */ PayLevelFloatingBannerChangedEvent copy$default(PayLevelFloatingBannerChangedEvent payLevelFloatingBannerChangedEvent, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = payLevelFloatingBannerChangedEvent.visible;
        }
        return payLevelFloatingBannerChangedEvent.copy(z16);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    @NotNull
    public final PayLevelFloatingBannerChangedEvent copy(boolean visible) {
        return new PayLevelFloatingBannerChangedEvent(visible);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof PayLevelFloatingBannerChangedEvent) && this.visible == ((PayLevelFloatingBannerChangedEvent) other).visible) {
            return true;
        }
        return false;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        boolean z16 = this.visible;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "PayLevelFloatingBannerChangedEvent(visible=" + this.visible + ")";
    }
}
