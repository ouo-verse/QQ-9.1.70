package com.tencent.state.library.push;

import com.tencent.state.common.push.PushBasic;
import com.tencent.state.common.push.PushMessage;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/library/push/UserRefreshMessage;", "Lcom/tencent/state/common/push/PushMessage;", "type", "", "info", "Lcom/tencent/state/common/push/PushBasic;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "(ILcom/tencent/state/common/push/PushBasic;Lcom/tencent/state/template/data/User;)V", "getInfo", "()Lcom/tencent/state/common/push/PushBasic;", "getType", "()I", "getUser", "()Lcom/tencent/state/template/data/User;", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class UserRefreshMessage extends PushMessage {
    private final PushBasic info;
    private final int type;
    private final User user;

    public UserRefreshMessage(int i3, PushBasic info, User user) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(user, "user");
        this.type = i3;
        this.info = info;
        this.user = user;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public PushBasic getInfo() {
        return this.info;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    public String toString() {
        return "UserRefreshMessage(type=" + getType() + ", info=" + getInfo() + ", user=" + this.user + ')';
    }
}
