package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.Tacit;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import s35.y;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TacitAgreementView extends ComposeView<NBPTacitAgreementAttr, NBPTacitAgreementEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPTacitAgreementAttr access$getAttr(TacitAgreementView tacitAgreementView) {
        return (NBPTacitAgreementAttr) tacitAgreementView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$report(TacitAgreementView tacitAgreementView) {
        e eVar;
        String str;
        c<y> tacitGuestList;
        c<Tacit> tacitMyList;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((NBPTacitAgreementAttr) tacitAgreementView.getAttr()).viewModel;
        int i3 = 0;
        boolean z16 = nBPHomePageBaseViewModel != null && nBPHomePageBaseViewModel.isSelf;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((NBPTacitAgreementAttr) tacitAgreementView.getAttr()).viewModel;
        if (!(nBPHomePageBaseViewModel2 != null && nBPHomePageBaseViewModel2.tacitFaqGuestNotAnswer())) {
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = ((NBPTacitAgreementAttr) tacitAgreementView.getAttr()).viewModel;
            if (!(nBPHomePageBaseViewModel3 != null && nBPHomePageBaseViewModel3.tacitFaqOwnerNotAnswer())) {
                if (z16) {
                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = ((NBPTacitAgreementAttr) tacitAgreementView.getAttr()).viewModel;
                    if (nBPHomePageBaseViewModel4 != null && (tacitMyList = nBPHomePageBaseViewModel4.getTacitMyList()) != null) {
                        i3 = tacitMyList.size();
                    }
                } else {
                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel5 = ((NBPTacitAgreementAttr) tacitAgreementView.getAttr()).viewModel;
                    if (nBPHomePageBaseViewModel5 != null && (tacitGuestList = nBPHomePageBaseViewModel5.getTacitGuestList()) != null) {
                        i3 = tacitGuestList.size();
                    }
                }
            }
        }
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel6 = ((NBPTacitAgreementAttr) tacitAgreementView.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel6 != null) {
            e jsonWithHomePagePgParams = nBPHomePageBaseViewModel6.jsonWithHomePagePgParams();
            jsonWithHomePagePgParams.v("dt_eid", "em_bas_tacit_answer");
            if (!z16) {
                NBPHomePageBaseViewModel nBPHomePageBaseViewModel7 = ((NBPTacitAgreementAttr) tacitAgreementView.getAttr()).viewModel;
                if (nBPHomePageBaseViewModel7 == null || (str = nBPHomePageBaseViewModel7.getTacitGuestTitle()) == null) {
                    str = "";
                }
                jsonWithHomePagePgParams.v("default_value", str);
            }
            jsonWithHomePagePgParams.t("cards_number", i3);
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel8 = ((NBPTacitAgreementAttr) tacitAgreementView.getAttr()).viewModel;
            if (nBPHomePageBaseViewModel8 != null) {
                eVar = nBPHomePageBaseViewModel8.jsonWithHomePagePgParams();
            } else {
                eVar = new e();
            }
            jsonWithHomePagePgParams.v("cur_pg", eVar);
            jsonWithHomePagePgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithHomePagePgParams);
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m154zIndex(1);
                        mVar2.flexDirectionColumn();
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementView tacitAgreementView = TacitAgreementView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final TacitAgreementView tacitAgreementView2 = TacitAgreementView.this;
                        VisibilityEventKt.b(event, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                TacitAgreementView.access$report(TacitAgreementView.this);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementView tacitAgreementView2 = TacitAgreementView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView$body$1.3
                    {
                        super(0);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
                    
                        if (r0.isSelf == true) goto L8;
                     */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invoke() {
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
                        boolean z16 = nBPHomePageBaseViewModel != null;
                        return Boolean.valueOf(z16);
                    }
                };
                final TacitAgreementView tacitAgreementView3 = TacitAgreementView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final TacitAgreementView tacitAgreementView4 = TacitAgreementView.this;
                        conditionView.addChild(new TacitAgreementTitleView(), new Function1<TacitAgreementTitleView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TacitAgreementTitleView tacitAgreementTitleView) {
                                final TacitAgreementView tacitAgreementView5 = TacitAgreementView.this;
                                tacitAgreementTitleView.attr(new Function1<TacitAgreementTitleAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TacitAgreementTitleAttr tacitAgreementTitleAttr) {
                                        tacitAgreementTitleAttr.viewModel = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementView tacitAgreementView4 = TacitAgreementView.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
                        return Boolean.valueOf((nBPHomePageBaseViewModel != null ? nBPHomePageBaseViewModel.getUserInfo() : null) != null);
                    }
                };
                final TacitAgreementView tacitAgreementView5 = TacitAgreementView.this;
                ConditionViewKt.b(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final TacitAgreementView tacitAgreementView6 = TacitAgreementView.this;
                        conditionView.addChild(new TacitAgreementTitleGuestView(), new Function1<TacitAgreementTitleGuestView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.6.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TacitAgreementTitleGuestView tacitAgreementTitleGuestView) {
                                final TacitAgreementView tacitAgreementView7 = TacitAgreementView.this;
                                tacitAgreementTitleGuestView.attr(new Function1<TacitAgreementTitleGuestAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.6.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TacitAgreementTitleGuestAttr tacitAgreementTitleGuestAttr) {
                                        tacitAgreementTitleGuestAttr.viewModel = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementView tacitAgreementView6 = TacitAgreementView.this;
                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView$body$1.7
                    {
                        super(0);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
                    
                        if ((r0 != null && r0.tacitFaqOwnerNotAnswer()) != false) goto L16;
                     */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invoke() {
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
                        boolean z16 = false;
                        if (!(nBPHomePageBaseViewModel != null && nBPHomePageBaseViewModel.tacitFaqGuestNotAnswer())) {
                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
                        }
                        z16 = true;
                        return Boolean.valueOf(z16);
                    }
                };
                final TacitAgreementView tacitAgreementView7 = TacitAgreementView.this;
                ConditionViewKt.c(viewContainer2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView$body$1.8
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final TacitAgreementView tacitAgreementView8 = TacitAgreementView.this;
                        conditionView.addChild(new TacitFaqView(), new Function1<TacitFaqView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.8.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TacitFaqView tacitFaqView) {
                                final TacitAgreementView tacitAgreementView9 = TacitAgreementView.this;
                                tacitFaqView.attr(new Function1<TacitFaqAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.8.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TacitFaqAttr tacitFaqAttr) {
                                        tacitFaqAttr.viewModel = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementView tacitAgreementView8 = TacitAgreementView.this;
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView$body$1.9
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        final TacitAgreementView tacitAgreementView9 = TacitAgreementView.this;
                        Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.1
                            {
                                super(0);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
                            
                                if (r0.isSelf == true) goto L8;
                             */
                            @Override // kotlin.jvm.functions.Function0
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object invoke() {
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
                                boolean z16 = nBPHomePageBaseViewModel != null;
                                return Boolean.valueOf(z16);
                            }
                        };
                        final TacitAgreementView tacitAgreementView10 = TacitAgreementView.this;
                        ConditionViewKt.c(conditionView2, function04, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView3) {
                                final TacitAgreementView tacitAgreementView11 = TacitAgreementView.this;
                                Function0<Object> function05 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.2.1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
                                    
                                        if ((!r0.isEmpty()) == true) goto L10;
                                     */
                                    @Override // kotlin.jvm.functions.Function0
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Object invoke() {
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
                                        boolean z16 = (nBPHomePageBaseViewModel == null || (r0 = nBPHomePageBaseViewModel.getTacitMyList()) == null) ? false : true;
                                        return Boolean.valueOf(z16);
                                    }
                                };
                                final TacitAgreementView tacitAgreementView12 = TacitAgreementView.this;
                                ConditionViewKt.c(conditionView3, function05, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView4) {
                                        final TacitAgreementView tacitAgreementView13 = TacitAgreementView.this;
                                        ar.a(conditionView4, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aq<?, ?> aqVar) {
                                                aq<?, ?> aqVar2 = aqVar;
                                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.2.2.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ao aoVar) {
                                                        ao aoVar2 = aoVar;
                                                        aoVar2.mo141height(132.0f);
                                                        aoVar2.showScrollerIndicator(false);
                                                        aoVar2.flexDirectionRow();
                                                        aoVar2.alignItemsCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final TacitAgreementView tacitAgreementView14 = TacitAgreementView.this;
                                                Function0<c<Tacit>> function06 = new Function0<c<Tacit>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.2.2.1.2
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final c<Tacit> invoke() {
                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
                                                        c<Tacit> tacitMyList = nBPHomePageBaseViewModel != null ? nBPHomePageBaseViewModel.getTacitMyList() : null;
                                                        Intrinsics.checkNotNull(tacitMyList);
                                                        return tacitMyList;
                                                    }
                                                };
                                                final TacitAgreementView tacitAgreementView15 = TacitAgreementView.this;
                                                LoopDirectivesViewKt.a(aqVar2, function06, new Function2<LoopDirectivesView<Tacit>, Tacit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.2.2.1.3
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Unit invoke(LoopDirectivesView<Tacit> loopDirectivesView, Tacit tacit) {
                                                        final Tacit tacit2 = tacit;
                                                        final TacitAgreementView tacitAgreementView16 = TacitAgreementView.this;
                                                        loopDirectivesView.addChild(new TacitAgreementCardView(), new Function1<TacitAgreementCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.2.2.1.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TacitAgreementCardView tacitAgreementCardView) {
                                                                final TacitAgreementView tacitAgreementView17 = TacitAgreementView.this;
                                                                final Tacit tacit3 = tacit2;
                                                                tacitAgreementCardView.attr(new Function1<TacitAgreementCardViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.2.2.1.3.1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TacitAgreementCardViewAttr tacitAgreementCardViewAttr) {
                                                                        c<Tacit> tacitMyList;
                                                                        c<Tacit> tacitMyList2;
                                                                        TacitAgreementCardViewAttr tacitAgreementCardViewAttr2 = tacitAgreementCardViewAttr;
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
                                                                        Integer valueOf = (nBPHomePageBaseViewModel == null || (tacitMyList2 = nBPHomePageBaseViewModel.getTacitMyList()) == null) ? null : Integer.valueOf(tacitMyList2.indexOf(tacit3));
                                                                        boolean z16 = valueOf != null && valueOf.intValue() == 0;
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
                                                                        boolean z17 = valueOf != null && valueOf.intValue() == ((nBPHomePageBaseViewModel2 == null || (tacitMyList = nBPHomePageBaseViewModel2.getTacitMyList()) == null) ? 0 : tacitMyList.size()) - 1;
                                                                        tacitAgreementCardViewAttr2.marginLeft(z16 ? 16.0f : 4.0f);
                                                                        if (z17) {
                                                                            tacitAgreementCardViewAttr2.marginRight(16.0f);
                                                                        }
                                                                        tacitAgreementCardViewAttr2.data$delegate.setValue(tacitAgreementCardViewAttr2, TacitAgreementCardViewAttr.$$delegatedProperties[0], tacit3);
                                                                        tacitAgreementCardViewAttr2.viewModel = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
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
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitAgreementView tacitAgreementView11 = TacitAgreementView.this;
                        ConditionViewKt.a(conditionView2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView3) {
                                final TacitAgreementView tacitAgreementView12 = TacitAgreementView.this;
                                Function0<Object> function05 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.3.1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
                                    
                                        if ((!r0.isEmpty()) == true) goto L10;
                                     */
                                    @Override // kotlin.jvm.functions.Function0
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Object invoke() {
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
                                        boolean z16 = (nBPHomePageBaseViewModel == null || (r0 = nBPHomePageBaseViewModel.getTacitGuestList()) == null) ? false : true;
                                        return Boolean.valueOf(z16);
                                    }
                                };
                                final TacitAgreementView tacitAgreementView13 = TacitAgreementView.this;
                                ConditionViewKt.c(conditionView3, function05, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView4) {
                                        final TacitAgreementView tacitAgreementView14 = TacitAgreementView.this;
                                        ar.a(conditionView4, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aq<?, ?> aqVar) {
                                                aq<?, ?> aqVar2 = aqVar;
                                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.3.2.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ao aoVar) {
                                                        ao aoVar2 = aoVar;
                                                        aoVar2.mo141height(108.0f);
                                                        aoVar2.showScrollerIndicator(false);
                                                        aoVar2.flexDirectionRow();
                                                        aoVar2.alignItemsCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final TacitAgreementView tacitAgreementView15 = TacitAgreementView.this;
                                                Function0<c<y>> function06 = new Function0<c<y>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.3.2.1.2
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final c<y> invoke() {
                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
                                                        c<y> tacitGuestList = nBPHomePageBaseViewModel != null ? nBPHomePageBaseViewModel.getTacitGuestList() : null;
                                                        Intrinsics.checkNotNull(tacitGuestList);
                                                        return tacitGuestList;
                                                    }
                                                };
                                                final TacitAgreementView tacitAgreementView16 = TacitAgreementView.this;
                                                LoopDirectivesViewKt.a(aqVar2, function06, new Function2<LoopDirectivesView<y>, y, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.3.2.1.3
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Unit invoke(LoopDirectivesView<y> loopDirectivesView, y yVar) {
                                                        final y yVar2 = yVar;
                                                        final TacitAgreementView tacitAgreementView17 = TacitAgreementView.this;
                                                        loopDirectivesView.addChild(new TacitAgreementGuestCardView(), new Function1<TacitAgreementGuestCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.3.2.1.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TacitAgreementGuestCardView tacitAgreementGuestCardView) {
                                                                final TacitAgreementView tacitAgreementView18 = TacitAgreementView.this;
                                                                final y yVar3 = yVar2;
                                                                tacitAgreementGuestCardView.attr(new Function1<TacitAgreementGuestCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.9.3.2.1.3.1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TacitAgreementGuestCardAttr tacitAgreementGuestCardAttr) {
                                                                        c<y> tacitGuestList;
                                                                        c<y> tacitGuestList2;
                                                                        TacitAgreementGuestCardAttr tacitAgreementGuestCardAttr2 = tacitAgreementGuestCardAttr;
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
                                                                        Integer valueOf = (nBPHomePageBaseViewModel == null || (tacitGuestList2 = nBPHomePageBaseViewModel.getTacitGuestList()) == null) ? null : Integer.valueOf(tacitGuestList2.indexOf(yVar3));
                                                                        boolean z16 = valueOf != null && valueOf.intValue() == 0;
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
                                                                        boolean z17 = valueOf != null && valueOf.intValue() == ((nBPHomePageBaseViewModel2 == null || (tacitGuestList = nBPHomePageBaseViewModel2.getTacitGuestList()) == null) ? 0 : tacitGuestList.size()) - 1;
                                                                        tacitAgreementGuestCardAttr2.marginLeft(z16 ? 16.0f : 4.0f);
                                                                        if (z17) {
                                                                            tacitAgreementGuestCardAttr2.marginRight(16.0f);
                                                                        }
                                                                        tacitAgreementGuestCardAttr2.data$delegate.setValue(tacitAgreementGuestCardAttr2, TacitAgreementGuestCardAttr.$$delegatedProperties[0], yVar3);
                                                                        tacitAgreementGuestCardAttr2.viewModel = TacitAgreementView.access$getAttr(TacitAgreementView.this).viewModel;
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
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView$body$1.10
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementView.body.1.10.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.positionAbsolute();
                                tVar2.m138bottom(-3.0f);
                                tVar2.size(tVar2.getPagerData().m(), 5.0f);
                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
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
        return new NBPTacitAgreementAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPTacitAgreementEvent();
    }
}
