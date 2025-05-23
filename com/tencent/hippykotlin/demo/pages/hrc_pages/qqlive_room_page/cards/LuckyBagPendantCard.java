package com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.view.hrc.HRCComposeAttr;
import com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardCompose;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendantAttr;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendantEvent;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPPageModel;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPPendantListItem;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPPlayDetail;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendantAttr;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendantEvent;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponRspModel;
import com.tencent.kuikly.core.base.Attr;
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
public final class LuckyBagPendantCard extends HippyRenderCardCompose<HRCComposeAttr> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Lazy pageModel$delegate;

    public LuckyBagPendantCard() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LBPPageModel>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard$pageModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final LBPPageModel invoke() {
                LBPPageModel lBPPageModel = new LBPPageModel(LuckyBagPendantCard.this.getPagerId());
                lBPPageModel.roomId = LuckyBagPendantCard.access$getAttr(LuckyBagPendantCard.this).getHRCData().n(AudienceReportConst.ROOM_ID);
                lBPPageModel.isAnchor = LuckyBagPendantCard.access$getAttr(LuckyBagPendantCard.this).getHRCData().n("is_master") > 0;
                return lBPPageModel;
            }
        });
        this.pageModel$delegate = lazy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ HRCComposeAttr access$getAttr(LuckyBagPendantCard luckyBagPendantCard) {
        return (HRCComposeAttr) luckyBagPendantCard.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final LuckyBagPendantCard luckyBagPendantCard = LuckyBagPendantCard.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width((float) LuckyBagPendantCard.access$getAttr(LuckyBagPendantCard.this).getHRCData().h("view_width"));
                        mVar2.mo141height((float) LuckyBagPendantCard.access$getAttr(LuckyBagPendantCard.this).getHRCData().h("view_height"));
                        return Unit.INSTANCE;
                    }
                });
                final LuckyBagPendantCard luckyBagPendantCard2 = LuckyBagPendantCard.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginTop(8.0f);
                                tVar2.marginLeft(8.0f);
                                tVar2.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final LuckyBagPendantCard luckyBagPendantCard3 = LuckyBagPendantCard.this;
                        Function0<c<LBPPendantListItem>> function0 = new Function0<c<LBPPendantListItem>>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final c<LBPPendantListItem> invoke() {
                                LuckyBagPendantCard luckyBagPendantCard4 = LuckyBagPendantCard.this;
                                int i3 = LuckyBagPendantCard.$r8$clinit;
                                return luckyBagPendantCard4.getPageModel().getPendantList();
                            }
                        };
                        final LuckyBagPendantCard luckyBagPendantCard4 = LuckyBagPendantCard.this;
                        LoopDirectivesViewKt.a(vVar2, function0, new Function2<LoopDirectivesView<LBPPendantListItem>, LBPPendantListItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.3
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<LBPPendantListItem> loopDirectivesView, LBPPendantListItem lBPPendantListItem) {
                                final LBPPendantListItem lBPPendantListItem2 = lBPPendantListItem;
                                final LuckyBagPendantCard luckyBagPendantCard5 = LuckyBagPendantCard.this;
                                w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final LBPPendantListItem lBPPendantListItem3 = LBPPendantListItem.this;
                                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.3.1.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Boolean.valueOf(LBPPendantListItem.this.getShowPendant() && LBPPendantListItem.this.type != 3);
                                            }
                                        };
                                        final LuckyBagPendantCard luckyBagPendantCard6 = luckyBagPendantCard5;
                                        final LBPPendantListItem lBPPendantListItem4 = LBPPendantListItem.this;
                                        ConditionViewKt.c(vVar4, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.3.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView) {
                                                final LuckyBagPendantCard luckyBagPendantCard7 = LuckyBagPendantCard.this;
                                                final LBPPendantListItem lBPPendantListItem5 = lBPPendantListItem4;
                                                conditionView.addChild(new LBPLuckyBagPendant(), new Function1<LBPLuckyBagPendant, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.3.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(LBPLuckyBagPendant lBPLuckyBagPendant) {
                                                        LBPLuckyBagPendant lBPLuckyBagPendant2 = lBPLuckyBagPendant;
                                                        final LuckyBagPendantCard luckyBagPendantCard8 = LuckyBagPendantCard.this;
                                                        final LBPPendantListItem lBPPendantListItem6 = lBPPendantListItem5;
                                                        lBPLuckyBagPendant2.attr(new Function1<LBPLuckyBagPendantAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.3.1.2.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(LBPLuckyBagPendantAttr lBPLuckyBagPendantAttr) {
                                                                LBPLuckyBagPendantAttr lBPLuckyBagPendantAttr2 = lBPLuckyBagPendantAttr;
                                                                lBPLuckyBagPendantAttr2.size(40.0f, 40.0f);
                                                                LuckyBagPendantCard luckyBagPendantCard9 = LuckyBagPendantCard.this;
                                                                int i3 = LuckyBagPendantCard.$r8$clinit;
                                                                lBPLuckyBagPendantAttr2.marginLeft(luckyBagPendantCard9.getPager().getPageData().getIsIOS() ? 9.0f : 7.0f);
                                                                LBPPendantListItem lBPPendantListItem7 = lBPPendantListItem6;
                                                                lBPLuckyBagPendantAttr2.localTimeDiffServe = lBPPendantListItem7.localTimeDiffServe;
                                                                LBPPlayDetail detail = lBPPendantListItem7.getDetail();
                                                                Intrinsics.checkNotNull(detail);
                                                                lBPLuckyBagPendantAttr2.updateLuckyBagData(detail);
                                                                lBPLuckyBagPendantAttr2.isHRC$delegate.setValue(lBPLuckyBagPendantAttr2, LBPLuckyBagPendantAttr.$$delegatedProperties[6], 1);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final LuckyBagPendantCard luckyBagPendantCard9 = LuckyBagPendantCard.this;
                                                        lBPLuckyBagPendant2.event(new Function1<LBPLuckyBagPendantEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.3.1.2.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(LBPLuckyBagPendantEvent lBPLuckyBagPendantEvent) {
                                                                final LuckyBagPendantCard luckyBagPendantCard10 = LuckyBagPendantCard.this;
                                                                lBPLuckyBagPendantEvent.registerEvent("newPendantDidShow", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.3.1.2.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        LuckyBagPendantCard luckyBagPendantCard11 = LuckyBagPendantCard.this;
                                                                        int i3 = LuckyBagPendantCard.$r8$clinit;
                                                                        luckyBagPendantCard11.getPageModel().showNextPendantIfNeed();
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
                                        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.3.1.3
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Boolean.valueOf(LBPPendantListItem.this.getShowPendant() && LBPPendantListItem.this.type == 3);
                                            }
                                        };
                                        final LBPPendantListItem lBPPendantListItem6 = LBPPendantListItem.this;
                                        final LuckyBagPendantCard luckyBagPendantCard7 = luckyBagPendantCard5;
                                        ConditionViewKt.b(vVar4, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.3.1.4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView) {
                                                final LBPPendantListItem lBPPendantListItem7 = LBPPendantListItem.this;
                                                final LuckyBagPendantCard luckyBagPendantCard8 = luckyBagPendantCard7;
                                                conditionView.addChild(new LiveCouponPendant(), new Function1<LiveCouponPendant, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.3.1.4.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(LiveCouponPendant liveCouponPendant) {
                                                        LiveCouponPendant liveCouponPendant2 = liveCouponPendant;
                                                        final LBPPendantListItem lBPPendantListItem8 = LBPPendantListItem.this;
                                                        final LuckyBagPendantCard luckyBagPendantCard9 = luckyBagPendantCard8;
                                                        liveCouponPendant2.attr(new Function1<LiveCouponPendantAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.3.1.4.1.1
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
                                                                LuckyBagPendantCard luckyBagPendantCard10 = luckyBagPendantCard9;
                                                                int i3 = LuckyBagPendantCard.$r8$clinit;
                                                                liveCouponPendantAttr2.isAnchor$delegate.setValue(liveCouponPendantAttr2, kPropertyArr[3], Boolean.valueOf(luckyBagPendantCard10.getPageModel().isAnchor));
                                                                liveCouponPendantAttr2.roomID$delegate.setValue(liveCouponPendantAttr2, kPropertyArr[4], Long.valueOf(luckyBagPendantCard9.getPageModel().roomId));
                                                                liveCouponPendantAttr2.isHRC$delegate.setValue(liveCouponPendantAttr2, kPropertyArr[8], 1);
                                                                liveCouponPendantAttr2.updateCouponData(LBPPendantListItem.this.getCouponInfo());
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final LuckyBagPendantCard luckyBagPendantCard10 = luckyBagPendantCard8;
                                                        liveCouponPendant2.event(new Function1<LiveCouponPendantEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.3.1.4.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(LiveCouponPendantEvent liveCouponPendantEvent) {
                                                                final LuckyBagPendantCard luckyBagPendantCard11 = LuckyBagPendantCard.this;
                                                                liveCouponPendantEvent.registerEvent("pendantDidShow", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.3.1.4.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        LuckyBagPendantCard luckyBagPendantCard12 = LuckyBagPendantCard.this;
                                                                        int i3 = LuckyBagPendantCard.$r8$clinit;
                                                                        luckyBagPendantCard12.getPageModel().showNextPendantIfNeed();
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
                                        TimerKt.e(pagerId, BusinessInfoCheckUpdateItem.UIAPPID_PLUS_LEBA_SETTING_ENTRY, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.qqlive_room_page.cards.LuckyBagPendantCard.body.1.2.3.1.5
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

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new HRCComposeAttr();
    }

    public final LBPPageModel getPageModel() {
        return (LBPPageModel) this.pageModel$delegate.getValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardCompose
    public final void onReceiveCustomEvent(String str, e eVar) {
        if (Intrinsics.areEqual(str, "onPendantChanged")) {
            Utils.INSTANCE.bridgeModule(getPagerId()).log("KTVLivePendantCard did receive onPendantChanged");
            getPageModel().requestData(true, eVar, new LuckyBagPendantCard$updateData$1(this, true, eVar));
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        getPageModel().preDownloadResource();
        getPageModel().requestData(false, null, new LuckyBagPendantCard$updateData$1(this, false, null));
    }
}
