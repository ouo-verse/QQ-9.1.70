package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import uo3.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$TtsCreateFloatViewKt {
    public static final ComposableSingletons$TtsCreateFloatViewKt INSTANCE = new ComposableSingletons$TtsCreateFloatViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f18lambda1 = ComposableLambdaKt.composableLambdaInstance(-99137365, false, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.ComposableSingletons$TtsCreateFloatViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-99137365, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.ComposableSingletons$TtsCreateFloatViewKt.lambda-1.<anonymous> (TtsCreateFloatView.kt:68)");
                }
                TtsCreateFloatViewKt.indicatorBar(composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f19lambda2 = ComposableLambdaKt.composableLambdaInstance(1433558382, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.ComposableSingletons$TtsCreateFloatViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1433558382, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.ComposableSingletons$TtsCreateFloatViewKt.lambda-2.<anonymous> (TtsCreateFloatView.kt:95)");
                }
                BoxKt.a(ModifiersKt.c(ModifiersKt.q(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 36.0f), 5.0f), c.a(5.0f)), QUIToken.color$default("icon_tertiary")), null, null, null, composer2, 8, 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
