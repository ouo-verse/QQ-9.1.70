package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.ktx.LocalConfigurationExtKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingIconType;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.y;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUINavBarKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QUINavBar(h hVar, String str, Function2<? super Composer, ? super Integer, Unit> function2, String str2, String str3, Function2<? super Composer, ? super Integer, Unit> function22, Function0<Unit> function0, Function0<Unit> function02, boolean z16, float f16, Composer composer, final int i3, final int i16) {
        int i17;
        int i18;
        int i19;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i26;
        int i27;
        int i28;
        int i29;
        h hVar2;
        h hVar3;
        final String str4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        String str5;
        String str6;
        Function0<Unit> function03;
        final float f17;
        boolean z17;
        Function0<Unit> function04;
        h hVar4;
        Composer composer2;
        final h hVar5;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final String str7;
        final Function0<Unit> function05;
        final String str8;
        final Function0<Unit> function06;
        final boolean z18;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        ScopeUpdateScope endRestartGroup;
        int i36;
        int i37;
        Composer startRestartGroup = composer.startRestartGroup(-1223344403);
        int i38 = i16 & 1;
        int i39 = i38 != 0 ? i3 | 2 : i3;
        if ((i3 & 112) == 0) {
            if ((i16 & 2) == 0 && startRestartGroup.changed(str)) {
                i37 = 32;
                i39 |= i37;
            }
            i37 = 16;
            i39 |= i37;
        }
        int i46 = i16 & 4;
        if (i46 != 0) {
            i39 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i3 & 896) == 0) {
            i39 |= startRestartGroup.changed(function2) ? 256 : 128;
            i17 = i16 & 8;
            if (i17 == 0) {
                i39 |= 3072;
            } else if ((i3 & 7168) == 0) {
                i39 |= startRestartGroup.changed(str2) ? 2048 : 1024;
                i18 = i16 & 16;
                if (i18 != 0) {
                    i39 |= 24576;
                } else if ((57344 & i3) == 0) {
                    i39 |= startRestartGroup.changed(str3) ? 16384 : 8192;
                    i19 = i16 & 32;
                    if (i19 == 0) {
                        i39 |= 196608;
                    } else if ((458752 & i3) == 0) {
                        function23 = function22;
                        i39 |= startRestartGroup.changed(function23) ? 131072 : 65536;
                        i26 = i16 & 64;
                        if (i26 != 0) {
                            i39 |= 1572864;
                        } else if ((i3 & 3670016) == 0) {
                            i39 |= startRestartGroup.changed(function0) ? 1048576 : 524288;
                        }
                        i27 = i16 & 128;
                        if (i27 != 0) {
                            i39 |= 12582912;
                        } else if ((i3 & 29360128) == 0) {
                            i39 |= startRestartGroup.changed(function02) ? 8388608 : 4194304;
                        }
                        i28 = i16 & 256;
                        if (i28 != 0) {
                            i39 |= 100663296;
                        } else if ((i3 & 234881024) == 0) {
                            i39 |= startRestartGroup.changed(z16) ? 67108864 : 33554432;
                        }
                        i29 = i16 & 512;
                        if (i29 == 0) {
                            i36 = (i3 & 1879048192) == 0 ? startRestartGroup.changed(f16) ? 536870912 : 268435456 : 805306368;
                            if (i38 != 1 && (i39 & 1533916891) == 306783378 && startRestartGroup.getSkipping()) {
                                startRestartGroup.skipToGroupEnd();
                                str4 = str;
                                function25 = function2;
                                str8 = str2;
                                str7 = str3;
                                function06 = function0;
                                function05 = function02;
                                z18 = z16;
                                f17 = f16;
                                composer2 = startRestartGroup;
                                function26 = function23;
                                hVar5 = hVar;
                            } else {
                                startRestartGroup.startDefaults();
                                if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i38 == 0) {
                                        hVar2 = QUIToken.color$default("bg_nav_secondary");
                                        i39 &= -15;
                                    } else {
                                        hVar2 = hVar;
                                    }
                                    if ((i16 & 2) == 0) {
                                        hVar3 = hVar2;
                                        str4 = QUIToken.INSTANCE.image("chevron_left", QUIToken.color$default("icon_nav_secondary"));
                                        i39 &= -113;
                                    } else {
                                        hVar3 = hVar2;
                                        str4 = str;
                                    }
                                    function24 = i46 == 0 ? null : function2;
                                    str5 = i17 == 0 ? "" : str2;
                                    str6 = i18 == 0 ? null : str3;
                                    if (i19 != 0) {
                                        function23 = null;
                                    }
                                    function03 = i26 == 0 ? null : function0;
                                    Function0<Unit> function07 = i27 == 0 ? null : function02;
                                    boolean z19 = i28 == 0 ? false : z16;
                                    f17 = i29 == 0 ? 10.0f : f16;
                                    z17 = z19;
                                    function04 = function07;
                                    hVar4 = hVar3;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if (i38 != 0) {
                                        i39 &= -15;
                                    }
                                    if ((i16 & 2) != 0) {
                                        i39 &= -113;
                                    }
                                    hVar4 = hVar;
                                    str4 = str;
                                    function24 = function2;
                                    str5 = str2;
                                    str6 = str3;
                                    function03 = function0;
                                    function04 = function02;
                                    z17 = z16;
                                    f17 = f16;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1223344403, i39, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar (QUINavBar.kt:40)");
                                }
                                a aVar = (a) startRestartGroup.consume(CompositionLocalsKt.d());
                                final Function2<? super Composer, ? super Integer, Unit> function27 = function24;
                                final String str9 = str4;
                                final Function0<Unit> function08 = function03;
                                final int i47 = i39;
                                final String str10 = str5;
                                final Function2<? super Composer, ? super Integer, Unit> function28 = function23;
                                final String str11 = str6;
                                final Function0<Unit> function09 = function04;
                                final boolean z26 = z17;
                                composer2 = startRestartGroup;
                                BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), hVar4), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar)), 0.0f, aVar.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(composer2, 2074908531, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar, Composer composer3, Integer num) {
                                        Composer composer4 = composer3;
                                        int intValue = num.intValue();
                                        if ((intValue & 81) == 16 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2074908531, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous> (QUINavBar.kt:60)");
                                            }
                                            i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                            final Function2<Composer, Integer, Unit> function29 = function27;
                                            final String str12 = str9;
                                            final Function0<Unit> function010 = function08;
                                            final int i48 = i47;
                                            final String str13 = str10;
                                            final Function2<Composer, Integer, Unit> function210 = function28;
                                            final String str14 = str11;
                                            final Function0<Unit> function011 = function09;
                                            final boolean z27 = z26;
                                            BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer4, 1259992441, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(b bVar2, Composer composer5, Integer num2) {
                                                    int i49;
                                                    b bVar3 = bVar2;
                                                    Composer composer6 = composer5;
                                                    int intValue2 = num2.intValue();
                                                    if ((intValue2 & 14) == 0) {
                                                        i49 = (composer6.changed(bVar3) ? 4 : 2) | intValue2;
                                                    } else {
                                                        i49 = intValue2;
                                                    }
                                                    if ((i49 & 91) == 18 && composer6.getSkipping()) {
                                                        composer6.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1259992441, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous> (QUINavBar.kt:61)");
                                                        }
                                                        composer6.startReplaceableGroup(914899004);
                                                        if (function29 != null || str12 != null) {
                                                            a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                            i a16 = ModifiersKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null), 10.0f, 0.0f, 16.0f, 0.0f, 10, null), Alignment.CenterStart), "\u8fd4\u56de");
                                                            final Function0<Unit> function012 = function010;
                                                            composer6.startReplaceableGroup(1157296644);
                                                            boolean changed = composer6.changed(function012);
                                                            Object rememberedValue = composer6.rememberedValue();
                                                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1$1$1$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        Function0<Unit> function013 = function012;
                                                                        if (function013 != null) {
                                                                            function013.invoke();
                                                                        } else {
                                                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                composer6.updateRememberedValue(rememberedValue);
                                                            }
                                                            composer6.endReplaceableGroup();
                                                            i d16 = ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue, 3, null);
                                                            final Function2<Composer, Integer, Unit> function211 = function29;
                                                            final int i56 = i48;
                                                            final String str15 = str12;
                                                            ColumnKt.a(d16, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -42221621, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(d dVar, Composer composer7, Integer num3) {
                                                                    Composer composer8 = composer7;
                                                                    int intValue3 = num3.intValue();
                                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                        composer8.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-42221621, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:76)");
                                                                        }
                                                                        if (function211 != null) {
                                                                            composer8.startReplaceableGroup(264212814);
                                                                            function211.invoke(composer8, Integer.valueOf((i56 >> 6) & 14));
                                                                            composer8.endReplaceableGroup();
                                                                        } else {
                                                                            composer8.startReplaceableGroup(264212887);
                                                                            ImageKt.a(str15, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i56 >> 3) & 14) | 262144, 0, 0, 2097118);
                                                                            composer8.endReplaceableGroup();
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer6, 24648, 12);
                                                        }
                                                        composer6.endReplaceableGroup();
                                                        i.Companion companion = i.INSTANCE;
                                                        i a17 = ModifiersKt.a(bVar3.a(companion, Alignment.Center), str13);
                                                        final String str16 = str13;
                                                        final int i57 = i48;
                                                        final boolean z28 = z27;
                                                        BoxKt.a(a17, null, null, ComposableLambdaKt.composableLambda(composer6, -1095780097, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(b bVar4, Composer composer7, Integer num3) {
                                                                int i58;
                                                                LoadingIconType loadingIconType;
                                                                b bVar5 = bVar4;
                                                                Composer composer8 = composer7;
                                                                int intValue3 = num3.intValue();
                                                                if ((intValue3 & 14) == 0) {
                                                                    i58 = (composer8.changed(bVar5) ? 4 : 2) | intValue3;
                                                                } else {
                                                                    i58 = intValue3;
                                                                }
                                                                if ((i58 & 91) == 18 && composer8.getSkipping()) {
                                                                    composer8.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1095780097, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:90)");
                                                                    }
                                                                    QUIToken qUIToken = QUIToken.INSTANCE;
                                                                    TextKt.a(str16, null, null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer8, ((i57 >> 9) & 14) | 1601536, 100663296, 0, 133955494);
                                                                    if (z28) {
                                                                        i v3 = ComposeLayoutPropUpdaterKt.v(ModifiersKt.Q(bVar5.a(i.INSTANCE, Alignment.CenterEnd), new y(1.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), 17.0f, 17.0f);
                                                                        if (qUIToken.isNightMode()) {
                                                                            loadingIconType = LoadingIconType.WHITE;
                                                                        } else {
                                                                            loadingIconType = LoadingIconType.GRAY;
                                                                        }
                                                                        LoadingKt.Loading(v3, loadingIconType, composer8, 8, 0);
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer6, 3080, 6);
                                                        if (function210 != null || str14 != null) {
                                                            a.e b17 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                            Alignment.Horizontal d17 = Alignment.INSTANCE.d();
                                                            i s16 = ComposeLayoutPropUpdaterKt.s(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterEnd), 16.0f, 0.0f, 10.0f, 0.0f, 10, null);
                                                            final Function0<Unit> function013 = function011;
                                                            composer6.startReplaceableGroup(1157296644);
                                                            boolean changed2 = composer6.changed(function013);
                                                            Object rememberedValue2 = composer6.rememberedValue();
                                                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1$1$4$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        Function0<Unit> function014 = function013;
                                                                        if (function014 != null) {
                                                                            function014.invoke();
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                composer6.updateRememberedValue(rememberedValue2);
                                                            }
                                                            composer6.endReplaceableGroup();
                                                            i d18 = ViewEventPropUpdaterKt.d(s16, false, null, (Function1) rememberedValue2, 3, null);
                                                            final Function2<Composer, Integer, Unit> function212 = function210;
                                                            final int i58 = i48;
                                                            final String str17 = str14;
                                                            ColumnKt.a(d18, b17, d17, null, ComposableLambdaKt.composableLambda(composer6, -1459877310, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.5
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(d dVar, Composer composer7, Integer num3) {
                                                                    Composer composer8 = composer7;
                                                                    int intValue3 = num3.intValue();
                                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                        composer8.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-1459877310, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:111)");
                                                                        }
                                                                        if (function212 != null) {
                                                                            composer8.startReplaceableGroup(264214345);
                                                                            function212.invoke(composer8, Integer.valueOf((i58 >> 15) & 14));
                                                                            composer8.endReplaceableGroup();
                                                                        } else {
                                                                            composer8.startReplaceableGroup(264214422);
                                                                            ImageKt.a(str17, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i58 >> 12) & 14) | 262144, 0, 0, 2097118);
                                                                            composer8.endReplaceableGroup();
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer6, 24648, 8);
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer4, 3080, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer2, 3080, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                hVar5 = hVar4;
                                function25 = function24;
                                str7 = str6;
                                function05 = function04;
                                str8 = str5;
                                function06 = function03;
                                z18 = z17;
                                function26 = function23;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                                return;
                            }
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Unit invoke(Composer composer3, Integer num) {
                                    num.intValue();
                                    QUINavBarKt.QUINavBar(h.this, str4, function25, str8, str7, function26, function06, function05, z18, f17, composer3, i3 | 1, i16);
                                    return Unit.INSTANCE;
                                }
                            });
                            return;
                        }
                        i39 |= i36;
                        if (i38 != 1) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i38 == 0) {
                        }
                        if ((i16 & 2) == 0) {
                        }
                        if (i46 == 0) {
                        }
                        if (i17 == 0) {
                        }
                        if (i18 == 0) {
                        }
                        if (i19 != 0) {
                        }
                        if (i26 == 0) {
                        }
                        if (i27 == 0) {
                        }
                        if (i28 == 0) {
                        }
                        if (i29 == 0) {
                        }
                        z17 = z19;
                        function04 = function07;
                        hVar4 = hVar3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        com.tencent.ntcompose.ui.platform.a aVar2 = (com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d());
                        final Function2<? super Composer, ? super Integer, Unit> function272 = function24;
                        final String str92 = str4;
                        final Function0<Unit> function082 = function03;
                        final int i472 = i39;
                        final String str102 = str5;
                        final Function2<? super Composer, ? super Integer, Unit> function282 = function23;
                        final String str112 = str6;
                        final Function0<Unit> function092 = function04;
                        final boolean z262 = z17;
                        composer2 = startRestartGroup;
                        BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), hVar4), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar2)), 0.0f, aVar2.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(composer2, 2074908531, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(b bVar, Composer composer3, Integer num) {
                                Composer composer4 = composer3;
                                int intValue = num.intValue();
                                if ((intValue & 81) == 16 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2074908531, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous> (QUINavBar.kt:60)");
                                    }
                                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                    final Function2<? super Composer, ? super Integer, Unit> function29 = function272;
                                    final String str12 = str92;
                                    final Function0<Unit> function010 = function082;
                                    final int i48 = i472;
                                    final String str13 = str102;
                                    final Function2<? super Composer, ? super Integer, Unit> function210 = function282;
                                    final String str14 = str112;
                                    final Function0<Unit> function011 = function092;
                                    final boolean z27 = z262;
                                    BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer4, 1259992441, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar2, Composer composer5, Integer num2) {
                                            int i49;
                                            b bVar3 = bVar2;
                                            Composer composer6 = composer5;
                                            int intValue2 = num2.intValue();
                                            if ((intValue2 & 14) == 0) {
                                                i49 = (composer6.changed(bVar3) ? 4 : 2) | intValue2;
                                            } else {
                                                i49 = intValue2;
                                            }
                                            if ((i49 & 91) == 18 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1259992441, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous> (QUINavBar.kt:61)");
                                                }
                                                composer6.startReplaceableGroup(914899004);
                                                if (function29 != null || str12 != null) {
                                                    a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                    i a16 = ModifiersKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null), 10.0f, 0.0f, 16.0f, 0.0f, 10, null), Alignment.CenterStart), "\u8fd4\u56de");
                                                    final Function0<Unit> function012 = function010;
                                                    composer6.startReplaceableGroup(1157296644);
                                                    boolean changed = composer6.changed(function012);
                                                    Object rememberedValue = composer6.rememberedValue();
                                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1$1$1$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Function0<Unit> function013 = function012;
                                                                if (function013 != null) {
                                                                    function013.invoke();
                                                                } else {
                                                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        composer6.updateRememberedValue(rememberedValue);
                                                    }
                                                    composer6.endReplaceableGroup();
                                                    i d16 = ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue, 3, null);
                                                    final Function2<? super Composer, ? super Integer, Unit> function211 = function29;
                                                    final int i56 = i48;
                                                    final String str15 = str12;
                                                    ColumnKt.a(d16, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -42221621, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(d dVar, Composer composer7, Integer num3) {
                                                            Composer composer8 = composer7;
                                                            int intValue3 = num3.intValue();
                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                composer8.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-42221621, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:76)");
                                                                }
                                                                if (function211 != null) {
                                                                    composer8.startReplaceableGroup(264212814);
                                                                    function211.invoke(composer8, Integer.valueOf((i56 >> 6) & 14));
                                                                    composer8.endReplaceableGroup();
                                                                } else {
                                                                    composer8.startReplaceableGroup(264212887);
                                                                    ImageKt.a(str15, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i56 >> 3) & 14) | 262144, 0, 0, 2097118);
                                                                    composer8.endReplaceableGroup();
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer6, 24648, 12);
                                                }
                                                composer6.endReplaceableGroup();
                                                i.Companion companion = i.INSTANCE;
                                                i a17 = ModifiersKt.a(bVar3.a(companion, Alignment.Center), str13);
                                                final String str16 = str13;
                                                final int i57 = i48;
                                                final boolean z28 = z27;
                                                BoxKt.a(a17, null, null, ComposableLambdaKt.composableLambda(composer6, -1095780097, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(b bVar4, Composer composer7, Integer num3) {
                                                        int i58;
                                                        LoadingIconType loadingIconType;
                                                        b bVar5 = bVar4;
                                                        Composer composer8 = composer7;
                                                        int intValue3 = num3.intValue();
                                                        if ((intValue3 & 14) == 0) {
                                                            i58 = (composer8.changed(bVar5) ? 4 : 2) | intValue3;
                                                        } else {
                                                            i58 = intValue3;
                                                        }
                                                        if ((i58 & 91) == 18 && composer8.getSkipping()) {
                                                            composer8.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1095780097, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:90)");
                                                            }
                                                            QUIToken qUIToken = QUIToken.INSTANCE;
                                                            TextKt.a(str16, null, null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer8, ((i57 >> 9) & 14) | 1601536, 100663296, 0, 133955494);
                                                            if (z28) {
                                                                i v3 = ComposeLayoutPropUpdaterKt.v(ModifiersKt.Q(bVar5.a(i.INSTANCE, Alignment.CenterEnd), new y(1.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), 17.0f, 17.0f);
                                                                if (qUIToken.isNightMode()) {
                                                                    loadingIconType = LoadingIconType.WHITE;
                                                                } else {
                                                                    loadingIconType = LoadingIconType.GRAY;
                                                                }
                                                                LoadingKt.Loading(v3, loadingIconType, composer8, 8, 0);
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer6, 3080, 6);
                                                if (function210 != null || str14 != null) {
                                                    a.e b17 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                    Alignment.Horizontal d17 = Alignment.INSTANCE.d();
                                                    i s16 = ComposeLayoutPropUpdaterKt.s(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterEnd), 16.0f, 0.0f, 10.0f, 0.0f, 10, null);
                                                    final Function0<Unit> function013 = function011;
                                                    composer6.startReplaceableGroup(1157296644);
                                                    boolean changed2 = composer6.changed(function013);
                                                    Object rememberedValue2 = composer6.rememberedValue();
                                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1$1$4$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Function0<Unit> function014 = function013;
                                                                if (function014 != null) {
                                                                    function014.invoke();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        composer6.updateRememberedValue(rememberedValue2);
                                                    }
                                                    composer6.endReplaceableGroup();
                                                    i d18 = ViewEventPropUpdaterKt.d(s16, false, null, (Function1) rememberedValue2, 3, null);
                                                    final Function2<? super Composer, ? super Integer, Unit> function212 = function210;
                                                    final int i58 = i48;
                                                    final String str17 = str14;
                                                    ColumnKt.a(d18, b17, d17, null, ComposableLambdaKt.composableLambda(composer6, -1459877310, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.5
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(d dVar, Composer composer7, Integer num3) {
                                                            Composer composer8 = composer7;
                                                            int intValue3 = num3.intValue();
                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                composer8.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-1459877310, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:111)");
                                                                }
                                                                if (function212 != null) {
                                                                    composer8.startReplaceableGroup(264214345);
                                                                    function212.invoke(composer8, Integer.valueOf((i58 >> 15) & 14));
                                                                    composer8.endReplaceableGroup();
                                                                } else {
                                                                    composer8.startReplaceableGroup(264214422);
                                                                    ImageKt.a(str17, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i58 >> 12) & 14) | 262144, 0, 0, 2097118);
                                                                    composer8.endReplaceableGroup();
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer6, 24648, 8);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer4, 3080, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer2, 3080, 6);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        hVar5 = hVar4;
                        function25 = function24;
                        str7 = str6;
                        function05 = function04;
                        str8 = str5;
                        function06 = function03;
                        z18 = z17;
                        function26 = function23;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    function23 = function22;
                    i26 = i16 & 64;
                    if (i26 != 0) {
                    }
                    i27 = i16 & 128;
                    if (i27 != 0) {
                    }
                    i28 = i16 & 256;
                    if (i28 != 0) {
                    }
                    i29 = i16 & 512;
                    if (i29 == 0) {
                    }
                    i39 |= i36;
                    if (i38 != 1) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i38 == 0) {
                    }
                    if ((i16 & 2) == 0) {
                    }
                    if (i46 == 0) {
                    }
                    if (i17 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i26 == 0) {
                    }
                    if (i27 == 0) {
                    }
                    if (i28 == 0) {
                    }
                    if (i29 == 0) {
                    }
                    z17 = z19;
                    function04 = function07;
                    hVar4 = hVar3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    com.tencent.ntcompose.ui.platform.a aVar22 = (com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d());
                    final Function2<? super Composer, ? super Integer, Unit> function2722 = function24;
                    final String str922 = str4;
                    final Function0<Unit> function0822 = function03;
                    final int i4722 = i39;
                    final String str1022 = str5;
                    final Function2<? super Composer, ? super Integer, Unit> function2822 = function23;
                    final String str1122 = str6;
                    final Function0<Unit> function0922 = function04;
                    final boolean z2622 = z17;
                    composer2 = startRestartGroup;
                    BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), hVar4), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar22)), 0.0f, aVar22.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(composer2, 2074908531, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer3, Integer num) {
                            Composer composer4 = composer3;
                            int intValue = num.intValue();
                            if ((intValue & 81) == 16 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2074908531, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous> (QUINavBar.kt:60)");
                                }
                                i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                final Function2<? super Composer, ? super Integer, Unit> function29 = function2722;
                                final String str12 = str922;
                                final Function0<Unit> function010 = function0822;
                                final int i48 = i4722;
                                final String str13 = str1022;
                                final Function2<? super Composer, ? super Integer, Unit> function210 = function2822;
                                final String str14 = str1122;
                                final Function0<Unit> function011 = function0922;
                                final boolean z27 = z2622;
                                BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer4, 1259992441, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar2, Composer composer5, Integer num2) {
                                        int i49;
                                        b bVar3 = bVar2;
                                        Composer composer6 = composer5;
                                        int intValue2 = num2.intValue();
                                        if ((intValue2 & 14) == 0) {
                                            i49 = (composer6.changed(bVar3) ? 4 : 2) | intValue2;
                                        } else {
                                            i49 = intValue2;
                                        }
                                        if ((i49 & 91) == 18 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1259992441, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous> (QUINavBar.kt:61)");
                                            }
                                            composer6.startReplaceableGroup(914899004);
                                            if (function29 != null || str12 != null) {
                                                a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                i a16 = ModifiersKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null), 10.0f, 0.0f, 16.0f, 0.0f, 10, null), Alignment.CenterStart), "\u8fd4\u56de");
                                                final Function0<Unit> function012 = function010;
                                                composer6.startReplaceableGroup(1157296644);
                                                boolean changed = composer6.changed(function012);
                                                Object rememberedValue = composer6.rememberedValue();
                                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            Function0<Unit> function013 = function012;
                                                            if (function013 != null) {
                                                                function013.invoke();
                                                            } else {
                                                                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                QQKuiklyPlatformApi.Companion.closePage$default();
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer6.updateRememberedValue(rememberedValue);
                                                }
                                                composer6.endReplaceableGroup();
                                                i d16 = ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue, 3, null);
                                                final Function2<? super Composer, ? super Integer, Unit> function211 = function29;
                                                final int i56 = i48;
                                                final String str15 = str12;
                                                ColumnKt.a(d16, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -42221621, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(d dVar, Composer composer7, Integer num3) {
                                                        Composer composer8 = composer7;
                                                        int intValue3 = num3.intValue();
                                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                            composer8.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-42221621, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:76)");
                                                            }
                                                            if (function211 != null) {
                                                                composer8.startReplaceableGroup(264212814);
                                                                function211.invoke(composer8, Integer.valueOf((i56 >> 6) & 14));
                                                                composer8.endReplaceableGroup();
                                                            } else {
                                                                composer8.startReplaceableGroup(264212887);
                                                                ImageKt.a(str15, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i56 >> 3) & 14) | 262144, 0, 0, 2097118);
                                                                composer8.endReplaceableGroup();
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer6, 24648, 12);
                                            }
                                            composer6.endReplaceableGroup();
                                            i.Companion companion = i.INSTANCE;
                                            i a17 = ModifiersKt.a(bVar3.a(companion, Alignment.Center), str13);
                                            final String str16 = str13;
                                            final int i57 = i48;
                                            final boolean z28 = z27;
                                            BoxKt.a(a17, null, null, ComposableLambdaKt.composableLambda(composer6, -1095780097, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(b bVar4, Composer composer7, Integer num3) {
                                                    int i58;
                                                    LoadingIconType loadingIconType;
                                                    b bVar5 = bVar4;
                                                    Composer composer8 = composer7;
                                                    int intValue3 = num3.intValue();
                                                    if ((intValue3 & 14) == 0) {
                                                        i58 = (composer8.changed(bVar5) ? 4 : 2) | intValue3;
                                                    } else {
                                                        i58 = intValue3;
                                                    }
                                                    if ((i58 & 91) == 18 && composer8.getSkipping()) {
                                                        composer8.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1095780097, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:90)");
                                                        }
                                                        QUIToken qUIToken = QUIToken.INSTANCE;
                                                        TextKt.a(str16, null, null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer8, ((i57 >> 9) & 14) | 1601536, 100663296, 0, 133955494);
                                                        if (z28) {
                                                            i v3 = ComposeLayoutPropUpdaterKt.v(ModifiersKt.Q(bVar5.a(i.INSTANCE, Alignment.CenterEnd), new y(1.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), 17.0f, 17.0f);
                                                            if (qUIToken.isNightMode()) {
                                                                loadingIconType = LoadingIconType.WHITE;
                                                            } else {
                                                                loadingIconType = LoadingIconType.GRAY;
                                                            }
                                                            LoadingKt.Loading(v3, loadingIconType, composer8, 8, 0);
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer6, 3080, 6);
                                            if (function210 != null || str14 != null) {
                                                a.e b17 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                Alignment.Horizontal d17 = Alignment.INSTANCE.d();
                                                i s16 = ComposeLayoutPropUpdaterKt.s(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterEnd), 16.0f, 0.0f, 10.0f, 0.0f, 10, null);
                                                final Function0<Unit> function013 = function011;
                                                composer6.startReplaceableGroup(1157296644);
                                                boolean changed2 = composer6.changed(function013);
                                                Object rememberedValue2 = composer6.rememberedValue();
                                                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1$1$4$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            Function0<Unit> function014 = function013;
                                                            if (function014 != null) {
                                                                function014.invoke();
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer6.updateRememberedValue(rememberedValue2);
                                                }
                                                composer6.endReplaceableGroup();
                                                i d18 = ViewEventPropUpdaterKt.d(s16, false, null, (Function1) rememberedValue2, 3, null);
                                                final Function2<? super Composer, ? super Integer, Unit> function212 = function210;
                                                final int i58 = i48;
                                                final String str17 = str14;
                                                ColumnKt.a(d18, b17, d17, null, ComposableLambdaKt.composableLambda(composer6, -1459877310, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.5
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(d dVar, Composer composer7, Integer num3) {
                                                        Composer composer8 = composer7;
                                                        int intValue3 = num3.intValue();
                                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                            composer8.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1459877310, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:111)");
                                                            }
                                                            if (function212 != null) {
                                                                composer8.startReplaceableGroup(264214345);
                                                                function212.invoke(composer8, Integer.valueOf((i58 >> 15) & 14));
                                                                composer8.endReplaceableGroup();
                                                            } else {
                                                                composer8.startReplaceableGroup(264214422);
                                                                ImageKt.a(str17, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i58 >> 12) & 14) | 262144, 0, 0, 2097118);
                                                                composer8.endReplaceableGroup();
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer6, 24648, 8);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer4, 3080, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer2, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    hVar5 = hVar4;
                    function25 = function24;
                    str7 = str6;
                    function05 = function04;
                    str8 = str5;
                    function06 = function03;
                    z18 = z17;
                    function26 = function23;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i19 = i16 & 32;
                if (i19 == 0) {
                }
                function23 = function22;
                i26 = i16 & 64;
                if (i26 != 0) {
                }
                i27 = i16 & 128;
                if (i27 != 0) {
                }
                i28 = i16 & 256;
                if (i28 != 0) {
                }
                i29 = i16 & 512;
                if (i29 == 0) {
                }
                i39 |= i36;
                if (i38 != 1) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i38 == 0) {
                }
                if ((i16 & 2) == 0) {
                }
                if (i46 == 0) {
                }
                if (i17 == 0) {
                }
                if (i18 == 0) {
                }
                if (i19 != 0) {
                }
                if (i26 == 0) {
                }
                if (i27 == 0) {
                }
                if (i28 == 0) {
                }
                if (i29 == 0) {
                }
                z17 = z19;
                function04 = function07;
                hVar4 = hVar3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                com.tencent.ntcompose.ui.platform.a aVar222 = (com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d());
                final Function2<? super Composer, ? super Integer, Unit> function27222 = function24;
                final String str9222 = str4;
                final Function0<Unit> function08222 = function03;
                final int i47222 = i39;
                final String str10222 = str5;
                final Function2<? super Composer, ? super Integer, Unit> function28222 = function23;
                final String str11222 = str6;
                final Function0<Unit> function09222 = function04;
                final boolean z26222 = z17;
                composer2 = startRestartGroup;
                BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), hVar4), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar222)), 0.0f, aVar222.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(composer2, 2074908531, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(b bVar, Composer composer3, Integer num) {
                        Composer composer4 = composer3;
                        int intValue = num.intValue();
                        if ((intValue & 81) == 16 && composer4.getSkipping()) {
                            composer4.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2074908531, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous> (QUINavBar.kt:60)");
                            }
                            i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                            final Function2<? super Composer, ? super Integer, Unit> function29 = function27222;
                            final String str12 = str9222;
                            final Function0<Unit> function010 = function08222;
                            final int i48 = i47222;
                            final String str13 = str10222;
                            final Function2<? super Composer, ? super Integer, Unit> function210 = function28222;
                            final String str14 = str11222;
                            final Function0<Unit> function011 = function09222;
                            final boolean z27 = z26222;
                            BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer4, 1259992441, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(b bVar2, Composer composer5, Integer num2) {
                                    int i49;
                                    b bVar3 = bVar2;
                                    Composer composer6 = composer5;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 14) == 0) {
                                        i49 = (composer6.changed(bVar3) ? 4 : 2) | intValue2;
                                    } else {
                                        i49 = intValue2;
                                    }
                                    if ((i49 & 91) == 18 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1259992441, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous> (QUINavBar.kt:61)");
                                        }
                                        composer6.startReplaceableGroup(914899004);
                                        if (function29 != null || str12 != null) {
                                            a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                            i a16 = ModifiersKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null), 10.0f, 0.0f, 16.0f, 0.0f, 10, null), Alignment.CenterStart), "\u8fd4\u56de");
                                            final Function0<Unit> function012 = function010;
                                            composer6.startReplaceableGroup(1157296644);
                                            boolean changed = composer6.changed(function012);
                                            Object rememberedValue = composer6.rememberedValue();
                                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Function0<Unit> function013 = function012;
                                                        if (function013 != null) {
                                                            function013.invoke();
                                                        } else {
                                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer6.updateRememberedValue(rememberedValue);
                                            }
                                            composer6.endReplaceableGroup();
                                            i d16 = ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue, 3, null);
                                            final Function2<? super Composer, ? super Integer, Unit> function211 = function29;
                                            final int i56 = i48;
                                            final String str15 = str12;
                                            ColumnKt.a(d16, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -42221621, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer7, Integer num3) {
                                                    Composer composer8 = composer7;
                                                    int intValue3 = num3.intValue();
                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                        composer8.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-42221621, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:76)");
                                                        }
                                                        if (function211 != null) {
                                                            composer8.startReplaceableGroup(264212814);
                                                            function211.invoke(composer8, Integer.valueOf((i56 >> 6) & 14));
                                                            composer8.endReplaceableGroup();
                                                        } else {
                                                            composer8.startReplaceableGroup(264212887);
                                                            ImageKt.a(str15, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i56 >> 3) & 14) | 262144, 0, 0, 2097118);
                                                            composer8.endReplaceableGroup();
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer6, 24648, 12);
                                        }
                                        composer6.endReplaceableGroup();
                                        i.Companion companion = i.INSTANCE;
                                        i a17 = ModifiersKt.a(bVar3.a(companion, Alignment.Center), str13);
                                        final String str16 = str13;
                                        final int i57 = i48;
                                        final boolean z28 = z27;
                                        BoxKt.a(a17, null, null, ComposableLambdaKt.composableLambda(composer6, -1095780097, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(b bVar4, Composer composer7, Integer num3) {
                                                int i58;
                                                LoadingIconType loadingIconType;
                                                b bVar5 = bVar4;
                                                Composer composer8 = composer7;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 14) == 0) {
                                                    i58 = (composer8.changed(bVar5) ? 4 : 2) | intValue3;
                                                } else {
                                                    i58 = intValue3;
                                                }
                                                if ((i58 & 91) == 18 && composer8.getSkipping()) {
                                                    composer8.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1095780097, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:90)");
                                                    }
                                                    QUIToken qUIToken = QUIToken.INSTANCE;
                                                    TextKt.a(str16, null, null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer8, ((i57 >> 9) & 14) | 1601536, 100663296, 0, 133955494);
                                                    if (z28) {
                                                        i v3 = ComposeLayoutPropUpdaterKt.v(ModifiersKt.Q(bVar5.a(i.INSTANCE, Alignment.CenterEnd), new y(1.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), 17.0f, 17.0f);
                                                        if (qUIToken.isNightMode()) {
                                                            loadingIconType = LoadingIconType.WHITE;
                                                        } else {
                                                            loadingIconType = LoadingIconType.GRAY;
                                                        }
                                                        LoadingKt.Loading(v3, loadingIconType, composer8, 8, 0);
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer6, 3080, 6);
                                        if (function210 != null || str14 != null) {
                                            a.e b17 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                            Alignment.Horizontal d17 = Alignment.INSTANCE.d();
                                            i s16 = ComposeLayoutPropUpdaterKt.s(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterEnd), 16.0f, 0.0f, 10.0f, 0.0f, 10, null);
                                            final Function0<Unit> function013 = function011;
                                            composer6.startReplaceableGroup(1157296644);
                                            boolean changed2 = composer6.changed(function013);
                                            Object rememberedValue2 = composer6.rememberedValue();
                                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1$1$4$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Function0<Unit> function014 = function013;
                                                        if (function014 != null) {
                                                            function014.invoke();
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer6.updateRememberedValue(rememberedValue2);
                                            }
                                            composer6.endReplaceableGroup();
                                            i d18 = ViewEventPropUpdaterKt.d(s16, false, null, (Function1) rememberedValue2, 3, null);
                                            final Function2<? super Composer, ? super Integer, Unit> function212 = function210;
                                            final int i58 = i48;
                                            final String str17 = str14;
                                            ColumnKt.a(d18, b17, d17, null, ComposableLambdaKt.composableLambda(composer6, -1459877310, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.5
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer7, Integer num3) {
                                                    Composer composer8 = composer7;
                                                    int intValue3 = num3.intValue();
                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                        composer8.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1459877310, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:111)");
                                                        }
                                                        if (function212 != null) {
                                                            composer8.startReplaceableGroup(264214345);
                                                            function212.invoke(composer8, Integer.valueOf((i58 >> 15) & 14));
                                                            composer8.endReplaceableGroup();
                                                        } else {
                                                            composer8.startReplaceableGroup(264214422);
                                                            ImageKt.a(str17, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i58 >> 12) & 14) | 262144, 0, 0, 2097118);
                                                            composer8.endReplaceableGroup();
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer6, 24648, 8);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer4, 3080, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer2, 3080, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
                hVar5 = hVar4;
                function25 = function24;
                str7 = str6;
                function05 = function04;
                str8 = str5;
                function06 = function03;
                z18 = z17;
                function26 = function23;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i18 = i16 & 16;
            if (i18 != 0) {
            }
            i19 = i16 & 32;
            if (i19 == 0) {
            }
            function23 = function22;
            i26 = i16 & 64;
            if (i26 != 0) {
            }
            i27 = i16 & 128;
            if (i27 != 0) {
            }
            i28 = i16 & 256;
            if (i28 != 0) {
            }
            i29 = i16 & 512;
            if (i29 == 0) {
            }
            i39 |= i36;
            if (i38 != 1) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i38 == 0) {
            }
            if ((i16 & 2) == 0) {
            }
            if (i46 == 0) {
            }
            if (i17 == 0) {
            }
            if (i18 == 0) {
            }
            if (i19 != 0) {
            }
            if (i26 == 0) {
            }
            if (i27 == 0) {
            }
            if (i28 == 0) {
            }
            if (i29 == 0) {
            }
            z17 = z19;
            function04 = function07;
            hVar4 = hVar3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            com.tencent.ntcompose.ui.platform.a aVar2222 = (com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d());
            final Function2<? super Composer, ? super Integer, Unit> function272222 = function24;
            final String str92222 = str4;
            final Function0<Unit> function082222 = function03;
            final int i472222 = i39;
            final String str102222 = str5;
            final Function2<? super Composer, ? super Integer, Unit> function282222 = function23;
            final String str112222 = str6;
            final Function0<Unit> function092222 = function04;
            final boolean z262222 = z17;
            composer2 = startRestartGroup;
            BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), hVar4), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar2222)), 0.0f, aVar2222.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(composer2, 2074908531, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(b bVar, Composer composer3, Integer num) {
                    Composer composer4 = composer3;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer4.getSkipping()) {
                        composer4.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2074908531, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous> (QUINavBar.kt:60)");
                        }
                        i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                        final Function2<? super Composer, ? super Integer, Unit> function29 = function272222;
                        final String str12 = str92222;
                        final Function0<Unit> function010 = function082222;
                        final int i48 = i472222;
                        final String str13 = str102222;
                        final Function2<? super Composer, ? super Integer, Unit> function210 = function282222;
                        final String str14 = str112222;
                        final Function0<Unit> function011 = function092222;
                        final boolean z27 = z262222;
                        BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer4, 1259992441, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(b bVar2, Composer composer5, Integer num2) {
                                int i49;
                                b bVar3 = bVar2;
                                Composer composer6 = composer5;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 14) == 0) {
                                    i49 = (composer6.changed(bVar3) ? 4 : 2) | intValue2;
                                } else {
                                    i49 = intValue2;
                                }
                                if ((i49 & 91) == 18 && composer6.getSkipping()) {
                                    composer6.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1259992441, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous> (QUINavBar.kt:61)");
                                    }
                                    composer6.startReplaceableGroup(914899004);
                                    if (function29 != null || str12 != null) {
                                        a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                        i a16 = ModifiersKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null), 10.0f, 0.0f, 16.0f, 0.0f, 10, null), Alignment.CenterStart), "\u8fd4\u56de");
                                        final Function0<Unit> function012 = function010;
                                        composer6.startReplaceableGroup(1157296644);
                                        boolean changed = composer6.changed(function012);
                                        Object rememberedValue = composer6.rememberedValue();
                                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1$1$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    Function0<Unit> function013 = function012;
                                                    if (function013 != null) {
                                                        function013.invoke();
                                                    } else {
                                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer6.updateRememberedValue(rememberedValue);
                                        }
                                        composer6.endReplaceableGroup();
                                        i d16 = ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue, 3, null);
                                        final Function2<? super Composer, ? super Integer, Unit> function211 = function29;
                                        final int i56 = i48;
                                        final String str15 = str12;
                                        ColumnKt.a(d16, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -42221621, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(d dVar, Composer composer7, Integer num3) {
                                                Composer composer8 = composer7;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                    composer8.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-42221621, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:76)");
                                                    }
                                                    if (function211 != null) {
                                                        composer8.startReplaceableGroup(264212814);
                                                        function211.invoke(composer8, Integer.valueOf((i56 >> 6) & 14));
                                                        composer8.endReplaceableGroup();
                                                    } else {
                                                        composer8.startReplaceableGroup(264212887);
                                                        ImageKt.a(str15, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i56 >> 3) & 14) | 262144, 0, 0, 2097118);
                                                        composer8.endReplaceableGroup();
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer6, 24648, 12);
                                    }
                                    composer6.endReplaceableGroup();
                                    i.Companion companion = i.INSTANCE;
                                    i a17 = ModifiersKt.a(bVar3.a(companion, Alignment.Center), str13);
                                    final String str16 = str13;
                                    final int i57 = i48;
                                    final boolean z28 = z27;
                                    BoxKt.a(a17, null, null, ComposableLambdaKt.composableLambda(composer6, -1095780097, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar4, Composer composer7, Integer num3) {
                                            int i58;
                                            LoadingIconType loadingIconType;
                                            b bVar5 = bVar4;
                                            Composer composer8 = composer7;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 14) == 0) {
                                                i58 = (composer8.changed(bVar5) ? 4 : 2) | intValue3;
                                            } else {
                                                i58 = intValue3;
                                            }
                                            if ((i58 & 91) == 18 && composer8.getSkipping()) {
                                                composer8.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1095780097, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:90)");
                                                }
                                                QUIToken qUIToken = QUIToken.INSTANCE;
                                                TextKt.a(str16, null, null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer8, ((i57 >> 9) & 14) | 1601536, 100663296, 0, 133955494);
                                                if (z28) {
                                                    i v3 = ComposeLayoutPropUpdaterKt.v(ModifiersKt.Q(bVar5.a(i.INSTANCE, Alignment.CenterEnd), new y(1.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), 17.0f, 17.0f);
                                                    if (qUIToken.isNightMode()) {
                                                        loadingIconType = LoadingIconType.WHITE;
                                                    } else {
                                                        loadingIconType = LoadingIconType.GRAY;
                                                    }
                                                    LoadingKt.Loading(v3, loadingIconType, composer8, 8, 0);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer6, 3080, 6);
                                    if (function210 != null || str14 != null) {
                                        a.e b17 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                        Alignment.Horizontal d17 = Alignment.INSTANCE.d();
                                        i s16 = ComposeLayoutPropUpdaterKt.s(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterEnd), 16.0f, 0.0f, 10.0f, 0.0f, 10, null);
                                        final Function0<Unit> function013 = function011;
                                        composer6.startReplaceableGroup(1157296644);
                                        boolean changed2 = composer6.changed(function013);
                                        Object rememberedValue2 = composer6.rememberedValue();
                                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1$1$4$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    Function0<Unit> function014 = function013;
                                                    if (function014 != null) {
                                                        function014.invoke();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer6.updateRememberedValue(rememberedValue2);
                                        }
                                        composer6.endReplaceableGroup();
                                        i d18 = ViewEventPropUpdaterKt.d(s16, false, null, (Function1) rememberedValue2, 3, null);
                                        final Function2<? super Composer, ? super Integer, Unit> function212 = function210;
                                        final int i58 = i48;
                                        final String str17 = str14;
                                        ColumnKt.a(d18, b17, d17, null, ComposableLambdaKt.composableLambda(composer6, -1459877310, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.5
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(d dVar, Composer composer7, Integer num3) {
                                                Composer composer8 = composer7;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                    composer8.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1459877310, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:111)");
                                                    }
                                                    if (function212 != null) {
                                                        composer8.startReplaceableGroup(264214345);
                                                        function212.invoke(composer8, Integer.valueOf((i58 >> 15) & 14));
                                                        composer8.endReplaceableGroup();
                                                    } else {
                                                        composer8.startReplaceableGroup(264214422);
                                                        ImageKt.a(str17, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i58 >> 12) & 14) | 262144, 0, 0, 2097118);
                                                        composer8.endReplaceableGroup();
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer6, 24648, 8);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer4, 3080, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), composer2, 3080, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
            hVar5 = hVar4;
            function25 = function24;
            str7 = str6;
            function05 = function04;
            str8 = str5;
            function06 = function03;
            z18 = z17;
            function26 = function23;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i17 = i16 & 8;
        if (i17 == 0) {
        }
        i18 = i16 & 16;
        if (i18 != 0) {
        }
        i19 = i16 & 32;
        if (i19 == 0) {
        }
        function23 = function22;
        i26 = i16 & 64;
        if (i26 != 0) {
        }
        i27 = i16 & 128;
        if (i27 != 0) {
        }
        i28 = i16 & 256;
        if (i28 != 0) {
        }
        i29 = i16 & 512;
        if (i29 == 0) {
        }
        i39 |= i36;
        if (i38 != 1) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i38 == 0) {
        }
        if ((i16 & 2) == 0) {
        }
        if (i46 == 0) {
        }
        if (i17 == 0) {
        }
        if (i18 == 0) {
        }
        if (i19 != 0) {
        }
        if (i26 == 0) {
        }
        if (i27 == 0) {
        }
        if (i28 == 0) {
        }
        if (i29 == 0) {
        }
        z17 = z19;
        function04 = function07;
        hVar4 = hVar3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        com.tencent.ntcompose.ui.platform.a aVar22222 = (com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d());
        final Function2<? super Composer, ? super Integer, Unit> function2722222 = function24;
        final String str922222 = str4;
        final Function0<Unit> function0822222 = function03;
        final int i4722222 = i39;
        final String str1022222 = str5;
        final Function2<? super Composer, ? super Integer, Unit> function2822222 = function23;
        final String str1122222 = str6;
        final Function0<Unit> function0922222 = function04;
        final boolean z2622222 = z17;
        composer2 = startRestartGroup;
        BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), hVar4), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar22222)), 0.0f, aVar22222.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(composer2, 2074908531, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer3, Integer num) {
                Composer composer4 = composer3;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer4.getSkipping()) {
                    composer4.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2074908531, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous> (QUINavBar.kt:60)");
                    }
                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                    final Function2<? super Composer, ? super Integer, Unit> function29 = function2722222;
                    final String str12 = str922222;
                    final Function0<Unit> function010 = function0822222;
                    final int i48 = i4722222;
                    final String str13 = str1022222;
                    final Function2<? super Composer, ? super Integer, Unit> function210 = function2822222;
                    final String str14 = str1122222;
                    final Function0<Unit> function011 = function0922222;
                    final boolean z27 = z2622222;
                    BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer4, 1259992441, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar2, Composer composer5, Integer num2) {
                            int i49;
                            b bVar3 = bVar2;
                            Composer composer6 = composer5;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i49 = (composer6.changed(bVar3) ? 4 : 2) | intValue2;
                            } else {
                                i49 = intValue2;
                            }
                            if ((i49 & 91) == 18 && composer6.getSkipping()) {
                                composer6.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1259992441, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous> (QUINavBar.kt:61)");
                                }
                                composer6.startReplaceableGroup(914899004);
                                if (function29 != null || str12 != null) {
                                    a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                    i a16 = ModifiersKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null), 10.0f, 0.0f, 16.0f, 0.0f, 10, null), Alignment.CenterStart), "\u8fd4\u56de");
                                    final Function0<Unit> function012 = function010;
                                    composer6.startReplaceableGroup(1157296644);
                                    boolean changed = composer6.changed(function012);
                                    Object rememberedValue = composer6.rememberedValue();
                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Function0<Unit> function013 = function012;
                                                if (function013 != null) {
                                                    function013.invoke();
                                                } else {
                                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer6.updateRememberedValue(rememberedValue);
                                    }
                                    composer6.endReplaceableGroup();
                                    i d16 = ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue, 3, null);
                                    final Function2<? super Composer, ? super Integer, Unit> function211 = function29;
                                    final int i56 = i48;
                                    final String str15 = str12;
                                    ColumnKt.a(d16, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -42221621, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(d dVar, Composer composer7, Integer num3) {
                                            Composer composer8 = composer7;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                composer8.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-42221621, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:76)");
                                                }
                                                if (function211 != null) {
                                                    composer8.startReplaceableGroup(264212814);
                                                    function211.invoke(composer8, Integer.valueOf((i56 >> 6) & 14));
                                                    composer8.endReplaceableGroup();
                                                } else {
                                                    composer8.startReplaceableGroup(264212887);
                                                    ImageKt.a(str15, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i56 >> 3) & 14) | 262144, 0, 0, 2097118);
                                                    composer8.endReplaceableGroup();
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer6, 24648, 12);
                                }
                                composer6.endReplaceableGroup();
                                i.Companion companion = i.INSTANCE;
                                i a17 = ModifiersKt.a(bVar3.a(companion, Alignment.Center), str13);
                                final String str16 = str13;
                                final int i57 = i48;
                                final boolean z28 = z27;
                                BoxKt.a(a17, null, null, ComposableLambdaKt.composableLambda(composer6, -1095780097, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar4, Composer composer7, Integer num3) {
                                        int i58;
                                        LoadingIconType loadingIconType;
                                        b bVar5 = bVar4;
                                        Composer composer8 = composer7;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i58 = (composer8.changed(bVar5) ? 4 : 2) | intValue3;
                                        } else {
                                            i58 = intValue3;
                                        }
                                        if ((i58 & 91) == 18 && composer8.getSkipping()) {
                                            composer8.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1095780097, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:90)");
                                            }
                                            QUIToken qUIToken = QUIToken.INSTANCE;
                                            TextKt.a(str16, null, null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer8, ((i57 >> 9) & 14) | 1601536, 100663296, 0, 133955494);
                                            if (z28) {
                                                i v3 = ComposeLayoutPropUpdaterKt.v(ModifiersKt.Q(bVar5.a(i.INSTANCE, Alignment.CenterEnd), new y(1.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), 17.0f, 17.0f);
                                                if (qUIToken.isNightMode()) {
                                                    loadingIconType = LoadingIconType.WHITE;
                                                } else {
                                                    loadingIconType = LoadingIconType.GRAY;
                                                }
                                                LoadingKt.Loading(v3, loadingIconType, composer8, 8, 0);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer6, 3080, 6);
                                if (function210 != null || str14 != null) {
                                    a.e b17 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                    Alignment.Horizontal d17 = Alignment.INSTANCE.d();
                                    i s16 = ComposeLayoutPropUpdaterKt.s(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterEnd), 16.0f, 0.0f, 10.0f, 0.0f, 10, null);
                                    final Function0<Unit> function013 = function011;
                                    composer6.startReplaceableGroup(1157296644);
                                    boolean changed2 = composer6.changed(function013);
                                    Object rememberedValue2 = composer6.rememberedValue();
                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt$QUINavBar$1$1$4$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Function0<Unit> function014 = function013;
                                                if (function014 != null) {
                                                    function014.invoke();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer6.updateRememberedValue(rememberedValue2);
                                    }
                                    composer6.endReplaceableGroup();
                                    i d18 = ViewEventPropUpdaterKt.d(s16, false, null, (Function1) rememberedValue2, 3, null);
                                    final Function2<? super Composer, ? super Integer, Unit> function212 = function210;
                                    final int i58 = i48;
                                    final String str17 = str14;
                                    ColumnKt.a(d18, b17, d17, null, ComposableLambdaKt.composableLambda(composer6, -1459877310, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt.QUINavBar.1.1.5
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(d dVar, Composer composer7, Integer num3) {
                                            Composer composer8 = composer7;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                composer8.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1459877310, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBar.<anonymous>.<anonymous>.<anonymous> (QUINavBar.kt:111)");
                                                }
                                                if (function212 != null) {
                                                    composer8.startReplaceableGroup(264214345);
                                                    function212.invoke(composer8, Integer.valueOf((i58 >> 15) & 14));
                                                    composer8.endReplaceableGroup();
                                                } else {
                                                    composer8.startReplaceableGroup(264214422);
                                                    ImageKt.a(str17, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i58 >> 12) & 14) | 262144, 0, 0, 2097118);
                                                    composer8.endReplaceableGroup();
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer6, 24648, 8);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer4, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), composer2, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        hVar5 = hVar4;
        function25 = function24;
        str7 = str6;
        function05 = function04;
        str8 = str5;
        function06 = function03;
        z18 = z17;
        function26 = function23;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
