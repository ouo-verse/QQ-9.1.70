package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.animation.b;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import com.tencent.ntcompose.material.AlertCustomDialogKt;
import com.tencent.ntcompose.material.AlertDialogTransitionType;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.DividerKt;
import com.tencent.ntcompose.material.LazyColumnKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.am;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUIAlertDialogKt {
    public static final QUIAlertDialogItem QUIAlertDialogNormalTextItem(String str, Function0<Unit> function0) {
        return new QUIAlertDialogItem(str, ComposableLambdaKt.composableLambdaInstance(1407900958, true, new QUIAlertDialogKt$QUIAlertDialogTextItem$1(str, new k(QUIToken.color$default("text_primary"), Float.valueOf(17.0f), c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, 16376, null))), function0);
    }

    public static final QUIAlertDialogItem QUIAlertDialogWarningTextItem(String str, Function0<Unit> function0) {
        return new QUIAlertDialogItem(str, ComposableLambdaKt.composableLambdaInstance(1407900958, true, new QUIAlertDialogKt$QUIAlertDialogTextItem$1(str, new k(QUIToken.color$default("feedback_error"), Float.valueOf(17.0f), c.INSTANCE.f(), null, null, null, null, null, null, null, null, null, null, null, 16376, null))), function0);
    }

    public static final void access$AlertDialogItem(final QUIAlertDialogItem qUIAlertDialogItem, Composer composer, final int i3) {
        int i16;
        h a16;
        Composer startRestartGroup = composer.startRestartGroup(1988349383);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(qUIAlertDialogItem) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1988349383, i16, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.AlertDialogItem (QUIAlertDialog.kt:204)");
            }
            i a17 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), qUIAlertDialogItem.accessibility);
            QQCommonNApiModule.Companion companion = QQCommonNApiModule.Companion;
            if (((QQCommonNApiModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQCommonNApiModule")).isDarkTheme()) {
                a16 = h.INSTANCE.p(0.1f);
            } else {
                a16 = h.INSTANCE.a(0.1f);
            }
            i w3 = ModifiersKt.w(a17, a16);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(qUIAlertDialogItem);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt$AlertDialogItem$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        QUIAlertDialogItem.this.onClick.invoke();
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            ButtonKt.a(null, (Function1) rememberedValue, w3, null, ComposableLambdaKt.composableLambda(startRestartGroup, 692498492, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt$AlertDialogItem$2
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(n nVar, Composer composer2, Integer num) {
                    n nVar2 = nVar;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 14) == 0) {
                        intValue |= composer3.changed(nVar2) ? 4 : 2;
                    }
                    if ((intValue & 91) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(692498492, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.AlertDialogItem.<anonymous> (QUIAlertDialog.kt:212)");
                        }
                        QUIAlertDialogItem.this.content.invoke(nVar2, composer3, Integer.valueOf(intValue & 14));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 25088, 9);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt$AlertDialogItem$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QUIAlertDialogKt.access$AlertDialogItem(QUIAlertDialogItem.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void QUIAlertDialog(final boolean z16, String str, final String str2, Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, final QUIAlertDialogItem[] qUIAlertDialogItemArr, Function0<Unit> function0, Function0<Unit> function02, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(1376412693);
        String str3 = (i16 & 2) != 0 ? null : str;
        Function3<? super Float, ? super Composer, ? super Integer, Unit> function32 = (i16 & 8) != 0 ? null : function3;
        Function0<Unit> function03 = (i16 & 32) != 0 ? null : function0;
        Function0<Unit> function04 = (i16 & 64) != 0 ? null : function02;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1376412693, i3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialog (QUIAlertDialog.kt:47)");
        }
        h a16 = h.INSTANCE.a(0.5f);
        AlertDialogTransitionType alertDialogTransitionType = AlertDialogTransitionType.DIRECTION_FROM_CENTER;
        Function0<Unit> function05 = function03 == null ? new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt$QUIAlertDialog$1
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                return Unit.INSTANCE;
            }
        } : function03;
        Function0<Unit> function06 = function04 == null ? new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt$QUIAlertDialog$2
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                return Unit.INSTANCE;
            }
        } : function04;
        final String str4 = str3;
        final Function3<? super Float, ? super Composer, ? super Integer, Unit> function33 = function32;
        AlertCustomDialogKt.a(z16, true, a16, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt$QUIAlertDialog$3
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                return Unit.INSTANCE;
            }
        }, alertDialogTransitionType, function05, function06, Alignment.Center, b.b(0.85f, 0.0f, 0, 0.0f, null, 0, false, 126, null), b.d(200, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null), ComposableLambdaKt.composableLambda(startRestartGroup, -1863350270, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt$QUIAlertDialog$4
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
                        ComposerKt.traceEventStart(-1863350270, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialog.<anonymous> (QUIAlertDialog.kt:68)");
                    }
                    i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 296.0f), 6.0f), QUIToken.color$default("bg_top_light")), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt$QUIAlertDialog$4.1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    final QUIAlertDialogItem[] qUIAlertDialogItemArr2 = qUIAlertDialogItemArr;
                    final String str5 = str4;
                    final Function3<Float, Composer, Integer, Unit> function34 = function33;
                    final String str6 = str2;
                    final int i17 = i3;
                    ColumnKt.a(d16, null, null, null, ComposableLambdaKt.composableLambda(composer3, -2065293141, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt$QUIAlertDialog$4.2
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
                                    ComposerKt.traceEventStart(-2065293141, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialog.<anonymous>.<anonymous> (QUIAlertDialog.kt:76)");
                                }
                                composer5.startReplaceableGroup(-492369756);
                                Object rememberedValue = composer5.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                    composer5.updateRememberedValue(rememberedValue);
                                }
                                composer5.endReplaceableGroup();
                                final MutableState mutableState = (MutableState) rememberedValue;
                                i.Companion companion = i.INSTANCE;
                                i q16 = ComposeLayoutPropUpdaterKt.q(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 24.0f);
                                Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                final String str7 = str5;
                                final Function3<Float, Composer, Integer, Unit> function35 = function34;
                                final String str8 = str6;
                                final int i18 = i17;
                                final float f16 = 296.0f;
                                final float f17 = 24.0f;
                                ColumnKt.a(q16, null, horizontal, null, ComposableLambdaKt.composableLambda(composer5, -1627396396, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt.QUIAlertDialog.4.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
                                    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
                                    /* JADX WARN: Removed duplicated region for block: B:37:0x0117  */
                                    /* JADX WARN: Removed duplicated region for block: B:40:0x0285  */
                                    /* JADX WARN: Removed duplicated region for block: B:41:0x0139  */
                                    /* JADX WARN: Removed duplicated region for block: B:64:0x0101  */
                                    @Override // kotlin.jvm.functions.Function3
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(d dVar2, Composer composer6, Integer num3) {
                                        boolean z17;
                                        boolean z18;
                                        boolean z19;
                                        Composer composer7;
                                        Composer composer8;
                                        Composer composer9;
                                        Composer composer10 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer10.getSkipping()) {
                                            composer10.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1627396396, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialog.<anonymous>.<anonymous>.<anonymous> (QUIAlertDialog.kt:79)");
                                            }
                                            String str9 = str7;
                                            if (str9 != null) {
                                                if (str9.length() > 0) {
                                                    z17 = true;
                                                    if (function35 == null) {
                                                        if (!(str8.length() > 0)) {
                                                            z18 = false;
                                                            composer10.startReplaceableGroup(-640301563);
                                                            if (z17) {
                                                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.x(i.INSTANCE, 0.0f, f16 - (f17 * 2)), 0.0f, 0.0f, 0.0f, z18 ? 12.0f : 0.0f, 7, null);
                                                                String str10 = str7;
                                                                if (str10 == null) {
                                                                    str10 = "";
                                                                }
                                                                z19 = z17;
                                                                composer7 = composer10;
                                                                TextKt.a(str7, ModifiersKt.a(n3, str10), null, QUIToken.color$default("text_primary"), Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i18 >> 3) & 14) | 1601600, 48, 0, 134214564);
                                                            } else {
                                                                z19 = z17;
                                                                composer7 = composer10;
                                                            }
                                                            composer7.endReplaceableGroup();
                                                            float f18 = (f16 - (f17 * 2)) - 8.0f;
                                                            if (function35 != null) {
                                                                Composer composer11 = composer7;
                                                                composer11.startReplaceableGroup(-640300782);
                                                                function35.invoke(Float.valueOf(f18), composer11, Integer.valueOf(((i18 >> 6) & 112) | 6));
                                                                composer11.endReplaceableGroup();
                                                            } else {
                                                                Composer composer12 = composer7;
                                                                composer12.startReplaceableGroup(-640300699);
                                                                if (mutableState.getValue().booleanValue()) {
                                                                    composer12.startReplaceableGroup(-640300592);
                                                                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, f18), 400.0f);
                                                                    final String str11 = str8;
                                                                    final int i19 = i18;
                                                                    final boolean z26 = z19;
                                                                    composer9 = composer12;
                                                                    LazyColumnKt.a(k3, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer12, 1158870403, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt.QUIAlertDialog.4.2.1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(a aVar, Composer composer13, Integer num4) {
                                                                            Composer composer14 = composer13;
                                                                            int intValue4 = num4.intValue();
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(1158870403, intValue4, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QUIAlertDialog.kt:104)");
                                                                            }
                                                                            i a17 = ModifiersKt.a(i.INSTANCE, str11);
                                                                            boolean z27 = z26;
                                                                            TextKt.a(str11, a17, null, QUIToken.color$default("text_primary"), Float.valueOf(z27 ? 14.0f : 17.0f), null, null, null, null, null, null, Float.valueOf(z27 ? 17.0f : 24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer14, ((i19 >> 6) & 14) | 4160, 0, 0, 134215652);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer9, 8, 0, MsgConstant.KRMFILETHUMBSIZE384, 4194302);
                                                                    composer9.endReplaceableGroup();
                                                                } else {
                                                                    boolean z27 = z19;
                                                                    if (str8.length() > 0) {
                                                                        composer12.startReplaceableGroup(-640299981);
                                                                        i a17 = ModifiersKt.a(ComposeLayoutPropUpdaterKt.x(i.INSTANCE, 0.0f, f18), str8);
                                                                        float f19 = z27 ? 14.0f : 17.0f;
                                                                        float f26 = z27 ? 17.0f : 24.0f;
                                                                        h color$default = QUIToken.color$default("text_primary");
                                                                        String str12 = str8;
                                                                        Float valueOf = Float.valueOf(f19);
                                                                        Float valueOf2 = Float.valueOf(f26);
                                                                        Object valueOf3 = Float.valueOf(400.0f);
                                                                        final MutableState<Boolean> mutableState2 = mutableState;
                                                                        composer12.startReplaceableGroup(511388516);
                                                                        boolean changed = composer12.changed(valueOf3) | composer12.changed(mutableState2);
                                                                        Object rememberedValue2 = composer12.rememberedValue();
                                                                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                            rememberedValue2 = new Function1<am, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt$QUIAlertDialog$4$2$1$2$1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(am amVar) {
                                                                                    if (amVar.getFrame().getHeight() > 400.0f) {
                                                                                        MutableState.this.setValue(Boolean.TRUE);
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            };
                                                                            composer12.updateRememberedValue(rememberedValue2);
                                                                        }
                                                                        composer12.endReplaceableGroup();
                                                                        composer9 = composer12;
                                                                        TextKt.a(str12, a17, null, color$default, valueOf, null, null, null, null, null, null, valueOf2, null, null, null, null, null, null, null, (Function1) rememberedValue2, null, null, null, null, null, null, false, composer9, ((i18 >> 6) & 14) | 4160, 0, 0, 133691364);
                                                                        composer9.endReplaceableGroup();
                                                                    } else {
                                                                        composer8 = composer12;
                                                                        composer8.startReplaceableGroup(-640299285);
                                                                        composer8.endReplaceableGroup();
                                                                        composer8.endReplaceableGroup();
                                                                    }
                                                                }
                                                                composer8 = composer9;
                                                                composer8.endReplaceableGroup();
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }
                                                    z18 = true;
                                                    composer10.startReplaceableGroup(-640301563);
                                                    if (z17) {
                                                    }
                                                    composer7.endReplaceableGroup();
                                                    float f182 = (f16 - (f17 * 2)) - 8.0f;
                                                    if (function35 != null) {
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                }
                                            }
                                            z17 = false;
                                            if (function35 == null) {
                                            }
                                            z18 = true;
                                            composer10.startReplaceableGroup(-640301563);
                                            if (z17) {
                                            }
                                            composer7.endReplaceableGroup();
                                            float f1822 = (f16 - (f17 * 2)) - 8.0f;
                                            if (function35 != null) {
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 24968, 10);
                                float f18 = 0.5f;
                                if (qUIAlertDialogItemArr2.length == 2) {
                                    composer5.startReplaceableGroup(708030769);
                                    DividerKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 0.5f), QUIToken.color$default("border_standard")), null, 0.0f, 0.0f, 0.0f, composer5, 8, 30);
                                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 54.0f);
                                    final QUIAlertDialogItem[] qUIAlertDialogItemArr3 = qUIAlertDialogItemArr2;
                                    RowKt.a(k3, null, null, null, null, ComposableLambdaKt.composableLambda(composer5, 204397262, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt.QUIAlertDialog.4.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(n nVar, Composer composer6, Integer num3) {
                                            int i19;
                                            n nVar2 = nVar;
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 14) == 0) {
                                                i19 = (composer7.changed(nVar2) ? 4 : 2) | intValue3;
                                            } else {
                                                i19 = intValue3;
                                            }
                                            if ((i19 & 91) == 18 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(204397262, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialog.<anonymous>.<anonymous>.<anonymous> (QUIAlertDialog.kt:135)");
                                                }
                                                i.Companion companion2 = i.INSTANCE;
                                                i f19 = ComposeLayoutPropUpdaterKt.f(nVar2.a(companion2, 1.0f), 0.0f, 1, null);
                                                final QUIAlertDialogItem[] qUIAlertDialogItemArr4 = qUIAlertDialogItemArr3;
                                                RowKt.a(f19, null, null, null, null, ComposableLambdaKt.composableLambda(composer7, 1852879852, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt.QUIAlertDialog.4.2.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(n nVar3, Composer composer8, Integer num4) {
                                                        Object first;
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1852879852, intValue4, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QUIAlertDialog.kt:136)");
                                                            }
                                                            first = ArraysKt___ArraysKt.first(qUIAlertDialogItemArr4);
                                                            QUIAlertDialogKt.access$AlertDialogItem((QUIAlertDialogItem) first, composer9, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 196616, 30);
                                                i f26 = ComposeLayoutPropUpdaterKt.f(nVar2.a(companion2, 1.0f), 0.0f, 1, null);
                                                final QUIAlertDialogItem[] qUIAlertDialogItemArr5 = qUIAlertDialogItemArr3;
                                                RowKt.a(f26, null, null, null, null, ComposableLambdaKt.composableLambda(composer7, -1167162475, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt.QUIAlertDialog.4.2.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(n nVar3, Composer composer8, Integer num4) {
                                                        Object last;
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1167162475, intValue4, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QUIAlertDialog.kt:139)");
                                                            }
                                                            last = ArraysKt___ArraysKt.last(qUIAlertDialogItemArr5);
                                                            QUIAlertDialogKt.access$AlertDialogItem((QUIAlertDialogItem) last, composer9, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 196616, 30);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 196616, 30);
                                    composer5.endReplaceableGroup();
                                } else {
                                    composer5.startReplaceableGroup(708031316);
                                    QUIAlertDialogItem[] qUIAlertDialogItemArr4 = qUIAlertDialogItemArr2;
                                    int i19 = 0;
                                    for (int length = qUIAlertDialogItemArr4.length; i19 < length; length = length) {
                                        final QUIAlertDialogItem qUIAlertDialogItem = qUIAlertDialogItemArr4[i19];
                                        i.Companion companion2 = i.INSTANCE;
                                        DividerKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), f18), QUIToken.color$default("border_standard")), null, 0.0f, 0.0f, 0.0f, composer5, 8, 30);
                                        RowKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), 54.0f), null, null, null, null, ComposableLambdaKt.composableLambda(composer5, 397850328, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt$QUIAlertDialog$4$2$3$1
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(n nVar, Composer composer6, Integer num3) {
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(397850328, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QUIAlertDialog.kt:146)");
                                                    }
                                                    QUIAlertDialogKt.access$AlertDialogItem(QUIAlertDialogItem.this, composer7, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer5, 196616, 30);
                                        i19++;
                                        f18 = f18;
                                    }
                                    composer5.endReplaceableGroup();
                                }
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
        }), startRestartGroup, (i3 & 14) | 113274416, 6, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final String str5 = str3;
        final Function3<? super Float, ? super Composer, ? super Integer, Unit> function34 = function32;
        final Function0<Unit> function07 = function03;
        final Function0<Unit> function08 = function04;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIAlertDialogKt$QUIAlertDialog$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QUIAlertDialogKt.QUIAlertDialog(z16, str5, str2, function34, qUIAlertDialogItemArr, function07, function08, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
