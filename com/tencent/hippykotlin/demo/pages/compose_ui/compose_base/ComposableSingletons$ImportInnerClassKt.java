package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.ntcompose.core.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$ImportInnerClassKt {
    public static final ComposableSingletons$ImportInnerClassKt INSTANCE = new ComposableSingletons$ImportInnerClassKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<i, Composer, Integer, Unit> f28lambda1 = ComposableLambdaKt.composableLambdaInstance(1937728393, false, new Function3<i, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.ComposableSingletons$ImportInnerClassKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(i iVar, Composer composer, Integer num) {
            int intValue = num.intValue();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1937728393, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.ComposableSingletons$ImportInnerClassKt.lambda-1.<anonymous> (importInnerClass.kt:20)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return Unit.INSTANCE;
        }
    });
}
