package com.tencent.state.square;

import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/tencent/state/map/Location;", "p1", "Lcom/tencent/state/map/MapItem;", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
final /* synthetic */ class SquareView$onCreateFilamentMapViewUpdater$1$1 extends FunctionReferenceImpl implements Function1<MapItem, Location> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SquareView$onCreateFilamentMapViewUpdater$1$1(SquareView squareView) {
        super(1, squareView, SquareView.class, "findItemStaticViewLocation", "findItemStaticViewLocation(Lcom/tencent/state/map/MapItem;)Lcom/tencent/state/map/Location;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Location invoke(MapItem p16) {
        Location findItemStaticViewLocation;
        Intrinsics.checkNotNullParameter(p16, "p1");
        findItemStaticViewLocation = ((SquareView) this.receiver).findItemStaticViewLocation(p16);
        return findItemStaticViewLocation;
    }
}
