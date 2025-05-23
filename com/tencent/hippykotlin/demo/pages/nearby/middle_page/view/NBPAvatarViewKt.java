package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class NBPAvatarViewKt {
    public static final void NBPAvatarView(final i iVar, final String str, final float f16, final String str2, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(1132689796);
        if ((i16 & 8) != 0) {
            str2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1132689796, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPAvatarView (NBPAvatarView.kt:16)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.u(iVar, f16), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -315676738, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPAvatarViewKt$NBPAvatarView$1
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
                        ComposerKt.traceEventStart(-315676738, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPAvatarView.<anonymous> (NBPAvatarView.kt:24)");
                    }
                    String str3 = str;
                    i.Companion companion = i.INSTANCE;
                    ImageKt.a(str3, null, null, null, null, ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.u(companion, f16), h.INSTANCE.e()), f16 / 2.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, ((i3 >> 3) & 14) | 262144, 0, 0, 2097118);
                    String str4 = str2;
                    if (!(str4 == null || str4.length() == 0)) {
                        float f17 = f16;
                        float f18 = 1.1111112f * f17;
                        float f19 = (f17 - f18) / 2.0f;
                        ImageKt.a(str2, null, null, null, null, ComposeLayoutPropUpdaterKt.o(ComposeLayoutPropUpdaterKt.u(companion, f18), f19, f19), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, ((i3 >> 9) & 14) | 262144, 0, 0, 2097118);
                    }
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
        final String str3 = str2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.NBPAvatarViewKt$NBPAvatarView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPAvatarViewKt.NBPAvatarView(i.this, str, f16, str3, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
