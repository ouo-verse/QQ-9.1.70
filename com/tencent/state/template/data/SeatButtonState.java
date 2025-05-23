package com.tencent.state.template.data;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/template/data/SeatButtonState;", "", "isRoomFull", "", "isMeSeated", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SeatButtonState {
    private final boolean isMeSeated;
    private final boolean isRoomFull;

    public SeatButtonState(boolean z16, boolean z17) {
        this.isRoomFull = z16;
        this.isMeSeated = z17;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsRoomFull() {
        return this.isRoomFull;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsMeSeated() {
        return this.isMeSeated;
    }

    public final SeatButtonState copy(boolean isRoomFull, boolean isMeSeated) {
        return new SeatButtonState(isRoomFull, isMeSeated);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isRoomFull;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        boolean z17 = this.isMeSeated;
        return i3 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final boolean isMeSeated() {
        return this.isMeSeated;
    }

    public final boolean isRoomFull() {
        return this.isRoomFull;
    }

    public String toString() {
        return "SeatButtonState(isRoomFull=" + this.isRoomFull + ", isMeSeated=" + this.isMeSeated + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SeatButtonState)) {
            return false;
        }
        SeatButtonState seatButtonState = (SeatButtonState) other;
        return this.isRoomFull == seatButtonState.isRoomFull && this.isMeSeated == seatButtonState.isMeSeated;
    }

    public static /* synthetic */ SeatButtonState copy$default(SeatButtonState seatButtonState, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = seatButtonState.isRoomFull;
        }
        if ((i3 & 2) != 0) {
            z17 = seatButtonState.isMeSeated;
        }
        return seatButtonState.copy(z16, z17);
    }
}
