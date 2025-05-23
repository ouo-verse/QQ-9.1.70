package com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallFeedBackBubbleViewKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class ComposableSingletons$LoveWallFloweringGuildViewKt {
    public static final ComposableSingletons$LoveWallFloweringGuildViewKt INSTANCE = new ComposableSingletons$LoveWallFloweringGuildViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f110lambda1 = ComposableLambdaKt.composableLambdaInstance(-1522785108, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.ComposableSingletons$LoveWallFloweringGuildViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            List listOf;
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1522785108, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.ComposableSingletons$LoveWallFloweringGuildViewKt.lambda-1.<anonymous> (LoveWallFloweringGuildView.kt:65)");
                }
                i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                listOf = CollectionsKt__CollectionsJVMKt.listOf("\u60ca\u559c\u5956\u52b1");
                LoveWallFeedBackBubbleViewKt.LoveWallFeedBackBubbleView(h16, "30m\u6709\u60ca\u559c\u5956\u52b1\u54e6\uff0c\u795d\u4f60\u4eec\u7684\u7231\u60c5\u957f\u957f\u4e45\u4e45\uff5e", listOf, composer2, 56, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
