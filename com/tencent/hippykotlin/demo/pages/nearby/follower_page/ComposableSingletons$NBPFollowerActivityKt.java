package com.tencent.hippykotlin.demo.pages.nearby.follower_page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.nearby.follower_page.view.NBPFollowerPageKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes31.dex */
public final class ComposableSingletons$NBPFollowerActivityKt {
    public static final ComposableSingletons$NBPFollowerActivityKt INSTANCE = new ComposableSingletons$NBPFollowerActivityKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f33lambda1 = ComposableLambdaKt.composableLambdaInstance(433643255, false, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.follower_page.ComposableSingletons$NBPFollowerActivityKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(433643255, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.follower_page.ComposableSingletons$NBPFollowerActivityKt.lambda-1.<anonymous> (NBPFollowerActivity.kt:14)");
                }
                NBPFollowerPageKt.NBPFollowerPage(null, composer2, 0, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
