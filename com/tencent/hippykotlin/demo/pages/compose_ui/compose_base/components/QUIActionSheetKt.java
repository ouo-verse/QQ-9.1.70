package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.AlertCustomDialogKt;
import com.tencent.ntcompose.material.AlertDialogTransitionType;
import com.tencent.ntcompose.material.DividerKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUIActionSheetKt {
    public static final QUIActionSheetItem QUIActionSheetWarningTextItem(final String str, Function0<Unit> function0) {
        final k kVar = new k(QUIToken.color$default("feedback_error"), Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, 16380, null);
        return new QUIActionSheetItem(str, ComposableLambdaKt.composableLambdaInstance(-869879842, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetKt$QUIActionSheetTextItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer, Integer num) {
                int i3;
                b bVar2 = bVar;
                Composer composer2 = composer;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i3 = (composer2.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i3 = intValue;
                }
                if ((i3 & 91) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-869879842, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetTextItem.<anonymous> (QUIActionSheet.kt:56)");
                    }
                    TextKt.a(str, bVar2.a(i.INSTANCE, Alignment.Center), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, kVar, null, null, null, null, null, false, composer2, 64, 0, k.f28903n, 133169148);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), function0);
    }

    public static final void QUIActionSheet(final boolean z16, final String str, final QUIActionSheetItem[] qUIActionSheetItemArr, String str2, final Function1<? super Boolean, Unit> function1, Function0<Unit> function0, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(1659164783);
        String str3 = (i16 & 8) != 0 ? "\u53d6\u6d88" : str2;
        final Function0<Unit> function02 = (i16 & 32) != 0 ? null : function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1659164783, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheet (QUIActionSheet.kt:97)");
        }
        AlertDialogTransitionType alertDialogTransitionType = AlertDialogTransitionType.DIRECTION_FROM_BOTTOM;
        h a16 = h.INSTANCE.a(0.5f);
        Alignment alignment = Alignment.BottomCenter;
        Boolean valueOf = Boolean.valueOf(z16);
        int i17 = i3 & 14;
        startRestartGroup.startReplaceableGroup(1618982084);
        boolean changed = startRestartGroup.changed(valueOf) | startRestartGroup.changed(function1) | startRestartGroup.changed(function02);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetKt$QUIActionSheet$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    if (z16) {
                        function1.invoke(Boolean.TRUE);
                    }
                    Function0<Unit> function03 = function02;
                    if (function03 != null) {
                        function03.invoke();
                    }
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final String str4 = str3;
        final Function0<Unit> function03 = function02;
        AlertCustomDialogKt.a(z16, false, a16, null, alertDialogTransitionType, (Function0) rememberedValue, null, alignment, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 500994204, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetKt$QUIActionSheet$2
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
                        ComposerKt.traceEventStart(500994204, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheet.<anonymous> (QUIActionSheet.kt:116)");
                    }
                    i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.k(ComposeLayoutPropUpdaterKt.j(ModifiersKt.c(i.INSTANCE, QUIToken.color$default("bg_middle_standard")), 0.0f, 1, null), 8.0f, 8.0f, 0.0f, 0.0f), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetKt$QUIActionSheet$2.1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    final String str5 = str;
                    final QUIActionSheetItem[] qUIActionSheetItemArr2 = qUIActionSheetItemArr;
                    final String str6 = str4;
                    final Function1<Boolean, Unit> function12 = function1;
                    final int i18 = i3;
                    ColumnKt.a(d16, null, null, null, ComposableLambdaKt.composableLambda(composer3, 236009605, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetKt$QUIActionSheet$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                            h a17;
                            Object first;
                            QUIActionSheetItem qUIActionSheetItem;
                            String str7;
                            int i19;
                            int i26;
                            h a18;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(236009605, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheet.<anonymous>.<anonymous> (QUIActionSheet.kt:123)");
                                }
                                String str8 = str5;
                                composer5.startReplaceableGroup(-778352454);
                                if (str8 != null) {
                                    final String str9 = str5;
                                    final int i27 = i18;
                                    BoxKt.a(ModifiersKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 16.0f, 10.5f, 16.0f, 11.0f), QUIToken.color$default("bg_middle_light")), str9), null, null, ComposableLambdaKt.composableLambda(composer5, -1312705701, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetKt$QUIActionSheet$2$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar, Composer composer6, Integer num3) {
                                            int i28;
                                            b bVar2 = bVar;
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 14) == 0) {
                                                i28 = (composer7.changed(bVar2) ? 4 : 2) | intValue3;
                                            } else {
                                                i28 = intValue3;
                                            }
                                            if ((i28 & 91) == 18 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1312705701, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QUIActionSheet.kt:129)");
                                                }
                                                TextKt.a(str9, bVar2.a(i.INSTANCE, Alignment.Center), null, QUIToken.color$default("text_secondary"), Float.valueOf(12.0f), null, null, null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(34.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i27 >> 3) & 14) | 28736, 48, 0, 134214628);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3080, 6);
                                }
                                composer5.endReplaceableGroup();
                                composer5.startReplaceableGroup(-778351915);
                                QUIActionSheetItem[] qUIActionSheetItemArr3 = qUIActionSheetItemArr2;
                                String str10 = str5;
                                int length = qUIActionSheetItemArr3.length;
                                int i28 = 0;
                                while (i28 < length) {
                                    QUIActionSheetItem qUIActionSheetItem2 = qUIActionSheetItemArr3[i28];
                                    composer5.startReplaceableGroup(-778351878);
                                    first = ArraysKt___ArraysKt.first(qUIActionSheetItemArr3);
                                    if (!Intrinsics.areEqual(first, qUIActionSheetItem2) || str10 != null) {
                                        qUIActionSheetItem = qUIActionSheetItem2;
                                        str7 = "QQCommonNApiModule";
                                        i19 = i28;
                                        i26 = length;
                                        DividerKt.a(ComposeLayoutPropUpdaterKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 0.5f), QUIToken.color$default("border_standard")), 0.0f, 1, null), null, 0.0f, 0.0f, 0.0f, composer5, 8, 30);
                                    } else {
                                        qUIActionSheetItem = qUIActionSheetItem2;
                                        str7 = "QQCommonNApiModule";
                                        i19 = i28;
                                        i26 = length;
                                    }
                                    composer5.endReplaceableGroup();
                                    final QUIActionSheetItem qUIActionSheetItem3 = qUIActionSheetItem;
                                    i a19 = ModifiersKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 56.0f), QUIToken.color$default("bg_middle_light")), qUIActionSheetItem3.accessibility);
                                    QQCommonNApiModule.Companion companion = QQCommonNApiModule.Companion;
                                    if (((QQCommonNApiModule) c.f117352a.g().acquireModule(str7)).isDarkTheme()) {
                                        a18 = h.INSTANCE.p(0.1f);
                                    } else {
                                        a18 = h.INSTANCE.a(0.1f);
                                    }
                                    i w3 = ModifiersKt.w(a19, a18);
                                    composer5.startReplaceableGroup(1157296644);
                                    boolean changed2 = composer5.changed(qUIActionSheetItem3);
                                    Object rememberedValue2 = composer5.rememberedValue();
                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetKt$QUIActionSheet$2$2$2$1$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                QUIActionSheetItem.this.onClick.invoke();
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue2);
                                    }
                                    composer5.endReplaceableGroup();
                                    BoxKt.a(ViewEventPropUpdaterKt.d(w3, false, null, (Function1) rememberedValue2, 3, null), null, null, ComposableLambdaKt.composableLambda(composer5, 1045627669, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetKt$QUIActionSheet$2$2$2$2
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar, Composer composer6, Integer num3) {
                                            b bVar2 = bVar;
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 14) == 0) {
                                                intValue3 |= composer7.changed(bVar2) ? 4 : 2;
                                            }
                                            if ((intValue3 & 91) == 18 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1045627669, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QUIActionSheet.kt:146)");
                                                }
                                                QUIActionSheetItem.this.content.invoke(bVar2, composer7, Integer.valueOf(intValue3 & 14));
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3080, 6);
                                    i28 = i19 + 1;
                                    length = i26;
                                }
                                composer5.endReplaceableGroup();
                                i.Companion companion2 = i.INSTANCE;
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion2, 12.0f), composer5, 8, 0);
                                i a26 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.j(ModifiersKt.c(companion2, QUIToken.color$default("bg_middle_light")), 0.0f, 1, null), 0.0f, 0.0f, 0.0f, ((a) composer5.consume(CompositionLocalsKt.d())).f().getBottom(), 7, null), str6);
                                QQCommonNApiModule.Companion companion3 = QQCommonNApiModule.Companion;
                                if (((QQCommonNApiModule) c.f117352a.g().acquireModule("QQCommonNApiModule")).isDarkTheme()) {
                                    a17 = h.INSTANCE.p(0.1f);
                                } else {
                                    a17 = h.INSTANCE.a(0.1f);
                                }
                                i w16 = ModifiersKt.w(a26, a17);
                                final Function1<Boolean, Unit> function13 = function12;
                                composer5.startReplaceableGroup(1157296644);
                                boolean changed3 = composer5.changed(function13);
                                Object rememberedValue3 = composer5.rememberedValue();
                                if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetKt$QUIActionSheet$2$2$3$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            function13.invoke(Boolean.FALSE);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue3);
                                }
                                composer5.endReplaceableGroup();
                                i d17 = ViewEventPropUpdaterKt.d(w16, false, null, (Function1) rememberedValue3, 3, null);
                                final String str11 = str6;
                                final int i29 = i18;
                                BoxKt.a(d17, null, null, ComposableLambdaKt.composableLambda(composer5, -810390337, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetKt.QUIActionSheet.2.2.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-810390337, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheet.<anonymous>.<anonymous>.<anonymous> (QUIActionSheet.kt:161)");
                                            }
                                            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 56.0f);
                                            final String str12 = str11;
                                            final int i36 = i29;
                                            BoxKt.a(k3, null, null, ComposableLambdaKt.composableLambda(composer7, 1292192633, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetKt.QUIActionSheet.2.2.4.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(b bVar2, Composer composer8, Integer num4) {
                                                    int i37;
                                                    b bVar3 = bVar2;
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 14) == 0) {
                                                        i37 = (composer9.changed(bVar3) ? 4 : 2) | intValue4;
                                                    } else {
                                                        i37 = intValue4;
                                                    }
                                                    if ((i37 & 91) == 18 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1292192633, intValue4, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QUIActionSheet.kt:162)");
                                                        }
                                                        TextKt.a(str12, bVar3.a(i.INSTANCE, Alignment.Center), null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, bp3.c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(34.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, ((i36 >> 9) & 14) | 1601600, 48, 0, 134214564);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 3080, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3080, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24584, 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, i17 | 12608000, 6, com.tencent.luggage.wxa.uf.h.CTRL_INDEX);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final String str5 = str3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIActionSheetKt$QUIActionSheet$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QUIActionSheetKt.QUIActionSheet(z16, str, qUIActionSheetItemArr, str5, function1, function03, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
