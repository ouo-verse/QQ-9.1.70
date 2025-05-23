package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB!\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J)\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\r\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/MoveViewportEvent;", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "Lcom/tencent/filament/zplan/scene/square/ViewportInfo;", "component1", "component2", "", "component3", "from", "to", "duration", "copy", "", "toString", "hashCode", "", "other", "", "equals", "Lcom/tencent/filament/zplan/scene/square/ViewportInfo;", "getFrom", "()Lcom/tencent/filament/zplan/scene/square/ViewportInfo;", "getTo", "I", "getDuration", "()I", "<init>", "(Lcom/tencent/filament/zplan/scene/square/ViewportInfo;Lcom/tencent/filament/zplan/scene/square/ViewportInfo;I)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class MoveViewportEvent extends SquareMapEvent {

    @NotNull
    public static final String NAME = "SquareMapScene.EVENT_ON_MOVE_VIEWPORT";
    private final int duration;

    @Nullable
    private final ViewportInfo from;

    @NotNull
    private final ViewportInfo to;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoveViewportEvent(@Nullable ViewportInfo viewportInfo, @NotNull ViewportInfo to5, int i3) {
        super(NAME);
        Intrinsics.checkNotNullParameter(to5, "to");
        this.from = viewportInfo;
        this.to = to5;
        this.duration = i3;
    }

    public static /* synthetic */ MoveViewportEvent copy$default(MoveViewportEvent moveViewportEvent, ViewportInfo viewportInfo, ViewportInfo viewportInfo2, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            viewportInfo = moveViewportEvent.from;
        }
        if ((i16 & 2) != 0) {
            viewportInfo2 = moveViewportEvent.to;
        }
        if ((i16 & 4) != 0) {
            i3 = moveViewportEvent.duration;
        }
        return moveViewportEvent.copy(viewportInfo, viewportInfo2, i3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final ViewportInfo getFrom() {
        return this.from;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final ViewportInfo getTo() {
        return this.to;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    @NotNull
    public final MoveViewportEvent copy(@Nullable ViewportInfo from, @NotNull ViewportInfo to5, int duration) {
        Intrinsics.checkNotNullParameter(to5, "to");
        return new MoveViewportEvent(from, to5, duration);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MoveViewportEvent) {
                MoveViewportEvent moveViewportEvent = (MoveViewportEvent) other;
                if (!Intrinsics.areEqual(this.from, moveViewportEvent.from) || !Intrinsics.areEqual(this.to, moveViewportEvent.to) || this.duration != moveViewportEvent.duration) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getDuration() {
        return this.duration;
    }

    @Nullable
    public final ViewportInfo getFrom() {
        return this.from;
    }

    @NotNull
    public final ViewportInfo getTo() {
        return this.to;
    }

    public int hashCode() {
        int i3;
        ViewportInfo viewportInfo = this.from;
        int i16 = 0;
        if (viewportInfo != null) {
            i3 = viewportInfo.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        ViewportInfo viewportInfo2 = this.to;
        if (viewportInfo2 != null) {
            i16 = viewportInfo2.hashCode();
        }
        return ((i17 + i16) * 31) + this.duration;
    }

    @NotNull
    public String toString() {
        return "MoveViewportEvent(from=" + this.from + ", to=" + this.to + ", duration=" + this.duration + ")";
    }
}
