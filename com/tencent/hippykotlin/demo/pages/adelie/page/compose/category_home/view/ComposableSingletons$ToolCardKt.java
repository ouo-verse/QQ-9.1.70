package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import g25.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$ToolCardKt {
    public static final ComposableSingletons$ToolCardKt INSTANCE = new ComposableSingletons$ToolCardKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function4<Integer, k, Composer, Integer, Unit> f5lambda1 = ComposableLambdaKt.composableLambdaInstance(1049377699, false, new Function4<Integer, k, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.ComposableSingletons$ToolCardKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function4
        public final Unit invoke(Integer num, k kVar, Composer composer, Integer num2) {
            int intValue = num.intValue();
            k kVar2 = kVar;
            Composer composer2 = composer;
            int intValue2 = num2.intValue();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1049377699, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.ComposableSingletons$ToolCardKt.lambda-1.<anonymous> (ToolCard.kt:41)");
            }
            ToolCardItemKt.ToolCardItem(intValue, kVar2, composer2, (intValue2 & 14) | 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return Unit.INSTANCE;
        }
    });
}
