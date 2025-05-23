package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponContanerViewKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemAttr;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemSkeletonViewKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemViewKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundAttr;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundView;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.view.CouponBackgroundViewKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListItemViewModel;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListViewModel;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.MyCouponDataStatus;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MyCouponListView extends ComposeView<MyCouponListViewAttr, MyCouponListViewEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public float oldScrollOffsetY;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ MyCouponListViewAttr access$getAttr(MyCouponListView myCouponListView) {
        return (MyCouponListViewAttr) myCouponListView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$scrollViewDidScroll(MyCouponListView myCouponListView, ScrollParams scrollParams) {
        IMyCouponListViewModel iMyCouponListViewModel;
        myCouponListView.getClass();
        if (scrollParams.getOffsetY() > myCouponListView.oldScrollOffsetY) {
            if ((scrollParams.getContentHeight() - scrollParams.getOffsetY() <= scrollParams.getViewHeight() + 208.0f) && (iMyCouponListViewModel = ((MyCouponListViewAttr) myCouponListView.getAttr()).couponViewModel) != null) {
                iMyCouponListViewModel.reqNextPage();
            }
        }
        myCouponListView.oldScrollOffsetY = scrollParams.getOffsetY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final MyCouponListViewAttr myCouponListViewAttr = (MyCouponListViewAttr) getViewAttr();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final MyCouponListViewAttr myCouponListViewAttr2 = myCouponListViewAttr;
                final MyCouponListView myCouponListView = MyCouponListView.this;
                ar.a(viewContainer, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        final MyCouponListView myCouponListView2 = myCouponListView;
                        final MyCouponListViewAttr myCouponListViewAttr3 = MyCouponListViewAttr.this;
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.body.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                ao aoVar2 = aoVar;
                                aoVar2.mo153width(((MyCouponListViewAttr) MyCouponListView.this.getViewAttr()).width());
                                aoVar2.mo141height(((MyCouponListViewAttr) MyCouponListView.this.getViewAttr()).height());
                                MyCouponListViewAttr myCouponListViewAttr4 = myCouponListViewAttr3;
                                aoVar2.scrollEnable(((Boolean) myCouponListViewAttr4.isNotEmptyCoupon$delegate.getValue(myCouponListViewAttr4, MyCouponListViewAttr.$$delegatedProperties[0])).booleanValue());
                                aoVar2.showScrollerIndicator(false);
                                IMyCouponListViewModel iMyCouponListViewModel = myCouponListViewAttr3.couponViewModel;
                                aoVar2.m152visibility(iMyCouponListViewModel != null ? iMyCouponListViewModel.isShow() : false);
                                return Unit.INSTANCE;
                            }
                        });
                        final MyCouponListView myCouponListView3 = myCouponListView;
                        aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ap apVar) {
                                final MyCouponListView myCouponListView4 = MyCouponListView.this;
                                apVar.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        MyCouponListView.access$scrollViewDidScroll(MyCouponListView.this, scrollParams);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final MyCouponListViewAttr myCouponListViewAttr4 = MyCouponListViewAttr.this;
                        final IMyCouponListViewModel iMyCouponListViewModel = myCouponListViewAttr4.couponViewModel;
                        if (iMyCouponListViewModel != null) {
                            final MyCouponListView myCouponListView4 = myCouponListView;
                            LoopDirectivesViewKt.a(aqVar2, new Function0<c<IMyCouponListItemViewModel>>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$body$1$1$3$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final c<IMyCouponListItemViewModel> invoke() {
                                    return IMyCouponListViewModel.this.getList();
                                }
                            }, new Function2<LoopDirectivesView<IMyCouponListItemViewModel>, IMyCouponListItemViewModel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$body$1$1$3$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Unit invoke(LoopDirectivesView<IMyCouponListItemViewModel> loopDirectivesView, IMyCouponListItemViewModel iMyCouponListItemViewModel) {
                                    LoopDirectivesView<IMyCouponListItemViewModel> loopDirectivesView2 = loopDirectivesView;
                                    final IMyCouponListItemViewModel iMyCouponListItemViewModel2 = iMyCouponListItemViewModel;
                                    if (iMyCouponListItemViewModel2.isInvalidSkeleton()) {
                                        MyCouponListView myCouponListView5 = MyCouponListView.this;
                                        int i3 = MyCouponListView.$r8$clinit;
                                        myCouponListView5.getClass();
                                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$bodyWithItemSkeleton$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                                final IMyCouponListItemViewModel iMyCouponListItemViewModel3 = IMyCouponListItemViewModel.this;
                                                CommonCouponContanerViewKt.CommonCouponContainerView(viewContainer2, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$bodyWithItemSkeleton$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                        ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                                        viewContainer4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemSkeleton.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(m mVar) {
                                                                m mVar2 = mVar;
                                                                mVar2.marginLeft(16.0f);
                                                                mVar2.marginRight(16.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final IMyCouponListItemViewModel iMyCouponListItemViewModel4 = IMyCouponListItemViewModel.this;
                                                        CouponBackgroundViewKt.CouponBackground(viewContainer4, new Function1<CouponBackgroundView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemSkeleton.1.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(CouponBackgroundView couponBackgroundView) {
                                                                final IMyCouponListItemViewModel iMyCouponListItemViewModel5 = IMyCouponListItemViewModel.this;
                                                                couponBackgroundView.attr(new Function1<CouponBackgroundAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemSkeleton.1.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(CouponBackgroundAttr couponBackgroundAttr) {
                                                                        CouponBackgroundAttr couponBackgroundAttr2 = couponBackgroundAttr;
                                                                        couponBackgroundAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                                                        couponBackgroundAttr2.rightAreaWidth = 84.0f;
                                                                        couponBackgroundAttr2.setShowStyleDisable(!IMyCouponListItemViewModel.this.isCanUseCoupon());
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        CommonCouponItemSkeletonViewKt.CommonCouponItemSkeleton(viewContainer4);
                                                        w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemSkeleton.1.1.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar) {
                                                                v vVar2 = vVar;
                                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemSkeleton.1.1.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.mo153width(84.0f);
                                                                        tVar2.allCenter();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemSkeleton.1.1.3.2
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar3) {
                                                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemSkeleton.1.1.3.2.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.size(56.0f, 16.0f);
                                                                                tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getDividerColor());
                                                                                tVar2.borderRadius(2.0f);
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
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        }.invoke(loopDirectivesView2);
                                    } else {
                                        MyCouponListViewAttr myCouponListViewAttr5 = myCouponListViewAttr4;
                                        myCouponListViewAttr5.isNotEmptyCoupon$delegate.setValue(myCouponListViewAttr5, MyCouponListViewAttr.$$delegatedProperties[0], Boolean.valueOf(!iMyCouponListViewModel.getList().isEmpty()));
                                        MyCouponListView myCouponListView6 = MyCouponListView.this;
                                        int i16 = MyCouponListView.$r8$clinit;
                                        myCouponListView6.getClass();
                                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$bodyWithItemView$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                                final IMyCouponListItemViewModel iMyCouponListItemViewModel3 = IMyCouponListItemViewModel.this;
                                                CommonCouponContanerViewKt.CommonCouponContainerView(viewContainer2, new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$bodyWithItemView$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                        ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                                        viewContainer4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemView.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(m mVar) {
                                                                m mVar2 = mVar;
                                                                mVar2.marginLeft(16.0f);
                                                                mVar2.marginRight(16.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final IMyCouponListItemViewModel iMyCouponListItemViewModel4 = IMyCouponListItemViewModel.this;
                                                        CouponBackgroundViewKt.CouponBackground(viewContainer4, new Function1<CouponBackgroundView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemView.1.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(CouponBackgroundView couponBackgroundView) {
                                                                final IMyCouponListItemViewModel iMyCouponListItemViewModel5 = IMyCouponListItemViewModel.this;
                                                                couponBackgroundView.attr(new Function1<CouponBackgroundAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemView.1.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(CouponBackgroundAttr couponBackgroundAttr) {
                                                                        CouponBackgroundAttr couponBackgroundAttr2 = couponBackgroundAttr;
                                                                        couponBackgroundAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                                                        couponBackgroundAttr2.rightAreaWidth = 84.0f;
                                                                        couponBackgroundAttr2.setShowStyleDisable(!IMyCouponListItemViewModel.this.isCanUseCoupon());
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final IMyCouponListItemViewModel iMyCouponListItemViewModel5 = IMyCouponListItemViewModel.this;
                                                        CommonCouponItemViewKt.CommonCouponItemView(viewContainer4, new Function1<CommonCouponItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemView.1.1.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(CommonCouponItemView commonCouponItemView) {
                                                                final IMyCouponListItemViewModel iMyCouponListItemViewModel6 = IMyCouponListItemViewModel.this;
                                                                commonCouponItemView.attr(new Function1<CommonCouponItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemView.1.1.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(CommonCouponItemAttr commonCouponItemAttr) {
                                                                        commonCouponItemAttr.commonCouponItem = IMyCouponListItemViewModel.this.couponItemModel();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final IMyCouponListItemViewModel iMyCouponListItemViewModel6 = IMyCouponListItemViewModel.this;
                                                        w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemView.1.1.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar) {
                                                                v vVar2 = vVar;
                                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemView.1.1.4.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.mo153width(84.0f);
                                                                        tVar2.allCenter();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final IMyCouponListItemViewModel iMyCouponListItemViewModel7 = IMyCouponListItemViewModel.this;
                                                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemView.1.1.4.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(u uVar) {
                                                                        final IMyCouponListItemViewModel iMyCouponListItemViewModel8 = IMyCouponListItemViewModel.this;
                                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemView.1.1.4.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                IMyCouponListItemViewModel.this.clickItem();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final IMyCouponListItemViewModel iMyCouponListItemViewModel8 = IMyCouponListItemViewModel.this;
                                                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemView.1.1.4.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final IMyCouponListItemViewModel iMyCouponListItemViewModel9 = IMyCouponListItemViewModel.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithItemView.1.1.4.3.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                h hVar;
                                                                                ce ceVar2 = ceVar;
                                                                                ce.fontSize$default(ceVar2, 13.0f, null, 2, null).fontWeightBold();
                                                                                ceVar2.value(IMyCouponListItemViewModel.this.itemText());
                                                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor(IMyCouponListItemViewModel.this.itemTextToken(), false);
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
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        }.invoke(loopDirectivesView2);
                                    }
                                    return Unit.INSTANCE;
                                }
                            });
                            aqVar2.addChild(new MyCouponFootLoadingCell(), new Function1<MyCouponFootLoadingCell, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$body$1$1$3$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(MyCouponFootLoadingCell myCouponFootLoadingCell) {
                                    final MyCouponListView myCouponListView5 = MyCouponListView.this;
                                    final IMyCouponListViewModel iMyCouponListViewModel2 = iMyCouponListViewModel;
                                    myCouponFootLoadingCell.attr(new Function1<MyCouponFootLoadingCellAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$body$1$1$3$3.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        /* JADX WARN: Multi-variable type inference failed */
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(MyCouponFootLoadingCellAttr myCouponFootLoadingCellAttr) {
                                            MyCouponFootLoadingCellAttr myCouponFootLoadingCellAttr2 = myCouponFootLoadingCellAttr;
                                            myCouponFootLoadingCellAttr2.mo153width(((MyCouponListViewAttr) MyCouponListView.this.getViewAttr()).width());
                                            myCouponFootLoadingCellAttr2.mo141height(iMyCouponListViewModel2.isShowLoadMore() ? 40.0f : 0.0f);
                                            myCouponFootLoadingCellAttr2.m152visibility(iMyCouponListViewModel2.isShowLoadMore());
                                            myCouponFootLoadingCellAttr2.isLoadFinishing$delegate.setValue(myCouponFootLoadingCellAttr2, MyCouponFootLoadingCellAttr.$$delegatedProperties[0], Boolean.valueOf(iMyCouponListViewModel2.isLoadFinishing()));
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
                final MyCouponListView myCouponListView2 = MyCouponListView.this;
                myCouponListView2.getClass();
                w.a(myCouponListView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$bodyWithNoDataView$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final MyCouponListView myCouponListView3 = MyCouponListView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$bodyWithNoDataView$1.1
                            {
                                super(1);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                tVar2.mo153width(((MyCouponListViewAttr) MyCouponListView.this.getViewAttr()).width());
                                tVar2.mo141height(((MyCouponListViewAttr) MyCouponListView.this.getViewAttr()).height());
                                tVar2.allCenter().flexDirectionColumn();
                                tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getForegroundColor());
                                IMyCouponListViewModel iMyCouponListViewModel = MyCouponListView.access$getAttr(MyCouponListView.this).couponViewModel;
                                tVar2.m152visibility((iMyCouponListViewModel != null ? iMyCouponListViewModel.getCouponDataStatus() : null) == MyCouponDataStatus.NO_DATA);
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$bodyWithNoDataView$1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithNoDataView.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.marginTop(-128.0f);
                                        afVar2.size(256.0f, 192.0f);
                                        if (afVar2.getPager().getPageData().n().f(MiniGamePAHippyBaseFragment.KEY_THEME)) {
                                            b.a.b(afVar2, "https://qq-ecommerce.cdn-go.cn/iOS/latest/darkmode/emptystate/qecommerce_skin_emptystate_img_wenjian.png", false, 2, null);
                                        } else {
                                            b.a.b(afVar2, "https://qq-ecommerce.cdn-go.cn/iOS/latest/defaultmode/emptystate/qecommerce_skin_emptystate_img_wenjian.png", false, 2, null);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$bodyWithNoDataView$1.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithNoDataView.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h hVar;
                                        ce ceVar2 = ceVar;
                                        ceVar2.value("\u6682\u65e0\u4f18\u60e0\u5238");
                                        ceVar2.marginTop(24.0f);
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null).fontWeight400();
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
                final MyCouponListView myCouponListView3 = MyCouponListView.this;
                myCouponListView3.getClass();
                w.a(myCouponListView3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$bodyWithDataFailureView$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final MyCouponListView myCouponListView4 = MyCouponListView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$bodyWithDataFailureView$1.1
                            {
                                super(1);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                tVar2.mo153width(((MyCouponListViewAttr) MyCouponListView.this.getViewAttr()).width());
                                tVar2.mo141height(((MyCouponListViewAttr) MyCouponListView.this.getViewAttr()).height());
                                tVar2.allCenter().flexDirectionColumn();
                                tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getForegroundColor());
                                IMyCouponListViewModel iMyCouponListViewModel = MyCouponListView.access$getAttr(MyCouponListView.this).couponViewModel;
                                tVar2.m152visibility((iMyCouponListViewModel != null ? iMyCouponListViewModel.getCouponDataStatus() : null) == MyCouponDataStatus.FAILURE);
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$bodyWithDataFailureView$1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithDataFailureView.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.marginTop(-64.0f);
                                        afVar2.size(256.0f, 192.0f);
                                        if (afVar2.getPager().getPageData().n().f(MiniGamePAHippyBaseFragment.KEY_THEME)) {
                                            b.a.b(afVar2, "https://qq-ecommerce.cdn-go.cn/url/latest/darkmode/emptystate/qecommerce_skin_emptystate_img_wuwangluo.png", false, 2, null);
                                        } else {
                                            b.a.b(afVar2, "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/emptystate/qecommerce_skin_emptystate_img_wuwangluo.png", false, 2, null);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView$bodyWithDataFailureView$1.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponListView.bodyWithDataFailureView.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h hVar;
                                        ce ceVar2 = ceVar;
                                        ceVar2.value("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                                        ceVar2.marginTop(24.0f);
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null).fontWeight400();
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new MyCouponListViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new MyCouponListViewEvent();
    }
}
