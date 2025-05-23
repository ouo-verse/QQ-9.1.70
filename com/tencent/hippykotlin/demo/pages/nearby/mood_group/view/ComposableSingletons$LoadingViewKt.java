package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ActivityIndicatorKt;
import com.tencent.ntcompose.material.TextKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$LoadingViewKt {
    public static final ComposableSingletons$LoadingViewKt INSTANCE = new ComposableSingletons$LoadingViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f67lambda1 = ComposableLambdaKt.composableLambdaInstance(848587321, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ComposableSingletons$LoadingViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(848587321, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.ComposableSingletons$LoadingViewKt.lambda-1.<anonymous> (LoadingView.kt:24)");
                }
                i.Companion companion = i.INSTANCE;
                ActivityIndicatorKt.a(ComposeLayoutPropUpdaterKt.u(companion, 20.0f), true, composer2, 56, 0);
                TextKt.a("\u52a0\u8f7d\u4e2d,\u8bf7\u7a0d\u540e...", ComposeLayoutPropUpdaterKt.n(companion, 13.0f, 0.0f, 0.0f, 0.0f, 14, null), null, new h(9211020L, 1.0f), Float.valueOf(13.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 28742, 0, 0, 134217700);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
