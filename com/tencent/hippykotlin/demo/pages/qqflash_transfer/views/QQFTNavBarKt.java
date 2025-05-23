package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.da_tong_report.DTReportConstKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.ktx.LocalConfigurationExtKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import defpackage.k;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ws3.ab;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTNavBarKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0290  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QQFTNavBar(QQFlashTransferViewModel qQFlashTransferViewModel, h hVar, String str, String str2, Integer num, String str3, String str4, String str5, String str6, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, Boolean bool, Boolean bool2, float f16, Composer composer, final int i3, final int i16, final int i17) {
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
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        int i57;
        h hVar2;
        String str7;
        String str8;
        Integer num2;
        String str9;
        String str10;
        String str11;
        Function0<Unit> function05;
        Boolean bool3;
        float f17;
        Boolean bool4;
        Function0<Unit> function06;
        Function0<Unit> function07;
        Function0<Unit> function08;
        String str12;
        QQFlashTransferViewModel qQFlashTransferViewModel2;
        String str13;
        Composer composer2;
        final QQFlashTransferViewModel qQFlashTransferViewModel3;
        final String str14;
        final h hVar3;
        final String str15;
        final String str16;
        final Integer num3;
        final String str17;
        final Function0<Unit> function09;
        final Boolean bool5;
        final Boolean bool6;
        final Function0<Unit> function010;
        final Function0<Unit> function011;
        final float f18;
        final Function0<Unit> function012;
        final String str18;
        ScopeUpdateScope endRestartGroup;
        int i58;
        Composer startRestartGroup = composer.startRestartGroup(-950264147);
        int i59 = i17 & 1;
        int i65 = i59 != 0 ? i3 | 2 : i3;
        int i66 = i17 & 2;
        if (i66 != 0) {
            i65 |= 16;
        }
        if ((i3 & 896) == 0) {
            if ((i17 & 4) == 0 && startRestartGroup.changed(str)) {
                i58 = 256;
                i65 |= i58;
            }
            i58 = 128;
            i65 |= i58;
        }
        int i67 = i17 & 8;
        if (i67 != 0) {
            i65 |= 3072;
        } else if ((i3 & 7168) == 0) {
            i65 |= startRestartGroup.changed(str2) ? 2048 : 1024;
            i18 = i17 & 16;
            if (i18 == 0) {
                i65 |= 24576;
            } else if ((i3 & 57344) == 0) {
                i65 |= startRestartGroup.changed(num) ? 16384 : 8192;
            }
            i19 = i17 & 32;
            if (i19 == 0) {
                i65 |= 196608;
            } else if ((i3 & 458752) == 0) {
                i65 |= startRestartGroup.changed(str3) ? 131072 : 65536;
            }
            i26 = i17 & 64;
            if (i26 == 0) {
                i65 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                i65 |= startRestartGroup.changed(str4) ? 1048576 : 524288;
            }
            i27 = i17 & 128;
            if (i27 == 0) {
                i65 |= 12582912;
            } else if ((i3 & 29360128) == 0) {
                i65 |= startRestartGroup.changed(str5) ? 8388608 : 4194304;
            }
            i28 = i17 & 256;
            if (i28 == 0) {
                i65 |= 100663296;
            } else if ((i3 & 234881024) == 0) {
                i65 |= startRestartGroup.changed(str6) ? 67108864 : 33554432;
            }
            i29 = i17 & 512;
            if (i29 == 0) {
                i65 |= 805306368;
            } else if ((i3 & 1879048192) == 0) {
                i65 |= startRestartGroup.changed(function0) ? 536870912 : 268435456;
            }
            i36 = i17 & 1024;
            if (i36 == 0) {
                i37 = i16 | 6;
            } else if ((i16 & 14) == 0) {
                i37 = i16 | (startRestartGroup.changed(function02) ? 4 : 2);
            } else {
                i37 = i16;
            }
            i38 = i17 & 2048;
            if (i38 == 0) {
                i37 |= 48;
            } else if ((i16 & 112) == 0) {
                i37 |= startRestartGroup.changed(function03) ? 32 : 16;
            }
            int i68 = i37;
            i39 = i17 & 4096;
            if (i39 == 0) {
                i68 |= MsgConstant.KRMFILETHUMBSIZE384;
                i46 = i39;
            } else {
                i46 = i39;
                if ((i16 & 896) == 0) {
                    i68 |= startRestartGroup.changed(function04) ? 256 : 128;
                    i47 = i17 & 8192;
                    if (i47 != 0) {
                        i68 |= 3072;
                        i48 = i47;
                    } else {
                        i48 = i47;
                        if ((i16 & 7168) == 0) {
                            i68 |= startRestartGroup.changed(bool) ? 2048 : 1024;
                            i49 = i17 & 16384;
                            if (i49 == 0) {
                                i68 |= 24576;
                            } else if ((i16 & 57344) == 0) {
                                i56 = i49;
                                i68 |= startRestartGroup.changed(bool2) ? 16384 : 8192;
                                i57 = i17 & 32768;
                                if (i57 != 0) {
                                    i68 |= 196608;
                                } else if ((i16 & 458752) == 0) {
                                    i68 |= startRestartGroup.changed(f16) ? 131072 : 65536;
                                }
                                if ((i17 & 3) != 3 && (1533916891 & i65) == 306783378 && (374491 & i68) == 74898 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    hVar3 = hVar;
                                    str14 = str;
                                    str15 = str2;
                                    num3 = num;
                                    str17 = str3;
                                    str18 = str4;
                                    str16 = str5;
                                    str13 = str6;
                                    function010 = function0;
                                    function011 = function02;
                                    function09 = function03;
                                    function012 = function04;
                                    bool6 = bool;
                                    bool5 = bool2;
                                    f18 = f16;
                                    composer2 = startRestartGroup;
                                    qQFlashTransferViewModel3 = qQFlashTransferViewModel;
                                } else {
                                    startRestartGroup.startDefaults();
                                    if ((i3 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        if (i66 != 0) {
                                            i65 &= -113;
                                        }
                                        if ((i17 & 4) != 0) {
                                            hVar2 = hVar;
                                            str7 = str;
                                            str8 = str2;
                                            num2 = num;
                                            str9 = str3;
                                            str10 = str4;
                                            str11 = str5;
                                            str12 = str6;
                                            function08 = function0;
                                            function07 = function02;
                                            function06 = function03;
                                            function05 = function04;
                                            bool3 = bool;
                                            bool4 = bool2;
                                            f17 = f16;
                                            i65 &= -897;
                                        } else {
                                            qQFlashTransferViewModel2 = qQFlashTransferViewModel;
                                            hVar2 = hVar;
                                            str7 = str;
                                            str8 = str2;
                                            num2 = num;
                                            str9 = str3;
                                            str10 = str4;
                                            str11 = str5;
                                            str12 = str6;
                                            function08 = function0;
                                            function07 = function02;
                                            function06 = function03;
                                            function05 = function04;
                                            bool3 = bool;
                                            bool4 = bool2;
                                            f17 = f16;
                                            startRestartGroup.endDefaults();
                                            if (ComposerKt.isTraceInProgress()) {
                                                str13 = str12;
                                            } else {
                                                str13 = str12;
                                                ComposerKt.traceEventStart(-950264147, i65, i68, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar (QQFTNavBar.kt:43)");
                                            }
                                            a aVar = (a) startRestartGroup.consume(CompositionLocalsKt.d());
                                            final Function0<Unit> function013 = function08;
                                            final String str19 = str10;
                                            final QQFlashTransferViewModel qQFlashTransferViewModel4 = qQFlashTransferViewModel2;
                                            final Boolean bool7 = bool4;
                                            final Integer num4 = num2;
                                            final String str20 = str8;
                                            final Function0<Unit> function014 = function06;
                                            final Function0<Unit> function015 = function07;
                                            final int i69 = i65;
                                            final int i75 = i68;
                                            final String str21 = str9;
                                            final String str22 = str11;
                                            final String str23 = str7;
                                            final Boolean bool8 = bool3;
                                            final Function0<Unit> function016 = function05;
                                            final String str24 = str13;
                                            composer2 = startRestartGroup;
                                            BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), hVar2), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar)), 0.0f, aVar.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(composer2, 1894388531, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
                                                /* JADX WARN: Removed duplicated region for block: B:29:0x0140  */
                                                /* JADX WARN: Removed duplicated region for block: B:32:0x0171  */
                                                /* JADX WARN: Removed duplicated region for block: B:33:0x00e0  */
                                                /* JADX WARN: Type inference failed for: r2v20 */
                                                /* JADX WARN: Type inference failed for: r2v21 */
                                                /* JADX WARN: Type inference failed for: r2v7, types: [int, boolean] */
                                                @Override // kotlin.jvm.functions.Function3
                                                /*
                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                */
                                                public final Unit invoke(b bVar, Composer composer3, Integer num5) {
                                                    int i76;
                                                    boolean z16;
                                                    boolean z17;
                                                    ?? r26;
                                                    b bVar2;
                                                    SnapshotStateMap<String, ab> snapshotStateMap;
                                                    b bVar3 = bVar;
                                                    Composer composer4 = composer3;
                                                    int intValue = num5.intValue();
                                                    if ((intValue & 14) == 0) {
                                                        i76 = (composer4.changed(bVar3) ? 4 : 2) | intValue;
                                                    } else {
                                                        i76 = intValue;
                                                    }
                                                    if ((i76 & 91) == 18 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1894388531, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous> (QQFTNavBar.kt:69)");
                                                        }
                                                        i.Companion companion = i.INSTANCE;
                                                        RowKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterStart), null, null, null, null, ComposableLambdaKt.composableLambda(composer4, 1884949333, true, new Function3<n, Composer, Integer, Unit>(num4, QQFlashTransferViewModel.this, str20, function014, function015, i69, i75, str21, str22, str23, str19) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.1
                                                            public final /* synthetic */ int $$dirty;
                                                            public final /* synthetic */ String $leftBtnImagePainter;
                                                            public final /* synthetic */ String $leftTextContent;
                                                            public final /* synthetic */ Integer $modalMode;
                                                            public final /* synthetic */ String $navImagePainter;
                                                            public final /* synthetic */ String $navTitle;
                                                            public final /* synthetic */ Function0<Unit> $onLeftBtnClick;
                                                            public final /* synthetic */ Function0<Unit> $onLeftTextClick;
                                                            public final /* synthetic */ String $rightBtnImagePainter;
                                                            public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                                this.$navTitle = r8;
                                                                this.$rightBtnImagePainter = r9;
                                                                this.$leftBtnImagePainter = r10;
                                                                this.$navImagePainter = r11;
                                                            }

                                                            /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
                                                            
                                                                if (((r1 == null || r1.isSecondaryPage()) ? false : true) == false) goto L23;
                                                             */
                                                            /* JADX WARN: Code restructure failed: missing block: B:39:0x0118, code lost:
                                                            
                                                                if ((r23.$navTitle.length() > 0) == false) goto L54;
                                                             */
                                                            /* JADX WARN: Removed duplicated region for block: B:26:0x00b7  */
                                                            /* JADX WARN: Removed duplicated region for block: B:30:0x00fd  */
                                                            /* JADX WARN: Removed duplicated region for block: B:36:0x010e  */
                                                            /* JADX WARN: Removed duplicated region for block: B:42:0x0163  */
                                                            /* JADX WARN: Removed duplicated region for block: B:55:0x007b  */
                                                            @Override // kotlin.jvm.functions.Function3
                                                            /*
                                                                Code decompiled incorrectly, please refer to instructions dump.
                                                            */
                                                            public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                                                                boolean z18;
                                                                float f19;
                                                                boolean changed;
                                                                Object rememberedValue;
                                                                QQFlashTransferViewModel qQFlashTransferViewModel5;
                                                                SnapshotStateMap<String, ab> snapshotStateMap2;
                                                                Composer composer6 = composer5;
                                                                int intValue2 = num6.intValue();
                                                                if ((intValue2 & 81) == 16 && composer6.getSkipping()) {
                                                                    composer6.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(1884949333, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:70)");
                                                                    }
                                                                    com.tencent.ntcompose.foundation.layout.base.a aVar2 = com.tencent.ntcompose.foundation.layout.base.a.f339245a;
                                                                    a.e b16 = aVar2.b();
                                                                    i.Companion companion2 = i.INSTANCE;
                                                                    i f26 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                                                    Integer num7 = this.$modalMode;
                                                                    if (num7 != null && num7.intValue() == 1) {
                                                                        QQFlashTransferViewModel qQFlashTransferViewModel6 = this.$viewModel;
                                                                    }
                                                                    String str25 = this.$leftTextContent;
                                                                    if (str25 != null) {
                                                                        if (str25.length() > 0) {
                                                                            z18 = true;
                                                                            if (!z18) {
                                                                                f19 = 10.0f;
                                                                                i a16 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                                                                final String str26 = this.$leftTextContent;
                                                                                final Function0<Unit> function017 = this.$onLeftTextClick;
                                                                                final Function0<Unit> function018 = this.$onLeftBtnClick;
                                                                                composer6.startReplaceableGroup(1618982084);
                                                                                changed = composer6.changed(str26) | composer6.changed(function017) | composer6.changed(function018);
                                                                                rememberedValue = composer6.rememberedValue();
                                                                                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                                            String str27 = str26;
                                                                                            boolean z19 = false;
                                                                                            if (str27 != null) {
                                                                                                if (str27.length() > 0) {
                                                                                                    z19 = true;
                                                                                                }
                                                                                            }
                                                                                            if (z19) {
                                                                                                Function0<Unit> function019 = function017;
                                                                                                if (function019 != null) {
                                                                                                    function019.invoke();
                                                                                                }
                                                                                            } else {
                                                                                                Function0<Unit> function020 = function018;
                                                                                                if (function020 != null) {
                                                                                                    function020.invoke();
                                                                                                } else {
                                                                                                    QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                                                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                                                                                }
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    };
                                                                                    composer6.updateRememberedValue(rememberedValue);
                                                                                }
                                                                                composer6.endReplaceableGroup();
                                                                                i A = ModifiersKt.A(ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                                                                final String str27 = this.$leftTextContent;
                                                                                final int i77 = this.$$dirty;
                                                                                final String str28 = this.$leftBtnImagePainter;
                                                                                ColumnKt.a(A, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(3);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function3
                                                                                    public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                                        Composer composer8 = composer7;
                                                                                        int intValue3 = num8.intValue();
                                                                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                            composer8.skipToGroupEnd();
                                                                                        } else {
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                                                            }
                                                                                            String str29 = str27;
                                                                                            boolean z19 = false;
                                                                                            if (str29 != null) {
                                                                                                if (str29.length() > 0) {
                                                                                                    z19 = true;
                                                                                                }
                                                                                            }
                                                                                            if (z19) {
                                                                                                composer8.startReplaceableGroup(2107916874);
                                                                                                TextKt.a(str27, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i77 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                                                                composer8.endReplaceableGroup();
                                                                                            } else {
                                                                                                composer8.startReplaceableGroup(2107917260);
                                                                                                ImageKt.a(str28, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i77 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                                                                composer8.endReplaceableGroup();
                                                                                            }
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventEnd();
                                                                                            }
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                }), composer6, 24648, 12);
                                                                                qQFlashTransferViewModel5 = this.$viewModel;
                                                                                if (qQFlashTransferViewModel5 == null && (snapshotStateMap2 = qQFlashTransferViewModel5.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                                                                }
                                                                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                                                a.e b17 = aVar2.b();
                                                                                final QQFlashTransferViewModel qQFlashTransferViewModel7 = this.$viewModel;
                                                                                final String str29 = this.$navTitle;
                                                                                final String str30 = this.$rightBtnImagePainter;
                                                                                final String str31 = this.$navImagePainter;
                                                                                final int i78 = this.$$dirty;
                                                                                ColumnKt.a(n3, b17, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(3);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function3
                                                                                    public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                                        Composer composer8 = composer7;
                                                                                        int intValue3 = num8.intValue();
                                                                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                            composer8.skipToGroupEnd();
                                                                                        } else {
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                                                            }
                                                                                            i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                                                            final String str32 = str31;
                                                                                            final int i79 = i78;
                                                                                            final String str33 = str29;
                                                                                            RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                {
                                                                                                    super(3);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                                public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                                                                    int i85;
                                                                                                    Composer composer10;
                                                                                                    Map mutableMapOf;
                                                                                                    n nVar3 = nVar2;
                                                                                                    Composer composer11 = composer9;
                                                                                                    int intValue4 = num9.intValue();
                                                                                                    if ((intValue4 & 14) == 0) {
                                                                                                        i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                                                                    } else {
                                                                                                        i85 = intValue4;
                                                                                                    }
                                                                                                    if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                                                                        composer11.skipToGroupEnd();
                                                                                                    } else {
                                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                                            ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                                                                        }
                                                                                                        composer11.startReplaceableGroup(-1116923971);
                                                                                                        if (str32 != null) {
                                                                                                            mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                                                            composer10 = composer11;
                                                                                                            ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                                                                        } else {
                                                                                                            composer10 = composer11;
                                                                                                        }
                                                                                                        composer10.endReplaceableGroup();
                                                                                                        TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                                            ComposerKt.traceEventEnd();
                                                                                                        }
                                                                                                    }
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            }), composer8, 196616, 30);
                                                                                            if (QQFlashTransferViewModel.this != null) {
                                                                                                if (str29.length() > 0) {
                                                                                                    QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str30), true, composer8, 25142, 0);
                                                                                                }
                                                                                            }
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventEnd();
                                                                                            }
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                }), composer6, 24648, 12);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            f19 = 16.0f;
                                                                            i a162 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                                                            final String str262 = this.$leftTextContent;
                                                                            final Function0<Unit> function0172 = this.$onLeftTextClick;
                                                                            final Function0<Unit> function0182 = this.$onLeftBtnClick;
                                                                            composer6.startReplaceableGroup(1618982084);
                                                                            changed = composer6.changed(str262) | composer6.changed(function0172) | composer6.changed(function0182);
                                                                            rememberedValue = composer6.rememberedValue();
                                                                            if (!changed) {
                                                                            }
                                                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ClickParams clickParams) {
                                                                                    String str272 = str262;
                                                                                    boolean z19 = false;
                                                                                    if (str272 != null) {
                                                                                        if (str272.length() > 0) {
                                                                                            z19 = true;
                                                                                        }
                                                                                    }
                                                                                    if (z19) {
                                                                                        Function0<Unit> function019 = function0172;
                                                                                        if (function019 != null) {
                                                                                            function019.invoke();
                                                                                        }
                                                                                    } else {
                                                                                        Function0<Unit> function020 = function0182;
                                                                                        if (function020 != null) {
                                                                                            function020.invoke();
                                                                                        } else {
                                                                                            QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            };
                                                                            composer6.updateRememberedValue(rememberedValue);
                                                                            composer6.endReplaceableGroup();
                                                                            i A2 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a162, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                                                            final String str272 = this.$leftTextContent;
                                                                            final int i772 = this.$$dirty;
                                                                            final String str282 = this.$leftBtnImagePainter;
                                                                            ColumnKt.a(A2, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(3);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                                    Composer composer8 = composer7;
                                                                                    int intValue3 = num8.intValue();
                                                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                        composer8.skipToGroupEnd();
                                                                                    } else {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                                                        }
                                                                                        String str292 = str272;
                                                                                        boolean z19 = false;
                                                                                        if (str292 != null) {
                                                                                            if (str292.length() > 0) {
                                                                                                z19 = true;
                                                                                            }
                                                                                        }
                                                                                        if (z19) {
                                                                                            composer8.startReplaceableGroup(2107916874);
                                                                                            TextKt.a(str272, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i772 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                                                            composer8.endReplaceableGroup();
                                                                                        } else {
                                                                                            composer8.startReplaceableGroup(2107917260);
                                                                                            ImageKt.a(str282, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i772 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                                                            composer8.endReplaceableGroup();
                                                                                        }
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }), composer6, 24648, 12);
                                                                            qQFlashTransferViewModel5 = this.$viewModel;
                                                                            if (qQFlashTransferViewModel5 == null && (snapshotStateMap2 = qQFlashTransferViewModel5.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                                                            }
                                                                            i n36 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                                            a.e b172 = aVar2.b();
                                                                            final QQFlashTransferViewModel qQFlashTransferViewModel72 = this.$viewModel;
                                                                            final String str292 = this.$navTitle;
                                                                            final String str302 = this.$rightBtnImagePainter;
                                                                            final String str312 = this.$navImagePainter;
                                                                            final int i782 = this.$$dirty;
                                                                            ColumnKt.a(n36, b172, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(3);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                                    Composer composer8 = composer7;
                                                                                    int intValue3 = num8.intValue();
                                                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                        composer8.skipToGroupEnd();
                                                                                    } else {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                                                        }
                                                                                        i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                                                        final String str32 = str312;
                                                                                        final int i79 = i782;
                                                                                        final String str33 = str292;
                                                                                        RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            {
                                                                                                super(3);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function3
                                                                                            public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                                                                int i85;
                                                                                                Composer composer10;
                                                                                                Map mutableMapOf;
                                                                                                n nVar3 = nVar2;
                                                                                                Composer composer11 = composer9;
                                                                                                int intValue4 = num9.intValue();
                                                                                                if ((intValue4 & 14) == 0) {
                                                                                                    i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                                                                } else {
                                                                                                    i85 = intValue4;
                                                                                                }
                                                                                                if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                                                                    composer11.skipToGroupEnd();
                                                                                                } else {
                                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                                        ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                                                                    }
                                                                                                    composer11.startReplaceableGroup(-1116923971);
                                                                                                    if (str32 != null) {
                                                                                                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                                                        composer10 = composer11;
                                                                                                        ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                                                                    } else {
                                                                                                        composer10 = composer11;
                                                                                                    }
                                                                                                    composer10.endReplaceableGroup();
                                                                                                    TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                                        ComposerKt.traceEventEnd();
                                                                                                    }
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        }), composer8, 196616, 30);
                                                                                        if (QQFlashTransferViewModel.this != null) {
                                                                                            if (str292.length() > 0) {
                                                                                                QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str302), true, composer8, 25142, 0);
                                                                                            }
                                                                                        }
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }), composer6, 24648, 12);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                            }
                                                                        }
                                                                    }
                                                                    z18 = false;
                                                                    if (!z18) {
                                                                    }
                                                                    f19 = 16.0f;
                                                                    i a1622 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                                                    final String str2622 = this.$leftTextContent;
                                                                    final Function0<Unit> function01722 = this.$onLeftTextClick;
                                                                    final Function0<Unit> function01822 = this.$onLeftBtnClick;
                                                                    composer6.startReplaceableGroup(1618982084);
                                                                    changed = composer6.changed(str2622) | composer6.changed(function01722) | composer6.changed(function01822);
                                                                    rememberedValue = composer6.rememberedValue();
                                                                    if (!changed) {
                                                                    }
                                                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            String str2722 = str2622;
                                                                            boolean z19 = false;
                                                                            if (str2722 != null) {
                                                                                if (str2722.length() > 0) {
                                                                                    z19 = true;
                                                                                }
                                                                            }
                                                                            if (z19) {
                                                                                Function0<Unit> function019 = function01722;
                                                                                if (function019 != null) {
                                                                                    function019.invoke();
                                                                                }
                                                                            } else {
                                                                                Function0<Unit> function020 = function01822;
                                                                                if (function020 != null) {
                                                                                    function020.invoke();
                                                                                } else {
                                                                                    QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    };
                                                                    composer6.updateRememberedValue(rememberedValue);
                                                                    composer6.endReplaceableGroup();
                                                                    i A22 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a1622, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                                                    final String str2722 = this.$leftTextContent;
                                                                    final int i7722 = this.$$dirty;
                                                                    final String str2822 = this.$leftBtnImagePainter;
                                                                    ColumnKt.a(A22, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                            Composer composer8 = composer7;
                                                                            int intValue3 = num8.intValue();
                                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                composer8.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                                                }
                                                                                String str2922 = str2722;
                                                                                boolean z19 = false;
                                                                                if (str2922 != null) {
                                                                                    if (str2922.length() > 0) {
                                                                                        z19 = true;
                                                                                    }
                                                                                }
                                                                                if (z19) {
                                                                                    composer8.startReplaceableGroup(2107916874);
                                                                                    TextKt.a(str2722, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i7722 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                                                    composer8.endReplaceableGroup();
                                                                                } else {
                                                                                    composer8.startReplaceableGroup(2107917260);
                                                                                    ImageKt.a(str2822, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i7722 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                                                    composer8.endReplaceableGroup();
                                                                                }
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer6, 24648, 12);
                                                                    qQFlashTransferViewModel5 = this.$viewModel;
                                                                    if (qQFlashTransferViewModel5 == null && (snapshotStateMap2 = qQFlashTransferViewModel5.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                                                    }
                                                                    i n362 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                                    a.e b1722 = aVar2.b();
                                                                    final QQFlashTransferViewModel qQFlashTransferViewModel722 = this.$viewModel;
                                                                    final String str2922 = this.$navTitle;
                                                                    final String str3022 = this.$rightBtnImagePainter;
                                                                    final String str3122 = this.$navImagePainter;
                                                                    final int i7822 = this.$$dirty;
                                                                    ColumnKt.a(n362, b1722, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                            Composer composer8 = composer7;
                                                                            int intValue3 = num8.intValue();
                                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                composer8.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                                                }
                                                                                i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                                                final String str32 = str3122;
                                                                                final int i79 = i7822;
                                                                                final String str33 = str2922;
                                                                                RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(3);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function3
                                                                                    public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                                                        int i85;
                                                                                        Composer composer10;
                                                                                        Map mutableMapOf;
                                                                                        n nVar3 = nVar2;
                                                                                        Composer composer11 = composer9;
                                                                                        int intValue4 = num9.intValue();
                                                                                        if ((intValue4 & 14) == 0) {
                                                                                            i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                                                        } else {
                                                                                            i85 = intValue4;
                                                                                        }
                                                                                        if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                                                            composer11.skipToGroupEnd();
                                                                                        } else {
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                                                            }
                                                                                            composer11.startReplaceableGroup(-1116923971);
                                                                                            if (str32 != null) {
                                                                                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                                                composer10 = composer11;
                                                                                                ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                                                            } else {
                                                                                                composer10 = composer11;
                                                                                            }
                                                                                            composer10.endReplaceableGroup();
                                                                                            TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventEnd();
                                                                                            }
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                }), composer8, 196616, 30);
                                                                                if (QQFlashTransferViewModel.this != null) {
                                                                                    if (str2922.length() > 0) {
                                                                                        QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str3022), true, composer8, 25142, 0);
                                                                                    }
                                                                                }
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer6, 24648, 12);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer4, 196616, 30);
                                                        composer4.startReplaceableGroup(-1240831040);
                                                        QQFlashTransferViewModel qQFlashTransferViewModel5 = QQFlashTransferViewModel.this;
                                                        if (qQFlashTransferViewModel5 == null || (snapshotStateMap = qQFlashTransferViewModel5.selectFilesToDownload) == null) {
                                                            z16 = true;
                                                        } else {
                                                            z16 = true;
                                                            r26 = 1;
                                                            if (!snapshotStateMap.isEmpty()) {
                                                                z17 = true;
                                                                if (z17) {
                                                                    bVar2 = bVar3;
                                                                } else {
                                                                    bVar2 = bVar3;
                                                                    i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, r26, null), Alignment.Center);
                                                                    final QQFlashTransferViewModel qQFlashTransferViewModel6 = QQFlashTransferViewModel.this;
                                                                    BoxKt.a(a16, null, null, ComposableLambdaKt.composableLambda(composer4, -408684780, r26, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.2
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(b bVar4, Composer composer5, Integer num6) {
                                                                            int i77;
                                                                            b bVar5 = bVar4;
                                                                            Composer composer6 = composer5;
                                                                            int intValue2 = num6.intValue();
                                                                            if ((intValue2 & 14) == 0) {
                                                                                i77 = (composer6.changed(bVar5) ? 4 : 2) | intValue2;
                                                                            } else {
                                                                                i77 = intValue2;
                                                                            }
                                                                            if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                                                                composer6.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-408684780, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:145)");
                                                                                }
                                                                                QQFTDownloadBarViewKt.selectFileInfoStrView(bVar5.a(i.INSTANCE, Alignment.Center), QQFlashTransferViewModel.this, composer6, 72);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer4, 3080, 6);
                                                                }
                                                                composer4.endReplaceableGroup();
                                                                RowKt.a(ComposeLayoutPropUpdaterKt.f(bVar2.a(companion, Alignment.CenterEnd), 0.0f, 1, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.c(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer4, 83640332, true, new Function3<n, Composer, Integer, Unit>(bool8, function013, i75, i69, QQFlashTransferViewModel.this, str22, function016, str24) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.3
                                                                    public final /* synthetic */ int $$dirty;
                                                                    public final /* synthetic */ Function0<Unit> $onRightBtnClick;
                                                                    public final /* synthetic */ Function0<Unit> $onRightTextClick;
                                                                    public final /* synthetic */ String $rightBtnImagePainter;
                                                                    public final /* synthetic */ String $rightTextContent;
                                                                    public final /* synthetic */ Boolean $showCheckBox;
                                                                    public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(3);
                                                                        this.$$dirty = r4;
                                                                        this.$viewModel = r5;
                                                                        this.$rightBtnImagePainter = r6;
                                                                        this.$onRightBtnClick = r7;
                                                                        this.$rightTextContent = r8;
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                                                                        int i77;
                                                                        Object obj;
                                                                        String str25;
                                                                        String str26;
                                                                        String str27;
                                                                        String str28;
                                                                        MutableState<Boolean> mutableState;
                                                                        n nVar2 = nVar;
                                                                        Composer composer6 = composer5;
                                                                        int intValue2 = num6.intValue();
                                                                        if ((intValue2 & 14) == 0) {
                                                                            i77 = (composer6.changed(nVar2) ? 4 : 2) | intValue2;
                                                                        } else {
                                                                            i77 = intValue2;
                                                                        }
                                                                        if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                                                            composer6.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(83640332, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:158)");
                                                                            }
                                                                            boolean z18 = false;
                                                                            if (Intrinsics.areEqual(this.$showCheckBox, Boolean.TRUE)) {
                                                                                composer6.startReplaceableGroup(-1319185738);
                                                                                i.Companion companion2 = i.INSTANCE;
                                                                                i f19 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                                                                com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                                                                if (k.a(cVar)) {
                                                                                    str26 = "0S200MNJT807V3GE";
                                                                                } else {
                                                                                    str26 = "0M2003OIIM08YV9M";
                                                                                }
                                                                                e dTBaseParams = DTReportConstKt.getDTBaseParams(str26);
                                                                                QQFlashTransferViewModel qQFlashTransferViewModel7 = this.$viewModel;
                                                                                if (qQFlashTransferViewModel7 != null && (mutableState = qQFlashTransferViewModel7.isAllSelectMode) != null && mutableState.getValue().booleanValue()) {
                                                                                    z18 = true;
                                                                                }
                                                                                if (z18) {
                                                                                    str27 = "1";
                                                                                } else {
                                                                                    str27 = "0";
                                                                                }
                                                                                dTBaseParams.v("is_screen", str27);
                                                                                Unit unit = Unit.INSTANCE;
                                                                                i elementVR = ModifierExtKt.elementVR(f19, "em_bas_select_all", dTBaseParams);
                                                                                final Boolean bool9 = this.$showCheckBox;
                                                                                final Function0<Unit> function017 = this.$onRightTextClick;
                                                                                composer6.startReplaceableGroup(511388516);
                                                                                boolean changed = composer6.changed(bool9) | composer6.changed(function017);
                                                                                Object rememberedValue = composer6.rememberedValue();
                                                                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$2$1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                                            Function0<Unit> function018;
                                                                                            if (Intrinsics.areEqual(bool9, Boolean.TRUE) && (function018 = function017) != null) {
                                                                                                function018.invoke();
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    };
                                                                                    composer6.updateRememberedValue(rememberedValue);
                                                                                }
                                                                                composer6.endReplaceableGroup();
                                                                                i d16 = ViewEventPropUpdaterKt.d(elementVR, false, null, (Function1) rememberedValue, 3, null);
                                                                                Alignment.Companion companion3 = Alignment.INSTANCE;
                                                                                Alignment.Vertical c16 = companion3.c();
                                                                                final QQFlashTransferViewModel qQFlashTransferViewModel8 = this.$viewModel;
                                                                                final String str29 = this.$rightBtnImagePainter;
                                                                                RowKt.a(d16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer6, 762994953, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.3
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(3);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function3
                                                                                    public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                                                        SnapshotStateMap<String, ab> snapshotStateMap2;
                                                                                        MutableState<Boolean> mutableState2;
                                                                                        Composer composer8 = composer7;
                                                                                        int intValue3 = num7.intValue();
                                                                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                            composer8.skipToGroupEnd();
                                                                                        } else {
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventStart(762994953, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:169)");
                                                                                            }
                                                                                            i.Companion companion4 = i.INSTANCE;
                                                                                            i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), 4.0f, 0.0f, 4.0f, 0.0f, 10, null);
                                                                                            QQFlashTransferViewModel qQFlashTransferViewModel9 = QQFlashTransferViewModel.this;
                                                                                            boolean z19 = false;
                                                                                            QQFTCheckBoxViewKt.QQFTCheckBoxView(n3, 0.0f, (qQFlashTransferViewModel9 == null || (mutableState2 = qQFlashTransferViewModel9.isAllSelectMode) == null || !mutableState2.getValue().booleanValue()) ? false : true, null, null, false, composer8, 8, 58);
                                                                                            QQFlashTransferViewModel qQFlashTransferViewModel10 = QQFlashTransferViewModel.this;
                                                                                            if (qQFlashTransferViewModel10 != null && (snapshotStateMap2 = qQFlashTransferViewModel10.selectFilesToDownload) != null && (!snapshotStateMap2.isEmpty())) {
                                                                                                z19 = true;
                                                                                            }
                                                                                            TextKt.a("\u5168\u9009", ComposeLayoutPropUpdaterKt.n(companion4, 0.0f, 0.0f, (z19 || str29 == null) ? 16.0f : 0.0f, 0.0f, 11, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, 1601606, 0, 0, 134216612);
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventEnd();
                                                                                            }
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                }), composer6, 196616, 26);
                                                                                QQFlashTransferViewModel qQFlashTransferViewModel9 = this.$viewModel;
                                                                                if (((qQFlashTransferViewModel9 != null ? qQFlashTransferViewModel9.selectFilesToDownload : null) == null || qQFlashTransferViewModel9.selectFilesToDownload.size() <= 0) && this.$rightBtnImagePainter != null) {
                                                                                    a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                                                    i A = ModifiersKt.A(nVar2.b(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), companion3.c()), 0.5f, 0.0f, 2, null);
                                                                                    if (k.a(cVar)) {
                                                                                        str28 = "0S200MNJT807V3GE";
                                                                                    } else {
                                                                                        str28 = "0M2003OIIM08YV9M";
                                                                                    }
                                                                                    i elementVR2 = ModifierExtKt.elementVR(A, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str28));
                                                                                    final Function0<Unit> function018 = this.$onRightBtnClick;
                                                                                    composer6.startReplaceableGroup(1157296644);
                                                                                    boolean changed2 = composer6.changed(function018);
                                                                                    Object rememberedValue2 = composer6.rememberedValue();
                                                                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$4$1
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                                Function0<Unit> function019 = function018;
                                                                                                if (function019 != null) {
                                                                                                    function019.invoke();
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        };
                                                                                        composer6.updateRememberedValue(rememberedValue2);
                                                                                    }
                                                                                    composer6.endReplaceableGroup();
                                                                                    i d17 = ViewEventPropUpdaterKt.d(elementVR2, false, null, (Function1) rememberedValue2, 3, null);
                                                                                    final String str30 = this.$rightBtnImagePainter;
                                                                                    final int i78 = this.$$dirty;
                                                                                    ColumnKt.a(d17, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -578852167, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.5
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(3);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function3
                                                                                        public final Unit invoke(d dVar, Composer composer7, Integer num7) {
                                                                                            Composer composer8 = composer7;
                                                                                            int intValue3 = num7.intValue();
                                                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                                composer8.skipToGroupEnd();
                                                                                            } else {
                                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                                    ComposerKt.traceEventStart(-578852167, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:193)");
                                                                                                }
                                                                                                ImageKt.a(str30, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 20.0f, 0.0f, 16.0f, 0.0f, 10, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i78 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                                    ComposerKt.traceEventEnd();
                                                                                                }
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    }), composer6, 24648, 12);
                                                                                }
                                                                                composer6.endReplaceableGroup();
                                                                            } else {
                                                                                composer6.startReplaceableGroup(-1319183568);
                                                                                composer6.startReplaceableGroup(-1319183550);
                                                                                String str31 = this.$rightTextContent;
                                                                                if (str31 != null) {
                                                                                    if (str31.length() > 0) {
                                                                                        z18 = true;
                                                                                    }
                                                                                }
                                                                                if (z18) {
                                                                                    i f26 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null);
                                                                                    final Function0<Unit> function019 = this.$onRightTextClick;
                                                                                    composer6.startReplaceableGroup(1157296644);
                                                                                    boolean changed3 = composer6.changed(function019);
                                                                                    Object rememberedValue3 = composer6.rememberedValue();
                                                                                    if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                                                        rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$6$1
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                                Function0<Unit> function020 = function019;
                                                                                                if (function020 != null) {
                                                                                                    function020.invoke();
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        };
                                                                                        composer6.updateRememberedValue(rememberedValue3);
                                                                                    }
                                                                                    composer6.endReplaceableGroup();
                                                                                    i d18 = ViewEventPropUpdaterKt.d(f26, false, null, (Function1) rememberedValue3, 3, null);
                                                                                    final String str32 = this.$rightTextContent;
                                                                                    final int i79 = this.$$dirty;
                                                                                    obj = null;
                                                                                    RowKt.a(d18, null, null, null, null, ComposableLambdaKt.composableLambda(composer6, 1105722541, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.7
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(3);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function3
                                                                                        public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                                                            int i85;
                                                                                            n nVar4 = nVar3;
                                                                                            Composer composer8 = composer7;
                                                                                            int intValue3 = num7.intValue();
                                                                                            if ((intValue3 & 14) == 0) {
                                                                                                i85 = (composer8.changed(nVar4) ? 4 : 2) | intValue3;
                                                                                            } else {
                                                                                                i85 = intValue3;
                                                                                            }
                                                                                            if ((i85 & 91) == 18 && composer8.getSkipping()) {
                                                                                                composer8.skipToGroupEnd();
                                                                                            } else {
                                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                                    ComposerKt.traceEventStart(1105722541, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:204)");
                                                                                                }
                                                                                                h color$default = QUIToken.color$default("text_nav_secondary");
                                                                                                int a17 = ai.INSTANCE.a();
                                                                                                TextKt.a(str32, ModifiersKt.w(nVar4.b(i.INSTANCE, Alignment.INSTANCE.c()), QUIToken.color$default("overlay_standard_primary")), null, color$default, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, ai.f(a17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i79 >> 24) & 14) | 1601600, 0, 0, 134216612);
                                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                                    ComposerKt.traceEventEnd();
                                                                                                }
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    }), composer6, 196616, 30);
                                                                                } else {
                                                                                    obj = null;
                                                                                }
                                                                                composer6.endReplaceableGroup();
                                                                                if (this.$rightBtnImagePainter != null) {
                                                                                    Alignment alignment = Alignment.CenterStart;
                                                                                    i f27 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, obj);
                                                                                    if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                                                                        str25 = "0S200MNJT807V3GE";
                                                                                    } else {
                                                                                        str25 = "0M2003OIIM08YV9M";
                                                                                    }
                                                                                    i elementVR3 = ModifierExtKt.elementVR(f27, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str25));
                                                                                    final Function0<Unit> function020 = this.$onRightBtnClick;
                                                                                    composer6.startReplaceableGroup(1157296644);
                                                                                    boolean changed4 = composer6.changed(function020);
                                                                                    Object rememberedValue4 = composer6.rememberedValue();
                                                                                    if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                                                        rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$8$1
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                                Function0<Unit> function021 = function020;
                                                                                                if (function021 != null) {
                                                                                                    function021.invoke();
                                                                                                }
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        };
                                                                                        composer6.updateRememberedValue(rememberedValue4);
                                                                                    }
                                                                                    composer6.endReplaceableGroup();
                                                                                    i d19 = ViewEventPropUpdaterKt.d(elementVR3, false, null, (Function1) rememberedValue4, 3, null);
                                                                                    final String str33 = this.$rightBtnImagePainter;
                                                                                    final int i85 = this.$$dirty;
                                                                                    BoxKt.a(d19, alignment, null, ComposableLambdaKt.composableLambda(composer6, 1487136136, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.9
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(3);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function3
                                                                                        public final Unit invoke(b bVar4, Composer composer7, Integer num7) {
                                                                                            Composer composer8 = composer7;
                                                                                            int intValue3 = num7.intValue();
                                                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                                composer8.skipToGroupEnd();
                                                                                            } else {
                                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                                    ComposerKt.traceEventStart(1487136136, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:223)");
                                                                                                }
                                                                                                ImageKt.a(str33, null, null, null, null, ModifiersKt.A(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 12.0f, 0.0f, 16.0f, 0.0f, 10, null), 0.5f, 0.0f, 2, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i85 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                                    ComposerKt.traceEventEnd();
                                                                                                }
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    }), composer6, 3128, 4);
                                                                                }
                                                                                composer6.endReplaceableGroup();
                                                                            }
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer4, 196680, 24);
                                                                if (Intrinsics.areEqual(bool7, Boolean.TRUE)) {
                                                                    SurfaceKt.a(ModifiersKt.c(bVar2.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 0.5f), Alignment.BottomCenter), QUIToken.color$default("border_light")), null, null, null, ComposableSingletons$QQFTNavBarKt.f144lambda1, composer4, 24584, 14);
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }
                                                        z17 = false;
                                                        r26 = z16;
                                                        if (z17) {
                                                        }
                                                        composer4.endReplaceableGroup();
                                                        RowKt.a(ComposeLayoutPropUpdaterKt.f(bVar2.a(companion, Alignment.CenterEnd), 0.0f, 1, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.c(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer4, 83640332, true, new Function3<n, Composer, Integer, Unit>(bool8, function013, i75, i69, QQFlashTransferViewModel.this, str22, function016, str24) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.3
                                                            public final /* synthetic */ int $$dirty;
                                                            public final /* synthetic */ Function0<Unit> $onRightBtnClick;
                                                            public final /* synthetic */ Function0<Unit> $onRightTextClick;
                                                            public final /* synthetic */ String $rightBtnImagePainter;
                                                            public final /* synthetic */ String $rightTextContent;
                                                            public final /* synthetic */ Boolean $showCheckBox;
                                                            public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                                this.$$dirty = r4;
                                                                this.$viewModel = r5;
                                                                this.$rightBtnImagePainter = r6;
                                                                this.$onRightBtnClick = r7;
                                                                this.$rightTextContent = r8;
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                                                                int i77;
                                                                Object obj;
                                                                String str25;
                                                                String str26;
                                                                String str27;
                                                                String str28;
                                                                MutableState<Boolean> mutableState;
                                                                n nVar2 = nVar;
                                                                Composer composer6 = composer5;
                                                                int intValue2 = num6.intValue();
                                                                if ((intValue2 & 14) == 0) {
                                                                    i77 = (composer6.changed(nVar2) ? 4 : 2) | intValue2;
                                                                } else {
                                                                    i77 = intValue2;
                                                                }
                                                                if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                                                    composer6.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(83640332, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:158)");
                                                                    }
                                                                    boolean z18 = false;
                                                                    if (Intrinsics.areEqual(this.$showCheckBox, Boolean.TRUE)) {
                                                                        composer6.startReplaceableGroup(-1319185738);
                                                                        i.Companion companion2 = i.INSTANCE;
                                                                        i f19 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                                                        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                                                        if (k.a(cVar)) {
                                                                            str26 = "0S200MNJT807V3GE";
                                                                        } else {
                                                                            str26 = "0M2003OIIM08YV9M";
                                                                        }
                                                                        e dTBaseParams = DTReportConstKt.getDTBaseParams(str26);
                                                                        QQFlashTransferViewModel qQFlashTransferViewModel7 = this.$viewModel;
                                                                        if (qQFlashTransferViewModel7 != null && (mutableState = qQFlashTransferViewModel7.isAllSelectMode) != null && mutableState.getValue().booleanValue()) {
                                                                            z18 = true;
                                                                        }
                                                                        if (z18) {
                                                                            str27 = "1";
                                                                        } else {
                                                                            str27 = "0";
                                                                        }
                                                                        dTBaseParams.v("is_screen", str27);
                                                                        Unit unit = Unit.INSTANCE;
                                                                        i elementVR = ModifierExtKt.elementVR(f19, "em_bas_select_all", dTBaseParams);
                                                                        final Boolean bool9 = this.$showCheckBox;
                                                                        final Function0<Unit> function017 = this.$onRightTextClick;
                                                                        composer6.startReplaceableGroup(511388516);
                                                                        boolean changed = composer6.changed(bool9) | composer6.changed(function017);
                                                                        Object rememberedValue = composer6.rememberedValue();
                                                                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$2$1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ClickParams clickParams) {
                                                                                    Function0<Unit> function018;
                                                                                    if (Intrinsics.areEqual(bool9, Boolean.TRUE) && (function018 = function017) != null) {
                                                                                        function018.invoke();
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            };
                                                                            composer6.updateRememberedValue(rememberedValue);
                                                                        }
                                                                        composer6.endReplaceableGroup();
                                                                        i d16 = ViewEventPropUpdaterKt.d(elementVR, false, null, (Function1) rememberedValue, 3, null);
                                                                        Alignment.Companion companion3 = Alignment.INSTANCE;
                                                                        Alignment.Vertical c16 = companion3.c();
                                                                        final QQFlashTransferViewModel qQFlashTransferViewModel8 = this.$viewModel;
                                                                        final String str29 = this.$rightBtnImagePainter;
                                                                        RowKt.a(d16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer6, 762994953, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.3
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                                                SnapshotStateMap<String, ab> snapshotStateMap2;
                                                                                MutableState<Boolean> mutableState2;
                                                                                Composer composer8 = composer7;
                                                                                int intValue3 = num7.intValue();
                                                                                if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                    composer8.skipToGroupEnd();
                                                                                } else {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(762994953, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:169)");
                                                                                    }
                                                                                    i.Companion companion4 = i.INSTANCE;
                                                                                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), 4.0f, 0.0f, 4.0f, 0.0f, 10, null);
                                                                                    QQFlashTransferViewModel qQFlashTransferViewModel9 = QQFlashTransferViewModel.this;
                                                                                    boolean z19 = false;
                                                                                    QQFTCheckBoxViewKt.QQFTCheckBoxView(n3, 0.0f, (qQFlashTransferViewModel9 == null || (mutableState2 = qQFlashTransferViewModel9.isAllSelectMode) == null || !mutableState2.getValue().booleanValue()) ? false : true, null, null, false, composer8, 8, 58);
                                                                                    QQFlashTransferViewModel qQFlashTransferViewModel10 = QQFlashTransferViewModel.this;
                                                                                    if (qQFlashTransferViewModel10 != null && (snapshotStateMap2 = qQFlashTransferViewModel10.selectFilesToDownload) != null && (!snapshotStateMap2.isEmpty())) {
                                                                                        z19 = true;
                                                                                    }
                                                                                    TextKt.a("\u5168\u9009", ComposeLayoutPropUpdaterKt.n(companion4, 0.0f, 0.0f, (z19 || str29 == null) ? 16.0f : 0.0f, 0.0f, 11, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, 1601606, 0, 0, 134216612);
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer6, 196616, 26);
                                                                        QQFlashTransferViewModel qQFlashTransferViewModel9 = this.$viewModel;
                                                                        if (((qQFlashTransferViewModel9 != null ? qQFlashTransferViewModel9.selectFilesToDownload : null) == null || qQFlashTransferViewModel9.selectFilesToDownload.size() <= 0) && this.$rightBtnImagePainter != null) {
                                                                            a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                                            i A = ModifiersKt.A(nVar2.b(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), companion3.c()), 0.5f, 0.0f, 2, null);
                                                                            if (k.a(cVar)) {
                                                                                str28 = "0S200MNJT807V3GE";
                                                                            } else {
                                                                                str28 = "0M2003OIIM08YV9M";
                                                                            }
                                                                            i elementVR2 = ModifierExtKt.elementVR(A, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str28));
                                                                            final Function0<Unit> function018 = this.$onRightBtnClick;
                                                                            composer6.startReplaceableGroup(1157296644);
                                                                            boolean changed2 = composer6.changed(function018);
                                                                            Object rememberedValue2 = composer6.rememberedValue();
                                                                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                                rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$4$1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        Function0<Unit> function019 = function018;
                                                                                        if (function019 != null) {
                                                                                            function019.invoke();
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                };
                                                                                composer6.updateRememberedValue(rememberedValue2);
                                                                            }
                                                                            composer6.endReplaceableGroup();
                                                                            i d17 = ViewEventPropUpdaterKt.d(elementVR2, false, null, (Function1) rememberedValue2, 3, null);
                                                                            final String str30 = this.$rightBtnImagePainter;
                                                                            final int i78 = this.$$dirty;
                                                                            ColumnKt.a(d17, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -578852167, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.5
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(3);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                public final Unit invoke(d dVar, Composer composer7, Integer num7) {
                                                                                    Composer composer8 = composer7;
                                                                                    int intValue3 = num7.intValue();
                                                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                        composer8.skipToGroupEnd();
                                                                                    } else {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(-578852167, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:193)");
                                                                                        }
                                                                                        ImageKt.a(str30, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 20.0f, 0.0f, 16.0f, 0.0f, 10, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i78 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }), composer6, 24648, 12);
                                                                        }
                                                                        composer6.endReplaceableGroup();
                                                                    } else {
                                                                        composer6.startReplaceableGroup(-1319183568);
                                                                        composer6.startReplaceableGroup(-1319183550);
                                                                        String str31 = this.$rightTextContent;
                                                                        if (str31 != null) {
                                                                            if (str31.length() > 0) {
                                                                                z18 = true;
                                                                            }
                                                                        }
                                                                        if (z18) {
                                                                            i f26 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null);
                                                                            final Function0<Unit> function019 = this.$onRightTextClick;
                                                                            composer6.startReplaceableGroup(1157296644);
                                                                            boolean changed3 = composer6.changed(function019);
                                                                            Object rememberedValue3 = composer6.rememberedValue();
                                                                            if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                                                rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$6$1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        Function0<Unit> function020 = function019;
                                                                                        if (function020 != null) {
                                                                                            function020.invoke();
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                };
                                                                                composer6.updateRememberedValue(rememberedValue3);
                                                                            }
                                                                            composer6.endReplaceableGroup();
                                                                            i d18 = ViewEventPropUpdaterKt.d(f26, false, null, (Function1) rememberedValue3, 3, null);
                                                                            final String str32 = this.$rightTextContent;
                                                                            final int i79 = this.$$dirty;
                                                                            obj = null;
                                                                            RowKt.a(d18, null, null, null, null, ComposableLambdaKt.composableLambda(composer6, 1105722541, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.7
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(3);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                                                    int i85;
                                                                                    n nVar4 = nVar3;
                                                                                    Composer composer8 = composer7;
                                                                                    int intValue3 = num7.intValue();
                                                                                    if ((intValue3 & 14) == 0) {
                                                                                        i85 = (composer8.changed(nVar4) ? 4 : 2) | intValue3;
                                                                                    } else {
                                                                                        i85 = intValue3;
                                                                                    }
                                                                                    if ((i85 & 91) == 18 && composer8.getSkipping()) {
                                                                                        composer8.skipToGroupEnd();
                                                                                    } else {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(1105722541, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:204)");
                                                                                        }
                                                                                        h color$default = QUIToken.color$default("text_nav_secondary");
                                                                                        int a17 = ai.INSTANCE.a();
                                                                                        TextKt.a(str32, ModifiersKt.w(nVar4.b(i.INSTANCE, Alignment.INSTANCE.c()), QUIToken.color$default("overlay_standard_primary")), null, color$default, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, ai.f(a17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i79 >> 24) & 14) | 1601600, 0, 0, 134216612);
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }), composer6, 196616, 30);
                                                                        } else {
                                                                            obj = null;
                                                                        }
                                                                        composer6.endReplaceableGroup();
                                                                        if (this.$rightBtnImagePainter != null) {
                                                                            Alignment alignment = Alignment.CenterStart;
                                                                            i f27 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, obj);
                                                                            if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                                                                str25 = "0S200MNJT807V3GE";
                                                                            } else {
                                                                                str25 = "0M2003OIIM08YV9M";
                                                                            }
                                                                            i elementVR3 = ModifierExtKt.elementVR(f27, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str25));
                                                                            final Function0<Unit> function020 = this.$onRightBtnClick;
                                                                            composer6.startReplaceableGroup(1157296644);
                                                                            boolean changed4 = composer6.changed(function020);
                                                                            Object rememberedValue4 = composer6.rememberedValue();
                                                                            if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                                                rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$8$1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        Function0<Unit> function021 = function020;
                                                                                        if (function021 != null) {
                                                                                            function021.invoke();
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                };
                                                                                composer6.updateRememberedValue(rememberedValue4);
                                                                            }
                                                                            composer6.endReplaceableGroup();
                                                                            i d19 = ViewEventPropUpdaterKt.d(elementVR3, false, null, (Function1) rememberedValue4, 3, null);
                                                                            final String str33 = this.$rightBtnImagePainter;
                                                                            final int i85 = this.$$dirty;
                                                                            BoxKt.a(d19, alignment, null, ComposableLambdaKt.composableLambda(composer6, 1487136136, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.9
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(3);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                public final Unit invoke(b bVar4, Composer composer7, Integer num7) {
                                                                                    Composer composer8 = composer7;
                                                                                    int intValue3 = num7.intValue();
                                                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                        composer8.skipToGroupEnd();
                                                                                    } else {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(1487136136, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:223)");
                                                                                        }
                                                                                        ImageKt.a(str33, null, null, null, null, ModifiersKt.A(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 12.0f, 0.0f, 16.0f, 0.0f, 10, null), 0.5f, 0.0f, 2, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i85 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }), composer6, 3128, 4);
                                                                        }
                                                                        composer6.endReplaceableGroup();
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer4, 196680, 24);
                                                        if (Intrinsics.areEqual(bool7, Boolean.TRUE)) {
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer2, 3080, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            qQFlashTransferViewModel3 = qQFlashTransferViewModel2;
                                            str14 = str7;
                                            hVar3 = hVar2;
                                            str15 = str8;
                                            str16 = str11;
                                            num3 = num2;
                                            str17 = str9;
                                            function09 = function06;
                                            bool5 = bool4;
                                            bool6 = bool3;
                                            function010 = function013;
                                            function011 = function07;
                                            f18 = f17;
                                            function012 = function05;
                                            str18 = str19;
                                        }
                                    } else {
                                        QQFlashTransferViewModel qQFlashTransferViewModel5 = i59 != 0 ? null : qQFlashTransferViewModel;
                                        if (i66 != 0) {
                                            hVar2 = QUIToken.color$default("bg_nav_secondary");
                                            i65 &= -113;
                                        } else {
                                            hVar2 = hVar;
                                        }
                                        if ((i17 & 4) != 0) {
                                            qQFlashTransferViewModel = qQFlashTransferViewModel5;
                                            str7 = QUIToken.INSTANCE.image("chevron_left", QUIToken.color$default("icon_nav_secondary"));
                                            i65 &= -897;
                                        } else {
                                            qQFlashTransferViewModel = qQFlashTransferViewModel5;
                                            str7 = str;
                                        }
                                        str8 = i67 != 0 ? null : str2;
                                        num2 = i18 != 0 ? 0 : num;
                                        str9 = i19 != 0 ? "" : str3;
                                        str10 = i26 != 0 ? null : str4;
                                        str11 = i27 != 0 ? null : str5;
                                        String str25 = i28 != 0 ? null : str6;
                                        Function0<Unit> function017 = i29 != 0 ? null : function0;
                                        Function0<Unit> function018 = i36 != 0 ? null : function02;
                                        Function0<Unit> function019 = i38 != 0 ? null : function03;
                                        function05 = i46 != 0 ? null : function04;
                                        bool3 = i48 != 0 ? null : bool;
                                        Boolean bool9 = i56 != 0 ? null : bool2;
                                        f17 = i57 != 0 ? 10.0f : f16;
                                        bool4 = bool9;
                                        function06 = function019;
                                        function07 = function018;
                                        function08 = function017;
                                        str12 = str25;
                                    }
                                    qQFlashTransferViewModel2 = qQFlashTransferViewModel;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    com.tencent.ntcompose.ui.platform.a aVar2 = (com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d());
                                    final Function0<Unit> function0132 = function08;
                                    final String str192 = str10;
                                    final QQFlashTransferViewModel qQFlashTransferViewModel42 = qQFlashTransferViewModel2;
                                    final Boolean bool72 = bool4;
                                    final Integer num42 = num2;
                                    final String str202 = str8;
                                    final Function0<Unit> function0142 = function06;
                                    final Function0<Unit> function0152 = function07;
                                    final int i692 = i65;
                                    final int i752 = i68;
                                    final String str212 = str9;
                                    final String str222 = str11;
                                    final String str232 = str7;
                                    final Boolean bool82 = bool3;
                                    final Function0<Unit> function0162 = function05;
                                    final String str242 = str13;
                                    composer2 = startRestartGroup;
                                    BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), hVar2), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar2)), 0.0f, aVar2.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(composer2, 1894388531, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
                                        /* JADX WARN: Removed duplicated region for block: B:29:0x0140  */
                                        /* JADX WARN: Removed duplicated region for block: B:32:0x0171  */
                                        /* JADX WARN: Removed duplicated region for block: B:33:0x00e0  */
                                        /* JADX WARN: Type inference failed for: r2v20 */
                                        /* JADX WARN: Type inference failed for: r2v21 */
                                        /* JADX WARN: Type inference failed for: r2v7, types: [int, boolean] */
                                        @Override // kotlin.jvm.functions.Function3
                                        /*
                                            Code decompiled incorrectly, please refer to instructions dump.
                                        */
                                        public final Unit invoke(b bVar, Composer composer3, Integer num5) {
                                            int i76;
                                            boolean z16;
                                            boolean z17;
                                            ?? r26;
                                            b bVar2;
                                            SnapshotStateMap<String, ab> snapshotStateMap;
                                            b bVar3 = bVar;
                                            Composer composer4 = composer3;
                                            int intValue = num5.intValue();
                                            if ((intValue & 14) == 0) {
                                                i76 = (composer4.changed(bVar3) ? 4 : 2) | intValue;
                                            } else {
                                                i76 = intValue;
                                            }
                                            if ((i76 & 91) == 18 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1894388531, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous> (QQFTNavBar.kt:69)");
                                                }
                                                i.Companion companion = i.INSTANCE;
                                                RowKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterStart), null, null, null, null, ComposableLambdaKt.composableLambda(composer4, 1884949333, true, new Function3<n, Composer, Integer, Unit>(num42, QQFlashTransferViewModel.this, str202, function0142, function0152, i692, i752, str212, str222, str232, str192) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.1
                                                    public final /* synthetic */ int $$dirty;
                                                    public final /* synthetic */ String $leftBtnImagePainter;
                                                    public final /* synthetic */ String $leftTextContent;
                                                    public final /* synthetic */ Integer $modalMode;
                                                    public final /* synthetic */ String $navImagePainter;
                                                    public final /* synthetic */ String $navTitle;
                                                    public final /* synthetic */ Function0<Unit> $onLeftBtnClick;
                                                    public final /* synthetic */ Function0<Unit> $onLeftTextClick;
                                                    public final /* synthetic */ String $rightBtnImagePainter;
                                                    public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                        this.$navTitle = r8;
                                                        this.$rightBtnImagePainter = r9;
                                                        this.$leftBtnImagePainter = r10;
                                                        this.$navImagePainter = r11;
                                                    }

                                                    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
                                                    
                                                        if (((r1 == null || r1.isSecondaryPage()) ? false : true) == false) goto L23;
                                                     */
                                                    /* JADX WARN: Code restructure failed: missing block: B:39:0x0118, code lost:
                                                    
                                                        if ((r23.$navTitle.length() > 0) == false) goto L54;
                                                     */
                                                    /* JADX WARN: Removed duplicated region for block: B:26:0x00b7  */
                                                    /* JADX WARN: Removed duplicated region for block: B:30:0x00fd  */
                                                    /* JADX WARN: Removed duplicated region for block: B:36:0x010e  */
                                                    /* JADX WARN: Removed duplicated region for block: B:42:0x0163  */
                                                    /* JADX WARN: Removed duplicated region for block: B:55:0x007b  */
                                                    @Override // kotlin.jvm.functions.Function3
                                                    /*
                                                        Code decompiled incorrectly, please refer to instructions dump.
                                                    */
                                                    public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                                                        boolean z18;
                                                        float f19;
                                                        boolean changed;
                                                        Object rememberedValue;
                                                        QQFlashTransferViewModel qQFlashTransferViewModel52;
                                                        SnapshotStateMap<String, ab> snapshotStateMap2;
                                                        Composer composer6 = composer5;
                                                        int intValue2 = num6.intValue();
                                                        if ((intValue2 & 81) == 16 && composer6.getSkipping()) {
                                                            composer6.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1884949333, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:70)");
                                                            }
                                                            com.tencent.ntcompose.foundation.layout.base.a aVar22 = com.tencent.ntcompose.foundation.layout.base.a.f339245a;
                                                            a.e b16 = aVar22.b();
                                                            i.Companion companion2 = i.INSTANCE;
                                                            i f26 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                                            Integer num7 = this.$modalMode;
                                                            if (num7 != null && num7.intValue() == 1) {
                                                                QQFlashTransferViewModel qQFlashTransferViewModel6 = this.$viewModel;
                                                            }
                                                            String str252 = this.$leftTextContent;
                                                            if (str252 != null) {
                                                                if (str252.length() > 0) {
                                                                    z18 = true;
                                                                    if (!z18) {
                                                                        f19 = 10.0f;
                                                                        i a1622 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                                                        final String str2622 = this.$leftTextContent;
                                                                        final Function0<Unit> function01722 = this.$onLeftTextClick;
                                                                        final Function0<Unit> function01822 = this.$onLeftBtnClick;
                                                                        composer6.startReplaceableGroup(1618982084);
                                                                        changed = composer6.changed(str2622) | composer6.changed(function01722) | composer6.changed(function01822);
                                                                        rememberedValue = composer6.rememberedValue();
                                                                        if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ClickParams clickParams) {
                                                                                    String str2722 = str2622;
                                                                                    boolean z19 = false;
                                                                                    if (str2722 != null) {
                                                                                        if (str2722.length() > 0) {
                                                                                            z19 = true;
                                                                                        }
                                                                                    }
                                                                                    if (z19) {
                                                                                        Function0<Unit> function0192 = function01722;
                                                                                        if (function0192 != null) {
                                                                                            function0192.invoke();
                                                                                        }
                                                                                    } else {
                                                                                        Function0<Unit> function020 = function01822;
                                                                                        if (function020 != null) {
                                                                                            function020.invoke();
                                                                                        } else {
                                                                                            QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            };
                                                                            composer6.updateRememberedValue(rememberedValue);
                                                                        }
                                                                        composer6.endReplaceableGroup();
                                                                        i A22 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a1622, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                                                        final String str2722 = this.$leftTextContent;
                                                                        final int i7722 = this.$$dirty;
                                                                        final String str2822 = this.$leftBtnImagePainter;
                                                                        ColumnKt.a(A22, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                                Composer composer8 = composer7;
                                                                                int intValue3 = num8.intValue();
                                                                                if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                    composer8.skipToGroupEnd();
                                                                                } else {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                                                    }
                                                                                    String str2922 = str2722;
                                                                                    boolean z19 = false;
                                                                                    if (str2922 != null) {
                                                                                        if (str2922.length() > 0) {
                                                                                            z19 = true;
                                                                                        }
                                                                                    }
                                                                                    if (z19) {
                                                                                        composer8.startReplaceableGroup(2107916874);
                                                                                        TextKt.a(str2722, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i7722 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                                                        composer8.endReplaceableGroup();
                                                                                    } else {
                                                                                        composer8.startReplaceableGroup(2107917260);
                                                                                        ImageKt.a(str2822, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i7722 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                                                        composer8.endReplaceableGroup();
                                                                                    }
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer6, 24648, 12);
                                                                        qQFlashTransferViewModel52 = this.$viewModel;
                                                                        if (qQFlashTransferViewModel52 == null && (snapshotStateMap2 = qQFlashTransferViewModel52.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                                                        }
                                                                        i n362 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                                        a.e b1722 = aVar22.b();
                                                                        final QQFlashTransferViewModel qQFlashTransferViewModel722 = this.$viewModel;
                                                                        final String str2922 = this.$navTitle;
                                                                        final String str3022 = this.$rightBtnImagePainter;
                                                                        final String str3122 = this.$navImagePainter;
                                                                        final int i7822 = this.$$dirty;
                                                                        ColumnKt.a(n362, b1722, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                                Composer composer8 = composer7;
                                                                                int intValue3 = num8.intValue();
                                                                                if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                    composer8.skipToGroupEnd();
                                                                                } else {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                                                    }
                                                                                    i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                                                    final String str32 = str3122;
                                                                                    final int i79 = i7822;
                                                                                    final String str33 = str2922;
                                                                                    RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(3);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function3
                                                                                        public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                                                            int i85;
                                                                                            Composer composer10;
                                                                                            Map mutableMapOf;
                                                                                            n nVar3 = nVar2;
                                                                                            Composer composer11 = composer9;
                                                                                            int intValue4 = num9.intValue();
                                                                                            if ((intValue4 & 14) == 0) {
                                                                                                i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                                                            } else {
                                                                                                i85 = intValue4;
                                                                                            }
                                                                                            if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                                                                composer11.skipToGroupEnd();
                                                                                            } else {
                                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                                    ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                                                                }
                                                                                                composer11.startReplaceableGroup(-1116923971);
                                                                                                if (str32 != null) {
                                                                                                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                                                    composer10 = composer11;
                                                                                                    ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                                                                } else {
                                                                                                    composer10 = composer11;
                                                                                                }
                                                                                                composer10.endReplaceableGroup();
                                                                                                TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                                    ComposerKt.traceEventEnd();
                                                                                                }
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    }), composer8, 196616, 30);
                                                                                    if (QQFlashTransferViewModel.this != null) {
                                                                                        if (str2922.length() > 0) {
                                                                                            QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str3022), true, composer8, 25142, 0);
                                                                                        }
                                                                                    }
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer6, 24648, 12);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    f19 = 16.0f;
                                                                    i a16222 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                                                    final String str26222 = this.$leftTextContent;
                                                                    final Function0<Unit> function017222 = this.$onLeftTextClick;
                                                                    final Function0<Unit> function018222 = this.$onLeftBtnClick;
                                                                    composer6.startReplaceableGroup(1618982084);
                                                                    changed = composer6.changed(str26222) | composer6.changed(function017222) | composer6.changed(function018222);
                                                                    rememberedValue = composer6.rememberedValue();
                                                                    if (!changed) {
                                                                    }
                                                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            String str27222 = str26222;
                                                                            boolean z19 = false;
                                                                            if (str27222 != null) {
                                                                                if (str27222.length() > 0) {
                                                                                    z19 = true;
                                                                                }
                                                                            }
                                                                            if (z19) {
                                                                                Function0<Unit> function0192 = function017222;
                                                                                if (function0192 != null) {
                                                                                    function0192.invoke();
                                                                                }
                                                                            } else {
                                                                                Function0<Unit> function020 = function018222;
                                                                                if (function020 != null) {
                                                                                    function020.invoke();
                                                                                } else {
                                                                                    QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    };
                                                                    composer6.updateRememberedValue(rememberedValue);
                                                                    composer6.endReplaceableGroup();
                                                                    i A222 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a16222, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                                                    final String str27222 = this.$leftTextContent;
                                                                    final int i77222 = this.$$dirty;
                                                                    final String str28222 = this.$leftBtnImagePainter;
                                                                    ColumnKt.a(A222, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                            Composer composer8 = composer7;
                                                                            int intValue3 = num8.intValue();
                                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                composer8.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                                                }
                                                                                String str29222 = str27222;
                                                                                boolean z19 = false;
                                                                                if (str29222 != null) {
                                                                                    if (str29222.length() > 0) {
                                                                                        z19 = true;
                                                                                    }
                                                                                }
                                                                                if (z19) {
                                                                                    composer8.startReplaceableGroup(2107916874);
                                                                                    TextKt.a(str27222, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i77222 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                                                    composer8.endReplaceableGroup();
                                                                                } else {
                                                                                    composer8.startReplaceableGroup(2107917260);
                                                                                    ImageKt.a(str28222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i77222 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                                                    composer8.endReplaceableGroup();
                                                                                }
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer6, 24648, 12);
                                                                    qQFlashTransferViewModel52 = this.$viewModel;
                                                                    if (qQFlashTransferViewModel52 == null && (snapshotStateMap2 = qQFlashTransferViewModel52.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                                                    }
                                                                    i n3622 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                                    a.e b17222 = aVar22.b();
                                                                    final QQFlashTransferViewModel qQFlashTransferViewModel7222 = this.$viewModel;
                                                                    final String str29222 = this.$navTitle;
                                                                    final String str30222 = this.$rightBtnImagePainter;
                                                                    final String str31222 = this.$navImagePainter;
                                                                    final int i78222 = this.$$dirty;
                                                                    ColumnKt.a(n3622, b17222, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                            Composer composer8 = composer7;
                                                                            int intValue3 = num8.intValue();
                                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                composer8.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                                                }
                                                                                i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                                                final String str32 = str31222;
                                                                                final int i79 = i78222;
                                                                                final String str33 = str29222;
                                                                                RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(3);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function3
                                                                                    public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                                                        int i85;
                                                                                        Composer composer10;
                                                                                        Map mutableMapOf;
                                                                                        n nVar3 = nVar2;
                                                                                        Composer composer11 = composer9;
                                                                                        int intValue4 = num9.intValue();
                                                                                        if ((intValue4 & 14) == 0) {
                                                                                            i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                                                        } else {
                                                                                            i85 = intValue4;
                                                                                        }
                                                                                        if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                                                            composer11.skipToGroupEnd();
                                                                                        } else {
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                                                            }
                                                                                            composer11.startReplaceableGroup(-1116923971);
                                                                                            if (str32 != null) {
                                                                                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                                                composer10 = composer11;
                                                                                                ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                                                            } else {
                                                                                                composer10 = composer11;
                                                                                            }
                                                                                            composer10.endReplaceableGroup();
                                                                                            TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventEnd();
                                                                                            }
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                }), composer8, 196616, 30);
                                                                                if (QQFlashTransferViewModel.this != null) {
                                                                                    if (str29222.length() > 0) {
                                                                                        QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str30222), true, composer8, 25142, 0);
                                                                                    }
                                                                                }
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer6, 24648, 12);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                    }
                                                                }
                                                            }
                                                            z18 = false;
                                                            if (!z18) {
                                                            }
                                                            f19 = 16.0f;
                                                            i a162222 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                                            final String str262222 = this.$leftTextContent;
                                                            final Function0<Unit> function0172222 = this.$onLeftTextClick;
                                                            final Function0<Unit> function0182222 = this.$onLeftBtnClick;
                                                            composer6.startReplaceableGroup(1618982084);
                                                            changed = composer6.changed(str262222) | composer6.changed(function0172222) | composer6.changed(function0182222);
                                                            rememberedValue = composer6.rememberedValue();
                                                            if (!changed) {
                                                            }
                                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    String str272222 = str262222;
                                                                    boolean z19 = false;
                                                                    if (str272222 != null) {
                                                                        if (str272222.length() > 0) {
                                                                            z19 = true;
                                                                        }
                                                                    }
                                                                    if (z19) {
                                                                        Function0<Unit> function0192 = function0172222;
                                                                        if (function0192 != null) {
                                                                            function0192.invoke();
                                                                        }
                                                                    } else {
                                                                        Function0<Unit> function020 = function0182222;
                                                                        if (function020 != null) {
                                                                            function020.invoke();
                                                                        } else {
                                                                            QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            composer6.updateRememberedValue(rememberedValue);
                                                            composer6.endReplaceableGroup();
                                                            i A2222 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a162222, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                                            final String str272222 = this.$leftTextContent;
                                                            final int i772222 = this.$$dirty;
                                                            final String str282222 = this.$leftBtnImagePainter;
                                                            ColumnKt.a(A2222, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                    Composer composer8 = composer7;
                                                                    int intValue3 = num8.intValue();
                                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                        composer8.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                                        }
                                                                        String str292222 = str272222;
                                                                        boolean z19 = false;
                                                                        if (str292222 != null) {
                                                                            if (str292222.length() > 0) {
                                                                                z19 = true;
                                                                            }
                                                                        }
                                                                        if (z19) {
                                                                            composer8.startReplaceableGroup(2107916874);
                                                                            TextKt.a(str272222, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i772222 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                                            composer8.endReplaceableGroup();
                                                                        } else {
                                                                            composer8.startReplaceableGroup(2107917260);
                                                                            ImageKt.a(str282222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i772222 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                                            composer8.endReplaceableGroup();
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer6, 24648, 12);
                                                            qQFlashTransferViewModel52 = this.$viewModel;
                                                            if (qQFlashTransferViewModel52 == null && (snapshotStateMap2 = qQFlashTransferViewModel52.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                                            }
                                                            i n36222 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                            a.e b172222 = aVar22.b();
                                                            final QQFlashTransferViewModel qQFlashTransferViewModel72222 = this.$viewModel;
                                                            final String str292222 = this.$navTitle;
                                                            final String str302222 = this.$rightBtnImagePainter;
                                                            final String str312222 = this.$navImagePainter;
                                                            final int i782222 = this.$$dirty;
                                                            ColumnKt.a(n36222, b172222, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                    Composer composer8 = composer7;
                                                                    int intValue3 = num8.intValue();
                                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                        composer8.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                                        }
                                                                        i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                                        final String str32 = str312222;
                                                                        final int i79 = i782222;
                                                                        final String str33 = str292222;
                                                                        RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                                                int i85;
                                                                                Composer composer10;
                                                                                Map mutableMapOf;
                                                                                n nVar3 = nVar2;
                                                                                Composer composer11 = composer9;
                                                                                int intValue4 = num9.intValue();
                                                                                if ((intValue4 & 14) == 0) {
                                                                                    i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                                                } else {
                                                                                    i85 = intValue4;
                                                                                }
                                                                                if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                                                    composer11.skipToGroupEnd();
                                                                                } else {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                                                    }
                                                                                    composer11.startReplaceableGroup(-1116923971);
                                                                                    if (str32 != null) {
                                                                                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                                        composer10 = composer11;
                                                                                        ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                                                    } else {
                                                                                        composer10 = composer11;
                                                                                    }
                                                                                    composer10.endReplaceableGroup();
                                                                                    TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer8, 196616, 30);
                                                                        if (QQFlashTransferViewModel.this != null) {
                                                                            if (str292222.length() > 0) {
                                                                                QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str302222), true, composer8, 25142, 0);
                                                                            }
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer6, 24648, 12);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer4, 196616, 30);
                                                composer4.startReplaceableGroup(-1240831040);
                                                QQFlashTransferViewModel qQFlashTransferViewModel52 = QQFlashTransferViewModel.this;
                                                if (qQFlashTransferViewModel52 == null || (snapshotStateMap = qQFlashTransferViewModel52.selectFilesToDownload) == null) {
                                                    z16 = true;
                                                } else {
                                                    z16 = true;
                                                    r26 = 1;
                                                    if (!snapshotStateMap.isEmpty()) {
                                                        z17 = true;
                                                        if (z17) {
                                                            bVar2 = bVar3;
                                                        } else {
                                                            bVar2 = bVar3;
                                                            i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, r26, null), Alignment.Center);
                                                            final QQFlashTransferViewModel qQFlashTransferViewModel6 = QQFlashTransferViewModel.this;
                                                            BoxKt.a(a16, null, null, ComposableLambdaKt.composableLambda(composer4, -408684780, r26, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.2
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(b bVar4, Composer composer5, Integer num6) {
                                                                    int i77;
                                                                    b bVar5 = bVar4;
                                                                    Composer composer6 = composer5;
                                                                    int intValue2 = num6.intValue();
                                                                    if ((intValue2 & 14) == 0) {
                                                                        i77 = (composer6.changed(bVar5) ? 4 : 2) | intValue2;
                                                                    } else {
                                                                        i77 = intValue2;
                                                                    }
                                                                    if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                                                        composer6.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-408684780, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:145)");
                                                                        }
                                                                        QQFTDownloadBarViewKt.selectFileInfoStrView(bVar5.a(i.INSTANCE, Alignment.Center), QQFlashTransferViewModel.this, composer6, 72);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer4, 3080, 6);
                                                        }
                                                        composer4.endReplaceableGroup();
                                                        RowKt.a(ComposeLayoutPropUpdaterKt.f(bVar2.a(companion, Alignment.CenterEnd), 0.0f, 1, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.c(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer4, 83640332, true, new Function3<n, Composer, Integer, Unit>(bool82, function0132, i752, i692, QQFlashTransferViewModel.this, str222, function0162, str242) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.3
                                                            public final /* synthetic */ int $$dirty;
                                                            public final /* synthetic */ Function0<Unit> $onRightBtnClick;
                                                            public final /* synthetic */ Function0<Unit> $onRightTextClick;
                                                            public final /* synthetic */ String $rightBtnImagePainter;
                                                            public final /* synthetic */ String $rightTextContent;
                                                            public final /* synthetic */ Boolean $showCheckBox;
                                                            public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                                this.$$dirty = r4;
                                                                this.$viewModel = r5;
                                                                this.$rightBtnImagePainter = r6;
                                                                this.$onRightBtnClick = r7;
                                                                this.$rightTextContent = r8;
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                                                                int i77;
                                                                Object obj;
                                                                String str252;
                                                                String str26;
                                                                String str27;
                                                                String str28;
                                                                MutableState<Boolean> mutableState;
                                                                n nVar2 = nVar;
                                                                Composer composer6 = composer5;
                                                                int intValue2 = num6.intValue();
                                                                if ((intValue2 & 14) == 0) {
                                                                    i77 = (composer6.changed(nVar2) ? 4 : 2) | intValue2;
                                                                } else {
                                                                    i77 = intValue2;
                                                                }
                                                                if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                                                    composer6.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(83640332, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:158)");
                                                                    }
                                                                    boolean z18 = false;
                                                                    if (Intrinsics.areEqual(this.$showCheckBox, Boolean.TRUE)) {
                                                                        composer6.startReplaceableGroup(-1319185738);
                                                                        i.Companion companion2 = i.INSTANCE;
                                                                        i f19 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                                                        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                                                        if (k.a(cVar)) {
                                                                            str26 = "0S200MNJT807V3GE";
                                                                        } else {
                                                                            str26 = "0M2003OIIM08YV9M";
                                                                        }
                                                                        e dTBaseParams = DTReportConstKt.getDTBaseParams(str26);
                                                                        QQFlashTransferViewModel qQFlashTransferViewModel7 = this.$viewModel;
                                                                        if (qQFlashTransferViewModel7 != null && (mutableState = qQFlashTransferViewModel7.isAllSelectMode) != null && mutableState.getValue().booleanValue()) {
                                                                            z18 = true;
                                                                        }
                                                                        if (z18) {
                                                                            str27 = "1";
                                                                        } else {
                                                                            str27 = "0";
                                                                        }
                                                                        dTBaseParams.v("is_screen", str27);
                                                                        Unit unit = Unit.INSTANCE;
                                                                        i elementVR = ModifierExtKt.elementVR(f19, "em_bas_select_all", dTBaseParams);
                                                                        final Boolean bool92 = this.$showCheckBox;
                                                                        final Function0<Unit> function0172 = this.$onRightTextClick;
                                                                        composer6.startReplaceableGroup(511388516);
                                                                        boolean changed = composer6.changed(bool92) | composer6.changed(function0172);
                                                                        Object rememberedValue = composer6.rememberedValue();
                                                                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$2$1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ClickParams clickParams) {
                                                                                    Function0<Unit> function0182;
                                                                                    if (Intrinsics.areEqual(bool92, Boolean.TRUE) && (function0182 = function0172) != null) {
                                                                                        function0182.invoke();
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            };
                                                                            composer6.updateRememberedValue(rememberedValue);
                                                                        }
                                                                        composer6.endReplaceableGroup();
                                                                        i d16 = ViewEventPropUpdaterKt.d(elementVR, false, null, (Function1) rememberedValue, 3, null);
                                                                        Alignment.Companion companion3 = Alignment.INSTANCE;
                                                                        Alignment.Vertical c16 = companion3.c();
                                                                        final QQFlashTransferViewModel qQFlashTransferViewModel8 = this.$viewModel;
                                                                        final String str29 = this.$rightBtnImagePainter;
                                                                        RowKt.a(d16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer6, 762994953, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.3
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                                                SnapshotStateMap<String, ab> snapshotStateMap2;
                                                                                MutableState<Boolean> mutableState2;
                                                                                Composer composer8 = composer7;
                                                                                int intValue3 = num7.intValue();
                                                                                if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                    composer8.skipToGroupEnd();
                                                                                } else {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(762994953, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:169)");
                                                                                    }
                                                                                    i.Companion companion4 = i.INSTANCE;
                                                                                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), 4.0f, 0.0f, 4.0f, 0.0f, 10, null);
                                                                                    QQFlashTransferViewModel qQFlashTransferViewModel9 = QQFlashTransferViewModel.this;
                                                                                    boolean z19 = false;
                                                                                    QQFTCheckBoxViewKt.QQFTCheckBoxView(n3, 0.0f, (qQFlashTransferViewModel9 == null || (mutableState2 = qQFlashTransferViewModel9.isAllSelectMode) == null || !mutableState2.getValue().booleanValue()) ? false : true, null, null, false, composer8, 8, 58);
                                                                                    QQFlashTransferViewModel qQFlashTransferViewModel10 = QQFlashTransferViewModel.this;
                                                                                    if (qQFlashTransferViewModel10 != null && (snapshotStateMap2 = qQFlashTransferViewModel10.selectFilesToDownload) != null && (!snapshotStateMap2.isEmpty())) {
                                                                                        z19 = true;
                                                                                    }
                                                                                    TextKt.a("\u5168\u9009", ComposeLayoutPropUpdaterKt.n(companion4, 0.0f, 0.0f, (z19 || str29 == null) ? 16.0f : 0.0f, 0.0f, 11, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, 1601606, 0, 0, 134216612);
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer6, 196616, 26);
                                                                        QQFlashTransferViewModel qQFlashTransferViewModel9 = this.$viewModel;
                                                                        if (((qQFlashTransferViewModel9 != null ? qQFlashTransferViewModel9.selectFilesToDownload : null) == null || qQFlashTransferViewModel9.selectFilesToDownload.size() <= 0) && this.$rightBtnImagePainter != null) {
                                                                            a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                                            i A = ModifiersKt.A(nVar2.b(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), companion3.c()), 0.5f, 0.0f, 2, null);
                                                                            if (k.a(cVar)) {
                                                                                str28 = "0S200MNJT807V3GE";
                                                                            } else {
                                                                                str28 = "0M2003OIIM08YV9M";
                                                                            }
                                                                            i elementVR2 = ModifierExtKt.elementVR(A, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str28));
                                                                            final Function0<Unit> function0182 = this.$onRightBtnClick;
                                                                            composer6.startReplaceableGroup(1157296644);
                                                                            boolean changed2 = composer6.changed(function0182);
                                                                            Object rememberedValue2 = composer6.rememberedValue();
                                                                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                                rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$4$1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        Function0<Unit> function0192 = function0182;
                                                                                        if (function0192 != null) {
                                                                                            function0192.invoke();
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                };
                                                                                composer6.updateRememberedValue(rememberedValue2);
                                                                            }
                                                                            composer6.endReplaceableGroup();
                                                                            i d17 = ViewEventPropUpdaterKt.d(elementVR2, false, null, (Function1) rememberedValue2, 3, null);
                                                                            final String str30 = this.$rightBtnImagePainter;
                                                                            final int i78 = this.$$dirty;
                                                                            ColumnKt.a(d17, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -578852167, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.5
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(3);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                public final Unit invoke(d dVar, Composer composer7, Integer num7) {
                                                                                    Composer composer8 = composer7;
                                                                                    int intValue3 = num7.intValue();
                                                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                        composer8.skipToGroupEnd();
                                                                                    } else {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(-578852167, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:193)");
                                                                                        }
                                                                                        ImageKt.a(str30, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 20.0f, 0.0f, 16.0f, 0.0f, 10, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i78 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }), composer6, 24648, 12);
                                                                        }
                                                                        composer6.endReplaceableGroup();
                                                                    } else {
                                                                        composer6.startReplaceableGroup(-1319183568);
                                                                        composer6.startReplaceableGroup(-1319183550);
                                                                        String str31 = this.$rightTextContent;
                                                                        if (str31 != null) {
                                                                            if (str31.length() > 0) {
                                                                                z18 = true;
                                                                            }
                                                                        }
                                                                        if (z18) {
                                                                            i f26 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null);
                                                                            final Function0<Unit> function0192 = this.$onRightTextClick;
                                                                            composer6.startReplaceableGroup(1157296644);
                                                                            boolean changed3 = composer6.changed(function0192);
                                                                            Object rememberedValue3 = composer6.rememberedValue();
                                                                            if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                                                rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$6$1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        Function0<Unit> function020 = function0192;
                                                                                        if (function020 != null) {
                                                                                            function020.invoke();
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                };
                                                                                composer6.updateRememberedValue(rememberedValue3);
                                                                            }
                                                                            composer6.endReplaceableGroup();
                                                                            i d18 = ViewEventPropUpdaterKt.d(f26, false, null, (Function1) rememberedValue3, 3, null);
                                                                            final String str32 = this.$rightTextContent;
                                                                            final int i79 = this.$$dirty;
                                                                            obj = null;
                                                                            RowKt.a(d18, null, null, null, null, ComposableLambdaKt.composableLambda(composer6, 1105722541, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.7
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(3);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                                                    int i85;
                                                                                    n nVar4 = nVar3;
                                                                                    Composer composer8 = composer7;
                                                                                    int intValue3 = num7.intValue();
                                                                                    if ((intValue3 & 14) == 0) {
                                                                                        i85 = (composer8.changed(nVar4) ? 4 : 2) | intValue3;
                                                                                    } else {
                                                                                        i85 = intValue3;
                                                                                    }
                                                                                    if ((i85 & 91) == 18 && composer8.getSkipping()) {
                                                                                        composer8.skipToGroupEnd();
                                                                                    } else {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(1105722541, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:204)");
                                                                                        }
                                                                                        h color$default = QUIToken.color$default("text_nav_secondary");
                                                                                        int a17 = ai.INSTANCE.a();
                                                                                        TextKt.a(str32, ModifiersKt.w(nVar4.b(i.INSTANCE, Alignment.INSTANCE.c()), QUIToken.color$default("overlay_standard_primary")), null, color$default, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, ai.f(a17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i79 >> 24) & 14) | 1601600, 0, 0, 134216612);
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }), composer6, 196616, 30);
                                                                        } else {
                                                                            obj = null;
                                                                        }
                                                                        composer6.endReplaceableGroup();
                                                                        if (this.$rightBtnImagePainter != null) {
                                                                            Alignment alignment = Alignment.CenterStart;
                                                                            i f27 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, obj);
                                                                            if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                                                                str252 = "0S200MNJT807V3GE";
                                                                            } else {
                                                                                str252 = "0M2003OIIM08YV9M";
                                                                            }
                                                                            i elementVR3 = ModifierExtKt.elementVR(f27, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str252));
                                                                            final Function0<Unit> function020 = this.$onRightBtnClick;
                                                                            composer6.startReplaceableGroup(1157296644);
                                                                            boolean changed4 = composer6.changed(function020);
                                                                            Object rememberedValue4 = composer6.rememberedValue();
                                                                            if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                                                rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$8$1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        Function0<Unit> function021 = function020;
                                                                                        if (function021 != null) {
                                                                                            function021.invoke();
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                };
                                                                                composer6.updateRememberedValue(rememberedValue4);
                                                                            }
                                                                            composer6.endReplaceableGroup();
                                                                            i d19 = ViewEventPropUpdaterKt.d(elementVR3, false, null, (Function1) rememberedValue4, 3, null);
                                                                            final String str33 = this.$rightBtnImagePainter;
                                                                            final int i85 = this.$$dirty;
                                                                            BoxKt.a(d19, alignment, null, ComposableLambdaKt.composableLambda(composer6, 1487136136, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.9
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(3);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                public final Unit invoke(b bVar4, Composer composer7, Integer num7) {
                                                                                    Composer composer8 = composer7;
                                                                                    int intValue3 = num7.intValue();
                                                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                        composer8.skipToGroupEnd();
                                                                                    } else {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(1487136136, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:223)");
                                                                                        }
                                                                                        ImageKt.a(str33, null, null, null, null, ModifiersKt.A(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 12.0f, 0.0f, 16.0f, 0.0f, 10, null), 0.5f, 0.0f, 2, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i85 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }), composer6, 3128, 4);
                                                                        }
                                                                        composer6.endReplaceableGroup();
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer4, 196680, 24);
                                                        if (Intrinsics.areEqual(bool72, Boolean.TRUE)) {
                                                            SurfaceKt.a(ModifiersKt.c(bVar2.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 0.5f), Alignment.BottomCenter), QUIToken.color$default("border_light")), null, null, null, ComposableSingletons$QQFTNavBarKt.f144lambda1, composer4, 24584, 14);
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }
                                                z17 = false;
                                                r26 = z16;
                                                if (z17) {
                                                }
                                                composer4.endReplaceableGroup();
                                                RowKt.a(ComposeLayoutPropUpdaterKt.f(bVar2.a(companion, Alignment.CenterEnd), 0.0f, 1, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.c(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer4, 83640332, true, new Function3<n, Composer, Integer, Unit>(bool82, function0132, i752, i692, QQFlashTransferViewModel.this, str222, function0162, str242) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.3
                                                    public final /* synthetic */ int $$dirty;
                                                    public final /* synthetic */ Function0<Unit> $onRightBtnClick;
                                                    public final /* synthetic */ Function0<Unit> $onRightTextClick;
                                                    public final /* synthetic */ String $rightBtnImagePainter;
                                                    public final /* synthetic */ String $rightTextContent;
                                                    public final /* synthetic */ Boolean $showCheckBox;
                                                    public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                        this.$$dirty = r4;
                                                        this.$viewModel = r5;
                                                        this.$rightBtnImagePainter = r6;
                                                        this.$onRightBtnClick = r7;
                                                        this.$rightTextContent = r8;
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                                                        int i77;
                                                        Object obj;
                                                        String str252;
                                                        String str26;
                                                        String str27;
                                                        String str28;
                                                        MutableState<Boolean> mutableState;
                                                        n nVar2 = nVar;
                                                        Composer composer6 = composer5;
                                                        int intValue2 = num6.intValue();
                                                        if ((intValue2 & 14) == 0) {
                                                            i77 = (composer6.changed(nVar2) ? 4 : 2) | intValue2;
                                                        } else {
                                                            i77 = intValue2;
                                                        }
                                                        if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                                            composer6.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(83640332, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:158)");
                                                            }
                                                            boolean z18 = false;
                                                            if (Intrinsics.areEqual(this.$showCheckBox, Boolean.TRUE)) {
                                                                composer6.startReplaceableGroup(-1319185738);
                                                                i.Companion companion2 = i.INSTANCE;
                                                                i f19 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                                                com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                                                if (k.a(cVar)) {
                                                                    str26 = "0S200MNJT807V3GE";
                                                                } else {
                                                                    str26 = "0M2003OIIM08YV9M";
                                                                }
                                                                e dTBaseParams = DTReportConstKt.getDTBaseParams(str26);
                                                                QQFlashTransferViewModel qQFlashTransferViewModel7 = this.$viewModel;
                                                                if (qQFlashTransferViewModel7 != null && (mutableState = qQFlashTransferViewModel7.isAllSelectMode) != null && mutableState.getValue().booleanValue()) {
                                                                    z18 = true;
                                                                }
                                                                if (z18) {
                                                                    str27 = "1";
                                                                } else {
                                                                    str27 = "0";
                                                                }
                                                                dTBaseParams.v("is_screen", str27);
                                                                Unit unit = Unit.INSTANCE;
                                                                i elementVR = ModifierExtKt.elementVR(f19, "em_bas_select_all", dTBaseParams);
                                                                final Boolean bool92 = this.$showCheckBox;
                                                                final Function0<Unit> function0172 = this.$onRightTextClick;
                                                                composer6.startReplaceableGroup(511388516);
                                                                boolean changed = composer6.changed(bool92) | composer6.changed(function0172);
                                                                Object rememberedValue = composer6.rememberedValue();
                                                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$2$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            Function0<Unit> function0182;
                                                                            if (Intrinsics.areEqual(bool92, Boolean.TRUE) && (function0182 = function0172) != null) {
                                                                                function0182.invoke();
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    };
                                                                    composer6.updateRememberedValue(rememberedValue);
                                                                }
                                                                composer6.endReplaceableGroup();
                                                                i d16 = ViewEventPropUpdaterKt.d(elementVR, false, null, (Function1) rememberedValue, 3, null);
                                                                Alignment.Companion companion3 = Alignment.INSTANCE;
                                                                Alignment.Vertical c16 = companion3.c();
                                                                final QQFlashTransferViewModel qQFlashTransferViewModel8 = this.$viewModel;
                                                                final String str29 = this.$rightBtnImagePainter;
                                                                RowKt.a(d16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer6, 762994953, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.3
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                                        SnapshotStateMap<String, ab> snapshotStateMap2;
                                                                        MutableState<Boolean> mutableState2;
                                                                        Composer composer8 = composer7;
                                                                        int intValue3 = num7.intValue();
                                                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                            composer8.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(762994953, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:169)");
                                                                            }
                                                                            i.Companion companion4 = i.INSTANCE;
                                                                            i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), 4.0f, 0.0f, 4.0f, 0.0f, 10, null);
                                                                            QQFlashTransferViewModel qQFlashTransferViewModel9 = QQFlashTransferViewModel.this;
                                                                            boolean z19 = false;
                                                                            QQFTCheckBoxViewKt.QQFTCheckBoxView(n3, 0.0f, (qQFlashTransferViewModel9 == null || (mutableState2 = qQFlashTransferViewModel9.isAllSelectMode) == null || !mutableState2.getValue().booleanValue()) ? false : true, null, null, false, composer8, 8, 58);
                                                                            QQFlashTransferViewModel qQFlashTransferViewModel10 = QQFlashTransferViewModel.this;
                                                                            if (qQFlashTransferViewModel10 != null && (snapshotStateMap2 = qQFlashTransferViewModel10.selectFilesToDownload) != null && (!snapshotStateMap2.isEmpty())) {
                                                                                z19 = true;
                                                                            }
                                                                            TextKt.a("\u5168\u9009", ComposeLayoutPropUpdaterKt.n(companion4, 0.0f, 0.0f, (z19 || str29 == null) ? 16.0f : 0.0f, 0.0f, 11, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, 1601606, 0, 0, 134216612);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer6, 196616, 26);
                                                                QQFlashTransferViewModel qQFlashTransferViewModel9 = this.$viewModel;
                                                                if (((qQFlashTransferViewModel9 != null ? qQFlashTransferViewModel9.selectFilesToDownload : null) == null || qQFlashTransferViewModel9.selectFilesToDownload.size() <= 0) && this.$rightBtnImagePainter != null) {
                                                                    a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                                    i A = ModifiersKt.A(nVar2.b(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), companion3.c()), 0.5f, 0.0f, 2, null);
                                                                    if (k.a(cVar)) {
                                                                        str28 = "0S200MNJT807V3GE";
                                                                    } else {
                                                                        str28 = "0M2003OIIM08YV9M";
                                                                    }
                                                                    i elementVR2 = ModifierExtKt.elementVR(A, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str28));
                                                                    final Function0<Unit> function0182 = this.$onRightBtnClick;
                                                                    composer6.startReplaceableGroup(1157296644);
                                                                    boolean changed2 = composer6.changed(function0182);
                                                                    Object rememberedValue2 = composer6.rememberedValue();
                                                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$4$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                Function0<Unit> function0192 = function0182;
                                                                                if (function0192 != null) {
                                                                                    function0192.invoke();
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        };
                                                                        composer6.updateRememberedValue(rememberedValue2);
                                                                    }
                                                                    composer6.endReplaceableGroup();
                                                                    i d17 = ViewEventPropUpdaterKt.d(elementVR2, false, null, (Function1) rememberedValue2, 3, null);
                                                                    final String str30 = this.$rightBtnImagePainter;
                                                                    final int i78 = this.$$dirty;
                                                                    ColumnKt.a(d17, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -578852167, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.5
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(d dVar, Composer composer7, Integer num7) {
                                                                            Composer composer8 = composer7;
                                                                            int intValue3 = num7.intValue();
                                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                composer8.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-578852167, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:193)");
                                                                                }
                                                                                ImageKt.a(str30, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 20.0f, 0.0f, 16.0f, 0.0f, 10, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i78 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer6, 24648, 12);
                                                                }
                                                                composer6.endReplaceableGroup();
                                                            } else {
                                                                composer6.startReplaceableGroup(-1319183568);
                                                                composer6.startReplaceableGroup(-1319183550);
                                                                String str31 = this.$rightTextContent;
                                                                if (str31 != null) {
                                                                    if (str31.length() > 0) {
                                                                        z18 = true;
                                                                    }
                                                                }
                                                                if (z18) {
                                                                    i f26 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null);
                                                                    final Function0<Unit> function0192 = this.$onRightTextClick;
                                                                    composer6.startReplaceableGroup(1157296644);
                                                                    boolean changed3 = composer6.changed(function0192);
                                                                    Object rememberedValue3 = composer6.rememberedValue();
                                                                    if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                                        rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$6$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                Function0<Unit> function020 = function0192;
                                                                                if (function020 != null) {
                                                                                    function020.invoke();
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        };
                                                                        composer6.updateRememberedValue(rememberedValue3);
                                                                    }
                                                                    composer6.endReplaceableGroup();
                                                                    i d18 = ViewEventPropUpdaterKt.d(f26, false, null, (Function1) rememberedValue3, 3, null);
                                                                    final String str32 = this.$rightTextContent;
                                                                    final int i79 = this.$$dirty;
                                                                    obj = null;
                                                                    RowKt.a(d18, null, null, null, null, ComposableLambdaKt.composableLambda(composer6, 1105722541, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.7
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                                            int i85;
                                                                            n nVar4 = nVar3;
                                                                            Composer composer8 = composer7;
                                                                            int intValue3 = num7.intValue();
                                                                            if ((intValue3 & 14) == 0) {
                                                                                i85 = (composer8.changed(nVar4) ? 4 : 2) | intValue3;
                                                                            } else {
                                                                                i85 = intValue3;
                                                                            }
                                                                            if ((i85 & 91) == 18 && composer8.getSkipping()) {
                                                                                composer8.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(1105722541, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:204)");
                                                                                }
                                                                                h color$default = QUIToken.color$default("text_nav_secondary");
                                                                                int a17 = ai.INSTANCE.a();
                                                                                TextKt.a(str32, ModifiersKt.w(nVar4.b(i.INSTANCE, Alignment.INSTANCE.c()), QUIToken.color$default("overlay_standard_primary")), null, color$default, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, ai.f(a17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i79 >> 24) & 14) | 1601600, 0, 0, 134216612);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer6, 196616, 30);
                                                                } else {
                                                                    obj = null;
                                                                }
                                                                composer6.endReplaceableGroup();
                                                                if (this.$rightBtnImagePainter != null) {
                                                                    Alignment alignment = Alignment.CenterStart;
                                                                    i f27 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, obj);
                                                                    if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                                                        str252 = "0S200MNJT807V3GE";
                                                                    } else {
                                                                        str252 = "0M2003OIIM08YV9M";
                                                                    }
                                                                    i elementVR3 = ModifierExtKt.elementVR(f27, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str252));
                                                                    final Function0<Unit> function020 = this.$onRightBtnClick;
                                                                    composer6.startReplaceableGroup(1157296644);
                                                                    boolean changed4 = composer6.changed(function020);
                                                                    Object rememberedValue4 = composer6.rememberedValue();
                                                                    if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                                        rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$8$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                Function0<Unit> function021 = function020;
                                                                                if (function021 != null) {
                                                                                    function021.invoke();
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        };
                                                                        composer6.updateRememberedValue(rememberedValue4);
                                                                    }
                                                                    composer6.endReplaceableGroup();
                                                                    i d19 = ViewEventPropUpdaterKt.d(elementVR3, false, null, (Function1) rememberedValue4, 3, null);
                                                                    final String str33 = this.$rightBtnImagePainter;
                                                                    final int i85 = this.$$dirty;
                                                                    BoxKt.a(d19, alignment, null, ComposableLambdaKt.composableLambda(composer6, 1487136136, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.9
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(b bVar4, Composer composer7, Integer num7) {
                                                                            Composer composer8 = composer7;
                                                                            int intValue3 = num7.intValue();
                                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                composer8.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(1487136136, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:223)");
                                                                                }
                                                                                ImageKt.a(str33, null, null, null, null, ModifiersKt.A(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 12.0f, 0.0f, 16.0f, 0.0f, 10, null), 0.5f, 0.0f, 2, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i85 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer6, 3128, 4);
                                                                }
                                                                composer6.endReplaceableGroup();
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer4, 196680, 24);
                                                if (Intrinsics.areEqual(bool72, Boolean.TRUE)) {
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer2, 3080, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    qQFlashTransferViewModel3 = qQFlashTransferViewModel2;
                                    str14 = str7;
                                    hVar3 = hVar2;
                                    str15 = str8;
                                    str16 = str11;
                                    num3 = num2;
                                    str17 = str9;
                                    function09 = function06;
                                    bool5 = bool4;
                                    bool6 = bool3;
                                    function010 = function0132;
                                    function011 = function07;
                                    f18 = f17;
                                    function012 = function05;
                                    str18 = str192;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                    return;
                                }
                                final String str26 = str13;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Composer composer3, Integer num5) {
                                        num5.intValue();
                                        QQFTNavBarKt.QQFTNavBar(QQFlashTransferViewModel.this, hVar3, str14, str15, num3, str17, str18, str16, str26, function010, function011, function09, function012, bool6, bool5, f18, composer3, i3 | 1, i16, i17);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return;
                            }
                            i56 = i49;
                            i57 = i17 & 32768;
                            if (i57 != 0) {
                            }
                            if ((i17 & 3) != 3) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) == 0) {
                            }
                            if (i59 != 0) {
                            }
                            if (i66 != 0) {
                            }
                            if ((i17 & 4) != 0) {
                            }
                            if (i67 != 0) {
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
                            if (i38 != 0) {
                            }
                            if (i46 != 0) {
                            }
                            if (i48 != 0) {
                            }
                            if (i56 != 0) {
                            }
                            if (i57 != 0) {
                            }
                            bool4 = bool9;
                            function06 = function019;
                            function07 = function018;
                            function08 = function017;
                            str12 = str25;
                            qQFlashTransferViewModel2 = qQFlashTransferViewModel;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            com.tencent.ntcompose.ui.platform.a aVar22 = (com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d());
                            final Function0<Unit> function01322 = function08;
                            final String str1922 = str10;
                            final QQFlashTransferViewModel qQFlashTransferViewModel422 = qQFlashTransferViewModel2;
                            final Boolean bool722 = bool4;
                            final Integer num422 = num2;
                            final String str2022 = str8;
                            final Function0<Unit> function01422 = function06;
                            final Function0<Unit> function01522 = function07;
                            final int i6922 = i65;
                            final int i7522 = i68;
                            final String str2122 = str9;
                            final String str2222 = str11;
                            final String str2322 = str7;
                            final Boolean bool822 = bool3;
                            final Function0<Unit> function01622 = function05;
                            final String str2422 = str13;
                            composer2 = startRestartGroup;
                            BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), hVar2), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar22)), 0.0f, aVar22.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(composer2, 1894388531, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
                                /* JADX WARN: Removed duplicated region for block: B:29:0x0140  */
                                /* JADX WARN: Removed duplicated region for block: B:32:0x0171  */
                                /* JADX WARN: Removed duplicated region for block: B:33:0x00e0  */
                                /* JADX WARN: Type inference failed for: r2v20 */
                                /* JADX WARN: Type inference failed for: r2v21 */
                                /* JADX WARN: Type inference failed for: r2v7, types: [int, boolean] */
                                @Override // kotlin.jvm.functions.Function3
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Unit invoke(b bVar, Composer composer3, Integer num5) {
                                    int i76;
                                    boolean z16;
                                    boolean z17;
                                    ?? r26;
                                    b bVar2;
                                    SnapshotStateMap<String, ab> snapshotStateMap;
                                    b bVar3 = bVar;
                                    Composer composer4 = composer3;
                                    int intValue = num5.intValue();
                                    if ((intValue & 14) == 0) {
                                        i76 = (composer4.changed(bVar3) ? 4 : 2) | intValue;
                                    } else {
                                        i76 = intValue;
                                    }
                                    if ((i76 & 91) == 18 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1894388531, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous> (QQFTNavBar.kt:69)");
                                        }
                                        i.Companion companion = i.INSTANCE;
                                        RowKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterStart), null, null, null, null, ComposableLambdaKt.composableLambda(composer4, 1884949333, true, new Function3<n, Composer, Integer, Unit>(num422, QQFlashTransferViewModel.this, str2022, function01422, function01522, i6922, i7522, str2122, str2222, str2322, str1922) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.1
                                            public final /* synthetic */ int $$dirty;
                                            public final /* synthetic */ String $leftBtnImagePainter;
                                            public final /* synthetic */ String $leftTextContent;
                                            public final /* synthetic */ Integer $modalMode;
                                            public final /* synthetic */ String $navImagePainter;
                                            public final /* synthetic */ String $navTitle;
                                            public final /* synthetic */ Function0<Unit> $onLeftBtnClick;
                                            public final /* synthetic */ Function0<Unit> $onLeftTextClick;
                                            public final /* synthetic */ String $rightBtnImagePainter;
                                            public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                                this.$navTitle = r8;
                                                this.$rightBtnImagePainter = r9;
                                                this.$leftBtnImagePainter = r10;
                                                this.$navImagePainter = r11;
                                            }

                                            /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
                                            
                                                if (((r1 == null || r1.isSecondaryPage()) ? false : true) == false) goto L23;
                                             */
                                            /* JADX WARN: Code restructure failed: missing block: B:39:0x0118, code lost:
                                            
                                                if ((r23.$navTitle.length() > 0) == false) goto L54;
                                             */
                                            /* JADX WARN: Removed duplicated region for block: B:26:0x00b7  */
                                            /* JADX WARN: Removed duplicated region for block: B:30:0x00fd  */
                                            /* JADX WARN: Removed duplicated region for block: B:36:0x010e  */
                                            /* JADX WARN: Removed duplicated region for block: B:42:0x0163  */
                                            /* JADX WARN: Removed duplicated region for block: B:55:0x007b  */
                                            @Override // kotlin.jvm.functions.Function3
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                                                boolean z18;
                                                float f19;
                                                boolean changed;
                                                Object rememberedValue;
                                                QQFlashTransferViewModel qQFlashTransferViewModel52;
                                                SnapshotStateMap<String, ab> snapshotStateMap2;
                                                Composer composer6 = composer5;
                                                int intValue2 = num6.intValue();
                                                if ((intValue2 & 81) == 16 && composer6.getSkipping()) {
                                                    composer6.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1884949333, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:70)");
                                                    }
                                                    com.tencent.ntcompose.foundation.layout.base.a aVar222 = com.tencent.ntcompose.foundation.layout.base.a.f339245a;
                                                    a.e b16 = aVar222.b();
                                                    i.Companion companion2 = i.INSTANCE;
                                                    i f26 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                                    Integer num7 = this.$modalMode;
                                                    if (num7 != null && num7.intValue() == 1) {
                                                        QQFlashTransferViewModel qQFlashTransferViewModel6 = this.$viewModel;
                                                    }
                                                    String str252 = this.$leftTextContent;
                                                    if (str252 != null) {
                                                        if (str252.length() > 0) {
                                                            z18 = true;
                                                            if (!z18) {
                                                                f19 = 10.0f;
                                                                i a162222 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                                                final String str262222 = this.$leftTextContent;
                                                                final Function0<Unit> function0172222 = this.$onLeftTextClick;
                                                                final Function0<Unit> function0182222 = this.$onLeftBtnClick;
                                                                composer6.startReplaceableGroup(1618982084);
                                                                changed = composer6.changed(str262222) | composer6.changed(function0172222) | composer6.changed(function0182222);
                                                                rememberedValue = composer6.rememberedValue();
                                                                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            String str272222 = str262222;
                                                                            boolean z19 = false;
                                                                            if (str272222 != null) {
                                                                                if (str272222.length() > 0) {
                                                                                    z19 = true;
                                                                                }
                                                                            }
                                                                            if (z19) {
                                                                                Function0<Unit> function0192 = function0172222;
                                                                                if (function0192 != null) {
                                                                                    function0192.invoke();
                                                                                }
                                                                            } else {
                                                                                Function0<Unit> function020 = function0182222;
                                                                                if (function020 != null) {
                                                                                    function020.invoke();
                                                                                } else {
                                                                                    QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    };
                                                                    composer6.updateRememberedValue(rememberedValue);
                                                                }
                                                                composer6.endReplaceableGroup();
                                                                i A2222 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a162222, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                                                final String str272222 = this.$leftTextContent;
                                                                final int i772222 = this.$$dirty;
                                                                final String str282222 = this.$leftBtnImagePainter;
                                                                ColumnKt.a(A2222, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                        Composer composer8 = composer7;
                                                                        int intValue3 = num8.intValue();
                                                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                            composer8.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                                            }
                                                                            String str292222 = str272222;
                                                                            boolean z19 = false;
                                                                            if (str292222 != null) {
                                                                                if (str292222.length() > 0) {
                                                                                    z19 = true;
                                                                                }
                                                                            }
                                                                            if (z19) {
                                                                                composer8.startReplaceableGroup(2107916874);
                                                                                TextKt.a(str272222, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i772222 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                                                composer8.endReplaceableGroup();
                                                                            } else {
                                                                                composer8.startReplaceableGroup(2107917260);
                                                                                ImageKt.a(str282222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i772222 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                                                composer8.endReplaceableGroup();
                                                                            }
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer6, 24648, 12);
                                                                qQFlashTransferViewModel52 = this.$viewModel;
                                                                if (qQFlashTransferViewModel52 == null && (snapshotStateMap2 = qQFlashTransferViewModel52.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                                                }
                                                                i n36222 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                                a.e b172222 = aVar222.b();
                                                                final QQFlashTransferViewModel qQFlashTransferViewModel72222 = this.$viewModel;
                                                                final String str292222 = this.$navTitle;
                                                                final String str302222 = this.$rightBtnImagePainter;
                                                                final String str312222 = this.$navImagePainter;
                                                                final int i782222 = this.$$dirty;
                                                                ColumnKt.a(n36222, b172222, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                        Composer composer8 = composer7;
                                                                        int intValue3 = num8.intValue();
                                                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                            composer8.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                                            }
                                                                            i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                                            final String str32 = str312222;
                                                                            final int i79 = i782222;
                                                                            final String str33 = str292222;
                                                                            RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(3);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                                                    int i85;
                                                                                    Composer composer10;
                                                                                    Map mutableMapOf;
                                                                                    n nVar3 = nVar2;
                                                                                    Composer composer11 = composer9;
                                                                                    int intValue4 = num9.intValue();
                                                                                    if ((intValue4 & 14) == 0) {
                                                                                        i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                                                    } else {
                                                                                        i85 = intValue4;
                                                                                    }
                                                                                    if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                                                        composer11.skipToGroupEnd();
                                                                                    } else {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                                                        }
                                                                                        composer11.startReplaceableGroup(-1116923971);
                                                                                        if (str32 != null) {
                                                                                            mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                                            composer10 = composer11;
                                                                                            ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                                                        } else {
                                                                                            composer10 = composer11;
                                                                                        }
                                                                                        composer10.endReplaceableGroup();
                                                                                        TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }), composer8, 196616, 30);
                                                                            if (QQFlashTransferViewModel.this != null) {
                                                                                if (str292222.length() > 0) {
                                                                                    QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str302222), true, composer8, 25142, 0);
                                                                                }
                                                                            }
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer6, 24648, 12);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            f19 = 16.0f;
                                                            i a1622222 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                                            final String str2622222 = this.$leftTextContent;
                                                            final Function0<Unit> function01722222 = this.$onLeftTextClick;
                                                            final Function0<Unit> function01822222 = this.$onLeftBtnClick;
                                                            composer6.startReplaceableGroup(1618982084);
                                                            changed = composer6.changed(str2622222) | composer6.changed(function01722222) | composer6.changed(function01822222);
                                                            rememberedValue = composer6.rememberedValue();
                                                            if (!changed) {
                                                            }
                                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    String str2722222 = str2622222;
                                                                    boolean z19 = false;
                                                                    if (str2722222 != null) {
                                                                        if (str2722222.length() > 0) {
                                                                            z19 = true;
                                                                        }
                                                                    }
                                                                    if (z19) {
                                                                        Function0<Unit> function0192 = function01722222;
                                                                        if (function0192 != null) {
                                                                            function0192.invoke();
                                                                        }
                                                                    } else {
                                                                        Function0<Unit> function020 = function01822222;
                                                                        if (function020 != null) {
                                                                            function020.invoke();
                                                                        } else {
                                                                            QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            composer6.updateRememberedValue(rememberedValue);
                                                            composer6.endReplaceableGroup();
                                                            i A22222 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a1622222, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                                            final String str2722222 = this.$leftTextContent;
                                                            final int i7722222 = this.$$dirty;
                                                            final String str2822222 = this.$leftBtnImagePainter;
                                                            ColumnKt.a(A22222, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                    Composer composer8 = composer7;
                                                                    int intValue3 = num8.intValue();
                                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                        composer8.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                                        }
                                                                        String str2922222 = str2722222;
                                                                        boolean z19 = false;
                                                                        if (str2922222 != null) {
                                                                            if (str2922222.length() > 0) {
                                                                                z19 = true;
                                                                            }
                                                                        }
                                                                        if (z19) {
                                                                            composer8.startReplaceableGroup(2107916874);
                                                                            TextKt.a(str2722222, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i7722222 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                                            composer8.endReplaceableGroup();
                                                                        } else {
                                                                            composer8.startReplaceableGroup(2107917260);
                                                                            ImageKt.a(str2822222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i7722222 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                                            composer8.endReplaceableGroup();
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer6, 24648, 12);
                                                            qQFlashTransferViewModel52 = this.$viewModel;
                                                            if (qQFlashTransferViewModel52 == null && (snapshotStateMap2 = qQFlashTransferViewModel52.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                                            }
                                                            i n362222 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                            a.e b1722222 = aVar222.b();
                                                            final QQFlashTransferViewModel qQFlashTransferViewModel722222 = this.$viewModel;
                                                            final String str2922222 = this.$navTitle;
                                                            final String str3022222 = this.$rightBtnImagePainter;
                                                            final String str3122222 = this.$navImagePainter;
                                                            final int i7822222 = this.$$dirty;
                                                            ColumnKt.a(n362222, b1722222, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                    Composer composer8 = composer7;
                                                                    int intValue3 = num8.intValue();
                                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                        composer8.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                                        }
                                                                        i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                                        final String str32 = str3122222;
                                                                        final int i79 = i7822222;
                                                                        final String str33 = str2922222;
                                                                        RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                                                int i85;
                                                                                Composer composer10;
                                                                                Map mutableMapOf;
                                                                                n nVar3 = nVar2;
                                                                                Composer composer11 = composer9;
                                                                                int intValue4 = num9.intValue();
                                                                                if ((intValue4 & 14) == 0) {
                                                                                    i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                                                } else {
                                                                                    i85 = intValue4;
                                                                                }
                                                                                if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                                                    composer11.skipToGroupEnd();
                                                                                } else {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                                                    }
                                                                                    composer11.startReplaceableGroup(-1116923971);
                                                                                    if (str32 != null) {
                                                                                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                                        composer10 = composer11;
                                                                                        ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                                                    } else {
                                                                                        composer10 = composer11;
                                                                                    }
                                                                                    composer10.endReplaceableGroup();
                                                                                    TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer8, 196616, 30);
                                                                        if (QQFlashTransferViewModel.this != null) {
                                                                            if (str2922222.length() > 0) {
                                                                                QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str3022222), true, composer8, 25142, 0);
                                                                            }
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer6, 24648, 12);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                            }
                                                        }
                                                    }
                                                    z18 = false;
                                                    if (!z18) {
                                                    }
                                                    f19 = 16.0f;
                                                    i a16222222 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                                    final String str26222222 = this.$leftTextContent;
                                                    final Function0<Unit> function017222222 = this.$onLeftTextClick;
                                                    final Function0<Unit> function018222222 = this.$onLeftBtnClick;
                                                    composer6.startReplaceableGroup(1618982084);
                                                    changed = composer6.changed(str26222222) | composer6.changed(function017222222) | composer6.changed(function018222222);
                                                    rememberedValue = composer6.rememberedValue();
                                                    if (!changed) {
                                                    }
                                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            String str27222222 = str26222222;
                                                            boolean z19 = false;
                                                            if (str27222222 != null) {
                                                                if (str27222222.length() > 0) {
                                                                    z19 = true;
                                                                }
                                                            }
                                                            if (z19) {
                                                                Function0<Unit> function0192 = function017222222;
                                                                if (function0192 != null) {
                                                                    function0192.invoke();
                                                                }
                                                            } else {
                                                                Function0<Unit> function020 = function018222222;
                                                                if (function020 != null) {
                                                                    function020.invoke();
                                                                } else {
                                                                    QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer6.updateRememberedValue(rememberedValue);
                                                    composer6.endReplaceableGroup();
                                                    i A222222 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a16222222, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                                    final String str27222222 = this.$leftTextContent;
                                                    final int i77222222 = this.$$dirty;
                                                    final String str28222222 = this.$leftBtnImagePainter;
                                                    ColumnKt.a(A222222, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                            Composer composer8 = composer7;
                                                            int intValue3 = num8.intValue();
                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                composer8.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                                }
                                                                String str29222222 = str27222222;
                                                                boolean z19 = false;
                                                                if (str29222222 != null) {
                                                                    if (str29222222.length() > 0) {
                                                                        z19 = true;
                                                                    }
                                                                }
                                                                if (z19) {
                                                                    composer8.startReplaceableGroup(2107916874);
                                                                    TextKt.a(str27222222, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i77222222 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                                    composer8.endReplaceableGroup();
                                                                } else {
                                                                    composer8.startReplaceableGroup(2107917260);
                                                                    ImageKt.a(str28222222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i77222222 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                                    composer8.endReplaceableGroup();
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer6, 24648, 12);
                                                    qQFlashTransferViewModel52 = this.$viewModel;
                                                    if (qQFlashTransferViewModel52 == null && (snapshotStateMap2 = qQFlashTransferViewModel52.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                                    }
                                                    i n3622222 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                    a.e b17222222 = aVar222.b();
                                                    final QQFlashTransferViewModel qQFlashTransferViewModel7222222 = this.$viewModel;
                                                    final String str29222222 = this.$navTitle;
                                                    final String str30222222 = this.$rightBtnImagePainter;
                                                    final String str31222222 = this.$navImagePainter;
                                                    final int i78222222 = this.$$dirty;
                                                    ColumnKt.a(n3622222, b17222222, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                            Composer composer8 = composer7;
                                                            int intValue3 = num8.intValue();
                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                composer8.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                                }
                                                                i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                                final String str32 = str31222222;
                                                                final int i79 = i78222222;
                                                                final String str33 = str29222222;
                                                                RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                                        int i85;
                                                                        Composer composer10;
                                                                        Map mutableMapOf;
                                                                        n nVar3 = nVar2;
                                                                        Composer composer11 = composer9;
                                                                        int intValue4 = num9.intValue();
                                                                        if ((intValue4 & 14) == 0) {
                                                                            i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                                        } else {
                                                                            i85 = intValue4;
                                                                        }
                                                                        if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                                            composer11.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                                            }
                                                                            composer11.startReplaceableGroup(-1116923971);
                                                                            if (str32 != null) {
                                                                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                                composer10 = composer11;
                                                                                ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                                            } else {
                                                                                composer10 = composer11;
                                                                            }
                                                                            composer10.endReplaceableGroup();
                                                                            TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer8, 196616, 30);
                                                                if (QQFlashTransferViewModel.this != null) {
                                                                    if (str29222222.length() > 0) {
                                                                        QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str30222222), true, composer8, 25142, 0);
                                                                    }
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer6, 24648, 12);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer4, 196616, 30);
                                        composer4.startReplaceableGroup(-1240831040);
                                        QQFlashTransferViewModel qQFlashTransferViewModel52 = QQFlashTransferViewModel.this;
                                        if (qQFlashTransferViewModel52 == null || (snapshotStateMap = qQFlashTransferViewModel52.selectFilesToDownload) == null) {
                                            z16 = true;
                                        } else {
                                            z16 = true;
                                            r26 = 1;
                                            if (!snapshotStateMap.isEmpty()) {
                                                z17 = true;
                                                if (z17) {
                                                    bVar2 = bVar3;
                                                } else {
                                                    bVar2 = bVar3;
                                                    i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, r26, null), Alignment.Center);
                                                    final QQFlashTransferViewModel qQFlashTransferViewModel6 = QQFlashTransferViewModel.this;
                                                    BoxKt.a(a16, null, null, ComposableLambdaKt.composableLambda(composer4, -408684780, r26, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.2
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(b bVar4, Composer composer5, Integer num6) {
                                                            int i77;
                                                            b bVar5 = bVar4;
                                                            Composer composer6 = composer5;
                                                            int intValue2 = num6.intValue();
                                                            if ((intValue2 & 14) == 0) {
                                                                i77 = (composer6.changed(bVar5) ? 4 : 2) | intValue2;
                                                            } else {
                                                                i77 = intValue2;
                                                            }
                                                            if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                                                composer6.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-408684780, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:145)");
                                                                }
                                                                QQFTDownloadBarViewKt.selectFileInfoStrView(bVar5.a(i.INSTANCE, Alignment.Center), QQFlashTransferViewModel.this, composer6, 72);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer4, 3080, 6);
                                                }
                                                composer4.endReplaceableGroup();
                                                RowKt.a(ComposeLayoutPropUpdaterKt.f(bVar2.a(companion, Alignment.CenterEnd), 0.0f, 1, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.c(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer4, 83640332, true, new Function3<n, Composer, Integer, Unit>(bool822, function01322, i7522, i6922, QQFlashTransferViewModel.this, str2222, function01622, str2422) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.3
                                                    public final /* synthetic */ int $$dirty;
                                                    public final /* synthetic */ Function0<Unit> $onRightBtnClick;
                                                    public final /* synthetic */ Function0<Unit> $onRightTextClick;
                                                    public final /* synthetic */ String $rightBtnImagePainter;
                                                    public final /* synthetic */ String $rightTextContent;
                                                    public final /* synthetic */ Boolean $showCheckBox;
                                                    public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                        this.$$dirty = r4;
                                                        this.$viewModel = r5;
                                                        this.$rightBtnImagePainter = r6;
                                                        this.$onRightBtnClick = r7;
                                                        this.$rightTextContent = r8;
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                                                        int i77;
                                                        Object obj;
                                                        String str252;
                                                        String str262;
                                                        String str27;
                                                        String str28;
                                                        MutableState<Boolean> mutableState;
                                                        n nVar2 = nVar;
                                                        Composer composer6 = composer5;
                                                        int intValue2 = num6.intValue();
                                                        if ((intValue2 & 14) == 0) {
                                                            i77 = (composer6.changed(nVar2) ? 4 : 2) | intValue2;
                                                        } else {
                                                            i77 = intValue2;
                                                        }
                                                        if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                                            composer6.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(83640332, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:158)");
                                                            }
                                                            boolean z18 = false;
                                                            if (Intrinsics.areEqual(this.$showCheckBox, Boolean.TRUE)) {
                                                                composer6.startReplaceableGroup(-1319185738);
                                                                i.Companion companion2 = i.INSTANCE;
                                                                i f19 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                                                com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                                                if (k.a(cVar)) {
                                                                    str262 = "0S200MNJT807V3GE";
                                                                } else {
                                                                    str262 = "0M2003OIIM08YV9M";
                                                                }
                                                                e dTBaseParams = DTReportConstKt.getDTBaseParams(str262);
                                                                QQFlashTransferViewModel qQFlashTransferViewModel7 = this.$viewModel;
                                                                if (qQFlashTransferViewModel7 != null && (mutableState = qQFlashTransferViewModel7.isAllSelectMode) != null && mutableState.getValue().booleanValue()) {
                                                                    z18 = true;
                                                                }
                                                                if (z18) {
                                                                    str27 = "1";
                                                                } else {
                                                                    str27 = "0";
                                                                }
                                                                dTBaseParams.v("is_screen", str27);
                                                                Unit unit = Unit.INSTANCE;
                                                                i elementVR = ModifierExtKt.elementVR(f19, "em_bas_select_all", dTBaseParams);
                                                                final Boolean bool92 = this.$showCheckBox;
                                                                final Function0<Unit> function0172 = this.$onRightTextClick;
                                                                composer6.startReplaceableGroup(511388516);
                                                                boolean changed = composer6.changed(bool92) | composer6.changed(function0172);
                                                                Object rememberedValue = composer6.rememberedValue();
                                                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$2$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            Function0<Unit> function0182;
                                                                            if (Intrinsics.areEqual(bool92, Boolean.TRUE) && (function0182 = function0172) != null) {
                                                                                function0182.invoke();
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    };
                                                                    composer6.updateRememberedValue(rememberedValue);
                                                                }
                                                                composer6.endReplaceableGroup();
                                                                i d16 = ViewEventPropUpdaterKt.d(elementVR, false, null, (Function1) rememberedValue, 3, null);
                                                                Alignment.Companion companion3 = Alignment.INSTANCE;
                                                                Alignment.Vertical c16 = companion3.c();
                                                                final QQFlashTransferViewModel qQFlashTransferViewModel8 = this.$viewModel;
                                                                final String str29 = this.$rightBtnImagePainter;
                                                                RowKt.a(d16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer6, 762994953, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.3
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                                        SnapshotStateMap<String, ab> snapshotStateMap2;
                                                                        MutableState<Boolean> mutableState2;
                                                                        Composer composer8 = composer7;
                                                                        int intValue3 = num7.intValue();
                                                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                            composer8.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(762994953, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:169)");
                                                                            }
                                                                            i.Companion companion4 = i.INSTANCE;
                                                                            i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), 4.0f, 0.0f, 4.0f, 0.0f, 10, null);
                                                                            QQFlashTransferViewModel qQFlashTransferViewModel9 = QQFlashTransferViewModel.this;
                                                                            boolean z19 = false;
                                                                            QQFTCheckBoxViewKt.QQFTCheckBoxView(n3, 0.0f, (qQFlashTransferViewModel9 == null || (mutableState2 = qQFlashTransferViewModel9.isAllSelectMode) == null || !mutableState2.getValue().booleanValue()) ? false : true, null, null, false, composer8, 8, 58);
                                                                            QQFlashTransferViewModel qQFlashTransferViewModel10 = QQFlashTransferViewModel.this;
                                                                            if (qQFlashTransferViewModel10 != null && (snapshotStateMap2 = qQFlashTransferViewModel10.selectFilesToDownload) != null && (!snapshotStateMap2.isEmpty())) {
                                                                                z19 = true;
                                                                            }
                                                                            TextKt.a("\u5168\u9009", ComposeLayoutPropUpdaterKt.n(companion4, 0.0f, 0.0f, (z19 || str29 == null) ? 16.0f : 0.0f, 0.0f, 11, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, 1601606, 0, 0, 134216612);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer6, 196616, 26);
                                                                QQFlashTransferViewModel qQFlashTransferViewModel9 = this.$viewModel;
                                                                if (((qQFlashTransferViewModel9 != null ? qQFlashTransferViewModel9.selectFilesToDownload : null) == null || qQFlashTransferViewModel9.selectFilesToDownload.size() <= 0) && this.$rightBtnImagePainter != null) {
                                                                    a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                                    i A = ModifiersKt.A(nVar2.b(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), companion3.c()), 0.5f, 0.0f, 2, null);
                                                                    if (k.a(cVar)) {
                                                                        str28 = "0S200MNJT807V3GE";
                                                                    } else {
                                                                        str28 = "0M2003OIIM08YV9M";
                                                                    }
                                                                    i elementVR2 = ModifierExtKt.elementVR(A, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str28));
                                                                    final Function0<Unit> function0182 = this.$onRightBtnClick;
                                                                    composer6.startReplaceableGroup(1157296644);
                                                                    boolean changed2 = composer6.changed(function0182);
                                                                    Object rememberedValue2 = composer6.rememberedValue();
                                                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$4$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                Function0<Unit> function0192 = function0182;
                                                                                if (function0192 != null) {
                                                                                    function0192.invoke();
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        };
                                                                        composer6.updateRememberedValue(rememberedValue2);
                                                                    }
                                                                    composer6.endReplaceableGroup();
                                                                    i d17 = ViewEventPropUpdaterKt.d(elementVR2, false, null, (Function1) rememberedValue2, 3, null);
                                                                    final String str30 = this.$rightBtnImagePainter;
                                                                    final int i78 = this.$$dirty;
                                                                    ColumnKt.a(d17, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -578852167, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.5
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(d dVar, Composer composer7, Integer num7) {
                                                                            Composer composer8 = composer7;
                                                                            int intValue3 = num7.intValue();
                                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                composer8.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-578852167, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:193)");
                                                                                }
                                                                                ImageKt.a(str30, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 20.0f, 0.0f, 16.0f, 0.0f, 10, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i78 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer6, 24648, 12);
                                                                }
                                                                composer6.endReplaceableGroup();
                                                            } else {
                                                                composer6.startReplaceableGroup(-1319183568);
                                                                composer6.startReplaceableGroup(-1319183550);
                                                                String str31 = this.$rightTextContent;
                                                                if (str31 != null) {
                                                                    if (str31.length() > 0) {
                                                                        z18 = true;
                                                                    }
                                                                }
                                                                if (z18) {
                                                                    i f26 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null);
                                                                    final Function0<Unit> function0192 = this.$onRightTextClick;
                                                                    composer6.startReplaceableGroup(1157296644);
                                                                    boolean changed3 = composer6.changed(function0192);
                                                                    Object rememberedValue3 = composer6.rememberedValue();
                                                                    if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                                        rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$6$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                Function0<Unit> function020 = function0192;
                                                                                if (function020 != null) {
                                                                                    function020.invoke();
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        };
                                                                        composer6.updateRememberedValue(rememberedValue3);
                                                                    }
                                                                    composer6.endReplaceableGroup();
                                                                    i d18 = ViewEventPropUpdaterKt.d(f26, false, null, (Function1) rememberedValue3, 3, null);
                                                                    final String str32 = this.$rightTextContent;
                                                                    final int i79 = this.$$dirty;
                                                                    obj = null;
                                                                    RowKt.a(d18, null, null, null, null, ComposableLambdaKt.composableLambda(composer6, 1105722541, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.7
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                                            int i85;
                                                                            n nVar4 = nVar3;
                                                                            Composer composer8 = composer7;
                                                                            int intValue3 = num7.intValue();
                                                                            if ((intValue3 & 14) == 0) {
                                                                                i85 = (composer8.changed(nVar4) ? 4 : 2) | intValue3;
                                                                            } else {
                                                                                i85 = intValue3;
                                                                            }
                                                                            if ((i85 & 91) == 18 && composer8.getSkipping()) {
                                                                                composer8.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(1105722541, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:204)");
                                                                                }
                                                                                h color$default = QUIToken.color$default("text_nav_secondary");
                                                                                int a17 = ai.INSTANCE.a();
                                                                                TextKt.a(str32, ModifiersKt.w(nVar4.b(i.INSTANCE, Alignment.INSTANCE.c()), QUIToken.color$default("overlay_standard_primary")), null, color$default, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, ai.f(a17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i79 >> 24) & 14) | 1601600, 0, 0, 134216612);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer6, 196616, 30);
                                                                } else {
                                                                    obj = null;
                                                                }
                                                                composer6.endReplaceableGroup();
                                                                if (this.$rightBtnImagePainter != null) {
                                                                    Alignment alignment = Alignment.CenterStart;
                                                                    i f27 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, obj);
                                                                    if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                                                        str252 = "0S200MNJT807V3GE";
                                                                    } else {
                                                                        str252 = "0M2003OIIM08YV9M";
                                                                    }
                                                                    i elementVR3 = ModifierExtKt.elementVR(f27, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str252));
                                                                    final Function0<Unit> function020 = this.$onRightBtnClick;
                                                                    composer6.startReplaceableGroup(1157296644);
                                                                    boolean changed4 = composer6.changed(function020);
                                                                    Object rememberedValue4 = composer6.rememberedValue();
                                                                    if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                                        rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$8$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                Function0<Unit> function021 = function020;
                                                                                if (function021 != null) {
                                                                                    function021.invoke();
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        };
                                                                        composer6.updateRememberedValue(rememberedValue4);
                                                                    }
                                                                    composer6.endReplaceableGroup();
                                                                    i d19 = ViewEventPropUpdaterKt.d(elementVR3, false, null, (Function1) rememberedValue4, 3, null);
                                                                    final String str33 = this.$rightBtnImagePainter;
                                                                    final int i85 = this.$$dirty;
                                                                    BoxKt.a(d19, alignment, null, ComposableLambdaKt.composableLambda(composer6, 1487136136, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.9
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(b bVar4, Composer composer7, Integer num7) {
                                                                            Composer composer8 = composer7;
                                                                            int intValue3 = num7.intValue();
                                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                                composer8.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(1487136136, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:223)");
                                                                                }
                                                                                ImageKt.a(str33, null, null, null, null, ModifiersKt.A(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 12.0f, 0.0f, 16.0f, 0.0f, 10, null), 0.5f, 0.0f, 2, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i85 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer6, 3128, 4);
                                                                }
                                                                composer6.endReplaceableGroup();
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer4, 196680, 24);
                                                if (Intrinsics.areEqual(bool722, Boolean.TRUE)) {
                                                    SurfaceKt.a(ModifiersKt.c(bVar2.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 0.5f), Alignment.BottomCenter), QUIToken.color$default("border_light")), null, null, null, ComposableSingletons$QQFTNavBarKt.f144lambda1, composer4, 24584, 14);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }
                                        z17 = false;
                                        r26 = z16;
                                        if (z17) {
                                        }
                                        composer4.endReplaceableGroup();
                                        RowKt.a(ComposeLayoutPropUpdaterKt.f(bVar2.a(companion, Alignment.CenterEnd), 0.0f, 1, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.c(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer4, 83640332, true, new Function3<n, Composer, Integer, Unit>(bool822, function01322, i7522, i6922, QQFlashTransferViewModel.this, str2222, function01622, str2422) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.3
                                            public final /* synthetic */ int $$dirty;
                                            public final /* synthetic */ Function0<Unit> $onRightBtnClick;
                                            public final /* synthetic */ Function0<Unit> $onRightTextClick;
                                            public final /* synthetic */ String $rightBtnImagePainter;
                                            public final /* synthetic */ String $rightTextContent;
                                            public final /* synthetic */ Boolean $showCheckBox;
                                            public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                                this.$$dirty = r4;
                                                this.$viewModel = r5;
                                                this.$rightBtnImagePainter = r6;
                                                this.$onRightBtnClick = r7;
                                                this.$rightTextContent = r8;
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                                                int i77;
                                                Object obj;
                                                String str252;
                                                String str262;
                                                String str27;
                                                String str28;
                                                MutableState<Boolean> mutableState;
                                                n nVar2 = nVar;
                                                Composer composer6 = composer5;
                                                int intValue2 = num6.intValue();
                                                if ((intValue2 & 14) == 0) {
                                                    i77 = (composer6.changed(nVar2) ? 4 : 2) | intValue2;
                                                } else {
                                                    i77 = intValue2;
                                                }
                                                if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                                    composer6.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(83640332, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:158)");
                                                    }
                                                    boolean z18 = false;
                                                    if (Intrinsics.areEqual(this.$showCheckBox, Boolean.TRUE)) {
                                                        composer6.startReplaceableGroup(-1319185738);
                                                        i.Companion companion2 = i.INSTANCE;
                                                        i f19 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                                        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                                        if (k.a(cVar)) {
                                                            str262 = "0S200MNJT807V3GE";
                                                        } else {
                                                            str262 = "0M2003OIIM08YV9M";
                                                        }
                                                        e dTBaseParams = DTReportConstKt.getDTBaseParams(str262);
                                                        QQFlashTransferViewModel qQFlashTransferViewModel7 = this.$viewModel;
                                                        if (qQFlashTransferViewModel7 != null && (mutableState = qQFlashTransferViewModel7.isAllSelectMode) != null && mutableState.getValue().booleanValue()) {
                                                            z18 = true;
                                                        }
                                                        if (z18) {
                                                            str27 = "1";
                                                        } else {
                                                            str27 = "0";
                                                        }
                                                        dTBaseParams.v("is_screen", str27);
                                                        Unit unit = Unit.INSTANCE;
                                                        i elementVR = ModifierExtKt.elementVR(f19, "em_bas_select_all", dTBaseParams);
                                                        final Boolean bool92 = this.$showCheckBox;
                                                        final Function0<Unit> function0172 = this.$onRightTextClick;
                                                        composer6.startReplaceableGroup(511388516);
                                                        boolean changed = composer6.changed(bool92) | composer6.changed(function0172);
                                                        Object rememberedValue = composer6.rememberedValue();
                                                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$2$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    Function0<Unit> function0182;
                                                                    if (Intrinsics.areEqual(bool92, Boolean.TRUE) && (function0182 = function0172) != null) {
                                                                        function0182.invoke();
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            composer6.updateRememberedValue(rememberedValue);
                                                        }
                                                        composer6.endReplaceableGroup();
                                                        i d16 = ViewEventPropUpdaterKt.d(elementVR, false, null, (Function1) rememberedValue, 3, null);
                                                        Alignment.Companion companion3 = Alignment.INSTANCE;
                                                        Alignment.Vertical c16 = companion3.c();
                                                        final QQFlashTransferViewModel qQFlashTransferViewModel8 = this.$viewModel;
                                                        final String str29 = this.$rightBtnImagePainter;
                                                        RowKt.a(d16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer6, 762994953, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                                SnapshotStateMap<String, ab> snapshotStateMap2;
                                                                MutableState<Boolean> mutableState2;
                                                                Composer composer8 = composer7;
                                                                int intValue3 = num7.intValue();
                                                                if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                    composer8.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(762994953, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:169)");
                                                                    }
                                                                    i.Companion companion4 = i.INSTANCE;
                                                                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), 4.0f, 0.0f, 4.0f, 0.0f, 10, null);
                                                                    QQFlashTransferViewModel qQFlashTransferViewModel9 = QQFlashTransferViewModel.this;
                                                                    boolean z19 = false;
                                                                    QQFTCheckBoxViewKt.QQFTCheckBoxView(n3, 0.0f, (qQFlashTransferViewModel9 == null || (mutableState2 = qQFlashTransferViewModel9.isAllSelectMode) == null || !mutableState2.getValue().booleanValue()) ? false : true, null, null, false, composer8, 8, 58);
                                                                    QQFlashTransferViewModel qQFlashTransferViewModel10 = QQFlashTransferViewModel.this;
                                                                    if (qQFlashTransferViewModel10 != null && (snapshotStateMap2 = qQFlashTransferViewModel10.selectFilesToDownload) != null && (!snapshotStateMap2.isEmpty())) {
                                                                        z19 = true;
                                                                    }
                                                                    TextKt.a("\u5168\u9009", ComposeLayoutPropUpdaterKt.n(companion4, 0.0f, 0.0f, (z19 || str29 == null) ? 16.0f : 0.0f, 0.0f, 11, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, 1601606, 0, 0, 134216612);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer6, 196616, 26);
                                                        QQFlashTransferViewModel qQFlashTransferViewModel9 = this.$viewModel;
                                                        if (((qQFlashTransferViewModel9 != null ? qQFlashTransferViewModel9.selectFilesToDownload : null) == null || qQFlashTransferViewModel9.selectFilesToDownload.size() <= 0) && this.$rightBtnImagePainter != null) {
                                                            a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                            i A = ModifiersKt.A(nVar2.b(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), companion3.c()), 0.5f, 0.0f, 2, null);
                                                            if (k.a(cVar)) {
                                                                str28 = "0S200MNJT807V3GE";
                                                            } else {
                                                                str28 = "0M2003OIIM08YV9M";
                                                            }
                                                            i elementVR2 = ModifierExtKt.elementVR(A, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str28));
                                                            final Function0<Unit> function0182 = this.$onRightBtnClick;
                                                            composer6.startReplaceableGroup(1157296644);
                                                            boolean changed2 = composer6.changed(function0182);
                                                            Object rememberedValue2 = composer6.rememberedValue();
                                                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$4$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        Function0<Unit> function0192 = function0182;
                                                                        if (function0192 != null) {
                                                                            function0192.invoke();
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                composer6.updateRememberedValue(rememberedValue2);
                                                            }
                                                            composer6.endReplaceableGroup();
                                                            i d17 = ViewEventPropUpdaterKt.d(elementVR2, false, null, (Function1) rememberedValue2, 3, null);
                                                            final String str30 = this.$rightBtnImagePainter;
                                                            final int i78 = this.$$dirty;
                                                            ColumnKt.a(d17, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -578852167, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.5
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(d dVar, Composer composer7, Integer num7) {
                                                                    Composer composer8 = composer7;
                                                                    int intValue3 = num7.intValue();
                                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                        composer8.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-578852167, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:193)");
                                                                        }
                                                                        ImageKt.a(str30, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 20.0f, 0.0f, 16.0f, 0.0f, 10, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i78 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer6, 24648, 12);
                                                        }
                                                        composer6.endReplaceableGroup();
                                                    } else {
                                                        composer6.startReplaceableGroup(-1319183568);
                                                        composer6.startReplaceableGroup(-1319183550);
                                                        String str31 = this.$rightTextContent;
                                                        if (str31 != null) {
                                                            if (str31.length() > 0) {
                                                                z18 = true;
                                                            }
                                                        }
                                                        if (z18) {
                                                            i f26 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null);
                                                            final Function0<Unit> function0192 = this.$onRightTextClick;
                                                            composer6.startReplaceableGroup(1157296644);
                                                            boolean changed3 = composer6.changed(function0192);
                                                            Object rememberedValue3 = composer6.rememberedValue();
                                                            if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$6$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        Function0<Unit> function020 = function0192;
                                                                        if (function020 != null) {
                                                                            function020.invoke();
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                composer6.updateRememberedValue(rememberedValue3);
                                                            }
                                                            composer6.endReplaceableGroup();
                                                            i d18 = ViewEventPropUpdaterKt.d(f26, false, null, (Function1) rememberedValue3, 3, null);
                                                            final String str32 = this.$rightTextContent;
                                                            final int i79 = this.$$dirty;
                                                            obj = null;
                                                            RowKt.a(d18, null, null, null, null, ComposableLambdaKt.composableLambda(composer6, 1105722541, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.7
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                                    int i85;
                                                                    n nVar4 = nVar3;
                                                                    Composer composer8 = composer7;
                                                                    int intValue3 = num7.intValue();
                                                                    if ((intValue3 & 14) == 0) {
                                                                        i85 = (composer8.changed(nVar4) ? 4 : 2) | intValue3;
                                                                    } else {
                                                                        i85 = intValue3;
                                                                    }
                                                                    if ((i85 & 91) == 18 && composer8.getSkipping()) {
                                                                        composer8.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(1105722541, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:204)");
                                                                        }
                                                                        h color$default = QUIToken.color$default("text_nav_secondary");
                                                                        int a17 = ai.INSTANCE.a();
                                                                        TextKt.a(str32, ModifiersKt.w(nVar4.b(i.INSTANCE, Alignment.INSTANCE.c()), QUIToken.color$default("overlay_standard_primary")), null, color$default, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, ai.f(a17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i79 >> 24) & 14) | 1601600, 0, 0, 134216612);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer6, 196616, 30);
                                                        } else {
                                                            obj = null;
                                                        }
                                                        composer6.endReplaceableGroup();
                                                        if (this.$rightBtnImagePainter != null) {
                                                            Alignment alignment = Alignment.CenterStart;
                                                            i f27 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, obj);
                                                            if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                                                str252 = "0S200MNJT807V3GE";
                                                            } else {
                                                                str252 = "0M2003OIIM08YV9M";
                                                            }
                                                            i elementVR3 = ModifierExtKt.elementVR(f27, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str252));
                                                            final Function0<Unit> function020 = this.$onRightBtnClick;
                                                            composer6.startReplaceableGroup(1157296644);
                                                            boolean changed4 = composer6.changed(function020);
                                                            Object rememberedValue4 = composer6.rememberedValue();
                                                            if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$8$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        Function0<Unit> function021 = function020;
                                                                        if (function021 != null) {
                                                                            function021.invoke();
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                composer6.updateRememberedValue(rememberedValue4);
                                                            }
                                                            composer6.endReplaceableGroup();
                                                            i d19 = ViewEventPropUpdaterKt.d(elementVR3, false, null, (Function1) rememberedValue4, 3, null);
                                                            final String str33 = this.$rightBtnImagePainter;
                                                            final int i85 = this.$$dirty;
                                                            BoxKt.a(d19, alignment, null, ComposableLambdaKt.composableLambda(composer6, 1487136136, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.9
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(b bVar4, Composer composer7, Integer num7) {
                                                                    Composer composer8 = composer7;
                                                                    int intValue3 = num7.intValue();
                                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                        composer8.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(1487136136, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:223)");
                                                                        }
                                                                        ImageKt.a(str33, null, null, null, null, ModifiersKt.A(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 12.0f, 0.0f, 16.0f, 0.0f, 10, null), 0.5f, 0.0f, 2, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i85 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer6, 3128, 4);
                                                        }
                                                        composer6.endReplaceableGroup();
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer4, 196680, 24);
                                        if (Intrinsics.areEqual(bool722, Boolean.TRUE)) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer2, 3080, 6);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            qQFlashTransferViewModel3 = qQFlashTransferViewModel2;
                            str14 = str7;
                            hVar3 = hVar2;
                            str15 = str8;
                            str16 = str11;
                            num3 = num2;
                            str17 = str9;
                            function09 = function06;
                            bool5 = bool4;
                            bool6 = bool3;
                            function010 = function01322;
                            function011 = function07;
                            f18 = f17;
                            function012 = function05;
                            str18 = str1922;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                    }
                    i49 = i17 & 16384;
                    if (i49 == 0) {
                    }
                    i56 = i49;
                    i57 = i17 & 32768;
                    if (i57 != 0) {
                    }
                    if ((i17 & 3) != 3) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) == 0) {
                    }
                    if (i59 != 0) {
                    }
                    if (i66 != 0) {
                    }
                    if ((i17 & 4) != 0) {
                    }
                    if (i67 != 0) {
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
                    if (i38 != 0) {
                    }
                    if (i46 != 0) {
                    }
                    if (i48 != 0) {
                    }
                    if (i56 != 0) {
                    }
                    if (i57 != 0) {
                    }
                    bool4 = bool9;
                    function06 = function019;
                    function07 = function018;
                    function08 = function017;
                    str12 = str25;
                    qQFlashTransferViewModel2 = qQFlashTransferViewModel;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    com.tencent.ntcompose.ui.platform.a aVar222 = (com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d());
                    final Function0<Unit> function013222 = function08;
                    final String str19222 = str10;
                    final QQFlashTransferViewModel qQFlashTransferViewModel4222 = qQFlashTransferViewModel2;
                    final Boolean bool7222 = bool4;
                    final Integer num4222 = num2;
                    final String str20222 = str8;
                    final Function0<Unit> function014222 = function06;
                    final Function0<Unit> function015222 = function07;
                    final int i69222 = i65;
                    final int i75222 = i68;
                    final String str21222 = str9;
                    final String str22222 = str11;
                    final String str23222 = str7;
                    final Boolean bool8222 = bool3;
                    final Function0<Unit> function016222 = function05;
                    final String str24222 = str13;
                    composer2 = startRestartGroup;
                    BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), hVar2), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar222)), 0.0f, aVar222.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(composer2, 1894388531, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
                        /* JADX WARN: Removed duplicated region for block: B:29:0x0140  */
                        /* JADX WARN: Removed duplicated region for block: B:32:0x0171  */
                        /* JADX WARN: Removed duplicated region for block: B:33:0x00e0  */
                        /* JADX WARN: Type inference failed for: r2v20 */
                        /* JADX WARN: Type inference failed for: r2v21 */
                        /* JADX WARN: Type inference failed for: r2v7, types: [int, boolean] */
                        @Override // kotlin.jvm.functions.Function3
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(b bVar, Composer composer3, Integer num5) {
                            int i76;
                            boolean z16;
                            boolean z17;
                            ?? r26;
                            b bVar2;
                            SnapshotStateMap<String, ab> snapshotStateMap;
                            b bVar3 = bVar;
                            Composer composer4 = composer3;
                            int intValue = num5.intValue();
                            if ((intValue & 14) == 0) {
                                i76 = (composer4.changed(bVar3) ? 4 : 2) | intValue;
                            } else {
                                i76 = intValue;
                            }
                            if ((i76 & 91) == 18 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1894388531, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous> (QQFTNavBar.kt:69)");
                                }
                                i.Companion companion = i.INSTANCE;
                                RowKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterStart), null, null, null, null, ComposableLambdaKt.composableLambda(composer4, 1884949333, true, new Function3<n, Composer, Integer, Unit>(num4222, QQFlashTransferViewModel.this, str20222, function014222, function015222, i69222, i75222, str21222, str22222, str23222, str19222) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.1
                                    public final /* synthetic */ int $$dirty;
                                    public final /* synthetic */ String $leftBtnImagePainter;
                                    public final /* synthetic */ String $leftTextContent;
                                    public final /* synthetic */ Integer $modalMode;
                                    public final /* synthetic */ String $navImagePainter;
                                    public final /* synthetic */ String $navTitle;
                                    public final /* synthetic */ Function0<Unit> $onLeftBtnClick;
                                    public final /* synthetic */ Function0<Unit> $onLeftTextClick;
                                    public final /* synthetic */ String $rightBtnImagePainter;
                                    public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                        this.$navTitle = r8;
                                        this.$rightBtnImagePainter = r9;
                                        this.$leftBtnImagePainter = r10;
                                        this.$navImagePainter = r11;
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
                                    
                                        if (((r1 == null || r1.isSecondaryPage()) ? false : true) == false) goto L23;
                                     */
                                    /* JADX WARN: Code restructure failed: missing block: B:39:0x0118, code lost:
                                    
                                        if ((r23.$navTitle.length() > 0) == false) goto L54;
                                     */
                                    /* JADX WARN: Removed duplicated region for block: B:26:0x00b7  */
                                    /* JADX WARN: Removed duplicated region for block: B:30:0x00fd  */
                                    /* JADX WARN: Removed duplicated region for block: B:36:0x010e  */
                                    /* JADX WARN: Removed duplicated region for block: B:42:0x0163  */
                                    /* JADX WARN: Removed duplicated region for block: B:55:0x007b  */
                                    @Override // kotlin.jvm.functions.Function3
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                                        boolean z18;
                                        float f19;
                                        boolean changed;
                                        Object rememberedValue;
                                        QQFlashTransferViewModel qQFlashTransferViewModel52;
                                        SnapshotStateMap<String, ab> snapshotStateMap2;
                                        Composer composer6 = composer5;
                                        int intValue2 = num6.intValue();
                                        if ((intValue2 & 81) == 16 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1884949333, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:70)");
                                            }
                                            com.tencent.ntcompose.foundation.layout.base.a aVar2222 = com.tencent.ntcompose.foundation.layout.base.a.f339245a;
                                            a.e b16 = aVar2222.b();
                                            i.Companion companion2 = i.INSTANCE;
                                            i f26 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                            Integer num7 = this.$modalMode;
                                            if (num7 != null && num7.intValue() == 1) {
                                                QQFlashTransferViewModel qQFlashTransferViewModel6 = this.$viewModel;
                                            }
                                            String str252 = this.$leftTextContent;
                                            if (str252 != null) {
                                                if (str252.length() > 0) {
                                                    z18 = true;
                                                    if (!z18) {
                                                        f19 = 10.0f;
                                                        i a16222222 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                                        final String str26222222 = this.$leftTextContent;
                                                        final Function0<Unit> function017222222 = this.$onLeftTextClick;
                                                        final Function0<Unit> function018222222 = this.$onLeftBtnClick;
                                                        composer6.startReplaceableGroup(1618982084);
                                                        changed = composer6.changed(str26222222) | composer6.changed(function017222222) | composer6.changed(function018222222);
                                                        rememberedValue = composer6.rememberedValue();
                                                        if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    String str27222222 = str26222222;
                                                                    boolean z19 = false;
                                                                    if (str27222222 != null) {
                                                                        if (str27222222.length() > 0) {
                                                                            z19 = true;
                                                                        }
                                                                    }
                                                                    if (z19) {
                                                                        Function0<Unit> function0192 = function017222222;
                                                                        if (function0192 != null) {
                                                                            function0192.invoke();
                                                                        }
                                                                    } else {
                                                                        Function0<Unit> function020 = function018222222;
                                                                        if (function020 != null) {
                                                                            function020.invoke();
                                                                        } else {
                                                                            QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            composer6.updateRememberedValue(rememberedValue);
                                                        }
                                                        composer6.endReplaceableGroup();
                                                        i A222222 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a16222222, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                                        final String str27222222 = this.$leftTextContent;
                                                        final int i77222222 = this.$$dirty;
                                                        final String str28222222 = this.$leftBtnImagePainter;
                                                        ColumnKt.a(A222222, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                Composer composer8 = composer7;
                                                                int intValue3 = num8.intValue();
                                                                if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                    composer8.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                                    }
                                                                    String str29222222 = str27222222;
                                                                    boolean z19 = false;
                                                                    if (str29222222 != null) {
                                                                        if (str29222222.length() > 0) {
                                                                            z19 = true;
                                                                        }
                                                                    }
                                                                    if (z19) {
                                                                        composer8.startReplaceableGroup(2107916874);
                                                                        TextKt.a(str27222222, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i77222222 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                                        composer8.endReplaceableGroup();
                                                                    } else {
                                                                        composer8.startReplaceableGroup(2107917260);
                                                                        ImageKt.a(str28222222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i77222222 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                                        composer8.endReplaceableGroup();
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer6, 24648, 12);
                                                        qQFlashTransferViewModel52 = this.$viewModel;
                                                        if (qQFlashTransferViewModel52 == null && (snapshotStateMap2 = qQFlashTransferViewModel52.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                                        }
                                                        i n3622222 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                        a.e b17222222 = aVar2222.b();
                                                        final QQFlashTransferViewModel qQFlashTransferViewModel7222222 = this.$viewModel;
                                                        final String str29222222 = this.$navTitle;
                                                        final String str30222222 = this.$rightBtnImagePainter;
                                                        final String str31222222 = this.$navImagePainter;
                                                        final int i78222222 = this.$$dirty;
                                                        ColumnKt.a(n3622222, b17222222, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                                Composer composer8 = composer7;
                                                                int intValue3 = num8.intValue();
                                                                if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                    composer8.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                                    }
                                                                    i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                                    final String str32 = str31222222;
                                                                    final int i79 = i78222222;
                                                                    final String str33 = str29222222;
                                                                    RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                                            int i85;
                                                                            Composer composer10;
                                                                            Map mutableMapOf;
                                                                            n nVar3 = nVar2;
                                                                            Composer composer11 = composer9;
                                                                            int intValue4 = num9.intValue();
                                                                            if ((intValue4 & 14) == 0) {
                                                                                i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                                            } else {
                                                                                i85 = intValue4;
                                                                            }
                                                                            if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                                                composer11.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                                                }
                                                                                composer11.startReplaceableGroup(-1116923971);
                                                                                if (str32 != null) {
                                                                                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                                    composer10 = composer11;
                                                                                    ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                                                } else {
                                                                                    composer10 = composer11;
                                                                                }
                                                                                composer10.endReplaceableGroup();
                                                                                TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer8, 196616, 30);
                                                                    if (QQFlashTransferViewModel.this != null) {
                                                                        if (str29222222.length() > 0) {
                                                                            QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str30222222), true, composer8, 25142, 0);
                                                                        }
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer6, 24648, 12);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    f19 = 16.0f;
                                                    i a162222222 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                                    final String str262222222 = this.$leftTextContent;
                                                    final Function0<Unit> function0172222222 = this.$onLeftTextClick;
                                                    final Function0<Unit> function0182222222 = this.$onLeftBtnClick;
                                                    composer6.startReplaceableGroup(1618982084);
                                                    changed = composer6.changed(str262222222) | composer6.changed(function0172222222) | composer6.changed(function0182222222);
                                                    rememberedValue = composer6.rememberedValue();
                                                    if (!changed) {
                                                    }
                                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            String str272222222 = str262222222;
                                                            boolean z19 = false;
                                                            if (str272222222 != null) {
                                                                if (str272222222.length() > 0) {
                                                                    z19 = true;
                                                                }
                                                            }
                                                            if (z19) {
                                                                Function0<Unit> function0192 = function0172222222;
                                                                if (function0192 != null) {
                                                                    function0192.invoke();
                                                                }
                                                            } else {
                                                                Function0<Unit> function020 = function0182222222;
                                                                if (function020 != null) {
                                                                    function020.invoke();
                                                                } else {
                                                                    QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer6.updateRememberedValue(rememberedValue);
                                                    composer6.endReplaceableGroup();
                                                    i A2222222 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a162222222, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                                    final String str272222222 = this.$leftTextContent;
                                                    final int i772222222 = this.$$dirty;
                                                    final String str282222222 = this.$leftBtnImagePainter;
                                                    ColumnKt.a(A2222222, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                            Composer composer8 = composer7;
                                                            int intValue3 = num8.intValue();
                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                composer8.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                                }
                                                                String str292222222 = str272222222;
                                                                boolean z19 = false;
                                                                if (str292222222 != null) {
                                                                    if (str292222222.length() > 0) {
                                                                        z19 = true;
                                                                    }
                                                                }
                                                                if (z19) {
                                                                    composer8.startReplaceableGroup(2107916874);
                                                                    TextKt.a(str272222222, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i772222222 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                                    composer8.endReplaceableGroup();
                                                                } else {
                                                                    composer8.startReplaceableGroup(2107917260);
                                                                    ImageKt.a(str282222222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i772222222 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                                    composer8.endReplaceableGroup();
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer6, 24648, 12);
                                                    qQFlashTransferViewModel52 = this.$viewModel;
                                                    if (qQFlashTransferViewModel52 == null && (snapshotStateMap2 = qQFlashTransferViewModel52.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                                    }
                                                    i n36222222 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                    a.e b172222222 = aVar2222.b();
                                                    final QQFlashTransferViewModel qQFlashTransferViewModel72222222 = this.$viewModel;
                                                    final String str292222222 = this.$navTitle;
                                                    final String str302222222 = this.$rightBtnImagePainter;
                                                    final String str312222222 = this.$navImagePainter;
                                                    final int i782222222 = this.$$dirty;
                                                    ColumnKt.a(n36222222, b172222222, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                            Composer composer8 = composer7;
                                                            int intValue3 = num8.intValue();
                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                composer8.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                                }
                                                                i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                                final String str32 = str312222222;
                                                                final int i79 = i782222222;
                                                                final String str33 = str292222222;
                                                                RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                                        int i85;
                                                                        Composer composer10;
                                                                        Map mutableMapOf;
                                                                        n nVar3 = nVar2;
                                                                        Composer composer11 = composer9;
                                                                        int intValue4 = num9.intValue();
                                                                        if ((intValue4 & 14) == 0) {
                                                                            i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                                        } else {
                                                                            i85 = intValue4;
                                                                        }
                                                                        if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                                            composer11.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                                            }
                                                                            composer11.startReplaceableGroup(-1116923971);
                                                                            if (str32 != null) {
                                                                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                                composer10 = composer11;
                                                                                ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                                            } else {
                                                                                composer10 = composer11;
                                                                            }
                                                                            composer10.endReplaceableGroup();
                                                                            TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer8, 196616, 30);
                                                                if (QQFlashTransferViewModel.this != null) {
                                                                    if (str292222222.length() > 0) {
                                                                        QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str302222222), true, composer8, 25142, 0);
                                                                    }
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer6, 24648, 12);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                }
                                            }
                                            z18 = false;
                                            if (!z18) {
                                            }
                                            f19 = 16.0f;
                                            i a1622222222 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                            final String str2622222222 = this.$leftTextContent;
                                            final Function0<Unit> function01722222222 = this.$onLeftTextClick;
                                            final Function0<Unit> function01822222222 = this.$onLeftBtnClick;
                                            composer6.startReplaceableGroup(1618982084);
                                            changed = composer6.changed(str2622222222) | composer6.changed(function01722222222) | composer6.changed(function01822222222);
                                            rememberedValue = composer6.rememberedValue();
                                            if (!changed) {
                                            }
                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    String str2722222222 = str2622222222;
                                                    boolean z19 = false;
                                                    if (str2722222222 != null) {
                                                        if (str2722222222.length() > 0) {
                                                            z19 = true;
                                                        }
                                                    }
                                                    if (z19) {
                                                        Function0<Unit> function0192 = function01722222222;
                                                        if (function0192 != null) {
                                                            function0192.invoke();
                                                        }
                                                    } else {
                                                        Function0<Unit> function020 = function01822222222;
                                                        if (function020 != null) {
                                                            function020.invoke();
                                                        } else {
                                                            QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer6.updateRememberedValue(rememberedValue);
                                            composer6.endReplaceableGroup();
                                            i A22222222 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a1622222222, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                            final String str2722222222 = this.$leftTextContent;
                                            final int i7722222222 = this.$$dirty;
                                            final String str2822222222 = this.$leftBtnImagePainter;
                                            ColumnKt.a(A22222222, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                    Composer composer8 = composer7;
                                                    int intValue3 = num8.intValue();
                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                        composer8.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                        }
                                                        String str2922222222 = str2722222222;
                                                        boolean z19 = false;
                                                        if (str2922222222 != null) {
                                                            if (str2922222222.length() > 0) {
                                                                z19 = true;
                                                            }
                                                        }
                                                        if (z19) {
                                                            composer8.startReplaceableGroup(2107916874);
                                                            TextKt.a(str2722222222, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i7722222222 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                            composer8.endReplaceableGroup();
                                                        } else {
                                                            composer8.startReplaceableGroup(2107917260);
                                                            ImageKt.a(str2822222222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i7722222222 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                            composer8.endReplaceableGroup();
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer6, 24648, 12);
                                            qQFlashTransferViewModel52 = this.$viewModel;
                                            if (qQFlashTransferViewModel52 == null && (snapshotStateMap2 = qQFlashTransferViewModel52.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                            }
                                            i n362222222 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                            a.e b1722222222 = aVar2222.b();
                                            final QQFlashTransferViewModel qQFlashTransferViewModel722222222 = this.$viewModel;
                                            final String str2922222222 = this.$navTitle;
                                            final String str3022222222 = this.$rightBtnImagePainter;
                                            final String str3122222222 = this.$navImagePainter;
                                            final int i7822222222 = this.$$dirty;
                                            ColumnKt.a(n362222222, b1722222222, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                    Composer composer8 = composer7;
                                                    int intValue3 = num8.intValue();
                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                        composer8.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                        }
                                                        i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                        final String str32 = str3122222222;
                                                        final int i79 = i7822222222;
                                                        final String str33 = str2922222222;
                                                        RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                                int i85;
                                                                Composer composer10;
                                                                Map mutableMapOf;
                                                                n nVar3 = nVar2;
                                                                Composer composer11 = composer9;
                                                                int intValue4 = num9.intValue();
                                                                if ((intValue4 & 14) == 0) {
                                                                    i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                                } else {
                                                                    i85 = intValue4;
                                                                }
                                                                if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                                    composer11.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                                    }
                                                                    composer11.startReplaceableGroup(-1116923971);
                                                                    if (str32 != null) {
                                                                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                        composer10 = composer11;
                                                                        ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                                    } else {
                                                                        composer10 = composer11;
                                                                    }
                                                                    composer10.endReplaceableGroup();
                                                                    TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer8, 196616, 30);
                                                        if (QQFlashTransferViewModel.this != null) {
                                                            if (str2922222222.length() > 0) {
                                                                QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str3022222222), true, composer8, 25142, 0);
                                                            }
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer6, 24648, 12);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer4, 196616, 30);
                                composer4.startReplaceableGroup(-1240831040);
                                QQFlashTransferViewModel qQFlashTransferViewModel52 = QQFlashTransferViewModel.this;
                                if (qQFlashTransferViewModel52 == null || (snapshotStateMap = qQFlashTransferViewModel52.selectFilesToDownload) == null) {
                                    z16 = true;
                                } else {
                                    z16 = true;
                                    r26 = 1;
                                    if (!snapshotStateMap.isEmpty()) {
                                        z17 = true;
                                        if (z17) {
                                            bVar2 = bVar3;
                                        } else {
                                            bVar2 = bVar3;
                                            i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, r26, null), Alignment.Center);
                                            final QQFlashTransferViewModel qQFlashTransferViewModel6 = QQFlashTransferViewModel.this;
                                            BoxKt.a(a16, null, null, ComposableLambdaKt.composableLambda(composer4, -408684780, r26, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.2
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(b bVar4, Composer composer5, Integer num6) {
                                                    int i77;
                                                    b bVar5 = bVar4;
                                                    Composer composer6 = composer5;
                                                    int intValue2 = num6.intValue();
                                                    if ((intValue2 & 14) == 0) {
                                                        i77 = (composer6.changed(bVar5) ? 4 : 2) | intValue2;
                                                    } else {
                                                        i77 = intValue2;
                                                    }
                                                    if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                                        composer6.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-408684780, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:145)");
                                                        }
                                                        QQFTDownloadBarViewKt.selectFileInfoStrView(bVar5.a(i.INSTANCE, Alignment.Center), QQFlashTransferViewModel.this, composer6, 72);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer4, 3080, 6);
                                        }
                                        composer4.endReplaceableGroup();
                                        RowKt.a(ComposeLayoutPropUpdaterKt.f(bVar2.a(companion, Alignment.CenterEnd), 0.0f, 1, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.c(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer4, 83640332, true, new Function3<n, Composer, Integer, Unit>(bool8222, function013222, i75222, i69222, QQFlashTransferViewModel.this, str22222, function016222, str24222) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.3
                                            public final /* synthetic */ int $$dirty;
                                            public final /* synthetic */ Function0<Unit> $onRightBtnClick;
                                            public final /* synthetic */ Function0<Unit> $onRightTextClick;
                                            public final /* synthetic */ String $rightBtnImagePainter;
                                            public final /* synthetic */ String $rightTextContent;
                                            public final /* synthetic */ Boolean $showCheckBox;
                                            public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                                this.$$dirty = r4;
                                                this.$viewModel = r5;
                                                this.$rightBtnImagePainter = r6;
                                                this.$onRightBtnClick = r7;
                                                this.$rightTextContent = r8;
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                                                int i77;
                                                Object obj;
                                                String str252;
                                                String str262;
                                                String str27;
                                                String str28;
                                                MutableState<Boolean> mutableState;
                                                n nVar2 = nVar;
                                                Composer composer6 = composer5;
                                                int intValue2 = num6.intValue();
                                                if ((intValue2 & 14) == 0) {
                                                    i77 = (composer6.changed(nVar2) ? 4 : 2) | intValue2;
                                                } else {
                                                    i77 = intValue2;
                                                }
                                                if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                                    composer6.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(83640332, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:158)");
                                                    }
                                                    boolean z18 = false;
                                                    if (Intrinsics.areEqual(this.$showCheckBox, Boolean.TRUE)) {
                                                        composer6.startReplaceableGroup(-1319185738);
                                                        i.Companion companion2 = i.INSTANCE;
                                                        i f19 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                                        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                                        if (k.a(cVar)) {
                                                            str262 = "0S200MNJT807V3GE";
                                                        } else {
                                                            str262 = "0M2003OIIM08YV9M";
                                                        }
                                                        e dTBaseParams = DTReportConstKt.getDTBaseParams(str262);
                                                        QQFlashTransferViewModel qQFlashTransferViewModel7 = this.$viewModel;
                                                        if (qQFlashTransferViewModel7 != null && (mutableState = qQFlashTransferViewModel7.isAllSelectMode) != null && mutableState.getValue().booleanValue()) {
                                                            z18 = true;
                                                        }
                                                        if (z18) {
                                                            str27 = "1";
                                                        } else {
                                                            str27 = "0";
                                                        }
                                                        dTBaseParams.v("is_screen", str27);
                                                        Unit unit = Unit.INSTANCE;
                                                        i elementVR = ModifierExtKt.elementVR(f19, "em_bas_select_all", dTBaseParams);
                                                        final Boolean bool92 = this.$showCheckBox;
                                                        final Function0<Unit> function0172 = this.$onRightTextClick;
                                                        composer6.startReplaceableGroup(511388516);
                                                        boolean changed = composer6.changed(bool92) | composer6.changed(function0172);
                                                        Object rememberedValue = composer6.rememberedValue();
                                                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$2$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    Function0<Unit> function0182;
                                                                    if (Intrinsics.areEqual(bool92, Boolean.TRUE) && (function0182 = function0172) != null) {
                                                                        function0182.invoke();
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            composer6.updateRememberedValue(rememberedValue);
                                                        }
                                                        composer6.endReplaceableGroup();
                                                        i d16 = ViewEventPropUpdaterKt.d(elementVR, false, null, (Function1) rememberedValue, 3, null);
                                                        Alignment.Companion companion3 = Alignment.INSTANCE;
                                                        Alignment.Vertical c16 = companion3.c();
                                                        final QQFlashTransferViewModel qQFlashTransferViewModel8 = this.$viewModel;
                                                        final String str29 = this.$rightBtnImagePainter;
                                                        RowKt.a(d16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer6, 762994953, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                                SnapshotStateMap<String, ab> snapshotStateMap2;
                                                                MutableState<Boolean> mutableState2;
                                                                Composer composer8 = composer7;
                                                                int intValue3 = num7.intValue();
                                                                if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                    composer8.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(762994953, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:169)");
                                                                    }
                                                                    i.Companion companion4 = i.INSTANCE;
                                                                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), 4.0f, 0.0f, 4.0f, 0.0f, 10, null);
                                                                    QQFlashTransferViewModel qQFlashTransferViewModel9 = QQFlashTransferViewModel.this;
                                                                    boolean z19 = false;
                                                                    QQFTCheckBoxViewKt.QQFTCheckBoxView(n3, 0.0f, (qQFlashTransferViewModel9 == null || (mutableState2 = qQFlashTransferViewModel9.isAllSelectMode) == null || !mutableState2.getValue().booleanValue()) ? false : true, null, null, false, composer8, 8, 58);
                                                                    QQFlashTransferViewModel qQFlashTransferViewModel10 = QQFlashTransferViewModel.this;
                                                                    if (qQFlashTransferViewModel10 != null && (snapshotStateMap2 = qQFlashTransferViewModel10.selectFilesToDownload) != null && (!snapshotStateMap2.isEmpty())) {
                                                                        z19 = true;
                                                                    }
                                                                    TextKt.a("\u5168\u9009", ComposeLayoutPropUpdaterKt.n(companion4, 0.0f, 0.0f, (z19 || str29 == null) ? 16.0f : 0.0f, 0.0f, 11, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, 1601606, 0, 0, 134216612);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer6, 196616, 26);
                                                        QQFlashTransferViewModel qQFlashTransferViewModel9 = this.$viewModel;
                                                        if (((qQFlashTransferViewModel9 != null ? qQFlashTransferViewModel9.selectFilesToDownload : null) == null || qQFlashTransferViewModel9.selectFilesToDownload.size() <= 0) && this.$rightBtnImagePainter != null) {
                                                            a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                            i A = ModifiersKt.A(nVar2.b(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), companion3.c()), 0.5f, 0.0f, 2, null);
                                                            if (k.a(cVar)) {
                                                                str28 = "0S200MNJT807V3GE";
                                                            } else {
                                                                str28 = "0M2003OIIM08YV9M";
                                                            }
                                                            i elementVR2 = ModifierExtKt.elementVR(A, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str28));
                                                            final Function0<Unit> function0182 = this.$onRightBtnClick;
                                                            composer6.startReplaceableGroup(1157296644);
                                                            boolean changed2 = composer6.changed(function0182);
                                                            Object rememberedValue2 = composer6.rememberedValue();
                                                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$4$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        Function0<Unit> function0192 = function0182;
                                                                        if (function0192 != null) {
                                                                            function0192.invoke();
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                composer6.updateRememberedValue(rememberedValue2);
                                                            }
                                                            composer6.endReplaceableGroup();
                                                            i d17 = ViewEventPropUpdaterKt.d(elementVR2, false, null, (Function1) rememberedValue2, 3, null);
                                                            final String str30 = this.$rightBtnImagePainter;
                                                            final int i78 = this.$$dirty;
                                                            ColumnKt.a(d17, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -578852167, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.5
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(d dVar, Composer composer7, Integer num7) {
                                                                    Composer composer8 = composer7;
                                                                    int intValue3 = num7.intValue();
                                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                        composer8.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-578852167, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:193)");
                                                                        }
                                                                        ImageKt.a(str30, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 20.0f, 0.0f, 16.0f, 0.0f, 10, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i78 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer6, 24648, 12);
                                                        }
                                                        composer6.endReplaceableGroup();
                                                    } else {
                                                        composer6.startReplaceableGroup(-1319183568);
                                                        composer6.startReplaceableGroup(-1319183550);
                                                        String str31 = this.$rightTextContent;
                                                        if (str31 != null) {
                                                            if (str31.length() > 0) {
                                                                z18 = true;
                                                            }
                                                        }
                                                        if (z18) {
                                                            i f26 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null);
                                                            final Function0<Unit> function0192 = this.$onRightTextClick;
                                                            composer6.startReplaceableGroup(1157296644);
                                                            boolean changed3 = composer6.changed(function0192);
                                                            Object rememberedValue3 = composer6.rememberedValue();
                                                            if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$6$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        Function0<Unit> function020 = function0192;
                                                                        if (function020 != null) {
                                                                            function020.invoke();
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                composer6.updateRememberedValue(rememberedValue3);
                                                            }
                                                            composer6.endReplaceableGroup();
                                                            i d18 = ViewEventPropUpdaterKt.d(f26, false, null, (Function1) rememberedValue3, 3, null);
                                                            final String str32 = this.$rightTextContent;
                                                            final int i79 = this.$$dirty;
                                                            obj = null;
                                                            RowKt.a(d18, null, null, null, null, ComposableLambdaKt.composableLambda(composer6, 1105722541, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.7
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                                    int i85;
                                                                    n nVar4 = nVar3;
                                                                    Composer composer8 = composer7;
                                                                    int intValue3 = num7.intValue();
                                                                    if ((intValue3 & 14) == 0) {
                                                                        i85 = (composer8.changed(nVar4) ? 4 : 2) | intValue3;
                                                                    } else {
                                                                        i85 = intValue3;
                                                                    }
                                                                    if ((i85 & 91) == 18 && composer8.getSkipping()) {
                                                                        composer8.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(1105722541, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:204)");
                                                                        }
                                                                        h color$default = QUIToken.color$default("text_nav_secondary");
                                                                        int a17 = ai.INSTANCE.a();
                                                                        TextKt.a(str32, ModifiersKt.w(nVar4.b(i.INSTANCE, Alignment.INSTANCE.c()), QUIToken.color$default("overlay_standard_primary")), null, color$default, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, ai.f(a17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i79 >> 24) & 14) | 1601600, 0, 0, 134216612);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer6, 196616, 30);
                                                        } else {
                                                            obj = null;
                                                        }
                                                        composer6.endReplaceableGroup();
                                                        if (this.$rightBtnImagePainter != null) {
                                                            Alignment alignment = Alignment.CenterStart;
                                                            i f27 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, obj);
                                                            if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                                                str252 = "0S200MNJT807V3GE";
                                                            } else {
                                                                str252 = "0M2003OIIM08YV9M";
                                                            }
                                                            i elementVR3 = ModifierExtKt.elementVR(f27, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str252));
                                                            final Function0<Unit> function020 = this.$onRightBtnClick;
                                                            composer6.startReplaceableGroup(1157296644);
                                                            boolean changed4 = composer6.changed(function020);
                                                            Object rememberedValue4 = composer6.rememberedValue();
                                                            if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$8$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        Function0<Unit> function021 = function020;
                                                                        if (function021 != null) {
                                                                            function021.invoke();
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                composer6.updateRememberedValue(rememberedValue4);
                                                            }
                                                            composer6.endReplaceableGroup();
                                                            i d19 = ViewEventPropUpdaterKt.d(elementVR3, false, null, (Function1) rememberedValue4, 3, null);
                                                            final String str33 = this.$rightBtnImagePainter;
                                                            final int i85 = this.$$dirty;
                                                            BoxKt.a(d19, alignment, null, ComposableLambdaKt.composableLambda(composer6, 1487136136, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.9
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(b bVar4, Composer composer7, Integer num7) {
                                                                    Composer composer8 = composer7;
                                                                    int intValue3 = num7.intValue();
                                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                        composer8.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(1487136136, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:223)");
                                                                        }
                                                                        ImageKt.a(str33, null, null, null, null, ModifiersKt.A(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 12.0f, 0.0f, 16.0f, 0.0f, 10, null), 0.5f, 0.0f, 2, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i85 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer6, 3128, 4);
                                                        }
                                                        composer6.endReplaceableGroup();
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer4, 196680, 24);
                                        if (Intrinsics.areEqual(bool7222, Boolean.TRUE)) {
                                            SurfaceKt.a(ModifiersKt.c(bVar2.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 0.5f), Alignment.BottomCenter), QUIToken.color$default("border_light")), null, null, null, ComposableSingletons$QQFTNavBarKt.f144lambda1, composer4, 24584, 14);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }
                                z17 = false;
                                r26 = z16;
                                if (z17) {
                                }
                                composer4.endReplaceableGroup();
                                RowKt.a(ComposeLayoutPropUpdaterKt.f(bVar2.a(companion, Alignment.CenterEnd), 0.0f, 1, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.c(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer4, 83640332, true, new Function3<n, Composer, Integer, Unit>(bool8222, function013222, i75222, i69222, QQFlashTransferViewModel.this, str22222, function016222, str24222) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.3
                                    public final /* synthetic */ int $$dirty;
                                    public final /* synthetic */ Function0<Unit> $onRightBtnClick;
                                    public final /* synthetic */ Function0<Unit> $onRightTextClick;
                                    public final /* synthetic */ String $rightBtnImagePainter;
                                    public final /* synthetic */ String $rightTextContent;
                                    public final /* synthetic */ Boolean $showCheckBox;
                                    public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                        this.$$dirty = r4;
                                        this.$viewModel = r5;
                                        this.$rightBtnImagePainter = r6;
                                        this.$onRightBtnClick = r7;
                                        this.$rightTextContent = r8;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                                        int i77;
                                        Object obj;
                                        String str252;
                                        String str262;
                                        String str27;
                                        String str28;
                                        MutableState<Boolean> mutableState;
                                        n nVar2 = nVar;
                                        Composer composer6 = composer5;
                                        int intValue2 = num6.intValue();
                                        if ((intValue2 & 14) == 0) {
                                            i77 = (composer6.changed(nVar2) ? 4 : 2) | intValue2;
                                        } else {
                                            i77 = intValue2;
                                        }
                                        if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(83640332, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:158)");
                                            }
                                            boolean z18 = false;
                                            if (Intrinsics.areEqual(this.$showCheckBox, Boolean.TRUE)) {
                                                composer6.startReplaceableGroup(-1319185738);
                                                i.Companion companion2 = i.INSTANCE;
                                                i f19 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                                com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                                if (k.a(cVar)) {
                                                    str262 = "0S200MNJT807V3GE";
                                                } else {
                                                    str262 = "0M2003OIIM08YV9M";
                                                }
                                                e dTBaseParams = DTReportConstKt.getDTBaseParams(str262);
                                                QQFlashTransferViewModel qQFlashTransferViewModel7 = this.$viewModel;
                                                if (qQFlashTransferViewModel7 != null && (mutableState = qQFlashTransferViewModel7.isAllSelectMode) != null && mutableState.getValue().booleanValue()) {
                                                    z18 = true;
                                                }
                                                if (z18) {
                                                    str27 = "1";
                                                } else {
                                                    str27 = "0";
                                                }
                                                dTBaseParams.v("is_screen", str27);
                                                Unit unit = Unit.INSTANCE;
                                                i elementVR = ModifierExtKt.elementVR(f19, "em_bas_select_all", dTBaseParams);
                                                final Boolean bool92 = this.$showCheckBox;
                                                final Function0<Unit> function0172 = this.$onRightTextClick;
                                                composer6.startReplaceableGroup(511388516);
                                                boolean changed = composer6.changed(bool92) | composer6.changed(function0172);
                                                Object rememberedValue = composer6.rememberedValue();
                                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$2$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            Function0<Unit> function0182;
                                                            if (Intrinsics.areEqual(bool92, Boolean.TRUE) && (function0182 = function0172) != null) {
                                                                function0182.invoke();
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer6.updateRememberedValue(rememberedValue);
                                                }
                                                composer6.endReplaceableGroup();
                                                i d16 = ViewEventPropUpdaterKt.d(elementVR, false, null, (Function1) rememberedValue, 3, null);
                                                Alignment.Companion companion3 = Alignment.INSTANCE;
                                                Alignment.Vertical c16 = companion3.c();
                                                final QQFlashTransferViewModel qQFlashTransferViewModel8 = this.$viewModel;
                                                final String str29 = this.$rightBtnImagePainter;
                                                RowKt.a(d16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer6, 762994953, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                        SnapshotStateMap<String, ab> snapshotStateMap2;
                                                        MutableState<Boolean> mutableState2;
                                                        Composer composer8 = composer7;
                                                        int intValue3 = num7.intValue();
                                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                            composer8.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(762994953, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:169)");
                                                            }
                                                            i.Companion companion4 = i.INSTANCE;
                                                            i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), 4.0f, 0.0f, 4.0f, 0.0f, 10, null);
                                                            QQFlashTransferViewModel qQFlashTransferViewModel9 = QQFlashTransferViewModel.this;
                                                            boolean z19 = false;
                                                            QQFTCheckBoxViewKt.QQFTCheckBoxView(n3, 0.0f, (qQFlashTransferViewModel9 == null || (mutableState2 = qQFlashTransferViewModel9.isAllSelectMode) == null || !mutableState2.getValue().booleanValue()) ? false : true, null, null, false, composer8, 8, 58);
                                                            QQFlashTransferViewModel qQFlashTransferViewModel10 = QQFlashTransferViewModel.this;
                                                            if (qQFlashTransferViewModel10 != null && (snapshotStateMap2 = qQFlashTransferViewModel10.selectFilesToDownload) != null && (!snapshotStateMap2.isEmpty())) {
                                                                z19 = true;
                                                            }
                                                            TextKt.a("\u5168\u9009", ComposeLayoutPropUpdaterKt.n(companion4, 0.0f, 0.0f, (z19 || str29 == null) ? 16.0f : 0.0f, 0.0f, 11, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, 1601606, 0, 0, 134216612);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer6, 196616, 26);
                                                QQFlashTransferViewModel qQFlashTransferViewModel9 = this.$viewModel;
                                                if (((qQFlashTransferViewModel9 != null ? qQFlashTransferViewModel9.selectFilesToDownload : null) == null || qQFlashTransferViewModel9.selectFilesToDownload.size() <= 0) && this.$rightBtnImagePainter != null) {
                                                    a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                    i A = ModifiersKt.A(nVar2.b(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), companion3.c()), 0.5f, 0.0f, 2, null);
                                                    if (k.a(cVar)) {
                                                        str28 = "0S200MNJT807V3GE";
                                                    } else {
                                                        str28 = "0M2003OIIM08YV9M";
                                                    }
                                                    i elementVR2 = ModifierExtKt.elementVR(A, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str28));
                                                    final Function0<Unit> function0182 = this.$onRightBtnClick;
                                                    composer6.startReplaceableGroup(1157296644);
                                                    boolean changed2 = composer6.changed(function0182);
                                                    Object rememberedValue2 = composer6.rememberedValue();
                                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$4$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Function0<Unit> function0192 = function0182;
                                                                if (function0192 != null) {
                                                                    function0192.invoke();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        composer6.updateRememberedValue(rememberedValue2);
                                                    }
                                                    composer6.endReplaceableGroup();
                                                    i d17 = ViewEventPropUpdaterKt.d(elementVR2, false, null, (Function1) rememberedValue2, 3, null);
                                                    final String str30 = this.$rightBtnImagePainter;
                                                    final int i78 = this.$$dirty;
                                                    ColumnKt.a(d17, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -578852167, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.5
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(d dVar, Composer composer7, Integer num7) {
                                                            Composer composer8 = composer7;
                                                            int intValue3 = num7.intValue();
                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                composer8.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-578852167, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:193)");
                                                                }
                                                                ImageKt.a(str30, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 20.0f, 0.0f, 16.0f, 0.0f, 10, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i78 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer6, 24648, 12);
                                                }
                                                composer6.endReplaceableGroup();
                                            } else {
                                                composer6.startReplaceableGroup(-1319183568);
                                                composer6.startReplaceableGroup(-1319183550);
                                                String str31 = this.$rightTextContent;
                                                if (str31 != null) {
                                                    if (str31.length() > 0) {
                                                        z18 = true;
                                                    }
                                                }
                                                if (z18) {
                                                    i f26 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null);
                                                    final Function0<Unit> function0192 = this.$onRightTextClick;
                                                    composer6.startReplaceableGroup(1157296644);
                                                    boolean changed3 = composer6.changed(function0192);
                                                    Object rememberedValue3 = composer6.rememberedValue();
                                                    if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$6$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Function0<Unit> function020 = function0192;
                                                                if (function020 != null) {
                                                                    function020.invoke();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        composer6.updateRememberedValue(rememberedValue3);
                                                    }
                                                    composer6.endReplaceableGroup();
                                                    i d18 = ViewEventPropUpdaterKt.d(f26, false, null, (Function1) rememberedValue3, 3, null);
                                                    final String str32 = this.$rightTextContent;
                                                    final int i79 = this.$$dirty;
                                                    obj = null;
                                                    RowKt.a(d18, null, null, null, null, ComposableLambdaKt.composableLambda(composer6, 1105722541, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.7
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                            int i85;
                                                            n nVar4 = nVar3;
                                                            Composer composer8 = composer7;
                                                            int intValue3 = num7.intValue();
                                                            if ((intValue3 & 14) == 0) {
                                                                i85 = (composer8.changed(nVar4) ? 4 : 2) | intValue3;
                                                            } else {
                                                                i85 = intValue3;
                                                            }
                                                            if ((i85 & 91) == 18 && composer8.getSkipping()) {
                                                                composer8.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1105722541, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:204)");
                                                                }
                                                                h color$default = QUIToken.color$default("text_nav_secondary");
                                                                int a17 = ai.INSTANCE.a();
                                                                TextKt.a(str32, ModifiersKt.w(nVar4.b(i.INSTANCE, Alignment.INSTANCE.c()), QUIToken.color$default("overlay_standard_primary")), null, color$default, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, ai.f(a17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i79 >> 24) & 14) | 1601600, 0, 0, 134216612);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer6, 196616, 30);
                                                } else {
                                                    obj = null;
                                                }
                                                composer6.endReplaceableGroup();
                                                if (this.$rightBtnImagePainter != null) {
                                                    Alignment alignment = Alignment.CenterStart;
                                                    i f27 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, obj);
                                                    if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                                        str252 = "0S200MNJT807V3GE";
                                                    } else {
                                                        str252 = "0M2003OIIM08YV9M";
                                                    }
                                                    i elementVR3 = ModifierExtKt.elementVR(f27, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str252));
                                                    final Function0<Unit> function020 = this.$onRightBtnClick;
                                                    composer6.startReplaceableGroup(1157296644);
                                                    boolean changed4 = composer6.changed(function020);
                                                    Object rememberedValue4 = composer6.rememberedValue();
                                                    if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$8$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Function0<Unit> function021 = function020;
                                                                if (function021 != null) {
                                                                    function021.invoke();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        composer6.updateRememberedValue(rememberedValue4);
                                                    }
                                                    composer6.endReplaceableGroup();
                                                    i d19 = ViewEventPropUpdaterKt.d(elementVR3, false, null, (Function1) rememberedValue4, 3, null);
                                                    final String str33 = this.$rightBtnImagePainter;
                                                    final int i85 = this.$$dirty;
                                                    BoxKt.a(d19, alignment, null, ComposableLambdaKt.composableLambda(composer6, 1487136136, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.9
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(b bVar4, Composer composer7, Integer num7) {
                                                            Composer composer8 = composer7;
                                                            int intValue3 = num7.intValue();
                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                composer8.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1487136136, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:223)");
                                                                }
                                                                ImageKt.a(str33, null, null, null, null, ModifiersKt.A(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 12.0f, 0.0f, 16.0f, 0.0f, 10, null), 0.5f, 0.0f, 2, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i85 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer6, 3128, 4);
                                                }
                                                composer6.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer4, 196680, 24);
                                if (Intrinsics.areEqual(bool7222, Boolean.TRUE)) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer2, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    qQFlashTransferViewModel3 = qQFlashTransferViewModel2;
                    str14 = str7;
                    hVar3 = hVar2;
                    str15 = str8;
                    str16 = str11;
                    num3 = num2;
                    str17 = str9;
                    function09 = function06;
                    bool5 = bool4;
                    bool6 = bool3;
                    function010 = function013222;
                    function011 = function07;
                    f18 = f17;
                    function012 = function05;
                    str18 = str19222;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
            }
            i47 = i17 & 8192;
            if (i47 != 0) {
            }
            i49 = i17 & 16384;
            if (i49 == 0) {
            }
            i56 = i49;
            i57 = i17 & 32768;
            if (i57 != 0) {
            }
            if ((i17 & 3) != 3) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) == 0) {
            }
            if (i59 != 0) {
            }
            if (i66 != 0) {
            }
            if ((i17 & 4) != 0) {
            }
            if (i67 != 0) {
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
            if (i38 != 0) {
            }
            if (i46 != 0) {
            }
            if (i48 != 0) {
            }
            if (i56 != 0) {
            }
            if (i57 != 0) {
            }
            bool4 = bool9;
            function06 = function019;
            function07 = function018;
            function08 = function017;
            str12 = str25;
            qQFlashTransferViewModel2 = qQFlashTransferViewModel;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            com.tencent.ntcompose.ui.platform.a aVar2222 = (com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d());
            final Function0<Unit> function0132222 = function08;
            final String str192222 = str10;
            final QQFlashTransferViewModel qQFlashTransferViewModel42222 = qQFlashTransferViewModel2;
            final Boolean bool72222 = bool4;
            final Integer num42222 = num2;
            final String str202222 = str8;
            final Function0<Unit> function0142222 = function06;
            final Function0<Unit> function0152222 = function07;
            final int i692222 = i65;
            final int i752222 = i68;
            final String str212222 = str9;
            final String str222222 = str11;
            final String str232222 = str7;
            final Boolean bool82222 = bool3;
            final Function0<Unit> function0162222 = function05;
            final String str242222 = str13;
            composer2 = startRestartGroup;
            BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), hVar2), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar2222)), 0.0f, aVar2222.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(composer2, 1894388531, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
                /* JADX WARN: Removed duplicated region for block: B:29:0x0140  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x0171  */
                /* JADX WARN: Removed duplicated region for block: B:33:0x00e0  */
                /* JADX WARN: Type inference failed for: r2v20 */
                /* JADX WARN: Type inference failed for: r2v21 */
                /* JADX WARN: Type inference failed for: r2v7, types: [int, boolean] */
                @Override // kotlin.jvm.functions.Function3
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Unit invoke(b bVar, Composer composer3, Integer num5) {
                    int i76;
                    boolean z16;
                    boolean z17;
                    ?? r26;
                    b bVar2;
                    SnapshotStateMap<String, ab> snapshotStateMap;
                    b bVar3 = bVar;
                    Composer composer4 = composer3;
                    int intValue = num5.intValue();
                    if ((intValue & 14) == 0) {
                        i76 = (composer4.changed(bVar3) ? 4 : 2) | intValue;
                    } else {
                        i76 = intValue;
                    }
                    if ((i76 & 91) == 18 && composer4.getSkipping()) {
                        composer4.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1894388531, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous> (QQFTNavBar.kt:69)");
                        }
                        i.Companion companion = i.INSTANCE;
                        RowKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterStart), null, null, null, null, ComposableLambdaKt.composableLambda(composer4, 1884949333, true, new Function3<n, Composer, Integer, Unit>(num42222, QQFlashTransferViewModel.this, str202222, function0142222, function0152222, i692222, i752222, str212222, str222222, str232222, str192222) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.1
                            public final /* synthetic */ int $$dirty;
                            public final /* synthetic */ String $leftBtnImagePainter;
                            public final /* synthetic */ String $leftTextContent;
                            public final /* synthetic */ Integer $modalMode;
                            public final /* synthetic */ String $navImagePainter;
                            public final /* synthetic */ String $navTitle;
                            public final /* synthetic */ Function0<Unit> $onLeftBtnClick;
                            public final /* synthetic */ Function0<Unit> $onLeftTextClick;
                            public final /* synthetic */ String $rightBtnImagePainter;
                            public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                                this.$navTitle = r8;
                                this.$rightBtnImagePainter = r9;
                                this.$leftBtnImagePainter = r10;
                                this.$navImagePainter = r11;
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
                            
                                if (((r1 == null || r1.isSecondaryPage()) ? false : true) == false) goto L23;
                             */
                            /* JADX WARN: Code restructure failed: missing block: B:39:0x0118, code lost:
                            
                                if ((r23.$navTitle.length() > 0) == false) goto L54;
                             */
                            /* JADX WARN: Removed duplicated region for block: B:26:0x00b7  */
                            /* JADX WARN: Removed duplicated region for block: B:30:0x00fd  */
                            /* JADX WARN: Removed duplicated region for block: B:36:0x010e  */
                            /* JADX WARN: Removed duplicated region for block: B:42:0x0163  */
                            /* JADX WARN: Removed duplicated region for block: B:55:0x007b  */
                            @Override // kotlin.jvm.functions.Function3
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                                boolean z18;
                                float f19;
                                boolean changed;
                                Object rememberedValue;
                                QQFlashTransferViewModel qQFlashTransferViewModel52;
                                SnapshotStateMap<String, ab> snapshotStateMap2;
                                Composer composer6 = composer5;
                                int intValue2 = num6.intValue();
                                if ((intValue2 & 81) == 16 && composer6.getSkipping()) {
                                    composer6.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1884949333, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:70)");
                                    }
                                    com.tencent.ntcompose.foundation.layout.base.a aVar22222 = com.tencent.ntcompose.foundation.layout.base.a.f339245a;
                                    a.e b16 = aVar22222.b();
                                    i.Companion companion2 = i.INSTANCE;
                                    i f26 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                    Integer num7 = this.$modalMode;
                                    if (num7 != null && num7.intValue() == 1) {
                                        QQFlashTransferViewModel qQFlashTransferViewModel6 = this.$viewModel;
                                    }
                                    String str252 = this.$leftTextContent;
                                    if (str252 != null) {
                                        if (str252.length() > 0) {
                                            z18 = true;
                                            if (!z18) {
                                                f19 = 10.0f;
                                                i a1622222222 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                                final String str2622222222 = this.$leftTextContent;
                                                final Function0<Unit> function01722222222 = this.$onLeftTextClick;
                                                final Function0<Unit> function01822222222 = this.$onLeftBtnClick;
                                                composer6.startReplaceableGroup(1618982084);
                                                changed = composer6.changed(str2622222222) | composer6.changed(function01722222222) | composer6.changed(function01822222222);
                                                rememberedValue = composer6.rememberedValue();
                                                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            String str2722222222 = str2622222222;
                                                            boolean z19 = false;
                                                            if (str2722222222 != null) {
                                                                if (str2722222222.length() > 0) {
                                                                    z19 = true;
                                                                }
                                                            }
                                                            if (z19) {
                                                                Function0<Unit> function0192 = function01722222222;
                                                                if (function0192 != null) {
                                                                    function0192.invoke();
                                                                }
                                                            } else {
                                                                Function0<Unit> function020 = function01822222222;
                                                                if (function020 != null) {
                                                                    function020.invoke();
                                                                } else {
                                                                    QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer6.updateRememberedValue(rememberedValue);
                                                }
                                                composer6.endReplaceableGroup();
                                                i A22222222 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a1622222222, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                                final String str2722222222 = this.$leftTextContent;
                                                final int i7722222222 = this.$$dirty;
                                                final String str2822222222 = this.$leftBtnImagePainter;
                                                ColumnKt.a(A22222222, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                        Composer composer8 = composer7;
                                                        int intValue3 = num8.intValue();
                                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                            composer8.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                            }
                                                            String str2922222222 = str2722222222;
                                                            boolean z19 = false;
                                                            if (str2922222222 != null) {
                                                                if (str2922222222.length() > 0) {
                                                                    z19 = true;
                                                                }
                                                            }
                                                            if (z19) {
                                                                composer8.startReplaceableGroup(2107916874);
                                                                TextKt.a(str2722222222, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i7722222222 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                                composer8.endReplaceableGroup();
                                                            } else {
                                                                composer8.startReplaceableGroup(2107917260);
                                                                ImageKt.a(str2822222222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i7722222222 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                                composer8.endReplaceableGroup();
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer6, 24648, 12);
                                                qQFlashTransferViewModel52 = this.$viewModel;
                                                if (qQFlashTransferViewModel52 == null && (snapshotStateMap2 = qQFlashTransferViewModel52.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                                }
                                                i n362222222 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                a.e b1722222222 = aVar22222.b();
                                                final QQFlashTransferViewModel qQFlashTransferViewModel722222222 = this.$viewModel;
                                                final String str2922222222 = this.$navTitle;
                                                final String str3022222222 = this.$rightBtnImagePainter;
                                                final String str3122222222 = this.$navImagePainter;
                                                final int i7822222222 = this.$$dirty;
                                                ColumnKt.a(n362222222, b1722222222, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                        Composer composer8 = composer7;
                                                        int intValue3 = num8.intValue();
                                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                            composer8.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                            }
                                                            i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                            final String str32 = str3122222222;
                                                            final int i79 = i7822222222;
                                                            final String str33 = str2922222222;
                                                            RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                                    int i85;
                                                                    Composer composer10;
                                                                    Map mutableMapOf;
                                                                    n nVar3 = nVar2;
                                                                    Composer composer11 = composer9;
                                                                    int intValue4 = num9.intValue();
                                                                    if ((intValue4 & 14) == 0) {
                                                                        i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                                    } else {
                                                                        i85 = intValue4;
                                                                    }
                                                                    if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                                        composer11.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                                        }
                                                                        composer11.startReplaceableGroup(-1116923971);
                                                                        if (str32 != null) {
                                                                            mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                            composer10 = composer11;
                                                                            ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                                        } else {
                                                                            composer10 = composer11;
                                                                        }
                                                                        composer10.endReplaceableGroup();
                                                                        TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer8, 196616, 30);
                                                            if (QQFlashTransferViewModel.this != null) {
                                                                if (str2922222222.length() > 0) {
                                                                    QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str3022222222), true, composer8, 25142, 0);
                                                                }
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer6, 24648, 12);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            f19 = 16.0f;
                                            i a16222222222 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                            final String str26222222222 = this.$leftTextContent;
                                            final Function0<Unit> function017222222222 = this.$onLeftTextClick;
                                            final Function0<Unit> function018222222222 = this.$onLeftBtnClick;
                                            composer6.startReplaceableGroup(1618982084);
                                            changed = composer6.changed(str26222222222) | composer6.changed(function017222222222) | composer6.changed(function018222222222);
                                            rememberedValue = composer6.rememberedValue();
                                            if (!changed) {
                                            }
                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    String str27222222222 = str26222222222;
                                                    boolean z19 = false;
                                                    if (str27222222222 != null) {
                                                        if (str27222222222.length() > 0) {
                                                            z19 = true;
                                                        }
                                                    }
                                                    if (z19) {
                                                        Function0<Unit> function0192 = function017222222222;
                                                        if (function0192 != null) {
                                                            function0192.invoke();
                                                        }
                                                    } else {
                                                        Function0<Unit> function020 = function018222222222;
                                                        if (function020 != null) {
                                                            function020.invoke();
                                                        } else {
                                                            QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer6.updateRememberedValue(rememberedValue);
                                            composer6.endReplaceableGroup();
                                            i A222222222 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a16222222222, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                            final String str27222222222 = this.$leftTextContent;
                                            final int i77222222222 = this.$$dirty;
                                            final String str28222222222 = this.$leftBtnImagePainter;
                                            ColumnKt.a(A222222222, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                    Composer composer8 = composer7;
                                                    int intValue3 = num8.intValue();
                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                        composer8.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                        }
                                                        String str29222222222 = str27222222222;
                                                        boolean z19 = false;
                                                        if (str29222222222 != null) {
                                                            if (str29222222222.length() > 0) {
                                                                z19 = true;
                                                            }
                                                        }
                                                        if (z19) {
                                                            composer8.startReplaceableGroup(2107916874);
                                                            TextKt.a(str27222222222, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i77222222222 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                            composer8.endReplaceableGroup();
                                                        } else {
                                                            composer8.startReplaceableGroup(2107917260);
                                                            ImageKt.a(str28222222222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i77222222222 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                            composer8.endReplaceableGroup();
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer6, 24648, 12);
                                            qQFlashTransferViewModel52 = this.$viewModel;
                                            if (qQFlashTransferViewModel52 == null && (snapshotStateMap2 = qQFlashTransferViewModel52.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                            }
                                            i n3622222222 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                            a.e b17222222222 = aVar22222.b();
                                            final QQFlashTransferViewModel qQFlashTransferViewModel7222222222 = this.$viewModel;
                                            final String str29222222222 = this.$navTitle;
                                            final String str30222222222 = this.$rightBtnImagePainter;
                                            final String str31222222222 = this.$navImagePainter;
                                            final int i78222222222 = this.$$dirty;
                                            ColumnKt.a(n3622222222, b17222222222, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                    Composer composer8 = composer7;
                                                    int intValue3 = num8.intValue();
                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                        composer8.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                        }
                                                        i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                        final String str32 = str31222222222;
                                                        final int i79 = i78222222222;
                                                        final String str33 = str29222222222;
                                                        RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                                int i85;
                                                                Composer composer10;
                                                                Map mutableMapOf;
                                                                n nVar3 = nVar2;
                                                                Composer composer11 = composer9;
                                                                int intValue4 = num9.intValue();
                                                                if ((intValue4 & 14) == 0) {
                                                                    i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                                } else {
                                                                    i85 = intValue4;
                                                                }
                                                                if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                                    composer11.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                                    }
                                                                    composer11.startReplaceableGroup(-1116923971);
                                                                    if (str32 != null) {
                                                                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                        composer10 = composer11;
                                                                        ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                                    } else {
                                                                        composer10 = composer11;
                                                                    }
                                                                    composer10.endReplaceableGroup();
                                                                    TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer8, 196616, 30);
                                                        if (QQFlashTransferViewModel.this != null) {
                                                            if (str29222222222.length() > 0) {
                                                                QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str30222222222), true, composer8, 25142, 0);
                                                            }
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer6, 24648, 12);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                        }
                                    }
                                    z18 = false;
                                    if (!z18) {
                                    }
                                    f19 = 16.0f;
                                    i a162222222222 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                    final String str262222222222 = this.$leftTextContent;
                                    final Function0<Unit> function0172222222222 = this.$onLeftTextClick;
                                    final Function0<Unit> function0182222222222 = this.$onLeftBtnClick;
                                    composer6.startReplaceableGroup(1618982084);
                                    changed = composer6.changed(str262222222222) | composer6.changed(function0172222222222) | composer6.changed(function0182222222222);
                                    rememberedValue = composer6.rememberedValue();
                                    if (!changed) {
                                    }
                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            String str272222222222 = str262222222222;
                                            boolean z19 = false;
                                            if (str272222222222 != null) {
                                                if (str272222222222.length() > 0) {
                                                    z19 = true;
                                                }
                                            }
                                            if (z19) {
                                                Function0<Unit> function0192 = function0172222222222;
                                                if (function0192 != null) {
                                                    function0192.invoke();
                                                }
                                            } else {
                                                Function0<Unit> function020 = function0182222222222;
                                                if (function020 != null) {
                                                    function020.invoke();
                                                } else {
                                                    QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer6.updateRememberedValue(rememberedValue);
                                    composer6.endReplaceableGroup();
                                    i A2222222222 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a162222222222, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                    final String str272222222222 = this.$leftTextContent;
                                    final int i772222222222 = this.$$dirty;
                                    final String str282222222222 = this.$leftBtnImagePainter;
                                    ColumnKt.a(A2222222222, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                            Composer composer8 = composer7;
                                            int intValue3 = num8.intValue();
                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                composer8.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                }
                                                String str292222222222 = str272222222222;
                                                boolean z19 = false;
                                                if (str292222222222 != null) {
                                                    if (str292222222222.length() > 0) {
                                                        z19 = true;
                                                    }
                                                }
                                                if (z19) {
                                                    composer8.startReplaceableGroup(2107916874);
                                                    TextKt.a(str272222222222, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i772222222222 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                    composer8.endReplaceableGroup();
                                                } else {
                                                    composer8.startReplaceableGroup(2107917260);
                                                    ImageKt.a(str282222222222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i772222222222 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                    composer8.endReplaceableGroup();
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer6, 24648, 12);
                                    qQFlashTransferViewModel52 = this.$viewModel;
                                    if (qQFlashTransferViewModel52 == null && (snapshotStateMap2 = qQFlashTransferViewModel52.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                    }
                                    i n36222222222 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                    a.e b172222222222 = aVar22222.b();
                                    final QQFlashTransferViewModel qQFlashTransferViewModel72222222222 = this.$viewModel;
                                    final String str292222222222 = this.$navTitle;
                                    final String str302222222222 = this.$rightBtnImagePainter;
                                    final String str312222222222 = this.$navImagePainter;
                                    final int i782222222222 = this.$$dirty;
                                    ColumnKt.a(n36222222222, b172222222222, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                            Composer composer8 = composer7;
                                            int intValue3 = num8.intValue();
                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                composer8.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                }
                                                i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                final String str32 = str312222222222;
                                                final int i79 = i782222222222;
                                                final String str33 = str292222222222;
                                                RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                        int i85;
                                                        Composer composer10;
                                                        Map mutableMapOf;
                                                        n nVar3 = nVar2;
                                                        Composer composer11 = composer9;
                                                        int intValue4 = num9.intValue();
                                                        if ((intValue4 & 14) == 0) {
                                                            i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                        } else {
                                                            i85 = intValue4;
                                                        }
                                                        if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                            composer11.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                            }
                                                            composer11.startReplaceableGroup(-1116923971);
                                                            if (str32 != null) {
                                                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                composer10 = composer11;
                                                                ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                            } else {
                                                                composer10 = composer11;
                                                            }
                                                            composer10.endReplaceableGroup();
                                                            TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer8, 196616, 30);
                                                if (QQFlashTransferViewModel.this != null) {
                                                    if (str292222222222.length() > 0) {
                                                        QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str302222222222), true, composer8, 25142, 0);
                                                    }
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer6, 24648, 12);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer4, 196616, 30);
                        composer4.startReplaceableGroup(-1240831040);
                        QQFlashTransferViewModel qQFlashTransferViewModel52 = QQFlashTransferViewModel.this;
                        if (qQFlashTransferViewModel52 == null || (snapshotStateMap = qQFlashTransferViewModel52.selectFilesToDownload) == null) {
                            z16 = true;
                        } else {
                            z16 = true;
                            r26 = 1;
                            if (!snapshotStateMap.isEmpty()) {
                                z17 = true;
                                if (z17) {
                                    bVar2 = bVar3;
                                } else {
                                    bVar2 = bVar3;
                                    i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, r26, null), Alignment.Center);
                                    final QQFlashTransferViewModel qQFlashTransferViewModel6 = QQFlashTransferViewModel.this;
                                    BoxKt.a(a16, null, null, ComposableLambdaKt.composableLambda(composer4, -408684780, r26, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.2
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar4, Composer composer5, Integer num6) {
                                            int i77;
                                            b bVar5 = bVar4;
                                            Composer composer6 = composer5;
                                            int intValue2 = num6.intValue();
                                            if ((intValue2 & 14) == 0) {
                                                i77 = (composer6.changed(bVar5) ? 4 : 2) | intValue2;
                                            } else {
                                                i77 = intValue2;
                                            }
                                            if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-408684780, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:145)");
                                                }
                                                QQFTDownloadBarViewKt.selectFileInfoStrView(bVar5.a(i.INSTANCE, Alignment.Center), QQFlashTransferViewModel.this, composer6, 72);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer4, 3080, 6);
                                }
                                composer4.endReplaceableGroup();
                                RowKt.a(ComposeLayoutPropUpdaterKt.f(bVar2.a(companion, Alignment.CenterEnd), 0.0f, 1, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.c(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer4, 83640332, true, new Function3<n, Composer, Integer, Unit>(bool82222, function0132222, i752222, i692222, QQFlashTransferViewModel.this, str222222, function0162222, str242222) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.3
                                    public final /* synthetic */ int $$dirty;
                                    public final /* synthetic */ Function0<Unit> $onRightBtnClick;
                                    public final /* synthetic */ Function0<Unit> $onRightTextClick;
                                    public final /* synthetic */ String $rightBtnImagePainter;
                                    public final /* synthetic */ String $rightTextContent;
                                    public final /* synthetic */ Boolean $showCheckBox;
                                    public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                        this.$$dirty = r4;
                                        this.$viewModel = r5;
                                        this.$rightBtnImagePainter = r6;
                                        this.$onRightBtnClick = r7;
                                        this.$rightTextContent = r8;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                                        int i77;
                                        Object obj;
                                        String str252;
                                        String str262;
                                        String str27;
                                        String str28;
                                        MutableState<Boolean> mutableState;
                                        n nVar2 = nVar;
                                        Composer composer6 = composer5;
                                        int intValue2 = num6.intValue();
                                        if ((intValue2 & 14) == 0) {
                                            i77 = (composer6.changed(nVar2) ? 4 : 2) | intValue2;
                                        } else {
                                            i77 = intValue2;
                                        }
                                        if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(83640332, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:158)");
                                            }
                                            boolean z18 = false;
                                            if (Intrinsics.areEqual(this.$showCheckBox, Boolean.TRUE)) {
                                                composer6.startReplaceableGroup(-1319185738);
                                                i.Companion companion2 = i.INSTANCE;
                                                i f19 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                                com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                                if (k.a(cVar)) {
                                                    str262 = "0S200MNJT807V3GE";
                                                } else {
                                                    str262 = "0M2003OIIM08YV9M";
                                                }
                                                e dTBaseParams = DTReportConstKt.getDTBaseParams(str262);
                                                QQFlashTransferViewModel qQFlashTransferViewModel7 = this.$viewModel;
                                                if (qQFlashTransferViewModel7 != null && (mutableState = qQFlashTransferViewModel7.isAllSelectMode) != null && mutableState.getValue().booleanValue()) {
                                                    z18 = true;
                                                }
                                                if (z18) {
                                                    str27 = "1";
                                                } else {
                                                    str27 = "0";
                                                }
                                                dTBaseParams.v("is_screen", str27);
                                                Unit unit = Unit.INSTANCE;
                                                i elementVR = ModifierExtKt.elementVR(f19, "em_bas_select_all", dTBaseParams);
                                                final Boolean bool92 = this.$showCheckBox;
                                                final Function0<Unit> function0172 = this.$onRightTextClick;
                                                composer6.startReplaceableGroup(511388516);
                                                boolean changed = composer6.changed(bool92) | composer6.changed(function0172);
                                                Object rememberedValue = composer6.rememberedValue();
                                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$2$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            Function0<Unit> function0182;
                                                            if (Intrinsics.areEqual(bool92, Boolean.TRUE) && (function0182 = function0172) != null) {
                                                                function0182.invoke();
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer6.updateRememberedValue(rememberedValue);
                                                }
                                                composer6.endReplaceableGroup();
                                                i d16 = ViewEventPropUpdaterKt.d(elementVR, false, null, (Function1) rememberedValue, 3, null);
                                                Alignment.Companion companion3 = Alignment.INSTANCE;
                                                Alignment.Vertical c16 = companion3.c();
                                                final QQFlashTransferViewModel qQFlashTransferViewModel8 = this.$viewModel;
                                                final String str29 = this.$rightBtnImagePainter;
                                                RowKt.a(d16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer6, 762994953, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                        SnapshotStateMap<String, ab> snapshotStateMap2;
                                                        MutableState<Boolean> mutableState2;
                                                        Composer composer8 = composer7;
                                                        int intValue3 = num7.intValue();
                                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                            composer8.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(762994953, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:169)");
                                                            }
                                                            i.Companion companion4 = i.INSTANCE;
                                                            i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), 4.0f, 0.0f, 4.0f, 0.0f, 10, null);
                                                            QQFlashTransferViewModel qQFlashTransferViewModel9 = QQFlashTransferViewModel.this;
                                                            boolean z19 = false;
                                                            QQFTCheckBoxViewKt.QQFTCheckBoxView(n3, 0.0f, (qQFlashTransferViewModel9 == null || (mutableState2 = qQFlashTransferViewModel9.isAllSelectMode) == null || !mutableState2.getValue().booleanValue()) ? false : true, null, null, false, composer8, 8, 58);
                                                            QQFlashTransferViewModel qQFlashTransferViewModel10 = QQFlashTransferViewModel.this;
                                                            if (qQFlashTransferViewModel10 != null && (snapshotStateMap2 = qQFlashTransferViewModel10.selectFilesToDownload) != null && (!snapshotStateMap2.isEmpty())) {
                                                                z19 = true;
                                                            }
                                                            TextKt.a("\u5168\u9009", ComposeLayoutPropUpdaterKt.n(companion4, 0.0f, 0.0f, (z19 || str29 == null) ? 16.0f : 0.0f, 0.0f, 11, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, 1601606, 0, 0, 134216612);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer6, 196616, 26);
                                                QQFlashTransferViewModel qQFlashTransferViewModel9 = this.$viewModel;
                                                if (((qQFlashTransferViewModel9 != null ? qQFlashTransferViewModel9.selectFilesToDownload : null) == null || qQFlashTransferViewModel9.selectFilesToDownload.size() <= 0) && this.$rightBtnImagePainter != null) {
                                                    a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                    i A = ModifiersKt.A(nVar2.b(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), companion3.c()), 0.5f, 0.0f, 2, null);
                                                    if (k.a(cVar)) {
                                                        str28 = "0S200MNJT807V3GE";
                                                    } else {
                                                        str28 = "0M2003OIIM08YV9M";
                                                    }
                                                    i elementVR2 = ModifierExtKt.elementVR(A, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str28));
                                                    final Function0<Unit> function0182 = this.$onRightBtnClick;
                                                    composer6.startReplaceableGroup(1157296644);
                                                    boolean changed2 = composer6.changed(function0182);
                                                    Object rememberedValue2 = composer6.rememberedValue();
                                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$4$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Function0<Unit> function0192 = function0182;
                                                                if (function0192 != null) {
                                                                    function0192.invoke();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        composer6.updateRememberedValue(rememberedValue2);
                                                    }
                                                    composer6.endReplaceableGroup();
                                                    i d17 = ViewEventPropUpdaterKt.d(elementVR2, false, null, (Function1) rememberedValue2, 3, null);
                                                    final String str30 = this.$rightBtnImagePainter;
                                                    final int i78 = this.$$dirty;
                                                    ColumnKt.a(d17, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -578852167, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.5
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(d dVar, Composer composer7, Integer num7) {
                                                            Composer composer8 = composer7;
                                                            int intValue3 = num7.intValue();
                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                composer8.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-578852167, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:193)");
                                                                }
                                                                ImageKt.a(str30, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 20.0f, 0.0f, 16.0f, 0.0f, 10, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i78 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer6, 24648, 12);
                                                }
                                                composer6.endReplaceableGroup();
                                            } else {
                                                composer6.startReplaceableGroup(-1319183568);
                                                composer6.startReplaceableGroup(-1319183550);
                                                String str31 = this.$rightTextContent;
                                                if (str31 != null) {
                                                    if (str31.length() > 0) {
                                                        z18 = true;
                                                    }
                                                }
                                                if (z18) {
                                                    i f26 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null);
                                                    final Function0<Unit> function0192 = this.$onRightTextClick;
                                                    composer6.startReplaceableGroup(1157296644);
                                                    boolean changed3 = composer6.changed(function0192);
                                                    Object rememberedValue3 = composer6.rememberedValue();
                                                    if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$6$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Function0<Unit> function020 = function0192;
                                                                if (function020 != null) {
                                                                    function020.invoke();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        composer6.updateRememberedValue(rememberedValue3);
                                                    }
                                                    composer6.endReplaceableGroup();
                                                    i d18 = ViewEventPropUpdaterKt.d(f26, false, null, (Function1) rememberedValue3, 3, null);
                                                    final String str32 = this.$rightTextContent;
                                                    final int i79 = this.$$dirty;
                                                    obj = null;
                                                    RowKt.a(d18, null, null, null, null, ComposableLambdaKt.composableLambda(composer6, 1105722541, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.7
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                            int i85;
                                                            n nVar4 = nVar3;
                                                            Composer composer8 = composer7;
                                                            int intValue3 = num7.intValue();
                                                            if ((intValue3 & 14) == 0) {
                                                                i85 = (composer8.changed(nVar4) ? 4 : 2) | intValue3;
                                                            } else {
                                                                i85 = intValue3;
                                                            }
                                                            if ((i85 & 91) == 18 && composer8.getSkipping()) {
                                                                composer8.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1105722541, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:204)");
                                                                }
                                                                h color$default = QUIToken.color$default("text_nav_secondary");
                                                                int a17 = ai.INSTANCE.a();
                                                                TextKt.a(str32, ModifiersKt.w(nVar4.b(i.INSTANCE, Alignment.INSTANCE.c()), QUIToken.color$default("overlay_standard_primary")), null, color$default, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, ai.f(a17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i79 >> 24) & 14) | 1601600, 0, 0, 134216612);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer6, 196616, 30);
                                                } else {
                                                    obj = null;
                                                }
                                                composer6.endReplaceableGroup();
                                                if (this.$rightBtnImagePainter != null) {
                                                    Alignment alignment = Alignment.CenterStart;
                                                    i f27 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, obj);
                                                    if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                                        str252 = "0S200MNJT807V3GE";
                                                    } else {
                                                        str252 = "0M2003OIIM08YV9M";
                                                    }
                                                    i elementVR3 = ModifierExtKt.elementVR(f27, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str252));
                                                    final Function0<Unit> function020 = this.$onRightBtnClick;
                                                    composer6.startReplaceableGroup(1157296644);
                                                    boolean changed4 = composer6.changed(function020);
                                                    Object rememberedValue4 = composer6.rememberedValue();
                                                    if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$8$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Function0<Unit> function021 = function020;
                                                                if (function021 != null) {
                                                                    function021.invoke();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        composer6.updateRememberedValue(rememberedValue4);
                                                    }
                                                    composer6.endReplaceableGroup();
                                                    i d19 = ViewEventPropUpdaterKt.d(elementVR3, false, null, (Function1) rememberedValue4, 3, null);
                                                    final String str33 = this.$rightBtnImagePainter;
                                                    final int i85 = this.$$dirty;
                                                    BoxKt.a(d19, alignment, null, ComposableLambdaKt.composableLambda(composer6, 1487136136, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.9
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(b bVar4, Composer composer7, Integer num7) {
                                                            Composer composer8 = composer7;
                                                            int intValue3 = num7.intValue();
                                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                                composer8.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1487136136, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:223)");
                                                                }
                                                                ImageKt.a(str33, null, null, null, null, ModifiersKt.A(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 12.0f, 0.0f, 16.0f, 0.0f, 10, null), 0.5f, 0.0f, 2, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i85 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer6, 3128, 4);
                                                }
                                                composer6.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer4, 196680, 24);
                                if (Intrinsics.areEqual(bool72222, Boolean.TRUE)) {
                                    SurfaceKt.a(ModifiersKt.c(bVar2.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 0.5f), Alignment.BottomCenter), QUIToken.color$default("border_light")), null, null, null, ComposableSingletons$QQFTNavBarKt.f144lambda1, composer4, 24584, 14);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }
                        z17 = false;
                        r26 = z16;
                        if (z17) {
                        }
                        composer4.endReplaceableGroup();
                        RowKt.a(ComposeLayoutPropUpdaterKt.f(bVar2.a(companion, Alignment.CenterEnd), 0.0f, 1, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.c(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer4, 83640332, true, new Function3<n, Composer, Integer, Unit>(bool82222, function0132222, i752222, i692222, QQFlashTransferViewModel.this, str222222, function0162222, str242222) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.3
                            public final /* synthetic */ int $$dirty;
                            public final /* synthetic */ Function0<Unit> $onRightBtnClick;
                            public final /* synthetic */ Function0<Unit> $onRightTextClick;
                            public final /* synthetic */ String $rightBtnImagePainter;
                            public final /* synthetic */ String $rightTextContent;
                            public final /* synthetic */ Boolean $showCheckBox;
                            public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                                this.$$dirty = r4;
                                this.$viewModel = r5;
                                this.$rightBtnImagePainter = r6;
                                this.$onRightBtnClick = r7;
                                this.$rightTextContent = r8;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                                int i77;
                                Object obj;
                                String str252;
                                String str262;
                                String str27;
                                String str28;
                                MutableState<Boolean> mutableState;
                                n nVar2 = nVar;
                                Composer composer6 = composer5;
                                int intValue2 = num6.intValue();
                                if ((intValue2 & 14) == 0) {
                                    i77 = (composer6.changed(nVar2) ? 4 : 2) | intValue2;
                                } else {
                                    i77 = intValue2;
                                }
                                if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                    composer6.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(83640332, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:158)");
                                    }
                                    boolean z18 = false;
                                    if (Intrinsics.areEqual(this.$showCheckBox, Boolean.TRUE)) {
                                        composer6.startReplaceableGroup(-1319185738);
                                        i.Companion companion2 = i.INSTANCE;
                                        i f19 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                        if (k.a(cVar)) {
                                            str262 = "0S200MNJT807V3GE";
                                        } else {
                                            str262 = "0M2003OIIM08YV9M";
                                        }
                                        e dTBaseParams = DTReportConstKt.getDTBaseParams(str262);
                                        QQFlashTransferViewModel qQFlashTransferViewModel7 = this.$viewModel;
                                        if (qQFlashTransferViewModel7 != null && (mutableState = qQFlashTransferViewModel7.isAllSelectMode) != null && mutableState.getValue().booleanValue()) {
                                            z18 = true;
                                        }
                                        if (z18) {
                                            str27 = "1";
                                        } else {
                                            str27 = "0";
                                        }
                                        dTBaseParams.v("is_screen", str27);
                                        Unit unit = Unit.INSTANCE;
                                        i elementVR = ModifierExtKt.elementVR(f19, "em_bas_select_all", dTBaseParams);
                                        final Boolean bool92 = this.$showCheckBox;
                                        final Function0<Unit> function0172 = this.$onRightTextClick;
                                        composer6.startReplaceableGroup(511388516);
                                        boolean changed = composer6.changed(bool92) | composer6.changed(function0172);
                                        Object rememberedValue = composer6.rememberedValue();
                                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    Function0<Unit> function0182;
                                                    if (Intrinsics.areEqual(bool92, Boolean.TRUE) && (function0182 = function0172) != null) {
                                                        function0182.invoke();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer6.updateRememberedValue(rememberedValue);
                                        }
                                        composer6.endReplaceableGroup();
                                        i d16 = ViewEventPropUpdaterKt.d(elementVR, false, null, (Function1) rememberedValue, 3, null);
                                        Alignment.Companion companion3 = Alignment.INSTANCE;
                                        Alignment.Vertical c16 = companion3.c();
                                        final QQFlashTransferViewModel qQFlashTransferViewModel8 = this.$viewModel;
                                        final String str29 = this.$rightBtnImagePainter;
                                        RowKt.a(d16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer6, 762994953, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                SnapshotStateMap<String, ab> snapshotStateMap2;
                                                MutableState<Boolean> mutableState2;
                                                Composer composer8 = composer7;
                                                int intValue3 = num7.intValue();
                                                if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                    composer8.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(762994953, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:169)");
                                                    }
                                                    i.Companion companion4 = i.INSTANCE;
                                                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), 4.0f, 0.0f, 4.0f, 0.0f, 10, null);
                                                    QQFlashTransferViewModel qQFlashTransferViewModel9 = QQFlashTransferViewModel.this;
                                                    boolean z19 = false;
                                                    QQFTCheckBoxViewKt.QQFTCheckBoxView(n3, 0.0f, (qQFlashTransferViewModel9 == null || (mutableState2 = qQFlashTransferViewModel9.isAllSelectMode) == null || !mutableState2.getValue().booleanValue()) ? false : true, null, null, false, composer8, 8, 58);
                                                    QQFlashTransferViewModel qQFlashTransferViewModel10 = QQFlashTransferViewModel.this;
                                                    if (qQFlashTransferViewModel10 != null && (snapshotStateMap2 = qQFlashTransferViewModel10.selectFilesToDownload) != null && (!snapshotStateMap2.isEmpty())) {
                                                        z19 = true;
                                                    }
                                                    TextKt.a("\u5168\u9009", ComposeLayoutPropUpdaterKt.n(companion4, 0.0f, 0.0f, (z19 || str29 == null) ? 16.0f : 0.0f, 0.0f, 11, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, 1601606, 0, 0, 134216612);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer6, 196616, 26);
                                        QQFlashTransferViewModel qQFlashTransferViewModel9 = this.$viewModel;
                                        if (((qQFlashTransferViewModel9 != null ? qQFlashTransferViewModel9.selectFilesToDownload : null) == null || qQFlashTransferViewModel9.selectFilesToDownload.size() <= 0) && this.$rightBtnImagePainter != null) {
                                            a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                            i A = ModifiersKt.A(nVar2.b(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), companion3.c()), 0.5f, 0.0f, 2, null);
                                            if (k.a(cVar)) {
                                                str28 = "0S200MNJT807V3GE";
                                            } else {
                                                str28 = "0M2003OIIM08YV9M";
                                            }
                                            i elementVR2 = ModifierExtKt.elementVR(A, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str28));
                                            final Function0<Unit> function0182 = this.$onRightBtnClick;
                                            composer6.startReplaceableGroup(1157296644);
                                            boolean changed2 = composer6.changed(function0182);
                                            Object rememberedValue2 = composer6.rememberedValue();
                                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$4$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Function0<Unit> function0192 = function0182;
                                                        if (function0192 != null) {
                                                            function0192.invoke();
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer6.updateRememberedValue(rememberedValue2);
                                            }
                                            composer6.endReplaceableGroup();
                                            i d17 = ViewEventPropUpdaterKt.d(elementVR2, false, null, (Function1) rememberedValue2, 3, null);
                                            final String str30 = this.$rightBtnImagePainter;
                                            final int i78 = this.$$dirty;
                                            ColumnKt.a(d17, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -578852167, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.5
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer7, Integer num7) {
                                                    Composer composer8 = composer7;
                                                    int intValue3 = num7.intValue();
                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                        composer8.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-578852167, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:193)");
                                                        }
                                                        ImageKt.a(str30, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 20.0f, 0.0f, 16.0f, 0.0f, 10, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i78 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer6, 24648, 12);
                                        }
                                        composer6.endReplaceableGroup();
                                    } else {
                                        composer6.startReplaceableGroup(-1319183568);
                                        composer6.startReplaceableGroup(-1319183550);
                                        String str31 = this.$rightTextContent;
                                        if (str31 != null) {
                                            if (str31.length() > 0) {
                                                z18 = true;
                                            }
                                        }
                                        if (z18) {
                                            i f26 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null);
                                            final Function0<Unit> function0192 = this.$onRightTextClick;
                                            composer6.startReplaceableGroup(1157296644);
                                            boolean changed3 = composer6.changed(function0192);
                                            Object rememberedValue3 = composer6.rememberedValue();
                                            if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$6$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Function0<Unit> function020 = function0192;
                                                        if (function020 != null) {
                                                            function020.invoke();
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer6.updateRememberedValue(rememberedValue3);
                                            }
                                            composer6.endReplaceableGroup();
                                            i d18 = ViewEventPropUpdaterKt.d(f26, false, null, (Function1) rememberedValue3, 3, null);
                                            final String str32 = this.$rightTextContent;
                                            final int i79 = this.$$dirty;
                                            obj = null;
                                            RowKt.a(d18, null, null, null, null, ComposableLambdaKt.composableLambda(composer6, 1105722541, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.7
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                    int i85;
                                                    n nVar4 = nVar3;
                                                    Composer composer8 = composer7;
                                                    int intValue3 = num7.intValue();
                                                    if ((intValue3 & 14) == 0) {
                                                        i85 = (composer8.changed(nVar4) ? 4 : 2) | intValue3;
                                                    } else {
                                                        i85 = intValue3;
                                                    }
                                                    if ((i85 & 91) == 18 && composer8.getSkipping()) {
                                                        composer8.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1105722541, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:204)");
                                                        }
                                                        h color$default = QUIToken.color$default("text_nav_secondary");
                                                        int a17 = ai.INSTANCE.a();
                                                        TextKt.a(str32, ModifiersKt.w(nVar4.b(i.INSTANCE, Alignment.INSTANCE.c()), QUIToken.color$default("overlay_standard_primary")), null, color$default, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, ai.f(a17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i79 >> 24) & 14) | 1601600, 0, 0, 134216612);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer6, 196616, 30);
                                        } else {
                                            obj = null;
                                        }
                                        composer6.endReplaceableGroup();
                                        if (this.$rightBtnImagePainter != null) {
                                            Alignment alignment = Alignment.CenterStart;
                                            i f27 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, obj);
                                            if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                                str252 = "0S200MNJT807V3GE";
                                            } else {
                                                str252 = "0M2003OIIM08YV9M";
                                            }
                                            i elementVR3 = ModifierExtKt.elementVR(f27, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str252));
                                            final Function0<Unit> function020 = this.$onRightBtnClick;
                                            composer6.startReplaceableGroup(1157296644);
                                            boolean changed4 = composer6.changed(function020);
                                            Object rememberedValue4 = composer6.rememberedValue();
                                            if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$8$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Function0<Unit> function021 = function020;
                                                        if (function021 != null) {
                                                            function021.invoke();
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer6.updateRememberedValue(rememberedValue4);
                                            }
                                            composer6.endReplaceableGroup();
                                            i d19 = ViewEventPropUpdaterKt.d(elementVR3, false, null, (Function1) rememberedValue4, 3, null);
                                            final String str33 = this.$rightBtnImagePainter;
                                            final int i85 = this.$$dirty;
                                            BoxKt.a(d19, alignment, null, ComposableLambdaKt.composableLambda(composer6, 1487136136, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.9
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(b bVar4, Composer composer7, Integer num7) {
                                                    Composer composer8 = composer7;
                                                    int intValue3 = num7.intValue();
                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                        composer8.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1487136136, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:223)");
                                                        }
                                                        ImageKt.a(str33, null, null, null, null, ModifiersKt.A(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 12.0f, 0.0f, 16.0f, 0.0f, 10, null), 0.5f, 0.0f, 2, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i85 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer6, 3128, 4);
                                        }
                                        composer6.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer4, 196680, 24);
                        if (Intrinsics.areEqual(bool72222, Boolean.TRUE)) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), composer2, 3080, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
            qQFlashTransferViewModel3 = qQFlashTransferViewModel2;
            str14 = str7;
            hVar3 = hVar2;
            str15 = str8;
            str16 = str11;
            num3 = num2;
            str17 = str9;
            function09 = function06;
            bool5 = bool4;
            bool6 = bool3;
            function010 = function0132222;
            function011 = function07;
            f18 = f17;
            function012 = function05;
            str18 = str192222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i18 = i17 & 16;
        if (i18 == 0) {
        }
        i19 = i17 & 32;
        if (i19 == 0) {
        }
        i26 = i17 & 64;
        if (i26 == 0) {
        }
        i27 = i17 & 128;
        if (i27 == 0) {
        }
        i28 = i17 & 256;
        if (i28 == 0) {
        }
        i29 = i17 & 512;
        if (i29 == 0) {
        }
        i36 = i17 & 1024;
        if (i36 == 0) {
        }
        i38 = i17 & 2048;
        if (i38 == 0) {
        }
        int i682 = i37;
        i39 = i17 & 4096;
        if (i39 == 0) {
        }
        i47 = i17 & 8192;
        if (i47 != 0) {
        }
        i49 = i17 & 16384;
        if (i49 == 0) {
        }
        i56 = i49;
        i57 = i17 & 32768;
        if (i57 != 0) {
        }
        if ((i17 & 3) != 3) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) == 0) {
        }
        if (i59 != 0) {
        }
        if (i66 != 0) {
        }
        if ((i17 & 4) != 0) {
        }
        if (i67 != 0) {
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
        if (i38 != 0) {
        }
        if (i46 != 0) {
        }
        if (i48 != 0) {
        }
        if (i56 != 0) {
        }
        if (i57 != 0) {
        }
        bool4 = bool9;
        function06 = function019;
        function07 = function018;
        function08 = function017;
        str12 = str25;
        qQFlashTransferViewModel2 = qQFlashTransferViewModel;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        com.tencent.ntcompose.ui.platform.a aVar22222 = (com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d());
        final Function0<Unit> function01322222 = function08;
        final String str1922222 = str10;
        final QQFlashTransferViewModel qQFlashTransferViewModel422222 = qQFlashTransferViewModel2;
        final Boolean bool722222 = bool4;
        final Integer num422222 = num2;
        final String str2022222 = str8;
        final Function0<Unit> function01422222 = function06;
        final Function0<Unit> function01522222 = function07;
        final int i6922222 = i65;
        final int i7522222 = i682;
        final String str2122222 = str9;
        final String str2222222 = str11;
        final String str2322222 = str7;
        final Boolean bool822222 = bool3;
        final Function0<Unit> function01622222 = function05;
        final String str2422222 = str13;
        composer2 = startRestartGroup;
        BoxKt.a(ModifiersKt.S(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), hVar2), LocalConfigurationExtKt.getQqNavigationBarHeight(aVar22222)), 0.0f, aVar22222.i(), 0.0f, 0.0f, 13, null), f17), null, null, ComposableLambdaKt.composableLambda(composer2, 1894388531, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0140  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0171  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x00e0  */
            /* JADX WARN: Type inference failed for: r2v20 */
            /* JADX WARN: Type inference failed for: r2v21 */
            /* JADX WARN: Type inference failed for: r2v7, types: [int, boolean] */
            @Override // kotlin.jvm.functions.Function3
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(b bVar, Composer composer3, Integer num5) {
                int i76;
                boolean z16;
                boolean z17;
                ?? r26;
                b bVar2;
                SnapshotStateMap<String, ab> snapshotStateMap;
                b bVar3 = bVar;
                Composer composer4 = composer3;
                int intValue = num5.intValue();
                if ((intValue & 14) == 0) {
                    i76 = (composer4.changed(bVar3) ? 4 : 2) | intValue;
                } else {
                    i76 = intValue;
                }
                if ((i76 & 91) == 18 && composer4.getSkipping()) {
                    composer4.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1894388531, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous> (QQFTNavBar.kt:69)");
                    }
                    i.Companion companion = i.INSTANCE;
                    RowKt.a(bVar3.a(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), Alignment.CenterStart), null, null, null, null, ComposableLambdaKt.composableLambda(composer4, 1884949333, true, new Function3<n, Composer, Integer, Unit>(num422222, QQFlashTransferViewModel.this, str2022222, function01422222, function01522222, i6922222, i7522222, str2122222, str2222222, str2322222, str1922222) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.1
                        public final /* synthetic */ int $$dirty;
                        public final /* synthetic */ String $leftBtnImagePainter;
                        public final /* synthetic */ String $leftTextContent;
                        public final /* synthetic */ Integer $modalMode;
                        public final /* synthetic */ String $navImagePainter;
                        public final /* synthetic */ String $navTitle;
                        public final /* synthetic */ Function0<Unit> $onLeftBtnClick;
                        public final /* synthetic */ Function0<Unit> $onLeftTextClick;
                        public final /* synthetic */ String $rightBtnImagePainter;
                        public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                            this.$navTitle = r8;
                            this.$rightBtnImagePainter = r9;
                            this.$leftBtnImagePainter = r10;
                            this.$navImagePainter = r11;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
                        
                            if (((r1 == null || r1.isSecondaryPage()) ? false : true) == false) goto L23;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:39:0x0118, code lost:
                        
                            if ((r23.$navTitle.length() > 0) == false) goto L54;
                         */
                        /* JADX WARN: Removed duplicated region for block: B:26:0x00b7  */
                        /* JADX WARN: Removed duplicated region for block: B:30:0x00fd  */
                        /* JADX WARN: Removed duplicated region for block: B:36:0x010e  */
                        /* JADX WARN: Removed duplicated region for block: B:42:0x0163  */
                        /* JADX WARN: Removed duplicated region for block: B:55:0x007b  */
                        @Override // kotlin.jvm.functions.Function3
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                            boolean z18;
                            float f19;
                            boolean changed;
                            Object rememberedValue;
                            QQFlashTransferViewModel qQFlashTransferViewModel52;
                            SnapshotStateMap<String, ab> snapshotStateMap2;
                            Composer composer6 = composer5;
                            int intValue2 = num6.intValue();
                            if ((intValue2 & 81) == 16 && composer6.getSkipping()) {
                                composer6.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1884949333, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:70)");
                                }
                                com.tencent.ntcompose.foundation.layout.base.a aVar222222 = com.tencent.ntcompose.foundation.layout.base.a.f339245a;
                                a.e b16 = aVar222222.b();
                                i.Companion companion2 = i.INSTANCE;
                                i f26 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                Integer num7 = this.$modalMode;
                                if (num7 != null && num7.intValue() == 1) {
                                    QQFlashTransferViewModel qQFlashTransferViewModel6 = this.$viewModel;
                                }
                                String str252 = this.$leftTextContent;
                                if (str252 != null) {
                                    if (str252.length() > 0) {
                                        z18 = true;
                                        if (!z18) {
                                            f19 = 10.0f;
                                            i a162222222222 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                            final String str262222222222 = this.$leftTextContent;
                                            final Function0<Unit> function0172222222222 = this.$onLeftTextClick;
                                            final Function0<Unit> function0182222222222 = this.$onLeftBtnClick;
                                            composer6.startReplaceableGroup(1618982084);
                                            changed = composer6.changed(str262222222222) | composer6.changed(function0172222222222) | composer6.changed(function0182222222222);
                                            rememberedValue = composer6.rememberedValue();
                                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        String str272222222222 = str262222222222;
                                                        boolean z19 = false;
                                                        if (str272222222222 != null) {
                                                            if (str272222222222.length() > 0) {
                                                                z19 = true;
                                                            }
                                                        }
                                                        if (z19) {
                                                            Function0<Unit> function0192 = function0172222222222;
                                                            if (function0192 != null) {
                                                                function0192.invoke();
                                                            }
                                                        } else {
                                                            Function0<Unit> function020 = function0182222222222;
                                                            if (function020 != null) {
                                                                function020.invoke();
                                                            } else {
                                                                QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                                QQKuiklyPlatformApi.Companion.closePage$default();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer6.updateRememberedValue(rememberedValue);
                                            }
                                            composer6.endReplaceableGroup();
                                            i A2222222222 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a162222222222, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                            final String str272222222222 = this.$leftTextContent;
                                            final int i772222222222 = this.$$dirty;
                                            final String str282222222222 = this.$leftBtnImagePainter;
                                            ColumnKt.a(A2222222222, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                    Composer composer8 = composer7;
                                                    int intValue3 = num8.intValue();
                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                        composer8.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                        }
                                                        String str292222222222 = str272222222222;
                                                        boolean z19 = false;
                                                        if (str292222222222 != null) {
                                                            if (str292222222222.length() > 0) {
                                                                z19 = true;
                                                            }
                                                        }
                                                        if (z19) {
                                                            composer8.startReplaceableGroup(2107916874);
                                                            TextKt.a(str272222222222, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i772222222222 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                            composer8.endReplaceableGroup();
                                                        } else {
                                                            composer8.startReplaceableGroup(2107917260);
                                                            ImageKt.a(str282222222222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i772222222222 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                            composer8.endReplaceableGroup();
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer6, 24648, 12);
                                            qQFlashTransferViewModel52 = this.$viewModel;
                                            if (qQFlashTransferViewModel52 == null && (snapshotStateMap2 = qQFlashTransferViewModel52.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                            }
                                            i n36222222222 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                            a.e b172222222222 = aVar222222.b();
                                            final QQFlashTransferViewModel qQFlashTransferViewModel72222222222 = this.$viewModel;
                                            final String str292222222222 = this.$navTitle;
                                            final String str302222222222 = this.$rightBtnImagePainter;
                                            final String str312222222222 = this.$navImagePainter;
                                            final int i782222222222 = this.$$dirty;
                                            ColumnKt.a(n36222222222, b172222222222, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                    Composer composer8 = composer7;
                                                    int intValue3 = num8.intValue();
                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                        composer8.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                        }
                                                        i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                        final String str32 = str312222222222;
                                                        final int i79 = i782222222222;
                                                        final String str33 = str292222222222;
                                                        RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                                int i85;
                                                                Composer composer10;
                                                                Map mutableMapOf;
                                                                n nVar3 = nVar2;
                                                                Composer composer11 = composer9;
                                                                int intValue4 = num9.intValue();
                                                                if ((intValue4 & 14) == 0) {
                                                                    i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                                } else {
                                                                    i85 = intValue4;
                                                                }
                                                                if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                                    composer11.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                                    }
                                                                    composer11.startReplaceableGroup(-1116923971);
                                                                    if (str32 != null) {
                                                                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                        composer10 = composer11;
                                                                        ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                                    } else {
                                                                        composer10 = composer11;
                                                                    }
                                                                    composer10.endReplaceableGroup();
                                                                    TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer8, 196616, 30);
                                                        if (QQFlashTransferViewModel.this != null) {
                                                            if (str292222222222.length() > 0) {
                                                                QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str302222222222), true, composer8, 25142, 0);
                                                            }
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer6, 24648, 12);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        f19 = 16.0f;
                                        i a1622222222222 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                        final String str2622222222222 = this.$leftTextContent;
                                        final Function0<Unit> function01722222222222 = this.$onLeftTextClick;
                                        final Function0<Unit> function01822222222222 = this.$onLeftBtnClick;
                                        composer6.startReplaceableGroup(1618982084);
                                        changed = composer6.changed(str2622222222222) | composer6.changed(function01722222222222) | composer6.changed(function01822222222222);
                                        rememberedValue = composer6.rememberedValue();
                                        if (!changed) {
                                        }
                                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                String str2722222222222 = str2622222222222;
                                                boolean z19 = false;
                                                if (str2722222222222 != null) {
                                                    if (str2722222222222.length() > 0) {
                                                        z19 = true;
                                                    }
                                                }
                                                if (z19) {
                                                    Function0<Unit> function0192 = function01722222222222;
                                                    if (function0192 != null) {
                                                        function0192.invoke();
                                                    }
                                                } else {
                                                    Function0<Unit> function020 = function01822222222222;
                                                    if (function020 != null) {
                                                        function020.invoke();
                                                    } else {
                                                        QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer6.updateRememberedValue(rememberedValue);
                                        composer6.endReplaceableGroup();
                                        i A22222222222 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a1622222222222, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                        final String str2722222222222 = this.$leftTextContent;
                                        final int i7722222222222 = this.$$dirty;
                                        final String str2822222222222 = this.$leftBtnImagePainter;
                                        ColumnKt.a(A22222222222, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                Composer composer8 = composer7;
                                                int intValue3 = num8.intValue();
                                                if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                    composer8.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                                    }
                                                    String str2922222222222 = str2722222222222;
                                                    boolean z19 = false;
                                                    if (str2922222222222 != null) {
                                                        if (str2922222222222.length() > 0) {
                                                            z19 = true;
                                                        }
                                                    }
                                                    if (z19) {
                                                        composer8.startReplaceableGroup(2107916874);
                                                        TextKt.a(str2722222222222, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i7722222222222 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                        composer8.endReplaceableGroup();
                                                    } else {
                                                        composer8.startReplaceableGroup(2107917260);
                                                        ImageKt.a(str2822222222222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i7722222222222 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                        composer8.endReplaceableGroup();
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer6, 24648, 12);
                                        qQFlashTransferViewModel52 = this.$viewModel;
                                        if (qQFlashTransferViewModel52 == null && (snapshotStateMap2 = qQFlashTransferViewModel52.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                        }
                                        i n362222222222 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                        a.e b1722222222222 = aVar222222.b();
                                        final QQFlashTransferViewModel qQFlashTransferViewModel722222222222 = this.$viewModel;
                                        final String str2922222222222 = this.$navTitle;
                                        final String str3022222222222 = this.$rightBtnImagePainter;
                                        final String str3122222222222 = this.$navImagePainter;
                                        final int i7822222222222 = this.$$dirty;
                                        ColumnKt.a(n362222222222, b1722222222222, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                                Composer composer8 = composer7;
                                                int intValue3 = num8.intValue();
                                                if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                    composer8.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                                    }
                                                    i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                                    final String str32 = str3122222222222;
                                                    final int i79 = i7822222222222;
                                                    final String str33 = str2922222222222;
                                                    RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                            int i85;
                                                            Composer composer10;
                                                            Map mutableMapOf;
                                                            n nVar3 = nVar2;
                                                            Composer composer11 = composer9;
                                                            int intValue4 = num9.intValue();
                                                            if ((intValue4 & 14) == 0) {
                                                                i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                            } else {
                                                                i85 = intValue4;
                                                            }
                                                            if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                                composer11.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                                }
                                                                composer11.startReplaceableGroup(-1116923971);
                                                                if (str32 != null) {
                                                                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                                    composer10 = composer11;
                                                                    ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                                } else {
                                                                    composer10 = composer11;
                                                                }
                                                                composer10.endReplaceableGroup();
                                                                TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer8, 196616, 30);
                                                    if (QQFlashTransferViewModel.this != null) {
                                                        if (str2922222222222.length() > 0) {
                                                            QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str3022222222222), true, composer8, 25142, 0);
                                                        }
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer6, 24648, 12);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                    }
                                }
                                z18 = false;
                                if (!z18) {
                                }
                                f19 = 16.0f;
                                i a16222222222222 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(f26, f19, 0.0f, 2.0f, 0.0f, 10, null), "\u8fd4\u56de");
                                final String str26222222222222 = this.$leftTextContent;
                                final Function0<Unit> function017222222222222 = this.$onLeftTextClick;
                                final Function0<Unit> function018222222222222 = this.$onLeftBtnClick;
                                composer6.startReplaceableGroup(1618982084);
                                changed = composer6.changed(str26222222222222) | composer6.changed(function017222222222222) | composer6.changed(function018222222222222);
                                rememberedValue = composer6.rememberedValue();
                                if (!changed) {
                                }
                                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        String str27222222222222 = str26222222222222;
                                        boolean z19 = false;
                                        if (str27222222222222 != null) {
                                            if (str27222222222222.length() > 0) {
                                                z19 = true;
                                            }
                                        }
                                        if (z19) {
                                            Function0<Unit> function0192 = function017222222222222;
                                            if (function0192 != null) {
                                                function0192.invoke();
                                            }
                                        } else {
                                            Function0<Unit> function020 = function018222222222222;
                                            if (function020 != null) {
                                                function020.invoke();
                                            } else {
                                                QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                QQKuiklyPlatformApi.Companion.closePage$default();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                composer6.updateRememberedValue(rememberedValue);
                                composer6.endReplaceableGroup();
                                i A222222222222 = ModifiersKt.A(ViewEventPropUpdaterKt.d(a16222222222222, false, null, (Function1) rememberedValue, 3, null), 0.5f, 0.0f, 2, null);
                                final String str27222222222222 = this.$leftTextContent;
                                final int i77222222222222 = this.$$dirty;
                                final String str28222222222222 = this.$leftBtnImagePainter;
                                ColumnKt.a(A222222222222, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -1173839796, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                        Composer composer8 = composer7;
                                        int intValue3 = num8.intValue();
                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                            composer8.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1173839796, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:88)");
                                            }
                                            String str29222222222222 = str27222222222222;
                                            boolean z19 = false;
                                            if (str29222222222222 != null) {
                                                if (str29222222222222.length() > 0) {
                                                    z19 = true;
                                                }
                                            }
                                            if (z19) {
                                                composer8.startReplaceableGroup(2107916874);
                                                TextKt.a(str27222222222222, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i77222222222222 >> 9) & 14) | 1601600, 0, 0, 134216612);
                                                composer8.endReplaceableGroup();
                                            } else {
                                                composer8.startReplaceableGroup(2107917260);
                                                ImageKt.a(str28222222222222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i77222222222222 >> 6) & 14) | 262144, 0, 0, 2097118);
                                                composer8.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer6, 24648, 12);
                                qQFlashTransferViewModel52 = this.$viewModel;
                                if (qQFlashTransferViewModel52 == null && (snapshotStateMap2 = qQFlashTransferViewModel52.selectFilesToDownload) != null && (snapshotStateMap2.isEmpty() ^ true)) {
                                }
                                i n3622222222222 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), QQFTNavBarKt.access$getMaxTitleWidth(this.$rightBtnImagePainter)), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                a.e b17222222222222 = aVar222222.b();
                                final QQFlashTransferViewModel qQFlashTransferViewModel7222222222222 = this.$viewModel;
                                final String str29222222222222 = this.$navTitle;
                                final String str30222222222222 = this.$rightBtnImagePainter;
                                final String str31222222222222 = this.$navImagePainter;
                                final int i78222222222222 = this.$$dirty;
                                ColumnKt.a(n3622222222222, b17222222222222, null, null, ComposableLambdaKt.composableLambda(composer6, -363648601, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar, Composer composer7, Integer num8) {
                                        Composer composer8 = composer7;
                                        int intValue3 = num8.intValue();
                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                            composer8.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-363648601, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:109)");
                                            }
                                            i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                                            final String str32 = str31222222222222;
                                            final int i79 = i78222222222222;
                                            final String str33 = str29222222222222;
                                            RowKt.a(j3, null, null, null, null, ComposableLambdaKt.composableLambda(composer8, -2087786807, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.1.3.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(n nVar2, Composer composer9, Integer num9) {
                                                    int i85;
                                                    Composer composer10;
                                                    Map mutableMapOf;
                                                    n nVar3 = nVar2;
                                                    Composer composer11 = composer9;
                                                    int intValue4 = num9.intValue();
                                                    if ((intValue4 & 14) == 0) {
                                                        i85 = (composer11.changed(nVar3) ? 4 : 2) | intValue4;
                                                    } else {
                                                        i85 = intValue4;
                                                    }
                                                    if ((i85 & 91) == 18 && composer11.getSkipping()) {
                                                        composer11.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-2087786807, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:110)");
                                                        }
                                                        composer11.startReplaceableGroup(-1116923971);
                                                        if (str32 != null) {
                                                            mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                                            composer10 = composer11;
                                                            ImageKt.a(str32, null, null, null, null, nVar3.b(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), 4.0f), 0.0f, 0.0f, 2.0f, 0.0f, 11, null), Alignment.INSTANCE.c()), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, mutableMapOf, composer10, ((i79 >> 18) & 14) | 262144, 0, 8, 1048542);
                                                        } else {
                                                            composer10 = composer11;
                                                        }
                                                        composer10.endReplaceableGroup();
                                                        TextKt.a(str33, ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), null, QUIToken.color$default("text_nav_secondary"), Float.valueOf(16.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, an.d(an.INSTANCE.c()), null, 1, null, null, null, null, null, null, null, false, composer10, ((i79 >> 15) & 14) | 1601600, 102236160, 0, 133888932);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer8, 196616, 30);
                                            if (QQFlashTransferViewModel.this != null) {
                                                if (str29222222222222.length() > 0) {
                                                    QQFTFileSetStatusViewKt.QQFTFileSetStatusView(10.0f, 14.0f, QQFlashTransferViewModel.this, QQFTNavBarKt.access$getMaxTitleWidth(str30222222222222), true, composer8, 25142, 0);
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer6, 24648, 12);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer4, 196616, 30);
                    composer4.startReplaceableGroup(-1240831040);
                    QQFlashTransferViewModel qQFlashTransferViewModel52 = QQFlashTransferViewModel.this;
                    if (qQFlashTransferViewModel52 == null || (snapshotStateMap = qQFlashTransferViewModel52.selectFilesToDownload) == null) {
                        z16 = true;
                    } else {
                        z16 = true;
                        r26 = 1;
                        if (!snapshotStateMap.isEmpty()) {
                            z17 = true;
                            if (z17) {
                                bVar2 = bVar3;
                            } else {
                                bVar2 = bVar3;
                                i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, r26, null), Alignment.Center);
                                final QQFlashTransferViewModel qQFlashTransferViewModel6 = QQFlashTransferViewModel.this;
                                BoxKt.a(a16, null, null, ComposableLambdaKt.composableLambda(composer4, -408684780, r26, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.2
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar4, Composer composer5, Integer num6) {
                                        int i77;
                                        b bVar5 = bVar4;
                                        Composer composer6 = composer5;
                                        int intValue2 = num6.intValue();
                                        if ((intValue2 & 14) == 0) {
                                            i77 = (composer6.changed(bVar5) ? 4 : 2) | intValue2;
                                        } else {
                                            i77 = intValue2;
                                        }
                                        if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-408684780, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:145)");
                                            }
                                            QQFTDownloadBarViewKt.selectFileInfoStrView(bVar5.a(i.INSTANCE, Alignment.Center), QQFlashTransferViewModel.this, composer6, 72);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer4, 3080, 6);
                            }
                            composer4.endReplaceableGroup();
                            RowKt.a(ComposeLayoutPropUpdaterKt.f(bVar2.a(companion, Alignment.CenterEnd), 0.0f, 1, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.c(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer4, 83640332, true, new Function3<n, Composer, Integer, Unit>(bool822222, function01322222, i7522222, i6922222, QQFlashTransferViewModel.this, str2222222, function01622222, str2422222) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.3
                                public final /* synthetic */ int $$dirty;
                                public final /* synthetic */ Function0<Unit> $onRightBtnClick;
                                public final /* synthetic */ Function0<Unit> $onRightTextClick;
                                public final /* synthetic */ String $rightBtnImagePainter;
                                public final /* synthetic */ String $rightTextContent;
                                public final /* synthetic */ Boolean $showCheckBox;
                                public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                    this.$$dirty = r4;
                                    this.$viewModel = r5;
                                    this.$rightBtnImagePainter = r6;
                                    this.$onRightBtnClick = r7;
                                    this.$rightTextContent = r8;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                                    int i77;
                                    Object obj;
                                    String str252;
                                    String str262;
                                    String str27;
                                    String str28;
                                    MutableState<Boolean> mutableState;
                                    n nVar2 = nVar;
                                    Composer composer6 = composer5;
                                    int intValue2 = num6.intValue();
                                    if ((intValue2 & 14) == 0) {
                                        i77 = (composer6.changed(nVar2) ? 4 : 2) | intValue2;
                                    } else {
                                        i77 = intValue2;
                                    }
                                    if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(83640332, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:158)");
                                        }
                                        boolean z18 = false;
                                        if (Intrinsics.areEqual(this.$showCheckBox, Boolean.TRUE)) {
                                            composer6.startReplaceableGroup(-1319185738);
                                            i.Companion companion2 = i.INSTANCE;
                                            i f19 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                            com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                            if (k.a(cVar)) {
                                                str262 = "0S200MNJT807V3GE";
                                            } else {
                                                str262 = "0M2003OIIM08YV9M";
                                            }
                                            e dTBaseParams = DTReportConstKt.getDTBaseParams(str262);
                                            QQFlashTransferViewModel qQFlashTransferViewModel7 = this.$viewModel;
                                            if (qQFlashTransferViewModel7 != null && (mutableState = qQFlashTransferViewModel7.isAllSelectMode) != null && mutableState.getValue().booleanValue()) {
                                                z18 = true;
                                            }
                                            if (z18) {
                                                str27 = "1";
                                            } else {
                                                str27 = "0";
                                            }
                                            dTBaseParams.v("is_screen", str27);
                                            Unit unit = Unit.INSTANCE;
                                            i elementVR = ModifierExtKt.elementVR(f19, "em_bas_select_all", dTBaseParams);
                                            final Boolean bool92 = this.$showCheckBox;
                                            final Function0<Unit> function0172 = this.$onRightTextClick;
                                            composer6.startReplaceableGroup(511388516);
                                            boolean changed = composer6.changed(bool92) | composer6.changed(function0172);
                                            Object rememberedValue = composer6.rememberedValue();
                                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$2$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Function0<Unit> function0182;
                                                        if (Intrinsics.areEqual(bool92, Boolean.TRUE) && (function0182 = function0172) != null) {
                                                            function0182.invoke();
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer6.updateRememberedValue(rememberedValue);
                                            }
                                            composer6.endReplaceableGroup();
                                            i d16 = ViewEventPropUpdaterKt.d(elementVR, false, null, (Function1) rememberedValue, 3, null);
                                            Alignment.Companion companion3 = Alignment.INSTANCE;
                                            Alignment.Vertical c16 = companion3.c();
                                            final QQFlashTransferViewModel qQFlashTransferViewModel8 = this.$viewModel;
                                            final String str29 = this.$rightBtnImagePainter;
                                            RowKt.a(d16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer6, 762994953, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                    SnapshotStateMap<String, ab> snapshotStateMap2;
                                                    MutableState<Boolean> mutableState2;
                                                    Composer composer8 = composer7;
                                                    int intValue3 = num7.intValue();
                                                    if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                        composer8.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(762994953, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:169)");
                                                        }
                                                        i.Companion companion4 = i.INSTANCE;
                                                        i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), 4.0f, 0.0f, 4.0f, 0.0f, 10, null);
                                                        QQFlashTransferViewModel qQFlashTransferViewModel9 = QQFlashTransferViewModel.this;
                                                        boolean z19 = false;
                                                        QQFTCheckBoxViewKt.QQFTCheckBoxView(n3, 0.0f, (qQFlashTransferViewModel9 == null || (mutableState2 = qQFlashTransferViewModel9.isAllSelectMode) == null || !mutableState2.getValue().booleanValue()) ? false : true, null, null, false, composer8, 8, 58);
                                                        QQFlashTransferViewModel qQFlashTransferViewModel10 = QQFlashTransferViewModel.this;
                                                        if (qQFlashTransferViewModel10 != null && (snapshotStateMap2 = qQFlashTransferViewModel10.selectFilesToDownload) != null && (!snapshotStateMap2.isEmpty())) {
                                                            z19 = true;
                                                        }
                                                        TextKt.a("\u5168\u9009", ComposeLayoutPropUpdaterKt.n(companion4, 0.0f, 0.0f, (z19 || str29 == null) ? 16.0f : 0.0f, 0.0f, 11, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, 1601606, 0, 0, 134216612);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer6, 196616, 26);
                                            QQFlashTransferViewModel qQFlashTransferViewModel9 = this.$viewModel;
                                            if (((qQFlashTransferViewModel9 != null ? qQFlashTransferViewModel9.selectFilesToDownload : null) == null || qQFlashTransferViewModel9.selectFilesToDownload.size() <= 0) && this.$rightBtnImagePainter != null) {
                                                a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                i A = ModifiersKt.A(nVar2.b(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), companion3.c()), 0.5f, 0.0f, 2, null);
                                                if (k.a(cVar)) {
                                                    str28 = "0S200MNJT807V3GE";
                                                } else {
                                                    str28 = "0M2003OIIM08YV9M";
                                                }
                                                i elementVR2 = ModifierExtKt.elementVR(A, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str28));
                                                final Function0<Unit> function0182 = this.$onRightBtnClick;
                                                composer6.startReplaceableGroup(1157296644);
                                                boolean changed2 = composer6.changed(function0182);
                                                Object rememberedValue2 = composer6.rememberedValue();
                                                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$4$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            Function0<Unit> function0192 = function0182;
                                                            if (function0192 != null) {
                                                                function0192.invoke();
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer6.updateRememberedValue(rememberedValue2);
                                                }
                                                composer6.endReplaceableGroup();
                                                i d17 = ViewEventPropUpdaterKt.d(elementVR2, false, null, (Function1) rememberedValue2, 3, null);
                                                final String str30 = this.$rightBtnImagePainter;
                                                final int i78 = this.$$dirty;
                                                ColumnKt.a(d17, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -578852167, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.5
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(d dVar, Composer composer7, Integer num7) {
                                                        Composer composer8 = composer7;
                                                        int intValue3 = num7.intValue();
                                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                            composer8.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-578852167, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:193)");
                                                            }
                                                            ImageKt.a(str30, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 20.0f, 0.0f, 16.0f, 0.0f, 10, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i78 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer6, 24648, 12);
                                            }
                                            composer6.endReplaceableGroup();
                                        } else {
                                            composer6.startReplaceableGroup(-1319183568);
                                            composer6.startReplaceableGroup(-1319183550);
                                            String str31 = this.$rightTextContent;
                                            if (str31 != null) {
                                                if (str31.length() > 0) {
                                                    z18 = true;
                                                }
                                            }
                                            if (z18) {
                                                i f26 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null);
                                                final Function0<Unit> function0192 = this.$onRightTextClick;
                                                composer6.startReplaceableGroup(1157296644);
                                                boolean changed3 = composer6.changed(function0192);
                                                Object rememberedValue3 = composer6.rememberedValue();
                                                if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$6$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            Function0<Unit> function020 = function0192;
                                                            if (function020 != null) {
                                                                function020.invoke();
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer6.updateRememberedValue(rememberedValue3);
                                                }
                                                composer6.endReplaceableGroup();
                                                i d18 = ViewEventPropUpdaterKt.d(f26, false, null, (Function1) rememberedValue3, 3, null);
                                                final String str32 = this.$rightTextContent;
                                                final int i79 = this.$$dirty;
                                                obj = null;
                                                RowKt.a(d18, null, null, null, null, ComposableLambdaKt.composableLambda(composer6, 1105722541, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.7
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                        int i85;
                                                        n nVar4 = nVar3;
                                                        Composer composer8 = composer7;
                                                        int intValue3 = num7.intValue();
                                                        if ((intValue3 & 14) == 0) {
                                                            i85 = (composer8.changed(nVar4) ? 4 : 2) | intValue3;
                                                        } else {
                                                            i85 = intValue3;
                                                        }
                                                        if ((i85 & 91) == 18 && composer8.getSkipping()) {
                                                            composer8.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1105722541, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:204)");
                                                            }
                                                            h color$default = QUIToken.color$default("text_nav_secondary");
                                                            int a17 = ai.INSTANCE.a();
                                                            TextKt.a(str32, ModifiersKt.w(nVar4.b(i.INSTANCE, Alignment.INSTANCE.c()), QUIToken.color$default("overlay_standard_primary")), null, color$default, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, ai.f(a17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i79 >> 24) & 14) | 1601600, 0, 0, 134216612);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer6, 196616, 30);
                                            } else {
                                                obj = null;
                                            }
                                            composer6.endReplaceableGroup();
                                            if (this.$rightBtnImagePainter != null) {
                                                Alignment alignment = Alignment.CenterStart;
                                                i f27 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, obj);
                                                if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                                    str252 = "0S200MNJT807V3GE";
                                                } else {
                                                    str252 = "0M2003OIIM08YV9M";
                                                }
                                                i elementVR3 = ModifierExtKt.elementVR(f27, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str252));
                                                final Function0<Unit> function020 = this.$onRightBtnClick;
                                                composer6.startReplaceableGroup(1157296644);
                                                boolean changed4 = composer6.changed(function020);
                                                Object rememberedValue4 = composer6.rememberedValue();
                                                if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$8$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            Function0<Unit> function021 = function020;
                                                            if (function021 != null) {
                                                                function021.invoke();
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer6.updateRememberedValue(rememberedValue4);
                                                }
                                                composer6.endReplaceableGroup();
                                                i d19 = ViewEventPropUpdaterKt.d(elementVR3, false, null, (Function1) rememberedValue4, 3, null);
                                                final String str33 = this.$rightBtnImagePainter;
                                                final int i85 = this.$$dirty;
                                                BoxKt.a(d19, alignment, null, ComposableLambdaKt.composableLambda(composer6, 1487136136, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.9
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(b bVar4, Composer composer7, Integer num7) {
                                                        Composer composer8 = composer7;
                                                        int intValue3 = num7.intValue();
                                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                            composer8.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1487136136, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:223)");
                                                            }
                                                            ImageKt.a(str33, null, null, null, null, ModifiersKt.A(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 12.0f, 0.0f, 16.0f, 0.0f, 10, null), 0.5f, 0.0f, 2, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i85 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer6, 3128, 4);
                                            }
                                            composer6.endReplaceableGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer4, 196680, 24);
                            if (Intrinsics.areEqual(bool722222, Boolean.TRUE)) {
                                SurfaceKt.a(ModifiersKt.c(bVar2.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 0.5f), Alignment.BottomCenter), QUIToken.color$default("border_light")), null, null, null, ComposableSingletons$QQFTNavBarKt.f144lambda1, composer4, 24584, 14);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }
                    z17 = false;
                    r26 = z16;
                    if (z17) {
                    }
                    composer4.endReplaceableGroup();
                    RowKt.a(ComposeLayoutPropUpdaterKt.f(bVar2.a(companion, Alignment.CenterEnd), 0.0f, 1, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.c(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer4, 83640332, true, new Function3<n, Composer, Integer, Unit>(bool822222, function01322222, i7522222, i6922222, QQFlashTransferViewModel.this, str2222222, function01622222, str2422222) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1.3
                        public final /* synthetic */ int $$dirty;
                        public final /* synthetic */ Function0<Unit> $onRightBtnClick;
                        public final /* synthetic */ Function0<Unit> $onRightTextClick;
                        public final /* synthetic */ String $rightBtnImagePainter;
                        public final /* synthetic */ String $rightTextContent;
                        public final /* synthetic */ Boolean $showCheckBox;
                        public final /* synthetic */ QQFlashTransferViewModel $viewModel;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                            this.$$dirty = r4;
                            this.$viewModel = r5;
                            this.$rightBtnImagePainter = r6;
                            this.$onRightBtnClick = r7;
                            this.$rightTextContent = r8;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer5, Integer num6) {
                            int i77;
                            Object obj;
                            String str252;
                            String str262;
                            String str27;
                            String str28;
                            MutableState<Boolean> mutableState;
                            n nVar2 = nVar;
                            Composer composer6 = composer5;
                            int intValue2 = num6.intValue();
                            if ((intValue2 & 14) == 0) {
                                i77 = (composer6.changed(nVar2) ? 4 : 2) | intValue2;
                            } else {
                                i77 = intValue2;
                            }
                            if ((i77 & 91) == 18 && composer6.getSkipping()) {
                                composer6.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(83640332, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous> (QQFTNavBar.kt:158)");
                                }
                                boolean z18 = false;
                                if (Intrinsics.areEqual(this.$showCheckBox, Boolean.TRUE)) {
                                    composer6.startReplaceableGroup(-1319185738);
                                    i.Companion companion2 = i.INSTANCE;
                                    i f19 = ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null);
                                    com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                    if (k.a(cVar)) {
                                        str262 = "0S200MNJT807V3GE";
                                    } else {
                                        str262 = "0M2003OIIM08YV9M";
                                    }
                                    e dTBaseParams = DTReportConstKt.getDTBaseParams(str262);
                                    QQFlashTransferViewModel qQFlashTransferViewModel7 = this.$viewModel;
                                    if (qQFlashTransferViewModel7 != null && (mutableState = qQFlashTransferViewModel7.isAllSelectMode) != null && mutableState.getValue().booleanValue()) {
                                        z18 = true;
                                    }
                                    if (z18) {
                                        str27 = "1";
                                    } else {
                                        str27 = "0";
                                    }
                                    dTBaseParams.v("is_screen", str27);
                                    Unit unit = Unit.INSTANCE;
                                    i elementVR = ModifierExtKt.elementVR(f19, "em_bas_select_all", dTBaseParams);
                                    final Boolean bool92 = this.$showCheckBox;
                                    final Function0<Unit> function0172 = this.$onRightTextClick;
                                    composer6.startReplaceableGroup(511388516);
                                    boolean changed = composer6.changed(bool92) | composer6.changed(function0172);
                                    Object rememberedValue = composer6.rememberedValue();
                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Function0<Unit> function0182;
                                                if (Intrinsics.areEqual(bool92, Boolean.TRUE) && (function0182 = function0172) != null) {
                                                    function0182.invoke();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer6.updateRememberedValue(rememberedValue);
                                    }
                                    composer6.endReplaceableGroup();
                                    i d16 = ViewEventPropUpdaterKt.d(elementVR, false, null, (Function1) rememberedValue, 3, null);
                                    Alignment.Companion companion3 = Alignment.INSTANCE;
                                    Alignment.Vertical c16 = companion3.c();
                                    final QQFlashTransferViewModel qQFlashTransferViewModel8 = this.$viewModel;
                                    final String str29 = this.$rightBtnImagePainter;
                                    RowKt.a(d16, null, c16, null, null, ComposableLambdaKt.composableLambda(composer6, 762994953, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                            SnapshotStateMap<String, ab> snapshotStateMap2;
                                            MutableState<Boolean> mutableState2;
                                            Composer composer8 = composer7;
                                            int intValue3 = num7.intValue();
                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                composer8.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(762994953, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:169)");
                                                }
                                                i.Companion companion4 = i.INSTANCE;
                                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), 4.0f, 0.0f, 4.0f, 0.0f, 10, null);
                                                QQFlashTransferViewModel qQFlashTransferViewModel9 = QQFlashTransferViewModel.this;
                                                boolean z19 = false;
                                                QQFTCheckBoxViewKt.QQFTCheckBoxView(n3, 0.0f, (qQFlashTransferViewModel9 == null || (mutableState2 = qQFlashTransferViewModel9.isAllSelectMode) == null || !mutableState2.getValue().booleanValue()) ? false : true, null, null, false, composer8, 8, 58);
                                                QQFlashTransferViewModel qQFlashTransferViewModel10 = QQFlashTransferViewModel.this;
                                                if (qQFlashTransferViewModel10 != null && (snapshotStateMap2 = qQFlashTransferViewModel10.selectFilesToDownload) != null && (!snapshotStateMap2.isEmpty())) {
                                                    z19 = true;
                                                }
                                                TextKt.a("\u5168\u9009", ComposeLayoutPropUpdaterKt.n(companion4, 0.0f, 0.0f, (z19 || str29 == null) ? 16.0f : 0.0f, 0.0f, 11, null), null, QUIToken.color$default("text_primary"), Float.valueOf(16.0f), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, 1601606, 0, 0, 134216612);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer6, 196616, 26);
                                    QQFlashTransferViewModel qQFlashTransferViewModel9 = this.$viewModel;
                                    if (((qQFlashTransferViewModel9 != null ? qQFlashTransferViewModel9.selectFilesToDownload : null) == null || qQFlashTransferViewModel9.selectFilesToDownload.size() <= 0) && this.$rightBtnImagePainter != null) {
                                        a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                        i A = ModifiersKt.A(nVar2.b(ComposeLayoutPropUpdaterKt.f(companion2, 0.0f, 1, null), companion3.c()), 0.5f, 0.0f, 2, null);
                                        if (k.a(cVar)) {
                                            str28 = "0S200MNJT807V3GE";
                                        } else {
                                            str28 = "0M2003OIIM08YV9M";
                                        }
                                        i elementVR2 = ModifierExtKt.elementVR(A, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str28));
                                        final Function0<Unit> function0182 = this.$onRightBtnClick;
                                        composer6.startReplaceableGroup(1157296644);
                                        boolean changed2 = composer6.changed(function0182);
                                        Object rememberedValue2 = composer6.rememberedValue();
                                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$4$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    Function0<Unit> function0192 = function0182;
                                                    if (function0192 != null) {
                                                        function0192.invoke();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer6.updateRememberedValue(rememberedValue2);
                                        }
                                        composer6.endReplaceableGroup();
                                        i d17 = ViewEventPropUpdaterKt.d(elementVR2, false, null, (Function1) rememberedValue2, 3, null);
                                        final String str30 = this.$rightBtnImagePainter;
                                        final int i78 = this.$$dirty;
                                        ColumnKt.a(d17, b16, null, null, ComposableLambdaKt.composableLambda(composer6, -578852167, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.5
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(d dVar, Composer composer7, Integer num7) {
                                                Composer composer8 = composer7;
                                                int intValue3 = num7.intValue();
                                                if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                    composer8.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-578852167, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:193)");
                                                    }
                                                    ImageKt.a(str30, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 20.0f, 0.0f, 16.0f, 0.0f, 10, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i78 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer6, 24648, 12);
                                    }
                                    composer6.endReplaceableGroup();
                                } else {
                                    composer6.startReplaceableGroup(-1319183568);
                                    composer6.startReplaceableGroup(-1319183550);
                                    String str31 = this.$rightTextContent;
                                    if (str31 != null) {
                                        if (str31.length() > 0) {
                                            z18 = true;
                                        }
                                    }
                                    if (z18) {
                                        i f26 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null);
                                        final Function0<Unit> function0192 = this.$onRightTextClick;
                                        composer6.startReplaceableGroup(1157296644);
                                        boolean changed3 = composer6.changed(function0192);
                                        Object rememberedValue3 = composer6.rememberedValue();
                                        if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$6$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    Function0<Unit> function020 = function0192;
                                                    if (function020 != null) {
                                                        function020.invoke();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer6.updateRememberedValue(rememberedValue3);
                                        }
                                        composer6.endReplaceableGroup();
                                        i d18 = ViewEventPropUpdaterKt.d(f26, false, null, (Function1) rememberedValue3, 3, null);
                                        final String str32 = this.$rightTextContent;
                                        final int i79 = this.$$dirty;
                                        obj = null;
                                        RowKt.a(d18, null, null, null, null, ComposableLambdaKt.composableLambda(composer6, 1105722541, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.7
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(n nVar3, Composer composer7, Integer num7) {
                                                int i85;
                                                n nVar4 = nVar3;
                                                Composer composer8 = composer7;
                                                int intValue3 = num7.intValue();
                                                if ((intValue3 & 14) == 0) {
                                                    i85 = (composer8.changed(nVar4) ? 4 : 2) | intValue3;
                                                } else {
                                                    i85 = intValue3;
                                                }
                                                if ((i85 & 91) == 18 && composer8.getSkipping()) {
                                                    composer8.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1105722541, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:204)");
                                                    }
                                                    h color$default = QUIToken.color$default("text_nav_secondary");
                                                    int a17 = ai.INSTANCE.a();
                                                    TextKt.a(str32, ModifiersKt.w(nVar4.b(i.INSTANCE, Alignment.INSTANCE.c()), QUIToken.color$default("overlay_standard_primary")), null, color$default, Float.valueOf(17.0f), null, c.INSTANCE.e(), null, null, null, ai.f(a17), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, ((i79 >> 24) & 14) | 1601600, 0, 0, 134216612);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer6, 196616, 30);
                                    } else {
                                        obj = null;
                                    }
                                    composer6.endReplaceableGroup();
                                    if (this.$rightBtnImagePainter != null) {
                                        Alignment alignment = Alignment.CenterStart;
                                        i f27 = ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, obj);
                                        if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                            str252 = "0S200MNJT807V3GE";
                                        } else {
                                            str252 = "0M2003OIIM08YV9M";
                                        }
                                        i elementVR3 = ModifierExtKt.elementVR(f27, "em_bas_share_ent", DTReportConstKt.getDTBaseParams(str252));
                                        final Function0<Unit> function020 = this.$onRightBtnClick;
                                        composer6.startReplaceableGroup(1157296644);
                                        boolean changed4 = composer6.changed(function020);
                                        Object rememberedValue4 = composer6.rememberedValue();
                                        if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt$QQFTNavBar$1$3$8$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    Function0<Unit> function021 = function020;
                                                    if (function021 != null) {
                                                        function021.invoke();
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer6.updateRememberedValue(rememberedValue4);
                                        }
                                        composer6.endReplaceableGroup();
                                        i d19 = ViewEventPropUpdaterKt.d(elementVR3, false, null, (Function1) rememberedValue4, 3, null);
                                        final String str33 = this.$rightBtnImagePainter;
                                        final int i85 = this.$$dirty;
                                        BoxKt.a(d19, alignment, null, ComposableLambdaKt.composableLambda(composer6, 1487136136, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBarKt.QQFTNavBar.1.3.9
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(b bVar4, Composer composer7, Integer num7) {
                                                Composer composer8 = composer7;
                                                int intValue3 = num7.intValue();
                                                if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                    composer8.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1487136136, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTNavBar.<anonymous>.<anonymous>.<anonymous> (QQFTNavBar.kt:223)");
                                                    }
                                                    ImageKt.a(str33, null, null, null, null, ModifiersKt.A(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 24.0f), 12.0f, 0.0f, 16.0f, 0.0f, 10, null), 0.5f, 0.0f, 2, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer8, ((i85 >> 21) & 14) | 262144, 0, 0, 2097118);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer6, 3128, 4);
                                    }
                                    composer6.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer4, 196680, 24);
                    if (Intrinsics.areEqual(bool722222, Boolean.TRUE)) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
                return Unit.INSTANCE;
            }
        }), composer2, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        qQFlashTransferViewModel3 = qQFlashTransferViewModel2;
        str14 = str7;
        hVar3 = hVar2;
        str15 = str8;
        str16 = str11;
        num3 = num2;
        str17 = str9;
        function09 = function06;
        bool5 = bool4;
        bool6 = bool3;
        function010 = function01322222;
        function011 = function07;
        f18 = f17;
        function012 = function05;
        str18 = str1922222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final float access$getMaxTitleWidth(String str) {
        float m3;
        int i3 = 20;
        if (str != null) {
            m3 = (GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(com.tencent.kuikly.core.manager.c.f117352a) - 124) - 20;
            i3 = 44;
        } else {
            m3 = GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(com.tencent.kuikly.core.manager.c.f117352a) - 124;
        }
        return m3 - i3;
    }
}
