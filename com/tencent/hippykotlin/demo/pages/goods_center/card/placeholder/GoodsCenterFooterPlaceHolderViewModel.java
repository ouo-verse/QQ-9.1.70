package com.tencent.hippykotlin.demo.pages.goods_center.card.placeholder;

import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.kuikly.core.base.ComposeView;

/* loaded from: classes31.dex */
public final class GoodsCenterFooterPlaceHolderViewModel implements IGoodsCenterCardViewModel {
    public float ceilingOffsetY;
    public final float mainViewHeight;

    public GoodsCenterFooterPlaceHolderViewModel(float f16) {
        this.mainViewHeight = f16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> getCardView() {
        return new GoodsCenterFooterPlaceHolderView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final boolean isTopOfCard() {
        return false;
    }
}
