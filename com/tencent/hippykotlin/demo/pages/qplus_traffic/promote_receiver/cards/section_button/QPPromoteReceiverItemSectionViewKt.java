package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button;

import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverItemSectionViewKt {
    public static final void QPPromoteReceiverItemSectionViewFun(ViewContainer<?, ?> viewContainer, final QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel, final QPPromoteReceiverViewModel qPPromoteReceiverViewModel, final String str, final Function1<? super QPPromoteReceiverItemSectionView, Unit> function1) {
        viewContainer.addChild(new QPPromoteReceiverItemSectionView(), new Function1<QPPromoteReceiverItemSectionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionViewKt$QPPromoteReceiverItemSectionViewFun$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView) {
                QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView2 = qPPromoteReceiverItemSectionView;
                final QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel2 = qPPromoteReceiverSectionViewModel;
                final QPPromoteReceiverViewModel qPPromoteReceiverViewModel2 = qPPromoteReceiverViewModel;
                final String str2 = str;
                qPPromoteReceiverItemSectionView2.attr(new Function1<QPPromoteReceiverItemSectionViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionViewKt$QPPromoteReceiverItemSectionViewFun$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QPPromoteReceiverItemSectionViewAttr qPPromoteReceiverItemSectionViewAttr) {
                        QPPromoteReceiverItemSectionViewAttr qPPromoteReceiverItemSectionViewAttr2 = qPPromoteReceiverItemSectionViewAttr;
                        qPPromoteReceiverItemSectionViewAttr2.sectionViewModel = QPPromoteReceiverSectionViewModel.this;
                        qPPromoteReceiverItemSectionViewAttr2.viewModel = qPPromoteReceiverViewModel2;
                        qPPromoteReceiverItemSectionViewAttr2.sectionTitle$delegate.setValue(qPPromoteReceiverItemSectionViewAttr2, QPPromoteReceiverItemSectionViewAttr.$$delegatedProperties[1], str2);
                        return Unit.INSTANCE;
                    }
                });
                function1.invoke(qPPromoteReceiverItemSectionView2);
                return Unit.INSTANCE;
            }
        });
    }
}
