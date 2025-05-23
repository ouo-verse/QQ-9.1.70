package com.tencent.hippykotlin.demo.pages.nearby.new_homepage;

import c01.c;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionEvent;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.ShareItemData;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NearbyUserShareHelper;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NearbyUserShareHelper$Companion$shareUserByQQ$helper$1;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NearbyUserShareHelper$Companion$shareUserByQQ$helper$2;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NearbyUserShareHelper$shareByQQ$1;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavBarEvent;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbarAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBar;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPBottomBarAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCard;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.NBPHomepageProfileCardAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedListViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.NBPTacitAgreementAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.ab;
import com.tencent.kuikly.core.views.ac;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.co;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import j35.a;
import j35.g;
import j35.i;
import j35.j;
import j35.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPModalHomePage extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPModalHomePage.class, "avatarOpacity", "getAvatarOpacity()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPModalHomePage.class, "exit", "getExit()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPModalHomePage.class, "startingOpenPageAnimate", "getStartingOpenPageAnimate()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPModalHomePage.class, OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, "isFullScreen()Z", 0)};
    public final ReadWriteProperty avatarOpacity$delegate = c.a(Float.valueOf(0.0f));
    public String closePageNotifyRef;
    public String dismissEventCallbackRef;
    public final ReadWriteProperty exit$delegate;
    public String feedLikeChangeNotifyRef;
    public final ReadWriteProperty isFullScreen$delegate;
    public String jieBanPublishNotifyRef;
    public aa<aq<?, ?>> listViewRef;
    public final ReadWriteProperty startingOpenPageAnimate$delegate;
    public String userSelfInfoChangeNotifyRef;
    public NBPHomePageBaseViewModel viewModel;

    public NBPModalHomePage() {
        Boolean bool = Boolean.FALSE;
        this.exit$delegate = c.a(bool);
        this.startingOpenPageAnimate$delegate = c.a(bool);
        this.isFullScreen$delegate = c.a(bool);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPModalHomePage nBPModalHomePage = NBPModalHomePage.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        boolean booleanValue;
                        boolean booleanValue2;
                        m mVar2 = mVar;
                        booleanValue = ((Boolean) r1.startingOpenPageAnimate$delegate.getValue(NBPModalHomePage.this, NBPModalHomePage.$$delegatedProperties[2])).booleanValue();
                        mVar2.mo113backgroundColor(new h(0L, booleanValue ? 0.5f : 0.0f));
                        mVar2.justifyContentFlexEnd();
                        mVar2.size(mVar2.getPagerData().m(), mVar2.getPagerData().l());
                        b f16 = b.Companion.f(b.INSTANCE, 0.25f, null, 2, null);
                        booleanValue2 = ((Boolean) r1.startingOpenPageAnimate$delegate.getValue(NBPModalHomePage.this, NBPModalHomePage.$$delegatedProperties[2])).booleanValue();
                        mVar2.animate(f16, Boolean.valueOf(booleanValue2));
                        return Unit.INSTANCE;
                    }
                });
                final NBPModalHomePage nBPModalHomePage2 = NBPModalHomePage.this;
                ECTransitionViewKt.TransitionFromBottomView(viewContainer2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECTransitionView eCTransitionView) {
                        ECTransitionView eCTransitionView2 = eCTransitionView;
                        final NBPModalHomePage nBPModalHomePage3 = NBPModalHomePage.this;
                        eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                boolean booleanValue;
                                ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                eCTransitionAttr2.flexDirectionColumn();
                                eCTransitionAttr2.size(eCTransitionAttr2.getPagerData().m(), eCTransitionAttr2.getPagerData().l());
                                eCTransitionAttr2.borderRadius(16.0f, 16.0f, 0.0f, 0.0f);
                                booleanValue = ((Boolean) r0.startingOpenPageAnimate$delegate.getValue(NBPModalHomePage.this, NBPModalHomePage.$$delegatedProperties[2])).booleanValue();
                                eCTransitionAttr2.setTransitionAppear(booleanValue);
                                return Unit.INSTANCE;
                            }
                        });
                        eCTransitionView2.event(new Function1<ECTransitionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionEvent eCTransitionEvent) {
                                ECTransitionEvent eCTransitionEvent2 = eCTransitionEvent;
                                eCTransitionEvent2.transitionFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool) {
                                        if (!bool.booleanValue()) {
                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                eCTransitionEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPModalHomePage nBPModalHomePage4 = NBPModalHomePage.this;
                        ar.a(eCTransitionView2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aq<?, ?> aqVar) {
                                aq<?, ?> aqVar2 = aqVar;
                                final NBPModalHomePage nBPModalHomePage5 = NBPModalHomePage.this;
                                aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                        NBPModalHomePage.this.listViewRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ao aoVar) {
                                        ao aoVar2 = aoVar;
                                        aoVar2.flexDirectionColumn();
                                        aoVar2.showScrollerIndicator(false);
                                        aoVar2.borderRadius(16.0f, 16.0f, 0.0f, 0.0f);
                                        aoVar2.size(aoVar2.getPagerData().m(), aoVar2.getPagerData().l());
                                        aoVar2.justifyContentCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPModalHomePage nBPModalHomePage6 = NBPModalHomePage.this;
                                aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ap apVar) {
                                        final ap apVar2 = apVar;
                                        final NBPModalHomePage nBPModalHomePage7 = NBPModalHomePage.this;
                                        apVar2.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollParams scrollParams) {
                                                ScrollParams scrollParams2 = scrollParams;
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPModalHomePage.this.viewModel;
                                                if (nBPHomePageBaseViewModel != null) {
                                                    nBPHomePageBaseViewModel.isScrolling = true;
                                                }
                                                if (scrollParams2.getOffsetY() < 250.0f) {
                                                    NBPModalHomePage nBPModalHomePage8 = NBPModalHomePage.this;
                                                    nBPModalHomePage8.avatarOpacity$delegate.setValue(nBPModalHomePage8, NBPModalHomePage.$$delegatedProperties[0], Float.valueOf(Math.min(1.0f, Math.max(0.0f, scrollParams2.getOffsetY() / 200.0f))));
                                                }
                                                if (scrollParams2.getContentHeight() - scrollParams2.getViewHeight() < scrollParams2.getOffsetY() + 744.0f) {
                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPModalHomePage.this.viewModel;
                                                    if (nBPHomePageBaseViewModel2 != null) {
                                                        nBPHomePageBaseViewModel2.fetchFeedList(false);
                                                    }
                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPModalHomePage.this.viewModel;
                                                    if ((nBPHomePageBaseViewModel3 != null && nBPHomePageBaseViewModel3.isCurrentLikedPage) && nBPHomePageBaseViewModel3 != null) {
                                                        nBPHomePageBaseViewModel3.fetchUserLikedList();
                                                    }
                                                }
                                                boolean z16 = scrollParams2.getOffsetY() > 150.0f;
                                                NBPModalHomePage nBPModalHomePage9 = NBPModalHomePage.this;
                                                if (((Boolean) nBPModalHomePage9.isFullScreen$delegate.getValue(nBPModalHomePage9, NBPModalHomePage.$$delegatedProperties[3])).booleanValue() != z16) {
                                                    NBPModalHomePage.this.setFullScreen(z16);
                                                    QQNearbyModule.Companion.getInstance().asyncToNativeMethod("updateNavColor", (e) null, (Function1<? super e, Unit>) null);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPModalHomePage nBPModalHomePage8 = NBPModalHomePage.this;
                                        apVar2.willDragEndBySync(new Function1<co, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(co coVar) {
                                                co coVar2 = coVar;
                                                final NBPModalHomePage nBPModalHomePage9 = NBPModalHomePage.this;
                                                KProperty<Object>[] kPropertyArr = NBPModalHomePage.$$delegatedProperties;
                                                nBPModalHomePage9.getClass();
                                                if (coVar2.getOffsetY() <= -40.0f) {
                                                    nBPModalHomePage9.dismissWithAnimation();
                                                } else if (coVar2.getOffsetY() <= 40.0f) {
                                                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage$handleEndScroll$1
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            aq<?, ?> b16;
                                                            aa<aq<?, ?>> aaVar = NBPModalHomePage.this.listViewRef;
                                                            if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                                ScrollerView.setContentOffset$default(b16, 0.0f, 0.0f, true, null, 8, null);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    KProperty<Object>[] kPropertyArr2 = IPagerIdKtxKt.$$delegatedProperties;
                                                    TimerKt.e(nBPModalHomePage9.getPagerId(), 16, function0);
                                                    nBPModalHomePage9.setFullScreen(false);
                                                } else if (!((Boolean) nBPModalHomePage9.isFullScreen$delegate.getValue(nBPModalHomePage9, NBPModalHomePage.$$delegatedProperties[3])).booleanValue() || coVar2.getOffsetY() <= 200.0f) {
                                                    Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage$handleEndScroll$2
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            aq<?, ?> b16;
                                                            float f16 = NBPModalHomePage.this.getPagerData().getIsIOS() ? 56.0f : 76.0f;
                                                            aa<aq<?, ?>> aaVar = NBPModalHomePage.this.listViewRef;
                                                            if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                                ScrollerView.setContentOffset$default(b16, 0.0f, f16 + 200.0f, true, null, 8, null);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    KProperty<Object>[] kPropertyArr3 = IPagerIdKtxKt.$$delegatedProperties;
                                                    TimerKt.e(nBPModalHomePage9.getPagerId(), 16, function02);
                                                    nBPModalHomePage9.setFullScreen(true);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPModalHomePage nBPModalHomePage9 = NBPModalHomePage.this;
                                        apVar2.scrollEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.3.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollParams scrollParams) {
                                                final NBPModalHomePage nBPModalHomePage10 = NBPModalHomePage.this;
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = nBPModalHomePage10.viewModel;
                                                if (nBPHomePageBaseViewModel != null) {
                                                    nBPHomePageBaseViewModel.isScrolling = false;
                                                }
                                                ap apVar3 = apVar2;
                                                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.3.3.1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPModalHomePage.this.viewModel;
                                                        if (nBPHomePageBaseViewModel2 != null) {
                                                            nBPHomePageBaseViewModel2.handlePendingFeeds();
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                TimerKt.e(apVar3.getPagerId(), 1, function0);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPModalHomePage nBPModalHomePage10 = NBPModalHomePage.this;
                                        apVar2.dragEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.3.4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollParams scrollParams) {
                                                NBPModalHomePage nBPModalHomePage11 = NBPModalHomePage.this;
                                                if (((Boolean) nBPModalHomePage11.exit$delegate.getValue(nBPModalHomePage11, NBPModalHomePage.$$delegatedProperties[1])).booleanValue()) {
                                                    ap apVar3 = apVar2;
                                                    AnonymousClass1 anonymousClass1 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.3.4.1
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                    TimerKt.e(apVar3.getPagerId(), 300, anonymousClass1);
                                                } else {
                                                    ap apVar4 = apVar2;
                                                    final NBPModalHomePage nBPModalHomePage12 = NBPModalHomePage.this;
                                                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.3.4.2
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPModalHomePage.this.viewModel;
                                                            if (nBPHomePageBaseViewModel != null) {
                                                                nBPHomePageBaseViewModel.handlePendingFeeds();
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    KProperty<Object>[] kPropertyArr2 = IPagerIdKtxKt.$$delegatedProperties;
                                                    TimerKt.e(apVar4.getPagerId(), 1, function0);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPModalHomePage nBPModalHomePage7 = NBPModalHomePage.this;
                                w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(tVar2.getPagerData().m(), 200.0f);
                                                tVar2.m154zIndex(0);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPModalHomePage nBPModalHomePage8 = NBPModalHomePage.this;
                                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.4.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPModalHomePage nBPModalHomePage9 = NBPModalHomePage.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.4.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NBPModalHomePage nBPModalHomePage10 = NBPModalHomePage.this;
                                                        KProperty<Object>[] kPropertyArr = NBPModalHomePage.$$delegatedProperties;
                                                        nBPModalHomePage10.dismissWithAnimation();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPModalHomePage nBPModalHomePage8 = NBPModalHomePage.this;
                                ac.b(aqVar2, new Function1<ab, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ab abVar) {
                                        ab abVar2 = abVar;
                                        abVar2.attr(new Function1<com.tencent.kuikly.core.views.aa, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.aa aaVar) {
                                                com.tencent.kuikly.core.views.aa aaVar2 = aaVar;
                                                aaVar2.size(aaVar2.getPagerData().m(), 36.0f);
                                                aaVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                                                aaVar2.borderRadius(16.0f, 16.0f, 0.0f, 0.0f);
                                                aaVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(abVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.size(tVar2.getPagerData().m(), 36.0f);
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.2.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.2.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.size(36.0f, 5.0f);
                                                                tVar2.borderRadius(3.0f);
                                                                tVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_secondary"));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPModalHomePage nBPModalHomePage9 = NBPModalHomePage.this;
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = nBPModalHomePage9.viewModel;
                                        if ((nBPHomePageBaseViewModel == null || nBPHomePageBaseViewModel.isSelf) ? false : true) {
                                            w.a(abVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar) {
                                                    v vVar2 = vVar;
                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.positionAbsolute();
                                                            tVar2.m150top(15.0f);
                                                            tVar2.m149right(20.0f);
                                                            tVar2.flexDirectionRow();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPModalHomePage nBPModalHomePage10 = NBPModalHomePage.this;
                                                    final NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = nBPModalHomePage10.viewModel;
                                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.3.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar3) {
                                                            v vVar4 = vVar3;
                                                            final NBPModalHomePage nBPModalHomePage11 = NBPModalHomePage.this;
                                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.3.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    float floatValue;
                                                                    t tVar2 = tVar;
                                                                    tVar2.size(20.0f, 20.0f);
                                                                    floatValue = ((Number) r0.avatarOpacity$delegate.getValue(NBPModalHomePage.this, NBPModalHomePage.$$delegatedProperties[0])).floatValue();
                                                                    tVar2.m147opacity(1.0f - floatValue);
                                                                    tVar2.marginRight(12.0f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.3.2.2
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ImageView imageView) {
                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.3.2.2.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(af afVar) {
                                                                            af afVar2 = afVar;
                                                                            afVar2.size(20.0f, 20.0f);
                                                                            b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_FRhUZDbTjpY.png", false, 2, null);
                                                                            afVar2.t(QUIToken.color$default("icon_tertiary"));
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = nBPHomePageBaseViewModel2;
                                                            vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.3.2.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(u uVar) {
                                                                    final u uVar2 = uVar;
                                                                    final NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = NBPHomePageBaseViewModel.this;
                                                                    VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.3.2.3.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(Object obj) {
                                                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel5 = NBPHomePageBaseViewModel.this;
                                                                            if (nBPHomePageBaseViewModel5 != null) {
                                                                                nBPHomePageBaseViewModel5.homePageBaseReport("dt_imp", "em_nearby_share_btn");
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final NBPHomePageBaseViewModel nBPHomePageBaseViewModel5 = NBPHomePageBaseViewModel.this;
                                                                    uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.3.2.3.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            c45.e gVar;
                                                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel6 = NBPHomePageBaseViewModel.this;
                                                                            if (nBPHomePageBaseViewModel6 != null) {
                                                                                nBPHomePageBaseViewModel6.homePageBaseReport("dt_clck", "em_nearby_share_btn");
                                                                                String pagerId = uVar2.getPagerId();
                                                                                int appId = NBPHomePageBaseViewModel.this.getAppId();
                                                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel7 = NBPHomePageBaseViewModel.this;
                                                                                String str = nBPHomePageBaseViewModel7.accountId;
                                                                                nBPHomePageBaseViewModel7.getUserInfo();
                                                                                NearbyUserShareHelper nearbyUserShareHelper = new NearbyUserShareHelper(pagerId, appId, str, NearbyUserShareHelper$Companion$shareUserByQQ$helper$1.INSTANCE, NearbyUserShareHelper$Companion$shareUserByQQ$helper$2.INSTANCE);
                                                                                ShareItemData shareItemData = NBPSharePanelViewKt.ShareItemQQ;
                                                                                if (Intrinsics.areEqual(shareItemData, shareItemData)) {
                                                                                    j35.b bVar = null;
                                                                                    int i3 = 2;
                                                                                    if (appId == 2) {
                                                                                        gVar = new j35.c(2, (j35.b) null, new k(Long.parseLong(str), null, 2), (i) null, (a) null, (j) null, 117);
                                                                                    } else {
                                                                                        gVar = new g(7, bVar, new k(0L, str, 1), i3);
                                                                                    }
                                                                                    nearbyUserShareHelper.repo.getArkMsg(gVar, new NearbyUserShareHelper$shareByQQ$1(nearbyUserShareHelper));
                                                                                }
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
                                                    final NBPModalHomePage nBPModalHomePage11 = NBPModalHomePage.this;
                                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.3.3
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar3) {
                                                            v vVar4 = vVar3;
                                                            final NBPModalHomePage nBPModalHomePage12 = NBPModalHomePage.this;
                                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.3.3.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    float floatValue;
                                                                    t tVar2 = tVar;
                                                                    tVar2.size(20.0f, 20.0f);
                                                                    floatValue = ((Number) r0.avatarOpacity$delegate.getValue(NBPModalHomePage.this, NBPModalHomePage.$$delegatedProperties[0])).floatValue();
                                                                    tVar2.m147opacity(1.0f - floatValue);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.3.3.2
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ImageView imageView) {
                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.3.3.2.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(af afVar) {
                                                                            af afVar2 = afVar;
                                                                            afVar2.size(20.0f, 20.0f);
                                                                            b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_nipDU1eSCH0.png", false, 2, null);
                                                                            afVar2.t(QUIToken.color$default("icon_tertiary"));
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPModalHomePage nBPModalHomePage13 = NBPModalHomePage.this;
                                                            vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.3.3.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(u uVar) {
                                                                    final NBPModalHomePage nBPModalHomePage14 = NBPModalHomePage.this;
                                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.5.3.3.3.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPModalHomePage.this.viewModel;
                                                                            if (nBPHomePageBaseViewModel3 != null) {
                                                                                nBPHomePageBaseViewModel3.reportUser();
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
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.6.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.positionAbsolute();
                                                tVar2.m150top(235.0f);
                                                tVar2.size(tVar2.getPagerData().m(), 6.0f);
                                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPModalHomePage nBPModalHomePage9 = NBPModalHomePage.this;
                                aqVar2.addChild(new NBPHomepageProfileCard(), new Function1<NBPHomepageProfileCard, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.7
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPHomepageProfileCard nBPHomepageProfileCard) {
                                        final NBPModalHomePage nBPModalHomePage10 = NBPModalHomePage.this;
                                        nBPHomepageProfileCard.attr(new Function1<NBPHomepageProfileCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.7.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPHomepageProfileCardAttr nBPHomepageProfileCardAttr) {
                                                float floatValue;
                                                NBPHomepageProfileCardAttr nBPHomepageProfileCardAttr2 = nBPHomepageProfileCardAttr;
                                                NBPModalHomePage nBPModalHomePage11 = NBPModalHomePage.this;
                                                nBPHomepageProfileCardAttr2.viewModel = nBPModalHomePage11.viewModel;
                                                floatValue = ((Number) nBPModalHomePage11.avatarOpacity$delegate.getValue(nBPModalHomePage11, NBPModalHomePage.$$delegatedProperties[0])).floatValue();
                                                nBPHomepageProfileCardAttr2.avatarOpacity$delegate.setValue(nBPHomepageProfileCardAttr2, NBPHomepageProfileCardAttr.$$delegatedProperties[0], Float.valueOf(1.0f - floatValue));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPModalHomePage nBPModalHomePage10 = NBPModalHomePage.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.8
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPModalHomePage.this.viewModel;
                                        if (nBPHomePageBaseViewModel != null) {
                                            return Boolean.valueOf(nBPHomePageBaseViewModel.tacitShow());
                                        }
                                        return null;
                                    }
                                };
                                final NBPModalHomePage nBPModalHomePage11 = NBPModalHomePage.this;
                                ConditionViewKt.c(aqVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.9
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final NBPModalHomePage nBPModalHomePage12 = NBPModalHomePage.this;
                                        conditionView.addChild(new TacitAgreementView(), new Function1<TacitAgreementView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.9.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TacitAgreementView tacitAgreementView) {
                                                final NBPModalHomePage nBPModalHomePage13 = NBPModalHomePage.this;
                                                tacitAgreementView.attr(new Function1<NBPTacitAgreementAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.9.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NBPTacitAgreementAttr nBPTacitAgreementAttr) {
                                                        nBPTacitAgreementAttr.viewModel = NBPModalHomePage.this.viewModel;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPModalHomePage nBPModalHomePage12 = NBPModalHomePage.this;
                                aqVar2.addChild(new HomepageFeedsView(), new Function1<HomepageFeedsView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.10
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(HomepageFeedsView homepageFeedsView) {
                                        final NBPModalHomePage nBPModalHomePage13 = NBPModalHomePage.this;
                                        homepageFeedsView.attr(new Function1<FeedListViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.10.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(FeedListViewAttr feedListViewAttr) {
                                                feedListViewAttr.viewModel = NBPModalHomePage.this.viewModel;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final float f16 = NBPModalHomePage.this.getPagerData().getIsIOS() ? 109.0f : NBPModalHomePage.this.getPagerData().getAndroidBottomBavBarHeight() > 30.0f ? 69.0f : 89.0f;
                                w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.11
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        final float f17 = f16;
                                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.11.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(tVar2.getPagerData().m(), f17);
                                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                                                tVar2.marginTop(-0.5f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.12
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.12.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(1.0f);
                                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                                                tVar2.marginTop(-0.5f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.12.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.2.3.12.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo141height(400.0f);
                                                        tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
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
                });
                final NBPModalHomePage nBPModalHomePage3 = NBPModalHomePage.this;
                viewContainer2.addChild(new NBPModalNavbar(), new Function1<NBPModalNavbar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPModalNavbar nBPModalNavbar) {
                        NBPModalNavbar nBPModalNavbar2 = nBPModalNavbar;
                        final NBPModalHomePage nBPModalHomePage4 = NBPModalHomePage.this;
                        nBPModalNavbar2.attr(new Function1<NBPModalNavbarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPModalNavbarAttr nBPModalNavbarAttr) {
                                float floatValue;
                                float floatValue2;
                                NBPModalNavbarAttr nBPModalNavbarAttr2 = nBPModalNavbarAttr;
                                nBPModalNavbarAttr2.positionAbsolute();
                                NBPModalHomePage nBPModalHomePage5 = NBPModalHomePage.this;
                                boolean booleanValue = ((Boolean) nBPModalHomePage5.isFullScreen$delegate.getValue(nBPModalHomePage5, NBPModalHomePage.$$delegatedProperties[3])).booleanValue();
                                ReadWriteProperty readWriteProperty = nBPModalNavbarAttr2.isFullScreen$delegate;
                                KProperty<?>[] kPropertyArr = NBPModalNavbarAttr.$$delegatedProperties;
                                readWriteProperty.setValue(nBPModalNavbarAttr2, kPropertyArr[0], Boolean.valueOf(booleanValue));
                                NBPModalHomePage nBPModalHomePage6 = NBPModalHomePage.this;
                                nBPModalNavbarAttr2.viewModel = nBPModalHomePage6.viewModel;
                                floatValue = ((Number) nBPModalHomePage6.avatarOpacity$delegate.getValue(nBPModalHomePage6, NBPModalHomePage.$$delegatedProperties[0])).floatValue();
                                nBPModalNavbarAttr2.avatarOpacity$delegate.setValue(nBPModalNavbarAttr2, kPropertyArr[1], Float.valueOf(floatValue));
                                floatValue2 = ((Number) r0.avatarOpacity$delegate.getValue(NBPModalHomePage.this, NBPModalHomePage.$$delegatedProperties[0])).floatValue();
                                nBPModalNavbarAttr2.m152visibility(!(floatValue2 == 0.0f));
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPModalHomePage nBPModalHomePage5 = NBPModalHomePage.this;
                        nBPModalNavbar2.event(new Function1<NBPModalNavBarEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPModalNavBarEvent nBPModalNavBarEvent) {
                                final NBPModalHomePage nBPModalHomePage6 = NBPModalHomePage.this;
                                nBPModalNavBarEvent.register("closePage", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        NBPModalHomePage nBPModalHomePage7 = NBPModalHomePage.this;
                                        KProperty<Object>[] kPropertyArr = NBPModalHomePage.$$delegatedProperties;
                                        nBPModalHomePage7.dismissWithAnimation();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPModalHomePage nBPModalHomePage4 = NBPModalHomePage.this;
                viewContainer2.addChild(new NBPBottomBar(), new Function1<NBPBottomBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPBottomBar nBPBottomBar) {
                        final NBPModalHomePage nBPModalHomePage5 = NBPModalHomePage.this;
                        nBPBottomBar.attr(new Function1<NBPBottomBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPBottomBarAttr nBPBottomBarAttr) {
                                NBPBottomBarAttr nBPBottomBarAttr2 = nBPBottomBarAttr;
                                nBPBottomBarAttr2.mo113backgroundColor(QUIToken.color$default("bg_nav_secondary"));
                                NBPModalHomePage nBPModalHomePage6 = NBPModalHomePage.this;
                                nBPBottomBarAttr2.m152visibility(!((Boolean) nBPModalHomePage6.exit$delegate.getValue(nBPModalHomePage6, NBPModalHomePage.$$delegatedProperties[1])).booleanValue());
                                Attr.absolutePosition$default(nBPBottomBarAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPModalHomePage.this.viewModel;
                                if (nBPHomePageBaseViewModel != null) {
                                    nBPBottomBarAttr2.appId = nBPHomePageBaseViewModel.getAppId();
                                }
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPModalHomePage.this.viewModel;
                                nBPBottomBarAttr2.tinyId = String.valueOf(nBPHomePageBaseViewModel2 != null ? nBPHomePageBaseViewModel2.accountId : null);
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPModalHomePage.this.viewModel;
                                if (nBPHomePageBaseViewModel3 != null) {
                                    nBPHomePageBaseViewModel3.getUserInfo();
                                }
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = NBPModalHomePage.this.viewModel;
                                if (nBPHomePageBaseViewModel4 != null) {
                                    nBPHomePageBaseViewModel4.getUserInfo();
                                }
                                nBPBottomBarAttr2.viewModel = NBPModalHomePage.this.viewModel;
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

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        this.viewModel = NBPHomePageBaseViewModel.Companion.created(getPageData(), true);
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage$created$1
            {
                super(0);
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x0009, code lost:
            
                if (r1.isSelf == true) goto L8;
             */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke() {
                final NBPModalHomePage nBPModalHomePage = NBPModalHomePage.this;
                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = nBPModalHomePage.viewModel;
                boolean z16 = nBPHomePageBaseViewModel != null;
                if (z16) {
                    nBPModalHomePage.userSelfInfoChangeNotifyRef = com.tencent.kuikly.core.module.k.b(IPagerIdKtxKt.getNotifyModule(nBPModalHomePage), "onNearbyProUserInfoChange", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage$initNotify$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(e eVar) {
                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2;
                            e eVar2 = eVar;
                            AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("on user info change: ", eVar2, KLog.INSTANCE, "NBPModalHomePage");
                            if (eVar2 != null && (nBPHomePageBaseViewModel2 = NBPModalHomePage.this.viewModel) != null) {
                                nBPHomePageBaseViewModel2.updateUserInfo(eVar2);
                            }
                            return Unit.INSTANCE;
                        }
                    }, 2, null);
                }
                nBPModalHomePage.feedLikeChangeNotifyRef = com.tencent.kuikly.core.module.k.b(IPagerIdKtxKt.getNotifyModule(nBPModalHomePage), "NearbyFeedLikeStatusChangedEvent", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage$initNotify$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        e eVar2 = eVar;
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPModalHomePage.this.viewModel;
                        if (nBPHomePageBaseViewModel2 != null) {
                            nBPHomePageBaseViewModel2.updateLikeNum(eVar2);
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                nBPModalHomePage.jieBanPublishNotifyRef = com.tencent.kuikly.core.module.k.b(IPagerIdKtxKt.getNotifyModule(nBPModalHomePage), "JIEBAN_PUBLISH_SUCCESS_EVENT", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage$initNotify$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPModalHomePage.this.viewModel;
                        if (nBPHomePageBaseViewModel2 != null) {
                            nBPHomePageBaseViewModel2.refreshFeedList();
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                nBPModalHomePage.closePageNotifyRef = com.tencent.kuikly.core.module.k.b(IPagerIdKtxKt.getNotifyModule(nBPModalHomePage), "JIEBAN_OPEN_MY_PROFILE_EVENT", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage$initNotify$4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar) {
                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                        QQKuiklyPlatformApi.Companion.closePage$default();
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(getPagerId(), 1, function0);
    }

    public final void dismissWithAnimation() {
        aq<?, ?> b16;
        aa<aq<?, ?>> aaVar = this.listViewRef;
        if (aaVar != null && (b16 = aaVar.b()) != null) {
            ScrollerView.setContentOffset$default(b16, 0.0f, 200.0f - getPageData().l(), true, null, 8, null);
        }
        ReadWriteProperty readWriteProperty = this.exit$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[1], Boolean.TRUE);
        this.startingOpenPageAnimate$delegate.setValue(this, kPropertyArr[2], Boolean.FALSE);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidAppear() {
        super.pageDidAppear();
        KLog.INSTANCE.i("NBPModalHomePage", "pageDidAppear");
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = this.viewModel;
        if (nBPHomePageBaseViewModel != null) {
            nBPHomePageBaseViewModel.refreshSelfInfo();
        }
        this.dismissEventCallbackRef = com.tencent.kuikly.core.module.k.b(IPagerIdKtxKt.getNotifyModule(this), "JIEBAN_CLOSE_FLOAT_PROFILE_EVENT", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.NBPModalHomePage$pageDidAppear$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                NBPModalHomePage.this.dismissWithAnimation();
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidDisappear() {
        super.pageDidDisappear();
        String str = this.dismissEventCallbackRef;
        if (str != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("JIEBAN_EXIT_MY_PROFILE_EVENT", str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0016, code lost:
    
        if (r0.isSelf == true) goto L8;
     */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void pageWillDestroy() {
        boolean z16;
        String str;
        super.pageWillDestroy();
        KLog.INSTANCE.i("NBPModalHomePage", Pager.PAGER_EVENT_WILL_DESTROY);
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = this.viewModel;
        if (nBPHomePageBaseViewModel != null) {
            z16 = true;
        }
        z16 = false;
        if (z16 && (str = this.userSelfInfoChangeNotifyRef) != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("onNearbyProUserInfoChange", str);
        }
        String str2 = this.feedLikeChangeNotifyRef;
        if (str2 != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("NearbyFeedLikeStatusChangedEvent", str2);
        }
        String str3 = this.jieBanPublishNotifyRef;
        if (str3 != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("JIEBAN_PUBLISH_SUCCESS_EVENT", str3);
        }
        String str4 = this.closePageNotifyRef;
        if (str4 != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("JIEBAN_OPEN_MY_PROFILE_EVENT", str4);
        }
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = this.viewModel;
        if (nBPHomePageBaseViewModel2 != null) {
            nBPHomePageBaseViewModel2.reportPageExposure(false);
        }
    }

    public final void setFullScreen(boolean z16) {
        this.isFullScreen$delegate.setValue(this, $$delegatedProperties[3], Boolean.valueOf(z16));
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLayout() {
        super.viewDidLayout();
        this.startingOpenPageAnimate$delegate.setValue(this, $$delegatedProperties[2], Boolean.TRUE);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = this.viewModel;
        if (nBPHomePageBaseViewModel != null) {
            nBPHomePageBaseViewModel.reportPageExposure(true);
        }
    }
}
