package com.tencent.mobileqq.icgame.widget.chat.floating;

import android.content.Context;
import android.util.AttributeSet;
import b52.a;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatGiftMsgItemView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ChatGiftMsgFloatingItemView extends ChatGiftMsgItemView {
    public ChatGiftMsgFloatingItemView(@NotNull Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText
    public int i() {
        return a.a(14);
    }

    @Override // com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText
    public void setSelfPadding() {
        setPadding(a.a(7), a.a(2), a.a(7), a.a(2));
    }

    public ChatGiftMsgFloatingItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
