package com.tencent.state.template.push;

import com.tencent.state.common.push.PushBasic;
import com.tencent.state.common.push.PushMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\b\u0010\u0019\u001a\u00020\u0007H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/template/push/RoomInteractionUserRefreshMessage;", "Lcom/tencent/state/common/push/PushMessage;", "type", "", "info", "Lcom/tencent/state/common/push/PushBasic;", "billNo", "", "sender", "", "receiver", "refreshType", "Lcom/tencent/state/template/push/RefreshType;", "(ILcom/tencent/state/common/push/PushBasic;Ljava/lang/String;JJLcom/tencent/state/template/push/RefreshType;)V", "getBillNo", "()Ljava/lang/String;", "getInfo", "()Lcom/tencent/state/common/push/PushBasic;", "getReceiver", "()J", "getRefreshType", "()Lcom/tencent/state/template/push/RefreshType;", "getSender", "getType", "()I", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class RoomInteractionUserRefreshMessage extends PushMessage {
    private final String billNo;
    private final PushBasic info;
    private final long receiver;
    private final RefreshType refreshType;
    private final long sender;
    private final int type;

    public RoomInteractionUserRefreshMessage(int i3, PushBasic info, String billNo, long j3, long j16, RefreshType refreshType) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(refreshType, "refreshType");
        this.type = i3;
        this.info = info;
        this.billNo = billNo;
        this.sender = j3;
        this.receiver = j16;
        this.refreshType = refreshType;
    }

    public final String getBillNo() {
        return this.billNo;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public PushBasic getInfo() {
        return this.info;
    }

    public final long getReceiver() {
        return this.receiver;
    }

    public final RefreshType getRefreshType() {
        return this.refreshType;
    }

    public final long getSender() {
        return this.sender;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public int getType() {
        return this.type;
    }

    public String toString() {
        return "RoomInteractionUserRefreshMessage(type=" + getType() + ", info=" + getInfo() + ", billNo=" + this.billNo + ", sender=" + this.sender + ", receiver=" + this.receiver + ", refreshType=" + this.refreshType + ')';
    }
}
