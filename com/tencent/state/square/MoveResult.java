package com.tencent.state.square;

import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.state.square.friendsetting.PlaceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/MoveResult;", "", "type", "Lcom/tencent/state/square/MoveType;", CanvasView.ACTION_MOVETO, "Lcom/tencent/state/square/friendsetting/PlaceInfo;", "(Lcom/tencent/state/square/MoveType;Lcom/tencent/state/square/friendsetting/PlaceInfo;)V", "getMoveTo", "()Lcom/tencent/state/square/friendsetting/PlaceInfo;", "getType", "()Lcom/tencent/state/square/MoveType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class MoveResult {
    private final PlaceInfo moveTo;
    private final MoveType type;

    public MoveResult(MoveType type, PlaceInfo moveTo) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(moveTo, "moveTo");
        this.type = type;
        this.moveTo = moveTo;
    }

    /* renamed from: component1, reason: from getter */
    public final MoveType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final PlaceInfo getMoveTo() {
        return this.moveTo;
    }

    public final MoveResult copy(MoveType type, PlaceInfo moveTo) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(moveTo, "moveTo");
        return new MoveResult(type, moveTo);
    }

    public final PlaceInfo getMoveTo() {
        return this.moveTo;
    }

    public final MoveType getType() {
        return this.type;
    }

    public int hashCode() {
        MoveType moveType = this.type;
        int hashCode = (moveType != null ? moveType.hashCode() : 0) * 31;
        PlaceInfo placeInfo = this.moveTo;
        return hashCode + (placeInfo != null ? placeInfo.hashCode() : 0);
    }

    public String toString() {
        return "{type:" + this.type.name() + ", place:" + this.moveTo + '}';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MoveResult)) {
            return false;
        }
        MoveResult moveResult = (MoveResult) other;
        return Intrinsics.areEqual(this.type, moveResult.type) && Intrinsics.areEqual(this.moveTo, moveResult.moveTo);
    }

    public static /* synthetic */ MoveResult copy$default(MoveResult moveResult, MoveType moveType, PlaceInfo placeInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            moveType = moveResult.type;
        }
        if ((i3 & 2) != 0) {
            placeInfo = moveResult.moveTo;
        }
        return moveResult.copy(moveType, placeInfo);
    }
}
