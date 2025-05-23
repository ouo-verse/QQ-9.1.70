package com.tencent.hippykotlin.demo.pages.qq_intimate_space.share;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes37.dex */
public final class ComposableSingletons$LoveWallTreeCardSharePageViewKt {
    public static final ComposableSingletons$LoveWallTreeCardSharePageViewKt INSTANCE = new ComposableSingletons$LoveWallTreeCardSharePageViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<d, Composer, Integer, Unit> f114lambda1 = ComposableLambdaKt.composableLambdaInstance(1130913817, false, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.ComposableSingletons$LoveWallTreeCardSharePageViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(d dVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1130913817, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.ComposableSingletons$LoveWallTreeCardSharePageViewKt.lambda-1.<anonymous> (LoveWallTreeCardSharePageView.kt:250)");
                }
                TextKt.a("\u8ba9\u6211\u4eec\u671f\u5f85\u672a\u6765\u7855\u679c\u7231\u60c5\u8def", null, null, QUIToken.color$default("button_text_secondary_disable"), Float.valueOf(10.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 28678, 0, 0, 134217702);
                i.Companion companion = i.INSTANCE;
                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 8), composer2, 8, 0);
                ImageKt.a(null, null, null, null, null, ModifiersKt.D(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 100), 16), 0.5f), null, h.INSTANCE.c(), null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_RfjyLjzaeyK.png", null, null, null, null, null, null, null, null, null, null, composer2, 12845056, 6, 0, 2095967);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
