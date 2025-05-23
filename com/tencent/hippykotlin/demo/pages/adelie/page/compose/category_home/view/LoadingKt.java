package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class LoadingKt {
    public static final float LoadingIcon$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    public static final void LoadingView(final boolean z16, final String str, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(1612324960);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(z16) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i16 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1612324960, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.LoadingView (Loading.kt:32)");
            }
            RowKt.a(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), a.f339245a.b(), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 97935234, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.LoadingKt$LoadingView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(n nVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(97935234, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.LoadingView.<anonymous> (Loading.kt:36)");
                        }
                        composer3.startReplaceableGroup(1328300098);
                        if (z16) {
                            LoadingKt.LoadingIcon(composer3, 0);
                        }
                        composer3.endReplaceableGroup();
                        TextKt.a(str, ComposeLayoutPropUpdaterKt.n(i.INSTANCE, z16 ? 4.0f : 0.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, ((i16 >> 3) & 14) | 1601600, 48, 0, 134214564);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 196680, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.LoadingKt$LoadingView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoadingKt.LoadingView(z16, str, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void LoadingIcon(Composer composer, final int i3) {
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(412687849);
        if (i3 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(412687849, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.LoadingIcon (Loading.kt:56)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, startRestartGroup);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState = (MutableState) rememberedValue;
            final State<Float> c16 = AnimateAsStateKt.c(((Number) mutableState.getValue()).floatValue(), new m(1000, 0, com.tencent.ntcompose.animation.i.c(), true, null, 18, null), null, startRestartGroup, 0, 4);
            Float valueOf = Float.valueOf(LoadingIcon$lambda$3(c16));
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed(c16) | startRestartGroup.changed(mutableState);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.LoadingKt$LoadingIcon$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        if (c16.getValue().floatValue() == 0.0f) {
                            mutableState.setValue(Float.valueOf(360.0f));
                        }
                        return new DisposableEffectResult() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.LoadingKt$LoadingIcon$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public final void dispose() {
                            }
                        };
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(valueOf, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, startRestartGroup, 0);
            composer2 = startRestartGroup;
            ImageKt.a(null, null, null, null, null, ModifiersKt.v(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), null, null, null, null, null, null, Float.valueOf(c16.getValue().floatValue()), null, null, null, null, null, 4031, null), null, h.INSTANCE.b(), null, null, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAAP1BMVEUAAACZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmampqZmZmZmZmZmZmZmZmZmZmYmJiYmJiZmZmZmZmZmZlYmfmEAAAAFXRSTlMAaz3f982oj4O2IJt4MMBYFAtg6koagBLIAAAB30lEQVRIx+3W23arIBAG4AwEgQFEkPd/1j0ztmvXQ4Tmpr3on5ss8XOcCMTHX35LUgaoWaXyLbWdjbkCJcYIaRmlqJSSwvUTO+fyEF+SUk3hrjJha9uYZS2lBW+W4rrFMYnGj+YLpgYfONjUrcwY9xfMYkOY8j0uVBrL6ZKZLGHSHX7djiNLUS9r4l0/bpJc/2rU660urL23L6YG6dt+7OQp+WJEbLp/EoHxVM4DitOZBsn7eZ7rNcZHJ3Gm+HPpRLj08ELWGLgYGFk30VDCu/uD4ZQ39cw4v4md0VrHN3HVFHtciTiGFeP5sE/mnIYwMja7Q5kzjvUB15zLEF5XvR5wpQxizhnjCFZPitkfAkoawcDYn7EawYGx3XcCnBGsGbf9PiIYR1rmHE7MABHa4F2b4xWBdCw9i1L4OJ0KRErrF+bgqZnI6XTdxAb+ei7tYLmzaJ7PVQqfSzsK3LRd/LqSjVdj4O40W61Jm+ttdXsDeHXnyJY+eD2cnCVs3eWwmrVm3V5OH7KceiqOTm+Bm8knNoQAuL8lY7TpWD6NLGey0NJCUTl6Q2Hb268XZ8VKPEX+nDY99RdOExz+4089tGKXGjb6Fc/y/Ie4cqIFc+yO9n2qLpCdJgetPP7y8/kHnf8Ykz05V+cAAAAASUVORK5CYII=", null, null, null, null, null, null, null, null, null, null, composer2, 12845056, 6, 0, 2095967);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.LoadingKt$LoadingIcon$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer3, Integer num) {
                num.intValue();
                LoadingKt.LoadingIcon(composer3, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
