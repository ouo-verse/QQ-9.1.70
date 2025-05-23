package com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation;

import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.ListStateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationItemData;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationParam;

/* loaded from: classes31.dex */
public final class AdeliePromptConversationViewModel {
    public float keyboardHeight;
    public boolean needScrollToBottom;
    public ConversationParam conversationParam = new ConversationParam();
    public final ListStateHolder<ConversationItemData> conversationList = new ListStateHolder<>();
    public StateHolder<Boolean> hideKeyboard = new StateHolder<>(Boolean.FALSE);
    public StateHolder<Float> spaceHolderHeight = new StateHolder<>(Float.valueOf(0.0f));
}
