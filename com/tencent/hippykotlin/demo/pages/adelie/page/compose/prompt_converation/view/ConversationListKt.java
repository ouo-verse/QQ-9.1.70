package com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.ListStateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationViewModel;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.lazy.d;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ConversationListKt {
    public static final void ConversationList(final a aVar, final AdeliePromptConversationViewModel adeliePromptConversationViewModel, d dVar, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-23780713);
        if ((i16 & 2) != 0) {
            dVar = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-23780713, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationList (ConversationList.kt:37)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new ConversationListStateHolder(adeliePromptConversationViewModel, dVar), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        LazyDslKt.c(aVar, adeliePromptConversationViewModel.conversationList._stateList, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1816973222, true, new Function4<Integer, ConversationItemData, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$ConversationList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final Unit invoke(Integer num, ConversationItemData conversationItemData, Composer composer2, Integer num2) {
                int intValue = num.intValue();
                Composer composer3 = composer2;
                int intValue2 = num2.intValue();
                if ((intValue2 & 14) == 0) {
                    intValue2 |= composer3.changed(intValue) ? 4 : 2;
                }
                if ((intValue2 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1816973222, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationList.<anonymous> (ConversationList.kt:39)");
                    }
                    composer3.startReplaceableGroup(245017105);
                    if (intValue > 0) {
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 12.0f), composer3, 8, 0);
                    }
                    composer3.endReplaceableGroup();
                    ConversationCellKt.ConversationCell(intValue, AdeliePromptConversationViewModel.this, mutableState.getValue().editTextAction, composer3, (intValue2 & 14) | 64, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3144, 2);
        AddConversation(adeliePromptConversationViewModel, dVar, startRestartGroup, ((i3 >> 3) & 112) | 8, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final d dVar2 = dVar;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$ConversationList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ConversationListKt.ConversationList(a.this, adeliePromptConversationViewModel, dVar2, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void AddConversation(final AdeliePromptConversationViewModel adeliePromptConversationViewModel, d dVar, Composer composer, final int i3, final int i16) {
        h hVar;
        Composer startRestartGroup = composer.startRestartGroup(441481692);
        final d dVar2 = (i16 & 2) != 0 ? null : dVar;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441481692, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.AddConversation (ConversationList.kt:52)");
        }
        if (c.f117352a.g().isNightMode()) {
            hVar = QUIToken.color$default("fill_allblack_medium");
        } else {
            hVar = new h(2164260863L);
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        mutableState.setValue(Boolean.valueOf(adeliePromptConversationViewModel.conversationList._stateList.size() < adeliePromptConversationViewModel.conversationParam.maxRound));
        BoxKt.a(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, ((Boolean) mutableState.getValue()).booleanValue() ? 44.0f : 0.0f), 0.0f, 1, null), hVar), 4.0f), 16.0f, 12.0f, 16.0f, 0.0f, 8, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("click current.size=");
                m3.append(AdeliePromptConversationViewModel.this.conversationList._stateList.size());
                m3.append(", maxRound=");
                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, AdeliePromptConversationViewModel.this.conversationParam.maxRound, kLog, "AddConversation");
                int size = AdeliePromptConversationViewModel.this.conversationList._stateList.size();
                AdeliePromptConversationViewModel adeliePromptConversationViewModel2 = AdeliePromptConversationViewModel.this;
                if (size < adeliePromptConversationViewModel2.conversationParam.maxRound) {
                    adeliePromptConversationViewModel2.needScrollToBottom = true;
                    ListStateHolder<ConversationItemData> listStateHolder = adeliePromptConversationViewModel2.conversationList;
                    listStateHolder._stateList.add(new ConversationItemData("", ""));
                }
                return Unit.INSTANCE;
            }
        }, 3, null), Alignment.CenterStart, null, ComposableSingletons$ConversationListKt.f15lambda2, startRestartGroup, 3128, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ConversationListKt.AddConversation(AdeliePromptConversationViewModel.this, dVar2, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
