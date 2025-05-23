package com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view;

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
/* loaded from: classes33.dex */
public final class HbDetailNavBarKt {
    /* JADX WARN: Removed duplicated region for block: B:104:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void HbDetailNavBar(String str, String str2, String str3, Function0<Unit> function0, Function0<Unit> function02, boolean z16, float f16, Composer composer, final int i3, final int i16) {
        int i17;
        String str4;
        int i18;
        String str5;
        int i19;
        Function0<Unit> function03;
        int i26;
        Function0<Unit> function04;
        int i27;
        boolean z17;
        int i28;
        String str6;
        String str7;
        float f17;
        final String str8;
        final boolean z18;
        String str9;
        final float f18;
        final Function0<Unit> function05;
        ScopeUpdateScope endRestartGroup;
        int i29;
        Composer startRestartGroup = composer.startRestartGroup(-784850534);
        if ((i3 & 14) == 0) {
            if ((i16 & 1) == 0 && startRestartGroup.changed(str)) {
                i29 = 4;
                i17 = i29 | i3;
            }
            i29 = 2;
            i17 = i29 | i3;
        } else {
            i17 = i3;
        }
        int i36 = i16 & 2;
        if (i36 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            str4 = str2;
            i17 |= startRestartGroup.changed(str4) ? 32 : 16;
            i18 = i16 & 4;
            if (i18 == 0) {
                i17 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                str5 = str3;
                i17 |= startRestartGroup.changed(str5) ? 256 : 128;
                i19 = i16 & 8;
                if (i19 != 0) {
                    i17 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    function03 = function0;
                    i17 |= startRestartGroup.changed(function03) ? 2048 : 1024;
                    i26 = i16 & 16;
                    if (i26 == 0) {
                        i17 |= 24576;
                    } else if ((57344 & i3) == 0) {
                        function04 = function02;
                        i17 |= startRestartGroup.changed(function04) ? 16384 : 8192;
                        i27 = i16 & 32;
                        if (i27 != 0) {
                            i17 |= 196608;
                        } else if ((458752 & i3) == 0) {
                            z17 = z16;
                            i17 |= startRestartGroup.changed(z17) ? 131072 : 65536;
                            i28 = i16 & 64;
                            if (i28 == 0) {
                                i17 |= 1572864;
                            } else if ((i3 & 3670016) == 0) {
                                i17 |= startRestartGroup.changed(f16) ? 1048576 : 524288;
                            }
                            if ((i17 & 2995931) != 599186 && startRestartGroup.getSkipping()) {
                                startRestartGroup.skipToGroupEnd();
                                str9 = str;
                                str8 = str5;
                                function05 = function03;
                                z18 = z17;
                                f18 = f16;
                            } else {
                                startRestartGroup.startDefaults();
                                if ((i3 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i16 & 1) != 0) {
                                        i17 &= -15;
                                    }
                                    str6 = str;
                                    f17 = f16;
                                    str7 = str4;
                                } else {
                                    if ((i16 & 1) == 0) {
                                        str6 = QUIToken.INSTANCE.image("chevron_left", QUIToken.color$default("icon_allwhite_primary"));
                                        i17 &= -15;
                                    } else {
                                        str6 = str;
                                    }
                                    str7 = i36 == 0 ? "" : str2;
                                    if (i18 != 0) {
                                        str5 = null;
                                    }
                                    if (i19 != 0) {
                                        function03 = null;
                                    }
                                    if (i26 != 0) {
                                        function04 = null;
                                    }
                                    if (i27 != 0) {
                                        z17 = false;
                                    }
                                    f17 = i28 == 0 ? 10.0f : f16;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-784850534, i17, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar (HbDetailNavBar.kt:41)");
                                }
                                a aVar = (a) startRestartGroup.consume(CompositionLocalsKt.d());
                                final Function0<Unit> function06 = function03;
                                final int i37 = i17;
                                final String str10 = str7;
                                final String str11 = str5;
                                final Function0<Unit> function07 = function04;
                                final String str12 = str6;
                                final boolean z19 = z17;
                                BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), h.INSTANCE.j()), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar)), 0.0f, aVar.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1485122592, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                ComposerKt.traceEventStart(1485122592, intValue, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous> (HbDetailNavBar.kt:58)");
                                            }
                                            i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                            final Function0<Unit> function08 = function06;
                                            final int i38 = i37;
                                            final String str13 = str10;
                                            final String str14 = str11;
                                            final Function0<Unit> function09 = function07;
                                            final String str15 = str12;
                                            final boolean z26 = z19;
                                            BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer3, 1686158374, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(b bVar2, Composer composer4, Integer num2) {
                                                    int i39;
                                                    b bVar3 = bVar2;
                                                    Composer composer5 = composer4;
                                                    int intValue2 = num2.intValue();
                                                    if ((intValue2 & 14) == 0) {
                                                        i39 = (composer5.changed(bVar3) ? 4 : 2) | intValue2;
                                                    } else {
                                                        i39 = intValue2;
                                                    }
                                                    if ((i39 & 91) == 18 && composer5.getSkipping()) {
                                                        composer5.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1686158374, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous> (HbDetailNavBar.kt:59)");
                                                        }
                                                        com.tencent.ntcompose.foundation.layout.base.a aVar2 = com.tencent.ntcompose.foundation.layout.base.a.f339245a;
                                                        a.e b16 = aVar2.b();
                                                        i.Companion companion = i.INSTANCE;
                                                        i a16 = ModifiersKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), 10.0f, 0.0f, 16.0f, 0.0f, 10, null), Alignment.CenterStart), "\u8fd4\u56de");
                                                        final Function0<Unit> function010 = function08;
                                                        composer5.startReplaceableGroup(1157296644);
                                                        boolean changed = composer5.changed(function010);
                                                        Object rememberedValue = composer5.rememberedValue();
                                                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1$1$1$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    Function0<Unit> function011 = function010;
                                                                    if (function011 != null) {
                                                                        function011.invoke();
                                                                    } else {
                                                                        QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            composer5.updateRememberedValue(rememberedValue);
                                                        }
                                                        composer5.endReplaceableGroup();
                                                        i d16 = ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue, 3, null);
                                                        final String str16 = str15;
                                                        final int i46 = i38;
                                                        ColumnKt.a(d16, b16, null, null, ComposableLambdaKt.composableLambda(composer5, 875458589, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                                                Composer composer7 = composer6;
                                                                int intValue3 = num3.intValue();
                                                                if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                                    composer7.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(875458589, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:73)");
                                                                    }
                                                                    ImageKt.a(str16, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, (i46 & 14) | 262144, 0, 0, 2097118);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer5, 24648, 12);
                                                        i a17 = ModifiersKt.a(bVar3.a(companion, Alignment.Center), str13);
                                                        final String str17 = str13;
                                                        final int i47 = i38;
                                                        final boolean z27 = z26;
                                                        BoxKt.a(a17, null, null, ComposableLambdaKt.composableLambda(composer5, 664613292, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(b bVar4, Composer composer6, Integer num3) {
                                                                int i48;
                                                                LoadingIconType loadingIconType;
                                                                b bVar5 = bVar4;
                                                                Composer composer7 = composer6;
                                                                int intValue3 = num3.intValue();
                                                                if ((intValue3 & 14) == 0) {
                                                                    i48 = (composer7.changed(bVar5) ? 4 : 2) | intValue3;
                                                                } else {
                                                                    i48 = intValue3;
                                                                }
                                                                if ((i48 & 91) == 18 && composer7.getSkipping()) {
                                                                    composer7.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(664613292, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:82)");
                                                                    }
                                                                    QUIToken qUIToken = QUIToken.INSTANCE;
                                                                    TextKt.a(str17, null, null, QUIToken.color$default("text_allwhite_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i47 >> 3) & 14) | 1601536, 0, 0, 134217638);
                                                                    if (z27) {
                                                                        i v3 = ComposeLayoutPropUpdaterKt.v(ModifiersKt.Q(bVar5.a(i.INSTANCE, Alignment.CenterEnd), new y(1.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), 17.0f, 17.0f);
                                                                        if (qUIToken.isNightMode()) {
                                                                            loadingIconType = LoadingIconType.WHITE;
                                                                        } else {
                                                                            loadingIconType = LoadingIconType.GRAY;
                                                                        }
                                                                        LoadingKt.Loading(v3, loadingIconType, composer7, 8, 0);
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer5, 3080, 6);
                                                        if (str14 != null) {
                                                            a.e b17 = aVar2.b();
                                                            Alignment.Horizontal d17 = Alignment.INSTANCE.d();
                                                            i s16 = ComposeLayoutPropUpdaterKt.s(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterEnd), 16.0f, 0.0f, 10.0f, 0.0f, 10, null);
                                                            final Function0<Unit> function011 = function09;
                                                            composer5.startReplaceableGroup(1157296644);
                                                            boolean changed2 = composer5.changed(function011);
                                                            Object rememberedValue2 = composer5.rememberedValue();
                                                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1$1$4$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        Function0<Unit> function012 = function011;
                                                                        if (function012 != null) {
                                                                            function012.invoke();
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                composer5.updateRememberedValue(rememberedValue2);
                                                            }
                                                            composer5.endReplaceableGroup();
                                                            i d18 = ViewEventPropUpdaterKt.d(s16, false, null, (Function1) rememberedValue2, 3, null);
                                                            final String str18 = str14;
                                                            final int i48 = i38;
                                                            ColumnKt.a(d18, b17, d17, null, ComposableLambdaKt.composableLambda(composer5, -1060512648, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.5
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                                                    Composer composer7 = composer6;
                                                                    int intValue3 = num3.intValue();
                                                                    if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                                        composer7.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-1060512648, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:110)");
                                                                        }
                                                                        TextKt.a(str18, null, null, QUIToken.color$default("text_allwhite_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.c(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i48 >> 6) & 14) | 1601536, 0, 0, 134217638);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer5, 24648, 8);
                                                        }
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
                                }), startRestartGroup, 3080, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                str4 = str7;
                                str8 = str5;
                                z18 = z17;
                                str9 = str6;
                                f18 = f17;
                                function05 = function03;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                                return;
                            }
                            final String str13 = str9;
                            final String str14 = str4;
                            final Function0<Unit> function08 = function04;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Unit invoke(Composer composer2, Integer num) {
                                    num.intValue();
                                    HbDetailNavBarKt.HbDetailNavBar(str13, str14, str8, function05, function08, z18, f18, composer2, i3 | 1, i16);
                                    return Unit.INSTANCE;
                                }
                            });
                            return;
                        }
                        z17 = z16;
                        i28 = i16 & 64;
                        if (i28 == 0) {
                        }
                        if ((i17 & 2995931) != 599186) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) == 0) {
                        }
                        if ((i16 & 1) == 0) {
                        }
                        if (i36 == 0) {
                        }
                        if (i18 != 0) {
                        }
                        if (i19 != 0) {
                        }
                        if (i26 != 0) {
                        }
                        if (i27 != 0) {
                        }
                        if (i28 == 0) {
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        com.tencent.ntcompose.ui.platform.a aVar2 = (com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d());
                        final Function0<Unit> function062 = function03;
                        final int i372 = i17;
                        final String str102 = str7;
                        final String str112 = str5;
                        final Function0<Unit> function072 = function04;
                        final String str122 = str6;
                        final boolean z192 = z17;
                        BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), h.INSTANCE.j()), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar2)), 0.0f, aVar2.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1485122592, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        ComposerKt.traceEventStart(1485122592, intValue, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous> (HbDetailNavBar.kt:58)");
                                    }
                                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                    final Function0<Unit> function082 = function062;
                                    final int i38 = i372;
                                    final String str132 = str102;
                                    final String str142 = str112;
                                    final Function0<Unit> function09 = function072;
                                    final String str15 = str122;
                                    final boolean z26 = z192;
                                    BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer3, 1686158374, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar2, Composer composer4, Integer num2) {
                                            int i39;
                                            b bVar3 = bVar2;
                                            Composer composer5 = composer4;
                                            int intValue2 = num2.intValue();
                                            if ((intValue2 & 14) == 0) {
                                                i39 = (composer5.changed(bVar3) ? 4 : 2) | intValue2;
                                            } else {
                                                i39 = intValue2;
                                            }
                                            if ((i39 & 91) == 18 && composer5.getSkipping()) {
                                                composer5.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1686158374, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous> (HbDetailNavBar.kt:59)");
                                                }
                                                com.tencent.ntcompose.foundation.layout.base.a aVar22 = com.tencent.ntcompose.foundation.layout.base.a.f339245a;
                                                a.e b16 = aVar22.b();
                                                i.Companion companion = i.INSTANCE;
                                                i a16 = ModifiersKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), 10.0f, 0.0f, 16.0f, 0.0f, 10, null), Alignment.CenterStart), "\u8fd4\u56de");
                                                final Function0<Unit> function010 = function082;
                                                composer5.startReplaceableGroup(1157296644);
                                                boolean changed = composer5.changed(function010);
                                                Object rememberedValue = composer5.rememberedValue();
                                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            Function0<Unit> function011 = function010;
                                                            if (function011 != null) {
                                                                function011.invoke();
                                                            } else {
                                                                QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                                                QQKuiklyPlatformApi.Companion.closePage$default();
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer5.updateRememberedValue(rememberedValue);
                                                }
                                                composer5.endReplaceableGroup();
                                                i d16 = ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue, 3, null);
                                                final String str16 = str15;
                                                final int i46 = i38;
                                                ColumnKt.a(d16, b16, null, null, ComposableLambdaKt.composableLambda(composer5, 875458589, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                                        Composer composer7 = composer6;
                                                        int intValue3 = num3.intValue();
                                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                            composer7.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(875458589, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:73)");
                                                            }
                                                            ImageKt.a(str16, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, (i46 & 14) | 262144, 0, 0, 2097118);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer5, 24648, 12);
                                                i a17 = ModifiersKt.a(bVar3.a(companion, Alignment.Center), str132);
                                                final String str17 = str132;
                                                final int i47 = i38;
                                                final boolean z27 = z26;
                                                BoxKt.a(a17, null, null, ComposableLambdaKt.composableLambda(composer5, 664613292, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(b bVar4, Composer composer6, Integer num3) {
                                                        int i48;
                                                        LoadingIconType loadingIconType;
                                                        b bVar5 = bVar4;
                                                        Composer composer7 = composer6;
                                                        int intValue3 = num3.intValue();
                                                        if ((intValue3 & 14) == 0) {
                                                            i48 = (composer7.changed(bVar5) ? 4 : 2) | intValue3;
                                                        } else {
                                                            i48 = intValue3;
                                                        }
                                                        if ((i48 & 91) == 18 && composer7.getSkipping()) {
                                                            composer7.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(664613292, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:82)");
                                                            }
                                                            QUIToken qUIToken = QUIToken.INSTANCE;
                                                            TextKt.a(str17, null, null, QUIToken.color$default("text_allwhite_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i47 >> 3) & 14) | 1601536, 0, 0, 134217638);
                                                            if (z27) {
                                                                i v3 = ComposeLayoutPropUpdaterKt.v(ModifiersKt.Q(bVar5.a(i.INSTANCE, Alignment.CenterEnd), new y(1.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), 17.0f, 17.0f);
                                                                if (qUIToken.isNightMode()) {
                                                                    loadingIconType = LoadingIconType.WHITE;
                                                                } else {
                                                                    loadingIconType = LoadingIconType.GRAY;
                                                                }
                                                                LoadingKt.Loading(v3, loadingIconType, composer7, 8, 0);
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer5, 3080, 6);
                                                if (str142 != null) {
                                                    a.e b17 = aVar22.b();
                                                    Alignment.Horizontal d17 = Alignment.INSTANCE.d();
                                                    i s16 = ComposeLayoutPropUpdaterKt.s(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterEnd), 16.0f, 0.0f, 10.0f, 0.0f, 10, null);
                                                    final Function0<Unit> function011 = function09;
                                                    composer5.startReplaceableGroup(1157296644);
                                                    boolean changed2 = composer5.changed(function011);
                                                    Object rememberedValue2 = composer5.rememberedValue();
                                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1$1$4$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Function0<Unit> function012 = function011;
                                                                if (function012 != null) {
                                                                    function012.invoke();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        composer5.updateRememberedValue(rememberedValue2);
                                                    }
                                                    composer5.endReplaceableGroup();
                                                    i d18 = ViewEventPropUpdaterKt.d(s16, false, null, (Function1) rememberedValue2, 3, null);
                                                    final String str18 = str142;
                                                    final int i48 = i38;
                                                    ColumnKt.a(d18, b17, d17, null, ComposableLambdaKt.composableLambda(composer5, -1060512648, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.5
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                                            Composer composer7 = composer6;
                                                            int intValue3 = num3.intValue();
                                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                                composer7.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-1060512648, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:110)");
                                                                }
                                                                TextKt.a(str18, null, null, QUIToken.color$default("text_allwhite_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.c(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i48 >> 6) & 14) | 1601536, 0, 0, 134217638);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer5, 24648, 8);
                                                }
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
                        }), startRestartGroup, 3080, 6);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        str4 = str7;
                        str8 = str5;
                        z18 = z17;
                        str9 = str6;
                        f18 = f17;
                        function05 = function03;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    function04 = function02;
                    i27 = i16 & 32;
                    if (i27 != 0) {
                    }
                    z17 = z16;
                    i28 = i16 & 64;
                    if (i28 == 0) {
                    }
                    if ((i17 & 2995931) != 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) == 0) {
                    }
                    if ((i16 & 1) == 0) {
                    }
                    if (i36 == 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if (i27 != 0) {
                    }
                    if (i28 == 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    com.tencent.ntcompose.ui.platform.a aVar22 = (com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d());
                    final Function0<Unit> function0622 = function03;
                    final int i3722 = i17;
                    final String str1022 = str7;
                    final String str1122 = str5;
                    final Function0<Unit> function0722 = function04;
                    final String str1222 = str6;
                    final boolean z1922 = z17;
                    BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), h.INSTANCE.j()), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar22)), 0.0f, aVar22.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1485122592, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    ComposerKt.traceEventStart(1485122592, intValue, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous> (HbDetailNavBar.kt:58)");
                                }
                                i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                final Function0<Unit> function082 = function0622;
                                final int i38 = i3722;
                                final String str132 = str1022;
                                final String str142 = str1122;
                                final Function0<Unit> function09 = function0722;
                                final String str15 = str1222;
                                final boolean z26 = z1922;
                                BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer3, 1686158374, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar2, Composer composer4, Integer num2) {
                                        int i39;
                                        b bVar3 = bVar2;
                                        Composer composer5 = composer4;
                                        int intValue2 = num2.intValue();
                                        if ((intValue2 & 14) == 0) {
                                            i39 = (composer5.changed(bVar3) ? 4 : 2) | intValue2;
                                        } else {
                                            i39 = intValue2;
                                        }
                                        if ((i39 & 91) == 18 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1686158374, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous> (HbDetailNavBar.kt:59)");
                                            }
                                            com.tencent.ntcompose.foundation.layout.base.a aVar222 = com.tencent.ntcompose.foundation.layout.base.a.f339245a;
                                            a.e b16 = aVar222.b();
                                            i.Companion companion = i.INSTANCE;
                                            i a16 = ModifiersKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), 10.0f, 0.0f, 16.0f, 0.0f, 10, null), Alignment.CenterStart), "\u8fd4\u56de");
                                            final Function0<Unit> function010 = function082;
                                            composer5.startReplaceableGroup(1157296644);
                                            boolean changed = composer5.changed(function010);
                                            Object rememberedValue = composer5.rememberedValue();
                                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Function0<Unit> function011 = function010;
                                                        if (function011 != null) {
                                                            function011.invoke();
                                                        } else {
                                                            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer5.updateRememberedValue(rememberedValue);
                                            }
                                            composer5.endReplaceableGroup();
                                            i d16 = ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue, 3, null);
                                            final String str16 = str15;
                                            final int i46 = i38;
                                            ColumnKt.a(d16, b16, null, null, ComposableLambdaKt.composableLambda(composer5, 875458589, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                                    Composer composer7 = composer6;
                                                    int intValue3 = num3.intValue();
                                                    if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                        composer7.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(875458589, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:73)");
                                                        }
                                                        ImageKt.a(str16, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, (i46 & 14) | 262144, 0, 0, 2097118);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer5, 24648, 12);
                                            i a17 = ModifiersKt.a(bVar3.a(companion, Alignment.Center), str132);
                                            final String str17 = str132;
                                            final int i47 = i38;
                                            final boolean z27 = z26;
                                            BoxKt.a(a17, null, null, ComposableLambdaKt.composableLambda(composer5, 664613292, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(b bVar4, Composer composer6, Integer num3) {
                                                    int i48;
                                                    LoadingIconType loadingIconType;
                                                    b bVar5 = bVar4;
                                                    Composer composer7 = composer6;
                                                    int intValue3 = num3.intValue();
                                                    if ((intValue3 & 14) == 0) {
                                                        i48 = (composer7.changed(bVar5) ? 4 : 2) | intValue3;
                                                    } else {
                                                        i48 = intValue3;
                                                    }
                                                    if ((i48 & 91) == 18 && composer7.getSkipping()) {
                                                        composer7.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(664613292, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:82)");
                                                        }
                                                        QUIToken qUIToken = QUIToken.INSTANCE;
                                                        TextKt.a(str17, null, null, QUIToken.color$default("text_allwhite_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i47 >> 3) & 14) | 1601536, 0, 0, 134217638);
                                                        if (z27) {
                                                            i v3 = ComposeLayoutPropUpdaterKt.v(ModifiersKt.Q(bVar5.a(i.INSTANCE, Alignment.CenterEnd), new y(1.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), 17.0f, 17.0f);
                                                            if (qUIToken.isNightMode()) {
                                                                loadingIconType = LoadingIconType.WHITE;
                                                            } else {
                                                                loadingIconType = LoadingIconType.GRAY;
                                                            }
                                                            LoadingKt.Loading(v3, loadingIconType, composer7, 8, 0);
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer5, 3080, 6);
                                            if (str142 != null) {
                                                a.e b17 = aVar222.b();
                                                Alignment.Horizontal d17 = Alignment.INSTANCE.d();
                                                i s16 = ComposeLayoutPropUpdaterKt.s(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterEnd), 16.0f, 0.0f, 10.0f, 0.0f, 10, null);
                                                final Function0<Unit> function011 = function09;
                                                composer5.startReplaceableGroup(1157296644);
                                                boolean changed2 = composer5.changed(function011);
                                                Object rememberedValue2 = composer5.rememberedValue();
                                                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1$1$4$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            Function0<Unit> function012 = function011;
                                                            if (function012 != null) {
                                                                function012.invoke();
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer5.updateRememberedValue(rememberedValue2);
                                                }
                                                composer5.endReplaceableGroup();
                                                i d18 = ViewEventPropUpdaterKt.d(s16, false, null, (Function1) rememberedValue2, 3, null);
                                                final String str18 = str142;
                                                final int i48 = i38;
                                                ColumnKt.a(d18, b17, d17, null, ComposableLambdaKt.composableLambda(composer5, -1060512648, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.5
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                                        Composer composer7 = composer6;
                                                        int intValue3 = num3.intValue();
                                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                            composer7.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1060512648, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:110)");
                                                            }
                                                            TextKt.a(str18, null, null, QUIToken.color$default("text_allwhite_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.c(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i48 >> 6) & 14) | 1601536, 0, 0, 134217638);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer5, 24648, 8);
                                            }
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
                    }), startRestartGroup, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    str4 = str7;
                    str8 = str5;
                    z18 = z17;
                    str9 = str6;
                    f18 = f17;
                    function05 = function03;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function03 = function0;
                i26 = i16 & 16;
                if (i26 == 0) {
                }
                function04 = function02;
                i27 = i16 & 32;
                if (i27 != 0) {
                }
                z17 = z16;
                i28 = i16 & 64;
                if (i28 == 0) {
                }
                if ((i17 & 2995931) != 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) == 0) {
                }
                if ((i16 & 1) == 0) {
                }
                if (i36 == 0) {
                }
                if (i18 != 0) {
                }
                if (i19 != 0) {
                }
                if (i26 != 0) {
                }
                if (i27 != 0) {
                }
                if (i28 == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                com.tencent.ntcompose.ui.platform.a aVar222 = (com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d());
                final Function0<Unit> function06222 = function03;
                final int i37222 = i17;
                final String str10222 = str7;
                final String str11222 = str5;
                final Function0<Unit> function07222 = function04;
                final String str12222 = str6;
                final boolean z19222 = z17;
                BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), h.INSTANCE.j()), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar222)), 0.0f, aVar222.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1485122592, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                ComposerKt.traceEventStart(1485122592, intValue, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous> (HbDetailNavBar.kt:58)");
                            }
                            i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                            final Function0<Unit> function082 = function06222;
                            final int i38 = i37222;
                            final String str132 = str10222;
                            final String str142 = str11222;
                            final Function0<Unit> function09 = function07222;
                            final String str15 = str12222;
                            final boolean z26 = z19222;
                            BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer3, 1686158374, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(b bVar2, Composer composer4, Integer num2) {
                                    int i39;
                                    b bVar3 = bVar2;
                                    Composer composer5 = composer4;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 14) == 0) {
                                        i39 = (composer5.changed(bVar3) ? 4 : 2) | intValue2;
                                    } else {
                                        i39 = intValue2;
                                    }
                                    if ((i39 & 91) == 18 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1686158374, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous> (HbDetailNavBar.kt:59)");
                                        }
                                        com.tencent.ntcompose.foundation.layout.base.a aVar2222 = com.tencent.ntcompose.foundation.layout.base.a.f339245a;
                                        a.e b16 = aVar2222.b();
                                        i.Companion companion = i.INSTANCE;
                                        i a16 = ModifiersKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), 10.0f, 0.0f, 16.0f, 0.0f, 10, null), Alignment.CenterStart), "\u8fd4\u56de");
                                        final Function0<Unit> function010 = function082;
                                        composer5.startReplaceableGroup(1157296644);
                                        boolean changed = composer5.changed(function010);
                                        Object rememberedValue = composer5.rememberedValue();
                                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1$1$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    Function0<Unit> function011 = function010;
                                                    if (function011 != null) {
                                                        function011.invoke();
                                                    } else {
                                                        QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer5.updateRememberedValue(rememberedValue);
                                        }
                                        composer5.endReplaceableGroup();
                                        i d16 = ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue, 3, null);
                                        final String str16 = str15;
                                        final int i46 = i38;
                                        ColumnKt.a(d16, b16, null, null, ComposableLambdaKt.composableLambda(composer5, 875458589, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(875458589, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:73)");
                                                    }
                                                    ImageKt.a(str16, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, (i46 & 14) | 262144, 0, 0, 2097118);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer5, 24648, 12);
                                        i a17 = ModifiersKt.a(bVar3.a(companion, Alignment.Center), str132);
                                        final String str17 = str132;
                                        final int i47 = i38;
                                        final boolean z27 = z26;
                                        BoxKt.a(a17, null, null, ComposableLambdaKt.composableLambda(composer5, 664613292, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(b bVar4, Composer composer6, Integer num3) {
                                                int i48;
                                                LoadingIconType loadingIconType;
                                                b bVar5 = bVar4;
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 14) == 0) {
                                                    i48 = (composer7.changed(bVar5) ? 4 : 2) | intValue3;
                                                } else {
                                                    i48 = intValue3;
                                                }
                                                if ((i48 & 91) == 18 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(664613292, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:82)");
                                                    }
                                                    QUIToken qUIToken = QUIToken.INSTANCE;
                                                    TextKt.a(str17, null, null, QUIToken.color$default("text_allwhite_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i47 >> 3) & 14) | 1601536, 0, 0, 134217638);
                                                    if (z27) {
                                                        i v3 = ComposeLayoutPropUpdaterKt.v(ModifiersKt.Q(bVar5.a(i.INSTANCE, Alignment.CenterEnd), new y(1.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), 17.0f, 17.0f);
                                                        if (qUIToken.isNightMode()) {
                                                            loadingIconType = LoadingIconType.WHITE;
                                                        } else {
                                                            loadingIconType = LoadingIconType.GRAY;
                                                        }
                                                        LoadingKt.Loading(v3, loadingIconType, composer7, 8, 0);
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer5, 3080, 6);
                                        if (str142 != null) {
                                            a.e b17 = aVar2222.b();
                                            Alignment.Horizontal d17 = Alignment.INSTANCE.d();
                                            i s16 = ComposeLayoutPropUpdaterKt.s(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterEnd), 16.0f, 0.0f, 10.0f, 0.0f, 10, null);
                                            final Function0<Unit> function011 = function09;
                                            composer5.startReplaceableGroup(1157296644);
                                            boolean changed2 = composer5.changed(function011);
                                            Object rememberedValue2 = composer5.rememberedValue();
                                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1$1$4$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Function0<Unit> function012 = function011;
                                                        if (function012 != null) {
                                                            function012.invoke();
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer5.updateRememberedValue(rememberedValue2);
                                            }
                                            composer5.endReplaceableGroup();
                                            i d18 = ViewEventPropUpdaterKt.d(s16, false, null, (Function1) rememberedValue2, 3, null);
                                            final String str18 = str142;
                                            final int i48 = i38;
                                            ColumnKt.a(d18, b17, d17, null, ComposableLambdaKt.composableLambda(composer5, -1060512648, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.5
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                                    Composer composer7 = composer6;
                                                    int intValue3 = num3.intValue();
                                                    if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                        composer7.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1060512648, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:110)");
                                                        }
                                                        TextKt.a(str18, null, null, QUIToken.color$default("text_allwhite_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.c(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i48 >> 6) & 14) | 1601536, 0, 0, 134217638);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer5, 24648, 8);
                                        }
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
                }), startRestartGroup, 3080, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
                str4 = str7;
                str8 = str5;
                z18 = z17;
                str9 = str6;
                f18 = f17;
                function05 = function03;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            str5 = str3;
            i19 = i16 & 8;
            if (i19 != 0) {
            }
            function03 = function0;
            i26 = i16 & 16;
            if (i26 == 0) {
            }
            function04 = function02;
            i27 = i16 & 32;
            if (i27 != 0) {
            }
            z17 = z16;
            i28 = i16 & 64;
            if (i28 == 0) {
            }
            if ((i17 & 2995931) != 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) == 0) {
            }
            if ((i16 & 1) == 0) {
            }
            if (i36 == 0) {
            }
            if (i18 != 0) {
            }
            if (i19 != 0) {
            }
            if (i26 != 0) {
            }
            if (i27 != 0) {
            }
            if (i28 == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            com.tencent.ntcompose.ui.platform.a aVar2222 = (com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d());
            final Function0<Unit> function062222 = function03;
            final int i372222 = i17;
            final String str102222 = str7;
            final String str112222 = str5;
            final Function0<Unit> function072222 = function04;
            final String str122222 = str6;
            final boolean z192222 = z17;
            BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), h.INSTANCE.j()), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar2222)), 0.0f, aVar2222.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1485122592, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.traceEventStart(1485122592, intValue, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous> (HbDetailNavBar.kt:58)");
                        }
                        i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                        final Function0<Unit> function082 = function062222;
                        final int i38 = i372222;
                        final String str132 = str102222;
                        final String str142 = str112222;
                        final Function0<Unit> function09 = function072222;
                        final String str15 = str122222;
                        final boolean z26 = z192222;
                        BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer3, 1686158374, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(b bVar2, Composer composer4, Integer num2) {
                                int i39;
                                b bVar3 = bVar2;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 14) == 0) {
                                    i39 = (composer5.changed(bVar3) ? 4 : 2) | intValue2;
                                } else {
                                    i39 = intValue2;
                                }
                                if ((i39 & 91) == 18 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1686158374, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous> (HbDetailNavBar.kt:59)");
                                    }
                                    com.tencent.ntcompose.foundation.layout.base.a aVar22222 = com.tencent.ntcompose.foundation.layout.base.a.f339245a;
                                    a.e b16 = aVar22222.b();
                                    i.Companion companion = i.INSTANCE;
                                    i a16 = ModifiersKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), 10.0f, 0.0f, 16.0f, 0.0f, 10, null), Alignment.CenterStart), "\u8fd4\u56de");
                                    final Function0<Unit> function010 = function082;
                                    composer5.startReplaceableGroup(1157296644);
                                    boolean changed = composer5.changed(function010);
                                    Object rememberedValue = composer5.rememberedValue();
                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Function0<Unit> function011 = function010;
                                                if (function011 != null) {
                                                    function011.invoke();
                                                } else {
                                                    QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue);
                                    }
                                    composer5.endReplaceableGroup();
                                    i d16 = ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue, 3, null);
                                    final String str16 = str15;
                                    final int i46 = i38;
                                    ColumnKt.a(d16, b16, null, null, ComposableLambdaKt.composableLambda(composer5, 875458589, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(875458589, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:73)");
                                                }
                                                ImageKt.a(str16, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, (i46 & 14) | 262144, 0, 0, 2097118);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 24648, 12);
                                    i a17 = ModifiersKt.a(bVar3.a(companion, Alignment.Center), str132);
                                    final String str17 = str132;
                                    final int i47 = i38;
                                    final boolean z27 = z26;
                                    BoxKt.a(a17, null, null, ComposableLambdaKt.composableLambda(composer5, 664613292, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar4, Composer composer6, Integer num3) {
                                            int i48;
                                            LoadingIconType loadingIconType;
                                            b bVar5 = bVar4;
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 14) == 0) {
                                                i48 = (composer7.changed(bVar5) ? 4 : 2) | intValue3;
                                            } else {
                                                i48 = intValue3;
                                            }
                                            if ((i48 & 91) == 18 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(664613292, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:82)");
                                                }
                                                QUIToken qUIToken = QUIToken.INSTANCE;
                                                TextKt.a(str17, null, null, QUIToken.color$default("text_allwhite_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i47 >> 3) & 14) | 1601536, 0, 0, 134217638);
                                                if (z27) {
                                                    i v3 = ComposeLayoutPropUpdaterKt.v(ModifiersKt.Q(bVar5.a(i.INSTANCE, Alignment.CenterEnd), new y(1.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), 17.0f, 17.0f);
                                                    if (qUIToken.isNightMode()) {
                                                        loadingIconType = LoadingIconType.WHITE;
                                                    } else {
                                                        loadingIconType = LoadingIconType.GRAY;
                                                    }
                                                    LoadingKt.Loading(v3, loadingIconType, composer7, 8, 0);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3080, 6);
                                    if (str142 != null) {
                                        a.e b17 = aVar22222.b();
                                        Alignment.Horizontal d17 = Alignment.INSTANCE.d();
                                        i s16 = ComposeLayoutPropUpdaterKt.s(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterEnd), 16.0f, 0.0f, 10.0f, 0.0f, 10, null);
                                        final Function0<Unit> function011 = function09;
                                        composer5.startReplaceableGroup(1157296644);
                                        boolean changed2 = composer5.changed(function011);
                                        Object rememberedValue2 = composer5.rememberedValue();
                                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1$1$4$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    Function0<Unit> function012 = function011;
                                                    if (function012 != null) {
                                                        function012.invoke();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer5.updateRememberedValue(rememberedValue2);
                                        }
                                        composer5.endReplaceableGroup();
                                        i d18 = ViewEventPropUpdaterKt.d(s16, false, null, (Function1) rememberedValue2, 3, null);
                                        final String str18 = str142;
                                        final int i48 = i38;
                                        ColumnKt.a(d18, b17, d17, null, ComposableLambdaKt.composableLambda(composer5, -1060512648, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.5
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1060512648, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:110)");
                                                    }
                                                    TextKt.a(str18, null, null, QUIToken.color$default("text_allwhite_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.c(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i48 >> 6) & 14) | 1601536, 0, 0, 134217638);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer5, 24648, 8);
                                    }
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
            }), startRestartGroup, 3080, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
            str4 = str7;
            str8 = str5;
            z18 = z17;
            str9 = str6;
            f18 = f17;
            function05 = function03;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        str4 = str2;
        i18 = i16 & 4;
        if (i18 == 0) {
        }
        str5 = str3;
        i19 = i16 & 8;
        if (i19 != 0) {
        }
        function03 = function0;
        i26 = i16 & 16;
        if (i26 == 0) {
        }
        function04 = function02;
        i27 = i16 & 32;
        if (i27 != 0) {
        }
        z17 = z16;
        i28 = i16 & 64;
        if (i28 == 0) {
        }
        if ((i17 & 2995931) != 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) == 0) {
        }
        if ((i16 & 1) == 0) {
        }
        if (i36 == 0) {
        }
        if (i18 != 0) {
        }
        if (i19 != 0) {
        }
        if (i26 != 0) {
        }
        if (i27 != 0) {
        }
        if (i28 == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        com.tencent.ntcompose.ui.platform.a aVar22222 = (com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d());
        final Function0<Unit> function0622222 = function03;
        final int i3722222 = i17;
        final String str1022222 = str7;
        final String str1122222 = str5;
        final Function0<Unit> function0722222 = function04;
        final String str1222222 = str6;
        final boolean z1922222 = z17;
        BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), h.INSTANCE.j()), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar22222)), 0.0f, aVar22222.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1485122592, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.traceEventStart(1485122592, intValue, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous> (HbDetailNavBar.kt:58)");
                    }
                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                    final Function0<Unit> function082 = function0622222;
                    final int i38 = i3722222;
                    final String str132 = str1022222;
                    final String str142 = str1122222;
                    final Function0<Unit> function09 = function0722222;
                    final String str15 = str1222222;
                    final boolean z26 = z1922222;
                    BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer3, 1686158374, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar2, Composer composer4, Integer num2) {
                            int i39;
                            b bVar3 = bVar2;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i39 = (composer5.changed(bVar3) ? 4 : 2) | intValue2;
                            } else {
                                i39 = intValue2;
                            }
                            if ((i39 & 91) == 18 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1686158374, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous> (HbDetailNavBar.kt:59)");
                                }
                                com.tencent.ntcompose.foundation.layout.base.a aVar222222 = com.tencent.ntcompose.foundation.layout.base.a.f339245a;
                                a.e b16 = aVar222222.b();
                                i.Companion companion = i.INSTANCE;
                                i a16 = ModifiersKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), 10.0f, 0.0f, 16.0f, 0.0f, 10, null), Alignment.CenterStart), "\u8fd4\u56de");
                                final Function0<Unit> function010 = function082;
                                composer5.startReplaceableGroup(1157296644);
                                boolean changed = composer5.changed(function010);
                                Object rememberedValue = composer5.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            Function0<Unit> function011 = function010;
                                            if (function011 != null) {
                                                function011.invoke();
                                            } else {
                                                QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                                QQKuiklyPlatformApi.Companion.closePage$default();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue);
                                }
                                composer5.endReplaceableGroup();
                                i d16 = ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue, 3, null);
                                final String str16 = str15;
                                final int i46 = i38;
                                ColumnKt.a(d16, b16, null, null, ComposableLambdaKt.composableLambda(composer5, 875458589, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(875458589, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:73)");
                                            }
                                            ImageKt.a(str16, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 24.0f), 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, (i46 & 14) | 262144, 0, 0, 2097118);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 24648, 12);
                                i a17 = ModifiersKt.a(bVar3.a(companion, Alignment.Center), str132);
                                final String str17 = str132;
                                final int i47 = i38;
                                final boolean z27 = z26;
                                BoxKt.a(a17, null, null, ComposableLambdaKt.composableLambda(composer5, 664613292, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar4, Composer composer6, Integer num3) {
                                        int i48;
                                        LoadingIconType loadingIconType;
                                        b bVar5 = bVar4;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i48 = (composer7.changed(bVar5) ? 4 : 2) | intValue3;
                                        } else {
                                            i48 = intValue3;
                                        }
                                        if ((i48 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(664613292, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:82)");
                                            }
                                            QUIToken qUIToken = QUIToken.INSTANCE;
                                            TextKt.a(str17, null, null, QUIToken.color$default("text_allwhite_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i47 >> 3) & 14) | 1601536, 0, 0, 134217638);
                                            if (z27) {
                                                i v3 = ComposeLayoutPropUpdaterKt.v(ModifiersKt.Q(bVar5.a(i.INSTANCE, Alignment.CenterEnd), new y(1.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), 17.0f, 17.0f);
                                                if (qUIToken.isNightMode()) {
                                                    loadingIconType = LoadingIconType.WHITE;
                                                } else {
                                                    loadingIconType = LoadingIconType.GRAY;
                                                }
                                                LoadingKt.Loading(v3, loadingIconType, composer7, 8, 0);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3080, 6);
                                if (str142 != null) {
                                    a.e b17 = aVar222222.b();
                                    Alignment.Horizontal d17 = Alignment.INSTANCE.d();
                                    i s16 = ComposeLayoutPropUpdaterKt.s(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterEnd), 16.0f, 0.0f, 10.0f, 0.0f, 10, null);
                                    final Function0<Unit> function011 = function09;
                                    composer5.startReplaceableGroup(1157296644);
                                    boolean changed2 = composer5.changed(function011);
                                    Object rememberedValue2 = composer5.rememberedValue();
                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt$HbDetailNavBar$1$1$4$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Function0<Unit> function012 = function011;
                                                if (function012 != null) {
                                                    function012.invoke();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue2);
                                    }
                                    composer5.endReplaceableGroup();
                                    i d18 = ViewEventPropUpdaterKt.d(s16, false, null, (Function1) rememberedValue2, 3, null);
                                    final String str18 = str142;
                                    final int i48 = i38;
                                    ColumnKt.a(d18, b17, d17, null, ComposableLambdaKt.composableLambda(composer5, -1060512648, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBarKt.HbDetailNavBar.1.1.5
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1060512648, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailNavBar.<anonymous>.<anonymous>.<anonymous> (HbDetailNavBar.kt:110)");
                                                }
                                                TextKt.a(str18, null, null, QUIToken.color$default("text_allwhite_secondary"), Float.valueOf(17.0f), null, c.INSTANCE.c(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i48 >> 6) & 14) | 1601536, 0, 0, 134217638);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 24648, 8);
                                }
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
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        str4 = str7;
        str8 = str5;
        z18 = z17;
        str9 = str6;
        f18 = f17;
        function05 = function03;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
