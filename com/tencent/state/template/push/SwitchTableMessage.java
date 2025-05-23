package com.tencent.state.template.push;

import com.tencent.state.common.push.PushBasic;
import com.tencent.state.common.push.PushMessage;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/template/push/RoomSwitchTableMessage;", "Lcom/tencent/state/common/push/PushMessage;", "type", "", "info", "Lcom/tencent/state/common/push/PushBasic;", "roomId", "", "uin", "tableId", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "(ILcom/tencent/state/common/push/PushBasic;JJJLcom/tencent/state/template/data/User;)V", "getInfo", "()Lcom/tencent/state/common/push/PushBasic;", "getRoomId", "()J", "getTableId", "getType", "()I", "getUin", "getUser", "()Lcom/tencent/state/template/data/User;", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.state.template.push.RoomSwitchTableMessage, reason: from toString */
/* loaded from: classes38.dex */
public final class SwitchTableMessage extends PushMessage {
    private final PushBasic info;
    private final long roomId;
    private final long tableId;
    private final int type;
    private final long uin;
    private final User user;

    public SwitchTableMessage(int i3, PushBasic info, long j3, long j16, long j17, User user) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(user, "user");
        this.type = i3;
        this.info = info;
        this.roomId = j3;
        this.uin = j16;
        this.tableId = j17;
        this.user = user;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public PushBasic getInfo() {
        return this.info;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final long getTableId() {
        return this.tableId;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public int getType() {
        return this.type;
    }

    public final long getUin() {
        return this.uin;
    }

    public final User getUser() {
        return this.user;
    }

    public String toString() {
        return "SwitchTableMessage(type=" + getType() + ", info=" + getInfo() + ", uin=" + this.uin + ", roomId=" + this.roomId + ", tableId=" + this.tableId + ", user=" + this.user + ')';
    }
}
