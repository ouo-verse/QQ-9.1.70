package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.SchemeParamExtensionKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.IBlindBoxProductDetailBottomBarViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures.ProductDetailBottomSpacingViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures.ProductDetailShopPicturesViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailShopRichTitleViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailShopSectionTitleViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.BlindBoxProductDetailShopShippingViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailShopTableCardViewModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.FooterRefreshState;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class BlindBoxProductDetailShopViewModel implements IProductDetailViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailShopViewModel.class, "height", "getHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailShopViewModel.class, "cards", "getCards()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final IBlindBoxProductDetailBottomBarViewModel bottomViewModel;
    public final e params;
    public final boolean showBottom;
    public final String spuId;
    public final ReadWriteProperty height$delegate = c.a(Float.valueOf(0.0f));
    public final ReadWriteProperty cards$delegate = c.b();

    public BlindBoxProductDetailShopViewModel(e eVar, IBlindBoxProductDetailBottomBarViewModel iBlindBoxProductDetailBottomBarViewModel) {
        this.params = eVar;
        this.bottomViewModel = iBlindBoxProductDetailBottomBarViewModel;
        this.spuId = SchemeParamExtensionKt.schemeSpuId(eVar);
        this.showBottom = SchemeParamExtensionKt.schemeShowBottom(eVar);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final boolean canShare() {
        return false;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final com.tencent.kuikly.core.reactive.collection.c<IProductDetailCardViewModel> detailCardsViewModel() {
        ArrayList arrayListOf;
        com.tencent.kuikly.core.reactive.collection.c<IProductDetailCardViewModel> cards = getCards();
        String str = this.spuId;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new ProductDetailShopMainPicViewModel(this.spuId, true), new BlindBoxProductDetailShopPriceViewModel(this.spuId), new ProductDetailShopRichTitleViewModel(str, true), new ProductDetailShopServicesViewModel(str, true), new BlindBoxProductDetailShopShippingViewModel(str), new ProductDetailEmptyViewModel(16.0f, true), new ProductDetailShopSectionTitleViewModel(str, "\u5546\u54c1\u8be6\u60c5", null, false, true, 12), new ProductDetailShopTableCardViewModel(this.spuId, true), new ProductDetailShopPicturesViewModel(this.spuId, true, null));
        cards.addAll(arrayListOf);
        if (this.showBottom) {
            getCards().add(new ProductDetailBottomSpacingViewModel(this.bottomViewModel.viewHeight()));
        }
        return getCards();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<IProductDetailCardViewModel> getCards() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.cards$delegate.getValue(this, $$delegatedProperties[1]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final float getHeight() {
        return ((Number) this.height$delegate.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final float halfMarginTopHeight() {
        float schemeMarginTop = SchemeParamExtensionKt.schemeMarginTop(this.params);
        return schemeMarginTop <= 0.1f ? com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().m() * 0.48f : schemeMarginTop;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final boolean needShowFooter() {
        return false;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final FooterRefreshState refreshState() {
        return FooterRefreshState.IDLE;
    }

    public final void setHeight(float f16) {
        this.height$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(f16));
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final void doShare() {
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final void loadMore() {
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final void setRefreshState(FooterRefreshState footerRefreshState) {
    }
}
