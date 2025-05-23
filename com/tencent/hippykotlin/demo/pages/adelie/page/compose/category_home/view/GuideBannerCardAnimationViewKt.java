package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQAnimatedImageKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.ktx.LocalConfigurationExtKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.views.LoadSuccessParams;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.animation.b;
import com.tencent.ntcompose.animation.i;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import defpackage.k;
import g25.g;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GuideBannerCardAnimationViewKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void GuideBannerCardAnimationView(final g gVar, final float f16, final float f17, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i3) {
        Float floatOrNull;
        Composer startRestartGroup = composer.startRestartGroup(-1820987216);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1820987216, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationView (GuideBannerCardAnimationView.kt:41)");
        }
        startRestartGroup.startReplaceableGroup(442738356);
        c cVar = c.f117352a;
        if (!k.a(cVar)) {
            floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(cVar.g().getPageData().n().q("topMargin", "0"));
        } else {
            floatOrNull = Float.valueOf(LocalConfigurationExtKt.getQqNavigationBarHeight((a) startRestartGroup.consume(CompositionLocalsKt.d())));
        }
        startRestartGroup.endReplaceableGroup();
        if (floatOrNull != null) {
            floatOrNull.floatValue();
            final float floatValue = floatOrNull.floatValue() + 56.0f;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(1.0f, null, 2, null, startRestartGroup);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState = (MutableState) rememberedValue;
            final State<Float> c16 = AnimateAsStateKt.c(((Number) mutableState.getValue()).floatValue(), b.d(300, 0, null, null, 14, null), null, startRestartGroup, 48, 4);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(1.0f, null, 2, null, startRestartGroup);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            final State<Float> c17 = AnimateAsStateKt.c(((Number) mutableState2.getValue()).floatValue(), b.d(1, 0, null, null, 14, null), null, startRestartGroup, 48, 4);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(1.0f, null, 2, null, startRestartGroup);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState3 = (MutableState) rememberedValue3;
            final State<Float> c18 = AnimateAsStateKt.c(((Number) mutableState3.getValue()).floatValue(), b.d(1000, 0, null, null, 14, null), null, startRestartGroup, 48, 4);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, startRestartGroup);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState4 = (MutableState) rememberedValue4;
            final State<Float> c19 = AnimateAsStateKt.c(((Number) mutableState4.getValue()).floatValue(), b.d(1000, 0, i.a(), null, 10, null), null, startRestartGroup, 0, 4);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(f16, null, 2, null, startRestartGroup);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState5 = (MutableState) rememberedValue5;
            final State<Float> c26 = AnimateAsStateKt.c(((Number) mutableState5.getValue()).floatValue(), b.d(1000, 0, i.a(), null, 10, null), null, startRestartGroup, 0, 4);
            final float f18 = f17 - 10.0f;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(f18, null, 2, null, startRestartGroup);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState6 = (MutableState) rememberedValue6;
            final State<Float> c27 = AnimateAsStateKt.c(((Number) mutableState6.getValue()).floatValue(), b.d(1000, 0, i.a(), null, 10, null), null, startRestartGroup, 0, 4);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(floatValue + 10.0f), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState7 = (MutableState) rememberedValue7;
            float floatValue2 = ((Number) mutableState7.getValue()).floatValue();
            m d16 = b.d(1000, 0, i.a(), null, 10, null);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(function02);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$GuideBannerCardAnimationView$topMarginAnim$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Float f19) {
                        if (f19.floatValue() == 0.0f) {
                            function02.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            startRestartGroup.endReplaceableGroup();
            final State<Float> c28 = AnimateAsStateKt.c(floatValue2, d16, (Function1) rememberedValue8, startRestartGroup, 0, 0);
            ModalKt.a(ModifiersKt.c(com.tencent.ntcompose.core.i.INSTANCE, h.INSTANCE.a(0.4f)), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -15875598, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$GuideBannerCardAnimationView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-15875598, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationView.<anonymous> (GuideBannerCardAnimationView.kt:116)");
                        }
                        com.tencent.ntcompose.core.i f19 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null);
                        final float f26 = f16;
                        final float f27 = f17;
                        final float f28 = floatValue;
                        final State<Float> state = c26;
                        final State<Float> state2 = c27;
                        final State<Float> state3 = c28;
                        final g gVar2 = gVar;
                        final MutableState<Float> mutableState8 = mutableState2;
                        final MutableState<Float> mutableState9 = mutableState;
                        final MutableState<Float> mutableState10 = mutableState3;
                        final MutableState<Float> mutableState11 = mutableState4;
                        final float f29 = f18;
                        final MutableState<Float> mutableState12 = mutableState5;
                        final MutableState<Float> mutableState13 = mutableState6;
                        final MutableState<Float> mutableState14 = mutableState7;
                        final Function0<Unit> function03 = function0;
                        final State<Float> state4 = c17;
                        final State<Float> state5 = c16;
                        final State<Float> state6 = c18;
                        final State<Float> state7 = c19;
                        final float f36 = 10.0f;
                        BoxKt.a(f19, null, null, ComposableLambdaKt.composableLambda(composer3, -1791552776, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$GuideBannerCardAnimationView$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1791552776, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationView.<anonymous>.<anonymous> (GuideBannerCardAnimationView.kt:119)");
                                    }
                                    final float e16 = (((a) composer5.consume(CompositionLocalsKt.d())).e() - state.getValue().floatValue()) / 2;
                                    i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                    com.tencent.ntcompose.core.i r16 = ModifiersKt.r(ComposeLayoutPropUpdaterKt.n(ModifiersKt.q(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, state.getValue().floatValue()), state2.getValue().floatValue()), uo3.c.a(8.0f)), e16, state3.getValue().floatValue(), 0.0f, 0.0f, 12, null), true);
                                    final g gVar3 = gVar2;
                                    final MutableState<Float> mutableState15 = mutableState8;
                                    final MutableState<Float> mutableState16 = mutableState9;
                                    final MutableState<Float> mutableState17 = mutableState10;
                                    final MutableState<Float> mutableState18 = mutableState11;
                                    final float f37 = f29;
                                    final float f38 = f28;
                                    final float f39 = f36;
                                    final MutableState<Float> mutableState19 = mutableState12;
                                    final MutableState<Float> mutableState20 = mutableState13;
                                    final MutableState<Float> mutableState21 = mutableState14;
                                    final Function0<Unit> function04 = function03;
                                    final State<Float> state8 = state3;
                                    BoxKt.a(r16, null, null, ComposableLambdaKt.composableLambda(composer5, 848791934, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt.GuideBannerCardAnimationView.2.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(848791934, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationView.<anonymous>.<anonymous>.<anonymous> (GuideBannerCardAnimationView.kt:126)");
                                                }
                                                i.Companion companion3 = com.tencent.ntcompose.core.i.INSTANCE;
                                                c cVar2 = c.f117352a;
                                                com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion3, cVar2.g().getPageData().h()), cVar2.g().getPageData().g()), -e16, -state8.getValue().floatValue(), 0.0f, 0.0f, 12, null);
                                                String str = gVar3.f401158e;
                                                int b16 = com.tencent.ntcompose.material.h.INSTANCE.b();
                                                boolean z16 = false;
                                                final MutableState<Float> mutableState22 = mutableState19;
                                                final MutableState<Float> mutableState23 = mutableState20;
                                                final MutableState<Float> mutableState24 = mutableState21;
                                                final Function0<Unit> function05 = function04;
                                                Object[] objArr = {mutableState15, mutableState16, mutableState17, mutableState18, Float.valueOf(f37), Float.valueOf(f38), Float.valueOf(f39), mutableState22, mutableState23, mutableState24, function05};
                                                final float f46 = f37;
                                                final float f47 = f38;
                                                final float f48 = f39;
                                                final MutableState<Float> mutableState25 = mutableState15;
                                                final MutableState<Float> mutableState26 = mutableState16;
                                                final MutableState<Float> mutableState27 = mutableState17;
                                                final MutableState<Float> mutableState28 = mutableState18;
                                                composer7.startReplaceableGroup(-568225417);
                                                for (int i16 = 0; i16 < 11; i16++) {
                                                    z16 |= composer7.changed(objArr[i16]);
                                                }
                                                Object rememberedValue9 = composer7.rememberedValue();
                                                if (z16 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue9 = new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$GuideBannerCardAnimationView$2$1$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                                            MutableState<Float> mutableState29 = mutableState25;
                                                            Float valueOf = Float.valueOf(0.0f);
                                                            mutableState29.setValue(valueOf);
                                                            mutableState26.setValue(valueOf);
                                                            mutableState27.setValue(valueOf);
                                                            MutableState<Float> mutableState30 = mutableState28;
                                                            c cVar3 = c.f117352a;
                                                            mutableState30.setValue(Float.valueOf((cVar3.g().getPageData().g() - f46) - (f47 + f48)));
                                                            mutableState22.setValue(Float.valueOf(cVar3.g().getPageData().h()));
                                                            mutableState23.setValue(Float.valueOf(cVar3.g().getPageData().g()));
                                                            mutableState24.setValue(valueOf);
                                                            function05.invoke();
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer7.updateRememberedValue(rememberedValue9);
                                                }
                                                composer7.endReplaceableGroup();
                                                ImageKt.a(null, null, null, null, null, n3, null, b16, null, null, str, null, null, null, null, null, (Function1) rememberedValue9, null, null, null, null, composer7, 12845056, 0, 0, 2030431);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3080, 6);
                                    com.tencent.ntcompose.core.i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, f26), f27), 16.0f, f28, 16.0f, 0.0f, 8, null);
                                    final float f46 = f26;
                                    final float f47 = f27;
                                    final g gVar4 = gVar2;
                                    final State<Float> state9 = state4;
                                    final State<Float> state10 = state5;
                                    final State<Float> state11 = state6;
                                    final State<Float> state12 = state7;
                                    BoxKt.a(s16, null, null, ComposableLambdaKt.composableLambda(composer5, 796240501, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt.GuideBannerCardAnimationView.2.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer6, Integer num3) {
                                            float floatValue3;
                                            float floatValue4;
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(796240501, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationView.<anonymous>.<anonymous>.<anonymous> (GuideBannerCardAnimationView.kt:153)");
                                                }
                                                i.Companion companion3 = com.tencent.ntcompose.core.i.INSTANCE;
                                                QQAnimatedImageKt.QQAnimatedImage(gVar4.f401157d, ModifiersKt.v(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion3, f46), f47), null, null, Float.valueOf(state9.getValue().floatValue()), null, null, null, null, null, null, null, null, null, 4091, null), false, null, composer7, 64, 12);
                                                QQAnimatedImageKt.QQAnimatedImage(gVar4.f401159f, ModifiersKt.v(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion3, f46), f47), null, null, Float.valueOf(state10.getValue().floatValue()), null, null, null, null, null, null, null, null, null, 4091, null), false, null, composer7, 64, 12);
                                                String str = gVar4.f401160h;
                                                com.tencent.ntcompose.core.i s17 = ComposeLayoutPropUpdaterKt.s(companion3, 16.0f, f47 * 0.42f, 0.0f, 0.0f, 12, null);
                                                floatValue3 = ((Number) state11.getValue()).floatValue();
                                                Float valueOf = Float.valueOf(floatValue3);
                                                floatValue4 = ((Number) state12.getValue()).floatValue();
                                                TextKt.a(str, ModifiersKt.v(s17, null, null, valueOf, null, Float.valueOf(floatValue4), null, null, null, null, null, null, null, 4075, null), null, h.INSTANCE.m(), Float.valueOf(20.0f), null, bp3.c.INSTANCE.f(), null, null, null, null, Float.valueOf(28.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 1601600, 48, 0, 134215588);
                                                com.tencent.ntcompose.core.i s18 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion3, 323.0f), 16.0f), 10.0f, f47 * 0.8f, 0.0f, 0.0f, 12, null);
                                                final g gVar5 = gVar4;
                                                final State<Float> state13 = state11;
                                                final State<Float> state14 = state12;
                                                RowKt.a(s18, null, null, null, null, ComposableLambdaKt.composableLambda(composer7, 1243633687, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt.GuideBannerCardAnimationView.2.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(n nVar, Composer composer8, Integer num4) {
                                                        float floatValue5;
                                                        float floatValue6;
                                                        float floatValue7;
                                                        float floatValue8;
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1243633687, intValue4, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GuideBannerCardAnimationView.kt:180)");
                                                            }
                                                            List<String> list = g.this.C;
                                                            State<Float> state15 = state13;
                                                            State<Float> state16 = state14;
                                                            int i16 = 0;
                                                            int i17 = 0;
                                                            for (Object obj : list) {
                                                                int i18 = i17 + 1;
                                                                if (i17 < 0) {
                                                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                                }
                                                                String str2 = (String) obj;
                                                                composer9.startReplaceableGroup(1189299505);
                                                                if (i17 != 0) {
                                                                    com.tencent.ntcompose.core.i c29 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(com.tencent.ntcompose.core.i.INSTANCE, 0.6f), 16.0f), new h(225, 225, 225, 0.4f));
                                                                    floatValue7 = ((Number) state15.getValue()).floatValue();
                                                                    Float valueOf2 = Float.valueOf(floatValue7);
                                                                    floatValue8 = ((Number) state16.getValue()).floatValue();
                                                                    SpacerKt.a(ModifiersKt.v(c29, null, null, valueOf2, null, Float.valueOf(floatValue8), null, null, null, null, null, null, null, 4075, null), composer9, 8, i16);
                                                                }
                                                                composer9.endReplaceableGroup();
                                                                h m3 = h.INSTANCE.m();
                                                                com.tencent.ntcompose.core.i r17 = ComposeLayoutPropUpdaterKt.r(com.tencent.ntcompose.core.i.INSTANCE, 6.0f, 2.0f, 6.0f, 2.0f);
                                                                floatValue5 = ((Number) state15.getValue()).floatValue();
                                                                Float valueOf3 = Float.valueOf(floatValue5);
                                                                floatValue6 = ((Number) state16.getValue()).floatValue();
                                                                Composer composer10 = composer9;
                                                                TextKt.a(str2, ModifiersKt.v(r17, null, null, valueOf3, null, Float.valueOf(floatValue6), null, null, null, null, null, null, null, 4075, null), null, m3, Float.valueOf(10.0f), null, null, null, null, null, null, Float.valueOf(12.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer10, 28736, 48, 0, 134215652);
                                                                i17 = i18;
                                                                i16 = i16;
                                                                state16 = state16;
                                                                state15 = state15;
                                                                composer9 = composer10;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 196616, 30);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3080, 6);
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
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$GuideBannerCardAnimationView$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    GuideBannerCardAnimationViewKt.GuideBannerCardAnimationView(g.this, f16, f17, function0, function02, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$GuideBannerCardAnimationView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                GuideBannerCardAnimationViewKt.GuideBannerCardAnimationView(g.this, f16, f17, function0, function02, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
