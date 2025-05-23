package com.tencent.hippykotlin.demo.pages.goods_center.shell;

import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.views.ScrollParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public class GoodsCenterPendantView extends ComposeView<GoodsCenterPendantAttr, GoodsCenterEvent> implements IGoodsCenterPageSubView {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView$body$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                return Unit.INSTANCE;
            }
        };
    }

    public boolean mainViewScrollEnable() {
        return false;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public GoodsCenterPendantAttr createAttr() {
        return new GoodsCenterPendantAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public GoodsCenterEvent createEvent() {
        return new GoodsCenterEvent();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageSubView
    public final void mainViewContentSizeChanged(float f16) {
    }

    public void mainViewScrollEnd() {
    }

    public void mainViewScrollEvent(ScrollParams scrollParams) {
    }
}
