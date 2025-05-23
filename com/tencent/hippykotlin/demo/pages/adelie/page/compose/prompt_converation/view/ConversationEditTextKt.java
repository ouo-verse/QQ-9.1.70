package com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import ap3.a;
import ap3.d;
import bp3.KeyboardOptions;
import bp3.e;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationViewModel;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.views.KeyboardParams;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextFieldKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.focus.FocusChangedModiferKt;
import com.tencent.ntcompose.ui.focus.FocusRequestModifierKt;
import com.tencent.ntcompose.ui.focus.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import yo3.Size;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ConversationEditTextKt {
    public static final void onKeyboardShow(a aVar, float f16, IEditTextAction iEditTextAction) {
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("inputBoxCoordinates=");
        m3.append(d.a(aVar));
        m3.append(", height=");
        m3.append(f16);
        kLog.i("QuestionEditText", m3.toString());
        if (f16 <= 0.0f || iEditTextAction == null) {
            return;
        }
        iEditTextAction.onKeyboardShow(f16, d.a(aVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c8, code lost:
    
        r1 = "";
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ConversationEditText(final int i3, final IEditTextAction iEditTextAction, final AdeliePromptConversationViewModel adeliePromptConversationViewModel, final ConversationItemData conversationItemData, Composer composer, final int i16) {
        Size size;
        Alignment alignment;
        String str;
        String str2;
        h color$default;
        h color$default2;
        h hVar;
        String value;
        String value2;
        MutableState mutableStateOf$default;
        Composer startRestartGroup = composer.startRestartGroup(-690933805);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-690933805, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditText (ConversationEditText.kt:47)");
        }
        if (i3 == 0) {
            size = new Size(163.0f, 38.0f);
        } else {
            size = new Size(172.0f, 38.0f);
        }
        final Size size2 = size;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        T t16 = rememberedValue2;
        if (rememberedValue2 == companion.getEmpty()) {
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Size(0.0f, 0.0f), null, 2, null);
            startRestartGroup.updateRememberedValue(mutableStateOf$default);
            t16 = mutableStateOf$default;
        }
        startRestartGroup.endReplaceableGroup();
        objectRef.element = t16;
        final State derivedStateOf = SnapshotStateKt.derivedStateOf(new Function0<Size>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditTextKt$ConversationEditText$inputSize$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                float width = objectRef.element.getValue().getWidth() + 18.0f;
                if (width < 30.0f) {
                    width = 30.0f;
                }
                if (objectRef.element.getValue().getHeight() > 25.0f) {
                    return new Size(width, objectRef.element.getValue().getHeight() + 18.0f);
                }
                return new Size(width, size2.getHeight());
            }
        });
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        String str3 = "";
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState2 = (MutableState) rememberedValue3;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
            if (i3 == 0) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value2, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            } else {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value2, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState3 = (MutableState) rememberedValue4;
        startRestartGroup.startReplaceableGroup(511388516);
        boolean changed = startRestartGroup.changed(mutableState) | startRestartGroup.changed(mutableState2);
        Object rememberedValue5 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue5 == companion.getEmpty()) {
            rememberedValue5 = new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditTextKt$ConversationEditText$showPlaceholder$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    boolean z16 = false;
                    if (!mutableState.getValue().booleanValue()) {
                        if (mutableState2.getValue().length() == 0) {
                            z16 = true;
                        }
                    }
                    return Boolean.valueOf(z16);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue5);
        }
        startRestartGroup.endReplaceableGroup();
        final State derivedStateOf2 = SnapshotStateKt.derivedStateOf((Function0) rememberedValue5);
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue6 = startRestartGroup.rememberedValue();
        if (rememberedValue6 == companion.getEmpty()) {
            rememberedValue6 = new com.tencent.ntcompose.ui.focus.a();
            startRestartGroup.updateRememberedValue(rememberedValue6);
        }
        startRestartGroup.endReplaceableGroup();
        final com.tencent.ntcompose.ui.focus.a aVar = (com.tencent.ntcompose.ui.focus.a) rememberedValue6;
        if (i3 == 0) {
            alignment = Alignment.TopEnd;
        } else {
            alignment = Alignment.TopStart;
        }
        Alignment alignment2 = alignment;
        if (i3 == 0) {
            str = "bubble_host_top";
        } else {
            str = "bubble_guest";
        }
        h color$default3 = QUIToken.color$default(str);
        if (i3 == 0) {
            str2 = "\u70b9\u51fb\u6dfb\u52a0\u6211\u7684\u5bf9\u8bdd\u5185\u5bb9";
        } else {
            str2 = "\u70b9\u51fb\u6dfb\u52a0\u667a\u80fd\u4f53\u5bf9\u8bdd\u5185\u5bb9";
        }
        final String str4 = str2;
        if (i3 == 0) {
            color$default = QUIToken.color$default("button_text_primary_default");
        } else {
            color$default = QUIToken.color$default("button_text_secondary_default");
        }
        final h hVar2 = color$default;
        if (i3 == 0) {
            color$default2 = QUIToken.color$default("button_text_primary_disable");
        } else {
            color$default2 = QUIToken.color$default("button_text_secondary_disable");
        }
        final h hVar3 = color$default2;
        if (Intrinsics.areEqual(adeliePromptConversationViewModel.hideKeyboard._state.getValue(), Boolean.TRUE) && ((Boolean) mutableState.getValue()).booleanValue()) {
            hVar = color$default3;
            if (zz0.a.f453719a.a() - conversationItemData.focusTime > 100) {
                aVar.b();
                if (iEditTextAction != null) {
                    iEditTextAction.onKeyboardHide();
                }
            }
            adeliePromptConversationViewModel.hideKeyboard._state.setValue(Boolean.FALSE);
        } else {
            hVar = color$default3;
        }
        if (i3 != 0 ? (value = conversationItemData.answer._state.getValue()) != null : (value = conversationItemData.question._state.getValue()) != null) {
            str3 = value;
        }
        mutableState2.setValue(str3);
        final h hVar4 = hVar;
        BoxKt.a(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), alignment2, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1181637133, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditTextKt$ConversationEditText$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Size value3;
                Size value4;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1181637133, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditText.<anonymous> (ConversationEditText.kt:86)");
                    }
                    i.Companion companion2 = i.INSTANCE;
                    if (derivedStateOf2.getValue().booleanValue()) {
                        value3 = size2;
                    } else {
                        value3 = derivedStateOf.getValue();
                    }
                    float width = value3.getWidth();
                    if (derivedStateOf2.getValue().booleanValue()) {
                        value4 = size2;
                    } else {
                        value4 = derivedStateOf.getValue();
                    }
                    i a16 = FocusRequestModifierKt.a(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.v(companion2, width, value4.getHeight()), hVar4), 8.0f), aVar);
                    final com.tencent.ntcompose.ui.focus.a aVar2 = aVar;
                    i d16 = ViewEventPropUpdaterKt.d(a16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditTextKt$ConversationEditText$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            com.tencent.ntcompose.ui.focus.a.this.c();
                            return Unit.INSTANCE;
                        }
                    }, 3, null);
                    final int i17 = i3;
                    final ConversationItemData conversationItemData2 = conversationItemData;
                    final MutableState<Boolean> mutableState4 = mutableState;
                    final IEditTextAction iEditTextAction2 = iEditTextAction;
                    i k3 = ViewEventPropUpdaterKt.k(d16, new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditTextKt$ConversationEditText$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(a aVar3) {
                            IEditTextAction iEditTextAction3;
                            a aVar4 = aVar3;
                            if (i17 == 0) {
                                conversationItemData2.questionInputBoxCoordinates = aVar4;
                            } else {
                                conversationItemData2.answerInputBoxCoordinates = aVar4;
                            }
                            if (mutableState4.getValue().booleanValue() && (iEditTextAction3 = iEditTextAction2) != null) {
                                iEditTextAction3.onEditTextChange(d.a(aVar4));
                            }
                            KLog kLog = KLog.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onGloballyPositioned inputBoxCoordinates.height=");
                            m3.append(aVar4.getHeight());
                            kLog.i("QuestionEditText", m3.toString());
                            return Unit.INSTANCE;
                        }
                    });
                    final MutableState<String> mutableState5 = mutableState3;
                    final int i18 = i3;
                    final AdeliePromptConversationViewModel adeliePromptConversationViewModel2 = adeliePromptConversationViewModel;
                    final h hVar5 = hVar2;
                    final MutableState<Boolean> mutableState6 = mutableState;
                    final MutableState<String> mutableState7 = mutableState2;
                    final ConversationItemData conversationItemData3 = conversationItemData;
                    final IEditTextAction iEditTextAction3 = iEditTextAction;
                    final com.tencent.ntcompose.ui.focus.a aVar3 = aVar;
                    final String str5 = str4;
                    final h hVar6 = hVar3;
                    final Ref.ObjectRef<MutableState<Size>> objectRef2 = objectRef;
                    ColumnKt.a(k3, null, null, null, ComposableLambdaKt.composableLambda(composer3, 225447606, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditTextKt$ConversationEditText$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer4, Integer num2) {
                            h color$default4;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(225447606, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditText.<anonymous>.<anonymous> (ConversationEditText.kt:103)");
                                }
                                i.Companion companion3 = i.INSTANCE;
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion3, 9.0f), composer5, 8, 0);
                                String value5 = mutableState5.getValue();
                                i f16 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.w(companion3, 225.0f), 9.0f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null);
                                final MutableState<Boolean> mutableState8 = mutableState6;
                                final MutableState<String> mutableState9 = mutableState7;
                                final MutableState<String> mutableState10 = mutableState5;
                                final int i19 = i18;
                                final ConversationItemData conversationItemData4 = conversationItemData3;
                                final AdeliePromptConversationViewModel adeliePromptConversationViewModel3 = adeliePromptConversationViewModel2;
                                final IEditTextAction iEditTextAction4 = iEditTextAction3;
                                i a17 = FocusChangedModiferKt.a(f16, new Function1<c, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditTextKt.ConversationEditText.1.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(c cVar) {
                                        a aVar4;
                                        CharSequence trim;
                                        mutableState8.setValue(Boolean.valueOf(cVar.a()));
                                        if (!mutableState8.getValue().booleanValue()) {
                                            MutableState<String> mutableState11 = mutableState9;
                                            trim = StringsKt__StringsKt.trim((CharSequence) mutableState11.getValue());
                                            mutableState11.setValue(trim.toString());
                                            mutableState10.setValue(mutableState9.getValue());
                                            if (i19 == 0) {
                                                StateHolder<String> stateHolder = conversationItemData4.question;
                                                stateHolder._state.setValue(mutableState9.getValue());
                                            } else {
                                                StateHolder<String> stateHolder2 = conversationItemData4.answer;
                                                stateHolder2._state.setValue(mutableState9.getValue());
                                            }
                                        } else {
                                            conversationItemData4.focusTime = zz0.a.f453719a.a();
                                            if (i19 == 0) {
                                                aVar4 = conversationItemData4.questionInputBoxCoordinates;
                                            } else {
                                                aVar4 = conversationItemData4.answerInputBoxCoordinates;
                                            }
                                            if (aVar4 != null) {
                                                AdeliePromptConversationViewModel adeliePromptConversationViewModel4 = adeliePromptConversationViewModel3;
                                                IEditTextAction iEditTextAction5 = iEditTextAction4;
                                                float f17 = adeliePromptConversationViewModel4.keyboardHeight;
                                                if (f17 > 0.0f) {
                                                    ConversationEditTextKt.onKeyboardShow(aVar4, f17, iEditTextAction5);
                                                }
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                if (i18 == 0) {
                                    QUIToken qUIToken = QUIToken.INSTANCE;
                                    if (!qUIToken.isNightMode() && !qUIToken.isDarkMode()) {
                                        color$default4 = h.INSTANCE.m();
                                    } else {
                                        color$default4 = QUIToken.color$default("brand_standard");
                                    }
                                } else {
                                    color$default4 = QUIToken.color$default("brand_standard");
                                }
                                h hVar7 = color$default4;
                                int i26 = adeliePromptConversationViewModel2.conversationParam.maxWord;
                                KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, 0, cp3.a.INSTANCE.b(), 7, null);
                                final com.tencent.ntcompose.ui.focus.a aVar4 = aVar3;
                                final IEditTextAction iEditTextAction5 = iEditTextAction3;
                                e eVar = new e(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditTextKt.ConversationEditText.1.3.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        com.tencent.ntcompose.ui.focus.a aVar5 = com.tencent.ntcompose.ui.focus.a.this;
                                        IEditTextAction iEditTextAction6 = iEditTextAction5;
                                        aVar5.b();
                                        if (iEditTextAction6 != null) {
                                            iEditTextAction6.onKeyboardHide();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, null, null, null, null, null, 62, null);
                                k kVar = new k(hVar5, Float.valueOf(14.0f), null, null, null, null, null, null, null, null, null, null, null, null, 16380, null);
                                final MutableState<String> mutableState11 = mutableState7;
                                final int i27 = i18;
                                final ConversationItemData conversationItemData5 = conversationItemData3;
                                Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditTextKt.ConversationEditText.1.3.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(String str6) {
                                        String str7 = str6;
                                        mutableState11.setValue(str7);
                                        if (i27 == 0) {
                                            conversationItemData5.question._state.setValue(str7);
                                        } else {
                                            conversationItemData5.answer._state.setValue(str7);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                final MutableState<Boolean> mutableState12 = mutableState6;
                                final String str6 = str5;
                                final h hVar8 = hVar6;
                                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer5, -1098147557, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditTextKt.ConversationEditText.1.3.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Composer composer6, Integer num3) {
                                        String str7;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 11) == 2 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1098147557, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditText.<anonymous>.<anonymous>.<anonymous> (ConversationEditText.kt:149)");
                                            }
                                            if (!mutableState12.getValue().booleanValue()) {
                                                str7 = str6;
                                            } else {
                                                str7 = "";
                                            }
                                            TextKt.a(str7, i.INSTANCE, null, hVar8, Float.valueOf(14.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 28736, 0, 0, 134217700);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                Integer valueOf = Integer.valueOf(i26);
                                Boolean bool = Boolean.FALSE;
                                AnonymousClass5 anonymousClass5 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditTextKt.ConversationEditText.1.3.5
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        Mqq.INSTANCE.getUi().showInfoTips("\u5df2\u8fbe\u5230\u5b57\u6570\u4e0a\u9650");
                                        return Unit.INSTANCE;
                                    }
                                };
                                final AdeliePromptConversationViewModel adeliePromptConversationViewModel4 = adeliePromptConversationViewModel2;
                                final MutableState<Boolean> mutableState13 = mutableState6;
                                final IEditTextAction iEditTextAction6 = iEditTextAction3;
                                final int i28 = i18;
                                final ConversationItemData conversationItemData6 = conversationItemData3;
                                final MutableState<String> mutableState14 = mutableState7;
                                Function1<KeyboardParams, Unit> function12 = new Function1<KeyboardParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditTextKt.ConversationEditText.1.3.6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(KeyboardParams keyboardParams) {
                                        a aVar5;
                                        KeyboardParams keyboardParams2 = keyboardParams;
                                        if (keyboardParams2.getHeight() <= 0.0f && AdeliePromptConversationViewModel.this.keyboardHeight > 0.0f) {
                                            KLog kLog = KLog.INSTANCE;
                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onKeyboardHide\uff0chasFocus=");
                                            m3.append(mutableState13.getValue().booleanValue());
                                            kLog.i("QuestionEditText", m3.toString());
                                            AdeliePromptConversationViewModel.this.keyboardHeight = 0.0f;
                                            IEditTextAction iEditTextAction7 = iEditTextAction6;
                                            if (iEditTextAction7 != null) {
                                                iEditTextAction7.onKeyboardHide();
                                            }
                                        } else {
                                            if (i28 == 0) {
                                                aVar5 = conversationItemData6.questionInputBoxCoordinates;
                                            } else {
                                                aVar5 = conversationItemData6.answerInputBoxCoordinates;
                                            }
                                            if (aVar5 == null) {
                                                KLog kLog2 = KLog.INSTANCE;
                                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("inputBoxCoordinates == null, text=");
                                                m16.append(mutableState14.getValue());
                                                kLog2.e("QuestionEditText", m16.toString());
                                            } else {
                                                if (mutableState13.getValue().booleanValue()) {
                                                    ConversationEditTextKt.onKeyboardShow(aVar5, keyboardParams2.getHeight(), iEditTextAction6);
                                                }
                                                AdeliePromptConversationViewModel.this.keyboardHeight = keyboardParams2.getHeight();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                final Ref.ObjectRef<MutableState<Size>> objectRef3 = objectRef2;
                                TextFieldKt.a(value5, null, function1, a17, null, kVar, false, composableLambda, hVar7, keyboardOptions, eVar, valueOf, bool, anonymousClass5, null, false, function12, new Function1<Size, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditTextKt.ConversationEditText.1.3.7
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Size size3) {
                                        objectRef3.element.setValue(size3);
                                        return Unit.INSTANCE;
                                    }
                                }, false, null, null, false, composer5, (k.f28903n << 15) | 146804736, 3456, 0, 3981394);
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
        }), startRestartGroup, 3080, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationEditTextKt$ConversationEditText$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ConversationEditTextKt.ConversationEditText(i3, iEditTextAction, adeliePromptConversationViewModel, conversationItemData, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
