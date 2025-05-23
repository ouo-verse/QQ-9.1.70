package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class RenameDialogKt {
    public static final void RenameDialog(final String str, final Function1<? super String, Unit> function1, final Function1<? super ClickParams, Unit> function12, final Function1<? super ClickParams, Unit> function13, Composer composer, final int i3) {
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1548106920);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(function1) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i16 |= startRestartGroup.changed(function12) ? 256 : 128;
        }
        if ((i3 & 7168) == 0) {
            i16 |= startRestartGroup.changed(function13) ? 2048 : 1024;
        }
        final int i17 = i16;
        if ((i17 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1548106920, i17, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialog (RenameDialog.kt:31)");
            }
            final StateHolder stateHolder = new StateHolder("");
            final StateHolder stateHolder2 = new StateHolder(Float.valueOf(317.0f));
            final StateHolder stateHolder3 = new StateHolder(Boolean.FALSE);
            final i j3 = ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 296.0f), 178.0f), QUIToken.color$default("bg_top_light")), 6.0f);
            ModalKt.a(null, false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1446538666, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialogKt$RenameDialog$1
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
                            ComposerKt.traceEventStart(-1446538666, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialog.<anonymous> (RenameDialog.kt:46)");
                        }
                        i d16 = ViewEventPropUpdaterKt.d(ModifiersKt.c(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), h.INSTANCE.j()), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialogKt$RenameDialog$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                return Unit.INSTANCE;
                            }
                        }, 3, null);
                        Alignment alignment = Alignment.BottomCenter;
                        final StateHolder<Float> stateHolder4 = stateHolder2;
                        final i iVar = j3;
                        final StateHolder<Boolean> stateHolder5 = stateHolder3;
                        final String str2 = str;
                        final StateHolder<String> stateHolder6 = stateHolder;
                        final Function1<String, Unit> function14 = function1;
                        final int i18 = i17;
                        final Function1<ClickParams, Unit> function15 = function13;
                        final Function1<ClickParams, Unit> function16 = function12;
                        BoxKt.a(d16, alignment, null, ComposableLambdaKt.composableLambda(composer3, 145082896, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialogKt$RenameDialog$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                        ComposerKt.traceEventStart(145082896, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialog.<anonymous>.<anonymous> (RenameDialog.kt:55)");
                                    }
                                    Float value = stateHolder4._state.getValue();
                                    i n3 = ComposeLayoutPropUpdaterKt.n(iVar, 0.0f, 0.0f, 0.0f, value != null ? value.floatValue() : 0.0f, 7, null);
                                    final StateHolder<Boolean> stateHolder7 = stateHolder5;
                                    final String str3 = str2;
                                    final StateHolder<String> stateHolder8 = stateHolder6;
                                    final Function1<String, Unit> function17 = function14;
                                    final int i19 = i18;
                                    final StateHolder<Float> stateHolder9 = stateHolder4;
                                    final Function1<ClickParams, Unit> function18 = function15;
                                    final Function1<ClickParams, Unit> function19 = function16;
                                    BoxKt.a(n3, null, null, ComposableLambdaKt.composableLambda(composer5, -1409577910, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialogKt.RenameDialog.1.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar2, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1409577910, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialog.<anonymous>.<anonymous>.<anonymous> (RenameDialog.kt:63)");
                                                }
                                                ColumnKt.a(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(composer7, -224895757, true, new Function3<d, Composer, Integer, Unit>(stateHolder7, str3, stateHolder8, function17, i19, stateHolder9, function18, function19) { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialogKt.RenameDialog.1.2.2.1
                                                    public final /* synthetic */ StateHolder<Boolean> $hasCleaned;
                                                    public final /* synthetic */ StateHolder<Float> $keyboardMarginBottom;
                                                    public final /* synthetic */ Function1<ClickParams, Unit> $onCancelClick;
                                                    public final /* synthetic */ Function1<ClickParams, Unit> $onConfirmClick;
                                                    public final /* synthetic */ Function1<String, Unit> $onTextChange;
                                                    public final /* synthetic */ String $originalName;
                                                    public final /* synthetic */ StateHolder<String> $textTemp;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                        this.$keyboardMarginBottom = r6;
                                                        this.$onCancelClick = r7;
                                                        this.$onConfirmClick = r8;
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(d dVar, Composer composer8, Integer num4) {
                                                        String str4;
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-224895757, intValue4, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RenameDialog.kt:67)");
                                                            }
                                                            c f16 = c.INSTANCE.f();
                                                            h color$default = QUIToken.color$default("text_primary");
                                                            i.Companion companion = i.INSTANCE;
                                                            TextKt.a("\u7f16\u8f91\u540d\u79f0", ComposeLayoutPropUpdaterKt.s(companion, 0.0f, 24.0f, 0.0f, 12.0f, 5, null), null, color$default, Float.valueOf(17.0f), null, f16, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1601606, 48, 0, 134215588);
                                                            if (Intrinsics.areEqual(this.$hasCleaned._state.getValue(), Boolean.TRUE)) {
                                                                str4 = "";
                                                            } else {
                                                                str4 = this.$originalName;
                                                            }
                                                            final StateHolder<String> stateHolder10 = this.$textTemp;
                                                            final Function1<String, Unit> function110 = this.$onTextChange;
                                                            composer9.startReplaceableGroup(511388516);
                                                            boolean changed = composer9.changed(stateHolder10) | composer9.changed(function110);
                                                            Object rememberedValue = composer9.rememberedValue();
                                                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialogKt$RenameDialog$1$2$2$1$1$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(String str5) {
                                                                        String str6 = str5;
                                                                        stateHolder10._state.setValue(str6);
                                                                        function110.invoke(str6);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                composer9.updateRememberedValue(rememberedValue);
                                                            }
                                                            composer9.endReplaceableGroup();
                                                            Function1 function111 = (Function1) rememberedValue;
                                                            final StateHolder<Float> stateHolder11 = this.$keyboardMarginBottom;
                                                            composer9.startReplaceableGroup(1157296644);
                                                            boolean changed2 = composer9.changed(stateHolder11);
                                                            Object rememberedValue2 = composer9.rememberedValue();
                                                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue2 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialogKt$RenameDialog$1$2$2$1$2$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Float f17) {
                                                                        float floatValue = f17.floatValue();
                                                                        StateHolder<Float> stateHolder12 = stateHolder11;
                                                                        stateHolder12._state.setValue(Float.valueOf(floatValue));
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                composer9.updateRememberedValue(rememberedValue2);
                                                            }
                                                            composer9.endReplaceableGroup();
                                                            Function1 function112 = (Function1) rememberedValue2;
                                                            final StateHolder<Boolean> stateHolder12 = this.$hasCleaned;
                                                            composer9.startReplaceableGroup(1157296644);
                                                            boolean changed3 = composer9.changed(stateHolder12);
                                                            Object rememberedValue3 = composer9.rememberedValue();
                                                            if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue3 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialogKt$RenameDialog$1$2$2$1$3$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Boolean bool) {
                                                                        boolean booleanValue = bool.booleanValue();
                                                                        StateHolder<Boolean> stateHolder13 = stateHolder12;
                                                                        stateHolder13._state.setValue(Boolean.valueOf(booleanValue));
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                composer9.updateRememberedValue(rememberedValue3);
                                                            }
                                                            composer9.endReplaceableGroup();
                                                            EditTextFieldKt.EditTextField(null, str4, 0, "10\u5b57\u4ee5\u5185", function111, function112, (Function1) rememberedValue3, composer9, 3072, 5);
                                                            BoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 0.5f), 0.0f, 24.0f, 0.0f, 0.0f, 13, null), QUIToken.color$default("border_standard")), null, null, null, composer9, 8, 14);
                                                            a.e f17 = a.f339245a.f();
                                                            Alignment.Vertical c16 = Alignment.INSTANCE.c();
                                                            final Function1<ClickParams, Unit> function113 = this.$onCancelClick;
                                                            final StateHolder<String> stateHolder13 = this.$textTemp;
                                                            final Function1<ClickParams, Unit> function114 = this.$onConfirmClick;
                                                            RowKt.a(null, f17, c16, null, null, ComposableLambdaKt.composableLambda(composer9, -436848623, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialogKt.RenameDialog.1.2.2.1.4
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(n nVar, Composer composer10, Integer num5) {
                                                                    i d17;
                                                                    CharSequence trim;
                                                                    Composer composer11 = composer10;
                                                                    int intValue5 = num5.intValue();
                                                                    if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                        composer11.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-436848623, intValue5, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RenameDialog.kt:100)");
                                                                        }
                                                                        i.Companion companion2 = i.INSTANCE;
                                                                        BoxKt.a(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 148.0f), 54.0f), false, null, function113, 3, null), null, null, ComposableSingletons$RenameDialogKt.f26lambda1, composer11, 3080, 6);
                                                                        i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, 148.0f), 54.0f);
                                                                        StateHolder<String> stateHolder14 = stateHolder13;
                                                                        Function1<ClickParams, Unit> function115 = function114;
                                                                        String value2 = stateHolder14._state.getValue();
                                                                        boolean z16 = false;
                                                                        if (value2 != null) {
                                                                            trim = StringsKt__StringsKt.trim((CharSequence) value2);
                                                                            String obj = trim.toString();
                                                                            if (obj != null) {
                                                                                if (obj.length() == 0) {
                                                                                    z16 = true;
                                                                                }
                                                                            }
                                                                        }
                                                                        if (z16) {
                                                                            d17 = ViewEventPropUpdaterKt.d(ModifiersKt.b(k3, 0.3f), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialogKt$RenameDialog$1$2$2$1$4$1$1
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }, 3, null);
                                                                        } else {
                                                                            d17 = ViewEventPropUpdaterKt.d(ModifiersKt.b(k3, 1.0f), false, null, function115, 3, null);
                                                                        }
                                                                        BoxKt.a(d17, null, null, ComposableSingletons$RenameDialogKt.f27lambda2, composer11, 3080, 6);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer9, 196672, 25);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 24584, 10);
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
                        }), composer3, 3128, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 24576, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.RenameDialogKt$RenameDialog$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                RenameDialogKt.RenameDialog(str, function1, function12, function13, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
