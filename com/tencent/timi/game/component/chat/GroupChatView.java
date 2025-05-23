package com.tencent.timi.game.component.chat;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\n\u0010\u000eB#\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\n\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/timi/game/component/chat/GroupChatView;", "Lcom/tencent/timi/game/component/chat/ChatView;", "", "p", "", "chatId", "Lcom/tencent/timi/game/tim/api/message/c;", "k", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class GroupChatView extends ChatView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupChatView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        p();
    }

    @Override // com.tencent.timi.game.component.chat.ChatView
    @NotNull
    public com.tencent.timi.game.tim.api.message.c k(long chatId) {
        return ((kn4.b) mm4.b.b(kn4.b.class)).M(chatId);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupChatView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        p();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupChatView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        p();
    }

    private final void p() {
    }
}
