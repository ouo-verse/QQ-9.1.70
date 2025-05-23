package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTFilterSelectionKt {
    public static final void QQFTFilterSelectionItemView(final QQFTFilterSelectionItem qQFTFilterSelectionItem, final boolean z16, final Function1<? super QQFTFilterSelectionItem, Unit> function1, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-153901547);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-153901547, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionItemView (QQFTFilterSelection.kt:80)");
        }
        RowKt.a(ViewEventPropUpdaterKt.d(ModifiersKt.w(ComposeLayoutPropUpdaterKt.B(ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null)), QUIToken.color$default("overlay_surface_bg")), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionKt$QQFTFilterSelectionItemView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                function1.invoke(qQFTFilterSelectionItem);
                return Unit.INSTANCE;
            }
        }, 3, null), null, Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1657620041, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionKt$QQFTFilterSelectionItemView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                h hVar;
                c e16;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1657620041, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionItemView.<anonymous> (QQFTFilterSelection.kt:88)");
                    }
                    i.Companion companion = i.INSTANCE;
                    float f16 = 10;
                    i s16 = ComposeLayoutPropUpdaterKt.s(companion, f16, 0.0f, f16, 0.0f, 10, null);
                    QQFTFilterSelectionItem qQFTFilterSelectionItem2 = QQFTFilterSelectionItem.this;
                    String str = qQFTFilterSelectionItem2.title;
                    float f17 = 14;
                    float f18 = 20;
                    if (qQFTFilterSelectionItem2.isSelected.getValue().booleanValue()) {
                        hVar = QQFTFilterSelectionItem.this.selectedTextColor;
                    } else {
                        hVar = QQFTFilterSelectionItem.this.normalTextColor;
                    }
                    h hVar2 = hVar;
                    if (QQFTFilterSelectionItem.this.isSelected.getValue().booleanValue()) {
                        e16 = c.INSTANCE.f();
                    } else {
                        e16 = c.INSTANCE.e();
                    }
                    TextKt.a(str, s16, null, hVar2, Float.valueOf(f17), null, e16, null, null, null, null, Float.valueOf(f18), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 28736, 48, 0, 134215588);
                    if (!z16) {
                        BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 1), f17), QUIToken.color$default("border_standard")), null, null, null, composer3, 8, 14);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196616, 26);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionKt$QQFTFilterSelectionItemView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFilterSelectionKt.QQFTFilterSelectionItemView(QQFTFilterSelectionItem.this, z16, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void QQFTFilterSelectionView(final QQFTFilterSelectionViewModel qQFTFilterSelectionViewModel, final Function1<? super QQFTFilterSelectionItem, Boolean> function1, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1246506977);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1246506977, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionView (QQFTFilterSelection.kt:60)");
        }
        float f16 = 2;
        RowKt.a(ModifiersKt.h(ModifiersKt.q(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.B(i.INSTANCE), qQFTFilterSelectionViewModel.height), f16, 0.0f, f16, 0.0f, 10, null), uo3.c.a(8)), 1, QUIToken.color$default("border_standard"), null, 4, null), null, Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -648999297, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionKt$QQFTFilterSelectionView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-648999297, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionView.<anonymous> (QQFTFilterSelection.kt:67)");
                    }
                    int size = QQFTFilterSelectionViewModel.this.items.size();
                    for (final int i16 = 0; i16 < size; i16++) {
                        final QQFTFilterSelectionItem qQFTFilterSelectionItem = QQFTFilterSelectionViewModel.this.items.get(i16);
                        boolean z16 = true;
                        if (i16 != QQFTFilterSelectionViewModel.this.items.size() - 1) {
                            z16 = false;
                        }
                        final Function1<QQFTFilterSelectionItem, Boolean> function12 = function1;
                        final QQFTFilterSelectionViewModel qQFTFilterSelectionViewModel2 = QQFTFilterSelectionViewModel.this;
                        QQFTFilterSelectionKt.QQFTFilterSelectionItemView(qQFTFilterSelectionItem, z16, new Function1<QQFTFilterSelectionItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionKt$QQFTFilterSelectionView$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QQFTFilterSelectionItem qQFTFilterSelectionItem2) {
                                if (function12.invoke(qQFTFilterSelectionItem).booleanValue()) {
                                    qQFTFilterSelectionViewModel2.selectItem(i16);
                                }
                                return Unit.INSTANCE;
                            }
                        }, composer3, 8);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196616, 26);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.common.QQFTFilterSelectionKt$QQFTFilterSelectionView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTFilterSelectionKt.QQFTFilterSelectionView(QQFTFilterSelectionViewModel.this, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
