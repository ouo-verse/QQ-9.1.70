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
import com.tencent.hippykotlin.demo.pages.foundation.module.ShareActionData;
import com.tencent.hippykotlin.demo.pages.foundation.module.ShareModule;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.SchemeParamExtensionKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.ECDetailPageReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.IReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailSimilarRecomRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.QQECShopProductCard;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailShopCommentViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.ProductDetailShopCouponViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures.ProductDetailShopPicturesViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPriceViewModelDefine;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.priceDescription.ProductDetailPriceDescriptionViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailShopRichTitleViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailShopSectionTitleViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shopCard.ProductDetailShopCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailShopTableCardViewModel;
import com.tencent.hippykotlin.demo.pages.retain.ECRetainHelper;
import com.tencent.hippykotlin.demo.pages.retain.ECRetainViewOption;
import com.tencent.hippykotlin.demo.pages.retain.repo.ECRetainInfoModel;
import com.tencent.hippykotlin.demo.pages.retain.repo.ECRetainRepository;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.FooterRefreshState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class ProductDetailShopViewModel implements IProductDetailViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailShopViewModel.class, "height", "getHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailShopViewModel.class, "recommendState", "getRecommendState()Lcom/tencent/kuikly/core/views/FooterRefreshState;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailShopViewModel.class, "cards", "getCards()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public boolean isRequesting;
    public final e params;
    public IReportParamsBuilder reportParams;
    public final String spuId;
    public final Lazy viewModelScope$delegate;
    public final ReadWriteProperty height$delegate = c.a(Float.valueOf(0.0f));
    public String recommendCookie = "";
    public String retainId = "";
    public final ReadWriteProperty recommendState$delegate = c.a(FooterRefreshState.REFRESHING);
    public final ReadWriteProperty cards$delegate = c.b();

    public ProductDetailShopViewModel(e eVar, IReportParamsBuilder iReportParamsBuilder) {
        Lazy lazy;
        this.params = eVar;
        this.reportParams = iReportParamsBuilder;
        this.spuId = SchemeParamExtensionKt.schemeSpuId(eVar);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.kuikly.core.coroutines.e>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel$viewModelScope$2
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.kuikly.core.coroutines.e invoke() {
                return com.tencent.kuikly.core.coroutines.e.f117232d;
            }
        });
        this.viewModelScope$delegate = lazy;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final boolean canShare() {
        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
        if (ProductDetailShopRepository.cache.getDetailInfo(this.params.p("spu_id")) != null) {
            return !r0.detail.hideShare;
        }
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final com.tencent.kuikly.core.reactive.collection.c<IProductDetailCardViewModel> detailCardsViewModel() {
        List reversed;
        ArrayList arrayListOf;
        if (getCards().isEmpty()) {
            com.tencent.kuikly.core.reactive.collection.c<IProductDetailCardViewModel> cards = getCards();
            IProductDetailCardViewModel[] iProductDetailCardViewModelArr = new IProductDetailCardViewModel[13];
            iProductDetailCardViewModelArr[0] = new ProductDetailShopMainPicViewModel(this.spuId, false);
            e eVar = this.params;
            reversed = ArraysKt___ArraysKt.reversed(ProductDetailPriceViewModelDefine.values());
            int size = reversed.size();
            for (int i3 = 0; i3 < size; i3++) {
                ProductDetailPriceViewModelDefine productDetailPriceViewModelDefine = (ProductDetailPriceViewModelDefine) reversed.get(i3);
                if (productDetailPriceViewModelDefine.isThePriceViewModelBlock.invoke(eVar).booleanValue()) {
                    iProductDetailCardViewModelArr[1] = productDetailPriceViewModelDefine.newPriceViewModelBLock.invoke(eVar);
                    iProductDetailCardViewModelArr[2] = new ProductDetailShopCouponViewModel(this.params, false);
                    String str = this.spuId;
                    iProductDetailCardViewModelArr[3] = new ProductDetailShopRichTitleViewModel(str, false);
                    iProductDetailCardViewModelArr[4] = new ProductDetailShopServicesViewModel(str, false);
                    iProductDetailCardViewModelArr[5] = new ProductDetailShopShippingViewModel(str);
                    iProductDetailCardViewModelArr[6] = new ProductDetailShopCommentViewModel(this.spuId, this.reportParams);
                    iProductDetailCardViewModelArr[7] = new ProductDetailShopCardViewModel(this.spuId, this.params, this.reportParams);
                    iProductDetailCardViewModelArr[8] = new ProductDetailShopSectionTitleViewModel(this.spuId, "\u5546\u54c1\u8be6\u60c5", "pictures_card_frame_change", false, false, 24);
                    iProductDetailCardViewModelArr[9] = new ProductDetailShopTableCardViewModel(this.spuId, false);
                    String str2 = this.spuId;
                    iProductDetailCardViewModelArr[10] = new ProductDetailShopPicturesViewModel(str2, false, this.reportParams);
                    iProductDetailCardViewModelArr[11] = new ProductDetailPriceDescriptionViewModel();
                    iProductDetailCardViewModelArr[12] = new ProductDetailShopSectionTitleViewModel(str2, "\u731c\u4f60\u559c\u6b22", "recommend_card_frame_change", true, false, 16);
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(iProductDetailCardViewModelArr);
                    cards.addAll(arrayListOf);
                }
            }
            throw new Exception("please check params, define param illegal");
        }
        return getCards();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final void doShare() {
        List mutableListOf;
        Utils utils = Utils.INSTANCE;
        ShareModule shareModule = utils.shareModule(utils.currentBridgeModule().getPagerId());
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(2, 3, 9, 10);
        ArrayList arrayList = new ArrayList();
        final Function2<Integer, ShareActionData, Unit> function2 = new Function2<Integer, ShareActionData, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel$doShare$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, ShareActionData shareActionData) {
                ProductDetailShopViewModel productDetailShopViewModel = ProductDetailShopViewModel.this;
                BuildersKt.e((com.tencent.kuikly.core.coroutines.e) productDetailShopViewModel.viewModelScope$delegate.getValue(), null, null, new ProductDetailShopViewModel$requestAndShare$1(num.intValue(), productDetailShopViewModel, shareActionData, null), 3, null);
                return Unit.INSTANCE;
            }
        };
        shareModule.getClass();
        e eVar = new e();
        b bVar = new b();
        Iterator it = mutableListOf.iterator();
        while (it.hasNext()) {
            bVar.r(((Number) it.next()).intValue());
        }
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "shareActions", bVar);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            m3.r(((Number) it5.next()).intValue());
        }
        eVar.v("shareOperations", m3);
        shareModule.toNative(false, "showSharePanel", eVar.toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.module.ShareModule$showSharePanel$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                String q16;
                e eVar3 = eVar2;
                int j3 = eVar3 != null ? eVar3.j("selectedShareAction") : 0;
                e eVar4 = (eVar3 == null || (q16 = eVar3.q("selectedShareActionData", "{}")) == null) ? null : new e(q16);
                function2.invoke(Integer.valueOf(j3), eVar4 != null ? new ShareActionData(eVar4.p("friendUin"), eVar4.p("friendName"), eVar4.j("friendType"), eVar4.p("guildId"), eVar4.f("directShowShareDialog")) : null);
                return Unit.INSTANCE;
            }
        }, false);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<IProductDetailCardViewModel> getCards() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.cards$delegate.getValue(this, $$delegatedProperties[2]);
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
    public final void loadMore() {
        ArrayList arrayListOf;
        if (this.isRequesting) {
            return;
        }
        this.isRequesting = true;
        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
        final String str = this.spuId;
        String str2 = this.recommendCookie;
        final Function1<ProductDetailSimilarRecomRsp, Unit> function1 = new Function1<ProductDetailSimilarRecomRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel$handleRecommendReqSuccess$1
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
                    ProductDetailShopViewModel.this.getCards().add(new ProductDetailShopRecommendViewModel(it.next(), ProductDetailShopViewModel.this.reportParams));
                }
                ProductDetailShopViewModel.this.setRecommendState(FooterRefreshState.IDLE);
                ProductDetailShopViewModel productDetailShopViewModel = ProductDetailShopViewModel.this;
                productDetailShopViewModel.recommendCookie = productDetailSimilarRecomRsp2.cookie;
                if (productDetailSimilarRecomRsp2.is_end) {
                    productDetailShopViewModel.setRecommendState(FooterRefreshState.NONE_MORE_DATA);
                    IReportParamsBuilder iReportParamsBuilder = ProductDetailShopViewModel.this.reportParams;
                    ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = iReportParamsBuilder instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder : null;
                    if (eCDetailPageReportParamsBuilder != null) {
                        eCDetailPageReportParamsBuilder.expDepth = Math.max(5, eCDetailPageReportParamsBuilder.expDepth);
                    }
                }
                ProductDetailShopViewModel.this.isRequesting = false;
                return Unit.INSTANCE;
            }
        };
        final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel$handleRecommendReqError$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str3) {
                int intValue = num.intValue();
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("req recommend info failure, spuId:["), ProductDetailShopViewModel.this.spuId, "] code:[", intValue, "] msg:[");
                m3.append(str3);
                m3.append(']');
                kLog.e("ProductDetail", m3.toString());
                ProductDetailShopViewModel.this.setRecommendState(FooterRefreshState.FAILURE);
                ProductDetailShopViewModel.this.isRequesting = false;
                return Unit.INSTANCE;
            }
        };
        final Function1<ProductDetailSimilarRecomRsp, Unit> function12 = new Function1<ProductDetailSimilarRecomRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqRecommendCardInfo$1
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
        final Function2<Integer, String, Unit> function22 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqRecommendCardInfo$2
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
        Function3<ProductDetailSimilarRecomRsp, Integer, String, Unit> function3 = new Function3<ProductDetailSimilarRecomRsp, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqRecommendInfo$1
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
        e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("shop_id", "", "scene", 2);
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

    public final boolean popRetainWindow() {
        e eVar = new e();
        IReportParamsBuilder iReportParamsBuilder = this.reportParams;
        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = iReportParamsBuilder instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder : null;
        if (eCDetailPageReportParamsBuilder != null) {
            ECDetailPageReportParamsBuilder addActivityId = eCDetailPageReportParamsBuilder.addSellerId().addShopId().addSpuId().addRole().addPriSortId().addActivityType().addActivityId();
            addActivityId.paramsMap.put("activity_state", Integer.valueOf(addActivityId.activityState));
            ECDetailPageReportParamsBuilder addContentId = addActivityId.addProgramId().addRoomId().addSourceFrom().addContentId();
            addContentId.paramsMap.put("click_id", addContentId.adClickId);
            eVar = eCDetailPageReportParamsBuilder.buildParamsJson();
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        String str = this.retainId;
        if (str != null) {
            booleanRef.element = ECRetainHelper.INSTANCE.showRetainView(str, this.spuId, eVar, new Function1<ECRetainViewOption, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel$popRetainWindow$2$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ECRetainViewOption eCRetainViewOption) {
                    if (eCRetainViewOption == ECRetainViewOption.EXIT) {
                        Ref.BooleanRef.this.element = false;
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        return booleanRef.element;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshPageRetainInfo(String str, Continuation<? super Unit> continuation) {
        ProductDetailShopViewModel$refreshPageRetainInfo$1 productDetailShopViewModel$refreshPageRetainInfo$1;
        Object coroutine_suspended;
        int i3;
        ProductDetailShopViewModel productDetailShopViewModel;
        ECRetainInfoModel eCRetainInfoModel;
        if (continuation instanceof ProductDetailShopViewModel$refreshPageRetainInfo$1) {
            productDetailShopViewModel$refreshPageRetainInfo$1 = (ProductDetailShopViewModel$refreshPageRetainInfo$1) continuation;
            int i16 = productDetailShopViewModel$refreshPageRetainInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                productDetailShopViewModel$refreshPageRetainInfo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = productDetailShopViewModel$refreshPageRetainInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = productDetailShopViewModel$refreshPageRetainInfo$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ECRetainRepository eCRetainRepository = ECRetainRepository.INSTANCE;
                    productDetailShopViewModel$refreshPageRetainInfo$1.L$0 = this;
                    productDetailShopViewModel$refreshPageRetainInfo$1.label = 1;
                    obj = eCRetainRepository.asyncGetRetainInfo(str, "500002", productDetailShopViewModel$refreshPageRetainInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    productDetailShopViewModel = this;
                } else if (i3 == 1) {
                    productDetailShopViewModel = productDetailShopViewModel$refreshPageRetainInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCRetainInfoModel = (ECRetainInfoModel) obj;
                if (eCRetainInfoModel != null || (r6 = eCRetainInfoModel.retainId) == null) {
                    String str2 = "";
                }
                productDetailShopViewModel.retainId = str2;
                return Unit.INSTANCE;
            }
        }
        productDetailShopViewModel$refreshPageRetainInfo$1 = new ProductDetailShopViewModel$refreshPageRetainInfo$1(this, continuation);
        Object obj2 = productDetailShopViewModel$refreshPageRetainInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = productDetailShopViewModel$refreshPageRetainInfo$1.label;
        if (i3 != 0) {
        }
        eCRetainInfoModel = (ECRetainInfoModel) obj2;
        if (eCRetainInfoModel != null) {
        }
        String str22 = "";
        productDetailShopViewModel.retainId = str22;
        return Unit.INSTANCE;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final FooterRefreshState refreshState() {
        return (FooterRefreshState) this.recommendState$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setHeight(float f16) {
        this.height$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(f16));
    }

    public final void setRecommendState(FooterRefreshState footerRefreshState) {
        this.recommendState$delegate.setValue(this, $$delegatedProperties[1], footerRefreshState);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel
    public final void setRefreshState(FooterRefreshState footerRefreshState) {
        setRecommendState(footerRefreshState);
    }
}
