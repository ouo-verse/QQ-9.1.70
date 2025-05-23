package com.tencent.timi.game.liveroom.impl.room.input;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/input/u;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/timi/game/liveroom/impl/room/input/o;", "a", "Lcom/tencent/timi/game/liveroom/impl/room/input/o;", "()Lcom/tencent/timi/game/liveroom/impl/room/input/o;", "barrageData", "b", "I", "()I", "position", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/input/o;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.timi.game.liveroom.impl.room.input.u, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class CurrentBarrage {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final BarrageData barrageData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int position;

    public CurrentBarrage(@Nullable BarrageData barrageData, int i3) {
        this.barrageData = barrageData;
        this.position = i3;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final BarrageData getBarrageData() {
        return this.barrageData;
    }

    /* renamed from: b, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CurrentBarrage)) {
            return false;
        }
        CurrentBarrage currentBarrage = (CurrentBarrage) other;
        if (Intrinsics.areEqual(this.barrageData, currentBarrage.barrageData) && this.position == currentBarrage.position) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        BarrageData barrageData = this.barrageData;
        if (barrageData == null) {
            hashCode = 0;
        } else {
            hashCode = barrageData.hashCode();
        }
        return (hashCode * 31) + this.position;
    }

    @NotNull
    public String toString() {
        return "CurrentBarrage(barrageData=" + this.barrageData + ", position=" + this.position + ")";
    }
}
