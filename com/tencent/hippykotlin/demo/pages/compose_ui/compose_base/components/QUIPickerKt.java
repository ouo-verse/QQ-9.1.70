package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.luggage.wxa.v1.b;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.lazy.d;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import com.tencent.ntcompose.material.LazyColumnKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt__MathJVMKt;

/* loaded from: classes31.dex */
public final class QUIPickerKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ScrollPicker(i iVar, ScrollPickerState scrollPickerState, int i3, List<String> list, int i16, float f16, float f17, h hVar, h hVar2, final Function0<Unit> function0, Function1<? super ScrollPickerState, Unit> function1, Composer composer, final int i17, final int i18, final int i19) {
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        i iVar2;
        ScrollPickerState scrollPickerState2;
        int i47;
        List<String> list2;
        int i48;
        float f18;
        float f19;
        h hVar3;
        h hVar4;
        int i49;
        Function1<? super ScrollPickerState, Unit> function12;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        Object rememberedValue3;
        int i56;
        boolean changed;
        Object rememberedValue4;
        i iVar3;
        h hVar5;
        Function1<? super ScrollPickerState, Unit> function13;
        final int i57;
        float f26;
        final int i58;
        h hVar6;
        final float f27;
        ScopeUpdateScope endRestartGroup;
        int i59;
        Composer startRestartGroup = composer.startRestartGroup(957310357);
        int i65 = i19 & 1;
        int i66 = i65 != 0 ? i17 | 2 : i17;
        int i67 = i19 & 2;
        if (i67 != 0) {
            i66 |= 16;
        }
        int i68 = i19 & 4;
        if (i68 != 0) {
            i66 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i17 & 896) == 0) {
            i66 |= startRestartGroup.changed(i3) ? 256 : 128;
            i26 = i19 & 8;
            if (i26 != 0) {
                i66 |= 1024;
            }
            i27 = i19 & 16;
            if (i27 == 0) {
                i66 |= 24576;
            } else if ((57344 & i17) == 0) {
                i66 |= startRestartGroup.changed(i16) ? 16384 : 8192;
                i28 = i19 & 32;
                if (i28 != 0) {
                    i66 |= 196608;
                } else if ((458752 & i17) == 0) {
                    i66 |= startRestartGroup.changed(f16) ? 131072 : 65536;
                    i29 = i19 & 64;
                    if (i29 == 0) {
                        i66 |= 1572864;
                    } else if ((i17 & 3670016) == 0) {
                        i66 |= startRestartGroup.changed(f17) ? 1048576 : 524288;
                    }
                    i36 = i19 & 128;
                    if (i36 != 0) {
                        i66 |= 4194304;
                    }
                    i37 = i19 & 256;
                    if (i37 != 0) {
                        i66 |= 33554432;
                    }
                    if ((i19 & 512) != 0) {
                        i59 = (1879048192 & i17) == 0 ? startRestartGroup.changed(function0) ? 536870912 : 268435456 : 805306368;
                        i38 = i19 & 1024;
                        if (i38 != 0) {
                            i46 = i18 | 6;
                        } else {
                            if ((i18 & 14) != 0) {
                                i39 = i18;
                                if ((i19 & b.CTRL_INDEX) != 395 && (1533916891 & i66) == 306783378 && (i39 & 11) == 2 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    iVar3 = iVar;
                                    scrollPickerState2 = scrollPickerState;
                                    i58 = i3;
                                    list2 = list;
                                    i57 = i16;
                                    f27 = f16;
                                    f26 = f17;
                                    hVar5 = hVar;
                                    hVar6 = hVar2;
                                    function13 = function1;
                                } else {
                                    startRestartGroup.startDefaults();
                                    if ((i17 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        if (i67 != 0) {
                                            i66 &= -113;
                                        }
                                        if (i26 != 0) {
                                            i66 &= -7169;
                                        }
                                        if (i36 != 0) {
                                            i66 &= -29360129;
                                        }
                                        if (i37 != 0) {
                                            i66 &= -234881025;
                                        }
                                        iVar2 = iVar;
                                        scrollPickerState2 = scrollPickerState;
                                        i47 = i3;
                                        list2 = list;
                                        i48 = i16;
                                        f18 = f16;
                                        f19 = f17;
                                        hVar3 = hVar;
                                        hVar4 = hVar2;
                                    } else {
                                        iVar2 = i65 == 0 ? i.INSTANCE : iVar;
                                        if (i67 == 0) {
                                            startRestartGroup.startReplaceableGroup(-492369756);
                                            Object rememberedValue5 = startRestartGroup.rememberedValue();
                                            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue5 = new ScrollPickerState(null, null, 15);
                                                startRestartGroup.updateRememberedValue(rememberedValue5);
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            scrollPickerState2 = (ScrollPickerState) rememberedValue5;
                                            i66 &= -113;
                                        } else {
                                            scrollPickerState2 = scrollPickerState;
                                        }
                                        i47 = i68 == 0 ? 0 : i3;
                                        if (i26 == 0) {
                                            list2 = SnapshotStateKt.mutableStateListOf();
                                            i66 &= -7169;
                                        } else {
                                            list2 = list;
                                        }
                                        i48 = i27 == 0 ? 0 : i16;
                                        f18 = i28 == 0 ? 0.0f : f16;
                                        f19 = i29 == 0 ? f17 : 0.0f;
                                        if (i36 == 0) {
                                            hVar3 = h.INSTANCE.j();
                                            i66 &= -29360129;
                                        } else {
                                            hVar3 = hVar;
                                        }
                                        if (i37 == 0) {
                                            hVar4 = h.INSTANCE.b();
                                            i66 &= -234881025;
                                        } else {
                                            hVar4 = hVar2;
                                        }
                                        if (i38 != 0) {
                                            i49 = i66;
                                            function12 = null;
                                            startRestartGroup.endDefaults();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(957310357, i49, i39, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ScrollPicker (QUIPicker.kt:204)");
                                            }
                                            startRestartGroup.startReplaceableGroup(-492369756);
                                            rememberedValue = startRestartGroup.rememberedValue();
                                            companion = Composer.INSTANCE;
                                            if (rememberedValue == companion.getEmpty()) {
                                                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            final MutableState mutableState = (MutableState) rememberedValue;
                                            startRestartGroup.startReplaceableGroup(-492369756);
                                            rememberedValue2 = startRestartGroup.rememberedValue();
                                            if (rememberedValue2 == companion.getEmpty()) {
                                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(-1, null, 2, null);
                                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            final MutableState mutableState2 = (MutableState) rememberedValue2;
                                            startRestartGroup.startReplaceableGroup(-492369756);
                                            rememberedValue3 = startRestartGroup.rememberedValue();
                                            if (rememberedValue3 == companion.getEmpty()) {
                                                i56 = i47;
                                                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                                startRestartGroup.updateRememberedValue(rememberedValue3);
                                            } else {
                                                i56 = i47;
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            MutableState mutableState3 = (MutableState) rememberedValue3;
                                            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(iVar2, f19), i48 * f18);
                                            d dVar = scrollPickerState2.state;
                                            Boolean bool = Boolean.FALSE;
                                            final float f28 = f18;
                                            final List<String> list3 = list2;
                                            final ScrollPickerState scrollPickerState3 = scrollPickerState2;
                                            final Function1<? super ScrollPickerState, Unit> function14 = function12;
                                            Function1<ScrollParams, Unit> function15 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ScrollParams scrollParams) {
                                                    int roundToInt;
                                                    roundToInt = MathKt__MathJVMKt.roundToInt(scrollParams.getOffsetY() / f28);
                                                    int min = Math.min(Math.max(0, roundToInt), list3.size() - 1);
                                                    mutableState.setValue(Integer.valueOf(min));
                                                    if (mutableState2.getValue().intValue() != mutableState.getValue().intValue()) {
                                                        d.x(scrollPickerState3.state, min, 0.0f, true, null, 8, null);
                                                        mutableState2.setValue(mutableState.getValue());
                                                        scrollPickerState3.centerValue = list3.get(mutableState.getValue().intValue());
                                                        scrollPickerState3.centerItemIndex = mutableState.getValue().intValue();
                                                        Function1<ScrollPickerState, Unit> function16 = function14;
                                                        if (function16 != null) {
                                                            function16.invoke(scrollPickerState3);
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            startRestartGroup.startReplaceableGroup(511388516);
                                            float f29 = f19;
                                            changed = startRestartGroup.changed(mutableState2) | startRestartGroup.changed(function0);
                                            i iVar4 = iVar2;
                                            rememberedValue4 = startRestartGroup.rememberedValue();
                                            if (!changed || rememberedValue4 == companion.getEmpty()) {
                                                rememberedValue4 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$3$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ScrollParams scrollParams) {
                                                        mutableState2.setValue(-1);
                                                        function0.invoke();
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue4);
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            final int i69 = i48;
                                            final float f36 = f18;
                                            final h hVar7 = hVar3;
                                            final List<String> list4 = list2;
                                            final h hVar8 = hVar4;
                                            LazyColumnKt.a(k3, null, dVar, null, null, null, bool, bool, null, null, null, 0, null, null, null, null, null, function15, (Function1) rememberedValue4, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2037395696, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$4
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(a aVar, Composer composer2, Integer num) {
                                                    Composer composer3 = composer2;
                                                    int intValue = num.intValue();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-2037395696, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ScrollPicker.<anonymous> (QUIPicker.kt:242)");
                                                    }
                                                    int i75 = i69 / 2;
                                                    if (1 <= i75) {
                                                        int i76 = 1;
                                                        while (true) {
                                                            BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f36), hVar7), null, null, null, composer3, 8, 14);
                                                            if (i76 == i75) {
                                                                break;
                                                            }
                                                            i76++;
                                                        }
                                                    }
                                                    List<String> list5 = list4;
                                                    float f37 = f36;
                                                    h hVar9 = hVar7;
                                                    final h hVar10 = hVar8;
                                                    for (final String str : list5) {
                                                        BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f37), hVar9), Alignment.Center, null, ComposableLambdaKt.composableLambda(composer3, 1259854150, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$4$1$1
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
                                                                        ComposerKt.traceEventStart(1259854150, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ScrollPicker.<anonymous>.<anonymous>.<anonymous> (QUIPicker.kt:258)");
                                                                    }
                                                                    TextKt.a(str, null, null, hVar10, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, 1601536, 100663296, 0, 133955494);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer3, 3128, 4);
                                                    }
                                                    int i77 = i69 / 2;
                                                    if (1 <= i77) {
                                                        int i78 = 1;
                                                        while (true) {
                                                            BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f36), hVar7), null, null, null, composer3, 8, 14);
                                                            if (i78 == i77) {
                                                                break;
                                                            }
                                                            i78++;
                                                        }
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), startRestartGroup, 14155784, 0, MsgConstant.KRMFILETHUMBSIZE384, 3800890);
                                            EffectsKt.LaunchedEffect(Float.valueOf(scrollPickerState2.state.d()), new QUIPickerKt$ScrollPicker$5(scrollPickerState2, i56, mutableState3, list4, null), startRestartGroup, 64);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            iVar3 = iVar4;
                                            hVar5 = hVar3;
                                            function13 = function12;
                                            i57 = i48;
                                            f26 = f29;
                                            i58 = i56;
                                            float f37 = f18;
                                            hVar6 = hVar4;
                                            f27 = f37;
                                        }
                                    }
                                    i49 = i66;
                                    function12 = function1;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    companion = Composer.INSTANCE;
                                    if (rememberedValue == companion.getEmpty()) {
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    final MutableState<Integer> mutableState4 = (MutableState) rememberedValue;
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == companion.getEmpty()) {
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    final MutableState<Integer> mutableState22 = (MutableState) rememberedValue2;
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (rememberedValue3 == companion.getEmpty()) {
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    MutableState mutableState32 = (MutableState) rememberedValue3;
                                    i k36 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(iVar2, f19), i48 * f18);
                                    d dVar2 = scrollPickerState2.state;
                                    Boolean bool2 = Boolean.FALSE;
                                    final float f282 = f18;
                                    final List<String> list32 = list2;
                                    final ScrollPickerState scrollPickerState32 = scrollPickerState2;
                                    final Function1<? super ScrollPickerState, Unit> function142 = function12;
                                    Function1<ScrollParams, Unit> function152 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ScrollParams scrollParams) {
                                            int roundToInt;
                                            roundToInt = MathKt__MathJVMKt.roundToInt(scrollParams.getOffsetY() / f282);
                                            int min = Math.min(Math.max(0, roundToInt), list32.size() - 1);
                                            mutableState4.setValue(Integer.valueOf(min));
                                            if (mutableState22.getValue().intValue() != mutableState4.getValue().intValue()) {
                                                d.x(scrollPickerState32.state, min, 0.0f, true, null, 8, null);
                                                mutableState22.setValue(mutableState4.getValue());
                                                scrollPickerState32.centerValue = list32.get(mutableState4.getValue().intValue());
                                                scrollPickerState32.centerItemIndex = mutableState4.getValue().intValue();
                                                Function1<ScrollPickerState, Unit> function16 = function142;
                                                if (function16 != null) {
                                                    function16.invoke(scrollPickerState32);
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    startRestartGroup.startReplaceableGroup(511388516);
                                    float f292 = f19;
                                    changed = startRestartGroup.changed(mutableState22) | startRestartGroup.changed(function0);
                                    i iVar42 = iVar2;
                                    rememberedValue4 = startRestartGroup.rememberedValue();
                                    if (!changed) {
                                    }
                                    rememberedValue4 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$3$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ScrollParams scrollParams) {
                                            mutableState22.setValue(-1);
                                            function0.invoke();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                    startRestartGroup.endReplaceableGroup();
                                    final int i692 = i48;
                                    final float f362 = f18;
                                    final h hVar72 = hVar3;
                                    final List<String> list42 = list2;
                                    final h hVar82 = hVar4;
                                    LazyColumnKt.a(k36, null, dVar2, null, null, null, bool2, bool2, null, null, null, 0, null, null, null, null, null, function152, (Function1) rememberedValue4, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2037395696, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(a aVar, Composer composer2, Integer num) {
                                            Composer composer3 = composer2;
                                            int intValue = num.intValue();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2037395696, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ScrollPicker.<anonymous> (QUIPicker.kt:242)");
                                            }
                                            int i75 = i692 / 2;
                                            if (1 <= i75) {
                                                int i76 = 1;
                                                while (true) {
                                                    BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f362), hVar72), null, null, null, composer3, 8, 14);
                                                    if (i76 == i75) {
                                                        break;
                                                    }
                                                    i76++;
                                                }
                                            }
                                            List<String> list5 = list42;
                                            float f372 = f362;
                                            h hVar9 = hVar72;
                                            final h hVar10 = hVar82;
                                            for (final String str : list5) {
                                                BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f372), hVar9), Alignment.Center, null, ComposableLambdaKt.composableLambda(composer3, 1259854150, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$4$1$1
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
                                                                ComposerKt.traceEventStart(1259854150, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ScrollPicker.<anonymous>.<anonymous>.<anonymous> (QUIPicker.kt:258)");
                                                            }
                                                            TextKt.a(str, null, null, hVar10, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, 1601536, 100663296, 0, 133955494);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer3, 3128, 4);
                                            }
                                            int i77 = i692 / 2;
                                            if (1 <= i77) {
                                                int i78 = 1;
                                                while (true) {
                                                    BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f362), hVar72), null, null, null, composer3, 8, 14);
                                                    if (i78 == i77) {
                                                        break;
                                                    }
                                                    i78++;
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), startRestartGroup, 14155784, 0, MsgConstant.KRMFILETHUMBSIZE384, 3800890);
                                    EffectsKt.LaunchedEffect(Float.valueOf(scrollPickerState2.state.d()), new QUIPickerKt$ScrollPicker$5(scrollPickerState2, i56, mutableState32, list42, null), startRestartGroup, 64);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    iVar3 = iVar42;
                                    hVar5 = hVar3;
                                    function13 = function12;
                                    i57 = i48;
                                    f26 = f292;
                                    i58 = i56;
                                    float f372 = f18;
                                    hVar6 = hVar4;
                                    f27 = f372;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    return;
                                }
                                final i iVar5 = iVar3;
                                final ScrollPickerState scrollPickerState4 = scrollPickerState2;
                                final List<String> list5 = list2;
                                final float f38 = f26;
                                final h hVar9 = hVar5;
                                final h hVar10 = hVar6;
                                final Function1<? super ScrollPickerState, Unit> function16 = function13;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Composer composer2, Integer num) {
                                        num.intValue();
                                        QUIPickerKt.ScrollPicker(i.this, scrollPickerState4, i58, list5, i57, f27, f38, hVar9, hVar10, function0, function16, composer2, i17 | 1, i18, i19);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return;
                            }
                            i46 = i18 | (startRestartGroup.changed(function1) ? 4 : 2);
                        }
                        i39 = i46;
                        if ((i19 & b.CTRL_INDEX) != 395) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i17 & 1) == 0) {
                        }
                        if (i65 == 0) {
                        }
                        if (i67 == 0) {
                        }
                        if (i68 == 0) {
                        }
                        if (i26 == 0) {
                        }
                        if (i27 == 0) {
                        }
                        if (i28 == 0) {
                        }
                        if (i29 == 0) {
                        }
                        if (i36 == 0) {
                        }
                        if (i37 == 0) {
                        }
                        if (i38 != 0) {
                        }
                        i49 = i66;
                        function12 = function1;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(-492369756);
                        rememberedValue = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (rememberedValue == companion.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        final MutableState<Integer> mutableState42 = (MutableState) rememberedValue;
                        startRestartGroup.startReplaceableGroup(-492369756);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == companion.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        final MutableState<Integer> mutableState222 = (MutableState) rememberedValue2;
                        startRestartGroup.startReplaceableGroup(-492369756);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (rememberedValue3 == companion.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        MutableState mutableState322 = (MutableState) rememberedValue3;
                        i k362 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(iVar2, f19), i48 * f18);
                        d dVar22 = scrollPickerState2.state;
                        Boolean bool22 = Boolean.FALSE;
                        final float f2822 = f18;
                        final List<String> list322 = list2;
                        final ScrollPickerState scrollPickerState322 = scrollPickerState2;
                        final Function1<? super ScrollPickerState, Unit> function1422 = function12;
                        Function1<ScrollParams, Unit> function1522 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ScrollParams scrollParams) {
                                int roundToInt;
                                roundToInt = MathKt__MathJVMKt.roundToInt(scrollParams.getOffsetY() / f2822);
                                int min = Math.min(Math.max(0, roundToInt), list322.size() - 1);
                                mutableState42.setValue(Integer.valueOf(min));
                                if (mutableState222.getValue().intValue() != mutableState42.getValue().intValue()) {
                                    d.x(scrollPickerState322.state, min, 0.0f, true, null, 8, null);
                                    mutableState222.setValue(mutableState42.getValue());
                                    scrollPickerState322.centerValue = list322.get(mutableState42.getValue().intValue());
                                    scrollPickerState322.centerItemIndex = mutableState42.getValue().intValue();
                                    Function1<ScrollPickerState, Unit> function162 = function1422;
                                    if (function162 != null) {
                                        function162.invoke(scrollPickerState322);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        startRestartGroup.startReplaceableGroup(511388516);
                        float f2922 = f19;
                        changed = startRestartGroup.changed(mutableState222) | startRestartGroup.changed(function0);
                        i iVar422 = iVar2;
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue4 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ScrollParams scrollParams) {
                                mutableState222.setValue(-1);
                                function0.invoke();
                                return Unit.INSTANCE;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                        startRestartGroup.endReplaceableGroup();
                        final int i6922 = i48;
                        final float f3622 = f18;
                        final h hVar722 = hVar3;
                        final List<String> list422 = list2;
                        final h hVar822 = hVar4;
                        LazyColumnKt.a(k362, null, dVar22, null, null, null, bool22, bool22, null, null, null, 0, null, null, null, null, null, function1522, (Function1) rememberedValue4, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2037395696, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(a aVar, Composer composer2, Integer num) {
                                Composer composer3 = composer2;
                                int intValue = num.intValue();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2037395696, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ScrollPicker.<anonymous> (QUIPicker.kt:242)");
                                }
                                int i75 = i6922 / 2;
                                if (1 <= i75) {
                                    int i76 = 1;
                                    while (true) {
                                        BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f3622), hVar722), null, null, null, composer3, 8, 14);
                                        if (i76 == i75) {
                                            break;
                                        }
                                        i76++;
                                    }
                                }
                                List<String> list52 = list422;
                                float f3722 = f3622;
                                h hVar92 = hVar722;
                                final h hVar102 = hVar822;
                                for (final String str : list52) {
                                    BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f3722), hVar92), Alignment.Center, null, ComposableLambdaKt.composableLambda(composer3, 1259854150, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$4$1$1
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
                                                    ComposerKt.traceEventStart(1259854150, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ScrollPicker.<anonymous>.<anonymous>.<anonymous> (QUIPicker.kt:258)");
                                                }
                                                TextKt.a(str, null, null, hVar102, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, 1601536, 100663296, 0, 133955494);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer3, 3128, 4);
                                }
                                int i77 = i6922 / 2;
                                if (1 <= i77) {
                                    int i78 = 1;
                                    while (true) {
                                        BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f3622), hVar722), null, null, null, composer3, 8, 14);
                                        if (i78 == i77) {
                                            break;
                                        }
                                        i78++;
                                    }
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }), startRestartGroup, 14155784, 0, MsgConstant.KRMFILETHUMBSIZE384, 3800890);
                        EffectsKt.LaunchedEffect(Float.valueOf(scrollPickerState2.state.d()), new QUIPickerKt$ScrollPicker$5(scrollPickerState2, i56, mutableState322, list422, null), startRestartGroup, 64);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        iVar3 = iVar422;
                        hVar5 = hVar3;
                        function13 = function12;
                        i57 = i48;
                        f26 = f2922;
                        i58 = i56;
                        float f3722 = f18;
                        hVar6 = hVar4;
                        f27 = f3722;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i66 |= i59;
                    i38 = i19 & 1024;
                    if (i38 != 0) {
                    }
                    i39 = i46;
                    if ((i19 & b.CTRL_INDEX) != 395) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i17 & 1) == 0) {
                    }
                    if (i65 == 0) {
                    }
                    if (i67 == 0) {
                    }
                    if (i68 == 0) {
                    }
                    if (i26 == 0) {
                    }
                    if (i27 == 0) {
                    }
                    if (i28 == 0) {
                    }
                    if (i29 == 0) {
                    }
                    if (i36 == 0) {
                    }
                    if (i37 == 0) {
                    }
                    if (i38 != 0) {
                    }
                    i49 = i66;
                    function12 = function1;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState<Integer> mutableState422 = (MutableState) rememberedValue;
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState<Integer> mutableState2222 = (MutableState) rememberedValue2;
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    MutableState mutableState3222 = (MutableState) rememberedValue3;
                    i k3622 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(iVar2, f19), i48 * f18);
                    d dVar222 = scrollPickerState2.state;
                    Boolean bool222 = Boolean.FALSE;
                    final float f28222 = f18;
                    final List<String> list3222 = list2;
                    final ScrollPickerState scrollPickerState3222 = scrollPickerState2;
                    final Function1<? super ScrollPickerState, Unit> function14222 = function12;
                    Function1<ScrollParams, Unit> function15222 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ScrollParams scrollParams) {
                            int roundToInt;
                            roundToInt = MathKt__MathJVMKt.roundToInt(scrollParams.getOffsetY() / f28222);
                            int min = Math.min(Math.max(0, roundToInt), list3222.size() - 1);
                            mutableState422.setValue(Integer.valueOf(min));
                            if (mutableState2222.getValue().intValue() != mutableState422.getValue().intValue()) {
                                d.x(scrollPickerState3222.state, min, 0.0f, true, null, 8, null);
                                mutableState2222.setValue(mutableState422.getValue());
                                scrollPickerState3222.centerValue = list3222.get(mutableState422.getValue().intValue());
                                scrollPickerState3222.centerItemIndex = mutableState422.getValue().intValue();
                                Function1<ScrollPickerState, Unit> function162 = function14222;
                                if (function162 != null) {
                                    function162.invoke(scrollPickerState3222);
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.startReplaceableGroup(511388516);
                    float f29222 = f19;
                    changed = startRestartGroup.changed(mutableState2222) | startRestartGroup.changed(function0);
                    i iVar4222 = iVar2;
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue4 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ScrollParams scrollParams) {
                            mutableState2222.setValue(-1);
                            function0.invoke();
                            return Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    startRestartGroup.endReplaceableGroup();
                    final int i69222 = i48;
                    final float f36222 = f18;
                    final h hVar7222 = hVar3;
                    final List<String> list4222 = list2;
                    final h hVar8222 = hVar4;
                    LazyColumnKt.a(k3622, null, dVar222, null, null, null, bool222, bool222, null, null, null, 0, null, null, null, null, null, function15222, (Function1) rememberedValue4, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2037395696, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(a aVar, Composer composer2, Integer num) {
                            Composer composer3 = composer2;
                            int intValue = num.intValue();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2037395696, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ScrollPicker.<anonymous> (QUIPicker.kt:242)");
                            }
                            int i75 = i69222 / 2;
                            if (1 <= i75) {
                                int i76 = 1;
                                while (true) {
                                    BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f36222), hVar7222), null, null, null, composer3, 8, 14);
                                    if (i76 == i75) {
                                        break;
                                    }
                                    i76++;
                                }
                            }
                            List<String> list52 = list4222;
                            float f37222 = f36222;
                            h hVar92 = hVar7222;
                            final h hVar102 = hVar8222;
                            for (final String str : list52) {
                                BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f37222), hVar92), Alignment.Center, null, ComposableLambdaKt.composableLambda(composer3, 1259854150, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$4$1$1
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
                                                ComposerKt.traceEventStart(1259854150, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ScrollPicker.<anonymous>.<anonymous>.<anonymous> (QUIPicker.kt:258)");
                                            }
                                            TextKt.a(str, null, null, hVar102, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, 1601536, 100663296, 0, 133955494);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer3, 3128, 4);
                            }
                            int i77 = i69222 / 2;
                            if (1 <= i77) {
                                int i78 = 1;
                                while (true) {
                                    BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f36222), hVar7222), null, null, null, composer3, 8, 14);
                                    if (i78 == i77) {
                                        break;
                                    }
                                    i78++;
                                }
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }), startRestartGroup, 14155784, 0, MsgConstant.KRMFILETHUMBSIZE384, 3800890);
                    EffectsKt.LaunchedEffect(Float.valueOf(scrollPickerState2.state.d()), new QUIPickerKt$ScrollPicker$5(scrollPickerState2, i56, mutableState3222, list4222, null), startRestartGroup, 64);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    iVar3 = iVar4222;
                    hVar5 = hVar3;
                    function13 = function12;
                    i57 = i48;
                    f26 = f29222;
                    i58 = i56;
                    float f37222 = f18;
                    hVar6 = hVar4;
                    f27 = f37222;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i29 = i19 & 64;
                if (i29 == 0) {
                }
                i36 = i19 & 128;
                if (i36 != 0) {
                }
                i37 = i19 & 256;
                if (i37 != 0) {
                }
                if ((i19 & 512) != 0) {
                }
                i66 |= i59;
                i38 = i19 & 1024;
                if (i38 != 0) {
                }
                i39 = i46;
                if ((i19 & b.CTRL_INDEX) != 395) {
                }
                startRestartGroup.startDefaults();
                if ((i17 & 1) == 0) {
                }
                if (i65 == 0) {
                }
                if (i67 == 0) {
                }
                if (i68 == 0) {
                }
                if (i26 == 0) {
                }
                if (i27 == 0) {
                }
                if (i28 == 0) {
                }
                if (i29 == 0) {
                }
                if (i36 == 0) {
                }
                if (i37 == 0) {
                }
                if (i38 != 0) {
                }
                i49 = i66;
                function12 = function1;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState<Integer> mutableState4222 = (MutableState) rememberedValue;
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState<Integer> mutableState22222 = (MutableState) rememberedValue2;
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                MutableState mutableState32222 = (MutableState) rememberedValue3;
                i k36222 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(iVar2, f19), i48 * f18);
                d dVar2222 = scrollPickerState2.state;
                Boolean bool2222 = Boolean.FALSE;
                final float f282222 = f18;
                final List<String> list32222 = list2;
                final ScrollPickerState scrollPickerState32222 = scrollPickerState2;
                final Function1<? super ScrollPickerState, Unit> function142222 = function12;
                Function1<ScrollParams, Unit> function152222 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ScrollParams scrollParams) {
                        int roundToInt;
                        roundToInt = MathKt__MathJVMKt.roundToInt(scrollParams.getOffsetY() / f282222);
                        int min = Math.min(Math.max(0, roundToInt), list32222.size() - 1);
                        mutableState4222.setValue(Integer.valueOf(min));
                        if (mutableState22222.getValue().intValue() != mutableState4222.getValue().intValue()) {
                            d.x(scrollPickerState32222.state, min, 0.0f, true, null, 8, null);
                            mutableState22222.setValue(mutableState4222.getValue());
                            scrollPickerState32222.centerValue = list32222.get(mutableState4222.getValue().intValue());
                            scrollPickerState32222.centerItemIndex = mutableState4222.getValue().intValue();
                            Function1<ScrollPickerState, Unit> function162 = function142222;
                            if (function162 != null) {
                                function162.invoke(scrollPickerState32222);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.startReplaceableGroup(511388516);
                float f292222 = f19;
                changed = startRestartGroup.changed(mutableState22222) | startRestartGroup.changed(function0);
                i iVar42222 = iVar2;
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue4 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ScrollParams scrollParams) {
                        mutableState22222.setValue(-1);
                        function0.invoke();
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
                startRestartGroup.endReplaceableGroup();
                final int i692222 = i48;
                final float f362222 = f18;
                final h hVar72222 = hVar3;
                final List<String> list42222 = list2;
                final h hVar82222 = hVar4;
                LazyColumnKt.a(k36222, null, dVar2222, null, null, null, bool2222, bool2222, null, null, null, 0, null, null, null, null, null, function152222, (Function1) rememberedValue4, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2037395696, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(a aVar, Composer composer2, Integer num) {
                        Composer composer3 = composer2;
                        int intValue = num.intValue();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2037395696, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ScrollPicker.<anonymous> (QUIPicker.kt:242)");
                        }
                        int i75 = i692222 / 2;
                        if (1 <= i75) {
                            int i76 = 1;
                            while (true) {
                                BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f362222), hVar72222), null, null, null, composer3, 8, 14);
                                if (i76 == i75) {
                                    break;
                                }
                                i76++;
                            }
                        }
                        List<String> list52 = list42222;
                        float f372222 = f362222;
                        h hVar92 = hVar72222;
                        final h hVar102 = hVar82222;
                        for (final String str : list52) {
                            BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f372222), hVar92), Alignment.Center, null, ComposableLambdaKt.composableLambda(composer3, 1259854150, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$4$1$1
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
                                            ComposerKt.traceEventStart(1259854150, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ScrollPicker.<anonymous>.<anonymous>.<anonymous> (QUIPicker.kt:258)");
                                        }
                                        TextKt.a(str, null, null, hVar102, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, 1601536, 100663296, 0, 133955494);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 3128, 4);
                        }
                        int i77 = i692222 / 2;
                        if (1 <= i77) {
                            int i78 = 1;
                            while (true) {
                                BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f362222), hVar72222), null, null, null, composer3, 8, 14);
                                if (i78 == i77) {
                                    break;
                                }
                                i78++;
                            }
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 14155784, 0, MsgConstant.KRMFILETHUMBSIZE384, 3800890);
                EffectsKt.LaunchedEffect(Float.valueOf(scrollPickerState2.state.d()), new QUIPickerKt$ScrollPicker$5(scrollPickerState2, i56, mutableState32222, list42222, null), startRestartGroup, 64);
                if (ComposerKt.isTraceInProgress()) {
                }
                iVar3 = iVar42222;
                hVar5 = hVar3;
                function13 = function12;
                i57 = i48;
                f26 = f292222;
                i58 = i56;
                float f372222 = f18;
                hVar6 = hVar4;
                f27 = f372222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i28 = i19 & 32;
            if (i28 != 0) {
            }
            i29 = i19 & 64;
            if (i29 == 0) {
            }
            i36 = i19 & 128;
            if (i36 != 0) {
            }
            i37 = i19 & 256;
            if (i37 != 0) {
            }
            if ((i19 & 512) != 0) {
            }
            i66 |= i59;
            i38 = i19 & 1024;
            if (i38 != 0) {
            }
            i39 = i46;
            if ((i19 & b.CTRL_INDEX) != 395) {
            }
            startRestartGroup.startDefaults();
            if ((i17 & 1) == 0) {
            }
            if (i65 == 0) {
            }
            if (i67 == 0) {
            }
            if (i68 == 0) {
            }
            if (i26 == 0) {
            }
            if (i27 == 0) {
            }
            if (i28 == 0) {
            }
            if (i29 == 0) {
            }
            if (i36 == 0) {
            }
            if (i37 == 0) {
            }
            if (i38 != 0) {
            }
            i49 = i66;
            function12 = function1;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<Integer> mutableState42222 = (MutableState) rememberedValue;
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<Integer> mutableState222222 = (MutableState) rememberedValue2;
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            MutableState mutableState322222 = (MutableState) rememberedValue3;
            i k362222 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(iVar2, f19), i48 * f18);
            d dVar22222 = scrollPickerState2.state;
            Boolean bool22222 = Boolean.FALSE;
            final float f2822222 = f18;
            final List<String> list322222 = list2;
            final ScrollPickerState scrollPickerState322222 = scrollPickerState2;
            final Function1<? super ScrollPickerState, Unit> function1422222 = function12;
            Function1<ScrollParams, Unit> function1522222 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ScrollParams scrollParams) {
                    int roundToInt;
                    roundToInt = MathKt__MathJVMKt.roundToInt(scrollParams.getOffsetY() / f2822222);
                    int min = Math.min(Math.max(0, roundToInt), list322222.size() - 1);
                    mutableState42222.setValue(Integer.valueOf(min));
                    if (mutableState222222.getValue().intValue() != mutableState42222.getValue().intValue()) {
                        d.x(scrollPickerState322222.state, min, 0.0f, true, null, 8, null);
                        mutableState222222.setValue(mutableState42222.getValue());
                        scrollPickerState322222.centerValue = list322222.get(mutableState42222.getValue().intValue());
                        scrollPickerState322222.centerItemIndex = mutableState42222.getValue().intValue();
                        Function1<ScrollPickerState, Unit> function162 = function1422222;
                        if (function162 != null) {
                            function162.invoke(scrollPickerState322222);
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.startReplaceableGroup(511388516);
            float f2922222 = f19;
            changed = startRestartGroup.changed(mutableState222222) | startRestartGroup.changed(function0);
            i iVar422222 = iVar2;
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue4 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ScrollParams scrollParams) {
                    mutableState222222.setValue(-1);
                    function0.invoke();
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            startRestartGroup.endReplaceableGroup();
            final int i6922222 = i48;
            final float f3622222 = f18;
            final h hVar722222 = hVar3;
            final List<String> list422222 = list2;
            final h hVar822222 = hVar4;
            LazyColumnKt.a(k362222, null, dVar22222, null, null, null, bool22222, bool22222, null, null, null, 0, null, null, null, null, null, function1522222, (Function1) rememberedValue4, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2037395696, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(a aVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2037395696, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ScrollPicker.<anonymous> (QUIPicker.kt:242)");
                    }
                    int i75 = i6922222 / 2;
                    if (1 <= i75) {
                        int i76 = 1;
                        while (true) {
                            BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f3622222), hVar722222), null, null, null, composer3, 8, 14);
                            if (i76 == i75) {
                                break;
                            }
                            i76++;
                        }
                    }
                    List<String> list52 = list422222;
                    float f3722222 = f3622222;
                    h hVar92 = hVar722222;
                    final h hVar102 = hVar822222;
                    for (final String str : list52) {
                        BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f3722222), hVar92), Alignment.Center, null, ComposableLambdaKt.composableLambda(composer3, 1259854150, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$4$1$1
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
                                        ComposerKt.traceEventStart(1259854150, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ScrollPicker.<anonymous>.<anonymous>.<anonymous> (QUIPicker.kt:258)");
                                    }
                                    TextKt.a(str, null, null, hVar102, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, 1601536, 100663296, 0, 133955494);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3128, 4);
                    }
                    int i77 = i6922222 / 2;
                    if (1 <= i77) {
                        int i78 = 1;
                        while (true) {
                            BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f3622222), hVar722222), null, null, null, composer3, 8, 14);
                            if (i78 == i77) {
                                break;
                            }
                            i78++;
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 14155784, 0, MsgConstant.KRMFILETHUMBSIZE384, 3800890);
            EffectsKt.LaunchedEffect(Float.valueOf(scrollPickerState2.state.d()), new QUIPickerKt$ScrollPicker$5(scrollPickerState2, i56, mutableState322222, list422222, null), startRestartGroup, 64);
            if (ComposerKt.isTraceInProgress()) {
            }
            iVar3 = iVar422222;
            hVar5 = hVar3;
            function13 = function12;
            i57 = i48;
            f26 = f2922222;
            i58 = i56;
            float f3722222 = f18;
            hVar6 = hVar4;
            f27 = f3722222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i26 = i19 & 8;
        if (i26 != 0) {
        }
        i27 = i19 & 16;
        if (i27 == 0) {
        }
        i28 = i19 & 32;
        if (i28 != 0) {
        }
        i29 = i19 & 64;
        if (i29 == 0) {
        }
        i36 = i19 & 128;
        if (i36 != 0) {
        }
        i37 = i19 & 256;
        if (i37 != 0) {
        }
        if ((i19 & 512) != 0) {
        }
        i66 |= i59;
        i38 = i19 & 1024;
        if (i38 != 0) {
        }
        i39 = i46;
        if ((i19 & b.CTRL_INDEX) != 395) {
        }
        startRestartGroup.startDefaults();
        if ((i17 & 1) == 0) {
        }
        if (i65 == 0) {
        }
        if (i67 == 0) {
        }
        if (i68 == 0) {
        }
        if (i26 == 0) {
        }
        if (i27 == 0) {
        }
        if (i28 == 0) {
        }
        if (i29 == 0) {
        }
        if (i36 == 0) {
        }
        if (i37 == 0) {
        }
        if (i38 != 0) {
        }
        i49 = i66;
        function12 = function1;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<Integer> mutableState422222 = (MutableState) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<Integer> mutableState2222222 = (MutableState) rememberedValue2;
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        MutableState mutableState3222222 = (MutableState) rememberedValue3;
        i k3622222 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(iVar2, f19), i48 * f18);
        d dVar222222 = scrollPickerState2.state;
        Boolean bool222222 = Boolean.FALSE;
        final float f28222222 = f18;
        final List<String> list3222222 = list2;
        final ScrollPickerState scrollPickerState3222222 = scrollPickerState2;
        final Function1<? super ScrollPickerState, Unit> function14222222 = function12;
        Function1<ScrollParams, Unit> function15222222 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ScrollParams scrollParams) {
                int roundToInt;
                roundToInt = MathKt__MathJVMKt.roundToInt(scrollParams.getOffsetY() / f28222222);
                int min = Math.min(Math.max(0, roundToInt), list3222222.size() - 1);
                mutableState422222.setValue(Integer.valueOf(min));
                if (mutableState2222222.getValue().intValue() != mutableState422222.getValue().intValue()) {
                    d.x(scrollPickerState3222222.state, min, 0.0f, true, null, 8, null);
                    mutableState2222222.setValue(mutableState422222.getValue());
                    scrollPickerState3222222.centerValue = list3222222.get(mutableState422222.getValue().intValue());
                    scrollPickerState3222222.centerItemIndex = mutableState422222.getValue().intValue();
                    Function1<ScrollPickerState, Unit> function162 = function14222222;
                    if (function162 != null) {
                        function162.invoke(scrollPickerState3222222);
                    }
                }
                return Unit.INSTANCE;
            }
        };
        startRestartGroup.startReplaceableGroup(511388516);
        float f29222222 = f19;
        changed = startRestartGroup.changed(mutableState2222222) | startRestartGroup.changed(function0);
        i iVar4222222 = iVar2;
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue4 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$3$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ScrollParams scrollParams) {
                mutableState2222222.setValue(-1);
                function0.invoke();
                return Unit.INSTANCE;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceableGroup();
        final int i69222222 = i48;
        final float f36222222 = f18;
        final h hVar7222222 = hVar3;
        final List<String> list4222222 = list2;
        final h hVar8222222 = hVar4;
        LazyColumnKt.a(k3622222, null, dVar222222, null, null, null, bool222222, bool222222, null, null, null, 0, null, null, null, null, null, function15222222, (Function1) rememberedValue4, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -2037395696, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(a aVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2037395696, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ScrollPicker.<anonymous> (QUIPicker.kt:242)");
                }
                int i75 = i69222222 / 2;
                if (1 <= i75) {
                    int i76 = 1;
                    while (true) {
                        BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f36222222), hVar7222222), null, null, null, composer3, 8, 14);
                        if (i76 == i75) {
                            break;
                        }
                        i76++;
                    }
                }
                List<String> list52 = list4222222;
                float f37222222 = f36222222;
                h hVar92 = hVar7222222;
                final h hVar102 = hVar8222222;
                for (final String str : list52) {
                    BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f37222222), hVar92), Alignment.Center, null, ComposableLambdaKt.composableLambda(composer3, 1259854150, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPickerKt$ScrollPicker$4$1$1
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
                                    ComposerKt.traceEventStart(1259854150, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.ScrollPicker.<anonymous>.<anonymous>.<anonymous> (QUIPicker.kt:258)");
                                }
                                TextKt.a(str, null, null, hVar102, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, 1601536, 100663296, 0, 133955494);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3128, 4);
                }
                int i77 = i69222222 / 2;
                if (1 <= i77) {
                    int i78 = 1;
                    while (true) {
                        BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f36222222), hVar7222222), null, null, null, composer3, 8, 14);
                        if (i78 == i77) {
                            break;
                        }
                        i78++;
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 14155784, 0, MsgConstant.KRMFILETHUMBSIZE384, 3800890);
        EffectsKt.LaunchedEffect(Float.valueOf(scrollPickerState2.state.d()), new QUIPickerKt$ScrollPicker$5(scrollPickerState2, i56, mutableState3222222, list4222222, null), startRestartGroup, 64);
        if (ComposerKt.isTraceInProgress()) {
        }
        iVar3 = iVar4222222;
        hVar5 = hVar3;
        function13 = function12;
        i57 = i48;
        f26 = f29222222;
        i58 = i56;
        float f37222222 = f18;
        hVar6 = hVar4;
        f27 = f37222222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
