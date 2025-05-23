package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUIGlobalLoadingViewKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QUIGlobalLoadingView(String str, Function0<Unit> function0, Composer composer, final int i3, final int i16) {
        String str2;
        final int i17;
        Function0<Unit> function02;
        final String str3;
        final Function0<Unit> function03;
        boolean changed;
        Object rememberedValue;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1943720602);
        int i18 = i16 & 1;
        if (i18 != 0) {
            i17 = i3 | 6;
            str2 = str;
        } else if ((i3 & 14) == 0) {
            str2 = str;
            i17 = (startRestartGroup.changed(str2) ? 4 : 2) | i3;
        } else {
            str2 = str;
            i17 = i3;
        }
        int i19 = i16 & 2;
        if (i19 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            function02 = function0;
            i17 |= startRestartGroup.changed(function02) ? 32 : 16;
            if ((i17 & 91) != 18 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                str3 = str2;
                function03 = function02;
            } else {
                str3 = i18 == 0 ? "\u52a0\u8f7d\u4e2d" : str2;
                function03 = i19 == 0 ? null : function02;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1943720602, i17, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIGlobalLoadingView (QUIGlobalLoadingView.kt:23)");
                }
                Alignment alignment = Alignment.Center;
                i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                startRestartGroup.startReplaceableGroup(1157296644);
                changed = startRestartGroup.changed(function03);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIGlobalLoadingViewKt$QUIGlobalLoadingView$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            Function0<Unit> function04 = function03;
                            if (function04 != null) {
                                function04.invoke();
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                BoxKt.a(ViewEventPropUpdaterKt.d(h16, false, null, (Function1) rememberedValue, 3, null), alignment, null, ComposableLambdaKt.composableLambda(startRestartGroup, 56201888, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIGlobalLoadingViewKt$QUIGlobalLoadingView$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(b bVar, Composer composer2, Integer num) {
                        Composer composer3 = composer2;
                        int intValue = num.intValue();
                        if ((intValue & 81) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(56201888, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIGlobalLoadingView.<anonymous> (QUIGlobalLoadingView.kt:31)");
                            }
                            a.e b16 = a.f339245a.b();
                            Alignment.Horizontal b17 = Alignment.INSTANCE.b();
                            i D = ModifiersKt.D(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 100.0f), QUIToken.color$default("bg_top_dark")), 6.0f), 0.7f);
                            final String str4 = str3;
                            final int i26 = i17;
                            ColumnKt.a(D, b16, b17, null, ComposableLambdaKt.composableLambda(composer3, 1277329047, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIGlobalLoadingViewKt$QUIGlobalLoadingView$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                                    Composer composer5 = composer4;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1277329047, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIGlobalLoadingView.<anonymous>.<anonymous> (QUIGlobalLoadingView.kt:39)");
                                        }
                                        i.Companion companion = i.INSTANCE;
                                        LoadingKt.Loading(ComposeLayoutPropUpdaterKt.u(companion, 24.0f), null, composer5, 8, 2);
                                        c e16 = c.INSTANCE.e();
                                        TextKt.a(str4, ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 10.5f, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_allwhite_primary"), Float.valueOf(14), null, e16, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, (14 & i26) | 1601600, 48, 0, 134215588);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 24648, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 3128, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIGlobalLoadingViewKt$QUIGlobalLoadingView$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    QUIGlobalLoadingViewKt.QUIGlobalLoadingView(str3, function03, composer2, i3 | 1, i16);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        function02 = function0;
        if ((i17 & 91) != 18) {
        }
        if (i18 == 0) {
        }
        if (i19 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Alignment alignment2 = Alignment.Center;
        i h162 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
        startRestartGroup.startReplaceableGroup(1157296644);
        changed = startRestartGroup.changed(function03);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIGlobalLoadingViewKt$QUIGlobalLoadingView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                Function0<Unit> function04 = function03;
                if (function04 != null) {
                    function04.invoke();
                }
                return Unit.INSTANCE;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        BoxKt.a(ViewEventPropUpdaterKt.d(h162, false, null, (Function1) rememberedValue, 3, null), alignment2, null, ComposableLambdaKt.composableLambda(startRestartGroup, 56201888, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIGlobalLoadingViewKt$QUIGlobalLoadingView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(56201888, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIGlobalLoadingView.<anonymous> (QUIGlobalLoadingView.kt:31)");
                    }
                    a.e b16 = a.f339245a.b();
                    Alignment.Horizontal b17 = Alignment.INSTANCE.b();
                    i D = ModifiersKt.D(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 100.0f), QUIToken.color$default("bg_top_dark")), 6.0f), 0.7f);
                    final String str4 = str3;
                    final int i26 = i17;
                    ColumnKt.a(D, b16, b17, null, ComposableLambdaKt.composableLambda(composer3, 1277329047, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIGlobalLoadingViewKt$QUIGlobalLoadingView$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1277329047, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIGlobalLoadingView.<anonymous>.<anonymous> (QUIGlobalLoadingView.kt:39)");
                                }
                                i.Companion companion = i.INSTANCE;
                                LoadingKt.Loading(ComposeLayoutPropUpdaterKt.u(companion, 24.0f), null, composer5, 8, 2);
                                c e16 = c.INSTANCE.e();
                                TextKt.a(str4, ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 10.5f, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_allwhite_primary"), Float.valueOf(14), null, e16, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, (14 & i26) | 1601600, 48, 0, 134215588);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24648, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3128, 4);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
