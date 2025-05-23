package com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendantAttr;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendantEvent;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponRspModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class LuckyBagPendantPage extends BasePager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Lazy pageModel$delegate;

    public LuckyBagPendantPage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LBPPageModel>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage$pageModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final LBPPageModel invoke() {
                LBPPageModel lBPPageModel = new LBPPageModel(LuckyBagPendantPage.this.getPagerId());
                lBPPageModel.roomId = LuckyBagPendantPage.this.getPageData().n().n(AudienceReportConst.ROOM_ID);
                lBPPageModel.isAnchor = LuckyBagPendantPage.this.getPageData().n().n("is_master") > 0;
                return lBPPageModel;
            }
        });
        this.pageModel$delegate = lazy;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(m mVar) {
                        return Unit.INSTANCE;
                    }
                });
                final LuckyBagPendantPage luckyBagPendantPage = LuckyBagPendantPage.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginTop(8.0f);
                                tVar2.marginLeft(8.0f);
                                tVar2.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final LuckyBagPendantPage luckyBagPendantPage2 = LuckyBagPendantPage.this;
                        Function0<c<LBPPendantListItem>> function0 = new Function0<c<LBPPendantListItem>>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final c<LBPPendantListItem> invoke() {
                                LuckyBagPendantPage luckyBagPendantPage3 = LuckyBagPendantPage.this;
                                int i3 = LuckyBagPendantPage.$r8$clinit;
                                return luckyBagPendantPage3.getPageModel().getPendantList();
                            }
                        };
                        final LuckyBagPendantPage luckyBagPendantPage3 = LuckyBagPendantPage.this;
                        LoopDirectivesViewKt.a(vVar2, function0, new Function2<LoopDirectivesView<LBPPendantListItem>, LBPPendantListItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.3
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<LBPPendantListItem> loopDirectivesView, LBPPendantListItem lBPPendantListItem) {
                                final LBPPendantListItem lBPPendantListItem2 = lBPPendantListItem;
                                final LuckyBagPendantPage luckyBagPendantPage4 = LuckyBagPendantPage.this;
                                w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final LBPPendantListItem lBPPendantListItem3 = LBPPendantListItem.this;
                                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.3.1.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Boolean.valueOf(LBPPendantListItem.this.getShowPendant() && LBPPendantListItem.this.type != 3);
                                            }
                                        };
                                        final LuckyBagPendantPage luckyBagPendantPage5 = luckyBagPendantPage4;
                                        final LBPPendantListItem lBPPendantListItem4 = LBPPendantListItem.this;
                                        ConditionViewKt.c(vVar4, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.3.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView) {
                                                final LuckyBagPendantPage luckyBagPendantPage6 = LuckyBagPendantPage.this;
                                                final LBPPendantListItem lBPPendantListItem5 = lBPPendantListItem4;
                                                conditionView.addChild(new LBPLuckyBagPendant(), new Function1<LBPLuckyBagPendant, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.3.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(LBPLuckyBagPendant lBPLuckyBagPendant) {
                                                        LBPLuckyBagPendant lBPLuckyBagPendant2 = lBPLuckyBagPendant;
                                                        final LuckyBagPendantPage luckyBagPendantPage7 = LuckyBagPendantPage.this;
                                                        final LBPPendantListItem lBPPendantListItem6 = lBPPendantListItem5;
                                                        lBPLuckyBagPendant2.attr(new Function1<LBPLuckyBagPendantAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.3.1.2.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(LBPLuckyBagPendantAttr lBPLuckyBagPendantAttr) {
                                                                LBPLuckyBagPendantAttr lBPLuckyBagPendantAttr2 = lBPLuckyBagPendantAttr;
                                                                lBPLuckyBagPendantAttr2.size(40.0f, 40.0f);
                                                                LuckyBagPendantPage luckyBagPendantPage8 = LuckyBagPendantPage.this;
                                                                int i3 = LuckyBagPendantPage.$r8$clinit;
                                                                lBPLuckyBagPendantAttr2.marginLeft(luckyBagPendantPage8.getPageData().getIsIOS() ? 9.0f : 7.0f);
                                                                LBPPendantListItem lBPPendantListItem7 = lBPPendantListItem6;
                                                                lBPLuckyBagPendantAttr2.localTimeDiffServe = lBPPendantListItem7.localTimeDiffServe;
                                                                LBPPlayDetail detail = lBPPendantListItem7.getDetail();
                                                                Intrinsics.checkNotNull(detail);
                                                                lBPLuckyBagPendantAttr2.updateLuckyBagData(detail);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final LuckyBagPendantPage luckyBagPendantPage8 = LuckyBagPendantPage.this;
                                                        lBPLuckyBagPendant2.event(new Function1<LBPLuckyBagPendantEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.3.1.2.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(LBPLuckyBagPendantEvent lBPLuckyBagPendantEvent) {
                                                                final LuckyBagPendantPage luckyBagPendantPage9 = LuckyBagPendantPage.this;
                                                                lBPLuckyBagPendantEvent.registerEvent("newPendantDidShow", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.3.1.2.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        LuckyBagPendantPage luckyBagPendantPage10 = LuckyBagPendantPage.this;
                                                                        int i3 = LuckyBagPendantPage.$r8$clinit;
                                                                        luckyBagPendantPage10.getPageModel().showNextPendantIfNeed();
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
                                        final LBPPendantListItem lBPPendantListItem5 = LBPPendantListItem.this;
                                        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.3.1.3
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Boolean.valueOf(LBPPendantListItem.this.getShowPendant() && LBPPendantListItem.this.type == 3);
                                            }
                                        };
                                        final LBPPendantListItem lBPPendantListItem6 = LBPPendantListItem.this;
                                        final LuckyBagPendantPage luckyBagPendantPage6 = luckyBagPendantPage4;
                                        ConditionViewKt.b(vVar4, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.3.1.4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView) {
                                                final LBPPendantListItem lBPPendantListItem7 = LBPPendantListItem.this;
                                                final LuckyBagPendantPage luckyBagPendantPage7 = luckyBagPendantPage6;
                                                conditionView.addChild(new LiveCouponPendant(), new Function1<LiveCouponPendant, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.3.1.4.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(LiveCouponPendant liveCouponPendant) {
                                                        LiveCouponPendant liveCouponPendant2 = liveCouponPendant;
                                                        final LBPPendantListItem lBPPendantListItem8 = LBPPendantListItem.this;
                                                        final LuckyBagPendantPage luckyBagPendantPage8 = luckyBagPendantPage7;
                                                        liveCouponPendant2.attr(new Function1<LiveCouponPendantAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.3.1.4.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(LiveCouponPendantAttr liveCouponPendantAttr) {
                                                                LiveCouponPendantAttr liveCouponPendantAttr2 = liveCouponPendantAttr;
                                                                LiveCouponRspModel couponInfo = LBPPendantListItem.this.getCouponInfo();
                                                                ReadWriteProperty readWriteProperty = liveCouponPendantAttr2.couponInfo$delegate;
                                                                KProperty<?>[] kPropertyArr = LiveCouponPendantAttr.$$delegatedProperties;
                                                                readWriteProperty.setValue(liveCouponPendantAttr2, kPropertyArr[5], couponInfo);
                                                                LuckyBagPendantPage luckyBagPendantPage9 = luckyBagPendantPage8;
                                                                int i3 = LuckyBagPendantPage.$r8$clinit;
                                                                liveCouponPendantAttr2.isAnchor$delegate.setValue(liveCouponPendantAttr2, kPropertyArr[3], Boolean.valueOf(luckyBagPendantPage9.getPageModel().isAnchor));
                                                                liveCouponPendantAttr2.roomID$delegate.setValue(liveCouponPendantAttr2, kPropertyArr[4], Long.valueOf(luckyBagPendantPage8.getPageModel().roomId));
                                                                liveCouponPendantAttr2.updateCouponData(LBPPendantListItem.this.getCouponInfo());
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final LuckyBagPendantPage luckyBagPendantPage9 = luckyBagPendantPage7;
                                                        liveCouponPendant2.event(new Function1<LiveCouponPendantEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.3.1.4.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(LiveCouponPendantEvent liveCouponPendantEvent) {
                                                                final LuckyBagPendantPage luckyBagPendantPage10 = LuckyBagPendantPage.this;
                                                                liveCouponPendantEvent.registerEvent("pendantDidShow", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.3.1.4.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        LuckyBagPendantPage luckyBagPendantPage11 = LuckyBagPendantPage.this;
                                                                        int i3 = LuckyBagPendantPage.$r8$clinit;
                                                                        luckyBagPendantPage11.getPageModel().showNextPendantIfNeed();
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
                                        String pagerId = vVar4.getPagerId();
                                        final LBPPendantListItem lBPPendantListItem7 = LBPPendantListItem.this;
                                        TimerKt.e(pagerId, BusinessInfoCheckUpdateItem.UIAPPID_PLUS_LEBA_SETTING_ENTRY, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LuckyBagPendantPage.body.1.2.3.1.5
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                if (!LBPPendantListItem.this.getShowPendant()) {
                                                    LBPPendantListItem.this.setShowPendant();
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
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    public final LBPPageModel getPageModel() {
        return (LBPPageModel) this.pageModel$delegate.getValue();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onPendantChanged")) {
            Utils.INSTANCE.bridgeModule(getPagerId()).log("did receive onPendantChanged");
            getPageModel().requestData(true, eVar, new LuckyBagPendantPage$updateData$1(this, true, eVar));
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        getPageModel().preDownloadResource();
        Utils utils = Utils.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("auto_open_luckybag ");
        m3.append(getPagerData().n().j("auto_open_luckybag"));
        utils.logToNative(m3.toString());
        getPageModel().requestData(false, null, new LuckyBagPendantPage$updateData$1(this, false, null));
    }
}
