package com.tencent.hippykotlin.demo.pages.nearby.interactive.view;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyFormatUtils;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class InteractiveTimeView extends ComposeView<InteractiveTimeViewAttr, InteractiveTimeViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ InteractiveTimeViewAttr access$getAttr(InteractiveTimeView interactiveTimeView) {
        return (InteractiveTimeViewAttr) interactiveTimeView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.InteractiveTimeView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.InteractiveTimeView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(m mVar) {
                        return Unit.INSTANCE;
                    }
                });
                final InteractiveTimeView interactiveTimeView = InteractiveTimeView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.InteractiveTimeView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final InteractiveTimeView interactiveTimeView2 = InteractiveTimeView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.InteractiveTimeView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                String formatStateItemTime = NearbyFormatUtils.INSTANCE.formatStateItemTime(InteractiveTimeView.access$getAttr(InteractiveTimeView.this).createTime * 1000);
                                if (formatStateItemTime.length() <= 5) {
                                    formatStateItemTime = AgreementConsentViewKt$$ExternalSyntheticOutline0.m("\u4eca\u5929 ", formatStateItemTime);
                                }
                                ceVar2.text(formatStateItemTime);
                                ceVar2.color(new h(9474196L, 1.0f));
                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                ceVar2.fontWeight400();
                                ceVar2.lineHeight(17.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new InteractiveTimeViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new InteractiveTimeViewEvent();
    }
}
