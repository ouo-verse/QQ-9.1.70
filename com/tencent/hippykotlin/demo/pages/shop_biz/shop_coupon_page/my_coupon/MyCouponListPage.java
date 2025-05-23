package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon;

import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNavigationBar;
import com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNavigationBarKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.NavBarAttr;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListViewAttr;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponSwitchTabPageEvent;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponTabPageAttr;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponTabPageConfig;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponTabPageEvent;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponTabPageView;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListViewModel;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.MyCouponListPageViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes33.dex */
public final class MyCouponListPage extends BasePager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Lazy viewModel$delegate;

    public MyCouponListPage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MyCouponListPageViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.MyCouponListPage$viewModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final MyCouponListPageViewModel invoke() {
                return new MyCouponListPageViewModel(MyCouponListPage.this.getPagerId());
            }
        });
        this.viewModel$delegate = lazy;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.MyCouponListPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                MyCouponListPage myCouponListPage = MyCouponListPage.this;
                myCouponListPage.getClass();
                ASDNavigationBarKt.NavBar(myCouponListPage, new Function1<ASDNavigationBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.MyCouponListPage$bodyWithNavBar$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ASDNavigationBar aSDNavigationBar) {
                        aSDNavigationBar.attr(new Function1<NavBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.MyCouponListPage$bodyWithNavBar$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NavBarAttr navBarAttr) {
                                navBarAttr.setNavTitle("\u6211\u7684\u4f18\u60e0\u5238");
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final MyCouponListPage myCouponListPage2 = MyCouponListPage.this;
                myCouponListPage2.getClass();
                myCouponListPage2.addChild(new MyCouponTabPageView(), new Function1<MyCouponTabPageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.MyCouponListPage$bodyWithTabPage$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(MyCouponTabPageView myCouponTabPageView) {
                        List<IMyCouponListViewModel> list;
                        final MyCouponTabPageView myCouponTabPageView2 = myCouponTabPageView;
                        final MyCouponListPage myCouponListPage3 = MyCouponListPage.this;
                        myCouponTabPageView2.attr(new Function1<MyCouponTabPageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.MyCouponListPage$bodyWithTabPage$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(MyCouponTabPageAttr myCouponTabPageAttr) {
                                MyCouponTabPageAttr myCouponTabPageAttr2 = myCouponTabPageAttr;
                                myCouponTabPageAttr2.mo113backgroundColor(SkinColor.INSTANCE.fgColor(myCouponTabPageAttr2.getPagerId()));
                                myCouponTabPageAttr2.tabHeight = 44.0f;
                                myCouponTabPageAttr2.tabMarginBottom = 12.0f;
                                myCouponTabPageAttr2.mo153width(MyCouponListPage.this.getPageData().m());
                                myCouponTabPageAttr2.mo141height(MyCouponListPage.this.getPageData().l() - MyCouponListPage.this.getPageData().getNavigationBarHeight());
                                return Unit.INSTANCE;
                            }
                        });
                        final MyCouponListPage myCouponListPage4 = MyCouponListPage.this;
                        myCouponTabPageView2.event(new Function1<MyCouponTabPageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.MyCouponListPage$bodyWithTabPage$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(MyCouponTabPageEvent myCouponTabPageEvent) {
                                final MyCouponListPage myCouponListPage5 = MyCouponListPage.this;
                                myCouponTabPageEvent.register("myCouponTabPageSwitchEvent", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.MyCouponListPage.bodyWithTabPage.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponSwitchTabPageEvent");
                                        MyCouponSwitchTabPageEvent myCouponSwitchTabPageEvent = (MyCouponSwitchTabPageEvent) obj;
                                        MyCouponListPageViewModel myCouponListPageViewModel = (MyCouponListPageViewModel) MyCouponListPage.this.viewModel$delegate.getValue();
                                        int i3 = myCouponSwitchTabPageEvent.oldIndex;
                                        int i16 = myCouponSwitchTabPageEvent.newIndex;
                                        if (i3 < myCouponListPageViewModel.tabPageViewModels.size()) {
                                            myCouponListPageViewModel.tabPageViewModels.get(i3).setShow(false);
                                        }
                                        if (i16 < myCouponListPageViewModel.tabPageViewModels.size()) {
                                            myCouponListPageViewModel.tabPageViewModels.get(i16).setShow(true);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        list = CollectionsKt___CollectionsKt.toList(((MyCouponListPageViewModel) MyCouponListPage.this.viewModel$delegate.getValue()).tabPageViewModels);
                        final MyCouponListPage myCouponListPage5 = MyCouponListPage.this;
                        for (final IMyCouponListViewModel iMyCouponListViewModel : list) {
                            new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.MyCouponListPage$bodyWithTabPage$1$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    MyCouponTabPageView myCouponTabPageView3 = MyCouponTabPageView.this;
                                    final IMyCouponListViewModel iMyCouponListViewModel2 = iMyCouponListViewModel;
                                    Function1<MyCouponTabPageConfig, Unit> function1 = new Function1<MyCouponTabPageConfig, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.MyCouponListPage$bodyWithTabPage$1$3$1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(MyCouponTabPageConfig myCouponTabPageConfig) {
                                            final MyCouponTabPageConfig myCouponTabPageConfig2 = myCouponTabPageConfig;
                                            ReactiveObserver.Companion companion = ReactiveObserver.INSTANCE;
                                            String displayTabTitle = IMyCouponListViewModel.this.getDisplayTabTitle();
                                            final IMyCouponListViewModel iMyCouponListViewModel3 = IMyCouponListViewModel.this;
                                            companion.b(displayTabTitle, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.MyCouponListPage.bodyWithTabPage.1.3.1.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Boolean bool) {
                                                    bool.booleanValue();
                                                    MyCouponTabPageConfig.this.text(iMyCouponListViewModel3.getDisplayTabTitle());
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            myCouponTabPageConfig2.itemTextColor = IMyCouponListViewModel.this.textColor();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    ArrayList<MyCouponTabPageConfig> arrayList = myCouponTabPageView3.pageConfigs;
                                    MyCouponTabPageConfig myCouponTabPageConfig = new MyCouponTabPageConfig();
                                    function1.invoke(myCouponTabPageConfig);
                                    arrayList.add(myCouponTabPageConfig);
                                    MyCouponTabPageView myCouponTabPageView4 = MyCouponTabPageView.this;
                                    final MyCouponListPage myCouponListPage6 = myCouponListPage5;
                                    final IMyCouponListViewModel iMyCouponListViewModel3 = iMyCouponListViewModel;
                                    int i3 = MyCouponListPage.$r8$clinit;
                                    myCouponListPage6.getClass();
                                    myCouponTabPageView4.pageViews.add(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.MyCouponListPage$couponPage$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                            final MyCouponListPage myCouponListPage7 = MyCouponListPage.this;
                                            final IMyCouponListViewModel iMyCouponListViewModel4 = iMyCouponListViewModel3;
                                            viewContainer2.addChild(new MyCouponListView(), new Function1<MyCouponListView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.MyCouponListPage$couponPage$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(MyCouponListView myCouponListView) {
                                                    final MyCouponListPage myCouponListPage8 = MyCouponListPage.this;
                                                    final IMyCouponListViewModel iMyCouponListViewModel5 = iMyCouponListViewModel4;
                                                    myCouponListView.attr(new Function1<MyCouponListViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.MyCouponListPage.couponPage.1.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(MyCouponListViewAttr myCouponListViewAttr) {
                                                            MyCouponListViewAttr myCouponListViewAttr2 = myCouponListViewAttr;
                                                            myCouponListViewAttr2.mo153width(MyCouponListPage.this.getPagerData().m());
                                                            myCouponListViewAttr2.mo141height((MyCouponListPage.this.getPageData().l() - MyCouponListPage.this.getPageData().getNavigationBarHeight()) - 12.0f);
                                                            myCouponListViewAttr2.couponViewModel = iMyCouponListViewModel5;
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
                            }.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        ArrayList<IMyCouponListViewModel> arrayList = ((MyCouponListPageViewModel) this.viewModel$delegate.getValue()).tabPageViewModels;
        if (arrayList != null) {
            Iterator<IMyCouponListViewModel> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().reqFirstPage();
            }
        }
    }
}
