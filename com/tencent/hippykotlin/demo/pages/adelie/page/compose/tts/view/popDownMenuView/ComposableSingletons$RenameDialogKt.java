package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposableSingletons$RenameDialogKt {
    public static final ComposableSingletons$RenameDialogKt INSTANCE = new ComposableSingletons$RenameDialogKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f26lambda1 = ComposableLambdaKt.composableLambdaInstance(1785112139, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.ComposableSingletons$RenameDialogKt$lambda-1$1
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
                    ComposerKt.traceEventStart(1785112139, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.ComposableSingletons$RenameDialogKt.lambda-1.<anonymous> (RenameDialog.kt:107)");
                }
                TextKt.a("\u53d6\u6d88", bVar2.a(i.INSTANCE, Alignment.Center), null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 1601606, 0, 0, 134216612);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<b, Composer, Integer, Unit> f27lambda2 = ComposableLambdaKt.composableLambdaInstance(591922740, false, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.ComposableSingletons$RenameDialogKt$lambda-2$1
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
                    ComposerKt.traceEventStart(591922740, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.ComposableSingletons$RenameDialogKt.lambda-2.<anonymous> (RenameDialog.kt:131)");
                }
                TextKt.a("\u786e\u5b9a", bVar2.a(i.INSTANCE, Alignment.Center), null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 1601606, 0, 0, 134216612);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
