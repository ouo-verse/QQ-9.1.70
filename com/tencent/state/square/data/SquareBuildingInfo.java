package com.tencent.state.square.data;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/data/SquareBuildingInfo;", "", "entranceId", "", "styleId", "(II)V", "getEntranceId", "()I", "setEntranceId", "(I)V", "getStyleId", "setStyleId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareBuildingInfo {
    private int entranceId;
    private int styleId;

    public SquareBuildingInfo(int i3, int i16) {
        this.entranceId = i3;
        this.styleId = i16;
    }

    /* renamed from: component1, reason: from getter */
    public final int getEntranceId() {
        return this.entranceId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStyleId() {
        return this.styleId;
    }

    public final SquareBuildingInfo copy(int entranceId, int styleId) {
        return new SquareBuildingInfo(entranceId, styleId);
    }

    public final int getEntranceId() {
        return this.entranceId;
    }

    public final int getStyleId() {
        return this.styleId;
    }

    public int hashCode() {
        return (this.entranceId * 31) + this.styleId;
    }

    public final void setEntranceId(int i3) {
        this.entranceId = i3;
    }

    public final void setStyleId(int i3) {
        this.styleId = i3;
    }

    public String toString() {
        return "SquareBuildingInfo(entranceId=" + this.entranceId + ", styleId=" + this.styleId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareBuildingInfo)) {
            return false;
        }
        SquareBuildingInfo squareBuildingInfo = (SquareBuildingInfo) other;
        return this.entranceId == squareBuildingInfo.entranceId && this.styleId == squareBuildingInfo.styleId;
    }

    public static /* synthetic */ SquareBuildingInfo copy$default(SquareBuildingInfo squareBuildingInfo, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = squareBuildingInfo.entranceId;
        }
        if ((i17 & 2) != 0) {
            i16 = squareBuildingInfo.styleId;
        }
        return squareBuildingInfo.copy(i3, i16);
    }
}
