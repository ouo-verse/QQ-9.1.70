package com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.ListStateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationViewModel;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ConversationCellKt {
    public static final void DeleteButton(final int i3, final AdeliePromptConversationViewModel adeliePromptConversationViewModel, final ConversationItemData conversationItemData, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-1791569343);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1791569343, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.DeleteButton (ConversationCell.kt:61)");
        }
        i.Companion companion = i.INSTANCE;
        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 6.0f), startRestartGroup, 8, 0);
        BoxKt.a(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.k(companion, 33.0f), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationCellKt$DeleteButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                StateHolder<Boolean> stateHolder = AdeliePromptConversationViewModel.this.hideKeyboard;
                stateHolder._state.setValue(Boolean.TRUE);
                QQUIModule qQUIModule = (QQUIModule) c.f117352a.g().acquireModule("QQUIModule");
                final AdeliePromptConversationViewModel adeliePromptConversationViewModel2 = AdeliePromptConversationViewModel.this;
                final int i17 = i3;
                qQUIModule.openAlertDialog("", "\u662f\u5426\u5220\u9664\u672c\u8f6e\u5bf9\u8bdd\u3002", "\u53d6\u6d88", "\u5220\u9664", "", false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationCellKt$DeleteButton$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Boolean bool, Boolean bool2) {
                        List listOf;
                        boolean booleanValue = bool.booleanValue();
                        bool2.booleanValue();
                        if (booleanValue) {
                            ListStateHolder<ConversationItemData> listStateHolder = AdeliePromptConversationViewModel.this.conversationList;
                            int i18 = i17;
                            if (i18 < listStateHolder._stateList.size()) {
                                listStateHolder._stateList.remove(i18);
                            }
                            if (AdeliePromptConversationViewModel.this.conversationList._stateList.isEmpty()) {
                                ListStateHolder<ConversationItemData> listStateHolder2 = AdeliePromptConversationViewModel.this.conversationList;
                                listOf = CollectionsKt__CollectionsJVMKt.listOf(new ConversationItemData("", ""));
                                listStateHolder2._stateList.addAll(listOf);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, ComposableSingletons$ConversationCellKt.f13lambda2, startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationCellKt$DeleteButton$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ConversationCellKt.DeleteButton(i3, adeliePromptConversationViewModel, conversationItemData, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void ConversationCell(final int i3, final AdeliePromptConversationViewModel adeliePromptConversationViewModel, IEditTextAction iEditTextAction, Composer composer, final int i16, final int i17) {
        Object orNull;
        h hVar;
        Composer startRestartGroup = composer.startRestartGroup(970373761);
        IEditTextAction iEditTextAction2 = (i17 & 4) != 0 ? null : iEditTextAction;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(970373761, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationCell (ConversationCell.kt:33)");
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(adeliePromptConversationViewModel.conversationList._stateList, i3);
        final ConversationItemData conversationItemData = (ConversationItemData) orNull;
        if (conversationItemData == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            final IEditTextAction iEditTextAction3 = iEditTextAction2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationCellKt$ConversationCell$item$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    ConversationCellKt.ConversationCell(i3, adeliePromptConversationViewModel, iEditTextAction3, composer2, i16 | 1, i17);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (c.f117352a.g().isNightMode()) {
            hVar = QUIToken.color$default("fill_allblack_medium");
        } else {
            hVar = new h(2164260863L);
        }
        final IEditTextAction iEditTextAction4 = iEditTextAction2;
        ColumnKt.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), hVar), 4.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), 10.0f, 0.0f, 10.0f, 0.0f, 10, null), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1265988232, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationCellKt$ConversationCell$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x0093  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00b2  */
            @Override // kotlin.jvm.functions.Function3
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                boolean z16;
                boolean z17;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1265988232, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationCell.<anonymous> (ConversationCell.kt:41)");
                    }
                    i.Companion companion = i.INSTANCE;
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 18.0f), composer3, 8, 0);
                    ConversationEditTextKt.ConversationEditText(0, IEditTextAction.this, adeliePromptConversationViewModel, conversationItemData, composer3, ((i16 >> 3) & 112) | g.f247760v1);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 20.0f), composer3, 8, 0);
                    ConversationEditTextKt.ConversationEditText(1, IEditTextAction.this, adeliePromptConversationViewModel, conversationItemData, composer3, ((i16 >> 3) & 112) | g.f247760v1);
                    boolean z18 = true;
                    if (adeliePromptConversationViewModel.conversationList._stateList.size() == 1) {
                        String value = conversationItemData.question._state.getValue();
                        if (value != null) {
                            if (value.length() > 0) {
                                z16 = true;
                                if (!z16) {
                                    String value2 = conversationItemData.answer._state.getValue();
                                    if (value2 != null) {
                                        if (value2.length() > 0) {
                                            z17 = true;
                                            if (!z17) {
                                                z18 = false;
                                            }
                                        }
                                    }
                                    z17 = false;
                                    if (!z17) {
                                    }
                                }
                            }
                        }
                        z16 = false;
                        if (!z16) {
                        }
                    }
                    if (z18) {
                        composer3.startReplaceableGroup(778842705);
                        ConversationCellKt.DeleteButton(i3, adeliePromptConversationViewModel, conversationItemData, composer3, (i16 & 14) | PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(778842771);
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 18.0f), composer3, 8, 0);
                        composer3.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        final IEditTextAction iEditTextAction5 = iEditTextAction2;
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationCellKt$ConversationCell$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ConversationCellKt.ConversationCell(i3, adeliePromptConversationViewModel, iEditTextAction5, composer2, i16 | 1, i17);
                return Unit.INSTANCE;
            }
        });
    }
}
