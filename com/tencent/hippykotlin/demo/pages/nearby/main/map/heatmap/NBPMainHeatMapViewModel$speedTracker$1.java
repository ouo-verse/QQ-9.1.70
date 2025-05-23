package com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap;

import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraPosition;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.HeatMapRenderReason;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMapUtil;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes31.dex */
public /* synthetic */ class NBPMainHeatMapViewModel$speedTracker$1 extends FunctionReferenceImpl implements Function1<CameraPosition, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(CameraPosition cameraPosition) {
        CameraPosition cameraPosition2 = cameraPosition;
        NBPMainHeatMapViewModel nBPMainHeatMapViewModel = (NBPMainHeatMapViewModel) this.receiver;
        nBPMainHeatMapViewModel.speedTracker.reset();
        if (nBPMainHeatMapViewModel.showHeatMap) {
            nBPMainHeatMapViewModel.renderIndex++;
            NBPLatLng nBPLatLng = cameraPosition2.target;
            if (!nBPMainHeatMapViewModel.fetchNearbyHeatMapDataIfNeeded(nBPLatLng, (int) (NBPMapUtil.INSTANCE.distanceBetween(nBPLatLng, cameraPosition2.topRightPosition) * nBPMainHeatMapViewModel.heatMapConfig.optimizeEnlargeRatio), false)) {
                nBPMainHeatMapViewModel.doRenderHeatMap(HeatMapRenderReason.MoveSlowDown, true);
            }
        }
        return Unit.INSTANCE;
    }

    public NBPMainHeatMapViewModel$speedTracker$1(Object obj) {
        super(1, obj, NBPMainHeatMapViewModel.class, "onMapCameraSlowDown", "onMapCameraSlowDown(Lcom/tencent/hippykotlin/demo/pages/nearby/base/view/CameraPosition;)V", 0);
    }
}
