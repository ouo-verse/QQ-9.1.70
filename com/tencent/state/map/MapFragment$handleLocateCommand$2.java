package com.tencent.state.map;

import com.tencent.state.map.IMapViewManipulator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0010\b\u0000\u0010\u0002*\n\u0012\u0002\b\u00030\u0003j\u0002`\u0004\"\b\b\u0001\u0010\u0005*\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "V", "Lcom/tencent/state/map/BaseMapView;", "Lcom/tencent/state/map/MapView;", "VM", "Lcom/tencent/state/map/MapViewModel;", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class MapFragment$handleLocateCommand$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MapFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapFragment$handleLocateCommand$2(MapFragment mapFragment) {
        super(0);
        this.this$0 = mapFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IMapViewManipulator manipulator;
        BaseMapView mapView = this.this$0.getMapView();
        if (mapView == null || (manipulator = mapView.getManipulator()) == null) {
            return;
        }
        IMapViewManipulator.DefaultImpls.locateToMe$default(manipulator, 0, new Function1<Boolean, Unit>() { // from class: com.tencent.state.map.MapFragment$handleLocateCommand$2.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                BaseMapView mapView2 = MapFragment$handleLocateCommand$2.this.this$0.getMapView();
                if (mapView2 != null) {
                    mapView2.post(new Runnable() { // from class: com.tencent.state.map.MapFragment.handleLocateCommand.2.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            BaseMapView mapView3 = MapFragment$handleLocateCommand$2.this.this$0.getMapView();
                            if (mapView3 != null) {
                                BaseMapView.scaleToMeDetail$default(mapView3, null, 1, null);
                            }
                        }
                    });
                }
            }
        }, 1, null);
    }
}
