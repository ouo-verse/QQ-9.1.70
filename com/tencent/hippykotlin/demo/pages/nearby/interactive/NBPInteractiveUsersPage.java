package com.tencent.hippykotlin.demo.pages.nearby.interactive;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionEvent;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.NBPInteractiveRepo;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemView;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveUserItemViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view_model.NBPInteractiveViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.FooterRefreshEndState;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.FooterRefreshView;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ab;
import com.tencent.kuikly.core.views.ac;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.co;
import com.tencent.kuikly.core.views.f;
import com.tencent.kuikly.core.views.i;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.kuikly.core.views.x;
import com.tencent.kuikly.core.views.y;
import com.tencent.kuikly.core.views.z;
import java.util.List;
import k35.g;
import k35.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPInteractiveUsersPage extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPInteractiveUsersPage.class, "footerRefreshText", "getFooterRefreshText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPInteractiveUsersPage.class, "exit", "getExit()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPInteractiveUsersPage.class, "startingOpenPageAnimate", "getStartingOpenPageAnimate()Z", 0)};
    public String closeMsgPageNotification;
    public final ReadWriteProperty exit$delegate;
    public aa<FooterRefreshView> footerRefreshRef;
    public aa<aq<?, ?>> listViewRef;
    public final ReadWriteProperty startingOpenPageAnimate$delegate;
    public NBPInteractiveViewModel viewModel;
    public final FastClickUtils fastClickUtils = new FastClickUtils(500);
    public final ReadWriteProperty footerRefreshText$delegate = c.a("");
    public float listViewHeight = 645.0f;

    /* loaded from: classes31.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FooterRefreshState.values().length];
            try {
                iArr[FooterRefreshState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FooterRefreshState.REFRESHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FooterRefreshState.NONE_MORE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FooterRefreshState.FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NBPInteractiveUsersPage() {
        Boolean bool = Boolean.FALSE;
        this.exit$delegate = c.a(bool);
        this.startingOpenPageAnimate$delegate = c.a(bool);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPInteractiveUsersPage nBPInteractiveUsersPage = NBPInteractiveUsersPage.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        boolean booleanValue;
                        boolean booleanValue2;
                        m mVar2 = mVar;
                        booleanValue = ((Boolean) r1.startingOpenPageAnimate$delegate.getValue(NBPInteractiveUsersPage.this, NBPInteractiveUsersPage.$$delegatedProperties[2])).booleanValue();
                        mVar2.mo113backgroundColor(new h(0L, booleanValue ? 0.5f : 0.0f));
                        mVar2.justifyContentFlexEnd();
                        b f16 = b.Companion.f(b.INSTANCE, 0.25f, null, 2, null);
                        booleanValue2 = ((Boolean) r1.startingOpenPageAnimate$delegate.getValue(NBPInteractiveUsersPage.this, NBPInteractiveUsersPage.$$delegatedProperties[2])).booleanValue();
                        mVar2.animate(f16, Boolean.valueOf(booleanValue2));
                        mVar2.accessibility("\u5173\u95ed\u5f39\u7a97");
                        mVar2.accessibilityRole(AccessibilityRole.BUTTON);
                        return Unit.INSTANCE;
                    }
                });
                final NBPInteractiveUsersPage nBPInteractiveUsersPage2 = NBPInteractiveUsersPage.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NBPInteractiveUsersPage nBPInteractiveUsersPage3 = NBPInteractiveUsersPage.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                NBPInteractiveUsersPage nBPInteractiveUsersPage4 = NBPInteractiveUsersPage.this;
                                nBPInteractiveUsersPage4.startingOpenPageAnimate$delegate.setValue(nBPInteractiveUsersPage4, NBPInteractiveUsersPage.$$delegatedProperties[2], Boolean.FALSE);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPInteractiveUsersPage nBPInteractiveUsersPage3 = NBPInteractiveUsersPage.this;
                ECTransitionViewKt.TransitionFromBottomView(viewContainer2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECTransitionView eCTransitionView) {
                        ECTransitionView eCTransitionView2 = eCTransitionView;
                        final NBPInteractiveUsersPage nBPInteractiveUsersPage4 = NBPInteractiveUsersPage.this;
                        eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                boolean booleanValue;
                                ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                eCTransitionAttr2.flexDirectionColumn();
                                eCTransitionAttr2.size(eCTransitionAttr2.getPagerData().m(), NBPInteractiveUsersPage.this.listViewHeight);
                                eCTransitionAttr2.borderRadius(16.0f, 16.0f, 0.0f, 0.0f);
                                booleanValue = ((Boolean) r0.startingOpenPageAnimate$delegate.getValue(NBPInteractiveUsersPage.this, NBPInteractiveUsersPage.$$delegatedProperties[2])).booleanValue();
                                eCTransitionAttr2.setTransitionAppear(booleanValue);
                                return Unit.INSTANCE;
                            }
                        });
                        eCTransitionView2.event(new Function1<ECTransitionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionEvent eCTransitionEvent) {
                                ECTransitionEvent eCTransitionEvent2 = eCTransitionEvent;
                                eCTransitionEvent2.transitionFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool) {
                                        if (!bool.booleanValue()) {
                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                eCTransitionEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPInteractiveUsersPage nBPInteractiveUsersPage5 = NBPInteractiveUsersPage.this;
                        ar.a(eCTransitionView2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aq<?, ?> aqVar) {
                                aq<?, ?> aqVar2 = aqVar;
                                final NBPInteractiveUsersPage nBPInteractiveUsersPage6 = NBPInteractiveUsersPage.this;
                                aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                        NBPInteractiveUsersPage.this.listViewRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPInteractiveUsersPage nBPInteractiveUsersPage7 = NBPInteractiveUsersPage.this;
                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ao aoVar) {
                                        ao aoVar2 = aoVar;
                                        aoVar2.flexDirectionColumn();
                                        aoVar2.showScrollerIndicator(false);
                                        aoVar2.borderRadius(16.0f, 16.0f, 0.0f, 0.0f);
                                        aoVar2.size(aoVar2.getPagerData().m(), NBPInteractiveUsersPage.this.listViewHeight);
                                        aoVar2.justifyContentCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPInteractiveUsersPage nBPInteractiveUsersPage8 = NBPInteractiveUsersPage.this;
                                aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ap apVar) {
                                        final ap apVar2 = apVar;
                                        final NBPInteractiveUsersPage nBPInteractiveUsersPage9 = NBPInteractiveUsersPage.this;
                                        apVar2.willDragEndBySync(new Function1<co, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(co coVar) {
                                                co coVar2 = coVar;
                                                final NBPInteractiveUsersPage nBPInteractiveUsersPage10 = NBPInteractiveUsersPage.this;
                                                KProperty<Object>[] kPropertyArr = NBPInteractiveUsersPage.$$delegatedProperties;
                                                nBPInteractiveUsersPage10.getClass();
                                                if (coVar2.getOffsetY() < 0.0f && Math.abs(coVar2.getOffsetY()) > nBPInteractiveUsersPage10.listViewHeight / 6) {
                                                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage$handleEndScroll$1
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            aq<?, ?> b16;
                                                            aa<aq<?, ?>> aaVar = NBPInteractiveUsersPage.this.listViewRef;
                                                            if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                                ScrollerView.setContentOffset$default(b16, 0.0f, -NBPInteractiveUsersPage.this.listViewHeight, true, null, 8, null);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    KProperty<Object>[] kPropertyArr2 = IPagerIdKtxKt.$$delegatedProperties;
                                                    TimerKt.e(nBPInteractiveUsersPage10.getPagerId(), 5, function0);
                                                    nBPInteractiveUsersPage10.exit$delegate.setValue(nBPInteractiveUsersPage10, NBPInteractiveUsersPage.$$delegatedProperties[1], Boolean.TRUE);
                                                } else if (coVar2.getOffsetY() < 0.0f && Math.abs(coVar2.getOffsetY()) <= nBPInteractiveUsersPage10.listViewHeight / 6) {
                                                    Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage$handleEndScroll$2
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            aq<?, ?> b16;
                                                            aa<aq<?, ?>> aaVar = NBPInteractiveUsersPage.this.listViewRef;
                                                            if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                                ScrollerView.setContentOffset$default(b16, 0.0f, 0.0f, true, null, 8, null);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    KProperty<Object>[] kPropertyArr3 = IPagerIdKtxKt.$$delegatedProperties;
                                                    TimerKt.e(nBPInteractiveUsersPage10.getPagerId(), 5, function02);
                                                    nBPInteractiveUsersPage10.exit$delegate.setValue(nBPInteractiveUsersPage10, NBPInteractiveUsersPage.$$delegatedProperties[1], Boolean.FALSE);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPInteractiveUsersPage nBPInteractiveUsersPage10 = NBPInteractiveUsersPage.this;
                                        apVar2.dragEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.3.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollParams scrollParams) {
                                                NBPInteractiveUsersPage nBPInteractiveUsersPage11 = NBPInteractiveUsersPage.this;
                                                if (((Boolean) nBPInteractiveUsersPage11.exit$delegate.getValue(nBPInteractiveUsersPage11, NBPInteractiveUsersPage.$$delegatedProperties[1])).booleanValue()) {
                                                    ap apVar3 = apVar2;
                                                    AnonymousClass1 anonymousClass1 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.3.2.1
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                    TimerKt.e(apVar3.getPagerId(), 300, anonymousClass1);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ac.b(aqVar2, new Function1<ab, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ab abVar) {
                                        ab abVar2 = abVar;
                                        abVar2.attr(new Function1<com.tencent.kuikly.core.views.aa, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.aa aaVar) {
                                                com.tencent.kuikly.core.views.aa aaVar2 = aaVar;
                                                aaVar2.size(aaVar2.getPagerData().m(), 62.0f);
                                                aaVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                                                aaVar2.borderRadius(16.0f, 16.0f, 0.0f, 0.0f);
                                                aaVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(abVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.4.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.4.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.size(tVar2.getPagerData().m(), 20.0f);
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.4.2.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.4.2.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.size(34.0f, 4.0f);
                                                                tVar2.borderRadius(2.0f);
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
                                        w.a(abVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.4.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.4.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.size(tVar2.getPagerData().m(), 42.0f);
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.4.3.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.4.3.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                                ceVar2.mo141height(20.0f);
                                                                ceVar2.text(ceVar2.getPagerData().n().p("title"));
                                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                ceVar2.fontWeight500();
                                                                ceVar2.textAlignCenter();
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
                                final NBPInteractiveUsersPage nBPInteractiveUsersPage9 = NBPInteractiveUsersPage.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.5
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        NBPInteractiveViewModel nBPInteractiveViewModel = NBPInteractiveUsersPage.this.viewModel;
                                        if (nBPInteractiveViewModel != null) {
                                            return Integer.valueOf(nBPInteractiveViewModel.getPageState());
                                        }
                                        return null;
                                    }
                                };
                                final NBPInteractiveUsersPage nBPInteractiveUsersPage10 = NBPInteractiveUsersPage.this;
                                BindDirectivesViewKt.a(aqVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                        NBPInteractiveViewModel nBPInteractiveViewModel = NBPInteractiveUsersPage.this.viewModel;
                                        Integer valueOf = nBPInteractiveViewModel != null ? Integer.valueOf(nBPInteractiveViewModel.getPageState()) : null;
                                        if (valueOf != null && valueOf.intValue() == 0) {
                                            final NBPInteractiveUsersPage nBPInteractiveUsersPage11 = NBPInteractiveUsersPage.this;
                                            w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar) {
                                                    v vVar2 = vVar;
                                                    final NBPInteractiveUsersPage nBPInteractiveUsersPage12 = NBPInteractiveUsersPage.this;
                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.mo153width(tVar2.getPagerData().m());
                                                            tVar2.mo141height(NBPInteractiveUsersPage.this.listViewHeight - 62.0f);
                                                            tVar2.allCenter();
                                                            tVar2.flexDirectionRow();
                                                            tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    i.a(vVar2, new Function1<com.tencent.kuikly.core.views.h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.1.2
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(com.tencent.kuikly.core.views.h hVar) {
                                                            hVar.attr(new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.1.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(f fVar) {
                                                                    f fVar2 = fVar;
                                                                    fVar2.size(20.0f, 20.0f);
                                                                    fVar2.h(true);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.1.3
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.1.3.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.marginLeft(4.0f);
                                                                    ceVar2.text("\u52a0\u8f7d\u4e2d,\u8bf7\u7a0d\u540e...");
                                                                    NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 13.0f, null, 2, null, "text_primary");
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        } else if (valueOf != null && valueOf.intValue() == 3) {
                                            final NBPInteractiveUsersPage nBPInteractiveUsersPage12 = NBPInteractiveUsersPage.this;
                                            w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar) {
                                                    v vVar2 = vVar;
                                                    final NBPInteractiveUsersPage nBPInteractiveUsersPage13 = NBPInteractiveUsersPage.this;
                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.mo153width(tVar2.getPagerData().m());
                                                            tVar2.mo141height(NBPInteractiveUsersPage.this.listViewHeight - 62.0f);
                                                            tVar2.allCenter();
                                                            tVar2.flexDirectionColumn();
                                                            tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.2.2
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.2.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(af afVar) {
                                                                    af afVar2 = afVar;
                                                                    afVar2.size(100.0f, 100.0f);
                                                                    b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_rJayQJ9gRzZ.png", false, 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.2.3
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.2.3.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.marginTop(24.0f);
                                                                    ceVar2.text("\u6682\u65e0\u4e92\u52a8\u6d88\u606f");
                                                                    NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 17.0f, null, 2, null, "text_primary");
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        } else if (valueOf != null && valueOf.intValue() == 1) {
                                            final NBPInteractiveUsersPage nBPInteractiveUsersPage13 = NBPInteractiveUsersPage.this;
                                            w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar) {
                                                    v vVar2 = vVar;
                                                    final NBPInteractiveUsersPage nBPInteractiveUsersPage14 = NBPInteractiveUsersPage.this;
                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.3.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.mo153width(tVar2.getPagerData().m());
                                                            tVar2.mo141height(NBPInteractiveUsersPage.this.listViewHeight - 62.0f);
                                                            tVar2.allCenter();
                                                            tVar2.flexDirectionColumn();
                                                            tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPInteractiveUsersPage nBPInteractiveUsersPage15 = NBPInteractiveUsersPage.this;
                                                    vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.3.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(u uVar) {
                                                            final NBPInteractiveUsersPage nBPInteractiveUsersPage16 = NBPInteractiveUsersPage.this;
                                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.3.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    NBPInteractiveViewModel nBPInteractiveViewModel2 = NBPInteractiveUsersPage.this.viewModel;
                                                                    if (nBPInteractiveViewModel2 != null) {
                                                                        nBPInteractiveViewModel2.setPageState(0);
                                                                        nBPInteractiveViewModel2.getUserList().clear();
                                                                        nBPInteractiveViewModel2.fetchFirstInteractiveUserList();
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.3.3
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.3.3.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(af afVar) {
                                                                    af afVar2 = afVar;
                                                                    afVar2.size(86.0f, 86.0f);
                                                                    b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAADICAMAAACahl6sAAAATlBMVEUAAABMTExMTExQUFBMTExMTExISEhLS0tLS0tMTExQUFBAQEBLS0tKSkpLS0tNTU1MTExMTExMTExMTExKSkpJSUlMTExLS0tMTExMTEzb8illAAAAGXRSTlMA3+8gv4AgX5BAEBBwMKCfz2+vUI9QQc4/sIny8wAAB+NJREFUeNrtndty2yAQhlkOAnSWHLvV+79oJ8TxOnXqALuScEf/XWbSKp/2wAILEocOHTp06NChQ4cOHSJKddYMgwaAJUjCqGdnzr4Wr6K6m4ZRLv+U1G7yonDV3mm5xEi7cm2jJr0kSU9KFCdv4KsDjYObrFdKiaBGdf40ufkvg4EriqX+YgsYptOTP6/x03wPPdpSWPwsEcLZRkSoOvUjsvQlBL/VuT5fWX1nFrGragNI0YhkNcgCe6JM8vOFmmQKtAvsjXKGT2N4YpANe6L4q1NIVwmyqhvK1hmsdlcM9CkmlH5TFHsNDocYDCib+5fS19hAp2JC2dYo5w9zgBfsOsFGRsHokEasIrMEvTViZSlAr1pFFayevjDKZStWEhpFruZe+AzoxHpCoxixluo+JefS43Be6UFqRLdaW+2KgaIA3Wp9dYAka3CMldhIFZKswKEbsZnqGUm4OXqxqRyS8HIYsbHMB8nLc9xIXp6DmaQmctBJRp4cE7KHEzspVBMD2zuZxW7STP5gg5c2YjfVoTKy5ECX7xzU8Zw+xkvFEeid2FWdRKcgDa6t2FltmP2SA8SJ3RXe55k4EkIjdleNYZKfwytRgEKYaJJjGVGEQphYgmONohDpd+dqXtyx3lXJ3MylCnKsW6nkRbpCxhIFCfLi3X6k7oJ0yfuLIFTPRUnn+IjliXTvYAkae0WPd6yXCAahbNBxbRU4TMGbGqQekYJlxlpLTKRbGsQtf+mNIwXDlgbBgQh8c7ep5skmSSxURg6D9F9K5xo4TOLSxhJPNAi+jdPXYQDIiSvNrj3LGPL+TIGq8WfiWDInObfnBhEsID4lA9vgBGWCBIdtE37Xlgpi4sNd0UO9ewbSiUxhqHWEFBet+jzI5RnIAv25poW7iR7VLa1T8znIu+YzZfYO0Z7VZLY4BoofQYKgV/m+pSKJdZ4xsH35GUiAJfQz6ci8pfM8y+sbhfPPs5Z3EIFCfdN1Vs5SPVLEpF8/QDZKFXw/auj8lRsbemqixxH7iZLcFglRhYdLr7M83LXNRoOgN4JNL4FdVIiccuaz2qeP7BfI8S8bFSQYIknmkDavRLGQ3iBZxxSOPrFgnLBvNgcEuxhNYpB0EbltTmh8wfeZB4INc1olzZfaiEBqEzs1XUOsfk1im1kbkZB0wpyqkyE6PK2Mx6CXsQ8+RQwRMr7QshJb0YggohqDUWz8kCgjEkIkx4dbcU2sTErIyx/rRh9ZMeKDM0DoJCOmrSfeN8dzWM6pro0n6X90QxO5r94hBxuI8CHofkcWKYYn+xrk4ADBNGh48u8cXWkZ5KCDIImJTjQD1zDSrbEcVMXvwunYdFDoutZtIIEfyzH1P4CEgf1/AOF5mIVnIMC0HLs6iAVcv2q+XdcC+wIgXZiI4xrBY8n6UbKXDmJwpdE9br0NuNJoigZR+u6v9OHVnz8wLnBbDPg8AarKBfESz/Y92Z6uhgUZ6SD848iEE/gfGgYsUNwLp038IBgec/NjCwcaxZQ4sn87Mar6q1XA+dh5VOQs4ldE0ZjNIRPc/iSfkFCKRpx6ZXNAl9bzHkGSPpFFkDbrf8azAIkk58ztt7eIqW6eRSRyJJCY3JYUEzH1yiPpchqsp+xDRqeIdJClivcfEXISruEVL5w2Pf2VUm5XIgzs2GTFpdpoWBbJeCcYDiOp+ZdWDRM21QnZF5e+WNRK5OA50o9Ja4qoYkDwyCwo1lscIGJlteZbR2nx9rAu1O3otAztq0kdHPQTjHJCN2M4TYj1kE7Zjad3y8ru8ZgUXT3Getz+NN3+04Or0bwWhwhPaIci94dperxjQxlXO1RcrBE6wQgdHLyPk7iu/zDTpr+iidIORV+wiUibnA1l8O5b5YJgezVbi3DqekzHMkfQ0aceOqpvYc5IjFJ6ezUhTSbYFTBKaZ71K2EIGFlisn0YECsOl7UpB4A8g289ligDy6nKKqXe1yynhGX7tWisOOqsIe1okmK6tcx2QqhWhx8mllD/neYWrsSJVY+hHp0aZMM91Z146kWbmhuMYLqdlO/m0z65WjNoEiLKpOWygMa+8c0Mghn4TRQmNEhKyilvyRENkn4xQVFCgyRv3VxEQTplXo2iS7y8AkS6fInXiVTZFxMUE+9V/l10tSwp3oFw85ot4pawO8eyxClFAULHylIlS7ooDCpK6i6jUnHBsY7L9IJNCwiTjnrnJYaJEjtKActs3xIvy2G63NYyZXAtdtPMVir11Ouw6Qlr5rHtuOvFxYxDWbX3VdKVEC9OcuN4cRLkYCTZoVjpkYObZN7ykwT6W45iP9rwL6kROZhJtv5sB3Lwk2xWC7d4MptbeJ/A21aftuk5HkS6CoDuVqtneyvXf0YrIz7/VP73spReIsOc7r9rGsXIjeIQzxXBSbDrAkvCMZRiP/dH+DwhwSiIwuizyVFe3pcxayMJtwKTUIARRbkrhv4ttpcFpi8uX0JsEI5Y8qGAVfk+NRIaCvhRFm3rDIoWP9lsGrGr7LggS5JdFFIs2or95e/6NMb+HAVTWwfYpDL/FmWosuOCgnm61E8McW4HWFB6KmADBlWFN4ySenbT+dKpK5JS6mJbN4xyuReYIjbEHvpnliTpqZg947/VeBcHI7XzRXnUd/KT0/IJwzhMXfEQd7Y5GTfrEa5IAKCHwdiuWG86dOjQoUOHDh06dOhl9Aea9iC3qxu2fAAAAABJRU5ErkJggg==", false, 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.3.4
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.3.4.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.marginTop(24.0f);
                                                                    ceVar2.text("\u7f51\u7edc\u5f02\u5e38\uff0c\u70b9\u51fb\u91cd\u8bd5");
                                                                    NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 13.0f, null, 2, null, "text_primary");
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        } else if (valueOf != null && valueOf.intValue() == 2) {
                                            final NBPInteractiveUsersPage nBPInteractiveUsersPage14 = NBPInteractiveUsersPage.this;
                                            Function0<com.tencent.kuikly.core.reactive.collection.c<j>> function02 = new Function0<com.tencent.kuikly.core.reactive.collection.c<j>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.4
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final com.tencent.kuikly.core.reactive.collection.c<j> invoke() {
                                                    NBPInteractiveViewModel nBPInteractiveViewModel2 = NBPInteractiveUsersPage.this.viewModel;
                                                    com.tencent.kuikly.core.reactive.collection.c<j> userList = nBPInteractiveViewModel2 != null ? nBPInteractiveViewModel2.getUserList() : null;
                                                    Intrinsics.checkNotNull(userList);
                                                    return userList;
                                                }
                                            };
                                            final NBPInteractiveUsersPage nBPInteractiveUsersPage15 = NBPInteractiveUsersPage.this;
                                            LoopDirectivesViewKt.b(bindDirectivesView2, function02, new Function4<LoopDirectivesView<j>, j, Integer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.5
                                                {
                                                    super(4);
                                                }

                                                @Override // kotlin.jvm.functions.Function4
                                                public final Unit invoke(LoopDirectivesView<j> loopDirectivesView, j jVar, Integer num, Integer num2) {
                                                    final int intValue = num.intValue();
                                                    num2.intValue();
                                                    final NBPInteractiveUsersPage nBPInteractiveUsersPage16 = NBPInteractiveUsersPage.this;
                                                    loopDirectivesView.addChild(new NBPInteractiveUserItemView(), new Function1<NBPInteractiveUserItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.5.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NBPInteractiveUserItemView nBPInteractiveUserItemView) {
                                                            final NBPInteractiveUsersPage nBPInteractiveUsersPage17 = NBPInteractiveUsersPage.this;
                                                            final int i3 = intValue;
                                                            nBPInteractiveUserItemView.attr(new Function1<NBPInteractiveUserItemViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.5.1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NBPInteractiveUserItemViewAttr nBPInteractiveUserItemViewAttr) {
                                                                    NBPInteractiveUserItemViewAttr nBPInteractiveUserItemViewAttr2 = nBPInteractiveUserItemViewAttr;
                                                                    nBPInteractiveUserItemViewAttr2.viewModel = NBPInteractiveUsersPage.this.viewModel;
                                                                    nBPInteractiveUserItemViewAttr2.index = i3;
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPInteractiveUsersPage nBPInteractiveUsersPage16 = NBPInteractiveUsersPage.this;
                                            Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.6
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
                                                
                                                    if ((!r0.isEmpty()) == true) goto L10;
                                                 */
                                                @Override // kotlin.jvm.functions.Function0
                                                /*
                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                */
                                                public final Object invoke() {
                                                    NBPInteractiveViewModel nBPInteractiveViewModel2 = NBPInteractiveUsersPage.this.viewModel;
                                                    boolean z16 = (nBPInteractiveViewModel2 == null || (r0 = nBPInteractiveViewModel2.getUserList()) == null) ? false : true;
                                                    return Boolean.valueOf(z16);
                                                }
                                            };
                                            final NBPInteractiveUsersPage nBPInteractiveUsersPage17 = NBPInteractiveUsersPage.this;
                                            ConditionViewKt.c(bindDirectivesView2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.7
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ConditionView conditionView) {
                                                    final NBPInteractiveUsersPage nBPInteractiveUsersPage18 = NBPInteractiveUsersPage.this;
                                                    z.a(conditionView, new Function1<FooterRefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.7.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(FooterRefreshView footerRefreshView) {
                                                            FooterRefreshView footerRefreshView2 = footerRefreshView;
                                                            final NBPInteractiveUsersPage nBPInteractiveUsersPage19 = NBPInteractiveUsersPage.this;
                                                            footerRefreshView2.ref(footerRefreshView2, new Function1<aa<FooterRefreshView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.7.1.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(aa<FooterRefreshView> aaVar) {
                                                                    NBPInteractiveUsersPage.this.footerRefreshRef = aaVar;
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            footerRefreshView2.attr(new Function1<x, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.7.1.2
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(x xVar) {
                                                                    x xVar2 = xVar;
                                                                    xVar2.allCenter();
                                                                    xVar2.mo141height(40.0f);
                                                                    xVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPInteractiveUsersPage nBPInteractiveUsersPage20 = NBPInteractiveUsersPage.this;
                                                            footerRefreshView2.event(new Function1<y, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.7.1.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(y yVar) {
                                                                    y yVar2 = yVar;
                                                                    final NBPInteractiveUsersPage nBPInteractiveUsersPage21 = NBPInteractiveUsersPage.this;
                                                                    yVar2.i(new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.7.1.3.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(FooterRefreshState footerRefreshState) {
                                                                            final NBPInteractiveUsersPage nBPInteractiveUsersPage22 = NBPInteractiveUsersPage.this;
                                                                            KProperty<Object>[] kPropertyArr = NBPInteractiveUsersPage.$$delegatedProperties;
                                                                            nBPInteractiveUsersPage22.getClass();
                                                                            int i3 = NBPInteractiveUsersPage.WhenMappings.$EnumSwitchMapping$0[footerRefreshState.ordinal()];
                                                                            if (i3 == 1) {
                                                                                nBPInteractiveUsersPage22.setFooterRefreshText("");
                                                                            } else if (i3 == 2) {
                                                                                nBPInteractiveUsersPage22.setFooterRefreshText("\u6b63\u5728\u52a0\u8f7d...");
                                                                                final NBPInteractiveViewModel nBPInteractiveViewModel2 = nBPInteractiveUsersPage22.viewModel;
                                                                                if (nBPInteractiveViewModel2 != null) {
                                                                                    final Function2<FooterRefreshEndState, Boolean, Unit> function2 = new Function2<FooterRefreshEndState, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage$footerStateChanged$1

                                                                                        /* loaded from: classes31.dex */
                                                                                        public /* synthetic */ class WhenMappings {
                                                                                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                                                                            static {
                                                                                                int[] iArr = new int[FooterRefreshEndState.values().length];
                                                                                                try {
                                                                                                    iArr[FooterRefreshEndState.SUCCESS.ordinal()] = 1;
                                                                                                } catch (NoSuchFieldError unused) {
                                                                                                }
                                                                                                try {
                                                                                                    iArr[FooterRefreshEndState.NONE_MORE_DATA.ordinal()] = 2;
                                                                                                } catch (NoSuchFieldError unused2) {
                                                                                                }
                                                                                                try {
                                                                                                    iArr[FooterRefreshEndState.FAILURE.ordinal()] = 3;
                                                                                                } catch (NoSuchFieldError unused3) {
                                                                                                }
                                                                                                $EnumSwitchMapping$0 = iArr;
                                                                                            }
                                                                                        }

                                                                                        {
                                                                                            super(2);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function2
                                                                                        public final Unit invoke(FooterRefreshEndState footerRefreshEndState, Boolean bool) {
                                                                                            FooterRefreshView b16;
                                                                                            FooterRefreshView b17;
                                                                                            FooterRefreshView b18;
                                                                                            aa<FooterRefreshView> aaVar;
                                                                                            FooterRefreshView b19;
                                                                                            boolean booleanValue = bool.booleanValue();
                                                                                            int i16 = WhenMappings.$EnumSwitchMapping$0[footerRefreshEndState.ordinal()];
                                                                                            if (i16 != 1) {
                                                                                                if (i16 == 2) {
                                                                                                    aa<FooterRefreshView> aaVar2 = NBPInteractiveUsersPage.this.footerRefreshRef;
                                                                                                    if (aaVar2 != null && (b18 = aaVar2.b()) != null) {
                                                                                                        b18.t(FooterRefreshEndState.NONE_MORE_DATA);
                                                                                                    }
                                                                                                } else if (i16 == 3 && (aaVar = NBPInteractiveUsersPage.this.footerRefreshRef) != null && (b19 = aaVar.b()) != null) {
                                                                                                    b19.t(FooterRefreshEndState.FAILURE);
                                                                                                }
                                                                                            } else if (booleanValue) {
                                                                                                aa<FooterRefreshView> aaVar3 = NBPInteractiveUsersPage.this.footerRefreshRef;
                                                                                                if (aaVar3 != null && (b17 = aaVar3.b()) != null) {
                                                                                                    b17.t(FooterRefreshEndState.NONE_MORE_DATA);
                                                                                                }
                                                                                            } else {
                                                                                                aa<FooterRefreshView> aaVar4 = NBPInteractiveUsersPage.this.footerRefreshRef;
                                                                                                if (aaVar4 != null && (b16 = aaVar4.b()) != null) {
                                                                                                    b16.t(FooterRefreshEndState.SUCCESS);
                                                                                                }
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    };
                                                                                    boolean z16 = nBPInteractiveViewModel2.isEnd;
                                                                                    if (z16) {
                                                                                        function2.invoke(FooterRefreshEndState.NONE_MORE_DATA, Boolean.valueOf(z16));
                                                                                    } else if (!nBPInteractiveViewModel2.isRequesting) {
                                                                                        nBPInteractiveViewModel2.isRequesting = true;
                                                                                        int j3 = nBPInteractiveViewModel2.pageData.n().j("mid");
                                                                                        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("fetchMoreInteractiveUserList mid:", j3, ", cookie:"), nBPInteractiveViewModel2.cookie.f30291a.length, KLog.INSTANCE, "NBPInteractivePage");
                                                                                        NBPInteractiveRepo.fetchInteractUserList$default(j3, nBPInteractiveViewModel2.cookie, new Function1<g, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view_model.NBPInteractiveViewModel$fetchMoreInteractiveUserList$1
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(g gVar) {
                                                                                                List<j> list;
                                                                                                g gVar2 = gVar;
                                                                                                if (gVar2 != null) {
                                                                                                    NBPInteractiveViewModel nBPInteractiveViewModel3 = NBPInteractiveViewModel.this;
                                                                                                    nBPInteractiveViewModel3.isEnd = gVar2.f411549e;
                                                                                                    nBPInteractiveViewModel3.cookie = gVar2.f411550f;
                                                                                                    nBPInteractiveViewModel3.getUserList().addAll(gVar2.f411548d);
                                                                                                    function2.invoke(FooterRefreshEndState.SUCCESS, Boolean.valueOf(NBPInteractiveViewModel.this.isEnd));
                                                                                                } else {
                                                                                                    function2.invoke(FooterRefreshEndState.FAILURE, Boolean.valueOf(NBPInteractiveViewModel.this.isEnd));
                                                                                                }
                                                                                                KLog kLog = KLog.INSTANCE;
                                                                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchMoreInteractiveUserList size:");
                                                                                                m3.append((gVar2 == null || (list = gVar2.f411548d) == null) ? null : Integer.valueOf(list.size()));
                                                                                                m3.append(", isEnd:");
                                                                                                m3.append(gVar2 != null ? Boolean.valueOf(gVar2.f411549e) : null);
                                                                                                m3.append(", cookie:");
                                                                                                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, NBPInteractiveViewModel.this.cookie.f30291a.length, kLog, "NBPInteractivePage");
                                                                                                NBPInteractiveViewModel.this.isRequesting = false;
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                    }
                                                                                }
                                                                            } else if (i3 == 3) {
                                                                                nBPInteractiveUsersPage22.setFooterRefreshText("");
                                                                            } else if (i3 == 4) {
                                                                                nBPInteractiveUsersPage22.setFooterRefreshText("");
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final NBPInteractiveUsersPage nBPInteractiveUsersPage22 = NBPInteractiveUsersPage.this;
                                                                    yVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.7.1.3.2
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            aa<FooterRefreshView> aaVar;
                                                                            FooterRefreshView b16;
                                                                            FooterRefreshView b17;
                                                                            aa<FooterRefreshView> aaVar2 = NBPInteractiveUsersPage.this.footerRefreshRef;
                                                                            if (((aaVar2 == null || (b17 = aaVar2.b()) == null) ? null : b17.getRefreshState()) == FooterRefreshState.FAILURE && (aaVar = NBPInteractiveUsersPage.this.footerRefreshRef) != null && (b16 = aaVar.b()) != null) {
                                                                                b16.p();
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPInteractiveUsersPage nBPInteractiveUsersPage21 = NBPInteractiveUsersPage.this;
                                                            w.a(footerRefreshView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.7.1.4
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar) {
                                                                    v vVar2 = vVar;
                                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.7.1.4.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.flexDirectionRow();
                                                                            tVar2.allCenter();
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final NBPInteractiveUsersPage nBPInteractiveUsersPage22 = NBPInteractiveUsersPage.this;
                                                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.7.1.4.2
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(TextView textView) {
                                                                            final NBPInteractiveUsersPage nBPInteractiveUsersPage23 = NBPInteractiveUsersPage.this;
                                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.6.7.1.4.2.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ce ceVar) {
                                                                                    ce ceVar2 = ceVar;
                                                                                    ce.fontSize$default(ceVar2.fontWeight400(), 15.0f, null, 2, null);
                                                                                    ceVar2.color(new h(4288256409L));
                                                                                    NBPInteractiveUsersPage nBPInteractiveUsersPage24 = NBPInteractiveUsersPage.this;
                                                                                    ceVar2.value((String) nBPInteractiveUsersPage24.footerRefreshText$delegate.getValue(nBPInteractiveUsersPage24, NBPInteractiveUsersPage.$$delegatedProperties[0]));
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
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.7.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(10.0f);
                                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.7.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.3.7.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo141height(600.0f);
                                                        tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
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
                        final NBPInteractiveUsersPage nBPInteractiveUsersPage6 = NBPInteractiveUsersPage.this;
                        w.a(eCTransitionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final NBPInteractiveUsersPage nBPInteractiveUsersPage7 = NBPInteractiveUsersPage.this;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        tVar2.m138bottom(36.0f);
                                        tVar2.m142left((NBPInteractiveUsersPage.this.getPageData().m() - 156.0f) / 2.0f);
                                        tVar2.size(156.0f, 56.0f);
                                        tVar2.borderRadius(32.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.mo113backgroundColor(QUIToken.color$default("brand_standard"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPInteractiveUsersPage nBPInteractiveUsersPage8 = NBPInteractiveUsersPage.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        u uVar2 = uVar;
                                        final NBPInteractiveUsersPage nBPInteractiveUsersPage9 = NBPInteractiveUsersPage.this;
                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                if (!NBPInteractiveUsersPage.this.fastClickUtils.isFastDoubleClick()) {
                                                    QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                                                    final NBPInteractiveUsersPage nBPInteractiveUsersPage10 = NBPInteractiveUsersPage.this;
                                                    companion.asyncToNativeMethod("popToNBPMainPage", (e) null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.4.2.1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(e eVar) {
                                                            NBPJumpUtil.jumpMoodGroupPage$default(5, NBPInteractiveUsersPage.this.getPageData().n().j("mid"), 0, null, false, 24);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    NBPInteractiveUsersPage nBPInteractiveUsersPage11 = NBPInteractiveUsersPage.this;
                                                    NBPInteractiveViewModel nBPInteractiveViewModel = nBPInteractiveUsersPage11.viewModel;
                                                    if (nBPInteractiveViewModel != null) {
                                                        nBPInteractiveViewModel.reportInteractive("dt_clck", "em_nearby_back_circle", nBPInteractiveUsersPage11.getPageData().n().q("source", "1"), Integer.valueOf(NBPInteractiveUsersPage.this.getPageData().n().j("mid")));
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPInteractiveUsersPage nBPInteractiveUsersPage10 = NBPInteractiveUsersPage.this;
                                        VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.4.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                NBPInteractiveUsersPage nBPInteractiveUsersPage11 = NBPInteractiveUsersPage.this;
                                                NBPInteractiveViewModel nBPInteractiveViewModel = nBPInteractiveUsersPage11.viewModel;
                                                if (nBPInteractiveViewModel != null) {
                                                    nBPInteractiveViewModel.reportInteractive("dt_imp", "em_nearby_back_circle", nBPInteractiveUsersPage11.getPageData().n().q("source", "1"), Integer.valueOf(NBPInteractiveUsersPage.this.getPageData().n().j("mid")));
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPInteractiveUsersPage nBPInteractiveUsersPage9 = NBPInteractiveUsersPage.this;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPInteractiveUsersPage nBPInteractiveUsersPage10 = NBPInteractiveUsersPage.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.4.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.margin(0.0f, 16.0f, 0.0f, 16.0f);
                                                afVar2.size(32.0f, 32.0f);
                                                b.a.b(afVar2, NBPInteractiveUsersPage.this.getPageData().n().p("icon"), false, 2, null);
                                                afVar2.p();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.4.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage.body.1.3.4.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.fontWeight500();
                                                ceVar2.color(QUIToken.color$default("text_allwhite_primary"));
                                                ceVar2.text("\u56de\u5230\u5708\u5b50");
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

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        this.listViewHeight = getPageData().l() - 220.0f;
        NBPInteractiveViewModel nBPInteractiveViewModel = new NBPInteractiveViewModel(getPageData());
        nBPInteractiveViewModel.fetchFirstInteractiveUserList();
        this.viewModel = nBPInteractiveViewModel;
        this.closeMsgPageNotification = k.b((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule"), "NEARBY_CLOSE_MSG_PAGE_EVENT", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractiveUsersPage$created$2
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.closePage$default();
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    public final void setFooterRefreshText(String str) {
        this.footerRefreshText$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDestroyed() {
        super.viewDestroyed();
        String str = this.closeMsgPageNotification;
        if (str != null) {
            ((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule")).e("NEARBY_CLOSE_MSG_PAGE_EVENT", str);
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLayout() {
        super.viewDidLayout();
        this.startingOpenPageAnimate$delegate.setValue(this, $$delegatedProperties[2], Boolean.TRUE);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        String q16 = getPageData().n().q("source", "1");
        int j3 = getPageData().n().j("mid");
        NBPInteractiveViewModel nBPInteractiveViewModel = this.viewModel;
        if (nBPInteractiveViewModel != null) {
            nBPInteractiveViewModel.reportInteractive("dt_imp", "em_nearby_interaction_pop", q16, Integer.valueOf(j3));
        }
    }
}
