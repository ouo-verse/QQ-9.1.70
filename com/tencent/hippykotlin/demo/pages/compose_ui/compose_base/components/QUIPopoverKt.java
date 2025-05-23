package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.a;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.t;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.base.y;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import yo3.Offset;

/* loaded from: classes31.dex */
public final class QUIPopoverKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QUIPopover(final MutableState<Boolean> mutableState, final Offset offset, h hVar, PopoverTriangle popoverTriangle, boolean z16, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i3, final int i16) {
        int i17;
        boolean z17;
        int i18;
        Function2<? super Composer, ? super Integer, Unit> function22;
        h hVar2;
        PopoverTriangle popoverTriangle2;
        int i19;
        h hVar3;
        PopoverTriangle popoverTriangle3;
        boolean z18;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Object rememberedValue;
        Composer.Companion companion;
        final MutableState mutableState2;
        Object rememberedValue2;
        final MutableState mutableState3;
        Object rememberedValue3;
        final MutableState mutableState4;
        boolean changed;
        Object rememberedValue4;
        final State<Float> c16;
        boolean changed2;
        Object rememberedValue5;
        boolean changed3;
        Object rememberedValue6;
        final State<Float> c17;
        final h hVar4;
        final PopoverTriangle popoverTriangle4;
        final boolean z19;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1699297903);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = i3 | (startRestartGroup.changed(mutableState) ? 4 : 2);
        } else {
            i17 = i3;
        }
        if ((i16 & 2) != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(offset) ? 32 : 16;
        }
        int i26 = i16 & 4;
        if (i26 != 0) {
            i17 |= 128;
        }
        int i27 = i16 & 8;
        if (i27 != 0) {
            i17 |= 1024;
        }
        int i28 = i16 & 16;
        if (i28 != 0) {
            i17 |= 24576;
        } else if ((i3 & 57344) == 0) {
            z17 = z16;
            i17 |= startRestartGroup.changed(z17) ? 16384 : 8192;
            i18 = i16 & 32;
            if (i18 == 0) {
                i17 |= 196608;
            } else if ((i3 & 458752) == 0) {
                function22 = function2;
                i17 |= startRestartGroup.changed(function22) ? 131072 : 65536;
                if ((i16 & 12) != 12 && (374491 & i17) == 74898 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    hVar4 = hVar;
                    popoverTriangle4 = popoverTriangle;
                    z19 = z17;
                    function24 = function22;
                } else {
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i26 != 0) {
                            hVar2 = h.INSTANCE.p(0.0f);
                            i17 &= -897;
                        } else {
                            hVar2 = hVar;
                        }
                        if (i27 != 0) {
                            popoverTriangle2 = new PopoverTriangle(false, 0.0f, null, null, null, 31, null);
                            i17 &= -7169;
                        } else {
                            popoverTriangle2 = popoverTriangle;
                        }
                        i19 = i17;
                        hVar3 = hVar2;
                        popoverTriangle3 = popoverTriangle2;
                        z18 = i28 != 0 ? false : z17;
                        if (i18 != 0) {
                            function23 = null;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1699297903, i19, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopover (QUIPopover.kt:50)");
                            }
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue = startRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (rememberedValue == companion.getEmpty()) {
                                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(mutableState.getValue(), null, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            mutableState2 = (MutableState) rememberedValue;
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == companion.getEmpty()) {
                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(mutableState.getValue(), null, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            startRestartGroup.endReplaceableGroup();
                            mutableState3 = (MutableState) rememberedValue2;
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == companion.getEmpty()) {
                                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(mutableState.getValue(), null, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            startRestartGroup.endReplaceableGroup();
                            mutableState4 = (MutableState) rememberedValue3;
                            if (mutableState.getValue().booleanValue()) {
                                Boolean bool = Boolean.TRUE;
                                mutableState2.setValue(bool);
                                mutableState3.setValue(bool);
                                mutableState4.setValue(bool);
                            }
                            float f16 = !mutableState.getValue().booleanValue() ? 1.0f : 0.1f;
                            startRestartGroup.startReplaceableGroup(1157296644);
                            changed = startRestartGroup.changed(mutableState2);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue4 == companion.getEmpty()) {
                                rememberedValue4 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$popoverScale$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Float f17) {
                                        if (f17.floatValue() == 0.1f) {
                                            mutableState2.setValue(Boolean.FALSE);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            startRestartGroup.endReplaceableGroup();
                            c16 = AnimateAsStateKt.c(f16, null, (Function1) rememberedValue4, startRestartGroup, 0, 2);
                            float f17 = !mutableState.getValue().booleanValue() ? 1.0f : 0.0f;
                            startRestartGroup.startReplaceableGroup(1157296644);
                            changed2 = startRestartGroup.changed(mutableState3);
                            rememberedValue5 = startRestartGroup.rememberedValue();
                            if (!changed2 || rememberedValue5 == companion.getEmpty()) {
                                rememberedValue5 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$popoverAlpha$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Float f18) {
                                        if (f18.floatValue() == 0.0f) {
                                            mutableState3.setValue(Boolean.FALSE);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            }
                            startRestartGroup.endReplaceableGroup();
                            AnimateAsStateKt.c(f17, null, (Function1) rememberedValue5, startRestartGroup, 0, 2);
                            float f18 = !mutableState.getValue().booleanValue() ? 1.0f : 0.0f;
                            startRestartGroup.startReplaceableGroup(1157296644);
                            changed3 = startRestartGroup.changed(mutableState4);
                            rememberedValue6 = startRestartGroup.rememberedValue();
                            if (!changed3 || rememberedValue6 == companion.getEmpty()) {
                                rememberedValue6 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$modalAlpha$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Float f19) {
                                        if (f19.floatValue() == 0.0f) {
                                            mutableState4.setValue(Boolean.FALSE);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue6);
                            }
                            startRestartGroup.endReplaceableGroup();
                            c17 = AnimateAsStateKt.c(f18, null, (Function1) rememberedValue6, startRestartGroup, 0, 2);
                            if (((Boolean) mutableState2.getValue()).booleanValue() && ((Boolean) mutableState3.getValue()).booleanValue() && ((Boolean) mutableState4.getValue()).booleanValue()) {
                                final h hVar5 = hVar3;
                                final boolean z26 = z18;
                                final int i29 = i19;
                                final PopoverTriangle popoverTriangle5 = popoverTriangle3;
                                final Function2<? super Composer, ? super Integer, Unit> function25 = function23;
                                ModalKt.a(ModifiersKt.T(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 99), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1986800609, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Composer composer2, Integer num) {
                                        i d16;
                                        Composer composer3 = composer2;
                                        int intValue = num.intValue();
                                        if ((intValue & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1986800609, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopover.<anonymous> (QUIPopover.kt:103)");
                                            }
                                            i.Companion companion2 = i.INSTANCE;
                                            i b16 = ModifiersKt.b(ModifiersKt.d(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), h.this), c17.getValue().floatValue());
                                            if (!z26) {
                                                composer3.startReplaceableGroup(1828475887);
                                                final MutableState<Boolean> mutableState5 = mutableState;
                                                composer3.startReplaceableGroup(1157296644);
                                                boolean changed4 = composer3.changed(mutableState5);
                                                Object rememberedValue7 = composer3.rememberedValue();
                                                if (changed4 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue7 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            mutableState5.setValue(Boolean.FALSE);
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(rememberedValue7);
                                                }
                                                composer3.endReplaceableGroup();
                                                d16 = ViewEventPropUpdaterKt.i(companion2, (Function0) rememberedValue7);
                                                composer3.endReplaceableGroup();
                                            } else {
                                                composer3.startReplaceableGroup(1828476054);
                                                final MutableState<Boolean> mutableState6 = mutableState;
                                                composer3.startReplaceableGroup(1157296644);
                                                boolean changed5 = composer3.changed(mutableState6);
                                                Object rememberedValue8 = composer3.rememberedValue();
                                                if (changed5 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue8 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$1$2$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            mutableState6.setValue(Boolean.FALSE);
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(rememberedValue8);
                                                }
                                                composer3.endReplaceableGroup();
                                                d16 = ViewEventPropUpdaterKt.d(companion2, false, null, (Function1) rememberedValue8, 3, null);
                                                composer3.endReplaceableGroup();
                                            }
                                            i b17 = b16.b(d16);
                                            final Offset offset2 = offset;
                                            final PopoverTriangle popoverTriangle6 = popoverTriangle5;
                                            final Function2<Composer, Integer, Unit> function26 = function25;
                                            final int i36 = i29;
                                            final State<Float> state = c16;
                                            BoxKt.a(b17, null, null, ComposableLambdaKt.composableLambda(composer3, 968332453, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$1.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
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
                                                            ComposerKt.traceEventStart(968332453, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopover.<anonymous>.<anonymous> (QUIPopover.kt:120)");
                                                        }
                                                        Offset offset3 = Offset.this;
                                                        float floatValue = state.getValue().floatValue();
                                                        PopoverTriangle popoverTriangle7 = popoverTriangle6;
                                                        Function2<Composer, Integer, Unit> function27 = function26;
                                                        int i37 = Offset.f450729d | 512;
                                                        int i38 = i36;
                                                        QUIPopoverKt.access$PopoverView(offset3, floatValue, popoverTriangle7, function27, composer5, i37 | ((i38 >> 3) & 14) | ((i38 >> 6) & 7168));
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
                                }), startRestartGroup, 24632, 12);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            hVar4 = hVar3;
                            popoverTriangle4 = popoverTriangle3;
                            z19 = z18;
                            function24 = function23;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if (i26 != 0) {
                            i17 &= -897;
                        }
                        if (i27 != 0) {
                            i17 &= -7169;
                        }
                        hVar3 = hVar;
                        popoverTriangle3 = popoverTriangle;
                        i19 = i17;
                        z18 = z17;
                    }
                    function23 = function22;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    mutableState2 = (MutableState) rememberedValue;
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    mutableState3 = (MutableState) rememberedValue2;
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    mutableState4 = (MutableState) rememberedValue3;
                    if (mutableState.getValue().booleanValue()) {
                    }
                    if (!mutableState.getValue().booleanValue()) {
                    }
                    startRestartGroup.startReplaceableGroup(1157296644);
                    changed = startRestartGroup.changed(mutableState2);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue4 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$popoverScale$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Float f172) {
                            if (f172.floatValue() == 0.1f) {
                                mutableState2.setValue(Boolean.FALSE);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    startRestartGroup.endReplaceableGroup();
                    c16 = AnimateAsStateKt.c(f16, null, (Function1) rememberedValue4, startRestartGroup, 0, 2);
                    if (!mutableState.getValue().booleanValue()) {
                    }
                    startRestartGroup.startReplaceableGroup(1157296644);
                    changed2 = startRestartGroup.changed(mutableState3);
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue5 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$popoverAlpha$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Float f182) {
                            if (f182.floatValue() == 0.0f) {
                                mutableState3.setValue(Boolean.FALSE);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                    startRestartGroup.endReplaceableGroup();
                    AnimateAsStateKt.c(f17, null, (Function1) rememberedValue5, startRestartGroup, 0, 2);
                    if (!mutableState.getValue().booleanValue()) {
                    }
                    startRestartGroup.startReplaceableGroup(1157296644);
                    changed3 = startRestartGroup.changed(mutableState4);
                    rememberedValue6 = startRestartGroup.rememberedValue();
                    if (!changed3) {
                    }
                    rememberedValue6 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$modalAlpha$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Float f19) {
                            if (f19.floatValue() == 0.0f) {
                                mutableState4.setValue(Boolean.FALSE);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                    startRestartGroup.endReplaceableGroup();
                    c17 = AnimateAsStateKt.c(f18, null, (Function1) rememberedValue6, startRestartGroup, 0, 2);
                    if (((Boolean) mutableState2.getValue()).booleanValue()) {
                        final h hVar52 = hVar3;
                        final boolean z262 = z18;
                        final int i292 = i19;
                        final PopoverTriangle popoverTriangle52 = popoverTriangle3;
                        final Function2<? super Composer, ? super Integer, Unit> function252 = function23;
                        ModalKt.a(ModifiersKt.T(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 99), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1986800609, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer2, Integer num) {
                                i d16;
                                Composer composer3 = composer2;
                                int intValue = num.intValue();
                                if ((intValue & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1986800609, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopover.<anonymous> (QUIPopover.kt:103)");
                                    }
                                    i.Companion companion2 = i.INSTANCE;
                                    i b16 = ModifiersKt.b(ModifiersKt.d(ComposeLayoutPropUpdaterKt.h(companion2, 0.0f, 1, null), h.this), c17.getValue().floatValue());
                                    if (!z262) {
                                        composer3.startReplaceableGroup(1828475887);
                                        final MutableState<Boolean> mutableState5 = mutableState;
                                        composer3.startReplaceableGroup(1157296644);
                                        boolean changed4 = composer3.changed(mutableState5);
                                        Object rememberedValue7 = composer3.rememberedValue();
                                        if (changed4 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue7 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$1$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    mutableState5.setValue(Boolean.FALSE);
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue7);
                                        }
                                        composer3.endReplaceableGroup();
                                        d16 = ViewEventPropUpdaterKt.i(companion2, (Function0) rememberedValue7);
                                        composer3.endReplaceableGroup();
                                    } else {
                                        composer3.startReplaceableGroup(1828476054);
                                        final MutableState<Boolean> mutableState6 = mutableState;
                                        composer3.startReplaceableGroup(1157296644);
                                        boolean changed5 = composer3.changed(mutableState6);
                                        Object rememberedValue8 = composer3.rememberedValue();
                                        if (changed5 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue8 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$1$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    mutableState6.setValue(Boolean.FALSE);
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue8);
                                        }
                                        composer3.endReplaceableGroup();
                                        d16 = ViewEventPropUpdaterKt.d(companion2, false, null, (Function1) rememberedValue8, 3, null);
                                        composer3.endReplaceableGroup();
                                    }
                                    i b17 = b16.b(d16);
                                    final Offset offset2 = offset;
                                    final PopoverTriangle popoverTriangle6 = popoverTriangle52;
                                    final Function2<? super Composer, ? super Integer, Unit> function26 = function252;
                                    final int i36 = i292;
                                    final State<Float> state = c16;
                                    BoxKt.a(b17, null, null, ComposableLambdaKt.composableLambda(composer3, 968332453, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
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
                                                    ComposerKt.traceEventStart(968332453, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopover.<anonymous>.<anonymous> (QUIPopover.kt:120)");
                                                }
                                                Offset offset3 = Offset.this;
                                                float floatValue = state.getValue().floatValue();
                                                PopoverTriangle popoverTriangle7 = popoverTriangle6;
                                                Function2<Composer, Integer, Unit> function27 = function26;
                                                int i37 = Offset.f450729d | 512;
                                                int i38 = i36;
                                                QUIPopoverKt.access$PopoverView(offset3, floatValue, popoverTriangle7, function27, composer5, i37 | ((i38 >> 3) & 14) | ((i38 >> 6) & 7168));
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
                        }), startRestartGroup, 24632, 12);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    hVar4 = hVar3;
                    popoverTriangle4 = popoverTriangle3;
                    z19 = z18;
                    function24 = function23;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        QUIPopoverKt.QUIPopover(mutableState, offset, hVar4, popoverTriangle4, z19, function24, composer2, i3 | 1, i16);
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            function22 = function2;
            if ((i16 & 12) != 12) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i26 != 0) {
            }
            if (i27 != 0) {
            }
            i19 = i17;
            hVar3 = hVar2;
            popoverTriangle3 = popoverTriangle2;
            z18 = i28 != 0 ? false : z17;
            if (i18 != 0) {
            }
            function23 = function22;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            mutableState2 = (MutableState) rememberedValue;
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            mutableState3 = (MutableState) rememberedValue2;
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            mutableState4 = (MutableState) rememberedValue3;
            if (mutableState.getValue().booleanValue()) {
            }
            if (!mutableState.getValue().booleanValue()) {
            }
            startRestartGroup.startReplaceableGroup(1157296644);
            changed = startRestartGroup.changed(mutableState2);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue4 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$popoverScale$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Float f172) {
                    if (f172.floatValue() == 0.1f) {
                        mutableState2.setValue(Boolean.FALSE);
                    }
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            startRestartGroup.endReplaceableGroup();
            c16 = AnimateAsStateKt.c(f16, null, (Function1) rememberedValue4, startRestartGroup, 0, 2);
            if (!mutableState.getValue().booleanValue()) {
            }
            startRestartGroup.startReplaceableGroup(1157296644);
            changed2 = startRestartGroup.changed(mutableState3);
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue5 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$popoverAlpha$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Float f182) {
                    if (f182.floatValue() == 0.0f) {
                        mutableState3.setValue(Boolean.FALSE);
                    }
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue5);
            startRestartGroup.endReplaceableGroup();
            AnimateAsStateKt.c(f17, null, (Function1) rememberedValue5, startRestartGroup, 0, 2);
            if (!mutableState.getValue().booleanValue()) {
            }
            startRestartGroup.startReplaceableGroup(1157296644);
            changed3 = startRestartGroup.changed(mutableState4);
            rememberedValue6 = startRestartGroup.rememberedValue();
            if (!changed3) {
            }
            rememberedValue6 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$modalAlpha$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Float f19) {
                    if (f19.floatValue() == 0.0f) {
                        mutableState4.setValue(Boolean.FALSE);
                    }
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue6);
            startRestartGroup.endReplaceableGroup();
            c17 = AnimateAsStateKt.c(f18, null, (Function1) rememberedValue6, startRestartGroup, 0, 2);
            if (((Boolean) mutableState2.getValue()).booleanValue()) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            hVar4 = hVar3;
            popoverTriangle4 = popoverTriangle3;
            z19 = z18;
            function24 = function23;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        z17 = z16;
        i18 = i16 & 32;
        if (i18 == 0) {
        }
        function22 = function2;
        if ((i16 & 12) != 12) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i26 != 0) {
        }
        if (i27 != 0) {
        }
        i19 = i17;
        hVar3 = hVar2;
        popoverTriangle3 = popoverTriangle2;
        z18 = i28 != 0 ? false : z17;
        if (i18 != 0) {
        }
        function23 = function22;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        mutableState2 = (MutableState) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        mutableState3 = (MutableState) rememberedValue2;
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        mutableState4 = (MutableState) rememberedValue3;
        if (mutableState.getValue().booleanValue()) {
        }
        if (!mutableState.getValue().booleanValue()) {
        }
        startRestartGroup.startReplaceableGroup(1157296644);
        changed = startRestartGroup.changed(mutableState2);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue4 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$popoverScale$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Float f172) {
                if (f172.floatValue() == 0.1f) {
                    mutableState2.setValue(Boolean.FALSE);
                }
                return Unit.INSTANCE;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceableGroup();
        c16 = AnimateAsStateKt.c(f16, null, (Function1) rememberedValue4, startRestartGroup, 0, 2);
        if (!mutableState.getValue().booleanValue()) {
        }
        startRestartGroup.startReplaceableGroup(1157296644);
        changed2 = startRestartGroup.changed(mutableState3);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue5 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$popoverAlpha$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Float f182) {
                if (f182.floatValue() == 0.0f) {
                    mutableState3.setValue(Boolean.FALSE);
                }
                return Unit.INSTANCE;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue5);
        startRestartGroup.endReplaceableGroup();
        AnimateAsStateKt.c(f17, null, (Function1) rememberedValue5, startRestartGroup, 0, 2);
        if (!mutableState.getValue().booleanValue()) {
        }
        startRestartGroup.startReplaceableGroup(1157296644);
        changed3 = startRestartGroup.changed(mutableState4);
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (!changed3) {
        }
        rememberedValue6 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$QUIPopover$modalAlpha$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Float f19) {
                if (f19.floatValue() == 0.0f) {
                    mutableState4.setValue(Boolean.FALSE);
                }
                return Unit.INSTANCE;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue6);
        startRestartGroup.endReplaceableGroup();
        c17 = AnimateAsStateKt.c(f18, null, (Function1) rememberedValue6, startRestartGroup, 0, 2);
        if (((Boolean) mutableState2.getValue()).booleanValue()) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        hVar4 = hVar3;
        popoverTriangle4 = popoverTriangle3;
        z19 = z18;
        function24 = function23;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final void PopoverTriangleView(final boolean z16, final Offset offset, final float f16, final PopoverTriangle popoverTriangle, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-482964191);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-482964191, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangleView (QUIPopover.kt:181)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = Float.valueOf((float) (Math.sqrt(2.0d) * popoverTriangle.triangleHeight));
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final float floatValue = ((Number) rememberedValue).floatValue();
        i.Companion companion = i.INSTANCE;
        float f17 = popoverTriangle.triangleHeight;
        BoxKt.a(ModifiersKt.r(ModifiersKt.O(ComposeLayoutPropUpdaterKt.v(companion, 2 * f17, f17), null, null, new y(0.0f, 0.0f, offset.getX() - popoverTriangle.triangleHeight, offset.getY() + (popoverTriangle.isTriangleTop ? 0.0f : -popoverTriangle.triangleHeight)), null, null, 27, null), !z16), Alignment.TopCenter, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1341623333, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$PopoverTriangleView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                h k3;
                PopoverTriangleShadow popoverTriangleShadow;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1341623333, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangleView.<anonymous> (QUIPopover.kt:203)");
                    }
                    i iVar = i.INSTANCE;
                    i u16 = ComposeLayoutPropUpdaterKt.u(iVar, floatValue);
                    if (!z16) {
                        k3 = popoverTriangle.triangleColor;
                    } else {
                        k3 = h.INSTANCE.k();
                    }
                    i d16 = ModifiersKt.d(u16, k3);
                    float f18 = (-floatValue) / 2;
                    PopoverTriangle popoverTriangle2 = popoverTriangle;
                    y yVar = new y(0.0f, 0.0f, 0.0f, f18 + (popoverTriangle2.isTriangleTop ? popoverTriangle2.triangleHeight : 0.0f));
                    t tVar = new t(45.0f, 0.0f, 0.0f, 6, null);
                    a aVar = new a(0.5f, 0.5f);
                    float f19 = f16;
                    i d17 = ViewEventPropUpdaterKt.d(ModifiersKt.l(ModifiersKt.O(d16, tVar, new u(f19, f19), yVar, aVar, null, 16, null), new f(2.0f, 0.0f, 0.0f, 2.0f)), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$PopoverTriangleView$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    if (z16 && (popoverTriangleShadow = popoverTriangle.triangleShadow) != null) {
                        double d18 = 2.0f;
                        iVar = ModifiersKt.p(iVar, new g((float) ((Math.sqrt(2.0d) * d18) + (Math.sqrt(2.0d) * 0.0f)), (float) ((Math.sqrt(2.0d) * d18) + (Math.sqrt(2.0d) * (-0.0f))), 10.0f, popoverTriangleShadow.shadowColor));
                    }
                    BoxKt.a(d17.b(iVar), Alignment.Center, null, null, composer3, 56, 12);
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
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$PopoverTriangleView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QUIPopoverKt.PopoverTriangleView(z16, offset, f16, popoverTriangle, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$PopoverView(final Offset offset, final float f16, final PopoverTriangle popoverTriangle, final Function2 function2, Composer composer, final int i3) {
        float f17;
        Composer startRestartGroup = composer.startRestartGroup(1026731185);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1026731185, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverView (QUIPopover.kt:133)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, startRestartGroup);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        int i16 = Offset.f450729d;
        int i17 = i3 << 3;
        int i18 = i17 & 112;
        int i19 = i17 & 896;
        PopoverTriangleView(true, offset, f16, popoverTriangle, startRestartGroup, (i16 << 3) | 4102 | i18 | i19);
        i.Companion companion = i.INSTANCE;
        float percentageOffset = popoverTriangle.triangleOffset.getPercentageOffset();
        float f18 = !popoverTriangle.isTriangleTop ? -1.0f : 0.0f;
        float offset2 = popoverTriangle.triangleOffset.getOffset(popoverTriangle.triangleHeight, -1) + offset.getX();
        float y16 = offset.getY();
        if (popoverTriangle.isTriangleTop) {
            f17 = popoverTriangle.triangleHeight - 0.1f;
        } else {
            f17 = (-popoverTriangle.triangleHeight) + 0.1f;
        }
        BoxKt.a(ViewEventPropUpdaterKt.d(ViewEventPropUpdaterKt.m(ModifiersKt.O(companion, null, new u(f16, f16), new y(percentageOffset, f18, offset2, y16 + f17), new a(((Number) mutableState.getValue()).floatValue(), popoverTriangle.isTriangleTop ? 0.0f : 1.0f), null, 17, null), new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$PopoverView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(w wVar) {
                MutableState<Float> mutableState2 = mutableState;
                float f19 = -popoverTriangle.triangleOffset.getPercentageOffset();
                PopoverTriangle popoverTriangle2 = popoverTriangle;
                mutableState2.setValue(Float.valueOf((popoverTriangle2.triangleOffset.getOffset(popoverTriangle2.triangleHeight, 1) / wVar.getWidth()) + f19));
                return Unit.INSTANCE;
            }
        }), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$PopoverView$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -331438357, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$PopoverView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                        ComposerKt.traceEventStart(-331438357, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverView.<anonymous> (QUIPopover.kt:166)");
                    }
                    Function2<Composer, Integer, Unit> function22 = function2;
                    if (function22 != null) {
                        function22.invoke(composer3, Integer.valueOf((i3 >> 9) & 14));
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        PopoverTriangleView(false, offset, f16, popoverTriangle, startRestartGroup, (i16 << 3) | 4102 | i18 | i19);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPopoverKt$PopoverView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QUIPopoverKt.access$PopoverView(Offset.this, f16, popoverTriangle, function2, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
