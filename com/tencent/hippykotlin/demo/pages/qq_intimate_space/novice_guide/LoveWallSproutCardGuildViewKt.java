package com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardConfig;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardViewKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import e25.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallSproutCardGuildViewKt {
    public static final void LoveWallSproutCardGuildView(final i iVar, final Function0<Unit> function0, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(227310730);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(227310730, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallSproutCardGuildView (LoveWallSproutCardGuildView.kt:22)");
        }
        ModalKt.a(ModifiersKt.d(com.tencent.ntcompose.core.i.INSTANCE, h.INSTANCE.a(0.4f)), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -919040692, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallSproutCardGuildViewKt$LoveWallSproutCardGuildView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-919040692, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallSproutCardGuildView.<anonymous> (LoveWallSproutCardGuildView.kt:23)");
                    }
                    com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                    final i iVar2 = i.this;
                    final Function0<Unit> function02 = function0;
                    final int i16 = i3;
                    BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer3, 1176587474, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallSproutCardGuildViewKt$LoveWallSproutCardGuildView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            int i17;
                            b bVar2 = bVar;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i17 = (composer5.changed(bVar2) ? 4 : 2) | intValue2;
                            } else {
                                i17 = intValue2;
                            }
                            if ((i17 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1176587474, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallSproutCardGuildView.<anonymous>.<anonymous> (LoveWallSproutCardGuildView.kt:24)");
                                }
                                i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                                com.tencent.ntcompose.core.i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), (com.tencent.ntcompose.activity.b.a().getPageData().m() * 407.0f) / 188.0f);
                                Alignment alignment = Alignment.Center;
                                APNGKt.a(bVar2.a(k3, alignment), null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_5cAgmr-WmMg.png", 0, null, null, null, null, composer5, 3464, 242);
                                LoveSproutCardViewKt.LoveSproutCardView(bVar2.a(ComposeLayoutPropUpdaterKt.v(companion, 292, 444), alignment), new LoveSproutCardConfig(e25.i.this, (String) null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_PdxDW6lTsHK.png", 0.0f, 0.0f, 58), function02, composer5, ((i16 << 3) & 896) | 8, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallSproutCardGuildViewKt$LoveWallSproutCardGuildView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallSproutCardGuildViewKt.LoveWallSproutCardGuildView(e25.i.this, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
