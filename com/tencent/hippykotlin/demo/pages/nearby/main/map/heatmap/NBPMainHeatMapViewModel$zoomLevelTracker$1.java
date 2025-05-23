package com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap;

import com.tencent.hippykotlin.demo.pages.nearby.base.view.HeatMapRenderReason;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes31.dex */
public /* synthetic */ class NBPMainHeatMapViewModel$zoomLevelTracker$1 extends FunctionReferenceImpl implements Function0<Unit> {
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        final NBPMainHeatMapViewModel nBPMainHeatMapViewModel = (NBPMainHeatMapViewModel) this.receiver;
        final long j3 = nBPMainHeatMapViewModel.renderIndex + 1;
        nBPMainHeatMapViewModel.renderIndex = j3;
        TimerKt.d(200, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap.NBPMainHeatMapViewModel$onZoomLevelIntChange$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                long j16 = j3;
                NBPMainHeatMapViewModel nBPMainHeatMapViewModel2 = nBPMainHeatMapViewModel;
                if (j16 == nBPMainHeatMapViewModel2.renderIndex) {
                    nBPMainHeatMapViewModel2.doRenderHeatMap(HeatMapRenderReason.ZoomLevelChanged, false);
                }
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }

    public NBPMainHeatMapViewModel$zoomLevelTracker$1(Object obj) {
        super(0, obj, NBPMainHeatMapViewModel.class, "onZoomLevelIntChange", "onZoomLevelIntChange()V", 0);
    }
}
