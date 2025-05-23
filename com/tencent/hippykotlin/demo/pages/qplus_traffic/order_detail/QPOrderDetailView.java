package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail;

import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ck;
import com.tencent.kuikly.core.views.cm;
import com.tencent.kuikly.core.views.cn;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes31.dex */
public final class QPOrderDetailView extends ComposeView<QPOrderDetailAttr, l> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QPOrderDetailAttr access$getAttr(QPOrderDetailView qPOrderDetailView) {
        return (QPOrderDetailAttr) qPOrderDetailView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QPOrderDetailView qPOrderDetailView = QPOrderDetailView.this;
                cn.a(viewContainer, new Function1<cm, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(cm cmVar) {
                        cm cmVar2 = cmVar;
                        cmVar2.attr(new Function1<ck, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ck ckVar) {
                                ck ckVar2 = ckVar;
                                ckVar2.m140flex(1.0f);
                                ckVar2.alignSelfCenter();
                                ckVar2.h(1);
                                ckVar2.w(ckVar2.getPagerData().m());
                                ckVar2.mo141height(ckVar2.getPagerData().l());
                                ckVar2.showScrollerIndicator(false);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPOrderDetailView qPOrderDetailView2 = QPOrderDetailView.this;
                        int i3 = QPOrderDetailView.$r8$clinit;
                        qPOrderDetailView2.getClass();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailView$bodyWithDetailCards$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                final QPOrderDetailView qPOrderDetailView3 = QPOrderDetailView.this;
                                LoopDirectivesViewKt.a(viewContainer2, new Function0<c<IQPOrderDetailCardViewModel>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailView$bodyWithDetailCards$1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final c<IQPOrderDetailCardViewModel> invoke() {
                                        c<IQPOrderDetailCardViewModel> detailCardsViewModel;
                                        IQPOrderDetailViewModel iQPOrderDetailViewModel = QPOrderDetailView.access$getAttr(QPOrderDetailView.this).viewModel;
                                        return (iQPOrderDetailViewModel == null || (detailCardsViewModel = iQPOrderDetailViewModel.detailCardsViewModel()) == null) ? new c<>(null, null, null, 7, null) : detailCardsViewModel;
                                    }
                                }, new Function2<LoopDirectivesView<IQPOrderDetailCardViewModel>, IQPOrderDetailCardViewModel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailView$bodyWithDetailCards$1.2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(LoopDirectivesView<IQPOrderDetailCardViewModel> loopDirectivesView, IQPOrderDetailCardViewModel iQPOrderDetailCardViewModel) {
                                        final IQPOrderDetailCardViewModel iQPOrderDetailCardViewModel2 = iQPOrderDetailCardViewModel;
                                        loopDirectivesView.addChild(iQPOrderDetailCardViewModel2.getCardView(), new Function1<IQPOrderDetailCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailView.bodyWithDetailCards.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(IQPOrderDetailCardView iQPOrderDetailCardView) {
                                                final IQPOrderDetailCardViewModel iQPOrderDetailCardViewModel3 = IQPOrderDetailCardViewModel.this;
                                                iQPOrderDetailCardView.attr(new Function1<QPOrderDetailCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailView.bodyWithDetailCards.1.2.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QPOrderDetailCardAttr qPOrderDetailCardAttr) {
                                                        qPOrderDetailCardAttr.viewModel = IQPOrderDetailCardViewModel.this;
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
                        }.invoke(cmVar2);
                        w.a(cmVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailView.body.1.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailView.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(tVar2.getPagerData().m(), 67.0f);
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
        return new QPOrderDetailAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
