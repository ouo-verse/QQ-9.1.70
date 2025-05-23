package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class VipTrackerView extends BaseVipTrackerView<VipTrackerViewAttr, VipTrackerViewEvent> {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerView$body$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new VipTrackerViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new VipTrackerViewEvent();
    }
}
