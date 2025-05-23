package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.IReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailSimilarRecomRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.QQECShopProductCard;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailDistributionCommentViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.ProductDetailDistributionCouponViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailDistributionMainPicViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures.ProductDetailDistributionPicturesViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailDistributionRichTitleViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.rules.ProductDetailDistributionRulesViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailShopSectionTitleViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailDistributionServicesViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailDistributionShippingViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shopCard.ProductDetailDistributionShopCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailDistributionTableCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionViewModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.FooterRefreshState;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionViewModel implements IProductDetailViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailDistributionViewModel.class, "height", "getHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailDistributionViewModel.class, "cards", "getCards()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailDistributionViewModel.class, "recommendState", "getRecommendState()Lcom/tencent/kuikly/core/views/FooterRefreshState;", 0)};
    public boolean isRequesting;
    public IReportParamsBuilder reportParams;
    public final String spuId;
    public final ReadWriteProperty height$delegate = c.a(Float.valueOf(0.0f));
    public final ReadWriteProperty cards$delegate = c.b();
    public String recommendCookie = "";
    public final ReadWriteProperty recommendState$delegate = c.a(FooterRefreshState.REFRESHING);

    public ProductDetailDistributionViewModel(String str, IReportParamsBuilder iReportParamsBuilder) {
        this.spuId = str;
        this.reportParams = iReportParamsBuilder;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final boolean canShare() {
        return false;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final com.tencent.kuikly.core.reactive.collection.c<IProductDetailCardViewModel> detailCardsViewModel() {
        ArrayList arrayListOf;
        if (getCards().isEmpty()) {
            com.tencent.kuikly.core.reactive.collection.c<IProductDetailCardViewModel> cards = getCards();
            String str = this.spuId;
            String str2 = this.spuId;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new ProductDetailDistributionMainPicViewModel(str), new ProductDetailDistributionCommissionViewModel(str), new ProductDetailDistributionRichTitleViewModel(this.spuId), new ProductDetailDistributionCouponViewModel(this.spuId, false), new ProductDetailDistributionServicesViewModel(this.spuId), new ProductDetailDistributionShippingViewModel(this.spuId), new ProductDetailTripleCommissionViewModel(this.spuId), new ProductDetailDistributionCommentViewModel(this.spuId, this.reportParams), new ProductDetailDistributionShopCardViewModel(this.spuId, this.reportParams), new ProductDetailShopSectionTitleViewModel(this.spuId, "\u5546\u54c1\u8be6\u60c5", "pictures_card_frame_change", false, false, 24), new ProductDetailDistributionTableCardViewModel(this.spuId, false), new ProductDetailDistributionPicturesViewModel(str2, this.reportParams), new ProductDetailShopSectionTitleViewModel(str2, "\u8be6\u7ec6\u89c4\u5219", null, false, false, 28), new ProductDetailDistributionRulesViewModel(str2), new ProductDetailShopSectionTitleViewModel(str2, "\u731c\u4f60\u559c\u6b22", "recommend_card_frame_change", true, false, 16));
            cards.addAll(arrayListOf);
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
        return 0.0f;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final void loadMore() {
        ArrayList arrayListOf;
        if (this.isRequesting) {
            return;
        }
        this.isRequesting = true;
        ProductDetailDistributionRepository productDetailDistributionRepository = ProductDetailDistributionRepository.INSTANCE;
        final String str = this.spuId;
        String str2 = this.recommendCookie;
        final Function1<ProductDetailSimilarRecomRsp, Unit> function1 = new Function1<ProductDetailSimilarRecomRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailDistributionViewModel$handleRecommendReqSuccess$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ProductDetailSimilarRecomRsp productDetailSimilarRecomRsp) {
                ProductDetailSimilarRecomRsp productDetailSimilarRecomRsp2 = productDetailSimilarRecomRsp;
                ArrayList<QQECShopProductCard> arrayList = productDetailSimilarRecomRsp2.recom_card;
                Intrinsics.checkNotNull(arrayList);
                Iterator<QQECShopProductCard> it = arrayList.iterator();
                while (it.hasNext()) {
                    ProductDetailDistributionViewModel.this.getCards().add(new ProductDetailDistributionRecommendViewModel(it.next(), ProductDetailDistributionViewModel.this.reportParams));
                }
                ProductDetailDistributionViewModel.this.setRecommendState(FooterRefreshState.IDLE);
                ProductDetailDistributionViewModel productDetailDistributionViewModel = ProductDetailDistributionViewModel.this;
                productDetailDistributionViewModel.recommendCookie = productDetailSimilarRecomRsp2.cookie;
                if (productDetailSimilarRecomRsp2.is_end) {
                    productDetailDistributionViewModel.setRecommendState(FooterRefreshState.NONE_MORE_DATA);
                }
                ProductDetailDistributionViewModel.this.isRequesting = false;
                return Unit.INSTANCE;
            }
        };
        final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailDistributionViewModel$handleRecommendReqError$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str3) {
                int intValue = num.intValue();
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("req recommend info failure, spuId:["), ProductDetailDistributionViewModel.this.spuId, "] code:[", intValue, "] msg:[");
                m3.append(str3);
                m3.append(']');
                kLog.e("ProductDetail", m3.toString());
                ProductDetailDistributionViewModel.this.setRecommendState(FooterRefreshState.FAILURE);
                ProductDetailDistributionViewModel.this.isRequesting = false;
                return Unit.INSTANCE;
            }
        };
        final Function1<ProductDetailSimilarRecomRsp, Unit> function12 = new Function1<ProductDetailSimilarRecomRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository$reqRecommendCardInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ProductDetailSimilarRecomRsp productDetailSimilarRecomRsp) {
                function1.invoke(productDetailSimilarRecomRsp);
                return Unit.INSTANCE;
            }
        };
        final Function2<Integer, String, Unit> function22 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository$reqRecommendCardInfo$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str3) {
                int intValue = num.intValue();
                function2.invoke(Integer.valueOf(intValue), str3);
                return Unit.INSTANCE;
            }
        };
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str);
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        ISSOModelFactory<ProductDetailSimilarRecomRsp> iSSOModelFactory = ProductDetailSimilarRecomRsp.Factory;
        Function3<ProductDetailSimilarRecomRsp, Integer, String, Unit> function3 = new Function3<ProductDetailSimilarRecomRsp, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository$reqRecommendInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(ProductDetailSimilarRecomRsp productDetailSimilarRecomRsp, Integer num, String str3) {
                ProductDetailSimilarRecomRsp productDetailSimilarRecomRsp2 = productDetailSimilarRecomRsp;
                int intValue = num.intValue();
                String str4 = str3;
                if (intValue == 0) {
                    function12.invoke(productDetailSimilarRecomRsp2);
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("req recommend success, spuId:[");
                    m3.append(str);
                    m3.append("] recommendCount:[");
                    ArrayList<QQECShopProductCard> arrayList = productDetailSimilarRecomRsp2.recom_card;
                    m3.append(arrayList != null ? Integer.valueOf(arrayList.size()) : null);
                    m3.append(']');
                    kLog.i("ProductDetail", m3.toString());
                } else {
                    function22.invoke(Integer.valueOf(intValue), str4);
                }
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("shop_id", "", "scene", 8);
        m3.v("full_txt", "");
        m3.v("cookie", str2);
        m3.w("is_select", false);
        m3.w("is_h5", false);
        b bVar = new b();
        if (arrayListOf != null) {
            Iterator it = arrayListOf.iterator();
            while (it.hasNext()) {
                bVar.t((String) it.next());
            }
        }
        m3.v("spu_ids", bVar);
        NetworkUtils$requestWithCmd$2 networkUtils$requestWithCmd$2 = new NetworkUtils$requestWithCmd$2(iSSOModelFactory, function3);
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.ssoRequest("trpc.ecom.qshop_similar_recom_svr.QshopSimilarRecomSvr/SimilarProductRecom", m3, false, networkUtils$requestWithCmd$2);
        setRecommendState(FooterRefreshState.IDLE);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final boolean needShowFooter() {
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final FooterRefreshState refreshState() {
        return (FooterRefreshState) this.recommendState$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void setRecommendState(FooterRefreshState footerRefreshState) {
        this.recommendState$delegate.setValue(this, $$delegatedProperties[2], footerRefreshState);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final void setRefreshState(FooterRefreshState footerRefreshState) {
        setRecommendState(footerRefreshState);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final void doShare() {
    }
}
