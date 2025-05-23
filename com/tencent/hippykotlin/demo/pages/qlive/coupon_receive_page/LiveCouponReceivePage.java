package com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionEvent;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$3;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceiveViewModel;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.SCPUtilsKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponReqItem;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponRetItem;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponDeviceInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponGetCouponRsp;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponUserCouponUse;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes31.dex */
public final class LiveCouponReceivePage extends BasePager implements c {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveCouponReceivePage.class, "resultDlgAppear", "getResultDlgAppear()Z", 0)};
    public final ReadWriteProperty resultDlgAppear$delegate = c01.c.a(Boolean.TRUE);
    public LiveCouponReceiveViewModel viewModel;

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final LiveCouponReceivePage liveCouponReceivePage = LiveCouponReceivePage.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage$body$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        LiveCouponReceiveViewModel liveCouponReceiveViewModel = LiveCouponReceivePage.this.viewModel;
                        if (liveCouponReceiveViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            liveCouponReceiveViewModel = null;
                        }
                        return liveCouponReceiveViewModel.getCouponReceiveState();
                    }
                };
                final LiveCouponReceivePage liveCouponReceivePage2 = LiveCouponReceivePage.this;
                BindDirectivesViewKt.a(viewContainer, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                        Utils utils = Utils.INSTANCE;
                        String pagerId = bindDirectivesView2.getPagerId();
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("LiveCouponReceivePage body() ");
                        LiveCouponReceiveViewModel liveCouponReceiveViewModel = LiveCouponReceivePage.this.viewModel;
                        LiveCouponReceiveViewModel liveCouponReceiveViewModel2 = null;
                        if (liveCouponReceiveViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            liveCouponReceiveViewModel = null;
                        }
                        m3.append(liveCouponReceiveViewModel.getCouponReceiveState());
                        m3.append(TokenParser.SP);
                        utils.bridgeModule(pagerId).log(m3.toString());
                        LiveCouponReceiveViewModel liveCouponReceiveViewModel3 = LiveCouponReceivePage.this.viewModel;
                        if (liveCouponReceiveViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            liveCouponReceiveViewModel3 = null;
                        }
                        LiveCouponReceiveViewModel.CouponReceiveState couponReceiveState = liveCouponReceiveViewModel3.getCouponReceiveState();
                        if (couponReceiveState instanceof LiveCouponReceiveViewModel.CouponReceiveState.Loading) {
                            w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                            tVar2.allCenter();
                                            tVar2.mo113backgroundColor(h.INSTANCE.j());
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    ECLoadingViewKt.ECLoading(vVar2, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.1.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ECLoadingView eCLoadingView) {
                                            eCLoadingView.attr(new Function1<ECLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.1.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ECLoadingAttr eCLoadingAttr) {
                                                    ECLoadingAttr eCLoadingAttr2 = eCLoadingAttr;
                                                    eCLoadingAttr2.setLoadingText("\u9886\u53d6\u4e2d");
                                                    eCLoadingAttr2.delayShow = true;
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else if (couponReceiveState instanceof LiveCouponReceiveViewModel.CouponReceiveState.ClosePageWithEventAndMsg) {
                            BridgeModule bridgeModule = utils.bridgeModule(bindDirectivesView2.getPagerId());
                            LiveCouponReceiveViewModel liveCouponReceiveViewModel4 = LiveCouponReceivePage.this.viewModel;
                            if (liveCouponReceiveViewModel4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                liveCouponReceiveViewModel4 = null;
                            }
                            LiveCouponReceiveViewModel.CouponReceiveState couponReceiveState2 = liveCouponReceiveViewModel4.getCouponReceiveState();
                            Intrinsics.checkNotNull(couponReceiveState2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceiveViewModel.CouponReceiveState.ClosePageWithEventAndMsg");
                            bridgeModule.toast(((LiveCouponReceiveViewModel.CouponReceiveState.ClosePageWithEventAndMsg) couponReceiveState2).f114247msg);
                            k kVar = (k) LiveCouponReceivePage.this.getModule("KRNotifyModule");
                            if (kVar != null) {
                                e eVar = new e();
                                LiveCouponReceivePage liveCouponReceivePage3 = LiveCouponReceivePage.this;
                                LiveCouponReceiveViewModel liveCouponReceiveViewModel5 = liveCouponReceivePage3.viewModel;
                                if (liveCouponReceiveViewModel5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    liveCouponReceiveViewModel5 = null;
                                }
                                LiveCouponReceiveViewModel.CouponReceiveState couponReceiveState3 = liveCouponReceiveViewModel5.getCouponReceiveState();
                                Intrinsics.checkNotNull(couponReceiveState3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceiveViewModel.CouponReceiveState.ClosePageWithEventAndMsg");
                                eVar.t("coupon_num", ((LiveCouponReceiveViewModel.CouponReceiveState.ClosePageWithEventAndMsg) couponReceiveState3).couponsNum);
                                eVar.u("roomID", PageDataExtKt.getUserData(liveCouponReceivePage3.getPager().getPageData()).n("roomID"));
                                Unit unit = Unit.INSTANCE;
                                kVar.c("CouponReceiveSuccess", eVar, true);
                            }
                            BridgeModule.closePage$default(IPagerIdKtxKt.getBridgeModule(LiveCouponReceivePage.this), null, null, 3);
                        } else if (couponReceiveState instanceof LiveCouponReceiveViewModel.CouponReceiveState.ClosePageWithMsg) {
                            BridgeModule bridgeModule2 = utils.bridgeModule(bindDirectivesView2.getPagerId());
                            LiveCouponReceiveViewModel liveCouponReceiveViewModel6 = LiveCouponReceivePage.this.viewModel;
                            if (liveCouponReceiveViewModel6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                liveCouponReceiveViewModel6 = null;
                            }
                            LiveCouponReceiveViewModel.CouponReceiveState couponReceiveState4 = liveCouponReceiveViewModel6.getCouponReceiveState();
                            Intrinsics.checkNotNull(couponReceiveState4, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceiveViewModel.CouponReceiveState.ClosePageWithMsg");
                            bridgeModule2.toast(((LiveCouponReceiveViewModel.CouponReceiveState.ClosePageWithMsg) couponReceiveState4).f114248msg);
                            BridgeModule.closePage$default(IPagerIdKtxKt.getBridgeModule(LiveCouponReceivePage.this), null, null, 3);
                        } else if (couponReceiveState instanceof LiveCouponReceiveViewModel.CouponReceiveState.Success) {
                            final LiveCouponReceivePage liveCouponReceivePage4 = LiveCouponReceivePage.this;
                            w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    final LiveCouponReceivePage liveCouponReceivePage5 = LiveCouponReceivePage.this;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.3.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                            tVar2.allCenter();
                                            LiveCouponReceivePage liveCouponReceivePage6 = LiveCouponReceivePage.this;
                                            liveCouponReceivePage6.getClass();
                                            e eVar2 = new e();
                                            eVar2.u("qqlive_user_id", PageDataExtKt.getUserData(liveCouponReceivePage6.getPager().getPageData()).n("liveUserId"));
                                            eVar2.u("qqlive_room_id", PageDataExtKt.getUserData(liveCouponReceivePage6.getPager().getPageData()).n("roomID"));
                                            eVar2.v("qqlive_program_id", PageDataExtKt.getUserData(liveCouponReceivePage6.getPager().getPageData()).q("liveProgramId", "-1"));
                                            eVar2.t("qqlive_zhibo_type", PageDataExtKt.getUserData(liveCouponReceivePage6.getPager().getPageData()).j("liveType"));
                                            EcommerceExtKt.vr$default(tVar2, "pg_qqlive_dscoupon", "em_qqlive_coupon_layer", eVar2, null, null, false, 56);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final LiveCouponReceivePage liveCouponReceivePage6 = LiveCouponReceivePage.this;
                                    ECTransitionViewKt.TransitionFadeInOutView(vVar2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.3.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ECTransitionView eCTransitionView) {
                                            final LiveCouponReceivePage liveCouponReceivePage7 = LiveCouponReceivePage.this;
                                            eCTransitionView.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.3.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                                    ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                                    LiveCouponReceivePage liveCouponReceivePage8 = LiveCouponReceivePage.this;
                                                    eCTransitionAttr2.setTransitionAppear(((Boolean) liveCouponReceivePage8.resultDlgAppear$delegate.getValue(liveCouponReceivePage8, LiveCouponReceivePage.$$delegatedProperties[0])).booleanValue());
                                                    eCTransitionAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                                    eCTransitionAttr2.mo113backgroundColor(new h(0, 0, 0, 0.5f));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final LiveCouponReceivePage liveCouponReceivePage7 = LiveCouponReceivePage.this;
                                    final Function1<ECTransitionView, Unit> function1 = new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.3.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ECTransitionView eCTransitionView) {
                                            ECTransitionView eCTransitionView2 = eCTransitionView;
                                            final LiveCouponReceivePage liveCouponReceivePage8 = LiveCouponReceivePage.this;
                                            eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.3.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                                    LiveCouponReceivePage liveCouponReceivePage9 = LiveCouponReceivePage.this;
                                                    eCTransitionAttr.setTransitionAppear(((Boolean) liveCouponReceivePage9.resultDlgAppear$delegate.getValue(liveCouponReceivePage9, LiveCouponReceivePage.$$delegatedProperties[0])).booleanValue());
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final LiveCouponReceivePage liveCouponReceivePage9 = LiveCouponReceivePage.this;
                                            eCTransitionView2.event(new Function1<ECTransitionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.3.3.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ECTransitionEvent eCTransitionEvent) {
                                                    final LiveCouponReceivePage liveCouponReceivePage10 = LiveCouponReceivePage.this;
                                                    eCTransitionEvent.transitionFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.3.3.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(Boolean bool) {
                                                            if (!bool.booleanValue()) {
                                                                LiveCouponReceivePage liveCouponReceivePage11 = LiveCouponReceivePage.this;
                                                                KProperty<Object>[] kPropertyArr = LiveCouponReceivePage.$$delegatedProperties;
                                                                liveCouponReceivePage11.getClass();
                                                                Utils.INSTANCE.bridgeModule(liveCouponReceivePage11.getPagerId()).log("LiveCouponReceivePage handleCloseBtnClicked");
                                                                BridgeModule.closePage$default(IPagerIdKtxKt.getBridgeModule(liveCouponReceivePage11), null, null, 3);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final LiveCouponReceivePage liveCouponReceivePage10 = LiveCouponReceivePage.this;
                                            eCTransitionView2.addChild(new ReceiveResultDlg(), new Function1<ReceiveResultDlg, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.3.3.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ReceiveResultDlg receiveResultDlg) {
                                                    ReceiveResultDlg receiveResultDlg2 = receiveResultDlg;
                                                    final LiveCouponReceivePage liveCouponReceivePage11 = LiveCouponReceivePage.this;
                                                    receiveResultDlg2.attr(new Function1<ReceiveResultAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.3.3.3.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ReceiveResultAttr receiveResultAttr) {
                                                            ReceiveResultAttr receiveResultAttr2 = receiveResultAttr;
                                                            LiveCouponReceiveViewModel liveCouponReceiveViewModel7 = LiveCouponReceivePage.this.viewModel;
                                                            if (liveCouponReceiveViewModel7 == null) {
                                                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                                                liveCouponReceiveViewModel7 = null;
                                                            }
                                                            LiveCouponReceiveViewModel.CouponReceiveState couponReceiveState5 = liveCouponReceiveViewModel7.getCouponReceiveState();
                                                            Intrinsics.checkNotNull(couponReceiveState5, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceiveViewModel.CouponReceiveState.Success");
                                                            ShopCouponCouponShowInfo shopCouponCouponShowInfo = ((LiveCouponReceiveViewModel.CouponReceiveState.Success) couponReceiveState5).couponRetItem.couponShowInfo;
                                                            receiveResultAttr2.couponInfo$delegate.setValue(receiveResultAttr2, ReceiveResultAttr.$$delegatedProperties[0], shopCouponCouponShowInfo != null ? shopCouponCouponShowInfo.couponListStyle : null);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final LiveCouponReceivePage liveCouponReceivePage12 = LiveCouponReceivePage.this;
                                                    receiveResultDlg2.event(new Function1<ReceiveResultEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.3.3.3.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ReceiveResultEvent receiveResultEvent) {
                                                            ReceiveResultEvent receiveResultEvent2 = receiveResultEvent;
                                                            final LiveCouponReceivePage liveCouponReceivePage13 = LiveCouponReceivePage.this;
                                                            receiveResultEvent2.registerEvent("onClickCloseBtn", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.3.3.3.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(Object obj) {
                                                                    LiveCouponReceivePage liveCouponReceivePage14 = LiveCouponReceivePage.this;
                                                                    liveCouponReceivePage14.resultDlgAppear$delegate.setValue(liveCouponReceivePage14, LiveCouponReceivePage.$$delegatedProperties[0], Boolean.FALSE);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final LiveCouponReceivePage liveCouponReceivePage14 = LiveCouponReceivePage.this;
                                                            receiveResultEvent2.registerEvent("OnClickUseCouponBtn", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceivePage.body.1.2.3.3.3.2.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(Object obj) {
                                                                    LiveCouponReceiveViewModel liveCouponReceiveViewModel7;
                                                                    LiveCouponReceivePage liveCouponReceivePage15 = LiveCouponReceivePage.this;
                                                                    LiveCouponReceiveViewModel liveCouponReceiveViewModel8 = liveCouponReceivePage15.viewModel;
                                                                    if (liveCouponReceiveViewModel8 == null) {
                                                                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                                                        liveCouponReceiveViewModel8 = null;
                                                                    }
                                                                    if (liveCouponReceiveViewModel8.getCouponReceiveState() instanceof LiveCouponReceiveViewModel.CouponReceiveState.Success) {
                                                                        LiveCouponReceiveViewModel liveCouponReceiveViewModel9 = liveCouponReceivePage15.viewModel;
                                                                        if (liveCouponReceiveViewModel9 == null) {
                                                                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                                                            liveCouponReceiveViewModel9 = null;
                                                                        }
                                                                        LiveCouponReceiveViewModel.CouponReceiveState couponReceiveState5 = liveCouponReceiveViewModel9.getCouponReceiveState();
                                                                        Intrinsics.checkNotNull(couponReceiveState5, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceiveViewModel.CouponReceiveState.Success");
                                                                        String str = ((LiveCouponReceiveViewModel.CouponReceiveState.Success) couponReceiveState5).couponRetItem.couponBatchId;
                                                                        LiveCouponReceiveViewModel liveCouponReceiveViewModel10 = liveCouponReceivePage15.viewModel;
                                                                        if (liveCouponReceiveViewModel10 == null) {
                                                                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                                                            liveCouponReceiveViewModel7 = null;
                                                                        } else {
                                                                            liveCouponReceiveViewModel7 = liveCouponReceiveViewModel10;
                                                                        }
                                                                        e userData = PageDataExtKt.getUserData(liveCouponReceivePage15.getPager().getPageData());
                                                                        BridgeModule bridgeModule3 = IPagerIdKtxKt.getBridgeModule(liveCouponReceivePage15);
                                                                        liveCouponReceiveViewModel7.getClass();
                                                                        BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new LiveCouponReceiveViewModel$jumpToLiveWindow$1(bridgeModule3, userData, userData.n("liveUserId"), userData.n("roomID"), userData.n("enterRoomTime"), userData.q("liveProgramId", "-1"), str, liveCouponReceiveViewModel7, null), 3, null);
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
                                    };
                                    vVar2.addChild(new ECTransitionView(), new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt$TransitionFromCenterView$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ECTransitionView eCTransitionView) {
                                            ECTransitionView eCTransitionView2 = eCTransitionView;
                                            eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt$TransitionFromCenterView$1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                                    eCTransitionAttr.transitionType = 2;
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            function1.invoke(eCTransitionView2);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            k kVar2 = (k) LiveCouponReceivePage.this.getModule("KRNotifyModule");
                            if (kVar2 != null) {
                                e eVar2 = new e();
                                LiveCouponReceivePage liveCouponReceivePage5 = LiveCouponReceivePage.this;
                                LiveCouponReceiveViewModel liveCouponReceiveViewModel7 = liveCouponReceivePage5.viewModel;
                                if (liveCouponReceiveViewModel7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                } else {
                                    liveCouponReceiveViewModel2 = liveCouponReceiveViewModel7;
                                }
                                LiveCouponReceiveViewModel.CouponReceiveState couponReceiveState5 = liveCouponReceiveViewModel2.getCouponReceiveState();
                                Intrinsics.checkNotNull(couponReceiveState5, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceiveViewModel.CouponReceiveState.Success");
                                eVar2.t("coupon_num", ((LiveCouponReceiveViewModel.CouponReceiveState.Success) couponReceiveState5).couponsNum);
                                eVar2.u("roomID", PageDataExtKt.getUserData(liveCouponReceivePage5.getPager().getPageData()).n("roomID"));
                                Unit unit2 = Unit.INSTANCE;
                                kVar2.c("CouponReceiveSuccess", eVar2, true);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        this.viewModel = new LiveCouponReceiveViewModel(getPagerId());
        Utils.INSTANCE.bridgeModule(getPagerId()).log("LiveCouponReceivePage created");
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        b bVar;
        Object d16;
        super.didInit();
        final LiveCouponReceiveViewModel liveCouponReceiveViewModel = this.viewModel;
        b bVar2 = null;
        if (liveCouponReceiveViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            liveCouponReceiveViewModel = null;
        }
        e userData = PageDataExtKt.getUserData(getPager().getPageData());
        liveCouponReceiveViewModel.getClass();
        if (userData.g("isAnchor", false)) {
            long n3 = userData.n("roomID");
            String str = liveCouponReceiveViewModel.pagerId;
            Utils utils = Utils.INSTANCE;
            utils.bridgeModule(str).log("LiveCouponReceiveViewModel requestData for anchor roomId:" + n3);
            final Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceiveViewModel$requestData$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    int k3 = eVar.k("coupon_num", 0);
                    Utils.INSTANCE.bridgeModule(LiveCouponReceiveViewModel.this.pagerId).log("LiveCouponReceiveViewModel requestData couponNum:" + k3);
                    if (k3 >= 1) {
                        LiveCouponReceiveViewModel.this.setCouponReceiveState(new LiveCouponReceiveViewModel.CouponReceiveState.ClosePageWithMsg("\u53d1\u5238\u4e2d\uff0c\u53d1\u5238\u8be6\u60c5\u8bf7\u5230\u76f4\u64ad\u4e2d\u63a7\u53f0\u67e5\u770b"));
                    } else {
                        LiveCouponReceiveViewModel.this.setCouponReceiveState(new LiveCouponReceiveViewModel.CouponReceiveState.ClosePageWithMsg("\u5238\u6d3e\u53d1\u5b8c\u6bd5"));
                    }
                    return Unit.INSTANCE;
                }
            };
            final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceiveViewModel$requestData$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, String str2) {
                    num.intValue();
                    LiveCouponReceiveViewModel.this.setCouponReceiveState(new LiveCouponReceiveViewModel.CouponReceiveState.ClosePageWithMsg("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5"));
                    return Unit.INSTANCE;
                }
            };
            BridgeModule bridgeModule = utils.bridgeModule(str);
            e eVar = new e();
            eVar.u(AudienceReportConst.ROOM_ID, n3);
            eVar.t(WadlProxyConsts.CHANNEL, 8);
            bridgeModule.ssoRequest("trpc.ecom.qqlive_window_read_svr.QqliveWindowReadSvr/GetCoupon", eVar, false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.SSORequestModel$requestData$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar2) {
                    e eVar3;
                    e eVar4 = eVar2;
                    if (eVar4 != null) {
                        Function2<Integer, String, Unit> function22 = function2;
                        Function1<e, Unit> function12 = function1;
                        if (eVar4.a("errorCode")) {
                            function22.invoke(Integer.valueOf(eVar4.k("errorCode", -1)), eVar4.q("errorMsg", ""));
                        } else {
                            String q16 = eVar4.q("data", "");
                            if (q16.length() == 0) {
                                eVar3 = new e();
                            } else {
                                eVar3 = new e(q16);
                            }
                            function12.invoke(eVar3);
                        }
                    }
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        String p16 = userData.p("couponBatchIds");
        if (p16 == null) {
            p16 = "";
        }
        if (p16.length() == 0) {
            bVar = userData.l("couponBatchIds");
            if (bVar == null) {
                bVar = new b();
            }
        } else {
            bVar = new b(p16);
        }
        liveCouponReceiveViewModel.couponBatchIdArray = bVar;
        if (bVar.c() == 0) {
            Utils.INSTANCE.bridgeModule(liveCouponReceiveViewModel.pagerId).log("LiveCouponReceiveViewModel requestData return by couponBatchIdArray length 0");
            liveCouponReceiveViewModel.setCouponReceiveState(new LiveCouponReceiveViewModel.CouponReceiveState.ClosePageWithMsg("\u9886\u53d6\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5"));
            return;
        }
        b bVar3 = liveCouponReceiveViewModel.couponBatchIdArray;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponBatchIdArray");
        } else {
            bVar2 = bVar3;
        }
        ArrayList arrayList = new ArrayList();
        int c16 = bVar2.c();
        for (int i3 = 0; i3 < c16; i3++) {
            if (BooleanCompanionObject.INSTANCE instanceof String) {
                d16 = Boolean.valueOf(bVar2.e(i3));
            } else if (IntCompanionObject.INSTANCE instanceof String) {
                d16 = Integer.valueOf(bVar2.i(i3));
            } else if (LongCompanionObject.INSTANCE instanceof String) {
                d16 = Long.valueOf(bVar2.m(i3));
            } else if (StringCompanionObject.INSTANCE instanceof String) {
                d16 = bVar2.o(i3);
            } else if (DoubleCompanionObject.INSTANCE instanceof String) {
                d16 = Double.valueOf(bVar2.g(i3));
            } else {
                d16 = bVar2.d(i3);
            }
            if (d16 != null) {
                arrayList.add(new ShopCouponCouponReqItem((String) d16, 1));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        Utils utils2 = Utils.INSTANCE;
        ShopCouponDeviceInfo shopCouponDeviceInfo = SCPUtilsKt.toShopCouponDeviceInfo(utils2.currentBridgeModule().getDeviceInfo());
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        ISSOModelFactory<ShopCouponGetCouponRsp> iSSOModelFactory = ShopCouponGetCouponRsp.Factory;
        Function1<ShopCouponGetCouponRsp, Unit> function12 = new Function1<ShopCouponGetCouponRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceiveViewModel$requestDataForGetCoupon$2
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r7v13 */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ShopCouponGetCouponRsp shopCouponGetCouponRsp) {
                ShopCouponUserCouponUse shopCouponUserCouponUse;
                ShopCouponUserCouponUse shopCouponUserCouponUse2;
                int i16;
                ShopCouponUserCouponUse shopCouponUserCouponUse3;
                ShopCouponGetCouponRsp shopCouponGetCouponRsp2 = shopCouponGetCouponRsp;
                ArrayList<ShopCouponCouponRetItem> arrayList2 = shopCouponGetCouponRsp2.items;
                if (arrayList2 != null && (arrayList2.isEmpty() ^ true)) {
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
                    ArrayList<ShopCouponCouponRetItem> arrayList3 = shopCouponGetCouponRsp2.items;
                    LiveCouponReceiveViewModel liveCouponReceiveViewModel2 = LiveCouponReceiveViewModel.this;
                    ShopCouponCouponRetItem shopCouponCouponRetItem = null;
                    int i17 = 0;
                    for (ShopCouponCouponRetItem shopCouponCouponRetItem2 : arrayList3) {
                        Utils.INSTANCE.bridgeModule(liveCouponReceiveViewModel2.pagerId).log("LiveCouponReceiveViewModel requestDataForGetCoupon getData retItem:" + shopCouponCouponRetItem2);
                        int i18 = shopCouponCouponRetItem2.retCode;
                        if (i18 == 0) {
                            ShopCouponCouponShowInfo shopCouponCouponShowInfo = shopCouponCouponRetItem2.couponShowInfo;
                            i17 += (shopCouponCouponShowInfo == null || (shopCouponUserCouponUse = shopCouponCouponShowInfo.userCouponUse) == null) ? 0 : shopCouponUserCouponUse.remainNum;
                            shopCouponCouponRetItem = shopCouponCouponRetItem2;
                        } else if (i18 == 36311) {
                            ShopCouponCouponShowInfo shopCouponCouponShowInfo2 = shopCouponCouponRetItem2.couponShowInfo;
                            if (shopCouponCouponShowInfo2 != null && (shopCouponUserCouponUse2 = shopCouponCouponShowInfo2.userCouponUse) != null) {
                                i16 = shopCouponUserCouponUse2.remainNum;
                                i17 += i16;
                            }
                            i16 = 0;
                            i17 += i16;
                        } else if (i18 >= 36315 && i18 < 36330) {
                            T t16 = shopCouponCouponRetItem2.retMsg;
                            if (t16.length() == 0) {
                                t16 = "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
                            }
                            objectRef.element = t16;
                        } else {
                            ShopCouponCouponShowInfo shopCouponCouponShowInfo3 = shopCouponCouponRetItem2.couponShowInfo;
                            if (shopCouponCouponShowInfo3 != null && (shopCouponUserCouponUse3 = shopCouponCouponShowInfo3.userCouponUse) != null) {
                                i16 = shopCouponUserCouponUse3.remainNum;
                                i17 += i16;
                            }
                            i16 = 0;
                            i17 += i16;
                        }
                    }
                    if (shopCouponCouponRetItem != null) {
                        LiveCouponReceiveViewModel.this.setCouponReceiveState(new LiveCouponReceiveViewModel.CouponReceiveState.Success(shopCouponCouponRetItem, i17));
                    } else {
                        LiveCouponReceiveViewModel.this.setCouponReceiveState(new LiveCouponReceiveViewModel.CouponReceiveState.ClosePageWithEventAndMsg((String) objectRef.element, i17));
                    }
                } else {
                    Utils.INSTANCE.bridgeModule(LiveCouponReceiveViewModel.this.pagerId).log("LiveCouponReceiveViewModel requestDataForGetCoupon getData retItem is empty");
                    LiveCouponReceiveViewModel.this.setCouponReceiveState(new LiveCouponReceiveViewModel.CouponReceiveState.ClosePageWithMsg("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5"));
                }
                return Unit.INSTANCE;
            }
        };
        Function2<Integer, String, Unit> function22 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.coupon_receive_page.LiveCouponReceiveViewModel$requestDataForGetCoupon$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str2) {
                Utils utils3 = Utils.INSTANCE;
                String str3 = LiveCouponReceiveViewModel.this.pagerId;
                utils3.bridgeModule(str3).log(AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("LiveCouponReceiveViewModel requestDataForGetCoupon fail errorCode:", num.intValue(), ",errorMsg:", str2));
                LiveCouponReceiveViewModel.this.setCouponReceiveState(new LiveCouponReceiveViewModel.CouponReceiveState.ClosePageWithMsg("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5"));
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule = utils2.currentBridgeModule();
        e eVar2 = new e();
        b bVar4 = new b();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bVar4.t(((ShopCouponCouponReqItem) it.next()).encode());
        }
        eVar2.v("items", bVar4);
        eVar2.t("sence", 1);
        eVar2.t("mode", 1);
        eVar2.v("device_info", shopCouponDeviceInfo.encode());
        currentBridgeModule.ssoRequest("trpc.ecom.qshop_coupon_user_writer.QshopCouponUserWriter/GetCoupon", eVar2, false, new NetworkUtils$requestWithCmd$3(function22, iSSOModelFactory, function12));
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onPagerEvent(String str, e eVar) {
    }
}
