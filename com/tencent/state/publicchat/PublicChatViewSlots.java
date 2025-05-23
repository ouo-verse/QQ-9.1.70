package com.tencent.state.publicchat;

import android.widget.FrameLayout;
import com.tencent.state.publicchat.view.MsgNewBtnConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/publicchat/PublicChatViewSlots;", "", "msgListSlot", "Landroid/widget/FrameLayout;", "msgNewBtnSlot", "msgNewBtnConfig", "Lcom/tencent/state/publicchat/view/MsgNewBtnConfig;", "(Landroid/widget/FrameLayout;Landroid/widget/FrameLayout;Lcom/tencent/state/publicchat/view/MsgNewBtnConfig;)V", "getMsgListSlot", "()Landroid/widget/FrameLayout;", "getMsgNewBtnConfig", "()Lcom/tencent/state/publicchat/view/MsgNewBtnConfig;", "getMsgNewBtnSlot", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class PublicChatViewSlots {
    private final FrameLayout msgListSlot;
    private final MsgNewBtnConfig msgNewBtnConfig;
    private final FrameLayout msgNewBtnSlot;

    public PublicChatViewSlots(FrameLayout msgListSlot, FrameLayout msgNewBtnSlot, MsgNewBtnConfig msgNewBtnConfig) {
        Intrinsics.checkNotNullParameter(msgListSlot, "msgListSlot");
        Intrinsics.checkNotNullParameter(msgNewBtnSlot, "msgNewBtnSlot");
        this.msgListSlot = msgListSlot;
        this.msgNewBtnSlot = msgNewBtnSlot;
        this.msgNewBtnConfig = msgNewBtnConfig;
    }

    /* renamed from: component1, reason: from getter */
    public final FrameLayout getMsgListSlot() {
        return this.msgListSlot;
    }

    /* renamed from: component2, reason: from getter */
    public final FrameLayout getMsgNewBtnSlot() {
        return this.msgNewBtnSlot;
    }

    /* renamed from: component3, reason: from getter */
    public final MsgNewBtnConfig getMsgNewBtnConfig() {
        return this.msgNewBtnConfig;
    }

    public final PublicChatViewSlots copy(FrameLayout msgListSlot, FrameLayout msgNewBtnSlot, MsgNewBtnConfig msgNewBtnConfig) {
        Intrinsics.checkNotNullParameter(msgListSlot, "msgListSlot");
        Intrinsics.checkNotNullParameter(msgNewBtnSlot, "msgNewBtnSlot");
        return new PublicChatViewSlots(msgListSlot, msgNewBtnSlot, msgNewBtnConfig);
    }

    public final FrameLayout getMsgListSlot() {
        return this.msgListSlot;
    }

    public final MsgNewBtnConfig getMsgNewBtnConfig() {
        return this.msgNewBtnConfig;
    }

    public final FrameLayout getMsgNewBtnSlot() {
        return this.msgNewBtnSlot;
    }

    public int hashCode() {
        FrameLayout frameLayout = this.msgListSlot;
        int hashCode = (frameLayout != null ? frameLayout.hashCode() : 0) * 31;
        FrameLayout frameLayout2 = this.msgNewBtnSlot;
        int hashCode2 = (hashCode + (frameLayout2 != null ? frameLayout2.hashCode() : 0)) * 31;
        MsgNewBtnConfig msgNewBtnConfig = this.msgNewBtnConfig;
        return hashCode2 + (msgNewBtnConfig != null ? msgNewBtnConfig.hashCode() : 0);
    }

    public String toString() {
        return "PublicChatViewSlots(msgListSlot=" + this.msgListSlot + ", msgNewBtnSlot=" + this.msgNewBtnSlot + ", msgNewBtnConfig=" + this.msgNewBtnConfig + ")";
    }

    public /* synthetic */ PublicChatViewSlots(FrameLayout frameLayout, FrameLayout frameLayout2, MsgNewBtnConfig msgNewBtnConfig, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(frameLayout, frameLayout2, (i3 & 4) != 0 ? null : msgNewBtnConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublicChatViewSlots)) {
            return false;
        }
        PublicChatViewSlots publicChatViewSlots = (PublicChatViewSlots) other;
        return Intrinsics.areEqual(this.msgListSlot, publicChatViewSlots.msgListSlot) && Intrinsics.areEqual(this.msgNewBtnSlot, publicChatViewSlots.msgNewBtnSlot) && Intrinsics.areEqual(this.msgNewBtnConfig, publicChatViewSlots.msgNewBtnConfig);
    }

    public static /* synthetic */ PublicChatViewSlots copy$default(PublicChatViewSlots publicChatViewSlots, FrameLayout frameLayout, FrameLayout frameLayout2, MsgNewBtnConfig msgNewBtnConfig, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            frameLayout = publicChatViewSlots.msgListSlot;
        }
        if ((i3 & 2) != 0) {
            frameLayout2 = publicChatViewSlots.msgNewBtnSlot;
        }
        if ((i3 & 4) != 0) {
            msgNewBtnConfig = publicChatViewSlots.msgNewBtnConfig;
        }
        return publicChatViewSlots.copy(frameLayout, frameLayout2, msgNewBtnConfig);
    }
}
