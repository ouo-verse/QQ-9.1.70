package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.animation.b;
import com.tencent.ntcompose.animation.i;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.AnimatedTransitionBoxKt;
import com.tencent.ntcompose.material.AnimatedTransitionType;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUIBottomToastKt {
    /* JADX WARN: Removed duplicated region for block: B:19:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QUIBottomToast(final boolean z16, final QToastMode qToastMode, final String str, final String str2, float f16, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i3, final int i16) {
        int i17;
        final float f17;
        final int i18;
        int ordinal;
        String str3;
        Object rememberedValue;
        Composer.Companion companion;
        Composer composer2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1852630886);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(z16) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        if ((i16 & 2) != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(qToastMode) ? 32 : 16;
        }
        if ((i16 & 4) != 0) {
            i17 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i3 & 896) == 0) {
            i17 |= startRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i16 & 8) != 0) {
            i17 |= 3072;
        } else if ((i3 & 7168) == 0) {
            i17 |= startRestartGroup.changed(str2) ? 2048 : 1024;
        }
        int i19 = i16 & 16;
        if (i19 != 0) {
            i17 |= 24576;
        } else if ((57344 & i3) == 0) {
            f17 = f16;
            i17 |= startRestartGroup.changed(f17) ? 16384 : 8192;
            if ((i16 & 32) == 0) {
                i17 |= 196608;
            } else if ((458752 & i3) == 0) {
                i17 |= startRestartGroup.changed(function0) ? 131072 : 65536;
            }
            if ((i16 & 64) == 0) {
                i17 |= 1572864;
            } else if ((3670016 & i3) == 0) {
                i17 |= startRestartGroup.changed(function02) ? 1048576 : 524288;
            }
            i18 = i17;
            if ((2995931 & i18) != 599186 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
            } else {
                float f18 = i19 == 0 ? 0.0f : f17;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1852630886, i18, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToast (QUIBottomToast.kt:80)");
                }
                ordinal = qToastMode.ordinal();
                if (ordinal != 1) {
                    str3 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFQAAABVCAMAAADg6TNWAAAAS1BMVEUAAAAV0XMV0XMQz3AU0HEQz3cV0XMYz3AV0XIV0HMUz3MVz3AV0XMU0nMV0XMU0XMU0HMV0XMW0nMTz3IUz3AU0XQV0nQV0XQV0XMM46g/AAAAGHRSTlMA318QgCDPIO9wQDCgv++vUJB/kEDPj89WqRPMAAABxElEQVRYw+3YSW7DMAxAUVLyKFuDm7Tl/U/aol04AGVTlIKgKPyXWTwosaYYrq7+S3YxpvvOJGefAt7niPRQiPPSKG6BMuFa7xpPh32aOhLpNNSzd09i2KtIu1FRHwqzR2K1DtYEKi6kMvONVL0pTJWqN9vVmSqaz82FqnLKudQ+syJV5o9NQ9XN8pfXF+wBupKUfhvoqaleHqi+VRhoXRZ4nQYY3MQ+64CHGtPCwtTATaczIaM6ht50Zk7dGPquNbmK7KjTm2Ck55+eYFJiE0ptyrtK1JvyovI5YkOVSUPB1O9gRIXJH/+UM2FXs6a0prLmrjIzH0O5uavMrENDD7taapL0m+KDWmoG9vTP1DKTkO0nZ2rcTc3pv4r3DtmkyC5mkspN8UBJJKmySYntp7Jq1OcpSqpsDsIZxVXZpE04Tblqqq6+04laZKLuhuJXT3Id8Cw1Nr7q1gdj60Cz3doHyrNTvYmj+HdPn4HDfK0Z4bgR2788z9Why6v+RcurVV6fsqo3ZVVvyiXFIpgMFDZi41xq2gY2Kzj6wXr3F95K/rDDySgN1LasmBOnm4OmljlOjyDGmYlVWZd+356bxcLV1WlfOM9GF/5elPYAAAAASUVORK5CYII=";
                } else if (ordinal != 2) {
                    str3 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEcAAABHCAMAAABibqotAAAAQlBMVEUAAAAAl/8Amf8Al/8Amv8Amf8AmP8Al/8Amf8AmP8Amf8Al/8Amf8An/8Amv8Amf8Amf8AmP8Amf8Al/8Amv8Amf8lYm8TAAAAFXRSTlMAgN8gv++QYK+/X0AwEM9wz29QoJ9kZwIVAAABdElEQVRYw92YW3KDMAxFFb8Bm1ej/W+1Cf3QkA7G+LqZTs4CzsgSWJboHUTvglL8QI3GLbHGkRZj+QUben3NMhg+IKzlFq84g+oLYxELYNKGC7if5WmxXITNhpQcF+MyZxr5AqM+0ii+hNIZDSQSDS4auYIxvWp2laqvmudKpn1yLFdidyn64mpM2anMbcPwIYN4MiW/0cYtU3wJhxEP9xIO4JGAVkY8kqGAeKRkmlEPJ8lyRd2FaXcs8Fu0DGOfzZcbEIkmboA/vXhUt6FOryHDeN05EM2QR34N1cjDgEf4XI/6T/Wa5XeHPB2RgzzyX3jIIy0jtvBEuccQj6UHBvcEejBBHumoCfdoemJQT6CNAfWsTd8J+Lul9TuKBqS/9yQYrub+B+9eoDv3TecCIc1cwdh6bsLnuPZzpYhmYM6trZpLlMGX7gEmyqOLRrFO129bBDW8Z28jrOHwRANdQvvwe6/VLYkqiIvr5p89mwrORzrmG3u5JBj5FpYCAAAAAElFTkSuQmCC";
                } else {
                    str3 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFQAAABUCAMAAAArteDzAAAAQlBMVEUAAAD1TDD3TDD3TDD3SjD3TDD3SzD3UDD3SDD4TDD1TDD3SzD4TDD3SzD/RTD2TDD2TDD2SzD2SzD4TTDvUDD3TDDFTYYZAAAAFXRSTlMAgN+/X++QICDPQDCvcBBvoFCwrxB4jAezAAABhElEQVRYw+3Y3Y6DIBCG4ekMIPhv27n/W91djzZOMMDXmB74XMAbsEgRut0uN7gwMusvThKWgVDzIl4P/Og6INmLZowbtXGsJ9i1jNIk4WwnWmCteraL1yLelf/kQYuF0qknrZC6oiZrFe6AJlDNNLFq0gZppjNBDXgNOG00nTxQr418/rGu2kwaJi+PnWhWn4myZj1o99Aszg0UiarLDBSIZoa6KRDNPdURjQoZnaJRne3PhEcnO3s8aufv8ag3ZxvFozocohMetes/4FG7rconok/7N4JHueDFh6PaELXu6H/8tb9+spsUHpW615Rlx3WvqdMPcHbrww12k4Z5OhKFPYmKdml7lqo6o7zxJRXJEDT6JKtHo9tFBzT8KHndoZd6ZEnZgeIvwEo5sf2TJ1LWpI3c1Z+R9G774KVzseXTPFJDFWiaKtC01bqLGdPE10CYqZQrveyaqEJctYBE8E7S4v47rjr/bK/sxHtqF93LXh/LMhNqWIIk3qfMr+AGut2u9gMn7CPE89iJhQAAAABJRU5ErkJggg==";
                }
                final String str4 = str3;
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState mutableState = (MutableState) rememberedValue;
                if (z16) {
                    composer2 = startRestartGroup;
                } else {
                    Boolean valueOf = Boolean.valueOf(z16);
                    Boolean valueOf2 = Boolean.valueOf(z16);
                    startRestartGroup.startReplaceableGroup(511388516);
                    boolean changed = startRestartGroup.changed(mutableState) | startRestartGroup.changed(valueOf2);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new QUIBottomToastKt$QUIBottomToast$1$1(mutableState, z16, null);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, (i18 & 14) | 64);
                    final State<Float> c16 = AnimateAsStateKt.c(!((Boolean) mutableState.getValue()).booleanValue() ? 0.0f : 1.0f, b.d(70, 0, i.d(), null, 10, null), null, startRestartGroup, 0, 4);
                    final float f19 = f18;
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 2026665983, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToastKt$QUIBottomToast$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer3, Integer num) {
                            Composer composer4 = composer3;
                            int intValue = num.intValue();
                            if ((intValue & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2026665983, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToast.<anonymous> (QUIBottomToast.kt:108)");
                                }
                                com.tencent.ntcompose.core.i v3 = ComposeLayoutPropUpdaterKt.v(com.tencent.ntcompose.core.i.INSTANCE, ((a) composer4.consume(CompositionLocalsKt.d())).e(), ((a) composer4.consume(CompositionLocalsKt.d())).d());
                                final MutableState<Boolean> mutableState2 = mutableState;
                                final Function0<Unit> function03 = function0;
                                composer4.startReplaceableGroup(511388516);
                                boolean changed2 = composer4.changed(mutableState2) | composer4.changed(function03);
                                Object rememberedValue3 = composer4.rememberedValue();
                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToastKt$QUIBottomToast$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Object obj) {
                                            KLog.INSTANCE.i("QUIBottomToast", "viewDidCreated");
                                            final MutableState<Boolean> mutableState3 = mutableState2;
                                            final Function0<Unit> function04 = function03;
                                            TimerKt.d(2800, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToastKt$QUIBottomToast$2$1$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    KLog.INSTANCE.i("QUIBottomToast", "is time to dismiss");
                                                    mutableState3.setValue(Boolean.FALSE);
                                                    final Function0<Unit> function05 = function04;
                                                    TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToastKt.QUIBottomToast.2.1.1.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            function05.invoke();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer4.updateRememberedValue(rememberedValue3);
                                }
                                composer4.endReplaceableGroup();
                                com.tencent.ntcompose.core.i q16 = ViewEventPropUpdaterKt.q(v3, (Function1) rememberedValue3);
                                Alignment alignment = Alignment.BottomCenter;
                                final float f26 = f19;
                                final MutableState<Boolean> mutableState3 = mutableState;
                                final Function0<Unit> function04 = function0;
                                final int i26 = i18;
                                final State<Float> state = c16;
                                final String str5 = str4;
                                final String str6 = str;
                                final Function0<Unit> function05 = function02;
                                final String str7 = str2;
                                BoxKt.a(q16, alignment, null, ComposableLambdaKt.composableLambda(composer4, -307619015, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToastKt$QUIBottomToast$2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer5, Integer num2) {
                                        Composer composer6 = composer5;
                                        int intValue2 = num2.intValue();
                                        if ((intValue2 & 81) == 16 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-307619015, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToast.<anonymous>.<anonymous> (QUIBottomToast.kt:123)");
                                            }
                                            com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ModifiersKt.b(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 52.0f), state.getValue().floatValue()), 0.0f, 0.0f, 0.0f, ((a) composer6.consume(CompositionLocalsKt.d())).f().getBottom() + 12.0f + f26, 7, null);
                                            AnimatedTransitionType animatedTransitionType = AnimatedTransitionType.DIRECTION_FROM_BOTTOM;
                                            boolean booleanValue = mutableState3.getValue().booleanValue();
                                            final MutableState<Boolean> mutableState4 = mutableState3;
                                            final Function0<Unit> function06 = function04;
                                            composer6.startReplaceableGroup(511388516);
                                            boolean changed3 = composer6.changed(mutableState4) | composer6.changed(function06);
                                            Object rememberedValue4 = composer6.rememberedValue();
                                            if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue4 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToastKt$QUIBottomToast$2$2$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Boolean bool) {
                                                        if (!bool.booleanValue()) {
                                                            mutableState4.setValue(Boolean.FALSE);
                                                            function06.invoke();
                                                        } else {
                                                            mutableState4.setValue(Boolean.TRUE);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer6.updateRememberedValue(rememberedValue4);
                                            }
                                            composer6.endReplaceableGroup();
                                            Function1 function1 = (Function1) rememberedValue4;
                                            m d16 = b.d(100, 0, i.b(), null, 10, null);
                                            m d17 = b.d(50, 0, i.a(), null, 10, null);
                                            final String str8 = str5;
                                            final String str9 = str6;
                                            final int i27 = i26;
                                            final Function0<Unit> function07 = function05;
                                            final String str10 = str7;
                                            AnimatedTransitionBoxKt.a(n3, null, animatedTransitionType, booleanValue, function1, d16, d17, ComposableLambdaKt.composableLambda(composer6, 1167511023, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToastKt.QUIBottomToast.2.2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer7, Integer num3) {
                                                    Composer composer8 = composer7;
                                                    int intValue3 = num3.intValue();
                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                        composer8.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1167511023, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToast.<anonymous>.<anonymous>.<anonymous> (QUIBottomToast.kt:140)");
                                                        }
                                                        com.tencent.ntcompose.core.i c17 = ModifiersKt.c(ModifiersKt.L(ModifiersKt.j(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 52.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), 12.0f), 2.0f, 2.0f, 12.0f, new h(637534208L)), QUIToken.color$default("bg_top_light"));
                                                        a.e e16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.e();
                                                        Alignment.Vertical c18 = Alignment.INSTANCE.c();
                                                        final String str11 = str8;
                                                        final String str12 = str9;
                                                        final int i28 = i27;
                                                        final Function0<Unit> function08 = function07;
                                                        final String str13 = str10;
                                                        RowKt.a(c17, e16, c18, null, null, ComposableLambdaKt.composableLambda(composer8, -1478973683, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToastKt.QUIBottomToast.2.2.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(n nVar, Composer composer9, Integer num4) {
                                                                int i29;
                                                                n nVar2 = nVar;
                                                                Composer composer10 = composer9;
                                                                int intValue4 = num4.intValue();
                                                                if ((intValue4 & 14) == 0) {
                                                                    i29 = (composer10.changed(nVar2) ? 4 : 2) | intValue4;
                                                                } else {
                                                                    i29 = intValue4;
                                                                }
                                                                if ((i29 & 91) == 18 && composer10.getSkipping()) {
                                                                    composer10.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1478973683, intValue4, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToast.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QUIBottomToast.kt:152)");
                                                                    }
                                                                    i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                                                    ImageKt.a(str11, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion2, 24.0f), 0.0f, 0.0f, 8.0f, 0.0f, 11, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer10, 262144, 0, 0, 2097118);
                                                                    TextKt.a(str12, nVar2.a(ComposeLayoutPropUpdaterKt.B(companion2), 1.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, new k(QUIToken.color$default("text_primary"), Float.valueOf(16.0f), c.INSTANCE.e(), null, new com.tencent.ntcompose.material.n("PingFang SC"), null, null, null, null, Float.valueOf(22.0f), null, null, null, null, 15848, null), null, null, null, null, null, false, composer10, ((i28 >> 6) & 14) | 64, 100663296, k.f28903n, 132907004);
                                                                    com.tencent.ntcompose.core.i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.B(companion2), 0.0f, 1, null), 16.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                                    final Function0<Unit> function09 = function08;
                                                                    composer10.startReplaceableGroup(1157296644);
                                                                    boolean changed4 = composer10.changed(function09);
                                                                    Object rememberedValue5 = composer10.rememberedValue();
                                                                    if (changed4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                                        rememberedValue5 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToastKt$QUIBottomToast$2$2$2$1$1$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                function09.invoke();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        };
                                                                        composer10.updateRememberedValue(rememberedValue5);
                                                                    }
                                                                    composer10.endReplaceableGroup();
                                                                    com.tencent.ntcompose.core.i d18 = ViewEventPropUpdaterKt.d(n16, false, null, (Function1) rememberedValue5, 3, null);
                                                                    Alignment alignment2 = Alignment.Center;
                                                                    final String str14 = str13;
                                                                    final int i36 = i28;
                                                                    BoxKt.a(d18, alignment2, null, ComposableLambdaKt.composableLambda(composer10, -57675961, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToastKt.QUIBottomToast.2.2.2.1.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar3, Composer composer11, Integer num5) {
                                                                            Composer composer12 = composer11;
                                                                            int intValue5 = num5.intValue();
                                                                            if ((intValue5 & 81) == 16 && composer12.getSkipping()) {
                                                                                composer12.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-57675961, intValue5, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToast.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QUIBottomToast.kt:178)");
                                                                                }
                                                                                com.tencent.ntcompose.core.i y16 = ComposeLayoutPropUpdaterKt.y(ComposeLayoutPropUpdaterKt.B(com.tencent.ntcompose.core.i.INSTANCE), 0.0f, 110.0f, 1, null);
                                                                                com.tencent.ntcompose.material.n nVar3 = new com.tencent.ntcompose.material.n("PingFang SC");
                                                                                TextKt.a(str14, y16, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, new k(new h(4281169893L), Float.valueOf(16.0f), c.INSTANCE.e(), null, nVar3, null, null, null, null, Float.valueOf(22.0f), null, null, null, null, 15848, null), null, null, null, null, null, false, composer12, ((i36 >> 9) & 14) | 64, 100663296, k.f28903n, 132907004);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer10, 3128, 4);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer8, 196680, 24);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer6, 12583304, 2);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer4, 3128, 4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    composer2 = startRestartGroup;
                    ModalKt.a(null, false, null, null, composableLambda, startRestartGroup, 24624, 13);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f17 = f18;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIBottomToastKt$QUIBottomToast$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer3, Integer num) {
                    num.intValue();
                    QUIBottomToastKt.QUIBottomToast(z16, qToastMode, str, str2, f17, function0, function02, composer3, i3 | 1, i16);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        f17 = f16;
        if ((i16 & 32) == 0) {
        }
        if ((i16 & 64) == 0) {
        }
        i18 = i17;
        if ((2995931 & i18) != 599186) {
        }
        if (i19 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ordinal = qToastMode.ordinal();
        if (ordinal != 1) {
        }
        final String str42 = str3;
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<Boolean> mutableState2 = (MutableState) rememberedValue;
        if (z16) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        f17 = f18;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
