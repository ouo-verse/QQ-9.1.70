package com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.Point;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallFloweringGuildViewKt {
    public static final void LoveWallFloweringGuildView(final LoveWallHomepageViewModel loveWallHomepageViewModel, final Function0<Unit> function0, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1297066914);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1297066914, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallFloweringGuildView (LoveWallFloweringGuildView.kt:22)");
        }
        ModalKt.a(null, false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1007637024, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallFloweringGuildViewKt$LoveWallFloweringGuildView$1
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
                        ComposerKt.traceEventStart(1007637024, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallFloweringGuildView.<anonymous> (LoveWallFloweringGuildView.kt:23)");
                    }
                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                    final Function0<Unit> function02 = function0;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed = composer3.changed(function02);
                    Object rememberedValue = composer3.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallFloweringGuildViewKt$LoveWallFloweringGuildView$1$1$1
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
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    BoxKt.a(ViewEventPropUpdaterKt.d(h16, false, null, (Function1) rememberedValue, 3, null), null, null, ComposableLambdaKt.composableLambda(composer3, 929495206, true, new Function3<b, Composer, Integer, Unit>(function0, i3, loveWallHomepageViewModel) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallFloweringGuildViewKt$LoveWallFloweringGuildView$1.2
                        public final /* synthetic */ Function0<Unit> $onNextStep;
                        public final /* synthetic */ LoveWallHomepageViewModel $viewModel;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                            this.$viewModel = r3;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            float f16;
                            Float density;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(929495206, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallFloweringGuildView.<anonymous>.<anonymous> (LoveWallFloweringGuildView.kt:26)");
                                }
                                composer5.startReplaceableGroup(-492369756);
                                Object rememberedValue2 = composer5.rememberedValue();
                                Composer.Companion companion = Composer.INSTANCE;
                                if (rememberedValue2 == companion.getEmpty()) {
                                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                                    composer5.updateRememberedValue(rememberedValue2);
                                }
                                composer5.endReplaceableGroup();
                                final MutableState mutableState = (MutableState) rememberedValue2;
                                composer5.startReplaceableGroup(-492369756);
                                Object rememberedValue3 = composer5.rememberedValue();
                                float f17 = 0.0f;
                                if (rememberedValue3 == companion.getEmpty()) {
                                    rememberedValue3 = new Animatable(Float.valueOf(0.0f));
                                    composer5.updateRememberedValue(rememberedValue3);
                                }
                                composer5.endReplaceableGroup();
                                Animatable animatable = (Animatable) rememberedValue3;
                                if (((Boolean) mutableState.getValue()).booleanValue()) {
                                    composer5.startReplaceableGroup(238937010);
                                    Float valueOf = Float.valueOf(1.0f);
                                    m d16 = com.tencent.ntcompose.animation.b.d(300, 0, null, null, 14, null);
                                    composer5.startReplaceableGroup(1157296644);
                                    boolean changed2 = composer5.changed(mutableState);
                                    Object rememberedValue4 = composer5.rememberedValue();
                                    if (changed2 || rememberedValue4 == companion.getEmpty()) {
                                        rememberedValue4 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallFloweringGuildViewKt$LoveWallFloweringGuildView$1$2$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Float f18) {
                                                f18.floatValue();
                                                mutableState.setValue(Boolean.FALSE);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue4);
                                    }
                                    composer5.endReplaceableGroup();
                                    Animatable.b(animatable, valueOf, d16, (Function1) rememberedValue4, false, 8, null);
                                    composer5.endReplaceableGroup();
                                } else {
                                    composer5.startReplaceableGroup(238937289);
                                    Float valueOf2 = Float.valueOf(0.0f);
                                    m d17 = com.tencent.ntcompose.animation.b.d(300, 1000, null, null, 12, null);
                                    final Function0<Unit> function03 = this.$onNextStep;
                                    composer5.startReplaceableGroup(1157296644);
                                    boolean changed3 = composer5.changed(function03);
                                    Object rememberedValue5 = composer5.rememberedValue();
                                    if (changed3 || rememberedValue5 == companion.getEmpty()) {
                                        rememberedValue5 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallFloweringGuildViewKt$LoveWallFloweringGuildView$1$2$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Float f18) {
                                                f18.floatValue();
                                                function03.invoke();
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue5);
                                    }
                                    composer5.endReplaceableGroup();
                                    Animatable.b(animatable, valueOf2, d17, (Function1) rememberedValue5, false, 8, null);
                                    composer5.endReplaceableGroup();
                                }
                                float dpScaleDensity = PageDataExtKt.getDpScaleDensity(com.tencent.ntcompose.activity.b.a().getPageData());
                                if (com.tencent.ntcompose.activity.b.a().getPageData().getIsIOS() && (density = com.tencent.ntcompose.activity.b.a().getPageData().getDensity()) != null) {
                                    dpScaleDensity *= density.floatValue();
                                }
                                i b16 = ModifiersKt.b(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, 136, 102), ((Number) animatable.f()).floatValue());
                                if (this.$viewModel.sproutFlowerPosition.getValue() == null) {
                                    f16 = 0.0f;
                                } else {
                                    Point value = this.$viewModel.sproutFlowerPosition.getValue();
                                    Intrinsics.checkNotNull(value);
                                    f16 = (value.f114257x / dpScaleDensity) - 100.0f;
                                }
                                if (this.$viewModel.sproutFlowerPosition.getValue() != null) {
                                    float l3 = com.tencent.ntcompose.activity.b.a().getPageData().l();
                                    Point value2 = this.$viewModel.sproutFlowerPosition.getValue();
                                    Intrinsics.checkNotNull(value2);
                                    f17 = (l3 - (value2.f114258y / dpScaleDensity)) - 102.0f;
                                }
                                BoxKt.a(ComposeLayoutPropUpdaterKt.o(b16, f16, f17), null, null, ComposableSingletons$LoveWallFloweringGuildViewKt.f110lambda1, composer5, 3080, 6);
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
        }), startRestartGroup, 24576, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallFloweringGuildViewKt$LoveWallFloweringGuildView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallFloweringGuildViewKt.LoveWallFloweringGuildView(LoveWallHomepageViewModel.this, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
