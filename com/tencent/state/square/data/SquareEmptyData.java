package com.tencent.state.square.data;

import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/square/data/SquareEmptyData;", "Lcom/tencent/state/map/MapItem;", "location", "Lcom/tencent/state/map/Location;", "(Lcom/tencent/state/map/Location;)V", "isFixed", "", "()Z", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareEmptyData extends MapItem {
    private final boolean isFixed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareEmptyData(Location location) {
        super(5, "", false, location);
        Intrinsics.checkNotNullParameter(location, "location");
    }

    @Override // com.tencent.state.map.MapItem
    /* renamed from: isFixed, reason: from getter */
    public boolean getIsFixed() {
        return this.isFixed;
    }
}
