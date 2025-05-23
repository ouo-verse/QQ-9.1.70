package com.tencent.state.square.chatland.data;

import com.tencent.state.template.push.BubbleMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/chatland/data/ChatLandAvatarExtra;", "", "needRingPagAnim", "", "speakBubble", "Lcom/tencent/state/template/push/BubbleMessage;", "changeAvatarImageVisible", "(ZLcom/tencent/state/template/push/BubbleMessage;Ljava/lang/Boolean;)V", "getChangeAvatarImageVisible", "()Ljava/lang/Boolean;", "setChangeAvatarImageVisible", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNeedRingPagAnim", "()Z", "setNeedRingPagAnim", "(Z)V", "getSpeakBubble", "()Lcom/tencent/state/template/push/BubbleMessage;", "setSpeakBubble", "(Lcom/tencent/state/template/push/BubbleMessage;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandAvatarExtra {
    private Boolean changeAvatarImageVisible;
    private boolean needRingPagAnim;
    private BubbleMessage speakBubble;

    public ChatLandAvatarExtra() {
        this(false, null, null, 7, null);
    }

    public final Boolean getChangeAvatarImageVisible() {
        return this.changeAvatarImageVisible;
    }

    public final boolean getNeedRingPagAnim() {
        return this.needRingPagAnim;
    }

    public final BubbleMessage getSpeakBubble() {
        return this.speakBubble;
    }

    public final void setChangeAvatarImageVisible(Boolean bool) {
        this.changeAvatarImageVisible = bool;
    }

    public final void setNeedRingPagAnim(boolean z16) {
        this.needRingPagAnim = z16;
    }

    public final void setSpeakBubble(BubbleMessage bubbleMessage) {
        this.speakBubble = bubbleMessage;
    }

    public ChatLandAvatarExtra(boolean z16, BubbleMessage bubbleMessage, Boolean bool) {
        this.needRingPagAnim = z16;
        this.speakBubble = bubbleMessage;
        this.changeAvatarImageVisible = bool;
    }

    public /* synthetic */ ChatLandAvatarExtra(boolean z16, BubbleMessage bubbleMessage, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? null : bubbleMessage, (i3 & 4) != 0 ? null : bool);
    }
}
