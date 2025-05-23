package com.tencent.biz.qqcircle.immersive.feed.live;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/live/AnchorLiveStateChangeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "roomId", "", "isLiving", "", "(JZ)V", "()Z", "getRoomId", "()J", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AnchorLiveStateChangeEvent extends SimpleBaseEvent {
    private final boolean isLiving;
    private final long roomId;

    public AnchorLiveStateChangeEvent(long j3, boolean z16) {
        this.roomId = j3;
        this.isLiving = z16;
    }

    public static /* synthetic */ AnchorLiveStateChangeEvent copy$default(AnchorLiveStateChangeEvent anchorLiveStateChangeEvent, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = anchorLiveStateChangeEvent.roomId;
        }
        if ((i3 & 2) != 0) {
            z16 = anchorLiveStateChangeEvent.isLiving;
        }
        return anchorLiveStateChangeEvent.copy(j3, z16);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsLiving() {
        return this.isLiving;
    }

    @NotNull
    public final AnchorLiveStateChangeEvent copy(long roomId, boolean isLiving) {
        return new AnchorLiveStateChangeEvent(roomId, isLiving);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnchorLiveStateChangeEvent)) {
            return false;
        }
        AnchorLiveStateChangeEvent anchorLiveStateChangeEvent = (AnchorLiveStateChangeEvent) other;
        if (this.roomId == anchorLiveStateChangeEvent.roomId && this.isLiving == anchorLiveStateChangeEvent.isLiving) {
            return true;
        }
        return false;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = androidx.fragment.app.a.a(this.roomId) * 31;
        boolean z16 = this.isLiving;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return a16 + i3;
    }

    public final boolean isLiving() {
        return this.isLiving;
    }

    @NotNull
    public String toString() {
        return "AnchorLiveStateChangeEvent(roomId=" + this.roomId + ", isLiving=" + this.isLiving + ")";
    }
}
