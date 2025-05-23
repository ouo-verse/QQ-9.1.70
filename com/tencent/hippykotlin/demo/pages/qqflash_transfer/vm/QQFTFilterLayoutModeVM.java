package com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModelKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import com.tencent.ntcompose.material.HoverKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTFilterLayoutModeVM extends QQFTCardVM {
    public QQFTFilterLayoutModeVM(final QQFlashTransferViewModel qQFlashTransferViewModel) {
        BaseComposeCardViewModelKt.setCardViewBuilder(this, ComposableLambdaKt.composableLambdaInstance(-1907302006, true, new Function5<a, BaseComposeCardViewModel, Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFilterLayoutModeVM.1
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(a aVar, BaseComposeCardViewModel baseComposeCardViewModel, Integer num, Composer composer, Integer num2) {
                a aVar2 = aVar;
                num.intValue();
                Composer composer2 = composer;
                int intValue = num2.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1907302006, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFilterLayoutModeVM.<anonymous> (QQFTFilterLayoutModeVM.kt:32)");
                }
                if (QQFlashTransferViewModel.this.isSelectBarShow()) {
                    composer2.startReplaceableGroup(-414022840);
                    i c16 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, c.f117352a.g().getPageData().m()), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), QUIToken.color$default("bg_bottom_light"));
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                    ColumnKt.a(c16, null, null, null, ComposableLambdaKt.composableLambda(composer2, 344760184, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFilterLayoutModeVM.1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer3, Integer num3) {
                            Composer composer4 = composer3;
                            int intValue2 = num3.intValue();
                            if ((intValue2 & 81) == 16 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(344760184, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFilterLayoutModeVM.<anonymous>.<anonymous> (QQFTFilterLayoutModeVM.kt:35)");
                                }
                                QQFTFilterLayoutModeViewKt.QQFTFilterLayoutModeView(QQFlashTransferViewModel.this, composer4, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer2, 24584, 14);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-414022467);
                    i c17 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, c.f117352a.g().getPageData().m()), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), QUIToken.color$default("bg_bottom_light"));
                    final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                    HoverKt.a(aVar2, c17, null, null, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, -201611782, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFilterLayoutModeVM.1.2
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer3, Integer num3) {
                            Composer composer4 = composer3;
                            int intValue2 = num3.intValue();
                            if ((intValue2 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-201611782, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFilterLayoutModeVM.<anonymous>.<anonymous> (QQFTFilterLayoutModeVM.kt:44)");
                                }
                                QQFTFilterLayoutModeViewKt.QQFTFilterLayoutModeView(QQFlashTransferViewModel.this, composer4, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer2, 1572936, 30);
                    composer2.endReplaceableGroup();
                }
                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 2.0f), c.f117352a.g().getPageData().m()), composer2, 8, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }));
    }
}
