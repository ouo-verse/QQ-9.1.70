package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class ComposableSingletons$QQFTCenterShareViewKt {
    public static final ComposableSingletons$QQFTCenterShareViewKt INSTANCE = new ComposableSingletons$QQFTCenterShareViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f154lambda1 = ComposableLambdaKt.composableLambdaInstance(-1044008185, false, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterShareViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1044008185, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterShareViewKt.lambda-1.<anonymous> (QQFTCenterShareView.kt:75)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f155lambda2 = ComposableLambdaKt.composableLambdaInstance(-50070943, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterShareViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-50070943, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterShareViewKt.lambda-2.<anonymous> (QQFTCenterShareView.kt:183)");
                }
                i.Companion companion = i.INSTANCE;
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 16), null, 0, null, null, QUIToken.INSTANCE.image("tick_circle", QUIToken.color$default("text_primary")), null, null, null, null, null, null, null, null, null, null, composer2, 262144, 0, 0, 2096095);
                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion, 2), composer2, 8, 0);
                TextKt.a("\u590d\u5236\u94fe\u63a5\u5373\u523b\u5206\u4eab\uff0c\u65e0\u9700\u7b49\u5f85\u4e0a\u4f20\u5b8c\u6210\u3002", ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion), 4, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_primary"), Float.valueOf(14), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.e()), Float.valueOf(20), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 1601606, 48, 0, 134214564);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
