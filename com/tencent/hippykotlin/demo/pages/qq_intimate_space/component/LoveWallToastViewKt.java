package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallToastViewKt {
    public static final void LoveWallToastView(final i iVar, final String str, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1956191862);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1956191862, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallToastView (LoveWallToastView.kt:23)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(iVar, 0.0f, 1, null), 34), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, 939639036, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallToastViewKt$LoveWallToastView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(939639036, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallToastView.<anonymous> (LoveWallToastView.kt:27)");
                    }
                    i e16 = ModifiersKt.e(ModifiersKt.j(ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null), 34), Direction.TO_BOTTOM, new j(new h(4294966258L), -0.4247f), new j(new h(4293394350L), -0.9f), new j(new h(4292804568L), 1.0513f));
                    Alignment.Vertical vertical = Alignment.Vertical.CenterVertically;
                    final String str2 = str;
                    final int i16 = i3;
                    RowKt.a(e16, null, vertical, null, null, ComposableLambdaKt.composableLambda(composer3, -348646626, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallToastViewKt$LoveWallToastView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    ComposerKt.traceEventStart(-348646626, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallToastView.<anonymous>.<anonymous> (LoveWallToastView.kt:36)");
                                }
                                i.Companion companion = i.INSTANCE;
                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion, 20), 10, 0.0f, 0.0f, 0.0f, 14, null), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_wXTvw5SAqep.png", null, null, null, null, null, null, null, null, null, null, composer5, 262144, 6, 0, 2096095);
                                TextKt.a(str2, ComposeLayoutPropUpdaterKt.n(companion, 4, 0.0f, 14, 0.0f, 10, null), null, new h(57, 149, 3, 1.0f), Float.valueOf(14.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, (14 & (i16 >> 3)) | 28736, 0, 0, 134217700);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 197000, 26);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3128, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallToastViewKt$LoveWallToastView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallToastViewKt.LoveWallToastView(i.this, str, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
