package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.LoadSuccessParams;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import g25.g;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GuideCardKt {
    public static final void GuideCard(final g gVar, final float f16, final float f17, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1371321602);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1371321602, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideCard (GuideCard.kt:31)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState2 = (MutableState) rememberedValue2;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState3 = (MutableState) rememberedValue3;
        EffectsKt.LaunchedEffect(Unit.INSTANCE, new GuideCardKt$GuideCard$1(null), startRestartGroup, 64);
        i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, f16), f17);
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(function0);
        Object rememberedValue4 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideCardKt$GuideCard$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    function0.invoke();
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
        }
        startRestartGroup.endReplaceableGroup();
        BoxKt.a(ViewEventPropUpdaterKt.g(k3, (Function1) rememberedValue4), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1231880764, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideCardKt$GuideCard$3
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
                        ComposerKt.traceEventStart(1231880764, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideCard.<anonymous> (GuideCard.kt:48)");
                    }
                    i f18 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null);
                    String str = g.this.f401157d;
                    final MutableState<Boolean> mutableState4 = mutableState;
                    boolean z16 = false;
                    final MutableState<Boolean> mutableState5 = mutableState2;
                    final MutableState<Boolean> mutableState6 = mutableState3;
                    final Function0<Unit> function03 = function02;
                    Object[] objArr = {mutableState4, mutableState5, mutableState6, function03};
                    composer3.startReplaceableGroup(-568225417);
                    int i16 = 0;
                    boolean z17 = false;
                    for (int i17 = 4; i16 < i17; i17 = 4) {
                        z17 |= composer3.changed(objArr[i16]);
                        i16++;
                    }
                    Object rememberedValue5 = composer3.rememberedValue();
                    if (z17 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideCardKt$GuideCard$3$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                mutableState4.setValue(Boolean.TRUE);
                                if (mutableState4.getValue().booleanValue() && mutableState5.getValue().booleanValue() && mutableState6.getValue().booleanValue()) {
                                    function03.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue5);
                    }
                    composer3.endReplaceableGroup();
                    ImageKt.a(null, null, null, null, null, f18, null, 0, null, null, str, null, null, null, null, null, (Function1) rememberedValue5, null, null, null, null, composer3, 262144, 0, 0, 2030559);
                    i f19 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null);
                    String str2 = g.this.f401159f;
                    final MutableState<Boolean> mutableState7 = mutableState2;
                    final MutableState<Boolean> mutableState8 = mutableState;
                    final MutableState<Boolean> mutableState9 = mutableState3;
                    final Function0<Unit> function04 = function02;
                    Object[] objArr2 = {mutableState7, mutableState8, mutableState9, function04};
                    composer3.startReplaceableGroup(-568225417);
                    int i18 = 0;
                    for (int i19 = 4; i18 < i19; i19 = 4) {
                        z16 |= composer3.changed(objArr2[i18]);
                        i18++;
                    }
                    Object rememberedValue6 = composer3.rememberedValue();
                    if (z16 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue6 = new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideCardKt$GuideCard$3$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                mutableState7.setValue(Boolean.TRUE);
                                if (mutableState8.getValue().booleanValue() && mutableState7.getValue().booleanValue() && mutableState9.getValue().booleanValue()) {
                                    function04.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue6);
                    }
                    composer3.endReplaceableGroup();
                    ImageKt.a(null, null, null, null, null, f19, null, 0, null, null, str2, null, null, null, null, null, (Function1) rememberedValue6, null, null, null, null, composer3, 262144, 0, 0, 2030559);
                    String str3 = g.this.f401160h;
                    i.Companion companion2 = i.INSTANCE;
                    TextKt.a(str3, ComposeLayoutPropUpdaterKt.s(companion2, 16.0f, f17 * 0.42f, 0.0f, 0.0f, 12, null), null, h.INSTANCE.m(), Float.valueOf(20.0f), null, c.INSTANCE.f(), null, null, null, null, Float.valueOf(28.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 48, 0, 134215588);
                    i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 323.0f), 16.0f), 10.0f, f17 * 0.8f, 0.0f, 0.0f, 12, null);
                    final g gVar2 = g.this;
                    RowKt.a(s16, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -2021607078, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideCardKt$GuideCard$3.3
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2021607078, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideCard.<anonymous>.<anonymous> (GuideCard.kt:80)");
                                }
                                int i26 = 0;
                                int i27 = 0;
                                for (Object obj : g.this.C) {
                                    int i28 = i27 + 1;
                                    if (i27 < 0) {
                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                    }
                                    String str4 = (String) obj;
                                    composer5.startReplaceableGroup(-736419764);
                                    if (i27 != 0) {
                                        SpacerKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 0.6f), 16.0f), new h(225, 225, 225, 0.4f)), composer5, 8, i26);
                                    }
                                    composer5.endReplaceableGroup();
                                    Composer composer6 = composer5;
                                    TextKt.a(str4, ComposeLayoutPropUpdaterKt.r(i.INSTANCE, 6.0f, 2.0f, 6.0f, 2.0f), null, h.INSTANCE.m(), Float.valueOf(10.0f), null, null, null, null, null, null, Float.valueOf(12.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer6, 28736, 48, 0, 134215652);
                                    i27 = i28;
                                    i26 = i26;
                                    composer5 = composer6;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196616, 30);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideCardKt$GuideCard$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                GuideCardKt.GuideCard(g.this, f16, f17, function0, function02, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
