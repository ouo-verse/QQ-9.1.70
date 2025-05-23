package com.tencent.hippykotlin.demo.pages.qplus_traffic.setting.card;

import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GrayGapBarView extends ComposeView<GapBarAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final GapBarAttr gapBarAttr = (GapBarAttr) getAttr();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.setting.card.GrayGapBarView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final GapBarAttr gapBarAttr2 = GapBarAttr.this;
                viewContainer.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.setting.card.GrayGapBarView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(mVar2.getPagerData().m(), GapBarAttr.this.height);
                        AttrExtKt.backgroundColorToken(mVar2, "qecommerce_skin_color_bg_backplate");
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GapBarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
