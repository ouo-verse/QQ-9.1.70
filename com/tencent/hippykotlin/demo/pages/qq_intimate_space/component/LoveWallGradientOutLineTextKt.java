package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.k;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ao;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallGradientOutLineTextKt {
    public static final void LoveWallGradientOutLineText(final i iVar, Alignment alignment, final String str, i iVar2, final k kVar, final ao aoVar, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-237652235);
        Alignment alignment2 = (i16 & 2) != 0 ? Alignment.CenterStart : alignment;
        i iVar3 = (i16 & 8) != 0 ? i.INSTANCE : iVar2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-237652235, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallGradientOutLineText (LoveWallGradientOutLineText.kt:12)");
        }
        final i iVar4 = iVar3;
        BoxKt.a(iVar, alignment2, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1918983291, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallGradientOutLineTextKt$LoveWallGradientOutLineText$1
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
                        ComposerKt.traceEventStart(1918983291, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallGradientOutLineText.<anonymous> (LoveWallGradientOutLineText.kt:23)");
                    }
                    String str2 = str;
                    ao aoVar2 = aoVar;
                    k kVar2 = kVar;
                    int i17 = i3;
                    int i18 = k.f28903n;
                    TextKt.a(str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, aoVar2, null, null, kVar2, null, null, null, null, null, false, composer3, (i17 >> 6) & 14, (i17 << 6) & 29360128, i18 | ((i17 >> 12) & 14), 133038078);
                    String str3 = str;
                    i iVar5 = iVar4;
                    k kVar3 = kVar;
                    int i19 = i3;
                    TextKt.a(str3, iVar5, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, kVar3, null, null, null, null, null, false, composer3, ((i19 >> 6) & 14) | 64, 0, i18 | ((i19 >> 12) & 14), 133169148);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, (i3 & 112) | 3080, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Alignment alignment3 = alignment2;
        final i iVar5 = iVar3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallGradientOutLineTextKt$LoveWallGradientOutLineText$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallGradientOutLineTextKt.LoveWallGradientOutLineText(i.this, alignment3, str, iVar5, kVar, aoVar, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
