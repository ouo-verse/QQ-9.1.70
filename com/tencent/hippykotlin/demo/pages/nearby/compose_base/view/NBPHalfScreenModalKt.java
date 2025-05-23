package com.tencent.hippykotlin.demo.pages.nearby.compose_base.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.animation.b;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.HoverKt;
import com.tencent.ntcompose.material.LazyColumnKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPHalfScreenModalKt {
    public static final boolean NBPHalfScreenModal$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NBPHalfScreenModal(i iVar, float f16, Boolean bool, final Function1<? super Boolean, Unit> function1, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i3, final int i16) {
        float f17;
        Boolean bool2;
        i iVar2;
        int i17;
        final float f18;
        Object rememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        boolean changed;
        Object rememberedValue2;
        h color$default;
        boolean changed2;
        Object rememberedValue3;
        boolean changed3;
        Object rememberedValue4;
        final i iVar3;
        Composer composer2;
        final Boolean bool3;
        final float f19;
        ScopeUpdateScope endRestartGroup;
        int i18;
        Composer startRestartGroup = composer.startRestartGroup(-117754394);
        int i19 = i16 & 1;
        int i26 = i19 != 0 ? i3 | 2 : i3;
        if ((i3 & 112) == 0) {
            if ((i16 & 2) == 0) {
                f17 = f16;
                if (startRestartGroup.changed(f17)) {
                    i18 = 32;
                    i26 |= i18;
                }
            } else {
                f17 = f16;
            }
            i18 = 16;
            i26 |= i18;
        } else {
            f17 = f16;
        }
        int i27 = i16 & 4;
        if (i27 != 0) {
            i26 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i3 & 896) == 0) {
            bool2 = bool;
            i26 |= startRestartGroup.changed(bool2) ? 256 : 128;
            if ((i16 & 8) == 0) {
                i26 |= 3072;
            } else if ((i3 & 7168) == 0) {
                i26 |= startRestartGroup.changed(function1) ? 2048 : 1024;
            }
            if ((i16 & 16) == 0) {
                i26 |= 24576;
            } else if ((57344 & i3) == 0) {
                i26 |= startRestartGroup.changed(function0) ? 16384 : 8192;
            }
            if ((i16 & 32) == 0) {
                i26 |= 196608;
            } else if ((458752 & i3) == 0) {
                i26 |= startRestartGroup.changed(function2) ? 131072 : 65536;
            }
            if (i19 != 1 && (374491 & i26) == 74898 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                iVar3 = iVar;
                f19 = f17;
                bool3 = bool2;
                composer2 = startRestartGroup;
            } else {
                startRestartGroup.startDefaults();
                if ((i3 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                    startRestartGroup.skipToGroupEnd();
                    if ((i16 & 2) != 0) {
                        iVar2 = iVar;
                        i17 = i26 & (-113);
                        f18 = f17;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final float d16 = ((a) startRestartGroup.consume(CompositionLocalsKt.d())).d();
                        startRestartGroup.startReplaceableGroup(-492369756);
                        rememberedValue = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (rememberedValue == companion.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) rememberedValue;
                        if (NBPHalfScreenModal$lambda$1(mutableState)) {
                        }
                        m d17 = b.d(150, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null);
                        Float valueOf = Float.valueOf(f18);
                        startRestartGroup.startReplaceableGroup(1618982084);
                        changed = startRestartGroup.changed(valueOf) | startRestartGroup.changed(mutableState) | startRestartGroup.changed(function0);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue2 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$offset$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Float f26) {
                                if ((f26.floatValue() == f18) && !mutableState.getValue().booleanValue()) {
                                    function0.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        startRestartGroup.endReplaceableGroup();
                        final int i28 = i17;
                        final Boolean bool4 = bool2;
                        final float f26 = f18;
                        final State<Float> c16 = AnimateAsStateKt.c(r1, d17, (Function1) rememberedValue2, startRestartGroup, 0, 0);
                        if (((Boolean) mutableState.getValue()).booleanValue()) {
                        }
                        State<h> a16 = AnimateAsStateKt.a(color$default, b.d(150, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null), null, startRestartGroup, 8, 4);
                        startRestartGroup.startReplaceableGroup(511388516);
                        changed2 = startRestartGroup.changed(mutableState) | startRestartGroup.changed(bool4);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed2) {
                        }
                        rememberedValue3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                mutableState.setValue(Boolean.valueOf(Intrinsics.areEqual(bool4, Boolean.TRUE)));
                                return Unit.INSTANCE;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((Function0) rememberedValue3, startRestartGroup, 0);
                        i M = ModifiersKt.M(ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(iVar2, 0.0f, 1, null), a16.getValue()), true);
                        startRestartGroup.startReplaceableGroup(1157296644);
                        changed3 = startRestartGroup.changed(function1);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!changed3) {
                        }
                        rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                function1.invoke(Boolean.FALSE);
                                return Unit.INSTANCE;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                        startRestartGroup.endReplaceableGroup();
                        iVar3 = iVar2;
                        composer2 = startRestartGroup;
                        BoxKt.a(ViewEventPropUpdaterKt.d(M, false, null, (Function1) rememberedValue4, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1508668052, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num) {
                                Composer composer4 = composer3;
                                int intValue = num.intValue();
                                if ((intValue & 81) == 16 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1508668052, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModal.<anonymous> (NBPHalfScreenModal.kt:83)");
                                    }
                                    i Q = ModifiersKt.Q(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, d16 - f26, 0.0f, 0.0f, 13, null), 0.0f, 1, null), new y(0.0f, 0.0f, 0.0f, c16.getValue().floatValue()), null, 2, null);
                                    final int i29 = 70;
                                    final Function1<Boolean, Unit> function12 = function1;
                                    composer4.startReplaceableGroup(511388516);
                                    boolean changed4 = composer4.changed((Object) 70) | composer4.changed(function12);
                                    Object rememberedValue5 = composer4.rememberedValue();
                                    if (changed4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue5 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$3$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollParams scrollParams) {
                                                if (scrollParams.getOffsetY() < (-i29)) {
                                                    function12.invoke(Boolean.FALSE);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer4.updateRememberedValue(rememberedValue5);
                                    }
                                    composer4.endReplaceableGroup();
                                    Function1 function13 = (Function1) rememberedValue5;
                                    final float f27 = f26;
                                    final Function2<Composer, Integer, Unit> function22 = function2;
                                    final int i36 = i28;
                                    LazyColumnKt.a(Q, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, function13, null, null, ComposableLambdaKt.composableLambda(composer4, -37524633, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$3.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer5, Integer num2) {
                                            com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                                            Composer composer6 = composer5;
                                            int intValue2 = num2.intValue();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-37524633, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModal.<anonymous>.<anonymous> (NBPHalfScreenModal.kt:95)");
                                            }
                                            HoverKt.a(aVar2, ModifiersKt.c(ModifiersKt.k(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, f27), 8.0f, 8.0f, 0.0f, 0.0f), QUIToken.color$default("bg_middle_light")), null, null, 0.0f, null, function22, composer6, ((i36 << 3) & 3670016) | 72, 30);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer4, 8, 0, MsgConstant.KRMFILETHUMBSIZE384, 3670014);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), startRestartGroup, 3080, 6);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        bool3 = bool4;
                        f19 = f26;
                    } else {
                        iVar2 = iVar;
                    }
                } else {
                    i iVar4 = i19 == 0 ? i.INSTANCE : iVar;
                    if ((i16 & 2) != 0) {
                        f17 = ((a) startRestartGroup.consume(CompositionLocalsKt.d())).d() / 2;
                        i26 &= -113;
                    }
                    iVar2 = iVar4;
                    if (i27 != 0) {
                        i17 = i26;
                        f18 = f17;
                        bool2 = null;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-117754394, i17, -1, "com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModal (NBPHalfScreenModal.kt:28)");
                        }
                        final float d162 = ((a) startRestartGroup.consume(CompositionLocalsKt.d())).d();
                        startRestartGroup.startReplaceableGroup(-492369756);
                        rememberedValue = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (rememberedValue == companion.getEmpty()) {
                            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceableGroup();
                        mutableState = (MutableState) rememberedValue;
                        float f27 = NBPHalfScreenModal$lambda$1(mutableState) ? f18 : 0.0f;
                        m d172 = b.d(150, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null);
                        Float valueOf2 = Float.valueOf(f18);
                        startRestartGroup.startReplaceableGroup(1618982084);
                        changed = startRestartGroup.changed(valueOf2) | startRestartGroup.changed(mutableState) | startRestartGroup.changed(function0);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed || rememberedValue2 == companion.getEmpty()) {
                            rememberedValue2 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$offset$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Float f262) {
                                    if ((f262.floatValue() == f18) && !mutableState.getValue().booleanValue()) {
                                        function0.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceableGroup();
                        final int i282 = i17;
                        final Boolean bool42 = bool2;
                        final float f262 = f18;
                        final State c162 = AnimateAsStateKt.c(f27, d172, (Function1) rememberedValue2, startRestartGroup, 0, 0);
                        if (((Boolean) mutableState.getValue()).booleanValue()) {
                            color$default = h.INSTANCE.j();
                        } else {
                            color$default = QUIToken.color$default("overlay_dark");
                        }
                        State<h> a162 = AnimateAsStateKt.a(color$default, b.d(150, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null), null, startRestartGroup, 8, 4);
                        startRestartGroup.startReplaceableGroup(511388516);
                        changed2 = startRestartGroup.changed(mutableState) | startRestartGroup.changed(bool42);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed2 || rememberedValue3 == companion.getEmpty()) {
                            rememberedValue3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    mutableState.setValue(Boolean.valueOf(Intrinsics.areEqual(bool42, Boolean.TRUE)));
                                    return Unit.INSTANCE;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((Function0) rememberedValue3, startRestartGroup, 0);
                        i M2 = ModifiersKt.M(ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(iVar2, 0.0f, 1, null), a162.getValue()), true);
                        startRestartGroup.startReplaceableGroup(1157296644);
                        changed3 = startRestartGroup.changed(function1);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!changed3 || rememberedValue4 == companion.getEmpty()) {
                            rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ClickParams clickParams) {
                                    function1.invoke(Boolean.FALSE);
                                    return Unit.INSTANCE;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                        }
                        startRestartGroup.endReplaceableGroup();
                        iVar3 = iVar2;
                        composer2 = startRestartGroup;
                        BoxKt.a(ViewEventPropUpdaterKt.d(M2, false, null, (Function1) rememberedValue4, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1508668052, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num) {
                                Composer composer4 = composer3;
                                int intValue = num.intValue();
                                if ((intValue & 81) == 16 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1508668052, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModal.<anonymous> (NBPHalfScreenModal.kt:83)");
                                    }
                                    i Q = ModifiersKt.Q(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, d162 - f262, 0.0f, 0.0f, 13, null), 0.0f, 1, null), new y(0.0f, 0.0f, 0.0f, c162.getValue().floatValue()), null, 2, null);
                                    final int i29 = 70;
                                    final Function1<? super Boolean, Unit> function12 = function1;
                                    composer4.startReplaceableGroup(511388516);
                                    boolean changed4 = composer4.changed((Object) 70) | composer4.changed(function12);
                                    Object rememberedValue5 = composer4.rememberedValue();
                                    if (changed4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue5 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$3$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollParams scrollParams) {
                                                if (scrollParams.getOffsetY() < (-i29)) {
                                                    function12.invoke(Boolean.FALSE);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer4.updateRememberedValue(rememberedValue5);
                                    }
                                    composer4.endReplaceableGroup();
                                    Function1 function13 = (Function1) rememberedValue5;
                                    final float f272 = f262;
                                    final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                                    final int i36 = i282;
                                    LazyColumnKt.a(Q, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, function13, null, null, ComposableLambdaKt.composableLambda(composer4, -37524633, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$3.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer5, Integer num2) {
                                            com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                                            Composer composer6 = composer5;
                                            int intValue2 = num2.intValue();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-37524633, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModal.<anonymous>.<anonymous> (NBPHalfScreenModal.kt:95)");
                                            }
                                            HoverKt.a(aVar2, ModifiersKt.c(ModifiersKt.k(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, f272), 8.0f, 8.0f, 0.0f, 0.0f), QUIToken.color$default("bg_middle_light")), null, null, 0.0f, null, function22, composer6, ((i36 << 3) & 3670016) | 72, 30);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer4, 8, 0, MsgConstant.KRMFILETHUMBSIZE384, 3670014);
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
                        bool3 = bool42;
                        f19 = f262;
                    }
                }
                i17 = i26;
                f18 = f17;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final float d1622 = ((a) startRestartGroup.consume(CompositionLocalsKt.d())).d();
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) rememberedValue;
                if (NBPHalfScreenModal$lambda$1(mutableState)) {
                }
                m d1722 = b.d(150, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null);
                Float valueOf22 = Float.valueOf(f18);
                startRestartGroup.startReplaceableGroup(1618982084);
                changed = startRestartGroup.changed(valueOf22) | startRestartGroup.changed(mutableState) | startRestartGroup.changed(function0);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue2 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$offset$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Float f2622) {
                        if ((f2622.floatValue() == f18) && !mutableState.getValue().booleanValue()) {
                            function0.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                final int i2822 = i17;
                final Boolean bool422 = bool2;
                final float f2622 = f18;
                final State c1622 = AnimateAsStateKt.c(f27, d1722, (Function1) rememberedValue2, startRestartGroup, 0, 0);
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                }
                State<h> a1622 = AnimateAsStateKt.a(color$default, b.d(150, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null), null, startRestartGroup, 8, 4);
                startRestartGroup.startReplaceableGroup(511388516);
                changed2 = startRestartGroup.changed(mutableState) | startRestartGroup.changed(bool422);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                rememberedValue3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        mutableState.setValue(Boolean.valueOf(Intrinsics.areEqual(bool422, Boolean.TRUE)));
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((Function0) rememberedValue3, startRestartGroup, 0);
                i M22 = ModifiersKt.M(ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(iVar2, 0.0f, 1, null), a1622.getValue()), true);
                startRestartGroup.startReplaceableGroup(1157296644);
                changed3 = startRestartGroup.changed(function1);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changed3) {
                }
                rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        function1.invoke(Boolean.FALSE);
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
                startRestartGroup.endReplaceableGroup();
                iVar3 = iVar2;
                composer2 = startRestartGroup;
                BoxKt.a(ViewEventPropUpdaterKt.d(M22, false, null, (Function1) rememberedValue4, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1508668052, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num) {
                        Composer composer4 = composer3;
                        int intValue = num.intValue();
                        if ((intValue & 81) == 16 && composer4.getSkipping()) {
                            composer4.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1508668052, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModal.<anonymous> (NBPHalfScreenModal.kt:83)");
                            }
                            i Q = ModifiersKt.Q(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, d1622 - f2622, 0.0f, 0.0f, 13, null), 0.0f, 1, null), new y(0.0f, 0.0f, 0.0f, c1622.getValue().floatValue()), null, 2, null);
                            final int i29 = 70;
                            final Function1<? super Boolean, Unit> function12 = function1;
                            composer4.startReplaceableGroup(511388516);
                            boolean changed4 = composer4.changed((Object) 70) | composer4.changed(function12);
                            Object rememberedValue5 = composer4.rememberedValue();
                            if (changed4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue5 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$3$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        if (scrollParams.getOffsetY() < (-i29)) {
                                            function12.invoke(Boolean.FALSE);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                composer4.updateRememberedValue(rememberedValue5);
                            }
                            composer4.endReplaceableGroup();
                            Function1 function13 = (Function1) rememberedValue5;
                            final float f272 = f2622;
                            final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                            final int i36 = i2822;
                            LazyColumnKt.a(Q, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, function13, null, null, ComposableLambdaKt.composableLambda(composer4, -37524633, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$3.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer5, Integer num2) {
                                    com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                                    Composer composer6 = composer5;
                                    int intValue2 = num2.intValue();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-37524633, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModal.<anonymous>.<anonymous> (NBPHalfScreenModal.kt:95)");
                                    }
                                    HoverKt.a(aVar2, ModifiersKt.c(ModifiersKt.k(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, f272), 8.0f, 8.0f, 0.0f, 0.0f), QUIToken.color$default("bg_middle_light")), null, null, 0.0f, null, function22, composer6, ((i36 << 3) & 3670016) | 72, 30);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer4, 8, 0, MsgConstant.KRMFILETHUMBSIZE384, 3670014);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 3080, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
                bool3 = bool422;
                f19 = f2622;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer3, Integer num) {
                    num.intValue();
                    NBPHalfScreenModalKt.NBPHalfScreenModal(i.this, f19, bool3, function1, function0, function2, composer3, i3 | 1, i16);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        bool2 = bool;
        if ((i16 & 8) == 0) {
        }
        if ((i16 & 16) == 0) {
        }
        if ((i16 & 32) == 0) {
        }
        if (i19 != 1) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) == 0) {
        }
        if (i19 == 0) {
        }
        if ((i16 & 2) != 0) {
        }
        iVar2 = iVar4;
        if (i27 != 0) {
        }
        i17 = i26;
        f18 = f17;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final float d16222 = ((a) startRestartGroup.consume(CompositionLocalsKt.d())).d();
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        mutableState = (MutableState) rememberedValue;
        if (NBPHalfScreenModal$lambda$1(mutableState)) {
        }
        m d17222 = b.d(150, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null);
        Float valueOf222 = Float.valueOf(f18);
        startRestartGroup.startReplaceableGroup(1618982084);
        changed = startRestartGroup.changed(valueOf222) | startRestartGroup.changed(mutableState) | startRestartGroup.changed(function0);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$offset$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Float f26222) {
                if ((f26222.floatValue() == f18) && !mutableState.getValue().booleanValue()) {
                    function0.invoke();
                }
                return Unit.INSTANCE;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        final int i28222 = i17;
        final Boolean bool4222 = bool2;
        final float f26222 = f18;
        final State c16222 = AnimateAsStateKt.c(f27, d17222, (Function1) rememberedValue2, startRestartGroup, 0, 0);
        if (((Boolean) mutableState.getValue()).booleanValue()) {
        }
        State<h> a16222 = AnimateAsStateKt.a(color$default, b.d(150, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null), null, startRestartGroup, 8, 4);
        startRestartGroup.startReplaceableGroup(511388516);
        changed2 = startRestartGroup.changed(mutableState) | startRestartGroup.changed(bool4222);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                mutableState.setValue(Boolean.valueOf(Intrinsics.areEqual(bool4222, Boolean.TRUE)));
                return Unit.INSTANCE;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.SideEffect((Function0) rememberedValue3, startRestartGroup, 0);
        i M222 = ModifiersKt.M(ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(iVar2, 0.0f, 1, null), a16222.getValue()), true);
        startRestartGroup.startReplaceableGroup(1157296644);
        changed3 = startRestartGroup.changed(function1);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changed3) {
        }
        rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                function1.invoke(Boolean.FALSE);
                return Unit.INSTANCE;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceableGroup();
        iVar3 = iVar2;
        composer2 = startRestartGroup;
        BoxKt.a(ViewEventPropUpdaterKt.d(M222, false, null, (Function1) rememberedValue4, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1508668052, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num) {
                Composer composer4 = composer3;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer4.getSkipping()) {
                    composer4.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1508668052, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModal.<anonymous> (NBPHalfScreenModal.kt:83)");
                    }
                    i Q = ModifiersKt.Q(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, d16222 - f26222, 0.0f, 0.0f, 13, null), 0.0f, 1, null), new y(0.0f, 0.0f, 0.0f, c16222.getValue().floatValue()), null, 2, null);
                    final int i29 = 70;
                    final Function1<? super Boolean, Unit> function12 = function1;
                    composer4.startReplaceableGroup(511388516);
                    boolean changed4 = composer4.changed((Object) 70) | composer4.changed(function12);
                    Object rememberedValue5 = composer4.rememberedValue();
                    if (changed4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$3$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ScrollParams scrollParams) {
                                if (scrollParams.getOffsetY() < (-i29)) {
                                    function12.invoke(Boolean.FALSE);
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        composer4.updateRememberedValue(rememberedValue5);
                    }
                    composer4.endReplaceableGroup();
                    Function1 function13 = (Function1) rememberedValue5;
                    final float f272 = f26222;
                    final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                    final int i36 = i28222;
                    LazyColumnKt.a(Q, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, function13, null, null, ComposableLambdaKt.composableLambda(composer4, -37524633, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModalKt$NBPHalfScreenModal$3.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer5, Integer num2) {
                            com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                            Composer composer6 = composer5;
                            int intValue2 = num2.intValue();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-37524633, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.compose_base.view.NBPHalfScreenModal.<anonymous>.<anonymous> (NBPHalfScreenModal.kt:95)");
                            }
                            HoverKt.a(aVar2, ModifiersKt.c(ModifiersKt.k(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, f272), 8.0f, 8.0f, 0.0f, 0.0f), QUIToken.color$default("bg_middle_light")), null, null, 0.0f, null, function22, composer6, ((i36 << 3) & 3670016) | 72, 30);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer4, 8, 0, MsgConstant.KRMFILETHUMBSIZE384, 3670014);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        bool3 = bool4222;
        f19 = f26222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
