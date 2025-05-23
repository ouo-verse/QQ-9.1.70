package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.core.k;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
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
import com.tencent.view.FilterEnum;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUIListDoubleLineCommonViewKt {
    /* JADX WARN: Code restructure failed: missing block: B:49:0x016f, code lost:
    
        if (r1.changed(r63) == false) goto L125;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x036d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QUIListDoubleLineCommonView(i iVar, String str, Function2<? super Composer, ? super Integer, Unit> function2, String str2, float f16, h hVar, Function2<? super Composer, ? super Integer, Unit> function22, String str3, h hVar2, Function2<? super Composer, ? super Integer, Unit> function23, float f17, String str4, Function3<? super i, ? super Composer, ? super Integer, Unit> function3, String str5, Function2<? super Composer, ? super Integer, Unit> function24, float f18, Composer composer, final int i3, final int i16, final int i17) {
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
        String str6;
        Function2<? super Composer, ? super Integer, Unit> function25;
        String str7;
        float f19;
        h hVar3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        String str8;
        h hVar4;
        Function2<? super Composer, ? super Integer, Unit> function27;
        float f26;
        String str9;
        Function3<? super i, ? super Composer, ? super Integer, Unit> function32;
        h hVar5;
        i iVar2;
        String str10;
        float f27;
        int i58;
        int i59;
        String str11;
        Function2<? super Composer, ? super Integer, Unit> function28;
        i iVar3;
        h hVar6;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Object rememberedValue;
        int i65;
        h j3;
        final Ref.BooleanRef booleanRef;
        Composer composer2;
        float f28;
        final i iVar4;
        final String str12;
        final String str13;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        Function2<? super Composer, ? super Integer, Unit> function211;
        final String str14;
        final String str15;
        final float f29;
        final h hVar7;
        final Function3<? super i, ? super Composer, ? super Integer, Unit> function33;
        final h hVar8;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final float f36;
        final String str16;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1283303938);
        int i66 = i17 & 1;
        int i67 = i66 != 0 ? i3 | 2 : i3;
        int i68 = i17 & 2;
        if (i68 != 0) {
            i67 |= 48;
        } else if ((i3 & 112) == 0) {
            i67 |= startRestartGroup.changed(str) ? 32 : 16;
            i18 = i17 & 4;
            if (i18 == 0) {
                i67 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                i67 |= startRestartGroup.changed(function2) ? 256 : 128;
                i19 = i17 & 8;
                int i69 = 2048;
                if (i19 != 0) {
                    i67 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    i67 |= startRestartGroup.changed(str2) ? 2048 : 1024;
                    i26 = i17 & 16;
                    if (i26 == 0) {
                        i67 |= 24576;
                    } else if ((i3 & 57344) == 0) {
                        i67 |= startRestartGroup.changed(f16) ? 16384 : 8192;
                    }
                    i27 = i17 & 32;
                    if (i27 != 0) {
                        i67 |= 65536;
                    }
                    i28 = i17 & 64;
                    if (i28 == 0) {
                        i67 |= 1572864;
                    } else if ((i3 & 3670016) == 0) {
                        i67 |= startRestartGroup.changed(function22) ? 1048576 : 524288;
                    }
                    i29 = i17 & 128;
                    if (i29 == 0) {
                        i67 |= 12582912;
                    } else if ((i3 & 29360128) == 0) {
                        i67 |= startRestartGroup.changed(str3) ? 8388608 : 4194304;
                    }
                    i36 = i17 & 256;
                    if (i36 != 0) {
                        i67 |= 33554432;
                    }
                    i37 = i17 & 512;
                    if (i37 == 0) {
                        i67 |= 805306368;
                    } else if ((i3 & 1879048192) == 0) {
                        i67 |= startRestartGroup.changed(function23) ? 536870912 : 268435456;
                    }
                    i38 = i17 & 1024;
                    if (i38 == 0) {
                        i39 = i16 | 6;
                    } else if ((i16 & 14) == 0) {
                        i39 = i16 | (startRestartGroup.changed(f17) ? 4 : 2);
                    } else {
                        i39 = i16;
                    }
                    i46 = i17 & 2048;
                    if (i46 == 0) {
                        i39 |= 48;
                    } else if ((i16 & 112) == 0) {
                        i39 |= startRestartGroup.changed(str4) ? 32 : 16;
                    }
                    int i75 = i39;
                    i47 = i17 & 4096;
                    if (i47 == 0) {
                        i75 |= MsgConstant.KRMFILETHUMBSIZE384;
                        i48 = i47;
                    } else {
                        i48 = i47;
                        if ((i16 & 896) == 0) {
                            i75 |= startRestartGroup.changed(function3) ? 256 : 128;
                            if ((i16 & 7168) == 0) {
                                if ((i17 & 8192) != 0) {
                                }
                                i69 = 1024;
                                i75 |= i69;
                            }
                            i49 = i17 & 16384;
                            if (i49 != 0) {
                                i75 |= 24576;
                            } else if ((i16 & 57344) == 0) {
                                i56 = i49;
                                i75 |= startRestartGroup.changed(function24) ? 16384 : 8192;
                                i57 = i17 & 32768;
                                if (i57 == 0) {
                                    i75 |= 196608;
                                } else if ((i16 & 458752) == 0) {
                                    i75 |= startRestartGroup.changed(f18) ? 131072 : 65536;
                                }
                                if ((i17 & FilterEnum.MIC_PTU_ZIRAN) != 289 && (1533916891 & i67) == 306783378 && (374491 & i75) == 74898 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    str13 = str;
                                    function210 = function2;
                                    str15 = str2;
                                    f29 = f16;
                                    hVar7 = hVar;
                                    function213 = function22;
                                    str14 = str3;
                                    hVar8 = hVar2;
                                    function212 = function23;
                                    f36 = f17;
                                    str16 = str4;
                                    function33 = function3;
                                    str12 = str5;
                                    function211 = function24;
                                    f28 = f18;
                                    composer2 = startRestartGroup;
                                    iVar4 = iVar;
                                } else {
                                    startRestartGroup.startDefaults();
                                    if ((i3 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        if (i27 != 0) {
                                            i67 &= -458753;
                                        }
                                        if (i36 != 0) {
                                            i67 &= -234881025;
                                        }
                                        if ((i17 & 8192) != 0) {
                                            i75 &= -7169;
                                        }
                                        iVar3 = iVar;
                                        str6 = str;
                                        function25 = function2;
                                        str7 = str2;
                                        f19 = f16;
                                        hVar3 = hVar;
                                        function26 = function22;
                                        str8 = str3;
                                        hVar6 = hVar2;
                                        function27 = function23;
                                        f26 = f17;
                                        str9 = str4;
                                        function32 = function3;
                                        f27 = f18;
                                        i58 = i67;
                                        i59 = i75;
                                        str11 = str5;
                                        function28 = function24;
                                    } else {
                                        i iVar5 = i66 == 0 ? i.INSTANCE : iVar;
                                        str6 = i68 == 0 ? null : str;
                                        function25 = i18 == 0 ? null : function2;
                                        str7 = i19 == 0 ? "" : str2;
                                        f19 = i26 == 0 ? 0.5f : f16;
                                        if (i27 == 0) {
                                            hVar3 = QUIToken.color$default("text_primary");
                                            i67 &= -458753;
                                        } else {
                                            hVar3 = hVar;
                                        }
                                        function26 = i28 == 0 ? null : function22;
                                        str8 = i29 == 0 ? "" : str3;
                                        if (i36 == 0) {
                                            hVar4 = QUIToken.color$default("text_secondary");
                                            i67 &= -234881025;
                                        } else {
                                            hVar4 = hVar2;
                                        }
                                        function27 = i37 == 0 ? null : function23;
                                        f26 = i38 == 0 ? 12.0f : f17;
                                        str9 = i46 == 0 ? null : str4;
                                        function32 = i48 == 0 ? null : function3;
                                        if ((i17 & 8192) == 0) {
                                            hVar5 = hVar4;
                                            iVar2 = iVar5;
                                            str10 = QUIToken.INSTANCE.image("chevron_right", QUIToken.color$default("text_secondary"));
                                            i75 &= -7169;
                                        } else {
                                            hVar5 = hVar4;
                                            iVar2 = iVar5;
                                            str10 = str5;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function214 = i56 == 0 ? null : function24;
                                        f27 = i57 == 0 ? 0.5f : f18;
                                        i58 = i67;
                                        i59 = i75;
                                        str11 = str10;
                                        function28 = function214;
                                        iVar3 = iVar2;
                                        hVar6 = hVar5;
                                    }
                                    startRestartGroup.endDefaults();
                                    final h hVar9 = hVar6;
                                    if (ComposerKt.isTraceInProgress()) {
                                        function29 = function27;
                                    } else {
                                        function29 = function27;
                                        ComposerKt.traceEventStart(-1283303938, i58, i59, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView (QUIListDoubleLineCommonView.kt:54)");
                                    }
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue != Composer.INSTANCE.getEmpty()) {
                                        i65 = i59;
                                        rememberedValue = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, startRestartGroup);
                                    } else {
                                        i65 = i59;
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    final MutableState mutableState = (MutableState) rememberedValue;
                                    i iVar6 = i.INSTANCE;
                                    final float f37 = f27;
                                    final float f38 = f26;
                                    i d16 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.r(iVar6.b(iVar3), 16.0f, 10.0f, 16.0f, 10.0f), Math.max(((Number) mutableState.getValue()).floatValue() + 20.0f, 72.0f)), 0.0f, 1, null), QUIToken.color$default("fill_light_secondary"));
                                    if (function28 == null) {
                                        if (!(str11.length() == 0)) {
                                            QQCommonNApiModule.Companion companion = QQCommonNApiModule.Companion;
                                            j3 = ((QQCommonNApiModule) c.f117352a.g().acquireModule("QQCommonNApiModule")).isDarkTheme() ? h.INSTANCE.p(0.1f) : h.INSTANCE.a(0.1f);
                                            i w3 = ModifiersKt.w(d16, j3);
                                            booleanRef = new Ref.BooleanRef();
                                            iVar3.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$hasAccessibility$1
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
                                                StringBuilder m3 = HotViewKt$$ExternalSyntheticOutline0.m(str7, str8);
                                                m3.append(str9 == null ? "" : str9);
                                                iVar6 = ModifiersKt.a(iVar6, m3.toString());
                                            }
                                            final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                                            final int i76 = i58;
                                            final String str17 = str6;
                                            final float f39 = f19;
                                            final Function3<? super i, ? super Composer, ? super Integer, Unit> function34 = function32;
                                            final int i77 = i65;
                                            final String str18 = str9;
                                            final String str19 = str11;
                                            final Function2<? super Composer, ? super Integer, Unit> function216 = function28;
                                            final Function2<? super Composer, ? super Integer, Unit> function217 = function26;
                                            final String str20 = str7;
                                            final h hVar10 = hVar3;
                                            final Function2<? super Composer, ? super Integer, Unit> function218 = function29;
                                            final String str21 = str8;
                                            composer2 = startRestartGroup;
                                            RowKt.a(w3.b(iVar6), a.f339245a.g(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(composer2, 758734364, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                /* JADX WARN: Removed duplicated region for block: B:37:0x023a  */
                                                /* JADX WARN: Removed duplicated region for block: B:40:0x02b7  */
                                                /* JADX WARN: Removed duplicated region for block: B:41:0x0253  */
                                                /* JADX WARN: Removed duplicated region for block: B:58:0x0181  */
                                                /* JADX WARN: Removed duplicated region for block: B:59:0x01f9  */
                                                @Override // kotlin.jvm.functions.Function3
                                                /*
                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                */
                                                public final Unit invoke(n nVar, Composer composer3, Integer num) {
                                                    int i78;
                                                    int i79;
                                                    int i85;
                                                    int i86;
                                                    boolean z16;
                                                    i.Companion companion2;
                                                    i.Companion companion3;
                                                    boolean z17;
                                                    n nVar2 = nVar;
                                                    Composer composer4 = composer3;
                                                    int intValue = num.intValue();
                                                    if ((intValue & 14) == 0) {
                                                        i78 = (composer4.changed(nVar2) ? 4 : 2) | intValue;
                                                    } else {
                                                        i78 = intValue;
                                                    }
                                                    if ((i78 & 91) == 18 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(758734364, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous> (QUIListDoubleLineCommonView.kt:85)");
                                                        }
                                                        if (function215 != null) {
                                                            composer4.startReplaceableGroup(-1787677728);
                                                            function215.invoke(composer4, Integer.valueOf((i76 >> 6) & 14));
                                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 12.0f), composer4, 8, 0);
                                                            composer4.endReplaceableGroup();
                                                            i79 = 8;
                                                            i85 = 0;
                                                        } else if (str17 != null) {
                                                            composer4.startReplaceableGroup(-1787677596);
                                                            String str22 = str17;
                                                            i.Companion companion4 = i.INSTANCE;
                                                            ImageKt.a(str22, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer4, ((i76 >> 3) & 14) | 262144, 0, 0, 2097118);
                                                            composer4 = composer4;
                                                            i85 = 0;
                                                            i79 = 8;
                                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion4, 12.0f), composer4, 8, 0);
                                                            composer4.endReplaceableGroup();
                                                        } else {
                                                            i79 = 8;
                                                            i85 = 0;
                                                            composer4.startReplaceableGroup(-1787677418);
                                                            composer4.endReplaceableGroup();
                                                        }
                                                        i.Companion companion5 = i.INSTANCE;
                                                        i z18 = ComposeLayoutPropUpdaterKt.z(nVar2.a(companion5, f39));
                                                        final MutableState<Float> mutableState2 = mutableState;
                                                        composer4.startReplaceableGroup(1157296644);
                                                        boolean changed = composer4.changed(mutableState2);
                                                        Object rememberedValue2 = composer4.rememberedValue();
                                                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue2 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1$1$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(w wVar) {
                                                                    mutableState2.setValue(Float.valueOf(wVar.getHeight()));
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            composer4.updateRememberedValue(rememberedValue2);
                                                        }
                                                        composer4.endReplaceableGroup();
                                                        i m16 = ViewEventPropUpdaterKt.m(z18, (Function1) rememberedValue2);
                                                        final Function2<Composer, Integer, Unit> function219 = function217;
                                                        final String str23 = str20;
                                                        final h hVar11 = hVar10;
                                                        final int i87 = i76;
                                                        final Function2<Composer, Integer, Unit> function220 = function218;
                                                        final String str24 = str21;
                                                        final h hVar12 = hVar9;
                                                        ColumnKt.a(m16, null, null, null, ComposableLambdaKt.composableLambda(composer4, -1642571259, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(d dVar, Composer composer5, Integer num2) {
                                                                Composer composer6;
                                                                Composer composer7 = composer5;
                                                                int intValue2 = num2.intValue();
                                                                if ((intValue2 & 81) == 16 && composer7.getSkipping()) {
                                                                    composer7.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1642571259, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:105)");
                                                                    }
                                                                    if (function219 != null) {
                                                                        composer7.startReplaceableGroup(765799035);
                                                                        i z19 = ComposeLayoutPropUpdaterKt.z(i.INSTANCE);
                                                                        Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                                                        final Function2<Composer, Integer, Unit> function221 = function219;
                                                                        final int i88 = i87;
                                                                        ColumnKt.a(z19, null, horizontal, null, ComposableLambdaKt.composableLambda(composer7, -158325005, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt.QUIListDoubleLineCommonView.1.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(d dVar2, Composer composer8, Integer num3) {
                                                                                Composer composer9 = composer8;
                                                                                int intValue3 = num3.intValue();
                                                                                if ((intValue3 & 81) == 16 && composer9.getSkipping()) {
                                                                                    composer9.skipToGroupEnd();
                                                                                } else {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(-158325005, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:110)");
                                                                                    }
                                                                                    function221.invoke(composer9, Integer.valueOf((i88 >> 18) & 14));
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer7, 24968, 10);
                                                                        composer7.endReplaceableGroup();
                                                                        composer6 = composer7;
                                                                    } else {
                                                                        composer7.startReplaceableGroup(765799315);
                                                                        composer6 = composer7;
                                                                        TextKt.a(str23, null, null, hVar11, Float.valueOf(17.0f), null, null, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer6, ((i87 >> 9) & 14) | 28672, 100663344, 0, 133953510);
                                                                        composer6.endReplaceableGroup();
                                                                    }
                                                                    i.Companion companion6 = i.INSTANCE;
                                                                    Composer composer8 = composer6;
                                                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion6, 0.0f, 1, null), 3.0f), composer8, 8, 0);
                                                                    if (function220 != null) {
                                                                        composer8.startReplaceableGroup(765799686);
                                                                        i z26 = ComposeLayoutPropUpdaterKt.z(companion6);
                                                                        Alignment.Horizontal horizontal2 = Alignment.Horizontal.CenterHorizontally;
                                                                        final Function2<Composer, Integer, Unit> function222 = function220;
                                                                        final int i89 = i87;
                                                                        ColumnKt.a(z26, null, horizontal2, null, ComposableLambdaKt.composableLambda(composer8, 1984435420, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt.QUIListDoubleLineCommonView.1.2.2
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(d dVar2, Composer composer9, Integer num3) {
                                                                                Composer composer10 = composer9;
                                                                                int intValue3 = num3.intValue();
                                                                                if ((intValue3 & 81) == 16 && composer10.getSkipping()) {
                                                                                    composer10.skipToGroupEnd();
                                                                                } else {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(1984435420, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:129)");
                                                                                    }
                                                                                    function222.invoke(composer10, Integer.valueOf((i89 >> 27) & 14));
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer8, 24968, 10);
                                                                        composer8.endReplaceableGroup();
                                                                    } else {
                                                                        composer8.startReplaceableGroup(765799969);
                                                                        TextKt.a(str24, null, null, hVar12, Float.valueOf(14.0f), null, null, null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer8, ((i87 >> 21) & 14) | 28672, 100663344, 0, 133953510);
                                                                        composer8.endReplaceableGroup();
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer4, 24584, 14);
                                                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion5, f38), composer4, i79, i85);
                                                        if (function34 != null) {
                                                            composer4.startReplaceableGroup(-1787675785);
                                                            function34.invoke(nVar2.a(companion5, f37), composer4, Integer.valueOf(((i77 >> 3) & 112) | i79));
                                                            composer4.endReplaceableGroup();
                                                            z16 = true;
                                                            companion2 = companion5;
                                                        } else {
                                                            String str25 = str18;
                                                            if (str25 != null) {
                                                                if ((str25.length() > 0 ? 1 : i85) == 1) {
                                                                    i86 = 1;
                                                                    if (i86 == 0) {
                                                                        composer4.startReplaceableGroup(-1787675659);
                                                                        z16 = true;
                                                                        companion2 = companion5;
                                                                        Composer composer5 = composer4;
                                                                        TextKt.a(str18, ComposeLayoutPropUpdaterKt.s(nVar2.a(companion5, f37), 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, ai.f(ai.INSTANCE.d()), null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, ((i77 >> 3) & 14) | 28736, 100663296, 0, 133954532);
                                                                        composer5.endReplaceableGroup();
                                                                        composer4 = composer5;
                                                                    } else {
                                                                        z16 = true;
                                                                        companion2 = companion5;
                                                                        composer4.startReplaceableGroup(-1787675364);
                                                                        composer4.endReplaceableGroup();
                                                                    }
                                                                }
                                                            }
                                                            i86 = i85;
                                                            if (i86 == 0) {
                                                            }
                                                        }
                                                        composer4.startReplaceableGroup(-1787675355);
                                                        if (function34 == null) {
                                                            if (!(str19.length() > 0 ? z16 : false)) {
                                                                companion3 = companion2;
                                                                z17 = false;
                                                                composer4.endReplaceableGroup();
                                                                if (function216 == null) {
                                                                    composer4.startReplaceableGroup(-1787675187);
                                                                    function216.invoke(composer4, Integer.valueOf((i77 >> 12) & 14));
                                                                    composer4.endReplaceableGroup();
                                                                } else {
                                                                    if (str19.length() > 0 ? z16 : z17) {
                                                                        composer4.startReplaceableGroup(-1787675099);
                                                                        Composer composer6 = composer4;
                                                                        ImageKt.a(str19, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion3, 16.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, ((i77 >> 9) & 14) | 262144, 0, 0, 2097118);
                                                                        composer6.endReplaceableGroup();
                                                                    } else {
                                                                        Composer composer7 = composer4;
                                                                        composer7.startReplaceableGroup(-1787674972);
                                                                        composer7.endReplaceableGroup();
                                                                    }
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }
                                                        companion3 = companion2;
                                                        z17 = false;
                                                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion3, 2.0f), composer4, 8, 0);
                                                        composer4.endReplaceableGroup();
                                                        if (function216 == null) {
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
                                            f28 = f37;
                                            iVar4 = iVar3;
                                            str12 = str11;
                                            str13 = str6;
                                            function210 = function25;
                                            function211 = function28;
                                            str14 = str8;
                                            str15 = str7;
                                            f29 = f19;
                                            hVar7 = hVar3;
                                            function33 = function32;
                                            hVar8 = hVar9;
                                            function212 = function29;
                                            f36 = f38;
                                            str16 = str9;
                                            function213 = function26;
                                        }
                                    }
                                    j3 = h.INSTANCE.j();
                                    i w36 = ModifiersKt.w(d16, j3);
                                    booleanRef = new Ref.BooleanRef();
                                    iVar3.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$hasAccessibility$1
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
                                    final Function2<? super Composer, ? super Integer, Unit> function2152 = function25;
                                    final int i762 = i58;
                                    final String str172 = str6;
                                    final float f392 = f19;
                                    final Function3<? super i, ? super Composer, ? super Integer, Unit> function342 = function32;
                                    final int i772 = i65;
                                    final String str182 = str9;
                                    final String str192 = str11;
                                    final Function2<? super Composer, ? super Integer, Unit> function2162 = function28;
                                    final Function2<? super Composer, ? super Integer, Unit> function2172 = function26;
                                    final String str202 = str7;
                                    final h hVar102 = hVar3;
                                    final Function2<? super Composer, ? super Integer, Unit> function2182 = function29;
                                    final String str212 = str8;
                                    composer2 = startRestartGroup;
                                    RowKt.a(w36.b(iVar6), a.f339245a.g(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(composer2, 758734364, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        /* JADX WARN: Removed duplicated region for block: B:37:0x023a  */
                                        /* JADX WARN: Removed duplicated region for block: B:40:0x02b7  */
                                        /* JADX WARN: Removed duplicated region for block: B:41:0x0253  */
                                        /* JADX WARN: Removed duplicated region for block: B:58:0x0181  */
                                        /* JADX WARN: Removed duplicated region for block: B:59:0x01f9  */
                                        @Override // kotlin.jvm.functions.Function3
                                        /*
                                            Code decompiled incorrectly, please refer to instructions dump.
                                        */
                                        public final Unit invoke(n nVar, Composer composer3, Integer num) {
                                            int i78;
                                            int i79;
                                            int i85;
                                            int i86;
                                            boolean z16;
                                            i.Companion companion2;
                                            i.Companion companion3;
                                            boolean z17;
                                            n nVar2 = nVar;
                                            Composer composer4 = composer3;
                                            int intValue = num.intValue();
                                            if ((intValue & 14) == 0) {
                                                i78 = (composer4.changed(nVar2) ? 4 : 2) | intValue;
                                            } else {
                                                i78 = intValue;
                                            }
                                            if ((i78 & 91) == 18 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(758734364, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous> (QUIListDoubleLineCommonView.kt:85)");
                                                }
                                                if (function2152 != null) {
                                                    composer4.startReplaceableGroup(-1787677728);
                                                    function2152.invoke(composer4, Integer.valueOf((i762 >> 6) & 14));
                                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 12.0f), composer4, 8, 0);
                                                    composer4.endReplaceableGroup();
                                                    i79 = 8;
                                                    i85 = 0;
                                                } else if (str172 != null) {
                                                    composer4.startReplaceableGroup(-1787677596);
                                                    String str22 = str172;
                                                    i.Companion companion4 = i.INSTANCE;
                                                    ImageKt.a(str22, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer4, ((i762 >> 3) & 14) | 262144, 0, 0, 2097118);
                                                    composer4 = composer4;
                                                    i85 = 0;
                                                    i79 = 8;
                                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion4, 12.0f), composer4, 8, 0);
                                                    composer4.endReplaceableGroup();
                                                } else {
                                                    i79 = 8;
                                                    i85 = 0;
                                                    composer4.startReplaceableGroup(-1787677418);
                                                    composer4.endReplaceableGroup();
                                                }
                                                i.Companion companion5 = i.INSTANCE;
                                                i z18 = ComposeLayoutPropUpdaterKt.z(nVar2.a(companion5, f392));
                                                final MutableState<Float> mutableState2 = mutableState;
                                                composer4.startReplaceableGroup(1157296644);
                                                boolean changed = composer4.changed(mutableState2);
                                                Object rememberedValue2 = composer4.rememberedValue();
                                                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue2 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(w wVar) {
                                                            mutableState2.setValue(Float.valueOf(wVar.getHeight()));
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer4.updateRememberedValue(rememberedValue2);
                                                }
                                                composer4.endReplaceableGroup();
                                                i m16 = ViewEventPropUpdaterKt.m(z18, (Function1) rememberedValue2);
                                                final Function2<? super Composer, ? super Integer, Unit> function219 = function2172;
                                                final String str23 = str202;
                                                final h hVar11 = hVar102;
                                                final int i87 = i762;
                                                final Function2<? super Composer, ? super Integer, Unit> function220 = function2182;
                                                final String str24 = str212;
                                                final h hVar12 = hVar9;
                                                ColumnKt.a(m16, null, null, null, ComposableLambdaKt.composableLambda(composer4, -1642571259, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(d dVar, Composer composer5, Integer num2) {
                                                        Composer composer6;
                                                        Composer composer7 = composer5;
                                                        int intValue2 = num2.intValue();
                                                        if ((intValue2 & 81) == 16 && composer7.getSkipping()) {
                                                            composer7.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1642571259, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:105)");
                                                            }
                                                            if (function219 != null) {
                                                                composer7.startReplaceableGroup(765799035);
                                                                i z19 = ComposeLayoutPropUpdaterKt.z(i.INSTANCE);
                                                                Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                                                final Function2<? super Composer, ? super Integer, Unit> function221 = function219;
                                                                final int i88 = i87;
                                                                ColumnKt.a(z19, null, horizontal, null, ComposableLambdaKt.composableLambda(composer7, -158325005, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt.QUIListDoubleLineCommonView.1.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(d dVar2, Composer composer8, Integer num3) {
                                                                        Composer composer9 = composer8;
                                                                        int intValue3 = num3.intValue();
                                                                        if ((intValue3 & 81) == 16 && composer9.getSkipping()) {
                                                                            composer9.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(-158325005, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:110)");
                                                                            }
                                                                            function221.invoke(composer9, Integer.valueOf((i88 >> 18) & 14));
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer7, 24968, 10);
                                                                composer7.endReplaceableGroup();
                                                                composer6 = composer7;
                                                            } else {
                                                                composer7.startReplaceableGroup(765799315);
                                                                composer6 = composer7;
                                                                TextKt.a(str23, null, null, hVar11, Float.valueOf(17.0f), null, null, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer6, ((i87 >> 9) & 14) | 28672, 100663344, 0, 133953510);
                                                                composer6.endReplaceableGroup();
                                                            }
                                                            i.Companion companion6 = i.INSTANCE;
                                                            Composer composer8 = composer6;
                                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion6, 0.0f, 1, null), 3.0f), composer8, 8, 0);
                                                            if (function220 != null) {
                                                                composer8.startReplaceableGroup(765799686);
                                                                i z26 = ComposeLayoutPropUpdaterKt.z(companion6);
                                                                Alignment.Horizontal horizontal2 = Alignment.Horizontal.CenterHorizontally;
                                                                final Function2<? super Composer, ? super Integer, Unit> function222 = function220;
                                                                final int i89 = i87;
                                                                ColumnKt.a(z26, null, horizontal2, null, ComposableLambdaKt.composableLambda(composer8, 1984435420, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt.QUIListDoubleLineCommonView.1.2.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(d dVar2, Composer composer9, Integer num3) {
                                                                        Composer composer10 = composer9;
                                                                        int intValue3 = num3.intValue();
                                                                        if ((intValue3 & 81) == 16 && composer10.getSkipping()) {
                                                                            composer10.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(1984435420, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:129)");
                                                                            }
                                                                            function222.invoke(composer10, Integer.valueOf((i89 >> 27) & 14));
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer8, 24968, 10);
                                                                composer8.endReplaceableGroup();
                                                            } else {
                                                                composer8.startReplaceableGroup(765799969);
                                                                TextKt.a(str24, null, null, hVar12, Float.valueOf(14.0f), null, null, null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer8, ((i87 >> 21) & 14) | 28672, 100663344, 0, 133953510);
                                                                composer8.endReplaceableGroup();
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer4, 24584, 14);
                                                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion5, f38), composer4, i79, i85);
                                                if (function342 != null) {
                                                    composer4.startReplaceableGroup(-1787675785);
                                                    function342.invoke(nVar2.a(companion5, f37), composer4, Integer.valueOf(((i772 >> 3) & 112) | i79));
                                                    composer4.endReplaceableGroup();
                                                    z16 = true;
                                                    companion2 = companion5;
                                                } else {
                                                    String str25 = str182;
                                                    if (str25 != null) {
                                                        if ((str25.length() > 0 ? 1 : i85) == 1) {
                                                            i86 = 1;
                                                            if (i86 == 0) {
                                                                composer4.startReplaceableGroup(-1787675659);
                                                                z16 = true;
                                                                companion2 = companion5;
                                                                Composer composer5 = composer4;
                                                                TextKt.a(str182, ComposeLayoutPropUpdaterKt.s(nVar2.a(companion5, f37), 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, ai.f(ai.INSTANCE.d()), null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, ((i772 >> 3) & 14) | 28736, 100663296, 0, 133954532);
                                                                composer5.endReplaceableGroup();
                                                                composer4 = composer5;
                                                            } else {
                                                                z16 = true;
                                                                companion2 = companion5;
                                                                composer4.startReplaceableGroup(-1787675364);
                                                                composer4.endReplaceableGroup();
                                                            }
                                                        }
                                                    }
                                                    i86 = i85;
                                                    if (i86 == 0) {
                                                    }
                                                }
                                                composer4.startReplaceableGroup(-1787675355);
                                                if (function342 == null) {
                                                    if (!(str192.length() > 0 ? z16 : false)) {
                                                        companion3 = companion2;
                                                        z17 = false;
                                                        composer4.endReplaceableGroup();
                                                        if (function2162 == null) {
                                                            composer4.startReplaceableGroup(-1787675187);
                                                            function2162.invoke(composer4, Integer.valueOf((i772 >> 12) & 14));
                                                            composer4.endReplaceableGroup();
                                                        } else {
                                                            if (str192.length() > 0 ? z16 : z17) {
                                                                composer4.startReplaceableGroup(-1787675099);
                                                                Composer composer6 = composer4;
                                                                ImageKt.a(str192, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion3, 16.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, ((i772 >> 9) & 14) | 262144, 0, 0, 2097118);
                                                                composer6.endReplaceableGroup();
                                                            } else {
                                                                Composer composer7 = composer4;
                                                                composer7.startReplaceableGroup(-1787674972);
                                                                composer7.endReplaceableGroup();
                                                            }
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }
                                                companion3 = companion2;
                                                z17 = false;
                                                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion3, 2.0f), composer4, 8, 0);
                                                composer4.endReplaceableGroup();
                                                if (function2162 == null) {
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer2, 197064, 24);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    f28 = f37;
                                    iVar4 = iVar3;
                                    str12 = str11;
                                    str13 = str6;
                                    function210 = function25;
                                    function211 = function28;
                                    str14 = str8;
                                    str15 = str7;
                                    f29 = f19;
                                    hVar7 = hVar3;
                                    function33 = function32;
                                    hVar8 = hVar9;
                                    function212 = function29;
                                    f36 = f38;
                                    str16 = str9;
                                    function213 = function26;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    return;
                                }
                                final Function2<? super Composer, ? super Integer, Unit> function219 = function211;
                                final float f46 = f28;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Composer composer3, Integer num) {
                                        num.intValue();
                                        QUIListDoubleLineCommonViewKt.QUIListDoubleLineCommonView(i.this, str13, function210, str15, f29, hVar7, function213, str14, hVar8, function212, f36, str16, function33, str12, function219, f46, composer3, i3 | 1, i16, i17);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return;
                            }
                            i56 = i49;
                            i57 = i17 & 32768;
                            if (i57 == 0) {
                            }
                            if ((i17 & FilterEnum.MIC_PTU_ZIRAN) != 289) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) == 0) {
                            }
                            if (i66 == 0) {
                            }
                            if (i68 == 0) {
                            }
                            if (i18 == 0) {
                            }
                            if (i19 == 0) {
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
                            if (i38 == 0) {
                            }
                            if (i46 == 0) {
                            }
                            if (i48 == 0) {
                            }
                            if ((i17 & 8192) == 0) {
                            }
                            if (i56 == 0) {
                            }
                            if (i57 == 0) {
                            }
                            i58 = i67;
                            i59 = i75;
                            str11 = str10;
                            function28 = function214;
                            iVar3 = iVar2;
                            hVar6 = hVar5;
                            startRestartGroup.endDefaults();
                            final h hVar92 = hVar6;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue != Composer.INSTANCE.getEmpty()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            final MutableState<Float> mutableState2 = (MutableState) rememberedValue;
                            i iVar62 = i.INSTANCE;
                            final float f372 = f27;
                            final float f382 = f26;
                            i d162 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.r(iVar62.b(iVar3), 16.0f, 10.0f, 16.0f, 10.0f), Math.max(((Number) mutableState2.getValue()).floatValue() + 20.0f, 72.0f)), 0.0f, 1, null), QUIToken.color$default("fill_light_secondary"));
                            if (function28 == null) {
                            }
                            j3 = h.INSTANCE.j();
                            i w362 = ModifiersKt.w(d162, j3);
                            booleanRef = new Ref.BooleanRef();
                            iVar3.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$hasAccessibility$1
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
                            final Function2<? super Composer, ? super Integer, Unit> function21522 = function25;
                            final int i7622 = i58;
                            final String str1722 = str6;
                            final float f3922 = f19;
                            final Function3<? super i, ? super Composer, ? super Integer, Unit> function3422 = function32;
                            final int i7722 = i65;
                            final String str1822 = str9;
                            final String str1922 = str11;
                            final Function2<? super Composer, ? super Integer, Unit> function21622 = function28;
                            final Function2<? super Composer, ? super Integer, Unit> function21722 = function26;
                            final String str2022 = str7;
                            final h hVar1022 = hVar3;
                            final Function2<? super Composer, ? super Integer, Unit> function21822 = function29;
                            final String str2122 = str8;
                            composer2 = startRestartGroup;
                            RowKt.a(w362.b(iVar62), a.f339245a.g(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(composer2, 758734364, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                /* JADX WARN: Removed duplicated region for block: B:37:0x023a  */
                                /* JADX WARN: Removed duplicated region for block: B:40:0x02b7  */
                                /* JADX WARN: Removed duplicated region for block: B:41:0x0253  */
                                /* JADX WARN: Removed duplicated region for block: B:58:0x0181  */
                                /* JADX WARN: Removed duplicated region for block: B:59:0x01f9  */
                                @Override // kotlin.jvm.functions.Function3
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Unit invoke(n nVar, Composer composer3, Integer num) {
                                    int i78;
                                    int i79;
                                    int i85;
                                    int i86;
                                    boolean z16;
                                    i.Companion companion2;
                                    i.Companion companion3;
                                    boolean z17;
                                    n nVar2 = nVar;
                                    Composer composer4 = composer3;
                                    int intValue = num.intValue();
                                    if ((intValue & 14) == 0) {
                                        i78 = (composer4.changed(nVar2) ? 4 : 2) | intValue;
                                    } else {
                                        i78 = intValue;
                                    }
                                    if ((i78 & 91) == 18 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(758734364, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous> (QUIListDoubleLineCommonView.kt:85)");
                                        }
                                        if (function21522 != null) {
                                            composer4.startReplaceableGroup(-1787677728);
                                            function21522.invoke(composer4, Integer.valueOf((i7622 >> 6) & 14));
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 12.0f), composer4, 8, 0);
                                            composer4.endReplaceableGroup();
                                            i79 = 8;
                                            i85 = 0;
                                        } else if (str1722 != null) {
                                            composer4.startReplaceableGroup(-1787677596);
                                            String str22 = str1722;
                                            i.Companion companion4 = i.INSTANCE;
                                            ImageKt.a(str22, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer4, ((i7622 >> 3) & 14) | 262144, 0, 0, 2097118);
                                            composer4 = composer4;
                                            i85 = 0;
                                            i79 = 8;
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion4, 12.0f), composer4, 8, 0);
                                            composer4.endReplaceableGroup();
                                        } else {
                                            i79 = 8;
                                            i85 = 0;
                                            composer4.startReplaceableGroup(-1787677418);
                                            composer4.endReplaceableGroup();
                                        }
                                        i.Companion companion5 = i.INSTANCE;
                                        i z18 = ComposeLayoutPropUpdaterKt.z(nVar2.a(companion5, f3922));
                                        final MutableState<Float> mutableState22 = mutableState2;
                                        composer4.startReplaceableGroup(1157296644);
                                        boolean changed = composer4.changed(mutableState22);
                                        Object rememberedValue2 = composer4.rememberedValue();
                                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(w wVar) {
                                                    mutableState22.setValue(Float.valueOf(wVar.getHeight()));
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer4.updateRememberedValue(rememberedValue2);
                                        }
                                        composer4.endReplaceableGroup();
                                        i m16 = ViewEventPropUpdaterKt.m(z18, (Function1) rememberedValue2);
                                        final Function2<? super Composer, ? super Integer, Unit> function2192 = function21722;
                                        final String str23 = str2022;
                                        final h hVar11 = hVar1022;
                                        final int i87 = i7622;
                                        final Function2<? super Composer, ? super Integer, Unit> function220 = function21822;
                                        final String str24 = str2122;
                                        final h hVar12 = hVar92;
                                        ColumnKt.a(m16, null, null, null, ComposableLambdaKt.composableLambda(composer4, -1642571259, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(d dVar, Composer composer5, Integer num2) {
                                                Composer composer6;
                                                Composer composer7 = composer5;
                                                int intValue2 = num2.intValue();
                                                if ((intValue2 & 81) == 16 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1642571259, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:105)");
                                                    }
                                                    if (function2192 != null) {
                                                        composer7.startReplaceableGroup(765799035);
                                                        i z19 = ComposeLayoutPropUpdaterKt.z(i.INSTANCE);
                                                        Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                                        final Function2<? super Composer, ? super Integer, Unit> function221 = function2192;
                                                        final int i88 = i87;
                                                        ColumnKt.a(z19, null, horizontal, null, ComposableLambdaKt.composableLambda(composer7, -158325005, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt.QUIListDoubleLineCommonView.1.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(d dVar2, Composer composer8, Integer num3) {
                                                                Composer composer9 = composer8;
                                                                int intValue3 = num3.intValue();
                                                                if ((intValue3 & 81) == 16 && composer9.getSkipping()) {
                                                                    composer9.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-158325005, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:110)");
                                                                    }
                                                                    function221.invoke(composer9, Integer.valueOf((i88 >> 18) & 14));
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer7, 24968, 10);
                                                        composer7.endReplaceableGroup();
                                                        composer6 = composer7;
                                                    } else {
                                                        composer7.startReplaceableGroup(765799315);
                                                        composer6 = composer7;
                                                        TextKt.a(str23, null, null, hVar11, Float.valueOf(17.0f), null, null, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer6, ((i87 >> 9) & 14) | 28672, 100663344, 0, 133953510);
                                                        composer6.endReplaceableGroup();
                                                    }
                                                    i.Companion companion6 = i.INSTANCE;
                                                    Composer composer8 = composer6;
                                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion6, 0.0f, 1, null), 3.0f), composer8, 8, 0);
                                                    if (function220 != null) {
                                                        composer8.startReplaceableGroup(765799686);
                                                        i z26 = ComposeLayoutPropUpdaterKt.z(companion6);
                                                        Alignment.Horizontal horizontal2 = Alignment.Horizontal.CenterHorizontally;
                                                        final Function2<? super Composer, ? super Integer, Unit> function222 = function220;
                                                        final int i89 = i87;
                                                        ColumnKt.a(z26, null, horizontal2, null, ComposableLambdaKt.composableLambda(composer8, 1984435420, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt.QUIListDoubleLineCommonView.1.2.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(d dVar2, Composer composer9, Integer num3) {
                                                                Composer composer10 = composer9;
                                                                int intValue3 = num3.intValue();
                                                                if ((intValue3 & 81) == 16 && composer10.getSkipping()) {
                                                                    composer10.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(1984435420, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:129)");
                                                                    }
                                                                    function222.invoke(composer10, Integer.valueOf((i89 >> 27) & 14));
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer8, 24968, 10);
                                                        composer8.endReplaceableGroup();
                                                    } else {
                                                        composer8.startReplaceableGroup(765799969);
                                                        TextKt.a(str24, null, null, hVar12, Float.valueOf(14.0f), null, null, null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer8, ((i87 >> 21) & 14) | 28672, 100663344, 0, 133953510);
                                                        composer8.endReplaceableGroup();
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer4, 24584, 14);
                                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion5, f382), composer4, i79, i85);
                                        if (function3422 != null) {
                                            composer4.startReplaceableGroup(-1787675785);
                                            function3422.invoke(nVar2.a(companion5, f372), composer4, Integer.valueOf(((i7722 >> 3) & 112) | i79));
                                            composer4.endReplaceableGroup();
                                            z16 = true;
                                            companion2 = companion5;
                                        } else {
                                            String str25 = str1822;
                                            if (str25 != null) {
                                                if ((str25.length() > 0 ? 1 : i85) == 1) {
                                                    i86 = 1;
                                                    if (i86 == 0) {
                                                        composer4.startReplaceableGroup(-1787675659);
                                                        z16 = true;
                                                        companion2 = companion5;
                                                        Composer composer5 = composer4;
                                                        TextKt.a(str1822, ComposeLayoutPropUpdaterKt.s(nVar2.a(companion5, f372), 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, ai.f(ai.INSTANCE.d()), null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, ((i7722 >> 3) & 14) | 28736, 100663296, 0, 133954532);
                                                        composer5.endReplaceableGroup();
                                                        composer4 = composer5;
                                                    } else {
                                                        z16 = true;
                                                        companion2 = companion5;
                                                        composer4.startReplaceableGroup(-1787675364);
                                                        composer4.endReplaceableGroup();
                                                    }
                                                }
                                            }
                                            i86 = i85;
                                            if (i86 == 0) {
                                            }
                                        }
                                        composer4.startReplaceableGroup(-1787675355);
                                        if (function3422 == null) {
                                            if (!(str1922.length() > 0 ? z16 : false)) {
                                                companion3 = companion2;
                                                z17 = false;
                                                composer4.endReplaceableGroup();
                                                if (function21622 == null) {
                                                    composer4.startReplaceableGroup(-1787675187);
                                                    function21622.invoke(composer4, Integer.valueOf((i7722 >> 12) & 14));
                                                    composer4.endReplaceableGroup();
                                                } else {
                                                    if (str1922.length() > 0 ? z16 : z17) {
                                                        composer4.startReplaceableGroup(-1787675099);
                                                        Composer composer6 = composer4;
                                                        ImageKt.a(str1922, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion3, 16.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, ((i7722 >> 9) & 14) | 262144, 0, 0, 2097118);
                                                        composer6.endReplaceableGroup();
                                                    } else {
                                                        Composer composer7 = composer4;
                                                        composer7.startReplaceableGroup(-1787674972);
                                                        composer7.endReplaceableGroup();
                                                    }
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }
                                        companion3 = companion2;
                                        z17 = false;
                                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion3, 2.0f), composer4, 8, 0);
                                        composer4.endReplaceableGroup();
                                        if (function21622 == null) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer2, 197064, 24);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            f28 = f372;
                            iVar4 = iVar3;
                            str12 = str11;
                            str13 = str6;
                            function210 = function25;
                            function211 = function28;
                            str14 = str8;
                            str15 = str7;
                            f29 = f19;
                            hVar7 = hVar3;
                            function33 = function32;
                            hVar8 = hVar92;
                            function212 = function29;
                            f36 = f382;
                            str16 = str9;
                            function213 = function26;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                    }
                    if ((i16 & 7168) == 0) {
                    }
                    i49 = i17 & 16384;
                    if (i49 != 0) {
                    }
                    i56 = i49;
                    i57 = i17 & 32768;
                    if (i57 == 0) {
                    }
                    if ((i17 & FilterEnum.MIC_PTU_ZIRAN) != 289) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) == 0) {
                    }
                    if (i66 == 0) {
                    }
                    if (i68 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i19 == 0) {
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
                    if (i38 == 0) {
                    }
                    if (i46 == 0) {
                    }
                    if (i48 == 0) {
                    }
                    if ((i17 & 8192) == 0) {
                    }
                    if (i56 == 0) {
                    }
                    if (i57 == 0) {
                    }
                    i58 = i67;
                    i59 = i75;
                    str11 = str10;
                    function28 = function214;
                    iVar3 = iVar2;
                    hVar6 = hVar5;
                    startRestartGroup.endDefaults();
                    final h hVar922 = hVar6;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue != Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState<Float> mutableState22 = (MutableState) rememberedValue;
                    i iVar622 = i.INSTANCE;
                    final float f3722 = f27;
                    final float f3822 = f26;
                    i d1622 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.r(iVar622.b(iVar3), 16.0f, 10.0f, 16.0f, 10.0f), Math.max(((Number) mutableState22.getValue()).floatValue() + 20.0f, 72.0f)), 0.0f, 1, null), QUIToken.color$default("fill_light_secondary"));
                    if (function28 == null) {
                    }
                    j3 = h.INSTANCE.j();
                    i w3622 = ModifiersKt.w(d1622, j3);
                    booleanRef = new Ref.BooleanRef();
                    iVar3.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$hasAccessibility$1
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
                    final Function2<? super Composer, ? super Integer, Unit> function215222 = function25;
                    final int i76222 = i58;
                    final String str17222 = str6;
                    final float f39222 = f19;
                    final Function3<? super i, ? super Composer, ? super Integer, Unit> function34222 = function32;
                    final int i77222 = i65;
                    final String str18222 = str9;
                    final String str19222 = str11;
                    final Function2<? super Composer, ? super Integer, Unit> function216222 = function28;
                    final Function2<? super Composer, ? super Integer, Unit> function217222 = function26;
                    final String str20222 = str7;
                    final h hVar10222 = hVar3;
                    final Function2<? super Composer, ? super Integer, Unit> function218222 = function29;
                    final String str21222 = str8;
                    composer2 = startRestartGroup;
                    RowKt.a(w3622.b(iVar622), a.f339245a.g(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(composer2, 758734364, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:37:0x023a  */
                        /* JADX WARN: Removed duplicated region for block: B:40:0x02b7  */
                        /* JADX WARN: Removed duplicated region for block: B:41:0x0253  */
                        /* JADX WARN: Removed duplicated region for block: B:58:0x0181  */
                        /* JADX WARN: Removed duplicated region for block: B:59:0x01f9  */
                        @Override // kotlin.jvm.functions.Function3
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(n nVar, Composer composer3, Integer num) {
                            int i78;
                            int i79;
                            int i85;
                            int i86;
                            boolean z16;
                            i.Companion companion2;
                            i.Companion companion3;
                            boolean z17;
                            n nVar2 = nVar;
                            Composer composer4 = composer3;
                            int intValue = num.intValue();
                            if ((intValue & 14) == 0) {
                                i78 = (composer4.changed(nVar2) ? 4 : 2) | intValue;
                            } else {
                                i78 = intValue;
                            }
                            if ((i78 & 91) == 18 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(758734364, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous> (QUIListDoubleLineCommonView.kt:85)");
                                }
                                if (function215222 != null) {
                                    composer4.startReplaceableGroup(-1787677728);
                                    function215222.invoke(composer4, Integer.valueOf((i76222 >> 6) & 14));
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 12.0f), composer4, 8, 0);
                                    composer4.endReplaceableGroup();
                                    i79 = 8;
                                    i85 = 0;
                                } else if (str17222 != null) {
                                    composer4.startReplaceableGroup(-1787677596);
                                    String str22 = str17222;
                                    i.Companion companion4 = i.INSTANCE;
                                    ImageKt.a(str22, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer4, ((i76222 >> 3) & 14) | 262144, 0, 0, 2097118);
                                    composer4 = composer4;
                                    i85 = 0;
                                    i79 = 8;
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion4, 12.0f), composer4, 8, 0);
                                    composer4.endReplaceableGroup();
                                } else {
                                    i79 = 8;
                                    i85 = 0;
                                    composer4.startReplaceableGroup(-1787677418);
                                    composer4.endReplaceableGroup();
                                }
                                i.Companion companion5 = i.INSTANCE;
                                i z18 = ComposeLayoutPropUpdaterKt.z(nVar2.a(companion5, f39222));
                                final MutableState<Float> mutableState222 = mutableState22;
                                composer4.startReplaceableGroup(1157296644);
                                boolean changed = composer4.changed(mutableState222);
                                Object rememberedValue2 = composer4.rememberedValue();
                                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(w wVar) {
                                            mutableState222.setValue(Float.valueOf(wVar.getHeight()));
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer4.updateRememberedValue(rememberedValue2);
                                }
                                composer4.endReplaceableGroup();
                                i m16 = ViewEventPropUpdaterKt.m(z18, (Function1) rememberedValue2);
                                final Function2<? super Composer, ? super Integer, Unit> function2192 = function217222;
                                final String str23 = str20222;
                                final h hVar11 = hVar10222;
                                final int i87 = i76222;
                                final Function2<? super Composer, ? super Integer, Unit> function220 = function218222;
                                final String str24 = str21222;
                                final h hVar12 = hVar922;
                                ColumnKt.a(m16, null, null, null, ComposableLambdaKt.composableLambda(composer4, -1642571259, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar, Composer composer5, Integer num2) {
                                        Composer composer6;
                                        Composer composer7 = composer5;
                                        int intValue2 = num2.intValue();
                                        if ((intValue2 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1642571259, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:105)");
                                            }
                                            if (function2192 != null) {
                                                composer7.startReplaceableGroup(765799035);
                                                i z19 = ComposeLayoutPropUpdaterKt.z(i.INSTANCE);
                                                Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                                final Function2<? super Composer, ? super Integer, Unit> function221 = function2192;
                                                final int i88 = i87;
                                                ColumnKt.a(z19, null, horizontal, null, ComposableLambdaKt.composableLambda(composer7, -158325005, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt.QUIListDoubleLineCommonView.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(d dVar2, Composer composer8, Integer num3) {
                                                        Composer composer9 = composer8;
                                                        int intValue3 = num3.intValue();
                                                        if ((intValue3 & 81) == 16 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-158325005, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:110)");
                                                            }
                                                            function221.invoke(composer9, Integer.valueOf((i88 >> 18) & 14));
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 24968, 10);
                                                composer7.endReplaceableGroup();
                                                composer6 = composer7;
                                            } else {
                                                composer7.startReplaceableGroup(765799315);
                                                composer6 = composer7;
                                                TextKt.a(str23, null, null, hVar11, Float.valueOf(17.0f), null, null, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer6, ((i87 >> 9) & 14) | 28672, 100663344, 0, 133953510);
                                                composer6.endReplaceableGroup();
                                            }
                                            i.Companion companion6 = i.INSTANCE;
                                            Composer composer8 = composer6;
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion6, 0.0f, 1, null), 3.0f), composer8, 8, 0);
                                            if (function220 != null) {
                                                composer8.startReplaceableGroup(765799686);
                                                i z26 = ComposeLayoutPropUpdaterKt.z(companion6);
                                                Alignment.Horizontal horizontal2 = Alignment.Horizontal.CenterHorizontally;
                                                final Function2<? super Composer, ? super Integer, Unit> function222 = function220;
                                                final int i89 = i87;
                                                ColumnKt.a(z26, null, horizontal2, null, ComposableLambdaKt.composableLambda(composer8, 1984435420, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt.QUIListDoubleLineCommonView.1.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(d dVar2, Composer composer9, Integer num3) {
                                                        Composer composer10 = composer9;
                                                        int intValue3 = num3.intValue();
                                                        if ((intValue3 & 81) == 16 && composer10.getSkipping()) {
                                                            composer10.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1984435420, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:129)");
                                                            }
                                                            function222.invoke(composer10, Integer.valueOf((i89 >> 27) & 14));
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer8, 24968, 10);
                                                composer8.endReplaceableGroup();
                                            } else {
                                                composer8.startReplaceableGroup(765799969);
                                                TextKt.a(str24, null, null, hVar12, Float.valueOf(14.0f), null, null, null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer8, ((i87 >> 21) & 14) | 28672, 100663344, 0, 133953510);
                                                composer8.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer4, 24584, 14);
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion5, f3822), composer4, i79, i85);
                                if (function34222 != null) {
                                    composer4.startReplaceableGroup(-1787675785);
                                    function34222.invoke(nVar2.a(companion5, f3722), composer4, Integer.valueOf(((i77222 >> 3) & 112) | i79));
                                    composer4.endReplaceableGroup();
                                    z16 = true;
                                    companion2 = companion5;
                                } else {
                                    String str25 = str18222;
                                    if (str25 != null) {
                                        if ((str25.length() > 0 ? 1 : i85) == 1) {
                                            i86 = 1;
                                            if (i86 == 0) {
                                                composer4.startReplaceableGroup(-1787675659);
                                                z16 = true;
                                                companion2 = companion5;
                                                Composer composer5 = composer4;
                                                TextKt.a(str18222, ComposeLayoutPropUpdaterKt.s(nVar2.a(companion5, f3722), 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, ai.f(ai.INSTANCE.d()), null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, ((i77222 >> 3) & 14) | 28736, 100663296, 0, 133954532);
                                                composer5.endReplaceableGroup();
                                                composer4 = composer5;
                                            } else {
                                                z16 = true;
                                                companion2 = companion5;
                                                composer4.startReplaceableGroup(-1787675364);
                                                composer4.endReplaceableGroup();
                                            }
                                        }
                                    }
                                    i86 = i85;
                                    if (i86 == 0) {
                                    }
                                }
                                composer4.startReplaceableGroup(-1787675355);
                                if (function34222 == null) {
                                    if (!(str19222.length() > 0 ? z16 : false)) {
                                        companion3 = companion2;
                                        z17 = false;
                                        composer4.endReplaceableGroup();
                                        if (function216222 == null) {
                                            composer4.startReplaceableGroup(-1787675187);
                                            function216222.invoke(composer4, Integer.valueOf((i77222 >> 12) & 14));
                                            composer4.endReplaceableGroup();
                                        } else {
                                            if (str19222.length() > 0 ? z16 : z17) {
                                                composer4.startReplaceableGroup(-1787675099);
                                                Composer composer6 = composer4;
                                                ImageKt.a(str19222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion3, 16.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, ((i77222 >> 9) & 14) | 262144, 0, 0, 2097118);
                                                composer6.endReplaceableGroup();
                                            } else {
                                                Composer composer7 = composer4;
                                                composer7.startReplaceableGroup(-1787674972);
                                                composer7.endReplaceableGroup();
                                            }
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }
                                companion3 = companion2;
                                z17 = false;
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion3, 2.0f), composer4, 8, 0);
                                composer4.endReplaceableGroup();
                                if (function216222 == null) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer2, 197064, 24);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f28 = f3722;
                    iVar4 = iVar3;
                    str12 = str11;
                    str13 = str6;
                    function210 = function25;
                    function211 = function28;
                    str14 = str8;
                    str15 = str7;
                    f29 = f19;
                    hVar7 = hVar3;
                    function33 = function32;
                    hVar8 = hVar922;
                    function212 = function29;
                    f36 = f3822;
                    str16 = str9;
                    function213 = function26;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i26 = i17 & 16;
                if (i26 == 0) {
                }
                i27 = i17 & 32;
                if (i27 != 0) {
                }
                i28 = i17 & 64;
                if (i28 == 0) {
                }
                i29 = i17 & 128;
                if (i29 == 0) {
                }
                i36 = i17 & 256;
                if (i36 != 0) {
                }
                i37 = i17 & 512;
                if (i37 == 0) {
                }
                i38 = i17 & 1024;
                if (i38 == 0) {
                }
                i46 = i17 & 2048;
                if (i46 == 0) {
                }
                int i752 = i39;
                i47 = i17 & 4096;
                if (i47 == 0) {
                }
                if ((i16 & 7168) == 0) {
                }
                i49 = i17 & 16384;
                if (i49 != 0) {
                }
                i56 = i49;
                i57 = i17 & 32768;
                if (i57 == 0) {
                }
                if ((i17 & FilterEnum.MIC_PTU_ZIRAN) != 289) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) == 0) {
                }
                if (i66 == 0) {
                }
                if (i68 == 0) {
                }
                if (i18 == 0) {
                }
                if (i19 == 0) {
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
                if (i38 == 0) {
                }
                if (i46 == 0) {
                }
                if (i48 == 0) {
                }
                if ((i17 & 8192) == 0) {
                }
                if (i56 == 0) {
                }
                if (i57 == 0) {
                }
                i58 = i67;
                i59 = i752;
                str11 = str10;
                function28 = function214;
                iVar3 = iVar2;
                hVar6 = hVar5;
                startRestartGroup.endDefaults();
                final h hVar9222 = hVar6;
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue != Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState<Float> mutableState222 = (MutableState) rememberedValue;
                i iVar6222 = i.INSTANCE;
                final float f37222 = f27;
                final float f38222 = f26;
                i d16222 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.r(iVar6222.b(iVar3), 16.0f, 10.0f, 16.0f, 10.0f), Math.max(((Number) mutableState222.getValue()).floatValue() + 20.0f, 72.0f)), 0.0f, 1, null), QUIToken.color$default("fill_light_secondary"));
                if (function28 == null) {
                }
                j3 = h.INSTANCE.j();
                i w36222 = ModifiersKt.w(d16222, j3);
                booleanRef = new Ref.BooleanRef();
                iVar3.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$hasAccessibility$1
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
                final Function2<? super Composer, ? super Integer, Unit> function2152222 = function25;
                final int i762222 = i58;
                final String str172222 = str6;
                final float f392222 = f19;
                final Function3<? super i, ? super Composer, ? super Integer, Unit> function342222 = function32;
                final int i772222 = i65;
                final String str182222 = str9;
                final String str192222 = str11;
                final Function2<? super Composer, ? super Integer, Unit> function2162222 = function28;
                final Function2<? super Composer, ? super Integer, Unit> function2172222 = function26;
                final String str202222 = str7;
                final h hVar102222 = hVar3;
                final Function2<? super Composer, ? super Integer, Unit> function2182222 = function29;
                final String str212222 = str8;
                composer2 = startRestartGroup;
                RowKt.a(w36222.b(iVar6222), a.f339245a.g(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(composer2, 758734364, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:37:0x023a  */
                    /* JADX WARN: Removed duplicated region for block: B:40:0x02b7  */
                    /* JADX WARN: Removed duplicated region for block: B:41:0x0253  */
                    /* JADX WARN: Removed duplicated region for block: B:58:0x0181  */
                    /* JADX WARN: Removed duplicated region for block: B:59:0x01f9  */
                    @Override // kotlin.jvm.functions.Function3
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Unit invoke(n nVar, Composer composer3, Integer num) {
                        int i78;
                        int i79;
                        int i85;
                        int i86;
                        boolean z16;
                        i.Companion companion2;
                        i.Companion companion3;
                        boolean z17;
                        n nVar2 = nVar;
                        Composer composer4 = composer3;
                        int intValue = num.intValue();
                        if ((intValue & 14) == 0) {
                            i78 = (composer4.changed(nVar2) ? 4 : 2) | intValue;
                        } else {
                            i78 = intValue;
                        }
                        if ((i78 & 91) == 18 && composer4.getSkipping()) {
                            composer4.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(758734364, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous> (QUIListDoubleLineCommonView.kt:85)");
                            }
                            if (function2152222 != null) {
                                composer4.startReplaceableGroup(-1787677728);
                                function2152222.invoke(composer4, Integer.valueOf((i762222 >> 6) & 14));
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 12.0f), composer4, 8, 0);
                                composer4.endReplaceableGroup();
                                i79 = 8;
                                i85 = 0;
                            } else if (str172222 != null) {
                                composer4.startReplaceableGroup(-1787677596);
                                String str22 = str172222;
                                i.Companion companion4 = i.INSTANCE;
                                ImageKt.a(str22, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer4, ((i762222 >> 3) & 14) | 262144, 0, 0, 2097118);
                                composer4 = composer4;
                                i85 = 0;
                                i79 = 8;
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion4, 12.0f), composer4, 8, 0);
                                composer4.endReplaceableGroup();
                            } else {
                                i79 = 8;
                                i85 = 0;
                                composer4.startReplaceableGroup(-1787677418);
                                composer4.endReplaceableGroup();
                            }
                            i.Companion companion5 = i.INSTANCE;
                            i z18 = ComposeLayoutPropUpdaterKt.z(nVar2.a(companion5, f392222));
                            final MutableState<Float> mutableState2222 = mutableState222;
                            composer4.startReplaceableGroup(1157296644);
                            boolean changed = composer4.changed(mutableState2222);
                            Object rememberedValue2 = composer4.rememberedValue();
                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(w wVar) {
                                        mutableState2222.setValue(Float.valueOf(wVar.getHeight()));
                                        return Unit.INSTANCE;
                                    }
                                };
                                composer4.updateRememberedValue(rememberedValue2);
                            }
                            composer4.endReplaceableGroup();
                            i m16 = ViewEventPropUpdaterKt.m(z18, (Function1) rememberedValue2);
                            final Function2<? super Composer, ? super Integer, Unit> function2192 = function2172222;
                            final String str23 = str202222;
                            final h hVar11 = hVar102222;
                            final int i87 = i762222;
                            final Function2<? super Composer, ? super Integer, Unit> function220 = function2182222;
                            final String str24 = str212222;
                            final h hVar12 = hVar9222;
                            ColumnKt.a(m16, null, null, null, ComposableLambdaKt.composableLambda(composer4, -1642571259, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(d dVar, Composer composer5, Integer num2) {
                                    Composer composer6;
                                    Composer composer7 = composer5;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 81) == 16 && composer7.getSkipping()) {
                                        composer7.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1642571259, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:105)");
                                        }
                                        if (function2192 != null) {
                                            composer7.startReplaceableGroup(765799035);
                                            i z19 = ComposeLayoutPropUpdaterKt.z(i.INSTANCE);
                                            Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                            final Function2<? super Composer, ? super Integer, Unit> function221 = function2192;
                                            final int i88 = i87;
                                            ColumnKt.a(z19, null, horizontal, null, ComposableLambdaKt.composableLambda(composer7, -158325005, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt.QUIListDoubleLineCommonView.1.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar2, Composer composer8, Integer num3) {
                                                    Composer composer9 = composer8;
                                                    int intValue3 = num3.intValue();
                                                    if ((intValue3 & 81) == 16 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-158325005, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:110)");
                                                        }
                                                        function221.invoke(composer9, Integer.valueOf((i88 >> 18) & 14));
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 24968, 10);
                                            composer7.endReplaceableGroup();
                                            composer6 = composer7;
                                        } else {
                                            composer7.startReplaceableGroup(765799315);
                                            composer6 = composer7;
                                            TextKt.a(str23, null, null, hVar11, Float.valueOf(17.0f), null, null, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer6, ((i87 >> 9) & 14) | 28672, 100663344, 0, 133953510);
                                            composer6.endReplaceableGroup();
                                        }
                                        i.Companion companion6 = i.INSTANCE;
                                        Composer composer8 = composer6;
                                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion6, 0.0f, 1, null), 3.0f), composer8, 8, 0);
                                        if (function220 != null) {
                                            composer8.startReplaceableGroup(765799686);
                                            i z26 = ComposeLayoutPropUpdaterKt.z(companion6);
                                            Alignment.Horizontal horizontal2 = Alignment.Horizontal.CenterHorizontally;
                                            final Function2<? super Composer, ? super Integer, Unit> function222 = function220;
                                            final int i89 = i87;
                                            ColumnKt.a(z26, null, horizontal2, null, ComposableLambdaKt.composableLambda(composer8, 1984435420, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt.QUIListDoubleLineCommonView.1.2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar2, Composer composer9, Integer num3) {
                                                    Composer composer10 = composer9;
                                                    int intValue3 = num3.intValue();
                                                    if ((intValue3 & 81) == 16 && composer10.getSkipping()) {
                                                        composer10.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1984435420, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:129)");
                                                        }
                                                        function222.invoke(composer10, Integer.valueOf((i89 >> 27) & 14));
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer8, 24968, 10);
                                            composer8.endReplaceableGroup();
                                        } else {
                                            composer8.startReplaceableGroup(765799969);
                                            TextKt.a(str24, null, null, hVar12, Float.valueOf(14.0f), null, null, null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer8, ((i87 >> 21) & 14) | 28672, 100663344, 0, 133953510);
                                            composer8.endReplaceableGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer4, 24584, 14);
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion5, f38222), composer4, i79, i85);
                            if (function342222 != null) {
                                composer4.startReplaceableGroup(-1787675785);
                                function342222.invoke(nVar2.a(companion5, f37222), composer4, Integer.valueOf(((i772222 >> 3) & 112) | i79));
                                composer4.endReplaceableGroup();
                                z16 = true;
                                companion2 = companion5;
                            } else {
                                String str25 = str182222;
                                if (str25 != null) {
                                    if ((str25.length() > 0 ? 1 : i85) == 1) {
                                        i86 = 1;
                                        if (i86 == 0) {
                                            composer4.startReplaceableGroup(-1787675659);
                                            z16 = true;
                                            companion2 = companion5;
                                            Composer composer5 = composer4;
                                            TextKt.a(str182222, ComposeLayoutPropUpdaterKt.s(nVar2.a(companion5, f37222), 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, ai.f(ai.INSTANCE.d()), null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, ((i772222 >> 3) & 14) | 28736, 100663296, 0, 133954532);
                                            composer5.endReplaceableGroup();
                                            composer4 = composer5;
                                        } else {
                                            z16 = true;
                                            companion2 = companion5;
                                            composer4.startReplaceableGroup(-1787675364);
                                            composer4.endReplaceableGroup();
                                        }
                                    }
                                }
                                i86 = i85;
                                if (i86 == 0) {
                                }
                            }
                            composer4.startReplaceableGroup(-1787675355);
                            if (function342222 == null) {
                                if (!(str192222.length() > 0 ? z16 : false)) {
                                    companion3 = companion2;
                                    z17 = false;
                                    composer4.endReplaceableGroup();
                                    if (function2162222 == null) {
                                        composer4.startReplaceableGroup(-1787675187);
                                        function2162222.invoke(composer4, Integer.valueOf((i772222 >> 12) & 14));
                                        composer4.endReplaceableGroup();
                                    } else {
                                        if (str192222.length() > 0 ? z16 : z17) {
                                            composer4.startReplaceableGroup(-1787675099);
                                            Composer composer6 = composer4;
                                            ImageKt.a(str192222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion3, 16.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, ((i772222 >> 9) & 14) | 262144, 0, 0, 2097118);
                                            composer6.endReplaceableGroup();
                                        } else {
                                            Composer composer7 = composer4;
                                            composer7.startReplaceableGroup(-1787674972);
                                            composer7.endReplaceableGroup();
                                        }
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }
                            companion3 = companion2;
                            z17 = false;
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion3, 2.0f), composer4, 8, 0);
                            composer4.endReplaceableGroup();
                            if (function2162222 == null) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer2, 197064, 24);
                if (ComposerKt.isTraceInProgress()) {
                }
                f28 = f37222;
                iVar4 = iVar3;
                str12 = str11;
                str13 = str6;
                function210 = function25;
                function211 = function28;
                str14 = str8;
                str15 = str7;
                f29 = f19;
                hVar7 = hVar3;
                function33 = function32;
                hVar8 = hVar9222;
                function212 = function29;
                f36 = f38222;
                str16 = str9;
                function213 = function26;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i19 = i17 & 8;
            int i692 = 2048;
            if (i19 != 0) {
            }
            i26 = i17 & 16;
            if (i26 == 0) {
            }
            i27 = i17 & 32;
            if (i27 != 0) {
            }
            i28 = i17 & 64;
            if (i28 == 0) {
            }
            i29 = i17 & 128;
            if (i29 == 0) {
            }
            i36 = i17 & 256;
            if (i36 != 0) {
            }
            i37 = i17 & 512;
            if (i37 == 0) {
            }
            i38 = i17 & 1024;
            if (i38 == 0) {
            }
            i46 = i17 & 2048;
            if (i46 == 0) {
            }
            int i7522 = i39;
            i47 = i17 & 4096;
            if (i47 == 0) {
            }
            if ((i16 & 7168) == 0) {
            }
            i49 = i17 & 16384;
            if (i49 != 0) {
            }
            i56 = i49;
            i57 = i17 & 32768;
            if (i57 == 0) {
            }
            if ((i17 & FilterEnum.MIC_PTU_ZIRAN) != 289) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) == 0) {
            }
            if (i66 == 0) {
            }
            if (i68 == 0) {
            }
            if (i18 == 0) {
            }
            if (i19 == 0) {
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
            if (i38 == 0) {
            }
            if (i46 == 0) {
            }
            if (i48 == 0) {
            }
            if ((i17 & 8192) == 0) {
            }
            if (i56 == 0) {
            }
            if (i57 == 0) {
            }
            i58 = i67;
            i59 = i7522;
            str11 = str10;
            function28 = function214;
            iVar3 = iVar2;
            hVar6 = hVar5;
            startRestartGroup.endDefaults();
            final h hVar92222 = hVar6;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue != Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<Float> mutableState2222 = (MutableState) rememberedValue;
            i iVar62222 = i.INSTANCE;
            final float f372222 = f27;
            final float f382222 = f26;
            i d162222 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.r(iVar62222.b(iVar3), 16.0f, 10.0f, 16.0f, 10.0f), Math.max(((Number) mutableState2222.getValue()).floatValue() + 20.0f, 72.0f)), 0.0f, 1, null), QUIToken.color$default("fill_light_secondary"));
            if (function28 == null) {
            }
            j3 = h.INSTANCE.j();
            i w362222 = ModifiersKt.w(d162222, j3);
            booleanRef = new Ref.BooleanRef();
            iVar3.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$hasAccessibility$1
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
            final Function2<? super Composer, ? super Integer, Unit> function21522222 = function25;
            final int i7622222 = i58;
            final String str1722222 = str6;
            final float f3922222 = f19;
            final Function3<? super i, ? super Composer, ? super Integer, Unit> function3422222 = function32;
            final int i7722222 = i65;
            final String str1822222 = str9;
            final String str1922222 = str11;
            final Function2<? super Composer, ? super Integer, Unit> function21622222 = function28;
            final Function2<? super Composer, ? super Integer, Unit> function21722222 = function26;
            final String str2022222 = str7;
            final h hVar1022222 = hVar3;
            final Function2<? super Composer, ? super Integer, Unit> function21822222 = function29;
            final String str2122222 = str8;
            composer2 = startRestartGroup;
            RowKt.a(w362222.b(iVar62222), a.f339245a.g(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(composer2, 758734364, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                /* JADX WARN: Removed duplicated region for block: B:37:0x023a  */
                /* JADX WARN: Removed duplicated region for block: B:40:0x02b7  */
                /* JADX WARN: Removed duplicated region for block: B:41:0x0253  */
                /* JADX WARN: Removed duplicated region for block: B:58:0x0181  */
                /* JADX WARN: Removed duplicated region for block: B:59:0x01f9  */
                @Override // kotlin.jvm.functions.Function3
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Unit invoke(n nVar, Composer composer3, Integer num) {
                    int i78;
                    int i79;
                    int i85;
                    int i86;
                    boolean z16;
                    i.Companion companion2;
                    i.Companion companion3;
                    boolean z17;
                    n nVar2 = nVar;
                    Composer composer4 = composer3;
                    int intValue = num.intValue();
                    if ((intValue & 14) == 0) {
                        i78 = (composer4.changed(nVar2) ? 4 : 2) | intValue;
                    } else {
                        i78 = intValue;
                    }
                    if ((i78 & 91) == 18 && composer4.getSkipping()) {
                        composer4.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(758734364, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous> (QUIListDoubleLineCommonView.kt:85)");
                        }
                        if (function21522222 != null) {
                            composer4.startReplaceableGroup(-1787677728);
                            function21522222.invoke(composer4, Integer.valueOf((i7622222 >> 6) & 14));
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 12.0f), composer4, 8, 0);
                            composer4.endReplaceableGroup();
                            i79 = 8;
                            i85 = 0;
                        } else if (str1722222 != null) {
                            composer4.startReplaceableGroup(-1787677596);
                            String str22 = str1722222;
                            i.Companion companion4 = i.INSTANCE;
                            ImageKt.a(str22, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer4, ((i7622222 >> 3) & 14) | 262144, 0, 0, 2097118);
                            composer4 = composer4;
                            i85 = 0;
                            i79 = 8;
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion4, 12.0f), composer4, 8, 0);
                            composer4.endReplaceableGroup();
                        } else {
                            i79 = 8;
                            i85 = 0;
                            composer4.startReplaceableGroup(-1787677418);
                            composer4.endReplaceableGroup();
                        }
                        i.Companion companion5 = i.INSTANCE;
                        i z18 = ComposeLayoutPropUpdaterKt.z(nVar2.a(companion5, f3922222));
                        final MutableState<Float> mutableState22222 = mutableState2222;
                        composer4.startReplaceableGroup(1157296644);
                        boolean changed = composer4.changed(mutableState22222);
                        Object rememberedValue2 = composer4.rememberedValue();
                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(w wVar) {
                                    mutableState22222.setValue(Float.valueOf(wVar.getHeight()));
                                    return Unit.INSTANCE;
                                }
                            };
                            composer4.updateRememberedValue(rememberedValue2);
                        }
                        composer4.endReplaceableGroup();
                        i m16 = ViewEventPropUpdaterKt.m(z18, (Function1) rememberedValue2);
                        final Function2<? super Composer, ? super Integer, Unit> function2192 = function21722222;
                        final String str23 = str2022222;
                        final h hVar11 = hVar1022222;
                        final int i87 = i7622222;
                        final Function2<? super Composer, ? super Integer, Unit> function220 = function21822222;
                        final String str24 = str2122222;
                        final h hVar12 = hVar92222;
                        ColumnKt.a(m16, null, null, null, ComposableLambdaKt.composableLambda(composer4, -1642571259, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(d dVar, Composer composer5, Integer num2) {
                                Composer composer6;
                                Composer composer7 = composer5;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer7.getSkipping()) {
                                    composer7.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1642571259, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:105)");
                                    }
                                    if (function2192 != null) {
                                        composer7.startReplaceableGroup(765799035);
                                        i z19 = ComposeLayoutPropUpdaterKt.z(i.INSTANCE);
                                        Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                        final Function2<? super Composer, ? super Integer, Unit> function221 = function2192;
                                        final int i88 = i87;
                                        ColumnKt.a(z19, null, horizontal, null, ComposableLambdaKt.composableLambda(composer7, -158325005, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt.QUIListDoubleLineCommonView.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(d dVar2, Composer composer8, Integer num3) {
                                                Composer composer9 = composer8;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer9.getSkipping()) {
                                                    composer9.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-158325005, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:110)");
                                                    }
                                                    function221.invoke(composer9, Integer.valueOf((i88 >> 18) & 14));
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer7, 24968, 10);
                                        composer7.endReplaceableGroup();
                                        composer6 = composer7;
                                    } else {
                                        composer7.startReplaceableGroup(765799315);
                                        composer6 = composer7;
                                        TextKt.a(str23, null, null, hVar11, Float.valueOf(17.0f), null, null, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer6, ((i87 >> 9) & 14) | 28672, 100663344, 0, 133953510);
                                        composer6.endReplaceableGroup();
                                    }
                                    i.Companion companion6 = i.INSTANCE;
                                    Composer composer8 = composer6;
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion6, 0.0f, 1, null), 3.0f), composer8, 8, 0);
                                    if (function220 != null) {
                                        composer8.startReplaceableGroup(765799686);
                                        i z26 = ComposeLayoutPropUpdaterKt.z(companion6);
                                        Alignment.Horizontal horizontal2 = Alignment.Horizontal.CenterHorizontally;
                                        final Function2<? super Composer, ? super Integer, Unit> function222 = function220;
                                        final int i89 = i87;
                                        ColumnKt.a(z26, null, horizontal2, null, ComposableLambdaKt.composableLambda(composer8, 1984435420, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt.QUIListDoubleLineCommonView.1.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(d dVar2, Composer composer9, Integer num3) {
                                                Composer composer10 = composer9;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer10.getSkipping()) {
                                                    composer10.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1984435420, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:129)");
                                                    }
                                                    function222.invoke(composer10, Integer.valueOf((i89 >> 27) & 14));
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer8, 24968, 10);
                                        composer8.endReplaceableGroup();
                                    } else {
                                        composer8.startReplaceableGroup(765799969);
                                        TextKt.a(str24, null, null, hVar12, Float.valueOf(14.0f), null, null, null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer8, ((i87 >> 21) & 14) | 28672, 100663344, 0, 133953510);
                                        composer8.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer4, 24584, 14);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion5, f382222), composer4, i79, i85);
                        if (function3422222 != null) {
                            composer4.startReplaceableGroup(-1787675785);
                            function3422222.invoke(nVar2.a(companion5, f372222), composer4, Integer.valueOf(((i7722222 >> 3) & 112) | i79));
                            composer4.endReplaceableGroup();
                            z16 = true;
                            companion2 = companion5;
                        } else {
                            String str25 = str1822222;
                            if (str25 != null) {
                                if ((str25.length() > 0 ? 1 : i85) == 1) {
                                    i86 = 1;
                                    if (i86 == 0) {
                                        composer4.startReplaceableGroup(-1787675659);
                                        z16 = true;
                                        companion2 = companion5;
                                        Composer composer5 = composer4;
                                        TextKt.a(str1822222, ComposeLayoutPropUpdaterKt.s(nVar2.a(companion5, f372222), 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, ai.f(ai.INSTANCE.d()), null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, ((i7722222 >> 3) & 14) | 28736, 100663296, 0, 133954532);
                                        composer5.endReplaceableGroup();
                                        composer4 = composer5;
                                    } else {
                                        z16 = true;
                                        companion2 = companion5;
                                        composer4.startReplaceableGroup(-1787675364);
                                        composer4.endReplaceableGroup();
                                    }
                                }
                            }
                            i86 = i85;
                            if (i86 == 0) {
                            }
                        }
                        composer4.startReplaceableGroup(-1787675355);
                        if (function3422222 == null) {
                            if (!(str1922222.length() > 0 ? z16 : false)) {
                                companion3 = companion2;
                                z17 = false;
                                composer4.endReplaceableGroup();
                                if (function21622222 == null) {
                                    composer4.startReplaceableGroup(-1787675187);
                                    function21622222.invoke(composer4, Integer.valueOf((i7722222 >> 12) & 14));
                                    composer4.endReplaceableGroup();
                                } else {
                                    if (str1922222.length() > 0 ? z16 : z17) {
                                        composer4.startReplaceableGroup(-1787675099);
                                        Composer composer6 = composer4;
                                        ImageKt.a(str1922222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion3, 16.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, ((i7722222 >> 9) & 14) | 262144, 0, 0, 2097118);
                                        composer6.endReplaceableGroup();
                                    } else {
                                        Composer composer7 = composer4;
                                        composer7.startReplaceableGroup(-1787674972);
                                        composer7.endReplaceableGroup();
                                    }
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }
                        companion3 = companion2;
                        z17 = false;
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion3, 2.0f), composer4, 8, 0);
                        composer4.endReplaceableGroup();
                        if (function21622222 == null) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), composer2, 197064, 24);
            if (ComposerKt.isTraceInProgress()) {
            }
            f28 = f372222;
            iVar4 = iVar3;
            str12 = str11;
            str13 = str6;
            function210 = function25;
            function211 = function28;
            str14 = str8;
            str15 = str7;
            f29 = f19;
            hVar7 = hVar3;
            function33 = function32;
            hVar8 = hVar92222;
            function212 = function29;
            f36 = f382222;
            str16 = str9;
            function213 = function26;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i18 = i17 & 4;
        if (i18 == 0) {
        }
        i19 = i17 & 8;
        int i6922 = 2048;
        if (i19 != 0) {
        }
        i26 = i17 & 16;
        if (i26 == 0) {
        }
        i27 = i17 & 32;
        if (i27 != 0) {
        }
        i28 = i17 & 64;
        if (i28 == 0) {
        }
        i29 = i17 & 128;
        if (i29 == 0) {
        }
        i36 = i17 & 256;
        if (i36 != 0) {
        }
        i37 = i17 & 512;
        if (i37 == 0) {
        }
        i38 = i17 & 1024;
        if (i38 == 0) {
        }
        i46 = i17 & 2048;
        if (i46 == 0) {
        }
        int i75222 = i39;
        i47 = i17 & 4096;
        if (i47 == 0) {
        }
        if ((i16 & 7168) == 0) {
        }
        i49 = i17 & 16384;
        if (i49 != 0) {
        }
        i56 = i49;
        i57 = i17 & 32768;
        if (i57 == 0) {
        }
        if ((i17 & FilterEnum.MIC_PTU_ZIRAN) != 289) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) == 0) {
        }
        if (i66 == 0) {
        }
        if (i68 == 0) {
        }
        if (i18 == 0) {
        }
        if (i19 == 0) {
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
        if (i38 == 0) {
        }
        if (i46 == 0) {
        }
        if (i48 == 0) {
        }
        if ((i17 & 8192) == 0) {
        }
        if (i56 == 0) {
        }
        if (i57 == 0) {
        }
        i58 = i67;
        i59 = i75222;
        str11 = str10;
        function28 = function214;
        iVar3 = iVar2;
        hVar6 = hVar5;
        startRestartGroup.endDefaults();
        final h hVar922222 = hVar6;
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue != Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<Float> mutableState22222 = (MutableState) rememberedValue;
        i iVar622222 = i.INSTANCE;
        final float f3722222 = f27;
        final float f3822222 = f26;
        i d1622222 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.r(iVar622222.b(iVar3), 16.0f, 10.0f, 16.0f, 10.0f), Math.max(((Number) mutableState22222.getValue()).floatValue() + 20.0f, 72.0f)), 0.0f, 1, null), QUIToken.color$default("fill_light_secondary"));
        if (function28 == null) {
        }
        j3 = h.INSTANCE.j();
        i w3622222 = ModifiersKt.w(d1622222, j3);
        booleanRef = new Ref.BooleanRef();
        iVar3.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$hasAccessibility$1
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
        final Function2<? super Composer, ? super Integer, Unit> function215222222 = function25;
        final int i76222222 = i58;
        final String str17222222 = str6;
        final float f39222222 = f19;
        final Function3<? super i, ? super Composer, ? super Integer, Unit> function34222222 = function32;
        final int i77222222 = i65;
        final String str18222222 = str9;
        final String str19222222 = str11;
        final Function2<? super Composer, ? super Integer, Unit> function216222222 = function28;
        final Function2<? super Composer, ? super Integer, Unit> function217222222 = function26;
        final String str20222222 = str7;
        final h hVar10222222 = hVar3;
        final Function2<? super Composer, ? super Integer, Unit> function218222222 = function29;
        final String str21222222 = str8;
        composer2 = startRestartGroup;
        RowKt.a(w3622222.b(iVar622222), a.f339245a.g(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(composer2, 758734364, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            /* JADX WARN: Removed duplicated region for block: B:37:0x023a  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x02b7  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x0253  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x0181  */
            /* JADX WARN: Removed duplicated region for block: B:59:0x01f9  */
            @Override // kotlin.jvm.functions.Function3
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(n nVar, Composer composer3, Integer num) {
                int i78;
                int i79;
                int i85;
                int i86;
                boolean z16;
                i.Companion companion2;
                i.Companion companion3;
                boolean z17;
                n nVar2 = nVar;
                Composer composer4 = composer3;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i78 = (composer4.changed(nVar2) ? 4 : 2) | intValue;
                } else {
                    i78 = intValue;
                }
                if ((i78 & 91) == 18 && composer4.getSkipping()) {
                    composer4.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(758734364, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous> (QUIListDoubleLineCommonView.kt:85)");
                    }
                    if (function215222222 != null) {
                        composer4.startReplaceableGroup(-1787677728);
                        function215222222.invoke(composer4, Integer.valueOf((i76222222 >> 6) & 14));
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 12.0f), composer4, 8, 0);
                        composer4.endReplaceableGroup();
                        i79 = 8;
                        i85 = 0;
                    } else if (str17222222 != null) {
                        composer4.startReplaceableGroup(-1787677596);
                        String str22 = str17222222;
                        i.Companion companion4 = i.INSTANCE;
                        ImageKt.a(str22, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion4, 20.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer4, ((i76222222 >> 3) & 14) | 262144, 0, 0, 2097118);
                        composer4 = composer4;
                        i85 = 0;
                        i79 = 8;
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion4, 12.0f), composer4, 8, 0);
                        composer4.endReplaceableGroup();
                    } else {
                        i79 = 8;
                        i85 = 0;
                        composer4.startReplaceableGroup(-1787677418);
                        composer4.endReplaceableGroup();
                    }
                    i.Companion companion5 = i.INSTANCE;
                    i z18 = ComposeLayoutPropUpdaterKt.z(nVar2.a(companion5, f39222222));
                    final MutableState<Float> mutableState222222 = mutableState22222;
                    composer4.startReplaceableGroup(1157296644);
                    boolean changed = composer4.changed(mutableState222222);
                    Object rememberedValue2 = composer4.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(w wVar) {
                                mutableState222222.setValue(Float.valueOf(wVar.getHeight()));
                                return Unit.INSTANCE;
                            }
                        };
                        composer4.updateRememberedValue(rememberedValue2);
                    }
                    composer4.endReplaceableGroup();
                    i m16 = ViewEventPropUpdaterKt.m(z18, (Function1) rememberedValue2);
                    final Function2<? super Composer, ? super Integer, Unit> function2192 = function217222222;
                    final String str23 = str20222222;
                    final h hVar11 = hVar10222222;
                    final int i87 = i76222222;
                    final Function2<? super Composer, ? super Integer, Unit> function220 = function218222222;
                    final String str24 = str21222222;
                    final h hVar12 = hVar922222;
                    ColumnKt.a(m16, null, null, null, ComposableLambdaKt.composableLambda(composer4, -1642571259, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt$QUIListDoubleLineCommonView$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer5, Integer num2) {
                            Composer composer6;
                            Composer composer7 = composer5;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer7.getSkipping()) {
                                composer7.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1642571259, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:105)");
                                }
                                if (function2192 != null) {
                                    composer7.startReplaceableGroup(765799035);
                                    i z19 = ComposeLayoutPropUpdaterKt.z(i.INSTANCE);
                                    Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                    final Function2<? super Composer, ? super Integer, Unit> function221 = function2192;
                                    final int i88 = i87;
                                    ColumnKt.a(z19, null, horizontal, null, ComposableLambdaKt.composableLambda(composer7, -158325005, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt.QUIListDoubleLineCommonView.1.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(d dVar2, Composer composer8, Integer num3) {
                                            Composer composer9 = composer8;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer9.getSkipping()) {
                                                composer9.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-158325005, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:110)");
                                                }
                                                function221.invoke(composer9, Integer.valueOf((i88 >> 18) & 14));
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer7, 24968, 10);
                                    composer7.endReplaceableGroup();
                                    composer6 = composer7;
                                } else {
                                    composer7.startReplaceableGroup(765799315);
                                    composer6 = composer7;
                                    TextKt.a(str23, null, null, hVar11, Float.valueOf(17.0f), null, null, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer6, ((i87 >> 9) & 14) | 28672, 100663344, 0, 133953510);
                                    composer6.endReplaceableGroup();
                                }
                                i.Companion companion6 = i.INSTANCE;
                                Composer composer8 = composer6;
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion6, 0.0f, 1, null), 3.0f), composer8, 8, 0);
                                if (function220 != null) {
                                    composer8.startReplaceableGroup(765799686);
                                    i z26 = ComposeLayoutPropUpdaterKt.z(companion6);
                                    Alignment.Horizontal horizontal2 = Alignment.Horizontal.CenterHorizontally;
                                    final Function2<? super Composer, ? super Integer, Unit> function222 = function220;
                                    final int i89 = i87;
                                    ColumnKt.a(z26, null, horizontal2, null, ComposableLambdaKt.composableLambda(composer8, 1984435420, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonViewKt.QUIListDoubleLineCommonView.1.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(d dVar2, Composer composer9, Integer num3) {
                                            Composer composer10 = composer9;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer10.getSkipping()) {
                                                composer10.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1984435420, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListDoubleLineCommonView.<anonymous>.<anonymous>.<anonymous> (QUIListDoubleLineCommonView.kt:129)");
                                                }
                                                function222.invoke(composer10, Integer.valueOf((i89 >> 27) & 14));
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer8, 24968, 10);
                                    composer8.endReplaceableGroup();
                                } else {
                                    composer8.startReplaceableGroup(765799969);
                                    TextKt.a(str24, null, null, hVar12, Float.valueOf(14.0f), null, null, null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer8, ((i87 >> 21) & 14) | 28672, 100663344, 0, 133953510);
                                    composer8.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer4, 24584, 14);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion5, f3822222), composer4, i79, i85);
                    if (function34222222 != null) {
                        composer4.startReplaceableGroup(-1787675785);
                        function34222222.invoke(nVar2.a(companion5, f3722222), composer4, Integer.valueOf(((i77222222 >> 3) & 112) | i79));
                        composer4.endReplaceableGroup();
                        z16 = true;
                        companion2 = companion5;
                    } else {
                        String str25 = str18222222;
                        if (str25 != null) {
                            if ((str25.length() > 0 ? 1 : i85) == 1) {
                                i86 = 1;
                                if (i86 == 0) {
                                    composer4.startReplaceableGroup(-1787675659);
                                    z16 = true;
                                    companion2 = companion5;
                                    Composer composer5 = composer4;
                                    TextKt.a(str18222222, ComposeLayoutPropUpdaterKt.s(nVar2.a(companion5, f3722222), 4.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, ai.f(ai.INSTANCE.d()), null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, false, composer5, ((i77222222 >> 3) & 14) | 28736, 100663296, 0, 133954532);
                                    composer5.endReplaceableGroup();
                                    composer4 = composer5;
                                } else {
                                    z16 = true;
                                    companion2 = companion5;
                                    composer4.startReplaceableGroup(-1787675364);
                                    composer4.endReplaceableGroup();
                                }
                            }
                        }
                        i86 = i85;
                        if (i86 == 0) {
                        }
                    }
                    composer4.startReplaceableGroup(-1787675355);
                    if (function34222222 == null) {
                        if (!(str19222222.length() > 0 ? z16 : false)) {
                            companion3 = companion2;
                            z17 = false;
                            composer4.endReplaceableGroup();
                            if (function216222222 == null) {
                                composer4.startReplaceableGroup(-1787675187);
                                function216222222.invoke(composer4, Integer.valueOf((i77222222 >> 12) & 14));
                                composer4.endReplaceableGroup();
                            } else {
                                if (str19222222.length() > 0 ? z16 : z17) {
                                    composer4.startReplaceableGroup(-1787675099);
                                    Composer composer6 = composer4;
                                    ImageKt.a(str19222222, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion3, 16.0f), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer6, ((i77222222 >> 9) & 14) | 262144, 0, 0, 2097118);
                                    composer6.endReplaceableGroup();
                                } else {
                                    Composer composer7 = composer4;
                                    composer7.startReplaceableGroup(-1787674972);
                                    composer7.endReplaceableGroup();
                                }
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }
                    companion3 = companion2;
                    z17 = false;
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion3, 2.0f), composer4, 8, 0);
                    composer4.endReplaceableGroup();
                    if (function216222222 == null) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
                return Unit.INSTANCE;
            }
        }), composer2, 197064, 24);
        if (ComposerKt.isTraceInProgress()) {
        }
        f28 = f3722222;
        iVar4 = iVar3;
        str12 = str11;
        str13 = str6;
        function210 = function25;
        function211 = function28;
        str14 = str8;
        str15 = str7;
        f29 = f19;
        hVar7 = hVar3;
        function33 = function32;
        hVar8 = hVar922222;
        function212 = function29;
        f36 = f3822222;
        str16 = str9;
        function213 = function26;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
