package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.ImageKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class ComposableSingletons$QQFTFileItemViewKt {
    public static final ComposableSingletons$QQFTFileItemViewKt INSTANCE = new ComposableSingletons$QQFTFileItemViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f131lambda1 = ComposableLambdaKt.composableLambdaInstance(-16752509, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQFTFileItemViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            int i3;
            b bVar2 = bVar;
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 14) == 0) {
                i3 = (composer2.changed(bVar2) ? 4 : 2) | intValue;
            } else {
                i3 = intValue;
            }
            if ((i3 & 91) == 18 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-16752509, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQFTFileItemViewKt.lambda-1.<anonymous> (QQFTFileItemView.kt:268)");
                }
                ImageKt.a(QUIToken.INSTANCE.image("more", QUIToken.color$default("icon_primary")), null, null, null, null, bVar2.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), Alignment.Center), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer2, 262144, 0, 0, 2097118);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f132lambda2 = ComposableLambdaKt.composableLambdaInstance(-1615279399, false, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQFTFileItemViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1615279399, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQFTFileItemViewKt.lambda-2.<anonymous> (QQFTFileItemView.kt:291)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f133lambda3 = ComposableLambdaKt.composableLambdaInstance(337301264, false, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQFTFileItemViewKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(337301264, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQFTFileItemViewKt.lambda-3.<anonymous> (QQFTFileItemView.kt:296)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
