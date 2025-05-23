package com.tencent.timi.game.ad.ui.event;

import androidx.fragment.app.a;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/timi/game/ad/ui/event/RefreshBatteryOperationEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "time", "", "(J)V", "getTime", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final /* data */ class RefreshBatteryOperationEvent extends SimpleBaseEvent {
    private final long time;

    public RefreshBatteryOperationEvent() {
        this(0L, 1, null);
    }

    public static /* synthetic */ RefreshBatteryOperationEvent copy$default(RefreshBatteryOperationEvent refreshBatteryOperationEvent, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = refreshBatteryOperationEvent.time;
        }
        return refreshBatteryOperationEvent.copy(j3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    @NotNull
    public final RefreshBatteryOperationEvent copy(long time) {
        return new RefreshBatteryOperationEvent(time);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof RefreshBatteryOperationEvent) && this.time == ((RefreshBatteryOperationEvent) other).time) {
            return true;
        }
        return false;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        return a.a(this.time);
    }

    @NotNull
    public String toString() {
        return "RefreshBatteryOperationEvent(time=" + this.time + ")";
    }

    public /* synthetic */ RefreshBatteryOperationEvent(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? NetConnInfoCenter.getServerTime() : j3);
    }

    public RefreshBatteryOperationEvent(long j3) {
        this.time = j3;
    }
}
