package com.tencent.state.square.layout;

import com.tencent.state.map.MapItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/layout/MoveSource;", "", "index", "", "data", "Lcom/tencent/state/map/MapItem;", "(ILcom/tencent/state/map/MapItem;)V", "getData", "()Lcom/tencent/state/map/MapItem;", "setData", "(Lcom/tencent/state/map/MapItem;)V", "getIndex", "()I", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MoveSource {
    private MapItem data;
    private final int index;

    public MoveSource(int i3, MapItem mapItem) {
        this.index = i3;
        this.data = mapItem;
    }

    public final MapItem getData() {
        return this.data;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setData(MapItem mapItem) {
        this.data = mapItem;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append('{');
        sb5.append(this.index);
        sb5.append(", ");
        MapItem mapItem = this.data;
        sb5.append(mapItem != null ? mapItem.getUin() : null);
        sb5.append(", ");
        MapItem mapItem2 = this.data;
        sb5.append(mapItem2 != null ? Integer.valueOf(mapItem2.getType()) : null);
        sb5.append(", ");
        MapItem mapItem3 = this.data;
        sb5.append(mapItem3 != null ? mapItem3.getLocation() : null);
        sb5.append('}');
        return sb5.toString();
    }

    public /* synthetic */ MoveSource(int i3, MapItem mapItem, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : mapItem);
    }
}
