package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ECButton;
import com.tencent.hippykotlin.demo.pages.base.ECButtonAttr;
import com.tencent.hippykotlin.demo.pages.base.ECButtonKt;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.base.FloatingPanelAttr;
import com.tencent.hippykotlin.demo.pages.base.FloatingPanelEvent;
import com.tencent.hippykotlin.demo.pages.base.FloatingPanelView;
import com.tencent.hippykotlin.demo.pages.base.FloatingPanelViewKt$FloatingPanelView$1;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemModel;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes33.dex */
public final class SelectCouponPage extends BasePager {
    public SelectCouponViewModel viewModel;

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final String str;
        SelectCouponViewModel selectCouponViewModel = this.viewModel;
        if (selectCouponViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            selectCouponViewModel = null;
        }
        SelectCouponViewModel.PageData optPageData = SelectCouponViewModelKt.optPageData(selectCouponViewModel.getPageState());
        if (optPageData == null || (str = optPageData.sellerId) == null) {
            str = "";
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                AnonymousClass1 anonymousClass1 = new Function1<FloatingPanelAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(FloatingPanelAttr floatingPanelAttr) {
                        Float floatOrNull;
                        FloatingPanelAttr floatingPanelAttr2 = floatingPanelAttr;
                        floatingPanelAttr2.title = "\u4f18\u60e0\u5238";
                        floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(floatingPanelAttr2.getPagerData().n().p(LayoutAttrDefine.MARGIN_TOP));
                        if (floatOrNull != null) {
                            floatingPanelAttr2.marginTop = floatOrNull.floatValue();
                        }
                        return Unit.INSTANCE;
                    }
                };
                final String str2 = str;
                Function1<FloatingPanelEvent, Unit> function1 = new Function1<FloatingPanelEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(FloatingPanelEvent floatingPanelEvent) {
                        FloatingPanelEvent floatingPanelEvent2 = floatingPanelEvent;
                        final String str3 = str2;
                        floatingPanelEvent2.registerEvent("actionShow", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                String str4 = str3;
                                BridgeModule bridgeModule = Utils.INSTANCE.bridgeModule(BridgeManager.f117344a.u());
                                e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("seller_id", str4, "scene", 2);
                                m3.t("layer_type", 2);
                                Unit unit = Unit.INSTANCE;
                                bridgeModule.reportDT("qstore_price_reduce_layer_exp", m3);
                                return Unit.INSTANCE;
                            }
                        });
                        final String str4 = str2;
                        floatingPanelEvent2.registerEvent("actionClose", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                String str5 = str4;
                                BridgeModule bridgeModule = Utils.INSTANCE.bridgeModule(BridgeManager.f117344a.u());
                                e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("seller_id", str5, "scene", 2);
                                m3.t("layer_type", 2);
                                m3.t("act_type", 3);
                                Unit unit = Unit.INSTANCE;
                                bridgeModule.reportDT("qstore_price_reduce_layer_clk", m3);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                };
                final SelectCouponPage selectCouponPage = this;
                final String str3 = str;
                viewContainer.addChild(new FloatingPanelView(new Function2<ViewContainer<?, ?>, FloatingPanelView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(ViewContainer<?, ?> viewContainer2, FloatingPanelView floatingPanelView) {
                        ViewContainer<?, ?> viewContainer3 = viewContainer2;
                        final FloatingPanelView floatingPanelView2 = floatingPanelView;
                        final SelectCouponPage selectCouponPage2 = SelectCouponPage.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                SelectCouponViewModel selectCouponViewModel2 = SelectCouponPage.this.viewModel;
                                if (selectCouponViewModel2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    selectCouponViewModel2 = null;
                                }
                                return selectCouponViewModel2.getPageState();
                            }
                        };
                        final SelectCouponPage selectCouponPage3 = SelectCouponPage.this;
                        final String str4 = str3;
                        BindDirectivesViewKt.a(viewContainer3, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                SelectCouponViewModel selectCouponViewModel2 = SelectCouponPage.this.viewModel;
                                SelectCouponViewModel selectCouponViewModel3 = null;
                                if (selectCouponViewModel2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    selectCouponViewModel2 = null;
                                }
                                if (Intrinsics.areEqual(selectCouponViewModel2.getPageState(), SelectCouponViewModel.PageState.Empty.INSTANCE)) {
                                    w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            v vVar2 = vVar;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.2.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.allCenter();
                                                    tVar2.m140flex(1.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.2.1.2
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.2.1.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            af afVar2 = afVar;
                                                            b.a.b(afVar2, "qecommerce_skin_emptystate_img_dongtai", false, 2, null);
                                                            afVar2.size(256.0f, 192.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.2.1.3
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.2.1.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.text("\u6682\u65e0\u53ef\u7528\u4f18\u60e0\u5238");
                                                            ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                            ceVar2.color(IPagerIdKtxKt.getSkinColor(ceVar2).getPrimaryTextColor());
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else {
                                    final SelectCouponPage selectCouponPage4 = SelectCouponPage.this;
                                    final String str5 = str4;
                                    bindDirectivesView2.addChild(new SelectCouponList(), new Function1<SelectCouponList, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(SelectCouponList selectCouponList) {
                                            SelectCouponList selectCouponList2 = selectCouponList;
                                            final SelectCouponPage selectCouponPage5 = SelectCouponPage.this;
                                            selectCouponList2.attr(new Function1<SelectCouponAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.2.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(SelectCouponAttr selectCouponAttr) {
                                                    SelectCouponAttr selectCouponAttr2 = selectCouponAttr;
                                                    selectCouponAttr2.m140flex(1.0f);
                                                    SelectCouponViewModel selectCouponViewModel4 = SelectCouponPage.this.viewModel;
                                                    if (selectCouponViewModel4 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                                        selectCouponViewModel4 = null;
                                                    }
                                                    selectCouponAttr2.listState = selectCouponViewModel4.getPageState();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final SelectCouponPage selectCouponPage6 = SelectCouponPage.this;
                                            final String str6 = str5;
                                            selectCouponList2.event(new Function1<SelectCouponEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.2.2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(SelectCouponEvent selectCouponEvent) {
                                                    SelectCouponEvent selectCouponEvent2 = selectCouponEvent;
                                                    final SelectCouponPage selectCouponPage7 = SelectCouponPage.this;
                                                    selectCouponEvent2.registerEvent("clickBestSelection", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.2.2.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(Object obj) {
                                                            SelectCouponViewModel.PageState pageState;
                                                            int collectionSizeOrDefault;
                                                            CouponItem couponItem;
                                                            boolean z16;
                                                            SelectCouponViewModel selectCouponViewModel4 = SelectCouponPage.this.viewModel;
                                                            if (selectCouponViewModel4 == null) {
                                                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                                                selectCouponViewModel4 = null;
                                                            }
                                                            SelectCouponViewModel.PageState pageState2 = selectCouponViewModel4.getPageState();
                                                            if (pageState2 instanceof SelectCouponViewModel.PageState.Succeed) {
                                                                SelectCouponViewModel.PageData pageData = selectCouponViewModel4.currentPageData;
                                                                if (pageData != null) {
                                                                    pageState = new SelectCouponViewModel.PageState.Loading(pageData, selectCouponViewModel4.shouldShowTitleInList(pageData.list));
                                                                } else {
                                                                    pageState = SelectCouponViewModel.PageState.Empty.INSTANCE;
                                                                }
                                                                selectCouponViewModel4.setPageState(pageState);
                                                                ArrayList arrayList = new ArrayList();
                                                                for (SelectCouponItemModel selectCouponItemModel : ((SelectCouponViewModel.PageState.Succeed) pageState2).pageData.list) {
                                                                    boolean z17 = selectCouponItemModel instanceof CouponItem;
                                                                    if (z17 && (z16 = (couponItem = (CouponItem) selectCouponItemModel).isBest)) {
                                                                        CommonCouponItemModel commonCouponItemModel = couponItem.commonCouponItem;
                                                                        if (commonCouponItemModel.isEnabled) {
                                                                            arrayList.add(new CouponItem(commonCouponItemModel, true, z16));
                                                                        }
                                                                    }
                                                                    if (z17) {
                                                                        arrayList.add(CouponItem.copy$default((CouponItem) selectCouponItemModel, false));
                                                                    } else {
                                                                        arrayList.add(selectCouponItemModel);
                                                                    }
                                                                }
                                                                List<CouponItem> allSelectedCoupon = selectCouponViewModel4.getAllSelectedCoupon(arrayList);
                                                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(allSelectedCoupon, 10);
                                                                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                                                                Iterator it = ((ArrayList) allSelectedCoupon).iterator();
                                                                while (it.hasNext()) {
                                                                    arrayList2.add(((CouponItem) it.next()).commonCouponItem.f114301id);
                                                                }
                                                                selectCouponViewModel4.notifyCouponSelected(arrayList2);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final SelectCouponPage selectCouponPage8 = SelectCouponPage.this;
                                                    final String str7 = str6;
                                                    selectCouponEvent2.registerEvent("selectCoupon", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.2.2.2.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
                                                        @Override // kotlin.jvm.functions.Function1
                                                        /*
                                                            Code decompiled incorrectly, please refer to instructions dump.
                                                        */
                                                        public final Unit invoke(Object obj) {
                                                            boolean z16;
                                                            SelectCouponViewModel.PageState pageState;
                                                            Object obj2;
                                                            int collectionSizeOrDefault;
                                                            List<String> plus;
                                                            int collectionSizeOrDefault2;
                                                            List<String> minus;
                                                            boolean isBlank;
                                                            SelectCouponViewModel selectCouponViewModel4 = SelectCouponPage.this.viewModel;
                                                            if (selectCouponViewModel4 == null) {
                                                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                                                selectCouponViewModel4 = null;
                                                            }
                                                            String str8 = obj instanceof String ? (String) obj : null;
                                                            selectCouponViewModel4.getClass();
                                                            if (str8 != null) {
                                                                isBlank = StringsKt__StringsJVMKt.isBlank(str8);
                                                                if (!isBlank) {
                                                                    z16 = false;
                                                                    if (!z16) {
                                                                        SelectCouponViewModel.PageState pageState2 = selectCouponViewModel4.getPageState();
                                                                        if (pageState2 instanceof SelectCouponViewModel.PageState.Succeed) {
                                                                            SelectCouponViewModel.PageData pageData = selectCouponViewModel4.currentPageData;
                                                                            if (pageData != null) {
                                                                                pageState = new SelectCouponViewModel.PageState.Loading(pageData, selectCouponViewModel4.shouldShowTitleInList(pageData.list));
                                                                            } else {
                                                                                pageState = SelectCouponViewModel.PageState.Empty.INSTANCE;
                                                                            }
                                                                            selectCouponViewModel4.setPageState(pageState);
                                                                            SelectCouponViewModel.PageState.Succeed succeed = (SelectCouponViewModel.PageState.Succeed) pageState2;
                                                                            List<SelectCouponItemModel> list = succeed.pageData.list;
                                                                            ListIterator<SelectCouponItemModel> listIterator = list.listIterator(list.size());
                                                                            while (true) {
                                                                                if (!listIterator.hasPrevious()) {
                                                                                    obj2 = null;
                                                                                    break;
                                                                                }
                                                                                obj2 = listIterator.previous();
                                                                                SelectCouponItemModel selectCouponItemModel = (SelectCouponItemModel) obj2;
                                                                                if ((selectCouponItemModel instanceof CouponItem) && Intrinsics.areEqual(((CouponItem) selectCouponItemModel).commonCouponItem.f114301id, str8)) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                            CouponItem couponItem = obj2 instanceof CouponItem ? (CouponItem) obj2 : null;
                                                                            if (couponItem != null) {
                                                                                List<CouponItem> allSelectedCoupon = selectCouponViewModel4.getAllSelectedCoupon(succeed.pageData.list);
                                                                                if (couponItem.isSelected) {
                                                                                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(allSelectedCoupon, 10);
                                                                                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
                                                                                    Iterator it = ((ArrayList) allSelectedCoupon).iterator();
                                                                                    while (it.hasNext()) {
                                                                                        arrayList.add(((CouponItem) it.next()).commonCouponItem.f114301id);
                                                                                    }
                                                                                    minus = CollectionsKt___CollectionsKt.minus((Iterable<? extends String>) ((Iterable<? extends Object>) arrayList), couponItem.commonCouponItem.f114301id);
                                                                                    selectCouponViewModel4.notifyCouponSelected(minus);
                                                                                } else {
                                                                                    ArrayList arrayList2 = new ArrayList();
                                                                                    Iterator it5 = ((ArrayList) allSelectedCoupon).iterator();
                                                                                    while (it5.hasNext()) {
                                                                                        Object next = it5.next();
                                                                                        if (((CouponItem) next).commonCouponItem.issuerType != couponItem.commonCouponItem.issuerType) {
                                                                                            arrayList2.add(next);
                                                                                        }
                                                                                    }
                                                                                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                                                                                    ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                                                                                    Iterator it6 = arrayList2.iterator();
                                                                                    while (it6.hasNext()) {
                                                                                        arrayList3.add(((CouponItem) it6.next()).commonCouponItem.f114301id);
                                                                                    }
                                                                                    plus = CollectionsKt___CollectionsKt.plus((Collection<? extends String>) ((Collection<? extends Object>) arrayList3), couponItem.commonCouponItem.f114301id);
                                                                                    selectCouponViewModel4.notifyCouponSelected(plus);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    String str9 = str7;
                                                                    BridgeModule bridgeModule = Utils.INSTANCE.bridgeModule(BridgeManager.f117344a.u());
                                                                    e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("seller_id", str9, "scene", 2);
                                                                    m3.t("layer_type", 2);
                                                                    m3.t("act_type", 2);
                                                                    Unit unit = Unit.INSTANCE;
                                                                    bridgeModule.reportDT("qstore_price_reduce_layer_clk", m3);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }
                                                            z16 = true;
                                                            if (!z16) {
                                                            }
                                                            String str92 = str7;
                                                            BridgeModule bridgeModule2 = Utils.INSTANCE.bridgeModule(BridgeManager.f117344a.u());
                                                            e m36 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("seller_id", str92, "scene", 2);
                                                            m36.t("layer_type", 2);
                                                            m36.t("act_type", 2);
                                                            Unit unit2 = Unit.INSTANCE;
                                                            bridgeModule2.reportDT("qstore_price_reduce_layer_clk", m36);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                SelectCouponViewModel selectCouponViewModel4 = SelectCouponPage.this.viewModel;
                                if (selectCouponViewModel4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                } else {
                                    selectCouponViewModel3 = selectCouponViewModel4;
                                }
                                if (selectCouponViewModel3.getPageState() instanceof SelectCouponViewModel.PageState.Loading) {
                                    ECLoadingViewKt.ECLoading(bindDirectivesView2, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.2.3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ECLoadingView eCLoadingView) {
                                            eCLoadingView.attr(new Function1<ECLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.2.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ECLoadingAttr eCLoadingAttr) {
                                                    eCLoadingAttr.setLoadingText("\u52a0\u8f7d\u4e2d");
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(0.5f);
                                        tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getDividerColor());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ECButtonKt.ECButton(viewContainer3, new Function1<ECButton, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECButton eCButton) {
                                ECButton eCButton2 = eCButton;
                                eCButton2.attr(new Function1<ECButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECButtonAttr eCButtonAttr) {
                                        ECButtonAttr eCButtonAttr2 = eCButtonAttr;
                                        eCButtonAttr2.mo141height(40.0f);
                                        eCButtonAttr2.margin(10.0f, 16.0f, 10.0f, 16.0f);
                                        eCButtonAttr2.titleAttrInit = new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.4.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.fontWeightBold();
                                                ceVar2.text("\u786e\u5b9a");
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        return Unit.INSTANCE;
                                    }
                                });
                                final FloatingPanelView floatingPanelView3 = FloatingPanelView.this;
                                eCButton2.event(new Function1<l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(l lVar) {
                                        final FloatingPanelView floatingPanelView4 = FloatingPanelView.this;
                                        lVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                FloatingPanelView.this.close();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        if (viewContainer3.getPager().getPageData().getIsIphoneX()) {
                            w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.5
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponPage.body.1.3.5.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            tVar.mo141height(34.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    }
                }), new FloatingPanelViewKt$FloatingPanelView$1(anonymousClass1, function1));
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        this.viewModel = new SelectCouponViewModel(IPagerIdKtxKt.getBridgeModule(this), (k) getModule("KRNotifyModule"));
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        super.didInit();
        SelectCouponViewModel selectCouponViewModel = this.viewModel;
        if (selectCouponViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            selectCouponViewModel = null;
        }
        selectCouponViewModel.refreshPage();
    }
}
