package com.tencent.state.publicchat.action;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.data.UserInfo;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/publicchat/action/ShowUserPanelAction;", "Lcom/tencent/state/publicchat/action/MsgAction;", HippyTKDListViewAdapter.X, "", "y", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/publicchat/data/UserInfo;", "(IILcom/tencent/state/publicchat/data/MsgInfo;Lcom/tencent/state/publicchat/data/UserInfo;)V", "getMsg", "()Lcom/tencent/state/publicchat/data/MsgInfo;", "getUser", "()Lcom/tencent/state/publicchat/data/UserInfo;", "getX", "()I", "getY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class ShowUserPanelAction extends MsgAction {
    private final MsgInfo msg;
    private final UserInfo user;
    private final int x;
    private final int y;

    public ShowUserPanelAction(int i3, int i16, MsgInfo msg2, UserInfo user) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(user, "user");
        this.x = i3;
        this.y = i16;
        this.msg = msg2;
        this.user = user;
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

    /* renamed from: component4, reason: from getter */
    public final UserInfo getUser() {
        return this.user;
    }

    public final ShowUserPanelAction copy(int x16, int y16, MsgInfo msg2, UserInfo user) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(user, "user");
        return new ShowUserPanelAction(x16, y16, msg2, user);
    }

    public final MsgInfo getMsg() {
        return this.msg;
    }

    public final UserInfo getUser() {
        return this.user;
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
        int hashCode = (i3 + (msgInfo != null ? msgInfo.hashCode() : 0)) * 31;
        UserInfo userInfo = this.user;
        return hashCode + (userInfo != null ? userInfo.hashCode() : 0);
    }

    public String toString() {
        return "ShowUserPanelAction(x=" + this.x + ", y=" + this.y + ", msg=" + this.msg + ", user=" + this.user + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShowUserPanelAction)) {
            return false;
        }
        ShowUserPanelAction showUserPanelAction = (ShowUserPanelAction) other;
        return this.x == showUserPanelAction.x && this.y == showUserPanelAction.y && Intrinsics.areEqual(this.msg, showUserPanelAction.msg) && Intrinsics.areEqual(this.user, showUserPanelAction.user);
    }

    public static /* synthetic */ ShowUserPanelAction copy$default(ShowUserPanelAction showUserPanelAction, int i3, int i16, MsgInfo msgInfo, UserInfo userInfo, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = showUserPanelAction.x;
        }
        if ((i17 & 2) != 0) {
            i16 = showUserPanelAction.y;
        }
        if ((i17 & 4) != 0) {
            msgInfo = showUserPanelAction.msg;
        }
        if ((i17 & 8) != 0) {
            userInfo = showUserPanelAction.user;
        }
        return showUserPanelAction.copy(i3, i16, msgInfo, userInfo);
    }
}
