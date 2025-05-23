package com.tencent.mobileqq.icgame.widget.chat.floating;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatSysMsgItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wi2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/floating/ChatSysMsgFloatingItemView;", "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatSysMsgItemView;", "", "setSelfPadding", "", "i", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ChatSysMsgFloatingItemView extends ChatSysMsgItemView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSysMsgFloatingItemView(@NotNull Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText
    public int i() {
        return c.b(14);
    }

    @Override // com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText
    public void setSelfPadding() {
        setPadding(c.b(6), c.b(2), c.b(3), c.b(2));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatSysMsgFloatingItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
