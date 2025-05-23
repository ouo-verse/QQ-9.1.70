package com.tencent.hippykotlin.demo.pages.goods_center.pendant.category;

import com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel;

/* loaded from: classes31.dex */
public final class GoodsCenterCategoryPendantViewModel extends GoodsCenterCategoryViewModel implements IGoodsCenterPendantViewModel {
    public GoodsCenterCategoryPendantViewModel(IGoodsCenterPageModel iGoodsCenterPageModel) {
        super(iGoodsCenterPageModel);
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel
    public final GoodsCenterPendantView getPendantView() {
        return new GoodsCenterCategoryPendant();
    }
}
