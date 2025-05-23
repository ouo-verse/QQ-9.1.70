package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards;

import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverView extends ComposeView<QPPromoteReceiverViewAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$bodyWithCustomSections(QPPromoteReceiverView qPPromoteReceiverView, QPPromoteReceiverView qPPromoteReceiverView2) {
        qPPromoteReceiverView.getClass();
        return new QPPromoteReceiverView$bodyWithCustomSections$1(((QPPromoteReceiverViewAttr) qPPromoteReceiverView2.getAttr()).getViewModel());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QPPromoteReceiverViewAttr access$getAttr(QPPromoteReceiverView qPPromoteReceiverView) {
        return (QPPromoteReceiverViewAttr) qPPromoteReceiverView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QPPromoteReceiverView qPPromoteReceiverView = QPPromoteReceiverView.this;
                ar.a(viewContainer, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        final QPPromoteReceiverView qPPromoteReceiverView2 = QPPromoteReceiverView.this;
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                ao aoVar2 = aoVar;
                                aoVar2.m140flex(1.0f);
                                aoVar2.alignSelfCenter();
                                aoVar2.flexDirectionColumn();
                                aoVar2.justifyContentFlexStart();
                                FlexNode flexNode = QPPromoteReceiverView.access$getAttr(QPPromoteReceiverView.this).getFlexNode();
                                aoVar2.mo141height(flexNode != null ? flexNode.K() : 0.0f);
                                FlexNode flexNode2 = QPPromoteReceiverView.access$getAttr(QPPromoteReceiverView.this).getFlexNode();
                                aoVar2.mo153width(flexNode2 != null ? flexNode2.U() : 0.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverView qPPromoteReceiverView3 = QPPromoteReceiverView.this;
                        aqVar2.addChild(new QPPromoteReceiverSelectSectionView(), new Function1<QPPromoteReceiverSelectSectionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QPPromoteReceiverSelectSectionView qPPromoteReceiverSelectSectionView) {
                                final QPPromoteReceiverView qPPromoteReceiverView4 = QPPromoteReceiverView.this;
                                qPPromoteReceiverSelectSectionView.attr(new Function1<QPPromoteReceiverViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QPPromoteReceiverViewAttr qPPromoteReceiverViewAttr) {
                                        qPPromoteReceiverViewAttr.viewModel = QPPromoteReceiverView.access$getAttr(QPPromoteReceiverView.this).getViewModel();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        QPPromoteReceiverView qPPromoteReceiverView4 = QPPromoteReceiverView.this;
                        ((QPPromoteReceiverView$bodyWithCustomSections$1) QPPromoteReceiverView.access$bodyWithCustomSections(qPPromoteReceiverView4, qPPromoteReceiverView4)).invoke(aqVar2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QPPromoteReceiverViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
