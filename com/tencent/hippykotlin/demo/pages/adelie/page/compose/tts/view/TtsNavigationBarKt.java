package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TtsNavigationBarKt {
    public static final void TtsNavigationBar(final boolean z16, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(-553847935);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(z16) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(function0) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i16 |= startRestartGroup.changed(function02) ? 256 : 128;
        }
        if ((i16 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-553847935, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsNavigationBar (TtsNavigationBar.kt:33)");
            }
            ColumnKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 88.0f), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 2146140842, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsNavigationBarKt$TtsNavigationBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(d dVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2146140842, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsNavigationBar.<anonymous> (TtsNavigationBar.kt:37)");
                        }
                        i.Companion companion = i.INSTANCE;
                        float f16 = 88.0f / 2;
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), f16), composer3, 8, 0);
                        BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), h.INSTANCE.j()), f16), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), null, null, ComposableLambdaKt.composableLambda(composer3, 2059315044, true, new Function3<b, Composer, Integer, Unit>(Function0.this, i16, z16, function02) { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsNavigationBarKt$TtsNavigationBar$1.1
                            public final /* synthetic */ Function0<Unit> $back;
                            public final /* synthetic */ Function0<Unit> $onKeySelect;
                            public final /* synthetic */ boolean $showRight;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                                this.$showRight = r3;
                                this.$onKeySelect = r4;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                                int i17;
                                b bVar2 = bVar;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 14) == 0) {
                                    i17 = (composer5.changed(bVar2) ? 4 : 2) | intValue2;
                                } else {
                                    i17 = intValue2;
                                }
                                if ((i17 & 91) == 18 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2059315044, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsNavigationBar.<anonymous>.<anonymous> (TtsNavigationBar.kt:45)");
                                    }
                                    i.Companion companion2 = i.INSTANCE;
                                    i a16 = bVar2.a(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(companion2, 28.0f), 28.0f / 2), QUIToken.color$default("fill_allblack_weak")), Alignment.CenterStart);
                                    final Function0<Unit> function03 = this.$back;
                                    composer5.startReplaceableGroup(1157296644);
                                    boolean changed = composer5.changed(function03);
                                    Object rememberedValue = composer5.rememberedValue();
                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsNavigationBarKt$TtsNavigationBar$1$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                function03.invoke();
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue);
                                    }
                                    composer5.endReplaceableGroup();
                                    i d16 = ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue, 3, null);
                                    Alignment alignment = Alignment.Center;
                                    BoxKt.a(d16, alignment, null, ComposableSingletons$TtsNavigationBarKt.f23lambda1, composer5, 3128, 4);
                                    TextKt.a("\u58f0\u97f3", bVar2.a(companion2, alignment), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.a(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601606, 0, 0, 134216612);
                                    if (this.$showRight) {
                                        i a17 = bVar2.a(companion2, Alignment.CenterEnd);
                                        final Function0<Unit> function04 = this.$onKeySelect;
                                        composer5.startReplaceableGroup(1157296644);
                                        boolean changed2 = composer5.changed(function04);
                                        Object rememberedValue2 = composer5.rememberedValue();
                                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsNavigationBarKt$TtsNavigationBar$1$1$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    function04.invoke();
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer5.updateRememberedValue(rememberedValue2);
                                        }
                                        composer5.endReplaceableGroup();
                                        BoxKt.a(ViewEventPropUpdaterKt.d(a17, false, null, (Function1) rememberedValue2, 3, null), null, null, ComposableSingletons$TtsNavigationBarKt.f25lambda3, composer5, 3080, 6);
                                    }
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
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 24584, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsNavigationBarKt$TtsNavigationBar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                TtsNavigationBarKt.TtsNavigationBar(z16, function0, function02, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
