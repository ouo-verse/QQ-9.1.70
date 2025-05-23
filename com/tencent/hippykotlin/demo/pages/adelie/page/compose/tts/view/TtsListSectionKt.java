package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import uo3.b;
import yo3.Offset;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TtsListSectionKt {
    public static final void cellTopLine(final int i3, final int i16, Composer composer, final int i17) {
        int i18;
        Composer startRestartGroup = composer.startRestartGroup(429224202);
        if ((i17 & 14) == 0) {
            i18 = (startRestartGroup.changed(i3) ? 4 : 2) | i17;
        } else {
            i18 = i17;
        }
        if ((i17 & 112) == 0) {
            i18 |= startRestartGroup.changed(i16) ? 32 : 16;
        }
        if ((i18 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(429224202, i17, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.cellTopLine (TtsListSection.kt:56)");
            }
            if (1 <= i3 && i3 < i16) {
                SpacerKt.a(ComposeLayoutPropUpdaterKt.n(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.5f), QUIToken.color$default("border_standard")), 52.0f, 0.0f, 12.0f, 0.0f, 10, null), startRestartGroup, 8, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListSectionKt$cellTopLine$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                TtsListSectionKt.cellTopLine(i3, i16, composer2, i17 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void TtsListSection(final a aVar, final String str, final List<AdelieTtsInfo> list, final Function1<? super AdelieTtsInfo, Unit> function1, Function1<? super AdelieTtsInfo, Unit> function12, Function2<? super AdelieTtsInfo, ? super Offset, Unit> function2, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-666643154);
        Function1<? super AdelieTtsInfo, Unit> function13 = (i16 & 8) != 0 ? null : function12;
        Function2<? super AdelieTtsInfo, ? super Offset, Unit> function22 = (i16 & 16) != 0 ? null : function2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-666643154, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListSection (TtsListSection.kt:23)");
        }
        startRestartGroup.startReplaceableGroup(1404817651);
        if ((str.length() > 0) && (!list.isEmpty())) {
            TextKt.a(str, ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 0.0f, 22.0f, 0.0f, 12.0f, 5, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.e()), Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, startRestartGroup, ((i3 >> 3) & 14) | 1601600, 48, 0, 134214564);
        }
        startRestartGroup.endReplaceableGroup();
        final Function1<? super AdelieTtsInfo, Unit> function14 = function13;
        final Function2<? super AdelieTtsInfo, ? super Offset, Unit> function23 = function22;
        LazyDslKt.c(aVar, list, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1047714858, true, new Function4<Integer, AdelieTtsInfo, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListSectionKt$TtsListSection$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final Unit invoke(Integer num, AdelieTtsInfo adelieTtsInfo, Composer composer2, Integer num2) {
                b a16;
                b bVar;
                final int intValue = num.intValue();
                final AdelieTtsInfo adelieTtsInfo2 = adelieTtsInfo;
                Composer composer3 = composer2;
                final int intValue2 = num2.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1047714858, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListSection.<anonymous> (TtsListSection.kt:42)");
                }
                i c16 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), QUIToken.color$default("fill_allwhite_medium"));
                int size = list.size();
                int i17 = intValue2 & 14;
                composer3.startReplaceableGroup(-297011995);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-297011995, i17, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.cellRoundedCornerShape (TtsListSection.kt:67)");
                }
                if (size == 1) {
                    a16 = uo3.c.a(8.0f);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceableGroup();
                } else {
                    if (intValue == 0) {
                        bVar = new b(8.0f, 8.0f, 0.0f, 0.0f);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceableGroup();
                    } else if (intValue == size - 1) {
                        bVar = new b(0.0f, 0.0f, 8.0f, 8.0f);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceableGroup();
                    } else {
                        a16 = uo3.c.a(0.0f);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceableGroup();
                    }
                    a16 = bVar;
                }
                i q16 = ModifiersKt.q(c16, a16);
                final List<AdelieTtsInfo> list2 = list;
                final Function1<AdelieTtsInfo, Unit> function15 = function1;
                final Function1<AdelieTtsInfo, Unit> function16 = function14;
                final Function2<AdelieTtsInfo, Offset, Unit> function24 = function23;
                final int i18 = i3;
                BoxKt.a(q16, null, null, ComposableLambdaKt.composableLambda(composer3, 1471575260, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListSectionKt$TtsListSection$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer4, Integer num3) {
                        Composer composer5 = composer4;
                        int intValue3 = num3.intValue();
                        if ((intValue3 & 81) == 16 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1471575260, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListSection.<anonymous>.<anonymous> (TtsListSection.kt:48)");
                            }
                            TtsListSectionKt.cellTopLine(intValue, list2.size(), composer5, intValue2 & 14);
                            AdelieTtsInfo adelieTtsInfo3 = adelieTtsInfo2;
                            Function1<AdelieTtsInfo, Unit> function17 = function15;
                            Function1<AdelieTtsInfo, Unit> function18 = function16;
                            Function2<AdelieTtsInfo, Offset, Unit> function25 = function24;
                            int i19 = i18 >> 6;
                            TtsListCellKt.TtsListCell(adelieTtsInfo3, function17, function18, function25, composer5, (i19 & 112) | 8 | (i19 & 896) | (i19 & 7168), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer3, 3080, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3144, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Function1<? super AdelieTtsInfo, Unit> function15 = function13;
        final Function2<? super AdelieTtsInfo, ? super Offset, Unit> function24 = function22;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListSectionKt$TtsListSection$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                TtsListSectionKt.TtsListSection(a.this, str, list, function1, function15, function24, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
