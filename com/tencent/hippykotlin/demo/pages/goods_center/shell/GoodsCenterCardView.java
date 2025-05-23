package com.tencent.hippykotlin.demo.pages.goods_center.shell;

import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.views.ScrollParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public class GoodsCenterCardView extends ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> implements IGoodsCenterPageSubView {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardView$body$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GoodsCenterEvent();
    }

    public boolean mainViewScrollEnable() {
        return false;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public GoodsCenterCardAttr createAttr() {
        return new GoodsCenterCardAttr();
    }

    public void mainViewContentSizeChanged(float f16) {
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageSubView
    public final void mainViewScrollEnd() {
    }

    public void mainViewScrollEvent(ScrollParams scrollParams) {
    }
}
