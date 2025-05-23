package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.PageListEvent;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.be;
import com.tencent.kuikly.core.views.bf;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes33.dex */
public final class MyCouponTabPageView extends ComposeView<MyCouponTabPageAttr, MyCouponTabPageEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(MyCouponTabPageView.class, "categoryIndicator", "getCategoryIndicator()F", 0)};
    public int currentPageIndex;
    public aa<PageListView<?, ?>> pageListRef;
    public final ArrayList<Function1<ViewContainer<?, ?>, Unit>> pageViews = new ArrayList<>();
    public final ArrayList<MyCouponTabPageConfig> pageConfigs = new ArrayList<>();
    public final ReadWriteProperty categoryIndicator$delegate = c.a(Float.valueOf(0.0f));
    public boolean isLinkageCategoryIndex = true;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ MyCouponTabPageAttr access$getAttr(MyCouponTabPageView myCouponTabPageView) {
        return (MyCouponTabPageAttr) myCouponTabPageView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$handlePageIndexDidChangedEvent(MyCouponTabPageView myCouponTabPageView, e eVar) {
        myCouponTabPageView.getClass();
        int k3 = eVar.k("index", 0);
        if (k3 != myCouponTabPageView.currentPageIndex) {
            ((MyCouponTabPageEvent) myCouponTabPageView.getEvent()).onFireEvent("myCouponTabPageSwitchEvent", new MyCouponSwitchTabPageEvent(myCouponTabPageView.currentPageIndex, k3));
            myCouponTabPageView.currentPageIndex = k3;
            BridgeModule bridgeModule = Utils.INSTANCE.bridgeModule(BridgeManager.f117344a.u());
            e eVar2 = new e();
            eVar2.t(EmotionReportDtImpl.CURRENT_TAB, k3 + 1);
            Unit unit = Unit.INSTANCE;
            bridgeModule.reportDT("ds_my_coupon_page_exp", eVar2);
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponTabPageView$body$1
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final MyCouponTabPageView myCouponTabPageView = MyCouponTabPageView.this;
                final MyCouponTabPageAttr myCouponTabPageAttr = (MyCouponTabPageAttr) myCouponTabPageView.getViewAttr();
                myCouponTabPageView.addChild(new MyCouponCategoryView(), new Function1<MyCouponCategoryView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponTabPageView$bodyWithCategoryView$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(MyCouponCategoryView myCouponCategoryView) {
                        MyCouponCategoryView myCouponCategoryView2 = myCouponCategoryView;
                        final MyCouponTabPageAttr myCouponTabPageAttr2 = MyCouponTabPageAttr.this;
                        final MyCouponTabPageView myCouponTabPageView2 = myCouponTabPageView;
                        myCouponCategoryView2.attr(new Function1<CategoryAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponTabPageView$bodyWithCategoryView$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(CategoryAttr categoryAttr) {
                                h hVar;
                                CategoryAttr categoryAttr2 = categoryAttr;
                                categoryAttr2.mo153width(MyCouponTabPageAttr.this.width());
                                categoryAttr2.mo141height(MyCouponTabPageAttr.this.tabHeight);
                                categoryAttr2.marginBottom(MyCouponTabPageAttr.this.tabMarginBottom);
                                categoryAttr2.items = myCouponTabPageView2.pageConfigs;
                                hVar = IPagerIdKtxKt.getSkinColor(categoryAttr2).tokenColor("qecommerce_skin_color_icon_primary", false);
                                categoryAttr2.indicatorColor = hVar;
                                MyCouponTabPageView myCouponTabPageView3 = myCouponTabPageView2;
                                categoryAttr2.indicatorPosition(((Number) myCouponTabPageView3.categoryIndicator$delegate.getValue(myCouponTabPageView3, MyCouponTabPageView.$$delegatedProperties[0])).floatValue(), myCouponTabPageView2.isLinkageCategoryIndex);
                                return Unit.INSTANCE;
                            }
                        });
                        final MyCouponTabPageView myCouponTabPageView3 = myCouponTabPageView;
                        myCouponCategoryView2.event(new Function1<CategoryEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponTabPageView$bodyWithCategoryView$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(CategoryEvent categoryEvent) {
                                final MyCouponTabPageView myCouponTabPageView4 = MyCouponTabPageView.this;
                                categoryEvent.registerEvent("clickTabSwitch", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponTabPageView.bodyWithCategoryView.1.2.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        MyCouponTabPageView myCouponTabPageView5 = MyCouponTabPageView.this;
                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue = ((Integer) obj).intValue();
                                        KProperty<Object>[] kPropertyArr = MyCouponTabPageView.$$delegatedProperties;
                                        float width = ((MyCouponTabPageAttr) myCouponTabPageView5.getViewAttr()).width() * intValue;
                                        myCouponTabPageView5.isLinkageCategoryIndex = false;
                                        aa<PageListView<?, ?>> aaVar = myCouponTabPageView5.pageListRef;
                                        if (aaVar == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("pageListRef");
                                            aaVar = null;
                                        }
                                        PageListView<?, ?> b16 = aaVar.b();
                                        if (b16 != null) {
                                            ScrollerView.setContentOffset$default(b16, width, 0.0f, true, null, 8, null);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final MyCouponTabPageView myCouponTabPageView2 = MyCouponTabPageView.this;
                final MyCouponTabPageAttr myCouponTabPageAttr2 = (MyCouponTabPageAttr) myCouponTabPageView2.getViewAttr();
                bf.a(myCouponTabPageView2, new Function1<PageListView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponTabPageView$bodyWithPageList$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(PageListView<?, ?> pageListView) {
                        PageListView<?, ?> pageListView2 = pageListView;
                        final MyCouponTabPageView myCouponTabPageView3 = MyCouponTabPageView.this;
                        pageListView2.ref(pageListView2, new Function1<aa<PageListView<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponTabPageView$bodyWithPageList$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<PageListView<?, ?>> aaVar) {
                                MyCouponTabPageView.this.pageListRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final MyCouponTabPageAttr myCouponTabPageAttr3 = myCouponTabPageAttr2;
                        final MyCouponTabPageView myCouponTabPageView4 = MyCouponTabPageView.this;
                        pageListView2.attr(new Function1<be, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponTabPageView$bodyWithPageList$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(be beVar) {
                                be beVar2 = beVar;
                                beVar2.pageItemWidth(MyCouponTabPageAttr.this.width());
                                FlexNode flexNode = MyCouponTabPageAttr.this.getFlexNode();
                                float K = flexNode != null ? flexNode.K() : 0.0f;
                                MyCouponTabPageAttr myCouponTabPageAttr4 = MyCouponTabPageAttr.this;
                                beVar2.pageItemHeight((K - myCouponTabPageAttr4.tabHeight) - myCouponTabPageAttr4.tabMarginBottom);
                                MyCouponTabPageView.access$getAttr(myCouponTabPageView4).getClass();
                                beVar2.defaultPageIndex(0);
                                beVar2.pageDirection(true);
                                beVar2.showScrollerIndicator(false);
                                beVar2.setKeepItemAlive(true);
                                return Unit.INSTANCE;
                            }
                        });
                        final MyCouponTabPageView myCouponTabPageView5 = MyCouponTabPageView.this;
                        pageListView2.event(new Function1<PageListEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponTabPageView$bodyWithPageList$1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(PageListEvent pageListEvent) {
                                PageListEvent pageListEvent2 = pageListEvent;
                                final MyCouponTabPageView myCouponTabPageView6 = MyCouponTabPageView.this;
                                pageListEvent2.dragBegin(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponTabPageView.bodyWithPageList.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        MyCouponTabPageView.this.isLinkageCategoryIndex = true;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final MyCouponTabPageView myCouponTabPageView7 = MyCouponTabPageView.this;
                                pageListEvent2.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponTabPageView.bodyWithPageList.1.3.2
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        MyCouponTabPageView myCouponTabPageView8 = MyCouponTabPageView.this;
                                        KProperty<Object>[] kPropertyArr = MyCouponTabPageView.$$delegatedProperties;
                                        float width = ((MyCouponTabPageAttr) myCouponTabPageView8.getViewAttr()).width();
                                        myCouponTabPageView8.categoryIndicator$delegate.setValue(myCouponTabPageView8, MyCouponTabPageView.$$delegatedProperties[0], Float.valueOf((scrollParams.getOffsetX() / (myCouponTabPageView8.pageConfigs.size() * width)) * width));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final MyCouponTabPageView myCouponTabPageView8 = MyCouponTabPageView.this;
                                pageListEvent2.pageIndexDidChanged(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponTabPageView.bodyWithPageList.1.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        MyCouponTabPageView myCouponTabPageView9 = MyCouponTabPageView.this;
                                        e eVar = obj instanceof e ? (e) obj : null;
                                        if (eVar == null) {
                                            eVar = new e();
                                        }
                                        MyCouponTabPageView.access$handlePageIndexDidChangedEvent(myCouponTabPageView9, eVar);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        Iterator<Function1<ViewContainer<?, ?>, Unit>> it = MyCouponTabPageView.this.pageViews.iterator();
                        while (it.hasNext()) {
                            it.next().invoke(pageListView2);
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new MyCouponTabPageAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new MyCouponTabPageEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        int i3 = this.currentPageIndex;
        BridgeModule bridgeModule = Utils.INSTANCE.bridgeModule(BridgeManager.f117344a.u());
        e eVar = new e();
        eVar.t(EmotionReportDtImpl.CURRENT_TAB, i3 + 1);
        Unit unit = Unit.INSTANCE;
        bridgeModule.reportDT("ds_my_coupon_page_exp", eVar);
    }
}
