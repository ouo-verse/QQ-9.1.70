package com.tencent.hippykotlin.demo.pages.nearby.public_account.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class ComposableSingletons$QQStrangerPAInteractCardViewKt {
    public static final ComposableSingletons$QQStrangerPAInteractCardViewKt INSTANCE = new ComposableSingletons$QQStrangerPAInteractCardViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f89lambda1 = ComposableLambdaKt.composableLambdaInstance(-735570133, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.view.ComposableSingletons$QQStrangerPAInteractCardViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-735570133, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.view.ComposableSingletons$QQStrangerPAInteractCardViewKt.lambda-1.<anonymous> (QQStrangerPAInteractCardView.kt:224)");
                }
                float f16 = 15;
                ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_TPEGzLHY5nc.png", null, null, null, null, ModifiersKt.j(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, f16, f16), 27), null, 0, null, null, null, null, null, null, null, null, null, null, null, QUIToken.color$default("icon_secondary"), null, composer2, 262150, 1073741824, 0, 1572830);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
