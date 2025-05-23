package com.tencent.state.publicchat.action;

import com.tencent.state.publicchat.data.UserInfo;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/publicchat/action/ViewTaProfileAction;", "Lcom/tencent/state/publicchat/action/MsgAction;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/publicchat/data/UserInfo;", "(Lcom/tencent/state/publicchat/data/UserInfo;)V", "getUser", "()Lcom/tencent/state/publicchat/data/UserInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class ViewTaProfileAction extends MsgAction {
    private final UserInfo user;

    public ViewTaProfileAction(UserInfo user) {
        Intrinsics.checkNotNullParameter(user, "user");
        this.user = user;
    }

    /* renamed from: component1, reason: from getter */
    public final UserInfo getUser() {
        return this.user;
    }

    public final ViewTaProfileAction copy(UserInfo user) {
        Intrinsics.checkNotNullParameter(user, "user");
        return new ViewTaProfileAction(user);
    }

    public final UserInfo getUser() {
        return this.user;
    }

    public int hashCode() {
        UserInfo userInfo = this.user;
        if (userInfo != null) {
            return userInfo.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ViewTaProfileAction(user=" + this.user + ")";
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ViewTaProfileAction) && Intrinsics.areEqual(this.user, ((ViewTaProfileAction) other).user);
        }
        return true;
    }

    public static /* synthetic */ ViewTaProfileAction copy$default(ViewTaProfileAction viewTaProfileAction, UserInfo userInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            userInfo = viewTaProfileAction.user;
        }
        return viewTaProfileAction.copy(userInfo);
    }
}
