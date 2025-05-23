package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.j;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.h;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallButtonKt {
    public static final void LoveWallButton(final i iVar, final LoveWallButtonConfig loveWallButtonConfig, final Function1<? super ClickParams, Unit> function1, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(215478548);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(215478548, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallButton (LoveWallButton.kt:27)");
        }
        ButtonKt.a(null, function1, iVar, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1806791871, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallButtonKt$LoveWallButton$1
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
                        ComposerKt.traceEventStart(1806791871, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallButton.<anonymous> (LoveWallButton.kt:31)");
                    }
                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                    final LoveWallButtonConfig loveWallButtonConfig2 = LoveWallButtonConfig.this;
                    BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer3, -896553863, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallButtonKt$LoveWallButton$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            int i16;
                            b bVar2 = bVar;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i16 = (composer5.changed(bVar2) ? 4 : 2) | intValue2;
                            } else {
                                i16 = intValue2;
                            }
                            if ((i16 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-896553863, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallButton.<anonymous>.<anonymous> (LoveWallButton.kt:32)");
                                }
                                i.Companion companion = i.INSTANCE;
                                i h17 = ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null);
                                Alignment alignment = Alignment.Center;
                                ImageKt.a(null, null, null, null, null, bVar2.a(h17, alignment), null, h.INSTANCE.c(), null, null, LoveWallButtonConfig.this.backgroundImageUrl, null, null, null, null, null, null, null, null, null, null, composer5, 12845056, 0, 0, 2095967);
                                i a16 = bVar2.a(companion, alignment);
                                Direction direction = Direction.TO_BOTTOM_RIGHT;
                                Object[] array = LoveWallButtonConfig.this.textGradientColorStops.toArray(new j[0]);
                                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                j[] jVarArr = (j[]) array;
                                i e16 = ModifiersKt.e(a16, direction, (j[]) Arrays.copyOf(jVarArr, jVarArr.length));
                                String str = LoveWallButtonConfig.this.text;
                                int a17 = ai.INSTANCE.a();
                                float f16 = LoveWallButtonConfig.this.textSize;
                                TextKt.a(str, e16, null, null, Float.valueOf(f16), null, new c(400), new com.tencent.ntcompose.material.n("MFYuanHei"), null, null, ai.f(a17), Float.valueOf(LoveWallButtonConfig.this.textSize + 5.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, (com.tencent.ntcompose.material.n.f339436b << 21) | 64, 0, 0, 134214444);
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
        }), startRestartGroup, ((i3 >> 3) & 112) | 25088, 9);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallButtonKt$LoveWallButton$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallButtonKt.LoveWallButton(i.this, loveWallButtonConfig, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
