package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.SchemeParamExtensionKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.define.ProductDetailPageState;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqBlindBoxProductFullInfo$1;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageDelegate;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.BlindBoxProductDetailShopViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.closeBtn.ProductDetailCloseBtnViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarViewModel;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class BlindBoxProductDetailPageModel implements IProductDetailPageModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailPageModel.class, "pageState", "getPageState()Lcom/tencent/hippykotlin/demo/pages/product_detail/detail_page/define/ProductDetailPageState;", 0)};
    public static final Companion Companion = new Companion();
    public final ProductDetailBaseViewModel bottomViewModel;
    public final BlindBoxProductDetailShopViewModel detailViewModel;
    public final boolean isHalf;
    public IProductDetailPageDelegate pageDelegate;
    public final ReadWriteProperty pageState$delegate = c.a(ProductDetailPageState.LOADING);
    public final e params;
    public final boolean showBottom;

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlindBoxProductDetailPageModel(e eVar, e eVar2) {
        this.params = eVar;
        this.isHalf = SchemeParamExtensionKt.schemeIsHalf(eVar);
        this.showBottom = SchemeParamExtensionKt.schemeShowBottom(eVar);
        IBlindBoxProductDetailBottomBarViewModel create = BlindBoxProductDetailBottomBarFactory.INSTANCE.create(eVar, eVar2);
        this.bottomViewModel = (ProductDetailBaseViewModel) create;
        SchemeParamExtensionKt.blindBoxID(eVar2);
        BlindBoxProductDetailShopViewModel blindBoxProductDetailShopViewModel = new BlindBoxProductDetailShopViewModel(eVar, create);
        this.detailViewModel = blindBoxProductDetailShopViewModel;
        blindBoxProductDetailShopViewModel.setHeight(com.tencent.kuikly.core.manager.c.f117352a.k(BridgeManager.f117344a.u()).getPageData().l() - detailViewTopOffset());
        ProductDetailShopRepository.INSTANCE.reqBlindBoxProductFullInfo(SchemeParamExtensionKt.schemeSpuId(eVar), handleReqSuccess(), handleReqFailure());
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageUIData
    public final ProductDetailPageState detailState() {
        return (ProductDetailPageState) this.pageState$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubViewModel
    public final IProductDetailViewModel detailViewModel() {
        return this.detailViewModel;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageUIData
    public final float detailViewTopOffset() {
        return IProductDetailPageModel.DefaultImpls.detailViewTopOffset();
    }

    public final Function2<Integer, String, Unit> handleReqFailure() {
        return new BlindBoxProductDetailPageModel$handleReqFailure$1(this);
    }

    public final Function2<ProductDetailInfo, ProductDetailInfoType, Unit> handleReqSuccess() {
        return new BlindBoxProductDetailPageModel$handleReqSuccess$1(this);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageUIData
    public final void refreshData() {
        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
        String p16 = this.params.p("spu_id");
        BlindBoxProductDetailPageModel$handleReqSuccess$1 blindBoxProductDetailPageModel$handleReqSuccess$1 = new BlindBoxProductDetailPageModel$handleReqSuccess$1(this);
        productDetailShopRepository.reqProductInfo(p16, new ProductDetailShopRepository$reqBlindBoxProductFullInfo$1(p16, blindBoxProductDetailPageModel$handleReqSuccess$1), new BlindBoxProductDetailPageModel$handleReqFailure$1(this), true);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageUIData
    public final void setPageDelegate(IProductDetailPageDelegate iProductDetailPageDelegate) {
        this.pageDelegate = iProductDetailPageDelegate;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubViewModel
    public final IProductDetailPendantViewModel[] detailPendantsViewModel() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new ProductDetailNavBarViewModel("\u76f2\u76d2\u5546\u8be6\u9875", this.isHalf, this.pageDelegate, this.detailViewModel, true));
        if (this.showBottom) {
            arrayListOf.add(this.bottomViewModel);
        }
        if (this.isHalf) {
            arrayListOf.add(new ProductDetailCloseBtnViewModel(null, this.pageDelegate));
        }
        Object[] array = arrayListOf.toArray(new IProductDetailPendantViewModel[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (IProductDetailPendantViewModel[]) array;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageLifeCycle
    public final void onDetailPageDestroy() {
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageReport
    public final void reportPageExit() {
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageReport
    public final void reportPageExp() {
    }
}
