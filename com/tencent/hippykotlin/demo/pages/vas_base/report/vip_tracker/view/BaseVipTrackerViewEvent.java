package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view;

import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BaseVipTrackerViewEvent extends l {
    public Function1<? super ClickParams, Unit> reportClickHandler;

    @Override // com.tencent.kuikly.core.base.l, com.tencent.kuikly.core.base.event.Event
    public final void click(final Function1<? super ClickParams, Unit> function1) {
        super.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerViewEvent$click$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                ClickParams clickParams2 = clickParams;
                Function1<? super ClickParams, Unit> function12 = BaseVipTrackerViewEvent.this.reportClickHandler;
                if (function12 != null) {
                    function12.invoke(clickParams2);
                }
                function1.invoke(clickParams2);
                return Unit.INSTANCE;
            }
        });
    }
}
