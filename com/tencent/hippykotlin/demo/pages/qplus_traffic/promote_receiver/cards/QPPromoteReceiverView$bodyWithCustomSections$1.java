package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards;

import com.tencent.hippykotlin.demo.pages.base.ECLoadingAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionViewKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverPhotoSelectSectionView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSectionViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverView$bodyWithCustomSections$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ QPPromoteReceiverViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QPPromoteReceiverView$bodyWithCustomSections$1(QPPromoteReceiverViewModel qPPromoteReceiverViewModel) {
        super(1);
        this.$viewModel = qPPromoteReceiverViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final QPPromoteReceiverViewModel qPPromoteReceiverViewModel = this.$viewModel;
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView$bodyWithCustomSections$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView.bodyWithCustomSections.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.m140flex(1.0f);
                        tVar2.marginTop(11.0f);
                        tVar2.mo153width(tVar2.getPagerData().m());
                        tVar2.flexDirectionColumn();
                        return Unit.INSTANCE;
                    }
                });
                QPPromoteReceiverItemSectionViewKt.QPPromoteReceiverItemSectionViewFun(vVar2, (QPPromoteReceiverSectionViewModel) QPPromoteReceiverViewModel.this.sexReceiverSectionViewModel$delegate.getValue(), QPPromoteReceiverViewModel.this, "\u6027\u522b\uff08\u5355\u9009\uff09", new Function1<QPPromoteReceiverItemSectionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView.bodyWithCustomSections.1.1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView) {
                        return Unit.INSTANCE;
                    }
                });
                QPPromoteReceiverItemSectionViewKt.QPPromoteReceiverItemSectionViewFun(vVar2, (QPPromoteReceiverSectionViewModel) QPPromoteReceiverViewModel.this.ageReceiverSectionViewModel$delegate.getValue(), QPPromoteReceiverViewModel.this, "\u5e74\u9f84\uff08\u591a\u9009\uff09", new Function1<QPPromoteReceiverItemSectionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView.bodyWithCustomSections.1.1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView) {
                        return Unit.INSTANCE;
                    }
                });
                QPPromoteReceiverItemSectionViewKt.QPPromoteReceiverItemSectionViewFun(vVar2, (QPPromoteReceiverSectionViewModel) QPPromoteReceiverViewModel.this.cityReceiverSectionViewModel$delegate.getValue(), QPPromoteReceiverViewModel.this, "\u5730\u57df\uff08\u591a\u9009\uff09", new Function1<QPPromoteReceiverItemSectionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView.bodyWithCustomSections.1.1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView) {
                        return Unit.INSTANCE;
                    }
                });
                QPPromoteReceiverItemSectionViewKt.QPPromoteReceiverItemSectionViewFun(vVar2, (QPPromoteReceiverSectionViewModel) QPPromoteReceiverViewModel.this.interestReceiverSectionViewModel$delegate.getValue(), QPPromoteReceiverViewModel.this, "\u5174\u8da3\uff08\u591a\u9009\uff09", new Function1<QPPromoteReceiverItemSectionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView.bodyWithCustomSections.1.1.5
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView) {
                        return Unit.INSTANCE;
                    }
                });
                QPPromoteReceiverItemSectionViewKt.QPPromoteReceiverItemSectionViewFun(vVar2, (QPPromoteReceiverSectionViewModel) QPPromoteReceiverViewModel.this.crowdReceiverSectionViewModel$delegate.getValue(), QPPromoteReceiverViewModel.this, "\u4eba\u7fa4\u753b\u50cf\uff08\u591a\u9009\uff09", new Function1<QPPromoteReceiverItemSectionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView.bodyWithCustomSections.1.1.6
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView) {
                        return Unit.INSTANCE;
                    }
                });
                QPPromoteReceiverViewModel qPPromoteReceiverViewModel2 = QPPromoteReceiverViewModel.this;
                vVar2.addChild(new QPPromoteReceiverPhotoSelectSectionView(qPPromoteReceiverViewModel2), new Function1<QPPromoteReceiverPhotoSelectSectionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView.bodyWithCustomSections.1.1.7
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(QPPromoteReceiverPhotoSelectSectionView qPPromoteReceiverPhotoSelectSectionView) {
                        return Unit.INSTANCE;
                    }
                });
                final QPPromoteReceiverViewModel qPPromoteReceiverViewModel3 = QPPromoteReceiverViewModel.this;
                ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView.bodyWithCustomSections.1.1.8
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        QPPromoteReceiverViewModel qPPromoteReceiverViewModel4 = QPPromoteReceiverViewModel.this;
                        return Boolean.valueOf(((Boolean) qPPromoteReceiverViewModel4.uploadLoading$delegate.getValue(qPPromoteReceiverViewModel4, QPPromoteReceiverViewModel.$$delegatedProperties[2])).booleanValue());
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView.bodyWithCustomSections.1.1.9
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ECLoadingViewKt.ECLoading(conditionView, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView.bodyWithCustomSections.1.1.9.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECLoadingView eCLoadingView) {
                                eCLoadingView.attr(new Function1<ECLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverView.bodyWithCustomSections.1.1.9.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECLoadingAttr eCLoadingAttr) {
                                        ECLoadingAttr eCLoadingAttr2 = eCLoadingAttr;
                                        eCLoadingAttr2.marginTop(200.0f);
                                        eCLoadingAttr2.setLoadingText("\u4e0a\u4f20\u4e2d...");
                                        eCLoadingAttr2.delayShow = false;
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
}
