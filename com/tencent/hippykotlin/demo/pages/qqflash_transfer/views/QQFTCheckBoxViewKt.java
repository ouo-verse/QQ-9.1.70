package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTCheckBoxViewKt {
    public static final void QQFTCheckBoxView(final i iVar, float f16, final boolean z16, h hVar, h hVar2, boolean z17, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(1400419535);
        float f17 = (i16 & 2) != 0 ? 20.0f : f16;
        h l3 = (i16 & 8) != 0 ? h.INSTANCE.l() : hVar;
        h color$default = (i16 & 16) != 0 ? QUIToken.color$default("icon_tertiary") : hVar2;
        boolean z18 = (i16 & 32) != 0 ? false : z17;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1400419535, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTCheckBoxView (QQFTCheckBoxView.kt:29)");
        }
        final float f18 = f17;
        final boolean z19 = z18;
        final h hVar3 = l3;
        final h hVar4 = color$default;
        BoxKt.a(iVar, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1236477867, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTCheckBoxViewKt$QQFTCheckBoxView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i17;
                h color$default2;
                h hVar5;
                b bVar2 = bVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i17 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i17 = intValue;
                }
                if ((i17 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1236477867, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTCheckBoxView.<anonymous> (QQFTCheckBoxView.kt:35)");
                    }
                    i u16 = ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f18);
                    Alignment alignment = Alignment.Center;
                    i j3 = ModifiersKt.j(bVar2.a(u16, alignment), f18 / 2);
                    if (z19) {
                        color$default2 = QUIToken.color$default("fill_standard_secondary");
                    } else if (!z16) {
                        color$default2 = hVar3;
                    } else {
                        color$default2 = QUIToken.color$default("brand_standard");
                    }
                    i c16 = ModifiersKt.c(j3, color$default2);
                    if (z16 && !z19) {
                        hVar5 = QUIToken.color$default("brand_standard");
                    } else {
                        hVar5 = hVar4;
                    }
                    i g16 = ModifiersKt.g(c16, new e(1.0f, BorderStyle.SOLID, hVar5));
                    final boolean z26 = z16;
                    final boolean z27 = z19;
                    final float f19 = f18;
                    BoxKt.a(g16, alignment, null, ComposableLambdaKt.composableLambda(composer3, 2001453403, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTCheckBoxViewKt$QQFTCheckBoxView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar3, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2001453403, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTCheckBoxView.<anonymous>.<anonymous> (QQFTCheckBoxView.kt:50)");
                                }
                                if (z26 && !z27) {
                                    i.Companion companion = i.INSTANCE;
                                    float f26 = f19 / 20;
                                    ImageKt.a("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABwAAAAUBAMAAABscEDKAAAAIVBMVEUAAAD////////////////////////////////////////PIev5AAAACnRSTlMAIN8Qz38w77+QE0n3xQAAAFtJREFUGNNjQALMbQzIwGR5ArKk16oyZMlVqxRRJBcJEJI0QJFkVEWRFFoVgKyza9VSuCRYFiiNMJZRCygNlYRJQyTh0hBJuDRYEiGN4lohiCRCGiSJAJKTYSwASQko0l/Sh4IAAAAASUVORK5CYII=", null, null, null, null, ComposeLayoutPropUpdaterKt.v(companion, 11.5f * f26, f26 * 8.2f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 262150, 0, 0, 2097118);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3128, 4);
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
        final float f19 = f17;
        final h hVar5 = l3;
        final h hVar6 = color$default;
        final boolean z26 = z18;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTCheckBoxViewKt$QQFTCheckBoxView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQFTCheckBoxViewKt.QQFTCheckBoxView(i.this, f19, z16, hVar5, hVar6, z26, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
