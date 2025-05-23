package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUILoadingType;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUILoadingViewKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import uo3.c;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class ComposableSingletons$QQTransferDownloadActivityKt {
    public static final ComposableSingletons$QQTransferDownloadActivityKt INSTANCE = new ComposableSingletons$QQTransferDownloadActivityKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f147lambda1 = ComposableLambdaKt.composableLambdaInstance(-1726835939, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQTransferDownloadActivityKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1726835939, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQTransferDownloadActivityKt.lambda-1.<anonymous> (QQTransferDownloadActivity.kt:179)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f148lambda2 = ComposableLambdaKt.composableLambdaInstance(-353205835, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQTransferDownloadActivityKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-353205835, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQTransferDownloadActivityKt.lambda-2.<anonymous> (QQTransferDownloadActivity.kt:575)");
                }
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, QUIToken.INSTANCE.image("arrowhead_up", QUIToken.color$default("icon_primary")), null, null, null, null, null, null, null, null, null, null, composer2, 262144, 0, 0, 2096095);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f149lambda3 = ComposableLambdaKt.composableLambdaInstance(-1725795298, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQTransferDownloadActivityKt$lambda-3$1
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
                    ComposerKt.traceEventStart(-1725795298, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.ComposableSingletons$QQTransferDownloadActivityKt.lambda-3.<anonymous> (QQTransferDownloadActivity.kt:590)");
                }
                QUILoadingViewKt.QUILoadingView(ModifiersKt.d(bVar2.a(ModifiersKt.q(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 80.0f), c.a(12.0f)), Alignment.Center), QUIToken.color$default("bg_top_dark")), false, QUILoadingType.TopImageBottomText, null, null, null, null, composer2, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE, 122);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
