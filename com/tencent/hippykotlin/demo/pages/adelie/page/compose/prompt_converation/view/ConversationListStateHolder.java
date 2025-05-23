package com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view;

import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.AdeliePromptConversationViewModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.ntcompose.foundation.lazy.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import to3.b;
import yo3.b;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ConversationListStateHolder {
    public ConversationListStateHolder$editTextAction$1 editTextAction;
    public float keyboardHeight;
    public float scrollOffset;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListStateHolder$editTextAction$1] */
    public ConversationListStateHolder(final AdeliePromptConversationViewModel adeliePromptConversationViewModel, final d dVar) {
        this.editTextAction = new IEditTextAction() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListStateHolder$editTextAction$1
            @Override // com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.IEditTextAction
            public final void onEditTextChange(b bVar) {
                d dVar2;
                float bottom = bVar.getBottom() - (c.f117352a.g().getPageData().l() - ConversationListStateHolder.this.keyboardHeight);
                if (bottom > 0.0f && (dVar2 = dVar) != null) {
                    b.a.a(dVar2, bottom + 20.0f, true, null, 4, null);
                }
                KLog.INSTANCE.i("ConversationList", "justifyPositionIfNeed, editTextRect=" + bVar + ", offset=" + bottom);
            }

            @Override // com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.IEditTextAction
            public final void onKeyboardHide() {
                KLog.INSTANCE.i("ConversationList", "onKeyboardHide");
                StateHolder<Float> stateHolder = adeliePromptConversationViewModel.spaceHolderHeight;
                stateHolder._state.setValue(Float.valueOf(0.0f));
                ConversationListStateHolder.this.scrollOffset = 0.0f;
            }

            @Override // com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.IEditTextAction
            public final void onKeyboardShow(float f16, yo3.b bVar) {
                c cVar = c.f117352a;
                float l3 = cVar.g().getPageData().l();
                float bottom = bVar.getBottom() - (l3 - f16);
                ConversationListStateHolder.this.keyboardHeight = f16;
                adeliePromptConversationViewModel.spaceHolderHeight._state.setValue(Float.valueOf(f16));
                if (bottom > 0.0f) {
                    KLog.INSTANCE.i("ConversationList", "update spaceHolderHeight = " + f16);
                    ConversationListStateHolder.this.scrollOffset = 20.0f + bottom;
                }
                final d dVar2 = dVar;
                final ConversationListStateHolder conversationListStateHolder = ConversationListStateHolder.this;
                final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListStateHolder$editTextAction$1$onKeyboardShow$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        d dVar3 = d.this;
                        if (dVar3 != null) {
                            b.a.a(dVar3, conversationListStateHolder.scrollOffset, true, null, 4, null);
                        }
                        conversationListStateHolder.scrollOffset = 0.0f;
                        return Unit.INSTANCE;
                    }
                };
                cVar.g().addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.AdelieUtils$runOnNextTick$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        com.tencent.kuikly.core.pager.b g16 = c.f117352a.g();
                        final Function0<Unit> function02 = function0;
                        g16.addNextTickTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.AdelieUtils$runOnNextTick$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                function02.invoke();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                KLog.INSTANCE.i("ConversationList", "onKeyboardShow pageHeight=" + l3 + " editTextRect = " + bVar + ", keyboardHeight=" + ConversationListStateHolder.this.keyboardHeight + ", offset=" + bottom);
            }
        };
    }
}
