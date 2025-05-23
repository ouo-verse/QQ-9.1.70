package com.tencent.state.square.layout;

import com.tencent.state.map.MapItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/layout/MoveCommand;", "", "from", "", "to", "fromData", "Lcom/tencent/state/map/MapItem;", "skipAnim", "", "(IILcom/tencent/state/map/MapItem;Z)V", "getFrom", "()I", "getFromData", "()Lcom/tencent/state/map/MapItem;", "getSkipAnim", "()Z", "getTo", "setTo", "(I)V", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MoveCommand {
    private final int from;
    private final MapItem fromData;
    private final boolean skipAnim;
    private int to;

    public MoveCommand(int i3, int i16, MapItem mapItem, boolean z16) {
        this.from = i3;
        this.to = i16;
        this.fromData = mapItem;
        this.skipAnim = z16;
    }

    public final int getFrom() {
        return this.from;
    }

    public final MapItem getFromData() {
        return this.fromData;
    }

    public final boolean getSkipAnim() {
        return this.skipAnim;
    }

    public final int getTo() {
        return this.to;
    }

    public final void setTo(int i3) {
        this.to = i3;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("MoveCommand(from=");
        sb5.append(this.from);
        sb5.append(", to=");
        sb5.append(this.to);
        sb5.append(", from.type=");
        MapItem mapItem = this.fromData;
        sb5.append(mapItem != null ? Integer.valueOf(mapItem.getType()) : null);
        sb5.append(", from.uin=");
        MapItem mapItem2 = this.fromData;
        sb5.append(mapItem2 != null ? mapItem2.getUin() : null);
        sb5.append(')');
        return sb5.toString();
    }

    public /* synthetic */ MoveCommand(int i3, int i16, MapItem mapItem, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, (i17 & 4) != 0 ? null : mapItem, (i17 & 8) != 0 ? false : z16);
    }
}
