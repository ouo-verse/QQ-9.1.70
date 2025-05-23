package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.core.k;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUIListSingleLineCommonViewKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0262  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QUIListSingleLineCommonView(i iVar, String str, Function2<? super Composer, ? super Integer, Unit> function2, String str2, float f16, h hVar, Function2<? super Composer, ? super Integer, Unit> function22, String str3, Function3<? super i, ? super Composer, ? super Integer, Unit> function3, String str4, Function2<? super Composer, ? super Integer, Unit> function23, float f17, Composer composer, final int i3, final int i16, final int i17) {
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        final int i46;
        i iVar2;
        String str5;
        Function2<? super Composer, ? super Integer, Unit> function24;
        String str6;
        float f18;
        h hVar2;
        Function2<? super Composer, ? super Integer, Unit> function25;
        String str7;
        Function3<? super i, ? super Composer, ? super Integer, Unit> function32;
        String str8;
        Function2<? super Composer, ? super Integer, Unit> function26;
        float f19;
        int i47;
        String str9;
        Function3<? super i, ? super Composer, ? super Integer, Unit> function33;
        String str10;
        h j3;
        final Ref.BooleanRef booleanRef;
        Composer composer2;
        final Function3<? super i, ? super Composer, ? super Integer, Unit> function34;
        final i iVar3;
        final String str11;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final String str12;
        final float f26;
        final String str13;
        final float f27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final String str14;
        final h hVar3;
        ScopeUpdateScope endRestartGroup;
        int i48;
        Composer startRestartGroup = composer.startRestartGroup(1043429814);
        int i49 = i17 & 1;
        int i56 = i49 != 0 ? i3 | 2 : i3;
        int i57 = i17 & 2;
        if (i57 != 0) {
            i56 |= 48;
        } else if ((i3 & 112) == 0) {
            i56 |= startRestartGroup.changed(str) ? 32 : 16;
            i18 = i17 & 4;
            if (i18 == 0) {
                i56 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                i56 |= startRestartGroup.changed(function2) ? 256 : 128;
                i19 = i17 & 8;
                if (i19 != 0) {
                    i56 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    i56 |= startRestartGroup.changed(str2) ? 2048 : 1024;
                    i26 = i17 & 16;
                    if (i26 == 0) {
                        i56 |= 24576;
                    } else if ((57344 & i3) == 0) {
                        i56 |= startRestartGroup.changed(f16) ? 16384 : 8192;
                        i27 = i17 & 32;
                        if (i27 != 0) {
                            i56 |= 65536;
                        }
                        i28 = i17 & 64;
                        if (i28 != 0) {
                            i56 |= 1572864;
                        } else if ((i3 & 3670016) == 0) {
                            i56 |= startRestartGroup.changed(function22) ? 1048576 : 524288;
                        }
                        i29 = i17 & 128;
                        if (i29 != 0) {
                            i56 |= 12582912;
                        } else if ((i3 & 29360128) == 0) {
                            i56 |= startRestartGroup.changed(str3) ? 8388608 : 4194304;
                        }
                        i36 = i17 & 256;
                        if (i36 != 0) {
                            i56 |= 100663296;
                        } else if ((i3 & 234881024) == 0) {
                            i56 |= startRestartGroup.changed(function3) ? 67108864 : 33554432;
                        }
                        if ((i3 & 1879048192) == 0) {
                            if ((i17 & 512) == 0 && startRestartGroup.changed(str4)) {
                                i48 = 536870912;
                                i56 |= i48;
                            }
                            i48 = 268435456;
                            i56 |= i48;
                        }
                        i37 = i17 & 1024;
                        if (i37 != 0) {
                            i38 = i16 | 6;
                        } else if ((i16 & 14) == 0) {
                            i38 = i16 | (startRestartGroup.changed(function23) ? 4 : 2);
                        } else {
                            i38 = i16;
                        }
                        i39 = i17 & 2048;
                        if (i39 != 0) {
                            i38 |= 48;
                        } else if ((i16 & 112) == 0) {
                            i38 |= startRestartGroup.changed(f17) ? 32 : 16;
                        }
                        i46 = i38;
                        if ((i17 & 33) != 33 && (1533916891 & i56) == 306783378 && (i46 & 91) == 18 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            str11 = str;
                            function28 = function2;
                            str12 = str2;
                            f26 = f16;
                            hVar3 = hVar;
                            function29 = function22;
                            str14 = str3;
                            function34 = function3;
                            str13 = str4;
                            function27 = function23;
                            f27 = f17;
                            composer2 = startRestartGroup;
                            iVar3 = iVar;
                        } else {
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if (i27 != 0) {
                                    i56 &= -458753;
                                }
                                if ((i17 & 512) != 0) {
                                    int i58 = i56 & (-1879048193);
                                    iVar2 = iVar;
                                    str5 = str;
                                    function24 = function2;
                                    str6 = str2;
                                    f18 = f16;
                                    hVar2 = hVar;
                                    function25 = function22;
                                    str7 = str3;
                                    str9 = str4;
                                    function26 = function23;
                                    f19 = f17;
                                    i47 = i58;
                                    function33 = function3;
                                } else {
                                    iVar2 = iVar;
                                    str5 = str;
                                    function24 = function2;
                                    str6 = str2;
                                    f18 = f16;
                                    hVar2 = hVar;
                                    function25 = function22;
                                    str7 = str3;
                                    function33 = function3;
                                    function26 = function23;
                                    f19 = f17;
                                    i47 = i56;
                                    str9 = str4;
                                }
                            } else {
                                iVar2 = i49 != 0 ? i.INSTANCE : iVar;
                                str5 = i57 != 0 ? null : str;
                                function24 = i18 != 0 ? null : function2;
                                str6 = i19 != 0 ? "" : str2;
                                f18 = i26 != 0 ? 0.5f : f16;
                                if (i27 != 0) {
                                    hVar2 = QUIToken.color$default("text_primary");
                                    i56 &= -458753;
                                } else {
                                    hVar2 = hVar;
                                }
                                function25 = i28 != 0 ? null : function22;
                                str7 = i29 != 0 ? null : str3;
                                Function3<? super i, ? super Composer, ? super Integer, Unit> function35 = i36 != 0 ? null : function3;
                                if ((i17 & 512) != 0) {
                                    function32 = function35;
                                    str8 = QUIToken.INSTANCE.image("chevron_right", QUIToken.color$default("text_secondary"));
                                    i56 &= -1879048193;
                                } else {
                                    function32 = function35;
                                    str8 = str4;
                                }
                                function26 = i37 != 0 ? null : function23;
                                if (i39 != 0) {
                                    i47 = i56;
                                    f19 = 0.5f;
                                } else {
                                    f19 = f17;
                                    i47 = i56;
                                }
                                str9 = str8;
                                function33 = function32;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                str10 = "";
                                ComposerKt.traceEventStart(1043429814, i47, i46, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonView (QUIListSingleLineCommonView.kt:32)");
                            } else {
                                str10 = "";
                            }
                            i iVar4 = i.INSTANCE;
                            i d16 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.s(iVar4.b(iVar2), 16.0f, 0.0f, 12.0f, 0.0f, 10, null), 56.0f), 0.0f, 1, null), QUIToken.color$default("fill_light_secondary"));
                            if (function26 == null) {
                                if (!(str9.length() == 0)) {
                                    QQCommonNApiModule.Companion companion = QQCommonNApiModule.Companion;
                                    j3 = ((QQCommonNApiModule) c.f117352a.g().acquireModule("QQCommonNApiModule")).isDarkTheme() ? h.INSTANCE.p(0.1f) : h.INSTANCE.a(0.1f);
                                    i w3 = ModifiersKt.w(d16, j3);
                                    booleanRef = new Ref.BooleanRef();
                                    iVar2.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$hasAccessibility$1
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(i.c cVar, Unit unit) {
                                            i.c cVar2 = cVar;
                                            if ((cVar2 instanceof k) && Intrinsics.areEqual(((k) cVar2).getPropKey(), "accessibility")) {
                                                Ref.BooleanRef.this.element = true;
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    if (!booleanRef.element) {
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(str6);
                                        m3.append(str7 == null ? str10 : str7);
                                        iVar4 = ModifiersKt.a(iVar4, m3.toString());
                                    }
                                    final Function2<? super Composer, ? super Integer, Unit> function210 = function24;
                                    final int i59 = i47;
                                    final String str15 = str5;
                                    final Function2<? super Composer, ? super Integer, Unit> function211 = function25;
                                    final float f28 = f18;
                                    final String str16 = str6;
                                    final h hVar4 = hVar2;
                                    final Function3<? super i, ? super Composer, ? super Integer, Unit> function36 = function33;
                                    final float f29 = f19;
                                    final String str17 = str7;
                                    final String str18 = str9;
                                    final Function2<? super Composer, ? super Integer, Unit> function212 = function26;
                                    Function3<? super i, ? super Composer, ? super Integer, Unit> function37 = function33;
                                    composer2 = startRestartGroup;
                                    RowKt.a(w3.b(iVar4), a.f339245a.g(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(composer2, -1116726056, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$QUIListSingleLineCommonView$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        /* JADX WARN: Removed duplicated region for block: B:36:0x026b  */
                                        /* JADX WARN: Removed duplicated region for block: B:39:0x02e8  */
                                        /* JADX WARN: Removed duplicated region for block: B:40:0x0282  */
                                        /* JADX WARN: Removed duplicated region for block: B:58:0x01b6  */
                                        /* JADX WARN: Removed duplicated region for block: B:59:0x022e  */
                                        @Override // kotlin.jvm.functions.Function3
                                        /*
                                            Code decompiled incorrectly, please refer to instructions dump.
                                        */
                                        public final Unit invoke(n nVar, Composer composer3, Integer num) {
                                            int i65;
                                            Composer composer4;
                                            Composer composer5;
                                            int i66;
                                            boolean z16;
                                            int i67;
                                            int i68;
                                            n nVar2 = nVar;
                                            Composer composer6 = composer3;
                                            int intValue = num.intValue();
                                            if ((intValue & 14) == 0) {
                                                i65 = (composer6.changed(nVar2) ? 4 : 2) | intValue;
                                            } else {
                                                i65 = intValue;
                                            }
                                            if ((i65 & 91) == 18 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1116726056, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonView.<anonymous> (QUIListSingleLineCommonView.kt:57)");
                                                }
                                                if (function210 != null) {
                                                    composer6.startReplaceableGroup(888574841);
                                                    function210.invoke(composer6, Integer.valueOf((i59 >> 6) & 14));
                                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 12.0f), composer6, 8, 0);
                                                    composer6.endReplaceableGroup();
                                                } else if (str15 != null) {
                                                    composer6.startReplaceableGroup(888574973);
                                                    String str19 = str15;
                                                    i.Companion companion2 = i.INSTANCE;
                                                    ImageKt.a(str19, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion2, 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, ((i59 >> 3) & 14) | 262144, 0, 0, 2097118);
                                                    composer6 = composer6;
                                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion2, 12.0f), composer6, 8, 0);
                                                    composer6.endReplaceableGroup();
                                                } else {
                                                    composer6.startReplaceableGroup(888575151);
                                                    composer6.endReplaceableGroup();
                                                }
                                                if (function211 != null) {
                                                    composer6.startReplaceableGroup(888575195);
                                                    i a16 = nVar2.a(i.INSTANCE, f28);
                                                    Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                                    final Function2<Composer, Integer, Unit> function213 = function211;
                                                    final int i69 = i59;
                                                    ColumnKt.a(a16, null, horizontal, null, ComposableLambdaKt.composableLambda(composer6, 2134418721, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$QUIListSingleLineCommonView$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(d dVar, Composer composer7, Integer num2) {
                                                            Composer composer8 = composer7;
                                                            int intValue2 = num2.intValue();
                                                            if ((intValue2 & 81) == 16 && composer8.getSkipping()) {
                                                                composer8.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(2134418721, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonView.<anonymous>.<anonymous> (QUIListSingleLineCommonView.kt:69)");
                                                                }
                                                                function213.invoke(composer8, Integer.valueOf((i69 >> 18) & 14));
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer6, 24968, 10);
                                                    composer6.endReplaceableGroup();
                                                    composer4 = composer6;
                                                } else {
                                                    composer6.startReplaceableGroup(888575399);
                                                    composer4 = composer6;
                                                    TextKt.a(str16, nVar2.a(i.INSTANCE, f28), null, hVar4, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer4, ((i59 >> 9) & 14) | 28736, 100663296, 0, 133955556);
                                                    composer4.endReplaceableGroup();
                                                }
                                                if (function36 != null) {
                                                    composer5 = composer4;
                                                    composer5.startReplaceableGroup(888575664);
                                                    function36.invoke(nVar2.a(i.INSTANCE, f29), composer5, Integer.valueOf(((i59 >> 21) & 112) | 8));
                                                    composer5.endReplaceableGroup();
                                                    i67 = 1;
                                                } else {
                                                    composer5 = composer4;
                                                    String str20 = str17;
                                                    if (str20 != null) {
                                                        i66 = 1;
                                                        if (str20.length() > 0) {
                                                            z16 = true;
                                                            if (!z16) {
                                                                composer5.startReplaceableGroup(888575790);
                                                                i67 = i66;
                                                                TextKt.a(str17, ComposeLayoutPropUpdaterKt.s(nVar2.a(i.INSTANCE, f29), 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, ai.f(ai.INSTANCE.d()), null, null, null, null, null, null, null, Integer.valueOf(i66), null, null, null, null, null, null, null, false, composer5, ((i59 >> 21) & 14) | 28736, 100663296, 0, 133954532);
                                                                composer5.endReplaceableGroup();
                                                                composer5 = composer5;
                                                            } else {
                                                                i67 = i66;
                                                                composer5.startReplaceableGroup(888576085);
                                                                composer5.endReplaceableGroup();
                                                            }
                                                        }
                                                    } else {
                                                        i66 = 1;
                                                    }
                                                    z16 = false;
                                                    if (!z16) {
                                                    }
                                                }
                                                composer5.startReplaceableGroup(888576094);
                                                if (function36 == null) {
                                                    if ((str18.length() > 0 ? i67 : 0) == 0) {
                                                        i68 = 0;
                                                        composer5.endReplaceableGroup();
                                                        if (function212 == null) {
                                                            composer5.startReplaceableGroup(888576262);
                                                            function212.invoke(composer5, Integer.valueOf(i46 & 14));
                                                            composer5.endReplaceableGroup();
                                                        } else {
                                                            if ((str18.length() > 0 ? i67 : i68) != 0) {
                                                                composer5.startReplaceableGroup(888576350);
                                                                Composer composer7 = composer5;
                                                                ImageKt.a(str18, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 16.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, ((i59 >> 27) & 14) | 262144, 0, 0, 2097118);
                                                                composer7.endReplaceableGroup();
                                                            } else {
                                                                Composer composer8 = composer5;
                                                                composer8.startReplaceableGroup(888576477);
                                                                composer8.endReplaceableGroup();
                                                            }
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }
                                                i68 = 0;
                                                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 2.0f), composer5, 8, 0);
                                                composer5.endReplaceableGroup();
                                                if (function212 == null) {
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer2, 197064, 24);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function34 = function37;
                                    iVar3 = iVar2;
                                    str11 = str5;
                                    function27 = function26;
                                    str12 = str6;
                                    f26 = f18;
                                    str13 = str9;
                                    f27 = f19;
                                    function28 = function24;
                                    function29 = function25;
                                    str14 = str7;
                                    hVar3 = hVar2;
                                }
                            }
                            j3 = h.INSTANCE.j();
                            i w36 = ModifiersKt.w(d16, j3);
                            booleanRef = new Ref.BooleanRef();
                            iVar2.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$hasAccessibility$1
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Unit invoke(i.c cVar, Unit unit) {
                                    i.c cVar2 = cVar;
                                    if ((cVar2 instanceof k) && Intrinsics.areEqual(((k) cVar2).getPropKey(), "accessibility")) {
                                        Ref.BooleanRef.this.element = true;
                                    }
                                    return Unit.INSTANCE;
                                }
                            });
                            if (!booleanRef.element) {
                            }
                            final Function2<? super Composer, ? super Integer, Unit> function2102 = function24;
                            final int i592 = i47;
                            final String str152 = str5;
                            final Function2<? super Composer, ? super Integer, Unit> function2112 = function25;
                            final float f282 = f18;
                            final String str162 = str6;
                            final h hVar42 = hVar2;
                            final Function3<? super i, ? super Composer, ? super Integer, Unit> function362 = function33;
                            final float f292 = f19;
                            final String str172 = str7;
                            final String str182 = str9;
                            final Function2<? super Composer, ? super Integer, Unit> function2122 = function26;
                            Function3<? super i, ? super Composer, ? super Integer, Unit> function372 = function33;
                            composer2 = startRestartGroup;
                            RowKt.a(w36.b(iVar4), a.f339245a.g(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(composer2, -1116726056, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$QUIListSingleLineCommonView$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                /* JADX WARN: Removed duplicated region for block: B:36:0x026b  */
                                /* JADX WARN: Removed duplicated region for block: B:39:0x02e8  */
                                /* JADX WARN: Removed duplicated region for block: B:40:0x0282  */
                                /* JADX WARN: Removed duplicated region for block: B:58:0x01b6  */
                                /* JADX WARN: Removed duplicated region for block: B:59:0x022e  */
                                @Override // kotlin.jvm.functions.Function3
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Unit invoke(n nVar, Composer composer3, Integer num) {
                                    int i65;
                                    Composer composer4;
                                    Composer composer5;
                                    int i66;
                                    boolean z16;
                                    int i67;
                                    int i68;
                                    n nVar2 = nVar;
                                    Composer composer6 = composer3;
                                    int intValue = num.intValue();
                                    if ((intValue & 14) == 0) {
                                        i65 = (composer6.changed(nVar2) ? 4 : 2) | intValue;
                                    } else {
                                        i65 = intValue;
                                    }
                                    if ((i65 & 91) == 18 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1116726056, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonView.<anonymous> (QUIListSingleLineCommonView.kt:57)");
                                        }
                                        if (function2102 != null) {
                                            composer6.startReplaceableGroup(888574841);
                                            function2102.invoke(composer6, Integer.valueOf((i592 >> 6) & 14));
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 12.0f), composer6, 8, 0);
                                            composer6.endReplaceableGroup();
                                        } else if (str152 != null) {
                                            composer6.startReplaceableGroup(888574973);
                                            String str19 = str152;
                                            i.Companion companion2 = i.INSTANCE;
                                            ImageKt.a(str19, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion2, 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, ((i592 >> 3) & 14) | 262144, 0, 0, 2097118);
                                            composer6 = composer6;
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion2, 12.0f), composer6, 8, 0);
                                            composer6.endReplaceableGroup();
                                        } else {
                                            composer6.startReplaceableGroup(888575151);
                                            composer6.endReplaceableGroup();
                                        }
                                        if (function2112 != null) {
                                            composer6.startReplaceableGroup(888575195);
                                            i a16 = nVar2.a(i.INSTANCE, f282);
                                            Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                            final Function2<? super Composer, ? super Integer, Unit> function213 = function2112;
                                            final int i69 = i592;
                                            ColumnKt.a(a16, null, horizontal, null, ComposableLambdaKt.composableLambda(composer6, 2134418721, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$QUIListSingleLineCommonView$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer7, Integer num2) {
                                                    Composer composer8 = composer7;
                                                    int intValue2 = num2.intValue();
                                                    if ((intValue2 & 81) == 16 && composer8.getSkipping()) {
                                                        composer8.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(2134418721, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonView.<anonymous>.<anonymous> (QUIListSingleLineCommonView.kt:69)");
                                                        }
                                                        function213.invoke(composer8, Integer.valueOf((i69 >> 18) & 14));
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer6, 24968, 10);
                                            composer6.endReplaceableGroup();
                                            composer4 = composer6;
                                        } else {
                                            composer6.startReplaceableGroup(888575399);
                                            composer4 = composer6;
                                            TextKt.a(str162, nVar2.a(i.INSTANCE, f282), null, hVar42, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer4, ((i592 >> 9) & 14) | 28736, 100663296, 0, 133955556);
                                            composer4.endReplaceableGroup();
                                        }
                                        if (function362 != null) {
                                            composer5 = composer4;
                                            composer5.startReplaceableGroup(888575664);
                                            function362.invoke(nVar2.a(i.INSTANCE, f292), composer5, Integer.valueOf(((i592 >> 21) & 112) | 8));
                                            composer5.endReplaceableGroup();
                                            i67 = 1;
                                        } else {
                                            composer5 = composer4;
                                            String str20 = str172;
                                            if (str20 != null) {
                                                i66 = 1;
                                                if (str20.length() > 0) {
                                                    z16 = true;
                                                    if (!z16) {
                                                        composer5.startReplaceableGroup(888575790);
                                                        i67 = i66;
                                                        TextKt.a(str172, ComposeLayoutPropUpdaterKt.s(nVar2.a(i.INSTANCE, f292), 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, ai.f(ai.INSTANCE.d()), null, null, null, null, null, null, null, Integer.valueOf(i66), null, null, null, null, null, null, null, false, composer5, ((i592 >> 21) & 14) | 28736, 100663296, 0, 133954532);
                                                        composer5.endReplaceableGroup();
                                                        composer5 = composer5;
                                                    } else {
                                                        i67 = i66;
                                                        composer5.startReplaceableGroup(888576085);
                                                        composer5.endReplaceableGroup();
                                                    }
                                                }
                                            } else {
                                                i66 = 1;
                                            }
                                            z16 = false;
                                            if (!z16) {
                                            }
                                        }
                                        composer5.startReplaceableGroup(888576094);
                                        if (function362 == null) {
                                            if ((str182.length() > 0 ? i67 : 0) == 0) {
                                                i68 = 0;
                                                composer5.endReplaceableGroup();
                                                if (function2122 == null) {
                                                    composer5.startReplaceableGroup(888576262);
                                                    function2122.invoke(composer5, Integer.valueOf(i46 & 14));
                                                    composer5.endReplaceableGroup();
                                                } else {
                                                    if ((str182.length() > 0 ? i67 : i68) != 0) {
                                                        composer5.startReplaceableGroup(888576350);
                                                        Composer composer7 = composer5;
                                                        ImageKt.a(str182, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 16.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, ((i592 >> 27) & 14) | 262144, 0, 0, 2097118);
                                                        composer7.endReplaceableGroup();
                                                    } else {
                                                        Composer composer8 = composer5;
                                                        composer8.startReplaceableGroup(888576477);
                                                        composer8.endReplaceableGroup();
                                                    }
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }
                                        i68 = 0;
                                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 2.0f), composer5, 8, 0);
                                        composer5.endReplaceableGroup();
                                        if (function2122 == null) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer2, 197064, 24);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function34 = function372;
                            iVar3 = iVar2;
                            str11 = str5;
                            function27 = function26;
                            str12 = str6;
                            f26 = f18;
                            str13 = str9;
                            f27 = f19;
                            function28 = function24;
                            function29 = function25;
                            str14 = str7;
                            hVar3 = hVar2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                            return;
                        }
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$QUIListSingleLineCommonView$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer3, Integer num) {
                                num.intValue();
                                QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(i.this, str11, function28, str12, f26, hVar3, function29, str14, function34, str13, function27, f27, composer3, i3 | 1, i16, i17);
                                return Unit.INSTANCE;
                            }
                        });
                        return;
                    }
                    i27 = i17 & 32;
                    if (i27 != 0) {
                    }
                    i28 = i17 & 64;
                    if (i28 != 0) {
                    }
                    i29 = i17 & 128;
                    if (i29 != 0) {
                    }
                    i36 = i17 & 256;
                    if (i36 != 0) {
                    }
                    if ((i3 & 1879048192) == 0) {
                    }
                    i37 = i17 & 1024;
                    if (i37 != 0) {
                    }
                    i39 = i17 & 2048;
                    if (i39 != 0) {
                    }
                    i46 = i38;
                    if ((i17 & 33) != 33) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) == 0) {
                    }
                    if (i49 != 0) {
                    }
                    if (i57 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if (i27 != 0) {
                    }
                    if (i28 != 0) {
                    }
                    if (i29 != 0) {
                    }
                    if (i36 != 0) {
                    }
                    if ((i17 & 512) != 0) {
                    }
                    if (i37 != 0) {
                    }
                    if (i39 != 0) {
                    }
                    str9 = str8;
                    function33 = function32;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i iVar42 = i.INSTANCE;
                    i d162 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.s(iVar42.b(iVar2), 16.0f, 0.0f, 12.0f, 0.0f, 10, null), 56.0f), 0.0f, 1, null), QUIToken.color$default("fill_light_secondary"));
                    if (function26 == null) {
                    }
                    j3 = h.INSTANCE.j();
                    i w362 = ModifiersKt.w(d162, j3);
                    booleanRef = new Ref.BooleanRef();
                    iVar2.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$hasAccessibility$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(i.c cVar, Unit unit) {
                            i.c cVar2 = cVar;
                            if ((cVar2 instanceof k) && Intrinsics.areEqual(((k) cVar2).getPropKey(), "accessibility")) {
                                Ref.BooleanRef.this.element = true;
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    if (!booleanRef.element) {
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function21022 = function24;
                    final int i5922 = i47;
                    final String str1522 = str5;
                    final Function2<? super Composer, ? super Integer, Unit> function21122 = function25;
                    final float f2822 = f18;
                    final String str1622 = str6;
                    final h hVar422 = hVar2;
                    final Function3<? super i, ? super Composer, ? super Integer, Unit> function3622 = function33;
                    final float f2922 = f19;
                    final String str1722 = str7;
                    final String str1822 = str9;
                    final Function2<? super Composer, ? super Integer, Unit> function21222 = function26;
                    Function3<? super i, ? super Composer, ? super Integer, Unit> function3722 = function33;
                    composer2 = startRestartGroup;
                    RowKt.a(w362.b(iVar42), a.f339245a.g(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(composer2, -1116726056, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$QUIListSingleLineCommonView$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:36:0x026b  */
                        /* JADX WARN: Removed duplicated region for block: B:39:0x02e8  */
                        /* JADX WARN: Removed duplicated region for block: B:40:0x0282  */
                        /* JADX WARN: Removed duplicated region for block: B:58:0x01b6  */
                        /* JADX WARN: Removed duplicated region for block: B:59:0x022e  */
                        @Override // kotlin.jvm.functions.Function3
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(n nVar, Composer composer3, Integer num) {
                            int i65;
                            Composer composer4;
                            Composer composer5;
                            int i66;
                            boolean z16;
                            int i67;
                            int i68;
                            n nVar2 = nVar;
                            Composer composer6 = composer3;
                            int intValue = num.intValue();
                            if ((intValue & 14) == 0) {
                                i65 = (composer6.changed(nVar2) ? 4 : 2) | intValue;
                            } else {
                                i65 = intValue;
                            }
                            if ((i65 & 91) == 18 && composer6.getSkipping()) {
                                composer6.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1116726056, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonView.<anonymous> (QUIListSingleLineCommonView.kt:57)");
                                }
                                if (function21022 != null) {
                                    composer6.startReplaceableGroup(888574841);
                                    function21022.invoke(composer6, Integer.valueOf((i5922 >> 6) & 14));
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 12.0f), composer6, 8, 0);
                                    composer6.endReplaceableGroup();
                                } else if (str1522 != null) {
                                    composer6.startReplaceableGroup(888574973);
                                    String str19 = str1522;
                                    i.Companion companion2 = i.INSTANCE;
                                    ImageKt.a(str19, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion2, 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, ((i5922 >> 3) & 14) | 262144, 0, 0, 2097118);
                                    composer6 = composer6;
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion2, 12.0f), composer6, 8, 0);
                                    composer6.endReplaceableGroup();
                                } else {
                                    composer6.startReplaceableGroup(888575151);
                                    composer6.endReplaceableGroup();
                                }
                                if (function21122 != null) {
                                    composer6.startReplaceableGroup(888575195);
                                    i a16 = nVar2.a(i.INSTANCE, f2822);
                                    Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                    final Function2<? super Composer, ? super Integer, Unit> function213 = function21122;
                                    final int i69 = i5922;
                                    ColumnKt.a(a16, null, horizontal, null, ComposableLambdaKt.composableLambda(composer6, 2134418721, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$QUIListSingleLineCommonView$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(d dVar, Composer composer7, Integer num2) {
                                            Composer composer8 = composer7;
                                            int intValue2 = num2.intValue();
                                            if ((intValue2 & 81) == 16 && composer8.getSkipping()) {
                                                composer8.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2134418721, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonView.<anonymous>.<anonymous> (QUIListSingleLineCommonView.kt:69)");
                                                }
                                                function213.invoke(composer8, Integer.valueOf((i69 >> 18) & 14));
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer6, 24968, 10);
                                    composer6.endReplaceableGroup();
                                    composer4 = composer6;
                                } else {
                                    composer6.startReplaceableGroup(888575399);
                                    composer4 = composer6;
                                    TextKt.a(str1622, nVar2.a(i.INSTANCE, f2822), null, hVar422, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer4, ((i5922 >> 9) & 14) | 28736, 100663296, 0, 133955556);
                                    composer4.endReplaceableGroup();
                                }
                                if (function3622 != null) {
                                    composer5 = composer4;
                                    composer5.startReplaceableGroup(888575664);
                                    function3622.invoke(nVar2.a(i.INSTANCE, f2922), composer5, Integer.valueOf(((i5922 >> 21) & 112) | 8));
                                    composer5.endReplaceableGroup();
                                    i67 = 1;
                                } else {
                                    composer5 = composer4;
                                    String str20 = str1722;
                                    if (str20 != null) {
                                        i66 = 1;
                                        if (str20.length() > 0) {
                                            z16 = true;
                                            if (!z16) {
                                                composer5.startReplaceableGroup(888575790);
                                                i67 = i66;
                                                TextKt.a(str1722, ComposeLayoutPropUpdaterKt.s(nVar2.a(i.INSTANCE, f2922), 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, ai.f(ai.INSTANCE.d()), null, null, null, null, null, null, null, Integer.valueOf(i66), null, null, null, null, null, null, null, false, composer5, ((i5922 >> 21) & 14) | 28736, 100663296, 0, 133954532);
                                                composer5.endReplaceableGroup();
                                                composer5 = composer5;
                                            } else {
                                                i67 = i66;
                                                composer5.startReplaceableGroup(888576085);
                                                composer5.endReplaceableGroup();
                                            }
                                        }
                                    } else {
                                        i66 = 1;
                                    }
                                    z16 = false;
                                    if (!z16) {
                                    }
                                }
                                composer5.startReplaceableGroup(888576094);
                                if (function3622 == null) {
                                    if ((str1822.length() > 0 ? i67 : 0) == 0) {
                                        i68 = 0;
                                        composer5.endReplaceableGroup();
                                        if (function21222 == null) {
                                            composer5.startReplaceableGroup(888576262);
                                            function21222.invoke(composer5, Integer.valueOf(i46 & 14));
                                            composer5.endReplaceableGroup();
                                        } else {
                                            if ((str1822.length() > 0 ? i67 : i68) != 0) {
                                                composer5.startReplaceableGroup(888576350);
                                                Composer composer7 = composer5;
                                                ImageKt.a(str1822, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 16.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, ((i5922 >> 27) & 14) | 262144, 0, 0, 2097118);
                                                composer7.endReplaceableGroup();
                                            } else {
                                                Composer composer8 = composer5;
                                                composer8.startReplaceableGroup(888576477);
                                                composer8.endReplaceableGroup();
                                            }
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }
                                i68 = 0;
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 2.0f), composer5, 8, 0);
                                composer5.endReplaceableGroup();
                                if (function21222 == null) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer2, 197064, 24);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function34 = function3722;
                    iVar3 = iVar2;
                    str11 = str5;
                    function27 = function26;
                    str12 = str6;
                    f26 = f18;
                    str13 = str9;
                    f27 = f19;
                    function28 = function24;
                    function29 = function25;
                    str14 = str7;
                    hVar3 = hVar2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i26 = i17 & 16;
                if (i26 == 0) {
                }
                i27 = i17 & 32;
                if (i27 != 0) {
                }
                i28 = i17 & 64;
                if (i28 != 0) {
                }
                i29 = i17 & 128;
                if (i29 != 0) {
                }
                i36 = i17 & 256;
                if (i36 != 0) {
                }
                if ((i3 & 1879048192) == 0) {
                }
                i37 = i17 & 1024;
                if (i37 != 0) {
                }
                i39 = i17 & 2048;
                if (i39 != 0) {
                }
                i46 = i38;
                if ((i17 & 33) != 33) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) == 0) {
                }
                if (i49 != 0) {
                }
                if (i57 != 0) {
                }
                if (i18 != 0) {
                }
                if (i19 != 0) {
                }
                if (i26 != 0) {
                }
                if (i27 != 0) {
                }
                if (i28 != 0) {
                }
                if (i29 != 0) {
                }
                if (i36 != 0) {
                }
                if ((i17 & 512) != 0) {
                }
                if (i37 != 0) {
                }
                if (i39 != 0) {
                }
                str9 = str8;
                function33 = function32;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                i iVar422 = i.INSTANCE;
                i d1622 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.s(iVar422.b(iVar2), 16.0f, 0.0f, 12.0f, 0.0f, 10, null), 56.0f), 0.0f, 1, null), QUIToken.color$default("fill_light_secondary"));
                if (function26 == null) {
                }
                j3 = h.INSTANCE.j();
                i w3622 = ModifiersKt.w(d1622, j3);
                booleanRef = new Ref.BooleanRef();
                iVar2.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$hasAccessibility$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(i.c cVar, Unit unit) {
                        i.c cVar2 = cVar;
                        if ((cVar2 instanceof k) && Intrinsics.areEqual(((k) cVar2).getPropKey(), "accessibility")) {
                            Ref.BooleanRef.this.element = true;
                        }
                        return Unit.INSTANCE;
                    }
                });
                if (!booleanRef.element) {
                }
                final Function2<? super Composer, ? super Integer, Unit> function210222 = function24;
                final int i59222 = i47;
                final String str15222 = str5;
                final Function2<? super Composer, ? super Integer, Unit> function211222 = function25;
                final float f28222 = f18;
                final String str16222 = str6;
                final h hVar4222 = hVar2;
                final Function3<? super i, ? super Composer, ? super Integer, Unit> function36222 = function33;
                final float f29222 = f19;
                final String str17222 = str7;
                final String str18222 = str9;
                final Function2<? super Composer, ? super Integer, Unit> function212222 = function26;
                Function3<? super i, ? super Composer, ? super Integer, Unit> function37222 = function33;
                composer2 = startRestartGroup;
                RowKt.a(w3622.b(iVar422), a.f339245a.g(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(composer2, -1116726056, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$QUIListSingleLineCommonView$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:36:0x026b  */
                    /* JADX WARN: Removed duplicated region for block: B:39:0x02e8  */
                    /* JADX WARN: Removed duplicated region for block: B:40:0x0282  */
                    /* JADX WARN: Removed duplicated region for block: B:58:0x01b6  */
                    /* JADX WARN: Removed duplicated region for block: B:59:0x022e  */
                    @Override // kotlin.jvm.functions.Function3
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Unit invoke(n nVar, Composer composer3, Integer num) {
                        int i65;
                        Composer composer4;
                        Composer composer5;
                        int i66;
                        boolean z16;
                        int i67;
                        int i68;
                        n nVar2 = nVar;
                        Composer composer6 = composer3;
                        int intValue = num.intValue();
                        if ((intValue & 14) == 0) {
                            i65 = (composer6.changed(nVar2) ? 4 : 2) | intValue;
                        } else {
                            i65 = intValue;
                        }
                        if ((i65 & 91) == 18 && composer6.getSkipping()) {
                            composer6.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1116726056, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonView.<anonymous> (QUIListSingleLineCommonView.kt:57)");
                            }
                            if (function210222 != null) {
                                composer6.startReplaceableGroup(888574841);
                                function210222.invoke(composer6, Integer.valueOf((i59222 >> 6) & 14));
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 12.0f), composer6, 8, 0);
                                composer6.endReplaceableGroup();
                            } else if (str15222 != null) {
                                composer6.startReplaceableGroup(888574973);
                                String str19 = str15222;
                                i.Companion companion2 = i.INSTANCE;
                                ImageKt.a(str19, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion2, 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, ((i59222 >> 3) & 14) | 262144, 0, 0, 2097118);
                                composer6 = composer6;
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion2, 12.0f), composer6, 8, 0);
                                composer6.endReplaceableGroup();
                            } else {
                                composer6.startReplaceableGroup(888575151);
                                composer6.endReplaceableGroup();
                            }
                            if (function211222 != null) {
                                composer6.startReplaceableGroup(888575195);
                                i a16 = nVar2.a(i.INSTANCE, f28222);
                                Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                final Function2<? super Composer, ? super Integer, Unit> function213 = function211222;
                                final int i69 = i59222;
                                ColumnKt.a(a16, null, horizontal, null, ComposableLambdaKt.composableLambda(composer6, 2134418721, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$QUIListSingleLineCommonView$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar, Composer composer7, Integer num2) {
                                        Composer composer8 = composer7;
                                        int intValue2 = num2.intValue();
                                        if ((intValue2 & 81) == 16 && composer8.getSkipping()) {
                                            composer8.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2134418721, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonView.<anonymous>.<anonymous> (QUIListSingleLineCommonView.kt:69)");
                                            }
                                            function213.invoke(composer8, Integer.valueOf((i69 >> 18) & 14));
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer6, 24968, 10);
                                composer6.endReplaceableGroup();
                                composer4 = composer6;
                            } else {
                                composer6.startReplaceableGroup(888575399);
                                composer4 = composer6;
                                TextKt.a(str16222, nVar2.a(i.INSTANCE, f28222), null, hVar4222, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer4, ((i59222 >> 9) & 14) | 28736, 100663296, 0, 133955556);
                                composer4.endReplaceableGroup();
                            }
                            if (function36222 != null) {
                                composer5 = composer4;
                                composer5.startReplaceableGroup(888575664);
                                function36222.invoke(nVar2.a(i.INSTANCE, f29222), composer5, Integer.valueOf(((i59222 >> 21) & 112) | 8));
                                composer5.endReplaceableGroup();
                                i67 = 1;
                            } else {
                                composer5 = composer4;
                                String str20 = str17222;
                                if (str20 != null) {
                                    i66 = 1;
                                    if (str20.length() > 0) {
                                        z16 = true;
                                        if (!z16) {
                                            composer5.startReplaceableGroup(888575790);
                                            i67 = i66;
                                            TextKt.a(str17222, ComposeLayoutPropUpdaterKt.s(nVar2.a(i.INSTANCE, f29222), 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, ai.f(ai.INSTANCE.d()), null, null, null, null, null, null, null, Integer.valueOf(i66), null, null, null, null, null, null, null, false, composer5, ((i59222 >> 21) & 14) | 28736, 100663296, 0, 133954532);
                                            composer5.endReplaceableGroup();
                                            composer5 = composer5;
                                        } else {
                                            i67 = i66;
                                            composer5.startReplaceableGroup(888576085);
                                            composer5.endReplaceableGroup();
                                        }
                                    }
                                } else {
                                    i66 = 1;
                                }
                                z16 = false;
                                if (!z16) {
                                }
                            }
                            composer5.startReplaceableGroup(888576094);
                            if (function36222 == null) {
                                if ((str18222.length() > 0 ? i67 : 0) == 0) {
                                    i68 = 0;
                                    composer5.endReplaceableGroup();
                                    if (function212222 == null) {
                                        composer5.startReplaceableGroup(888576262);
                                        function212222.invoke(composer5, Integer.valueOf(i46 & 14));
                                        composer5.endReplaceableGroup();
                                    } else {
                                        if ((str18222.length() > 0 ? i67 : i68) != 0) {
                                            composer5.startReplaceableGroup(888576350);
                                            Composer composer7 = composer5;
                                            ImageKt.a(str18222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 16.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, ((i59222 >> 27) & 14) | 262144, 0, 0, 2097118);
                                            composer7.endReplaceableGroup();
                                        } else {
                                            Composer composer8 = composer5;
                                            composer8.startReplaceableGroup(888576477);
                                            composer8.endReplaceableGroup();
                                        }
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }
                            i68 = 0;
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 2.0f), composer5, 8, 0);
                            composer5.endReplaceableGroup();
                            if (function212222 == null) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer2, 197064, 24);
                if (ComposerKt.isTraceInProgress()) {
                }
                function34 = function37222;
                iVar3 = iVar2;
                str11 = str5;
                function27 = function26;
                str12 = str6;
                f26 = f18;
                str13 = str9;
                f27 = f19;
                function28 = function24;
                function29 = function25;
                str14 = str7;
                hVar3 = hVar2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i19 = i17 & 8;
            if (i19 != 0) {
            }
            i26 = i17 & 16;
            if (i26 == 0) {
            }
            i27 = i17 & 32;
            if (i27 != 0) {
            }
            i28 = i17 & 64;
            if (i28 != 0) {
            }
            i29 = i17 & 128;
            if (i29 != 0) {
            }
            i36 = i17 & 256;
            if (i36 != 0) {
            }
            if ((i3 & 1879048192) == 0) {
            }
            i37 = i17 & 1024;
            if (i37 != 0) {
            }
            i39 = i17 & 2048;
            if (i39 != 0) {
            }
            i46 = i38;
            if ((i17 & 33) != 33) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) == 0) {
            }
            if (i49 != 0) {
            }
            if (i57 != 0) {
            }
            if (i18 != 0) {
            }
            if (i19 != 0) {
            }
            if (i26 != 0) {
            }
            if (i27 != 0) {
            }
            if (i28 != 0) {
            }
            if (i29 != 0) {
            }
            if (i36 != 0) {
            }
            if ((i17 & 512) != 0) {
            }
            if (i37 != 0) {
            }
            if (i39 != 0) {
            }
            str9 = str8;
            function33 = function32;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            i iVar4222 = i.INSTANCE;
            i d16222 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.s(iVar4222.b(iVar2), 16.0f, 0.0f, 12.0f, 0.0f, 10, null), 56.0f), 0.0f, 1, null), QUIToken.color$default("fill_light_secondary"));
            if (function26 == null) {
            }
            j3 = h.INSTANCE.j();
            i w36222 = ModifiersKt.w(d16222, j3);
            booleanRef = new Ref.BooleanRef();
            iVar2.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$hasAccessibility$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(i.c cVar, Unit unit) {
                    i.c cVar2 = cVar;
                    if ((cVar2 instanceof k) && Intrinsics.areEqual(((k) cVar2).getPropKey(), "accessibility")) {
                        Ref.BooleanRef.this.element = true;
                    }
                    return Unit.INSTANCE;
                }
            });
            if (!booleanRef.element) {
            }
            final Function2<? super Composer, ? super Integer, Unit> function2102222 = function24;
            final int i592222 = i47;
            final String str152222 = str5;
            final Function2<? super Composer, ? super Integer, Unit> function2112222 = function25;
            final float f282222 = f18;
            final String str162222 = str6;
            final h hVar42222 = hVar2;
            final Function3<? super i, ? super Composer, ? super Integer, Unit> function362222 = function33;
            final float f292222 = f19;
            final String str172222 = str7;
            final String str182222 = str9;
            final Function2<? super Composer, ? super Integer, Unit> function2122222 = function26;
            Function3<? super i, ? super Composer, ? super Integer, Unit> function372222 = function33;
            composer2 = startRestartGroup;
            RowKt.a(w36222.b(iVar4222), a.f339245a.g(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(composer2, -1116726056, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$QUIListSingleLineCommonView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                /* JADX WARN: Removed duplicated region for block: B:36:0x026b  */
                /* JADX WARN: Removed duplicated region for block: B:39:0x02e8  */
                /* JADX WARN: Removed duplicated region for block: B:40:0x0282  */
                /* JADX WARN: Removed duplicated region for block: B:58:0x01b6  */
                /* JADX WARN: Removed duplicated region for block: B:59:0x022e  */
                @Override // kotlin.jvm.functions.Function3
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Unit invoke(n nVar, Composer composer3, Integer num) {
                    int i65;
                    Composer composer4;
                    Composer composer5;
                    int i66;
                    boolean z16;
                    int i67;
                    int i68;
                    n nVar2 = nVar;
                    Composer composer6 = composer3;
                    int intValue = num.intValue();
                    if ((intValue & 14) == 0) {
                        i65 = (composer6.changed(nVar2) ? 4 : 2) | intValue;
                    } else {
                        i65 = intValue;
                    }
                    if ((i65 & 91) == 18 && composer6.getSkipping()) {
                        composer6.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1116726056, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonView.<anonymous> (QUIListSingleLineCommonView.kt:57)");
                        }
                        if (function2102222 != null) {
                            composer6.startReplaceableGroup(888574841);
                            function2102222.invoke(composer6, Integer.valueOf((i592222 >> 6) & 14));
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 12.0f), composer6, 8, 0);
                            composer6.endReplaceableGroup();
                        } else if (str152222 != null) {
                            composer6.startReplaceableGroup(888574973);
                            String str19 = str152222;
                            i.Companion companion2 = i.INSTANCE;
                            ImageKt.a(str19, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion2, 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, ((i592222 >> 3) & 14) | 262144, 0, 0, 2097118);
                            composer6 = composer6;
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion2, 12.0f), composer6, 8, 0);
                            composer6.endReplaceableGroup();
                        } else {
                            composer6.startReplaceableGroup(888575151);
                            composer6.endReplaceableGroup();
                        }
                        if (function2112222 != null) {
                            composer6.startReplaceableGroup(888575195);
                            i a16 = nVar2.a(i.INSTANCE, f282222);
                            Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                            final Function2<? super Composer, ? super Integer, Unit> function213 = function2112222;
                            final int i69 = i592222;
                            ColumnKt.a(a16, null, horizontal, null, ComposableLambdaKt.composableLambda(composer6, 2134418721, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$QUIListSingleLineCommonView$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(d dVar, Composer composer7, Integer num2) {
                                    Composer composer8 = composer7;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 81) == 16 && composer8.getSkipping()) {
                                        composer8.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2134418721, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonView.<anonymous>.<anonymous> (QUIListSingleLineCommonView.kt:69)");
                                        }
                                        function213.invoke(composer8, Integer.valueOf((i69 >> 18) & 14));
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer6, 24968, 10);
                            composer6.endReplaceableGroup();
                            composer4 = composer6;
                        } else {
                            composer6.startReplaceableGroup(888575399);
                            composer4 = composer6;
                            TextKt.a(str162222, nVar2.a(i.INSTANCE, f282222), null, hVar42222, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer4, ((i592222 >> 9) & 14) | 28736, 100663296, 0, 133955556);
                            composer4.endReplaceableGroup();
                        }
                        if (function362222 != null) {
                            composer5 = composer4;
                            composer5.startReplaceableGroup(888575664);
                            function362222.invoke(nVar2.a(i.INSTANCE, f292222), composer5, Integer.valueOf(((i592222 >> 21) & 112) | 8));
                            composer5.endReplaceableGroup();
                            i67 = 1;
                        } else {
                            composer5 = composer4;
                            String str20 = str172222;
                            if (str20 != null) {
                                i66 = 1;
                                if (str20.length() > 0) {
                                    z16 = true;
                                    if (!z16) {
                                        composer5.startReplaceableGroup(888575790);
                                        i67 = i66;
                                        TextKt.a(str172222, ComposeLayoutPropUpdaterKt.s(nVar2.a(i.INSTANCE, f292222), 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, ai.f(ai.INSTANCE.d()), null, null, null, null, null, null, null, Integer.valueOf(i66), null, null, null, null, null, null, null, false, composer5, ((i592222 >> 21) & 14) | 28736, 100663296, 0, 133954532);
                                        composer5.endReplaceableGroup();
                                        composer5 = composer5;
                                    } else {
                                        i67 = i66;
                                        composer5.startReplaceableGroup(888576085);
                                        composer5.endReplaceableGroup();
                                    }
                                }
                            } else {
                                i66 = 1;
                            }
                            z16 = false;
                            if (!z16) {
                            }
                        }
                        composer5.startReplaceableGroup(888576094);
                        if (function362222 == null) {
                            if ((str182222.length() > 0 ? i67 : 0) == 0) {
                                i68 = 0;
                                composer5.endReplaceableGroup();
                                if (function2122222 == null) {
                                    composer5.startReplaceableGroup(888576262);
                                    function2122222.invoke(composer5, Integer.valueOf(i46 & 14));
                                    composer5.endReplaceableGroup();
                                } else {
                                    if ((str182222.length() > 0 ? i67 : i68) != 0) {
                                        composer5.startReplaceableGroup(888576350);
                                        Composer composer7 = composer5;
                                        ImageKt.a(str182222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 16.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, ((i592222 >> 27) & 14) | 262144, 0, 0, 2097118);
                                        composer7.endReplaceableGroup();
                                    } else {
                                        Composer composer8 = composer5;
                                        composer8.startReplaceableGroup(888576477);
                                        composer8.endReplaceableGroup();
                                    }
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }
                        i68 = 0;
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 2.0f), composer5, 8, 0);
                        composer5.endReplaceableGroup();
                        if (function2122222 == null) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), composer2, 197064, 24);
            if (ComposerKt.isTraceInProgress()) {
            }
            function34 = function372222;
            iVar3 = iVar2;
            str11 = str5;
            function27 = function26;
            str12 = str6;
            f26 = f18;
            str13 = str9;
            f27 = f19;
            function28 = function24;
            function29 = function25;
            str14 = str7;
            hVar3 = hVar2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i18 = i17 & 4;
        if (i18 == 0) {
        }
        i19 = i17 & 8;
        if (i19 != 0) {
        }
        i26 = i17 & 16;
        if (i26 == 0) {
        }
        i27 = i17 & 32;
        if (i27 != 0) {
        }
        i28 = i17 & 64;
        if (i28 != 0) {
        }
        i29 = i17 & 128;
        if (i29 != 0) {
        }
        i36 = i17 & 256;
        if (i36 != 0) {
        }
        if ((i3 & 1879048192) == 0) {
        }
        i37 = i17 & 1024;
        if (i37 != 0) {
        }
        i39 = i17 & 2048;
        if (i39 != 0) {
        }
        i46 = i38;
        if ((i17 & 33) != 33) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) == 0) {
        }
        if (i49 != 0) {
        }
        if (i57 != 0) {
        }
        if (i18 != 0) {
        }
        if (i19 != 0) {
        }
        if (i26 != 0) {
        }
        if (i27 != 0) {
        }
        if (i28 != 0) {
        }
        if (i29 != 0) {
        }
        if (i36 != 0) {
        }
        if ((i17 & 512) != 0) {
        }
        if (i37 != 0) {
        }
        if (i39 != 0) {
        }
        str9 = str8;
        function33 = function32;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        i iVar42222 = i.INSTANCE;
        i d162222 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.s(iVar42222.b(iVar2), 16.0f, 0.0f, 12.0f, 0.0f, 10, null), 56.0f), 0.0f, 1, null), QUIToken.color$default("fill_light_secondary"));
        if (function26 == null) {
        }
        j3 = h.INSTANCE.j();
        i w362222 = ModifiersKt.w(d162222, j3);
        booleanRef = new Ref.BooleanRef();
        iVar2.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$hasAccessibility$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(i.c cVar, Unit unit) {
                i.c cVar2 = cVar;
                if ((cVar2 instanceof k) && Intrinsics.areEqual(((k) cVar2).getPropKey(), "accessibility")) {
                    Ref.BooleanRef.this.element = true;
                }
                return Unit.INSTANCE;
            }
        });
        if (!booleanRef.element) {
        }
        final Function2<? super Composer, ? super Integer, Unit> function21022222 = function24;
        final int i5922222 = i47;
        final String str1522222 = str5;
        final Function2<? super Composer, ? super Integer, Unit> function21122222 = function25;
        final float f2822222 = f18;
        final String str1622222 = str6;
        final h hVar422222 = hVar2;
        final Function3<? super i, ? super Composer, ? super Integer, Unit> function3622222 = function33;
        final float f2922222 = f19;
        final String str1722222 = str7;
        final String str1822222 = str9;
        final Function2<? super Composer, ? super Integer, Unit> function21222222 = function26;
        Function3<? super i, ? super Composer, ? super Integer, Unit> function3722222 = function33;
        composer2 = startRestartGroup;
        RowKt.a(w362222.b(iVar42222), a.f339245a.g(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(composer2, -1116726056, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$QUIListSingleLineCommonView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            /* JADX WARN: Removed duplicated region for block: B:36:0x026b  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x02e8  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x0282  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x01b6  */
            /* JADX WARN: Removed duplicated region for block: B:59:0x022e  */
            @Override // kotlin.jvm.functions.Function3
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(n nVar, Composer composer3, Integer num) {
                int i65;
                Composer composer4;
                Composer composer5;
                int i66;
                boolean z16;
                int i67;
                int i68;
                n nVar2 = nVar;
                Composer composer6 = composer3;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i65 = (composer6.changed(nVar2) ? 4 : 2) | intValue;
                } else {
                    i65 = intValue;
                }
                if ((i65 & 91) == 18 && composer6.getSkipping()) {
                    composer6.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1116726056, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonView.<anonymous> (QUIListSingleLineCommonView.kt:57)");
                    }
                    if (function21022222 != null) {
                        composer6.startReplaceableGroup(888574841);
                        function21022222.invoke(composer6, Integer.valueOf((i5922222 >> 6) & 14));
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 12.0f), composer6, 8, 0);
                        composer6.endReplaceableGroup();
                    } else if (str1522222 != null) {
                        composer6.startReplaceableGroup(888574973);
                        String str19 = str1522222;
                        i.Companion companion2 = i.INSTANCE;
                        ImageKt.a(str19, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion2, 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, ((i5922222 >> 3) & 14) | 262144, 0, 0, 2097118);
                        composer6 = composer6;
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion2, 12.0f), composer6, 8, 0);
                        composer6.endReplaceableGroup();
                    } else {
                        composer6.startReplaceableGroup(888575151);
                        composer6.endReplaceableGroup();
                    }
                    if (function21122222 != null) {
                        composer6.startReplaceableGroup(888575195);
                        i a16 = nVar2.a(i.INSTANCE, f2822222);
                        Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                        final Function2<? super Composer, ? super Integer, Unit> function213 = function21122222;
                        final int i69 = i5922222;
                        ColumnKt.a(a16, null, horizontal, null, ComposableLambdaKt.composableLambda(composer6, 2134418721, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt$QUIListSingleLineCommonView$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(d dVar, Composer composer7, Integer num2) {
                                Composer composer8 = composer7;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer8.getSkipping()) {
                                    composer8.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2134418721, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonView.<anonymous>.<anonymous> (QUIListSingleLineCommonView.kt:69)");
                                    }
                                    function213.invoke(composer8, Integer.valueOf((i69 >> 18) & 14));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer6, 24968, 10);
                        composer6.endReplaceableGroup();
                        composer4 = composer6;
                    } else {
                        composer6.startReplaceableGroup(888575399);
                        composer4 = composer6;
                        TextKt.a(str1622222, nVar2.a(i.INSTANCE, f2822222), null, hVar422222, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer4, ((i5922222 >> 9) & 14) | 28736, 100663296, 0, 133955556);
                        composer4.endReplaceableGroup();
                    }
                    if (function3622222 != null) {
                        composer5 = composer4;
                        composer5.startReplaceableGroup(888575664);
                        function3622222.invoke(nVar2.a(i.INSTANCE, f2922222), composer5, Integer.valueOf(((i5922222 >> 21) & 112) | 8));
                        composer5.endReplaceableGroup();
                        i67 = 1;
                    } else {
                        composer5 = composer4;
                        String str20 = str1722222;
                        if (str20 != null) {
                            i66 = 1;
                            if (str20.length() > 0) {
                                z16 = true;
                                if (!z16) {
                                    composer5.startReplaceableGroup(888575790);
                                    i67 = i66;
                                    TextKt.a(str1722222, ComposeLayoutPropUpdaterKt.s(nVar2.a(i.INSTANCE, f2922222), 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, ai.f(ai.INSTANCE.d()), null, null, null, null, null, null, null, Integer.valueOf(i66), null, null, null, null, null, null, null, false, composer5, ((i5922222 >> 21) & 14) | 28736, 100663296, 0, 133954532);
                                    composer5.endReplaceableGroup();
                                    composer5 = composer5;
                                } else {
                                    i67 = i66;
                                    composer5.startReplaceableGroup(888576085);
                                    composer5.endReplaceableGroup();
                                }
                            }
                        } else {
                            i66 = 1;
                        }
                        z16 = false;
                        if (!z16) {
                        }
                    }
                    composer5.startReplaceableGroup(888576094);
                    if (function3622222 == null) {
                        if ((str1822222.length() > 0 ? i67 : 0) == 0) {
                            i68 = 0;
                            composer5.endReplaceableGroup();
                            if (function21222222 == null) {
                                composer5.startReplaceableGroup(888576262);
                                function21222222.invoke(composer5, Integer.valueOf(i46 & 14));
                                composer5.endReplaceableGroup();
                            } else {
                                if ((str1822222.length() > 0 ? i67 : i68) != 0) {
                                    composer5.startReplaceableGroup(888576350);
                                    Composer composer7 = composer5;
                                    ImageKt.a(str1822222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 16.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, ((i5922222 >> 27) & 14) | 262144, 0, 0, 2097118);
                                    composer7.endReplaceableGroup();
                                } else {
                                    Composer composer8 = composer5;
                                    composer8.startReplaceableGroup(888576477);
                                    composer8.endReplaceableGroup();
                                }
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }
                    i68 = 0;
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 2.0f), composer5, 8, 0);
                    composer5.endReplaceableGroup();
                    if (function21222222 == null) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
                return Unit.INSTANCE;
            }
        }), composer2, 197064, 24);
        if (ComposerKt.isTraceInProgress()) {
        }
        function34 = function3722222;
        iVar3 = iVar2;
        str11 = str5;
        function27 = function26;
        str12 = str6;
        f26 = f18;
        str13 = str9;
        f27 = f19;
        function28 = function24;
        function29 = function25;
        str14 = str7;
        hVar3 = hVar2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
