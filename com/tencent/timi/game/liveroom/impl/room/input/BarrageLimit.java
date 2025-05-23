package com.tencent.timi.game.liveroom.impl.room.input;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/input/q;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "payLimit", "b", "roomLimitCounts", "<init>", "(II)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.timi.game.liveroom.impl.room.input.q, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class BarrageLimit {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int payLimit;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int roomLimitCounts;

    public BarrageLimit(int i3, int i16) {
        this.payLimit = i3;
        this.roomLimitCounts = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getPayLimit() {
        return this.payLimit;
    }

    /* renamed from: b, reason: from getter */
    public final int getRoomLimitCounts() {
        return this.roomLimitCounts;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BarrageLimit)) {
            return false;
        }
        BarrageLimit barrageLimit = (BarrageLimit) other;
        if (this.payLimit == barrageLimit.payLimit && this.roomLimitCounts == barrageLimit.roomLimitCounts) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.payLimit * 31) + this.roomLimitCounts;
    }

    @NotNull
    public String toString() {
        return "BarrageLimit(payLimit=" + this.payLimit + ", roomLimitCounts=" + this.roomLimitCounts + ")";
    }
}
