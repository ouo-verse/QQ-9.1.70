package com.tencent.state.library.push;

import com.tencent.state.common.push.PushBasic;
import com.tencent.state.common.push.PushMessage;
import com.tencent.state.data.UserCommon;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/library/push/EnterRoomMessage;", "Lcom/tencent/state/common/push/PushMessage;", "type", "", "info", "Lcom/tencent/state/common/push/PushBasic;", "roomId", "", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/data/UserCommon;", "(ILcom/tencent/state/common/push/PushBasic;JLcom/tencent/state/data/UserCommon;)V", "getInfo", "()Lcom/tencent/state/common/push/PushBasic;", "getRoomId", "()J", "getType", "()I", "getUser", "()Lcom/tencent/state/data/UserCommon;", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class EnterRoomMessage extends PushMessage {
    private final PushBasic info;
    private final long roomId;
    private final int type;
    private final UserCommon user;

    public EnterRoomMessage(int i3, PushBasic info, long j3, UserCommon user) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(user, "user");
        this.type = i3;
        this.info = info;
        this.roomId = j3;
        this.user = user;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public PushBasic getInfo() {
        return this.info;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public int getType() {
        return this.type;
    }

    public final UserCommon getUser() {
        return this.user;
    }

    public String toString() {
        return "EnterRoomMessage(type=" + getType() + ", info=" + getInfo() + ", roomId=" + this.roomId + ", user=" + this.user + ')';
    }
}
