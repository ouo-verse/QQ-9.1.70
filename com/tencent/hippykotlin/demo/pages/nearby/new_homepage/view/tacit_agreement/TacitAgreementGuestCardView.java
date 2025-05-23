package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import s35.ab;
import s35.y;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TacitAgreementGuestCardView extends ComposeView<TacitAgreementGuestCardAttr, TacitAgreementGuestCardEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TacitAgreementGuestCardAttr access$getAttr(TacitAgreementGuestCardView tacitAgreementGuestCardView) {
        return (TacitAgreementGuestCardAttr) tacitAgreementGuestCardView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final int access$getOptionsNum(TacitAgreementGuestCardView tacitAgreementGuestCardView) {
        List<ab> list;
        y data = ((TacitAgreementGuestCardAttr) tacitAgreementGuestCardView.getAttr()).getData();
        if (data == null || (list = data.f433285f) == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$report(TacitAgreementGuestCardView tacitAgreementGuestCardView) {
        String str;
        e eVar;
        c<y> tacitGuestList;
        String tacitGuestTitle;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((TacitAgreementGuestCardAttr) tacitAgreementGuestCardView.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel != null) {
            e jsonWithHomePagePgParams = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
            jsonWithHomePagePgParams.v("dt_eid", "em_bas_tacit_understanding_problem");
            y data = ((TacitAgreementGuestCardAttr) tacitAgreementGuestCardView.getAttr()).getData();
            String str2 = "";
            if (data == null || (str = data.f433284e) == null) {
                str = "";
            }
            jsonWithHomePagePgParams.v("relation_content", str);
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((TacitAgreementGuestCardAttr) tacitAgreementGuestCardView.getAttr()).viewModel;
            if (nBPHomePageBaseViewModel2 != null && (tacitGuestTitle = nBPHomePageBaseViewModel2.getTacitGuestTitle()) != null) {
                str2 = tacitGuestTitle;
            }
            jsonWithHomePagePgParams.v("default_value", str2);
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = ((TacitAgreementGuestCardAttr) tacitAgreementGuestCardView.getAttr()).viewModel;
            jsonWithHomePagePgParams.t("cards_number", (nBPHomePageBaseViewModel3 == null || (tacitGuestList = nBPHomePageBaseViewModel3.getTacitGuestList()) == null) ? 0 : tacitGuestList.size());
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = ((TacitAgreementGuestCardAttr) tacitAgreementGuestCardView.getAttr()).viewModel;
            if (nBPHomePageBaseViewModel4 != null) {
                eVar = nBPHomePageBaseViewModel4.jsonWithHomePagePgParams();
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
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestCardView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestCardView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementGuestCardView tacitAgreementGuestCardView = TacitAgreementGuestCardView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestCardView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final TacitAgreementGuestCardView tacitAgreementGuestCardView2 = TacitAgreementGuestCardView.this;
                        VisibilityEventKt.b(event, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestCardView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                TacitAgreementGuestCardView.access$report(TacitAgreementGuestCardView.this);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementGuestCardView tacitAgreementGuestCardView2 = TacitAgreementGuestCardView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestCardView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(TacitAgreementGuestCardView.access$getOptionsNum(TacitAgreementGuestCardView.this));
                    }
                };
                final TacitAgreementGuestCardView tacitAgreementGuestCardView3 = TacitAgreementGuestCardView.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestCardView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                        int access$getOptionsNum = TacitAgreementGuestCardView.access$getOptionsNum(TacitAgreementGuestCardView.this);
                        if (access$getOptionsNum == 0) {
                            final TacitAgreementGuestCardView tacitAgreementGuestCardView4 = TacitAgreementGuestCardView.this;
                            bindDirectivesView2.addChild(new TacitAgreementGuestJudgeContentView(), new Function1<TacitAgreementGuestJudgeContentView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestCardView.body.1.4.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TacitAgreementGuestJudgeContentView tacitAgreementGuestJudgeContentView) {
                                    final TacitAgreementGuestCardView tacitAgreementGuestCardView5 = TacitAgreementGuestCardView.this;
                                    tacitAgreementGuestJudgeContentView.attr(new Function1<TacitAgreementGuestJudgeContentAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestCardView.body.1.4.1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TacitAgreementGuestJudgeContentAttr tacitAgreementGuestJudgeContentAttr) {
                                            TacitAgreementGuestJudgeContentAttr tacitAgreementGuestJudgeContentAttr2 = tacitAgreementGuestJudgeContentAttr;
                                            tacitAgreementGuestJudgeContentAttr2.data$delegate.setValue(tacitAgreementGuestJudgeContentAttr2, TacitAgreementGuestJudgeContentAttr.$$delegatedProperties[0], TacitAgreementGuestCardView.access$getAttr(TacitAgreementGuestCardView.this).getData());
                                            tacitAgreementGuestJudgeContentAttr2.viewModel = TacitAgreementGuestCardView.access$getAttr(TacitAgreementGuestCardView.this).viewModel;
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else if (access$getOptionsNum == 1 || access$getOptionsNum == 2) {
                            final TacitAgreementGuestCardView tacitAgreementGuestCardView5 = TacitAgreementGuestCardView.this;
                            bindDirectivesView2.addChild(new TacitAgreementGuestSelectContentView(), new Function1<TacitAgreementGuestSelectContentView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestCardView.body.1.4.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView) {
                                    final TacitAgreementGuestCardView tacitAgreementGuestCardView6 = TacitAgreementGuestCardView.this;
                                    tacitAgreementGuestSelectContentView.attr(new Function1<TacitAgreementGuestSelectContentAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestCardView.body.1.4.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TacitAgreementGuestSelectContentAttr tacitAgreementGuestSelectContentAttr) {
                                            TacitAgreementGuestSelectContentAttr tacitAgreementGuestSelectContentAttr2 = tacitAgreementGuestSelectContentAttr;
                                            tacitAgreementGuestSelectContentAttr2.data$delegate.setValue(tacitAgreementGuestSelectContentAttr2, TacitAgreementGuestSelectContentAttr.$$delegatedProperties[0], TacitAgreementGuestCardView.access$getAttr(TacitAgreementGuestCardView.this).getData());
                                            tacitAgreementGuestSelectContentAttr2.viewModel = TacitAgreementGuestCardView.access$getAttr(TacitAgreementGuestCardView.this).viewModel;
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
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new TacitAgreementGuestCardAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new TacitAgreementGuestCardEvent();
    }
}
