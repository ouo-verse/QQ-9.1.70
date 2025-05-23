package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import zo3.d;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class ComposableSingletons$QQFTCenterFileSetCardViewKt {
    public static final ComposableSingletons$QQFTCenterFileSetCardViewKt INSTANCE = new ComposableSingletons$QQFTCenterFileSetCardViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f152lambda1 = ComposableLambdaKt.composableLambdaInstance(-1806105516, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterFileSetCardViewKt$lambda-1$1
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
                    ComposerKt.traceEventStart(-1806105516, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterFileSetCardViewKt.lambda-1.<anonymous> (QQFTCenterFileSetCardView.kt:130)");
                }
                ImageKt.a(null, null, null, null, null, ModifiersKt.u(bVar2.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 16), 0.0f, 4, 0.0f, 0.0f, 13, null), Alignment.TopEnd), new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterFileSetCardViewKt$lambda-1$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(d dVar) {
                        dVar.m(Float.valueOf(90.0f));
                        return Unit.INSTANCE;
                    }
                }), null, h.INSTANCE.c(), null, null, QUIToken.INSTANCE.image("more", QUIToken.color$default("text_primary")), null, null, null, null, null, null, null, null, null, null, composer2, 12845056, 0, 0, 2095967);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f153lambda2 = ComposableLambdaKt.composableLambdaInstance(-1822487107, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterFileSetCardViewKt$lambda-2$1
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
                    ComposerKt.traceEventStart(-1822487107, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterFileSetCardViewKt.lambda-2.<anonymous> (QQFTCenterFileSetCardView.kt:198)");
                }
                ImageKt.a(null, null, null, null, null, bVar2.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20), Alignment.CenterEnd), null, h.INSTANCE.c(), null, null, QUIToken.INSTANCE.image("more", QUIToken.color$default("text_primary")), null, null, null, null, null, null, null, null, null, null, composer2, 12845056, 0, 0, 2095967);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
