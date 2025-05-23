package com.tencent.hippykotlin.demo.pages.goods_center.card.product;

import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.kuikly.core.base.ComposeView;

/* loaded from: classes31.dex */
public final class GoodsCenterProductSkeletonViewModel implements IGoodsCenterCardViewModel {
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> getCardView() {
        return new GoodsCenterProductSkeletonView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final boolean isTopOfCard() {
        return false;
    }
}
