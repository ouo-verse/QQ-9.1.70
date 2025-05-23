package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallTreeUpgradeAnimationKt {
    public static final void LoveWallTreeUpgradeAnimation(final LoveWallHomepageViewModel loveWallHomepageViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-354465166);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-354465166, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallTreeUpgradeAnimation (LoveWallTreeUpgradeAnimation.kt:20)");
        }
        if (loveWallHomepageViewModel.playTreeUpgradeAnimation.getValue().booleanValue()) {
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Animatable(Float.valueOf(0.0f));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            Animatable animatable = (Animatable) rememberedValue;
            EffectsKt.LaunchedEffect(animatable, new LoveWallTreeUpgradeAnimationKt$LoveWallTreeUpgradeAnimation$1(animatable, null), startRestartGroup, Animatable.f339143c | 64);
            ModalKt.a(ModifiersKt.D(ModifiersKt.d(i.INSTANCE, h.INSTANCE.a(0.7f)), ((Number) animatable.f()).floatValue()), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -429377397, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallTreeUpgradeAnimationKt$LoveWallTreeUpgradeAnimation$2
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
                            ComposerKt.traceEventStart(-429377397, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallTreeUpgradeAnimation.<anonymous> (LoveWallTreeUpgradeAnimation.kt:29)");
                        }
                        final LoveWallHomepageViewModel loveWallHomepageViewModel2 = LoveWallHomepageViewModel.this;
                        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallTreeUpgradeAnimationKt$LoveWallTreeUpgradeAnimation$2$nextStep$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                Function0<Unit> function02 = LoveWallHomepageViewModel.this.onTreeUpgradeAnimationFinish;
                                if (function02 != null) {
                                    function02.invoke();
                                }
                                LoveWallHomepageViewModel.this.playTreeUpgradeAnimation.setValue(Boolean.FALSE);
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.startReplaceableGroup(-492369756);
                        Object rememberedValue2 = composer3.rememberedValue();
                        Composer.Companion companion = Composer.INSTANCE;
                        if (rememberedValue2 == companion.getEmpty()) {
                            rememberedValue2 = new Animatable(Float.valueOf(1.0f));
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        final Animatable animatable2 = (Animatable) rememberedValue2;
                        i D = ModifiersKt.D(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), ((Number) animatable2.f()).floatValue());
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed = composer3.changed(function0);
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changed || rememberedValue3 == companion.getEmpty()) {
                            rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallTreeUpgradeAnimationKt$LoveWallTreeUpgradeAnimation$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ClickParams clickParams) {
                                    function0.invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        BoxKt.a(ViewEventPropUpdaterKt.d(D, false, null, (Function1) rememberedValue3, 3, null), Alignment.Center, null, ComposableLambdaKt.composableLambda(composer3, 1443193541, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallTreeUpgradeAnimationKt$LoveWallTreeUpgradeAnimation$2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1443193541, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallTreeUpgradeAnimation.<anonymous>.<anonymous> (LoveWallTreeUpgradeAnimation.kt:38)");
                                    }
                                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                    final Animatable<Float> animatable3 = animatable2;
                                    final Function0<Unit> function02 = function0;
                                    APNGKt.a(h16, null, "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/social_tree/guild/tree_upgrade_animation.png", 1, null, null, null, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallTreeUpgradeAnimationKt.LoveWallTreeUpgradeAnimation.2.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Object obj) {
                                            Animatable<Float> animatable4 = animatable3;
                                            Float valueOf = Float.valueOf(0.0f);
                                            m d16 = com.tencent.ntcompose.animation.b.d(500, 0, null, null, 14, null);
                                            final Function0<Unit> function03 = function02;
                                            Animatable.b(animatable4, valueOf, d16, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallTreeUpgradeAnimationKt.LoveWallTreeUpgradeAnimation.2.2.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Float f16) {
                                                    f16.floatValue();
                                                    function03.invoke();
                                                    return Unit.INSTANCE;
                                                }
                                            }, false, 8, null);
                                            return Unit.INSTANCE;
                                        }
                                    }, composer5, 3464, 114);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3128, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 24584, 14);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallTreeUpgradeAnimationKt$LoveWallTreeUpgradeAnimation$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallTreeUpgradeAnimationKt.LoveWallTreeUpgradeAnimation(LoveWallHomepageViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
