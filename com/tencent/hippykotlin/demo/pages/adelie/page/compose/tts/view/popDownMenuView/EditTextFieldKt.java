package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.KeyboardParams;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextFieldKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class EditTextFieldKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void EditTextField(Float f16, String str, int i3, String str2, final Function1<? super String, Unit> function1, final Function1<? super Float, Unit> function12, final Function1<? super Boolean, Unit> function13, Composer composer, final int i16, final int i17) {
        Float f17;
        int i18;
        String str3;
        int i19;
        int i26;
        int i27;
        String str4;
        final Float f18;
        final String str5;
        final String str6;
        final int i28;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(2143265100);
        int i29 = i17 & 1;
        if (i29 != 0) {
            i18 = i16 | 6;
            f17 = f16;
        } else if ((i16 & 14) == 0) {
            f17 = f16;
            i18 = (startRestartGroup.changed(f17) ? 4 : 2) | i16;
        } else {
            f17 = f16;
            i18 = i16;
        }
        int i36 = i17 & 2;
        if (i36 != 0) {
            i18 |= 48;
        } else if ((i16 & 112) == 0) {
            str3 = str;
            i18 |= startRestartGroup.changed(str3) ? 32 : 16;
            i19 = i17 & 4;
            if (i19 == 0) {
                i18 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i16 & 896) == 0) {
                i26 = i3;
                i18 |= startRestartGroup.changed(i26) ? 256 : 128;
                i27 = i17 & 8;
                if (i27 != 0) {
                    i18 |= 3072;
                } else if ((i16 & 7168) == 0) {
                    str4 = str2;
                    i18 |= startRestartGroup.changed(str4) ? 2048 : 1024;
                    if ((i17 & 16) == 0) {
                        i18 |= 24576;
                    } else if ((57344 & i16) == 0) {
                        i18 |= startRestartGroup.changed(function1) ? 16384 : 8192;
                        if ((i17 & 32) != 0) {
                            i18 |= 196608;
                        } else if ((458752 & i16) == 0) {
                            i18 |= startRestartGroup.changed(function12) ? 131072 : 65536;
                        }
                        if ((i17 & 64) != 0) {
                            i18 |= 1572864;
                        } else if ((3670016 & i16) == 0) {
                            i18 |= startRestartGroup.changed(function13) ? 1048576 : 524288;
                        }
                        if ((2995931 & i18) != 599186 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            f18 = f17;
                            str6 = str3;
                            i28 = i26;
                            str5 = str4;
                        } else {
                            Float valueOf = i29 != 0 ? Float.valueOf(14.0f) : f17;
                            if (i36 != 0) {
                                str3 = "";
                            }
                            int i37 = i19 != 0 ? 10 : i26;
                            if (i27 != 0) {
                                str4 = "10\u5b57\u4ee5\u5185";
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2143265100, i18, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextField (EditTextField.kt:26)");
                            }
                            final StateHolder stateHolder = new StateHolder(str3);
                            final Float f19 = valueOf;
                            final int i38 = i18;
                            final int i39 = i37;
                            final String str7 = str4;
                            String str8 = str3;
                            BoxKt.a(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 256.0f), 44.0f), 4.0f), QUIToken.color$default("fill_standard_primary")), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1713931770, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1
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
                                            ComposerKt.traceEventStart(-1713931770, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextField.<anonymous> (EditTextField.kt:45)");
                                        }
                                        final StateHolder<String> stateHolder2 = StateHolder.this;
                                        final Float f26 = f19;
                                        final Function1<String, Unit> function14 = function1;
                                        final int i46 = i38;
                                        final int i47 = i39;
                                        final Function1<Float, Unit> function15 = function12;
                                        final Function1<Boolean, Unit> function16 = function13;
                                        final String str9 = str7;
                                        final float f27 = 60.0f;
                                        final float f28 = 317.0f;
                                        RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 1084516260, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            /* JADX WARN: Code restructure failed: missing block: B:29:0x0185, code lost:
                                            
                                                if ((r1.length() > 0) == true) goto L34;
                                             */
                                            @Override // kotlin.jvm.functions.Function3
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                                boolean z16;
                                                Composer composer5 = composer4;
                                                int intValue2 = num2.intValue();
                                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                                    composer5.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1084516260, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextField.<anonymous>.<anonymous> (EditTextField.kt:46)");
                                                    }
                                                    String value = stateHolder2._state.getValue();
                                                    if (value == null) {
                                                        value = "";
                                                    }
                                                    h color$default = QUIToken.color$default("brand_standard");
                                                    k kVar = new k(QUIToken.color$default("text_primary"), f26, c.INSTANCE.e(), null, null, null, null, null, ai.f(ai.INSTANCE.e()), null, null, null, null, null, 16120, null);
                                                    i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 226.0f), 44.0f), 12.0f, 12.0f, 0.0f, 12.0f, 4, null);
                                                    final StateHolder<String> stateHolder3 = stateHolder2;
                                                    final Function1<String, Unit> function17 = function14;
                                                    composer5.startReplaceableGroup(511388516);
                                                    boolean changed = composer5.changed(stateHolder3) | composer5.changed(function17);
                                                    Object rememberedValue = composer5.rememberedValue();
                                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1$1$1$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(String str10) {
                                                                String str11 = str10;
                                                                stateHolder3._state.setValue(str11);
                                                                function17.invoke(str11);
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        composer5.updateRememberedValue(rememberedValue);
                                                    }
                                                    composer5.endReplaceableGroup();
                                                    Function1 function18 = (Function1) rememberedValue;
                                                    final String str10 = str9;
                                                    final Float f29 = f26;
                                                    final int i48 = i46;
                                                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer5, -354551031, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt.EditTextField.1.1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Unit invoke(Composer composer6, Integer num3) {
                                                            Composer composer7 = composer6;
                                                            int intValue3 = num3.intValue();
                                                            if ((intValue3 & 11) == 2 && composer7.getSkipping()) {
                                                                composer7.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-354551031, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextField.<anonymous>.<anonymous>.<anonymous> (EditTextField.kt:69)");
                                                                }
                                                                c e16 = c.INSTANCE.e();
                                                                h color$default2 = QUIToken.color$default("text_tertiary");
                                                                String str11 = str10;
                                                                Float f36 = f29;
                                                                Float valueOf2 = Float.valueOf(20.0f);
                                                                int i49 = i48;
                                                                TextKt.a(str11, null, null, color$default2, f36, null, e16, null, null, null, null, valueOf2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i49 >> 9) & 14) | 1576960 | ((i49 << 12) & 57344), 48, 0, 134215590);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    Integer valueOf2 = Integer.valueOf(i47);
                                                    Boolean bool = Boolean.FALSE;
                                                    AnonymousClass3 anonymousClass3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt.EditTextField.1.1.3
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u5b57\u6570\u5df2\u8fbe\u5230\u4e0a\u9650", QToastMode.Info);
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    Object obj = function15;
                                                    Object valueOf3 = Float.valueOf(f27);
                                                    Object valueOf4 = Float.valueOf(f28);
                                                    final Function1<Float, Unit> function19 = function15;
                                                    final float f36 = f27;
                                                    final float f37 = f28;
                                                    composer5.startReplaceableGroup(1618982084);
                                                    boolean changed2 = composer5.changed(valueOf4) | composer5.changed(valueOf3) | composer5.changed(obj);
                                                    Object rememberedValue2 = composer5.rememberedValue();
                                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue2 = new Function1<KeyboardParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1$1$4$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(KeyboardParams keyboardParams) {
                                                                KeyboardParams keyboardParams2 = keyboardParams;
                                                                if (keyboardParams2.getHeight() > 0.0f) {
                                                                    function19.invoke(Float.valueOf(keyboardParams2.getHeight() + f36));
                                                                } else {
                                                                    function19.invoke(Float.valueOf(f37));
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        composer5.updateRememberedValue(rememberedValue2);
                                                    }
                                                    composer5.endReplaceableGroup();
                                                    TextFieldKt.a(value, null, function18, s16, null, kVar, true, composableLambda, color$default, null, null, valueOf2, bool, anonymousClass3, null, false, (Function1) rememberedValue2, null, false, null, null, false, composer5, (k.f28903n << 15) | 148377600, ((i46 >> 3) & 112) | 3456, 0, 4113938);
                                                    String value2 = stateHolder2._state.getValue();
                                                    if (value2 != null) {
                                                        z16 = true;
                                                    }
                                                    z16 = false;
                                                    if (z16) {
                                                        final StateHolder<String> stateHolder4 = stateHolder2;
                                                        final Function1<String, Unit> function110 = function14;
                                                        final Function1<Boolean, Unit> function111 = function16;
                                                        composer5.startReplaceableGroup(1618982084);
                                                        boolean changed3 = composer5.changed(stateHolder4) | composer5.changed(function110) | composer5.changed(function111);
                                                        Object rememberedValue3 = composer5.rememberedValue();
                                                        if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1$1$5$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    stateHolder4._state.setValue("");
                                                                    function110.invoke("");
                                                                    function111.invoke(Boolean.TRUE);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            composer5.updateRememberedValue(rememberedValue3);
                                                        }
                                                        composer5.endReplaceableGroup();
                                                        EditTextFieldKt.access$ClearButton((Function1) rememberedValue3, composer5, 0);
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer3, 196608, 31);
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
                            f18 = valueOf;
                            str5 = str4;
                            str6 = str8;
                            i28 = i37;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                            return;
                        }
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer2, Integer num) {
                                num.intValue();
                                EditTextFieldKt.EditTextField(f18, str6, i28, str5, function1, function12, function13, composer2, i16 | 1, i17);
                                return Unit.INSTANCE;
                            }
                        });
                        return;
                    }
                    if ((i17 & 32) != 0) {
                    }
                    if ((i17 & 64) != 0) {
                    }
                    if ((2995931 & i18) != 599186) {
                    }
                    if (i29 != 0) {
                    }
                    if (i36 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i27 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final StateHolder stateHolder2 = new StateHolder(str3);
                    final Float f192 = valueOf;
                    final int i382 = i18;
                    final int i392 = i37;
                    final String str72 = str4;
                    String str82 = str3;
                    BoxKt.a(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 256.0f), 44.0f), 4.0f), QUIToken.color$default("fill_standard_primary")), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1713931770, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1
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
                                    ComposerKt.traceEventStart(-1713931770, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextField.<anonymous> (EditTextField.kt:45)");
                                }
                                final StateHolder<String> stateHolder22 = StateHolder.this;
                                final Float f26 = f192;
                                final Function1<? super String, Unit> function14 = function1;
                                final int i46 = i382;
                                final int i47 = i392;
                                final Function1<? super Float, Unit> function15 = function12;
                                final Function1<? super Boolean, Unit> function16 = function13;
                                final String str9 = str72;
                                final float f27 = 60.0f;
                                final float f28 = 317.0f;
                                RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 1084516260, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:29:0x0185, code lost:
                                    
                                        if ((r1.length() > 0) == true) goto L34;
                                     */
                                    @Override // kotlin.jvm.functions.Function3
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                        boolean z16;
                                        Composer composer5 = composer4;
                                        int intValue2 = num2.intValue();
                                        if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1084516260, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextField.<anonymous>.<anonymous> (EditTextField.kt:46)");
                                            }
                                            String value = stateHolder22._state.getValue();
                                            if (value == null) {
                                                value = "";
                                            }
                                            h color$default = QUIToken.color$default("brand_standard");
                                            k kVar = new k(QUIToken.color$default("text_primary"), f26, c.INSTANCE.e(), null, null, null, null, null, ai.f(ai.INSTANCE.e()), null, null, null, null, null, 16120, null);
                                            i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 226.0f), 44.0f), 12.0f, 12.0f, 0.0f, 12.0f, 4, null);
                                            final StateHolder<String> stateHolder3 = stateHolder22;
                                            final Function1<? super String, Unit> function17 = function14;
                                            composer5.startReplaceableGroup(511388516);
                                            boolean changed = composer5.changed(stateHolder3) | composer5.changed(function17);
                                            Object rememberedValue = composer5.rememberedValue();
                                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(String str10) {
                                                        String str11 = str10;
                                                        stateHolder3._state.setValue(str11);
                                                        function17.invoke(str11);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer5.updateRememberedValue(rememberedValue);
                                            }
                                            composer5.endReplaceableGroup();
                                            Function1 function18 = (Function1) rememberedValue;
                                            final String str10 = str9;
                                            final Float f29 = f26;
                                            final int i48 = i46;
                                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer5, -354551031, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt.EditTextField.1.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Unit invoke(Composer composer6, Integer num3) {
                                                    Composer composer7 = composer6;
                                                    int intValue3 = num3.intValue();
                                                    if ((intValue3 & 11) == 2 && composer7.getSkipping()) {
                                                        composer7.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-354551031, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextField.<anonymous>.<anonymous>.<anonymous> (EditTextField.kt:69)");
                                                        }
                                                        c e16 = c.INSTANCE.e();
                                                        h color$default2 = QUIToken.color$default("text_tertiary");
                                                        String str11 = str10;
                                                        Float f36 = f29;
                                                        Float valueOf2 = Float.valueOf(20.0f);
                                                        int i49 = i48;
                                                        TextKt.a(str11, null, null, color$default2, f36, null, e16, null, null, null, null, valueOf2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i49 >> 9) & 14) | 1576960 | ((i49 << 12) & 57344), 48, 0, 134215590);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            Integer valueOf2 = Integer.valueOf(i47);
                                            Boolean bool = Boolean.FALSE;
                                            AnonymousClass3 anonymousClass3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt.EditTextField.1.1.3
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u5b57\u6570\u5df2\u8fbe\u5230\u4e0a\u9650", QToastMode.Info);
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            Object obj = function15;
                                            Object valueOf3 = Float.valueOf(f27);
                                            Object valueOf4 = Float.valueOf(f28);
                                            final Function1<? super Float, Unit> function19 = function15;
                                            final float f36 = f27;
                                            final float f37 = f28;
                                            composer5.startReplaceableGroup(1618982084);
                                            boolean changed2 = composer5.changed(valueOf4) | composer5.changed(valueOf3) | composer5.changed(obj);
                                            Object rememberedValue2 = composer5.rememberedValue();
                                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = new Function1<KeyboardParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1$1$4$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(KeyboardParams keyboardParams) {
                                                        KeyboardParams keyboardParams2 = keyboardParams;
                                                        if (keyboardParams2.getHeight() > 0.0f) {
                                                            function19.invoke(Float.valueOf(keyboardParams2.getHeight() + f36));
                                                        } else {
                                                            function19.invoke(Float.valueOf(f37));
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer5.updateRememberedValue(rememberedValue2);
                                            }
                                            composer5.endReplaceableGroup();
                                            TextFieldKt.a(value, null, function18, s16, null, kVar, true, composableLambda, color$default, null, null, valueOf2, bool, anonymousClass3, null, false, (Function1) rememberedValue2, null, false, null, null, false, composer5, (k.f28903n << 15) | 148377600, ((i46 >> 3) & 112) | 3456, 0, 4113938);
                                            String value2 = stateHolder22._state.getValue();
                                            if (value2 != null) {
                                                z16 = true;
                                            }
                                            z16 = false;
                                            if (z16) {
                                                final StateHolder<String> stateHolder4 = stateHolder22;
                                                final Function1<? super String, Unit> function110 = function14;
                                                final Function1<? super Boolean, Unit> function111 = function16;
                                                composer5.startReplaceableGroup(1618982084);
                                                boolean changed3 = composer5.changed(stateHolder4) | composer5.changed(function110) | composer5.changed(function111);
                                                Object rememberedValue3 = composer5.rememberedValue();
                                                if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1$1$5$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            stateHolder4._state.setValue("");
                                                            function110.invoke("");
                                                            function111.invoke(Boolean.TRUE);
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer5.updateRememberedValue(rememberedValue3);
                                                }
                                                composer5.endReplaceableGroup();
                                                EditTextFieldKt.access$ClearButton((Function1) rememberedValue3, composer5, 0);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer3, 196608, 31);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), startRestartGroup, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f18 = valueOf;
                    str5 = str4;
                    str6 = str82;
                    i28 = i37;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                str4 = str2;
                if ((i17 & 16) == 0) {
                }
                if ((i17 & 32) != 0) {
                }
                if ((i17 & 64) != 0) {
                }
                if ((2995931 & i18) != 599186) {
                }
                if (i29 != 0) {
                }
                if (i36 != 0) {
                }
                if (i19 != 0) {
                }
                if (i27 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                final StateHolder stateHolder22 = new StateHolder(str3);
                final Float f1922 = valueOf;
                final int i3822 = i18;
                final int i3922 = i37;
                final String str722 = str4;
                String str822 = str3;
                BoxKt.a(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 256.0f), 44.0f), 4.0f), QUIToken.color$default("fill_standard_primary")), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1713931770, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1
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
                                ComposerKt.traceEventStart(-1713931770, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextField.<anonymous> (EditTextField.kt:45)");
                            }
                            final StateHolder<String> stateHolder222 = StateHolder.this;
                            final Float f26 = f1922;
                            final Function1<? super String, Unit> function14 = function1;
                            final int i46 = i3822;
                            final int i47 = i3922;
                            final Function1<? super Float, Unit> function15 = function12;
                            final Function1<? super Boolean, Unit> function16 = function13;
                            final String str9 = str722;
                            final float f27 = 60.0f;
                            final float f28 = 317.0f;
                            RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 1084516260, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                /* JADX WARN: Code restructure failed: missing block: B:29:0x0185, code lost:
                                
                                    if ((r1.length() > 0) == true) goto L34;
                                 */
                                @Override // kotlin.jvm.functions.Function3
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                    boolean z16;
                                    Composer composer5 = composer4;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1084516260, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextField.<anonymous>.<anonymous> (EditTextField.kt:46)");
                                        }
                                        String value = stateHolder222._state.getValue();
                                        if (value == null) {
                                            value = "";
                                        }
                                        h color$default = QUIToken.color$default("brand_standard");
                                        k kVar = new k(QUIToken.color$default("text_primary"), f26, c.INSTANCE.e(), null, null, null, null, null, ai.f(ai.INSTANCE.e()), null, null, null, null, null, 16120, null);
                                        i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 226.0f), 44.0f), 12.0f, 12.0f, 0.0f, 12.0f, 4, null);
                                        final StateHolder<String> stateHolder3 = stateHolder222;
                                        final Function1<? super String, Unit> function17 = function14;
                                        composer5.startReplaceableGroup(511388516);
                                        boolean changed = composer5.changed(stateHolder3) | composer5.changed(function17);
                                        Object rememberedValue = composer5.rememberedValue();
                                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1$1$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(String str10) {
                                                    String str11 = str10;
                                                    stateHolder3._state.setValue(str11);
                                                    function17.invoke(str11);
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer5.updateRememberedValue(rememberedValue);
                                        }
                                        composer5.endReplaceableGroup();
                                        Function1 function18 = (Function1) rememberedValue;
                                        final String str10 = str9;
                                        final Float f29 = f26;
                                        final int i48 = i46;
                                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer5, -354551031, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt.EditTextField.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(Composer composer6, Integer num3) {
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 11) == 2 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-354551031, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextField.<anonymous>.<anonymous>.<anonymous> (EditTextField.kt:69)");
                                                    }
                                                    c e16 = c.INSTANCE.e();
                                                    h color$default2 = QUIToken.color$default("text_tertiary");
                                                    String str11 = str10;
                                                    Float f36 = f29;
                                                    Float valueOf2 = Float.valueOf(20.0f);
                                                    int i49 = i48;
                                                    TextKt.a(str11, null, null, color$default2, f36, null, e16, null, null, null, null, valueOf2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i49 >> 9) & 14) | 1576960 | ((i49 << 12) & 57344), 48, 0, 134215590);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        Integer valueOf2 = Integer.valueOf(i47);
                                        Boolean bool = Boolean.FALSE;
                                        AnonymousClass3 anonymousClass3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt.EditTextField.1.1.3
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u5b57\u6570\u5df2\u8fbe\u5230\u4e0a\u9650", QToastMode.Info);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        Object obj = function15;
                                        Object valueOf3 = Float.valueOf(f27);
                                        Object valueOf4 = Float.valueOf(f28);
                                        final Function1<? super Float, Unit> function19 = function15;
                                        final float f36 = f27;
                                        final float f37 = f28;
                                        composer5.startReplaceableGroup(1618982084);
                                        boolean changed2 = composer5.changed(valueOf4) | composer5.changed(valueOf3) | composer5.changed(obj);
                                        Object rememberedValue2 = composer5.rememberedValue();
                                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = new Function1<KeyboardParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1$1$4$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(KeyboardParams keyboardParams) {
                                                    KeyboardParams keyboardParams2 = keyboardParams;
                                                    if (keyboardParams2.getHeight() > 0.0f) {
                                                        function19.invoke(Float.valueOf(keyboardParams2.getHeight() + f36));
                                                    } else {
                                                        function19.invoke(Float.valueOf(f37));
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer5.updateRememberedValue(rememberedValue2);
                                        }
                                        composer5.endReplaceableGroup();
                                        TextFieldKt.a(value, null, function18, s16, null, kVar, true, composableLambda, color$default, null, null, valueOf2, bool, anonymousClass3, null, false, (Function1) rememberedValue2, null, false, null, null, false, composer5, (k.f28903n << 15) | 148377600, ((i46 >> 3) & 112) | 3456, 0, 4113938);
                                        String value2 = stateHolder222._state.getValue();
                                        if (value2 != null) {
                                            z16 = true;
                                        }
                                        z16 = false;
                                        if (z16) {
                                            final StateHolder<String> stateHolder4 = stateHolder222;
                                            final Function1<? super String, Unit> function110 = function14;
                                            final Function1<? super Boolean, Unit> function111 = function16;
                                            composer5.startReplaceableGroup(1618982084);
                                            boolean changed3 = composer5.changed(stateHolder4) | composer5.changed(function110) | composer5.changed(function111);
                                            Object rememberedValue3 = composer5.rememberedValue();
                                            if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1$1$5$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        stateHolder4._state.setValue("");
                                                        function110.invoke("");
                                                        function111.invoke(Boolean.TRUE);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer5.updateRememberedValue(rememberedValue3);
                                            }
                                            composer5.endReplaceableGroup();
                                            EditTextFieldKt.access$ClearButton((Function1) rememberedValue3, composer5, 0);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 196608, 31);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 3080, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
                f18 = valueOf;
                str5 = str4;
                str6 = str822;
                i28 = i37;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i26 = i3;
            i27 = i17 & 8;
            if (i27 != 0) {
            }
            str4 = str2;
            if ((i17 & 16) == 0) {
            }
            if ((i17 & 32) != 0) {
            }
            if ((i17 & 64) != 0) {
            }
            if ((2995931 & i18) != 599186) {
            }
            if (i29 != 0) {
            }
            if (i36 != 0) {
            }
            if (i19 != 0) {
            }
            if (i27 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            final StateHolder stateHolder222 = new StateHolder(str3);
            final Float f19222 = valueOf;
            final int i38222 = i18;
            final int i39222 = i37;
            final String str7222 = str4;
            String str8222 = str3;
            BoxKt.a(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 256.0f), 44.0f), 4.0f), QUIToken.color$default("fill_standard_primary")), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1713931770, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1
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
                            ComposerKt.traceEventStart(-1713931770, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextField.<anonymous> (EditTextField.kt:45)");
                        }
                        final StateHolder<String> stateHolder2222 = StateHolder.this;
                        final Float f26 = f19222;
                        final Function1<? super String, Unit> function14 = function1;
                        final int i46 = i38222;
                        final int i47 = i39222;
                        final Function1<? super Float, Unit> function15 = function12;
                        final Function1<? super Boolean, Unit> function16 = function13;
                        final String str9 = str7222;
                        final float f27 = 60.0f;
                        final float f28 = 317.0f;
                        RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 1084516260, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:29:0x0185, code lost:
                            
                                if ((r1.length() > 0) == true) goto L34;
                             */
                            @Override // kotlin.jvm.functions.Function3
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                boolean z16;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1084516260, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextField.<anonymous>.<anonymous> (EditTextField.kt:46)");
                                    }
                                    String value = stateHolder2222._state.getValue();
                                    if (value == null) {
                                        value = "";
                                    }
                                    h color$default = QUIToken.color$default("brand_standard");
                                    k kVar = new k(QUIToken.color$default("text_primary"), f26, c.INSTANCE.e(), null, null, null, null, null, ai.f(ai.INSTANCE.e()), null, null, null, null, null, 16120, null);
                                    i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 226.0f), 44.0f), 12.0f, 12.0f, 0.0f, 12.0f, 4, null);
                                    final StateHolder<String> stateHolder3 = stateHolder2222;
                                    final Function1<? super String, Unit> function17 = function14;
                                    composer5.startReplaceableGroup(511388516);
                                    boolean changed = composer5.changed(stateHolder3) | composer5.changed(function17);
                                    Object rememberedValue = composer5.rememberedValue();
                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(String str10) {
                                                String str11 = str10;
                                                stateHolder3._state.setValue(str11);
                                                function17.invoke(str11);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue);
                                    }
                                    composer5.endReplaceableGroup();
                                    Function1 function18 = (Function1) rememberedValue;
                                    final String str10 = str9;
                                    final Float f29 = f26;
                                    final int i48 = i46;
                                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer5, -354551031, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt.EditTextField.1.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 11) == 2 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-354551031, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextField.<anonymous>.<anonymous>.<anonymous> (EditTextField.kt:69)");
                                                }
                                                c e16 = c.INSTANCE.e();
                                                h color$default2 = QUIToken.color$default("text_tertiary");
                                                String str11 = str10;
                                                Float f36 = f29;
                                                Float valueOf2 = Float.valueOf(20.0f);
                                                int i49 = i48;
                                                TextKt.a(str11, null, null, color$default2, f36, null, e16, null, null, null, null, valueOf2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i49 >> 9) & 14) | 1576960 | ((i49 << 12) & 57344), 48, 0, 134215590);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    Integer valueOf2 = Integer.valueOf(i47);
                                    Boolean bool = Boolean.FALSE;
                                    AnonymousClass3 anonymousClass3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt.EditTextField.1.1.3
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u5b57\u6570\u5df2\u8fbe\u5230\u4e0a\u9650", QToastMode.Info);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    Object obj = function15;
                                    Object valueOf3 = Float.valueOf(f27);
                                    Object valueOf4 = Float.valueOf(f28);
                                    final Function1<? super Float, Unit> function19 = function15;
                                    final float f36 = f27;
                                    final float f37 = f28;
                                    composer5.startReplaceableGroup(1618982084);
                                    boolean changed2 = composer5.changed(valueOf4) | composer5.changed(valueOf3) | composer5.changed(obj);
                                    Object rememberedValue2 = composer5.rememberedValue();
                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new Function1<KeyboardParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1$1$4$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(KeyboardParams keyboardParams) {
                                                KeyboardParams keyboardParams2 = keyboardParams;
                                                if (keyboardParams2.getHeight() > 0.0f) {
                                                    function19.invoke(Float.valueOf(keyboardParams2.getHeight() + f36));
                                                } else {
                                                    function19.invoke(Float.valueOf(f37));
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue2);
                                    }
                                    composer5.endReplaceableGroup();
                                    TextFieldKt.a(value, null, function18, s16, null, kVar, true, composableLambda, color$default, null, null, valueOf2, bool, anonymousClass3, null, false, (Function1) rememberedValue2, null, false, null, null, false, composer5, (k.f28903n << 15) | 148377600, ((i46 >> 3) & 112) | 3456, 0, 4113938);
                                    String value2 = stateHolder2222._state.getValue();
                                    if (value2 != null) {
                                        z16 = true;
                                    }
                                    z16 = false;
                                    if (z16) {
                                        final StateHolder<String> stateHolder4 = stateHolder2222;
                                        final Function1<? super String, Unit> function110 = function14;
                                        final Function1<? super Boolean, Unit> function111 = function16;
                                        composer5.startReplaceableGroup(1618982084);
                                        boolean changed3 = composer5.changed(stateHolder4) | composer5.changed(function110) | composer5.changed(function111);
                                        Object rememberedValue3 = composer5.rememberedValue();
                                        if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1$1$5$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    stateHolder4._state.setValue("");
                                                    function110.invoke("");
                                                    function111.invoke(Boolean.TRUE);
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer5.updateRememberedValue(rememberedValue3);
                                        }
                                        composer5.endReplaceableGroup();
                                        EditTextFieldKt.access$ClearButton((Function1) rememberedValue3, composer5, 0);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196608, 31);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3080, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
            f18 = valueOf;
            str5 = str4;
            str6 = str8222;
            i28 = i37;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        str3 = str;
        i19 = i17 & 4;
        if (i19 == 0) {
        }
        i26 = i3;
        i27 = i17 & 8;
        if (i27 != 0) {
        }
        str4 = str2;
        if ((i17 & 16) == 0) {
        }
        if ((i17 & 32) != 0) {
        }
        if ((i17 & 64) != 0) {
        }
        if ((2995931 & i18) != 599186) {
        }
        if (i29 != 0) {
        }
        if (i36 != 0) {
        }
        if (i19 != 0) {
        }
        if (i27 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        final StateHolder stateHolder2222 = new StateHolder(str3);
        final Float f192222 = valueOf;
        final int i382222 = i18;
        final int i392222 = i37;
        final String str72222 = str4;
        String str82222 = str3;
        BoxKt.a(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 256.0f), 44.0f), 4.0f), QUIToken.color$default("fill_standard_primary")), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1713931770, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1
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
                        ComposerKt.traceEventStart(-1713931770, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextField.<anonymous> (EditTextField.kt:45)");
                    }
                    final StateHolder<String> stateHolder22222 = StateHolder.this;
                    final Float f26 = f192222;
                    final Function1<? super String, Unit> function14 = function1;
                    final int i46 = i382222;
                    final int i47 = i392222;
                    final Function1<? super Float, Unit> function15 = function12;
                    final Function1<? super Boolean, Unit> function16 = function13;
                    final String str9 = str72222;
                    final float f27 = 60.0f;
                    final float f28 = 317.0f;
                    RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 1084516260, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:29:0x0185, code lost:
                        
                            if ((r1.length() > 0) == true) goto L34;
                         */
                        @Override // kotlin.jvm.functions.Function3
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            boolean z16;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1084516260, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextField.<anonymous>.<anonymous> (EditTextField.kt:46)");
                                }
                                String value = stateHolder22222._state.getValue();
                                if (value == null) {
                                    value = "";
                                }
                                h color$default = QUIToken.color$default("brand_standard");
                                k kVar = new k(QUIToken.color$default("text_primary"), f26, c.INSTANCE.e(), null, null, null, null, null, ai.f(ai.INSTANCE.e()), null, null, null, null, null, 16120, null);
                                i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 226.0f), 44.0f), 12.0f, 12.0f, 0.0f, 12.0f, 4, null);
                                final StateHolder<String> stateHolder3 = stateHolder22222;
                                final Function1<? super String, Unit> function17 = function14;
                                composer5.startReplaceableGroup(511388516);
                                boolean changed = composer5.changed(stateHolder3) | composer5.changed(function17);
                                Object rememberedValue = composer5.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(String str10) {
                                            String str11 = str10;
                                            stateHolder3._state.setValue(str11);
                                            function17.invoke(str11);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue);
                                }
                                composer5.endReplaceableGroup();
                                Function1 function18 = (Function1) rememberedValue;
                                final String str10 = str9;
                                final Float f29 = f26;
                                final int i48 = i46;
                                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer5, -354551031, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt.EditTextField.1.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 11) == 2 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-354551031, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextField.<anonymous>.<anonymous>.<anonymous> (EditTextField.kt:69)");
                                            }
                                            c e16 = c.INSTANCE.e();
                                            h color$default2 = QUIToken.color$default("text_tertiary");
                                            String str11 = str10;
                                            Float f36 = f29;
                                            Float valueOf2 = Float.valueOf(20.0f);
                                            int i49 = i48;
                                            TextKt.a(str11, null, null, color$default2, f36, null, e16, null, null, null, null, valueOf2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, ((i49 >> 9) & 14) | 1576960 | ((i49 << 12) & 57344), 48, 0, 134215590);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                Integer valueOf2 = Integer.valueOf(i47);
                                Boolean bool = Boolean.FALSE;
                                AnonymousClass3 anonymousClass3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt.EditTextField.1.1.3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u5b57\u6570\u5df2\u8fbe\u5230\u4e0a\u9650", QToastMode.Info);
                                        return Unit.INSTANCE;
                                    }
                                };
                                Object obj = function15;
                                Object valueOf3 = Float.valueOf(f27);
                                Object valueOf4 = Float.valueOf(f28);
                                final Function1<? super Float, Unit> function19 = function15;
                                final float f36 = f27;
                                final float f37 = f28;
                                composer5.startReplaceableGroup(1618982084);
                                boolean changed2 = composer5.changed(valueOf4) | composer5.changed(valueOf3) | composer5.changed(obj);
                                Object rememberedValue2 = composer5.rememberedValue();
                                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new Function1<KeyboardParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1$1$4$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(KeyboardParams keyboardParams) {
                                            KeyboardParams keyboardParams2 = keyboardParams;
                                            if (keyboardParams2.getHeight() > 0.0f) {
                                                function19.invoke(Float.valueOf(keyboardParams2.getHeight() + f36));
                                            } else {
                                                function19.invoke(Float.valueOf(f37));
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue2);
                                }
                                composer5.endReplaceableGroup();
                                TextFieldKt.a(value, null, function18, s16, null, kVar, true, composableLambda, color$default, null, null, valueOf2, bool, anonymousClass3, null, false, (Function1) rememberedValue2, null, false, null, null, false, composer5, (k.f28903n << 15) | 148377600, ((i46 >> 3) & 112) | 3456, 0, 4113938);
                                String value2 = stateHolder22222._state.getValue();
                                if (value2 != null) {
                                    z16 = true;
                                }
                                z16 = false;
                                if (z16) {
                                    final StateHolder<String> stateHolder4 = stateHolder22222;
                                    final Function1<? super String, Unit> function110 = function14;
                                    final Function1<? super Boolean, Unit> function111 = function16;
                                    composer5.startReplaceableGroup(1618982084);
                                    boolean changed3 = composer5.changed(stateHolder4) | composer5.changed(function110) | composer5.changed(function111);
                                    Object rememberedValue3 = composer5.rememberedValue();
                                    if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$EditTextField$1$1$5$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                stateHolder4._state.setValue("");
                                                function110.invoke("");
                                                function111.invoke(Boolean.TRUE);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue3);
                                    }
                                    composer5.endReplaceableGroup();
                                    EditTextFieldKt.access$ClearButton((Function1) rememberedValue3, composer5, 0);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196608, 31);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        f18 = valueOf;
        str5 = str4;
        str6 = str82222;
        i28 = i37;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final void access$ClearButton(final Function1 function1, Composer composer, final int i3) {
        int i16;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(514712119);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(function1) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(514712119, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.ClearButton (EditTextField.kt:103)");
            }
            String image = QUIToken.INSTANCE.image("close_filled", QUIToken.color$default("icon_secondary"));
            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.s(i.INSTANCE, 0.0f, 14.0f, 12.0f, 14.0f, 1, null), 16.0f), 16.0f);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(function1);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$ClearButton$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        function1.invoke(clickParams);
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            ImageKt.a(null, null, null, null, null, ViewEventPropUpdaterKt.d(k3, false, null, (Function1) rememberedValue, 3, null), null, 0, null, null, image, null, null, null, null, null, null, null, null, null, null, composer2, 262144, 0, 0, 2096095);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.EditTextFieldKt$ClearButton$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer3, Integer num) {
                num.intValue();
                EditTextFieldKt.access$ClearButton(function1, composer3, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
