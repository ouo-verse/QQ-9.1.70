package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPLandMarkerView$scheduleSummaryTextMarquee$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ d $frame;
    public final /* synthetic */ NBPLandMarkerView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NBPLandMarkerView$scheduleSummaryTextMarquee$1(NBPLandMarkerView nBPLandMarkerView, d dVar) {
        super(0);
        this.this$0 = nBPLandMarkerView;
        this.$frame = dVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.this$0.summaryTextTranslateX = (-((this.$frame.getWidth() - NBPLandMarkerView.access$getAttr(this.this$0).getVm().getSummaryTextMaxWidth()) + 8.0f)) / this.$frame.getWidth();
        NBPLandMarkerView nBPLandMarkerView = this.this$0;
        nBPLandMarkerView.setSummaryTextAnimationTick(nBPLandMarkerView.getSummaryTextAnimationTick() + 1);
        final NBPLandMarkerView nBPLandMarkerView2 = this.this$0;
        final d dVar = this.$frame;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView$scheduleSummaryTextMarquee$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                NBPLandMarkerView nBPLandMarkerView3 = NBPLandMarkerView.this;
                nBPLandMarkerView3.summaryTextTranslateX = 0.0f;
                nBPLandMarkerView3.setSummaryTextAnimationTick(nBPLandMarkerView3.getSummaryTextAnimationTick() + 1);
                NBPLandMarkerView nBPLandMarkerView4 = NBPLandMarkerView.this;
                d dVar2 = dVar;
                nBPLandMarkerView4.getClass();
                NBPLandMarkerView$scheduleSummaryTextMarquee$1 nBPLandMarkerView$scheduleSummaryTextMarquee$1 = new NBPLandMarkerView$scheduleSummaryTextMarquee$1(nBPLandMarkerView4, dVar2);
                KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                nBPLandMarkerView4.summaryTextTimeoutRef = TimerKt.e(nBPLandMarkerView4.getPagerId(), 5000, nBPLandMarkerView$scheduleSummaryTextMarquee$1);
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        nBPLandMarkerView2.summaryTextTimeoutRef = TimerKt.e(nBPLandMarkerView2.getPagerId(), 5000, function0);
        return Unit.INSTANCE;
    }
}
