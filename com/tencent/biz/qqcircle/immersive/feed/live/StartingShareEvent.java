package com.tencent.biz.qqcircle.immersive.feed.live;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/live/StartingShareEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "roomId", "", "(J)V", "getRoomId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class StartingShareEvent extends SimpleBaseEvent {
    private final long roomId;

    public StartingShareEvent(long j3) {
        this.roomId = j3;
    }

    public static /* synthetic */ StartingShareEvent copy$default(StartingShareEvent startingShareEvent, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = startingShareEvent.roomId;
        }
        return startingShareEvent.copy(j3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    @NotNull
    public final StartingShareEvent copy(long roomId) {
        return new StartingShareEvent(roomId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof StartingShareEvent) && this.roomId == ((StartingShareEvent) other).roomId) {
            return true;
        }
        return false;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public int hashCode() {
        return androidx.fragment.app.a.a(this.roomId);
    }

    @NotNull
    public String toString() {
        return "StartingShareEvent(roomId=" + this.roomId + ")";
    }
}
