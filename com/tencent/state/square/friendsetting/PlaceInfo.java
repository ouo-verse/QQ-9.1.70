package com.tencent.state.square.friendsetting;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/friendsetting/PlaceInfo;", "", GdtGetUserInfoHandler.KEY_AREA, "", "rank", "index", "(III)V", "getArea", "()I", "getIndex", "getRank", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class PlaceInfo {
    private final int area;
    private final int index;
    private final int rank;

    public PlaceInfo() {
        this(0, 0, 0, 7, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getArea() {
        return this.area;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRank() {
        return this.rank;
    }

    /* renamed from: component3, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    public final PlaceInfo copy(int area, int rank, int index) {
        return new PlaceInfo(area, rank, index);
    }

    public final int getArea() {
        return this.area;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getRank() {
        return this.rank;
    }

    public int hashCode() {
        return (((this.area * 31) + this.rank) * 31) + this.index;
    }

    public String toString() {
        return "{area:" + this.area + ", rank:" + this.rank + ", index:" + this.index + '}';
    }

    public PlaceInfo(int i3, int i16, int i17) {
        this.area = i3;
        this.rank = i16;
        this.index = i17;
    }

    public /* synthetic */ PlaceInfo(int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? -1 : i3, (i18 & 2) != 0 ? -1 : i16, (i18 & 4) != 0 ? -1 : i17);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaceInfo)) {
            return false;
        }
        PlaceInfo placeInfo = (PlaceInfo) other;
        return this.area == placeInfo.area && this.rank == placeInfo.rank && this.index == placeInfo.index;
    }

    public static /* synthetic */ PlaceInfo copy$default(PlaceInfo placeInfo, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            i3 = placeInfo.area;
        }
        if ((i18 & 2) != 0) {
            i16 = placeInfo.rank;
        }
        if ((i18 & 4) != 0) {
            i17 = placeInfo.index;
        }
        return placeInfo.copy(i3, i16, i17);
    }
}
