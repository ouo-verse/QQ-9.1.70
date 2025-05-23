package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.ntcompose.foundation.layout.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$ChannelFeedItemViewKt {
    public static final ComposableSingletons$ChannelFeedItemViewKt INSTANCE = new ComposableSingletons$ChannelFeedItemViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f61lambda1 = ComposableLambdaKt.composableLambdaInstance(-436191737, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ComposableSingletons$ChannelFeedItemViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-436191737, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ComposableSingletons$ChannelFeedItemViewKt.lambda-1.<anonymous> (ChannelFeedItemView.kt:62)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
