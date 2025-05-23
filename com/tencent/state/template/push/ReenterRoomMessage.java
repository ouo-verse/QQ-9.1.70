package com.tencent.state.template.push;

import com.tencent.state.common.push.PushBasic;
import com.tencent.state.common.push.PushMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/template/push/RoomReenterRoomMessage;", "Lcom/tencent/state/common/push/PushMessage;", "type", "", "info", "Lcom/tencent/state/common/push/PushBasic;", "(ILcom/tencent/state/common/push/PushBasic;)V", "getInfo", "()Lcom/tencent/state/common/push/PushBasic;", "getType", "()I", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.state.template.push.RoomReenterRoomMessage, reason: from toString */
/* loaded from: classes38.dex */
public final class ReenterRoomMessage extends PushMessage {
    private final PushBasic info;
    private final int type;

    public ReenterRoomMessage(int i3, PushBasic info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.type = i3;
        this.info = info;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public PushBasic getInfo() {
        return this.info;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public int getType() {
        return this.type;
    }

    public String toString() {
        return "ReenterRoomMessage(type=" + getType() + ", info=" + getInfo() + ')';
    }
}
