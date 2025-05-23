package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingIconType;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
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
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUILoadingViewKt {
    public static final void finalLoadingView(final i iVar, final QUILoadingType qUILoadingType, final LoadingIconType loadingIconType, final h hVar, final String str, final i iVar2, final h hVar2, Composer composer, final int i3) {
        i u16;
        Composer startRestartGroup = composer.startRestartGroup(-729870617);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-729870617, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.finalLoadingView (QUILoadingView.kt:119)");
        }
        if (qUILoadingType == QUILoadingType.LeftTextRightImage) {
            u16 = i.INSTANCE;
        } else {
            u16 = ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 128.0f);
        }
        BoxKt.a(iVar.b(u16), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1593281953, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUILoadingViewKt$finalLoadingView$1
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
                        ComposerKt.traceEventStart(1593281953, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.finalLoadingView.<anonymous> (QUILoadingView.kt:132)");
                    }
                    int ordinal = QUILoadingType.this.ordinal();
                    if (ordinal == 0) {
                        composer3.startReplaceableGroup(1268653801);
                        i c16 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), hVar2);
                        a.e b16 = a.f339245a.b();
                        Alignment.Vertical c17 = Alignment.INSTANCE.c();
                        final LoadingIconType loadingIconType2 = loadingIconType;
                        final int i16 = i3;
                        final String str2 = str;
                        final i iVar3 = iVar2;
                        final h hVar3 = hVar;
                        RowKt.a(c16, b16, c17, null, null, ComposableLambdaKt.composableLambda(composer3, -628557369, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUILoadingViewKt$finalLoadingView$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-628557369, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.finalLoadingView.<anonymous>.<anonymous> (QUILoadingView.kt:140)");
                                    }
                                    LoadingKt.Loading(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 18.0f), LoadingIconType.this, composer5, ((i16 >> 3) & 112) | 8, 0);
                                    if (str2.length() > 0) {
                                        TextKt.a(str2, iVar3, null, hVar3, Float.valueOf(14.0f), null, null, new com.tencent.ntcompose.material.n("PingFang SC"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, ((i16 >> 12) & 14) | 28736 | (com.tencent.ntcompose.material.n.f339436b << 21), 0, 0, 134217572);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196680, 24);
                        composer3.endReplaceableGroup();
                    } else if (ordinal != 1) {
                        composer3.startReplaceableGroup(1268655619);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(1268654705);
                        i j3 = ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), hVar2), 12.0f);
                        Alignment.Horizontal b17 = Alignment.INSTANCE.b();
                        a.e b18 = a.f339245a.b();
                        final LoadingIconType loadingIconType3 = loadingIconType;
                        final int i17 = i3;
                        final String str3 = str;
                        final i iVar4 = iVar2;
                        final h hVar4 = hVar;
                        ColumnKt.a(j3, b18, b17, null, ComposableLambdaKt.composableLambda(composer3, 565310537, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUILoadingViewKt$finalLoadingView$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(565310537, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.finalLoadingView.<anonymous>.<anonymous> (QUILoadingView.kt:164)");
                                    }
                                    LoadingKt.Loading(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 18.0f), LoadingIconType.this, composer5, ((i17 >> 3) & 112) | 8, 0);
                                    if (str3.length() > 0) {
                                        TextKt.a(str3, iVar4, null, hVar4, Float.valueOf(14.0f), null, null, new com.tencent.ntcompose.material.n("PingFang SC"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, ((i17 >> 12) & 14) | 28736 | (com.tencent.ntcompose.material.n.f339436b << 21), 0, 0, 134217572);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 24648, 8);
                        composer3.endReplaceableGroup();
                    }
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUILoadingViewKt$finalLoadingView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QUILoadingViewKt.finalLoadingView(i.this, qUILoadingType, loadingIconType, hVar, str, iVar2, hVar2, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QUILoadingView(i iVar, boolean z16, QUILoadingType qUILoadingType, LoadingIconType loadingIconType, String str, h hVar, h hVar2, Composer composer, final int i3, final int i16) {
        boolean z17;
        int i17;
        QUILoadingType qUILoadingType2;
        int i18;
        LoadingIconType loadingIconType2;
        int i19;
        String str2;
        int i26;
        int i27;
        boolean z18;
        LoadingIconType loadingIconType3;
        String str3;
        h hVar3;
        h hVar4;
        final LoadingIconType loadingIconType4;
        final h hVar5;
        final h hVar6;
        Object rememberedValue;
        final QUILoadingType qUILoadingType3;
        final h hVar7;
        final LoadingIconType loadingIconType5;
        i iVar2;
        h j3;
        h color$default;
        LoadingIconType loadingIconType6;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1399144437);
        int i28 = i16 & 1;
        int i29 = i28 != 0 ? i3 | 2 : i3;
        int i36 = i16 & 2;
        if (i36 != 0) {
            i29 |= 48;
        } else if ((i3 & 112) == 0) {
            z17 = z16;
            i29 |= startRestartGroup.changed(z17) ? 32 : 16;
            i17 = i16 & 4;
            if (i17 == 0) {
                i29 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                qUILoadingType2 = qUILoadingType;
                i29 |= startRestartGroup.changed(qUILoadingType2) ? 256 : 128;
                i18 = i16 & 8;
                if (i18 != 0) {
                    i29 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    loadingIconType2 = loadingIconType;
                    i29 |= startRestartGroup.changed(loadingIconType2) ? 2048 : 1024;
                    i19 = i16 & 16;
                    if (i19 == 0) {
                        i29 |= 24576;
                    } else if ((i3 & 57344) == 0) {
                        str2 = str;
                        i29 |= startRestartGroup.changed(str2) ? 16384 : 8192;
                        i26 = i16 & 32;
                        if (i26 != 0) {
                            i29 |= 65536;
                        }
                        i27 = i16 & 64;
                        if (i27 != 0) {
                            i29 |= 524288;
                        }
                        if ((i16 & 97) != 97 && (2995931 & i29) == 599186 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            iVar2 = iVar;
                            hVar3 = hVar;
                            qUILoadingType3 = qUILoadingType2;
                            loadingIconType5 = loadingIconType2;
                            str3 = str2;
                            hVar7 = hVar2;
                        } else {
                            i iVar3 = i28 != 0 ? i.INSTANCE : iVar;
                            z18 = i36 != 0 ? false : z17;
                            if (i17 != 0) {
                                qUILoadingType2 = QUILoadingType.LeftTextRightImage;
                            }
                            loadingIconType3 = i18 != 0 ? null : loadingIconType2;
                            str3 = i19 != 0 ? "\u52a0\u8f7d\u4e2d" : str2;
                            hVar3 = i26 != 0 ? null : hVar;
                            hVar4 = i27 == 0 ? hVar2 : null;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1399144437, i29, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUILoadingView (QUILoadingView.kt:57)");
                            }
                            if (loadingIconType3 == null) {
                                if (QUIToken.INSTANCE.isNightMode()) {
                                    loadingIconType6 = LoadingIconType.WHITE;
                                } else {
                                    loadingIconType6 = LoadingIconType.GRAY;
                                }
                                loadingIconType4 = loadingIconType6;
                            } else {
                                loadingIconType4 = loadingIconType3;
                            }
                            if (hVar4 == null) {
                                int ordinal = qUILoadingType2.ordinal();
                                if (ordinal == 0) {
                                    color$default = QUIToken.color$default("text_secondary");
                                } else if (ordinal == 1) {
                                    color$default = QUIToken.color$default("text_allwhite_primary");
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                                hVar5 = color$default;
                            } else {
                                hVar5 = hVar4;
                            }
                            if (hVar3 == null) {
                                if (z18) {
                                    j3 = h.INSTANCE.j();
                                } else if (qUILoadingType2 == QUILoadingType.LeftTextRightImage) {
                                    j3 = h.INSTANCE.j();
                                } else if (qUILoadingType2 == QUILoadingType.TopImageBottomText) {
                                    j3 = new h(2991344716L);
                                } else {
                                    j3 = h.INSTANCE.j();
                                }
                                hVar6 = j3;
                            } else {
                                hVar6 = hVar3;
                            }
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = ComposeLayoutPropUpdaterKt.n(i.INSTANCE, qUILoadingType2 == QUILoadingType.LeftTextRightImage ? 4.0f : 0.0f, qUILoadingType2 == QUILoadingType.TopImageBottomText ? 16.0f : 0.0f, 0.0f, 0.0f, 12, null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final i iVar4 = (i) rememberedValue;
                            if (z18) {
                                startRestartGroup.startReplaceableGroup(-373693948);
                                final i iVar5 = iVar3;
                                final QUILoadingType qUILoadingType4 = qUILoadingType2;
                                final String str4 = str3;
                                final int i37 = i29;
                                ModalKt.a(null, false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1441060978, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUILoadingViewKt$QUILoadingView$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Composer composer2, Integer num) {
                                        Composer composer3 = composer2;
                                        int intValue = num.intValue();
                                        if ((intValue & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1441060978, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUILoadingView.<anonymous> (QUILoadingView.kt:86)");
                                            }
                                            Alignment alignment = Alignment.Center;
                                            i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), h.this), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUILoadingViewKt$QUILoadingView$1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                    return Unit.INSTANCE;
                                                }
                                            }, 3, null);
                                            final i iVar6 = iVar5;
                                            final QUILoadingType qUILoadingType5 = qUILoadingType4;
                                            final LoadingIconType loadingIconType7 = loadingIconType4;
                                            final h hVar8 = hVar5;
                                            final String str5 = str4;
                                            final i iVar7 = iVar4;
                                            final int i38 = i37;
                                            BoxKt.a(d16, alignment, null, ComposableLambdaKt.composableLambda(composer3, 472314056, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUILoadingViewKt$QUILoadingView$1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                            ComposerKt.traceEventStart(472314056, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUILoadingView.<anonymous>.<anonymous> (QUILoadingView.kt:92)");
                                                        }
                                                        i iVar8 = i.this;
                                                        QUILoadingType qUILoadingType6 = qUILoadingType5;
                                                        LoadingIconType loadingIconType8 = loadingIconType7;
                                                        h hVar9 = hVar8;
                                                        String str6 = str5;
                                                        i iVar9 = iVar7;
                                                        h j16 = h.INSTANCE.j();
                                                        int i39 = i38;
                                                        QUILoadingViewKt.finalLoadingView(iVar8, qUILoadingType6, loadingIconType8, hVar9, str6, iVar9, j16, composer5, ((i39 >> 3) & 112) | 2363400 | (i39 & 57344));
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer3, 3128, 4);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), startRestartGroup, 24576, 15);
                                startRestartGroup.endReplaceableGroup();
                            } else {
                                startRestartGroup.startReplaceableGroup(-373693282);
                                finalLoadingView(iVar3, qUILoadingType2, loadingIconType4, hVar5, str3, iVar4, hVar6, startRestartGroup, (i29 & 57344) | ((i29 >> 3) & 112) | 2363400);
                                startRestartGroup.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            qUILoadingType3 = qUILoadingType2;
                            hVar7 = hVar4;
                            loadingIconType5 = loadingIconType3;
                            z17 = z18;
                            iVar2 = iVar3;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                            return;
                        }
                        final i iVar6 = iVar2;
                        final boolean z19 = z17;
                        final String str5 = str3;
                        final h hVar8 = hVar3;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUILoadingViewKt$QUILoadingView$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer2, Integer num) {
                                num.intValue();
                                QUILoadingViewKt.QUILoadingView(i.this, z19, qUILoadingType3, loadingIconType5, str5, hVar8, hVar7, composer2, i3 | 1, i16);
                                return Unit.INSTANCE;
                            }
                        });
                        return;
                    }
                    str2 = str;
                    i26 = i16 & 32;
                    if (i26 != 0) {
                    }
                    i27 = i16 & 64;
                    if (i27 != 0) {
                    }
                    if ((i16 & 97) != 97) {
                    }
                    if (i28 != 0) {
                    }
                    if (i36 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if (i27 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (loadingIconType3 == null) {
                    }
                    if (hVar4 == null) {
                    }
                    if (hVar3 == null) {
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final i iVar42 = (i) rememberedValue;
                    if (z18) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    qUILoadingType3 = qUILoadingType2;
                    hVar7 = hVar4;
                    loadingIconType5 = loadingIconType3;
                    z17 = z18;
                    iVar2 = iVar3;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                loadingIconType2 = loadingIconType;
                i19 = i16 & 16;
                if (i19 == 0) {
                }
                str2 = str;
                i26 = i16 & 32;
                if (i26 != 0) {
                }
                i27 = i16 & 64;
                if (i27 != 0) {
                }
                if ((i16 & 97) != 97) {
                }
                if (i28 != 0) {
                }
                if (i36 != 0) {
                }
                if (i17 != 0) {
                }
                if (i18 != 0) {
                }
                if (i19 != 0) {
                }
                if (i26 != 0) {
                }
                if (i27 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                if (loadingIconType3 == null) {
                }
                if (hVar4 == null) {
                }
                if (hVar3 == null) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final i iVar422 = (i) rememberedValue;
                if (z18) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                qUILoadingType3 = qUILoadingType2;
                hVar7 = hVar4;
                loadingIconType5 = loadingIconType3;
                z17 = z18;
                iVar2 = iVar3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            qUILoadingType2 = qUILoadingType;
            i18 = i16 & 8;
            if (i18 != 0) {
            }
            loadingIconType2 = loadingIconType;
            i19 = i16 & 16;
            if (i19 == 0) {
            }
            str2 = str;
            i26 = i16 & 32;
            if (i26 != 0) {
            }
            i27 = i16 & 64;
            if (i27 != 0) {
            }
            if ((i16 & 97) != 97) {
            }
            if (i28 != 0) {
            }
            if (i36 != 0) {
            }
            if (i17 != 0) {
            }
            if (i18 != 0) {
            }
            if (i19 != 0) {
            }
            if (i26 != 0) {
            }
            if (i27 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (loadingIconType3 == null) {
            }
            if (hVar4 == null) {
            }
            if (hVar3 == null) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final i iVar4222 = (i) rememberedValue;
            if (z18) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            qUILoadingType3 = qUILoadingType2;
            hVar7 = hVar4;
            loadingIconType5 = loadingIconType3;
            z17 = z18;
            iVar2 = iVar3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        z17 = z16;
        i17 = i16 & 4;
        if (i17 == 0) {
        }
        qUILoadingType2 = qUILoadingType;
        i18 = i16 & 8;
        if (i18 != 0) {
        }
        loadingIconType2 = loadingIconType;
        i19 = i16 & 16;
        if (i19 == 0) {
        }
        str2 = str;
        i26 = i16 & 32;
        if (i26 != 0) {
        }
        i27 = i16 & 64;
        if (i27 != 0) {
        }
        if ((i16 & 97) != 97) {
        }
        if (i28 != 0) {
        }
        if (i36 != 0) {
        }
        if (i17 != 0) {
        }
        if (i18 != 0) {
        }
        if (i19 != 0) {
        }
        if (i26 != 0) {
        }
        if (i27 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (loadingIconType3 == null) {
        }
        if (hVar4 == null) {
        }
        if (hVar3 == null) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final i iVar42222 = (i) rememberedValue;
        if (z18) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        qUILoadingType3 = qUILoadingType2;
        hVar7 = hVar4;
        loadingIconType5 = loadingIconType3;
        z17 = z18;
        iVar2 = iVar3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
