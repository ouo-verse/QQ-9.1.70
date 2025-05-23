package com.tencent.state.publicchat.action;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.state.publicchat.data.MsgInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/publicchat/action/ShowMsgPanelAction;", "Lcom/tencent/state/publicchat/action/MsgAction;", HippyTKDListViewAdapter.X, "", "y", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", "(IILcom/tencent/state/publicchat/data/MsgInfo;)V", "getMsg", "()Lcom/tencent/state/publicchat/data/MsgInfo;", "getX", "()I", "getY", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class ShowMsgPanelAction extends MsgAction {
    private final MsgInfo msg;
    private final int x;
    private final int y;

    public ShowMsgPanelAction(int i3, int i16, MsgInfo msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.x = i3;
        this.y = i16;
        this.msg = msg2;
    }

    /* renamed from: component1, reason: from getter */
    public final int getX() {
        return this.x;
    }

    /* renamed from: component2, reason: from getter */
    public final int getY() {
        return this.y;
    }

    /* renamed from: component3, reason: from getter */
    public final MsgInfo getMsg() {
        return this.msg;
    }

    public final ShowMsgPanelAction copy(int x16, int y16, MsgInfo msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new ShowMsgPanelAction(x16, y16, msg2);
    }

    public final MsgInfo getMsg() {
        return this.msg;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public int hashCode() {
        int i3 = ((this.x * 31) + this.y) * 31;
        MsgInfo msgInfo = this.msg;
        return i3 + (msgInfo != null ? msgInfo.hashCode() : 0);
    }

    public String toString() {
        return "ShowMsgPanelAction(x=" + this.x + ", y=" + this.y + ", msg=" + this.msg + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShowMsgPanelAction)) {
            return false;
        }
        ShowMsgPanelAction showMsgPanelAction = (ShowMsgPanelAction) other;
        return this.x == showMsgPanelAction.x && this.y == showMsgPanelAction.y && Intrinsics.areEqual(this.msg, showMsgPanelAction.msg);
    }

    public static /* synthetic */ ShowMsgPanelAction copy$default(ShowMsgPanelAction showMsgPanelAction, int i3, int i16, MsgInfo msgInfo, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = showMsgPanelAction.x;
        }
        if ((i17 & 2) != 0) {
            i16 = showMsgPanelAction.y;
        }
        if ((i17 & 4) != 0) {
            msgInfo = showMsgPanelAction.msg;
        }
        return showMsgPanelAction.copy(i3, i16, msgInfo);
    }
}
