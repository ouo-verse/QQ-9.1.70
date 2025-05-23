package com.tencent.state.library.push;

import com.tencent.state.common.push.PushBasic;
import com.tencent.state.common.push.PushMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/library/push/CancelFocusMessage;", "Lcom/tencent/state/common/push/PushMessage;", "type", "", "info", "Lcom/tencent/state/common/push/PushBasic;", "roomId", "", "uin", "tableId", "reason", "(ILcom/tencent/state/common/push/PushBasic;JJJI)V", "getInfo", "()Lcom/tencent/state/common/push/PushBasic;", "getReason", "()I", "getRoomId", "()J", "getTableId", "getType", "getUin", "isTimeOut", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class CancelFocusMessage extends PushMessage {
    private final PushBasic info;
    private final int reason;
    private final long roomId;
    private final long tableId;
    private final int type;
    private final long uin;

    public CancelFocusMessage(int i3, PushBasic info, long j3, long j16, long j17, int i16) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.type = i3;
        this.info = info;
        this.roomId = j3;
        this.uin = j16;
        this.tableId = j17;
        this.reason = i16;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public PushBasic getInfo() {
        return this.info;
    }

    public final int getReason() {
        return this.reason;
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

    public final boolean isTimeOut() {
        return this.reason == 2;
    }

    public String toString() {
        return "CancelFocusMessage(type=" + getType() + ", info=" + getInfo() + ", roomId=" + this.roomId + ", uin=" + this.uin + ", tableId=" + this.tableId + ')';
    }
}
