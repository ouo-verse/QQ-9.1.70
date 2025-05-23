package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFilterLayoutModeViewKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionItem;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionViewModel;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import uo3.b;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTCompressFilterBarViewKt {
    public static final void QQFTCompressFilterBarView(final QQFlashTransferViewModel qQFlashTransferViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(10035431);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(10035431, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressFilterBarView (QQFTCompressFilterBarView.kt:46)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.s(ModifiersKt.q(ModifiersKt.c(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), QUIToken.color$default("bg_bottom_light")), new b(20.0f, 20.0f, 0.0f, 0.0f)), 0.0f, 16.0f, 0.0f, 12.0f, 5, null), 0.0f, -1.0f, 0.0f, 0.0f, 13, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1965921313, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressFilterBarViewKt$QQFTCompressFilterBarView$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                int i16;
                com.tencent.ntcompose.foundation.layout.b bVar2 = bVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1965921313, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressFilterBarView.<anonymous> (QQFTCompressFilterBarView.kt:53)");
                    }
                    i.Companion companion = i.INSTANCE;
                    TextKt.a("\u6587\u4ef6", ComposeLayoutPropUpdaterKt.n(bVar2.a(companion, Alignment.CenterStart), 16.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601606, 0, 0, 134216612);
                    i n3 = ComposeLayoutPropUpdaterKt.n(bVar2.a(companion, Alignment.CenterEnd), 0.0f, 0.0f, 16.0f, 0.0f, 11, null);
                    final QQFlashTransferViewModel qQFlashTransferViewModel2 = QQFlashTransferViewModel.this;
                    RowKt.a(n3, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 1000295743, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressFilterBarViewKt$QQFTCompressFilterBarView$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1000295743, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressFilterBarView.<anonymous>.<anonymous> (QQFTCompressFilterBarView.kt:63)");
                                }
                                QQFTFilterSelectionViewModel filterSelectionModel = QQFlashTransferViewModel.this.getFilterSelectionModel();
                                final QQFlashTransferViewModel qQFlashTransferViewModel3 = QQFlashTransferViewModel.this;
                                QQFTFilterSelectionKt.QQFTFilterSelectionView(filterSelectionModel, new Function1<QQFTFilterSelectionItem, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressFilterBarViewKt.QQFTCompressFilterBarView.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(QQFTFilterSelectionItem qQFTFilterSelectionItem) {
                                        return Boolean.valueOf(QQFTFilterLayoutModeViewKt.handleFilterSelection(QQFlashTransferViewModel.this, qQFTFilterSelectionItem));
                                    }
                                }, composer5, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196616, 30);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.compress.QQFTCompressFilterBarViewKt$QQFTCompressFilterBarView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCompressFilterBarViewKt.QQFTCompressFilterBarView(QQFlashTransferViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
