package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import ap3.a;
import ap3.d;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieMyTtsVoiceState;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import yo3.Offset;

/* loaded from: classes31.dex */
public final class TtsListCellMyOPKt {
    public static final float Loading$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    public static final void Error(final Function0<Unit> function0, Composer composer, final int i3) {
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1182181111);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(function0) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1182181111, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.Error (TtsListCellMyOP.kt:129)");
            }
            i w3 = ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 44.0f), 36.0f);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(function0);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellMyOPKt$Error$1$1
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
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            BoxKt.a(ViewEventPropUpdaterKt.d(w3, false, null, (Function1) rememberedValue, 3, null), Alignment.Center, null, ComposableSingletons$TtsListCellMyOPKt.f22lambda2, startRestartGroup, 3128, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellMyOPKt$Error$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                TtsListCellMyOPKt.Error(function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void MoreAction(final AdelieTtsInfo adelieTtsInfo, final Function2<? super AdelieTtsInfo, ? super Offset, Unit> function2, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(73831769);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(73831769, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.MoreAction (TtsListCellMyOP.kt:102)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        i w3 = ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 44.0f), 38.0f);
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(mutableState);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellMyOPKt$MoreAction$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(a aVar) {
                    mutableState.setValue(aVar);
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        BoxKt.a(ViewEventPropUpdaterKt.d(ViewEventPropUpdaterKt.k(w3, (Function1) rememberedValue2), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellMyOPKt$MoreAction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                a value = mutableState.getValue();
                if (value != null) {
                    function2.invoke(adelieTtsInfo, d.c(value));
                    KLog.INSTANCE.i("LazyListScope.TtsList MoreAction Position", "click offset=" + value + ".positionInRoot()");
                }
                return Unit.INSTANCE;
            }
        }, 3, null), Alignment.CenterStart, null, ComposableSingletons$TtsListCellMyOPKt.f21lambda1, startRestartGroup, 3128, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellMyOPKt$MoreAction$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                TtsListCellMyOPKt.MoreAction(AdelieTtsInfo.this, function2, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void TtsListCellMyOP(final AdelieTtsInfo adelieTtsInfo, final Function1<? super AdelieTtsInfo, Unit> function1, final Function2<? super AdelieTtsInfo, ? super Offset, Unit> function2, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-1800056525);
        if ((i16 & 2) != 0) {
            function1 = null;
        }
        if ((i16 & 4) != 0) {
            function2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1800056525, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellMyOP (TtsListCellMyOP.kt:38)");
        }
        RowKt.a(ComposeLayoutPropUpdaterKt.B(ComposeLayoutPropUpdaterKt.z(i.INSTANCE)), null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -483837103, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellMyOPKt$TtsListCellMyOP$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x0098  */
            @Override // kotlin.jvm.functions.Function3
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-483837103, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellMyOP.<anonymous> (TtsListCellMyOP.kt:45)");
                    }
                    int ordinal = AdelieTtsInfo.this.getState().ordinal();
                    if (ordinal != 0) {
                        if (ordinal == 1) {
                            composer3.startReplaceableGroup(-280523585);
                            TtsListCellMyOPKt.Loading(composer3, 0);
                            composer3.endReplaceableGroup();
                        } else if (ordinal != 2 && ordinal != 3) {
                            composer3.startReplaceableGroup(-280522696);
                            composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    composer3.startReplaceableGroup(-280523414);
                    RowKt.a(ComposeLayoutPropUpdaterKt.B(ComposeLayoutPropUpdaterKt.z(i.INSTANCE)), null, Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer3, 1994284014, true, new Function3<n, Composer, Integer, Unit>(function2, i3, function1) { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellMyOPKt$TtsListCellMyOP$1.1
                        public final /* synthetic */ Function2<AdelieTtsInfo, Offset, Unit> $onMore;
                        public final /* synthetic */ Function1<AdelieTtsInfo, Unit> $onRetry;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                            this.$onRetry = r4;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar2, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1994284014, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellMyOP.<anonymous>.<anonymous> (TtsListCellMyOP.kt:57)");
                                }
                                if (AdelieTtsInfo.this.getState() != AdelieMyTtsVoiceState.ERROR && AdelieTtsInfo.this.getState() != AdelieMyTtsVoiceState.CANNOT) {
                                    composer5.startReplaceableGroup(-651389364);
                                    TtsListCellSelectKt.TtsListCellSelect(AdelieTtsInfo.this, composer5, 8);
                                    composer5.endReplaceableGroup();
                                } else {
                                    composer5.startReplaceableGroup(-651389504);
                                    final Function1<AdelieTtsInfo, Unit> function12 = this.$onRetry;
                                    final AdelieTtsInfo adelieTtsInfo2 = AdelieTtsInfo.this;
                                    TtsListCellMyOPKt.Error(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellMyOPKt.TtsListCellMyOP.1.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            Function1<AdelieTtsInfo, Unit> function13 = function12;
                                            if (function13 != null) {
                                                function13.invoke(adelieTtsInfo2);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }, composer5, 0);
                                    composer5.endReplaceableGroup();
                                }
                                AdelieTtsInfo adelieTtsInfo3 = AdelieTtsInfo.this;
                                final Function2<AdelieTtsInfo, Offset, Unit> function22 = this.$onMore;
                                composer5.startReplaceableGroup(1157296644);
                                boolean changed = composer5.changed(function22);
                                Object rememberedValue = composer5.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function2<AdelieTtsInfo, Offset, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellMyOPKt$TtsListCellMyOP$1$1$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(AdelieTtsInfo adelieTtsInfo4, Offset offset) {
                                            AdelieTtsInfo adelieTtsInfo5 = adelieTtsInfo4;
                                            Offset offset2 = offset;
                                            Function2<AdelieTtsInfo, Offset, Unit> function23 = function22;
                                            if (function23 != null) {
                                                function23.invoke(adelieTtsInfo5, offset2);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue);
                                }
                                composer5.endReplaceableGroup();
                                TtsListCellMyOPKt.MoreAction(adelieTtsInfo3, (Function2) rememberedValue, composer5, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196616, 26);
                    composer3.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196616, 30);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Function1<? super AdelieTtsInfo, Unit> function12 = function1;
        final Function2<? super AdelieTtsInfo, ? super Offset, Unit> function22 = function2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellMyOPKt$TtsListCellMyOP$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                TtsListCellMyOPKt.TtsListCellMyOP(AdelieTtsInfo.this, function12, function22, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void Loading(Composer composer, final int i3) {
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(431410073);
        if (i3 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(431410073, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.Loading (TtsListCellMyOP.kt:75)");
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
            Float valueOf = Float.valueOf(Loading$lambda$3(c16));
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed(c16) | startRestartGroup.changed(mutableState);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellMyOPKt$Loading$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        if (c16.getValue().floatValue() == 0.0f) {
                            mutableState.setValue(Float.valueOf(360.0f));
                        }
                        return new DisposableEffectResult() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellMyOPKt$Loading$1$1$invoke$$inlined$onDispose$1
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
            ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ModifiersKt.v(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), null, null, null, null, null, null, Float.valueOf(c16.getValue().floatValue()), null, null, null, null, null, 4031, null), 0.0f, 0.0f, 12.0f, 0.0f, 11, null), null, h.INSTANCE.b(), null, null, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAAP1BMVEUAAACZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmampqZmZmZmZmZmZmZmZmZmZmYmJiYmJiZmZmZmZmZmZlYmfmEAAAAFXRSTlMAaz3f982oj4O2IJt4MMBYFAtg6koagBLIAAAB30lEQVRIx+3W23arIBAG4AwEgQFEkPd/1j0ztmvXQ4Tmpr3on5ss8XOcCMTHX35LUgaoWaXyLbWdjbkCJcYIaRmlqJSSwvUTO+fyEF+SUk3hrjJha9uYZS2lBW+W4rrFMYnGj+YLpgYfONjUrcwY9xfMYkOY8j0uVBrL6ZKZLGHSHX7djiNLUS9r4l0/bpJc/2rU660urL23L6YG6dt+7OQp+WJEbLp/EoHxVM4DitOZBsn7eZ7rNcZHJ3Gm+HPpRLj08ELWGLgYGFk30VDCu/uD4ZQ39cw4v4md0VrHN3HVFHtciTiGFeP5sE/mnIYwMja7Q5kzjvUB15zLEF5XvR5wpQxizhnjCFZPitkfAkoawcDYn7EawYGx3XcCnBGsGbf9PiIYR1rmHE7MABHa4F2b4xWBdCw9i1L4OJ0KRErrF+bgqZnI6XTdxAb+ei7tYLmzaJ7PVQqfSzsK3LRd/LqSjVdj4O40W61Jm+ttdXsDeHXnyJY+eD2cnCVs3eWwmrVm3V5OH7KceiqOTm+Bm8knNoQAuL8lY7TpWD6NLGey0NJCUTl6Q2Hb268XZ8VKPEX+nDY99RdOExz+4089tGKXGjb6Fc/y/Ie4cqIFc+yO9n2qLpCdJgetPP7y8/kHnf8Ykz05V+cAAAAASUVORK5CYII=", null, null, null, null, null, null, null, null, null, null, composer2, 12845056, 6, 0, 2095967);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListCellMyOPKt$Loading$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer3, Integer num) {
                num.intValue();
                TtsListCellMyOPKt.Loading(composer3, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
