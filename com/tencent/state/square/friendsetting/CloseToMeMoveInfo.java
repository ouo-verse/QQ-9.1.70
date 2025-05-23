package com.tencent.state.square.friendsetting;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/friendsetting/CloseToMeMoveInfo;", "", "fromIndex", "", "toIndex", "toPlaceInfo", "Lcom/tencent/state/square/friendsetting/PlaceInfo;", "(IILcom/tencent/state/square/friendsetting/PlaceInfo;)V", "getFromIndex", "()I", "getToIndex", "getToPlaceInfo", "()Lcom/tencent/state/square/friendsetting/PlaceInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class CloseToMeMoveInfo {
    private final int fromIndex;
    private final int toIndex;
    private final PlaceInfo toPlaceInfo;

    public CloseToMeMoveInfo(int i3, int i16, PlaceInfo toPlaceInfo) {
        Intrinsics.checkNotNullParameter(toPlaceInfo, "toPlaceInfo");
        this.fromIndex = i3;
        this.toIndex = i16;
        this.toPlaceInfo = toPlaceInfo;
    }

    /* renamed from: component1, reason: from getter */
    public final int getFromIndex() {
        return this.fromIndex;
    }

    /* renamed from: component2, reason: from getter */
    public final int getToIndex() {
        return this.toIndex;
    }

    /* renamed from: component3, reason: from getter */
    public final PlaceInfo getToPlaceInfo() {
        return this.toPlaceInfo;
    }

    public final CloseToMeMoveInfo copy(int fromIndex, int toIndex, PlaceInfo toPlaceInfo) {
        Intrinsics.checkNotNullParameter(toPlaceInfo, "toPlaceInfo");
        return new CloseToMeMoveInfo(fromIndex, toIndex, toPlaceInfo);
    }

    public final int getFromIndex() {
        return this.fromIndex;
    }

    public final int getToIndex() {
        return this.toIndex;
    }

    public final PlaceInfo getToPlaceInfo() {
        return this.toPlaceInfo;
    }

    public int hashCode() {
        int i3 = ((this.fromIndex * 31) + this.toIndex) * 31;
        PlaceInfo placeInfo = this.toPlaceInfo;
        return i3 + (placeInfo != null ? placeInfo.hashCode() : 0);
    }

    public String toString() {
        return "CloseToMeMoveInfo(fromIndex=" + this.fromIndex + ", toIndex=" + this.toIndex + ", toPlaceInfo=" + this.toPlaceInfo + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CloseToMeMoveInfo)) {
            return false;
        }
        CloseToMeMoveInfo closeToMeMoveInfo = (CloseToMeMoveInfo) other;
        return this.fromIndex == closeToMeMoveInfo.fromIndex && this.toIndex == closeToMeMoveInfo.toIndex && Intrinsics.areEqual(this.toPlaceInfo, closeToMeMoveInfo.toPlaceInfo);
    }

    public static /* synthetic */ CloseToMeMoveInfo copy$default(CloseToMeMoveInfo closeToMeMoveInfo, int i3, int i16, PlaceInfo placeInfo, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = closeToMeMoveInfo.fromIndex;
        }
        if ((i17 & 2) != 0) {
            i16 = closeToMeMoveInfo.toIndex;
        }
        if ((i17 & 4) != 0) {
            placeInfo = closeToMeMoveInfo.toPlaceInfo;
        }
        return closeToMeMoveInfo.copy(i3, i16, placeInfo);
    }
}
