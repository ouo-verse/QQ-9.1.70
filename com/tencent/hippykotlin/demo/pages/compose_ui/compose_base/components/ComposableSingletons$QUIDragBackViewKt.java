package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.ntcompose.foundation.layout.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$QUIDragBackViewKt {
    public static final ComposableSingletons$QUIDragBackViewKt INSTANCE = new ComposableSingletons$QUIDragBackViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f31lambda1 = ComposableLambdaKt.composableLambdaInstance(1735056562, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ComposableSingletons$QUIDragBackViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1735056562, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ComposableSingletons$QUIDragBackViewKt.lambda-1.<anonymous> (QUIDragBackView.kt:105)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
