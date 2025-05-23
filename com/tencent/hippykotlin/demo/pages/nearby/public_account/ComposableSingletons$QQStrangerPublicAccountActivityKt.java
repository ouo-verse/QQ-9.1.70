package com.tencent.hippykotlin.demo.pages.nearby.public_account;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.ImportInnerClassKt;
import com.tencent.hippykotlin.demo.pages.nearby.public_account.view.AppScreenKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes31.dex */
public final class ComposableSingletons$QQStrangerPublicAccountActivityKt {
    public static final ComposableSingletons$QQStrangerPublicAccountActivityKt INSTANCE = new ComposableSingletons$QQStrangerPublicAccountActivityKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f87lambda1 = ComposableLambdaKt.composableLambdaInstance(-1356469048, false, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.ComposableSingletons$QQStrangerPublicAccountActivityKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1356469048, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.ComposableSingletons$QQStrangerPublicAccountActivityKt.lambda-1.<anonymous> (QQStrangerPublicAccountActivity.kt:18)");
                }
                AppScreenKt.AppScreen(null, null, composer2, 0, 3);
                ImportInnerClassKt.importInnerClass(composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
