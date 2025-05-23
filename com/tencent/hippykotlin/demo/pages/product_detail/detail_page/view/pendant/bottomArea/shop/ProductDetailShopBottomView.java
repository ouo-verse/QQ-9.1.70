package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ECEmptyViewView;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.SchemeParamExtensionKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.ECDetailPageReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.IReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailButtonItem;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes31.dex */
public final class ProductDetailShopBottomView extends ProductDetailPendantView implements IProductDetailPageSubView {
    public float scrollProgress;

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$bigBtn(ProductDetailShopBottomView productDetailShopBottomView, ProductDetailButtonItem productDetailButtonItem, Function1 function1) {
        IProductDetailPendantViewModel viewModel = ((ProductDetailPendantAttr) productDetailShopBottomView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomViewModel");
        return new ProductDetailShopBottomView$bigBtn$1((ProductDetailShopBottomViewModel) viewModel, function1, productDetailButtonItem);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ProductDetailPendantAttr access$getAttr(ProductDetailShopBottomView productDetailShopBottomView) {
        return (ProductDetailPendantAttr) productDetailShopBottomView.getAttr();
    }

    public static final Function1 access$handleTapPendant(final ProductDetailShopBottomView productDetailShopBottomView) {
        productDetailShopBottomView.getClass();
        return new Function1<ProductDetailButtonItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView$handleTapPendant$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ProductDetailButtonItem productDetailButtonItem) {
                boolean contains;
                boolean contains2;
                boolean contains3;
                String str;
                List split$default;
                Object last;
                List split$default2;
                List split$default3;
                ProductDetailButtonItem productDetailButtonItem2 = productDetailButtonItem;
                IProductDetailPendantViewModel viewModel = ProductDetailShopBottomView.access$getAttr(ProductDetailShopBottomView.this).getViewModel();
                Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomViewModel");
                ProductDetailShopBottomViewModel productDetailShopBottomViewModel = (ProductDetailShopBottomViewModel) viewModel;
                float f16 = ProductDetailShopBottomView.this.scrollProgress;
                productDetailShopBottomViewModel.getClass();
                String str2 = productDetailButtonItem2.jumpUrl;
                boolean z16 = true;
                contains = StringsKt__StringsKt.contains((CharSequence) str2, (CharSequence) "target=21", true);
                if (contains) {
                    IReportParamsBuilder iReportParamsBuilder = productDetailShopBottomViewModel.reportParams;
                    ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = iReportParamsBuilder instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder : null;
                    if (eCDetailPageReportParamsBuilder != null) {
                        eCDetailPageReportParamsBuilder.addBuiId().addSellerId().addShopId().addSpuId().addRole().addPriSortId().addRoomId().addSourceFrom().addContentId();
                        Utils utils = Utils.INSTANCE;
                        ProductDetailDistributionPageModel$$ExternalSyntheticOutline1.m(eCDetailPageReportParamsBuilder, ProductDetailDistributionPageModel$$ExternalSyntheticOutline0.m(eCDetailPageReportParamsBuilder, utils.currentBridgeModule(), "qstore_prd_detail_pg_enter_store_ck", "[ProductDetailReporter] reportEnterStore, event cod = qstore_prd_detail_pg_enter_store_ck, data = "), utils);
                    }
                }
                contains2 = StringsKt__StringsKt.contains((CharSequence) str2, (CharSequence) "target=43", true);
                if (contains2) {
                    IReportParamsBuilder iReportParamsBuilder2 = productDetailShopBottomViewModel.reportParams;
                    ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder2 = iReportParamsBuilder2 instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder2 : null;
                    if (eCDetailPageReportParamsBuilder2 != null) {
                        eCDetailPageReportParamsBuilder2.addBuiId().addSellerId().addShopId().addSpuId().addRole().addPriSortId().addRoomId().addSourceFrom().addContentId();
                        Utils utils2 = Utils.INSTANCE;
                        ProductDetailDistributionPageModel$$ExternalSyntheticOutline1.m(eCDetailPageReportParamsBuilder2, ProductDetailDistributionPageModel$$ExternalSyntheticOutline0.m(eCDetailPageReportParamsBuilder2, utils2.currentBridgeModule(), "qstore_prd_detail_pg_contact_ck", "[ProductDetailReporter] reportContactClk, event cod = qstore_prd_detail_pg_contact_ck, data = "), utils2);
                    }
                }
                contains3 = StringsKt__StringsKt.contains((CharSequence) str2, (CharSequence) "target=33", true);
                if (contains3) {
                    IReportParamsBuilder iReportParamsBuilder3 = productDetailShopBottomViewModel.reportParams;
                    ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder3 = iReportParamsBuilder3 instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder3 : null;
                    if (eCDetailPageReportParamsBuilder3 != null) {
                        eCDetailPageReportParamsBuilder3.addBuiId().addSellerId().addShopId().addSpuId().addRole().addPriSortId().addRoomId().addSourceFrom().addContentId();
                        Utils utils3 = Utils.INSTANCE;
                        ProductDetailDistributionPageModel$$ExternalSyntheticOutline1.m(eCDetailPageReportParamsBuilder3, ProductDetailDistributionPageModel$$ExternalSyntheticOutline0.m(eCDetailPageReportParamsBuilder3, utils3.currentBridgeModule(), "qstore_prd_detail_pg_go_purchase_ck", "[ProductDetailReporter] reportPurchaseClk, event cod = qstore_prd_detail_pg_go_purchase_ck, data = "), utils3);
                    }
                }
                c cVar = c.f117352a;
                e userData = PageDataExtKt.getUserData(cVar.g().getPageData());
                if (f16 >= 0.6f) {
                    userData.v("half", "0");
                    userData.v(LayoutAttrDefine.MARGIN_TOP, "0");
                    userData.v("bg_mask_alpha", "0");
                } else if (!AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar)) {
                    userData.v("half", "1");
                }
                BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                if (productDetailButtonItem2.buttonType != 3) {
                    str = productDetailButtonItem2.jumpUrl;
                } else {
                    str = productDetailButtonItem2.jumpUrl;
                    if (SchemeParamExtensionKt.schemeAmsClickID(productDetailShopBottomViewModel.params).length() > 0) {
                        str = ProductDetailShopBottomViewModel.appendParamToScheme$default(productDetailShopBottomViewModel, "qz_gdt", SchemeParamExtensionKt.schemeAmsClickID(productDetailShopBottomViewModel.params), str);
                    }
                    if (productDetailShopBottomViewModel.params.p("source_from").length() > 0) {
                        str = ProductDetailShopBottomViewModel.appendParamToScheme$default(productDetailShopBottomViewModel, "source_from", productDetailShopBottomViewModel.params.p("source_from"), str);
                    }
                    split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default);
                    split$default2 = StringsKt__StringsKt.split$default((CharSequence) last, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
                    Iterator it = split$default2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z16 = false;
                            break;
                        }
                        split$default3 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                        if (split$default3.size() == 2 && Intrinsics.areEqual(split$default3.get(0), "target") && Intrinsics.areEqual(split$default3.get(1), WadlProxyConsts.OPER_TYPE_APK_SIGN)) {
                            break;
                        }
                    }
                    if (z16) {
                        str = AgreementConsentViewKt$$ExternalSyntheticOutline0.m(str, "&is_trans_activity=1");
                    }
                }
                BridgeModule.openPage$default(currentBridgeModule, str, false, userData, null, 26);
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        c.f117352a.k(BridgeManager.f117344a.u()).getPageData();
        IProductDetailPendantViewModel viewModel = ((ProductDetailPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomViewModel");
        final ProductDetailShopBottomViewModel productDetailShopBottomViewModel = (ProductDetailShopBottomViewModel) viewModel;
        if (productDetailShopBottomViewModel.bottomInfoArray().length >= 3) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView$body$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                    ViewContainer<?, ?> viewContainer2 = viewContainer;
                    final ProductDetailShopBottomViewModel productDetailShopBottomViewModel2 = ProductDetailShopBottomViewModel.this;
                    viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView$body$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(m mVar) {
                            h hVar;
                            m mVar2 = mVar;
                            mVar2.flexDirectionColumn();
                            Attr absolutePosition$default = Attr.absolutePosition$default(mVar2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                            ProductDetailShopBottomViewModel.this.getClass();
                            absolutePosition$default.mo141height(80.0f);
                            hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                            mVar2.mo113backgroundColor(hVar);
                            return Unit.INSTANCE;
                        }
                    });
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView$body$1.2
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.body.1.2.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    ((Attr) c.a.a(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 5, null)).mo141height(1.0f);
                                    GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_divider", false, 2, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    final ProductDetailShopBottomView productDetailShopBottomView = this;
                    final ProductDetailShopBottomViewModel productDetailShopBottomViewModel3 = ProductDetailShopBottomViewModel.this;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView$body$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.body.1.3.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    h hVar;
                                    t tVar2 = tVar;
                                    c.a.a(tVar2, 10.0f, 16.0f, 0.0f, 16.0f, 4, null);
                                    tVar2.flexDirectionRow().justifyContentFlexStart();
                                    hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                    tVar2.mo113backgroundColor(hVar);
                                    return Unit.INSTANCE;
                                }
                            });
                            ProductDetailShopBottomView productDetailShopBottomView2 = ProductDetailShopBottomView.this;
                            final ProductDetailButtonItem productDetailButtonItem = productDetailShopBottomViewModel3.bottomInfoArray()[0];
                            final Function1 access$handleTapPendant = ProductDetailShopBottomView.access$handleTapPendant(ProductDetailShopBottomView.this);
                            productDetailShopBottomView2.getClass();
                            final String str = "qecommerce_skin_icon_general_store_primary";
                            new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView$smallBtn$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                    final Function1<ProductDetailButtonItem, Unit> function1 = access$handleTapPendant;
                                    final ProductDetailButtonItem productDetailButtonItem2 = productDetailButtonItem;
                                    final String str2 = str;
                                    w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView$smallBtn$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            v vVar4 = vVar3;
                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.smallBtn.1.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.flexDirectionColumn();
                                                    tVar2.alignItemsCenter();
                                                    tVar2.justifyContentFlexStart();
                                                    tVar2.marginRight(16.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final Function1<ProductDetailButtonItem, Unit> function12 = function1;
                                            final ProductDetailButtonItem productDetailButtonItem3 = productDetailButtonItem2;
                                            vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.smallBtn.1.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    final Function1<ProductDetailButtonItem, Unit> function13 = function12;
                                                    final ProductDetailButtonItem productDetailButtonItem4 = productDetailButtonItem3;
                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.smallBtn.1.1.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            function13.invoke(productDetailButtonItem4);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final String str3 = str2;
                                            ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.smallBtn.1.1.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    final String str4 = str3;
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.smallBtn.1.1.3.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            af afVar2 = afVar;
                                                            ImageAttrExtKt.srcUrl(afVar2, str4, null);
                                                            afVar2.size(20.0f, 20.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final ProductDetailButtonItem productDetailButtonItem4 = productDetailButtonItem2;
                                            cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.smallBtn.1.1.4
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final ProductDetailButtonItem productDetailButtonItem5 = ProductDetailButtonItem.this;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.smallBtn.1.1.4.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            h hVar;
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.marginTop(4.0f);
                                                            ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                            ceVar2.text(ProductDetailButtonItem.this.txt);
                                                            hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                            ceVar2.color(hVar);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            }.invoke(vVar2);
                            ProductDetailShopBottomView productDetailShopBottomView3 = ProductDetailShopBottomView.this;
                            final ProductDetailButtonItem productDetailButtonItem2 = productDetailShopBottomViewModel3.bottomInfoArray()[1];
                            final Function1 access$handleTapPendant2 = ProductDetailShopBottomView.access$handleTapPendant(ProductDetailShopBottomView.this);
                            productDetailShopBottomView3.getClass();
                            final String str2 = "qecommerce_skin_icon_general_cs_primary";
                            new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView$smallBtn$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                    final Function1<? super ProductDetailButtonItem, Unit> function1 = access$handleTapPendant2;
                                    final ProductDetailButtonItem productDetailButtonItem22 = productDetailButtonItem2;
                                    final String str22 = str2;
                                    w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView$smallBtn$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            v vVar4 = vVar3;
                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.smallBtn.1.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.flexDirectionColumn();
                                                    tVar2.alignItemsCenter();
                                                    tVar2.justifyContentFlexStart();
                                                    tVar2.marginRight(16.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final Function1<? super ProductDetailButtonItem, Unit> function12 = function1;
                                            final ProductDetailButtonItem productDetailButtonItem3 = productDetailButtonItem22;
                                            vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.smallBtn.1.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    final Function1<? super ProductDetailButtonItem, Unit> function13 = function12;
                                                    final ProductDetailButtonItem productDetailButtonItem4 = productDetailButtonItem3;
                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.smallBtn.1.1.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            function13.invoke(productDetailButtonItem4);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final String str3 = str22;
                                            ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.smallBtn.1.1.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    final String str4 = str3;
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.smallBtn.1.1.3.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            af afVar2 = afVar;
                                                            ImageAttrExtKt.srcUrl(afVar2, str4, null);
                                                            afVar2.size(20.0f, 20.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final ProductDetailButtonItem productDetailButtonItem4 = productDetailButtonItem22;
                                            cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.smallBtn.1.1.4
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final ProductDetailButtonItem productDetailButtonItem5 = ProductDetailButtonItem.this;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.smallBtn.1.1.4.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            h hVar;
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.marginTop(4.0f);
                                                            ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                            ceVar2.text(ProductDetailButtonItem.this.txt);
                                                            hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                            ceVar2.color(hVar);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            }.invoke(vVar2);
                            ((ProductDetailShopBottomView$bigBtn$1) ProductDetailShopBottomView.access$bigBtn(ProductDetailShopBottomView.this, productDetailShopBottomViewModel3.bottomInfoArray()[2], ProductDetailShopBottomView.access$handleTapPendant(ProductDetailShopBottomView.this))).invoke(vVar2);
                            return Unit.INSTANCE;
                        }
                    });
                    return Unit.INSTANCE;
                }
            };
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView$body$2
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                viewContainer.addChild(new ECEmptyViewView(), new Function1<ECEmptyViewView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView$body$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(ECEmptyViewView eCEmptyViewView) {
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final boolean mainViewScrollEnable() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final void mainViewScrollEvent(ScrollParams scrollParams) {
        IProductDetailPendantViewModel viewModel = ((ProductDetailPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomViewModel");
        ProductDetailShopBottomViewModel productDetailShopBottomViewModel = (ProductDetailShopBottomViewModel) viewModel;
        g pageData = com.tencent.kuikly.core.manager.c.f117352a.k(BridgeManager.f117344a.u()).getPageData();
        float schemeMarginTop = SchemeParamExtensionKt.schemeMarginTop(pageData.n());
        if (Math.abs(schemeMarginTop - 0) <= 0.1f) {
            schemeMarginTop = pageData.m() * 0.48f;
        }
        this.scrollProgress = Math.min(1.0f, Math.max(scrollParams.getOffsetY() / ((pageData.getNavigationBarHeight() - 44.0f) + schemeMarginTop), 0.0f));
        if (SchemeParamExtensionKt.schemeIsHalf(productDetailShopBottomViewModel.params)) {
            return;
        }
        this.scrollProgress = 2.0f;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final void mainViewScrollEnd() {
    }
}
