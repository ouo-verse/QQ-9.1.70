package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.j;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$TtsNavigationBarKt {
    public static final ComposableSingletons$TtsNavigationBarKt INSTANCE = new ComposableSingletons$TtsNavigationBarKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f23lambda1 = ComposableLambdaKt.composableLambdaInstance(74618526, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.ComposableSingletons$TtsNavigationBarKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(74618526, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.ComposableSingletons$TtsNavigationBarKt.lambda-1.<anonymous> (TtsNavigationBar.kt:56)");
                }
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), null, h.INSTANCE.a(), null, null, QUIToken.INSTANCE.image("chevron_left", QUIToken.color$default("icon_allwhite_primary")), null, null, null, null, null, null, null, null, null, null, composer2, 12845056, 0, 0, 2095967);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<n, Composer, Integer, Unit> f24lambda2 = ComposableLambdaKt.composableLambdaInstance(-747901439, false, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.ComposableSingletons$TtsNavigationBarKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(n nVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-747901439, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.ComposableSingletons$TtsNavigationBarKt.lambda-2.<anonymous> (TtsNavigationBar.kt:85)");
                }
                i.Companion companion = i.INSTANCE;
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 18.0f), null, h.INSTANCE.a(), null, null, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADUAAAA1CAMAAADWOFNCAAAANlBMVEUAAADnVf/nVf/nVf/nV//nVf/oVf/nVf/nWP/fUP/nVv/nVf/nVv/oVf/qWf/mVf/oVf/nVf9xDvpMAAAAEXRSTlMAv2CfQN/vkCAQcLCAUDDPz+Zr+jAAAAEhSURBVEjH7dVLroMwDAVQO/+Ez6v3v9lXJ0UOSAFTdcgdVAn4CN2oLfAE1uUbhSHfR4no+DAz4TARaiwR7pGlYbbZ7Iko9ajQlXI2tLUR9XehUpCdL5uq9+woMyQUha5X5vwAo+ehENloFSfIadxQM9EEt1UmWk7U6mpkk9oSPYwV7+QCyq3kTpT7KNspyUjNH+W1Sub425KPytl3Bqo+JvKVozI8d1RSa6qf8Yaa6zq3YmrFYytALaZQsg4ArZhKSS2AhYsplNQqAK2YWuH2Aw1cTKuoj1Eqt1NRqQofoa/hYkrFQw5qmGWdCkSh+2c1KsW1sJuJKsW1irwN6AUTES1napxH6RTay+BeeVLnJWrWqwISq0V2XxQ1mQw8+VH+ASEeMMdgAZs3AAAAAElFTkSuQmCC", null, null, null, null, null, null, null, null, null, null, composer2, 12845056, 6, 0, 2095967);
                TextKt.a("\u4e00\u952e\u9009\u62e9", ComposeLayoutPropUpdaterKt.n(ModifiersKt.e(companion, Direction.TO_BOTTOM_RIGHT, new j(new com.tencent.kuikly.core.base.h(4293350911L), 0.0f), new j(new com.tencent.kuikly.core.base.h(4289617151L), 0.4f), new j(new com.tencent.kuikly.core.base.h(4282811903L), 1.0f)), 2.0f, 0.0f, 0.0f, 0.0f, 14, null), null, null, Float.valueOf(14.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(18.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 1597510, 48, 0, 134214572);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f25lambda3 = ComposableLambdaKt.composableLambdaInstance(980119139, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.ComposableSingletons$TtsNavigationBarKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(b bVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(980119139, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.ComposableSingletons$TtsNavigationBarKt.lambda-3.<anonymous> (TtsNavigationBar.kt:80)");
                }
                RowKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.B(i.INSTANCE), 40.0f), null, Alignment.INSTANCE.c(), null, null, ComposableSingletons$TtsNavigationBarKt.f24lambda2, composer2, 196616, 26);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
