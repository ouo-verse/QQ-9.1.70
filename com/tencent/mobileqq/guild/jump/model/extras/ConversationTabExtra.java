package com.tencent.mobileqq.guild.jump.model.extras;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/model/extras/ConversationTabExtra;", "Lcom/tencent/mobileqq/guild/jump/model/extras/AbsJumpExtra;", "scrollToItemOnly", "", "jumpToMsgListOnly", "(ZZ)V", "getJumpToMsgListOnly", "()Z", "setJumpToMsgListOnly", "(Z)V", "getScrollToItemOnly", "setScrollToItemOnly", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class ConversationTabExtra extends AbsJumpExtra {
    private boolean jumpToMsgListOnly;
    private boolean scrollToItemOnly;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ConversationTabExtra() {
        this(r2, r2, 3, null);
        boolean z16 = false;
    }

    public final boolean getJumpToMsgListOnly() {
        return this.jumpToMsgListOnly;
    }

    public final boolean getScrollToItemOnly() {
        return this.scrollToItemOnly;
    }

    public final void setJumpToMsgListOnly(boolean z16) {
        this.jumpToMsgListOnly = z16;
    }

    public final void setScrollToItemOnly(boolean z16) {
        this.scrollToItemOnly = z16;
    }

    public /* synthetic */ ConversationTabExtra(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17);
    }

    public ConversationTabExtra(boolean z16, boolean z17) {
        this.scrollToItemOnly = z16;
        this.jumpToMsgListOnly = z17;
    }
}
