package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUIListSingleLineSwitchViewKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QUIListSingleLineSwitchView(i iVar, String str, Function2<? super Composer, ? super Integer, Unit> function2, String str2, Function2<? super Composer, ? super Integer, Unit> function22, final boolean z16, final Function1<? super Boolean, Unit> function1, Composer composer, final int i3, final int i16) {
        String str3;
        int i17;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i18;
        String str4;
        int i19;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i26;
        int i27;
        String str5;
        i iVar2;
        i iVar3;
        final String str6;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1313527491);
        int i28 = i16 & 1;
        final int i29 = i28 != 0 ? i3 | 2 : i3;
        int i36 = i16 & 2;
        if (i36 != 0) {
            i29 |= 48;
        } else if ((i3 & 112) == 0) {
            str3 = str;
            i29 |= startRestartGroup.changed(str3) ? 32 : 16;
            i17 = i16 & 4;
            if (i17 == 0) {
                i29 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                function23 = function2;
                i29 |= startRestartGroup.changed(function23) ? 256 : 128;
                i18 = i16 & 8;
                if (i18 != 0) {
                    i29 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    str4 = str2;
                    i29 |= startRestartGroup.changed(str4) ? 2048 : 1024;
                    i19 = i16 & 16;
                    if (i19 == 0) {
                        i29 |= 24576;
                    } else if ((57344 & i3) == 0) {
                        function24 = function22;
                        i29 |= startRestartGroup.changed(function24) ? 16384 : 8192;
                        if ((i16 & 32) != 0) {
                            i26 = 196608;
                        } else {
                            if ((458752 & i3) == 0) {
                                i26 = startRestartGroup.changed(z16) ? 131072 : 65536;
                            }
                            if ((i16 & 64) != 0) {
                                if ((i3 & 3670016) == 0) {
                                    i27 = startRestartGroup.changed(function1) ? 1048576 : 524288;
                                }
                                if (i28 != 1 && (i29 & 2995931) == 599186 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    iVar3 = iVar;
                                    function25 = function23;
                                    str6 = str4;
                                } else {
                                    i iVar4 = i28 != 0 ? i.INSTANCE : iVar;
                                    if (i36 != 0) {
                                        str3 = null;
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function26 = i17 != 0 ? null : function23;
                                    String str7 = i18 != 0 ? "" : str4;
                                    Function2<? super Composer, ? super Integer, Unit> function27 = i19 == 0 ? function24 : null;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1313527491, i29, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchView (QUIListSingleLineSwitchView.kt:26)");
                                    }
                                    StringBuilder m3 = HotViewKt$$ExternalSyntheticOutline0.m(str7, "\uff0c\u5207\u6362\u6309\u94ae \uff0c");
                                    if (z16) {
                                        str5 = "\u5df2\u6253\u5f00";
                                    } else {
                                        str5 = "\u5df2\u5173\u95ed";
                                    }
                                    m3.append(str5);
                                    i a16 = ModifiersKt.a(iVar4, m3.toString());
                                    if (c.f117352a.g().getPageData().getIsAccessibilityRunning()) {
                                        i.Companion companion = i.INSTANCE;
                                        Boolean valueOf = Boolean.valueOf(z16);
                                        startRestartGroup.startReplaceableGroup(511388516);
                                        boolean changed = startRestartGroup.changed(valueOf) | startRestartGroup.changed(function1);
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt$QUIListSingleLineSwitchView$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    function1.invoke(Boolean.valueOf(!z16));
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        iVar2 = ViewEventPropUpdaterKt.d(companion, false, null, (Function1) rememberedValue, 3, null);
                                    } else {
                                        iVar2 = i.INSTANCE;
                                    }
                                    i b16 = a16.b(iVar2);
                                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -1631741840, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt$QUIListSingleLineSwitchView$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
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
                                                    ComposerKt.traceEventStart(-1631741840, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchView.<anonymous> (QUIListSingleLineSwitchView.kt:45)");
                                                }
                                                boolean z17 = z16;
                                                final Function1<Boolean, Unit> function12 = function1;
                                                composer3.startReplaceableGroup(1157296644);
                                                boolean changed2 = composer3.changed(function12);
                                                Object rememberedValue2 = composer3.rememberedValue();
                                                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue2 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt$QUIListSingleLineSwitchView$2$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(Boolean bool) {
                                                            function12.invoke(Boolean.valueOf(bool.booleanValue()));
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(rememberedValue2);
                                                }
                                                composer3.endReplaceableGroup();
                                                QUISwitchKt.QUISwitch(z17, (Function1) rememberedValue2, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 47.0f), 26.0f), composer3, ((i29 >> 15) & 14) | 512, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    int i37 = (i29 & 112) | 8 | (i29 & 896) | (i29 & 7168) | ((i29 << 6) & 3670016);
                                    String str8 = str7;
                                    QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(b16, str3, function26, str7, 0.0f, null, function27, null, null, null, composableLambda, 0.0f, startRestartGroup, i37, 6, 2992);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function24 = function27;
                                    iVar3 = iVar4;
                                    Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                    str6 = str8;
                                    function25 = function28;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup == null) {
                                    return;
                                }
                                final i iVar5 = iVar3;
                                final String str9 = str3;
                                final Function2<? super Composer, ? super Integer, Unit> function29 = function24;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt$QUIListSingleLineSwitchView$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Composer composer2, Integer num) {
                                        num.intValue();
                                        QUIListSingleLineSwitchViewKt.QUIListSingleLineSwitchView(i.this, str9, function25, str6, function29, z16, function1, composer2, i3 | 1, i16);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return;
                            }
                            i27 = 1572864;
                            i29 |= i27;
                            if (i28 != 1) {
                            }
                            if (i28 != 0) {
                            }
                            if (i36 != 0) {
                            }
                            if (i17 != 0) {
                            }
                            if (i18 != 0) {
                            }
                            if (i19 == 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            StringBuilder m36 = HotViewKt$$ExternalSyntheticOutline0.m(str7, "\uff0c\u5207\u6362\u6309\u94ae \uff0c");
                            if (z16) {
                            }
                            m36.append(str5);
                            i a162 = ModifiersKt.a(iVar4, m36.toString());
                            if (c.f117352a.g().getPageData().getIsAccessibilityRunning()) {
                            }
                            i b162 = a162.b(iVar2);
                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, -1631741840, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt$QUIListSingleLineSwitchView$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
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
                                            ComposerKt.traceEventStart(-1631741840, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchView.<anonymous> (QUIListSingleLineSwitchView.kt:45)");
                                        }
                                        boolean z17 = z16;
                                        final Function1<? super Boolean, Unit> function12 = function1;
                                        composer3.startReplaceableGroup(1157296644);
                                        boolean changed2 = composer3.changed(function12);
                                        Object rememberedValue2 = composer3.rememberedValue();
                                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt$QUIListSingleLineSwitchView$2$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Boolean bool) {
                                                    function12.invoke(Boolean.valueOf(bool.booleanValue()));
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue2);
                                        }
                                        composer3.endReplaceableGroup();
                                        QUISwitchKt.QUISwitch(z17, (Function1) rememberedValue2, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 47.0f), 26.0f), composer3, ((i29 >> 15) & 14) | 512, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            });
                            int i372 = (i29 & 112) | 8 | (i29 & 896) | (i29 & 7168) | ((i29 << 6) & 3670016);
                            String str82 = str7;
                            QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(b162, str3, function26, str7, 0.0f, null, function27, null, null, null, composableLambda2, 0.0f, startRestartGroup, i372, 6, 2992);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function24 = function27;
                            iVar3 = iVar4;
                            Function2<? super Composer, ? super Integer, Unit> function282 = function26;
                            str6 = str82;
                            function25 = function282;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i29 |= i26;
                        if ((i16 & 64) != 0) {
                        }
                        i29 |= i27;
                        if (i28 != 1) {
                        }
                        if (i28 != 0) {
                        }
                        if (i36 != 0) {
                        }
                        if (i17 != 0) {
                        }
                        if (i18 != 0) {
                        }
                        if (i19 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        StringBuilder m362 = HotViewKt$$ExternalSyntheticOutline0.m(str7, "\uff0c\u5207\u6362\u6309\u94ae \uff0c");
                        if (z16) {
                        }
                        m362.append(str5);
                        i a1622 = ModifiersKt.a(iVar4, m362.toString());
                        if (c.f117352a.g().getPageData().getIsAccessibilityRunning()) {
                        }
                        i b1622 = a1622.b(iVar2);
                        ComposableLambda composableLambda22 = ComposableLambdaKt.composableLambda(startRestartGroup, -1631741840, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt$QUIListSingleLineSwitchView$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                        ComposerKt.traceEventStart(-1631741840, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchView.<anonymous> (QUIListSingleLineSwitchView.kt:45)");
                                    }
                                    boolean z17 = z16;
                                    final Function1<? super Boolean, Unit> function12 = function1;
                                    composer3.startReplaceableGroup(1157296644);
                                    boolean changed2 = composer3.changed(function12);
                                    Object rememberedValue2 = composer3.rememberedValue();
                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt$QUIListSingleLineSwitchView$2$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Boolean bool) {
                                                function12.invoke(Boolean.valueOf(bool.booleanValue()));
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue2);
                                    }
                                    composer3.endReplaceableGroup();
                                    QUISwitchKt.QUISwitch(z17, (Function1) rememberedValue2, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 47.0f), 26.0f), composer3, ((i29 >> 15) & 14) | 512, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        int i3722 = (i29 & 112) | 8 | (i29 & 896) | (i29 & 7168) | ((i29 << 6) & 3670016);
                        String str822 = str7;
                        QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(b1622, str3, function26, str7, 0.0f, null, function27, null, null, null, composableLambda22, 0.0f, startRestartGroup, i3722, 6, 2992);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function24 = function27;
                        iVar3 = iVar4;
                        Function2<? super Composer, ? super Integer, Unit> function2822 = function26;
                        str6 = str822;
                        function25 = function2822;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    function24 = function22;
                    if ((i16 & 32) != 0) {
                    }
                    i29 |= i26;
                    if ((i16 & 64) != 0) {
                    }
                    i29 |= i27;
                    if (i28 != 1) {
                    }
                    if (i28 != 0) {
                    }
                    if (i36 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i19 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    StringBuilder m3622 = HotViewKt$$ExternalSyntheticOutline0.m(str7, "\uff0c\u5207\u6362\u6309\u94ae \uff0c");
                    if (z16) {
                    }
                    m3622.append(str5);
                    i a16222 = ModifiersKt.a(iVar4, m3622.toString());
                    if (c.f117352a.g().getPageData().getIsAccessibilityRunning()) {
                    }
                    i b16222 = a16222.b(iVar2);
                    ComposableLambda composableLambda222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1631741840, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt$QUIListSingleLineSwitchView$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                                    ComposerKt.traceEventStart(-1631741840, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchView.<anonymous> (QUIListSingleLineSwitchView.kt:45)");
                                }
                                boolean z17 = z16;
                                final Function1<? super Boolean, Unit> function12 = function1;
                                composer3.startReplaceableGroup(1157296644);
                                boolean changed2 = composer3.changed(function12);
                                Object rememberedValue2 = composer3.rememberedValue();
                                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt$QUIListSingleLineSwitchView$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Boolean bool) {
                                            function12.invoke(Boolean.valueOf(bool.booleanValue()));
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue2);
                                }
                                composer3.endReplaceableGroup();
                                QUISwitchKt.QUISwitch(z17, (Function1) rememberedValue2, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 47.0f), 26.0f), composer3, ((i29 >> 15) & 14) | 512, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    int i37222 = (i29 & 112) | 8 | (i29 & 896) | (i29 & 7168) | ((i29 << 6) & 3670016);
                    String str8222 = str7;
                    QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(b16222, str3, function26, str7, 0.0f, null, function27, null, null, null, composableLambda222, 0.0f, startRestartGroup, i37222, 6, 2992);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function24 = function27;
                    iVar3 = iVar4;
                    Function2<? super Composer, ? super Integer, Unit> function28222 = function26;
                    str6 = str8222;
                    function25 = function28222;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                str4 = str2;
                i19 = i16 & 16;
                if (i19 == 0) {
                }
                function24 = function22;
                if ((i16 & 32) != 0) {
                }
                i29 |= i26;
                if ((i16 & 64) != 0) {
                }
                i29 |= i27;
                if (i28 != 1) {
                }
                if (i28 != 0) {
                }
                if (i36 != 0) {
                }
                if (i17 != 0) {
                }
                if (i18 != 0) {
                }
                if (i19 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                StringBuilder m36222 = HotViewKt$$ExternalSyntheticOutline0.m(str7, "\uff0c\u5207\u6362\u6309\u94ae \uff0c");
                if (z16) {
                }
                m36222.append(str5);
                i a162222 = ModifiersKt.a(iVar4, m36222.toString());
                if (c.f117352a.g().getPageData().getIsAccessibilityRunning()) {
                }
                i b162222 = a162222.b(iVar2);
                ComposableLambda composableLambda2222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1631741840, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt$QUIListSingleLineSwitchView$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                                ComposerKt.traceEventStart(-1631741840, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchView.<anonymous> (QUIListSingleLineSwitchView.kt:45)");
                            }
                            boolean z17 = z16;
                            final Function1<? super Boolean, Unit> function12 = function1;
                            composer3.startReplaceableGroup(1157296644);
                            boolean changed2 = composer3.changed(function12);
                            Object rememberedValue2 = composer3.rememberedValue();
                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt$QUIListSingleLineSwitchView$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool) {
                                        function12.invoke(Boolean.valueOf(bool.booleanValue()));
                                        return Unit.INSTANCE;
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue2);
                            }
                            composer3.endReplaceableGroup();
                            QUISwitchKt.QUISwitch(z17, (Function1) rememberedValue2, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 47.0f), 26.0f), composer3, ((i29 >> 15) & 14) | 512, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                int i372222 = (i29 & 112) | 8 | (i29 & 896) | (i29 & 7168) | ((i29 << 6) & 3670016);
                String str82222 = str7;
                QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(b162222, str3, function26, str7, 0.0f, null, function27, null, null, null, composableLambda2222, 0.0f, startRestartGroup, i372222, 6, 2992);
                if (ComposerKt.isTraceInProgress()) {
                }
                function24 = function27;
                iVar3 = iVar4;
                Function2<? super Composer, ? super Integer, Unit> function282222 = function26;
                str6 = str82222;
                function25 = function282222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function23 = function2;
            i18 = i16 & 8;
            if (i18 != 0) {
            }
            str4 = str2;
            i19 = i16 & 16;
            if (i19 == 0) {
            }
            function24 = function22;
            if ((i16 & 32) != 0) {
            }
            i29 |= i26;
            if ((i16 & 64) != 0) {
            }
            i29 |= i27;
            if (i28 != 1) {
            }
            if (i28 != 0) {
            }
            if (i36 != 0) {
            }
            if (i17 != 0) {
            }
            if (i18 != 0) {
            }
            if (i19 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            StringBuilder m362222 = HotViewKt$$ExternalSyntheticOutline0.m(str7, "\uff0c\u5207\u6362\u6309\u94ae \uff0c");
            if (z16) {
            }
            m362222.append(str5);
            i a1622222 = ModifiersKt.a(iVar4, m362222.toString());
            if (c.f117352a.g().getPageData().getIsAccessibilityRunning()) {
            }
            i b1622222 = a1622222.b(iVar2);
            ComposableLambda composableLambda22222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1631741840, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt$QUIListSingleLineSwitchView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                            ComposerKt.traceEventStart(-1631741840, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchView.<anonymous> (QUIListSingleLineSwitchView.kt:45)");
                        }
                        boolean z17 = z16;
                        final Function1<? super Boolean, Unit> function12 = function1;
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed2 = composer3.changed(function12);
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt$QUIListSingleLineSwitchView$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Boolean bool) {
                                    function12.invoke(Boolean.valueOf(bool.booleanValue()));
                                    return Unit.INSTANCE;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        QUISwitchKt.QUISwitch(z17, (Function1) rememberedValue2, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 47.0f), 26.0f), composer3, ((i29 >> 15) & 14) | 512, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            });
            int i3722222 = (i29 & 112) | 8 | (i29 & 896) | (i29 & 7168) | ((i29 << 6) & 3670016);
            String str822222 = str7;
            QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(b1622222, str3, function26, str7, 0.0f, null, function27, null, null, null, composableLambda22222, 0.0f, startRestartGroup, i3722222, 6, 2992);
            if (ComposerKt.isTraceInProgress()) {
            }
            function24 = function27;
            iVar3 = iVar4;
            Function2<? super Composer, ? super Integer, Unit> function2822222 = function26;
            str6 = str822222;
            function25 = function2822222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        str3 = str;
        i17 = i16 & 4;
        if (i17 == 0) {
        }
        function23 = function2;
        i18 = i16 & 8;
        if (i18 != 0) {
        }
        str4 = str2;
        i19 = i16 & 16;
        if (i19 == 0) {
        }
        function24 = function22;
        if ((i16 & 32) != 0) {
        }
        i29 |= i26;
        if ((i16 & 64) != 0) {
        }
        i29 |= i27;
        if (i28 != 1) {
        }
        if (i28 != 0) {
        }
        if (i36 != 0) {
        }
        if (i17 != 0) {
        }
        if (i18 != 0) {
        }
        if (i19 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        StringBuilder m3622222 = HotViewKt$$ExternalSyntheticOutline0.m(str7, "\uff0c\u5207\u6362\u6309\u94ae \uff0c");
        if (z16) {
        }
        m3622222.append(str5);
        i a16222222 = ModifiersKt.a(iVar4, m3622222.toString());
        if (c.f117352a.g().getPageData().getIsAccessibilityRunning()) {
        }
        i b16222222 = a16222222.b(iVar2);
        ComposableLambda composableLambda222222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1631741840, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt$QUIListSingleLineSwitchView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                        ComposerKt.traceEventStart(-1631741840, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchView.<anonymous> (QUIListSingleLineSwitchView.kt:45)");
                    }
                    boolean z17 = z16;
                    final Function1<? super Boolean, Unit> function12 = function1;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed2 = composer3.changed(function12);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt$QUIListSingleLineSwitchView$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Boolean bool) {
                                function12.invoke(Boolean.valueOf(bool.booleanValue()));
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    QUISwitchKt.QUISwitch(z17, (Function1) rememberedValue2, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 47.0f), 26.0f), composer3, ((i29 >> 15) & 14) | 512, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        });
        int i37222222 = (i29 & 112) | 8 | (i29 & 896) | (i29 & 7168) | ((i29 << 6) & 3670016);
        String str8222222 = str7;
        QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(b16222222, str3, function26, str7, 0.0f, null, function27, null, null, null, composableLambda222222, 0.0f, startRestartGroup, i37222222, 6, 2992);
        if (ComposerKt.isTraceInProgress()) {
        }
        function24 = function27;
        iVar3 = iVar4;
        Function2<? super Composer, ? super Integer, Unit> function28222222 = function26;
        str6 = str8222222;
        function25 = function28222222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
