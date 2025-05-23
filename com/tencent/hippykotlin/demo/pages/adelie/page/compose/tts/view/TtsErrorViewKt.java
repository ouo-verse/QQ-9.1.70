package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TtsErrorViewKt {
    public static final void TtsErrorView(final Function0<Unit> function0, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(-739728295);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(function0) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-739728295, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsErrorView (TtsErrorView.kt:29)");
            }
            BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.f(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), h.INSTANCE.j()), 0.0f, 1, null), 0.0f, 1, null), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, -165935469, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsErrorViewKt$TtsErrorView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(b bVar, Composer composer2, Integer num) {
                    int i17;
                    b bVar2 = bVar;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 14) == 0) {
                        i17 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                    } else {
                        i17 = intValue;
                    }
                    if ((i17 & 91) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-165935469, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsErrorView.<anonymous> (TtsErrorView.kt:37)");
                        }
                        ColumnKt.a(bVar2.a(i.INSTANCE, Alignment.Center), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(composer3, 1236035388, true, new Function3<d, Composer, Integer, Unit>(function0, i16) { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsErrorViewKt$TtsErrorView$1.1
                            public final /* synthetic */ Function0<Unit> $onRetryClick;

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
                                        ComposerKt.traceEventStart(1236035388, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsErrorView.<anonymous>.<anonymous> (TtsErrorView.kt:42)");
                                    }
                                    i.Companion companion = i.INSTANCE;
                                    ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 86.0f), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFYAAABWCAMAAABiiJHFAAAAUVBMVEUAAAAwMDAvMDIvMDMwMDAvMDMuMDMwMDQvMDMuMDIvMDIuMDIvMDMvMDIwMDIwMDQuMDIuMDIuMDMuMDMwMDMwMDksMDMwMDQvMDIwMDMvMDP4jtSAAAAAGnRSTlMAIN/vEL+gQK9gcIBf7zCAf5CPb1AgUE/PkOnu4qQAAANqSURBVFjDtVntluIwCBVI0qSZVqvtrHPf/0G3Op5T3Ujph8svT403eIEL4sG2IeXgWTCasI+5bw97bbh4QWHiL7Qd050Yo3HsUjUM9ydD1ef4+3QjcuUBNCG58i1KgQH4fhNoE6qZAwEAf60HPbr5Q5QY4Go5pxFoFvlxAw4LOf6WyVPTjguZcGfArwgyBeDszFOMpl4X3VrAhh+tcsRyhWcr70sQ3Ya6iZCvGVTgx0DQI/c1g3o0AVbjtmKgGrjSKsTPoNrWQegN7Yx42GURXIb7fHu4yxzjXFQ3GjrsNBL0BbG18RkviGTUG+T1GwcE05PRxMD1r/GpALLiERwFePPyZ/21c+t+r4MYxzL8c7zYCofAjc4AVjY8u8swldgjkAt2aqfJ3e/CWSVkS5JwctePztq4UekaGrsELKqEiViDXfdI4mA2+EtkAeQas9nAA/IjYJUxMwmejI0OXoF/OWCrE4O7NLjxddt3DGs0EJDJwUWA15mpDcZoEFBbeTANDf+OBlbqip4HzitDQy24Kur8KPF2htqr2v+JZ1SHQWOJRZ0BJn3k0HmISIeMrHLU0Oz8U6vNMo/Qf1R/aqsVaP6Eg1eKwW4YXqOhgj+wkgi2UhDglDf4ps+qs3b1K7Ci6hKjfdWu8nUFUbUOUAXDgC1FyobN6GzYDvVK2DHvbNiEqMBqknAdqTWNwIooKAlWJojyee02j2p74wK0cghIn4a9qVdG92nYjHyL5h5YLYsIrEmxaS1EKVAt5l7Ty1cSvSIJN4BkVNlcj1VapNbQXSHSinZqlxHEnNdXCT2DdB0isX6knNDQjPbl95fWwGkO9QLUOuE6jUcg0Nw+5zhPuEfW1hoI71Z/Q9+JtiRJ8FbzoADF9Mmcx4Q3p3y6+AaFsVc3Twk8BW9id6/x5OHE7m47gV9yTegTqARUr1rm14PYdecE9X7USzG59h+ggaTMqO4TS5Wf/7cCKr/CeWdukTK2n/agNq1WeDhtRy3DtR/3rKPecLcuWo1desvb1sJNax6RemVtLdlQu07pNYqRB36WEJdYiZyywmj6hQ6UGwM9xGtiXPENmGxP4SsDqmQC838VKaCG9R4Ah3c+uzRi2qBq2338DZf7argzOAxV6uLv0+PKurEbeuMvw2GvtX2Onps7HvuQ0wLIv+DfQmF45JSiAAAAAElFTkSuQmCC", null, null, null, null, null, null, null, null, QUIToken.color$default("icon_primary"), null, composer5, 12845056, 1073741830, 0, 1571679);
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 24.0f), composer5, 8, 0);
                                    TextKt.a("\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", null, null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601542, 48, 0, 134215590);
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 16.0f), composer5, 8, 0);
                                    i f16 = ModifiersKt.f(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 168.0f), 45.0f), QUIToken.color$default("button_bg_primary_default")), 4.0f), 1.0f, QUIToken.color$default("button_border_secondary_default"), BorderStyle.SOLID);
                                    com.tencent.ntcompose.material.d a16 = e.f339415a.a(h.INSTANCE.n());
                                    final Function0<Unit> function02 = this.$onRetryClick;
                                    composer5.startReplaceableGroup(1157296644);
                                    boolean changed = composer5.changed(function02);
                                    Object rememberedValue = composer5.rememberedValue();
                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsErrorViewKt$TtsErrorView$1$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                function02.invoke();
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue);
                                    }
                                    composer5.endReplaceableGroup();
                                    ButtonKt.a(null, (Function1) rememberedValue, f16, a16, ComposableSingletons$TtsErrorViewKt.f20lambda1, composer5, 29184, 1);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 24584, 10);
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
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsErrorViewKt$TtsErrorView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                TtsErrorViewKt.TtsErrorView(function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
