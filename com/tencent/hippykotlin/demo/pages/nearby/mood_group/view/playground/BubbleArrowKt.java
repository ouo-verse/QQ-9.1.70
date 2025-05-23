package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.t;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.pager.g;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BubbleArrowKt {
    public static final void BubbleArrow(final float f16, final float f17, final float f18, final h hVar, final float f19, float f26, h hVar2, Composer composer, final int i3, final int i16) {
        Integer intOrNull;
        Composer startRestartGroup = composer.startRestartGroup(216193282);
        float f27 = (i16 & 32) != 0 ? 0.0f : f26;
        h l3 = (i16 & 64) != 0 ? h.INSTANCE.l() : hVar2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(216193282, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.BubbleArrow (BubbleArrow.kt:25)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            g pageData = c.f117352a.g().getPageData();
            boolean z16 = false;
            if (pageData.getIsAndroid()) {
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(pageData.getOsVersion());
                if ((intOrNull != null ? intOrNull.intValue() : 0) <= 27) {
                    z16 = true;
                }
            }
            rememberedValue = Boolean.valueOf(z16);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final float f28 = ((Boolean) rememberedValue).booleanValue() ? 0.0f : f18;
        float f29 = f27 > 0.0f ? f27 + 0.2f : 0.1f;
        final float max = Math.max(f16, f17);
        final float sqrt = ((((float) Math.sqrt((max * max) * r5)) - f17) - f29) / 2;
        final float f36 = f27;
        final h hVar3 = l3;
        BoxKt.a(ModifiersKt.Q(ModifiersKt.E(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, f16), f17 + f27), true), new y(0.0f, 0.0f, f19, -f29), null, 2, null), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1874263176, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.BubbleArrowKt$BubbleArrow$1
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
                        ComposerKt.traceEventStart(1874263176, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.BubbleArrow.<anonymous> (BubbleArrow.kt:47)");
                    }
                    BoxKt.a(ModifiersKt.O(ModifiersKt.g(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, max), max), hVar), f28), new e(f36, BorderStyle.SOLID, hVar3)), new t(45.0f, 0.0f, 0.0f, 6, null), null, new y(0.0f, 0.0f, 0.0f, -sqrt), null, null, 26, null), null, null, null, composer3, 8, 14);
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
        final float f37 = f27;
        final h hVar4 = l3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.BubbleArrowKt$BubbleArrow$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                BubbleArrowKt.BubbleArrow(f16, f17, f18, hVar, f19, f37, hVar4, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
