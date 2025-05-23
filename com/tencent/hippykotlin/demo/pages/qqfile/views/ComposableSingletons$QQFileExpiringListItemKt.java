package com.tencent.hippykotlin.demo.pages.qqfile.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class ComposableSingletons$QQFileExpiringListItemKt {
    public static final ComposableSingletons$QQFileExpiringListItemKt INSTANCE = new ComposableSingletons$QQFileExpiringListItemKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f116lambda1 = ComposableLambdaKt.composableLambdaInstance(-442791478, false, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.ComposableSingletons$QQFileExpiringListItemKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-442791478, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.ComposableSingletons$QQFileExpiringListItemKt.lambda-1.<anonymous> (QQFileExpiringListItem.kt:188)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f117lambda2 = ComposableLambdaKt.composableLambdaInstance(1984144701, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.ComposableSingletons$QQFileExpiringListItemKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1984144701, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.ComposableSingletons$QQFileExpiringListItemKt.lambda-2.<anonymous> (QQFileExpiringListItem.kt:262)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f118lambda3 = ComposableLambdaKt.composableLambdaInstance(1353555174, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.views.ComposableSingletons$QQFileExpiringListItemKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1353555174, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqfile.views.ComposableSingletons$QQFileExpiringListItemKt.lambda-3.<anonymous> (QQFileExpiringListItem.kt:277)");
                }
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 12.0f), null, h.INSTANCE.a(), null, null, QUIToken.INSTANCE.image("arrowhead_down", QUIToken.color$default("icon_secondary")), null, null, null, null, null, null, null, null, null, null, composer2, 12845056, 0, 0, 2095967);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
