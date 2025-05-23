package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement;

import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.Tacit;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TacitAgreementCardView extends ComposeView<TacitAgreementCardViewAttr, TacitAgreementCardViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TacitAgreementCardViewAttr access$getAttr(TacitAgreementCardView tacitAgreementCardView) {
        return (TacitAgreementCardViewAttr) tacitAgreementCardView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementCardView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementCardView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                Tacit data = TacitAgreementCardView.access$getAttr(TacitAgreementCardView.this).getData();
                boolean z16 = false;
                if (data != null && data.type == 1) {
                    final TacitAgreementCardView tacitAgreementCardView = TacitAgreementCardView.this;
                    viewContainer2.addChild(new TacitAgreementJudgeContentView(), new Function1<TacitAgreementJudgeContentView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementCardView$body$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(TacitAgreementJudgeContentView tacitAgreementJudgeContentView) {
                            final TacitAgreementCardView tacitAgreementCardView2 = TacitAgreementCardView.this;
                            tacitAgreementJudgeContentView.attr(new Function1<TacitAgreementJudgeContentViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementCardView.body.1.2.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TacitAgreementJudgeContentViewAttr tacitAgreementJudgeContentViewAttr) {
                                    TacitAgreementJudgeContentViewAttr tacitAgreementJudgeContentViewAttr2 = tacitAgreementJudgeContentViewAttr;
                                    tacitAgreementJudgeContentViewAttr2.data$delegate.setValue(tacitAgreementJudgeContentViewAttr2, TacitAgreementJudgeContentViewAttr.$$delegatedProperties[0], TacitAgreementCardView.access$getAttr(TacitAgreementCardView.this).getData());
                                    tacitAgreementJudgeContentViewAttr2.viewModel = TacitAgreementCardView.access$getAttr(TacitAgreementCardView.this).viewModel;
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    Tacit data2 = TacitAgreementCardView.access$getAttr(TacitAgreementCardView.this).getData();
                    if (data2 != null && data2.type == 2) {
                        z16 = true;
                    }
                    if (z16) {
                        final TacitAgreementCardView tacitAgreementCardView2 = TacitAgreementCardView.this;
                        viewContainer2.addChild(new TacitAgreementSelectContentView(), new Function1<TacitAgreementSelectContentView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementCardView$body$1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TacitAgreementSelectContentView tacitAgreementSelectContentView) {
                                final TacitAgreementCardView tacitAgreementCardView3 = TacitAgreementCardView.this;
                                tacitAgreementSelectContentView.attr(new Function1<TacitAgreementSelectContentViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementCardView.body.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TacitAgreementSelectContentViewAttr tacitAgreementSelectContentViewAttr) {
                                        TacitAgreementSelectContentViewAttr tacitAgreementSelectContentViewAttr2 = tacitAgreementSelectContentViewAttr;
                                        tacitAgreementSelectContentViewAttr2.data$delegate.setValue(tacitAgreementSelectContentViewAttr2, TacitAgreementSelectContentViewAttr.$$delegatedProperties[0], TacitAgreementCardView.access$getAttr(TacitAgreementCardView.this).getData());
                                        tacitAgreementSelectContentViewAttr2.viewModel = TacitAgreementCardView.access$getAttr(TacitAgreementCardView.this).viewModel;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                    }
                }
                final TacitAgreementCardView tacitAgreementCardView3 = TacitAgreementCardView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementCardView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Tacit data3 = TacitAgreementCardView.access$getAttr(TacitAgreementCardView.this).getData();
                        boolean z17 = false;
                        if (data3 != null && ((Boolean) data3.showAfter$delegate.getValue(data3, Tacit.$$delegatedProperties[0])).booleanValue()) {
                            z17 = true;
                        }
                        return Boolean.valueOf(z17);
                    }
                };
                final TacitAgreementCardView tacitAgreementCardView4 = TacitAgreementCardView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementCardView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final TacitAgreementCardView tacitAgreementCardView5 = TacitAgreementCardView.this;
                        conditionView.addChild(new TacitAgreementAfterSelectView(), new Function1<TacitAgreementAfterSelectView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementCardView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TacitAgreementAfterSelectView tacitAgreementAfterSelectView) {
                                final TacitAgreementCardView tacitAgreementCardView6 = TacitAgreementCardView.this;
                                tacitAgreementAfterSelectView.attr(new Function1<TacitAgreementAfterSelectViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementCardView.body.1.5.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TacitAgreementAfterSelectViewAttr tacitAgreementAfterSelectViewAttr) {
                                        TacitAgreementAfterSelectViewAttr tacitAgreementAfterSelectViewAttr2 = tacitAgreementAfterSelectViewAttr;
                                        tacitAgreementAfterSelectViewAttr2.absolutePositionAllZero();
                                        tacitAgreementAfterSelectViewAttr2.data$delegate.setValue(tacitAgreementAfterSelectViewAttr2, TacitAgreementAfterSelectViewAttr.$$delegatedProperties[0], TacitAgreementCardView.access$getAttr(TacitAgreementCardView.this).getData());
                                        tacitAgreementAfterSelectViewAttr2.viewModel = TacitAgreementCardView.access$getAttr(TacitAgreementCardView.this).viewModel;
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
        return new TacitAgreementCardViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new TacitAgreementCardViewEvent();
    }
}
