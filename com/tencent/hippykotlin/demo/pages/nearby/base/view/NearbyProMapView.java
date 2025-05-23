package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NearbyProMapView extends ViewContainer<NearbyProMapAttr, NearbyProMapEvent> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NearbyProMapAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyProMapEvent();
    }

    public final void moveCameraWithCallback(final CameraUpdate cameraUpdate, final Function1<? super Boolean, Unit> function1) {
        NBPLatLng nBPLatLng = cameraUpdate.target;
        if (nBPLatLng == null || Intrinsics.areEqual(Double.valueOf(nBPLatLng.latitude), -1.0d)) {
            return;
        }
        NBPLatLng nBPLatLng2 = cameraUpdate.target;
        if (Intrinsics.areEqual(nBPLatLng2 != null ? Double.valueOf(nBPLatLng2.longitude) : null, -1.0d)) {
            return;
        }
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapView$moveCameraWithCallback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Object obj;
                Object obj2;
                RenderView renderView = NearbyProMapView.this.getRenderView();
                if (renderView != null) {
                    CameraUpdate cameraUpdate2 = cameraUpdate;
                    cameraUpdate2.getClass();
                    e eVar = new e();
                    e eVar2 = new e();
                    NBPLatLng nBPLatLng3 = cameraUpdate2.target;
                    if (nBPLatLng3 != null) {
                        obj = Double.valueOf(nBPLatLng3.latitude);
                    } else {
                        obj = 0;
                    }
                    eVar2.v("lat02", obj);
                    NBPLatLng nBPLatLng4 = cameraUpdate2.target;
                    if (nBPLatLng4 != null) {
                        obj2 = Double.valueOf(nBPLatLng4.longitude);
                    } else {
                        obj2 = 0;
                    }
                    eVar2.v("lon02", obj2);
                    Unit unit = Unit.INSTANCE;
                    eVar.v("target", eVar2);
                    eVar.v("zoomLevel", Float.valueOf(cameraUpdate2.zoomLevel));
                    eVar.t("animate", d.b(cameraUpdate2.animate));
                    eVar.u("animationDuration", cameraUpdate2.animateDuration);
                    String eVar3 = eVar.toString();
                    final Function1<Boolean, Unit> function12 = function1;
                    renderView.a("moveCamera", eVar3, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProMapView$moveCameraWithCallback$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
                        
                            if (r2.j("finish") == 1) goto L8;
                         */
                        @Override // kotlin.jvm.functions.Function1
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(e eVar4) {
                            e eVar5 = eVar4;
                            boolean z16 = eVar5 != null;
                            Function1<Boolean, Unit> function13 = function12;
                            if (function13 != null) {
                                function13.invoke(Boolean.valueOf(z16));
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "NBPKuiklyMapView";
    }
}
